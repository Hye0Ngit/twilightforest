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

public class MayappleBlock extends TFPlantBlock
{
    private static final VoxelShape MAYAPPLE_SHAPE;
    
    public MayappleBlock(final BlockBehaviour.Properties props) {
        super(props);
    }
    
    public VoxelShape m_5940_(final BlockState state, final BlockGetter access, final BlockPos pos, final CollisionContext context) {
        return MayappleBlock.MAYAPPLE_SHAPE;
    }
    
    static {
        MAYAPPLE_SHAPE = m_49796_(4.0, 0.0, 4.0, 13.0, 6.0, 13.0);
    }
}
