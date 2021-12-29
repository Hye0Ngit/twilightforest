// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import twilightforest.entity.EntityTFRedcap;

public class EntityAITFRedcapPlantTNT extends EntityAITFRedcapBase
{
    public EntityAITFRedcapPlantTNT(final EntityTFRedcap entityTFRedcap) {
        this.entityObj = entityTFRedcap;
    }
    
    public boolean func_75250_a() {
        final EntityLivingBase attackTarget = this.entityObj.func_70638_az();
        return attackTarget != null && this.entityObj.getTntLeft() > 0 && this.entityObj.func_70068_e((Entity)attackTarget) < 25.0 && !this.isTargetLookingAtMe(attackTarget) && !this.isLitTNTNearby(8) && this.findBlockTNTNearby(5) == null;
    }
    
    public void func_75249_e() {
        final int entityPosX = MathHelper.func_76128_c(this.entityObj.field_70165_t);
        final int entityPosY = MathHelper.func_76128_c(this.entityObj.field_70163_u);
        final int entityPosZ = MathHelper.func_76128_c(this.entityObj.field_70161_v);
        this.entityObj.func_70062_b(0, EntityTFRedcap.heldTNT);
        if (this.entityObj.field_70170_p.func_147437_c(entityPosX, entityPosY, entityPosZ)) {
            this.entityObj.setTntLeft(this.entityObj.getTntLeft() - 1);
            this.entityObj.func_70642_aH();
            this.entityObj.field_70170_p.func_147465_d(entityPosX, entityPosY, entityPosZ, Blocks.field_150335_W, 0, 3);
        }
    }
    
    public void func_75251_c() {
        this.entityObj.func_70062_b(0, this.entityObj.getPick());
    }
}
