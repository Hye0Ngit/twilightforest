// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.entity.BlockEntity;
import twilightforest.advancements.TFAdvancements;
import twilightforest.util.TFStats;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import twilightforest.entity.projectile.CicadaShot;
import twilightforest.entity.projectile.MoonwormShot;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import twilightforest.TFSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.Items;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import javax.annotation.Nullable;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.BaseEntityBlock;

public abstract class CritterBlock extends BaseEntityBlock implements SimpleWaterloggedBlock
{
    private final float WIDTH;
    public static final DirectionProperty FACING;
    public static final BooleanProperty WATERLOGGED;
    private final VoxelShape DOWN_BB;
    private final VoxelShape UP_BB;
    private final VoxelShape NORTH_BB;
    private final VoxelShape SOUTH_BB;
    private final VoxelShape WEST_BB;
    private final VoxelShape EAST_BB;
    
    protected CritterBlock(final BlockBehaviour.Properties props) {
        super(props);
        this.WIDTH = this.getWidth();
        this.DOWN_BB = Shapes.m_83064_(new AABB((double)(0.5f - this.WIDTH), 0.800000011920929, 0.20000000298023224, (double)(0.5f + this.WIDTH), 1.0, 0.800000011920929));
        this.UP_BB = Shapes.m_83064_(new AABB((double)(0.5f - this.WIDTH), 0.0, 0.20000000298023224, (double)(0.5f + this.WIDTH), 0.20000000298023224, 0.800000011920929));
        this.NORTH_BB = Shapes.m_83064_(new AABB((double)(0.5f - this.WIDTH), 0.20000000298023224, 0.800000011920929, (double)(0.5f + this.WIDTH), 0.800000011920929, 1.0));
        this.SOUTH_BB = Shapes.m_83064_(new AABB((double)(0.5f - this.WIDTH), 0.20000000298023224, 0.0, (double)(0.5f + this.WIDTH), 0.800000011920929, 0.20000000298023224));
        this.WEST_BB = Shapes.m_83064_(new AABB(0.800000011920929, 0.20000000298023224, (double)(0.5f - this.WIDTH), 1.0, 0.800000011920929, (double)(0.5f + this.WIDTH)));
        this.EAST_BB = Shapes.m_83064_(new AABB(0.0, 0.20000000298023224, (double)(0.5f - this.WIDTH), 0.20000000298023224, 0.800000011920929, (double)(0.5f + this.WIDTH)));
        this.m_49959_((BlockState)((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_((Property)CritterBlock.FACING, (Comparable)Direction.UP)).m_61124_((Property)CritterBlock.WATERLOGGED, (Comparable)Boolean.FALSE));
    }
    
    public float getWidth() {
        return 0.15f;
    }
    
    @Deprecated
    public VoxelShape m_5940_(final BlockState state, final BlockGetter worldIn, final BlockPos pos, final CollisionContext context) {
        return switch ((Direction)state.m_61143_((Property)CritterBlock.FACING)) {
            case DOWN -> this.DOWN_BB;
            default -> this.UP_BB;
            case NORTH -> this.NORTH_BB;
            case SOUTH -> this.SOUTH_BB;
            case WEST -> this.WEST_BB;
            case EAST -> this.EAST_BB;
        };
    }
    
    public FluidState m_5888_(final BlockState state) {
        return state.m_61143_((Property)CritterBlock.WATERLOGGED) ? Fluids.f_76193_.m_76068_(false) : super.m_5888_(state);
    }
    
    @Nullable
    public BlockState m_5573_(final BlockPlaceContext context) {
        final Direction clicked = context.m_43719_();
        final FluidState fluidstate = context.m_43725_().m_6425_(context.m_8083_());
        BlockState state = (BlockState)((BlockState)this.m_49966_().m_61124_((Property)CritterBlock.FACING, (Comparable)clicked)).m_61124_((Property)CritterBlock.WATERLOGGED, (Comparable)(fluidstate.m_76152_() == Fluids.f_76193_));
        if (this.m_7898_(state, (LevelReader)context.m_43725_(), context.m_8083_())) {
            return state;
        }
        for (final Direction dir : context.m_6232_()) {
            state = (BlockState)this.m_49966_().m_61124_((Property)CritterBlock.FACING, (Comparable)dir.m_122424_());
            if (this.m_7898_(state, (LevelReader)context.m_43725_(), context.m_8083_())) {
                return state;
            }
        }
        return null;
    }
    
    @Deprecated
    public BlockState m_7417_(final BlockState state, final Direction direction, final BlockState neighborState, final LevelAccessor world, final BlockPos pos, final BlockPos neighborPos) {
        if (state.m_61143_((Property)CritterBlock.WATERLOGGED)) {
            world.m_6217_().m_5945_(pos, (Object)Fluids.f_76193_, Fluids.f_76193_.m_6718_((LevelReader)world));
        }
        if (!this.m_7898_(state, (LevelReader)world, pos)) {
            return Blocks.f_50016_.m_49966_();
        }
        return super.m_7417_(state, direction, neighborState, world, pos, neighborPos);
    }
    
    @Deprecated
    public boolean m_7898_(final BlockState state, final LevelReader world, final BlockPos pos) {
        final Direction facing = (Direction)state.m_61143_((Property)DirectionalBlock.f_52588_);
        final BlockPos restingPos = pos.m_142300_(facing.m_122424_());
        return m_49863_(world, restingPos, facing);
    }
    
    public abstract ItemStack getSquishResult();
    
    public BlockState m_6843_(final BlockState state, final Rotation rot) {
        return (BlockState)state.m_61124_((Property)CritterBlock.FACING, (Comparable)rot.m_55954_((Direction)state.m_61143_((Property)CritterBlock.FACING)));
    }
    
    public InteractionResult m_6227_(final BlockState state, final Level worldIn, final BlockPos pos, final Player player, final InteractionHand handIn, final BlockHitResult hit) {
        final ItemStack stack = player.m_21120_(handIn);
        if (stack.m_41720_() == Items.f_42590_) {
            if (this == TFBlocks.FIREFLY.get()) {
                if (!player.m_7500_()) {
                    stack.m_41774_(1);
                }
                player.m_150109_().m_36054_(new ItemStack((ItemLike)TFBlocks.FIREFLY_JAR.get()));
                worldIn.m_46597_(pos, ((boolean)state.m_61143_((Property)CritterBlock.WATERLOGGED)) ? Blocks.f_49990_.m_49966_() : Blocks.f_50016_.m_49966_());
                return InteractionResult.SUCCESS;
            }
            if (this == TFBlocks.CICADA.get()) {
                if (!player.m_7500_()) {
                    stack.m_41774_(1);
                }
                player.m_150109_().m_36054_(new ItemStack((ItemLike)TFBlocks.CICADA_JAR.get()));
                if (worldIn.f_46443_) {
                    Minecraft.m_91087_().m_91106_().m_120386_(TFSounds.CICADA.m_11660_(), SoundSource.NEUTRAL);
                }
                worldIn.m_46597_(pos, ((boolean)state.m_61143_((Property)CritterBlock.WATERLOGGED)) ? Blocks.f_49990_.m_49966_() : Blocks.f_50016_.m_49966_());
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }
    
    public void m_7892_(final BlockState state, final Level worldIn, final BlockPos pos, final Entity entityIn) {
        if ((entityIn instanceof Projectile && !(entityIn instanceof MoonwormShot) && !(entityIn instanceof CicadaShot)) || entityIn instanceof FallingBlockEntity) {
            worldIn.m_46597_(pos, ((boolean)state.m_61143_((Property)CritterBlock.WATERLOGGED)) ? Blocks.f_49990_.m_49966_() : Blocks.f_50016_.m_49966_());
            if (worldIn.f_46443_) {
                Minecraft.m_91087_().m_91106_().m_120386_(TFSounds.CICADA.m_11660_(), SoundSource.NEUTRAL);
            }
            worldIn.m_5594_((Player)null, pos, TFSounds.BUG_SQUISH, SoundSource.BLOCKS, 1.0f, 1.0f);
            final ItemEntity squish = new ItemEntity(worldIn, (double)pos.m_123341_(), (double)pos.m_123342_(), (double)pos.m_123343_(), this.getSquishResult());
            squish.m_19983_(squish.m_32055_());
            for (int i = 0; i < 50; ++i) {
                final boolean wallBug = state.m_61143_((Property)CritterBlock.FACING) != Direction.UP;
                worldIn.m_6493_((ParticleOptions)new BlockParticleOption(ParticleTypes.f_123794_, Blocks.f_50374_.m_49966_()), true, (double)(pos.m_123341_() + Mth.m_14068_(worldIn.f_46441_, 0.25f, 0.75f)), (double)(pos.m_123342_() + (wallBug ? 0.5f : 0.0f)), (double)(pos.m_123343_() + Mth.m_14068_(worldIn.f_46441_, 0.25f, 0.75f)), 0.0, 0.0, 0.0);
            }
            if (entityIn instanceof final Projectile projectile) {
                final Entity 37282_ = projectile.m_37282_();
                if (37282_ instanceof final ServerPlayer player) {
                    player.m_36220_(TFStats.BUGS_SQUISHED);
                    TFAdvancements.KILL_BUG.trigger(player, state);
                }
            }
        }
    }
    
    @Nullable
    public abstract BlockEntity m_142194_(final BlockPos p0, final BlockState p1);
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_((StateDefinition.Builder)builder);
        builder.m_61104_(new Property[] { (Property)CritterBlock.FACING, (Property)CritterBlock.WATERLOGGED });
    }
    
    static {
        FACING = DirectionalBlock.f_52588_;
        WATERLOGGED = BlockStateProperties.f_61362_;
    }
}
