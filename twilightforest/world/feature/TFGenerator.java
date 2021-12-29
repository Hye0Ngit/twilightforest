// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.util.EnumFacing;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public abstract class TFGenerator extends WorldGenerator implements IBlockSettable
{
    public TFGenerator() {
        this(false);
    }
    
    public TFGenerator(final boolean notify) {
        super(notify);
    }
    
    public final void setBlockAndNotify(final World worldIn, final BlockPos pos, final IBlockState state) {
        this.func_175903_a(worldIn, pos, state);
    }
    
    public static BlockPos translate(final BlockPos pos, final double distance, final double angle, final double tilt) {
        final double rangle = angle * 2.0 * 3.141592653589793;
        final double rtilt = tilt * 3.141592653589793;
        return pos.func_177963_a((double)Math.round(Math.sin(rangle) * Math.sin(rtilt) * distance), (double)Math.round(Math.cos(rtilt) * distance), (double)Math.round(Math.cos(rangle) * Math.sin(rtilt) * distance));
    }
    
    protected static void drawBresehnam(final IBlockSettable generator, final World world, final BlockPos from, final BlockPos to, final IBlockState state) {
        if (from.func_177958_n() == to.func_177958_n() && from.func_177952_p() == to.func_177952_p()) {
            for (int l = Math.max(from.func_177956_o(), to.func_177956_o()), i = Math.min(from.func_177956_o(), to.func_177956_o()); i < l; ++i) {
                generator.setBlockAndNotify(world, from.func_177981_b(i - from.func_177956_o()), state);
            }
        }
        else {
            for (final BlockPos pixel : getBresehnamArrays(from, to)) {
                generator.setBlockAndNotify(world, pixel, state);
            }
        }
    }
    
    public static BlockPos[] getBresehnamArrays(final BlockPos src, final BlockPos dest) {
        return getBresehnamArrays(src.func_177958_n(), src.func_177956_o(), src.func_177952_p(), dest.func_177958_n(), dest.func_177956_o(), dest.func_177952_p());
    }
    
    public static BlockPos[] getBresehnamArrays(final int x1, final int y1, final int z1, final int x2, final int y2, final int z2) {
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
    
    public static void makeLeafCircle(final IBlockSettable generator, final World world, final BlockPos pos, final int rad, final IBlockState state, final boolean useHack) {
        for (byte dx = 0; dx <= rad; ++dx) {
            for (byte dz = 0; dz <= rad; ++dz) {
                int dist = Math.max(dx, dz) + (Math.min(dx, dz) >> 1);
                if (useHack && dx == 3 && dz == 3) {
                    dist = 6;
                }
                if (dist <= rad) {
                    putLeafBlock(generator, world, pos.func_177982_a((int)dx, 0, (int)dz), state);
                    putLeafBlock(generator, world, pos.func_177982_a((int)dx, 0, -dz), state);
                    putLeafBlock(generator, world, pos.func_177982_a(-dx, 0, (int)dz), state);
                    putLeafBlock(generator, world, pos.func_177982_a(-dx, 0, -dz), state);
                }
            }
        }
    }
    
    public static void makeLeafCircle2(final IBlockSettable generator, final World world, final BlockPos pos, final int rad, final IBlockState state, final boolean useHack) {
        for (byte dx = 0; dx <= rad; ++dx) {
            for (byte dz = 0; dz <= rad; ++dz) {
                if (dx * dx + dz * dz <= rad * rad) {
                    putLeafBlock(generator, world, pos.func_177982_a(1 + dx, 0, 1 + dz), state);
                    putLeafBlock(generator, world, pos.func_177982_a(1 + dx, 0, -dz), state);
                    putLeafBlock(generator, world, pos.func_177982_a(-dx, 0, 1 + dz), state);
                    putLeafBlock(generator, world, pos.func_177982_a(-dx, 0, -dz), state);
                }
            }
        }
    }
    
    public static void putLeafBlock(final IBlockSettable generator, final World world, final BlockPos pos, final IBlockState state) {
        final IBlockState whatsThere = world.func_180495_p(pos);
        if (whatsThere.func_177230_c().canBeReplacedByLeaves(whatsThere, (IBlockAccess)world, pos) && whatsThere.func_177230_c() != state.func_177230_c()) {
            generator.setBlockAndNotify(world, pos, state);
        }
    }
    
    protected static IBlockState randStone(final Random rand, final int howMuch) {
        return (rand.nextInt(howMuch) >= 1) ? Blocks.field_150347_e.func_176223_P() : Blocks.field_150341_Y.func_176223_P();
    }
    
    protected static boolean isAreaSuitable(final World world, final Random rand, final BlockPos pos, final int width, final int height, final int depth) {
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
    
    public static void drawBlob(final IBlockSettable generator, final World world, final BlockPos pos, final int rad, final IBlockState state) {
        for (byte dx = 0; dx <= rad; ++dx) {
            for (byte dy = 0; dy <= rad; ++dy) {
                for (byte dz = 0; dz <= rad; ++dz) {
                    int dist = 0;
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
                        generator.setBlockAndNotify(world, pos.func_177982_a((int)dx, (int)dy, (int)dz), state);
                        generator.setBlockAndNotify(world, pos.func_177982_a((int)dx, (int)dy, -dz), state);
                        generator.setBlockAndNotify(world, pos.func_177982_a(-dx, (int)dy, (int)dz), state);
                        generator.setBlockAndNotify(world, pos.func_177982_a(-dx, (int)dy, -dz), state);
                        generator.setBlockAndNotify(world, pos.func_177982_a((int)dx, -dy, (int)dz), state);
                        generator.setBlockAndNotify(world, pos.func_177982_a((int)dx, -dy, -dz), state);
                        generator.setBlockAndNotify(world, pos.func_177982_a(-dx, -dy, (int)dz), state);
                        generator.setBlockAndNotify(world, pos.func_177982_a(-dx, -dy, -dz), state);
                    }
                }
            }
        }
    }
    
    public static void drawLeafBlob(final IBlockSettable generator, final World world, final BlockPos pos, final int rad, final IBlockState state) {
        for (byte dx = 0; dx <= rad; ++dx) {
            for (byte dy = 0; dy <= rad; ++dy) {
                for (byte dz = 0; dz <= rad; ++dz) {
                    int dist = 0;
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
                        putLeafBlock(generator, world, pos.func_177982_a((int)dx, (int)dy, (int)dz), state);
                        putLeafBlock(generator, world, pos.func_177982_a((int)dx, (int)dy, -dz), state);
                        putLeafBlock(generator, world, pos.func_177982_a(-dx, (int)dy, (int)dz), state);
                        putLeafBlock(generator, world, pos.func_177982_a(-dx, (int)dy, -dz), state);
                        putLeafBlock(generator, world, pos.func_177982_a((int)dx, -dy, (int)dz), state);
                        putLeafBlock(generator, world, pos.func_177982_a((int)dx, -dy, -dz), state);
                        putLeafBlock(generator, world, pos.func_177982_a(-dx, -dy, (int)dz), state);
                        putLeafBlock(generator, world, pos.func_177982_a(-dx, -dy, -dz), state);
                    }
                }
            }
        }
    }
    
    protected static boolean surroundedByAir(final IBlockAccess world, final BlockPos pos) {
        for (final EnumFacing e : EnumFacing.field_82609_l) {
            if (!world.func_175623_d(pos.func_177972_a(e))) {
                return false;
            }
        }
        return true;
    }
    
    protected static boolean hasAirAround(final World world, final BlockPos pos) {
        for (final EnumFacing e : EnumFacing.field_82609_l) {
            if (e != EnumFacing.DOWN) {
                if (world.func_175667_e(pos.func_177972_a(e)) && world.func_175623_d(pos.func_177972_a(e))) {
                    return true;
                }
            }
        }
        return false;
    }
    
    protected static boolean isNearSolid(final World world, final BlockPos pos) {
        for (final EnumFacing e : EnumFacing.field_176754_o) {
            if (world.func_175667_e(pos.func_177972_a(e)) && world.func_180495_p(pos.func_177972_a(e)).func_185904_a().func_76220_a()) {
                return true;
            }
        }
        return false;
    }
}
