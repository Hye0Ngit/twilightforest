// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.Util;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.AABB;
import java.util.Random;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.core.Direction;
import java.util.Map;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class PatchBlock extends TFPlantBlock
{
    public static final BooleanProperty NORTH;
    public static final BooleanProperty EAST;
    public static final BooleanProperty SOUTH;
    public static final BooleanProperty WEST;
    private static final Map<Direction, BooleanProperty> PROPERTY_BY_DIRECTION;
    
    public PatchBlock(final BlockBehaviour.Properties props) {
        super(props);
        this.m_49959_((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_((Property)PatchBlock.NORTH, (Comparable)false)).m_61124_((Property)PatchBlock.EAST, (Comparable)false)).m_61124_((Property)PatchBlock.SOUTH, (Comparable)false)).m_61124_((Property)PatchBlock.WEST, (Comparable)false));
    }
    
    public BlockState m_7417_(final BlockState state, final Direction dir, final BlockState neighborUpdated, final LevelAccessor levelAccessor, final BlockPos pos, final BlockPos posNeighbor) {
        return (BlockState)(dir.m_122434_().m_122479_() ? state.m_61124_((Property)PatchBlock.PROPERTY_BY_DIRECTION.get(dir), (Comparable)(neighborUpdated.m_60734_() == this)) : super.m_7417_(state, dir, neighborUpdated, levelAccessor, pos, posNeighbor));
    }
    
    @Deprecated
    public VoxelShape m_5940_(final BlockState state, final BlockGetter access, final BlockPos pos, final CollisionContext context) {
        return shapeFromPos(state, pos);
    }
    
    public static VoxelShape shapeFromLong(final BlockState state, final long seed) {
        final boolean xConnect0 = (boolean)state.m_61143_((Property)PatchBlock.EAST);
        final boolean xConnect2 = (boolean)state.m_61143_((Property)PatchBlock.WEST);
        final boolean zConnect0 = (boolean)state.m_61143_((Property)PatchBlock.SOUTH);
        final boolean zConnect2 = (boolean)state.m_61143_((Property)PatchBlock.NORTH);
        final int xOff0 = (int)(seed >> 12 & 0x3L);
        final int xOff2 = (int)(seed >> 15 & 0x3L);
        final int zOff0 = (int)(seed >> 18 & 0x3L);
        final int zOff2 = (int)(seed >> 21 & 0x3L);
        return Block.m_49796_(xConnect2 ? 0.0 : ((double)(1.0f + xOff2)), 0.0, zConnect2 ? 0.0 : ((double)(1.0f + zOff2)), xConnect0 ? 16.0 : ((double)(15.0f - xOff0)), 1.0, zConnect0 ? 16.0 : ((double)(15.0f - zOff0)));
    }
    
    public static VoxelShape shapeFromRandom(final BlockState state, final Random random) {
        return shapeFromLong(state, random.nextLong());
    }
    
    public static VoxelShape shapeFromPos(final BlockState state, final BlockPos pos) {
        return shapeFromRandom(state, new Random(state.m_60726_(pos)));
    }
    
    public static AABB AABBFromLong(final long seed) {
        final int xOff0 = (int)(seed >> 12 & 0x3L);
        final int xOff2 = (int)(seed >> 15 & 0x3L);
        final int zOff0 = (int)(seed >> 18 & 0x3L);
        final int zOff2 = (int)(seed >> 21 & 0x3L);
        return new AABB((double)(1.0f + xOff2), 0.0, (double)(1.0f + zOff2), (double)(15.0f - xOff0), 1.0, (double)(15.0f - zOff0));
    }
    
    public static AABB AABBFromRandom(final Random random) {
        return AABBFromLong(random.nextLong());
    }
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        builder.m_61104_(new Property[] { (Property)PatchBlock.NORTH, (Property)PatchBlock.EAST, (Property)PatchBlock.SOUTH, (Property)PatchBlock.WEST });
    }
    
    static {
        NORTH = BlockStateProperties.f_61368_;
        EAST = BlockStateProperties.f_61369_;
        SOUTH = BlockStateProperties.f_61370_;
        WEST = BlockStateProperties.f_61371_;
        PROPERTY_BY_DIRECTION = (Map)PipeBlock.f_55154_.entrySet().stream().filter(directionPropertyPair -> directionPropertyPair.getKey().m_122434_().m_122479_()).collect(Util.m_137448_());
    }
}
