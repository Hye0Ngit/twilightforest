// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.core.Vec3i;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.world.entity.Entity;
import twilightforest.entity.monster.Redcap;

public class RedcapPlantTNTGoal extends RedcapBaseGoal
{
    public RedcapPlantTNTGoal(final Redcap entityTFRedcap) {
        super(entityTFRedcap);
    }
    
    public boolean m_8036_() {
        final LivingEntity attackTarget = this.redcap.m_5448_();
        return attackTarget != null && !this.redcap.heldTNT.m_41619_() && this.redcap.m_20280_((Entity)attackTarget) < 25.0 && !this.isTargetLookingAtMe(attackTarget) && ForgeEventFactory.getMobGriefingEvent(this.redcap.f_19853_, (Entity)this.redcap) && !this.isLitTNTNearby(8) && this.findBlockTNTNearby(5) == null;
    }
    
    public void m_8056_() {
        final BlockPos entityPos = new BlockPos((Vec3i)this.redcap.m_142538_());
        this.redcap.m_8061_(EquipmentSlot.MAINHAND, this.redcap.heldTNT);
        if (this.redcap.f_19853_.m_46859_(entityPos)) {
            this.redcap.heldTNT.m_41774_(1);
            this.redcap.m_8032_();
            this.redcap.f_19853_.m_46597_(entityPos, Blocks.f_50077_.m_49966_());
        }
    }
    
    public void m_8041_() {
        this.redcap.m_8061_(EquipmentSlot.MAINHAND, this.redcap.heldPick);
    }
}
