// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.world.phys.AABB;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.Vec3i;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import twilightforest.entity.monster.Redcap;
import net.minecraft.world.entity.ai.goal.Goal;

public abstract class RedcapBaseGoal extends Goal
{
    protected final Redcap redcap;
    
    protected RedcapBaseGoal(final Redcap entity) {
        this.redcap = entity;
    }
    
    public boolean isTargetLookingAtMe(final LivingEntity attackTarget) {
        final double dx = this.redcap.m_20185_() - attackTarget.m_20185_();
        final double dz = this.redcap.m_20189_() - attackTarget.m_20189_();
        final float angle = (float)(Math.atan2(dz, dx) * 180.0 / 3.141592653589793) - 90.0f;
        final float difference = Mth.m_14154_((attackTarget.m_146908_() - angle) % 360.0f);
        return difference < 60.0f || difference > 300.0f;
    }
    
    public BlockPos findBlockTNTNearby(final int range) {
        final BlockPos entityPos = new BlockPos((Vec3i)this.redcap.m_142538_());
        for (int x = -range; x <= range; ++x) {
            for (int y = -range; y <= range; ++y) {
                for (int z = -range; z <= range; ++z) {
                    if (this.redcap.f_19853_.m_8055_(entityPos.m_142082_(x, y, z)).m_60734_() == Blocks.f_50077_) {
                        return entityPos.m_142082_(x, y, z);
                    }
                }
            }
        }
        return null;
    }
    
    public boolean isLitTNTNearby(final int range) {
        final AABB expandedBox = this.redcap.m_142469_().m_82377_((double)range, (double)range, (double)range);
        return !this.redcap.f_19853_.m_45976_((Class)PrimedTnt.class, expandedBox).isEmpty();
    }
}
