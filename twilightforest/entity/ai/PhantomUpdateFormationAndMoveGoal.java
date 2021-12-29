// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.util.math.vector.Vector3i;
import java.util.Iterator;
import java.util.List;
import net.minecraft.item.ItemStack;
import twilightforest.item.TFItems;
import net.minecraft.util.IItemProvider;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.math.vector.Vector3d;
import twilightforest.entity.boss.KnightPhantomEntity;
import net.minecraft.entity.ai.goal.Goal;

public class PhantomUpdateFormationAndMoveGoal extends Goal
{
    private static final float CIRCLE_SMALL_RADIUS = 2.5f;
    private static final float CIRCLE_LARGE_RADIUS = 8.5f;
    private final KnightPhantomEntity boss;
    
    public PhantomUpdateFormationAndMoveGoal(final KnightPhantomEntity entity) {
        this.boss = entity;
    }
    
    public boolean func_75250_a() {
        return true;
    }
    
    public void func_75246_d() {
        this.boss.field_70145_X = (this.boss.getTicksProgress() % 20 != 0);
        this.boss.setTicksProgress(this.boss.getTicksProgress() + 1);
        if (this.boss.getTicksProgress() >= this.boss.getMaxTicksForFormation()) {
            this.switchToNextFormation();
        }
        final Vector3d dest = this.getDestination();
        this.boss.func_70605_aq().func_75642_a(dest.field_72450_a, dest.field_72448_b, dest.field_72449_c, this.boss.isChargingAtPlayer() ? 2.0 : 1.0);
    }
    
    public Vector3d getDestination() {
        if (!this.boss.hasHome()) {
            this.boss.func_213390_a(this.boss.func_233580_cy_(), 20);
        }
        switch (this.boss.getCurrentFormation()) {
            case LARGE_CLOCKWISE: {
                return this.getCirclePosition(8.5f, true);
            }
            case SMALL_CLOCKWISE: {
                return this.getCirclePosition(2.5f, true);
            }
            case LARGE_ANTICLOCKWISE: {
                return this.getCirclePosition(8.5f, false);
            }
            case SMALL_ANTICLOCKWISE: {
                return this.getCirclePosition(2.5f, false);
            }
            case CHARGE_PLUSX: {
                return this.getMoveAcrossPosition(true, true);
            }
            case CHARGE_MINUSX: {
                return this.getMoveAcrossPosition(false, true);
            }
            case CHARGE_PLUSZ: {
                return this.getMoveAcrossPosition(true, false);
            }
            case ATTACK_PLAYER_START:
            case HOVER: {
                return this.getHoverPosition(8.5f);
            }
            case CHARGE_MINUSZ: {
                return this.getMoveAcrossPosition(false, false);
            }
            default: {
                return this.getLoiterPosition();
            }
            case ATTACK_PLAYER_ATTACK: {
                return this.getAttackPlayerPosition();
            }
        }
    }
    
    private void switchToNextFormation() {
        final List<KnightPhantomEntity> nearbyKnights = this.boss.getNearbyKnights();
        if (this.boss.getCurrentFormation() == KnightPhantomEntity.Formation.ATTACK_PLAYER_START) {
            this.boss.switchToFormation(KnightPhantomEntity.Formation.ATTACK_PLAYER_ATTACK);
        }
        else if (this.boss.getCurrentFormation() == KnightPhantomEntity.Formation.ATTACK_PLAYER_ATTACK) {
            if (nearbyKnights.size() > 1) {
                this.boss.switchToFormation(KnightPhantomEntity.Formation.WAITING_FOR_LEADER);
            }
            else {
                switch (this.boss.func_70681_au().nextInt(3)) {
                    case 0: {
                        this.boss.func_184201_a(EquipmentSlotType.MAINHAND, new ItemStack((IItemProvider)TFItems.knightmetal_sword.get()));
                        break;
                    }
                    case 1: {
                        this.boss.func_184201_a(EquipmentSlotType.MAINHAND, new ItemStack((IItemProvider)TFItems.knightmetal_axe.get()));
                        break;
                    }
                    case 2: {
                        this.boss.func_184201_a(EquipmentSlotType.MAINHAND, new ItemStack((IItemProvider)TFItems.knightmetal_pickaxe.get()));
                        break;
                    }
                }
                this.boss.switchToFormation(KnightPhantomEntity.Formation.ATTACK_PLAYER_START);
            }
        }
        else if (this.boss.getCurrentFormation() == KnightPhantomEntity.Formation.WAITING_FOR_LEADER) {
            if (nearbyKnights.size() > 1) {
                this.boss.switchToFormation(nearbyKnights.get(1).getCurrentFormation());
                this.boss.setTicksProgress(nearbyKnights.get(1).getTicksProgress());
            }
            else {
                this.boss.switchToFormation(KnightPhantomEntity.Formation.ATTACK_PLAYER_START);
            }
        }
        else if (this.isThisTheLeader(nearbyKnights)) {
            this.pickRandomFormation();
            this.broadcastMyFormation(nearbyKnights);
            if (this.isNobodyCharging(nearbyKnights)) {
                this.makeARandomKnightCharge(nearbyKnights);
            }
        }
    }
    
