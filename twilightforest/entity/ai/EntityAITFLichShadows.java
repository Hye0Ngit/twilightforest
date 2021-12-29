// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import java.util.Iterator;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import twilightforest.item.TFItems;
import net.minecraft.inventory.EntityEquipmentSlot;
import twilightforest.entity.boss.EntityTFLich;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAITFLichShadows extends EntityAIBase
{
    private final EntityTFLich lich;
    
    public EntityAITFLichShadows(final EntityTFLich boss) {
        this.lich = boss;
        this.func_75248_a(3);
    }
    
    public boolean func_75250_a() {
        return this.lich.getPhase() == 1;
    }
    
    public void func_75249_e() {
        this.lich.func_184201_a(EntityEquipmentSlot.MAINHAND, new ItemStack(TFItems.twilight_scepter));
    }
    
    public void func_75251_c() {
        this.despawnClones();
    }
    
    public void func_75246_d() {
        if (this.lich.isShadowClone()) {
            this.checkForMaster();
        }
        final EntityLivingBase targetedEntity = this.lich.func_70638_az();
        if (targetedEntity == null) {
            return;
        }
        final float dist = this.lich.func_70032_d((Entity)targetedEntity);
        if (this.lich.getAttackCooldown() == 60) {
            this.lich.teleportToSightOfEntity((Entity)targetedEntity);
            if (!this.lich.isShadowClone()) {
                this.checkAndSpawnClones();
            }
        }
        if (this.lich.func_70635_at().func_75522_a((Entity)targetedEntity) && this.lich.getAttackCooldown() == 0 && dist < 20.0f) {
            if (this.lich.getNextAttackType() == 0) {
                this.lich.launchBoltAt();
            }
            else {
                this.lich.launchBombAt();
            }
            if (this.lich.func_70681_au().nextInt(3) > 0) {
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
        if (!this.lich.field_70170_p.field_72995_K && (this.lich.getMasterLich() == null || this.lich.getMasterLich().field_70128_L)) {
            this.lich.func_70106_y();
        }
    }
    
    private void checkAndSpawnClones() {
        if (this.lich.countMyClones() < 2) {
            this.spawnShadowClone();
        }
    }
    
    private void spawnShadowClone() {
        final EntityLivingBase targetedEntity = this.lich.func_70638_az();
        final Vec3d cloneSpot = this.lich.findVecInLOSOf((Entity)targetedEntity);
        if (cloneSpot != null) {
            final EntityTFLich newClone = new EntityTFLich(this.lich.field_70170_p, this.lich);
            newClone.func_70107_b(cloneSpot.field_72450_a, cloneSpot.field_72448_b, cloneSpot.field_72449_c);
            this.lich.field_70170_p.func_72838_d((Entity)newClone);
            newClone.func_70624_b(targetedEntity);
            newClone.setAttackCooldown(60 + this.lich.func_70681_au().nextInt(3) - this.lich.func_70681_au().nextInt(3));
            this.lich.makeTeleportTrail(this.lich.field_70165_t, this.lich.field_70163_u, this.lich.field_70161_v, cloneSpot.field_72450_a, cloneSpot.field_72448_b, cloneSpot.field_72449_c);
        }
    }
    
    private void despawnClones() {
        for (final EntityTFLich nearbyLich : this.lich.getNearbyLiches()) {
            if (nearbyLich.isShadowClone()) {
                nearbyLich.field_70128_L = true;
            }
        }
    }
    
    private void findNewMaster() {
        for (final EntityTFLich nearbyLich : this.lich.getNearbyLiches()) {
            if (!nearbyLich.isShadowClone() && nearbyLich.wantsNewClone(this.lich)) {
                this.lich.setMaster(nearbyLich);
                this.lich.makeTeleportTrail(this.lich.field_70165_t, this.lich.field_70163_u, this.lich.field_70161_v, nearbyLich.field_70165_t, nearbyLich.field_70163_u, nearbyLich.field_70161_v);
                this.lich.func_70624_b(nearbyLich.func_70638_az());
                break;
            }
        }
    }
}
