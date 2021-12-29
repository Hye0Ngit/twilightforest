// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.block.Block;

public class ThornRoseBlock extends Block
{
    private static final float RADIUS = 0.4f;
    private static final VoxelShape AABB;
    
    protected ThornRoseBlock(final BlockBehaviour.Properties props) {
        super(props);
    }
    
    @Deprecated
    public VoxelShape m_5940_(final BlockState state, final BlockGetter worldIn, final BlockPos pos, final CollisionContext context) {
        return ThornRoseBlock.AABB;
    }
    
    static {
        AABB = Shapes.m_83064_(new AABB(0.09999999403953552, 0.09999999403953552, 0.09999999403953552, 0.8999999761581421, 0.8999999761581421, 0.8999999761581421));
    }
}