    private boolean isThisTheLeader(final List<KnightPhantomEntity> nearbyKnights) {
        boolean iAmTheLowest = true;
        for (final KnightPhantomEntity knight : nearbyKnights) {
            if (knight.getNumber() < this.boss.getNumber()) {
                iAmTheLowest = false;
                break;
            }
        }
        return iAmTheLowest;
    }
    
    private void pickRandomFormation() {
        switch (this.boss.func_70681_au().nextInt(8)) {
            case 0:
            case 7: {
                this.boss.switchToFormation(KnightPhantomEntity.Formation.SMALL_CLOCKWISE);
            }
            case 3: {
                this.boss.switchToFormation(KnightPhantomEntity.Formation.CHARGE_PLUSX);
                break;
            }
            case 4: {
                this.boss.switchToFormation(KnightPhantomEntity.Formation.CHARGE_MINUSX);
                break;
            }
            case 5: {
                this.boss.switchToFormation(KnightPhantomEntity.Formation.CHARGE_PLUSZ);
                break;
            }
            case 6: {
                this.boss.switchToFormation(KnightPhantomEntity.Formation.CHARGE_MINUSZ);
                break;
            }
        }
    }
    
    private void makeARandomKnightCharge(final List<KnightPhantomEntity> nearbyKnights) {
        final int randomNum = this.boss.func_70681_au().nextInt(nearbyKnights.size());
        nearbyKnights.get(randomNum).switchToFormation(KnightPhantomEntity.Formation.ATTACK_PLAYER_START);
    }
    
    private void broadcastMyFormation(final List<KnightPhantomEntity> nearbyKnights) {
        for (final KnightPhantomEntity knight : nearbyKnights) {
            if (!knight.isChargingAtPlayer()) {
                knight.switchToFormation(this.boss.getCurrentFormation());
            }
        }
    }
    
    private boolean isNobodyCharging(final List<KnightPhantomEntity> nearbyKnights) {
        boolean noCharge = true;
        for (final KnightPhantomEntity knight : nearbyKnights) {
            if (knight.isChargingAtPlayer()) {
                noCharge = false;
                break;
            }
        }
        return noCharge;
    }
    
    private Vector3d getMoveAcrossPosition(final boolean plus, final boolean alongX) {
        final float offset0 = this.boss.getNumber() * 3.0f - 7.5f;
        float offset2;
        if (this.boss.getTicksProgress() < 60) {
            offset2 = -7.0f;
        }
        else {
            offset2 = -7.0f + (this.boss.getTicksProgress() - 60) / 120.0f * 14.0f;
        }
        if (!plus) {
            offset2 *= -1.0f;
        }
        final double dx = this.boss.func_213384_dI().func_177958_n() + (alongX ? offset0 : offset2);
        final double dy = this.boss.func_213384_dI().func_177956_o() + Math.cos(this.boss.getTicksProgress() / 7.0f + this.boss.getNumber());
        final double dz = this.boss.func_213384_dI().func_177952_p() + (alongX ? offset2 : offset0);
        return new Vector3d(dx, dy, dz);
    }
    
    private Vector3d getCirclePosition(final float distance, final boolean clockwise) {
        float angle = this.boss.getTicksProgress() * 2.0f;
        if (!clockwise) {
            angle *= -1.0f;
        }
        angle += 60.0f * this.boss.getNumber();
        final double dx = this.boss.func_213384_dI().func_177958_n() + Math.cos(angle * 3.141592653589793 / 180.0) * distance;
        final double dy = this.boss.func_213384_dI().func_177956_o() + Math.cos(this.boss.getTicksProgress() / 7.0f + this.boss.getNumber());
        final double dz = this.boss.func_213384_dI().func_177952_p() + Math.sin(angle * 3.141592653589793 / 180.0) * distance;
        return new Vector3d(dx, dy, dz);
    }
    
    private Vector3d getHoverPosition(final float distance) {
        double dx = this.boss.field_70142_S;
        final double dy = this.boss.func_213384_dI().func_177956_o() + Math.cos(this.boss.getTicksProgress() / 7.0f + this.boss.getNumber());
        double dz = this.boss.field_70136_U;
        final double ox = this.boss.func_213384_dI().func_177958_n() - dx;
        final double oz = this.boss.func_213384_dI().func_177952_p() - dz;
        final double dDist = Math.sqrt(ox * ox + oz * oz);
        if (dDist > distance) {
            dx = this.boss.func_213384_dI().func_177958_n() + ox / dDist * distance;
            dz = this.boss.func_213384_dI().func_177952_p() + oz / dDist * distance;
        }
        return new Vector3d(dx, dy, dz);
    }
    
    private Vector3d getLoiterPosition() {
        final double dx = this.boss.func_213384_dI().func_177958_n();
        final double dy = this.boss.func_213384_dI().func_177956_o() + Math.cos(this.boss.getTicksProgress() / 7.0f + this.boss.getNumber());
        final double dz = this.boss.func_213384_dI().func_177952_p();
        return new Vector3d(dx, dy, dz);
    }
    
    private Vector3d getAttackPlayerPosition() {
        if (this.boss.isSwordKnight()) {
            return Vector3d.func_237491_b_((Vector3i)this.boss.getChargePos());
        }
        return this.getHoverPosition(8.5f);
    }
}
