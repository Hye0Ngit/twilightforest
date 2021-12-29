// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import com.google.common.collect.Maps;
import com.google.common.collect.ImmutableMap;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.Block;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.state.Property;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.material.Material;
import twilightforest.enums.BossVariant;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.Direction;
import java.util.Map;
import net.minecraft.state.DirectionProperty;

public class TrophyWallBlock extends AbstractTrophyBlock
{
    public static final DirectionProperty FACING;
    private static final Map<Direction, VoxelShape> SHAPES;
    private static final Map<Direction, VoxelShape> YETI_SHAPES;
    
    public TrophyWallBlock(final BossVariant variant) {
        super(variant, 0, AbstractBlock.Properties.func_200945_a(Material.field_151594_q).func_200946_b());
        this.func_180632_j((BlockState)((BlockState)this.field_176227_L.func_177621_b()).func_206870_a((Property)TrophyWallBlock.FACING, (Comparable)Direction.NORTH));
    }
    
    public String func_149739_a() {
        return this.func_199767_j().func_77658_a();
    }
    
    public VoxelShape func_220053_a(final BlockState state, final IBlockReader worldIn, final BlockPos pos, final ISelectionContext context) {
        if (((AbstractTrophyBlock)state.func_177230_c()).getVariant() == BossVariant.UR_GHAST) {
            return TrophyBlock.GHAST_SHAPE;
        }
        if (((AbstractTrophyBlock)state.func_177230_c()).getVariant() == BossVariant.ALPHA_YETI) {
            return TrophyWallBlock.YETI_SHAPES.get(state.func_177229_b((Property)TrophyWallBlock.FACING));
        }
        return TrophyWallBlock.SHAPES.get(state.func_177229_b((Property)TrophyWallBlock.FACING));
    }
    
    public BlockState func_196258_a(final BlockItemUseContext context) {
        BlockState blockstate = this.func_176223_P();
        final IBlockReader iblockreader = (IBlockReader)context.func_195991_k();
        final BlockPos blockpos = context.func_195995_a();
        final Direction[] func_196009_e;
        final Direction[] adirection = func_196009_e = context.func_196009_e();
        for (final Direction direction : func_196009_e) {
            if (direction.func_176740_k().func_176722_c()) {
                final Direction direction2 = direction.func_176734_d();
                blockstate = (BlockState)blockstate.func_206870_a((Property)TrophyWallBlock.FACING, (Comparable)direction2);
                if (!iblockreader.func_180495_p(blockpos.func_177972_a(direction)).func_196953_a(context)) {
                    return blockstate;
                }
            }
        }
        return null;
    }
    
    public BlockState func_185499_a(final BlockState state, final Rotation rot) {
        return (BlockState)state.func_206870_a((Property)TrophyWallBlock.FACING, (Comparable)rot.func_185831_a((Direction)state.func_177229_b((Property)TrophyWallBlock.FACING)));
    }
    
    public BlockState func_185471_a(final BlockState state, final Mirror mirrorIn) {
        return state.func_185907_a(mirrorIn.func_185800_a((Direction)state.func_177229_b((Property)TrophyWallBlock.FACING)));
    }
    
    @Override
    protected void func_206840_a(final StateContainer.Builder<Block, BlockState> builder) {
        builder.func_206894_a(new Property[] { (Property)TrophyWallBlock.FACING, (Property)TrophyWallBlock.POWERED });
    }
    
    static {
        FACING = HorizontalBlock.field_185512_D;
        SHAPES = Maps.newEnumMap((Map)ImmutableMap.of((Object)Direction.NORTH, (Object)Block.func_208617_a(4.0, 4.0, 8.0, 12.0, 12.0, 16.0), (Object)Direction.SOUTH, (Object)Block.func_208617_a(4.0, 4.0, 0.0, 12.0, 12.0, 8.0), (Object)Direction.EAST, (Object)Block.func_208617_a(0.0, 4.0, 4.0, 8.0, 12.0, 12.0), (Object)Direction.WEST, (Object)Block.func_208617_a(8.0, 4.0, 4.0, 16.0, 12.0, 12.0)));
        YETI_SHAPES = Maps.newEnumMap((Map)ImmutableMap.of((Object)Direction.NORTH, (Object)Block.func_208617_a(3.25, 4.0, 8.5, 12.75, 14.5, 16.0), (Object)Direction.SOUTH, (Object)Block.func_208617_a(3.25, 4.0, 0.0, 12.75, 14.5, 7.5), (Object)Direction.EAST, (Object)Block.func_208617_a(0.0, 4.0, 3.25, 7.5, 14.5, 12.75), (Object)Direction.WEST, (Object)Block.func_208617_a(8.5, 4.0, 3.25, 16.0, 14.5, 12.75)));
    }
}
