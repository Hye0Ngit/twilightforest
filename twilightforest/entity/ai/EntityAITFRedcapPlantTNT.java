// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.Entity;
import twilightforest.entity.EntityTFRedcap;

public class EntityAITFRedcapPlantTNT extends EntityAITFRedcapBase
{
    public EntityAITFRedcapPlantTNT(final EntityTFRedcap entityTFRedcap) {
        this.me = entityTFRedcap;
    }
    
    public boolean func_75250_a() {
        final EntityLiving attackTarget = this.me.func_70638_az();
        return attackTarget != null && this.me.getTntLeft() > 0 && this.me.func_70068_e((Entity)attackTarget) < 25.0 && !this.isTargetLookingAtMe(attackTarget) && !this.isLitTNTNearby(8) && this.findBlockTNTNearby(5) == null;
    }
    
    public void func_75249_e() {
        final int entityPosX = MathHelper.func_76128_c(this.me.field_70165_t);
        final int entityPosY = MathHelper.func_76128_c(this.me.field_70163_u);
        final int entityPosZ = MathHelper.func_76128_c(this.me.field_70161_v);
        this.me.func_70062_b(0, EntityTFRedcap.heldTNT);
        if (this.me.field_70170_p.func_72799_c(entityPosX, entityPosY, entityPosZ)) {
            this.me.setTntLeft(this.me.getTntLeft() - 1);
            this.me.func_70642_aH();
            this.me.field_70170_p.func_72832_d(entityPosX, entityPosY, entityPosZ, Block.field_72091_am.field_71990_ca, 0, 3);
        }
    }
    
    public void func_75251_c() {
        this.me.func_70062_b(0, this.me.getPick());
    }
}
