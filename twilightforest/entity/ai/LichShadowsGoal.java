// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import java.util.Iterator;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import twilightforest.item.TFItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.entity.EquipmentSlot;
import java.util.EnumSet;
import twilightforest.entity.boss.Lich;
import net.minecraft.world.entity.ai.goal.Goal;

public class LichShadowsGoal extends Goal
{
    private final Lich lich;
    
    public LichShadowsGoal(final Lich boss) {
        this.lich = boss;
        this.m_7021_((EnumSet)EnumSet.of(Goal.Flag.LOOK, Goal.Flag.MOVE));
    }
    
    public boolean m_8036_() {
        return this.lich.getPhase() == 1;
    }
    
    public void m_8056_() {
        this.lich.m_8061_(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)TFItems.TWILIGHT_SCEPTER.get()));
    }
    
    public void m_8041_() {
        this.despawnClones();
    }
    
    public void m_8037_() {
        if (this.lich.isShadowClone()) {
            this.checkForMaster();
        }
        final LivingEntity targetedEntity = this.lich.m_5448_();
        if (targetedEntity == null) {
            return;
        }
        final float dist = this.lich.m_20270_((Entity)targetedEntity);
        if (this.lich.getAttackCooldown() == 60) {
            this.lich.teleportToSightOfEntity((Entity)targetedEntity);
            if (!this.lich.isShadowClone()) {
                this.checkAndSpawnClones();
            }
        }
        if (this.lich.m_21574_().m_148306_((Entity)targetedEntity) && this.lich.getAttackCooldown() == 0 && dist < 20.0f) {
            if (this.lich.getNextAttackType() == 0) {
                this.lich.launchBoltAt();
            }
            else {
                this.lich.launchBombAt();
            }
            if (this.lich.m_21187_().nextInt(3) > 0) {
                this.lich.setNextAttackType(0);
            }
            else {
                this.lich.setNextAttackType(1);
            }
            this.lich.setAttackCooldown(100);
        }
    }
    
    private void checkForMaster() {
        if (this.lich.getMasterLich() == null) {
            this.findNewMaster();
        }
        if (!this.lich.f_19853_.f_46443_ && (this.lich.getMasterLich() == null || !this.lich.getMasterLich().m_6084_())) {
            this.lich.m_146870_();
        }
    }
    
    private void checkAndSpawnClones() {
        if (this.lich.countMyClones() < 2) {
            this.spawnShadowClone();
        }
    }
    
    private void spawnShadowClone() {
        final LivingEntity targetedEntity = this.lich.m_5448_();
        final Vec3 cloneSpot = this.lich.findVecInLOSOf((Entity)targetedEntity);
        if (cloneSpot != null) {
            final Lich newClone = new Lich(this.lich.f_19853_, this.lich);
            newClone.m_6034_(cloneSpot.f_82479_, cloneSpot.f_82480_, cloneSpot.f_82481_);
            this.lich.f_19853_.m_7967_((Entity)newClone);
            newClone.m_6710_(targetedEntity);
            newClone.setAttackCooldown(60 + this.lich.m_21187_().nextInt(3) - this.lich.m_21187_().nextInt(3));
            this.lich.makeTeleportTrail(this.lich.m_20185_(), this.lich.m_20186_(), this.lich.m_20189_(), cloneSpot.f_82479_, cloneSpot.f_82480_, cloneSpot.f_82481_);
        }
    }
    
    private void despawnClones() {
        for (final Lich nearbyLich : this.lich.getNearbyLiches()) {
            if (nearbyLich.isShadowClone()) {
                nearbyLich.m_142687_(Entity.RemovalReason.DISCARDED);
            }
        }
    }
    
    private void findNewMaster() {
        for (final Lich nearbyLich : this.lich.getNearbyLiches()) {
            if (!nearbyLich.isShadowClone() && nearbyLich.wantsNewClone(this.lich)) {
                this.lich.setMaster(nearbyLich);
                this.lich.makeTeleportTrail(this.lich.m_20185_(), this.lich.m_20186_(), this.lich.m_20189_(), nearbyLich.m_20185_(), nearbyLich.m_20186_(), nearbyLich.m_20189_());
                this.lich.m_6710_(nearbyLich.m_5448_());
                break;
            }
        }
    }
}
