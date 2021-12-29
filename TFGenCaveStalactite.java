import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

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
    
    public static TFGenCaveStalactite makeRandomOreStalactite(final Random rand, final int caveSize) {
        if (caveSize >= 3) {
            final int s3 = rand.nextInt(6);
            if (s3 == 0) {
                return new TFGenCaveStalactite(yy.aw.bM, rand.nextDouble() * 0.5, true);
            }
            if (s3 == 1) {
                return new TFGenCaveStalactite(yy.N.bM, rand.nextDouble() * 0.8, true);
            }
        }
        if (caveSize >= 2) {
            final int s4 = rand.nextInt(6);
            if (s4 == 0) {
                return new TFGenCaveStalactite(yy.G.bM, rand.nextDouble() * 0.6, true);
            }
            if (s4 == 1 || s4 == 2) {
                return new TFGenCaveStalactite(yy.aN.bM, rand.nextDouble() * 0.8, true);
            }
        }
        final int s5 = rand.nextInt(5);
        if (s5 == 0 || s5 == 1) {
            return new TFGenCaveStalactite(yy.H.bM, rand.nextDouble() * 0.7, true);
        }
        if (s5 == 2 || s5 == 3) {
            return new TFGenCaveStalactite(yy.I.bM, rand.nextDouble() * 0.8, true);
        }
        return new TFGenCaveStalactite(yy.bd.bM, rand.nextDouble() * 0.5, true);
    }
    
    @Override
    public boolean a(final ry world, final Random random, final int x, final int y, final int z) {
        this.worldObj = world;
        int ceiling = 129;
        int floor = -1;
        int ty = y;
        while (ty < 128) {
            final p m = this.worldObj.e(x, ty, z);
            if (m == p.a) {
                ++ty;
            }
            else {
                if (m != p.c && m != p.e) {
                    return false;
                }
                ceiling = ty;
                break;
            }
        }
        if (ceiling == 129) {
            return false;
        }
        ty = y;
        while (ty > 4) {
            final p m = this.worldObj.e(x, ty, z);
            if (m == p.a) {
                --ty;
            }
            else {
                if (m != p.c && m != p.e && !this.hang && m != p.g && !this.hang && m != p.h) {
                    return false;
                }
                floor = ty;
                break;
            }
        }
        int length = (int)((ceiling - floor) * this.size);
        if (this.bType == yy.aw.bM && length > 4) {
            length = 4;
        }
        if (this.bType == yy.G.bM && length > 6) {
            length = 6;
        }
        return this.makeSpike(random, x, this.hang ? ceiling : floor, z, length);
    }
    
    public boolean makeSpike(final Random random, final int x, final int y, final int z, final int length) {
        for (int dw = (int)(length / 4.5), dx = -dw; dx <= dw; ++dx) {
            for (int dz = -dw; dz <= dw; ++dz) {
                final int ax = Math.abs(dx);
                final int az = Math.abs(dz);
                final int dist = (int)(Math.max(ax, az) + Math.min(ax, az) * 0.5);
                int dl = 0;
                if (dist == 0) {
                    dl = length;
                }
                if (dist > 0) {
                    dl = random.nextInt((int)(length / (dist + 0.25)));
                }
                for (int dy = 0; dy != dl * this.dir; dy += this.dir) {
                    this.putBlock(x + dx, y + dy, z + dz, this.bType, false);
                }
            }
        }
        return true;
    }
    
    public boolean generateOld(final ry world, final Random random, final int i, final int j, final int k) {
        this.worldObj = world;
        if (!world.h(i, j, k)) {
            return false;
        }
        if (world.a(i, j + 1, k) != yy.t.bM && world.a(i, j + 1, k) != yy.v.bM) {
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
