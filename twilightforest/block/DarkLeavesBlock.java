// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class DarkLeavesBlock extends TFLeavesBlock
{
    protected DarkLeavesBlock(final BlockBehaviour.Properties props) {
        super(props);
    }
    
    @Override
    public int getFlammability(final BlockState state, final BlockGetter world, final BlockPos pos, final Direction face) {
        return 1;
    }
    
    @Override
    public int getFireSpreadSpeed(final BlockState state, final BlockGetter world, final BlockPos pos, final Direction face) {
        return 0;
    }
    
    public VoxelShape m_7947_(final BlockState pState, final BlockGetter pReader, final BlockPos pPos) {
        return Shapes.m_83144_();
    }
    
    public int m_7753_(final BlockState pState, final BlockGetter pLevel, final BlockPos pPos) {
        return 15;
    }
}
