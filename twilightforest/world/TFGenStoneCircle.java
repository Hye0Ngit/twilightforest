// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import java.util.Random;

public class TFGenStoneCircle extends TFGenerator
{
    @Override
    public boolean a(final zv world, final Random rand, final int x, final int y, final int z) {
        for (int cx = -3; cx <= 3; ++cx) {
            for (int cz = -3; cz <= 3; ++cz) {
                for (int cy = 0; cy <= 4; ++cy) {
                    if (!world.g(x + cx, y - 1, z + cz).a()) {
                        return false;
                    }
                    if (!world.c(x + cx, y + cy, z + cz)) {
                        return false;
                    }
                }
            }
        }
        for (int cy2 = 0; cy2 <= 2; ++cy2) {
            this.putBlock(world, x - 3, y + cy2, z, aou.as.cz, true);
            this.putBlock(world, x + 3, y + cy2, z, aou.as.cz, true);
            this.putBlock(world, x, y + cy2, z - 3, aou.as.cz, true);
            this.putBlock(world, x, y + cy2, z + 3, aou.as.cz, true);
            this.putBlock(world, x - 2, y + cy2, z - 2, aou.as.cz, true);
            this.putBlock(world, x + 2, y + cy2, z - 2, aou.as.cz, true);
            this.putBlock(world, x - 2, y + cy2, z + 2, aou.as.cz, true);
            this.putBlock(world, x + 2, y + cy2, z + 2, aou.as.cz, true);
        }
        return true;
    }
}
