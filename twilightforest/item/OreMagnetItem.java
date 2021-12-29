// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraft.tags.Tag;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import net.minecraft.resources.ResourceLocation;
import java.util.function.Function;
import net.minecraftforge.registries.ForgeRegistryEntry;
import java.util.Collection;
import net.minecraftforge.common.Tags;
import net.minecraft.tags.BlockTags;
import twilightforest.TwilightForestMod;
import net.minecraft.core.Direction;
import twilightforest.data.BlockTagGenerator;
import net.minecraft.util.Mth;
import java.util.Set;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.AirBlock;
import java.util.HashSet;
import twilightforest.util.VoxelBresenhamIterator;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.item.UseAnim;
import twilightforest.TFSounds;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import javax.annotation.Nonnull;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import java.util.HashMap;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.item.Item;

@Mod.EventBusSubscriber(modid = "twilightforest")
public class OreMagnetItem extends Item
{
    private static final float WIGGLE = 10.0f;
    private static boolean cacheNeedsBuild;
    private static final HashMap<Block, Block> ORE_TO_BLOCK_REPLACEMENTS;
    
    protected OreMagnetItem(final Item.Properties props) {
        super(props);
    }
    
    public boolean m_8120_(final ItemStack pStack) {
        return false;
    }
    
    public boolean isBookEnchantable(final ItemStack stack, final ItemStack book) {
        final Map<Enchantment, Integer> enchants = EnchantmentHelper.m_44831_(book);
        for (final Enchantment ench : enchants.keySet()) {
            if (Objects.equals(ench.getRegistryName(), Enchantments.f_44986_.getRegistryName())) {
                return super.isBookEnchantable(stack, book);
            }
        }
        return false;
    }
    
    public boolean canApplyAtEnchantingTable(final ItemStack stack, final Enchantment enchantment) {
        return false;
    }
    
    @Nonnull
    public InteractionResultHolder<ItemStack> m_7203_(final Level world, final Player player, @Nonnull final InteractionHand hand) {
        player.m_6672_(hand);
        return (InteractionResultHolder<ItemStack>)new InteractionResultHolder(InteractionResult.SUCCESS, (Object)player.m_21120_(hand));
    }
    
    public void m_5551_(final ItemStack stack, final Level world, final LivingEntity living, final int useRemaining) {
        final int useTime = this.m_8105_(stack) - useRemaining;
        if (!world.f_46443_ && useTime > 10) {
            int moved = this.doMagnet(world, living, 0.0f, 0.0f);
            if (moved == 0) {
                moved = this.doMagnet(world, living, 10.0f, 0.0f);
            }
            if (moved == 0) {
                moved = this.doMagnet(world, living, 10.0f, 10.0f);
            }
            if (moved == 0) {
                moved = this.doMagnet(world, living, 0.0f, 10.0f);
            }
            if (moved == 0) {
                moved = this.doMagnet(world, living, -10.0f, 10.0f);
            }
            if (moved == 0) {
                moved = this.doMagnet(world, living, -10.0f, 0.0f);
            }
            if (moved == 0) {
                moved = this.doMagnet(world, living, -10.0f, -10.0f);
            }
            if (moved == 0) {
                moved = this.doMagnet(world, living, 0.0f, -10.0f);
            }
            if (moved == 0) {
                moved = this.doMagnet(world, living, 10.0f, -10.0f);
            }
            if (moved > 0) {
                stack.m_41622_(moved, living, user -> user.m_21190_(living.m_7655_()));
                world.m_6263_((Player)null, living.m_20185_(), living.m_20186_(), living.m_20189_(), TFSounds.MAGNET_GRAB, living.m_5720_(), 1.0f, 1.0f);
            }
        }
    }
    
    public float getXpRepairRatio(final ItemStack stack) {
        return 0.1f;
    }
    
    @Nonnull
    public UseAnim m_6164_(final ItemStack stack) {
        return UseAnim.BOW;
    }
    
    public int m_8105_(final ItemStack stack) {
        return 72000;
    }
    
    private int doMagnet(final Level world, final LivingEntity living, final float yawOffset, final float pitchOffset) {
        final double range = 32.0;
        final Vec3 srcVec = new Vec3(living.m_20185_(), living.m_20186_() + living.m_20192_(), living.m_20189_());
        final Vec3 lookVec = this.getOffsetLook(living, yawOffset, pitchOffset);
        final Vec3 destVec = srcVec.m_82520_(lookVec.f_82479_ * range, lookVec.f_82480_ * range, lookVec.f_82481_ * range);
        return doMagnet(world, new BlockPos(srcVec), new BlockPos(destVec));
    }
    
