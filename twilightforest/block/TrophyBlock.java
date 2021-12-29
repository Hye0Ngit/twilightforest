// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.block.Block;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.state.Property;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.material.Material;
import twilightforest.enums.BossVariant;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.state.IntegerProperty;

public class TrophyBlock extends AbstractTrophyBlock
{
    public static final IntegerProperty ROTATION;
    protected static final VoxelShape SHAPE;
    public static final VoxelShape GHAST_SHAPE;
    protected static final VoxelShape YETI_X_SHAPE;
    protected static final VoxelShape YETI_Z_SHAPE;
    protected static final VoxelShape YETI_CORNER_SHAPE;
    
    public TrophyBlock(final BossVariant variant, final int value) {
        super(variant, value, AbstractBlock.Properties.func_200945_a(Material.field_151594_q).func_200946_b());
        this.func_180632_j((BlockState)((BlockState)this.field_176227_L.func_177621_b()).func_206870_a((Property)TrophyBlock.ROTATION, (Comparable)0));
    }
    
    public VoxelShape func_220053_a(final BlockState state, final IBlockReader worldIn, final BlockPos pos, final ISelectionContext context) {
        if (((AbstractTrophyBlock)state.func_177230_c()).getVariant() == BossVariant.UR_GHAST) {
            return TrophyBlock.GHAST_SHAPE;
        }
        if (((AbstractTrophyBlock)state.func_177230_c()).getVariant() != BossVariant.ALPHA_YETI) {
            return TrophyBlock.SHAPE;
        }
        switch ((int)state.func_177229_b((Property)TrophyBlock.ROTATION)) {
            default: {
                return TrophyBlock.YETI_X_SHAPE;
            }
            case 3:
            case 4:
            case 5:
            case 11:
            case 12:
            case 13: {
                return TrophyBlock.YETI_Z_SHAPE;
            }
            case 2:
            case 6:
            case 10:
            case 14: {
                return TrophyBlock.YETI_CORNER_SHAPE;
            }
        }
    }
    
    public VoxelShape func_196247_c(final BlockState state, final IBlockReader worldIn, final BlockPos pos) {
        return VoxelShapes.func_197880_a();
    }
    
    public BlockState func_196258_a(final BlockItemUseContext context) {
        return (BlockState)this.func_176223_P().func_206870_a((Property)TrophyBlock.ROTATION, (Comparable)(MathHelper.func_76128_c(context.func_195990_h() * 16.0f / 360.0f + 0.5) & 0xF));
    }
    
    public BlockState func_185499_a(final BlockState state, final Rotation rot) {
        return (BlockState)state.func_206870_a((Property)TrophyBlock.ROTATION, (Comparable)rot.func_185833_a((int)state.func_177229_b((Property)TrophyBlock.ROTATION), 16));
    }
    
    public BlockState func_185471_a(final BlockState state, final Mirror mirrorIn) {
        return (BlockState)state.func_206870_a((Property)TrophyBlock.ROTATION, (Comparable)mirrorIn.func_185802_a((int)state.func_177229_b((Property)TrophyBlock.ROTATION), 16));
    }
    
    @Override
    protected void func_206840_a(final StateContainer.Builder<Block, BlockState> builder) {
        builder.func_206894_a(new Property[] { (Property)TrophyBlock.ROTATION, (Property)TrophyBlock.POWERED });
    }
    
    static {
        ROTATION = BlockStateProperties.field_208138_am;
        SHAPE = Block.func_208617_a(4.0, 0.0, 4.0, 12.0, 8.0, 12.0);
        GHAST_SHAPE = Block.func_208617_a(4.0, 8.0, 4.0, 12.0, 16.0, 12.0);
        YETI_X_SHAPE = Block.func_208617_a(3.25, 0.0, 4.5, 12.75, 10.0, 11.5);
        YETI_Z_SHAPE = Block.func_208617_a(4.5, 0.0, 3.25, 11.5, 10.0, 12.75);
        YETI_CORNER_SHAPE = Block.func_208617_a(4.5, 0.0, 4.5, 11.5, 10.0, 11.5);
    }
}
