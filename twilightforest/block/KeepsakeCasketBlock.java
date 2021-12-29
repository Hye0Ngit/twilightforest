// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.sounds.SoundEvent;
import java.util.Optional;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import java.util.Objects;
import it.unimi.dsi.fastutil.floats.Float2FloatFunction;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraft.world.level.block.entity.LidBlockEntity;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundSource;
import twilightforest.TFSounds;
import twilightforest.item.TFItems;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.Containers;
import net.minecraft.world.Container;
import twilightforest.block.entity.TFBlockEntities;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.Level;
import javax.annotation.Nullable;
import twilightforest.block.entity.KeepsakeCasketBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import twilightforest.enums.BlockLoggingEnum;
import net.minecraft.world.level.block.BaseEntityBlock;

public class KeepsakeCasketBlock extends BaseEntityBlock implements BlockLoggingEnum.IMultiLoggable
{
    public static final DirectionProperty FACING;
    public static final IntegerProperty BREAKAGE;
    private static final VoxelShape BOTTOM_X;
    private static final VoxelShape TOP_X;
    private static final VoxelShape BOTTOM_Z;
    private static final VoxelShape TOP_Z;
    private static final VoxelShape CASKET_X;
    private static final VoxelShape CASKET_Z;
    private static final VoxelShape SOLID;
    private static final VoxelShape TOPPER_X;
    private static final VoxelShape TOPPER_Z;
    private static final VoxelShape SOLID_X;
    private static final VoxelShape SOLID_Z;
    
    protected KeepsakeCasketBlock() {
        super(BlockBehaviour.Properties.m_60944_(Material.f_76279_, MaterialColor.f_76365_).m_60955_().m_60999_().m_60913_(50.0f, 1200.0f).m_60918_(SoundType.f_56725_));
        this.m_49959_((BlockState)((BlockState)((BlockState)this.m_49965_().m_61090_()).m_61124_((Property)KeepsakeCasketBlock.FACING, (Comparable)Direction.NORTH)).m_61124_((Property)KeepsakeCasketBlock.BREAKAGE, (Comparable)0));
    }
    
    public RenderShape m_7514_(final BlockState state) {
        return (((BlockLoggingEnum)state.m_61143_((Property)BlockLoggingEnum.MULTILOGGED)).getBlock() == Blocks.f_50016_) ? RenderShape.ENTITYBLOCK_ANIMATED : RenderShape.MODEL;
    }
    
    public VoxelShape m_5940_(final BlockState state, final BlockGetter worldIn, final BlockPos pos, final CollisionContext context) {
        final Direction direction = (Direction)state.m_61143_((Property)BlockStateProperties.f_61374_);
        if (((BlockLoggingEnum)state.m_61143_((Property)BlockLoggingEnum.MULTILOGGED)).getBlock() != Blocks.f_50016_ && ((BlockLoggingEnum)state.m_61143_((Property)BlockLoggingEnum.MULTILOGGED)).getFluid() == Fluids.f_76191_) {
            return (direction.m_122434_() == Direction.Axis.X) ? KeepsakeCasketBlock.SOLID_X : KeepsakeCasketBlock.SOLID_Z;
        }
        return (direction.m_122434_() == Direction.Axis.X) ? KeepsakeCasketBlock.CASKET_X : KeepsakeCasketBlock.CASKET_Z;
    }
    
    @Nullable
    public BlockEntity m_142194_(final BlockPos pos, final BlockState state) {
        return (BlockEntity)new KeepsakeCasketBlockEntity(pos, state);
    }
    
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> m_142354_(final Level level, final BlockState state, final BlockEntityType<T> type) {
        return (BlockEntityTicker<T>)m_152132_((BlockEntityType)type, (BlockEntityType)TFBlockEntities.KEEPSAKE_CASKET.get(), KeepsakeCasketBlockEntity::tick);
    }
    
