// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.util;

import net.minecraft.block.material.Material;
import net.minecraft.block.Blocks;
import net.minecraft.world.IWorldReader;
import net.minecraft.block.BlockState;
import net.minecraft.world.IWorld;
import twilightforest.world.feature.config.TFTreeFeatureConfig;
import twilightforest.world.feature.TFTreeGenerator;
import net.minecraft.world.gen.trunkplacer.AbstractTrunkPlacer;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.block.AirBlock;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.feature.TreeFeature;
import java.util.Set;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.util.Direction;

public class FeatureUtil
{
    private static final Direction[] directionsExceptDown;
    
    public static void putLeafBlock(final IWorldGenerationReader world, final Random random, final BlockPos pos, final BlockStateProvider state, final Set<BlockPos> leavesPos) {
        if (!TreeFeature.func_236404_a_((IWorldGenerationBaseReader)world, pos)) {
            return;
        }
        world.func_180501_a(pos, state.func_225574_a_(random, pos), 3);
        leavesPos.add(pos.func_185334_h());
    }
    
    public static void makeLeafCircle(final IWorldGenerationReader world, final Random random, final BlockPos centerPos, final float radius, final BlockStateProvider state, final Set<BlockPos> leaves) {
        final float radiusSquared = radius * radius;
        putLeafBlock(world, random, centerPos, state, leaves);
        for (int x = 0; x <= radius; ++x) {
            for (int z = 1; z <= radius; ++z) {
                if (x * x + z * z <= radiusSquared) {
                    putLeafBlock(world, random, centerPos.func_177982_a(x, 0, z), state, leaves);
                    putLeafBlock(world, random, centerPos.func_177982_a(-x, 0, -z), state, leaves);
                    putLeafBlock(world, random, centerPos.func_177982_a(-z, 0, x), state, leaves);
                    putLeafBlock(world, random, centerPos.func_177982_a(z, 0, -x), state, leaves);
                }
            }
        }
    }
    
    public static void makeLeafSpheroid(final IWorldGenerationReader world, final Random random, final BlockPos centerPos, final float xzRadius, final float yRadius, final float verticalBias, final BlockStateProvider state, final Set<BlockPos> leaves) {
        final float xzRadiusSquared = xzRadius * xzRadius;
        final float yRadiusSquared = yRadius * yRadius;
        final float superRadiusSquared = xzRadiusSquared * yRadiusSquared;
        putLeafBlock(world, random, centerPos, state, leaves);
        for (int y = 0; y <= yRadius; ++y) {
            if (y <= yRadius) {
                putLeafBlock(world, random, centerPos.func_177982_a(0, y, 0), state, leaves);
                putLeafBlock(world, random, centerPos.func_177982_a(0, y, 0), state, leaves);
                putLeafBlock(world, random, centerPos.func_177982_a(0, y, 0), state, leaves);
                putLeafBlock(world, random, centerPos.func_177982_a(0, y, 0), state, leaves);
                putLeafBlock(world, random, centerPos.func_177982_a(0, -y, 0), state, leaves);
                putLeafBlock(world, random, centerPos.func_177982_a(0, -y, 0), state, leaves);
                putLeafBlock(world, random, centerPos.func_177982_a(0, -y, 0), state, leaves);
                putLeafBlock(world, random, centerPos.func_177982_a(0, -y, 0), state, leaves);
            }
        }
        for (int x = 0; x <= xzRadius; ++x) {
            for (int z = 1; z <= xzRadius; ++z) {
                if (x * x + z * z <= xzRadiusSquared) {
                    putLeafBlock(world, random, centerPos.func_177982_a(x, 0, z), state, leaves);
                    putLeafBlock(world, random, centerPos.func_177982_a(-x, 0, -z), state, leaves);
                    putLeafBlock(world, random, centerPos.func_177982_a(-z, 0, x), state, leaves);
                    putLeafBlock(world, random, centerPos.func_177982_a(z, 0, -x), state, leaves);
                    for (int y2 = 1; y2 <= yRadius; ++y2) {
                        final float xzSquare = (x * x + z * z) * yRadiusSquared;
                        if (xzSquare + (y2 - verticalBias) * (y2 - verticalBias) * xzRadiusSquared <= superRadiusSquared) {
                            putLeafBlock(world, random, centerPos.func_177982_a(x, y2, z), state, leaves);
                            putLeafBlock(world, random, centerPos.func_177982_a(-x, y2, -z), state, leaves);
                            putLeafBlock(world, random, centerPos.func_177982_a(-z, y2, x), state, leaves);
                            putLeafBlock(world, random, centerPos.func_177982_a(z, y2, -x), state, leaves);
                        }
                        if (xzSquare + (y2 + verticalBias) * (y2 + verticalBias) * xzRadiusSquared <= superRadiusSquared) {
                            putLeafBlock(world, random, centerPos.func_177982_a(x, -y2, z), state, leaves);
                            putLeafBlock(world, random, centerPos.func_177982_a(-x, -y2, -z), state, leaves);
                            putLeafBlock(world, random, centerPos.func_177982_a(-z, -y2, x), state, leaves);
                            putLeafBlock(world, random, centerPos.func_177982_a(z, -y2, -x), state, leaves);
                        }
                    }
                }
            }
        }
    }
    
