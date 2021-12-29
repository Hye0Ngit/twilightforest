// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.world.level.block.state.properties.Property;
import java.util.Iterator;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.BlockItem;
import javax.annotation.Nullable;
import net.minecraft.sounds.SoundEvent;
import java.util.Objects;
import net.minecraft.advancements.CriteriaTriggers;
import javax.annotation.Nonnull;
import net.minecraft.world.item.UseAnim;
import twilightforest.TFSounds;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import twilightforest.entity.projectile.MoonwormShot;
import twilightforest.entity.TFEntities;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.phys.shapes.CollisionContext;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class MoonwormQueenItem extends Item
{
    protected static final int FIRING_TIME = 12;
    
    protected MoonwormQueenItem(final Item.Properties props) {
        super(props);
    }
    
    public boolean m_8120_(final ItemStack pStack) {
        return false;
    }
    
    public boolean isBookEnchantable(final ItemStack stack, final ItemStack book) {
        return false;
    }
    
    public boolean canApplyAtEnchantingTable(final ItemStack stack, final Enchantment enchantment) {
        return false;
    }
    
    public InteractionResultHolder<ItemStack> m_7203_(final Level world, final Player player, final InteractionHand hand) {
        final ItemStack stack = player.m_21120_(hand);
        if (stack.m_41773_() + 1 >= this.getMaxDamage(stack)) {
            return (InteractionResultHolder<ItemStack>)InteractionResultHolder.m_19100_((Object)stack);
        }
        player.m_6672_(hand);
        return (InteractionResultHolder<ItemStack>)InteractionResultHolder.m_19090_((Object)player.m_21120_(hand));
    }
    
    public InteractionResult m_6225_(final UseOnContext context) {
        final Level worldIn = context.m_43725_();
        BlockPos pos = context.m_8083_();
        final BlockState iblockstate = worldIn.m_8055_(pos);
        final Player player = context.m_43723_();
        final BlockPlaceContext blockItemUseContext = new BlockPlaceContext(context);
        if (!iblockstate.m_60767_().m_76336_()) {
            pos = pos.m_142300_(context.m_43719_());
        }
        final ItemStack itemstack = player.m_21120_(context.m_43724_());
        if (itemstack.m_41773_() < itemstack.m_41776_() && player.m_36204_(pos, context.m_43719_(), itemstack) && worldIn.m_45752_(((Block)TFBlocks.MOONWORM.get()).m_49966_(), pos, CollisionContext.m_82749_())) {
            if (this.tryPlace(blockItemUseContext).m_19080_()) {
                final SoundType soundtype = worldIn.m_8055_(pos).m_60734_().getSoundType(worldIn.m_8055_(pos), (LevelReader)worldIn, pos, (Entity)player);
                worldIn.m_5594_(player, pos, soundtype.m_56777_(), SoundSource.BLOCKS, (soundtype.m_56773_() + 1.0f) / 2.0f, soundtype.m_56774_() * 0.8f);
                player.m_5810_();
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }
    
    public void m_5551_(final ItemStack stack, final Level world, final LivingEntity living, final int useRemaining) {
        final int useTime = this.m_8105_(stack) - useRemaining;
        if (!world.f_46443_ && useTime > 12 && stack.m_41773_() + 1 < stack.m_41776_()) {
            final boolean fired = world.m_7967_((Entity)new MoonwormShot(TFEntities.MOONWORM_SHOT, world, living));
            if (fired) {
                stack.m_41629_(2, world.f_46441_, (ServerPlayer)null);
                world.m_6263_((Player)null, living.m_20185_(), living.m_20186_(), living.m_20189_(), TFSounds.MOONWORM_SQUISH, (living instanceof Player) ? SoundSource.PLAYERS : SoundSource.NEUTRAL, 1.0f, 1.0f);
            }
        }
    }
    
    @Nonnull
    public UseAnim m_6164_(final ItemStack stack) {
        return UseAnim.BOW;
    }
    
    public int m_8105_(final ItemStack stack) {
        return 72000;
    }
    
    public InteractionResult tryPlace(final BlockPlaceContext context) {
        if (!context.m_7059_()) {
            return InteractionResult.FAIL;
        }
        final BlockPlaceContext blockitemusecontext = this.getBlockItemUseContext(context);
        if (blockitemusecontext == null) {
            return InteractionResult.FAIL;
        }
        final BlockState blockstate = this.getStateForPlacement(blockitemusecontext);
        if (blockstate == null) {
            return InteractionResult.FAIL;
        }
        if (!this.placeBlock(blockitemusecontext, blockstate)) {
            return InteractionResult.FAIL;
        }
        final BlockPos blockpos = blockitemusecontext.m_8083_();
        final Level world = blockitemusecontext.m_43725_();
        final Player playerentity = blockitemusecontext.m_43723_();
        final ItemStack itemstack = blockitemusecontext.m_43722_();
        BlockState blockstate2 = world.m_8055_(blockpos);
        final Block block = blockstate2.m_60734_();
        if (block == blockstate.m_60734_()) {
            blockstate2 = this.updateBlockStateFromTag(blockpos, world, itemstack, blockstate2);
            this.onBlockPlaced(blockpos, world, playerentity, itemstack);
            block.m_6402_(world, blockpos, blockstate2, (LivingEntity)playerentity, itemstack);
            if (playerentity instanceof final ServerPlayer serverPlayer) {
                CriteriaTriggers.f_10591_.m_59469_(serverPlayer, blockpos, itemstack);
            }
        }
        final SoundType soundtype = blockstate2.getSoundType((LevelReader)world, blockpos, (Entity)context.m_43723_());
        world.m_5594_(playerentity, blockpos, this.getPlaceSound(blockstate2, world, blockpos, Objects.requireNonNull(context.m_43723_())), SoundSource.BLOCKS, (soundtype.m_56773_() + 1.0f) / 2.0f, soundtype.m_56774_() * 0.8f);
        if (playerentity == null || !playerentity.m_150110_().f_35937_) {
            itemstack.m_41629_(1, world.f_46441_, (ServerPlayer)null);
        }
        return InteractionResult.SUCCESS;
    }
    
    protected SoundEvent getPlaceSound(final BlockState state, final Level world, final BlockPos pos, final Player entity) {
        return state.getSoundType((LevelReader)world, pos, (Entity)entity).m_56777_();
    }
    
    @Nullable
    public BlockPlaceContext getBlockItemUseContext(final BlockPlaceContext context) {
        return context;
    }
    
    protected boolean onBlockPlaced(final BlockPos pos, final Level worldIn, @Nullable final Player player, final ItemStack stack) {
        return BlockItem.m_40582_(worldIn, player, pos, stack);
    }
    
    @Nullable
    protected BlockState getStateForPlacement(final BlockPlaceContext context) {
        final BlockState blockstate = ((Block)TFBlocks.MOONWORM.get()).m_5573_(context);
        return (blockstate != null && this.canPlace(context, blockstate)) ? blockstate : null;
    }
    
    protected boolean canPlace(final BlockPlaceContext p_195944_1_, final BlockState p_195944_2_) {
        final Player playerentity = p_195944_1_.m_43723_();
        final CollisionContext iselectioncontext = (playerentity == null) ? CollisionContext.m_82749_() : CollisionContext.m_82750_((Entity)playerentity);
        return p_195944_2_.m_60710_((LevelReader)p_195944_1_.m_43725_(), p_195944_1_.m_8083_()) && p_195944_1_.m_43725_().m_45752_(p_195944_2_, p_195944_1_.m_8083_(), iselectioncontext);
    }
    
    private BlockState updateBlockStateFromTag(final BlockPos p_219985_1_, final Level p_219985_2_, final ItemStack p_219985_3_, final BlockState p_219985_4_) {
        BlockState blockstate = p_219985_4_;
        final CompoundTag compoundnbt = p_219985_3_.m_41783_();
        if (compoundnbt != null) {
            final CompoundTag compoundnbt2 = compoundnbt.m_128469_("BlockStateTag");
            final StateDefinition<Block, BlockState> statecontainer = (StateDefinition<Block, BlockState>)p_219985_4_.m_60734_().m_49965_();
            for (final String s : compoundnbt2.m_128431_()) {
                final Property<?> property = (Property<?>)statecontainer.m_61081_(s);
                if (property != null) {
                    final String s2 = compoundnbt2.m_128423_(s).m_7916_();
                    blockstate = updateState(blockstate, property, s2);
                }
            }
        }
        if (blockstate != p_219985_4_) {
            p_219985_2_.m_7731_(p_219985_1_, blockstate, 2);
        }
        return blockstate;
    }
    
    private static <T extends Comparable<T>> BlockState updateState(final BlockState p_219988_0_, final Property<T> p_219988_1_, final String p_219988_2_) {
        return p_219988_1_.m_6215_(p_219988_2_).map(p_219986_2_ -> p_219988_0_.m_61124_(p_219988_1_, p_219986_2_)).orElse(p_219988_0_);
    }
    
    protected boolean placeBlock(final BlockPlaceContext context, final BlockState state) {
        return context.m_43725_().m_7731_(context.m_8083_(), state, 11);
    }
}