    public void m_6810_(final BlockState state, final Level worldIn, final BlockPos pos, final BlockState newState, final boolean isMoving) {
        if (!state.m_60713_(newState.m_60734_())) {
            final BlockEntity tileentity = worldIn.m_7702_(pos);
            if (tileentity instanceof final Container container) {
                Containers.m_19002_(worldIn, pos, container);
                worldIn.m_46717_(pos, (Block)this);
            }
            super.m_6810_(state, worldIn, pos, newState, isMoving);
        }
    }
    
    public float getExplosionResistance(final BlockState state, final BlockGetter world, final BlockPos pos, final Explosion explosion) {
        return 1.0E9f;
    }
    
    public InteractionResult m_6227_(final BlockState state, final Level worldIn, final BlockPos pos, final Player player, final InteractionHand handIn, final BlockHitResult hit) {
        boolean flag = false;
        if (((BlockLoggingEnum)state.m_61143_((Property)BlockLoggingEnum.MULTILOGGED)).getBlock() == Blocks.f_50016_ || ((BlockLoggingEnum)state.m_61143_((Property)BlockLoggingEnum.MULTILOGGED)).getFluid() != Fluids.f_76191_) {
            final ItemStack stack = player.m_21120_(handIn);
            if (stack.m_41720_() != TFItems.CHARM_OF_KEEPING_3.get()) {
                if (worldIn.f_46443_) {
                    return InteractionResult.SUCCESS;
                }
                final MenuProvider inamedcontainerprovider = this.m_7246_(state, worldIn, pos);
                if (inamedcontainerprovider != null) {
                    player.m_5893_(inamedcontainerprovider);
                }
                flag = true;
            }
            else if (stack.m_41720_() == TFItems.CHARM_OF_KEEPING_3.get() && (int)state.m_61143_((Property)KeepsakeCasketBlock.BREAKAGE) > 0) {
                if (!player.m_7500_()) {
                    stack.m_41774_(1);
                }
                worldIn.m_46597_(pos, (BlockState)state.m_61124_((Property)KeepsakeCasketBlock.BREAKAGE, (Comparable)((int)state.m_61143_((Property)KeepsakeCasketBlock.BREAKAGE) - 1)));
                worldIn.m_5594_((Player)null, pos, TFSounds.CASKET_REPAIR, SoundSource.BLOCKS, 0.5f, worldIn.f_46441_.nextFloat() * 0.1f + 0.9f);
                flag = true;
            }
        }
        return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
    }
    
    public void m_5707_(final Level worldIn, final BlockPos pos, final BlockState state, final Player player) {
        if (!worldIn.f_46443_ && !player.m_7500_() && worldIn.m_46469_().m_46207_(GameRules.f_46136_)) {
            final BlockEntity tile = worldIn.m_7702_(pos);
            if (tile instanceof final KeepsakeCasketBlockEntity casket) {
                final ItemStack stack = new ItemStack((ItemLike)this);
                final String nameCheck = new TextComponent(casket.f_58622_ + "'s " + casket.m_5446_()).getString();
                final ItemEntity itementity = new ItemEntity(worldIn, (double)pos.m_123341_(), (double)pos.m_123342_(), (double)pos.m_123343_(), stack);
                final CompoundTag nbt = new CompoundTag();
                nbt.m_128405_("damage", (int)state.m_61143_((Property)KeepsakeCasketBlock.BREAKAGE));
                stack.m_41700_("BlockStateTag", (Tag)nbt);
                if (casket.m_8077_()) {
                    if (nameCheck.equals(casket.m_7770_().getString())) {
                        itementity.m_6593_(casket.m_5446_());
                    }
                    else {
                        itementity.m_6593_(casket.m_7770_());
                    }
                }
                if (((BlockLoggingEnum)state.m_61143_((Property)BlockLoggingEnum.MULTILOGGED)).getFluid() == Fluids.f_76191_) {
                    final Block block = ((BlockLoggingEnum)state.m_61143_((Property)BlockLoggingEnum.MULTILOGGED)).getBlock();
                    if (block != Blocks.f_50016_) {
                        final ItemStack blockstack = new ItemStack((ItemLike)block);
                        final ItemEntity item = new ItemEntity(worldIn, (double)pos.m_123341_(), (double)pos.m_123342_(), (double)pos.m_123343_(), blockstack);
                        item.m_32060_();
                        worldIn.m_7967_((Entity)item);
                    }
                }
                itementity.m_32060_();
                worldIn.m_7967_((Entity)itementity);
            }
        }
        super.m_5707_(worldIn, pos, state, player);
    }
    
