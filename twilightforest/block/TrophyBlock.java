// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import twilightforest.enums.BossVariant;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class TrophyBlock extends AbstractTrophyBlock
{
    public static final IntegerProperty ROTATION;
    protected static final VoxelShape SHAPE;
    public static final VoxelShape GHAST_SHAPE;
    protected static final VoxelShape YETI_X_SHAPE;
    protected static final VoxelShape YETI_Z_SHAPE;
    protected static final VoxelShape YETI_CORNER_SHAPE;
    
    public TrophyBlock(final BossVariant variant, final int value) {
        super(variant, value, BlockBehaviour.Properties.m_60939_(Material.f_76310_).m_60966_());
        this.m_49959_((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_((Property)TrophyBlock.ROTATION, (Comparable)0));
    }
    
    public VoxelShape m_5940_(final BlockState state, final BlockGetter worldIn, final BlockPos pos, final CollisionContext context) {
        if (((AbstractTrophyBlock)state.m_60734_()).getVariant() == BossVariant.UR_GHAST) {
            return TrophyBlock.GHAST_SHAPE;
        }
        if (((AbstractTrophyBlock)state.m_60734_()).getVariant() == BossVariant.ALPHA_YETI) {
            return switch ((int)state.m_61143_((Property)TrophyBlock.ROTATION)) {
                case 3,  4,  5,  11,  12,  13 -> TrophyBlock.YETI_Z_SHAPE;
                case 2,  6,  10,  14 -> TrophyBlock.YETI_CORNER_SHAPE;
                default -> TrophyBlock.YETI_X_SHAPE;
            };
        }
        return TrophyBlock.SHAPE;
    }
    
    public VoxelShape m_7952_(final BlockState state, final BlockGetter worldIn, final BlockPos pos) {
        return Shapes.m_83040_();
    }
    
    public BlockState m_5573_(final BlockPlaceContext context) {
        return (BlockState)this.m_49966_().m_61124_((Property)TrophyBlock.ROTATION, (Comparable)(Mth.m_14107_(context.m_7074_() * 16.0f / 360.0f + 0.5) & 0xF));
    }
    
    public BlockState m_6843_(final BlockState state, final Rotation rot) {
        return (BlockState)state.m_61124_((Property)TrophyBlock.ROTATION, (Comparable)rot.m_55949_((int)state.m_61143_((Property)TrophyBlock.ROTATION), 16));
    }
    
    public BlockState m_6943_(final BlockState state, final Mirror mirrorIn) {
        return (BlockState)state.m_61124_((Property)TrophyBlock.ROTATION, (Comparable)mirrorIn.m_54843_((int)state.m_61143_((Property)TrophyBlock.ROTATION), 16));
    }
    
    @Override
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        builder.m_61104_(new Property[] { (Property)TrophyBlock.ROTATION, (Property)TrophyBlock.POWERED });
    }
    
    static {
        ROTATION = BlockStateProperties.f_61390_;
        SHAPE = Block.m_49796_(4.0, 0.0, 4.0, 12.0, 8.0, 12.0);
        GHAST_SHAPE = Block.m_49796_(4.0, 8.0, 4.0, 12.0, 16.0, 12.0);
        YETI_X_SHAPE = Block.m_49796_(3.25, 0.0, 4.5, 12.75, 10.0, 11.5);
        YETI_Z_SHAPE = Block.m_49796_(4.5, 0.0, 3.25, 11.5, 10.0, 12.75);
        YETI_CORNER_SHAPE = Block.m_49796_(4.5, 0.0, 4.5, 11.5, 10.0, 11.5);
    }
}
