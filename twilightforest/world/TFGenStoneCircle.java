// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.world.World;

public class TFGenStoneCircle extends TFGenerator
{
    public boolean func_76484_a(final World world, final Random rand, final int x, final int y, final int z) {
        if (!this.isAreaSuitable(world, rand, x - 3, y, z - 3, 6, 4, 6)) {
            return false;
        }
        for (int cy = 0; cy <= 2; ++cy) {
            this.setBlock(world, x - 3, y + cy, z, Blocks.field_150341_Y);
            this.setBlock(world, x + 3, y + cy, z, Blocks.field_150341_Y);
            this.setBlock(world, x, y + cy, z - 3, Blocks.field_150341_Y);
            this.setBlock(world, x, y + cy, z + 3, Blocks.field_150341_Y);
            this.setBlock(world, x - 2, y + cy, z - 2, Blocks.field_150341_Y);
            this.setBlock(world, x + 2, y + cy, z - 2, Blocks.field_150341_Y);
            this.setBlock(world, x - 2, y + cy, z + 2, Blocks.field_150341_Y);
            this.setBlock(world, x + 2, y + cy, z + 2, Blocks.field_150341_Y);
        }
        return true;
    }
}
