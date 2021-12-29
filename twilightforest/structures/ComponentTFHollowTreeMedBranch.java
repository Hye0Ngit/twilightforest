// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.block.TFBlocks;
import java.util.Random;
import java.util.List;
import twilightforest.world.TFGenerator;

public class ComponentTFHollowTreeMedBranch extends StructureTFComponent
{
    int[] src;
    int[] dest;
    double length;
    double angle;
    double tilt;
    boolean leafy;
    
    protected ComponentTFHollowTreeMedBranch(final int i, final int sx, final int sy, final int sz, final double length, final double angle, final double tilt, final boolean leafy) {
        super(i);
        this.src = new int[] { sx, sy, sz };
        this.dest = TFGenerator.translate(this.src[0], this.src[1], this.src[2], length, angle, tilt);
        this.length = length;
        this.angle = angle;
        this.tilt = tilt;
        this.leafy = leafy;
        this.setCoordBaseMode(0);
        this.e = new aee(Math.min(this.src[0], this.dest[0]), Math.min(this.src[1], this.dest[1]), Math.min(this.src[2], this.dest[2]), Math.max(this.src[0], this.dest[0]), Math.max(this.src[1], this.dest[1]), Math.max(this.src[2], this.dest[2]));
    }
    
    public void a(final agq structurecomponent, final List list, final Random rand) {
        final int index = this.c();
        if (this.leafy) {
            for (int numLeafBalls = Math.min(rand.nextInt(3) + 1, (int)(this.length / 5.0)), i = 0; i < numLeafBalls; ++i) {
                final double slength = (rand.nextDouble() * 0.6 + 0.2) * this.length;
                final int[] bdst = TFGenerator.translate(this.src[0], this.src[1], this.src[2], slength, this.angle, this.tilt);
                final ComponentTFLeafSphere leafBlob = new ComponentTFLeafSphere(index + 1, bdst[0], bdst[1], bdst[2], 2);
                list.add(leafBlob);
                leafBlob.a((agq)this, list, rand);
            }
            final ComponentTFLeafSphere leafBlob2 = new ComponentTFLeafSphere(index + 1, this.dest[0], this.dest[1], this.dest[2], 2);
            list.add(leafBlob2);
            leafBlob2.a((agq)this, list, rand);
        }
        final int numShoots = Math.min(rand.nextInt(3) + 1, (int)(this.length / 5.0));
        final double angleInc = 0.8 / numShoots;
        for (int j = 0; j < numShoots; ++j) {
            final double angleVar = angleInc * j - 0.4;
            final double outVar = rand.nextDouble() * 0.8 + 0.2;
            final double tiltVar = rand.nextDouble() * 0.75 + 0.15;
            final int[] bsrc = TFGenerator.translate(this.src[0], this.src[1], this.src[2], this.length * outVar, this.angle, this.tilt);
            final double slength2 = this.length * 0.4;
            this.makeSmallBranch(list, rand, index + 1, bsrc[0], bsrc[1], bsrc[2], slength2, this.angle + angleVar, this.tilt * tiltVar, this.leafy);
        }
    }
    
    public void makeSmallBranch(final List list, final Random rand, final int index, final int x, final int y, final int z, final double branchLength, final double branchRotation, final double branchAngle, final boolean leafy) {
        final ComponentTFHollowTreeSmallBranch branch = new ComponentTFHollowTreeSmallBranch(index, x, y, z, branchLength, branchRotation, branchAngle, leafy);
        list.add(branch);
        branch.a(this, list, rand);
    }
    
    public boolean a(final zv world, final Random random, final aee sbb) {
        final int[] rSrc = { this.src[0] - this.e.a, this.src[1] - this.e.b, this.src[2] - this.e.c };
        final int[] rDest = { this.dest[0] - this.e.a, this.dest[1] - this.e.b, this.dest[2] - this.e.c };
        this.drawBresehnam(world, sbb, rSrc[0], rSrc[1], rSrc[2], rDest[0], rDest[1], rDest[2], TFBlocks.log.cz, 0);
        return true;
    }
    
    protected void drawBresehnam(final zv world, final aee sbb, final int x1, final int y1, final int z1, final int x2, final int y2, final int z2, final int blockValue, final int metaValue) {
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
                this.a(world, blockValue, metaValue, pixel[0], pixel[1], pixel[2], sbb);
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
                this.a(world, blockValue, metaValue, pixel[0], pixel[1], pixel[2], sbb);
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
                this.a(world, blockValue, metaValue, pixel[0], pixel[1], pixel[2], sbb);
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
        this.a(world, blockValue, metaValue, pixel[0], pixel[1], pixel[2], sbb);
    }
}
