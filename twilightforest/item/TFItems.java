// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.BowlFoodItem;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.entity.EquipmentSlot;
import twilightforest.enums.TwilightArmorMaterial;
import twilightforest.util.TwilightItemTier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import twilightforest.TFSounds;
import net.minecraft.world.item.BannerPatternItem;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import javax.annotation.Nullable;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.item.ItemPropertyFunction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.item.ItemProperties;
import twilightforest.TwilightForestMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import java.util.UUID;
import net.minecraft.world.food.FoodProperties;

public class TFItems
{
    public static final FoodProperties E115;
    public static final FoodProperties CHOP;
    public static final FoodProperties WAFER;
    public static final FoodProperties MEEF_COOKED;
    public static final FoodProperties MEEF_RAW;
    public static final FoodProperties STROGANOFF;
    public static final FoodProperties VENISON_COOKED;
    public static final FoodProperties VENISON_RAW;
    public static final FoodProperties TORCHBERRY;
    public static final UUID GIANT_REACH_MODIFIER;
    public static final DeferredRegister<Item> ITEMS;
    public static final RegistryObject<Item> NAGA_SCALE;
    public static final RegistryObject<Item> NAGA_CHESTPLATE;
    public static final RegistryObject<Item> NAGA_LEGGINGS;
    public static final RegistryObject<Item> TWILIGHT_SCEPTER;
    public static final RegistryObject<Item> LIFEDRAIN_SCEPTER;
    public static final RegistryObject<Item> ZOMBIE_SCEPTER;
    public static final RegistryObject<Item> FORTIFICATION_SCEPTER;
    public static final RegistryObject<Item> ORE_METER;
    public static final RegistryObject<Item> FILLED_MAGIC_MAP;
    public static final RegistryObject<Item> FILLED_MAZE_MAP;
    public static final RegistryObject<Item> FILLED_ORE_MAP;
    public static final RegistryObject<Item> RAVEN_FEATHER;
    public static final RegistryObject<Item> MAGIC_MAP_FOCUS;
    public static final RegistryObject<Item> MAZE_MAP_FOCUS;
    public static final RegistryObject<Item> MAGIC_MAP;
    public static final RegistryObject<Item> MAZE_MAP;
    public static final RegistryObject<Item> ORE_MAP;
    public static final RegistryObject<Item> LIVEROOT;
    public static final RegistryObject<Item> RAW_IRONWOOD;
    public static final RegistryObject<Item> IRONWOOD_INGOT;
    public static final RegistryObject<Item> IRONWOOD_HELMET;
    public static final RegistryObject<Item> IRONWOOD_CHESTPLATE;
    public static final RegistryObject<Item> IRONWOOD_LEGGINGS;
    public static final RegistryObject<Item> IRONWOOD_BOOTS;
    public static final RegistryObject<Item> IRONWOOD_SWORD;
    public static final RegistryObject<Item> IRONWOOD_SHOVEL;
    public static final RegistryObject<Item> IRONWOOD_PICKAXE;
    public static final RegistryObject<Item> IRONWOOD_AXE;
    public static final RegistryObject<Item> IRONWOOD_HOE;
    public static final RegistryObject<Item> TORCHBERRIES;
    public static final RegistryObject<Item> RAW_VENISON;
    public static final RegistryObject<Item> COOKED_VENISON;
    public static final RegistryObject<Item> HYDRA_CHOP;
    public static final RegistryObject<Item> FIERY_BLOOD;
    public static final RegistryObject<Item> FIERY_TEARS;
    public static final RegistryObject<Item> FIERY_INGOT;
    public static final RegistryObject<Item> FIERY_HELMET;
    public static final RegistryObject<Item> FIERY_CHESTPLATE;
    public static final RegistryObject<Item> FIERY_LEGGINGS;
    public static final RegistryObject<Item> FIERY_BOOTS;
    public static final RegistryObject<Item> FIERY_SWORD;
    public static final RegistryObject<Item> FIERY_PICKAXE;
    public static final RegistryObject<Item> STEELEAF_INGOT;
    public static final RegistryObject<Item> STEELEAF_HELMET;
    public static final RegistryObject<Item> STEELEAF_CHESTPLATE;
    public static final RegistryObject<Item> STEELEAF_LEGGINGS;
    public static final RegistryObject<Item> STEELEAF_BOOTS;
    public static final RegistryObject<Item> STEELEAF_SWORD;
    public static final RegistryObject<Item> STEELEAF_SHOVEL;
    public static final RegistryObject<Item> STEELEAF_PICKAXE;
    public static final RegistryObject<Item> STEELEAF_AXE;
    public static final RegistryObject<Item> STEELEAF_HOE;
    public static final RegistryObject<Item> GOLDEN_MINOTAUR_AXE;
    public static final RegistryObject<Item> DIAMOND_MINOTAUR_AXE;
    public static final RegistryObject<Item> MAZEBREAKER_PICKAXE;
    public static final RegistryObject<Item> TRANSFORMATION_POWDER;
    public static final RegistryObject<Item> RAW_MEEF;
    public static final RegistryObject<Item> COOKED_MEEF;
    public static final RegistryObject<Item> MEEF_STROGANOFF;
    public static final RegistryObject<Item> MAZE_WAFER;
    public static final RegistryObject<Item> ORE_MAGNET;
    public static final RegistryObject<Item> CRUMBLE_HORN;
    public static final RegistryObject<Item> PEACOCK_FEATHER_FAN;
    public static final RegistryObject<Item> MOONWORM_QUEEN;
    public static final RegistryObject<Item> BRITTLE_FLASK;
    public static final RegistryObject<Item> GREATER_FLASK;
    public static final RegistryObject<Item> CHARM_OF_LIFE_1;
    public static final RegistryObject<Item> CHARM_OF_LIFE_2;
    public static final RegistryObject<Item> CHARM_OF_KEEPING_1;
    public static final RegistryObject<Item> CHARM_OF_KEEPING_2;
    public static final RegistryObject<Item> CHARM_OF_KEEPING_3;
    public static final RegistryObject<Item> TOWER_KEY;
    public static final RegistryObject<Item> BORER_ESSENCE;
    public static final RegistryObject<Item> CARMINITE;
    public static final RegistryObject<Item> EXPERIMENT_115;
    public static final RegistryObject<Item> ARMOR_SHARD;
    public static final RegistryObject<Item> ARMOR_SHARD_CLUSTER;
    public static final RegistryObject<Item> KNIGHTMETAL_INGOT;
    public static final RegistryObject<Item> KNIGHTMETAL_HELMET;
    public static final RegistryObject<Item> KNIGHTMETAL_CHESTPLATE;
    public static final RegistryObject<Item> KNIGHTMETAL_LEGGINGS;
    public static final RegistryObject<Item> KNIGHTMETAL_BOOTS;
    public static final RegistryObject<Item> KNIGHTMETAL_SWORD;
    public static final RegistryObject<Item> KNIGHTMETAL_PICKAXE;
    public static final RegistryObject<Item> KNIGHTMETAL_AXE;
    public static final RegistryObject<Item> KNIGHTMETAL_RING;
    public static final RegistryObject<Item> KNIGHTMETAL_SHIELD;
    public static final RegistryObject<Item> BLOCK_AND_CHAIN;
    public static final RegistryObject<Item> PHANTOM_HELMET;
    public static final RegistryObject<Item> PHANTOM_CHESTPLATE;
    public static final RegistryObject<Item> ICE_BOMB;
    public static final RegistryObject<Item> ARCTIC_FUR;
    public static final RegistryObject<Item> ARCTIC_HELMET;
    public static final RegistryObject<Item> ARCTIC_CHESTPLATE;
    public static final RegistryObject<Item> ARCTIC_LEGGINGS;
    public static final RegistryObject<Item> ARCTIC_BOOTS;
    public static final RegistryObject<Item> ALPHA_YETI_FUR;
    public static final RegistryObject<Item> YETI_HELMET;
    public static final RegistryObject<Item> YETI_CHESTPLATE;
    public static final RegistryObject<Item> YETI_LEGGINGS;
    public static final RegistryObject<Item> YETI_BOOTS;
    public static final RegistryObject<Item> TRIPLE_BOW;
    public static final RegistryObject<Item> SEEKER_BOW;
    public static final RegistryObject<Item> ICE_BOW;
    public static final RegistryObject<Item> ENDER_BOW;
    public static final RegistryObject<Item> ICE_SWORD;
    public static final RegistryObject<Item> GLASS_SWORD;
    public static final RegistryObject<Item> MAGIC_BEANS;
    public static final RegistryObject<Item> GIANT_PICKAXE;
    public static final RegistryObject<Item> GIANT_SWORD;
    public static final RegistryObject<Item> LAMP_OF_CINDERS;
    public static final RegistryObject<Item> CUBE_TALISMAN;
    public static final RegistryObject<Item> CUBE_OF_ANNIHILATION;
    public static final RegistryObject<Item> MOON_DIAL;
    public static final RegistryObject<Item> MUSIC_DISC_RADIANCE;
    public static final RegistryObject<Item> MUSIC_DISC_STEPS;
    public static final RegistryObject<Item> MUSIC_DISC_SUPERSTITIOUS;
    public static final RegistryObject<Item> MUSIC_DISC_HOME;
    public static final RegistryObject<Item> MUSIC_DISC_WAYFARER;
    public static final RegistryObject<Item> MUSIC_DISC_FINDINGS;
    public static final RegistryObject<Item> MUSIC_DISC_MAKER;
    public static final RegistryObject<Item> MUSIC_DISC_THREAD;
    public static final RegistryObject<Item> MUSIC_DISC_MOTION;
    public static final RegistryObject<Item> NAGA_BANNER_PATTERN;
    public static final RegistryObject<Item> LICH_BANNER_PATTERN;
    public static final RegistryObject<Item> MINOSHROOM_BANNER_PATTERN;
    public static final RegistryObject<Item> HYDRA_BANNER_PATTERN;
    public static final RegistryObject<Item> KNIGHT_PHANTOM_BANNER_PATTERN;
    public static final RegistryObject<Item> UR_GHAST_BANNER_PATTERN;
    public static final RegistryObject<Item> ALPHA_YETI_BANNER_PATTERN;
    public static final RegistryObject<Item> SNOW_QUEEN_BANNER_PATTERN;
    public static final RegistryObject<Item> QUEST_RAM_BANNER_PATTERN;
    public static CreativeModeTab creativeTab;
    
