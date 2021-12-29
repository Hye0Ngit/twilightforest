// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.PushReaction;
import twilightforest.util.TFStats;
import twilightforest.advancements.TFAdvancements;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import twilightforest.TFSounds;
import twilightforest.util.PlayerHelper;
import twilightforest.TwilightForestMod;
import net.minecraft.resources.ResourceLocation;
import java.util.Iterator;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.entity.player.Player;
import net.minecraft.tags.Tag;
import twilightforest.data.BlockTagGenerator;
import twilightforest.world.registration.TFGenerationSettings;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.LevelReader;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import javax.annotation.Nullable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.Block;

public class TrophyPedestalBlock extends Block implements SimpleWaterloggedBlock
{
    public static final BooleanProperty ACTIVE;
    public static final BooleanProperty WATERLOGGED;
    private static final VoxelShape BOTTOM;
    private static final VoxelShape MID;
    private static final VoxelShape TOP;
    private static final VoxelShape CORNER1;
    private static final VoxelShape CORNER2;
    private static final VoxelShape CORNER3;
    private static final VoxelShape CORNER4;
    private static final VoxelShape FINAL;
    
    public TrophyPedestalBlock(final BlockBehaviour.Properties props) {
        super(props);
        this.m_49959_((BlockState)((BlockState)this.m_49966_().m_61124_((Property)TrophyPedestalBlock.ACTIVE, (Comparable)false)).m_61124_((Property)TrophyPedestalBlock.WATERLOGGED, (Comparable)false));
    }
    
    public FluidState m_5888_(final BlockState state) {
        return state.m_61143_((Property)TrophyPedestalBlock.WATERLOGGED) ? Fluids.f_76193_.m_76068_(false) : super.m_5888_(state);
    }
    
    @Nullable
    public BlockState m_5573_(final BlockPlaceContext context) {
        final FluidState fluidstate = context.m_43725_().m_6425_(context.m_8083_());
        final boolean flag = fluidstate.m_76152_() == Fluids.f_76193_;
        return (BlockState)super.m_5573_(context).m_61124_((Property)TrophyPedestalBlock.WATERLOGGED, (Comparable)flag);
    }
    
