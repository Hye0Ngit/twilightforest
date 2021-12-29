// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.data;

import com.google.common.collect.ImmutableSet;
import twilightforest.TwilightForestMod;
import net.minecraftforge.registries.ForgeRegistries;
import java.util.function.Predicate;
import net.minecraft.util.ResourceLocation;
import net.minecraft.block.material.Material;
import net.minecraft.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraft.tags.BlockTags;
import twilightforest.block.TFBlocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraft.data.DataGenerator;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.tags.ITag;
import net.minecraft.data.BlockTagsProvider;

public class BlockTagGenerator extends BlockTagsProvider
{
    public static final ITag.INamedTag<Block> TOWERWOOD;
    public static final ITag.INamedTag<Block> TWILIGHT_OAK_LOGS;
    public static final ITag.INamedTag<Block> CANOPY_LOGS;
    public static final ITag.INamedTag<Block> MANGROVE_LOGS;
    public static final ITag.INamedTag<Block> DARKWOOD_LOGS;
    public static final ITag.INamedTag<Block> TIME_LOGS;
    public static final ITag.INamedTag<Block> TRANSFORMATION_LOGS;
    public static final ITag.INamedTag<Block> MINING_LOGS;
    public static final ITag.INamedTag<Block> SORTING_LOGS;
    public static final ITag.INamedTag<Block> TF_LOGS;
    public static final ITag.INamedTag<Block> TF_FENCES;
    public static final ITag.INamedTag<Block> TF_FENCE_GATES;
    public static final ITag.INamedTag<Block> STORAGE_BLOCKS_ARCTIC_FUR;
    public static final ITag.INamedTag<Block> STORAGE_BLOCKS_CARMINITE;
    public static final ITag.INamedTag<Block> STORAGE_BLOCKS_FIERY;
    public static final ITag.INamedTag<Block> STORAGE_BLOCKS_IRONWOOD;
    public static final ITag.INamedTag<Block> STORAGE_BLOCKS_KNIGHTMETAL;
    public static final ITag.INamedTag<Block> STORAGE_BLOCKS_STEELEAF;
    public static final ITag.INamedTag<Block> ORES_IRONWOOD;
    public static final ITag.INamedTag<Block> ORES_KNIGHTMETAL;
    public static final ITag.INamedTag<Block> PORTAL_EDGE;
    public static final ITag.INamedTag<Block> PORTAL_POOL;
    public static final ITag.INamedTag<Block> PORTAL_DECO;
    public static final ITag.INamedTag<Block> SPECIAL_POTS;
    public static final ITag.INamedTag<Block> TROPHIES;
    public static final ITag.INamedTag<Block> FIRE_JET_FUEL;
    public static final ITag.INamedTag<Block> ANNIHILATION_INCLUSIONS;
    public static final ITag.INamedTag<Block> ANTIBUILDER_IGNORES;
    public static final ITag.INamedTag<Block> CARMINITE_REACTOR_IMMUNE;
    public static final ITag.INamedTag<Block> STRUCTURE_BANNED_INTERACTIONS;
    public static final ITag.INamedTag<Block> ORE_MAGNET_SAFE_REPLACE_BLOCK;
    public static final ITag.INamedTag<Block> ORE_MAGNET_BLOCK_REPLACE_ORE;
    public static final ITag.INamedTag<Block> ORE_MAGNET_STONE;
    public static final ITag.INamedTag<Block> ORE_MAGNET_NETHERRACK;
    public static final ITag.INamedTag<Block> ORE_MAGNET_END_STONE;
    public static final ITag.INamedTag<Block> ORE_MAGNET_ROOT;
    private static final Set<Block> plants;
    
    public BlockTagGenerator(final DataGenerator generator, final ExistingFileHelper exFileHelper) {
        super(generator, "twilightforest", exFileHelper);
    }
    
