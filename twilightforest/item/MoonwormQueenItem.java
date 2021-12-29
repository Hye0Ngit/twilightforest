// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.state.Property;
import java.util.Iterator;
import net.minecraft.state.StateContainer;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.BlockItem;
import javax.annotation.Nullable;
import net.minecraft.util.SoundEvent;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.player.ServerPlayerEntity;
import javax.annotation.Nonnull;
import net.minecraft.item.UseAction;
import twilightforest.TFSounds;
import net.minecraft.entity.EntityType;
import twilightforest.entity.projectile.MoonwormShotEntity;
import twilightforest.entity.TFEntities;
import net.minecraft.entity.LivingEntity;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.entity.Entity;
import net.minecraft.world.IWorldReader;
import net.minecraft.util.math.shapes.ISelectionContext;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.item.Item;

public class MoonwormQueenItem extends Item
{
    protected static final int FIRING_TIME = 12;
    
    protected MoonwormQueenItem(final Item.Properties props) {
        super(props);
    }
    
    public ActionResult<ItemStack> func_77659_a(final World world, final PlayerEntity player, final Hand hand) {
        final ItemStack stack = player.func_184586_b(hand);
        if (stack.func_77952_i() >= stack.func_77958_k() - 1) {
            return (ActionResult<ItemStack>)ActionResult.func_226251_d_((Object)stack);
        }
        player.func_184598_c(hand);
        return (ActionResult<ItemStack>)ActionResult.func_226248_a_((Object)player.func_184586_b(hand));
    }
    
    public ActionResultType func_195939_a(final ItemUseContext context) {
        final World worldIn = context.func_195991_k();
        BlockPos pos = context.func_195995_a();
        final BlockState iblockstate = worldIn.func_180495_p(pos);
        final PlayerEntity player = context.func_195999_j();
        final BlockItemUseContext blockItemUseContext = new BlockItemUseContext(context);
        if (!iblockstate.func_185904_a().func_76222_j()) {
            pos = pos.func_177972_a(context.func_196000_l());
        }
        final ItemStack itemstack = player.func_184586_b(context.func_221531_n());
        if (itemstack.func_77952_i() < itemstack.func_77958_k() && player.func_175151_a(pos, context.func_196000_l(), itemstack) && worldIn.func_226663_a_(((Block)TFBlocks.moonworm.get()).func_176223_P(), pos, ISelectionContext.func_216377_a())) {
            if (this.tryPlace(blockItemUseContext).func_226247_b_()) {
                final SoundType soundtype = worldIn.func_180495_p(pos).func_177230_c().getSoundType(worldIn.func_180495_p(pos), (IWorldReader)worldIn, pos, (Entity)player);
                worldIn.func_184133_a(player, pos, soundtype.func_185841_e(), SoundCategory.BLOCKS, (soundtype.func_185843_a() + 1.0f) / 2.0f, soundtype.func_185847_b() * 0.8f);
                player.func_184602_cy();
            }
            return ActionResultType.SUCCESS;
        }
        return ActionResultType.FAIL;
    }
    
    public void func_77615_a(final ItemStack stack, final World world, final LivingEntity living, final int useRemaining) {
        final int useTime = this.func_77626_a(stack) - useRemaining;
        if (!world.field_72995_K && useTime > 12 && stack.func_77952_i() + 1 < stack.func_77958_k()) {
            final boolean fired = world.func_217376_c((Entity)new MoonwormShotEntity(TFEntities.moonworm_shot, world, living));
            if (fired) {
                stack.func_222118_a(2, living, user -> user.func_213334_d(living.func_184600_cs()));
                world.func_184148_a((PlayerEntity)null, living.func_226277_ct_(), living.func_226278_cu_(), living.func_226281_cx_(), TFSounds.MOONWORM_SQUISH, (living instanceof PlayerEntity) ? SoundCategory.PLAYERS : SoundCategory.NEUTRAL, 1.0f, 1.0f);
            }
        }
    }
    
    @Nonnull
    public UseAction func_77661_b(final ItemStack stack) {
        return UseAction.BOW;
    }
    
    public int func_77626_a(final ItemStack stack) {
        return 72000;
    }
    