    public static void makeLeafSpheroid(final IWorldGenerationReader world, final Random random, final BlockPos centerPos, final float radius, final BlockStateProvider state, final Set<BlockPos> leaves) {
        final float radiusSquared = radius * radius;
        putLeafBlock(world, random, centerPos, state, leaves);
        for (int y = 0; y <= radius; ++y) {
            if (y <= radius) {
                putLeafBlock(world, random, centerPos.func_177982_a(0, y, 0), state, leaves);
                putLeafBlock(world, random, centerPos.func_177982_a(0, y, 0), state, leaves);
                putLeafBlock(world, random, centerPos.func_177982_a(0, y, 0), state, leaves);
                putLeafBlock(world, random, centerPos.func_177982_a(0, y, 0), state, leaves);
                putLeafBlock(world, random, centerPos.func_177982_a(0, -y, 0), state, leaves);
                putLeafBlock(world, random, centerPos.func_177982_a(0, -y, 0), state, leaves);
                putLeafBlock(world, random, centerPos.func_177982_a(0, -y, 0), state, leaves);
                putLeafBlock(world, random, centerPos.func_177982_a(0, -y, 0), state, leaves);
            }
        }
        for (int x = 0; x <= radius; ++x) {
            for (int z = 1; z <= radius; ++z) {
                final float xzSquare = (float)(x * x + z * z);
                if (xzSquare <= radiusSquared) {
                    putLeafBlock(world, random, centerPos.func_177982_a(x, 0, z), state, leaves);
                    putLeafBlock(world, random, centerPos.func_177982_a(-x, 0, -z), state, leaves);
                    putLeafBlock(world, random, centerPos.func_177982_a(-z, 0, x), state, leaves);
                    putLeafBlock(world, random, centerPos.func_177982_a(z, 0, -x), state, leaves);
                    for (int y2 = 1; y2 <= radius; ++y2) {
                        if (xzSquare + y2 * y2 <= radius * radius) {
                            putLeafBlock(world, random, centerPos.func_177982_a(x, y2, z), state, leaves);
                            putLeafBlock(world, random, centerPos.func_177982_a(-x, y2, -z), state, leaves);
                            putLeafBlock(world, random, centerPos.func_177982_a(-z, y2, x), state, leaves);
                            putLeafBlock(world, random, centerPos.func_177982_a(z, y2, -x), state, leaves);
                            putLeafBlock(world, random, centerPos.func_177982_a(x, -y2, z), state, leaves);
                            putLeafBlock(world, random, centerPos.func_177982_a(-x, -y2, -z), state, leaves);
                            putLeafBlock(world, random, centerPos.func_177982_a(-z, -y2, x), state, leaves);
                            putLeafBlock(world, random, centerPos.func_177982_a(z, -y2, -x), state, leaves);
                        }
                    }
                }
            }
        }
    }
    
    public static boolean hasAirAround(final IWorldGenerationReader world, final BlockPos pos) {
        for (final Direction e : FeatureUtil.directionsExceptDown) {
            if (world.func_217375_a(pos, b -> b.func_177230_c() instanceof AirBlock)) {
                return true;
            }
        }
        return false;
    }
    
    public static void drawBresenhamBranch(final IWorldGenerationReader world, final Random random, final BlockPos from, final BlockPos to, final Set<BlockPos> state, final MutableBoundingBox mbb, final BaseTreeFeatureConfig config) {
        for (final BlockPos pixel : getBresenhamArrays(from, to)) {
            AbstractTrunkPlacer.func_236911_a_(world, random, pixel, (Set)state, mbb, config);
        }
    }
    
    public static BlockPos translate(final BlockPos pos, final double distance, final double angle, final double tilt) {
        final double rangle = angle * 2.0 * 3.141592653589793;
        final double rtilt = tilt * 3.141592653589793;
        return pos.func_177963_a((double)Math.round(Math.sin(rangle) * Math.sin(rtilt) * distance), (double)Math.round(Math.cos(rtilt) * distance), (double)Math.round(Math.cos(rangle) * Math.sin(rtilt) * distance));
    }
    
