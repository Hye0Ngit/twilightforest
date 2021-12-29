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
import net.minecraft.world.level.block.WaterlilyBlock;

public class HugeWaterLilyBlock extends WaterlilyBlock
{
    private static final VoxelShape AABB;
    
    protected HugeWaterLilyBlock(final BlockBehaviour.Properties props) {
        super(props);
    }
    
    public VoxelShape m_5940_(final BlockState state, final BlockGetter worldIn, final BlockPos pos, final CollisionContext context) {
        return HugeWaterLilyBlock.AABB;
    }
    
    static {
        AABB = m_49796_(1.6, 1.6, 1.6, 14.4, 14.4, 14.4);
    }
}
