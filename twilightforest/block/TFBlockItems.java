// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.Objects;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.SignItem;
import net.minecraft.item.TallBlockItem;
import twilightforest.item.WearableItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import twilightforest.item.TrophyItem;
import twilightforest.TwilightForestMod;
import twilightforest.item.FurnaceFuelItem;
import net.minecraftforge.registries.IForgeRegistry;
import twilightforest.item.HugeLilyPadItem;
import twilightforest.item.HugeWaterLilyItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraft.item.BlockItem;
import twilightforest.client.ISTER;
import twilightforest.tileentity.TFTileEntities;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import java.util.concurrent.Callable;
import twilightforest.item.TFItems;
import net.minecraft.block.Block;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;

public class TFBlockItems
{
    public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> r = (IForgeRegistry<Item>)event.getRegistry();
        r.register((IForgeRegistryEntry)trophyBlock(TFBlocks.naga_trophy, TFBlocks.naga_wall_trophy));
        r.register((IForgeRegistryEntry)trophyBlock(TFBlocks.lich_trophy, TFBlocks.lich_wall_trophy));
        r.register((IForgeRegistryEntry)trophyBlock(TFBlocks.minoshroom_trophy, TFBlocks.minoshroom_wall_trophy));
        r.register((IForgeRegistryEntry)trophyBlock(TFBlocks.hydra_trophy, TFBlocks.hydra_wall_trophy));
        r.register((IForgeRegistryEntry)trophyBlock(TFBlocks.knight_phantom_trophy, TFBlocks.knight_phantom_wall_trophy));
        r.register((IForgeRegistryEntry)trophyBlock(TFBlocks.ur_ghast_trophy, TFBlocks.ur_ghast_wall_trophy));
        r.register((IForgeRegistryEntry)trophyBlock(TFBlocks.yeti_trophy, TFBlocks.yeti_wall_trophy));
        r.register((IForgeRegistryEntry)trophyBlock(TFBlocks.snow_queen_trophy, TFBlocks.snow_queen_wall_trophy));
        r.register((IForgeRegistryEntry)trophyBlock(TFBlocks.quest_ram_trophy, TFBlocks.quest_ram_wall_trophy));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.twilight_portal_miniature_structure));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.naga_courtyard_miniature_structure));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.lich_tower_miniature_structure));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.boss_spawner_naga));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.boss_spawner_lich));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.boss_spawner_minoshroom));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.boss_spawner_hydra));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.boss_spawner_knight_phantom));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.boss_spawner_ur_ghast));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.boss_spawner_alpha_yeti));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.boss_spawner_snow_queen));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.boss_spawner_final_boss));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.etched_nagastone));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.etched_nagastone_weathered));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.etched_nagastone_mossy));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.nagastone_pillar));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.nagastone_pillar_weathered));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.nagastone_pillar_mossy));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.nagastone_stairs_left));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.nagastone_stairs_weathered_left));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.nagastone_stairs_mossy_left));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.nagastone_stairs_right));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.nagastone_stairs_weathered_right));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.nagastone_stairs_mossy_right));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.naga_stone_head));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.naga_stone));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.spiral_bricks));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.stone_twist));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.stone_twist_thin));
        r.register((IForgeRegistryEntry)makeBlockItem((Item)new BlockItem((Block)TFBlocks.keepsake_casket.get(), TFItems.defaultBuilder().setISTER(() -> new Callable<ItemStackTileEntityRenderer>() {
            @Override
            public ItemStackTileEntityRenderer call() {
                return new ISTER(TFTileEntities.KEEPSAKE_CASKET.getId());
            }
        })), (RegistryObject<? extends Block>)TFBlocks.keepsake_casket));
        r.register((IForgeRegistryEntry)makeBlockItem((Item)new HugeWaterLilyItem((Block)TFBlocks.huge_waterlily.get(), TFItems.defaultBuilder()), TFBlocks.huge_waterlily));
        r.register((IForgeRegistryEntry)makeBlockItem((Item)new HugeLilyPadItem((HugeLilyPadBlock)TFBlocks.huge_lilypad.get(), TFItems.defaultBuilder()), (RegistryObject<? extends Block>)TFBlocks.huge_lilypad));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.maze_stone));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.maze_stone_brick));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.maze_stone_cracked));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.maze_stone_mossy));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.maze_stone_decorative));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.maze_stone_chiseled));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.maze_stone_border));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.maze_stone_mosaic));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.smoker));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.encased_smoker));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.fire_jet));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.encased_fire_jet));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.stronghold_shield));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.trophy_pedestal));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.underbrick));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.underbrick_cracked));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.underbrick_mossy));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.underbrick_floor));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.tower_wood));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.tower_wood_cracked));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.tower_wood_mossy));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.tower_wood_infested));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.tower_wood_encased));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.vanishing_block));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.reappearing_block));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.locked_vanishing_block));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.carminite_builder));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.antibuilder));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.carminite_reactor));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.ghast_trap));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.fake_gold));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.fake_diamond));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.aurora_block));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.aurora_pillar));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.aurora_slab));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.auroralized_glass));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.trollsteinn));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.trollvidr));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.unripe_trollber));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.trollber));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.huge_mushgloom));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.huge_mushgloom_stem));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.uberous_soil));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.huge_stalk));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.beanstalk_leaves));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.wispy_cloud));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.fluffy_cloud));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.giant_cobblestone));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.giant_log));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.giant_leaves));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.giant_obsidian));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.deadrock));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.deadrock_cracked));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.deadrock_weathered));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.brown_thorns));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.green_thorns));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.burnt_thorns));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.thorn_rose));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.thorn_leaves));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.castle_brick));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.castle_brick_worn));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.castle_brick_cracked));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.castle_brick_mossy));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.castle_brick_frame));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.castle_brick_roof));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.castle_pillar_encased));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.castle_pillar_encased_tile));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.castle_pillar_bold));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.castle_pillar_bold_tile));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.castle_stairs_brick));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.castle_stairs_worn));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.castle_stairs_cracked));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.castle_stairs_mossy));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.castle_stairs_encased));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.castle_stairs_bold));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.castle_rune_brick_pink));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.castle_rune_brick_yellow));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.castle_rune_brick_blue));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.castle_rune_brick_purple));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.castle_door_pink));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.castle_door_yellow));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.castle_door_blue));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.castle_door_purple));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.force_field_pink));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.force_field_orange));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.force_field_green));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.force_field_blue));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.force_field_purple));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.uncrafting_table));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.cinder_furnace));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.cinder_log));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.cinder_wood));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.slider));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.iron_ladder));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.ironwood_block));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.steeleaf_block));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.fiery_block));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.knightmetal_block));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.carminite_block));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.arctic_fur_block));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.moss_patch));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.mayapple));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.clover_patch));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.fiddlehead));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.mushgloom));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.torchberry_plant));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.root_strand));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.fallen_leaves));
        r.register((IForgeRegistryEntry)wearableBlock(TFBlocks.firefly, TFTileEntities.FIREFLY));
        r.register((IForgeRegistryEntry)wearableBlock(TFBlocks.cicada, TFTileEntities.CICADA));
        r.register((IForgeRegistryEntry)wearableBlock(TFBlocks.moonworm, TFTileEntities.MOONWORM));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.firefly_jar));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.cicada_jar));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.hedge));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.root));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.liveroot_block));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.oak_leaves));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.canopy_leaves));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.mangrove_leaves));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.dark_leaves));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.time_leaves));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.transformation_leaves));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.mining_leaves));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.sorting_leaves));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.rainboak_leaves));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.oak_log));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.canopy_log));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.mangrove_log));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.dark_log));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.time_log));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.transformation_log));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.mining_log));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.sorting_log));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.stripped_oak_log));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.stripped_canopy_log));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.stripped_mangrove_log));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.stripped_dark_log));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.stripped_time_log));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.stripped_transformation_log));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.stripped_mining_log));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.stripped_sorting_log));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.oak_wood));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.canopy_wood));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.mangrove_wood));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.dark_wood));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.time_wood));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.transformation_wood));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.mining_wood));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.sorting_wood));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.stripped_oak_wood));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.stripped_canopy_wood));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.stripped_mangrove_wood));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.stripped_dark_wood));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.stripped_time_wood));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.stripped_transformation_wood));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.stripped_mining_wood));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.stripped_sorting_wood));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.time_log_core));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.transformation_log_core));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.mining_log_core));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.sorting_log_core));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.oak_sapling));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.canopy_sapling));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.mangrove_sapling));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.darkwood_sapling));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.hollow_oak_sapling));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.time_sapling));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.transformation_sapling));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.mining_sapling));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.sorting_sapling));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.rainboak_sapling));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.twilight_oak_planks));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.twilight_oak_stairs));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.twilight_oak_slab));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.twilight_oak_button));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.twilight_oak_fence, 300));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.twilight_oak_gate, 300));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.twilight_oak_plate));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.twilight_oak_trapdoor));
        r.register((IForgeRegistryEntry)tallBlock(TFBlocks.twilight_oak_door));
        r.register((IForgeRegistryEntry)signBlock(TFBlocks.twilight_oak_sign, TFBlocks.twilight_wall_sign));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.canopy_planks));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.canopy_stairs));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.canopy_slab));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.canopy_button));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.canopy_fence, 300));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.canopy_gate, 300));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.canopy_plate));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.canopy_trapdoor));
        r.register((IForgeRegistryEntry)tallBlock(TFBlocks.canopy_door));
        r.register((IForgeRegistryEntry)signBlock(TFBlocks.canopy_sign, TFBlocks.canopy_wall_sign));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.mangrove_planks));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.mangrove_stairs));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.mangrove_slab));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.mangrove_button));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.mangrove_fence, 300));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.mangrove_gate, 300));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.mangrove_plate));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.mangrove_trapdoor));
        r.register((IForgeRegistryEntry)tallBlock(TFBlocks.mangrove_door));
        r.register((IForgeRegistryEntry)signBlock(TFBlocks.mangrove_sign, TFBlocks.mangrove_wall_sign));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.dark_planks));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.dark_stairs));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.dark_slab));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.dark_button));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.dark_fence, 300));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.dark_gate, 300));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.dark_plate));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.dark_trapdoor));
        r.register((IForgeRegistryEntry)tallBlock(TFBlocks.dark_door));
        r.register((IForgeRegistryEntry)signBlock(TFBlocks.darkwood_sign, TFBlocks.darkwood_wall_sign));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.time_planks));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.time_stairs));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.time_slab));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.time_button));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.time_fence, 300));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.time_gate, 300));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.time_plate));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.time_trapdoor));
        r.register((IForgeRegistryEntry)tallBlock(TFBlocks.time_door));
        r.register((IForgeRegistryEntry)signBlock(TFBlocks.time_sign, TFBlocks.time_wall_sign));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.trans_planks));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.trans_stairs));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.trans_slab));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.trans_button));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.trans_fence, 300));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.trans_gate, 300));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.trans_plate));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.trans_trapdoor));
        r.register((IForgeRegistryEntry)tallBlock(TFBlocks.trans_door));
        r.register((IForgeRegistryEntry)signBlock(TFBlocks.trans_sign, TFBlocks.trans_wall_sign));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.mine_planks));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.mine_stairs));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.mine_slab));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.mine_button));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.mine_fence, 300));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.mine_gate, 300));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.mine_plate));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.mine_trapdoor));
        r.register((IForgeRegistryEntry)tallBlock(TFBlocks.mine_door));
        r.register((IForgeRegistryEntry)signBlock(TFBlocks.mine_sign, TFBlocks.mine_wall_sign));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.sort_planks));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.sort_stairs));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.sort_slab));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.sort_button));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.sort_fence, 300));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.sort_gate, 300));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.sort_plate));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.sort_trapdoor));
        r.register((IForgeRegistryEntry)tallBlock(TFBlocks.sort_door));
        r.register((IForgeRegistryEntry)signBlock(TFBlocks.sort_sign, TFBlocks.sort_wall_sign));
    }
    
    private static <B extends Block> Item blockItem(final RegistryObject<B> block) {
        return makeBlockItem((Item)new BlockItem((Block)block.get(), TFItems.defaultBuilder()), block);
    }
    
    private static <B extends Block> Item burningItem(final RegistryObject<B> block, final int burntime) {
        return makeBlockItem((Item)new FurnaceFuelItem((Block)block.get(), TFItems.defaultBuilder(), burntime), block);
    }
    
    private static <B extends Block, W extends Block> Item trophyBlock(final RegistryObject<B> block, final RegistryObject<W> wallblock) {
        return makeBlockItem((Item)new TrophyItem((Block)block.get(), (Block)wallblock.get(), TFItems.defaultBuilder().func_208103_a(TwilightForestMod.getRarity()).setISTER(() -> new Callable<ItemStackTileEntityRenderer>() {
            @Override
            public ItemStackTileEntityRenderer call() {
                return new ISTER(TFTileEntities.TROPHY.getId());
            }
        })), block);
    }
    
    private static <T extends Block, E extends TileEntity> Item wearableBlock(final RegistryObject<T> block, final RegistryObject<TileEntityType<E>> tileentity) {
        return makeBlockItem((Item)new WearableItem((Block)block.get(), TFItems.defaultBuilder().setISTER(() -> new Callable<ItemStackTileEntityRenderer>() {
            final /* synthetic */ RegistryObject val$tileentity;
            
            @Override
            public ItemStackTileEntityRenderer call() {
                return new ISTER(this.val$tileentity.getId());
            }
        })), block);
    }
    
    private static <B extends Block> Item tallBlock(final RegistryObject<B> block) {
        return makeBlockItem((Item)new TallBlockItem((Block)block.get(), TFItems.defaultBuilder()), block);
    }
    
    private static <B extends Block, W extends Block> Item signBlock(final RegistryObject<B> block, final RegistryObject<W> wallblock) {
        return makeBlockItem((Item)new SignItem(TFItems.defaultBuilder().func_200917_a(16), (Block)block.get(), (Block)wallblock.get()), block);
    }
    
    private static Item makeBlockItem(final Item blockitem, final RegistryObject<? extends Block> block) {
        return (Item)blockitem.setRegistryName((ResourceLocation)Objects.requireNonNull(block.getId()));
    }
}
