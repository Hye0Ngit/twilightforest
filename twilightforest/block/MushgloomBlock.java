// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraftforge.common.PlantType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MushgloomBlock extends TFPlantBlock
{
    private static final VoxelShape MUSHGLOOM_SHAPE;
    
    public MushgloomBlock(final BlockBehaviour.Properties props) {
        super(props);
    }
    
    @Override
    public boolean m_7898_(final BlockState state, final LevelReader world, final BlockPos pos) {
        return world.m_8055_(pos.m_7495_()).m_60783_((BlockGetter)world, pos, Direction.UP);
    }
    
    @Deprecated
    public VoxelShape m_5940_(final BlockState state, final BlockGetter access, final BlockPos pos, final CollisionContext context) {
        return MushgloomBlock.MUSHGLOOM_SHAPE;
    }
    
    @Override
    public PlantType getPlantType(final BlockGetter world, final BlockPos pos) {
        return PlantType.CAVE;
    }
    
    static {
        MUSHGLOOM_SHAPE = m_49796_(2.0, 0.0, 2.0, 14.0, 8.0, 14.0);
    }
}
