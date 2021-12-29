// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.data;

import twilightforest.block.HollowLogHorizontal;
import net.minecraftforge.fmllegacy.RegistryObject;
import java.util.Iterator;
import twilightforest.item.TFItems;
import twilightforest.item.Experiment115Item;
import twilightforest.TwilightForestMod;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Item;
import net.minecraft.core.Registry;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;

public class ItemModelGenerator extends ItemModelProvider
{
    public ItemModelGenerator(final DataGenerator generator, final ExistingFileHelper existingFileHelper) {
        super(generator, "twilightforest", existingFileHelper);
    }
    
    protected void registerModels() {
        for (final Item i : Registry.f_122827_) {
            if (i instanceof SpawnEggItem && i.getRegistryName().m_135827_().equals("twilightforest")) {
                ((ItemModelBuilder)this.getBuilder(i.getRegistryName().m_135815_())).parent((ModelFile)this.getExistingFile(new ResourceLocation("item/template_spawn_egg")));
            }
        }
        this.toBlock((Block)TFBlocks.TOWERWOOD.get());
        this.toBlock((Block)TFBlocks.ENCASED_TOWERWOOD.get());
        this.toBlock((Block)TFBlocks.CRACKED_TOWERWOOD.get());
        this.toBlock((Block)TFBlocks.MOSSY_TOWERWOOD.get());
        this.toBlock((Block)TFBlocks.INFESTED_TOWERWOOD.get());
        this.toBlock((Block)TFBlocks.CARMINITE_BUILDER.get());
        this.toBlock((Block)TFBlocks.ANTIBUILDER.get());
        this.toBlock((Block)TFBlocks.GHAST_TRAP.get());
        this.toBlock((Block)TFBlocks.VANISHING_BLOCK.get());
        this.toBlock((Block)TFBlocks.LOCKED_VANISHING_BLOCK.get());
        this.toBlock((Block)TFBlocks.REAPPEARING_BLOCK.get());
        this.toBlock((Block)TFBlocks.CARMINITE_REACTOR.get());
        this.toBlockModel((Block)TFBlocks.FAKE_GOLD.get(), new ResourceLocation("block/gold_block"));
        this.toBlockModel((Block)TFBlocks.FAKE_DIAMOND.get(), new ResourceLocation("block/diamond_block"));
        this.toBlock((Block)TFBlocks.STRONGHOLD_SHIELD.get());
        this.toBlock((Block)TFBlocks.TROPHY_PEDESTAL.get());
        this.toBlockModel((Block)TFBlocks.AURORA_BLOCK.get(), TwilightForestMod.prefix("block/aurora_block_0"));
        this.toBlock((Block)TFBlocks.AURORA_PILLAR.get());
        this.toBlock((Block)TFBlocks.AURORA_SLAB.get());
        this.toBlock((Block)TFBlocks.AURORALIZED_GLASS.get());
        this.toBlock((Block)TFBlocks.UNDERBRICK.get());
        this.toBlock((Block)TFBlocks.CRACKED_UNDERBRICK.get());
        this.toBlock((Block)TFBlocks.MOSSY_UNDERBRICK.get());
        this.toBlock((Block)TFBlocks.UNDERBRICK_FLOOR.get());
        this.toBlock((Block)TFBlocks.GREEN_THORNS.get());
        this.toBlock((Block)TFBlocks.BROWN_THORNS.get());
        this.toBlock((Block)TFBlocks.BURNT_THORNS.get());
        this.generated(TFBlocks.THORN_ROSE.getId().m_135815_(), TwilightForestMod.prefix("block/" + TFBlocks.THORN_ROSE.getId().m_135815_()));
        this.toBlockModel((Block)TFBlocks.THORN_LEAVES.get(), new ResourceLocation("block/oak_leaves"));
        this.toBlockModel((Block)TFBlocks.BEANSTALK_LEAVES.get(), new ResourceLocation("block/spruce_leaves"));
        this.toBlock((Block)TFBlocks.DEADROCK.get());
        this.toBlock((Block)TFBlocks.CRACKED_DEADROCK.get());
        this.toBlock((Block)TFBlocks.WEATHERED_DEADROCK.get());
        ((ItemModelBuilder)((ItemModelBuilder)this.getBuilder(TFBlocks.TROLLSTEINN.getId().m_135815_())).parent((ModelFile)this.getExistingFile(new ResourceLocation("block/cube_all")))).texture("all", TwilightForestMod.prefix("block/trollsteinn"));
        this.toBlock((Block)TFBlocks.WISPY_CLOUD.get());
        this.toBlock((Block)TFBlocks.FLUFFY_CLOUD.get());
        this.toBlockModel((Block)TFBlocks.GIANT_COBBLESTONE.get(), new ResourceLocation("block/cobblestone"));
        this.toBlockModel((Block)TFBlocks.GIANT_LOG.get(), new ResourceLocation("block/oak_log"));
        this.toBlockModel((Block)TFBlocks.GIANT_LEAVES.get(), new ResourceLocation("block/oak_leaves"));
        this.toBlockModel((Block)TFBlocks.GIANT_OBSIDIAN.get(), new ResourceLocation("block/obsidian"));
        this.toBlock((Block)TFBlocks.UBEROUS_SOIL.get());
        this.toBlock((Block)TFBlocks.HUGE_STALK.get());
        ((ItemModelBuilder)((ItemModelBuilder)this.getBuilder(TFBlocks.HUGE_MUSHGLOOM.getId().m_135815_())).parent((ModelFile)this.getExistingFile(new ResourceLocation("block/cube_all")))).texture("all", TwilightForestMod.prefix("block/huge_gloom_cap"));
        ((ItemModelBuilder)((ItemModelBuilder)this.getBuilder(TFBlocks.HUGE_MUSHGLOOM_STEM.getId().m_135815_())).parent((ModelFile)this.getExistingFile(new ResourceLocation("block/cube_all")))).texture("all", TwilightForestMod.prefix("block/huge_mushgloom_stem"));
        this.generated(TFBlocks.TROLLVIDR.getId().m_135815_(), TwilightForestMod.prefix("block/" + TFBlocks.TROLLVIDR.getId().m_135815_()));
        this.generated(TFBlocks.UNRIPE_TROLLBER.getId().m_135815_(), TwilightForestMod.prefix("block/" + TFBlocks.UNRIPE_TROLLBER.getId().m_135815_()));
        this.generated(TFBlocks.TROLLBER.getId().m_135815_(), TwilightForestMod.prefix("block/" + TFBlocks.TROLLBER.getId().m_135815_()));
        this.toBlock((Block)TFBlocks.SLIDER.get());
        this.generated(TFBlocks.HUGE_LILY_PAD.getId().m_135815_(), TwilightForestMod.prefix("block/" + TFBlocks.HUGE_LILY_PAD.getId().m_135815_()));
        this.generated(TFBlocks.HUGE_WATER_LILY.getId().m_135815_(), TwilightForestMod.prefix("block/" + TFBlocks.HUGE_WATER_LILY.getId().m_135815_()));
        this.toBlock((Block)TFBlocks.CASTLE_BRICK.get());
        this.toBlock((Block)TFBlocks.WORN_CASTLE_BRICK.get());
        this.toBlock((Block)TFBlocks.CRACKED_CASTLE_BRICK.get());
        this.toBlock((Block)TFBlocks.CASTLE_ROOF_TILE.get());
        this.toBlock((Block)TFBlocks.MOSSY_CASTLE_BRICK.get());
        this.toBlock((Block)TFBlocks.THICK_CASTLE_BRICK.get());
        this.toBlock((Block)TFBlocks.ENCASED_CASTLE_BRICK_PILLAR.get());
        this.toBlock((Block)TFBlocks.ENCASED_CASTLE_BRICK_TILE.get());
        this.toBlock((Block)TFBlocks.BOLD_CASTLE_BRICK_PILLAR.get());
        this.toBlock((Block)TFBlocks.BOLD_CASTLE_BRICK_TILE.get());
        this.toBlock((Block)TFBlocks.CASTLE_BRICK_STAIRS.get());
        this.toBlock((Block)TFBlocks.WORN_CASTLE_BRICK_STAIRS.get());
        this.toBlock((Block)TFBlocks.CRACKED_CASTLE_BRICK_STAIRS.get());
        this.toBlock((Block)TFBlocks.MOSSY_CASTLE_BRICK_STAIRS.get());
        this.toBlock((Block)TFBlocks.ENCASED_CASTLE_BRICK_STAIRS.get());
        this.toBlock((Block)TFBlocks.BOLD_CASTLE_BRICK_STAIRS.get());
        this.toBlockModel((Block)TFBlocks.YELLOW_CASTLE_RUNE_BRICK.get(), "castle_rune_brick_0");
        this.toBlockModel((Block)TFBlocks.VIOLET_CASTLE_RUNE_BRICK.get(), "castle_rune_brick_0");
        this.toBlockModel((Block)TFBlocks.PINK_CASTLE_RUNE_BRICK.get(), "castle_rune_brick_0");
        this.toBlockModel((Block)TFBlocks.BLUE_CASTLE_RUNE_BRICK.get(), "castle_rune_brick_0");
        this.generated(TFBlocks.PINK_FORCE_FIELD.getId().m_135815_(), TwilightForestMod.prefix("block/forcefield_white"));
        this.generated(TFBlocks.BLUE_FORCE_FIELD.getId().m_135815_(), TwilightForestMod.prefix("block/forcefield_white"));
        this.generated(TFBlocks.GREEN_FORCE_FIELD.getId().m_135815_(), TwilightForestMod.prefix("block/forcefield_white"));
        this.generated(TFBlocks.VIOLET_FORCE_FIELD.getId().m_135815_(), TwilightForestMod.prefix("block/forcefield_white"));
        this.generated(TFBlocks.ORANGE_FORCE_FIELD.getId().m_135815_(), TwilightForestMod.prefix("block/forcefield_white"));
        this.toBlock((Block)TFBlocks.CINDER_LOG.get());
        this.toBlock((Block)TFBlocks.CINDER_WOOD.get());
        this.toBlockModel((Block)TFBlocks.CINDER_FURNACE.get(), new ResourceLocation("block/furnace"));
        final ModelFile think115 = (ModelFile)this.generated("item/think115", TwilightForestMod.prefix("items/think115"));
        final ModelFile fullBlockSprinkle = (ModelFile)this.getExistingFile(TwilightForestMod.prefix("block/experiment115_8_8_regenerating"));
        this.generated(TFBlocks.EXPERIMENT_115.getId().m_135815_(), TwilightForestMod.prefix("items/experiment_115")).override().predicate(Experiment115Item.THINK, 1.0f).model(think115).end().override().predicate(Experiment115Item.FULL, 1.0f).model(fullBlockSprinkle).end();
        this.toBlockModel((Block)TFBlocks.TWILIGHT_PORTAL_MINIATURE_STRUCTURE.get(), "miniature/portal");
        this.toBlockModel((Block)TFBlocks.NAGA_COURTYARD_MINIATURE_STRUCTURE.get(), "miniature/naga_courtyard");
        this.toBlockModel((Block)TFBlocks.LICH_TOWER_MINIATURE_STRUCTURE.get(), "miniature/lich_tower");
        this.toBlock((Block)TFBlocks.KNIGHTMETAL_BLOCK.get());
        this.toBlock((Block)TFBlocks.IRONWOOD_BLOCK.get());
        this.toBlock((Block)TFBlocks.FIERY_BLOCK.get());
        this.toBlock((Block)TFBlocks.ARCTIC_FUR_BLOCK.get());
        this.toBlock((Block)TFBlocks.STEELEAF_BLOCK.get());
        this.toBlock((Block)TFBlocks.CARMINITE_BLOCK.get());
        this.toBlock((Block)TFBlocks.MAZESTONE.get());
        this.toBlock((Block)TFBlocks.MAZESTONE_BRICK.get());
        this.toBlock((Block)TFBlocks.CUT_MAZESTONE.get());
        this.toBlock((Block)TFBlocks.DECORATIVE_MAZESTONE.get());
        this.toBlock((Block)TFBlocks.CRACKED_MAZESTONE.get());
        this.toBlock((Block)TFBlocks.MOSSY_MAZESTONE.get());
        this.toBlock((Block)TFBlocks.MAZESTONE_MOSAIC.get());
        this.toBlock((Block)TFBlocks.MAZESTONE_BORDER.get());
        this.toBlock((Block)TFBlocks.HEDGE.get());
        this.toBlock((Block)TFBlocks.ROOT_BLOCK.get());
        this.toBlock((Block)TFBlocks.LIVEROOT_BLOCK.get());
        this.toBlock((Block)TFBlocks.MANGROVE_ROOT.get());
        this.toBlock((Block)TFBlocks.UNCRAFTING_TABLE.get());
        this.toBlockModel((Block)TFBlocks.NAGA_BOSS_SPAWNER.get(), new ResourceLocation("block/spawner"));
        this.toBlockModel((Block)TFBlocks.LICH_BOSS_SPAWNER.get(), new ResourceLocation("block/spawner"));
        this.toBlockModel((Block)TFBlocks.HYDRA_BOSS_SPAWNER.get(), new ResourceLocation("block/spawner"));
        this.toBlockModel((Block)TFBlocks.UR_GHAST_BOSS_SPAWNER.get(), new ResourceLocation("block/spawner"));
        this.toBlockModel((Block)TFBlocks.KNIGHT_PHANTOM_BOSS_SPAWNER.get(), new ResourceLocation("block/spawner"));
        this.toBlockModel((Block)TFBlocks.SNOW_QUEEN_BOSS_SPAWNER.get(), new ResourceLocation("block/spawner"));
        this.toBlockModel((Block)TFBlocks.MINOSHROOM_BOSS_SPAWNER.get(), new ResourceLocation("block/spawner"));
        this.toBlockModel((Block)TFBlocks.ALPHA_YETI_BOSS_SPAWNER.get(), new ResourceLocation("block/spawner"));
        this.toBlockModel((Block)TFBlocks.FINAL_BOSS_BOSS_SPAWNER.get(), new ResourceLocation("block/spawner"));
        this.toBlock((Block)TFBlocks.FIREFLY_JAR.get());
        this.toBlock((Block)TFBlocks.FIREFLY_SPAWNER.get());
        this.toBlock((Block)TFBlocks.CICADA_JAR.get());
        this.generated(TFBlocks.MOSS_PATCH.getId().m_135815_(), TwilightForestMod.prefix("block/patch/moss"));
        this.generated(TFBlocks.MAYAPPLE.getId().m_135815_(), TwilightForestMod.prefix("block/mayapple"));
        this.generated(TFBlocks.CLOVER_PATCH.getId().m_135815_(), TwilightForestMod.prefix("block/patch/clover"));
        this.generated(TFBlocks.FIDDLEHEAD.getId().m_135815_(), TwilightForestMod.prefix("block/fiddlehead"));
        this.generated(TFBlocks.MUSHGLOOM.getId().m_135815_(), TwilightForestMod.prefix("block/mushgloom"), TwilightForestMod.prefix("block/mushgloom_head"));
        this.generated(TFBlocks.TORCHBERRY_PLANT.getId().m_135815_(), TwilightForestMod.prefix("block/torchberry_plant"));
        this.generated(TFBlocks.ROOT_STRAND.getId().m_135815_(), TwilightForestMod.prefix("block/root_strand"));
        this.generated(TFBlocks.FALLEN_LEAVES.getId().m_135815_(), new ResourceLocation("block/oak_leaves"));
        this.toBlockModel((Block)TFBlocks.SMOKER.get(), TwilightForestMod.prefix("block/jet"));
        this.toBlockModel((Block)TFBlocks.FIRE_JET.get(), TwilightForestMod.prefix("block/jet"));
        this.toBlock((Block)TFBlocks.ENCASED_SMOKER.get());
        this.toBlock((Block)TFBlocks.ENCASED_FIRE_JET.get());
        this.toBlock((Block)TFBlocks.NAGASTONE.get());
        this.toBlock((Block)TFBlocks.NAGASTONE_HEAD.get());
        this.toBlock((Block)TFBlocks.NAGASTONE_PILLAR.get());
        this.toBlock((Block)TFBlocks.MOSSY_NAGASTONE_PILLAR.get());
        this.toBlock((Block)TFBlocks.CRACKED_NAGASTONE_PILLAR.get());
        this.toBlock((Block)TFBlocks.ETCHED_NAGASTONE.get());
        this.toBlock((Block)TFBlocks.MOSSY_ETCHED_NAGASTONE.get());
        this.toBlock((Block)TFBlocks.CRACKED_ETCHED_NAGASTONE.get());
        this.toBlock((Block)TFBlocks.NAGASTONE_STAIRS_LEFT.get());
        this.toBlock((Block)TFBlocks.NAGASTONE_STAIRS_RIGHT.get());
        this.toBlock((Block)TFBlocks.CRACKED_NAGASTONE_STAIRS_LEFT.get());
        this.toBlock((Block)TFBlocks.CRACKED_NAGASTONE_STAIRS_RIGHT.get());
        this.toBlock((Block)TFBlocks.MOSSY_NAGASTONE_STAIRS_LEFT.get());
        this.toBlock((Block)TFBlocks.MOSSY_NAGASTONE_STAIRS_RIGHT.get());
        this.toBlockModel((Block)TFBlocks.SPIRAL_BRICKS.get(), TwilightForestMod.prefix("block/spiral_bricks/x_spiral_bottom_right"));
        this.toBlock((Block)TFBlocks.TWISTED_STONE.get());
        this.toBlockModel((Block)TFBlocks.TWISTED_STONE_PILLAR.get(), TwilightForestMod.prefix("block/pillar/pillar_inventory"));
        this.toBlock((Block)TFBlocks.BOLD_STONE_PILLAR.get());
        this.toBlockModel((Block)TFBlocks.DEATH_TOME_SPAWNER.get(), TwilightForestMod.prefix("block/death_tome_spawner_10"));
        this.toBlock((Block)TFBlocks.EMPTY_CANOPY_BOOKSHELF.get());
        this.toBlock((Block)TFBlocks.CANOPY_BOOKSHELF.get());
        this.toBlockModel((Block)TFBlocks.CANDELABRA.get(), "candelabra_4_5_4_plain");
        ((ItemModelBuilder)this.withExistingParent(TFBlocks.OAK_BANISTER.getId().toString(), TwilightForestMod.prefix("item/banister_item"))).texture("texture", "minecraft:block/oak_planks");
        ((ItemModelBuilder)this.withExistingParent(TFBlocks.SPRUCE_BANISTER.getId().toString(), TwilightForestMod.prefix("item/banister_item"))).texture("texture", "minecraft:block/spruce_planks");
        ((ItemModelBuilder)this.withExistingParent(TFBlocks.BIRCH_BANISTER.getId().toString(), TwilightForestMod.prefix("item/banister_item"))).texture("texture", "minecraft:block/birch_planks");
        ((ItemModelBuilder)this.withExistingParent(TFBlocks.JUNGLE_BANISTER.getId().toString(), TwilightForestMod.prefix("item/banister_item"))).texture("texture", "minecraft:block/jungle_planks");
        ((ItemModelBuilder)this.withExistingParent(TFBlocks.ACACIA_BANISTER.getId().toString(), TwilightForestMod.prefix("item/banister_item"))).texture("texture", "minecraft:block/acacia_planks");
        ((ItemModelBuilder)this.withExistingParent(TFBlocks.DARK_OAK_BANISTER.getId().toString(), TwilightForestMod.prefix("item/banister_item"))).texture("texture", "minecraft:block/dark_oak_planks");
        ((ItemModelBuilder)this.withExistingParent(TFBlocks.CRIMSON_BANISTER.getId().toString(), TwilightForestMod.prefix("item/banister_item"))).texture("texture", "minecraft:block/crimson_planks");
        ((ItemModelBuilder)this.withExistingParent(TFBlocks.WARPED_BANISTER.getId().toString(), TwilightForestMod.prefix("item/banister_item"))).texture("texture", "minecraft:block/warped_planks");
        this.toBlock((Block)TFBlocks.TWILIGHT_OAK_LOG.get());
        this.toBlock((Block)TFBlocks.STRIPPED_TWILIGHT_OAK_LOG.get());
        this.toBlock((Block)TFBlocks.TWILIGHT_OAK_WOOD.get());
        this.toBlock((Block)TFBlocks.STRIPPED_TWILIGHT_OAK_WOOD.get());
        this.toBlock((Block)TFBlocks.TWILIGHT_OAK_LEAVES.get());
        this.toBlock((Block)TFBlocks.RAINBOW_OAK_LEAVES.get());
        this.generated(TFBlocks.RAINBOW_OAK_SAPLING.getId().m_135815_(), TwilightForestMod.prefix("block/" + TFBlocks.RAINBOW_OAK_SAPLING.getId().m_135815_()));
        this.generated(TFBlocks.TWILIGHT_OAK_SAPLING.getId().m_135815_(), TwilightForestMod.prefix("block/" + TFBlocks.TWILIGHT_OAK_SAPLING.getId().m_135815_()));
        this.toBlock((Block)TFBlocks.TWILIGHT_OAK_PLANKS.get());
        this.toBlock((Block)TFBlocks.TWILIGHT_OAK_STAIRS.get());
        this.toBlock((Block)TFBlocks.TWILIGHT_OAK_SLAB.get());
        this.woodenButton((Block)TFBlocks.TWILIGHT_OAK_BUTTON.get(), "twilight_oak");
        this.woodenFence((Block)TFBlocks.TWILIGHT_OAK_FENCE.get(), "twilight_oak");
        this.toBlock((Block)TFBlocks.TWILIGHT_OAK_GATE.get());
        this.toBlock((Block)TFBlocks.TWILIGHT_OAK_PLATE.get());
        this.toBlockModel((Block)TFBlocks.TWILIGHT_OAK_TRAPDOOR.get(), "twilight_oak_trapdoor_bottom");
        this.generated(TFBlocks.TWILIGHT_OAK_SIGN.getId().m_135815_(), TwilightForestMod.prefix("items/" + TFBlocks.TWILIGHT_OAK_SIGN.getId().m_135815_()));
        ((ItemModelBuilder)this.withExistingParent(TFBlocks.TWILIGHT_OAK_BANISTER.getId().toString(), TwilightForestMod.prefix("item/banister_item"))).texture("texture", "block/wood/planks_twilight_oak_0");
        this.generated(TFBlocks.TWILIGHT_OAK_DOOR.getId().m_135815_(), TwilightForestMod.prefix("items/" + TFBlocks.TWILIGHT_OAK_DOOR.getId().m_135815_()));
        this.toBlock((Block)TFBlocks.CANOPY_LOG.get());
        this.toBlock((Block)TFBlocks.STRIPPED_CANOPY_LOG.get());
        this.toBlock((Block)TFBlocks.CANOPY_WOOD.get());
        this.toBlock((Block)TFBlocks.STRIPPED_CANOPY_WOOD.get());
        this.toBlock((Block)TFBlocks.CANOPY_LEAVES.get());
        this.generated(TFBlocks.CANOPY_SAPLING.getId().m_135815_(), TwilightForestMod.prefix("block/" + TFBlocks.CANOPY_SAPLING.getId().m_135815_()));
        this.toBlock((Block)TFBlocks.CANOPY_PLANKS.get());
        this.toBlock((Block)TFBlocks.CANOPY_STAIRS.get());
        this.toBlock((Block)TFBlocks.CANOPY_SLAB.get());
        this.woodenButton((Block)TFBlocks.CANOPY_BUTTON.get(), "canopy");
        this.woodenFence((Block)TFBlocks.CANOPY_FENCE.get(), "canopy");
        this.toBlock((Block)TFBlocks.CANOPY_GATE.get());
        this.toBlock((Block)TFBlocks.CANOPY_PLATE.get());
        this.toBlockModel((Block)TFBlocks.CANOPY_TRAPDOOR.get(), "canopy_trapdoor_bottom");
        this.generated(TFBlocks.CANOPY_SIGN.getId().m_135815_(), TwilightForestMod.prefix("items/" + TFBlocks.CANOPY_SIGN.getId().m_135815_()));
        ((ItemModelBuilder)this.withExistingParent(TFBlocks.CANOPY_BANISTER.getId().toString(), TwilightForestMod.prefix("item/banister_item"))).texture("texture", "block/wood/planks_canopy_0");
        this.generated(TFBlocks.CANOPY_DOOR.getId().m_135815_(), TwilightForestMod.prefix("items/" + TFBlocks.CANOPY_DOOR.getId().m_135815_()));
        this.toBlock((Block)TFBlocks.MANGROVE_LOG.get());
        this.toBlock((Block)TFBlocks.STRIPPED_MANGROVE_LOG.get());
        this.toBlock((Block)TFBlocks.MANGROVE_WOOD.get());
        this.toBlock((Block)TFBlocks.STRIPPED_MANGROVE_WOOD.get());
        this.toBlock((Block)TFBlocks.MANGROVE_LEAVES.get());
        this.generated(TFBlocks.MANGROVE_SAPLING.getId().m_135815_(), TwilightForestMod.prefix("block/" + TFBlocks.MANGROVE_SAPLING.getId().m_135815_()));
        this.toBlock((Block)TFBlocks.MANGROVE_PLANKS.get());
        this.toBlock((Block)TFBlocks.MANGROVE_STAIRS.get());
        this.toBlock((Block)TFBlocks.MANGROVE_SLAB.get());
        this.woodenButton((Block)TFBlocks.MANGROVE_BUTTON.get(), "mangrove");
        this.woodenFence((Block)TFBlocks.MANGROVE_FENCE.get(), "mangrove");
        this.toBlock((Block)TFBlocks.MANGROVE_GATE.get());
        this.toBlock((Block)TFBlocks.MANGROVE_PLATE.get());
        this.toBlockModel((Block)TFBlocks.MANGROVE_TRAPDOOR.get(), "mangrove_trapdoor_bottom");
        this.generated(TFBlocks.MANGROVE_SIGN.getId().m_135815_(), TwilightForestMod.prefix("items/" + TFBlocks.MANGROVE_SIGN.getId().m_135815_()));
        ((ItemModelBuilder)this.withExistingParent(TFBlocks.MANGROVE_BANISTER.getId().toString(), TwilightForestMod.prefix("item/banister_item"))).texture("texture", "block/wood/planks_mangrove_0");
        this.generated(TFBlocks.MANGROVE_DOOR.getId().m_135815_(), TwilightForestMod.prefix("items/" + TFBlocks.MANGROVE_DOOR.getId().m_135815_()));
        this.toBlock((Block)TFBlocks.DARK_LOG.get());
        this.toBlock((Block)TFBlocks.STRIPPED_DARK_LOG.get());
        this.toBlock((Block)TFBlocks.DARK_WOOD.get());
        this.toBlock((Block)TFBlocks.STRIPPED_DARK_WOOD.get());
        this.toBlock((Block)TFBlocks.DARK_LEAVES.get());
        this.generated(TFBlocks.DARKWOOD_SAPLING.getId().m_135815_(), TwilightForestMod.prefix("block/" + TFBlocks.DARKWOOD_SAPLING.getId().m_135815_()));
        this.toBlock((Block)TFBlocks.DARK_PLANKS.get());
        this.toBlock((Block)TFBlocks.DARK_STAIRS.get());
        this.toBlock((Block)TFBlocks.DARK_SLAB.get());
        this.woodenButton((Block)TFBlocks.DARK_BUTTON.get(), "darkwood");
        this.woodenFence((Block)TFBlocks.DARK_FENCE.get(), "darkwood");
        this.toBlock((Block)TFBlocks.DARK_GATE.get());
        this.toBlock((Block)TFBlocks.DARK_PLATE.get());
        this.toBlockModel((Block)TFBlocks.DARK_TRAPDOOR.get(), "dark_trapdoor_bottom");
        this.generated(TFBlocks.DARKWOOD_SIGN.getId().m_135815_(), TwilightForestMod.prefix("items/" + TFBlocks.DARKWOOD_SIGN.getId().m_135815_()));
        ((ItemModelBuilder)this.withExistingParent(TFBlocks.DARKWOOD_BANISTER.getId().toString(), TwilightForestMod.prefix("item/banister_item"))).texture("texture", "block/wood/planks_darkwood_0");
        this.generated(TFBlocks.DARK_DOOR.getId().m_135815_(), TwilightForestMod.prefix("items/" + TFBlocks.DARK_DOOR.getId().m_135815_()));
        this.generated(TFBlocks.HOLLOW_OAK_SAPLING.getId().m_135815_(), TwilightForestMod.prefix("block/" + TFBlocks.HOLLOW_OAK_SAPLING.getId().m_135815_()));
        this.toBlock((Block)TFBlocks.TIME_LOG.get());
        this.toBlock((Block)TFBlocks.STRIPPED_TIME_LOG.get());
        this.toBlock((Block)TFBlocks.TIME_WOOD.get());
        this.toBlock((Block)TFBlocks.STRIPPED_TIME_WOOD.get());
        this.toBlock((Block)TFBlocks.TIME_LOG_CORE.get());
        this.toBlock((Block)TFBlocks.TIME_LEAVES.get());
        this.generated(TFBlocks.TIME_SAPLING.getId().m_135815_(), TwilightForestMod.prefix("block/" + TFBlocks.TIME_SAPLING.getId().m_135815_()));
        this.toBlock((Block)TFBlocks.TIME_PLANKS.get());
        this.toBlock((Block)TFBlocks.TIME_STAIRS.get());
        this.toBlock((Block)TFBlocks.TIME_SLAB.get());
        this.woodenButton((Block)TFBlocks.TIME_BUTTON.get(), "time");
        this.woodenFence((Block)TFBlocks.TIME_FENCE.get(), "time");
        this.toBlock((Block)TFBlocks.TIME_GATE.get());
        this.toBlock((Block)TFBlocks.TIME_PLATE.get());
        this.toBlockModel((Block)TFBlocks.TIME_TRAPDOOR.get(), "time_trapdoor_bottom");
        this.generated(TFBlocks.TIME_SIGN.getId().m_135815_(), TwilightForestMod.prefix("items/" + TFBlocks.TIME_SIGN.getId().m_135815_()));
        ((ItemModelBuilder)this.withExistingParent(TFBlocks.TIME_BANISTER.getId().toString(), TwilightForestMod.prefix("item/banister_item"))).texture("texture", "block/wood/planks_time_0");
        this.generated(TFBlocks.TIME_DOOR.getId().m_135815_(), TwilightForestMod.prefix("items/" + TFBlocks.TIME_DOOR.getId().m_135815_()));
        this.toBlock((Block)TFBlocks.TRANSFORMATION_LOG.get());
        this.toBlock((Block)TFBlocks.STRIPPED_TRANSFORMATION_LOG.get());
        this.toBlock((Block)TFBlocks.TRANSFORMATION_WOOD.get());
        this.toBlock((Block)TFBlocks.STRIPPED_TRANSFORMATION_WOOD.get());
        this.toBlock((Block)TFBlocks.TRANSFORMATION_LOG_CORE.get());
        this.toBlock((Block)TFBlocks.TRANSFORMATION_LEAVES.get());
        this.generated(TFBlocks.TRANSFORMATION_SAPLING.getId().m_135815_(), TwilightForestMod.prefix("block/" + TFBlocks.TRANSFORMATION_SAPLING.getId().m_135815_()));
        this.toBlock((Block)TFBlocks.TRANSFORMATION_PLANKS.get());
        this.toBlock((Block)TFBlocks.TRANSFORMATION_STAIRS.get());
        this.toBlock((Block)TFBlocks.TRANSFORMATION_SLAB.get());
        this.woodenButton((Block)TFBlocks.TRANSFORMATION_BUTTON.get(), "trans");
        this.woodenFence((Block)TFBlocks.TRANSFORMATION_FENCE.get(), "trans");
        this.toBlock((Block)TFBlocks.TRANSFORMATION_GATE.get());
        this.toBlock((Block)TFBlocks.TRANSFORMATION_PLATE.get());
        this.toBlockModel((Block)TFBlocks.TRANSFORMATION_TRAPDOOR.get(), "transformation_trapdoor_bottom");
        this.generated(TFBlocks.TRANSFORMATION_SIGN.getId().m_135815_(), TwilightForestMod.prefix("items/" + TFBlocks.TRANSFORMATION_SIGN.getId().m_135815_()));
        ((ItemModelBuilder)this.withExistingParent(TFBlocks.TRANSFORMATION_BANISTER.getId().toString(), TwilightForestMod.prefix("item/banister_item"))).texture("texture", "block/wood/planks_trans_0");
        this.generated(TFBlocks.TRANSFORMATION_DOOR.getId().m_135815_(), TwilightForestMod.prefix("items/" + TFBlocks.TRANSFORMATION_DOOR.getId().m_135815_()));
        this.toBlock((Block)TFBlocks.MINING_LOG.get());
        this.toBlock((Block)TFBlocks.STRIPPED_MINING_LOG.get());
        this.toBlock((Block)TFBlocks.MINING_WOOD.get());
        this.toBlock((Block)TFBlocks.STRIPPED_MINING_WOOD.get());
        this.toBlock((Block)TFBlocks.MINING_LOG_CORE.get());
        this.toBlock((Block)TFBlocks.MINING_LEAVES.get());
        this.generated(TFBlocks.MINING_SAPLING.getId().m_135815_(), TwilightForestMod.prefix("block/" + TFBlocks.MINING_SAPLING.getId().m_135815_()));
        this.toBlock((Block)TFBlocks.MINING_PLANKS.get());
        this.toBlock((Block)TFBlocks.MINING_STAIRS.get());
        this.toBlock((Block)TFBlocks.MINING_SLAB.get());
        this.woodenButton((Block)TFBlocks.MINING_BUTTON.get(), "mine");
        this.woodenFence((Block)TFBlocks.MINING_FENCE.get(), "mine");
        this.toBlock((Block)TFBlocks.MINING_GATE.get());
        this.toBlock((Block)TFBlocks.MINING_PLATE.get());
        this.toBlockModel((Block)TFBlocks.MINING_TRAPDOOR.get(), "mining_trapdoor_bottom");
        this.generated(TFBlocks.MINING_SIGN.getId().m_135815_(), TwilightForestMod.prefix("items/" + TFBlocks.MINING_SIGN.getId().m_135815_()));
        ((ItemModelBuilder)this.withExistingParent(TFBlocks.MINING_BANISTER.getId().toString(), TwilightForestMod.prefix("item/banister_item"))).texture("texture", "block/wood/planks_mine_0");
        this.generated(TFBlocks.MINING_DOOR.getId().m_135815_(), TwilightForestMod.prefix("items/" + TFBlocks.MINING_DOOR.getId().m_135815_()));
        this.toBlock((Block)TFBlocks.SORTING_LOG.get());
        this.toBlock((Block)TFBlocks.STRIPPED_SORTING_LOG.get());
        this.toBlock((Block)TFBlocks.SORTING_WOOD.get());
        this.toBlock((Block)TFBlocks.STRIPPED_SORTING_WOOD.get());
        this.toBlock((Block)TFBlocks.SORTING_LOG_CORE.get());
        this.toBlock((Block)TFBlocks.SORTING_LEAVES.get());
        this.generated(TFBlocks.SORTING_SAPLING.getId().m_135815_(), TwilightForestMod.prefix("block/" + TFBlocks.SORTING_SAPLING.getId().m_135815_()));
        this.toBlock((Block)TFBlocks.SORTING_PLANKS.get());
        this.toBlock((Block)TFBlocks.SORTING_STAIRS.get());
        this.toBlock((Block)TFBlocks.SORTING_SLAB.get());
        this.woodenButton((Block)TFBlocks.SORTING_BUTTON.get(), "sort");
        this.woodenFence((Block)TFBlocks.SORTING_FENCE.get(), "sort");
        this.toBlock((Block)TFBlocks.SORTING_GATE.get());
        this.toBlock((Block)TFBlocks.SORTING_PLATE.get());
        this.toBlockModel((Block)TFBlocks.SORTING_TRAPDOOR.get(), "sorting_trapdoor_bottom");
        this.generated(TFBlocks.SORTING_SIGN.getId().m_135815_(), TwilightForestMod.prefix("items/" + TFBlocks.SORTING_SIGN.getId().m_135815_()));
        ((ItemModelBuilder)this.withExistingParent(TFBlocks.SORTING_BANISTER.getId().toString(), TwilightForestMod.prefix("item/banister_item"))).texture("texture", "block/wood/planks_sort_0");
        this.generated(TFBlocks.SORTING_DOOR.getId().m_135815_(), TwilightForestMod.prefix("items/" + TFBlocks.SORTING_DOOR.getId().m_135815_()));
        this.hollowLog(TFBlocks.HOLLOW_OAK_LOG_HORIZONTAL);
        this.hollowLog(TFBlocks.HOLLOW_SPRUCE_LOG_HORIZONTAL);
        this.hollowLog(TFBlocks.HOLLOW_BIRCH_LOG_HORIZONTAL);
        this.hollowLog(TFBlocks.HOLLOW_JUNGLE_LOG_HORIZONTAL);
        this.hollowLog(TFBlocks.HOLLOW_ACACIA_LOG_HORIZONTAL);
        this.hollowLog(TFBlocks.HOLLOW_DARK_OAK_LOG_HORIZONTAL);
        this.hollowLog(TFBlocks.HOLLOW_CRIMSON_STEM_HORIZONTAL);
        this.hollowLog(TFBlocks.HOLLOW_WARPED_STEM_HORIZONTAL);
        this.hollowLog(TFBlocks.HOLLOW_TWILIGHT_OAK_LOG_HORIZONTAL);
        this.hollowLog(TFBlocks.HOLLOW_CANOPY_LOG_HORIZONTAL);
        this.hollowLog(TFBlocks.HOLLOW_MANGROVE_LOG_HORIZONTAL);
        this.hollowLog(TFBlocks.HOLLOW_DARK_LOG_HORIZONTAL);
        this.hollowLog(TFBlocks.HOLLOW_TIME_LOG_HORIZONTAL);
        this.hollowLog(TFBlocks.HOLLOW_TRANSFORMATION_LOG_HORIZONTAL);
        this.hollowLog(TFBlocks.HOLLOW_MINING_LOG_HORIZONTAL);
        this.hollowLog(TFBlocks.HOLLOW_SORTING_LOG_HORIZONTAL);
        this.singleTex(TFItems.NAGA_SCALE);
        this.singleTex(TFItems.NAGA_CHESTPLATE);
        this.singleTex(TFItems.NAGA_LEGGINGS);
        this.singleTexTool(TFItems.TWILIGHT_SCEPTER);
        this.singleTexTool(TFItems.LIFEDRAIN_SCEPTER);
        this.singleTexTool(TFItems.ZOMBIE_SCEPTER);
        this.singleTexTool(TFItems.FORTIFICATION_SCEPTER);
        this.singleTex(TFItems.ORE_METER);
        this.singleTex(TFItems.FILLED_MAGIC_MAP);
        this.singleTex(TFItems.FILLED_MAZE_MAP);
        this.biggerTex(TFItems.FILLED_ORE_MAP, TwilightForestMod.prefix("items/" + TFItems.FILLED_ORE_MAP.getId().m_135815_()));
        this.singleTex(TFItems.RAVEN_FEATHER);
        this.singleTex(TFItems.MAGIC_MAP_FOCUS);
        this.singleTex(TFItems.MAZE_MAP_FOCUS);
        this.singleTex(TFItems.LIVEROOT);
        this.singleTex(TFItems.RAW_IRONWOOD);
        this.singleTex(TFItems.IRONWOOD_INGOT);
        this.singleTex(TFItems.IRONWOOD_HELMET);
        this.singleTex(TFItems.IRONWOOD_CHESTPLATE);
        this.singleTex(TFItems.IRONWOOD_LEGGINGS);
        this.singleTex(TFItems.IRONWOOD_BOOTS);
        this.singleTexTool(TFItems.IRONWOOD_SWORD);
        this.singleTexTool(TFItems.IRONWOOD_PICKAXE);
        this.singleTexTool(TFItems.IRONWOOD_AXE);
        this.singleTexTool(TFItems.IRONWOOD_SHOVEL);
        this.singleTexTool(TFItems.IRONWOOD_HOE);
        this.singleTex(TFItems.TORCHBERRIES);
        this.singleTex(TFItems.RAW_VENISON);
        this.singleTex(TFItems.COOKED_VENISON);
        this.singleTex(TFItems.HYDRA_CHOP);
        this.singleTex(TFItems.FIERY_BLOOD);
        this.singleTex(TFItems.FIERY_TEARS);
        this.singleTex(TFItems.FIERY_INGOT);
        this.singleTex(TFItems.FIERY_HELMET);
        this.singleTex(TFItems.FIERY_CHESTPLATE);
        this.singleTex(TFItems.FIERY_LEGGINGS);
        this.singleTex(TFItems.FIERY_BOOTS);
        this.singleTexTool(TFItems.FIERY_SWORD);
        this.singleTexTool(TFItems.FIERY_PICKAXE);
        this.singleTex(TFItems.STEELEAF_INGOT);
        this.singleTex(TFItems.STEELEAF_HELMET);
        this.singleTex(TFItems.STEELEAF_CHESTPLATE);
        this.singleTex(TFItems.STEELEAF_LEGGINGS);
        this.singleTex(TFItems.STEELEAF_BOOTS);
        this.singleTexTool(TFItems.STEELEAF_SWORD);
        this.singleTexTool(TFItems.STEELEAF_PICKAXE);
        this.singleTexTool(TFItems.STEELEAF_AXE);
        this.singleTexTool(TFItems.STEELEAF_SHOVEL);
        this.singleTexTool(TFItems.STEELEAF_HOE);
        this.singleTexTool(TFItems.DIAMOND_MINOTAUR_AXE);
        this.singleTexTool(TFItems.GOLDEN_MINOTAUR_AXE);
        this.singleTexTool(TFItems.MAZEBREAKER_PICKAXE);
        this.singleTex(TFItems.TRANSFORMATION_POWDER);
        this.singleTex(TFItems.RAW_MEEF);
        this.singleTex(TFItems.COOKED_MEEF);
        this.singleTex(TFItems.MEEF_STROGANOFF);
        this.singleTex(TFItems.MAZE_WAFER);
        this.singleTex(TFItems.MAGIC_MAP);
        this.singleTex(TFItems.MAZE_MAP);
        this.biggerTex(TFItems.ORE_MAP, TwilightForestMod.prefix("items/" + TFItems.ORE_MAP.getId().m_135815_()));
        final ModelFile magnetPull1 = (ModelFile)this.generated("ore_magnet_pulling_1", TwilightForestMod.prefix("items/ore_magnet_pulling_1"));
        final ModelFile magnetPull2 = (ModelFile)this.generated("ore_magnet_pulling_2", TwilightForestMod.prefix("items/ore_magnet_pulling_2"));
        this.singleTex(TFItems.ORE_MAGNET).override().predicate(new ResourceLocation("pulling"), 1.0f).predicate(new ResourceLocation("pull"), 0.5f).model(magnetPull1).end().override().predicate(new ResourceLocation("pulling"), 1.0f).predicate(new ResourceLocation("pull"), 1.0f).model(magnetPull2).end();
        this.singleTexTool(TFItems.CRUMBLE_HORN);
        this.singleTexTool(TFItems.PEACOCK_FEATHER_FAN);
        final ModelFile queenAlt = (ModelFile)this.tool("moonworm_queen_alt", TwilightForestMod.prefix("items/moonworm_queen_alt"));
        this.singleTexTool(TFItems.MOONWORM_QUEEN).override().predicate(TwilightForestMod.prefix("alt"), 1.0f).model(queenAlt).end();
        this.singleTex(TFItems.CHARM_OF_KEEPING_1);
        this.singleTex(TFItems.CHARM_OF_KEEPING_2);
        this.singleTex(TFItems.CHARM_OF_KEEPING_3);
        this.singleTex(TFItems.CHARM_OF_LIFE_1);
        this.singleTex(TFItems.CHARM_OF_LIFE_2);
        this.singleTex(TFItems.TOWER_KEY);
        this.generated(TFItems.BORER_ESSENCE.getId().m_135815_(), TwilightForestMod.prefix("items/" + TFItems.BORER_ESSENCE.getId().m_135815_()), TwilightForestMod.prefix("items/borer_essence_particles"));
        this.singleTex(TFItems.CARMINITE);
        this.singleTex(TFItems.ARMOR_SHARD);
        this.singleTex(TFItems.ARMOR_SHARD_CLUSTER);
        this.singleTex(TFItems.KNIGHTMETAL_INGOT);
        this.biggerTex(TFItems.KNIGHTMETAL_HELMET, TwilightForestMod.prefix("items/" + TFItems.KNIGHTMETAL_HELMET.getId().m_135815_()));
        this.singleTex(TFItems.KNIGHTMETAL_CHESTPLATE);
        this.singleTex(TFItems.KNIGHTMETAL_LEGGINGS);
        this.singleTex(TFItems.KNIGHTMETAL_BOOTS);
        this.singleTexTool(TFItems.KNIGHTMETAL_SWORD);
        this.singleTexTool(TFItems.KNIGHTMETAL_PICKAXE);
        this.singleTexTool(TFItems.KNIGHTMETAL_AXE);
        this.singleTex(TFItems.KNIGHTMETAL_RING);
        this.singleTex(TFItems.PHANTOM_HELMET);
        this.singleTex(TFItems.PHANTOM_CHESTPLATE);
        this.singleTex(TFItems.LAMP_OF_CINDERS);
        this.singleTex(TFItems.ALPHA_YETI_FUR);
        this.biggerTex(TFItems.YETI_HELMET, TwilightForestMod.prefix("items/" + TFItems.YETI_HELMET.getId().m_135815_()));
        this.singleTex(TFItems.YETI_CHESTPLATE);
        this.singleTex(TFItems.YETI_LEGGINGS);
        this.singleTex(TFItems.YETI_BOOTS);
        this.singleTex(TFItems.ICE_BOMB);
        this.singleTex(TFItems.ARCTIC_FUR);
        this.arcticArmorTex(TFItems.ARCTIC_HELMET);
        this.arcticArmorTex(TFItems.ARCTIC_CHESTPLATE);
        this.arcticArmorTex(TFItems.ARCTIC_LEGGINGS);
        this.arcticArmorTex(TFItems.ARCTIC_BOOTS);
        this.singleTex(TFItems.MAGIC_BEANS);
        final ModelFile triplePulling0 = (ModelFile)this.bowItem("triple_bow_pulling_0", TwilightForestMod.prefix("items/triple_bow_pulling_0"));
        final ModelFile triplePulling2 = (ModelFile)this.bowItem("triple_bow_pulling_1", TwilightForestMod.prefix("items/triple_bow_pulling_1"));
        final ModelFile triplePulling3 = (ModelFile)this.bowItem("triple_bow_pulling_2", TwilightForestMod.prefix("items/triple_bow_pulling_2"));
        this.bowTex(TFItems.TRIPLE_BOW, triplePulling0, triplePulling2, triplePulling3);
        final ModelFile seekerPulling0 = (ModelFile)this.bowItem("seeker_bow_pulling_0", TwilightForestMod.prefix("items/seeker_bow_pulling_0"));
        final ModelFile seekerPulling2 = (ModelFile)this.bowItem("seeker_bow_pulling_1", TwilightForestMod.prefix("items/seeker_bow_pulling_1"));
        final ModelFile seekerPulling3 = (ModelFile)this.bowItem("seeker_bow_pulling_2", TwilightForestMod.prefix("items/seeker_bow_pulling_2"));
        this.bowTex(TFItems.SEEKER_BOW, seekerPulling0, seekerPulling2, seekerPulling3);
        final ModelFile icePulling0 = (ModelFile)this.bowItem("ice_bow_pulling_0", TwilightForestMod.prefix("items/ice_bow_solid_pulling_0"), TwilightForestMod.prefix("items/ice_bow_clear_pulling_0"));
        final ModelFile icePulling2 = (ModelFile)this.bowItem("ice_bow_pulling_1", TwilightForestMod.prefix("items/ice_bow_solid_pulling_1"), TwilightForestMod.prefix("items/ice_bow_clear_pulling_1"));
        final ModelFile icePulling3 = (ModelFile)this.bowItem("ice_bow_pulling_2", TwilightForestMod.prefix("items/ice_bow_solid_pulling_2"), TwilightForestMod.prefix("items/ice_bow_clear_pulling_2"));
        this.iceBowTex(TFItems.ICE_BOW, icePulling0, icePulling2, icePulling3);
        final ModelFile enderPulling0 = (ModelFile)this.bowItem("ender_bow_pulling_0", TwilightForestMod.prefix("items/ender_bow_pulling_0"));
        final ModelFile enderPulling2 = (ModelFile)this.bowItem("ender_bow_pulling_1", TwilightForestMod.prefix("items/ender_bow_pulling_1"));
        final ModelFile enderPulling3 = (ModelFile)this.bowItem("ender_bow_pulling_2", TwilightForestMod.prefix("items/ender_bow_pulling_2"));
        this.bowTex(TFItems.ENDER_BOW, enderPulling0, enderPulling2, enderPulling3);
        this.tool(TFItems.ICE_SWORD.getId().m_135815_(), TwilightForestMod.prefix("items/ice_sword_solid"), TwilightForestMod.prefix("items/ice_sword_clear"));
        this.tool(TFItems.GLASS_SWORD.getId().m_135815_(), TwilightForestMod.prefix("items/glass_sword_solid"), TwilightForestMod.prefix("items/glass_sword_clear"));
        final ModelFile chainThrown = (ModelFile)this.biggerTexString("block_and_chain_thrown", TwilightForestMod.prefix("items/block_and_chain_thrown"));
        this.biggerTexHeld(TFItems.BLOCK_AND_CHAIN, TwilightForestMod.prefix("items/block_and_chain")).override().predicate(TwilightForestMod.prefix("thrown"), 1.0f).model(chainThrown).end();
        final ModelFile cubeThrown = (ModelFile)this.biggerTexString("cube_of_annihilation_thrown", TwilightForestMod.prefix("items/cube_of_annihilation_thrown"));
        this.biggerTexHeld(TFItems.CUBE_OF_ANNIHILATION, TwilightForestMod.prefix("items/cube_of_annihilation")).override().predicate(TwilightForestMod.prefix("thrown"), 1.0f).model(cubeThrown).end();
        this.singleTex(TFItems.CUBE_TALISMAN);
        final ModelFile full = (ModelFile)this.phaseTex("moon_dial_full", TwilightForestMod.prefix("items/moon_dial/full"));
        final ModelFile waning_gib = (ModelFile)this.phaseTex("moon_dial_waning_gib", TwilightForestMod.prefix("items/moon_dial/waning_gibbous"));
        final ModelFile quarter3 = (ModelFile)this.phaseTex("moon_dial_quarter3", TwilightForestMod.prefix("items/moon_dial/third_quarter"));
        final ModelFile waning_cres = (ModelFile)this.phaseTex("moon_dial_waning_cres", TwilightForestMod.prefix("items/moon_dial/waning_cresent"));
        final ModelFile unlit = (ModelFile)this.phaseTex("moon_dial_new", TwilightForestMod.prefix("items/moon_dial/new"));
        final ModelFile waxing_cres = (ModelFile)this.phaseTex("moon_dial_waxing_cres", TwilightForestMod.prefix("items/moon_dial/waxing_cresent"));
        final ModelFile quarter4 = (ModelFile)this.phaseTex("moon_dial_quarter1", TwilightForestMod.prefix("items/moon_dial/first_quarter"));
        final ModelFile waxing_gib = (ModelFile)this.phaseTex("moon_dial_waxing_gib", TwilightForestMod.prefix("items/moon_dial/waxing_gibbous"));
        this.phaseTex(TFItems.MOON_DIAL.getId().m_135815_(), TwilightForestMod.prefix("items/moon_dial/full")).override().predicate(new ResourceLocation("phase"), 0.0f).model(full).end().override().predicate(new ResourceLocation("phase"), 0.125f).model(waning_gib).end().override().predicate(new ResourceLocation("phase"), 0.25f).model(quarter3).end().override().predicate(new ResourceLocation("phase"), 0.375f).model(waning_cres).end().override().predicate(new ResourceLocation("phase"), 0.5f).model(unlit).end().override().predicate(new ResourceLocation("phase"), 0.625f).model(waxing_cres).end().override().predicate(new ResourceLocation("phase"), 0.75f).model(quarter4).end().override().predicate(new ResourceLocation("phase"), 0.875f).model(waxing_gib).end();
        final ModelFile fill1 = (ModelFile)this.generated("brittle_flask_0", TwilightForestMod.prefix("items/brittle_potion_flask_1"), TwilightForestMod.prefix("items/brittle_potion_flask_labelled"));
        final ModelFile fill2 = (ModelFile)this.generated("brittle_flask_1", TwilightForestMod.prefix("items/brittle_potion_flask_2"), TwilightForestMod.prefix("items/brittle_potion_flask_labelled"));
        final ModelFile fill3 = (ModelFile)this.generated("brittle_flask_2", TwilightForestMod.prefix("items/brittle_potion_flask_3"), TwilightForestMod.prefix("items/brittle_potion_flask_labelled"));
        final ModelFile fill4 = (ModelFile)this.generated("brittle_flask_3", TwilightForestMod.prefix("items/brittle_potion_flask_4"), TwilightForestMod.prefix("items/brittle_potion_flask_labelled"));
        final ModelFile splintered = (ModelFile)this.generated("brittle_flask_splintered", TwilightForestMod.prefix("items/brittle_potion_flask_splintered"));
        final ModelFile fill1_splintered = (ModelFile)this.generated("brittle_flask_0_splintered", TwilightForestMod.prefix("items/brittle_potion_flask_1"), TwilightForestMod.prefix("items/brittle_potion_flask_splintered"));
        final ModelFile fill2_splintered = (ModelFile)this.generated("brittle_flask_1_splintered", TwilightForestMod.prefix("items/brittle_potion_flask_2"), TwilightForestMod.prefix("items/brittle_potion_flask_splintered"));
        final ModelFile fill3_splintered = (ModelFile)this.generated("brittle_flask_2_splintered", TwilightForestMod.prefix("items/brittle_potion_flask_3"), TwilightForestMod.prefix("items/brittle_potion_flask_splintered"));
        final ModelFile fill4_splintered = (ModelFile)this.generated("brittle_flask_3_splintered", TwilightForestMod.prefix("items/brittle_potion_flask_4"), TwilightForestMod.prefix("items/brittle_potion_flask_splintered"));
        final ModelFile cracked = (ModelFile)this.generated("brittle_flask_cracked", TwilightForestMod.prefix("items/brittle_potion_flask_cracked"));
        final ModelFile fill1_cracked = (ModelFile)this.generated("brittle_flask_0_cracked", TwilightForestMod.prefix("items/brittle_potion_flask_1"), TwilightForestMod.prefix("items/brittle_potion_flask_cracked"));
        final ModelFile fill2_cracked = (ModelFile)this.generated("brittle_flask_1_cracked", TwilightForestMod.prefix("items/brittle_potion_flask_2"), TwilightForestMod.prefix("items/brittle_potion_flask_cracked"));
        final ModelFile fill3_cracked = (ModelFile)this.generated("brittle_flask_2_cracked", TwilightForestMod.prefix("items/brittle_potion_flask_3"), TwilightForestMod.prefix("items/brittle_potion_flask_cracked"));
        final ModelFile fill4_cracked = (ModelFile)this.generated("brittle_flask_3_cracked", TwilightForestMod.prefix("items/brittle_potion_flask_4"), TwilightForestMod.prefix("items/brittle_potion_flask_cracked"));
        final ModelFile damaged = (ModelFile)this.generated("brittle_flask_damaged", TwilightForestMod.prefix("items/brittle_potion_flask_damaged"));
        final ModelFile fill1_damaged = (ModelFile)this.generated("brittle_flask_0_damaged", TwilightForestMod.prefix("items/brittle_potion_flask_1"), TwilightForestMod.prefix("items/brittle_potion_flask_damaged"));
        final ModelFile fill2_damaged = (ModelFile)this.generated("brittle_flask_1_damaged", TwilightForestMod.prefix("items/brittle_potion_flask_2"), TwilightForestMod.prefix("items/brittle_potion_flask_damaged"));
        final ModelFile fill3_damaged = (ModelFile)this.generated("brittle_flask_2_damaged", TwilightForestMod.prefix("items/brittle_potion_flask_3"), TwilightForestMod.prefix("items/brittle_potion_flask_damaged"));
        final ModelFile fill4_damaged = (ModelFile)this.generated("brittle_flask_3_damaged", TwilightForestMod.prefix("items/brittle_potion_flask_4"), TwilightForestMod.prefix("items/brittle_potion_flask_damaged"));
        this.generated(TFItems.BRITTLE_FLASK.getId().m_135815_(), TwilightForestMod.prefix("block/stone_twist/twist_blank"), TwilightForestMod.prefix("items/brittle_potion_flask")).override().predicate(TwilightForestMod.prefix("potion_level"), 1.0f).model(fill1).end().override().predicate(TwilightForestMod.prefix("potion_level"), 2.0f).model(fill2).end().override().predicate(TwilightForestMod.prefix("potion_level"), 3.0f).model(fill3).end().override().predicate(TwilightForestMod.prefix("potion_level"), 4.0f).model(fill4).end().override().predicate(TwilightForestMod.prefix("potion_level"), 0.0f).predicate(TwilightForestMod.prefix("breakage"), 1.0f).model(splintered).end().override().predicate(TwilightForestMod.prefix("potion_level"), 1.0f).predicate(TwilightForestMod.prefix("breakage"), 1.0f).model(fill1_splintered).end().override().predicate(TwilightForestMod.prefix("potion_level"), 2.0f).predicate(TwilightForestMod.prefix("breakage"), 1.0f).model(fill2_splintered).end().override().predicate(TwilightForestMod.prefix("potion_level"), 3.0f).predicate(TwilightForestMod.prefix("breakage"), 1.0f).model(fill3_splintered).end().override().predicate(TwilightForestMod.prefix("potion_level"), 4.0f).predicate(TwilightForestMod.prefix("breakage"), 1.0f).model(fill4_splintered).end().override().predicate(TwilightForestMod.prefix("potion_level"), 0.0f).predicate(TwilightForestMod.prefix("breakage"), 2.0f).model(cracked).end().override().predicate(TwilightForestMod.prefix("potion_level"), 1.0f).predicate(TwilightForestMod.prefix("breakage"), 2.0f).model(fill1_cracked).end().override().predicate(TwilightForestMod.prefix("potion_level"), 2.0f).predicate(TwilightForestMod.prefix("breakage"), 2.0f).model(fill2_cracked).end().override().predicate(TwilightForestMod.prefix("potion_level"), 3.0f).predicate(TwilightForestMod.prefix("breakage"), 2.0f).model(fill3_cracked).end().override().predicate(TwilightForestMod.prefix("potion_level"), 4.0f).predicate(TwilightForestMod.prefix("breakage"), 2.0f).model(fill4_cracked).end().override().predicate(TwilightForestMod.prefix("potion_level"), 0.0f).predicate(TwilightForestMod.prefix("breakage"), 3.0f).model(damaged).end().override().predicate(TwilightForestMod.prefix("potion_level"), 1.0f).predicate(TwilightForestMod.prefix("breakage"), 3.0f).model(fill1_damaged).end().override().predicate(TwilightForestMod.prefix("potion_level"), 2.0f).predicate(TwilightForestMod.prefix("breakage"), 3.0f).model(fill2_damaged).end().override().predicate(TwilightForestMod.prefix("potion_level"), 3.0f).predicate(TwilightForestMod.prefix("breakage"), 3.0f).model(fill3_damaged).end().override().predicate(TwilightForestMod.prefix("potion_level"), 4.0f).predicate(TwilightForestMod.prefix("breakage"), 3.0f).model(fill4_damaged).end();
        final ModelFile gfill1 = (ModelFile)this.generated("greater_flask_0", TwilightForestMod.prefix("items/greater_potion_flask_1"), TwilightForestMod.prefix("items/greater_potion_flask"));
        final ModelFile gfill2 = (ModelFile)this.generated("greater_flask_1", TwilightForestMod.prefix("items/greater_potion_flask_2"), TwilightForestMod.prefix("items/greater_potion_flask"));
        final ModelFile gfill3 = (ModelFile)this.generated("greater_flask_2", TwilightForestMod.prefix("items/greater_potion_flask_3"), TwilightForestMod.prefix("items/greater_potion_flask"));
        final ModelFile gfill4 = (ModelFile)this.generated("greater_flask_3", TwilightForestMod.prefix("items/greater_potion_flask_4"), TwilightForestMod.prefix("items/greater_potion_flask"));
        this.generated(TFItems.GREATER_FLASK.getId().m_135815_(), TwilightForestMod.prefix("block/stone_twist/twist_blank"), TwilightForestMod.prefix("items/greater_potion_flask")).override().predicate(TwilightForestMod.prefix("potion_level"), 1.0f).model(gfill1).end().override().predicate(TwilightForestMod.prefix("potion_level"), 2.0f).model(gfill2).end().override().predicate(TwilightForestMod.prefix("potion_level"), 3.0f).model(gfill3).end().override().predicate(TwilightForestMod.prefix("potion_level"), 4.0f).model(gfill4).end();
        this.singleTex(TFItems.MUSIC_DISC_FINDINGS);
        this.singleTex(TFItems.MUSIC_DISC_HOME);
        this.singleTex(TFItems.MUSIC_DISC_MAKER);
        this.singleTex(TFItems.MUSIC_DISC_MOTION);
        this.singleTex(TFItems.MUSIC_DISC_RADIANCE);
        this.singleTex(TFItems.MUSIC_DISC_STEPS);
        this.singleTex(TFItems.MUSIC_DISC_SUPERSTITIOUS);
        this.singleTex(TFItems.MUSIC_DISC_THREAD);
        this.singleTex(TFItems.MUSIC_DISC_WAYFARER);
        this.generated(TFItems.NAGA_BANNER_PATTERN.getId().m_135815_(), TwilightForestMod.prefix("items/tf_banner_pattern"));
        this.generated(TFItems.LICH_BANNER_PATTERN.getId().m_135815_(), TwilightForestMod.prefix("items/tf_banner_pattern"));
        this.generated(TFItems.MINOSHROOM_BANNER_PATTERN.getId().m_135815_(), TwilightForestMod.prefix("items/tf_banner_pattern"));
        this.generated(TFItems.HYDRA_BANNER_PATTERN.getId().m_135815_(), TwilightForestMod.prefix("items/tf_banner_pattern"));
        this.generated(TFItems.KNIGHT_PHANTOM_BANNER_PATTERN.getId().m_135815_(), TwilightForestMod.prefix("items/tf_banner_pattern"));
        this.generated(TFItems.UR_GHAST_BANNER_PATTERN.getId().m_135815_(), TwilightForestMod.prefix("items/tf_banner_pattern"));
        this.generated(TFItems.ALPHA_YETI_BANNER_PATTERN.getId().m_135815_(), TwilightForestMod.prefix("items/tf_banner_pattern"));
        this.generated(TFItems.SNOW_QUEEN_BANNER_PATTERN.getId().m_135815_(), TwilightForestMod.prefix("items/tf_banner_pattern"));
        this.generated(TFItems.QUEST_RAM_BANNER_PATTERN.getId().m_135815_(), TwilightForestMod.prefix("items/tf_banner_pattern"));
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
        return this.tool(item.getId().m_135815_(), TwilightForestMod.prefix("items/" + item.getId().m_135815_()));
    }
    
