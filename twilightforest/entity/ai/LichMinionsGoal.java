// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.util.math.vector.Vector3d;
import twilightforest.TFSounds;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.util.math.BlockPos;
import twilightforest.entity.boss.LichMinionEntity;
import net.minecraft.world.IServerWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import twilightforest.item.TFItems;
import net.minecraft.util.IItemProvider;
import net.minecraft.inventory.EquipmentSlotType;
import java.util.EnumSet;
import twilightforest.entity.boss.LichEntity;
import net.minecraft.entity.ai.goal.Goal;

public class LichMinionsGoal extends Goal
{
    private final LichEntity lich;
    
    public LichMinionsGoal(final LichEntity boss) {
        this.lich = boss;
        this.func_220684_a((EnumSet)EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }
    
    public boolean func_75250_a() {
        return this.lich.getPhase() == 2 && !this.lich.isShadowClone();
    }
    
    public void func_75249_e() {
        this.lich.func_184201_a(EquipmentSlotType.MAINHAND, new ItemStack((IItemProvider)TFItems.zombie_scepter.get()));
    }
    
    public void func_75246_d() {
        final LivingEntity targetedEntity = this.lich.func_70638_az();
        if (targetedEntity == null) {
            return;
        }
        final float dist = this.lich.func_70032_d((Entity)targetedEntity);
        if (this.lich.getAttackCooldown() % 15 == 0) {
            this.checkAndSpawnMinions();
        }
        if (this.lich.getAttackCooldown() == 0) {
            if (dist < 2.0f) {
                this.lich.func_70652_k((Entity)targetedEntity);
                this.lich.setAttackCooldown(20);
            }
            else if (dist < 20.0f && this.lich.func_70635_at().func_75522_a((Entity)targetedEntity)) {
                if (this.lich.getNextAttackType() == 0) {
                    this.lich.launchBoltAt();
                }
                else {
                    this.lich.launchBombAt();
                }
                if (this.lich.func_70681_au().nextInt(2) > 0) {
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
        if (!this.lich.field_70170_p.field_72995_K && this.lich.getMinionsToSummon() > 0) {
            final int minions = this.lich.countMyMinions();
            if (minions < 3) {
                this.spawnMinionAt();
                this.lich.setMinionsToSummon(this.lich.getMinionsToSummon() - 1);
            }
        }
    }
    
    private void spawnMinionAt() {
        final LivingEntity targetedEntity = this.lich.func_70638_az();
        final Vector3d minionSpot = this.lich.findVecInLOSOf((Entity)targetedEntity);
        if (minionSpot != null && this.lich.field_70170_p instanceof IServerWorld) {
            final LichMinionEntity minion = new LichMinionEntity(this.lich.field_70170_p, this.lich);
            minion.func_70107_b(minionSpot.field_72450_a, minionSpot.field_72448_b, minionSpot.field_72449_c);
            minion.func_213386_a((IServerWorld)this.lich.field_70170_p, this.lich.field_70170_p.func_175649_E(new BlockPos(minionSpot)), SpawnReason.MOB_SUMMONED, (ILivingEntityData)null, (CompoundNBT)null);
            this.lich.field_70170_p.func_217376_c((Entity)minion);
            minion.func_70624_b(targetedEntity);
            minion.func_70656_aK();
            minion.func_184185_a(TFSounds.MINION_SUMMON, 1.0f, ((this.lich.func_70681_au().nextFloat() - this.lich.func_70681_au().nextFloat()) * 0.7f + 1.0f) * 2.0f);
            this.lich.makeBlackMagicTrail(this.lich.func_226277_ct_(), this.lich.func_226278_cu_() + this.lich.func_70047_e(), this.lich.func_226281_cx_(), minionSpot.field_72450_a, minionSpot.field_72448_b + minion.func_213302_cg() / 2.0, minionSpot.field_72449_c);
        }
    }
}
