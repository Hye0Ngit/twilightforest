// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.data;

import net.minecraftforge.fml.RegistryObject;
import java.util.Iterator;
import twilightforest.item.TFItems;
import twilightforest.item.Experiment115Item;
import twilightforest.TwilightForestMod;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;

public class ItemModelGenerator extends ItemModelProvider
{
    public ItemModelGenerator(final DataGenerator generator, final ExistingFileHelper existingFileHelper) {
        super(generator, "twilightforest", existingFileHelper);
    }
    
    protected void registerModels() {
        for (final Item i : Registry.field_212630_s) {
            if (i instanceof SpawnEggItem && i.getRegistryName().func_110624_b().equals("twilightforest")) {
                ((ItemModelBuilder)this.getBuilder(i.getRegistryName().func_110623_a())).parent((ModelFile)this.getExistingFile(new ResourceLocation("item/template_spawn_egg")));
            }
        }
        this.toBlock((Block)TFBlocks.tower_wood.get());
        this.toBlock((Block)TFBlocks.tower_wood_encased.get());
        this.toBlock((Block)TFBlocks.tower_wood_cracked.get());
        this.toBlock((Block)TFBlocks.tower_wood_mossy.get());
        this.toBlock((Block)TFBlocks.tower_wood_infested.get());
        this.toBlock((Block)TFBlocks.carminite_builder.get());
        this.toBlock((Block)TFBlocks.antibuilder.get());
        this.toBlock((Block)TFBlocks.ghast_trap.get());
        this.toBlock((Block)TFBlocks.vanishing_block.get());
        this.toBlock((Block)TFBlocks.locked_vanishing_block.get());
        this.toBlock((Block)TFBlocks.reappearing_block.get());
        this.toBlock((Block)TFBlocks.carminite_reactor.get());
        this.toBlockModel((Block)TFBlocks.fake_gold.get(), new ResourceLocation("block/gold_block"));
        this.toBlockModel((Block)TFBlocks.fake_diamond.get(), new ResourceLocation("block/diamond_block"));
        this.toBlock((Block)TFBlocks.stronghold_shield.get());
        this.toBlock((Block)TFBlocks.trophy_pedestal.get());
        this.toBlockModel((Block)TFBlocks.aurora_block.get(), TwilightForestMod.prefix("block/aurora_block_0"));
        this.toBlock((Block)TFBlocks.aurora_pillar.get());
        this.toBlock((Block)TFBlocks.aurora_slab.get());
        this.toBlock((Block)TFBlocks.auroralized_glass.get());
        this.toBlock((Block)TFBlocks.underbrick.get());
        this.toBlock((Block)TFBlocks.underbrick_cracked.get());
        this.toBlock((Block)TFBlocks.underbrick_mossy.get());
        this.toBlock((Block)TFBlocks.underbrick_floor.get());
        this.toBlock((Block)TFBlocks.green_thorns.get());
        this.toBlock((Block)TFBlocks.brown_thorns.get());
        this.toBlock((Block)TFBlocks.burnt_thorns.get());
        this.generated(TFBlocks.thorn_rose.getId().func_110623_a(), TwilightForestMod.prefix("block/" + TFBlocks.thorn_rose.getId().func_110623_a()));
        this.toBlockModel((Block)TFBlocks.thorn_leaves.get(), new ResourceLocation("block/oak_leaves"));
        this.toBlockModel((Block)TFBlocks.beanstalk_leaves.get(), new ResourceLocation("block/spruce_leaves"));
        this.toBlock((Block)TFBlocks.deadrock.get());
        this.toBlock((Block)TFBlocks.deadrock_cracked.get());
        this.toBlock((Block)TFBlocks.deadrock_weathered.get());
        ((ItemModelBuilder)((ItemModelBuilder)this.getBuilder(TFBlocks.trollsteinn.getId().func_110623_a())).parent((ModelFile)this.getExistingFile(new ResourceLocation("block/cube_all")))).texture("all", TwilightForestMod.prefix("block/trollsteinn"));
        this.toBlock((Block)TFBlocks.wispy_cloud.get());
        this.toBlock((Block)TFBlocks.fluffy_cloud.get());
        this.toBlockModel((Block)TFBlocks.giant_cobblestone.get(), new ResourceLocation("block/cobblestone"));
        this.toBlockModel((Block)TFBlocks.giant_log.get(), new ResourceLocation("block/oak_log"));
        this.toBlockModel((Block)TFBlocks.giant_leaves.get(), new ResourceLocation("block/oak_leaves"));
        this.toBlockModel((Block)TFBlocks.giant_obsidian.get(), new ResourceLocation("block/obsidian"));
        this.toBlock((Block)TFBlocks.uberous_soil.get());
        this.toBlock((Block)TFBlocks.huge_stalk.get());
        ((ItemModelBuilder)((ItemModelBuilder)this.getBuilder(TFBlocks.huge_mushgloom.getId().func_110623_a())).parent((ModelFile)this.getExistingFile(new ResourceLocation("block/cube_all")))).texture("all", TwilightForestMod.prefix("block/huge_gloom_cap"));
        this.toBlock((Block)TFBlocks.huge_mushgloom_stem.get());
        this.generated(TFBlocks.trollvidr.getId().func_110623_a(), TwilightForestMod.prefix("block/" + TFBlocks.trollvidr.getId().func_110623_a()));
        this.generated(TFBlocks.unripe_trollber.getId().func_110623_a(), TwilightForestMod.prefix("block/" + TFBlocks.unripe_trollber.getId().func_110623_a()));
        this.generated(TFBlocks.trollber.getId().func_110623_a(), TwilightForestMod.prefix("block/" + TFBlocks.trollber.getId().func_110623_a()));
        this.toBlock((Block)TFBlocks.slider.get());
        this.generated(TFBlocks.huge_lilypad.getId().func_110623_a(), TwilightForestMod.prefix("block/" + TFBlocks.huge_lilypad.getId().func_110623_a()));
        this.generated(TFBlocks.huge_waterlily.getId().func_110623_a(), TwilightForestMod.prefix("block/" + TFBlocks.huge_waterlily.getId().func_110623_a()));
        this.toBlock((Block)TFBlocks.castle_brick.get());
        this.toBlock((Block)TFBlocks.castle_brick_worn.get());
        this.toBlock((Block)TFBlocks.castle_brick_cracked.get());
        this.toBlock((Block)TFBlocks.castle_brick_roof.get());
        this.toBlock((Block)TFBlocks.castle_brick_mossy.get());
        this.toBlock((Block)TFBlocks.castle_brick_frame.get());
        this.toBlock((Block)TFBlocks.castle_pillar_encased.get());
        this.toBlock((Block)TFBlocks.castle_pillar_encased_tile.get());
        this.toBlock((Block)TFBlocks.castle_pillar_bold.get());
        this.toBlock((Block)TFBlocks.castle_pillar_bold_tile.get());
        this.toBlock((Block)TFBlocks.castle_stairs_brick.get());
        this.toBlock((Block)TFBlocks.castle_stairs_worn.get());
        this.toBlock((Block)TFBlocks.castle_stairs_cracked.get());
        this.toBlock((Block)TFBlocks.castle_stairs_mossy.get());
        this.toBlock((Block)TFBlocks.castle_stairs_encased.get());
        this.toBlock((Block)TFBlocks.castle_stairs_bold.get());
        this.toBlockModel((Block)TFBlocks.castle_rune_brick_yellow.get(), "castle_rune_brick_0");
        this.toBlockModel((Block)TFBlocks.castle_rune_brick_purple.get(), "castle_rune_brick_0");
        this.toBlockModel((Block)TFBlocks.castle_rune_brick_pink.get(), "castle_rune_brick_0");
        this.toBlockModel((Block)TFBlocks.castle_rune_brick_blue.get(), "castle_rune_brick_0");
        this.generated(TFBlocks.force_field_pink.getId().func_110623_a(), TwilightForestMod.prefix("block/forcefield_white"));
        this.generated(TFBlocks.force_field_blue.getId().func_110623_a(), TwilightForestMod.prefix("block/forcefield_white"));
        this.generated(TFBlocks.force_field_green.getId().func_110623_a(), TwilightForestMod.prefix("block/forcefield_white"));
        this.generated(TFBlocks.force_field_purple.getId().func_110623_a(), TwilightForestMod.prefix("block/forcefield_white"));
        this.generated(TFBlocks.force_field_orange.getId().func_110623_a(), TwilightForestMod.prefix("block/forcefield_white"));
        this.toBlock((Block)TFBlocks.cinder_log.get());
        this.toBlock((Block)TFBlocks.cinder_wood.get());
        this.toBlockModel((Block)TFBlocks.cinder_furnace.get(), new ResourceLocation("block/furnace"));
        final ModelFile think115 = (ModelFile)this.generated("item/think115", TwilightForestMod.prefix("items/think115"));
        final ModelFile fullBlockSprinkle = (ModelFile)this.getExistingFile(TwilightForestMod.prefix("block/experiment115_8_8_regenerating"));
        this.generated(TFBlocks.experiment_115.getId().func_110623_a(), TwilightForestMod.prefix("items/experiment_115")).override().predicate(Experiment115Item.THINK, 1.0f).model(think115).end().override().predicate(Experiment115Item.FULL, 1.0f).model(fullBlockSprinkle).end();
        this.toBlockModel((Block)TFBlocks.twilight_portal_miniature_structure.get(), "miniature/portal");
        this.toBlockModel((Block)TFBlocks.naga_courtyard_miniature_structure.get(), "miniature/naga_courtyard");
        this.toBlockModel((Block)TFBlocks.lich_tower_miniature_structure.get(), "miniature/lich_tower");
        this.toBlock((Block)TFBlocks.knightmetal_block.get());
        this.toBlock((Block)TFBlocks.ironwood_block.get());
        this.toBlock((Block)TFBlocks.fiery_block.get());
        this.toBlock((Block)TFBlocks.arctic_fur_block.get());
        this.toBlock((Block)TFBlocks.steeleaf_block.get());
        this.toBlock((Block)TFBlocks.carminite_block.get());
        this.toBlock((Block)TFBlocks.maze_stone.get());
        this.toBlock((Block)TFBlocks.maze_stone_brick.get());
        this.toBlock((Block)TFBlocks.maze_stone_chiseled.get());
        this.toBlock((Block)TFBlocks.maze_stone_decorative.get());
        this.toBlock((Block)TFBlocks.maze_stone_cracked.get());
        this.toBlock((Block)TFBlocks.maze_stone_mossy.get());
        this.toBlock((Block)TFBlocks.maze_stone_mosaic.get());
        this.toBlock((Block)TFBlocks.maze_stone_border.get());
        this.toBlock((Block)TFBlocks.hedge.get());
        this.toBlock((Block)TFBlocks.root.get());
        this.toBlock((Block)TFBlocks.liveroot_block.get());
        this.toBlock((Block)TFBlocks.uncrafting_table.get());
        this.toBlockModel((Block)TFBlocks.boss_spawner_naga.get(), new ResourceLocation("block/spawner"));
        this.toBlockModel((Block)TFBlocks.boss_spawner_lich.get(), new ResourceLocation("block/spawner"));
        this.toBlockModel((Block)TFBlocks.boss_spawner_hydra.get(), new ResourceLocation("block/spawner"));
        this.toBlockModel((Block)TFBlocks.boss_spawner_ur_ghast.get(), new ResourceLocation("block/spawner"));
        this.toBlockModel((Block)TFBlocks.boss_spawner_knight_phantom.get(), new ResourceLocation("block/spawner"));
        this.toBlockModel((Block)TFBlocks.boss_spawner_snow_queen.get(), new ResourceLocation("block/spawner"));
        this.toBlockModel((Block)TFBlocks.boss_spawner_minoshroom.get(), new ResourceLocation("block/spawner"));
        this.toBlockModel((Block)TFBlocks.boss_spawner_alpha_yeti.get(), new ResourceLocation("block/spawner"));
        this.toBlockModel((Block)TFBlocks.boss_spawner_final_boss.get(), new ResourceLocation("block/spawner"));
        this.toBlock((Block)TFBlocks.firefly_jar.get());
        this.toBlock((Block)TFBlocks.cicada_jar.get());
        this.generated(TFBlocks.moss_patch.getId().func_110623_a(), TwilightForestMod.prefix("block/patch/moss"));
        this.generated(TFBlocks.mayapple.getId().func_110623_a(), TwilightForestMod.prefix("block/mayapple"));
        this.generated(TFBlocks.clover_patch.getId().func_110623_a(), TwilightForestMod.prefix("block/patch/clover"));
        this.generated(TFBlocks.fiddlehead.getId().func_110623_a(), TwilightForestMod.prefix("block/fiddlehead"));
        this.generated(TFBlocks.mushgloom.getId().func_110623_a(), TwilightForestMod.prefix("block/mushgloom"), TwilightForestMod.prefix("block/mushgloom_head"));
        this.generated(TFBlocks.torchberry_plant.getId().func_110623_a(), TwilightForestMod.prefix("block/torchberry_plant"), TwilightForestMod.prefix("block/torchberry_plant_glow"));
        this.generated(TFBlocks.root_strand.getId().func_110623_a(), TwilightForestMod.prefix("block/root_strand"));
        this.generated(TFBlocks.fallen_leaves.getId().func_110623_a(), new ResourceLocation("block/spruce_leaves"));
        this.toBlockModel((Block)TFBlocks.smoker.get(), TwilightForestMod.prefix("block/jet"));
        this.toBlockModel((Block)TFBlocks.fire_jet.get(), TwilightForestMod.prefix("block/jet"));
        this.toBlock((Block)TFBlocks.encased_smoker.get());
        this.toBlock((Block)TFBlocks.encased_fire_jet.get());
        this.toBlock((Block)TFBlocks.naga_stone.get());
        this.toBlock((Block)TFBlocks.naga_stone_head.get());
        this.toBlock((Block)TFBlocks.nagastone_pillar.get());
        this.toBlock((Block)TFBlocks.nagastone_pillar_mossy.get());
        this.toBlock((Block)TFBlocks.nagastone_pillar_weathered.get());
        this.toBlock((Block)TFBlocks.etched_nagastone.get());
        this.toBlock((Block)TFBlocks.etched_nagastone_mossy.get());
        this.toBlock((Block)TFBlocks.etched_nagastone_weathered.get());
        this.toBlock((Block)TFBlocks.nagastone_stairs_left.get());
        this.toBlock((Block)TFBlocks.nagastone_stairs_right.get());
        this.toBlock((Block)TFBlocks.nagastone_stairs_mossy_left.get());
        this.toBlock((Block)TFBlocks.nagastone_stairs_mossy_right.get());
        this.toBlock((Block)TFBlocks.nagastone_stairs_weathered_left.get());
        this.toBlock((Block)TFBlocks.nagastone_stairs_weathered_right.get());
        this.toBlockModel((Block)TFBlocks.spiral_bricks.get(), TwilightForestMod.prefix("block/spiral_bricks/x_spiral_bottom_right"));
        this.toBlock((Block)TFBlocks.stone_twist.get());
        this.toBlockModel((Block)TFBlocks.stone_twist_thin.get(), TwilightForestMod.prefix("block/pillar/pillar_inventory"));
        this.toBlock((Block)TFBlocks.oak_log.get());
        this.toBlock((Block)TFBlocks.stripped_oak_log.get());
        this.toBlock((Block)TFBlocks.oak_wood.get());
        this.toBlock((Block)TFBlocks.stripped_oak_wood.get());
        this.toBlock((Block)TFBlocks.oak_leaves.get());
        this.toBlock((Block)TFBlocks.rainboak_leaves.get());
        this.generated(TFBlocks.rainboak_sapling.getId().func_110623_a(), TwilightForestMod.prefix("block/" + TFBlocks.rainboak_sapling.getId().func_110623_a()));
        this.generated(TFBlocks.oak_sapling.getId().func_110623_a(), TwilightForestMod.prefix("block/" + TFBlocks.oak_sapling.getId().func_110623_a()));
        this.toBlock((Block)TFBlocks.twilight_oak_planks.get());
        this.toBlock((Block)TFBlocks.twilight_oak_stairs.get());
        this.toBlock((Block)TFBlocks.twilight_oak_slab.get());
        this.woodenButton((Block)TFBlocks.twilight_oak_button.get(), "twilight_oak");
        this.woodenFence((Block)TFBlocks.twilight_oak_fence.get(), "twilight_oak");
        this.toBlock((Block)TFBlocks.twilight_oak_gate.get());
        this.toBlock((Block)TFBlocks.twilight_oak_plate.get());
        this.toBlockModel((Block)TFBlocks.twilight_oak_trapdoor.get(), "twilight_oak_trapdoor_bottom");
        this.generated(TFBlocks.twilight_oak_sign.getId().func_110623_a(), TwilightForestMod.prefix("items/" + TFBlocks.twilight_oak_sign.getId().func_110623_a()));
        this.toBlock((Block)TFBlocks.canopy_log.get());
        this.toBlock((Block)TFBlocks.stripped_canopy_log.get());
        this.toBlock((Block)TFBlocks.canopy_wood.get());
        this.toBlock((Block)TFBlocks.stripped_canopy_wood.get());
        this.toBlock((Block)TFBlocks.canopy_leaves.get());
        this.generated(TFBlocks.canopy_sapling.getId().func_110623_a(), TwilightForestMod.prefix("block/" + TFBlocks.canopy_sapling.getId().func_110623_a()));
        this.toBlock((Block)TFBlocks.canopy_planks.get());
        this.toBlock((Block)TFBlocks.canopy_stairs.get());
        this.toBlock((Block)TFBlocks.canopy_slab.get());
        this.woodenButton((Block)TFBlocks.canopy_button.get(), "canopy");
        this.woodenFence((Block)TFBlocks.canopy_fence.get(), "canopy");
        this.toBlock((Block)TFBlocks.canopy_gate.get());
        this.toBlock((Block)TFBlocks.canopy_plate.get());
        this.toBlockModel((Block)TFBlocks.canopy_trapdoor.get(), "canopy_trapdoor_bottom");
        this.generated(TFBlocks.canopy_sign.getId().func_110623_a(), TwilightForestMod.prefix("items/" + TFBlocks.canopy_sign.getId().func_110623_a()));
        this.toBlock((Block)TFBlocks.mangrove_log.get());
        this.toBlock((Block)TFBlocks.stripped_mangrove_log.get());
        this.toBlock((Block)TFBlocks.mangrove_wood.get());
        this.toBlock((Block)TFBlocks.stripped_mangrove_wood.get());
        this.toBlock((Block)TFBlocks.mangrove_leaves.get());
        this.generated(TFBlocks.mangrove_sapling.getId().func_110623_a(), TwilightForestMod.prefix("block/" + TFBlocks.mangrove_sapling.getId().func_110623_a()));
        this.toBlock((Block)TFBlocks.mangrove_planks.get());
        this.toBlock((Block)TFBlocks.mangrove_stairs.get());
        this.toBlock((Block)TFBlocks.mangrove_slab.get());
        this.woodenButton((Block)TFBlocks.mangrove_button.get(), "mangrove");
        this.woodenFence((Block)TFBlocks.mangrove_fence.get(), "mangrove");
        this.toBlock((Block)TFBlocks.mangrove_gate.get());
        this.toBlock((Block)TFBlocks.mangrove_plate.get());
        this.toBlockModel((Block)TFBlocks.mangrove_trapdoor.get(), "mangrove_trapdoor_bottom");
        this.generated(TFBlocks.mangrove_sign.getId().func_110623_a(), TwilightForestMod.prefix("items/" + TFBlocks.mangrove_sign.getId().func_110623_a()));
        this.toBlock((Block)TFBlocks.dark_log.get());
        this.toBlock((Block)TFBlocks.stripped_dark_log.get());
        this.toBlock((Block)TFBlocks.dark_wood.get());
        this.toBlock((Block)TFBlocks.stripped_dark_wood.get());
        this.toBlock((Block)TFBlocks.dark_leaves.get());
        this.generated(TFBlocks.darkwood_sapling.getId().func_110623_a(), TwilightForestMod.prefix("block/" + TFBlocks.darkwood_sapling.getId().func_110623_a()));
        this.toBlock((Block)TFBlocks.dark_planks.get());
        this.toBlock((Block)TFBlocks.dark_stairs.get());
        this.toBlock((Block)TFBlocks.dark_slab.get());
        this.woodenButton((Block)TFBlocks.dark_button.get(), "darkwood");
        this.woodenFence((Block)TFBlocks.dark_fence.get(), "darkwood");
        this.toBlock((Block)TFBlocks.dark_gate.get());
        this.toBlock((Block)TFBlocks.dark_plate.get());
        this.toBlockModel((Block)TFBlocks.dark_trapdoor.get(), "dark_trapdoor_bottom");
        this.generated(TFBlocks.darkwood_sign.getId().func_110623_a(), TwilightForestMod.prefix("items/" + TFBlocks.darkwood_sign.getId().func_110623_a()));
        this.generated(TFBlocks.hollow_oak_sapling.getId().func_110623_a(), TwilightForestMod.prefix("block/" + TFBlocks.hollow_oak_sapling.getId().func_110623_a()));
        this.toBlock((Block)TFBlocks.time_log.get());
        this.toBlock((Block)TFBlocks.stripped_time_log.get());
        this.toBlock((Block)TFBlocks.time_wood.get());
        this.toBlock((Block)TFBlocks.stripped_time_wood.get());
        this.toBlock((Block)TFBlocks.time_log_core.get());
        this.toBlock((Block)TFBlocks.time_leaves.get());
        this.generated(TFBlocks.time_sapling.getId().func_110623_a(), TwilightForestMod.prefix("block/" + TFBlocks.time_sapling.getId().func_110623_a()));
        this.toBlock((Block)TFBlocks.time_planks.get());
        this.toBlock((Block)TFBlocks.time_stairs.get());
        this.toBlock((Block)TFBlocks.time_slab.get());
        this.woodenButton((Block)TFBlocks.time_button.get(), "time");
        this.woodenFence((Block)TFBlocks.time_fence.get(), "time");
        this.toBlock((Block)TFBlocks.time_gate.get());
        this.toBlock((Block)TFBlocks.time_plate.get());
        this.toBlockModel((Block)TFBlocks.time_trapdoor.get(), "time_trapdoor_bottom");
        this.generated(TFBlocks.time_sign.getId().func_110623_a(), TwilightForestMod.prefix("items/" + TFBlocks.time_sign.getId().func_110623_a()));
        this.toBlock((Block)TFBlocks.transformation_log.get());
        this.toBlock((Block)TFBlocks.stripped_transformation_log.get());
        this.toBlock((Block)TFBlocks.transformation_wood.get());
        this.toBlock((Block)TFBlocks.stripped_transformation_wood.get());
        this.toBlock((Block)TFBlocks.transformation_log_core.get());
        this.toBlock((Block)TFBlocks.transformation_leaves.get());
        this.generated(TFBlocks.transformation_sapling.getId().func_110623_a(), TwilightForestMod.prefix("block/" + TFBlocks.transformation_sapling.getId().func_110623_a()));
        this.toBlock((Block)TFBlocks.trans_planks.get());
        this.toBlock((Block)TFBlocks.trans_stairs.get());
        this.toBlock((Block)TFBlocks.trans_slab.get());
        this.woodenButton((Block)TFBlocks.trans_button.get(), "trans");
        this.woodenFence((Block)TFBlocks.trans_fence.get(), "trans");
        this.toBlock((Block)TFBlocks.trans_gate.get());
        this.toBlock((Block)TFBlocks.trans_plate.get());
        this.toBlockModel((Block)TFBlocks.trans_trapdoor.get(), "trans_trapdoor_bottom");
        this.generated(TFBlocks.trans_sign.getId().func_110623_a(), TwilightForestMod.prefix("items/" + TFBlocks.trans_sign.getId().func_110623_a()));
        this.toBlock((Block)TFBlocks.mining_log.get());
        this.toBlock((Block)TFBlocks.stripped_mining_log.get());
        this.toBlock((Block)TFBlocks.mining_wood.get());
        this.toBlock((Block)TFBlocks.stripped_mining_wood.get());
        this.toBlock((Block)TFBlocks.mining_log_core.get());
        this.toBlock((Block)TFBlocks.mining_leaves.get());
        this.generated(TFBlocks.mining_sapling.getId().func_110623_a(), TwilightForestMod.prefix("block/" + TFBlocks.mining_sapling.getId().func_110623_a()));
        this.toBlock((Block)TFBlocks.mine_planks.get());
        this.toBlock((Block)TFBlocks.mine_stairs.get());
        this.toBlock((Block)TFBlocks.mine_slab.get());
        this.woodenButton((Block)TFBlocks.mine_button.get(), "mine");
        this.woodenFence((Block)TFBlocks.mine_fence.get(), "mine");
        this.toBlock((Block)TFBlocks.mine_gate.get());
        this.toBlock((Block)TFBlocks.mine_plate.get());
        this.toBlockModel((Block)TFBlocks.mine_trapdoor.get(), "mine_trapdoor_bottom");
        this.generated(TFBlocks.mine_sign.getId().func_110623_a(), TwilightForestMod.prefix("items/" + TFBlocks.mine_sign.getId().func_110623_a()));
        this.toBlock((Block)TFBlocks.sorting_log.get());
        this.toBlock((Block)TFBlocks.stripped_sorting_log.get());
        this.toBlock((Block)TFBlocks.sorting_wood.get());
        this.toBlock((Block)TFBlocks.stripped_sorting_wood.get());
        this.toBlock((Block)TFBlocks.sorting_log_core.get());
        this.toBlock((Block)TFBlocks.sorting_leaves.get());
        this.generated(TFBlocks.sorting_sapling.getId().func_110623_a(), TwilightForestMod.prefix("block/" + TFBlocks.sorting_sapling.getId().func_110623_a()));
        this.toBlock((Block)TFBlocks.sort_planks.get());
        this.toBlock((Block)TFBlocks.sort_stairs.get());
        this.toBlock((Block)TFBlocks.sort_slab.get());
        this.woodenButton((Block)TFBlocks.sort_button.get(), "sort");
        this.woodenFence((Block)TFBlocks.sort_fence.get(), "sort");
        this.toBlock((Block)TFBlocks.sort_gate.get());
        this.toBlock((Block)TFBlocks.sort_plate.get());
        this.toBlockModel((Block)TFBlocks.sort_trapdoor.get(), "sort_trapdoor_bottom");
        this.generated(TFBlocks.sort_sign.getId().func_110623_a(), TwilightForestMod.prefix("items/" + TFBlocks.sort_sign.getId().func_110623_a()));
        this.singleTex(TFItems.naga_scale);
        this.singleTex(TFItems.naga_chestplate);
        this.singleTex(TFItems.naga_leggings);
        this.singleTexTool(TFItems.twilight_scepter);
        this.singleTexTool(TFItems.lifedrain_scepter);
        this.singleTexTool(TFItems.zombie_scepter);
        this.singleTexTool(TFItems.shield_scepter);
        this.singleTex(TFItems.ore_meter);
        this.singleTex(TFItems.magic_map);
        this.singleTex(TFItems.maze_map);
        this.biggerTex(TFItems.ore_map, TwilightForestMod.prefix("items/" + TFItems.ore_map.getId().func_110623_a()));
        this.singleTex(TFItems.raven_feather);
        this.singleTex(TFItems.magic_map_focus);
        this.singleTex(TFItems.maze_map_focus);
        this.singleTex(TFItems.liveroot);
        this.singleTex(TFItems.ironwood_raw);
        this.singleTex(TFItems.ironwood_ingot);
        this.singleTex(TFItems.ironwood_helmet);
        this.singleTex(TFItems.ironwood_chestplate);
        this.singleTex(TFItems.ironwood_leggings);
        this.singleTex(TFItems.ironwood_boots);
        this.singleTexTool(TFItems.ironwood_sword);
        this.singleTexTool(TFItems.ironwood_pickaxe);
        this.singleTexTool(TFItems.ironwood_axe);
        this.singleTexTool(TFItems.ironwood_shovel);
        this.singleTexTool(TFItems.ironwood_hoe);
        this.singleTex(TFItems.torchberries);
        this.singleTex(TFItems.raw_venison);
        this.singleTex(TFItems.cooked_venison);
        this.singleTex(TFItems.hydra_chop);
        this.singleTex(TFItems.fiery_blood);
        this.singleTex(TFItems.fiery_tears);
        this.singleTex(TFItems.fiery_ingot);
        this.singleTex(TFItems.fiery_helmet);
        this.singleTex(TFItems.fiery_chestplate);
        this.singleTex(TFItems.fiery_leggings);
        this.singleTex(TFItems.fiery_boots);
        this.singleTexTool(TFItems.fiery_sword);
        this.singleTexTool(TFItems.fiery_pickaxe);
        this.singleTex(TFItems.steeleaf_ingot);
        this.singleTex(TFItems.steeleaf_helmet);
        this.singleTex(TFItems.steeleaf_chestplate);
        this.singleTex(TFItems.steeleaf_leggings);
        this.singleTex(TFItems.steeleaf_boots);
        this.singleTexTool(TFItems.steeleaf_sword);
        this.singleTexTool(TFItems.steeleaf_pickaxe);
        this.singleTexTool(TFItems.steeleaf_axe);
        this.singleTexTool(TFItems.steeleaf_shovel);
        this.singleTexTool(TFItems.steeleaf_hoe);
        this.singleTexTool(TFItems.minotaur_axe_gold);
        this.singleTexTool(TFItems.minotaur_axe);
        this.singleTexTool(TFItems.mazebreaker_pickaxe);
        this.singleTex(TFItems.transformation_powder);
        this.singleTex(TFItems.raw_meef);
        this.singleTex(TFItems.cooked_meef);
        this.singleTex(TFItems.meef_stroganoff);
        this.singleTex(TFItems.maze_wafer);
        this.singleTex(TFItems.magic_map_empty);
        this.singleTex(TFItems.maze_map_empty);
        this.biggerTex(TFItems.ore_map_empty, TwilightForestMod.prefix("items/" + TFItems.ore_map_empty.getId().func_110623_a()));
        final ModelFile magnetPull1 = (ModelFile)this.generated("ore_magnet_pulling_1", TwilightForestMod.prefix("items/ore_magnet_pulling_1"));
        final ModelFile magnetPull2 = (ModelFile)this.generated("ore_magnet_pulling_2", TwilightForestMod.prefix("items/ore_magnet_pulling_2"));
        this.singleTex(TFItems.ore_magnet).override().predicate(new ResourceLocation("pulling"), 1.0f).predicate(new ResourceLocation("pull"), 0.5f).model(magnetPull1).end().override().predicate(new ResourceLocation("pulling"), 1.0f).predicate(new ResourceLocation("pull"), 1.0f).model(magnetPull2).end();
        this.singleTexTool(TFItems.crumble_horn);
        this.singleTexTool(TFItems.peacock_fan);
        final ModelFile queenAlt = (ModelFile)this.generated("moonworm_queen_alt", TwilightForestMod.prefix("items/moonworm_queen_alt"));
        this.singleTexTool(TFItems.moonworm_queen).override().predicate(TwilightForestMod.prefix("alt"), 1.0f).model(queenAlt).end();
        this.singleTex(TFItems.charm_of_keeping_1);
        this.singleTex(TFItems.charm_of_keeping_2);
        this.singleTex(TFItems.charm_of_keeping_3);
        this.singleTex(TFItems.charm_of_life_1);
        this.singleTex(TFItems.charm_of_life_2);
        this.singleTex(TFItems.tower_key);
        this.generated(TFItems.borer_essence.getId().func_110623_a(), TwilightForestMod.prefix("items/" + TFItems.borer_essence.getId().func_110623_a()), TwilightForestMod.prefix("items/borer_essence_particles"));
        this.singleTex(TFItems.carminite);
        this.singleTex(TFItems.armor_shard);
        this.singleTex(TFItems.armor_shard_cluster);
        this.singleTex(TFItems.knightmetal_ingot);
        this.biggerTex(TFItems.knightmetal_helmet, TwilightForestMod.prefix("items/" + TFItems.knightmetal_helmet.getId().func_110623_a()));
        this.singleTex(TFItems.knightmetal_chestplate);
        this.singleTex(TFItems.knightmetal_leggings);
        this.singleTex(TFItems.knightmetal_boots);
        this.singleTexTool(TFItems.knightmetal_sword);
        this.singleTexTool(TFItems.knightmetal_pickaxe);
        this.singleTexTool(TFItems.knightmetal_axe);
        this.singleTex(TFItems.knightmetal_ring);
        this.singleTex(TFItems.phantom_helmet);
        this.singleTex(TFItems.phantom_chestplate);
        this.singleTex(TFItems.lamp_of_cinders);
        this.singleTex(TFItems.alpha_fur);
        this.biggerTex(TFItems.yeti_helmet, TwilightForestMod.prefix("items/" + TFItems.yeti_helmet.getId().func_110623_a()));
        this.singleTex(TFItems.yeti_chestplate);
        this.singleTex(TFItems.yeti_leggings);
        this.singleTex(TFItems.yeti_boots);
        this.singleTex(TFItems.ice_bomb);
        this.singleTex(TFItems.arctic_fur);
        this.arcticArmorTex(TFItems.arctic_helmet);
        this.arcticArmorTex(TFItems.arctic_chestplate);
        this.arcticArmorTex(TFItems.arctic_leggings);
        this.arcticArmorTex(TFItems.arctic_boots);
        this.singleTex(TFItems.magic_beans);
        final ModelFile triplePulling0 = (ModelFile)this.bowItem("triple_bow_pulling_0", TwilightForestMod.prefix("items/triple_bow_pulling_0"));
        final ModelFile triplePulling2 = (ModelFile)this.bowItem("triple_bow_pulling_1", TwilightForestMod.prefix("items/triple_bow_pulling_1"));
        final ModelFile triplePulling3 = (ModelFile)this.bowItem("triple_bow_pulling_2", TwilightForestMod.prefix("items/triple_bow_pulling_2"));
        this.bowTex(TFItems.triple_bow, triplePulling0, triplePulling2, triplePulling3);
        final ModelFile seekerPulling0 = (ModelFile)this.bowItem("seeker_bow_pulling_0", TwilightForestMod.prefix("items/seeker_bow_pulling_0"));
        final ModelFile seekerPulling2 = (ModelFile)this.bowItem("seeker_bow_pulling_1", TwilightForestMod.prefix("items/seeker_bow_pulling_1"));
        final ModelFile seekerPulling3 = (ModelFile)this.bowItem("seeker_bow_pulling_2", TwilightForestMod.prefix("items/seeker_bow_pulling_2"));
        this.bowTex(TFItems.seeker_bow, seekerPulling0, seekerPulling2, seekerPulling3);
        final ModelFile icePulling0 = (ModelFile)this.bowItem("ice_bow_pulling_0", TwilightForestMod.prefix("items/ice_bow_solid_pulling_0"), TwilightForestMod.prefix("items/ice_bow_clear_pulling_0"));
        final ModelFile icePulling2 = (ModelFile)this.bowItem("ice_bow_pulling_1", TwilightForestMod.prefix("items/ice_bow_solid_pulling_1"), TwilightForestMod.prefix("items/ice_bow_clear_pulling_1"));
        final ModelFile icePulling3 = (ModelFile)this.bowItem("ice_bow_pulling_2", TwilightForestMod.prefix("items/ice_bow_solid_pulling_2"), TwilightForestMod.prefix("items/ice_bow_clear_pulling_2"));
        this.iceBowTex(TFItems.ice_bow, icePulling0, icePulling2, icePulling3);
        final ModelFile enderPulling0 = (ModelFile)this.bowItem("ender_bow_pulling_0", TwilightForestMod.prefix("items/ender_bow_pulling_0"));
        final ModelFile enderPulling2 = (ModelFile)this.bowItem("ender_bow_pulling_1", TwilightForestMod.prefix("items/ender_bow_pulling_1"));
        final ModelFile enderPulling3 = (ModelFile)this.bowItem("ender_bow_pulling_2", TwilightForestMod.prefix("items/ender_bow_pulling_2"));
        this.bowTex(TFItems.ender_bow, enderPulling0, enderPulling2, enderPulling3);
        this.tool(TFItems.ice_sword.getId().func_110623_a(), TwilightForestMod.prefix("items/ice_sword_solid"), TwilightForestMod.prefix("items/ice_sword_clear"));
        this.tool(TFItems.glass_sword.getId().func_110623_a(), TwilightForestMod.prefix("items/glass_sword_solid"), TwilightForestMod.prefix("items/glass_sword_clear"));
        final ModelFile chainThrown = (ModelFile)this.biggerTexString("block_and_chain_thrown", TwilightForestMod.prefix("items/block_and_chain_thrown"));
        this.biggerTex(TFItems.block_and_chain, TwilightForestMod.prefix("items/block_and_chain")).override().predicate(TwilightForestMod.prefix("thrown"), 1.0f).model(chainThrown).end();
        final ModelFile cubeThrown = (ModelFile)this.biggerTexString("cube_of_annihilation_thrown", TwilightForestMod.prefix("items/cube_of_annihilation_thrown"));
        this.biggerTex(TFItems.cube_of_annihilation, TwilightForestMod.prefix("items/cube_of_annihilation")).override().predicate(TwilightForestMod.prefix("thrown"), 1.0f).model(cubeThrown).end();
        this.singleTex(TFItems.cube_talisman);
        final ModelFile full = (ModelFile)this.phaseTex("moon_dial_full", TwilightForestMod.prefix("items/moon_dial/full"));
        final ModelFile waning_gib = (ModelFile)this.phaseTex("moon_dial_waning_gib", TwilightForestMod.prefix("items/moon_dial/waning_gibbous"));
        final ModelFile quarter3 = (ModelFile)this.phaseTex("moon_dial_quarter3", TwilightForestMod.prefix("items/moon_dial/third_quarter"));
        final ModelFile waning_cres = (ModelFile)this.phaseTex("moon_dial_waning_cres", TwilightForestMod.prefix("items/moon_dial/waning_cresent"));
        final ModelFile unlit = (ModelFile)this.phaseTex("moon_dial_new", TwilightForestMod.prefix("items/moon_dial/new"));
        final ModelFile waxing_cres = (ModelFile)this.phaseTex("moon_dial_waxing_cres", TwilightForestMod.prefix("items/moon_dial/waxing_cresent"));
        final ModelFile quarter4 = (ModelFile)this.phaseTex("moon_dial_quarter1", TwilightForestMod.prefix("items/moon_dial/first_quarter"));
        final ModelFile waxing_gib = (ModelFile)this.phaseTex("moon_dial_waxing_gib", TwilightForestMod.prefix("items/moon_dial/waxing_gibbous"));
        this.phaseTex(TFItems.moon_dial.getId().func_110623_a(), TwilightForestMod.prefix("items/moon_dial/full")).override().predicate(new ResourceLocation("phase"), 0.0f).model(full).end().override().predicate(new ResourceLocation("phase"), 0.125f).model(waning_gib).end().override().predicate(new ResourceLocation("phase"), 0.25f).model(quarter3).end().override().predicate(new ResourceLocation("phase"), 0.375f).model(waning_cres).end().override().predicate(new ResourceLocation("phase"), 0.5f).model(unlit).end().override().predicate(new ResourceLocation("phase"), 0.625f).model(waxing_cres).end().override().predicate(new ResourceLocation("phase"), 0.75f).model(quarter4).end().override().predicate(new ResourceLocation("phase"), 0.875f).model(waxing_gib).end();
        final ModelFile freshBook = (ModelFile)this.generated("logbook_0", TwilightForestMod.prefix("items/logbook/fresh"));
        final ModelFile usedBook = (ModelFile)this.generated("logbook_1", TwilightForestMod.prefix("items/logbook/used"));
        final ModelFile smortBook = (ModelFile)this.generated("logbook_2", TwilightForestMod.prefix("items/logbook/knowledgable"));
        final ModelFile masterBook = (ModelFile)this.generated("logbook_3", TwilightForestMod.prefix("items/logbook/supreme"));
        this.generated("logbook", TwilightForestMod.prefix("items/logbook/fresh")).override().predicate(new ResourceLocation("completion"), 0.0f).model(freshBook).end().override().predicate(new ResourceLocation("completion"), 0.333f).model(usedBook).end().override().predicate(new ResourceLocation("completion"), 0.666f).model(smortBook).end().override().predicate(new ResourceLocation("completion"), 1.0f).model(masterBook).end();
        ((ItemModelBuilder)((ItemModelBuilder)((ItemModelBuilder)this.withExistingParent("shader", TwilightForestMod.prefix("item/lunchcase"))).texture("missing", TwilightForestMod.prefix("block/fluffy_cloud"))).texture("face", TwilightForestMod.prefix("block/lunchbox_face"))).texture("side", TwilightForestMod.prefix("block/lunchbox_side"));
        this.withExistingParent("shader_bag_common", TwilightForestMod.prefix("item/shader"));
        this.withExistingParent("shader_bag_uncommon", TwilightForestMod.prefix("item/shader"));
        this.withExistingParent("shader_bag_rare", TwilightForestMod.prefix("item/shader"));
        this.withExistingParent("shader_bag_epic", TwilightForestMod.prefix("item/shader"));
        this.withExistingParent("shader_bag_ie_masterwork", TwilightForestMod.prefix("item/shader"));
        this.withExistingParent("shader_bag_twilight", TwilightForestMod.prefix("item/shader"));
        this.generated("trophy", TwilightForestMod.prefix("items/trophy"));
        this.generated("trophy_minor", TwilightForestMod.prefix("items/trophy_minor"));
        this.generated("trophy_quest", TwilightForestMod.prefix("items/trophy_quest"));
        this.generated("shield", TwilightForestMod.prefix("items/lich_shield_frame"), TwilightForestMod.prefix("items/lich_shield_fill"));
    }
    
