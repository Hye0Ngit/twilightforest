// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import java.util.ArrayList;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.registries.IForgeRegistryEntry;
import java.util.Collections;
import twilightforest.client.ModelRegisterCallback;
import java.util.List;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemDoor;
import net.minecraft.block.BlockSlab;
import twilightforest.TwilightForestMod;
import twilightforest.util.IMapColorSupplier;
import net.minecraft.block.properties.IProperty;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import twilightforest.compat.TFCompat;
import twilightforest.enums.MagicWoodVariant;
import twilightforest.block.BlockTFMagicLog;
import twilightforest.enums.WoodVariant;
import twilightforest.block.BlockTFLog;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import twilightforest.block.TFBlocks;
import twilightforest.enums.DeadrockVariant;
import java.util.function.Function;
import net.minecraft.util.IStringSerializable;
import java.util.Arrays;
import twilightforest.enums.ThornVariant;
import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "twilightforest")
public class RegisterItemEvent
{
    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
        final ItemRegistryHelper items = new ItemRegistryHelper((IForgeRegistry<Item>)event.getRegistry());
        items.register("naga_scale", "nagaScale", new ItemTF(EnumRarity.UNCOMMON));
        items.register("naga_chestplate", "plateNaga", new ItemTFNagaArmor(TFItems.ARMOR_NAGA, EntityEquipmentSlot.CHEST, EnumRarity.UNCOMMON).func_77625_d(1));
        items.register("naga_leggings", "legsNaga", new ItemTFNagaArmor(TFItems.ARMOR_NAGA, EntityEquipmentSlot.LEGS, EnumRarity.UNCOMMON).func_77625_d(1));
        items.register("twilight_scepter", "scepterTwilight", new ItemTFTwilightWand(EnumRarity.UNCOMMON).func_77625_d(1));
        items.register("lifedrain_scepter", "scepterLifeDrain", new ItemTFScepterLifeDrain(EnumRarity.UNCOMMON).func_77625_d(1));
        items.register("zombie_scepter", "scepterZombie", new ItemTFZombieWand(EnumRarity.UNCOMMON).func_77625_d(1));
        items.register("shield_scepter", "scepterShield", new ItemTFShieldWand(EnumRarity.UNCOMMON).func_77625_d(1));
        items.register("ore_meter", "oreMeter", new ItemTFOreMeter().func_77625_d(1));
        items.register("magic_map", "magicMap", new ItemTFMagicMap().func_77625_d(1));
        items.register("maze_map", "mazeMap", new ItemTFMazeMap(false).func_77625_d(1));
        items.register("ore_map", "oreMap", new ItemTFMazeMap(true).func_77625_d(1));
        items.register("raven_feather", "tfFeather", new ItemTF());
        items.register("magic_map_focus", "magicMapFocus", new ItemTF());
        items.register("maze_map_focus", "mazeMapFocus", new ItemTF());
        items.register("liveroot", "liveRoot", new ItemTF());
        items.register("ironwood_raw", "ironwoodRaw", new ItemTF());
        items.register("ironwood_ingot", "ironwoodIngot", new ItemTF());
        items.register("ironwood_helmet", "ironwoodHelm", new ItemTFIronwoodArmor(TFItems.ARMOR_IRONWOOD, EntityEquipmentSlot.HEAD, EnumRarity.COMMON).func_77625_d(1));
        items.register("ironwood_chestplate", "ironwoodPlate", new ItemTFIronwoodArmor(TFItems.ARMOR_IRONWOOD, EntityEquipmentSlot.CHEST, EnumRarity.COMMON).func_77625_d(1));
        items.register("ironwood_leggings", "ironwoodLegs", new ItemTFIronwoodArmor(TFItems.ARMOR_IRONWOOD, EntityEquipmentSlot.LEGS, EnumRarity.COMMON).func_77625_d(1));
        items.register("ironwood_boots", "ironwoodBoots", new ItemTFIronwoodArmor(TFItems.ARMOR_IRONWOOD, EntityEquipmentSlot.FEET, EnumRarity.COMMON).func_77625_d(1));
        items.register("ironwood_sword", "ironwoodSword", new ItemTFIronwoodSword(TFItems.TOOL_IRONWOOD).func_77625_d(1));
        items.register("ironwood_shovel", "ironwoodShovel", new ItemTFIronwoodShovel(TFItems.TOOL_IRONWOOD).func_77625_d(1));
        items.register("ironwood_pickaxe", "ironwoodPick", new ItemTFIronwoodPick(TFItems.TOOL_IRONWOOD).func_77625_d(1));
        items.register("ironwood_axe", "ironwoodAxe", new ItemTFIronwoodAxe(TFItems.TOOL_IRONWOOD).func_77625_d(1));
        items.register("ironwood_hoe", "ironwoodHoe", new ItemTFIronwoodHoe(TFItems.TOOL_IRONWOOD).func_77625_d(1));
        items.register("torchberries", "torchberries", new ItemTF());
        items.register("raw_venison", "venisonRaw", new ItemTFFood(3, 0.3f, true));
        items.register("cooked_venison", "venisonCooked", new ItemTFFood(8, 0.8f, true));
        items.register("hydra_chop", "hydraChop", new ItemTFHydraChops(18, 2.0f).func_185070_a(new PotionEffect(MobEffects.field_76428_l, 100, 0), 1.0f));
        items.register("fiery_blood", "fieryBlood", new ItemTF(EnumRarity.UNCOMMON));
        items.register("fiery_tears", "fieryTears", new ItemTF(EnumRarity.UNCOMMON));
        items.register("trophy", "trophy", new ItemTFTrophy());
        items.register("fiery_ingot", "fieryIngot", new ItemTF(EnumRarity.UNCOMMON));
        items.register("fiery_helmet", "fieryHelm", new ItemTFFieryArmor(TFItems.ARMOR_FIERY, EntityEquipmentSlot.HEAD, EnumRarity.UNCOMMON).func_77625_d(1));
        items.register("fiery_chestplate", "fieryPlate", new ItemTFFieryArmor(TFItems.ARMOR_FIERY, EntityEquipmentSlot.CHEST, EnumRarity.UNCOMMON).func_77625_d(1));
        items.register("fiery_leggings", "fieryLegs", new ItemTFFieryArmor(TFItems.ARMOR_FIERY, EntityEquipmentSlot.LEGS, EnumRarity.UNCOMMON).func_77625_d(1));
        items.register("fiery_boots", "fieryBoots", new ItemTFFieryArmor(TFItems.ARMOR_FIERY, EntityEquipmentSlot.FEET, EnumRarity.UNCOMMON).func_77625_d(1));
        items.register("fiery_sword", "fierySword", new ItemTFFierySword(TFItems.TOOL_FIERY).func_77625_d(1));
        items.register("fiery_pickaxe", "fieryPick", new ItemTFFieryPick(TFItems.TOOL_FIERY).func_77625_d(1));
        items.register("steeleaf_ingot", "steeleafIngot", new ItemTF());
        items.register("steeleaf_helmet", "steeleafHelm", new ItemTFSteeleafArmor(TFItems.ARMOR_STEELEAF, EntityEquipmentSlot.HEAD, EnumRarity.COMMON).func_77625_d(1));
        items.register("steeleaf_chestplate", "steeleafPlate", new ItemTFSteeleafArmor(TFItems.ARMOR_STEELEAF, EntityEquipmentSlot.CHEST, EnumRarity.COMMON).func_77625_d(1));
        items.register("steeleaf_leggings", "steeleafLegs", new ItemTFSteeleafArmor(TFItems.ARMOR_STEELEAF, EntityEquipmentSlot.LEGS, EnumRarity.COMMON).func_77625_d(1));
        items.register("steeleaf_boots", "steeleafBoots", new ItemTFSteeleafArmor(TFItems.ARMOR_STEELEAF, EntityEquipmentSlot.FEET, EnumRarity.COMMON).func_77625_d(1));
        items.register("steeleaf_sword", "steeleafSword", new ItemTFSteeleafSword(TFItems.TOOL_STEELEAF).func_77625_d(1));
        items.register("steeleaf_shovel", "steeleafShovel", new ItemTFSteeleafShovel(TFItems.TOOL_STEELEAF).func_77625_d(1));
        items.register("steeleaf_pickaxe", "steeleafPick", new ItemTFSteeleafPick(TFItems.TOOL_STEELEAF).func_77625_d(1));
        items.register("steeleaf_axe", "steeleafAxe", new ItemTFSteeleafAxe(TFItems.TOOL_STEELEAF).func_77625_d(1));
        items.register("steeleaf_hoe", "steeleafHoe", new ItemTFSteeleafHoe(TFItems.TOOL_STEELEAF).func_77625_d(1));
        items.register("minotaur_axe_gold", "minotaurAxeGold", new ItemTFMinotaurAxe(Item.ToolMaterial.GOLD, EnumRarity.COMMON).func_77625_d(1));
        items.register("minotaur_axe", "minotaurAxe", new ItemTFMinotaurAxe(Item.ToolMaterial.DIAMOND, EnumRarity.UNCOMMON).func_77625_d(1));
        items.register("mazebreaker_pickaxe", "mazebreakerPick", new ItemTFMazebreakerPick(Item.ToolMaterial.DIAMOND).func_77625_d(1));
        items.register("transformation_powder", "transformPowder", new ItemTFTransformPowder());
        items.register("raw_meef", "meefRaw", new ItemTFFood(2, 0.3f, true));
        items.register("cooked_meef", "meefSteak", new ItemTFFood(6, 0.6f, true));
        items.register("meef_stroganoff", "meefStroganoff", new ItemTFSoup(8));
        items.register("maze_wafer", "mazeWafer", new ItemTFFood(4, 0.6f, false));
        items.register("magic_map_empty", "emptyMagicMap", new ItemTFEmptyMagicMap());
        items.register("maze_map_empty", "emptyMazeMap", new ItemTFEmptyMazeMap(false));
        items.register("ore_map_empty", "emptyOreMap", new ItemTFEmptyMazeMap(true));
        items.register("ore_magnet", "oreMagnet", new ItemTFOreMagnet());
        items.register("crumble_horn", "crumbleHorn", new ItemTFCrumbleHorn(EnumRarity.RARE));
        items.register("peacock_fan", "peacockFan", new ItemTFPeacockFan(EnumRarity.RARE));
        items.register("moonworm_queen", "moonwormQueen", new ItemTFMoonwormQueen(EnumRarity.RARE));
        items.register("charm_of_life_1", "charmOfLife1", new ItemCharmBaubleable(EnumRarity.UNCOMMON));
        items.register("charm_of_life_2", "charmOfLife2", new ItemCharmBaubleable(EnumRarity.UNCOMMON));
        items.register("charm_of_keeping_1", "charmOfKeeping1", new ItemCharmBaubleable(EnumRarity.UNCOMMON));
        items.register("charm_of_keeping_2", "charmOfKeeping2", new ItemCharmBaubleable(EnumRarity.UNCOMMON));
        items.register("charm_of_keeping_3", "charmOfKeeping3", new ItemCharmBaubleable(EnumRarity.UNCOMMON));
        items.register("tower_key", "towerKey", new ItemTFTowerKey(EnumRarity.UNCOMMON));
        items.register("borer_essence", "borerEssence", new ItemTF());
        items.register("carminite", "carminite", new ItemTF());
        items.register("experiment_115", "experiment115", new ItemTFExperiment115());
        items.register("armor_shard", "armorShards", new ItemTF());
        items.register("knightmetal_ingot", "knightMetal", new ItemTF());
        items.register("armor_shard_cluster", "shardCluster", new ItemTF());
        items.register("knightmetal_helmet", "knightlyHelm", new ItemTFKnightlyArmor(TFItems.ARMOR_KNIGHTLY, EntityEquipmentSlot.HEAD, EnumRarity.COMMON).func_77625_d(1));
        items.register("knightmetal_chestplate", "knightlyPlate", new ItemTFKnightlyArmor(TFItems.ARMOR_KNIGHTLY, EntityEquipmentSlot.CHEST, EnumRarity.COMMON).func_77625_d(1));
        items.register("knightmetal_leggings", "knightlyLegs", new ItemTFKnightlyArmor(TFItems.ARMOR_KNIGHTLY, EntityEquipmentSlot.LEGS, EnumRarity.COMMON).func_77625_d(1));
        items.register("knightmetal_boots", "knightlyBoots", new ItemTFKnightlyArmor(TFItems.ARMOR_KNIGHTLY, EntityEquipmentSlot.FEET, EnumRarity.COMMON).func_77625_d(1));
        items.register("knightmetal_sword", "knightlySword", new ItemTFKnightlySword(TFItems.TOOL_KNIGHTLY).func_77625_d(1));
        items.register("knightmetal_pickaxe", "knightlyPick", new ItemTFKnightlyPick(TFItems.TOOL_KNIGHTLY).func_77625_d(1));
        items.register("knightmetal_axe", "knightlyAxe", new ItemTFKnightlyAxe(TFItems.TOOL_KNIGHTLY).func_77625_d(1));
        items.register("knightmetal_shield", "knightlyShield", new ItemKnightlyShield().func_77625_d(1));
        items.register("phantom_helmet", "phantomHelm", new ItemTFPhantomArmor(TFItems.ARMOR_PHANTOM, EntityEquipmentSlot.HEAD, EnumRarity.UNCOMMON).func_77625_d(1));
        items.register("phantom_chestplate", "phantomPlate", new ItemTFPhantomArmor(TFItems.ARMOR_PHANTOM, EntityEquipmentSlot.CHEST, EnumRarity.UNCOMMON).func_77625_d(1));
        items.register("lamp_of_cinders", "lampOfCinders", new ItemTFLampOfCinders(EnumRarity.UNCOMMON));
        items.register("alpha_fur", "alphaFur", new ItemTF(EnumRarity.UNCOMMON));
        items.register("yeti_helmet", "yetiHelm", new ItemTFYetiArmor(TFItems.ARMOR_YETI, EntityEquipmentSlot.HEAD, EnumRarity.UNCOMMON).func_77625_d(1));
        items.register("yeti_chestplate", "yetiPlate", new ItemTFYetiArmor(TFItems.ARMOR_YETI, EntityEquipmentSlot.CHEST, EnumRarity.UNCOMMON).func_77625_d(1));
        items.register("yeti_leggings", "yetiLegs", new ItemTFYetiArmor(TFItems.ARMOR_YETI, EntityEquipmentSlot.LEGS, EnumRarity.UNCOMMON).func_77625_d(1));
        items.register("yeti_boots", "yetiBoots", new ItemTFYetiArmor(TFItems.ARMOR_YETI, EntityEquipmentSlot.FEET, EnumRarity.UNCOMMON).func_77625_d(1));
        items.register("ice_bomb", "iceBomb", new ItemTFIceBomb().func_77625_d(16));
        items.register("arctic_fur", "arcticFur", new ItemTF());
        items.register("arctic_helmet", "arcticHelm", new ItemTFArcticArmor(TFItems.ARMOR_ARCTIC, EntityEquipmentSlot.HEAD, EnumRarity.COMMON).func_77625_d(1));
        items.register("arctic_chestplate", "arcticPlate", new ItemTFArcticArmor(TFItems.ARMOR_ARCTIC, EntityEquipmentSlot.CHEST, EnumRarity.COMMON).func_77625_d(1));
        items.register("arctic_leggings", "arcticLegs", new ItemTFArcticArmor(TFItems.ARMOR_ARCTIC, EntityEquipmentSlot.LEGS, EnumRarity.COMMON).func_77625_d(1));
        items.register("arctic_boots", "arcticBoots", new ItemTFArcticArmor(TFItems.ARMOR_ARCTIC, EntityEquipmentSlot.FEET, EnumRarity.COMMON).func_77625_d(1));
        items.register("magic_beans", "magicBeans", new ItemTFMagicBeans());
        items.register("giant_pickaxe", "giantPick", new ItemTFGiantPick(TFItems.TOOL_GIANT).func_77625_d(1));
        items.register("giant_sword", "giantSword", new ItemTFGiantSword(TFItems.TOOL_GIANT).func_77625_d(1));
        items.register("triple_bow", "tripleBow", new ItemTFTripleBow().func_77625_d(1));
        items.register("seeker_bow", "seekerBow", new ItemTFSeekerBow().func_77625_d(1));
        items.register("ice_bow", "iceBow", new ItemTFIceBow().func_77625_d(1));
        items.register("ender_bow", "enderBow", new ItemTFEnderBow().func_77625_d(1));
        items.register("ice_sword", "iceSword", new ItemTFIceSword(TFItems.TOOL_ICE).func_77625_d(1));
        items.register("glass_sword", "glassSword", new ItemTFGlassSword(TFItems.TOOL_GLASS).func_77625_d(1));
        items.register("knightmetal_ring", "knightmetalRing", new ItemTF());
        items.register("block_and_chain", "chainBlock", new ItemTFChainBlock().func_77625_d(1));
        items.register("cube_talisman", "cubeTalisman", new ItemTF(EnumRarity.UNCOMMON));
        items.register("cube_of_annihilation", "cubeOfAnnihilation", new ItemTFCubeOfAnnihilation(EnumRarity.UNCOMMON).func_77625_d(1));
        items.register("moon_dial", "moonDial", new ItemTFMoonDial());
        final String[] thornNames = Arrays.stream(ThornVariant.values()).map((Function<? super ThornVariant, ?>)IStringSerializable::func_176610_l).toArray(String[]::new);
        final String[] deadrockNames = Arrays.stream(DeadrockVariant.values()).map((Function<? super DeadrockVariant, ?>)IStringSerializable::func_176610_l).toArray(String[]::new);
        items.registerSubItemBlock(TFBlocks.twilight_log);
        items.registerSubItemBlock(TFBlocks.root);
        items.register(new ItemBlockTFLeaves((Block)TFBlocks.twilight_leaves));
        items.register(new ItemBlockWearable(TFBlocks.firefly));
        items.register(new ItemBlockWearable(TFBlocks.cicada));
        items.registerSubItemBlock(TFBlocks.maze_stone);
        items.registerSubItemBlock(TFBlocks.hedge);
        items.registerSubItemBlock(TFBlocks.boss_spawner);
        items.registerBlock(TFBlocks.firefly_jar);
        items.register(new ItemBlockTFPlant(TFBlocks.twilight_plant));
        items.registerBlock(TFBlocks.uncrafting_table);
        items.registerSubItemBlock(TFBlocks.fire_jet);
        items.registerSubItemBlock(TFBlocks.naga_stone);
        items.register(new ItemBlockTFMeta(TFBlocks.twilight_sapling) {
            public int getItemBurnTime(final ItemStack itemStack) {
                return 100;
            }
            
            public EnumRarity func_77613_e(final ItemStack stack) {
                switch (stack.func_77960_j()) {
                    case 5:
                    case 6:
                    case 7:
                    case 8: {
                        return EnumRarity.RARE;
                    }
                    default: {
                        return EnumRarity.COMMON;
                    }
                }
            }
        }.setAppend(true));
        items.register(new ItemBlockWearable(TFBlocks.moonworm));
        items.registerSubItemBlock(TFBlocks.magic_log);
        items.register(new ItemBlockTFLeaves((Block)TFBlocks.magic_leaves));
        items.registerSubItemBlock(TFBlocks.magic_log_core);
        items.registerSubItemBlock(TFBlocks.tower_wood);
        items.registerSubItemBlock(TFBlocks.tower_device);
        items.registerSubItemBlock(TFBlocks.tower_translucent);
        items.registerBlock(TFBlocks.stronghold_shield);
        items.registerSubItemBlock(TFBlocks.trophy_pedestal);
        items.registerBlock(TFBlocks.aurora_block);
        items.registerSubItemBlock(TFBlocks.underbrick);
        items.register(new ItemMultiTexture(TFBlocks.thorns, TFBlocks.thorns, thornNames));
        items.registerBlock(TFBlocks.burnt_thorns);
        items.registerBlock(TFBlocks.thorn_rose);
        items.register(new ItemBlockTFLeaves((Block)TFBlocks.twilight_leaves_3));
        items.register(new ItemMultiTexture(TFBlocks.deadrock, TFBlocks.deadrock, deadrockNames));
        items.registerBlock(TFBlocks.dark_leaves);
        items.registerBlock(TFBlocks.aurora_pillar);
        items.register(new ItemSlab((Block)TFBlocks.aurora_slab, TFBlocks.aurora_slab, TFBlocks.double_aurora_slab));
        items.registerBlock(TFBlocks.trollsteinn);
        items.registerBlock(TFBlocks.wispy_cloud);
        items.registerBlock(TFBlocks.fluffy_cloud);
        items.register(new ItemTFGiantBlock(TFBlocks.giant_cobblestone));
        items.register(new ItemTFGiantBlock(TFBlocks.giant_log));
        items.register(new ItemTFGiantBlock(TFBlocks.giant_leaves));
        items.register(new ItemTFGiantBlock(TFBlocks.giant_obsidian));
        items.registerBlock(TFBlocks.uberous_soil);
        items.registerBlock(TFBlocks.huge_stalk);
        items.registerBlock(TFBlocks.huge_mushgloom);
        items.registerBlock(TFBlocks.trollvidr);
        items.registerBlock(TFBlocks.unripe_trollber);
        items.registerBlock(TFBlocks.trollber);
        items.registerBlock(TFBlocks.knightmetal_block);
        items.register(new ItemBlockTFHugeLilyPad(TFBlocks.huge_lilypad));
        items.register(new ItemBlockTFHugeWaterLily(TFBlocks.huge_waterlily));
        items.registerSubItemBlock(TFBlocks.slider);
        items.registerSubItemBlock(TFBlocks.castle_brick);
        items.registerBlock(TFBlocks.castle_stairs_brick);
        items.registerBlock(TFBlocks.castle_stairs_cracked);
        items.registerBlock(TFBlocks.castle_stairs_worn);
        items.registerBlock(TFBlocks.castle_stairs_mossy);
        items.registerSubItemBlock(TFBlocks.castle_pillar);
        items.registerSubItemBlock(TFBlocks.castle_stairs);
        items.registerSubItemBlock(TFBlocks.castle_rune_brick);
        items.registerSubItemBlock(TFBlocks.force_field);
        items.registerBlock(TFBlocks.cinder_furnace);
        items.registerBlock(TFBlocks.cinder_log);
        items.registerSubItemBlock(TFBlocks.castle_door);
        items.register(new ItemTFMiniatureStructure(TFBlocks.miniature_structure));
        items.register(new ItemTFCompressed(TFBlocks.block_storage));
        items.registerBlock(TFBlocks.spiral_bricks);
        items.registerBlock(TFBlocks.etched_nagastone);
        items.registerBlock(TFBlocks.nagastone_pillar);
        items.registerSubItemBlock(TFBlocks.nagastone_stairs);
        items.registerBlock(TFBlocks.etched_nagastone_mossy);
        items.registerBlock(TFBlocks.nagastone_pillar_mossy);
        items.registerSubItemBlock(TFBlocks.nagastone_stairs_mossy);
        items.registerBlock(TFBlocks.etched_nagastone_weathered);
        items.registerBlock(TFBlocks.nagastone_pillar_weathered);
        items.registerSubItemBlock(TFBlocks.nagastone_stairs_weathered);
        items.registerBlock(TFBlocks.auroralized_glass);
        items.registerBlock((Block)TFBlocks.iron_ladder);
        items.registerBlock(TFBlocks.terrorcotta_circle);
        items.registerBlock(TFBlocks.terrorcotta_diagonal);
        items.registerBlock(TFBlocks.stone_twist);
        items.registerBlock(TFBlocks.stone_twist_thin);
        registerWoodVariants(items, BlockTFLog.VARIANT, WoodVariant.values());
        registerWoodVariants(items, BlockTFMagicLog.VARIANT, MagicWoodVariant.values());
        TFCompat.initCompatItems(items);
    }
    
    private static <T extends IStringSerializable & Comparable<T> & IMapColorSupplier> void registerWoodVariants(final ItemRegistryHelper items, final IProperty<T> key, final T[] types) {
        for (final T woodType : types) {
            String woodName = woodType.func_176610_l();
            if ("oak".equals(woodName)) {
                woodName = "twilight_oak";
            }
            items.registerBlock((Block)Block.field_149771_c.func_82594_a((Object)TwilightForestMod.prefix(woodName + "_planks")));
            items.registerBlock((Block)Block.field_149771_c.func_82594_a((Object)TwilightForestMod.prefix(woodName + "_stairs")));
            final BlockSlab slab = (BlockSlab)Block.field_149771_c.func_82594_a((Object)TwilightForestMod.prefix(woodName + "_slab"));
            items.register(woodName + "_slab", new ItemSlab((Block)slab, slab, (BlockSlab)Block.field_149771_c.func_82594_a((Object)TwilightForestMod.prefix(woodName + "_doubleslab"))));
            items.registerBlock((Block)Block.field_149771_c.func_82594_a((Object)TwilightForestMod.prefix(woodName + "_button")));
            final ResourceLocation doorRL = TwilightForestMod.prefix(woodName + "_door");
            final Block doorBlock = (Block)Block.field_149771_c.func_82594_a((Object)doorRL);
            items.register(doorRL.func_110623_a(), (Item)new ItemDoor(doorBlock)).func_77655_b(doorBlock.func_149739_a());
            items.registerBlock((Block)Block.field_149771_c.func_82594_a((Object)TwilightForestMod.prefix(woodName + "_trapdoor")));
            items.registerBlock((Block)Block.field_149771_c.func_82594_a((Object)TwilightForestMod.prefix(woodName + "_fence")));
            items.registerBlock((Block)Block.field_149771_c.func_82594_a((Object)TwilightForestMod.prefix(woodName + "_gate")));
            items.registerBlock((Block)Block.field_149771_c.func_82594_a((Object)TwilightForestMod.prefix(woodName + "_plate")));
        }
    }
    
    public static List<ModelRegisterCallback> getItemModels() {
        return Collections.unmodifiableList((List<? extends ModelRegisterCallback>)ItemRegistryHelper.itemModels);
    }
    
    public static class ItemRegistryHelper
    {
        static final List<ModelRegisterCallback> itemModels;
        private final IForgeRegistry<Item> registry;
        
        ItemRegistryHelper(final IForgeRegistry<Item> registry) {
            this.registry = registry;
        }
        
         <T extends Item> void register(final String registryName, final String translationKey, final T item) {
            item.func_77655_b("twilightforest." + translationKey);
            this.register(registryName, item);
        }
        
        public <T extends Item> Item register(final String registryName, final T item) {
            item.setRegistryName("twilightforest", registryName);
            if (item instanceof ModelRegisterCallback) {
                ItemRegistryHelper.itemModels.add((ModelRegisterCallback)item);
            }
            this.registry.register((IForgeRegistryEntry)item);
            return item;
        }
        
        void registerBlock(final Block block) {
            this.register(new ItemBlock(block));
        }
        
        void registerSubItemBlock(final Block block) {
            this.registerSubItemBlock(block, true);
        }
        
        void registerSubItemBlock(final Block block, final boolean shouldAppendNumber) {
            this.register(new ItemBlockTFMeta(block).setAppend(shouldAppendNumber));
        }
        
         <T extends ItemBlock> void register(final T item) {
            item.setRegistryName(item.func_179223_d().getRegistryName());
            item.func_77655_b(item.func_179223_d().func_149739_a());
            this.registry.register((IForgeRegistryEntry)item);
        }
        
        static {
            itemModels = new ArrayList<ModelRegisterCallback>();
        }
    }
}
