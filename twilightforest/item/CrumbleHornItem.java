// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.advancements.TFAdvancements;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.world.IBlockReader;
import java.util.Iterator;
import net.minecraft.util.math.BlockPos;
import twilightforest.util.WorldUtil;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.item.UseAction;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ActionResultType;
import twilightforest.TFSounds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import java.util.function.Supplier;
import net.minecraft.block.Block;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Blocks;
import java.util.ArrayList;
import java.util.function.UnaryOperator;
import net.minecraft.block.BlockState;
import java.util.function.Predicate;
import org.apache.commons.lang3.tuple.Pair;
import java.util.List;
import net.minecraft.item.Item;

public class CrumbleHornItem extends Item
{
    private static final int CHANCE_HARVEST = 20;
    private static final int CHANCE_CRUMBLE = 5;
    private final List<Pair<Predicate<BlockState>, UnaryOperator<BlockState>>> crumbleTransforms;
    private final List<Predicate<BlockState>> harvestedStates;
    
    CrumbleHornItem(final Item.Properties props) {
        super(props);
        this.crumbleTransforms = new ArrayList<Pair<Predicate<BlockState>, UnaryOperator<BlockState>>>();
        this.harvestedStates = new ArrayList<Predicate<BlockState>>();
        this.addCrumbleTransforms();
    }
    
    private void addCrumbleTransforms() {
        this.addCrumble(() -> Blocks.field_196696_di, Blocks.field_196700_dk::func_176223_P);
        this.addCrumble(() -> Blocks.field_235411_nu_, Blocks.field_235412_nv_::func_176223_P);
        this.addCrumble(() -> Blocks.field_235412_nv_, Blocks.field_235406_np_::func_176223_P);
        this.addCrumble(() -> Blocks.field_196653_dH, Blocks.field_235394_nH_::func_176223_P);
        this.addCrumble((Supplier<Block>)TFBlocks.maze_stone_brick, () -> ((Block)TFBlocks.maze_stone_cracked.get()).func_176223_P());
        this.addCrumble((Supplier<Block>)TFBlocks.underbrick, () -> ((Block)TFBlocks.underbrick_cracked.get()).func_176223_P());
        this.addCrumble((Supplier<Block>)TFBlocks.tower_wood, () -> ((Block)TFBlocks.tower_wood_cracked.get()).func_176223_P());
        this.addCrumble((Supplier<Block>)TFBlocks.deadrock, () -> ((Block)TFBlocks.deadrock_cracked.get()).func_176223_P());
        this.addCrumble((Supplier<Block>)TFBlocks.castle_brick, () -> ((Block)TFBlocks.castle_brick_cracked.get()).func_176223_P());
        this.addCrumble((Supplier<Block>)TFBlocks.nagastone_pillar, () -> ((Block)TFBlocks.nagastone_pillar_weathered.get()).func_176223_P());
        this.addCrumble((Supplier<Block>)TFBlocks.etched_nagastone, () -> ((Block)TFBlocks.etched_nagastone_weathered.get()).func_176223_P());
        this.addCrumble(() -> Blocks.field_150348_b, Blocks.field_150347_e::func_176223_P);
        this.addCrumble(() -> Blocks.field_150347_e, Blocks.field_150351_n::func_176223_P);
        this.addCrumble(() -> Blocks.field_150322_A, Blocks.field_150354_m::func_176223_P);
        this.addCrumble(() -> Blocks.field_180395_cM, Blocks.field_196611_F::func_176223_P);
        this.addCrumble(() -> Blocks.field_196658_i, Blocks.field_150346_d::func_176223_P);
        this.addCrumble(() -> Blocks.field_150391_bh, Blocks.field_150346_d::func_176223_P);
        this.addCrumble(() -> Blocks.field_196661_l, Blocks.field_150346_d::func_176223_P);
        this.addCrumble(() -> Blocks.field_196660_k, Blocks.field_150346_d::func_176223_P);
        this.addCrumble(() -> Blocks.field_235381_mu_, Blocks.field_150424_aL::func_176223_P);
        this.addCrumble(() -> Blocks.field_235372_ml_, Blocks.field_150424_aL::func_176223_P);
        this.addCrumble(() -> Blocks.field_150371_ca, Blocks.field_150354_m::func_176223_P);
        this.addHarvest(() -> Blocks.field_150351_n);
        this.addHarvest(() -> Blocks.field_150346_d);
        this.addHarvest(() -> Blocks.field_150354_m);
        this.addHarvest(() -> Blocks.field_196611_F);
        this.addHarvest(() -> Blocks.field_150435_aG);
        this.addHarvest(() -> Blocks.field_196656_g);
        this.addHarvest(() -> Blocks.field_196650_c);
        this.addHarvest(() -> Blocks.field_196654_e);
    }
    
    private void addCrumble(final Supplier<Block> block, final Supplier<BlockState> result) {
        this.addCrumble(state -> state.func_177230_c() == block.get(), state -> result.get());
    }
    
    private void addCrumble(final Predicate<BlockState> test, final UnaryOperator<BlockState> transform) {
        this.crumbleTransforms.add((Pair<Predicate<BlockState>, UnaryOperator<BlockState>>)Pair.of((Object)test, (Object)transform));
    }
    
    private void addHarvest(final Supplier<Block> block) {
        this.addHarvest(state -> state.func_177230_c() == block.get());
    }
    