    private ItemModelBuilder generated(final String name, final ResourceLocation... layers) {
        ItemModelBuilder builder = (ItemModelBuilder)this.withExistingParent(name, "item/generated");
        for (int i = 0; i < layers.length; ++i) {
            builder = (ItemModelBuilder)builder.texture("layer" + i, layers[i]);
        }
        return builder;
    }
    
    private ItemModelBuilder singleTexTool(final RegistryObject<Item> item) {
        return this.tool(item.getId().func_110623_a(), TwilightForestMod.prefix("items/" + item.getId().func_110623_a()));
    }
    
    private ItemModelBuilder tool(final String name, final ResourceLocation... layers) {
        ItemModelBuilder builder = (ItemModelBuilder)this.withExistingParent(name, "item/handheld");
        for (int i = 0; i < layers.length; ++i) {
            builder = (ItemModelBuilder)builder.texture("layer" + i, layers[i]);
        }
        return builder;
    }
    
    private ItemModelBuilder singleTex(final RegistryObject<Item> item) {
        return this.generated(item.getId().func_110623_a(), TwilightForestMod.prefix("items/" + item.getId().func_110623_a()));
    }
    
    private ItemModelBuilder biggerTex(final RegistryObject<Item> item, final ResourceLocation... layers) {
        ItemModelBuilder builder = (ItemModelBuilder)this.withExistingParent(item.getId().func_110623_a(), "twilightforest:item/util/overlap_gui");
        for (int i = 0; i < layers.length; ++i) {
            builder = (ItemModelBuilder)builder.texture("layer" + i, layers[i]);
        }
        return builder;
    }
    
