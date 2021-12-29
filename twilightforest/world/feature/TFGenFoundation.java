// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import twilightforest.loot.TFTreasure;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;

public class TFGenFoundation extends TFGenerator
{
    public boolean func_180709_b(final World world, final Random rand, final BlockPos pos) {
        final int sx = 5 + rand.nextInt(5);
        final int sz = 5 + rand.nextInt(5);
        if (!TFGenerator.isAreaSuitable(world, rand, pos, sx, 4, sz)) {
            return false;
        }
        for (int cx = 0; cx <= sx; ++cx) {
            for (int cz = 0; cz <= sz; ++cz) {
                if (cx == 0 || cx == sx || cz == 0 || cz == sz) {
                    for (int ht = rand.nextInt(4) + 1, cy = 0; cy <= ht; ++cy) {
                        this.func_175903_a(world, pos.func_177982_a(cx, cy - 1, cz), TFGenerator.randStone(rand, cy + 1));
                    }
                }
                else if (rand.nextInt(3) != 0) {
                    this.func_175903_a(world, pos.func_177982_a(cx, -1, cz), Blocks.field_150344_f.func_176223_P());
                }
            }
        }
        if (rand.nextInt(2) == 0) {
            for (int cx = 1; cx < sx; ++cx) {
                for (int cz = 1; cz < sz; ++cz) {
                    this.func_175903_a(world, pos.func_177982_a(cx, -3, cz), Blocks.field_150350_a.func_176223_P());
                    this.func_175903_a(world, pos.func_177982_a(cx, -4, cz), Blocks.field_150350_a.func_176223_P());
                }
            }
            int cx = rand.nextInt(sx - 1) + 1;
            int cz = rand.nextInt(sz - 1) + 1;
            TFTreasure.basement.generateChest(world, pos.func_177982_a(cx, -4, cz), false);
        }
        return true;
    }
}
