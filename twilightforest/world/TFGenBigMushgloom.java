// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.block.Block;
import twilightforest.block.TFBlocks;
import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.world.World;

public class TFGenBigMushgloom extends TFGenerator
{
    public boolean func_76484_a(final World world, final Random rand, final int x, final int y, final int z) {
        final int height = 3 + rand.nextInt(2) + rand.nextInt(2);
        if (!this.isAreaSuitable(world, rand, x - 1, y, z - 1, 3, height, 3)) {
            return false;
        }
        final Block blockUnder = world.func_147439_a(x, y - 1, z);
        if (blockUnder != Blocks.field_150346_d && blockUnder != Blocks.field_150349_c && blockUnder != Blocks.field_150391_bh) {
            return false;
        }
        for (int dy = 0; dy < height - 2; ++dy) {
            this.func_150516_a(world, x, y + dy, z, TFBlocks.hugeGloomBlock, 10);
        }
        this.makeMushroomCap(world, x, z, y + (height - 2));
        if (rand.nextBoolean()) {
            this.makeMushroomCap(world, x, z, y + (height - 1));
        }
        return true;
    }
    
    private void makeMushroomCap(final World world, final int x, final int z, final int dy) {
        this.func_150516_a(world, x - 1, dy, z - 1, TFBlocks.hugeGloomBlock, 1);
        this.func_150516_a(world, x + 0, dy, z - 1, TFBlocks.hugeGloomBlock, 2);
        this.func_150516_a(world, x + 1, dy, z - 1, TFBlocks.hugeGloomBlock, 3);
        this.func_150516_a(world, x - 1, dy, z + 0, TFBlocks.hugeGloomBlock, 4);
        this.func_150516_a(world, x + 0, dy, z + 0, TFBlocks.hugeGloomBlock, 5);
        this.func_150516_a(world, x + 1, dy, z + 0, TFBlocks.hugeGloomBlock, 6);
        this.func_150516_a(world, x - 1, dy, z + 1, TFBlocks.hugeGloomBlock, 7);
        this.func_150516_a(world, x + 0, dy, z + 1, TFBlocks.hugeGloomBlock, 8);
        this.func_150516_a(world, x + 1, dy, z + 1, TFBlocks.hugeGloomBlock, 9);
    }
}
