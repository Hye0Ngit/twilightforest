// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import java.util.Random;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RootStrandBlock extends TFPlantBlock
{
    private static final VoxelShape ROOT_SHAPE;
    
    public RootStrandBlock(final BlockBehaviour.Properties props) {
        super(props);
    }
    
    @Override
    public boolean m_7898_(final BlockState state, final LevelReader world, final BlockPos pos) {
        return TFPlantBlock.canPlaceRootAt(world, pos);
    }
    
    @Deprecated
    public VoxelShape m_5940_(final BlockState state, final BlockGetter access, final BlockPos pos, final CollisionContext context) {
        return RootStrandBlock.ROOT_SHAPE;
    }
    
    @Override
    public boolean m_7370_(final BlockGetter level, final BlockPos pos, final BlockState state, final boolean isClient) {
        return this.isBottomOpen(level, pos);
    }
    
    @Override
    public boolean m_5491_(final Level level, final Random random, final BlockPos pos, final BlockState state) {
        return this.isBottomOpen((BlockGetter)level, pos);
    }
    
    private boolean isBottomOpen(final BlockGetter level, final BlockPos pos) {
        final BlockPos.MutableBlockPos mutable = pos.m_122032_();
        do {
            mutable.m_122173_(Direction.DOWN);
        } while (level.m_8055_((BlockPos)mutable).m_60713_((Block)this));
        return level.m_8055_((BlockPos)mutable).m_60795_() || level.m_8055_((BlockPos)mutable).m_60767_().m_76336_();
    }
    
    @Override
    public void m_7719_(final ServerLevel level, final Random random, final BlockPos pos, final BlockState state) {
        final BlockPos.MutableBlockPos mutable = pos.m_122032_();
        do {
            mutable.m_122173_(Direction.DOWN);
        } while (level.m_8055_((BlockPos)mutable).m_60713_((Block)this));
        if (level.m_8055_((BlockPos)mutable).m_60795_() || level.m_8055_((BlockPos)mutable).m_60767_().m_76336_()) {
            level.m_46597_((BlockPos)mutable, this.m_49966_());
        }
    }
    
    static {
        ROOT_SHAPE = m_49796_(2.0, 0.0, 2.0, 14.0, 16.0, 14.0);
    }
}
