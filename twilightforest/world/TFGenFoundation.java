// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.TFTreasure;
import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.world.World;

public class TFGenFoundation extends TFGenerator
{
    public boolean func_76484_a(final World world, final Random rand, final int x, final int y, final int z) {
        final int sx = 5 + rand.nextInt(5);
        final int sz = 5 + rand.nextInt(5);
        if (!this.isAreaSuitable(world, rand, x, y, z, sx, 4, sz)) {
            return false;
        }
        for (int cx = 0; cx <= sx; ++cx) {
            for (int cz = 0; cz <= sz; ++cz) {
                if (cx == 0 || cx == sx || cz == 0 || cz == sz) {
                    for (int ht = rand.nextInt(4) + 1, cy = 0; cy <= ht; ++cy) {
                        this.setBlock(world, x + cx, y + cy - 1, z + cz, this.randStone(rand, cy + 1));
                    }
                }
                else if (rand.nextInt(3) != 0) {
                    this.setBlock(world, x + cx, y - 1, z + cz, Blocks.field_150344_f);
                }
            }
        }
        if (rand.nextInt(2) == 0) {
            for (int cx = 1; cx < sx; ++cx) {
                for (int cz = 1; cz < sz; ++cz) {
                    this.setBlock(world, x + cx, y - 3, z + cz, Blocks.field_150350_a);
                    this.setBlock(world, x + cx, y - 4, z + cz, Blocks.field_150350_a);
                }
            }
            int cx = rand.nextInt(sx - 1) + 1;
            int cz = rand.nextInt(sz - 1) + 1;
            TFTreasure.basement.generate(world, rand, x + cx, y - 4, z + cz);
        }
        return true;
    }
}
