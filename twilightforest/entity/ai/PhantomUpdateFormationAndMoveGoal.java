// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.core.Vec3i;
import java.util.Iterator;
import java.util.List;
import net.minecraft.world.item.ItemStack;
import twilightforest.item.TFItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.phys.Vec3;
import twilightforest.entity.boss.KnightPhantom;
import net.minecraft.world.entity.ai.goal.Goal;

public class PhantomUpdateFormationAndMoveGoal extends Goal
{
    private static final float CIRCLE_SMALL_RADIUS = 2.5f;
    private static final float CIRCLE_LARGE_RADIUS = 8.5f;
    private final KnightPhantom boss;
    
    public PhantomUpdateFormationAndMoveGoal(final KnightPhantom entity) {
        this.boss = entity;
    }
    
    public boolean m_8036_() {
        return true;
    }
    
    public void m_8037_() {
        this.boss.f_19794_ = (this.boss.getTicksProgress() % 20 != 0);
        this.boss.setTicksProgress(this.boss.getTicksProgress() + 1);
        if (this.boss.getTicksProgress() >= this.boss.getMaxTicksForFormation()) {
            this.switchToNextFormation();
        }
        final Vec3 dest = this.getDestination();
        this.boss.m_21566_().m_6849_(dest.f_82479_, dest.f_82480_, dest.f_82481_, this.boss.isChargingAtPlayer() ? 2.0 : 1.0);
    }
    
    public Vec3 getDestination() {
        if (!this.boss.hasHome()) {
            this.boss.m_21446_(this.boss.m_142538_(), 20);
        }
        return switch (this.boss.getCurrentFormation()) {
            case LARGE_CLOCKWISE -> this.getCirclePosition(8.5f, true);
            case SMALL_CLOCKWISE -> this.getCirclePosition(2.5f, true);
            case LARGE_ANTICLOCKWISE -> this.getCirclePosition(8.5f, false);
            case SMALL_ANTICLOCKWISE -> this.getCirclePosition(2.5f, false);
            case CHARGE_PLUSX -> this.getMoveAcrossPosition(true, true);
            case CHARGE_MINUSX -> this.getMoveAcrossPosition(false, true);
            case CHARGE_PLUSZ -> this.getMoveAcrossPosition(true, false);
            case ATTACK_PLAYER_START,  HOVER -> this.getHoverPosition(8.5f);
            case CHARGE_MINUSZ -> this.getMoveAcrossPosition(false, false);
            default -> this.getLoiterPosition();
            case ATTACK_PLAYER_ATTACK -> this.getAttackPlayerPosition();
        };
    }
    