    protected void func_200432_c() {
        this.func_240522_a_((ITag.INamedTag)BlockTagGenerator.TWILIGHT_OAK_LOGS).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.oak_log.get(), (Block)TFBlocks.stripped_oak_log.get(), (Block)TFBlocks.oak_wood.get(), (Block)TFBlocks.stripped_oak_wood.get() });
        this.func_240522_a_((ITag.INamedTag)BlockTagGenerator.CANOPY_LOGS).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.canopy_log.get(), (Block)TFBlocks.stripped_canopy_log.get(), (Block)TFBlocks.canopy_wood.get(), (Block)TFBlocks.stripped_canopy_wood.get() });
        this.func_240522_a_((ITag.INamedTag)BlockTagGenerator.MANGROVE_LOGS).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.mangrove_log.get(), (Block)TFBlocks.stripped_mangrove_log.get(), (Block)TFBlocks.mangrove_wood.get(), (Block)TFBlocks.stripped_mangrove_wood.get() });
        this.func_240522_a_((ITag.INamedTag)BlockTagGenerator.DARKWOOD_LOGS).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.dark_log.get(), (Block)TFBlocks.stripped_dark_log.get(), (Block)TFBlocks.dark_wood.get(), (Block)TFBlocks.stripped_dark_wood.get() });
        this.func_240522_a_((ITag.INamedTag)BlockTagGenerator.TIME_LOGS).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.time_log.get(), (Block)TFBlocks.stripped_time_log.get(), (Block)TFBlocks.time_wood.get(), (Block)TFBlocks.stripped_time_wood.get() });
        this.func_240522_a_((ITag.INamedTag)BlockTagGenerator.TRANSFORMATION_LOGS).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.transformation_log.get(), (Block)TFBlocks.stripped_transformation_log.get(), (Block)TFBlocks.transformation_wood.get(), (Block)TFBlocks.stripped_transformation_wood.get() });
        this.func_240522_a_((ITag.INamedTag)BlockTagGenerator.MINING_LOGS).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.mining_log.get(), (Block)TFBlocks.stripped_mining_log.get(), (Block)TFBlocks.mining_wood.get(), (Block)TFBlocks.stripped_mining_wood.get() });
        this.func_240522_a_((ITag.INamedTag)BlockTagGenerator.SORTING_LOGS).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.sorting_log.get(), (Block)TFBlocks.stripped_sorting_log.get(), (Block)TFBlocks.sorting_wood.get(), (Block)TFBlocks.stripped_sorting_wood.get() });
        this.func_240522_a_((ITag.INamedTag)BlockTagGenerator.TF_LOGS).addTags(new ITag.INamedTag[] { BlockTagGenerator.TWILIGHT_OAK_LOGS, BlockTagGenerator.CANOPY_LOGS, BlockTagGenerator.MANGROVE_LOGS, BlockTagGenerator.DARKWOOD_LOGS, BlockTagGenerator.TIME_LOGS, BlockTagGenerator.TRANSFORMATION_LOGS, BlockTagGenerator.MINING_LOGS, BlockTagGenerator.SORTING_LOGS });
        this.func_240522_a_(BlockTags.field_200031_h).func_240531_a_((ITag.INamedTag)BlockTagGenerator.TF_LOGS);
        this.func_240522_a_(BlockTags.field_232887_q_).addTags(new ITag.INamedTag[] { BlockTagGenerator.TWILIGHT_OAK_LOGS, BlockTagGenerator.CANOPY_LOGS, BlockTagGenerator.MANGROVE_LOGS, BlockTagGenerator.TIME_LOGS, BlockTagGenerator.TRANSFORMATION_LOGS, BlockTagGenerator.MINING_LOGS, BlockTagGenerator.SORTING_LOGS });
        this.func_240522_a_(BlockTags.field_200030_g).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.oak_sapling.get(), (Block)TFBlocks.canopy_sapling.get(), (Block)TFBlocks.mangrove_sapling.get(), (Block)TFBlocks.darkwood_sapling.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.time_sapling.get(), (Block)TFBlocks.transformation_sapling.get(), (Block)TFBlocks.mining_sapling.get(), (Block)TFBlocks.sorting_sapling.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.hollow_oak_sapling.get(), (Block)TFBlocks.rainboak_sapling.get() });
        this.func_240522_a_(BlockTags.field_206952_E).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.rainboak_leaves.get(), (Block)TFBlocks.oak_leaves.get(), (Block)TFBlocks.canopy_leaves.get(), (Block)TFBlocks.mangrove_leaves.get(), (Block)TFBlocks.dark_leaves.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.time_leaves.get(), (Block)TFBlocks.transformation_leaves.get(), (Block)TFBlocks.mining_leaves.get(), (Block)TFBlocks.sorting_leaves.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.thorn_leaves.get(), (Block)TFBlocks.beanstalk_leaves.get() });
        this.func_240522_a_(BlockTags.field_199898_b).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.twilight_oak_planks.get(), (Block)TFBlocks.canopy_planks.get(), (Block)TFBlocks.mangrove_planks.get(), (Block)TFBlocks.dark_planks.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.time_planks.get(), (Block)TFBlocks.trans_planks.get(), (Block)TFBlocks.mine_planks.get(), (Block)TFBlocks.sort_planks.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.tower_wood.get(), (Block)TFBlocks.tower_wood_encased.get(), (Block)TFBlocks.tower_wood_cracked.get(), (Block)TFBlocks.tower_wood_mossy.get(), (Block)TFBlocks.tower_wood_infested.get() });
        this.func_240522_a_((ITag.INamedTag)BlockTagGenerator.TF_FENCES).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.twilight_oak_fence.get(), (Block)TFBlocks.canopy_fence.get(), (Block)TFBlocks.mangrove_fence.get(), (Block)TFBlocks.dark_fence.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.time_fence.get(), (Block)TFBlocks.trans_fence.get(), (Block)TFBlocks.mine_fence.get(), (Block)TFBlocks.sort_fence.get() });
        this.func_240522_a_((ITag.INamedTag)BlockTagGenerator.TF_FENCE_GATES).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.twilight_oak_gate.get(), (Block)TFBlocks.canopy_gate.get(), (Block)TFBlocks.mangrove_gate.get(), (Block)TFBlocks.dark_gate.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.time_gate.get(), (Block)TFBlocks.trans_gate.get(), (Block)TFBlocks.mine_gate.get(), (Block)TFBlocks.sort_gate.get() });
        this.func_240522_a_(BlockTags.field_219756_j).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.twilight_oak_fence.get(), (Block)TFBlocks.canopy_fence.get(), (Block)TFBlocks.mangrove_fence.get(), (Block)TFBlocks.dark_fence.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.time_fence.get(), (Block)TFBlocks.trans_fence.get(), (Block)TFBlocks.mine_fence.get(), (Block)TFBlocks.sort_fence.get() });
        this.func_240522_a_(BlockTags.field_232868_aA_).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.twilight_oak_gate.get(), (Block)TFBlocks.canopy_gate.get(), (Block)TFBlocks.mangrove_gate.get(), (Block)TFBlocks.dark_gate.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.time_gate.get(), (Block)TFBlocks.trans_gate.get(), (Block)TFBlocks.mine_gate.get(), (Block)TFBlocks.sort_gate.get() });
        this.func_240522_a_((ITag.INamedTag)Tags.Blocks.FENCES).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.twilight_oak_fence.get(), (Block)TFBlocks.canopy_fence.get(), (Block)TFBlocks.mangrove_fence.get(), (Block)TFBlocks.dark_fence.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.time_fence.get(), (Block)TFBlocks.trans_fence.get(), (Block)TFBlocks.mine_fence.get(), (Block)TFBlocks.sort_fence.get() });
        this.func_240522_a_((ITag.INamedTag)Tags.Blocks.FENCE_GATES).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.twilight_oak_gate.get(), (Block)TFBlocks.canopy_gate.get(), (Block)TFBlocks.mangrove_gate.get(), (Block)TFBlocks.dark_gate.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.time_gate.get(), (Block)TFBlocks.trans_gate.get(), (Block)TFBlocks.mine_gate.get(), (Block)TFBlocks.sort_gate.get() });
        this.func_240522_a_((ITag.INamedTag)Tags.Blocks.FENCES_WOODEN).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.twilight_oak_fence.get(), (Block)TFBlocks.canopy_fence.get(), (Block)TFBlocks.mangrove_fence.get(), (Block)TFBlocks.dark_fence.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.time_fence.get(), (Block)TFBlocks.trans_fence.get(), (Block)TFBlocks.mine_fence.get(), (Block)TFBlocks.sort_fence.get() });
        this.func_240522_a_((ITag.INamedTag)Tags.Blocks.FENCE_GATES_WOODEN).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.twilight_oak_gate.get(), (Block)TFBlocks.canopy_gate.get(), (Block)TFBlocks.mangrove_gate.get(), (Block)TFBlocks.dark_gate.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.time_gate.get(), (Block)TFBlocks.trans_gate.get(), (Block)TFBlocks.mine_gate.get(), (Block)TFBlocks.sort_gate.get() });
        this.func_240522_a_(BlockTags.field_202895_i).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.twilight_oak_slab.get(), (Block)TFBlocks.canopy_slab.get(), (Block)TFBlocks.mangrove_slab.get(), (Block)TFBlocks.dark_slab.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.time_slab.get(), (Block)TFBlocks.trans_slab.get(), (Block)TFBlocks.mine_slab.get(), (Block)TFBlocks.sort_slab.get() });
        this.func_240522_a_(BlockTags.field_203292_x).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.aurora_slab.get() });
        this.func_240522_a_(BlockTags.field_202894_h).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.twilight_oak_stairs.get(), (Block)TFBlocks.canopy_stairs.get(), (Block)TFBlocks.mangrove_stairs.get(), (Block)TFBlocks.dark_stairs.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.time_stairs.get(), (Block)TFBlocks.trans_stairs.get(), (Block)TFBlocks.mine_stairs.get(), (Block)TFBlocks.sort_stairs.get() });
        this.func_240522_a_(BlockTags.field_203291_w).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.castle_stairs_brick.get(), (Block)TFBlocks.castle_stairs_worn.get(), (Block)TFBlocks.castle_stairs_cracked.get(), (Block)TFBlocks.castle_stairs_mossy.get(), (Block)TFBlocks.castle_stairs_encased.get(), (Block)TFBlocks.castle_stairs_bold.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.nagastone_stairs_left.get(), (Block)TFBlocks.nagastone_stairs_right.get(), (Block)TFBlocks.nagastone_stairs_mossy_left.get(), (Block)TFBlocks.nagastone_stairs_mossy_right.get(), (Block)TFBlocks.nagastone_stairs_weathered_left.get(), (Block)TFBlocks.nagastone_stairs_weathered_right.get() });
        this.func_240522_a_(BlockTags.field_200151_d).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.twilight_oak_button.get(), (Block)TFBlocks.canopy_button.get(), (Block)TFBlocks.mangrove_button.get(), (Block)TFBlocks.dark_button.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.time_button.get(), (Block)TFBlocks.trans_button.get(), (Block)TFBlocks.mine_button.get(), (Block)TFBlocks.sort_button.get() });
        this.func_240522_a_(BlockTags.field_202896_j).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.twilight_oak_plate.get(), (Block)TFBlocks.canopy_plate.get(), (Block)TFBlocks.mangrove_plate.get(), (Block)TFBlocks.dark_plate.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.time_plate.get(), (Block)TFBlocks.trans_plate.get(), (Block)TFBlocks.mine_plate.get(), (Block)TFBlocks.sort_plate.get() });
        this.func_240522_a_(BlockTags.field_212186_k).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.twilight_oak_trapdoor.get(), (Block)TFBlocks.canopy_trapdoor.get(), (Block)TFBlocks.mangrove_trapdoor.get(), (Block)TFBlocks.dark_trapdoor.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.time_trapdoor.get(), (Block)TFBlocks.trans_trapdoor.get(), (Block)TFBlocks.mine_trapdoor.get(), (Block)TFBlocks.sort_trapdoor.get() });
        this.func_240522_a_(BlockTags.field_200152_g).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.twilight_oak_door.get(), (Block)TFBlocks.canopy_door.get(), (Block)TFBlocks.mangrove_door.get(), (Block)TFBlocks.dark_door.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.time_door.get(), (Block)TFBlocks.trans_door.get(), (Block)TFBlocks.mine_door.get(), (Block)TFBlocks.sort_door.get() });
        this.func_240522_a_(BlockTags.field_200032_i).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.potted_twilight_oak_sapling.get(), (Block)TFBlocks.potted_canopy_sapling.get(), (Block)TFBlocks.potted_mangrove_sapling.get(), (Block)TFBlocks.potted_darkwood_sapling.get(), (Block)TFBlocks.potted_rainboak_sapling.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.potted_hollow_oak_sapling.get(), (Block)TFBlocks.potted_time_sapling.get(), (Block)TFBlocks.potted_trans_sapling.get(), (Block)TFBlocks.potted_mine_sapling.get(), (Block)TFBlocks.potted_sort_sapling.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.potted_mayapple.get(), (Block)TFBlocks.potted_fiddlehead.get(), (Block)TFBlocks.potted_mushgloom.get(), (Block)TFBlocks.potted_thorn.get(), (Block)TFBlocks.potted_green_thorn.get(), (Block)TFBlocks.potted_dead_thorn.get() });
        this.func_240522_a_(BlockTags.field_232881_aw_).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.fiery_block.get() });
        this.func_240522_a_(BlockTags.field_226154_ad_).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.twilight_portal.get() });
        this.func_240522_a_(BlockTags.field_232878_as_).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.iron_ladder.get() });
        this.func_240522_a_(BlockTags.field_219753_V).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.twilight_oak_sign.get(), (Block)TFBlocks.twilight_wall_sign.get(), (Block)TFBlocks.canopy_sign.get(), (Block)TFBlocks.canopy_wall_sign.get(), (Block)TFBlocks.mangrove_sign.get(), (Block)TFBlocks.mangrove_wall_sign.get(), (Block)TFBlocks.darkwood_sign.get(), (Block)TFBlocks.darkwood_wall_sign.get(), (Block)TFBlocks.time_sign.get(), (Block)TFBlocks.time_wall_sign.get(), (Block)TFBlocks.trans_sign.get(), (Block)TFBlocks.trans_wall_sign.get(), (Block)TFBlocks.mine_sign.get(), (Block)TFBlocks.mine_wall_sign.get(), (Block)TFBlocks.sort_sign.get(), (Block)TFBlocks.sort_wall_sign.get() });
        this.func_240522_a_(BlockTags.field_219751_T).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.twilight_oak_sign.get(), (Block)TFBlocks.canopy_sign.get(), (Block)TFBlocks.mangrove_sign.get(), (Block)TFBlocks.darkwood_sign.get(), (Block)TFBlocks.time_sign.get(), (Block)TFBlocks.trans_sign.get(), (Block)TFBlocks.mine_sign.get(), (Block)TFBlocks.sort_sign.get() });
        this.func_240522_a_(BlockTags.field_219752_U).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.twilight_wall_sign.get(), (Block)TFBlocks.canopy_wall_sign.get(), (Block)TFBlocks.mangrove_wall_sign.get(), (Block)TFBlocks.darkwood_wall_sign.get(), (Block)TFBlocks.time_wall_sign.get(), (Block)TFBlocks.trans_wall_sign.get(), (Block)TFBlocks.mine_wall_sign.get(), (Block)TFBlocks.sort_wall_sign.get() });
        this.func_240522_a_((ITag.INamedTag)BlockTagGenerator.TOWERWOOD).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.tower_wood.get(), (Block)TFBlocks.tower_wood_mossy.get(), (Block)TFBlocks.tower_wood_cracked.get(), (Block)TFBlocks.tower_wood_infested.get() });
        this.func_240522_a_((ITag.INamedTag)BlockTagGenerator.STORAGE_BLOCKS_ARCTIC_FUR).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.arctic_fur_block.get() });
        this.func_240522_a_((ITag.INamedTag)BlockTagGenerator.STORAGE_BLOCKS_CARMINITE).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.carminite_block.get() });
        this.func_240522_a_((ITag.INamedTag)BlockTagGenerator.STORAGE_BLOCKS_FIERY).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.fiery_block.get() });
        this.func_240522_a_((ITag.INamedTag)BlockTagGenerator.STORAGE_BLOCKS_IRONWOOD).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.ironwood_block.get() });
        this.func_240522_a_((ITag.INamedTag)BlockTagGenerator.STORAGE_BLOCKS_KNIGHTMETAL).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.knightmetal_block.get() });
        this.func_240522_a_((ITag.INamedTag)BlockTagGenerator.STORAGE_BLOCKS_STEELEAF).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.steeleaf_block.get() });
        this.func_240522_a_(BlockTags.field_232875_ap_).addTags(new ITag.INamedTag[] { BlockTagGenerator.STORAGE_BLOCKS_ARCTIC_FUR, BlockTagGenerator.STORAGE_BLOCKS_CARMINITE, BlockTagGenerator.STORAGE_BLOCKS_FIERY, BlockTagGenerator.STORAGE_BLOCKS_IRONWOOD, BlockTagGenerator.STORAGE_BLOCKS_KNIGHTMETAL, BlockTagGenerator.STORAGE_BLOCKS_STEELEAF });
        this.func_240522_a_((ITag.INamedTag)Tags.Blocks.STORAGE_BLOCKS).addTags(new ITag.INamedTag[] { BlockTagGenerator.STORAGE_BLOCKS_ARCTIC_FUR, BlockTagGenerator.STORAGE_BLOCKS_CARMINITE, BlockTagGenerator.STORAGE_BLOCKS_FIERY, BlockTagGenerator.STORAGE_BLOCKS_IRONWOOD, BlockTagGenerator.STORAGE_BLOCKS_KNIGHTMETAL, BlockTagGenerator.STORAGE_BLOCKS_STEELEAF });
        this.func_240522_a_((ITag.INamedTag)Tags.Blocks.ORES).addTags(new ITag.INamedTag[] { BlockTagGenerator.ORES_IRONWOOD, BlockTagGenerator.ORES_KNIGHTMETAL });
        this.func_240522_a_((ITag.INamedTag)BlockTagGenerator.ORES_IRONWOOD);
        this.func_240522_a_((ITag.INamedTag)BlockTagGenerator.ORES_KNIGHTMETAL);
        this.func_240522_a_((ITag.INamedTag)BlockTagGenerator.PORTAL_EDGE).func_240534_a_((Object[])new Block[] { Blocks.field_196658_i, Blocks.field_150391_bh }).func_240534_a_((Object[])getAllFilteredBlocks(b -> b.field_149764_J == Material.field_151578_c));
        this.func_240522_a_((ITag.INamedTag)BlockTagGenerator.PORTAL_POOL).func_240534_a_((Object[])new Block[] { Blocks.field_150355_j });
        this.func_240522_a_((ITag.INamedTag)BlockTagGenerator.PORTAL_DECO).addTags(new ITag.INamedTag[] { BlockTags.field_226149_I_, BlockTags.field_206952_E, BlockTags.field_200030_g, BlockTags.field_226152_ab_ }).func_240534_a_((Object[])new Block[] { Blocks.field_222405_kQ }).func_240534_a_((Object[])getAllFilteredBlocks(b -> (b.field_149764_J == Material.field_151585_k || b.field_149764_J == Material.field_151582_l || b.field_149764_J == Material.field_151584_j) && !BlockTagGenerator.plants.contains(b)));
        this.func_240522_a_((ITag.INamedTag)BlockTagGenerator.SPECIAL_POTS).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.potted_thorn.get(), (Block)TFBlocks.potted_green_thorn.get(), (Block)TFBlocks.potted_dead_thorn.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.potted_hollow_oak_sapling.get(), (Block)TFBlocks.potted_time_sapling.get(), (Block)TFBlocks.potted_trans_sapling.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.potted_mine_sapling.get(), (Block)TFBlocks.potted_sort_sapling.get() });
        this.func_240522_a_((ITag.INamedTag)BlockTagGenerator.TROPHIES).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.naga_trophy.get(), (Block)TFBlocks.naga_wall_trophy.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.lich_trophy.get(), (Block)TFBlocks.lich_wall_trophy.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.minoshroom_trophy.get(), (Block)TFBlocks.minoshroom_wall_trophy.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.hydra_trophy.get(), (Block)TFBlocks.hydra_wall_trophy.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.knight_phantom_trophy.get(), (Block)TFBlocks.knight_phantom_wall_trophy.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.ur_ghast_trophy.get(), (Block)TFBlocks.ur_ghast_wall_trophy.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.yeti_trophy.get(), (Block)TFBlocks.yeti_wall_trophy.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.snow_queen_trophy.get(), (Block)TFBlocks.snow_queen_wall_trophy.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.quest_ram_trophy.get(), (Block)TFBlocks.quest_ram_wall_trophy.get() });
        this.func_240522_a_((ITag.INamedTag)BlockTagGenerator.FIRE_JET_FUEL).func_240534_a_((Object[])new Block[] { Blocks.field_150353_l });
        this.func_240522_a_(BlockTags.field_219754_W).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.boss_spawner_naga.get(), (Block)TFBlocks.boss_spawner_lich.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.boss_spawner_minoshroom.get(), (Block)TFBlocks.boss_spawner_hydra.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.boss_spawner_knight_phantom.get(), (Block)TFBlocks.boss_spawner_ur_ghast.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.boss_spawner_alpha_yeti.get(), (Block)TFBlocks.boss_spawner_snow_queen.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.boss_spawner_final_boss.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.force_field_pink.get(), (Block)TFBlocks.force_field_orange.get(), (Block)TFBlocks.force_field_green.get(), (Block)TFBlocks.force_field_blue.get(), (Block)TFBlocks.force_field_purple.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.giant_obsidian.get(), (Block)TFBlocks.stronghold_shield.get(), (Block)TFBlocks.vanishing_block.get(), (Block)TFBlocks.locked_vanishing_block.get(), (Block)TFBlocks.keepsake_casket.get() });
        this.func_240522_a_(BlockTags.field_219755_X).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.boss_spawner_naga.get(), (Block)TFBlocks.boss_spawner_lich.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.boss_spawner_minoshroom.get(), (Block)TFBlocks.boss_spawner_hydra.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.boss_spawner_knight_phantom.get(), (Block)TFBlocks.boss_spawner_ur_ghast.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.boss_spawner_alpha_yeti.get(), (Block)TFBlocks.boss_spawner_snow_queen.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.boss_spawner_final_boss.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.force_field_pink.get(), (Block)TFBlocks.force_field_orange.get(), (Block)TFBlocks.force_field_green.get(), (Block)TFBlocks.force_field_blue.get(), (Block)TFBlocks.force_field_purple.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.stronghold_shield.get(), (Block)TFBlocks.vanishing_block.get(), (Block)TFBlocks.locked_vanishing_block.get(), (Block)TFBlocks.keepsake_casket.get() });
        this.func_240522_a_((ITag.INamedTag)BlockTagGenerator.CARMINITE_REACTOR_IMMUNE).func_240534_a_((Object[])new Block[] { Blocks.field_180401_cv, Blocks.field_150357_h, Blocks.field_150384_bq, Blocks.field_150378_br, Blocks.field_185775_db, Blocks.field_150483_bI, Blocks.field_185776_dc, Blocks.field_185777_dd, Blocks.field_185779_df, Blocks.field_226904_lY_, Blocks.field_196603_bb }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.boss_spawner_naga.get(), (Block)TFBlocks.boss_spawner_lich.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.boss_spawner_minoshroom.get(), (Block)TFBlocks.boss_spawner_hydra.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.boss_spawner_knight_phantom.get(), (Block)TFBlocks.boss_spawner_ur_ghast.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.boss_spawner_alpha_yeti.get(), (Block)TFBlocks.boss_spawner_snow_queen.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.boss_spawner_final_boss.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.force_field_pink.get(), (Block)TFBlocks.force_field_orange.get(), (Block)TFBlocks.force_field_green.get(), (Block)TFBlocks.force_field_blue.get(), (Block)TFBlocks.force_field_purple.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.stronghold_shield.get(), (Block)TFBlocks.vanishing_block.get(), (Block)TFBlocks.locked_vanishing_block.get(), (Block)TFBlocks.keepsake_casket.get() });
        this.func_240522_a_((ITag.INamedTag)BlockTagGenerator.ANNIHILATION_INCLUSIONS).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.deadrock.get(), (Block)TFBlocks.deadrock_cracked.get(), (Block)TFBlocks.deadrock_weathered.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.castle_brick.get(), (Block)TFBlocks.castle_brick_cracked.get(), (Block)TFBlocks.castle_brick_frame.get(), (Block)TFBlocks.castle_brick_mossy.get(), (Block)TFBlocks.castle_brick_roof.get(), (Block)TFBlocks.castle_brick_worn.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.castle_rune_brick_blue.get(), (Block)TFBlocks.castle_rune_brick_purple.get(), (Block)TFBlocks.castle_rune_brick_yellow.get(), (Block)TFBlocks.castle_rune_brick_pink.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.force_field_pink.get(), (Block)TFBlocks.force_field_orange.get(), (Block)TFBlocks.force_field_green.get(), (Block)TFBlocks.force_field_blue.get(), (Block)TFBlocks.force_field_purple.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.brown_thorns.get(), (Block)TFBlocks.green_thorns.get() });
        this.func_240522_a_((ITag.INamedTag)BlockTagGenerator.ANTIBUILDER_IGNORES).func_240534_a_((Object[])new Block[] { Blocks.field_150357_h, Blocks.field_150379_bu, Blocks.field_150335_W, Blocks.field_150355_j }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.antibuilder.get(), (Block)TFBlocks.carminite_builder.get(), (Block)TFBlocks.built_block.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.reactor_debris.get(), (Block)TFBlocks.carminite_reactor.get(), (Block)TFBlocks.fake_diamond.get(), (Block)TFBlocks.fake_gold.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.vanishing_block.get(), (Block)TFBlocks.reappearing_block.get(), (Block)TFBlocks.locked_vanishing_block.get(), (Block)TFBlocks.ghast_trap.get() }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.keepsake_casket.get() }).addOptional(new ResourceLocation("gravestone:gravestone"));
        this.func_240522_a_((ITag.INamedTag)BlockTagGenerator.STRUCTURE_BANNED_INTERACTIONS).addTags(new ITag.INamedTag[] { BlockTags.field_200027_d, (ITag.INamedTag)Tags.Blocks.CHESTS }).func_240534_a_((Object[])new Block[] { Blocks.field_150442_at }).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.antibuilder.get() });
        this.func_240522_a_((ITag.INamedTag)BlockTagGenerator.ORE_MAGNET_SAFE_REPLACE_BLOCK).addTags(new ITag.INamedTag[] { BlockTagGenerator.ORE_MAGNET_BLOCK_REPLACE_ORE, (ITag.INamedTag)Tags.Blocks.DIRT, (ITag.INamedTag)Tags.Blocks.GRAVEL, (ITag.INamedTag)Tags.Blocks.SAND });
        this.func_240522_a_((ITag.INamedTag)BlockTagGenerator.ORE_MAGNET_BLOCK_REPLACE_ORE).func_240534_a_((Object[])new Block[] { Blocks.field_150348_b, Blocks.field_150424_aL, Blocks.field_150377_bs, (Block)TFBlocks.root.get() });
        this.func_240522_a_((ITag.INamedTag)BlockTagGenerator.ORE_MAGNET_STONE).func_240534_a_((Object[])new Block[] { Blocks.field_150352_o, Blocks.field_150366_p, Blocks.field_150369_x, Blocks.field_150482_ag, Blocks.field_150450_ax, Blocks.field_150412_bA });
        this.func_240522_a_((ITag.INamedTag)BlockTagGenerator.ORE_MAGNET_NETHERRACK).func_240534_a_((Object[])new Block[] { Blocks.field_235334_I_, Blocks.field_196766_fg });
        this.func_240522_a_((ITag.INamedTag)BlockTagGenerator.ORE_MAGNET_END_STONE).addOptional(new ResourceLocation("quark", "biotite_ore"));
        this.func_240522_a_((ITag.INamedTag)BlockTagGenerator.ORE_MAGNET_ROOT).func_240534_a_((Object[])new Block[] { (Block)TFBlocks.liveroot_block.get() });
    }
    
    private static Block[] getAllFilteredBlocks(final Predicate<Block> predicate) {
        return (Block[])ForgeRegistries.BLOCKS.getValues().stream().filter(b -> b.getRegistryName() != null && (b.getRegistryName().func_110624_b().equals("twilightforest") || b.getRegistryName().func_110624_b().equals("minecraft")) && predicate.test(b)).toArray(Block[]::new);
    }
    
    private boolean isExcludedFromTagBuilder(final Block block, final ITag.INamedTag<Block> tag) {
        return !BlockTagGenerator.plants.contains(block);
    }
    
    static {
        TOWERWOOD = BlockTags.func_199894_a(TwilightForestMod.prefix("towerwood").toString());
        TWILIGHT_OAK_LOGS = BlockTags.func_199894_a(TwilightForestMod.prefix("twilight_oak_logs").toString());
        CANOPY_LOGS = BlockTags.func_199894_a(TwilightForestMod.prefix("canopy_logs").toString());
        MANGROVE_LOGS = BlockTags.func_199894_a(TwilightForestMod.prefix("mangrove_logs").toString());
        DARKWOOD_LOGS = BlockTags.func_199894_a(TwilightForestMod.prefix("darkwood_logs").toString());
        TIME_LOGS = BlockTags.func_199894_a(TwilightForestMod.prefix("timewood_logs").toString());
        TRANSFORMATION_LOGS = BlockTags.func_199894_a(TwilightForestMod.prefix("transwood_logs").toString());
        MINING_LOGS = BlockTags.func_199894_a(TwilightForestMod.prefix("mining_logs").toString());
        SORTING_LOGS = BlockTags.func_199894_a(TwilightForestMod.prefix("sortwood_logs").toString());
        TF_LOGS = BlockTags.func_199894_a(TwilightForestMod.prefix("logs").toString());
        TF_FENCES = BlockTags.func_199894_a(TwilightForestMod.prefix("fences").toString());
        TF_FENCE_GATES = BlockTags.func_199894_a(TwilightForestMod.prefix("fence_gates").toString());
        STORAGE_BLOCKS_ARCTIC_FUR = BlockTags.func_199894_a("forge:storage_blocks/arctic_fur");
        STORAGE_BLOCKS_CARMINITE = BlockTags.func_199894_a("forge:storage_blocks/carminite");
        STORAGE_BLOCKS_FIERY = BlockTags.func_199894_a("forge:storage_blocks/fiery");
        STORAGE_BLOCKS_IRONWOOD = BlockTags.func_199894_a("forge:storage_blocks/ironwood");
        STORAGE_BLOCKS_KNIGHTMETAL = BlockTags.func_199894_a("forge:storage_blocks/knightmetal");
        STORAGE_BLOCKS_STEELEAF = BlockTags.func_199894_a("forge:storage_blocks/steeleaf");
        ORES_IRONWOOD = BlockTags.func_199894_a("forge:ores/ironwood");
        ORES_KNIGHTMETAL = BlockTags.func_199894_a("forge:ores/knightmetal");
        PORTAL_EDGE = BlockTags.func_199894_a(TwilightForestMod.prefix("portal/edge").toString());
        PORTAL_POOL = BlockTags.func_199894_a(TwilightForestMod.prefix("portal/fluid").toString());
        PORTAL_DECO = BlockTags.func_199894_a(TwilightForestMod.prefix("portal/decoration").toString());
        SPECIAL_POTS = BlockTags.func_199894_a(TwilightForestMod.prefix("dark_tower_excluded_pots").toString());
        TROPHIES = BlockTags.func_199894_a(TwilightForestMod.prefix("trophies").toString());
        FIRE_JET_FUEL = BlockTags.func_199894_a(TwilightForestMod.prefix("fire_jet_fuel").toString());
        ANNIHILATION_INCLUSIONS = BlockTags.func_199894_a(TwilightForestMod.prefix("annihilation_inclusions").toString());
        ANTIBUILDER_IGNORES = BlockTags.func_199894_a(TwilightForestMod.prefix("antibuilder_ignores").toString());
        CARMINITE_REACTOR_IMMUNE = BlockTags.func_199894_a(TwilightForestMod.prefix("carminite_reactor_immune").toString());
        STRUCTURE_BANNED_INTERACTIONS = BlockTags.func_199894_a(TwilightForestMod.prefix("structure_banned_interactions").toString());
        ORE_MAGNET_SAFE_REPLACE_BLOCK = BlockTags.func_199894_a(TwilightForestMod.prefix("ore_magnet/ore_safe_replace_block").toString());
        ORE_MAGNET_BLOCK_REPLACE_ORE = BlockTags.func_199894_a(TwilightForestMod.prefix("ore_magnet/block_replace_ore").toString());
        ORE_MAGNET_STONE = BlockTags.func_199894_a(TwilightForestMod.prefix("ore_magnet/minecraft/stone").toString());
        ORE_MAGNET_NETHERRACK = BlockTags.func_199894_a(TwilightForestMod.prefix("ore_magnet/minecraft/netherrack").toString());
        ORE_MAGNET_END_STONE = BlockTags.func_199894_a(TwilightForestMod.prefix("ore_magnet/minecraft/end_stone").toString());
        ORE_MAGNET_ROOT = BlockTags.func_199894_a(TwilightForestMod.prefix("ore_magnet/twilightforest/" + TFBlocks.root.getId().func_110623_a()).toString());
        plants = (Set)ImmutableSet.builder().add((Object[])new Block[] { Blocks.field_196605_bc, Blocks.field_196606_bd, Blocks.field_196607_be, Blocks.field_196609_bf, Blocks.field_196610_bg, Blocks.field_196612_bh, Blocks.field_196613_bi, Blocks.field_196614_bj, Blocks.field_196615_bk, Blocks.field_196616_bl, Blocks.field_222387_by, Blocks.field_222383_bA, Blocks.field_222388_bz, Blocks.field_196800_gd, Blocks.field_196801_ge, Blocks.field_196803_gg, Blocks.field_196802_gf, Blocks.field_196648_Z, Blocks.field_196642_W, Blocks.field_196645_X, Blocks.field_196574_ab, Blocks.field_196572_aa, Blocks.field_196647_Y, Blocks.field_196674_t, Blocks.field_196675_u, Blocks.field_196676_v, Blocks.field_196678_w, Blocks.field_196679_x, Blocks.field_196680_y, Blocks.field_185773_cZ, Blocks.field_150459_bM, Blocks.field_150469_bN, Blocks.field_150464_aj, Blocks.field_150394_bc, Blocks.field_150393_bb, (Block)TFBlocks.oak_sapling.get(), (Block)TFBlocks.canopy_sapling.get(), (Block)TFBlocks.mangrove_sapling.get(), (Block)TFBlocks.darkwood_sapling.get(), (Block)TFBlocks.time_sapling.get(), (Block)TFBlocks.transformation_sapling.get(), (Block)TFBlocks.mining_sapling.get(), (Block)TFBlocks.sorting_sapling.get(), (Block)TFBlocks.hollow_oak_sapling.get(), (Block)TFBlocks.rainboak_sapling.get(), (Block)TFBlocks.rainboak_leaves.get(), (Block)TFBlocks.oak_leaves.get(), (Block)TFBlocks.canopy_leaves.get(), (Block)TFBlocks.mangrove_leaves.get(), (Block)TFBlocks.dark_leaves.get(), (Block)TFBlocks.time_leaves.get(), (Block)TFBlocks.transformation_leaves.get(), (Block)TFBlocks.mining_leaves.get(), (Block)TFBlocks.sorting_leaves.get(), (Block)TFBlocks.thorn_leaves.get(), (Block)TFBlocks.beanstalk_leaves.get() }).build();
    }
}
