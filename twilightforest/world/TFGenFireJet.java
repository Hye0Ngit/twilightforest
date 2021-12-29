// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import java.util.Random;

public class TFGenFireJet extends TFGenerator
{
    private int plantBlockId;
    private int plantBlockMeta;
    
    public TFGenFireJet(final int id, final int meta) {
        this.plantBlockId = id;
        this.plantBlockMeta = meta;
    }
    
    @Override
    public boolean a(final zv world, final Random rand, final int x, final int y, final int z) {
        for (int var6 = 0; var6 < 4; ++var6) {
            final int dx = x + rand.nextInt(8) - rand.nextInt(8);
            final int dy = y + rand.nextInt(4) - rand.nextInt(4);
            final int dz = z + rand.nextInt(8) - rand.nextInt(8);
            if (world.c(dx, dy, dz) && world.l(dx, dy, dz) && world.g(dx, dy - 1, dz) == ahz.b && world.g(dx + 1, dy - 1, dz) == ahz.b && world.g(dx - 1, dy - 1, dz) == ahz.b && world.g(dx, dy - 1, dz + 1) == ahz.b && world.g(dx, dy - 1, dz - 1) == ahz.b) {
                world.f(dx, dy - 1, dz, this.plantBlockId, this.plantBlockMeta, 0);
                for (int rx = -2; rx <= 2; ++rx) {
                    for (int rz = -2; rz <= 2; ++rz) {
                        if ((rx == 1 || rx == 0 || rx == -1) && (rz == 1 || rz == 0 || rz == -1)) {
                            world.f(dx + rx, dy - 2, dz + rz, aou.G.cz, 0, 0);
                        }
                        else if (world.g(dx + rx, dy - 2, dz + rz) != ahz.i) {
                            world.f(dx + rx, dy - 2, dz + rz, aou.x.cz, 0, 0);
                        }
                        world.f(dx + rx, dy - 3, dz + rz, aou.x.cz, 0, 0);
                    }
                }
            }
        }
        return true;
    }
}