    private void switchToNextFormation() {
        final List<KnightPhantom> nearbyKnights = this.boss.getNearbyKnights();
        if (this.boss.getCurrentFormation() == KnightPhantom.Formation.ATTACK_PLAYER_START) {
            this.boss.switchToFormation(KnightPhantom.Formation.ATTACK_PLAYER_ATTACK);
        }
        else if (this.boss.getCurrentFormation() == KnightPhantom.Formation.ATTACK_PLAYER_ATTACK) {
            if (nearbyKnights.size() > 1) {
                this.boss.switchToFormation(KnightPhantom.Formation.WAITING_FOR_LEADER);
            }
            else {
                switch (this.boss.m_21187_().nextInt(3)) {
                    case 0: {
                        this.boss.m_8061_(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)TFItems.KNIGHTMETAL_SWORD.get()));
                        break;
                    }
                    case 1: {
                        this.boss.m_8061_(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)TFItems.KNIGHTMETAL_AXE.get()));
                        break;
                    }
                    case 2: {
                        this.boss.m_8061_(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)TFItems.KNIGHTMETAL_PICKAXE.get()));
                        break;
                    }
                }
                this.boss.switchToFormation(KnightPhantom.Formation.ATTACK_PLAYER_START);
            }
        }
        else if (this.boss.getCurrentFormation() == KnightPhantom.Formation.WAITING_FOR_LEADER) {
            if (nearbyKnights.size() > 1) {
                this.boss.switchToFormation(nearbyKnights.get(1).getCurrentFormation());
                this.boss.setTicksProgress(nearbyKnights.get(1).getTicksProgress());
            }
            else {
                this.boss.switchToFormation(KnightPhantom.Formation.ATTACK_PLAYER_START);
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
    
    private boolean isThisTheLeader(final List<KnightPhantom> nearbyKnights) {
        boolean iAmTheLowest = true;
        for (final KnightPhantom knight : nearbyKnights) {
            if (knight.getNumber() < this.boss.getNumber()) {
                iAmTheLowest = false;
                break;
            }
        }
        return iAmTheLowest;
    }
    
    private void pickRandomFormation() {
        switch (this.boss.m_21187_().nextInt(8)) {
            case 0:
            case 7: {
                this.boss.switchToFormation(KnightPhantom.Formation.SMALL_CLOCKWISE);
            }
            case 3: {
                this.boss.switchToFormation(KnightPhantom.Formation.CHARGE_PLUSX);
                break;
            }
            case 4: {
                this.boss.switchToFormation(KnightPhantom.Formation.CHARGE_MINUSX);
                break;
            }
            case 5: {
                this.boss.switchToFormation(KnightPhantom.Formation.CHARGE_PLUSZ);
                break;
            }
            case 6: {
                this.boss.switchToFormation(KnightPhantom.Formation.CHARGE_MINUSZ);
                break;
            }
        }
    }
    
    private void makeARandomKnightCharge(final List<KnightPhantom> nearbyKnights) {
        final int randomNum = this.boss.m_21187_().nextInt(nearbyKnights.size());
        nearbyKnights.get(randomNum).switchToFormation(KnightPhantom.Formation.ATTACK_PLAYER_START);
    }
    
    private void broadcastMyFormation(final List<KnightPhantom> nearbyKnights) {
        for (final KnightPhantom knight : nearbyKnights) {
            if (!knight.isChargingAtPlayer()) {
                knight.switchToFormation(this.boss.getCurrentFormation());
            }
        }
    }
    
    private boolean isNobodyCharging(final List<KnightPhantom> nearbyKnights) {
        boolean noCharge = true;
        for (final KnightPhantom knight : nearbyKnights) {
            if (knight.isChargingAtPlayer()) {
                noCharge = false;
                break;
            }
        }
        return noCharge;
    }
    
    private Vec3 getMoveAcrossPosition(final boolean plus, final boolean alongX) {
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
        final double dx = this.boss.m_21534_().m_123341_() + (alongX ? offset0 : offset2);
        final double dy = this.boss.m_21534_().m_123342_() + Math.cos(this.boss.getTicksProgress() / 7.0f + this.boss.getNumber());
        final double dz = this.boss.m_21534_().m_123343_() + (alongX ? offset2 : offset0);
        return new Vec3(dx, dy, dz);
    }
    
    private Vec3 getCirclePosition(final float distance, final boolean clockwise) {
        float angle = this.boss.getTicksProgress() * 2.0f;
        if (!clockwise) {
            angle *= -1.0f;
        }
        angle += 60.0f * this.boss.getNumber();
        final double dx = this.boss.m_21534_().m_123341_() + Math.cos(angle * 3.141592653589793 / 180.0) * distance;
        final double dy = this.boss.m_21534_().m_123342_() + Math.cos(this.boss.getTicksProgress() / 7.0f + this.boss.getNumber());
        final double dz = this.boss.m_21534_().m_123343_() + Math.sin(angle * 3.141592653589793 / 180.0) * distance;
        return new Vec3(dx, dy, dz);
    }
    
    private Vec3 getHoverPosition(final float distance) {
        double dx = this.boss.f_19790_;
        final double dy = this.boss.m_21534_().m_123342_() + Math.cos(this.boss.getTicksProgress() / 7.0f + this.boss.getNumber());
        double dz = this.boss.f_19792_;
        final double ox = this.boss.m_21534_().m_123341_() - dx;
        final double oz = this.boss.m_21534_().m_123343_() - dz;
        final double dDist = Math.sqrt(ox * ox + oz * oz);
        if (dDist > distance) {
            dx = this.boss.m_21534_().m_123341_() + ox / dDist * distance;
            dz = this.boss.m_21534_().m_123343_() + oz / dDist * distance;
        }
        return new Vec3(dx, dy, dz);
    }
    
    private Vec3 getLoiterPosition() {
        final double dx = this.boss.m_21534_().m_123341_();
        final double dy = this.boss.m_21534_().m_123342_() + Math.cos(this.boss.getTicksProgress() / 7.0f + this.boss.getNumber());
        final double dz = this.boss.m_21534_().m_123343_();
        return new Vec3(dx, dy, dz);
    }
    
    private Vec3 getAttackPlayerPosition() {
        if (this.boss.isSwordKnight()) {
            return Vec3.m_82528_((Vec3i)this.boss.getChargePos());
        }
        return this.getHoverPosition(8.5f);
    }
}