    private ItemModelBuilder tool(final String name, final ResourceLocation... layers) {
        ItemModelBuilder builder = (ItemModelBuilder)this.withExistingParent(name, "item/handheld");
        for (int i = 0; i < layers.length; ++i) {
            builder = (ItemModelBuilder)builder.texture("layer" + i, layers[i]);
        }
        return builder;
    }
    
    private ItemModelBuilder singleTex(final RegistryObject<Item> item) {
        return this.generated(item.getId().m_135815_(), TwilightForestMod.prefix("items/" + item.getId().m_135815_()));
    }
    
    private ItemModelBuilder biggerTex(final RegistryObject<Item> item, final ResourceLocation... layers) {
        ItemModelBuilder builder = (ItemModelBuilder)this.withExistingParent(item.getId().m_135815_(), "twilightforest:item/util/overlap_gui");
        for (int i = 0; i < layers.length; ++i) {
            builder = (ItemModelBuilder)builder.texture("layer" + i, layers[i]);
        }
        return builder;
    }
    
    private ItemModelBuilder biggerTexHeld(final RegistryObject<Item> item, final ResourceLocation... layers) {
        ItemModelBuilder builder = (ItemModelBuilder)this.withExistingParent(item.getId().m_135815_(), "twilightforest:item/util/overlap_gui_held");
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
        return this.generated(item.getId().m_135815_(), TwilightForestMod.prefix("items/" + item.getId().m_135815_()), TwilightForestMod.prefix("items/" + item.getId().m_135815_() + "_0"));
    }
    