    public static Item.Properties defaultBuilder() {
        return new Item.Properties().m_41491_(TFItems.creativeTab);
    }
    
    public static Item.Properties unstackable() {
        return defaultBuilder().m_41487_(1);
    }
    
    @OnlyIn(Dist.CLIENT)
    public static void addItemModelProperties() {
        ItemProperties.register((Item)TFItems.CUBE_OF_ANNIHILATION.get(), TwilightForestMod.prefix("thrown"), (stack, world, entity, idk) -> (CubeOfAnnihilationItem.getThrownUuid(stack) != null) ? 1.0f : 0.0f);
        ItemProperties.register((Item)TFItems.KNIGHTMETAL_SHIELD.get(), new ResourceLocation("blocking"), (stack, world, entity, idk) -> (entity != null && entity.m_6117_() && entity.m_21211_() == stack) ? 1.0f : 0.0f);
        ItemProperties.register((Item)TFItems.MOON_DIAL.get(), new ResourceLocation("phase"), (ItemPropertyFunction)new ItemPropertyFunction() {
            @OnlyIn(Dist.CLIENT)
            double rotation;
            @OnlyIn(Dist.CLIENT)
            double rota;
            @OnlyIn(Dist.CLIENT)
            long lastUpdateTick;
            
            public float m_141951_(final ItemStack stack, @Nullable ClientLevel world, @Nullable final LivingEntity entityBase, final int idk) {
                final boolean flag = entityBase != null;
                final Entity entity = (Entity)(flag ? entityBase : stack.m_41795_());
                if (world == null && entity != null) {
                    world = (ClientLevel)entity.f_19853_;
                }
                return (world == null) ? 0.0f : ((float)(world.m_6042_().m_63956_() ? Mth.m_14187_(world.m_46941_() / 8.0f) : this.wobble((Level)world, Math.random())));
            }
            
            @OnlyIn(Dist.CLIENT)
            private double wobble(final Level world, final double rotation) {
                if (world.m_46467_() != this.lastUpdateTick) {
                    this.lastUpdateTick = world.m_46467_();
                    double delta = rotation - this.rotation;
                    delta = Mth.m_14109_(delta + 0.5, 1.0) - 0.5;
                    this.rota += delta * 0.1;
                    this.rota *= 0.9;
                    this.rotation = Mth.m_14109_(this.rotation + this.rota, 1.0);
                }
                return this.rotation;
            }
        });
        ItemProperties.register((Item)TFItems.MOONWORM_QUEEN.get(), TwilightForestMod.prefix("alt"), (stack, world, entity, idk) -> {
            if (entity != null && entity.m_21211_() == stack) {
                final int useTime = stack.m_41779_() - entity.m_21212_();
                if (useTime >= 12 && (useTime >>> 1) % 2 == 0) {
                    return 1.0f;
                }
            }
            return 0.0f;
        });
        ItemProperties.register((Item)TFItems.ENDER_BOW.get(), new ResourceLocation("pull"), (stack, world, entity, idk) -> {
            if (entity == null) {
                return 0.0f;
            }
            return (entity.m_21211_() != stack) ? 0.0f : ((stack.m_41779_() - entity.m_21212_()) / 20.0f);
        });
        ItemProperties.register((Item)TFItems.ENDER_BOW.get(), new ResourceLocation("pulling"), (stack, world, entity, idk) -> (entity != null && entity.m_6117_() && entity.m_21211_() == stack) ? 1.0f : 0.0f);
        ItemProperties.register((Item)TFItems.ICE_BOW.get(), new ResourceLocation("pull"), (stack, world, entity, idk) -> {
            if (entity == null) {
                return 0.0f;
            }
            return (entity.m_21211_() != stack) ? 0.0f : ((stack.m_41779_() - entity.m_21212_()) / 20.0f);
        });
        ItemProperties.register((Item)TFItems.ICE_BOW.get(), new ResourceLocation("pulling"), (stack, world, entity, idk) -> (entity != null && entity.m_6117_() && entity.m_21211_() == stack) ? 1.0f : 0.0f);
        ItemProperties.register((Item)TFItems.SEEKER_BOW.get(), new ResourceLocation("pull"), (stack, world, entity, idk) -> {
            if (entity == null) {
                return 0.0f;
            }
            return (entity.m_21211_() != stack) ? 0.0f : ((stack.m_41779_() - entity.m_21212_()) / 20.0f);
        });
        ItemProperties.register((Item)TFItems.SEEKER_BOW.get(), new ResourceLocation("pulling"), (stack, world, entity, idk) -> (entity != null && entity.m_6117_() && entity.m_21211_() == stack) ? 1.0f : 0.0f);
        ItemProperties.register((Item)TFItems.TRIPLE_BOW.get(), new ResourceLocation("pull"), (stack, world, entity, idk) -> {
            if (entity == null) {
                return 0.0f;
            }
            return (entity.m_21211_() != stack) ? 0.0f : ((stack.m_41779_() - entity.m_21212_()) / 20.0f);
        });
        ItemProperties.register((Item)TFItems.TRIPLE_BOW.get(), new ResourceLocation("pulling"), (stack, world, entity, idk) -> (entity != null && entity.m_6117_() && entity.m_21211_() == stack) ? 1.0f : 0.0f);
        ItemProperties.register((Item)TFItems.ORE_MAGNET.get(), new ResourceLocation("pull"), (stack, world, entity, idk) -> {
            if (entity == null) {
                return 0.0f;
            }
            final ItemStack itemstack = entity.m_21211_();
            return itemstack.m_41619_() ? 0.0f : ((stack.m_41779_() - entity.m_21212_()) / 20.0f);
        });
        ItemProperties.register((Item)TFItems.ORE_MAGNET.get(), new ResourceLocation("pulling"), (stack, world, entity, idk) -> (entity != null && entity.m_6117_() && entity.m_21211_() == stack) ? 1.0f : 0.0f);
        ItemProperties.register((Item)TFItems.BLOCK_AND_CHAIN.get(), TwilightForestMod.prefix("thrown"), (stack, world, entity, idk) -> (ChainBlockItem.getThrownUuid(stack) != null) ? 1.0f : 0.0f);
        ItemProperties.register((Item)TFItems.EXPERIMENT_115.get(), Experiment115Item.THINK, (stack, world, entity, idk) -> (stack.m_41782_() && stack.m_41783_().m_128441_("think")) ? 1.0f : 0.0f);
        ItemProperties.register((Item)TFItems.EXPERIMENT_115.get(), Experiment115Item.FULL, (stack, world, entity, idk) -> (stack.m_41782_() && stack.m_41783_().m_128441_("full")) ? 1.0f : 0.0f);
        ItemProperties.register((Item)TFItems.BRITTLE_FLASK.get(), TwilightForestMod.prefix("breakage"), (stack, world, entity, i) -> (float)stack.m_41784_().m_128451_("Breakage"));
        ItemProperties.register((Item)TFItems.BRITTLE_FLASK.get(), TwilightForestMod.prefix("potion_level"), (stack, world, entity, i) -> (float)stack.m_41784_().m_128451_("Uses"));
        ItemProperties.register((Item)TFItems.GREATER_FLASK.get(), TwilightForestMod.prefix("potion_level"), (stack, world, entity, i) -> (float)stack.m_41784_().m_128451_("Uses"));
    }
    