    public void m_6402_(final Level worldIn, final BlockPos pos, final BlockState state, final LivingEntity placer, final ItemStack stack) {
        final CompoundTag nbt = stack.m_41784_();
        if (nbt.m_128441_("BlockStateTag")) {
            final CompoundTag damageNbt = nbt.m_128469_("BlockStateTag");
            if (damageNbt.m_128441_("damage")) {
                worldIn.m_7731_(pos, (BlockState)state.m_61124_((Property)KeepsakeCasketBlock.BREAKAGE, (Comparable)damageNbt.m_128451_("damage")), 2);
            }
        }
        if (stack.m_41788_()) {
            final BlockEntity tileentity = worldIn.m_7702_(pos);
            if (tileentity instanceof final KeepsakeCasketBlockEntity keepsakeCasketBlockEntity) {
                keepsakeCasketBlockEntity.m_58638_(stack.m_41786_());
            }
        }
    }
    
    public void m_6861_(final BlockState state, final Level worldIn, final BlockPos pos, final Block blockIn, final BlockPos fromPos, final boolean isMoving) {
        this.reactWithNeighbors(worldIn, pos, state);
        super.m_6861_(state, worldIn, pos, blockIn, fromPos, isMoving);
    }
    
    private void reactWithNeighbors(final Level worldIn, final BlockPos pos, final BlockState state) {
        if (state.m_61143_((Property)BlockLoggingEnum.MULTILOGGED) == BlockLoggingEnum.LAVA) {
            final boolean flag = worldIn.m_8055_(pos.m_7495_()).m_60713_(Blocks.f_50136_);
            for (final Direction direction : Direction.values()) {
                if (direction != Direction.DOWN) {
                    final BlockPos blockpos = pos.m_142300_(direction);
                    if (worldIn.m_6425_(blockpos).m_76153_((net.minecraft.tags.Tag)FluidTags.f_13131_)) {
                        worldIn.m_46597_(pos, (BlockState)state.m_61124_((Property)BlockLoggingEnum.MULTILOGGED, (Comparable)BlockLoggingEnum.OBSIDIAN));
                        worldIn.m_46796_(1501, pos, 0);
                    }
                    if (flag && worldIn.m_8055_(blockpos).m_60713_(Blocks.f_50568_)) {
                        worldIn.m_46597_(pos, (BlockState)state.m_61124_((Property)BlockLoggingEnum.MULTILOGGED, (Comparable)BlockLoggingEnum.BASALT));
                        worldIn.m_46796_(1501, pos, 0);
                    }
                }
            }
        }
        else if (state.m_61143_((Property)BlockLoggingEnum.MULTILOGGED) == BlockLoggingEnum.WATER) {
            for (final Direction direction2 : Direction.values()) {
                if (direction2 != Direction.DOWN) {
                    final BlockPos blockpos2 = pos.m_142300_(direction2);
                    if (worldIn.m_6425_(blockpos2).m_76153_((net.minecraft.tags.Tag)FluidTags.f_13132_)) {
                        worldIn.m_46597_(pos, (BlockState)state.m_61124_((Property)BlockLoggingEnum.MULTILOGGED, (Comparable)BlockLoggingEnum.STONE));
                        worldIn.m_46796_(1501, pos, 0);
                    }
                }
            }
        }
    }
    
    public PushReaction m_5537_(final BlockState state) {
        return PushReaction.BLOCK;
    }
    
    public boolean m_7278_(final BlockState state) {
        return true;
    }
    
