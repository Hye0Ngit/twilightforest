// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.util;

import net.minecraft.world.level.block.Blocks;
import java.util.Random;
import net.minecraft.tags.Tag;
import twilightforest.data.BlockTagGenerator;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import java.util.function.Predicate;

public final class FeatureLogic
{
    public static final Predicate<BlockState> IS_REPLACEABLE;
    public static final Predicate<BlockState> SHOULD_SKIP;
    
    public static boolean hasEmptyNeighbor(final LevelSimulatedReader worldReader, final BlockPos pos) {
        return worldReader.m_7433_(pos.m_7494_(), (Predicate)FeatureLogic.IS_REPLACEABLE) || worldReader.m_7433_(pos.m_142127_(), (Predicate)FeatureLogic.IS_REPLACEABLE) || worldReader.m_7433_(pos.m_142128_(), (Predicate)FeatureLogic.IS_REPLACEABLE) || worldReader.m_7433_(pos.m_142125_(), (Predicate)FeatureLogic.IS_REPLACEABLE) || worldReader.m_7433_(pos.m_142126_(), (Predicate)FeatureLogic.IS_REPLACEABLE) || worldReader.m_7433_(pos.m_7495_(), (Predicate)FeatureLogic.IS_REPLACEABLE);
    }
    
    public static boolean hasSolidNeighbor(final LevelSimulatedReader worldReader, final BlockPos pos) {
        return !worldReader.m_7433_(pos.m_7495_(), (Predicate)FeatureLogic.IS_REPLACEABLE) || !worldReader.m_7433_(pos.m_142127_(), (Predicate)FeatureLogic.IS_REPLACEABLE) || !worldReader.m_7433_(pos.m_142128_(), (Predicate)FeatureLogic.IS_REPLACEABLE) || !worldReader.m_7433_(pos.m_142125_(), (Predicate)FeatureLogic.IS_REPLACEABLE) || !worldReader.m_7433_(pos.m_142126_(), (Predicate)FeatureLogic.IS_REPLACEABLE) || !worldReader.m_7433_(pos.m_7494_(), (Predicate)FeatureLogic.IS_REPLACEABLE);
    }
    
    public static boolean canRootGrowIn(final LevelSimulatedReader worldReader, final BlockPos pos) {
        if (worldReader.m_7433_(pos, (Predicate)FeatureLogic.IS_REPLACEABLE)) {
            return hasSolidNeighbor(worldReader, pos);
        }
        return worldReader.m_7433_(pos, (Predicate)FeatureLogic::isReplaceable);
    }
    
    public static boolean isReplaceable(final BlockState state) {
        return (state.m_60767_().m_76336_() || state.m_60620_((Tag)BlockTagGenerator.WORLDGEN_REPLACEABLES)) && !state.m_60620_((Tag)BlockTagGenerator.WORLDGEN_SKIPPABLES);
    }
    
    public static BlockPos translate(final BlockPos pos, final double distance, final double angle, final double tilt) {
        final double rangle = angle * 2.0 * 3.141592653589793;
        final double rtilt = tilt * 3.141592653589793;
        return pos.m_142022_((double)Math.round(Math.sin(rangle) * Math.sin(rtilt) * distance), (double)Math.round(Math.cos(rtilt) * distance), (double)Math.round(Math.cos(rangle) * Math.sin(rtilt) * distance));
    }
    
    @Deprecated
    public static BlockPos[] getBresenhamArrays(final BlockPos src, final BlockPos dest) {
        return getBresenhamArrays(src.m_123341_(), src.m_123342_(), src.m_123343_(), dest.m_123341_(), dest.m_123342_(), dest.m_123343_());
    }
    
    @Deprecated
    public static BlockPos[] getBresenhamArrays(final int x1, final int y1, final int z1, final int x2, final int y2, final int z2) {
        BlockPos pixel = new BlockPos(x1, y1, z1);
        final int dx = x2 - x1;
        final int dy = y2 - y1;
        final int dz = z2 - z1;
        final int x_inc = (dx < 0) ? -1 : 1;
        final int absDx = Math.abs(dx);
        final int y_inc = (dy < 0) ? -1 : 1;
        final int absDy = Math.abs(dy);
        final int z_inc = (dz < 0) ? -1 : 1;
        final int absDz = Math.abs(dz);
        final int doubleAbsDx = absDx << 1;
        final int doubleAbsDy = absDy << 1;
        final int doubleAbsDz = absDz << 1;
        BlockPos[] lineArray;
        if (absDx >= absDy && absDx >= absDz) {
            int err_1 = doubleAbsDy - absDx;
            int err_2 = doubleAbsDz - absDx;
            lineArray = new BlockPos[absDx + 1];
            for (int i = 0; i < absDx; ++i) {
                lineArray[i] = pixel;
                if (err_1 > 0) {
                    pixel = pixel.m_6630_(y_inc);
                    err_1 -= doubleAbsDx;
                }
                if (err_2 > 0) {
                    pixel = pixel.m_142383_(z_inc);
                    err_2 -= doubleAbsDx;
                }
                err_1 += doubleAbsDy;
                err_2 += doubleAbsDz;
                pixel = pixel.m_142385_(x_inc);
            }
        }
        else if (absDy >= absDx && absDy >= absDz) {
            int err_1 = doubleAbsDx - absDy;
            int err_2 = doubleAbsDz - absDy;
            lineArray = new BlockPos[absDy + 1];
            for (int i = 0; i < absDy; ++i) {
                lineArray[i] = pixel;
                if (err_1 > 0) {
                    pixel = pixel.m_142385_(x_inc);
                    err_1 -= doubleAbsDy;
                }
                if (err_2 > 0) {
                    pixel = pixel.m_142383_(z_inc);
                    err_2 -= doubleAbsDy;
                }
                err_1 += doubleAbsDx;
                err_2 += doubleAbsDz;
                pixel = pixel.m_6630_(y_inc);
            }
        }
        else {
            int err_1 = doubleAbsDy - absDz;
            int err_2 = doubleAbsDx - absDz;
            lineArray = new BlockPos[absDz + 1];
            for (int i = 0; i < absDz; ++i) {
                lineArray[i] = pixel;
                if (err_1 > 0) {
                    pixel = pixel.m_6630_(y_inc);
                    err_1 -= doubleAbsDz;
                }
                if (err_2 > 0) {
                    pixel = pixel.m_142385_(x_inc);
                    err_2 -= doubleAbsDz;
                }
                err_1 += doubleAbsDy;
                err_2 += doubleAbsDx;
                pixel = pixel.m_142383_(z_inc);
            }
        }
        lineArray[lineArray.length - 1] = pixel;
        return lineArray;
    }
    
    @Deprecated
    public static BlockState randStone(final Random rand, final int howMuch) {
        return (rand.nextInt(howMuch) >= 1) ? Blocks.f_50652_.m_49966_() : Blocks.f_50079_.m_49966_();
    }
    
    static {
        IS_REPLACEABLE = (state -> state.m_60767_().m_76336_());
        SHOULD_SKIP = (state -> state.m_60620_((Tag)BlockTagGenerator.WORLDGEN_SKIPPABLES));
    }
}