    static {
        E115 = new FoodProperties.Builder().m_38760_(4).m_38758_(0.3f).m_38767_();
        CHOP = new FoodProperties.Builder().m_38760_(18).m_38758_(2.0f).m_38757_().effect(() -> new MobEffectInstance(MobEffects.f_19605_, 100, 0), 1.0f).m_38767_();
        WAFER = new FoodProperties.Builder().m_38760_(4).m_38758_(0.6f).m_38767_();
        MEEF_COOKED = new FoodProperties.Builder().m_38760_(6).m_38758_(0.6f).m_38757_().m_38767_();
        MEEF_RAW = new FoodProperties.Builder().m_38760_(2).m_38758_(0.3f).m_38757_().m_38767_();
        STROGANOFF = new FoodProperties.Builder().m_38760_(8).m_38758_(0.6f).m_38765_().m_38767_();
        VENISON_COOKED = new FoodProperties.Builder().m_38760_(8).m_38758_(0.8f).m_38757_().m_38767_();
        VENISON_RAW = new FoodProperties.Builder().m_38760_(3).m_38758_(0.3f).m_38757_().m_38767_();
        TORCHBERRY = new FoodProperties.Builder().m_38765_().effect(() -> new MobEffectInstance(MobEffects.f_19619_, 100, 0), 0.75f).m_38767_();
        GIANT_REACH_MODIFIER = UUID.fromString("7f10172d-de69-49d7-81bd-9594286a6827");
        ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "twilightforest");
        NAGA_SCALE = TFItems.ITEMS.register("naga_scale", () -> new Item(defaultBuilder().m_41497_(Rarity.UNCOMMON)));
        NAGA_CHESTPLATE = TFItems.ITEMS.register("naga_chestplate", () -> new NagaArmorItem((ArmorMaterial)TwilightArmorMaterial.ARMOR_NAGA, EquipmentSlot.CHEST, defaultBuilder().m_41497_(Rarity.UNCOMMON)));
        NAGA_LEGGINGS = TFItems.ITEMS.register("naga_leggings", () -> new NagaArmorItem((ArmorMaterial)TwilightArmorMaterial.ARMOR_NAGA, EquipmentSlot.LEGS, defaultBuilder().m_41497_(Rarity.UNCOMMON)));
        TWILIGHT_SCEPTER = TFItems.ITEMS.register("twilight_scepter", () -> new TwilightWandItem(defaultBuilder().m_41503_(99).m_41497_(Rarity.UNCOMMON)));
        LIFEDRAIN_SCEPTER = TFItems.ITEMS.register("lifedrain_scepter", () -> new LifedrainScepterItem(defaultBuilder().m_41503_(99).m_41497_(Rarity.UNCOMMON)));
        ZOMBIE_SCEPTER = TFItems.ITEMS.register("zombie_scepter", () -> new ZombieWandItem(defaultBuilder().m_41503_(9).m_41497_(Rarity.UNCOMMON)));
        FORTIFICATION_SCEPTER = TFItems.ITEMS.register("fortification_scepter", () -> new FortificationWandItem(defaultBuilder().m_41503_(9).m_41497_(Rarity.UNCOMMON)));
        ORE_METER = TFItems.ITEMS.register("ore_meter", () -> new OreMeterItem(defaultBuilder()));
        FILLED_MAGIC_MAP = TFItems.ITEMS.register("filled_magic_map", () -> {
            new MagicMapItem(new Item.Properties().m_41487_(1));
            return;
        });
        FILLED_MAZE_MAP = TFItems.ITEMS.register("filled_maze_map", () -> {
            new MazeMapItem(false, new Item.Properties().m_41487_(1));
            return;
        });
        FILLED_ORE_MAP = TFItems.ITEMS.register("filled_ore_map", () -> {
            new MazeMapItem(true, new Item.Properties().m_41487_(1).m_41497_(Rarity.UNCOMMON));
            return;
        });
        RAVEN_FEATHER = TFItems.ITEMS.register("raven_feather", () -> new Item(defaultBuilder()));
        MAGIC_MAP_FOCUS = TFItems.ITEMS.register("magic_map_focus", () -> new Item(defaultBuilder()));
        MAZE_MAP_FOCUS = TFItems.ITEMS.register("maze_map_focus", () -> new Item(defaultBuilder()));
        MAGIC_MAP = TFItems.ITEMS.register("magic_map", () -> new EmptyMagicMapItem(defaultBuilder()));
        MAZE_MAP = TFItems.ITEMS.register("maze_map", () -> new EmptyMazeMapItem(false, defaultBuilder()));
        ORE_MAP = TFItems.ITEMS.register("ore_map", () -> new EmptyMazeMapItem(true, defaultBuilder()));
        LIVEROOT = TFItems.ITEMS.register("liveroot", () -> new Item(defaultBuilder()));
        RAW_IRONWOOD = TFItems.ITEMS.register("raw_ironwood", () -> new Item(defaultBuilder()));
        IRONWOOD_INGOT = TFItems.ITEMS.register("ironwood_ingot", () -> new Item(defaultBuilder()));
        IRONWOOD_HELMET = TFItems.ITEMS.register("ironwood_helmet", () -> new IronwoodArmorItem((ArmorMaterial)TwilightArmorMaterial.ARMOR_IRONWOOD, EquipmentSlot.HEAD, defaultBuilder()));
        IRONWOOD_CHESTPLATE = TFItems.ITEMS.register("ironwood_chestplate", () -> new IronwoodArmorItem((ArmorMaterial)TwilightArmorMaterial.ARMOR_IRONWOOD, EquipmentSlot.CHEST, defaultBuilder()));
        IRONWOOD_LEGGINGS = TFItems.ITEMS.register("ironwood_leggings", () -> new IronwoodArmorItem((ArmorMaterial)TwilightArmorMaterial.ARMOR_IRONWOOD, EquipmentSlot.LEGS, defaultBuilder()));
        IRONWOOD_BOOTS = TFItems.ITEMS.register("ironwood_boots", () -> new IronwoodArmorItem((ArmorMaterial)TwilightArmorMaterial.ARMOR_IRONWOOD, EquipmentSlot.FEET, defaultBuilder()));
        IRONWOOD_SWORD = TFItems.ITEMS.register("ironwood_sword", () -> new IronwoodSwordItem(TwilightItemTier.IRONWOOD, defaultBuilder()));
        IRONWOOD_SHOVEL = TFItems.ITEMS.register("ironwood_shovel", () -> new IronwoodShovelItem(TwilightItemTier.IRONWOOD, defaultBuilder()));
        IRONWOOD_PICKAXE = TFItems.ITEMS.register("ironwood_pickaxe", () -> new IronwoodPickItem(TwilightItemTier.IRONWOOD, defaultBuilder()));
        IRONWOOD_AXE = TFItems.ITEMS.register("ironwood_axe", () -> new IronwoodAxeItem(TwilightItemTier.IRONWOOD, defaultBuilder()));
        IRONWOOD_HOE = TFItems.ITEMS.register("ironwood_hoe", () -> new IronwoodHoeItem(TwilightItemTier.IRONWOOD, defaultBuilder()));
        TORCHBERRIES = TFItems.ITEMS.register("torchberries", () -> new Item(defaultBuilder().m_41489_(TFItems.TORCHBERRY)));
        RAW_VENISON = TFItems.ITEMS.register("raw_venison", () -> new Item(defaultBuilder().m_41489_(TFItems.VENISON_RAW)));
        COOKED_VENISON = TFItems.ITEMS.register("cooked_venison", () -> new Item(defaultBuilder().m_41489_(TFItems.VENISON_COOKED)));
        HYDRA_CHOP = TFItems.ITEMS.register("hydra_chop", () -> new HydraChopItem(defaultBuilder().m_41486_().m_41489_(TFItems.CHOP).m_41497_(Rarity.UNCOMMON)));
        FIERY_BLOOD = TFItems.ITEMS.register("fiery_blood", () -> new Item(defaultBuilder().m_41497_(Rarity.UNCOMMON)));
        FIERY_TEARS = TFItems.ITEMS.register("fiery_tears", () -> new Item(defaultBuilder().m_41497_(Rarity.UNCOMMON)));
        FIERY_INGOT = TFItems.ITEMS.register("fiery_ingot", () -> new Item(defaultBuilder().m_41486_().m_41497_(Rarity.UNCOMMON)));
        FIERY_HELMET = TFItems.ITEMS.register("fiery_helmet", () -> new FieryArmorItem((ArmorMaterial)TwilightArmorMaterial.ARMOR_FIERY, EquipmentSlot.HEAD, defaultBuilder().m_41486_().m_41497_(Rarity.UNCOMMON)));
        FIERY_CHESTPLATE = TFItems.ITEMS.register("fiery_chestplate", () -> new FieryArmorItem((ArmorMaterial)TwilightArmorMaterial.ARMOR_FIERY, EquipmentSlot.CHEST, defaultBuilder().m_41486_().m_41497_(Rarity.UNCOMMON)));
        FIERY_LEGGINGS = TFItems.ITEMS.register("fiery_leggings", () -> new FieryArmorItem((ArmorMaterial)TwilightArmorMaterial.ARMOR_FIERY, EquipmentSlot.LEGS, defaultBuilder().m_41486_().m_41497_(Rarity.UNCOMMON)));
        FIERY_BOOTS = TFItems.ITEMS.register("fiery_boots", () -> new FieryArmorItem((ArmorMaterial)TwilightArmorMaterial.ARMOR_FIERY, EquipmentSlot.FEET, defaultBuilder().m_41486_().m_41497_(Rarity.UNCOMMON)));
        FIERY_SWORD = TFItems.ITEMS.register("fiery_sword", () -> new FierySwordItem(TwilightItemTier.FIERY, defaultBuilder().m_41486_().m_41497_(Rarity.UNCOMMON)));
        FIERY_PICKAXE = TFItems.ITEMS.register("fiery_pickaxe", () -> new FieryPickItem(TwilightItemTier.FIERY, defaultBuilder().m_41486_().m_41497_(Rarity.UNCOMMON)));
        STEELEAF_INGOT = TFItems.ITEMS.register("steeleaf_ingot", () -> new Item(defaultBuilder()));
        STEELEAF_HELMET = TFItems.ITEMS.register("steeleaf_helmet", () -> new SteeleafArmorItem((ArmorMaterial)TwilightArmorMaterial.ARMOR_STEELEAF, EquipmentSlot.HEAD, defaultBuilder()));
        STEELEAF_CHESTPLATE = TFItems.ITEMS.register("steeleaf_chestplate", () -> new SteeleafArmorItem((ArmorMaterial)TwilightArmorMaterial.ARMOR_STEELEAF, EquipmentSlot.CHEST, defaultBuilder()));
        STEELEAF_LEGGINGS = TFItems.ITEMS.register("steeleaf_leggings", () -> new SteeleafArmorItem((ArmorMaterial)TwilightArmorMaterial.ARMOR_STEELEAF, EquipmentSlot.LEGS, defaultBuilder()));
        STEELEAF_BOOTS = TFItems.ITEMS.register("steeleaf_boots", () -> new SteeleafArmorItem((ArmorMaterial)TwilightArmorMaterial.ARMOR_STEELEAF, EquipmentSlot.FEET, defaultBuilder()));
        STEELEAF_SWORD = TFItems.ITEMS.register("steeleaf_sword", () -> new SteeleafSwordItem(TwilightItemTier.STEELEAF, defaultBuilder()));
        STEELEAF_SHOVEL = TFItems.ITEMS.register("steeleaf_shovel", () -> new SteeleafShovelItem(TwilightItemTier.STEELEAF, defaultBuilder()));
        STEELEAF_PICKAXE = TFItems.ITEMS.register("steeleaf_pickaxe", () -> new SteeleafPickItem(TwilightItemTier.STEELEAF, defaultBuilder()));
        STEELEAF_AXE = TFItems.ITEMS.register("steeleaf_axe", () -> new SteeleafAxeItem(TwilightItemTier.STEELEAF, defaultBuilder()));
        STEELEAF_HOE = TFItems.ITEMS.register("steeleaf_hoe", () -> new SteeleafHoeItem(TwilightItemTier.STEELEAF, defaultBuilder()));
        GOLDEN_MINOTAUR_AXE = TFItems.ITEMS.register("gold_minotaur_axe", () -> new MinotaurAxeItem((Tier)Tiers.GOLD, defaultBuilder().m_41497_(Rarity.COMMON)));
        DIAMOND_MINOTAUR_AXE = TFItems.ITEMS.register("diamond_minotaur_axe", () -> new MinotaurAxeItem((Tier)Tiers.DIAMOND, defaultBuilder().m_41497_(Rarity.UNCOMMON)));
        MAZEBREAKER_PICKAXE = TFItems.ITEMS.register("mazebreaker_pickaxe", () -> new MazebreakerPickItem((Tier)Tiers.DIAMOND, defaultBuilder().setNoRepair().m_41497_(Rarity.RARE)));
        TRANSFORMATION_POWDER = TFItems.ITEMS.register("transformation_powder", () -> new TransformPowderItem(defaultBuilder()));
        RAW_MEEF = TFItems.ITEMS.register("raw_meef", () -> new Item(defaultBuilder().m_41489_(TFItems.MEEF_RAW)));
        COOKED_MEEF = TFItems.ITEMS.register("cooked_meef", () -> new Item(defaultBuilder().m_41489_(TFItems.MEEF_COOKED)));
        MEEF_STROGANOFF = TFItems.ITEMS.register("meef_stroganoff", () -> new BowlFoodItem(defaultBuilder().m_41486_().m_41489_(TFItems.STROGANOFF).m_41487_(1)));
        MAZE_WAFER = TFItems.ITEMS.register("maze_wafer", () -> new Item(defaultBuilder().m_41489_(TFItems.WAFER)));
        ORE_MAGNET = TFItems.ITEMS.register("ore_magnet", () -> new OreMagnetItem(defaultBuilder().m_41503_(64)));
        CRUMBLE_HORN = TFItems.ITEMS.register("crumble_horn", () -> new CrumbleHornItem(defaultBuilder().m_41503_(1024).m_41497_(Rarity.RARE)));
        PEACOCK_FEATHER_FAN = TFItems.ITEMS.register("peacock_feather_fan", () -> new PeacockFanItem(defaultBuilder().m_41503_(1024).m_41497_(Rarity.RARE)));
        MOONWORM_QUEEN = TFItems.ITEMS.register("moonworm_queen", () -> new MoonwormQueenItem(defaultBuilder().setNoRepair().m_41503_(256).m_41497_(Rarity.RARE)));
        BRITTLE_FLASK = TFItems.ITEMS.register("brittle_potion_flask", () -> new BrittleFlaskItem(defaultBuilder().m_41487_(1)));
        GREATER_FLASK = TFItems.ITEMS.register("greater_potion_flask", () -> new GreaterFlaskItem(defaultBuilder().m_41497_(Rarity.UNCOMMON).m_41486_().m_41487_(1)));
        CHARM_OF_LIFE_1 = TFItems.ITEMS.register("charm_of_life_1", () -> new CuriosCharmItem(defaultBuilder().m_41497_(Rarity.UNCOMMON)));
        CHARM_OF_LIFE_2 = TFItems.ITEMS.register("charm_of_life_2", () -> new CuriosCharmItem(defaultBuilder().m_41497_(Rarity.UNCOMMON)));
        CHARM_OF_KEEPING_1 = TFItems.ITEMS.register("charm_of_keeping_1", () -> new CuriosCharmItem(defaultBuilder().m_41497_(Rarity.UNCOMMON)));
        CHARM_OF_KEEPING_2 = TFItems.ITEMS.register("charm_of_keeping_2", () -> new CuriosCharmItem(defaultBuilder().m_41497_(Rarity.UNCOMMON)));
        CHARM_OF_KEEPING_3 = TFItems.ITEMS.register("charm_of_keeping_3", () -> new CuriosCharmItem(defaultBuilder().m_41497_(Rarity.UNCOMMON)));
        TOWER_KEY = TFItems.ITEMS.register("tower_key", () -> new Item(defaultBuilder().m_41486_().m_41497_(Rarity.UNCOMMON)));
        BORER_ESSENCE = TFItems.ITEMS.register("borer_essence", () -> new Item(defaultBuilder()));
        CARMINITE = TFItems.ITEMS.register("carminite", () -> new Item(defaultBuilder()));
        EXPERIMENT_115 = TFItems.ITEMS.register("experiment_115", () -> new Experiment115Item((Block)TFBlocks.EXPERIMENT_115.get(), defaultBuilder().m_41489_(TFItems.E115)));
        ARMOR_SHARD = TFItems.ITEMS.register("armor_shard", () -> new Item(defaultBuilder()));
        ARMOR_SHARD_CLUSTER = TFItems.ITEMS.register("armor_shard_cluster", () -> new Item(defaultBuilder()));
        KNIGHTMETAL_INGOT = TFItems.ITEMS.register("knightmetal_ingot", () -> new Item(defaultBuilder()));
        KNIGHTMETAL_HELMET = TFItems.ITEMS.register("knightmetal_helmet", () -> new KnightmetalArmorItem((ArmorMaterial)TwilightArmorMaterial.ARMOR_KNIGHTLY, EquipmentSlot.HEAD, defaultBuilder()));
        KNIGHTMETAL_CHESTPLATE = TFItems.ITEMS.register("knightmetal_chestplate", () -> new KnightmetalArmorItem((ArmorMaterial)TwilightArmorMaterial.ARMOR_KNIGHTLY, EquipmentSlot.CHEST, defaultBuilder()));
        KNIGHTMETAL_LEGGINGS = TFItems.ITEMS.register("knightmetal_leggings", () -> new KnightmetalArmorItem((ArmorMaterial)TwilightArmorMaterial.ARMOR_KNIGHTLY, EquipmentSlot.LEGS, defaultBuilder()));
        KNIGHTMETAL_BOOTS = TFItems.ITEMS.register("knightmetal_boots", () -> new KnightmetalArmorItem((ArmorMaterial)TwilightArmorMaterial.ARMOR_KNIGHTLY, EquipmentSlot.FEET, defaultBuilder()));
        KNIGHTMETAL_SWORD = TFItems.ITEMS.register("knightmetal_sword", () -> new KnightmetalSwordItem(TwilightItemTier.KNIGHTMETAL, defaultBuilder()));
        KNIGHTMETAL_PICKAXE = TFItems.ITEMS.register("knightmetal_pickaxe", () -> new KnightmetalPickItem(TwilightItemTier.KNIGHTMETAL, defaultBuilder()));
        KNIGHTMETAL_AXE = TFItems.ITEMS.register("knightmetal_axe", () -> new KnightmetalAxeItem(TwilightItemTier.KNIGHTMETAL, defaultBuilder()));
        KNIGHTMETAL_RING = TFItems.ITEMS.register("knightmetal_ring", () -> new Item(defaultBuilder()));
        KNIGHTMETAL_SHIELD = TFItems.ITEMS.register("knightmetal_shield", () -> new KnightmetalShieldItem(defaultBuilder().m_41503_(1024)));
        BLOCK_AND_CHAIN = TFItems.ITEMS.register("block_and_chain", () -> new ChainBlockItem(defaultBuilder().m_41503_(99)));
        PHANTOM_HELMET = TFItems.ITEMS.register("phantom_helmet", () -> new PhantomArmorItem((ArmorMaterial)TwilightArmorMaterial.ARMOR_PHANTOM, EquipmentSlot.HEAD, defaultBuilder().m_41497_(Rarity.UNCOMMON)));
        PHANTOM_CHESTPLATE = TFItems.ITEMS.register("phantom_chestplate", () -> new PhantomArmorItem((ArmorMaterial)TwilightArmorMaterial.ARMOR_PHANTOM, EquipmentSlot.CHEST, defaultBuilder().m_41497_(Rarity.UNCOMMON)));
        ICE_BOMB = TFItems.ITEMS.register("ice_bomb", () -> new IceBombItem(defaultBuilder().m_41487_(16)));
        ARCTIC_FUR = TFItems.ITEMS.register("arctic_fur", () -> new Item(defaultBuilder()));
        ARCTIC_HELMET = TFItems.ITEMS.register("arctic_helmet", () -> new ArcticArmorItem((ArmorMaterial)TwilightArmorMaterial.ARMOR_ARCTIC, EquipmentSlot.HEAD, defaultBuilder()));
        ARCTIC_CHESTPLATE = TFItems.ITEMS.register("arctic_chestplate", () -> new ArcticArmorItem((ArmorMaterial)TwilightArmorMaterial.ARMOR_ARCTIC, EquipmentSlot.CHEST, defaultBuilder()));
        ARCTIC_LEGGINGS = TFItems.ITEMS.register("arctic_leggings", () -> new ArcticArmorItem((ArmorMaterial)TwilightArmorMaterial.ARMOR_ARCTIC, EquipmentSlot.LEGS, defaultBuilder()));
        ARCTIC_BOOTS = TFItems.ITEMS.register("arctic_boots", () -> new ArcticArmorItem((ArmorMaterial)TwilightArmorMaterial.ARMOR_ARCTIC, EquipmentSlot.FEET, defaultBuilder()));
        ALPHA_YETI_FUR = TFItems.ITEMS.register("alpha_yeti_fur", () -> new Item(defaultBuilder().m_41497_(Rarity.UNCOMMON)));
        YETI_HELMET = TFItems.ITEMS.register("yeti_helmet", () -> new YetiArmorItem((ArmorMaterial)TwilightArmorMaterial.ARMOR_YETI, EquipmentSlot.HEAD, defaultBuilder().m_41497_(Rarity.UNCOMMON)));
        YETI_CHESTPLATE = TFItems.ITEMS.register("yeti_chestplate", () -> new YetiArmorItem((ArmorMaterial)TwilightArmorMaterial.ARMOR_YETI, EquipmentSlot.CHEST, defaultBuilder().m_41497_(Rarity.UNCOMMON)));
        YETI_LEGGINGS = TFItems.ITEMS.register("yeti_leggings", () -> new YetiArmorItem((ArmorMaterial)TwilightArmorMaterial.ARMOR_YETI, EquipmentSlot.LEGS, defaultBuilder().m_41497_(Rarity.UNCOMMON)));
        YETI_BOOTS = TFItems.ITEMS.register("yeti_boots", () -> new YetiArmorItem((ArmorMaterial)TwilightArmorMaterial.ARMOR_YETI, EquipmentSlot.FEET, defaultBuilder().m_41497_(Rarity.UNCOMMON)));
        TRIPLE_BOW = TFItems.ITEMS.register("triple_bow", () -> new TripleBowItem(defaultBuilder().m_41497_(Rarity.UNCOMMON).m_41503_(384)));
        SEEKER_BOW = TFItems.ITEMS.register("seeker_bow", () -> new SeekerBowItem(defaultBuilder().m_41497_(Rarity.UNCOMMON).m_41503_(384)));
        ICE_BOW = TFItems.ITEMS.register("ice_bow", () -> new IceBowItem(defaultBuilder().m_41497_(Rarity.UNCOMMON).m_41503_(384)));
        ENDER_BOW = TFItems.ITEMS.register("ender_bow", () -> new EnderBowItem(defaultBuilder().m_41497_(Rarity.UNCOMMON).m_41503_(384)));
        ICE_SWORD = TFItems.ITEMS.register("ice_sword", () -> new IceSwordItem(TwilightItemTier.ICE, defaultBuilder()));
        GLASS_SWORD = TFItems.ITEMS.register("glass_sword", () -> new GlassSwordItem(TwilightItemTier.GLASS, defaultBuilder().setNoRepair().m_41497_(Rarity.RARE)));
        MAGIC_BEANS = TFItems.ITEMS.register("magic_beans", () -> new MagicBeansItem(defaultBuilder()));
        GIANT_PICKAXE = TFItems.ITEMS.register("giant_pickaxe", () -> new GiantPickItem(TwilightItemTier.GIANT, defaultBuilder()));
        GIANT_SWORD = TFItems.ITEMS.register("giant_sword", () -> new GiantSwordItem(TwilightItemTier.GIANT, defaultBuilder()));
        LAMP_OF_CINDERS = TFItems.ITEMS.register("lamp_of_cinders", () -> new LampOfCindersItem(defaultBuilder().m_41486_().m_41503_(1024).m_41497_(Rarity.UNCOMMON)));
        CUBE_TALISMAN = TFItems.ITEMS.register("cube_talisman", () -> new Item(defaultBuilder().m_41486_().m_41497_(Rarity.UNCOMMON)));
        CUBE_OF_ANNIHILATION = TFItems.ITEMS.register("cube_of_annihilation", () -> new CubeOfAnnihilationItem(unstackable().m_41486_().m_41497_(Rarity.UNCOMMON)));
        MOON_DIAL = TFItems.ITEMS.register("moon_dial", () -> new Item(defaultBuilder()));
        MUSIC_DISC_RADIANCE = TFItems.ITEMS.register("music_disc_radiance", () -> new RecordItem(15, () -> TFSounds.MUSIC_DISC_RADIANCE, defaultBuilder().m_41487_(1).m_41497_(Rarity.RARE)));
        MUSIC_DISC_STEPS = TFItems.ITEMS.register("music_disc_steps", () -> new RecordItem(15, () -> TFSounds.MUSIC_DISC_STEPS, defaultBuilder().m_41487_(1).m_41497_(Rarity.RARE)));
        MUSIC_DISC_SUPERSTITIOUS = TFItems.ITEMS.register("music_disc_superstitious", () -> new RecordItem(15, () -> TFSounds.MUSIC_DISC_SUPERSTITIOUS, defaultBuilder().m_41487_(1).m_41497_(Rarity.RARE)));
        MUSIC_DISC_HOME = TFItems.ITEMS.register("music_disc_home", () -> new RecordItem(15, () -> TFSounds.MUSIC_DISC_HOME, defaultBuilder().m_41487_(1).m_41497_(Rarity.RARE)));
        MUSIC_DISC_WAYFARER = TFItems.ITEMS.register("music_disc_wayfarer", () -> new RecordItem(15, () -> TFSounds.MUSIC_DISC_WAYFARER, defaultBuilder().m_41487_(1).m_41497_(Rarity.RARE)));
        MUSIC_DISC_FINDINGS = TFItems.ITEMS.register("music_disc_findings", () -> new RecordItem(15, () -> TFSounds.MUSIC_DISC_FINDINGS, defaultBuilder().m_41487_(1).m_41497_(Rarity.RARE)));
        MUSIC_DISC_MAKER = TFItems.ITEMS.register("music_disc_maker", () -> new RecordItem(15, () -> TFSounds.MUSIC_DISC_MAKER, defaultBuilder().m_41487_(1).m_41497_(Rarity.RARE)));
        MUSIC_DISC_THREAD = TFItems.ITEMS.register("music_disc_thread", () -> new RecordItem(15, () -> TFSounds.MUSIC_DISC_THREAD, defaultBuilder().m_41487_(1).m_41497_(Rarity.RARE)));
        MUSIC_DISC_MOTION = TFItems.ITEMS.register("music_disc_motion", () -> new RecordItem(15, () -> TFSounds.MUSIC_DISC_MOTION, defaultBuilder().m_41487_(1).m_41497_(Rarity.RARE)));
        NAGA_BANNER_PATTERN = TFItems.ITEMS.register("naga_banner_pattern", () -> new BannerPatternItem(BannerPattern.create("TF_NAGA", "tf_naga", "tfn", true), defaultBuilder().m_41487_(1).m_41497_(TwilightForestMod.getRarity())));
        LICH_BANNER_PATTERN = TFItems.ITEMS.register("lich_banner_pattern", () -> new BannerPatternItem(BannerPattern.create("TF_LICH", "tf_lich", "tfl", true), defaultBuilder().m_41487_(1).m_41497_(TwilightForestMod.getRarity())));
        MINOSHROOM_BANNER_PATTERN = TFItems.ITEMS.register("minoshroom_banner_pattern", () -> new BannerPatternItem(BannerPattern.create("TF_MINOSHROOM", "tf_minoshroom", "tfm", true), defaultBuilder().m_41487_(1).m_41497_(TwilightForestMod.getRarity())));
        HYDRA_BANNER_PATTERN = TFItems.ITEMS.register("hydra_banner_pattern", () -> new BannerPatternItem(BannerPattern.create("TF_HYDRA", "tf_hydra", "tfh", true), defaultBuilder().m_41487_(1).m_41497_(TwilightForestMod.getRarity())));
        KNIGHT_PHANTOM_BANNER_PATTERN = TFItems.ITEMS.register("knight_phantom_banner_pattern", () -> new BannerPatternItem(BannerPattern.create("TF_PHANTOMS", "tf_phantoms", "tfp", true), defaultBuilder().m_41487_(1).m_41497_(TwilightForestMod.getRarity())));
        UR_GHAST_BANNER_PATTERN = TFItems.ITEMS.register("ur_ghast_banner_pattern", () -> new BannerPatternItem(BannerPattern.create("TF_UR_GHAST", "tf_ur_ghast", "tfg", true), defaultBuilder().m_41487_(1).m_41497_(TwilightForestMod.getRarity())));
        ALPHA_YETI_BANNER_PATTERN = TFItems.ITEMS.register("alpha_yeti_banner_pattern", () -> new BannerPatternItem(BannerPattern.create("TF_ALPHA_YETI", "tf_alpha_yeti", "tfy", true), defaultBuilder().m_41487_(1).m_41497_(TwilightForestMod.getRarity())));
        SNOW_QUEEN_BANNER_PATTERN = TFItems.ITEMS.register("snow_queen_banner_pattern", () -> new BannerPatternItem(BannerPattern.create("TF_SNOW_QUEEN", "tf_snow_queen", "tfq", true), defaultBuilder().m_41487_(1).m_41497_(TwilightForestMod.getRarity())));
        QUEST_RAM_BANNER_PATTERN = TFItems.ITEMS.register("quest_ram_banner_pattern", () -> new BannerPatternItem(BannerPattern.create("TF_QUEST_RAM", "tf_quest_ram", "tfr", true), defaultBuilder().m_41487_(1).m_41497_(TwilightForestMod.getRarity())));
        TFItems.creativeTab = new CreativeModeTab() {
            public ItemStack m_6976_() {
                return new ItemStack((ItemLike)TFBlocks.TWILIGHT_PORTAL_MINIATURE_STRUCTURE.get());
            }
        };
    }
}
