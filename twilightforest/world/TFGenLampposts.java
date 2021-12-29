// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.block.TFBlocks;
import net.minecraft.world.IBlockAccess;
import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.world.World;

public class TFGenLampposts extends TFGenerator
{
    private static final int MAX_HANG = 8;
    
    public boolean func_76484_a(final World world, final Random rand, final int x, final int y, final int z) {
        if (world.func_147439_a(x, y - 1, z) == Blocks.field_150349_c) {
            final int height = 1 + rand.nextInt(4);
            boolean clear = true;
            for (int dy = 0; dy < height; ++dy) {
                if (!world.func_147437_c(x, y + dy, z) && !world.func_147439_a(x, y + dy, z).isReplaceable((IBlockAccess)world, x, y + dy, z)) {
                    clear = false;
                }
            }
            if (clear) {
                for (int dy = 0; dy < height; ++dy) {
                    world.func_147449_b(x, y + dy, z, Blocks.field_150422_aJ);
                    world.func_147449_b(x, y + height, z, TFBlocks.fireflyJar);
                }
            }
            return clear;
        }
        return false;
    }
}
