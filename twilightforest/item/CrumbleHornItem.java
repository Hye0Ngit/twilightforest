// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import java.util.ArrayList;
import net.minecraft.advancements.Advancement;
import net.minecraft.server.ServerAdvancementManager;
import net.minecraft.server.PlayerAdvancements;
import twilightforest.TwilightForestMod;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.world.level.BlockGetter;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.common.MinecraftForge;
import java.util.Iterator;
import twilightforest.util.TFStats;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;
import twilightforest.util.WorldUtil;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResult;
import twilightforest.TFSounds;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import java.util.function.Supplier;
import net.minecraft.world.level.block.Block;
import twilightforest.block.TFBlocks;
import java.util.Objects;
import net.minecraft.world.level.block.Blocks;
import java.util.function.UnaryOperator;
import net.minecraft.world.level.block.state.BlockState;
import java.util.function.Predicate;
import org.apache.commons.lang3.tuple.Pair;
import java.util.List;
import net.minecraft.world.item.Item;

public class CrumbleHornItem extends Item
{
    private static final int CHANCE_HARVEST = 20;
    private static final int CHANCE_CRUMBLE = 5;
    public static final List<Pair<Predicate<BlockState>, UnaryOperator<BlockState>>> crumbleTransforms;
    public static final List<Predicate<BlockState>> harvestedStates;
    
    CrumbleHornItem(final Item.Properties props) {
        super(props);
        this.addCrumbleTransforms();
    }
    
    public void addCrumbleTransforms() {
        final Supplier<Block> block = () -> Blocks.f_50222_;
        final Block f_50224_ = Blocks.f_50224_;
        Objects.requireNonNull(f_50224_);
        this.addCrumble(block, f_50224_::m_49966_);
        final Supplier<Block> block2 = () -> Blocks.f_50735_;
        final Block f_50736_ = Blocks.f_50736_;
        Objects.requireNonNull(f_50736_);
        this.addCrumble(block2, f_50736_::m_49966_);
        final Supplier<Block> block3 = () -> Blocks.f_50736_;
        final Block f_50730_ = Blocks.f_50730_;
        Objects.requireNonNull(f_50730_);
        this.addCrumble(block3, f_50730_::m_49966_);
        final Supplier<Block> block4 = () -> Blocks.f_50197_;
        final Block f_50713_ = Blocks.f_50713_;
        Objects.requireNonNull(f_50713_);
        this.addCrumble(block4, f_50713_::m_49966_);
        final Supplier<Block> block5 = () -> Blocks.f_152589_;
        final Block f_152594_ = Blocks.f_152594_;
        Objects.requireNonNull(f_152594_);
        this.addCrumble(block5, f_152594_::m_49966_);
        final Supplier<Block> block6 = () -> Blocks.f_152559_;
        final Block f_152595_ = Blocks.f_152595_;
        Objects.requireNonNull(f_152595_);
        this.addCrumble(block6, f_152595_::m_49966_);
        this.addCrumble((Supplier<Block>)TFBlocks.MAZESTONE_BRICK, () -> ((Block)TFBlocks.CRACKED_MAZESTONE.get()).m_49966_());
        this.addCrumble((Supplier<Block>)TFBlocks.UNDERBRICK, () -> ((Block)TFBlocks.CRACKED_UNDERBRICK.get()).m_49966_());
        this.addCrumble((Supplier<Block>)TFBlocks.TOWERWOOD, () -> ((Block)TFBlocks.CRACKED_TOWERWOOD.get()).m_49966_());
        this.addCrumble((Supplier<Block>)TFBlocks.DEADROCK, () -> ((Block)TFBlocks.CRACKED_DEADROCK.get()).m_49966_());
        this.addCrumble((Supplier<Block>)TFBlocks.CASTLE_BRICK, () -> ((Block)TFBlocks.CRACKED_CASTLE_BRICK.get()).m_49966_());
        this.addCrumble((Supplier<Block>)TFBlocks.NAGASTONE_PILLAR, () -> ((Block)TFBlocks.CRACKED_NAGASTONE_PILLAR.get()).m_49966_());
        this.addCrumble((Supplier<Block>)TFBlocks.ETCHED_NAGASTONE, () -> ((Block)TFBlocks.CRACKED_ETCHED_NAGASTONE.get()).m_49966_());
        final Supplier<Block> block7 = () -> Blocks.f_50069_;
        final Block f_50652_ = Blocks.f_50652_;
        Objects.requireNonNull(f_50652_);
        this.addCrumble(block7, f_50652_::m_49966_);
        final Supplier<Block> block8 = () -> Blocks.f_50652_;
        final Block f_49994_ = Blocks.f_49994_;
        Objects.requireNonNull(f_49994_);
        this.addCrumble(block8, f_49994_::m_49966_);
        final Supplier<Block> block9 = () -> Blocks.f_50062_;
        final Block f_49992_ = Blocks.f_49992_;
        Objects.requireNonNull(f_49992_);
        this.addCrumble(block9, f_49992_::m_49966_);
        final Supplier<Block> block10 = () -> Blocks.f_50394_;
        final Block f_49993_ = Blocks.f_49993_;
        Objects.requireNonNull(f_49993_);
        this.addCrumble(block10, f_49993_::m_49966_);
        final Supplier<Block> block11 = () -> Blocks.f_50440_;
        final Block f_50493_ = Blocks.f_50493_;
        Objects.requireNonNull(f_50493_);
        this.addCrumble(block11, f_50493_::m_49966_);
        final Supplier<Block> block12 = () -> Blocks.f_50195_;
        final Block f_50493_2 = Blocks.f_50493_;
        Objects.requireNonNull(f_50493_2);
        this.addCrumble(block12, f_50493_2::m_49966_);
        final Supplier<Block> block13 = () -> Blocks.f_50599_;
        final Block f_50493_3 = Blocks.f_50493_;
        Objects.requireNonNull(f_50493_3);
        this.addCrumble(block13, f_50493_3::m_49966_);
        final Supplier<Block> block14 = () -> Blocks.f_50546_;
        final Block f_50493_4 = Blocks.f_50493_;
        Objects.requireNonNull(f_50493_4);
        this.addCrumble(block14, f_50493_4::m_49966_);
        final Supplier<Block> block15 = () -> Blocks.f_50699_;
        final Block f_50134_ = Blocks.f_50134_;
        Objects.requireNonNull(f_50134_);
        this.addCrumble(block15, f_50134_::m_49966_);
        final Supplier<Block> block16 = () -> Blocks.f_50690_;
        final Block f_50134_2 = Blocks.f_50134_;
        Objects.requireNonNull(f_50134_2);
        this.addCrumble(block16, f_50134_2::m_49966_);
        final Supplier<Block> block17 = () -> Blocks.f_50333_;
        final Block f_49992_2 = Blocks.f_49992_;
        Objects.requireNonNull(f_49992_2);
        this.addCrumble(block17, f_49992_2::m_49966_);
        final Supplier<Block> block18 = () -> Blocks.f_152549_;
        final Block f_50493_5 = Blocks.f_50493_;
        Objects.requireNonNull(f_50493_5);
        this.addCrumble(block18, f_50493_5::m_49966_);
        this.addCopperCrumble(() -> Blocks.f_152501_, () -> Blocks.f_152502_, () -> Blocks.f_152503_, () -> Blocks.f_152504_);
        this.addCopperCrumble(() -> Blocks.f_152507_, () -> Blocks.f_152508_, () -> Blocks.f_152509_, () -> Blocks.f_152510_);
        this.addHarvest(() -> Blocks.f_49994_);
        this.addHarvest(() -> Blocks.f_50493_);
        this.addHarvest(() -> Blocks.f_49992_);
        this.addHarvest(() -> Blocks.f_49993_);
        this.addHarvest(() -> Blocks.f_50129_);
        this.addHarvest(() -> Blocks.f_50334_);
        this.addHarvest(() -> Blocks.f_50122_);
        this.addHarvest(() -> Blocks.f_50228_);
    }
    
