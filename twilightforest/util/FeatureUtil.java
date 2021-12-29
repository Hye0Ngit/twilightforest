// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.util;

import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.material.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.core.Direction;

@Deprecated
public final class FeatureUtil
{
    private static final Direction[] directionsExceptDown;
    
    public static boolean isAreaSuitable(final WorldGenLevel world, final BlockPos pos, final int width, final int height, final int depth) {
        return isAreaSuitable(world, pos, width, height, depth, false);
    }
    
    public static boolean isAreaSuitable(final WorldGenLevel world, final BlockPos pos, final int width, final int height, final int depth, final boolean underwaterAllowed) {
        boolean flag = true;
        for (int cx = 0; cx < width; ++cx) {
            for (int cz = 0; cz < depth; ++cz) {
                final BlockPos pos_ = pos.m_142082_(cx, 0, cz);
                if (world.m_46805_(pos_)) {
                    final Material m = world.m_8055_(pos_.m_7495_()).m_60767_();
                    if (m != Material.f_76314_ && m != Material.f_76315_ && m != Material.f_76278_ && m != Material.f_76280_ && m != Material.f_76317_) {
                        if (underwaterAllowed && m == Material.f_76305_) {
                            continue;
                        }
                        flag = false;
                    }
                    for (int cy = 0; cy < height; ++cy) {
                        if (!world.m_46859_(pos_.m_6630_(cy)) && !world.m_8055_(pos_.m_6630_(cy)).m_60767_().m_76336_()) {
                            if (!underwaterAllowed || world.m_8055_(pos_.m_6630_(cy)).m_60767_() != Material.f_76305_) {
                                flag = false;
                            }
                        }
                    }
                }
                else {
                    flag = false;
                }
            }
        }
        return flag;
    }
    
    public static void drawBlob(final LevelAccessor world, final BlockPos pos, final int rad, final BlockState state) {
        for (byte dx = 0; dx <= rad; ++dx) {
            for (byte dy = 0; dy <= rad; ++dy) {
                for (byte dz = 0; dz <= rad; ++dz) {
                    int dist;
                    if (dx >= dy && dx >= dz) {
                        dist = dx + (Math.max(dy, dz) >> 1) + (Math.min(dy, dz) >> 2);
                    }
                    else if (dy >= dx && dy >= dz) {
                        dist = dy + (Math.max(dx, dz) >> 1) + (Math.min(dx, dz) >> 2);
                    }
                    else {
                        dist = dz + (Math.max(dx, dy) >> 1) + (Math.min(dx, dy) >> 2);
                    }
                    if (dist <= rad) {
                        world.m_7731_(pos.m_142082_((int)dx, (int)dy, (int)dz), state, 3);
                        world.m_7731_(pos.m_142082_((int)dx, (int)dy, -dz), state, 3);
                        world.m_7731_(pos.m_142082_(-dx, (int)dy, (int)dz), state, 3);
                        world.m_7731_(pos.m_142082_(-dx, (int)dy, -dz), state, 3);
                        world.m_7731_(pos.m_142082_((int)dx, -dy, (int)dz), state, 3);
                        world.m_7731_(pos.m_142082_((int)dx, -dy, -dz), state, 3);
                        world.m_7731_(pos.m_142082_(-dx, -dy, (int)dz), state, 3);
                        world.m_7731_(pos.m_142082_(-dx, -dy, -dz), state, 3);
                    }
                }
            }
        }
    }
    
    public static boolean hasAirAround(final LevelAccessor world, final BlockPos pos) {
        for (final Direction e : FeatureUtil.directionsExceptDown) {
            if (world.m_46859_(pos.m_142300_(e))) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean isNearSolid(final LevelReader world, final BlockPos pos) {
        for (final Direction e : Direction.values()) {
            if (world.m_46805_(pos.m_142300_(e)) && world.m_8055_(pos.m_142300_(e)).m_60767_().m_76333_()) {
                return true;
            }
        }
        return false;
    }
    
    static {
        directionsExceptDown = new Direction[] { Direction.UP, Direction.NORTH, Direction.SOUTH, Direction.WEST, Direction.EAST };
    }
}