    private ItemModelBuilder bowItem(final String name, final ResourceLocation... layers) {
        ItemModelBuilder builder = (ItemModelBuilder)this.withExistingParent(name, "item/bow");
        for (int i = 0; i < layers.length; ++i) {
            builder = (ItemModelBuilder)builder.texture("layer" + i, layers[i]);
        }
        return builder;
    }
    
    private ItemModelBuilder bowTex(final RegistryObject<Item> item, final ModelFile pull0, final ModelFile pull1, final ModelFile pull2) {
        return this.bowItem(item.getId().m_135815_(), TwilightForestMod.prefix("items/" + item.getId().m_135815_())).override().predicate(new ResourceLocation("pulling"), 1.0f).model(pull0).end().override().predicate(new ResourceLocation("pulling"), 1.0f).predicate(new ResourceLocation("pull"), 0.65f).model(pull1).end().override().predicate(new ResourceLocation("pulling"), 1.0f).predicate(new ResourceLocation("pull"), 0.9f).model(pull2).end();
    }
    
    private ItemModelBuilder iceBowTex(final RegistryObject<Item> item, final ModelFile pull0, final ModelFile pull1, final ModelFile pull2) {
        return this.bowItem(item.getId().m_135815_(), TwilightForestMod.prefix("items/ice_bow_solid"), TwilightForestMod.prefix("items/ice_bow_clear")).override().predicate(new ResourceLocation("pulling"), 1.0f).model(pull0).end().override().predicate(new ResourceLocation("pulling"), 1.0f).predicate(new ResourceLocation("pull"), 0.65f).model(pull1).end().override().predicate(new ResourceLocation("pulling"), 1.0f).predicate(new ResourceLocation("pull"), 0.9f).model(pull2).end();
    }
    
