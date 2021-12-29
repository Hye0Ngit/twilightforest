// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import java.util.Random;

public class TFGenCaveStalactite extends TFGenerator
{
    public double size;
    public int bType;
    public boolean hang;
    public int dir;
    
    public TFGenCaveStalactite(final int blockType, final double sizeFactor, final boolean down) {
        this.bType = blockType;
        this.size = sizeFactor;
        this.hang = down;
        this.dir = (this.hang ? -1 : 1);
    }
    
    public static TFGenCaveStalactite makeRandomOreStalactite(final Random rand, final int hillSize) {
        if (hillSize >= 3 || (hillSize >= 2 && rand.nextInt(5) == 0)) {
            final int s3 = rand.nextInt(13);
            if (s3 == 0 || s3 == 1) {
                return new TFGenCaveStalactite(aou.aA.cz, rand.nextDouble() * 0.5, true);
            }
            if (s3 == 2 || s3 == 3) {
                return new TFGenCaveStalactite(aou.R.cz, rand.nextDouble() * 0.8, true);
            }
            if (s3 == 4) {
                return new TFGenCaveStalactite(aou.bV.cz, rand.nextDouble() * 0.5, true);
            }
        }
        if (hillSize >= 2 || (hillSize >= 1 && rand.nextInt(5) == 0)) {
            final int s4 = rand.nextInt(6);
            if (s4 == 0) {
                return new TFGenCaveStalactite(aou.K.cz, rand.nextDouble() * 0.6, true);
            }
            if (s4 == 1 || s4 == 2) {
                return new TFGenCaveStalactite(aou.aR.cz, rand.nextDouble() * 0.8, true);
            }
        }
        final int s5 = rand.nextInt(5);
        if (s5 == 0 || s5 == 1) {
            return new TFGenCaveStalactite(aou.L.cz, rand.nextDouble() * 0.7, true);
        }
        if (s5 == 2 || s5 == 3) {
            return new TFGenCaveStalactite(aou.M.cz, rand.nextDouble() * 0.8, true);
        }
        return new TFGenCaveStalactite(aou.bh.cz, rand.nextDouble() * 0.5, true);
    }
    
    @Override
    public boolean a(final zv world, final Random random, final int x, final int y, final int z) {
        int ceiling = Integer.MAX_VALUE;
        int floor = -1;
        int ty = y;
        while (ty < TFWorld.WORLDHEIGHT) {
            final ahz m = world.g(x, ty, z);
            if (m == ahz.a) {
                ++ty;
            }
            else {
                if (m != ahz.c && m != ahz.e) {
                    return false;
                }
                ceiling = ty;
                break;
            }
        }
        if (ceiling == Integer.MAX_VALUE) {
            return false;
        }
        ty = y;
        while (ty > 4) {
            final ahz m = world.g(x, ty, z);
            if (m == ahz.a) {
                --ty;
            }
            else {
                if (m != ahz.c && m != ahz.e && !this.hang && m != ahz.h && !this.hang && m != ahz.i) {
                    return false;
                }
                floor = ty;
                break;
            }
        }
        int length = (int)((ceiling - floor) * this.size);
        if (this.bType == aou.aA.cz && length > 4) {
            length = 4;
        }
        if (this.bType == aou.bV.cz && length > 3) {
            length = 3;
        }
        if (this.bType == aou.K.cz && length > 6) {
            length = 6;
        }
        if (length > 8 && (this.bType == aou.R.cz || this.bType == aou.aR.cz || this.bType == aou.L.cz || this.bType == aou.bh.cz)) {
            length = 8;
        }
        if (this.bType == aou.bh.cz) {
            world.d(x, z).n();
        }
        return this.makeSpike(world, random, x, this.hang ? ceiling : floor, z, length);
    }
    
    public boolean makeSpike(final zv world, final Random random, final int x, final int y, final int z, final int maxLength) {
        for (int diameter = (int)(maxLength / 4.5), dx = -diameter; dx <= diameter; ++dx) {
            for (int dz = -diameter; dz <= diameter; ++dz) {
                final int absx = Math.abs(dx);
                final int absz = Math.abs(dz);
                final int dist = (int)(Math.max(absx, absz) + Math.min(absx, absz) * 0.5);
                int spikeLength = 0;
                if (dist == 0) {
                    spikeLength = maxLength;
                }
                if (dist > 0) {
                    spikeLength = random.nextInt((int)(maxLength / (dist + 0.25)));
                }
                if (!world.g(x + dx, y - this.dir, z + dz).a()) {
                    spikeLength = 0;
                }
                for (int dy = 0; dy != spikeLength * this.dir; dy += this.dir) {
                    this.putBlock(world, x + dx, y + dy, z + dz, this.bType, false);
                }
            }
        }
        return true;
    }
}
