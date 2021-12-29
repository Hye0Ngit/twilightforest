// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelReader;
import java.util.Random;
import net.minecraft.world.item.Item;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import twilightforest.util.TFStats;
import net.minecraft.advancements.Advancement;
import net.minecraft.server.ServerAdvancementManager;
import net.minecraft.server.PlayerAdvancements;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import twilightforest.TwilightForestMod;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.item.Items;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import twilightforest.item.TFItems;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.Block;

public class Experiment115Block extends Block
{
    public static final IntegerProperty BITES_TAKEN;
    public static final BooleanProperty REGENERATE;
    private static final VoxelShape QUARTER_SHAPE;
    private static final VoxelShape HALF_SHAPE;
    private static final VoxelShape THREE_QUARTER_SHAPE;
    private static final VoxelShape FULL_SHAPE;
    
    public Experiment115Block() {
        super(BlockBehaviour.Properties.m_60944_(Material.f_76287_, MaterialColor.f_76404_).m_60978_(0.5f).m_60918_(SoundType.f_56745_).m_60977_());
        this.m_49959_((BlockState)((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_((Property)Experiment115Block.BITES_TAKEN, (Comparable)7)).m_61124_((Property)Experiment115Block.REGENERATE, (Comparable)false));
    }
    
    @Deprecated
    public VoxelShape m_5940_(final BlockState state, final BlockGetter worldIn, final BlockPos pos, final CollisionContext context) {
        return switch ((int)state.m_61143_((Property)Experiment115Block.BITES_TAKEN)) {
            default -> Experiment115Block.FULL_SHAPE;
            case 2,  3 -> Experiment115Block.THREE_QUARTER_SHAPE;
            case 4,  5 -> Experiment115Block.HALF_SHAPE;
            case 6,  7 -> Experiment115Block.QUARTER_SHAPE;
        };
    }
    
    @Deprecated
    public InteractionResult m_6227_(final BlockState state, final Level worldIn, final BlockPos pos, final Player player, final InteractionHand hand, final BlockHitResult hit) {
        final int bitesTaken = (int)state.m_61143_((Property)Experiment115Block.BITES_TAKEN);
        final ItemStack stack = player.m_21120_(hand);
        if (!player.m_6144_()) {
            if (bitesTaken > 0 && stack.m_41720_() == TFItems.EXPERIMENT_115.get()) {
                worldIn.m_46597_(pos, (BlockState)state.m_61124_((Property)Experiment115Block.BITES_TAKEN, (Comparable)(bitesTaken - 1)));
                if (!player.m_7500_()) {
                    stack.m_41774_(1);
                }
                if (player instanceof final ServerPlayer serverPlayer) {
                    CriteriaTriggers.f_10591_.m_59469_(serverPlayer, pos, stack);
                }
                return InteractionResult.SUCCESS;
            }
            if (!(boolean)state.m_61143_((Property)Experiment115Block.REGENERATE) && stack.m_41720_() == Items.f_42451_ && (player.m_7500_() || bitesTaken == 0)) {
                worldIn.m_46597_(pos, (BlockState)state.m_61124_((Property)Experiment115Block.REGENERATE, (Comparable)true));
                if (!player.m_7500_()) {
                    stack.m_41774_(1);
                }
                if (player instanceof ServerPlayer) {
                    player.m_36246_(Stats.f_12982_.m_12902_((Object)Items.f_42451_));
                    final PlayerAdvancements advancements = ((ServerPlayer)player).m_8960_();
                    final ServerAdvancementManager manager = ((ServerLevel)player.m_20193_()).m_142572_().m_129889_();
                    final Advancement advancement = manager.m_136041_(TwilightForestMod.prefix("experiment_115_self_replenishing"));
                    if (advancement != null) {
                        advancements.m_135988_(advancement, "place_complete_e115");
                    }
                }
                return InteractionResult.SUCCESS;
            }
        }
        else if (!(boolean)state.m_61143_((Property)Experiment115Block.REGENERATE) && player.m_21211_().m_41619_()) {
            if (bitesTaken < 7) {
                worldIn.m_46597_(pos, (BlockState)state.m_61124_((Property)Experiment115Block.BITES_TAKEN, (Comparable)(bitesTaken + 1)));
            }
            else {
                worldIn.m_7471_(pos, false);
            }
            if (!player.m_7500_()) {
                ItemHandlerHelper.giveItemToPlayer(player, new ItemStack((ItemLike)TFItems.EXPERIMENT_115.get()));
            }
            return InteractionResult.SUCCESS;
        }
        return this.eatCake(worldIn, pos, state, player);
    }
    
    private InteractionResult eatCake(final Level world, final BlockPos pos, final BlockState state, final Player player) {
        if (!player.m_36391_(false)) {
            return InteractionResult.PASS;
        }
        player.m_36220_(TFStats.E115_SLICES_EATEN);
        player.m_36324_().m_38707_(4, 0.3f);
        world.m_5594_((Player)null, pos, SoundEvents.f_11912_, SoundSource.PLAYERS, 0.5f, world.f_46441_.nextFloat() * 0.1f + 0.9f);
        final int i = (int)state.m_61143_((Property)Experiment115Block.BITES_TAKEN);
        if (i < 7) {
            world.m_7731_(pos, (BlockState)state.m_61124_((Property)Experiment115Block.BITES_TAKEN, (Comparable)(i + 1)), 3);
        }
        else {
            world.m_7471_(pos, false);
        }
        if (player instanceof final ServerPlayer serverPlayer) {
            CriteriaTriggers.f_10592_.m_23682_(serverPlayer, new ItemStack((ItemLike)TFItems.EXPERIMENT_115.get(), 8 - i));
            player.m_36246_(Stats.f_12982_.m_12902_((Object)TFItems.EXPERIMENT_115.get()));
        }
        return InteractionResult.SUCCESS;
    }
    
    @Deprecated
    public void m_7455_(final BlockState state, final ServerLevel worldIn, final BlockPos pos, final Random random) {
        if ((boolean)state.m_61143_((Property)Experiment115Block.REGENERATE) && (int)state.m_61143_((Property)Experiment115Block.BITES_TAKEN) != 0) {
            worldIn.m_46597_(pos, (BlockState)state.m_61124_((Property)Experiment115Block.BITES_TAKEN, (Comparable)((int)state.m_61143_((Property)Experiment115Block.BITES_TAKEN) - 1)));
        }
    }
    
    @Deprecated
    public boolean m_7898_(final BlockState state, final LevelReader worldIn, final BlockPos pos) {
        return worldIn.m_8055_(pos.m_7495_()).m_60767_().m_76333_();
    }
    
    @Deprecated
    public BlockState m_7417_(final BlockState stateIn, final Direction facing, final BlockState facingState, final LevelAccessor worldIn, final BlockPos currentPos, final BlockPos facingPos) {
        return (facing == Direction.DOWN && !stateIn.m_60710_((LevelReader)worldIn, currentPos)) ? Blocks.f_50016_.m_49966_() : super.m_7417_(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_((StateDefinition.Builder)builder);
        builder.m_61104_(new Property[] { (Property)Experiment115Block.BITES_TAKEN, (Property)Experiment115Block.REGENERATE });
    }
    
    @Deprecated
    public int m_6782_(final BlockState state, final Level world, final BlockPos pos) {
        return 15 - (int)state.m_61143_((Property)Experiment115Block.BITES_TAKEN) * 2;
    }
    
    @Deprecated
    public boolean m_7278_(final BlockState state) {
        return true;
    }
    
    @Deprecated
    public boolean m_7899_(final BlockState state) {
        return (boolean)state.m_61143_((Property)Experiment115Block.REGENERATE);
    }
    
    @Deprecated
    public int m_6378_(final BlockState state, final BlockGetter blockAccess, final BlockPos pos, final Direction side) {
        return state.m_61143_((Property)Experiment115Block.REGENERATE) ? (15 - (int)state.m_61143_((Property)Experiment115Block.BITES_TAKEN) * 2) : 0;
    }
    
    static {
        BITES_TAKEN = IntegerProperty.m_61631_("omnomnom", 0, 7);
        REGENERATE = BooleanProperty.m_61465_("regenerate");
        QUARTER_SHAPE = m_49796_(1.0, 0.0, 1.0, 8.0, 8.0, 8.0);
        HALF_SHAPE = m_49796_(1.0, 0.0, 1.0, 8.0, 8.0, 15.0);
        THREE_QUARTER_SHAPE = Shapes.m_83113_(Experiment115Block.HALF_SHAPE, m_49796_(8.0, 0.0, 8.0, 15.0, 8.0, 15.0), BooleanOp.f_82695_);
        FULL_SHAPE = m_49796_(1.0, 0.0, 1.0, 15.0, 8.0, 15.0);
    }
}
