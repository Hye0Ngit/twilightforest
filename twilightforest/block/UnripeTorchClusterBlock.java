// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.block.Block;
import java.util.Random;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;

public class UnripeTorchClusterBlock extends TrollRootBlock
{
    private static final int RIPEN_THRESHHOLD = 6;
    
    protected UnripeTorchClusterBlock(final AbstractBlock.Properties props) {
        super(props);
    }
    
    @Deprecated
    public void func_225542_b_(final BlockState state, final ServerWorld world, final BlockPos pos, final Random rand) {
        if (world.func_201696_r(pos) >= 6) {
            world.func_175656_a(pos, ((Block)TFBlocks.trollber.get()).func_176223_P());
        }
    }
}