    public BlockState m_7417_(final BlockState stateIn, final Direction facing, final BlockState facingState, final LevelAccessor worldIn, final BlockPos currentPos, final BlockPos facingPos) {
        if (stateIn.m_61143_((Property)TrophyPedestalBlock.WATERLOGGED)) {
            worldIn.m_6217_().m_5945_(currentPos, (Object)Fluids.f_76193_, Fluids.f_76193_.m_6718_((LevelReader)worldIn));
        }
        return super.m_7417_(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_((StateDefinition.Builder)builder);
        builder.m_61104_(new Property[] { (Property)TrophyPedestalBlock.ACTIVE, (Property)TrophyPedestalBlock.WATERLOGGED });
    }
    
    @Deprecated
    public VoxelShape m_5940_(final BlockState state, final BlockGetter worldIn, final BlockPos pos, final CollisionContext context) {
        return TrophyPedestalBlock.FINAL;
    }
    
    @Deprecated
    public void m_6861_(final BlockState state, final Level world, final BlockPos pos, final Block blockIn, final BlockPos fromPos, final boolean isMoving) {
        world.m_46717_(pos, (Block)this);
        if (world.f_46443_ || (boolean)state.m_61143_((Property)TrophyPedestalBlock.ACTIVE) || !this.isTrophyOnTop(world, pos)) {
            return;
        }
        if (TFGenerationSettings.isProgressionEnforced(world)) {
            if (this.areNearbyPlayersEligible(world, pos)) {
                this.doPedestalEffect(world, pos, state);
            }
            this.warnIneligiblePlayers(world, pos);
        }
        else {
            this.doPedestalEffect(world, pos, state);
        }
        this.rewardNearbyPlayers(world, pos);
    }
    
    private boolean isTrophyOnTop(final Level world, final BlockPos pos) {
        return world.m_8055_(pos.m_7494_()).m_60620_((Tag)BlockTagGenerator.TROPHIES);
    }
    
    private void warnIneligiblePlayers(final Level world, final BlockPos pos) {
        for (final Player player : world.m_45976_((Class)Player.class, new AABB(pos).m_82400_(16.0))) {
            if (!this.isPlayerEligible(player)) {
                player.m_5661_((Component)new TranslatableComponent("twilightforest.trophy_pedestal.ineligible"), true);
            }
        }
    }
    
    private boolean areNearbyPlayersEligible(final Level world, final BlockPos pos) {
        for (final Player player : world.m_45976_((Class)Player.class, new AABB(pos).m_82400_(16.0))) {
            if (this.isPlayerEligible(player)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isPlayerEligible(final Player player) {
        return PlayerHelper.doesPlayerHaveRequiredAdvancements(player, TwilightForestMod.prefix("progress_lich"));
    }
    
    private void doPedestalEffect(final Level world, final BlockPos pos, final BlockState state) {
        world.m_46597_(pos, (BlockState)state.m_61124_((Property)TrophyPedestalBlock.ACTIVE, (Comparable)true));
        this.removeNearbyShields(world, pos);
        world.m_5594_((Player)null, pos, TFSounds.PEDESTAL_ACTIVATE, SoundSource.BLOCKS, 4.0f, 0.1f);
    }
    
    private void rewardNearbyPlayers(final Level world, final BlockPos pos) {
        for (final ServerPlayer player : world.m_45976_((Class)ServerPlayer.class, new AABB(pos).m_82400_(16.0))) {
            TFAdvancements.PLACED_TROPHY_ON_PEDESTAL.trigger(player);
            player.m_36220_(TFStats.TROPHY_PEDESTALS_ACTIVATED);
        }
    }
    
    private void removeNearbyShields(final Level world, final BlockPos pos) {
        for (int sx = -5; sx <= 5; ++sx) {
            for (int sy = -5; sy <= 5; ++sy) {
                for (int sz = -5; sz <= 5; ++sz) {
                    if (world.m_8055_(pos.m_142082_(sx, sy, sz)).m_60734_() == TFBlocks.STRONGHOLD_SHIELD.get()) {
                        world.m_46961_(pos.m_142082_(sx, sy, sz), false);
                    }
                }
            }
        }
    }
    
    public float m_5880_(final BlockState state, final Player player, final BlockGetter worldIn, final BlockPos pos) {
        return state.m_61143_((Property)TrophyPedestalBlock.ACTIVE) ? super.m_5880_(state, player, worldIn, pos) : -1.0f;
    }
    
    public boolean m_7278_(final BlockState state) {
        return true;
    }
    
    public int m_6782_(final BlockState blockState, final Level worldIn, final BlockPos pos) {
        final Block trophy = worldIn.m_8055_(pos.m_7494_()).m_60734_();
        if (trophy instanceof final TrophyBlock trophyBlock) {
            return trophyBlock.getComparatorValue();
        }
        return 0;
    }
    
    public PushReaction m_5537_(final BlockState state) {
        return state.m_61143_((Property)TrophyPedestalBlock.ACTIVE) ? PushReaction.NORMAL : PushReaction.BLOCK;
    }
    
    static {
        ACTIVE = BooleanProperty.m_61465_("active");
        WATERLOGGED = BlockStateProperties.f_61362_;
        BOTTOM = Block.m_49796_(1.0, 0.0, 1.0, 15.0, 3.0, 15.0);
        MID = Block.m_49796_(2.0, 3.0, 2.0, 14.0, 13.0, 14.0);
        TOP = Block.m_49796_(1.0, 13.0, 1.0, 15.0, 16.0, 15.0);
        CORNER1 = Block.m_49796_(1.0, 12.0, 1.0, 4.0, 13.0, 4.0);
        CORNER2 = Block.m_49796_(12.0, 12.0, 1.0, 15.0, 13.0, 4.0);
        CORNER3 = Block.m_49796_(1.0, 12.0, 12.0, 4.0, 13.0, 15.0);
        CORNER4 = Block.m_49796_(12.0, 12.0, 12.0, 15.0, 13.0, 15.0);
        FINAL = Shapes.m_83124_(TrophyPedestalBlock.BOTTOM, new VoxelShape[] { TrophyPedestalBlock.MID, TrophyPedestalBlock.TOP, TrophyPedestalBlock.CORNER1, TrophyPedestalBlock.CORNER2, TrophyPedestalBlock.CORNER3, TrophyPedestalBlock.CORNER4 });
    }
}
