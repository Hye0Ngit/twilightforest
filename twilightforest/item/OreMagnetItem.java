// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import net.minecraft.profiler.IProfiler;
import net.minecraft.resources.IResourceManager;
import net.minecraft.resources.IFutureReloadListener;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraft.tags.ITag;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import net.minecraft.util.ResourceLocation;
import java.util.function.Function;
import net.minecraftforge.registries.ForgeRegistryEntry;
import java.util.Collection;
import net.minecraftforge.common.Tags;
import net.minecraft.tags.BlockTags;
import twilightforest.TwilightForestMod;
import net.minecraft.util.Direction;
import twilightforest.data.BlockTagGenerator;
import net.minecraft.util.math.MathHelper;
import java.util.Iterator;
import java.util.Set;
import net.minecraft.block.BlockState;
import net.minecraft.block.AirBlock;
import java.util.HashSet;
import net.minecraft.block.Blocks;
import twilightforest.util.FeatureUtil;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.item.UseAction;
import twilightforest.TFSounds;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import javax.annotation.Nonnull;
import net.minecraft.util.Hand;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import java.util.HashMap;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.item.Item;

@Mod.EventBusSubscriber(modid = "twilightforest")
public class OreMagnetItem extends Item
{
    private static final float WIGGLE = 10.0f;
    private static boolean cacheNeedsBuild;
    private static final HashMap<Block, Block> ORE_TO_BLOCK_REPLACEMENTS;
    
    protected OreMagnetItem(final Item.Properties props) {
        super(props);
    }
    
    @Nonnull
    public ActionResult<ItemStack> func_77659_a(final World world, final PlayerEntity player, @Nonnull final Hand hand) {
        player.func_184598_c(hand);
        return (ActionResult<ItemStack>)new ActionResult(ActionResultType.SUCCESS, (Object)player.func_184586_b(hand));
    }
    