    private ItemModelBuilder biggerTexString(final String name, final ResourceLocation... layers) {
        ItemModelBuilder builder = (ItemModelBuilder)this.withExistingParent(name, "twilightforest:item/util/overlap_gui");
        for (int i = 0; i < layers.length; ++i) {
            builder = (ItemModelBuilder)builder.texture("layer" + i, layers[i]);
        }
        return builder;
    }
    
    private ItemModelBuilder arcticArmorTex(final RegistryObject<Item> item) {
        return this.generated(item.getId().func_110623_a(), TwilightForestMod.prefix("items/" + item.getId().func_110623_a()), TwilightForestMod.prefix("items/" + item.getId().func_110623_a() + "_0"));
    }
    
    private ItemModelBuilder bowItem(final String name, final ResourceLocation... layers) {
        ItemModelBuilder builder = (ItemModelBuilder)this.withExistingParent(name, "item/bow");
        for (int i = 0; i < layers.length; ++i) {
            builder = (ItemModelBuilder)builder.texture("layer" + i, layers[i]);
        }
        return builder;
    }
    
    private ItemModelBuilder bowTex(final RegistryObject<Item> item, final ModelFile pull0, final ModelFile pull1, final ModelFile pull2) {
        return this.bowItem(item.getId().func_110623_a(), TwilightForestMod.prefix("items/" + item.getId().func_110623_a())).override().predicate(new ResourceLocation("pulling"), 1.0f).model(pull0).end().override().predicate(new ResourceLocation("pulling"), 1.0f).predicate(new ResourceLocation("pull"), 0.65f).model(pull1).end().override().predicate(new ResourceLocation("pulling"), 1.0f).predicate(new ResourceLocation("pull"), 0.9f).model(pull2).end();
    }
    
