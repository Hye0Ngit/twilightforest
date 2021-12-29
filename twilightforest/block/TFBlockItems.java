// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.Objects;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.item.DoubleHighBlockItem;
import twilightforest.item.WearableItem;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import twilightforest.item.TrophyItem;
import twilightforest.TwilightForestMod;
import twilightforest.item.FurnaceFuelItem;
import twilightforest.item.SkullCandleItem;
import net.minecraft.world.item.Rarity;
import twilightforest.item.HollowLogItem;
import net.minecraftforge.registries.IForgeRegistry;
import twilightforest.item.HugeLilyPadItem;
import twilightforest.item.HugeWaterLilyItem;
import net.minecraftforge.fmllegacy.RegistryObject;
import twilightforest.client.ISTER;
import twilightforest.block.entity.TFBlockEntities;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraftforge.client.IItemRenderProperties;
import java.util.function.Consumer;
import net.minecraft.world.item.BlockItem;
import twilightforest.item.TFItems;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;

public class TFBlockItems
{
    public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> r = (IForgeRegistry<Item>)event.getRegistry();
        r.register((IForgeRegistryEntry)trophyBlock(TFBlocks.NAGA_TROPHY, TFBlocks.NAGA_WALL_TROPHY));
        r.register((IForgeRegistryEntry)trophyBlock(TFBlocks.LICH_TROPHY, TFBlocks.LICH_WALL_TROPHY));
        r.register((IForgeRegistryEntry)trophyBlock(TFBlocks.MINOSHROOM_TROPHY, TFBlocks.MINOSHROOM_WALL_TROPHY));
        r.register((IForgeRegistryEntry)trophyBlock(TFBlocks.HYDRA_TROPHY, TFBlocks.HYDRA_WALL_TROPHY));
        r.register((IForgeRegistryEntry)trophyBlock(TFBlocks.KNIGHT_PHANTOM_TROPHY, TFBlocks.KNIGHT_PHANTOM_WALL_TROPHY));
        r.register((IForgeRegistryEntry)trophyBlock(TFBlocks.UR_GHAST_TROPHY, TFBlocks.UR_GHAST_WALL_TROPHY));
        r.register((IForgeRegistryEntry)trophyBlock(TFBlocks.ALPHA_YETI_TROPHY, TFBlocks.ALPHA_YETI_WALL_TROPHY));
        r.register((IForgeRegistryEntry)trophyBlock(TFBlocks.SNOW_QUEEN_TROPHY, TFBlocks.SNOW_QUEEN_WALL_TROPHY));
        r.register((IForgeRegistryEntry)trophyBlock(TFBlocks.QUEST_RAM_TROPHY, TFBlocks.QUEST_RAM_WALL_TROPHY));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TWILIGHT_PORTAL_MINIATURE_STRUCTURE));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.NAGA_COURTYARD_MINIATURE_STRUCTURE));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.LICH_TOWER_MINIATURE_STRUCTURE));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.NAGA_BOSS_SPAWNER));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.LICH_BOSS_SPAWNER));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.MINOSHROOM_BOSS_SPAWNER));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.HYDRA_BOSS_SPAWNER));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.KNIGHT_PHANTOM_BOSS_SPAWNER));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.UR_GHAST_BOSS_SPAWNER));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.ALPHA_YETI_BOSS_SPAWNER));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.SNOW_QUEEN_BOSS_SPAWNER));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.FINAL_BOSS_BOSS_SPAWNER));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.ETCHED_NAGASTONE));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.CRACKED_ETCHED_NAGASTONE));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.MOSSY_ETCHED_NAGASTONE));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.NAGASTONE_PILLAR));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.CRACKED_NAGASTONE_PILLAR));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.MOSSY_NAGASTONE_PILLAR));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.NAGASTONE_STAIRS_LEFT));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.CRACKED_NAGASTONE_STAIRS_LEFT));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.MOSSY_NAGASTONE_STAIRS_LEFT));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.NAGASTONE_STAIRS_RIGHT));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.CRACKED_NAGASTONE_STAIRS_RIGHT));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.MOSSY_NAGASTONE_STAIRS_RIGHT));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.NAGASTONE_HEAD));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.NAGASTONE));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.SPIRAL_BRICKS));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TWISTED_STONE));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TWISTED_STONE_PILLAR));
        r.register((IForgeRegistryEntry)makeBlockItem((Item)new BlockItem((Block)TFBlocks.KEEPSAKE_CASKET.get(), TFItems.defaultBuilder().m_41486_()) {
            public void initializeClient(final Consumer<IItemRenderProperties> consumer) {
                consumer.accept((IItemRenderProperties)new IItemRenderProperties() {
                    public BlockEntityWithoutLevelRenderer getItemStackRenderer() {
                        return new ISTER(TFBlockEntities.KEEPSAKE_CASKET.getId());
                    }
                });
            }
        }, (RegistryObject<? extends Block>)TFBlocks.KEEPSAKE_CASKET));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.CANDELABRA));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.BOLD_STONE_PILLAR));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.DEATH_TOME_SPAWNER));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.EMPTY_CANOPY_BOOKSHELF));
        r.register((IForgeRegistryEntry)skullCandleItem(TFBlocks.ZOMBIE_SKULL_CANDLE, TFBlocks.ZOMBIE_WALL_SKULL_CANDLE));
        r.register((IForgeRegistryEntry)skullCandleItem(TFBlocks.SKELETON_SKULL_CANDLE, TFBlocks.SKELETON_WALL_SKULL_CANDLE));
        r.register((IForgeRegistryEntry)skullCandleItem(TFBlocks.WITHER_SKELE_SKULL_CANDLE, TFBlocks.WITHER_SKELE_WALL_SKULL_CANDLE));
        r.register((IForgeRegistryEntry)skullCandleItem(TFBlocks.CREEPER_SKULL_CANDLE, TFBlocks.CREEPER_WALL_SKULL_CANDLE));
        r.register((IForgeRegistryEntry)skullCandleItem(TFBlocks.PLAYER_SKULL_CANDLE, TFBlocks.PLAYER_WALL_SKULL_CANDLE));
        r.register((IForgeRegistryEntry)makeBlockItem((Item)new HugeWaterLilyItem((Block)TFBlocks.HUGE_WATER_LILY.get(), TFItems.defaultBuilder()), TFBlocks.HUGE_WATER_LILY));
        r.register((IForgeRegistryEntry)makeBlockItem((Item)new HugeLilyPadItem((HugeLilyPadBlock)TFBlocks.HUGE_LILY_PAD.get(), TFItems.defaultBuilder()), (RegistryObject<? extends Block>)TFBlocks.HUGE_LILY_PAD));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.MAZESTONE));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.MAZESTONE_BRICK));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.CRACKED_MAZESTONE));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.MOSSY_MAZESTONE));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.DECORATIVE_MAZESTONE));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.CUT_MAZESTONE));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.MAZESTONE_BORDER));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.MAZESTONE_MOSAIC));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.SMOKER));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.ENCASED_SMOKER));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.FIRE_JET));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.ENCASED_FIRE_JET));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.STRONGHOLD_SHIELD));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TROPHY_PEDESTAL));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.UNDERBRICK));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.CRACKED_UNDERBRICK));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.MOSSY_UNDERBRICK));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.UNDERBRICK_FLOOR));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TOWERWOOD));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.CRACKED_TOWERWOOD));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.MOSSY_TOWERWOOD));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.INFESTED_TOWERWOOD));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.ENCASED_TOWERWOOD));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.VANISHING_BLOCK));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.REAPPEARING_BLOCK));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.LOCKED_VANISHING_BLOCK));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.CARMINITE_BUILDER));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.ANTIBUILDER));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.CARMINITE_REACTOR));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.GHAST_TRAP));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.AURORA_BLOCK));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.AURORA_PILLAR));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.AURORA_SLAB));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.AURORALIZED_GLASS));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TROLLSTEINN));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TROLLVIDR));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.UNRIPE_TROLLBER));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TROLLBER));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.HUGE_MUSHGLOOM));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.HUGE_MUSHGLOOM_STEM));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.UBEROUS_SOIL));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.HUGE_STALK));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.BEANSTALK_LEAVES));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.WISPY_CLOUD));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.FLUFFY_CLOUD));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.GIANT_COBBLESTONE));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.GIANT_LOG));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.GIANT_LEAVES));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.GIANT_OBSIDIAN));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.DEADROCK));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.CRACKED_DEADROCK));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.WEATHERED_DEADROCK));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.BROWN_THORNS));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.GREEN_THORNS));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.BURNT_THORNS));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.THORN_ROSE));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.THORN_LEAVES));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.CASTLE_BRICK));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.WORN_CASTLE_BRICK));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.CRACKED_CASTLE_BRICK));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.MOSSY_CASTLE_BRICK));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.THICK_CASTLE_BRICK));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.CASTLE_ROOF_TILE));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.ENCASED_CASTLE_BRICK_PILLAR));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.ENCASED_CASTLE_BRICK_TILE));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.BOLD_CASTLE_BRICK_PILLAR));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.BOLD_CASTLE_BRICK_TILE));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.CASTLE_BRICK_STAIRS));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.WORN_CASTLE_BRICK_STAIRS));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.CRACKED_CASTLE_BRICK_STAIRS));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.MOSSY_CASTLE_BRICK_STAIRS));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.ENCASED_CASTLE_BRICK_STAIRS));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.BOLD_CASTLE_BRICK_STAIRS));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.PINK_CASTLE_RUNE_BRICK));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.YELLOW_CASTLE_RUNE_BRICK));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.BLUE_CASTLE_RUNE_BRICK));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.VIOLET_CASTLE_RUNE_BRICK));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.PINK_CASTLE_DOOR));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.YELLOW_CASTLE_DOOR));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.BLUE_CASTLE_DOOR));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.VIOLET_CASTLE_DOOR));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.PINK_FORCE_FIELD));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.ORANGE_FORCE_FIELD));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.GREEN_FORCE_FIELD));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.BLUE_FORCE_FIELD));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.VIOLET_FORCE_FIELD));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.UNCRAFTING_TABLE));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.CINDER_FURNACE));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.CINDER_LOG));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.CINDER_WOOD));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.SLIDER));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.IRON_LADDER));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.IRONWOOD_BLOCK));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.STEELEAF_BLOCK));
        r.register((IForgeRegistryEntry)fireImmuneBlock(TFBlocks.FIERY_BLOCK));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.KNIGHTMETAL_BLOCK));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.CARMINITE_BLOCK));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.ARCTIC_FUR_BLOCK));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.MOSS_PATCH));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.MAYAPPLE));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.CLOVER_PATCH));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.FIDDLEHEAD));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.MUSHGLOOM));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TORCHBERRY_PLANT));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.ROOT_STRAND));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.FALLEN_LEAVES));
        r.register((IForgeRegistryEntry)wearableBlock(TFBlocks.FIREFLY, TFBlockEntities.FIREFLY));
        r.register((IForgeRegistryEntry)wearableBlock(TFBlocks.CICADA, TFBlockEntities.CICADA));
        r.register((IForgeRegistryEntry)wearableBlock(TFBlocks.MOONWORM, TFBlockEntities.MOONWORM));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.FIREFLY_JAR));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.FIREFLY_SPAWNER));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.CICADA_JAR));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.HEDGE));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.ROOT_BLOCK));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.LIVEROOT_BLOCK));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.MANGROVE_ROOT));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TWILIGHT_OAK_LEAVES));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.CANOPY_LEAVES));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.MANGROVE_LEAVES));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.DARK_LEAVES));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TIME_LEAVES));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TRANSFORMATION_LEAVES));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.MINING_LEAVES));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.SORTING_LEAVES));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.RAINBOW_OAK_LEAVES));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TWILIGHT_OAK_LOG));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.CANOPY_LOG));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.MANGROVE_LOG));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.DARK_LOG));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TIME_LOG));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TRANSFORMATION_LOG));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.MINING_LOG));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.SORTING_LOG));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.STRIPPED_TWILIGHT_OAK_LOG));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.STRIPPED_CANOPY_LOG));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.STRIPPED_MANGROVE_LOG));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.STRIPPED_DARK_LOG));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.STRIPPED_TIME_LOG));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.STRIPPED_TRANSFORMATION_LOG));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.STRIPPED_MINING_LOG));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.STRIPPED_SORTING_LOG));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TWILIGHT_OAK_WOOD));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.CANOPY_WOOD));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.MANGROVE_WOOD));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.DARK_WOOD));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TIME_WOOD));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TRANSFORMATION_WOOD));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.MINING_WOOD));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.SORTING_WOOD));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.STRIPPED_TWILIGHT_OAK_WOOD));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.STRIPPED_CANOPY_WOOD));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.STRIPPED_MANGROVE_WOOD));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.STRIPPED_DARK_WOOD));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.STRIPPED_TIME_WOOD));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.STRIPPED_TRANSFORMATION_WOOD));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.STRIPPED_MINING_WOOD));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.STRIPPED_SORTING_WOOD));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TIME_LOG_CORE));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TRANSFORMATION_LOG_CORE));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.MINING_LOG_CORE));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.SORTING_LOG_CORE));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TWILIGHT_OAK_SAPLING));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.CANOPY_SAPLING));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.MANGROVE_SAPLING));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.DARKWOOD_SAPLING));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.HOLLOW_OAK_SAPLING));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TIME_SAPLING));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TRANSFORMATION_SAPLING));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.MINING_SAPLING));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.SORTING_SAPLING));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.RAINBOW_OAK_SAPLING));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.OAK_BANISTER, 300));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.SPRUCE_BANISTER, 300));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.BIRCH_BANISTER, 300));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.JUNGLE_BANISTER, 300));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.ACACIA_BANISTER, 300));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.DARK_OAK_BANISTER, 300));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.CRIMSON_BANISTER, 300));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.WARPED_BANISTER, 300));
        r.register((IForgeRegistryEntry)hollowLog(TFBlocks.HOLLOW_OAK_LOG_HORIZONTAL, TFBlocks.HOLLOW_OAK_LOG_VERTICAL, TFBlocks.HOLLOW_OAK_LOG_CLIMBABLE, "hollow_oak_log"));
        r.register((IForgeRegistryEntry)hollowLog(TFBlocks.HOLLOW_SPRUCE_LOG_HORIZONTAL, TFBlocks.HOLLOW_SPRUCE_LOG_VERTICAL, TFBlocks.HOLLOW_SPRUCE_LOG_CLIMBABLE, "hollow_spruce_log"));
        r.register((IForgeRegistryEntry)hollowLog(TFBlocks.HOLLOW_BIRCH_LOG_HORIZONTAL, TFBlocks.HOLLOW_BIRCH_LOG_VERTICAL, TFBlocks.HOLLOW_BIRCH_LOG_CLIMBABLE, "hollow_birch_log"));
        r.register((IForgeRegistryEntry)hollowLog(TFBlocks.HOLLOW_JUNGLE_LOG_HORIZONTAL, TFBlocks.HOLLOW_JUNGLE_LOG_VERTICAL, TFBlocks.HOLLOW_JUNGLE_LOG_CLIMBABLE, "hollow_jungle_log"));
        r.register((IForgeRegistryEntry)hollowLog(TFBlocks.HOLLOW_ACACIA_LOG_HORIZONTAL, TFBlocks.HOLLOW_ACACIA_LOG_VERTICAL, TFBlocks.HOLLOW_ACACIA_LOG_CLIMBABLE, "hollow_acacia_log"));
        r.register((IForgeRegistryEntry)hollowLog(TFBlocks.HOLLOW_DARK_OAK_LOG_HORIZONTAL, TFBlocks.HOLLOW_DARK_OAK_LOG_VERTICAL, TFBlocks.HOLLOW_DARK_OAK_LOG_CLIMBABLE, "hollow_dark_oak_log"));
        r.register((IForgeRegistryEntry)hollowLog(TFBlocks.HOLLOW_CRIMSON_STEM_HORIZONTAL, TFBlocks.HOLLOW_CRIMSON_STEM_VERTICAL, TFBlocks.HOLLOW_CRIMSON_STEM_CLIMBABLE, "hollow_crimson_stem"));
        r.register((IForgeRegistryEntry)hollowLog(TFBlocks.HOLLOW_WARPED_STEM_HORIZONTAL, TFBlocks.HOLLOW_WARPED_STEM_VERTICAL, TFBlocks.HOLLOW_WARPED_STEM_CLIMBABLE, "hollow_warped_stem"));
        r.register((IForgeRegistryEntry)hollowLog(TFBlocks.HOLLOW_TWILIGHT_OAK_LOG_HORIZONTAL, TFBlocks.HOLLOW_TWILIGHT_OAK_LOG_VERTICAL, TFBlocks.HOLLOW_TWILIGHT_OAK_LOG_CLIMBABLE, "hollow_twilight_oak_log"));
        r.register((IForgeRegistryEntry)hollowLog(TFBlocks.HOLLOW_CANOPY_LOG_HORIZONTAL, TFBlocks.HOLLOW_CANOPY_LOG_VERTICAL, TFBlocks.HOLLOW_CANOPY_LOG_CLIMBABLE, "hollow_canopy_log"));
        r.register((IForgeRegistryEntry)hollowLog(TFBlocks.HOLLOW_MANGROVE_LOG_HORIZONTAL, TFBlocks.HOLLOW_MANGROVE_LOG_VERTICAL, TFBlocks.HOLLOW_MANGROVE_LOG_CLIMBABLE, "hollow_mangrove_log"));
        r.register((IForgeRegistryEntry)hollowLog(TFBlocks.HOLLOW_DARK_LOG_HORIZONTAL, TFBlocks.HOLLOW_DARK_LOG_VERTICAL, TFBlocks.HOLLOW_DARK_LOG_CLIMBABLE, "hollow_dark_log"));
        r.register((IForgeRegistryEntry)hollowLog(TFBlocks.HOLLOW_TIME_LOG_HORIZONTAL, TFBlocks.HOLLOW_TIME_LOG_VERTICAL, TFBlocks.HOLLOW_TIME_LOG_CLIMBABLE, "hollow_time_log"));
        r.register((IForgeRegistryEntry)hollowLog(TFBlocks.HOLLOW_TRANSFORMATION_LOG_HORIZONTAL, TFBlocks.HOLLOW_TRANSFORMATION_LOG_VERTICAL, TFBlocks.HOLLOW_TRANSFORMATION_LOG_CLIMBABLE, "hollow_transformation_log"));
        r.register((IForgeRegistryEntry)hollowLog(TFBlocks.HOLLOW_MINING_LOG_HORIZONTAL, TFBlocks.HOLLOW_MINING_LOG_VERTICAL, TFBlocks.HOLLOW_MINING_LOG_CLIMBABLE, "hollow_mining_log"));
        r.register((IForgeRegistryEntry)hollowLog(TFBlocks.HOLLOW_SORTING_LOG_HORIZONTAL, TFBlocks.HOLLOW_SORTING_LOG_VERTICAL, TFBlocks.HOLLOW_SORTING_LOG_CLIMBABLE, "hollow_sorting_log"));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TWILIGHT_OAK_PLANKS));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TWILIGHT_OAK_STAIRS));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TWILIGHT_OAK_SLAB));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TWILIGHT_OAK_BUTTON));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.TWILIGHT_OAK_FENCE, 300));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.TWILIGHT_OAK_GATE, 300));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TWILIGHT_OAK_PLATE));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TWILIGHT_OAK_TRAPDOOR));
        r.register((IForgeRegistryEntry)tallBlock(TFBlocks.TWILIGHT_OAK_DOOR));
        r.register((IForgeRegistryEntry)signBlock(TFBlocks.TWILIGHT_OAK_SIGN, TFBlocks.TWILIGHT_WALL_SIGN));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.TWILIGHT_OAK_BANISTER, 300));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.CANOPY_PLANKS));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.CANOPY_STAIRS));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.CANOPY_SLAB));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.CANOPY_BUTTON));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.CANOPY_FENCE, 300));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.CANOPY_GATE, 300));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.CANOPY_PLATE));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.CANOPY_TRAPDOOR));
        r.register((IForgeRegistryEntry)tallBlock(TFBlocks.CANOPY_DOOR));
        r.register((IForgeRegistryEntry)signBlock(TFBlocks.CANOPY_SIGN, TFBlocks.CANOPY_WALL_SIGN));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.CANOPY_BANISTER, 300));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.CANOPY_BOOKSHELF));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.MANGROVE_PLANKS));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.MANGROVE_STAIRS));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.MANGROVE_SLAB));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.MANGROVE_BUTTON));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.MANGROVE_FENCE, 300));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.MANGROVE_GATE, 300));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.MANGROVE_PLATE));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.MANGROVE_TRAPDOOR));
        r.register((IForgeRegistryEntry)tallBlock(TFBlocks.MANGROVE_DOOR));
        r.register((IForgeRegistryEntry)signBlock(TFBlocks.MANGROVE_SIGN, TFBlocks.MANGROVE_WALL_SIGN));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.MANGROVE_BANISTER, 300));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.DARK_PLANKS));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.DARK_STAIRS));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.DARK_SLAB));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.DARK_BUTTON));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.DARK_FENCE, 300));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.DARK_GATE, 300));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.DARK_PLATE));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.DARK_TRAPDOOR));
        r.register((IForgeRegistryEntry)tallBlock(TFBlocks.DARK_DOOR));
        r.register((IForgeRegistryEntry)signBlock(TFBlocks.DARKWOOD_SIGN, TFBlocks.DARKWOOD_WALL_SIGN));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.DARKWOOD_BANISTER, 300));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TIME_PLANKS));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TIME_STAIRS));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TIME_SLAB));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TIME_BUTTON));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.TIME_FENCE, 300));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.TIME_GATE, 300));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TIME_PLATE));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TIME_TRAPDOOR));
        r.register((IForgeRegistryEntry)tallBlock(TFBlocks.TIME_DOOR));
        r.register((IForgeRegistryEntry)signBlock(TFBlocks.TIME_SIGN, TFBlocks.TIME_WALL_SIGN));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.TIME_BANISTER, 300));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TRANSFORMATION_PLANKS));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TRANSFORMATION_STAIRS));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TRANSFORMATION_SLAB));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TRANSFORMATION_BUTTON));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.TRANSFORMATION_FENCE, 300));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.TRANSFORMATION_GATE, 300));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TRANSFORMATION_PLATE));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.TRANSFORMATION_TRAPDOOR));
        r.register((IForgeRegistryEntry)tallBlock(TFBlocks.TRANSFORMATION_DOOR));
        r.register((IForgeRegistryEntry)signBlock(TFBlocks.TRANSFORMATION_SIGN, TFBlocks.TRANSFORMATION_WALL_SIGN));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.TRANSFORMATION_BANISTER, 300));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.MINING_PLANKS));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.MINING_STAIRS));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.MINING_SLAB));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.MINING_BUTTON));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.MINING_FENCE, 300));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.MINING_GATE, 300));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.MINING_PLATE));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.MINING_TRAPDOOR));
        r.register((IForgeRegistryEntry)tallBlock(TFBlocks.MINING_DOOR));
        r.register((IForgeRegistryEntry)signBlock(TFBlocks.MINING_SIGN, TFBlocks.MINING_WALL_SIGN));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.MINING_BANISTER, 300));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.SORTING_PLANKS));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.SORTING_STAIRS));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.SORTING_SLAB));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.SORTING_BUTTON));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.SORTING_FENCE, 300));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.SORTING_GATE, 300));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.SORTING_PLATE));
        r.register((IForgeRegistryEntry)blockItem(TFBlocks.SORTING_TRAPDOOR));
        r.register((IForgeRegistryEntry)tallBlock(TFBlocks.SORTING_DOOR));
        r.register((IForgeRegistryEntry)signBlock(TFBlocks.SORTING_SIGN, TFBlocks.SORTING_WALL_SIGN));
        r.register((IForgeRegistryEntry)burningItem(TFBlocks.SORTING_BANISTER, 300));
        makeBEWLRItem(r, (RegistryObject<? extends Block>)TFBlocks.TWILIGHT_OAK_CHEST, TFBlockEntities.TF_CHEST.getId());
        makeBEWLRItem(r, (RegistryObject<? extends Block>)TFBlocks.CANOPY_CHEST, TFBlockEntities.TF_CHEST.getId());
        makeBEWLRItem(r, (RegistryObject<? extends Block>)TFBlocks.MANGROVE_CHEST, TFBlockEntities.TF_CHEST.getId());
        makeBEWLRItem(r, (RegistryObject<? extends Block>)TFBlocks.DARKWOOD_CHEST, TFBlockEntities.TF_CHEST.getId());
        makeBEWLRItem(r, (RegistryObject<? extends Block>)TFBlocks.TIME_CHEST, TFBlockEntities.TF_CHEST.getId());
        makeBEWLRItem(r, (RegistryObject<? extends Block>)TFBlocks.TRANSFORMATION_CHEST, TFBlockEntities.TF_CHEST.getId());
        makeBEWLRItem(r, (RegistryObject<? extends Block>)TFBlocks.MINING_CHEST, TFBlockEntities.TF_CHEST.getId());
        makeBEWLRItem(r, (RegistryObject<? extends Block>)TFBlocks.SORTING_CHEST, TFBlockEntities.TF_CHEST.getId());
    }
    
    private static <B extends Block> Item hollowLog(final RegistryObject<HollowLogHorizontal> horizontalLog, final RegistryObject<HollowLogVertical> verticalLog, final RegistryObject<HollowLogClimbable> climbable, final String name) {
        return (Item)new HollowLogItem(horizontalLog, verticalLog, climbable, TFItems.defaultBuilder()).setRegistryName("twilightforest", name);
    }
    
    private static <B extends Block> Item blockItem(final RegistryObject<B> block) {
        return makeBlockItem((Item)new BlockItem((Block)block.get(), TFItems.defaultBuilder()), block);
    }
    
    private static <B extends Block> Item fireImmuneBlock(final RegistryObject<B> block) {
        return makeBlockItem((Item)new BlockItem((Block)block.get(), TFItems.defaultBuilder().m_41486_()), block);
    }
    
    private static <B extends AbstractSkullCandleBlock> Item skullCandleItem(final RegistryObject<B> floor, final RegistryObject<B> wall) {
        return makeBlockItem((Item)new SkullCandleItem((AbstractSkullCandleBlock)floor.get(), (AbstractSkullCandleBlock)wall.get(), TFItems.defaultBuilder().m_41497_(Rarity.UNCOMMON)) {
            public void initializeClient(final Consumer<IItemRenderProperties> consumer) {
                consumer.accept((IItemRenderProperties)new IItemRenderProperties() {
                    public BlockEntityWithoutLevelRenderer getItemStackRenderer() {
                        return new ISTER(TFBlockEntities.SKULL_CANDLE.getId());
                    }
                });
            }
        }, (RegistryObject<? extends Block>)floor);
    }
    
    private static <B extends Block> Item burningItem(final RegistryObject<B> block, final int burntime) {
        return makeBlockItem((Item)new FurnaceFuelItem((Block)block.get(), TFItems.defaultBuilder(), burntime), block);
    }
    
    private static <B extends Block, W extends Block> Item trophyBlock(final RegistryObject<B> block, final RegistryObject<W> wallblock) {
        return makeBlockItem((Item)new TrophyItem((Block)block.get(), (Block)wallblock.get(), TFItems.defaultBuilder().m_41497_(TwilightForestMod.getRarity())) {
            public void initializeClient(final Consumer<IItemRenderProperties> consumer) {
                consumer.accept((IItemRenderProperties)new IItemRenderProperties() {
                    public BlockEntityWithoutLevelRenderer getItemStackRenderer() {
                        return new ISTER(TFBlockEntities.TROPHY.getId());
                    }
                });
            }
        }, block);
    }
    
    private static <T extends Block, E extends BlockEntity> Item wearableBlock(final RegistryObject<T> block, final RegistryObject<BlockEntityType<E>> tileentity) {
        return makeBlockItem((Item)new WearableItem((Block)block.get(), TFItems.defaultBuilder()) {
            public void initializeClient(final Consumer<IItemRenderProperties> consumer) {
                consumer.accept((IItemRenderProperties)new IItemRenderProperties() {
                    public BlockEntityWithoutLevelRenderer getItemStackRenderer() {
                        return new ISTER(tileentity.getId());
                    }
                });
            }
        }, block);
    }
    
    private static <B extends Block> Item tallBlock(final RegistryObject<B> block) {
        return makeBlockItem((Item)new DoubleHighBlockItem((Block)block.get(), TFItems.defaultBuilder()), block);
    }
    
    private static <B extends Block, W extends Block> Item signBlock(final RegistryObject<B> block, final RegistryObject<W> wallblock) {
        return makeBlockItem((Item)new SignItem(TFItems.defaultBuilder().m_41487_(16), (Block)block.get(), (Block)wallblock.get()), block);
    }
    
    private static Item makeBlockItem(final Item blockitem, final RegistryObject<? extends Block> block) {
        return (Item)blockitem.setRegistryName((ResourceLocation)Objects.requireNonNull(block.getId()));
    }
    
    private static void makeBEWLRItem(final IForgeRegistry<Item> r, final RegistryObject<? extends Block> block, final ResourceLocation rl) {
        r.register((IForgeRegistryEntry)makeBlockItem((Item)new BlockItem((Block)block.get(), TFItems.defaultBuilder()) {
            public void initializeClient(final Consumer<IItemRenderProperties> consumer) {
                consumer.accept((IItemRenderProperties)new IItemRenderProperties() {
                    public BlockEntityWithoutLevelRenderer getItemStackRenderer() {
                        return new ISTER(rl);
                    }
                });
            }
        }, block));
    }
}