    public void func_77615_a(final ItemStack stack, final World world, final LivingEntity living, final int useRemaining) {
        final int useTime = this.func_77626_a(stack) - useRemaining;
        if (!world.field_72995_K && useTime > 10) {
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
                stack.func_222118_a(moved, living, user -> user.func_213334_d(living.func_184600_cs()));
                world.func_184148_a((PlayerEntity)null, living.func_226277_ct_(), living.func_226278_cu_(), living.func_226281_cx_(), TFSounds.MAGNET_GRAB, living.func_184176_by(), 1.0f, 1.0f);
            }
        }
    }
    
    public float getXpRepairRatio(final ItemStack stack) {
        return 0.1f;
    }
    
    @Nonnull
    public UseAction func_77661_b(final ItemStack stack) {
        return UseAction.BOW;
    }
    
    public int func_77626_a(final ItemStack stack) {
        return 72000;
    }
    
    private int doMagnet(final World world, final LivingEntity living, final float yawOffset, final float pitchOffset) {
        final double range = 32.0;
        final Vector3d srcVec = new Vector3d(living.func_226277_ct_(), living.func_226278_cu_() + living.func_70047_e(), living.func_226281_cx_());
        final Vector3d lookVec = this.getOffsetLook(living, yawOffset, pitchOffset);
        final Vector3d destVec = srcVec.func_72441_c(lookVec.field_72450_a * range, lookVec.field_72448_b * range, lookVec.field_72449_c * range);
        return doMagnet(world, new BlockPos(srcVec), new BlockPos(destVec));
    }
    
    public static int doMagnet(final World world, final BlockPos usePos, final BlockPos destPos) {
        initOre2BlockMap();
        int blocksMoved = 0;
        final BlockPos[] lineArray = FeatureUtil.getBresenhamArrays(usePos, destPos);
        BlockState attactedOreBlock = Blocks.field_150350_a.func_176223_P();
        BlockState replacementBlock = Blocks.field_150350_a.func_176223_P();
        BlockPos foundPos = null;
        BlockPos basePos = null;
        for (final BlockPos coord : lineArray) {
            final BlockState searchState = world.func_180495_p(coord);
            if (basePos == null) {
                if (isReplaceable(searchState)) {
                    basePos = coord;
                }
            }
            else if (foundPos == null && searchState.func_177230_c() != Blocks.field_150350_a && isOre(searchState.func_177230_c()) && world.func_175625_s(coord) == null) {
                attactedOreBlock = searchState;
                replacementBlock = OreMagnetItem.ORE_TO_BLOCK_REPLACEMENTS.getOrDefault(attactedOreBlock.func_177230_c(), Blocks.field_150348_b).func_176223_P();
                foundPos = coord;
            }
        }
        if (basePos != null && foundPos != null && attactedOreBlock.func_177230_c() != Blocks.field_150350_a) {
            final Set<BlockPos> veinBlocks = new HashSet<BlockPos>();
            findVein(world, foundPos, attactedOreBlock, veinBlocks);
            final int offX = basePos.func_177958_n() - foundPos.func_177958_n();
            final int offY = basePos.func_177956_o() - foundPos.func_177956_o();
            final int offZ = basePos.func_177952_p() - foundPos.func_177952_p();
            for (final BlockPos coord2 : veinBlocks) {
                final BlockPos replacePos = coord2.func_177982_a(offX, offY, offZ);
                final BlockState replaceState = world.func_180495_p(replacePos);
                if (isReplaceable(replaceState) || replaceState.func_177230_c() instanceof AirBlock) {
                    world.func_180501_a(coord2, replacementBlock, 2);
                    world.func_180501_a(replacePos, attactedOreBlock, 2);
                    ++blocksMoved;
                }
            }
        }
        return blocksMoved;
    }
    
    private Vector3d getOffsetLook(final LivingEntity living, final float yawOffset, final float pitchOffset) {
        final float var2 = MathHelper.func_76134_b(-(living.field_70177_z + yawOffset) * 0.017453292f - 3.1415927f);
        final float var3 = MathHelper.func_76126_a(-(living.field_70177_z + yawOffset) * 0.017453292f - 3.1415927f);
        final float var4 = -MathHelper.func_76134_b(-(living.field_70125_A + pitchOffset) * 0.017453292f);
        final float var5 = MathHelper.func_76126_a(-(living.field_70125_A + pitchOffset) * 0.017453292f);
        return new Vector3d((double)(var3 * var4), (double)var5, (double)(var2 * var4));
    }
    
    @Deprecated
    private static boolean isReplaceable(final BlockState state) {
        final Block block = state.func_177230_c();
        return BlockTagGenerator.ORE_MAGNET_SAFE_REPLACE_BLOCK.func_230235_a_((Object)block);
    }
    
    private static boolean findVein(final World world, final BlockPos here, final BlockState oreState, final Set<BlockPos> veinBlocks) {
        if (veinBlocks.contains(here)) {
            return false;
        }
        if (veinBlocks.size() >= 24) {
            return false;
        }
        if (world.func_180495_p(here) == oreState) {
            veinBlocks.add(here);
            for (final Direction e : Direction.values()) {
                findVein(world, here.func_177972_a(e), oreState, veinBlocks);
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
        for (final Block blockReplaceOre : BlockTagGenerator.ORE_MAGNET_BLOCK_REPLACE_ORE.func_230236_b_()) {
            final ResourceLocation rl = blockReplaceOre.getRegistryName();
            final ITag<Block> tag = (ITag<Block>)BlockTags.func_199896_a().func_241834_b(TwilightForestMod.prefix("ore_magnet/" + rl.func_110624_b() + "/" + rl.func_110623_a()));
            for (final Block oreBlock : tag.func_230236_b_()) {
                OreMagnetItem.ORE_TO_BLOCK_REPLACEMENTS.put(oreBlock, blockReplaceOre);
            }
        }
        final Set<Block> remainingOres = new HashSet<Block>(Tags.Blocks.ORES.func_230236_b_());
        remainingOres.removeAll(OreMagnetItem.ORE_TO_BLOCK_REPLACEMENTS.keySet());
        remainingOres.removeIf(b -> "minecraft".equals(b.getRegistryName().func_110624_b()));
        if (!remainingOres.isEmpty()) {
            TwilightForestMod.LOGGER.warn((String)remainingOres.stream().peek(ore -> {
                final Block block = OreMagnetItem.ORE_TO_BLOCK_REPLACEMENTS.put(ore, Blocks.field_150348_b);
                return;
            }).map((Function<? super Object, ?>)ForgeRegistryEntry::getRegistryName).map((Function<? super Object, ?>)ResourceLocation::toString).collect((Collector<? super Object, ?, String>)Collectors.joining(", ", "Partially supported ores with Ore Magnet, [", "], will relate these to `minecraft:stone`. Mod packers/Mod devs are encouraged to add support for their ores to our ore magnet through block tag jsons")));
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
            return stage.func_216872_a((Object)null).thenRun(() -> {});
        });
    }
    
    static {
        OreMagnetItem.cacheNeedsBuild = true;
        ORE_TO_BLOCK_REPLACEMENTS = new HashMap<Block, Block>();
    }
}
