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
    public boolean a(final xv world, final Random rand, final int x, final int y, final int z) {
        for (int var6 = 0; var6 < 4; ++var6) {
            final int dx = x + rand.nextInt(8) - rand.nextInt(8);
            final int dy = y + rand.nextInt(4) - rand.nextInt(4);
            final int dz = z + rand.nextInt(8) - rand.nextInt(8);
            if (world.c(dx, dy, dz) && world.k(dx, dy, dz) && world.g(dx, dy - 1, dz) == agb.b && world.g(dx + 1, dy - 1, dz) == agb.b && world.g(dx - 1, dy - 1, dz) == agb.b && world.g(dx, dy - 1, dz + 1) == agb.b && world.g(dx, dy - 1, dz - 1) == agb.b) {
                world.c(dx, dy - 1, dz, this.plantBlockId, this.plantBlockMeta);
                for (int rx = -2; rx <= 2; ++rx) {
                    for (int rz = -2; rz <= 2; ++rz) {
                        if ((rx == 1 || rx == 0 || rx == -1) && (rz == 1 || rz == 0 || rz == -1)) {
                            world.b(dx + rx, dy - 2, dz + rz, amj.F.cm);
                        }
                        else if (world.g(dx + rx, dy - 2, dz + rz) != agb.i) {
                            world.b(dx + rx, dy - 2, dz + rz, amj.w.cm);
                        }
                        world.b(dx + rx, dy - 3, dz + rz, amj.w.cm);
                    }
                }
            }
        }
        return true;
    }
}
