// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.level.block.Block;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class UnripeTorchClusterBlock extends TrollRootBlock
{
    private static final int RIPEN_THRESHHOLD = 6;
    
    protected UnripeTorchClusterBlock(final BlockBehaviour.Properties props) {
        super(props);
    }
    
    @Deprecated
    public void m_7455_(final BlockState state, final ServerLevel world, final BlockPos pos, final Random rand) {
        if (world.m_46803_(pos) >= 6) {
            world.m_46597_(pos, ((Block)TFBlocks.TROLLBER.get()).m_49966_());
        }
    }
}
