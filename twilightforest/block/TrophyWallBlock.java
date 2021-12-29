// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import com.google.common.collect.Maps;
import com.google.common.collect.ImmutableMap;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import twilightforest.enums.BossVariant;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.core.Direction;
import java.util.Map;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

public class TrophyWallBlock extends AbstractTrophyBlock
{
    public static final DirectionProperty FACING;
    private static final Map<Direction, VoxelShape> SHAPES;
    private static final Map<Direction, VoxelShape> YETI_SHAPES;
    
    public TrophyWallBlock(final BossVariant variant) {
        super(variant, 0, BlockBehaviour.Properties.m_60939_(Material.f_76310_).m_60966_());
        this.m_49959_((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_((Property)TrophyWallBlock.FACING, (Comparable)Direction.NORTH));
    }
    
    public String m_7705_() {
        return this.m_5456_().m_5524_();
    }
    
    public VoxelShape m_5940_(final BlockState state, final BlockGetter worldIn, final BlockPos pos, final CollisionContext context) {
        if (((AbstractTrophyBlock)state.m_60734_()).getVariant() == BossVariant.UR_GHAST) {
            return TrophyBlock.GHAST_SHAPE;
        }
        if (((AbstractTrophyBlock)state.m_60734_()).getVariant() == BossVariant.ALPHA_YETI) {
            return TrophyWallBlock.YETI_SHAPES.get(state.m_61143_((Property)TrophyWallBlock.FACING));
        }
        return TrophyWallBlock.SHAPES.get(state.m_61143_((Property)TrophyWallBlock.FACING));
    }
    
    public BlockState m_5573_(final BlockPlaceContext context) {
        BlockState blockstate = this.m_49966_();
        final BlockGetter iblockreader = (BlockGetter)context.m_43725_();
        final BlockPos blockpos = context.m_8083_();
        final Direction[] 6232_;
        final Direction[] adirection = 6232_ = context.m_6232_();
        for (final Direction direction : 6232_) {
            if (direction.m_122434_().m_122479_()) {
                final Direction direction2 = direction.m_122424_();
                blockstate = (BlockState)blockstate.m_61124_((Property)TrophyWallBlock.FACING, (Comparable)direction2);
                if (!iblockreader.m_8055_(blockpos.m_142300_(direction)).m_60629_(context)) {
                    return blockstate;
                }
            }
        }
        return null;
    }
    
    public BlockState m_6843_(final BlockState state, final Rotation rot) {
        return (BlockState)state.m_61124_((Property)TrophyWallBlock.FACING, (Comparable)rot.m_55954_((Direction)state.m_61143_((Property)TrophyWallBlock.FACING)));
    }
    
    public BlockState m_6943_(final BlockState state, final Mirror mirrorIn) {
        return state.m_60717_(mirrorIn.m_54846_((Direction)state.m_61143_((Property)TrophyWallBlock.FACING)));
    }
    
    @Override
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        builder.m_61104_(new Property[] { (Property)TrophyWallBlock.FACING, (Property)TrophyWallBlock.POWERED });
    }
    
    static {
        FACING = HorizontalDirectionalBlock.f_54117_;
        SHAPES = Maps.newEnumMap((Map)ImmutableMap.of((Object)Direction.NORTH, (Object)Block.m_49796_(4.0, 4.0, 8.0, 12.0, 12.0, 16.0), (Object)Direction.SOUTH, (Object)Block.m_49796_(4.0, 4.0, 0.0, 12.0, 12.0, 8.0), (Object)Direction.EAST, (Object)Block.m_49796_(0.0, 4.0, 4.0, 8.0, 12.0, 12.0), (Object)Direction.WEST, (Object)Block.m_49796_(8.0, 4.0, 4.0, 16.0, 12.0, 12.0)));
        YETI_SHAPES = Maps.newEnumMap((Map)ImmutableMap.of((Object)Direction.NORTH, (Object)Block.m_49796_(3.25, 4.0, 8.5, 12.75, 14.5, 16.0), (Object)Direction.SOUTH, (Object)Block.m_49796_(3.25, 4.0, 0.0, 12.75, 14.5, 7.5), (Object)Direction.EAST, (Object)Block.m_49796_(0.0, 4.0, 3.25, 7.5, 14.5, 12.75), (Object)Direction.WEST, (Object)Block.m_49796_(8.5, 4.0, 3.25, 16.0, 14.5, 12.75)));
    }
}
