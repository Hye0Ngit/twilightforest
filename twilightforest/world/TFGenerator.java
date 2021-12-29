// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.world.IBlockAccess;
import net.minecraft.block.material.Material;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.gen.feature.WorldGenerator;

public abstract class TFGenerator extends WorldGenerator
{
    public TFGenerator() {
        this(false);
    }
    
    public TFGenerator(final boolean par1) {
        super(par1);
    }
    
    public static int[] translate(final int sx, final int sy, final int sz, final double distance, final double angle, final double tilt) {
        final int[] dest = { sx, sy, sz };
        final double rangle = angle * 2.0 * 3.141592653589793;
        final double rtilt = tilt * 3.141592653589793;
        final int[] array = dest;
        final int n = 0;
        array[n] += (int)Math.round(Math.sin(rangle) * Math.sin(rtilt) * distance);
        final int[] array2 = dest;
        final int n2 = 1;
        array2[n2] += (int)Math.round(Math.cos(rtilt) * distance);
        final int[] array3 = dest;
        final int n3 = 2;
        array3[n3] += (int)Math.round(Math.cos(rangle) * Math.sin(rtilt) * distance);
        return dest;
    }
    
    public static ChunkCoordinates translateCoords(final int sx, final int sy, final int sz, final double distance, final double angle, final double tilt) {
        final ChunkCoordinates dest = new ChunkCoordinates(sx, sy, sz);
        final double rangle = angle * 2.0 * 3.141592653589793;
        final double rtilt = tilt * 3.141592653589793;
        final ChunkCoordinates chunkCoordinates = dest;
        chunkCoordinates.field_71574_a += (int)Math.round(Math.sin(rangle) * Math.sin(rtilt) * distance);
        final ChunkCoordinates chunkCoordinates2 = dest;
        chunkCoordinates2.field_71572_b += (int)Math.round(Math.cos(rtilt) * distance);
        final ChunkCoordinates chunkCoordinates3 = dest;
        chunkCoordinates3.field_71573_c += (int)Math.round(Math.cos(rangle) * Math.sin(rtilt) * distance);
        return dest;
    }
    
    protected void drawBresehnam(final World world, final int x1, final int y1, final int z1, final int x2, final int y2, final int z2, final int blockValue, final int metaValue) {
        final ChunkCoordinates[] arr$;
        final ChunkCoordinates[] lineArray = arr$ = getBresehnamArrayCoords(x1, y1, z1, x2, y2, z2);
        for (final ChunkCoordinates pixel : arr$) {
            this.func_76485_a(world, pixel.field_71574_a, pixel.field_71572_b, pixel.field_71573_c, blockValue, metaValue);
        }
    }
    
    public static ChunkCoordinates[] getBresehnamArrayCoords(final ChunkCoordinates src, final ChunkCoordinates dest) {
        return getBresehnamArrayCoords(src.field_71574_a, src.field_71572_b, src.field_71573_c, dest.field_71574_a, dest.field_71572_b, dest.field_71573_c);
    }
    