    private void addHarvest(final Predicate<BlockState> test) {
        this.harvestedStates.add(test);
    }
    
    public ActionResult<ItemStack> func_77659_a(final World world, final PlayerEntity player, final Hand hand) {
        player.func_184598_c(hand);
        player.func_184185_a(TFSounds.QUEST_RAM_AMBIENT, 1.0f, 0.8f);
        return (ActionResult<ItemStack>)new ActionResult(ActionResultType.SUCCESS, (Object)player.func_184586_b(hand));
    }
    
    public void onUsingTick(final ItemStack stack, final LivingEntity living, final int count) {
        if (count > 10 && count % 5 == 0 && !living.field_70170_p.field_72995_K) {
            final int crumbled = this.doCrumble(stack, living.field_70170_p, living);
            if (crumbled > 0) {
                stack.func_222118_a(crumbled, living, user -> user.func_213334_d(living.func_184600_cs()));
            }
            living.field_70170_p.func_184148_a((PlayerEntity)null, living.func_226277_ct_(), living.func_226278_cu_(), living.func_226281_cx_(), TFSounds.QUEST_RAM_AMBIENT, living.func_184176_by(), 1.0f, 0.8f);
        }
    }
    
    public UseAction func_77661_b(final ItemStack stack) {
        return UseAction.BOW;
    }
    
    public int func_77626_a(final ItemStack stack) {
        return 72000;
    }
    
    public boolean canContinueUsing(final ItemStack oldStack, final ItemStack newStack) {
        return oldStack.func_77973_b() == newStack.func_77973_b();
    }
    
    public boolean shouldCauseReequipAnimation(final ItemStack oldStack, final ItemStack newStack, final boolean slotChanged) {
        return slotChanged || newStack.func_77973_b() != oldStack.func_77973_b();
    }
    
    private int doCrumble(final ItemStack stack, final World world, final LivingEntity living) {
        final double range = 3.0;
        final double radius = 2.0;
        final Vector3d srcVec = new Vector3d(living.func_226277_ct_(), living.func_226278_cu_() + living.func_70047_e(), living.func_226281_cx_());
        final Vector3d lookVec = living.func_70040_Z().func_186678_a(3.0);
        final Vector3d destVec = srcVec.func_178787_e(lookVec);
        final AxisAlignedBB crumbleBox = new AxisAlignedBB(destVec.field_72450_a - 2.0, destVec.field_72448_b - 2.0, destVec.field_72449_c - 2.0, destVec.field_72450_a + 2.0, destVec.field_72448_b + 2.0, destVec.field_72449_c + 2.0);
        return this.crumbleBlocksInAABB(stack, world, living, crumbleBox);
    }
    
    private int crumbleBlocksInAABB(final ItemStack stack, final World world, final LivingEntity living, final AxisAlignedBB box) {
        int crumbled = 0;
        for (final BlockPos pos : WorldUtil.getAllInBB(box)) {
            if (this.crumbleBlock(stack, world, living, pos)) {
                ++crumbled;
            }
        }
        return crumbled;
    }
    
    private boolean crumbleBlock(final ItemStack stack, final World world, final LivingEntity living, final BlockPos pos) {
        final BlockState state = world.func_180495_p(pos);
        final Block block = state.func_177230_c();
        if (block.isAir(state, (IBlockReader)world, pos)) {
            return false;
        }
        if (living instanceof PlayerEntity && MinecraftForge.EVENT_BUS.post((Event)new BlockEvent.BreakEvent(world, pos, state, (PlayerEntity)living))) {
            return false;
        }
        for (final Pair<Predicate<BlockState>, UnaryOperator<BlockState>> transform : this.crumbleTransforms) {
            if (((Predicate)transform.getLeft()).test(state) && world.field_73012_v.nextInt(5) == 0) {
                world.func_180501_a(pos, (BlockState)((UnaryOperator)transform.getRight()).apply(state), 3);
                world.func_217379_c(2001, pos, Block.func_196246_j(state));
                this.postTrigger(living, stack, world, pos);
                return true;
            }
        }
        for (final Predicate<BlockState> predicate : this.harvestedStates) {
            if (predicate.test(state) && world.field_73012_v.nextInt(20) == 0) {
                if (living instanceof PlayerEntity) {
                    if (block.canHarvestBlock(state, (IBlockReader)world, pos, (PlayerEntity)living)) {
                        world.func_217377_a(pos, false);
                        block.func_180657_a(world, (PlayerEntity)living, pos, state, world.func_175625_s(pos), ItemStack.field_190927_a);
                        world.func_217379_c(2001, pos, Block.func_196246_j(state));
                        this.postTrigger(living, stack, world, pos);
                        return true;
                    }
                    continue;
                }
                else {
                    if (ForgeEventFactory.getMobGriefingEvent(world, (Entity)living)) {
                        world.func_175655_b(pos, true);
                        this.postTrigger(living, stack, world, pos);
                        return true;
                    }
                    continue;
                }
            }
        }
        return false;
    }
    
    private void postTrigger(final LivingEntity living, final ItemStack stack, final World world, final BlockPos pos) {
        if (living instanceof ServerPlayerEntity) {
            TFAdvancements.ITEM_USE_TRIGGER.trigger((ServerPlayerEntity)living, stack, world, pos);
        }
    }
}
