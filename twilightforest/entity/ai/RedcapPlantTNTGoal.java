// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.block.Blocks;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.entity.Entity;
import twilightforest.entity.RedcapEntity;

public class RedcapPlantTNTGoal extends RedcapBaseGoal
{
    public RedcapPlantTNTGoal(final RedcapEntity entityTFRedcap) {
        super(entityTFRedcap);
    }
    
    public boolean func_75250_a() {
        final LivingEntity attackTarget = this.redcap.func_70638_az();
        return attackTarget != null && !this.redcap.heldTNT.func_190926_b() && this.redcap.func_70068_e((Entity)attackTarget) < 25.0 && !this.isTargetLookingAtMe(attackTarget) && ForgeEventFactory.getMobGriefingEvent(this.redcap.field_70170_p, (Entity)this.redcap) && !this.isLitTNTNearby(8) && this.findBlockTNTNearby(5) == null;
    }
    
    public void func_75249_e() {
        final BlockPos entityPos = new BlockPos((Vector3i)this.redcap.func_233580_cy_());
        this.redcap.func_184201_a(EquipmentSlotType.MAINHAND, this.redcap.heldTNT);
        if (this.redcap.field_70170_p.func_175623_d(entityPos)) {
            this.redcap.heldTNT.func_190918_g(1);
            this.redcap.func_70642_aH();
            this.redcap.field_70170_p.func_175656_a(entityPos, Blocks.field_150335_W.func_176223_P());
        }
    }
    
    public void func_75251_c() {
        this.redcap.func_184201_a(EquipmentSlotType.MAINHAND, this.redcap.heldPick);
    }
}
