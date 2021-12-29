// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import java.util.Random;

public class TFGenStoneCircle extends TFGenerator
{
    @Override
    public boolean a(final abv world, final Random rand, final int x, final int y, final int z) {
        if (!this.isAreaClear(world, rand, x - 3, y, z - 3, 6, 4, 6)) {
            return false;
        }
        for (int cy = 0; cy <= 2; ++cy) {
            this.putBlock(world, x - 3, y + cy, z, aqw.at.cF, true);
            this.putBlock(world, x + 3, y + cy, z, aqw.at.cF, true);
            this.putBlock(world, x, y + cy, z - 3, aqw.at.cF, true);
            this.putBlock(world, x, y + cy, z + 3, aqw.at.cF, true);
            this.putBlock(world, x - 2, y + cy, z - 2, aqw.at.cF, true);
            this.putBlock(world, x + 2, y + cy, z - 2, aqw.at.cF, true);
            this.putBlock(world, x - 2, y + cy, z + 2, aqw.at.cF, true);
            this.putBlock(world, x + 2, y + cy, z + 2, aqw.at.cF, true);
        }
        return true;
    }
}
