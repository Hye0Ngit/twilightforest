// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FiddleheadBlock extends TFPlantBlock
{
    private static final VoxelShape FIDDLEHEAD_SHAPE;
    
    public FiddleheadBlock(final BlockBehaviour.Properties props) {
        super(props);
    }
    
    public VoxelShape m_5940_(final BlockState state, final BlockGetter access, final BlockPos pos, final CollisionContext context) {
        return FiddleheadBlock.FIDDLEHEAD_SHAPE;
    }
    
    static {
        FIDDLEHEAD_SHAPE = m_49796_(3.0, 0.0, 3.0, 13.0, 14.0, 13.0);
    }
}