    public static void drawBresenhamBranch(final TFTreeGenerator<? extends TFTreeFeatureConfig> generator, final IWorld world, final Random random, final BlockPos from, final BlockPos to, final Set<BlockPos> state, final MutableBoundingBox mbb, final TFTreeFeatureConfig config) {
        for (final BlockPos pixel : getBresenhamArrays(from, to)) {
            generator.setBranchBlockState(world, random, pixel, state, mbb, config);
        }
    }
    
    public static void drawBresenhamTree(final IWorld world, final BlockPos from, final BlockPos to, final BlockState state, final Set<BlockPos> treepos) {
        for (final BlockPos pixel : getBresenhamArrays(from, to)) {
            world.func_180501_a(pixel, state, 3);
            treepos.add(pixel.func_185334_h());
        }
    }
    
    public static BlockPos[] getBresenhamArrays(final BlockPos src, final BlockPos dest) {
        return getBresenhamArrays(src.func_177958_n(), src.func_177956_o(), src.func_177952_p(), dest.func_177958_n(), dest.func_177956_o(), dest.func_177952_p());
    }
    
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
                    pixel = pixel.func_177981_b(y_inc);
                    err_1 -= doubleAbsDx;
                }
                if (err_2 > 0) {
                    pixel = pixel.func_177970_e(z_inc);
                    err_2 -= doubleAbsDx;
                }
                err_1 += doubleAbsDy;
                err_2 += doubleAbsDz;
                pixel = pixel.func_177965_g(x_inc);
            }
        }
        else if (absDy >= absDx && absDy >= absDz) {
            int err_1 = doubleAbsDx - absDy;
            int err_2 = doubleAbsDz - absDy;
            lineArray = new BlockPos[absDy + 1];
            for (int i = 0; i < absDy; ++i) {
                lineArray[i] = pixel;
                if (err_1 > 0) {
                    pixel = pixel.func_177965_g(x_inc);
                    err_1 -= doubleAbsDy;
                }
                if (err_2 > 0) {
                    pixel = pixel.func_177970_e(z_inc);
                    err_2 -= doubleAbsDy;
                }
                err_1 += doubleAbsDx;
                err_2 += doubleAbsDz;
                pixel = pixel.func_177981_b(y_inc);
            }
        }
        else {
            int err_1 = doubleAbsDy - absDz;
            int err_2 = doubleAbsDx - absDz;
            lineArray = new BlockPos[absDz + 1];
            for (int i = 0; i < absDz; ++i) {
                lineArray[i] = pixel;
                if (err_1 > 0) {
                    pixel = pixel.func_177981_b(y_inc);
                    err_1 -= doubleAbsDz;
                }
                if (err_2 > 0) {
                    pixel = pixel.func_177965_g(x_inc);
                    err_2 -= doubleAbsDz;
                }
                err_1 += doubleAbsDy;
                err_2 += doubleAbsDx;
                pixel = pixel.func_177970_e(z_inc);
            }
        }
        lineArray[lineArray.length - 1] = pixel;
        return lineArray;
    }
    
    public static void makeLeafCircle(final IWorld world, final BlockPos pos, final int rad, final BlockState state, final Set<BlockPos> leaves, final boolean useHack) {
        for (byte dx = 0; dx <= rad; ++dx) {
            for (byte dz = 0; dz <= rad; ++dz) {
                int dist = Math.max(dx, dz) + (Math.min(dx, dz) >> 1);
                if (useHack && dx == 3 && dz == 3) {
                    dist = 6;
                }
                if (dist <= rad) {
                    putLeafBlock(world, pos.func_177982_a((int)dx, 0, (int)dz), state, leaves);
                    putLeafBlock(world, pos.func_177982_a((int)dx, 0, -dz), state, leaves);
                    putLeafBlock(world, pos.func_177982_a(-dx, 0, (int)dz), state, leaves);
                    putLeafBlock(world, pos.func_177982_a(-dx, 0, -dz), state, leaves);
                }
            }
        }
    }
    
    public static void putLeafBlock(final IWorld world, final BlockPos pos, final BlockState state, final Set<BlockPos> leavespos) {
        final BlockState whatsThere = world.func_180495_p(pos);
        if (whatsThere.canBeReplacedByLeaves((IWorldReader)world, pos) && whatsThere.func_177230_c() != state.func_177230_c()) {
            world.func_180501_a(pos, state, 3);
            leavespos.add(pos.func_185334_h());
        }
    }
    
    public static void makeLeafCircle2(final IWorld world, final BlockPos pos, final int rad, final BlockState state, final Set<BlockPos> leaves) {
        for (byte dx = 0; dx <= rad; ++dx) {
            for (byte dz = 0; dz <= rad; ++dz) {
                if (dx * dx + dz * dz <= rad * rad) {
                    putLeafBlock(world, pos.func_177982_a(1 + dx, 0, 1 + dz), state, leaves);
                    putLeafBlock(world, pos.func_177982_a(1 + dx, 0, -dz), state, leaves);
                    putLeafBlock(world, pos.func_177982_a(-dx, 0, 1 + dz), state, leaves);
                    putLeafBlock(world, pos.func_177982_a(-dx, 0, -dz), state, leaves);
                }
            }
        }
    }
    
    public static BlockState randStone(final Random rand, final int howMuch) {
        return (rand.nextInt(howMuch) >= 1) ? Blocks.field_150347_e.func_176223_P() : Blocks.field_150341_Y.func_176223_P();
    }
    
    public static boolean isAreaSuitable(final IWorld world, final BlockPos pos, final int width, final int height, final int depth) {
        boolean flag = true;
        for (int cx = 0; cx < width; ++cx) {
            for (int cz = 0; cz < depth; ++cz) {
                final BlockPos pos_ = pos.func_177982_a(cx, 0, cz);
                if (world.func_175667_e(pos_)) {
                    final Material m = world.func_180495_p(pos_.func_177977_b()).func_185904_a();
                    if (m != Material.field_151578_c && m != Material.field_151577_b && m != Material.field_151576_e) {
                        flag = false;
                    }
                    for (int cy = 0; cy < height; ++cy) {
                        if (!world.func_175623_d(pos_.func_177981_b(cy))) {
                            flag = false;
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
    
    public static void drawBlob(final IWorld world, final BlockPos pos, final int rad, final BlockState state) {
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
                        world.func_180501_a(pos.func_177982_a((int)dx, (int)dy, (int)dz), state, 3);
                        world.func_180501_a(pos.func_177982_a((int)dx, (int)dy, -dz), state, 3);
                        world.func_180501_a(pos.func_177982_a(-dx, (int)dy, (int)dz), state, 3);
                        world.func_180501_a(pos.func_177982_a(-dx, (int)dy, -dz), state, 3);
                        world.func_180501_a(pos.func_177982_a((int)dx, -dy, (int)dz), state, 3);
                        world.func_180501_a(pos.func_177982_a((int)dx, -dy, -dz), state, 3);
                        world.func_180501_a(pos.func_177982_a(-dx, -dy, (int)dz), state, 3);
                        world.func_180501_a(pos.func_177982_a(-dx, -dy, -dz), state, 3);
                    }
                }
            }
        }
    }
    
    public static void drawLeafBlob(final IWorld world, final BlockPos pos, final int rad, final BlockState state, final Set<BlockPos> leaves) {
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
                        putLeafBlock(world, pos.func_177982_a((int)dx, (int)dy, (int)dz), state, leaves);
                        putLeafBlock(world, pos.func_177982_a((int)dx, (int)dy, -dz), state, leaves);
                        putLeafBlock(world, pos.func_177982_a(-dx, (int)dy, (int)dz), state, leaves);
                        putLeafBlock(world, pos.func_177982_a(-dx, (int)dy, -dz), state, leaves);
                        putLeafBlock(world, pos.func_177982_a((int)dx, -dy, (int)dz), state, leaves);
                        putLeafBlock(world, pos.func_177982_a((int)dx, -dy, -dz), state, leaves);
                        putLeafBlock(world, pos.func_177982_a(-dx, -dy, (int)dz), state, leaves);
                        putLeafBlock(world, pos.func_177982_a(-dx, -dy, -dz), state, leaves);
                    }
                }
            }
        }
    }
    
    public static boolean surroundedByAir(final IWorldReader world, final BlockPos pos) {
        for (final Direction e : Direction.values()) {
            if (!world.func_175623_d(pos.func_177972_a(e))) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean hasAirAround(final IWorld world, final BlockPos pos) {
        for (final Direction e : FeatureUtil.directionsExceptDown) {
            if (world.func_175623_d(pos.func_177972_a(e))) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean isNearSolid(final IWorldReader world, final BlockPos pos) {
        for (final Direction e : Direction.values()) {
            if (world.func_175667_e(pos.func_177972_a(e)) && world.func_180495_p(pos.func_177972_a(e)).func_185904_a().func_76220_a()) {
                return true;
            }
        }
        return false;
    }
    
    public static void setBlockStateProvider(final IWorld world, final BlockStateProvider provider, final Random rand, final BlockPos pos) {
        world.func_180501_a(pos, provider.func_225574_a_(rand, pos), 3);
    }
    
    static {
        directionsExceptDown = new Direction[] { Direction.UP, Direction.NORTH, Direction.SOUTH, Direction.WEST, Direction.EAST };
    }
}
