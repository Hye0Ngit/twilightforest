// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import java.util.EnumSet;
import net.minecraft.core.BlockPos;
import twilightforest.entity.RovingCube;
import net.minecraft.world.entity.ai.goal.Goal;

public class CubeMoveToRedstoneSymbolsGoal extends Goal
{
    private final RovingCube myCube;
    private final double speed;
    private BlockPos targetPos;
    
    public CubeMoveToRedstoneSymbolsGoal(final RovingCube entityTFRovingCube, final double d) {
        this.myCube = entityTFRovingCube;
        this.speed = d;
        this.m_7021_((EnumSet)EnumSet.of(Goal.Flag.MOVE));
    }
    
    public boolean m_8036_() {
        if (this.myCube.m_21187_().nextInt(20) != 0) {
            return false;
        }
        final BlockPos pos = this.searchForRedstoneSymbol(this.myCube, 16, 5);
        if (pos == null) {
            return false;
        }
        this.targetPos = pos;
        return true;
    }
    
    public boolean m_8045_() {
        return !this.myCube.m_21573_().m_26571_();
    }
    
    public void m_8056_() {
        this.myCube.m_21573_().m_26519_((double)this.targetPos.m_123341_(), (double)this.targetPos.m_123342_(), (double)this.targetPos.m_123343_(), this.speed);
    }
    
    private BlockPos searchForRedstoneSymbol(final RovingCube myCube2, final int xzRange, final int yRange) {
        final BlockPos curPos = new BlockPos((Vec3i)myCube2.m_142538_());
        for (int x = -xzRange; x < xzRange; ++x) {
            for (int z = -xzRange; z < xzRange; ++z) {
                for (int y = -yRange; y < yRange; ++y) {
                    if (this.isRedstoneSymbol(curPos.m_142082_(x, y, z))) {
                        this.myCube.hasFoundSymbol = true;
                        this.myCube.symbolX = curPos.m_123341_() + x;
                        this.myCube.symbolY = curPos.m_123342_() + y;
                        this.myCube.symbolZ = curPos.m_123343_() + z;
                        return curPos.m_142082_(x, y, z);
                    }
                }
            }
        }
        return null;
    }
    
    private boolean isRedstoneSymbol(final BlockPos pos) {
        if (!this.myCube.f_19853_.m_46805_(pos) || !this.myCube.f_19853_.m_46859_(pos)) {
            return false;
        }
        for (final Direction e : Direction.values()) {
            if (this.myCube.f_19853_.m_8055_(pos.m_142300_(e)).m_60734_() != Blocks.f_50088_) {
                return false;
            }
        }
        return true;
    }
}
