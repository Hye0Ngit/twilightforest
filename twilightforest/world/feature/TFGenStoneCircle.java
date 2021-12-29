// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;

public class TFGenStoneCircle extends TFGenerator
{
    public boolean func_180709_b(final World world, final Random rand, final BlockPos pos) {
        if (!TFGenerator.isAreaSuitable(world, rand, pos.func_177982_a(-3, 0, -3), 6, 4, 6)) {
            return false;
        }
        final IBlockState mossyCobble = Blocks.field_150341_Y.func_176223_P();
        for (int cy = 0; cy <= 2; ++cy) {
            this.func_175903_a(world, pos.func_177982_a(-3, cy, 0), mossyCobble);
            this.func_175903_a(world, pos.func_177982_a(3, cy, 0), mossyCobble);
            this.func_175903_a(world, pos.func_177982_a(0, cy, -3), mossyCobble);
            this.func_175903_a(world, pos.func_177982_a(0, cy, 3), mossyCobble);
            this.func_175903_a(world, pos.func_177982_a(-2, cy, -2), mossyCobble);
            this.func_175903_a(world, pos.func_177982_a(2, cy, -2), mossyCobble);
            this.func_175903_a(world, pos.func_177982_a(-2, cy, 2), mossyCobble);
            this.func_175903_a(world, pos.func_177982_a(2, cy, 2), mossyCobble);
        }
        return true;
    }
}