    public int m_6782_(final BlockState blockState, final Level worldIn, final BlockPos pos) {
        return AbstractContainerMenu.m_38918_(worldIn.m_7702_(pos));
    }
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        builder.m_61104_(new Property[] { (Property)BlockLoggingEnum.MULTILOGGED, (Property)KeepsakeCasketBlock.FACING, (Property)KeepsakeCasketBlock.BREAKAGE });
    }
    
    @Nullable
    public BlockState m_5573_(final BlockPlaceContext context) {
        return (BlockState)((BlockState)super.m_5573_(context).m_61124_((Property)KeepsakeCasketBlock.FACING, (Comparable)context.m_8125_().m_122424_())).m_61124_((Property)BlockLoggingEnum.MULTILOGGED, (Comparable)BlockLoggingEnum.getFromFluid(context.m_43725_().m_6425_(context.m_8083_()).m_76152_()));
    }
    
    public FluidState m_5888_(final BlockState state) {
        return ((BlockLoggingEnum)state.m_61143_((Property)BlockLoggingEnum.MULTILOGGED)).getFluid().m_76145_();
    }
    
    @OnlyIn(Dist.CLIENT)
    public static DoubleBlockCombiner.Combiner<KeepsakeCasketBlockEntity, Float2FloatFunction> getLidRotationCallback(final LidBlockEntity lid) {
        return (DoubleBlockCombiner.Combiner<KeepsakeCasketBlockEntity, Float2FloatFunction>)new DoubleBlockCombiner.Combiner<KeepsakeCasketBlockEntity, Float2FloatFunction>() {
            public Float2FloatFunction acceptDouble(final KeepsakeCasketBlockEntity p_225539_1_, final KeepsakeCasketBlockEntity p_225539_2_) {
                return angle -> Math.max(p_225539_1_.m_6683_(angle), p_225539_2_.m_6683_(angle));
            }
            
            public Float2FloatFunction acceptSingle(final KeepsakeCasketBlockEntity p_225538_1_) {
                Objects.requireNonNull(p_225538_1_);
                return p_225538_1_::m_6683_;
            }
            
            public Float2FloatFunction acceptNone() {
                final LidBlockEntity val$lid = lid;
                Objects.requireNonNull(val$lid);
                return val$lid::m_6683_;
            }
        };
    }
    
    public Optional<SoundEvent> m_142298_() {
        return Optional.empty();
    }
    
    static {
        FACING = TFHorizontalBlock.f_54117_;
        BREAKAGE = IntegerProperty.m_61631_("damage", 0, 2);
        BOTTOM_X = Block.m_49796_(2.0, 0.0, 1.0, 14.0, 6.0, 15.0);
        TOP_X = Block.m_49796_(1.0, 6.0, 0.0, 15.0, 14.0, 16.0);
        BOTTOM_Z = Block.m_49796_(1.0, 0.0, 2.0, 15.0, 6.0, 14.0);
        TOP_Z = Block.m_49796_(0.0, 6.0, 1.0, 16.0, 14.0, 15.0);
        CASKET_X = Shapes.m_83110_(KeepsakeCasketBlock.BOTTOM_X, KeepsakeCasketBlock.TOP_X);
        CASKET_Z = Shapes.m_83110_(KeepsakeCasketBlock.BOTTOM_Z, KeepsakeCasketBlock.TOP_Z);
        SOLID = Block.m_49796_(0.0, 0.0, 0.0, 16.0, 12.0, 16.0);
        TOPPER_X = Block.m_49796_(1.0, 12.0, 0.0, 15.0, 14.0, 16.0);
        TOPPER_Z = Block.m_49796_(0.0, 12.0, 1.0, 16.0, 14.0, 15.0);
        SOLID_X = Shapes.m_83110_(KeepsakeCasketBlock.SOLID, KeepsakeCasketBlock.TOPPER_X);
        SOLID_Z = Shapes.m_83110_(KeepsakeCasketBlock.SOLID, KeepsakeCasketBlock.TOPPER_Z);
    }
}
