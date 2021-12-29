// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.entity.Entity;
import twilightforest.entity.EntityTFRedcap;

public class EntityAITFRedcapPlantTNT extends EntityAITFRedcapBase
{
    public EntityAITFRedcapPlantTNT(final EntityTFRedcap entityTFRedcap) {
        super(entityTFRedcap);
    }
    
    public boolean func_75250_a() {
        final EntityLivingBase attackTarget = this.redcap.func_70638_az();
        return attackTarget != null && !this.redcap.heldTNT.func_190926_b() && this.redcap.func_70068_e((Entity)attackTarget) < 25.0 && !this.isTargetLookingAtMe(attackTarget) && ForgeEventFactory.getMobGriefingEvent(this.redcap.field_70170_p, (Entity)this.redcap) && !this.isLitTNTNearby(8) && this.findBlockTNTNearby(5) == null;
    }
    
    public void func_75249_e() {
        final BlockPos entityPos = new BlockPos((Entity)this.redcap);
        this.redcap.func_184201_a(EntityEquipmentSlot.MAINHAND, this.redcap.heldTNT);
        if (this.redcap.field_70170_p.func_175623_d(entityPos)) {
            this.redcap.heldTNT.func_190918_g(1);
            this.redcap.func_70642_aH();
            this.redcap.field_70170_p.func_175656_a(entityPos, Blocks.field_150335_W.func_176223_P());
        }
    }
    
    public void func_75251_c() {
        this.redcap.func_184201_a(EntityEquipmentSlot.MAINHAND, this.redcap.heldPick);
    }
}
