// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.world.phys.Vec3;
import twilightforest.TFSounds;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.core.BlockPos;
import twilightforest.entity.monster.LichMinion;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import twilightforest.item.TFItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.entity.EquipmentSlot;
import java.util.EnumSet;
import twilightforest.entity.boss.Lich;
import net.minecraft.world.entity.ai.goal.Goal;

public class LichMinionsGoal extends Goal
{
    private final Lich lich;
    
    public LichMinionsGoal(final Lich boss) {
        this.lich = boss;
        this.m_7021_((EnumSet)EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }
    
    public boolean m_8036_() {
        return this.lich.getPhase() == 2 && !this.lich.isShadowClone();
    }
    
    public void m_8056_() {
        this.lich.m_8061_(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)TFItems.ZOMBIE_SCEPTER.get()));
    }
    
    public void m_8037_() {
        final LivingEntity targetedEntity = this.lich.m_5448_();
        if (targetedEntity == null) {
            return;
        }
        final float dist = this.lich.m_20270_((Entity)targetedEntity);
        if (this.lich.getAttackCooldown() % 15 == 0) {
            this.checkAndSpawnMinions();
        }
        if (this.lich.getAttackCooldown() == 0) {
            if (dist < 2.0f) {
                this.lich.m_7327_((Entity)targetedEntity);
                this.lich.setAttackCooldown(20);
            }
            else if (dist < 20.0f && this.lich.m_21574_().m_148306_((Entity)targetedEntity)) {
                if (this.lich.getNextAttackType() == 0) {
                    this.lich.launchBoltAt();
                }
                else {
                    this.lich.launchBombAt();
                }
                if (this.lich.m_21187_().nextInt(2) > 0) {
                    this.lich.setNextAttackType(0);
                }
                else {
                    this.lich.setNextAttackType(1);
                }
                this.lich.setAttackCooldown(60);
            }
            else {
                this.lich.teleportToSightOfEntity((Entity)targetedEntity);
                this.lich.setAttackCooldown(20);
            }
        }
    }
    
    private void checkAndSpawnMinions() {
        if (!this.lich.f_19853_.f_46443_ && this.lich.getMinionsToSummon() > 0) {
            final int minions = this.lich.countMyMinions();
            if (minions < 3) {
                this.spawnMinionAt();
                this.lich.setMinionsToSummon(this.lich.getMinionsToSummon() - 1);
            }
        }
    }
    
    private void spawnMinionAt() {
        final LivingEntity targetedEntity = this.lich.m_5448_();
        final Vec3 minionSpot = this.lich.findVecInLOSOf((Entity)targetedEntity);
        if (minionSpot != null && this.lich.f_19853_ instanceof ServerLevelAccessor) {
            final LichMinion minion = new LichMinion(this.lich.f_19853_, this.lich);
            minion.m_6034_(minionSpot.f_82479_, minionSpot.f_82480_, minionSpot.f_82481_);
            minion.m_6518_((ServerLevelAccessor)this.lich.f_19853_, this.lich.f_19853_.m_6436_(new BlockPos(minionSpot)), MobSpawnType.MOB_SUMMONED, (SpawnGroupData)null, (CompoundTag)null);
            this.lich.f_19853_.m_7967_((Entity)minion);
            minion.m_6710_(targetedEntity);
            minion.m_21373_();
            minion.m_5496_(TFSounds.MINION_SUMMON, 1.0f, ((this.lich.m_21187_().nextFloat() - this.lich.m_21187_().nextFloat()) * 0.7f + 1.0f) * 2.0f);
            this.lich.makeBlackMagicTrail(this.lich.m_20185_(), this.lich.m_20186_() + this.lich.m_20192_(), this.lich.m_20189_(), minionSpot.f_82479_, minionSpot.f_82480_ + minion.m_20206_() / 2.0, minionSpot.f_82481_);
        }
    }
}