    private ItemModelBuilder phaseTex(final String name, final ResourceLocation... layers) {
        ItemModelBuilder builder = (ItemModelBuilder)this.withExistingParent(name, "twilightforest:item/util/readable");
        for (int i = 0; i < layers.length; ++i) {
            builder = (ItemModelBuilder)builder.texture("layer" + i, layers[i]);
        }
        return builder;
    }
    
    private void woodenButton(final Block button, final String variant) {
        ((ItemModelBuilder)((ItemModelBuilder)this.getBuilder(button.getRegistryName().m_135815_())).parent((ModelFile)this.getExistingFile(this.mcLoc("block/button_inventory")))).texture("texture", "block/wood/planks_" + variant + "_0");
    }
    
    private void woodenFence(final Block fence, final String variant) {
        ((ItemModelBuilder)((ItemModelBuilder)this.getBuilder(fence.getRegistryName().m_135815_())).parent((ModelFile)this.getExistingFile(this.mcLoc("block/fence_inventory")))).texture("texture", "block/wood/planks_" + variant + "_0");
    }
    
    private void hollowLog(final RegistryObject<HollowLogHorizontal> hollowLog) {
        ((ItemModelBuilder)this.getBuilder(((HollowLogHorizontal)hollowLog.get()).m_5456_().getRegistryName().m_135815_())).parent((ModelFile)new ModelFile.ExistingModelFile(TwilightForestMod.prefix("block/" + hollowLog.getId().m_135815_()), this.existingFileHelper));
    }
    
    private void toBlock(final Block b) {
        this.toBlockModel(b, b.getRegistryName().m_135815_());
    }
    
    private void toBlockModel(final Block b, final String model) {
        this.toBlockModel(b, TwilightForestMod.prefix("block/" + model));
    }
    
    private void toBlockModel(final Block b, final ResourceLocation model) {
        this.withExistingParent(b.getRegistryName().m_135815_(), model);
    }
    
    public String m_6055_() {
        return "TwilightForest item and itemblock models";
    }
}
