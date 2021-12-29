import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFGenMonolith extends TFGenerator
{
    @Override
    public boolean a(final fq world, final Random rand, final int x, final int y, final int z) {
        this.worldObj = world;
        final int ht = rand.nextInt(10) + 10;
        final int dir = rand.nextInt(4);
        if (!this.isAreaClear(world, rand, x, y, z, 2, ht, 2)) {
            return false;
        }
        int h0 = 0;
        int h2 = 0;
        int h3 = 0;
        int h4 = 0;
        switch (dir) {
            case 0: {
                h0 = ht;
                h2 = (int)(ht * 0.75);
                h3 = (int)(ht * 0.75);
                h4 = (int)(ht * 0.5);
                break;
            }
            case 1: {
                h0 = (int)(ht * 0.5);
                h2 = ht;
                h3 = (int)(ht * 0.75);
                h4 = (int)(ht * 0.75);
                break;
            }
            case 2: {
                h0 = (int)(ht * 0.75);
                h2 = (int)(ht * 0.5);
                h3 = ht;
                h4 = (int)(ht * 0.75);
                break;
            }
            default: {
                h0 = (int)(ht * 0.75);
                h2 = (int)(ht * 0.75);
                h3 = (int)(ht * 0.5);
                h4 = ht;
                break;
            }
        }
        for (int cy = 0; cy <= h0; ++cy) {
            this.putBlock(x + 0, y + cy - 1, z + 0, (cy == ht) ? ((byte)ud.Q.bO) : ((byte)ud.ar.bO), true);
        }
        for (int cy = 0; cy <= h2; ++cy) {
            this.putBlock(x + 1, y + cy - 1, z + 0, (cy == ht) ? ((byte)ud.Q.bO) : ((byte)ud.ar.bO), true);
        }
        for (int cy = 0; cy <= h3; ++cy) {
            this.putBlock(x + 0, y + cy - 1, z + 1, (cy == ht) ? ((byte)ud.Q.bO) : ((byte)ud.ar.bO), true);
        }
        for (int cy = 0; cy <= h4; ++cy) {
            this.putBlock(x + 1, y + cy - 1, z + 1, (cy == ht) ? ((byte)ud.Q.bO) : ((byte)ud.ar.bO), true);
        }
        return true;
    }
}
