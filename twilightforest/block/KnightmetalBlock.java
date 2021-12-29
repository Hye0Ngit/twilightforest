// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.AABB;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.network.chat.Component;
import java.util.List;
import net.minecraft.world.item.ItemStack;
import twilightforest.util.TFDamageSources;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import javax.annotation.Nullable;
import net.minecraft.tags.Tag;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.Block;

public class KnightmetalBlock extends Block implements SimpleWaterloggedBlock
{
    private static final MutableComponent TOOLTIP;
    private static final VoxelShape SHAPE;
    public static final BooleanProperty WATERLOGGED;
    private static final float BLOCK_DAMAGE = 4.0f;
    
    public KnightmetalBlock(final BlockBehaviour.Properties props) {
        super(props);
        this.m_49959_((BlockState)((BlockState)this.m_49965_().m_61090_()).m_61124_((Property)KnightmetalBlock.WATERLOGGED, (Comparable)false));
    }
    
    @Deprecated
    public VoxelShape m_5940_(final BlockState state, final BlockGetter worldIn, final BlockPos pos, final CollisionContext context) {
        return KnightmetalBlock.SHAPE;
    }
    
    public FluidState m_5888_(final BlockState state) {
        return state.m_61143_((Property)KnightmetalBlock.WATERLOGGED) ? Fluids.f_76193_.m_76068_(false) : super.m_5888_(state);
    }
    
    @Nullable
    public BlockState m_5573_(final BlockPlaceContext context) {
        final FluidState fluidstate = context.m_43725_().m_6425_(context.m_8083_());
        return (BlockState)this.m_49966_().m_61124_((Property)KnightmetalBlock.WATERLOGGED, (Comparable)(fluidstate.m_76153_((Tag)FluidTags.f_13131_) && fluidstate.m_76186_() == 8));
    }
    
    public BlockState m_7417_(final BlockState stateIn, final Direction facing, final BlockState facingState, final LevelAccessor worldIn, final BlockPos currentPos, final BlockPos facingPos) {
        if (stateIn.m_61143_((Property)KnightmetalBlock.WATERLOGGED)) {
            worldIn.m_6217_().m_5945_(currentPos, (Object)Fluids.f_76193_, Fluids.f_76193_.m_6718_((LevelReader)worldIn));
        }
        return super.m_7417_(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_((StateDefinition.Builder)builder);
        builder.m_61104_(new Property[] { (Property)KnightmetalBlock.WATERLOGGED });
    }
    
    @Nullable
    public BlockPathTypes getAiPathNodeType(final BlockState state, final BlockGetter world, final BlockPos pos, @Nullable final Mob entity) {
        return BlockPathTypes.DAMAGE_CACTUS;
    }
    
    @Deprecated
    public void m_7892_(final BlockState state, final Level worldIn, final BlockPos pos, final Entity entity) {
        entity.m_6469_(TFDamageSources.KNIGHTMETAL, 4.0f);
    }
    
    @OnlyIn(Dist.CLIENT)
    public void m_5871_(final ItemStack stack, @Nullable final BlockGetter worldIn, final List<Component> tooltip, final TooltipFlag flagIn) {
        tooltip.add((Component)KnightmetalBlock.TOOLTIP);
    }
    
    static {
        TOOLTIP = new TranslatableComponent("block.knightmetal.tooltip").m_130940_(ChatFormatting.GRAY);
        SHAPE = Shapes.m_83064_(new AABB(0.0625, 0.0625, 0.0625, 0.9375, 0.9375, 0.9375));
        WATERLOGGED = BlockStateProperties.f_61362_;
    }
}