    private ItemModelBuilder iceBowTex(final RegistryObject<Item> item, final ModelFile pull0, final ModelFile pull1, final ModelFile pull2) {
        return this.bowItem(item.getId().func_110623_a(), TwilightForestMod.prefix("items/ice_bow_solid"), TwilightForestMod.prefix("items/ice_bow_clear")).override().predicate(new ResourceLocation("pulling"), 1.0f).model(pull0).end().override().predicate(new ResourceLocation("pulling"), 1.0f).predicate(new ResourceLocation("pull"), 0.65f).model(pull1).end().override().predicate(new ResourceLocation("pulling"), 1.0f).predicate(new ResourceLocation("pull"), 0.9f).model(pull2).end();
    }
    
    private ItemModelBuilder phaseTex(final String name, final ResourceLocation... layers) {
        ItemModelBuilder builder = (ItemModelBuilder)this.withExistingParent(name, "twilightforest:item/util/readable");
        for (int i = 0; i < layers.length; ++i) {
            builder = (ItemModelBuilder)builder.texture("layer" + i, layers[i]);
        }
        return builder;
    }
    
    private void woodenButton(final Block button, final String variant) {
        ((ItemModelBuilder)((ItemModelBuilder)this.getBuilder(button.getRegistryName().func_110623_a())).parent((ModelFile)this.getExistingFile(this.mcLoc("block/button_inventory")))).texture("texture", "block/wood/planks_" + variant + "_0");
    }
    
    private void woodenFence(final Block fence, final String variant) {
        ((ItemModelBuilder)((ItemModelBuilder)this.getBuilder(fence.getRegistryName().func_110623_a())).parent((ModelFile)this.getExistingFile(this.mcLoc("block/fence_inventory")))).texture("texture", "block/wood/planks_" + variant + "_0");
    }
    
    private void toBlock(final Block b) {
        this.toBlockModel(b, b.getRegistryName().func_110623_a());
    }
    
    private void toBlockModel(final Block b, final String model) {
        this.toBlockModel(b, TwilightForestMod.prefix("block/" + model));
    }
    
    private void toBlockModel(final Block b, final ResourceLocation model) {
        this.withExistingParent(b.getRegistryName().func_110623_a(), model);
    }
    
    public String func_200397_b() {
        return "TwilightForest item and itemblock models";
    }
}