    private void addCopperCrumble(final Supplier<Block> oxidized, final Supplier<Block> weathered, final Supplier<Block> exposed, final Supplier<Block> normal) {
        this.addCrumble(state -> state.m_60713_((Block)oxidized.get()), state -> weathered.get().m_49966_());
        this.addCrumble(state -> state.m_60713_((Block)weathered.get()), state -> exposed.get().m_49966_());
        this.addCrumble(state -> state.m_60713_((Block)exposed.get()), state -> normal.get().m_49966_());
    }
    
    private void addCrumble(final Supplier<Block> block, final Supplier<BlockState> result) {
        this.addCrumble(state -> state.m_60734_() == block.get(), state -> result.get());
    }
    
    private void addCrumble(final Predicate<BlockState> test, final UnaryOperator<BlockState> transform) {
        CrumbleHornItem.crumbleTransforms.add((Pair<Predicate<BlockState>, UnaryOperator<BlockState>>)Pair.of((Object)test, (Object)transform));
    }
    
    private void addHarvest(final Supplier<Block> block) {
        this.addHarvest(state -> state.m_60734_() == block.get());
    }
    
    private void addHarvest(final Predicate<BlockState> test) {
        CrumbleHornItem.harvestedStates.add(test);
    }
    
    public InteractionResultHolder<ItemStack> m_7203_(final Level world, final Player player, final InteractionHand hand) {
        player.m_6672_(hand);
        player.m_5496_(TFSounds.QUEST_RAM_AMBIENT, 1.0f, 0.8f);
        return (InteractionResultHolder<ItemStack>)new InteractionResultHolder(InteractionResult.SUCCESS, (Object)player.m_21120_(hand));
    }
    