    public static ChunkCoordinates[] getBresehnamArrayCoords(final int x1, final int y1, final int z1, final int x2, final int y2, final int z2) {
        final ChunkCoordinates pixel = new ChunkCoordinates(x1, y1, z1);
        final int dx = x2 - x1;
        final int dy = y2 - y1;
        final int dz = z2 - z1;
        final int x_inc = (dx < 0) ? -1 : 1;
        final int l = Math.abs(dx);
        final int y_inc = (dy < 0) ? -1 : 1;
        final int m = Math.abs(dy);
        final int z_inc = (dz < 0) ? -1 : 1;
        final int n = Math.abs(dz);
        final int dx2 = l << 1;
        final int dy2 = m << 1;
        final int dz2 = n << 1;
        ChunkCoordinates[] lineArray;
        if (l >= m && l >= n) {
            int err_1 = dy2 - l;
            int err_2 = dz2 - l;
            lineArray = new ChunkCoordinates[l + 1];
            for (int i = 0; i < l; ++i) {
                lineArray[i] = new ChunkCoordinates(pixel);
                if (err_1 > 0) {
                    final ChunkCoordinates chunkCoordinates = pixel;
                    chunkCoordinates.field_71572_b += y_inc;
                    err_1 -= dx2;
                }
                if (err_2 > 0) {
                    final ChunkCoordinates chunkCoordinates2 = pixel;
                    chunkCoordinates2.field_71573_c += z_inc;
                    err_2 -= dx2;
                }
                err_1 += dy2;
                err_2 += dz2;
                final ChunkCoordinates chunkCoordinates3 = pixel;
                chunkCoordinates3.field_71574_a += x_inc;
            }
        }
        else if (m >= l && m >= n) {
            int err_1 = dx2 - m;
            int err_2 = dz2 - m;
            lineArray = new ChunkCoordinates[m + 1];
            for (int i = 0; i < m; ++i) {
                lineArray[i] = new ChunkCoordinates(pixel);
                if (err_1 > 0) {
                    final ChunkCoordinates chunkCoordinates4 = pixel;
                    chunkCoordinates4.field_71574_a += x_inc;
                    err_1 -= dy2;
                }
                if (err_2 > 0) {
                    final ChunkCoordinates chunkCoordinates5 = pixel;
                    chunkCoordinates5.field_71573_c += z_inc;
                    err_2 -= dy2;
                }
                err_1 += dx2;
                err_2 += dz2;
                final ChunkCoordinates chunkCoordinates6 = pixel;
                chunkCoordinates6.field_71572_b += y_inc;
            }
        }
        else {
            int err_1 = dy2 - n;
            int err_2 = dx2 - n;
            lineArray = new ChunkCoordinates[n + 1];
            for (int i = 0; i < n; ++i) {
                lineArray[i] = new ChunkCoordinates(pixel);
                if (err_1 > 0) {
                    final ChunkCoordinates chunkCoordinates7 = pixel;
                    chunkCoordinates7.field_71572_b += y_inc;
                    err_1 -= dz2;
                }
                if (err_2 > 0) {
                    final ChunkCoordinates chunkCoordinates8 = pixel;
                    chunkCoordinates8.field_71574_a += x_inc;
                    err_2 -= dz2;
                }
                err_1 += dy2;
                err_2 += dx2;
                final ChunkCoordinates chunkCoordinates9 = pixel;
                chunkCoordinates9.field_71573_c += z_inc;
            }
        }
        lineArray[lineArray.length - 1] = new ChunkCoordinates(pixel);
        return lineArray;
    }
    
    public void makeLeafCircle(final World world, final int sx, final int sy, final int sz, final int rad, final int blockValue, final int metaValue) {
        this.makeLeafCircle(world, sx, sy, sz, rad, blockValue, metaValue, false);
    }
    
    public void makeLeafCircle(final World world, final int sx, final int sy, final int sz, final int rad, final int blockValue, final int metaValue, final boolean useHack) {
        for (byte dx = 0; dx <= rad; ++dx) {
            for (byte dz = 0; dz <= rad; ++dz) {
                int dist = Math.max(dx, dz) + (Math.min(dx, dz) >> 1);
                if (useHack && dx == 3 && dz == 3) {
                    dist = 6;
                }
                if (dist <= rad) {
                    this.putLeafBlock(world, sx + dx, sy, sz + dz, blockValue, metaValue);
                    this.putLeafBlock(world, sx + dx, sy, sz - dz, blockValue, metaValue);
                    this.putLeafBlock(world, sx - dx, sy, sz + dz, blockValue, metaValue);
                    this.putLeafBlock(world, sx - dx, sy, sz - dz, blockValue, metaValue);
                }
            }
        }
    }
    
    public void makeLeafCircle2(final World world, final int sx, final int sy, final int sz, final int rad, final int blockValue, final int metaValue, final boolean useHack) {
        for (byte dx = 0; dx <= rad; ++dx) {
            for (byte dz = 0; dz <= rad; ++dz) {
                if (dx * dx + dz * dz <= rad * rad) {
                    this.putLeafBlock(world, sx + 1 + dx, sy, sz + 1 + dz, blockValue, metaValue);
                    this.putLeafBlock(world, sx + 1 + dx, sy, sz - dz, blockValue, metaValue);
                    this.putLeafBlock(world, sx - dx, sy, sz + 1 + dz, blockValue, metaValue);
                    this.putLeafBlock(world, sx - dx, sy, sz - dz, blockValue, metaValue);
                }
            }
        }
    }
    
    public void putLeafBlock(final World world, final int x, final int y, final int z, final int blockValue, final int metaValue) {
        final int whatsThere = world.func_72798_a(x, y, z);
        final Block block = Block.field_71973_m[whatsThere];
        if (block == null || block.canBeReplacedByLeaves(world, x, y, z)) {
            this.func_76485_a(world, x, y, z, blockValue, metaValue);
        }
    }
    
    protected byte randStone(final Random rand, final int howMuch) {
        return (rand.nextInt(howMuch) >= 1) ? ((byte)Block.field_71978_w.field_71990_ca) : ((byte)Block.field_72087_ao.field_71990_ca);
    }
    
