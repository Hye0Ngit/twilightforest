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
                return new TFGenCaveStalactite(amq.az.cm, rand.nextDouble() * 0.5, true);
            }
            if (s3 == 2 || s3 == 3) {
                return new TFGenCaveStalactite(amq.Q.cm, rand.nextDouble() * 0.8, true);
            }
            if (s3 == 4) {
                return new TFGenCaveStalactite(amq.bU.cm, rand.nextDouble() * 0.5, true);
            }
        }
        if (hillSize >= 2 || (hillSize >= 1 && rand.nextInt(5) == 0)) {
            final int s4 = rand.nextInt(6);
            if (s4 == 0) {
                return new TFGenCaveStalactite(amq.J.cm, rand.nextDouble() * 0.6, true);
            }
            if (s4 == 1 || s4 == 2) {
                return new TFGenCaveStalactite(amq.aQ.cm, rand.nextDouble() * 0.8, true);
            }
        }
        final int s5 = rand.nextInt(5);
        if (s5 == 0 || s5 == 1) {
            return new TFGenCaveStalactite(amq.K.cm, rand.nextDouble() * 0.7, true);
        }
        if (s5 == 2 || s5 == 3) {
            return new TFGenCaveStalactite(amq.L.cm, rand.nextDouble() * 0.8, true);
        }
        return new TFGenCaveStalactite(amq.bg.cm, rand.nextDouble() * 0.5, true);
    }
    
    @Override
    public boolean a(final yc world, final Random random, final int x, final int y, final int z) {
        this.worldObj = world;
        int ceiling = Integer.MAX_VALUE;
        int floor = -1;
        int ty = y;
        while (ty < TFWorld.WORLDHEIGHT) {
            final agi m = this.worldObj.g(x, ty, z);
            if (m == agi.a) {
                ++ty;
            }
            else {
                if (m != agi.c && m != agi.e) {
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
            final agi m = this.worldObj.g(x, ty, z);
            if (m == agi.a) {
                --ty;
            }
            else {
                if (m != agi.c && m != agi.e && !this.hang && m != agi.h && !this.hang && m != agi.i) {
                    return false;
                }
                floor = ty;
                break;
            }
        }
        int length = (int)((ceiling - floor) * this.size);
        if (this.bType == amq.az.cm && length > 4) {
            length = 4;
        }
        if (this.bType == amq.bU.cm && length > 3) {
            length = 3;
        }
        if (this.bType == amq.J.cm && length > 6) {
            length = 6;
        }
        if (length > 8 && (this.bType == amq.Q.cm || this.bType == amq.aQ.cm || this.bType == amq.K.cm || this.bType == amq.bg.cm)) {
            length = 8;
        }
        if (this.bType == amq.bg.cm) {
            world.d(x, z).n();
        }
        return this.makeSpike(random, x, this.hang ? ceiling : floor, z, length);
    }
    
    public boolean makeSpike(final Random random, final int x, final int y, final int z, final int maxLength) {
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
                if (!this.worldObj.g(x + dx, y - this.dir, z + dz).a()) {
                    spikeLength = 0;
                }
                for (int dy = 0; dy != spikeLength * this.dir; dy += this.dir) {
                    this.putBlock(x + dx, y + dy, z + dz, this.bType, false);
                }
            }
        }
        return true;
    }
    
    public boolean generateOld(final yc world, final Random random, final int i, final int j, final int k) {
        this.worldObj = world;
        if (!world.c(i, j, k)) {
            return false;
        }
        if (world.a(i, j + 1, k) != amq.w.cm && world.a(i, j + 1, k) != amq.y.cm) {
            return false;
        }
        this.drawDiameterCircle(i, j + 1, k, 3, (byte)this.bType, 0, false);
        this.drawDiameterCircle(i, j, k, 3, (byte)this.bType, 0, false);
        this.drawDiameterCircle(i, j - 1, k, 3, (byte)this.bType, 0, false);
        this.drawDiameterCircle(i, j - 2, k, 2, (byte)this.bType, 0, false);
        this.drawDiameterCircle(i, j - 3, k, 2, (byte)this.bType, 0, false);
        this.drawDiameterCircle(i, j - 4, k, 2, (byte)this.bType, 0, false);
        this.drawDiameterCircle(i, j - 5, k, 1, (byte)this.bType, 0, false);
        this.drawDiameterCircle(i, j - 6, k, 1, (byte)this.bType, 0, false);
        this.drawDiameterCircle(i, j - 7, k, 1, (byte)this.bType, 0, false);
        return true;
    }
}