    public ActionResultType tryPlace(final BlockItemUseContext context) {
        if (!context.func_196011_b()) {
            return ActionResultType.FAIL;
        }
        final BlockItemUseContext blockitemusecontext = this.getBlockItemUseContext(context);
        if (blockitemusecontext == null) {
            return ActionResultType.FAIL;
        }
        final BlockState blockstate = this.getStateForPlacement(blockitemusecontext);
        if (blockstate == null) {
            return ActionResultType.FAIL;
        }
        if (!this.placeBlock(blockitemusecontext, blockstate)) {
            return ActionResultType.FAIL;
        }
        final BlockPos blockpos = blockitemusecontext.func_195995_a();
        final World world = blockitemusecontext.func_195991_k();
        final PlayerEntity playerentity = blockitemusecontext.func_195999_j();
        final ItemStack itemstack = blockitemusecontext.func_195996_i();
        BlockState blockstate2 = world.func_180495_p(blockpos);
        final Block block = blockstate2.func_177230_c();
        if (block == blockstate.func_177230_c()) {
            blockstate2 = this.func_219985_a(blockpos, world, itemstack, blockstate2);
            this.onBlockPlaced(blockpos, world, playerentity, itemstack);
            block.func_180633_a(world, blockpos, blockstate2, (LivingEntity)playerentity, itemstack);
            if (playerentity instanceof ServerPlayerEntity) {
                CriteriaTriggers.field_193137_x.func_193173_a((ServerPlayerEntity)playerentity, blockpos, itemstack);
            }
        }
        final SoundType soundtype = blockstate2.getSoundType((IWorldReader)world, blockpos, (Entity)context.func_195999_j());
        world.func_184133_a(playerentity, blockpos, this.getPlaceSound(blockstate2, world, blockpos, context.func_195999_j()), SoundCategory.BLOCKS, (soundtype.func_185843_a() + 1.0f) / 2.0f, soundtype.func_185847_b() * 0.8f);
        if (playerentity == null || !playerentity.field_71075_bZ.field_75098_d) {
            itemstack.func_222118_a(1, (LivingEntity)playerentity, user -> user.func_213334_d(playerentity.func_184600_cs()));
        }
        return ActionResultType.SUCCESS;
    }
    
    protected SoundEvent getPlaceSound(final BlockState state, final World world, final BlockPos pos, final PlayerEntity entity) {
        return state.getSoundType((IWorldReader)world, pos, (Entity)entity).func_185841_e();
    }
    
    @Nullable
    public BlockItemUseContext getBlockItemUseContext(final BlockItemUseContext context) {
        return context;
    }
    
    protected boolean onBlockPlaced(final BlockPos pos, final World worldIn, @Nullable final PlayerEntity player, final ItemStack stack) {
        return BlockItem.func_179224_a(worldIn, player, pos, stack);
    }
    
    @Nullable
    protected BlockState getStateForPlacement(final BlockItemUseContext context) {
        final BlockState blockstate = ((Block)TFBlocks.moonworm.get()).func_196258_a(context);
        return (blockstate != null && this.canPlace(context, blockstate)) ? blockstate : null;
    }
    
    protected boolean canPlace(final BlockItemUseContext p_195944_1_, final BlockState p_195944_2_) {
        final PlayerEntity playerentity = p_195944_1_.func_195999_j();
        final ISelectionContext iselectioncontext = (playerentity == null) ? ISelectionContext.func_216377_a() : ISelectionContext.func_216374_a((Entity)playerentity);
        return p_195944_2_.func_196955_c((IWorldReader)p_195944_1_.func_195991_k(), p_195944_1_.func_195995_a()) && p_195944_1_.func_195991_k().func_226663_a_(p_195944_2_, p_195944_1_.func_195995_a(), iselectioncontext);
    }
    
    private BlockState func_219985_a(final BlockPos p_219985_1_, final World p_219985_2_, final ItemStack p_219985_3_, final BlockState p_219985_4_) {
        BlockState blockstate = p_219985_4_;
        final CompoundNBT compoundnbt = p_219985_3_.func_77978_p();
        if (compoundnbt != null) {
            final CompoundNBT compoundnbt2 = compoundnbt.func_74775_l("BlockStateTag");
            final StateContainer<Block, BlockState> statecontainer = (StateContainer<Block, BlockState>)p_219985_4_.func_177230_c().func_176194_O();
            for (final String s : compoundnbt2.func_150296_c()) {
                final Property<?> property = (Property<?>)statecontainer.func_185920_a(s);
                if (property != null) {
                    final String s2 = compoundnbt2.func_74781_a(s).func_150285_a_();
                    blockstate = func_219988_a(blockstate, property, s2);
                }
            }
        }
        if (blockstate != p_219985_4_) {
            p_219985_2_.func_180501_a(p_219985_1_, blockstate, 2);
        }
        return blockstate;
    }
    
    private static <T extends Comparable<T>> BlockState func_219988_a(final BlockState p_219988_0_, final Property<T> p_219988_1_, final String p_219988_2_) {
        return p_219988_1_.func_185929_b(p_219988_2_).map(p_219986_2_ -> p_219988_0_.func_206870_a(p_219988_1_, p_219986_2_)).orElse(p_219988_0_);
    }
    
    protected boolean placeBlock(final BlockItemUseContext context, final BlockState state) {
        return context.func_195991_k().func_180501_a(context.func_195995_a(), state, 11);
    }
}