    public void onUsingTick(final ItemStack stack, final LivingEntity living, final int count) {
        if (count > 10 && count % 5 == 0 && !living.f_19853_.f_46443_) {
            final int crumbled = this.doCrumble(living.f_19853_, living);
            if (crumbled > 0) {
                stack.m_41622_(crumbled, living, user -> user.m_21190_(living.m_7655_()));
            }
            living.f_19853_.m_6263_((Player)null, living.m_20185_(), living.m_20186_(), living.m_20189_(), TFSounds.QUEST_RAM_AMBIENT, living.m_5720_(), 1.0f, 0.8f);
        }
    }
    
    public UseAnim m_6164_(final ItemStack stack) {
        return UseAnim.BOW;
    }
    
    public int m_8105_(final ItemStack stack) {
        return 72000;
    }
    
    public boolean canContinueUsing(final ItemStack oldStack, final ItemStack newStack) {
        return oldStack.m_41720_() == newStack.m_41720_();
    }
    
    public boolean shouldCauseReequipAnimation(final ItemStack oldStack, final ItemStack newStack, final boolean slotChanged) {
        return slotChanged || newStack.m_41720_() != oldStack.m_41720_();
    }
    
    private int doCrumble(final Level world, final LivingEntity living) {
        final double range = 3.0;
        final double radius = 2.0;
        final Vec3 srcVec = new Vec3(living.m_20185_(), living.m_20186_() + living.m_20192_(), living.m_20189_());
        final Vec3 lookVec = living.m_20154_().m_82490_(3.0);
        final Vec3 destVec = srcVec.m_82549_(lookVec);
        final AABB crumbleBox = new AABB(destVec.f_82479_ - 2.0, destVec.f_82480_ - 2.0, destVec.f_82481_ - 2.0, destVec.f_82479_ + 2.0, destVec.f_82480_ + 2.0, destVec.f_82481_ + 2.0);
        return this.crumbleBlocksInAABB(world, living, crumbleBox);
    }
    
    private int crumbleBlocksInAABB(final Level world, final LivingEntity living, final AABB box) {
        int crumbled = 0;
        for (final BlockPos pos : WorldUtil.getAllInBB(box)) {
            if (this.crumbleBlock(world, living, pos)) {
                ++crumbled;
                if (!(living instanceof Player)) {
                    continue;
                }
                final Player player = (Player)living;
                if (!(player instanceof ServerPlayer)) {
                    continue;
                }
                player.m_36220_(TFStats.BLOCKS_CRUMBLED);
            }
        }
        return crumbled;
    }
    
    private boolean crumbleBlock(final Level world, final LivingEntity living, final BlockPos pos) {
        final BlockState state = world.m_8055_(pos);
        final Block block = state.m_60734_();
        if (state.m_60795_()) {
            return false;
        }
        if (living instanceof Player && MinecraftForge.EVENT_BUS.post((Event)new BlockEvent.BreakEvent(world, pos, state, (Player)living))) {
            return false;
        }
        for (final Pair<Predicate<BlockState>, UnaryOperator<BlockState>> transform : CrumbleHornItem.crumbleTransforms) {
            if (((Predicate)transform.getLeft()).test(state) && world.f_46441_.nextInt(5) == 0) {
                world.m_7731_(pos, (BlockState)((UnaryOperator)transform.getRight()).apply(state), 3);
                world.m_46796_(2001, pos, Block.m_49956_(state));
                this.postTrigger(living);
                return true;
            }
        }
        for (final Predicate<BlockState> predicate : CrumbleHornItem.harvestedStates) {
            if (predicate.test(state) && world.f_46441_.nextInt(20) == 0) {
                if (living instanceof final Player player) {
                    if (block.canHarvestBlock(state, (BlockGetter)world, pos, player)) {
                        world.m_7471_(pos, false);
                        block.m_6240_(world, player, pos, state, world.m_7702_(pos), ItemStack.f_41583_);
                        world.m_46796_(2001, pos, Block.m_49956_(state));
                        this.postTrigger(living);
                        return true;
                    }
                    continue;
                }
                else {
                    if (ForgeEventFactory.getMobGriefingEvent(world, (Entity)living)) {
                        world.m_46961_(pos, true);
                        this.postTrigger(living);
                        return true;
                    }
                    continue;
                }
            }
        }
        return false;
    }
    
    private void postTrigger(final LivingEntity living) {
        if (living instanceof ServerPlayer) {
            final Player player = (Player)living;
            player.m_36246_(Stats.f_12982_.m_12902_((Object)this));
            final PlayerAdvancements advancements = ((ServerPlayer)player).m_8960_();
            final ServerAdvancementManager manager = ((ServerLevel)player.m_20193_()).m_142572_().m_129889_();
            final Advancement advancement = manager.m_136041_(TwilightForestMod.prefix("alt/treasures/crumble_horn_used"));
            if (advancement != null) {
                advancements.m_135988_(advancement, "used");
            }
        }
    }
    
    static {
        crumbleTransforms = new ArrayList<Pair<Predicate<BlockState>, UnaryOperator<BlockState>>>();
        harvestedStates = new ArrayList<Predicate<BlockState>>();
    }
}
