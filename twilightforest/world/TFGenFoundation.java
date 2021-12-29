// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.TFTreasure;
import java.util.Random;

public class TFGenFoundation extends TFGenerator
{
    @Override
    public boolean a(final abv world, final Random rand, final int x, final int y, final int z) {
        final int sx = 5 + rand.nextInt(5);
        final int sz = 5 + rand.nextInt(5);
        if (!this.isAreaClear(world, rand, x, y, z, sx, 4, sz)) {
            return false;
        }
        for (int cx = 0; cx <= sx; ++cx) {
            for (int cz = 0; cz <= sz; ++cz) {
                if (cx == 0 || cx == sx || cz == 0 || cz == sz) {
                    for (int ht = rand.nextInt(4) + 1, cy = 0; cy <= ht; ++cy) {
                        this.putBlock(world, x + cx, y + cy - 1, z + cz, this.randStone(rand, cy + 1), true);
                    }
                }
                else if (rand.nextInt(3) != 0) {
                    this.putBlock(world, x + cx, y - 1, z + cz, (byte)aqw.C.cF, true);
                }
            }
        }
        if (rand.nextInt(2) == 0) {
            for (int cx = 1; cx < sx; ++cx) {
                for (int cz = 1; cz < sz; ++cz) {
                    this.putBlock(world, x + cx, y - 3, z + cz, 0, true);
                    this.putBlock(world, x + cx, y - 4, z + cz, 0, true);
                }
            }
            int cx = rand.nextInt(sx - 1) + 1;
            int cz = rand.nextInt(sz - 1) + 1;
            TFTreasure.basement.generate(world, rand, x + cx, y - 4, z + cz);
        }
        return true;
    }
}