    public static int doMagnet(final Level world, final BlockPos usePos, final BlockPos destPos) {
        initOre2BlockMap();
        int blocksMoved = 0;
        BlockState attactedOreBlock = Blocks.f_50016_.m_49966_();
        BlockState replacementBlock = Blocks.f_50016_.m_49966_();
        BlockPos foundPos = null;
        BlockPos basePos = null;
        for (final BlockPos coord : new VoxelBresenhamIterator(usePos, destPos)) {
            final BlockState searchState = world.m_8055_(coord);
            if (basePos == null) {
                if (!isReplaceable(searchState)) {
                    continue;
                }
                basePos = coord;
            }
            else {
                if (foundPos != null || searchState.m_60734_() == Blocks.f_50016_ || !isOre(searchState.m_60734_()) || world.m_7702_(coord) != null) {
                    continue;
                }
                attactedOreBlock = searchState;
                replacementBlock = OreMagnetItem.ORE_TO_BLOCK_REPLACEMENTS.getOrDefault(attactedOreBlock.m_60734_(), Blocks.f_50069_).m_49966_();
                foundPos = coord;
            }
        }
        if (basePos != null && foundPos != null && attactedOreBlock.m_60734_() != Blocks.f_50016_) {
            final Set<BlockPos> veinBlocks = new HashSet<BlockPos>();
            findVein(world, foundPos, attactedOreBlock, veinBlocks);
            final int offX = basePos.m_123341_() - foundPos.m_123341_();
            final int offY = basePos.m_123342_() - foundPos.m_123342_();
            final int offZ = basePos.m_123343_() - foundPos.m_123343_();
            for (final BlockPos coord2 : veinBlocks) {
                final BlockPos replacePos = coord2.m_142082_(offX, offY, offZ);
                final BlockState replaceState = world.m_8055_(replacePos);
                if (isReplaceable(replaceState) || replaceState.m_60734_() instanceof AirBlock) {
                    world.m_7731_(coord2, replacementBlock, 2);
                    world.m_7731_(replacePos, attactedOreBlock, 2);
                    ++blocksMoved;
                }
            }
        }
        return blocksMoved;
    }
    
    private Vec3 getOffsetLook(final LivingEntity living, final float yawOffset, final float pitchOffset) {
        final float var2 = Mth.m_14089_(-(living.m_146908_() + yawOffset) * 0.017453292f - 3.1415927f);
        final float var3 = Mth.m_14031_(-(living.m_146908_() + yawOffset) * 0.017453292f - 3.1415927f);
        final float var4 = -Mth.m_14089_(-(living.m_146909_() + pitchOffset) * 0.017453292f);
        final float var5 = Mth.m_14031_(-(living.m_146909_() + pitchOffset) * 0.017453292f);
        return new Vec3((double)(var3 * var4), (double)var5, (double)(var2 * var4));
    }
    
    @Deprecated
    private static boolean isReplaceable(final BlockState state) {
        final Block block = state.m_60734_();
        return BlockTagGenerator.ORE_MAGNET_SAFE_REPLACE_BLOCK.m_8110_((Object)block);
    }
    
    private static boolean findVein(final Level world, final BlockPos here, final BlockState oreState, final Set<BlockPos> veinBlocks) {
        if (veinBlocks.contains(here)) {
            return false;
        }
        if (veinBlocks.size() >= 24) {
            return false;
        }
        if (world.m_8055_(here) == oreState) {
            veinBlocks.add(here);
            for (final Direction e : Direction.values()) {
                findVein(world, here.m_142300_(e), oreState, veinBlocks);
            }
            return true;
        }
        return false;
    }
    
    private static boolean isOre(final Block ore) {
        return OreMagnetItem.ORE_TO_BLOCK_REPLACEMENTS.containsKey(ore);
    }
    
    private static void initOre2BlockMap() {
        if (!OreMagnetItem.cacheNeedsBuild) {
            return;
        }
        TwilightForestMod.LOGGER.info("GENERATING ORE TO BLOCK MAPPING");
        for (Block blockReplaceOre : BlockTagGenerator.ORE_MAGNET_BLOCK_REPLACE_ORE.m_6497_()) {
            final ResourceLocation rl = blockReplaceOre.getRegistryName();
            final Tag<Block> tag = (Tag<Block>)BlockTags.m_13115_().m_7689_(TwilightForestMod.prefix("ore_magnet/" + rl.m_135827_() + "/" + rl.m_135815_()));
            for (final Block oreBlock : tag.m_6497_()) {
                OreMagnetItem.ORE_TO_BLOCK_REPLACEMENTS.put(oreBlock, blockReplaceOre);
            }
        }
        final Set<Block> remainingOres = new HashSet<Block>(Tags.Blocks.ORES.m_6497_());
        remainingOres.removeAll(OreMagnetItem.ORE_TO_BLOCK_REPLACEMENTS.keySet());
        remainingOres.removeIf(b -> "minecraft".equals(b.getRegistryName().m_135827_()));
        if (!remainingOres.isEmpty()) {
            TwilightForestMod.LOGGER.warn((String)remainingOres.stream().peek(ore -> OreMagnetItem.ORE_TO_BLOCK_REPLACEMENTS.put(ore, Blocks.f_50069_)).map((Function<? super Object, ?>)ForgeRegistryEntry::getRegistryName).map((Function<? super Object, ?>)ResourceLocation::toString).collect((Collector<? super Object, ?, String>)Collectors.joining(", ", "Partially supported ores with Ore Magnet, [", "], will relate these to `minecraft:stone`. Mod packers/Mod devs are encouraged to add support for their ores to our ore magnet through block tag jsons")));
        }
        else {
            TwilightForestMod.LOGGER.info("No remaining ores to map!");
        }
        OreMagnetItem.cacheNeedsBuild = false;
    }
    
    @SubscribeEvent
    public static void buildOreMagnetCache(final AddReloadListenerEvent event) {
        event.addListener((stage, resourceManager, preparationsProfiler, reloadProfiler, backgroundExecutor, gameExecutor) -> {
            if (!OreMagnetItem.cacheNeedsBuild) {
                OreMagnetItem.ORE_TO_BLOCK_REPLACEMENTS.clear();
                OreMagnetItem.cacheNeedsBuild = true;
            }
            return stage.m_6769_((Object)null).thenRun(() -> {});
        });
    }
    
    static {
        OreMagnetItem.cacheNeedsBuild = true;
        ORE_TO_BLOCK_REPLACEMENTS = new HashMap<Block, Block>();
    }
}
