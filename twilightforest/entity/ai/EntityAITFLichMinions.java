// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.util.math.Vec3d;
import net.minecraft.init.SoundEvents;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.util.math.BlockPos;
import twilightforest.entity.boss.EntityTFLichMinion;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import twilightforest.item.TFItems;
import net.minecraft.inventory.EntityEquipmentSlot;
import twilightforest.entity.boss.EntityTFLich;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAITFLichMinions extends EntityAIBase
{
    private final EntityTFLich lich;
    
    public EntityAITFLichMinions(final EntityTFLich boss) {
        this.lich = boss;
        this.func_75248_a(3);
    }
    
    public boolean func_75250_a() {
        return this.lich.getPhase() == 2 && !this.lich.isShadowClone();
    }
    
    public void func_75249_e() {
        this.lich.func_184201_a(EntityEquipmentSlot.MAINHAND, new ItemStack(TFItems.zombie_scepter));
    }
    
    public void func_75246_d() {
        final EntityLivingBase targetedEntity = this.lich.func_70638_az();
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
        final EntityLivingBase targetedEntity = this.lich.func_70638_az();
        final Vec3d minionSpot = this.lich.findVecInLOSOf((Entity)targetedEntity);
        if (minionSpot != null) {
            final EntityTFLichMinion minion = new EntityTFLichMinion(this.lich.field_70170_p, this.lich);
            minion.func_70107_b(minionSpot.field_72450_a, minionSpot.field_72448_b, minionSpot.field_72449_c);
            minion.func_180482_a(this.lich.field_70170_p.func_175649_E(new BlockPos(minionSpot)), (IEntityLivingData)null);
            this.lich.field_70170_p.func_72838_d((Entity)minion);
            minion.func_70624_b(targetedEntity);
            minion.func_70656_aK();
            minion.func_184185_a(SoundEvents.field_187638_cR, 1.0f, ((this.lich.func_70681_au().nextFloat() - this.lich.func_70681_au().nextFloat()) * 0.7f + 1.0f) * 2.0f);
            this.lich.makeBlackMagicTrail(this.lich.field_70165_t, this.lich.field_70163_u + this.lich.func_70047_e(), this.lich.field_70161_v, minionSpot.field_72450_a, minionSpot.field_72448_b + minion.field_70131_O / 2.0, minionSpot.field_72449_c);
        }
    }
}
