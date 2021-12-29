// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockTFUnripeTorchCluster extends BlockTFTrollRoot
{
    private static final int RIPEN_THRESHHOLD = 6;
    
    @Override
    public void func_180650_b(final World world, final BlockPos pos, final IBlockState state, final Random rand) {
        super.func_180650_b(world, pos, state, rand);
        if (world.func_175699_k(pos) >= 6) {
            world.func_175656_a(pos, TFBlocks.trollber.func_176223_P());
        }
    }
}
