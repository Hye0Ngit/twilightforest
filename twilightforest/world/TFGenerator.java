// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.world.IBlockAccess;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public abstract class TFGenerator extends WorldGenerator
{
    public TFGenerator() {
        this(false);
    }
    
    public TFGenerator(final boolean par1) {
        super(par1);
    }
    
    public abstract boolean func_76484_a(final World p0, final Random p1, final int p2, final int p3, final int p4);
    
    protected boolean putBlock(final World world, final int dx, final int dy, final int dz, final int blockValue, final boolean priority) {
        return this.putBlockAndMetadata(world, dx, dy, dz, blockValue, 0, priority);
    }
    
    protected boolean putBlockAndMetadata(final World world, final int dx, final int dy, final int dz, final int blockValue, final int metaValue, final boolean priority) {
        if (priority) {
            this.func_76485_a(world, dx, dy, dz, blockValue, metaValue);
        }
        else {
            final int whatsThere = world.func_72798_a(dx, dy, dz);
            if (whatsThere != 0) {
                return false;
            }
            this.func_76485_a(world, dx, dy, dz, blockValue, metaValue);
        }
        return true;
    }
    
    protected void putBlockAndMetadata(final World world, final int[] pixel, final int blockValue, final int metaValue, final boolean priority) {
        this.putBlockAndMetadata(world, pixel[0], pixel[1], pixel[2], blockValue, metaValue, priority);
    }
    
    protected void putBlock(final World world, final int[] pixel, final int blockValue, final boolean priority) {
        this.putBlockAndMetadata(world, pixel[0], pixel[1], pixel[2], blockValue, 0, priority);
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
    
    protected void drawBresehnam(final World world, final int x1, final int y1, final int z1, final int x2, final int y2, final int z2, final int blockValue, final boolean priority) {
        this.drawBresehnam(world, x1, y1, z1, x2, y2, z2, blockValue, 0, priority);
    }
    
    protected void drawBresehnamX(final World world, final int x1, final int y1, final int z1, final int x2, final int y2, final int z2, final int blockValue, final int metaValue, final boolean priority) {
        final int[] pixel = { x1, y1, z1 };
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
        if (l >= m && l >= n) {
            int err_1 = dy2 - l;
            int err_2 = dz2 - l;
            for (int i = 0; i < l; ++i) {
                this.putBlockAndMetadata(world, pixel, blockValue, metaValue, priority);
                if (err_1 > 0) {
                    final int[] array = pixel;
                    final int n2 = 1;
                    array[n2] += y_inc;
                    err_1 -= dx2;
                }
                if (err_2 > 0) {
                    final int[] array2 = pixel;
                    final int n3 = 2;
                    array2[n3] += z_inc;
                    err_2 -= dx2;
                }
                err_1 += dy2;
                err_2 += dz2;
                final int[] array3 = pixel;
                final int n4 = 0;
                array3[n4] += x_inc;
            }
        }
        else if (m >= l && m >= n) {
            int err_1 = dx2 - m;
            int err_2 = dz2 - m;
            for (int i = 0; i < m; ++i) {
                this.putBlockAndMetadata(world, pixel, blockValue, metaValue, priority);
                if (err_1 > 0) {
                    final int[] array4 = pixel;
                    final int n5 = 0;
                    array4[n5] += x_inc;
                    err_1 -= dy2;
                }
                if (err_2 > 0) {
                    final int[] array5 = pixel;
                    final int n6 = 2;
                    array5[n6] += z_inc;
                    err_2 -= dy2;
                }
                err_1 += dx2;
                err_2 += dz2;
                final int[] array6 = pixel;
                final int n7 = 1;
                array6[n7] += y_inc;
            }
        }
        else {
            int err_1 = dy2 - n;
            int err_2 = dx2 - n;
            for (int i = 0; i < n; ++i) {
                this.putBlockAndMetadata(world, pixel, blockValue, metaValue, priority);
                if (err_1 > 0) {
                    final int[] array7 = pixel;
                    final int n8 = 1;
                    array7[n8] += y_inc;
                    err_1 -= dz2;
                }
                if (err_2 > 0) {
                    final int[] array8 = pixel;
                    final int n9 = 0;
                    array8[n9] += x_inc;
                    err_2 -= dz2;
                }
                err_1 += dy2;
                err_2 += dx2;
                final int[] array9 = pixel;
                final int n10 = 2;
                array9[n10] += z_inc;
            }
        }
        this.putBlockAndMetadata(world, pixel, blockValue, metaValue, priority);
    }
    
    protected void drawBresehnam(final World world, final int x1, final int y1, final int z1, final int x2, final int y2, final int z2, final int blockValue, final int metaValue, final boolean priority) {
        final int[] lineArray = getBresehnamArray(x1, y1, z1, x2, y2, z2);
        for (int i = 0; i < lineArray.length; i += 3) {
            this.putBlockAndMetadata(world, lineArray[i + 0], lineArray[i + 1], lineArray[i + 2], blockValue, metaValue, priority);
        }
    }
    
    public static int[] getBresehnamArray(final int x1, final int y1, final int z1, final int x2, final int y2, final int z2) {
        final int[] pixel = { x1, y1, z1 };
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
        int[] lineArray;
        if (l >= m && l >= n) {
            int err_1 = dy2 - l;
            int err_2 = dz2 - l;
            lineArray = new int[3 * l + 3];
            for (int i = 0; i < l * 3; i += 3) {
                lineArray[i + 0] = pixel[0];
                lineArray[i + 1] = pixel[1];
                lineArray[i + 2] = pixel[2];
                if (err_1 > 0) {
                    final int[] array = pixel;
                    final int n2 = 1;
                    array[n2] += y_inc;
                    err_1 -= dx2;
                }
                if (err_2 > 0) {
                    final int[] array2 = pixel;
                    final int n3 = 2;
                    array2[n3] += z_inc;
                    err_2 -= dx2;
                }
                err_1 += dy2;
                err_2 += dz2;
                final int[] array3 = pixel;
                final int n4 = 0;
                array3[n4] += x_inc;
            }
        }
        else if (m >= l && m >= n) {
            int err_1 = dx2 - m;
            int err_2 = dz2 - m;
            lineArray = new int[3 * m + 3];
            for (int i = 0; i < m * 3; i += 3) {
                lineArray[i + 0] = pixel[0];
                lineArray[i + 1] = pixel[1];
                lineArray[i + 2] = pixel[2];
                if (err_1 > 0) {
                    final int[] array4 = pixel;
                    final int n5 = 0;
                    array4[n5] += x_inc;
                    err_1 -= dy2;
                }
                if (err_2 > 0) {
                    final int[] array5 = pixel;
                    final int n6 = 2;
                    array5[n6] += z_inc;
                    err_2 -= dy2;
                }
                err_1 += dx2;
                err_2 += dz2;
                final int[] array6 = pixel;
                final int n7 = 1;
                array6[n7] += y_inc;
            }
        }
        else {
            int err_1 = dy2 - n;
            int err_2 = dx2 - n;
            lineArray = new int[3 * n + 3];
            for (int i = 0; i < n * 3; i += 3) {
                lineArray[i + 0] = pixel[0];
                lineArray[i + 1] = pixel[1];
                lineArray[i + 2] = pixel[2];
                if (err_1 > 0) {
                    final int[] array7 = pixel;
                    final int n8 = 1;
                    array7[n8] += y_inc;
                    err_1 -= dz2;
                }
                if (err_2 > 0) {
                    final int[] array8 = pixel;
                    final int n9 = 0;
                    array8[n9] += x_inc;
                    err_2 -= dz2;
                }
                err_1 += dy2;
                err_2 += dx2;
                final int[] array9 = pixel;
                final int n10 = 2;
                array9[n10] += z_inc;
            }
        }
        lineArray[lineArray.length - 3] = pixel[0];
        lineArray[lineArray.length - 2] = pixel[1];
        lineArray[lineArray.length - 1] = pixel[2];
        return lineArray;
    }
    
    public void drawCircle(final World world, final int sx, final int sy, final int sz, final int rad, final int blockValue, final int metaValue, final boolean priority) {
        for (byte dx = 0; dx <= rad; ++dx) {
            for (byte dz = 0; dz <= rad; ++dz) {
                int dist = Math.max(dx, dz) + (Math.min(dx, dz) >> 1);
                if (dx == 3 && dz == 3) {
                    dist = 6;
                }
                if (dist <= rad) {
                    this.putBlockAndMetadata(world, sx + dx, sy, sz + dz, blockValue, metaValue, priority);
                    this.putBlockAndMetadata(world, sx + dx, sy, sz - dz, blockValue, metaValue, priority);
                    this.putBlockAndMetadata(world, sx - dx, sy, sz + dz, blockValue, metaValue, priority);
                    this.putBlockAndMetadata(world, sx - dx, sy, sz - dz, blockValue, metaValue, priority);
                }
            }
        }
    }
    
    public void drawDiameterCircle(final World world, final int sx, final int sy, final int sz, final int diam, final int block, final int meta, final boolean priority) {
        final byte rad = (byte)((diam - 1) / 2);
        if (diam % 2 == 1) {
            this.drawCircle(world, sx, sy, sz, rad, (byte)block, meta, priority);
        }
        else {
            this.drawCircle(world, sx, sy, sz, rad, (byte)block, meta, priority);
            this.drawCircle(world, sx + 1, sy, sz, rad, (byte)block, meta, priority);
            this.drawCircle(world, sx, sy, sz + 1, rad, (byte)block, meta, priority);
            this.drawCircle(world, sx + 1, sy, sz + 1, rad, (byte)block, meta, priority);
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
    
    protected void fill(final World world, final int dx, final int dy, final int dz, final int width, final int height, final int depth, final int blockID, final int meta) {
        for (int cx = 0; cx < width; ++cx) {
            for (int cy = 0; cy < height; ++cy) {
                for (int cz = 0; cz < depth; ++cz) {
                    this.func_76485_a(world, dx + cx, dy + cy, dz + cz, blockID, meta);
                }
            }
        }
    }
    
    public void drawBlob(final World world, final int sx, final int sy, final int sz, final int rad, final int blockValue, final int metaValue, final boolean priority) {
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
                        this.putBlockAndMetadata(world, sx + dx, sy + dy, sz + dz, blockValue, metaValue, priority);
                        this.putBlockAndMetadata(world, sx + dx, sy + dy, sz - dz, blockValue, metaValue, priority);
                        this.putBlockAndMetadata(world, sx - dx, sy + dy, sz + dz, blockValue, metaValue, priority);
                        this.putBlockAndMetadata(world, sx - dx, sy + dy, sz - dz, blockValue, metaValue, priority);
                        this.putBlockAndMetadata(world, sx + dx, sy - dy, sz + dz, blockValue, metaValue, priority);
                        this.putBlockAndMetadata(world, sx + dx, sy - dy, sz - dz, blockValue, metaValue, priority);
                        this.putBlockAndMetadata(world, sx - dx, sy - dy, sz + dz, blockValue, metaValue, priority);
                        this.putBlockAndMetadata(world, sx - dx, sy - dy, sz - dz, blockValue, metaValue, priority);
                    }
                }
            }
        }
    }
    
    protected boolean hasAirAround(final IBlockAccess world, final int bx, final int by, final int bz) {
        boolean airAround = false;
        if (world.func_72798_a(bx + 1, by, bz) == 0) {
            airAround = true;
        }
        if (world.func_72798_a(bx - 1, by, bz) == 0) {
            airAround = true;
        }
        if (world.func_72798_a(bx, by, bz + 1) == 0) {
            airAround = true;
        }
        if (world.func_72798_a(bx, by, bz - 1) == 0) {
            airAround = true;
        }
        if (world.func_72798_a(bx, by + 1, bz) == 0) {
            airAround = true;
        }
        return airAround;
    }
    
    protected boolean isNearSolid(final IBlockAccess world, final int bx, final int by, final int bz) {
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
