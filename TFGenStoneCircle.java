import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFGenStoneCircle extends TFGenerator
{
    @Override
    public boolean a(final fq world, final Random rand, final int x, final int y, final int z) {
        this.worldObj = world;
        for (int cx = -3; cx <= 3; ++cx) {
            for (int cz = -3; cz <= 3; ++cz) {
                for (int cy = 0; cy <= 4; ++cy) {
                    if (!world.d(x + cx, y - 1, z + cz).a()) {
                        return false;
                    }
                    if (!world.f(x + cx, y + cy, z + cz)) {
                        return false;
                    }
                }
            }
        }
        for (int cy2 = 0; cy2 <= 2; ++cy2) {
            this.putBlock(x - 3, y + cy2, z, ud.aq.bO, true);
            this.putBlock(x + 3, y + cy2, z, ud.aq.bO, true);
            this.putBlock(x, y + cy2, z - 3, ud.aq.bO, true);
            this.putBlock(x, y + cy2, z + 3, ud.aq.bO, true);
            this.putBlock(x - 2, y + cy2, z - 2, ud.aq.bO, true);
            this.putBlock(x + 2, y + cy2, z - 2, ud.aq.bO, true);
            this.putBlock(x - 2, y + cy2, z + 2, ud.aq.bO, true);
            this.putBlock(x + 2, y + cy2, z + 2, ud.aq.bO, true);
        }
        return true;
    }
}