    protected boolean isAreaClear(final World world, final Random rand, final int x, final int y, final int z, final int dx, final int dy, final int dz) {
        boolean flag = true;
        for (int cx = 0; cx < dx; ++cx) {
            for (int cz = 0; cz < dy; ++cz) {
                final Material m = world.func_72803_f(x + cx, y - 1, z + cz);
                if (m != Material.field_76248_c && m != Material.field_76247_b && m != Material.field_76246_e) {
                    flag = false;
                }
                for (int cy = 0; cy < dz; ++cy) {
                    if (!world.func_72799_c(x + cx, y + cy, z + cz)) {
                        flag = false;
                    }
                }
            }
        }
        return flag;
    }
    
    public void drawBlob(final World world, final int sx, final int sy, final int sz, final int rad, final int blockValue, final int metaValue) {
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
                        this.func_76485_a(world, sx + dx, sy + dy, sz + dz, blockValue, metaValue);
                        this.func_76485_a(world, sx + dx, sy + dy, sz - dz, blockValue, metaValue);
                        this.func_76485_a(world, sx - dx, sy + dy, sz + dz, blockValue, metaValue);
                        this.func_76485_a(world, sx - dx, sy + dy, sz - dz, blockValue, metaValue);
                        this.func_76485_a(world, sx + dx, sy - dy, sz + dz, blockValue, metaValue);
                        this.func_76485_a(world, sx + dx, sy - dy, sz - dz, blockValue, metaValue);
                        this.func_76485_a(world, sx - dx, sy - dy, sz + dz, blockValue, metaValue);
                        this.func_76485_a(world, sx - dx, sy - dy, sz - dz, blockValue, metaValue);
                    }
                }
            }
        }
    }
    
    public void drawLeafBlob(final World world, final int sx, final int sy, final int sz, final int rad, final int blockValue, final int metaValue) {
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
                        this.putLeafBlock(world, sx + dx, sy + dy, sz + dz, blockValue, metaValue);
                        this.putLeafBlock(world, sx + dx, sy + dy, sz - dz, blockValue, metaValue);
                        this.putLeafBlock(world, sx - dx, sy + dy, sz + dz, blockValue, metaValue);
                        this.putLeafBlock(world, sx - dx, sy + dy, sz - dz, blockValue, metaValue);
                        this.putLeafBlock(world, sx + dx, sy - dy, sz + dz, blockValue, metaValue);
                        this.putLeafBlock(world, sx + dx, sy - dy, sz - dz, blockValue, metaValue);
                        this.putLeafBlock(world, sx - dx, sy - dy, sz + dz, blockValue, metaValue);
                        this.putLeafBlock(world, sx - dx, sy - dy, sz - dz, blockValue, metaValue);
                    }
                }
            }
        }
    }
    
    protected boolean hasAirAround(final IBlockAccess world, final int bx, final int by, final int bz) {
        boolean airAround = false;
        if (world.func_72799_c(bx + 1, by, bz)) {
            airAround = true;
        }
        if (world.func_72799_c(bx - 1, by, bz)) {
            airAround = true;
        }
        if (world.func_72799_c(bx, by, bz + 1)) {
            airAround = true;
        }
        if (world.func_72799_c(bx, by, bz - 1)) {
            airAround = true;
        }
        if (world.func_72799_c(bx, by + 1, bz)) {
            airAround = true;
        }
        if (world.func_72799_c(bx, by - 1, bz)) {
            airAround = true;
        }
        return airAround;
    }
    
    protected static boolean surroundedByAir(final IBlockAccess world, final int bx, final int by, final int bz) {
        boolean airAround = true;
        if (!world.func_72799_c(bx + 1, by, bz)) {
            airAround = false;
        }
        if (!world.func_72799_c(bx - 1, by, bz)) {
            airAround = false;
        }
        if (!world.func_72799_c(bx, by, bz + 1)) {
            airAround = false;
        }
        if (!world.func_72799_c(bx, by, bz - 1)) {
            airAround = false;
        }
        if (!world.func_72799_c(bx, by + 1, bz)) {
            airAround = false;
        }
        if (!world.func_72799_c(bx, by - 1, bz)) {
            airAround = false;
        }
        return airAround;
    }
    
    protected static boolean isNearSolid(final IBlockAccess world, final int bx, final int by, final int bz) {
        boolean nearSolid = false;
        if (world.func_72803_f(bx + 1, by, bz).func_76220_a()) {
            nearSolid = true;
        }
        if (world.func_72803_f(bx - 1, by, bz).func_76220_a()) {
            nearSolid = true;
        }
        if (world.func_72803_f(bx, by, bz + 1).func_76220_a()) {
            nearSolid = true;
        }
        if (world.func_72803_f(bx, by, bz - 1).func_76220_a()) {
            nearSolid = true;
        }
        return nearSolid;
    }
}
