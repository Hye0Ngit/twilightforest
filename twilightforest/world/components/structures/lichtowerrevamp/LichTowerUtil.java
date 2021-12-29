// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.lichtowerrevamp;

import net.minecraft.world.level.block.Mirror;
import net.minecraft.core.BlockPos;
import twilightforest.util.IntPair;
import java.util.Random;
import net.minecraft.core.Direction;

public final class LichTowerUtil
{
    static IntPair yOffsetForOpening(final Direction side, final Random random, final int segmentLevel, final boolean sidesFaceXAxis) {
        int height = (side.m_122434_() == Direction.Axis.X != sidesFaceXAxis) ? 4 : 0;
        int offsetFromLeft = random.nextInt(13);
        height += offsetFromLeft - 1 >> 2;
        height += segmentLevel * 4;
        offsetFromLeft += 6;
        return new IntPair(offsetFromLeft, height);
    }
    
    static BlockPos getRandomOpeningPlacementPos(final BlockPos origin, final Direction side, final Mirror mirror, final Random random, final int segmentLevel, final boolean sidesFaceXAxis) {
        final IntPair pair = yOffsetForOpening(side, random, segmentLevel, sidesFaceXAxis);
        return switch (side) {
            case EAST -> origin.m_142082_(-1, pair.z, (mirror == Mirror.FRONT_BACK) ? (30 - pair.x) : pair.x);
            case WEST -> origin.m_142082_(30, pair.z, (mirror == Mirror.FRONT_BACK) ? pair.x : (30 - pair.x));
            case SOUTH -> origin.m_142082_((mirror == Mirror.LEFT_RIGHT) ? pair.x : (30 - pair.x), pair.z, -1);
            default -> origin.m_142082_((mirror == Mirror.LEFT_RIGHT) ? (30 - pair.x) : pair.x, pair.z, 30);
        };
    }
}
