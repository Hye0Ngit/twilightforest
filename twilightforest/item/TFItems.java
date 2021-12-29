// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.util.IItemProvider;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SoupItem;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import twilightforest.enums.TwilightArmorMaterial;
import net.minecraft.item.IItemTier;
import twilightforest.enums.TwilightItemTier;
import net.minecraft.item.Rarity;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.LivingEntity;
import javax.annotation.Nullable;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemModelsProperties;
import twilightforest.TwilightForestMod;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraft.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import java.util.UUID;
import net.minecraft.item.Food;

public class TFItems
{
    public static final Food EXPERIMENT_115;
    public static final Food HYDRA_CHOP;
    public static final Food MAZE_WAFER;
    public static final Food MEEF_COOKED;
    public static final Food MEEF_RAW;
    public static final Food MEEF_STROGANOFF;
    public static final Food VENISON_COOKED;
    public static final Food VENISON_RAW;
    public static final UUID GIANT_REACH_MODIFIER;
    public static final DeferredRegister<Item> ITEMS;
    public static final RegistryObject<Item> naga_scale;
    public static final RegistryObject<Item> naga_chestplate;
    public static final RegistryObject<Item> naga_leggings;
    public static final RegistryObject<Item> twilight_scepter;
    public static final RegistryObject<Item> lifedrain_scepter;
    public static final RegistryObject<Item> zombie_scepter;
    public static final RegistryObject<Item> shield_scepter;
    public static final RegistryObject<Item> ore_meter;
    public static final RegistryObject<Item> magic_map;
    public static final RegistryObject<Item> maze_map;
    public static final RegistryObject<Item> ore_map;
    public static final RegistryObject<Item> raven_feather;
    public static final RegistryObject<Item> magic_map_focus;
    public static final RegistryObject<Item> maze_map_focus;
    public static final RegistryObject<Item> liveroot;
    public static final RegistryObject<Item> ironwood_raw;
    public static final RegistryObject<Item> ironwood_ingot;
    public static final RegistryObject<Item> ironwood_helmet;
    public static final RegistryObject<Item> ironwood_chestplate;
    public static final RegistryObject<Item> ironwood_leggings;
    public static final RegistryObject<Item> ironwood_boots;
    public static final RegistryObject<Item> ironwood_sword;
    public static final RegistryObject<Item> ironwood_shovel;
    public static final RegistryObject<Item> ironwood_pickaxe;
    public static final RegistryObject<Item> ironwood_axe;
    public static final RegistryObject<Item> ironwood_hoe;
    public static final RegistryObject<Item> torchberries;
    public static final RegistryObject<Item> raw_venison;
    public static final RegistryObject<Item> cooked_venison;
    public static final RegistryObject<Item> hydra_chop;
    public static final RegistryObject<Item> fiery_blood;
    public static final RegistryObject<Item> fiery_tears;
    public static final RegistryObject<Item> fiery_ingot;
    public static final RegistryObject<Item> fiery_helmet;
    public static final RegistryObject<Item> fiery_chestplate;
    public static final RegistryObject<Item> fiery_leggings;
    public static final RegistryObject<Item> fiery_boots;
    public static final RegistryObject<Item> fiery_sword;
    public static final RegistryObject<Item> fiery_pickaxe;
    public static final RegistryObject<Item> steeleaf_ingot;
    public static final RegistryObject<Item> steeleaf_helmet;
    public static final RegistryObject<Item> steeleaf_chestplate;
    public static final RegistryObject<Item> steeleaf_leggings;
    public static final RegistryObject<Item> steeleaf_boots;
    public static final RegistryObject<Item> steeleaf_sword;
    public static final RegistryObject<Item> steeleaf_shovel;
    public static final RegistryObject<Item> steeleaf_pickaxe;
    public static final RegistryObject<Item> steeleaf_axe;
    public static final RegistryObject<Item> steeleaf_hoe;
    public static final RegistryObject<Item> minotaur_axe_gold;
    public static final RegistryObject<Item> minotaur_axe;
    public static final RegistryObject<Item> mazebreaker_pickaxe;
    public static final RegistryObject<Item> transformation_powder;
    public static final RegistryObject<Item> raw_meef;
    public static final RegistryObject<Item> cooked_meef;
    public static final RegistryObject<Item> meef_stroganoff;
    public static final RegistryObject<Item> maze_wafer;
    public static final RegistryObject<Item> magic_map_empty;
    public static final RegistryObject<Item> maze_map_empty;
    public static final RegistryObject<Item> ore_map_empty;
    public static final RegistryObject<Item> ore_magnet;
    public static final RegistryObject<Item> crumble_horn;
    public static final RegistryObject<Item> peacock_fan;
    public static final RegistryObject<Item> moonworm_queen;
    public static final RegistryObject<Item> charm_of_life_1;
    public static final RegistryObject<Item> charm_of_life_2;
    public static final RegistryObject<Item> charm_of_keeping_1;
    public static final RegistryObject<Item> charm_of_keeping_2;
    public static final RegistryObject<Item> charm_of_keeping_3;
    public static final RegistryObject<Item> tower_key;
    public static final RegistryObject<Item> borer_essence;
    public static final RegistryObject<Item> carminite;
    public static final RegistryObject<Item> experiment_115;
    public static final RegistryObject<Item> armor_shard;
    public static final RegistryObject<Item> knightmetal_ingot;
    public static final RegistryObject<Item> armor_shard_cluster;
    public static final RegistryObject<Item> knightmetal_helmet;
    public static final RegistryObject<Item> knightmetal_chestplate;
    public static final RegistryObject<Item> knightmetal_leggings;
    public static final RegistryObject<Item> knightmetal_boots;
    public static final RegistryObject<Item> knightmetal_sword;
    public static final RegistryObject<Item> knightmetal_pickaxe;
    public static final RegistryObject<Item> knightmetal_axe;
    public static final RegistryObject<Item> knightmetal_shield;
    public static final RegistryObject<Item> phantom_helmet;
    public static final RegistryObject<Item> phantom_chestplate;
    public static final RegistryObject<Item> lamp_of_cinders;
    public static final RegistryObject<Item> alpha_fur;
    public static final RegistryObject<Item> yeti_helmet;
    public static final RegistryObject<Item> yeti_chestplate;
    public static final RegistryObject<Item> yeti_leggings;
    public static final RegistryObject<Item> yeti_boots;
    public static final RegistryObject<Item> ice_bomb;
    public static final RegistryObject<Item> arctic_fur;
    public static final RegistryObject<Item> arctic_helmet;
    public static final RegistryObject<Item> arctic_chestplate;
    public static final RegistryObject<Item> arctic_leggings;
    public static final RegistryObject<Item> arctic_boots;
    public static final RegistryObject<Item> magic_beans;
    public static final RegistryObject<Item> giant_pickaxe;
    public static final RegistryObject<Item> giant_sword;
    public static final RegistryObject<Item> triple_bow;
    public static final RegistryObject<Item> seeker_bow;
    public static final RegistryObject<Item> ice_bow;
    public static final RegistryObject<Item> ender_bow;
    public static final RegistryObject<Item> ice_sword;
    public static final RegistryObject<Item> glass_sword;
    public static final RegistryObject<Item> knightmetal_ring;
    public static final RegistryObject<Item> block_and_chain;
    public static final RegistryObject<Item> cube_talisman;
    public static final RegistryObject<Item> cube_of_annihilation;
    public static final RegistryObject<Item> moon_dial;
    public static ItemGroup creativeTab;
    
    public static Item.Properties defaultBuilder() {
        return new Item.Properties().func_200916_a(TFItems.creativeTab);
    }
    
    public static Item.Properties unstackable() {
        return defaultBuilder().func_200917_a(1);
    }
    
    @OnlyIn(Dist.CLIENT)
    public static void addItemModelProperties() {
        ItemModelsProperties.func_239418_a_((Item)TFItems.cube_of_annihilation.get(), TwilightForestMod.prefix("thrown"), (stack, world, entity) -> (CubeOfAnnihilationItem.getThrownUuid(stack) != null) ? 1.0f : 0.0f);
        ItemModelsProperties.func_239418_a_((Item)TFItems.knightmetal_shield.get(), new ResourceLocation("blocking"), (stack, world, entity) -> (entity != null && entity.func_184587_cr() && entity.func_184607_cu() == stack) ? 1.0f : 0.0f);
        ItemModelsProperties.func_239418_a_((Item)TFItems.moon_dial.get(), new ResourceLocation("phase"), (IItemPropertyGetter)new IItemPropertyGetter() {
            @OnlyIn(Dist.CLIENT)
            double rotation;
            @OnlyIn(Dist.CLIENT)
            double rota;
            @OnlyIn(Dist.CLIENT)
            long lastUpdateTick;
            
            public float call(final ItemStack stack, @Nullable ClientWorld world, @Nullable final LivingEntity entityBase) {
                final boolean flag = entityBase != null;
                final Entity entity = (Entity)(flag ? entityBase : stack.func_82836_z());
                if (world == null && entity != null) {
                    world = (ClientWorld)entity.field_70170_p;
                }
                return (world == null) ? 0.0f : ((float)(world.func_230315_m_().func_236043_f_() ? MathHelper.func_226164_h_(world.func_242414_af() / 8.0f) : this.wobble((World)world, Math.random())));
            }
            
            @OnlyIn(Dist.CLIENT)
            private double wobble(final World world, final double rotation) {
                if (world.func_82737_E() != this.lastUpdateTick) {
                    this.lastUpdateTick = world.func_82737_E();
                    double delta = rotation - this.rotation;
                    delta = MathHelper.func_191273_b(delta + 0.5, 1.0) - 0.5;
                    this.rota += delta * 0.1;
                    this.rota *= 0.9;
                    this.rotation = MathHelper.func_191273_b(this.rotation + this.rota, 1.0);
                }
                return this.rotation;
            }
        });
        ItemModelsProperties.func_239418_a_((Item)TFItems.moonworm_queen.get(), TwilightForestMod.prefix("alt"), (stack, world, entity) -> {
            if (entity != null && entity.func_184607_cu() == stack) {
                final int useTime = stack.func_77988_m() - entity.func_184605_cv();
                if (useTime >= 12 && (useTime >>> 1) % 2 == 0) {
                    return 1.0f;
                }
            }
            return 0.0f;
        });
        ItemModelsProperties.func_239418_a_((Item)TFItems.ender_bow.get(), new ResourceLocation("pull"), (stack, world, entity) -> {
            if (entity == null) {
                return 0.0f;
            }
            return (entity.func_184607_cu() != stack) ? 0.0f : ((stack.func_77988_m() - entity.func_184605_cv()) / 20.0f);
        });
        ItemModelsProperties.func_239418_a_((Item)TFItems.ender_bow.get(), new ResourceLocation("pulling"), (stack, world, entity) -> (entity != null && entity.func_184587_cr() && entity.func_184607_cu() == stack) ? 1.0f : 0.0f);
        ItemModelsProperties.func_239418_a_((Item)TFItems.ice_bow.get(), new ResourceLocation("pull"), (stack, world, entity) -> {
            if (entity == null) {
                return 0.0f;
            }
            return (entity.func_184607_cu() != stack) ? 0.0f : ((stack.func_77988_m() - entity.func_184605_cv()) / 20.0f);
        });
        ItemModelsProperties.func_239418_a_((Item)TFItems.ice_bow.get(), new ResourceLocation("pulling"), (stack, world, entity) -> (entity != null && entity.func_184587_cr() && entity.func_184607_cu() == stack) ? 1.0f : 0.0f);
        ItemModelsProperties.func_239418_a_((Item)TFItems.seeker_bow.get(), new ResourceLocation("pull"), (stack, world, entity) -> {
            if (entity == null) {
                return 0.0f;
            }
            return (entity.func_184607_cu() != stack) ? 0.0f : ((stack.func_77988_m() - entity.func_184605_cv()) / 20.0f);
        });
        ItemModelsProperties.func_239418_a_((Item)TFItems.seeker_bow.get(), new ResourceLocation("pulling"), (stack, world, entity) -> (entity != null && entity.func_184587_cr() && entity.func_184607_cu() == stack) ? 1.0f : 0.0f);
        ItemModelsProperties.func_239418_a_((Item)TFItems.triple_bow.get(), new ResourceLocation("pull"), (stack, world, entity) -> {
            if (entity == null) {
                return 0.0f;
            }
            return (entity.func_184607_cu() != stack) ? 0.0f : ((stack.func_77988_m() - entity.func_184605_cv()) / 20.0f);
        });
        ItemModelsProperties.func_239418_a_((Item)TFItems.triple_bow.get(), new ResourceLocation("pulling"), (stack, world, entity) -> (entity != null && entity.func_184587_cr() && entity.func_184607_cu() == stack) ? 1.0f : 0.0f);
        ItemModelsProperties.func_239418_a_((Item)TFItems.ore_magnet.get(), new ResourceLocation("pull"), (stack, world, entity) -> {
            if (entity == null) {
                return 0.0f;
            }
            final ItemStack itemstack = entity.func_184607_cu();
            return itemstack.func_190926_b() ? 0.0f : ((stack.func_77988_m() - entity.func_184605_cv()) / 20.0f);
        });
        ItemModelsProperties.func_239418_a_((Item)TFItems.ore_magnet.get(), new ResourceLocation("pulling"), (stack, world, entity) -> (entity != null && entity.func_184587_cr() && entity.func_184607_cu() == stack) ? 1.0f : 0.0f);
        ItemModelsProperties.func_239418_a_((Item)TFItems.block_and_chain.get(), TwilightForestMod.prefix("thrown"), (stack, world, entity) -> (ChainBlockItem.getThrownUuid(stack) != null) ? 1.0f : 0.0f);
        ItemModelsProperties.func_239418_a_((Item)TFItems.experiment_115.get(), Experiment115Item.THINK, (stack, world, entity) -> (stack.func_77942_o() && stack.func_77978_p().func_74764_b("think")) ? 1.0f : 0.0f);
        ItemModelsProperties.func_239418_a_((Item)TFItems.experiment_115.get(), Experiment115Item.FULL, (stack, world, entity) -> (stack.func_77942_o() && stack.func_77978_p().func_74764_b("full")) ? 1.0f : 0.0f);
    }
    
    static {
        EXPERIMENT_115 = new Food.Builder().func_221456_a(4).func_221454_a(0.3f).func_221453_d();
        HYDRA_CHOP = new Food.Builder().func_221456_a(18).func_221454_a(2.0f).effect(() -> new EffectInstance(Effects.field_76428_l, 100, 0), 1.0f).func_221453_d();
        MAZE_WAFER = new Food.Builder().func_221456_a(4).func_221454_a(0.6f).func_221453_d();
        MEEF_COOKED = new Food.Builder().func_221456_a(6).func_221454_a(0.6f).func_221451_a().func_221453_d();
        MEEF_RAW = new Food.Builder().func_221456_a(2).func_221454_a(0.3f).func_221451_a().func_221453_d();
        MEEF_STROGANOFF = new Food.Builder().func_221456_a(8).func_221454_a(0.6f).func_221453_d();
        VENISON_COOKED = new Food.Builder().func_221456_a(8).func_221454_a(0.8f).func_221451_a().func_221453_d();
        VENISON_RAW = new Food.Builder().func_221456_a(3).func_221454_a(0.3f).func_221451_a().func_221453_d();
        GIANT_REACH_MODIFIER = UUID.fromString("7f10172d-de69-49d7-81bd-9594286a6827");
        ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "twilightforest");
        naga_scale = TFItems.ITEMS.register("naga_scale", () -> new Item(defaultBuilder().func_208103_a(Rarity.UNCOMMON)));
        naga_chestplate = TFItems.ITEMS.register("naga_chestplate", () -> new NagaArmorItem((IArmorMaterial)TwilightArmorMaterial.ARMOR_NAGA, EquipmentSlotType.CHEST, defaultBuilder().func_208103_a(Rarity.UNCOMMON)));
        naga_leggings = TFItems.ITEMS.register("naga_leggings", () -> new NagaArmorItem((IArmorMaterial)TwilightArmorMaterial.ARMOR_NAGA, EquipmentSlotType.LEGS, defaultBuilder().func_208103_a(Rarity.UNCOMMON)));
        twilight_scepter = TFItems.ITEMS.register("twilight_scepter", () -> new TwilightWandItem(defaultBuilder().func_200918_c(99).func_208103_a(Rarity.UNCOMMON)));
        lifedrain_scepter = TFItems.ITEMS.register("lifedrain_scepter", () -> new LifedrainScepterItem(defaultBuilder().func_200918_c(99).func_208103_a(Rarity.UNCOMMON)));
        zombie_scepter = TFItems.ITEMS.register("zombie_scepter", () -> new ZombieWandItem(defaultBuilder().func_200918_c(9).func_208103_a(Rarity.UNCOMMON)));
        shield_scepter = TFItems.ITEMS.register("shield_scepter", () -> new FortificationWandItem(defaultBuilder().func_200918_c(9).func_208103_a(Rarity.UNCOMMON)));
        ore_meter = TFItems.ITEMS.register("ore_meter", () -> new OreMeterItem(defaultBuilder()));
        magic_map = TFItems.ITEMS.register("magic_map", () -> new MagicMapItem(unstackable()));
        maze_map = TFItems.ITEMS.register("maze_map", () -> new MazeMapItem(false, unstackable()));
        ore_map = TFItems.ITEMS.register("ore_map", () -> new MazeMapItem(true, unstackable().func_208103_a(Rarity.UNCOMMON)));
        raven_feather = TFItems.ITEMS.register("raven_feather", () -> new Item(defaultBuilder()));
        magic_map_focus = TFItems.ITEMS.register("magic_map_focus", () -> new Item(defaultBuilder()));
        maze_map_focus = TFItems.ITEMS.register("maze_map_focus", () -> new Item(defaultBuilder()));
        liveroot = TFItems.ITEMS.register("liveroot", () -> new Item(defaultBuilder()));
        ironwood_raw = TFItems.ITEMS.register("ironwood_raw", () -> new Item(defaultBuilder()));
        ironwood_ingot = TFItems.ITEMS.register("ironwood_ingot", () -> new Item(defaultBuilder()));
        ironwood_helmet = TFItems.ITEMS.register("ironwood_helmet", () -> new IronwoodArmorItem((IArmorMaterial)TwilightArmorMaterial.ARMOR_IRONWOOD, EquipmentSlotType.HEAD, defaultBuilder()));
        ironwood_chestplate = TFItems.ITEMS.register("ironwood_chestplate", () -> new IronwoodArmorItem((IArmorMaterial)TwilightArmorMaterial.ARMOR_IRONWOOD, EquipmentSlotType.CHEST, defaultBuilder()));
        ironwood_leggings = TFItems.ITEMS.register("ironwood_leggings", () -> new IronwoodArmorItem((IArmorMaterial)TwilightArmorMaterial.ARMOR_IRONWOOD, EquipmentSlotType.LEGS, defaultBuilder()));
        ironwood_boots = TFItems.ITEMS.register("ironwood_boots", () -> new IronwoodArmorItem((IArmorMaterial)TwilightArmorMaterial.ARMOR_IRONWOOD, EquipmentSlotType.FEET, defaultBuilder()));
        ironwood_sword = TFItems.ITEMS.register("ironwood_sword", () -> new IronwoodSwordItem((IItemTier)TwilightItemTier.TOOL_IRONWOOD, defaultBuilder()));
        ironwood_shovel = TFItems.ITEMS.register("ironwood_shovel", () -> new IronwoodShovelItem((IItemTier)TwilightItemTier.TOOL_IRONWOOD, defaultBuilder()));
        ironwood_pickaxe = TFItems.ITEMS.register("ironwood_pickaxe", () -> new IronwoodPickItem((IItemTier)TwilightItemTier.TOOL_IRONWOOD, defaultBuilder()));
        ironwood_axe = TFItems.ITEMS.register("ironwood_axe", () -> new IronwoodAxeItem((IItemTier)TwilightItemTier.TOOL_IRONWOOD, defaultBuilder()));
        ironwood_hoe = TFItems.ITEMS.register("ironwood_hoe", () -> new IronwoodHoeItem((IItemTier)TwilightItemTier.TOOL_IRONWOOD, defaultBuilder()));
        torchberries = TFItems.ITEMS.register("torchberries", () -> new Item(defaultBuilder()));
        raw_venison = TFItems.ITEMS.register("raw_venison", () -> new Item(defaultBuilder().func_221540_a(TFItems.VENISON_RAW)));
        cooked_venison = TFItems.ITEMS.register("cooked_venison", () -> new Item(defaultBuilder().func_221540_a(TFItems.VENISON_COOKED)));
        hydra_chop = TFItems.ITEMS.register("hydra_chop", () -> new HydraChopItem(defaultBuilder().func_234689_a_().func_221540_a(TFItems.HYDRA_CHOP).func_208103_a(Rarity.UNCOMMON)));
        fiery_blood = TFItems.ITEMS.register("fiery_blood", () -> new Item(defaultBuilder().func_208103_a(Rarity.UNCOMMON)));
        fiery_tears = TFItems.ITEMS.register("fiery_tears", () -> new Item(defaultBuilder().func_208103_a(Rarity.UNCOMMON)));
        fiery_ingot = TFItems.ITEMS.register("fiery_ingot", () -> new Item(defaultBuilder().func_234689_a_().func_208103_a(Rarity.UNCOMMON)));
        fiery_helmet = TFItems.ITEMS.register("fiery_helmet", () -> new FieryArmorItem((IArmorMaterial)TwilightArmorMaterial.ARMOR_FIERY, EquipmentSlotType.HEAD, defaultBuilder().func_234689_a_().func_208103_a(Rarity.UNCOMMON)));
        fiery_chestplate = TFItems.ITEMS.register("fiery_chestplate", () -> new FieryArmorItem((IArmorMaterial)TwilightArmorMaterial.ARMOR_FIERY, EquipmentSlotType.CHEST, defaultBuilder().func_234689_a_().func_208103_a(Rarity.UNCOMMON)));
        fiery_leggings = TFItems.ITEMS.register("fiery_leggings", () -> new FieryArmorItem((IArmorMaterial)TwilightArmorMaterial.ARMOR_FIERY, EquipmentSlotType.LEGS, defaultBuilder().func_234689_a_().func_208103_a(Rarity.UNCOMMON)));
        fiery_boots = TFItems.ITEMS.register("fiery_boots", () -> new FieryArmorItem((IArmorMaterial)TwilightArmorMaterial.ARMOR_FIERY, EquipmentSlotType.FEET, defaultBuilder().func_234689_a_().func_208103_a(Rarity.UNCOMMON)));
        fiery_sword = TFItems.ITEMS.register("fiery_sword", () -> new FierySwordItem((IItemTier)TwilightItemTier.TOOL_FIERY, defaultBuilder().func_234689_a_().func_208103_a(Rarity.UNCOMMON)));
        fiery_pickaxe = TFItems.ITEMS.register("fiery_pickaxe", () -> new FieryPickItem((IItemTier)TwilightItemTier.TOOL_FIERY, defaultBuilder().func_234689_a_().func_208103_a(Rarity.UNCOMMON)));
        steeleaf_ingot = TFItems.ITEMS.register("steeleaf_ingot", () -> new Item(defaultBuilder()));
        steeleaf_helmet = TFItems.ITEMS.register("steeleaf_helmet", () -> new SteeleafArmorItem((IArmorMaterial)TwilightArmorMaterial.ARMOR_STEELEAF, EquipmentSlotType.HEAD, defaultBuilder()));
        steeleaf_chestplate = TFItems.ITEMS.register("steeleaf_chestplate", () -> new SteeleafArmorItem((IArmorMaterial)TwilightArmorMaterial.ARMOR_STEELEAF, EquipmentSlotType.CHEST, defaultBuilder()));
        steeleaf_leggings = TFItems.ITEMS.register("steeleaf_leggings", () -> new SteeleafArmorItem((IArmorMaterial)TwilightArmorMaterial.ARMOR_STEELEAF, EquipmentSlotType.LEGS, defaultBuilder()));
        steeleaf_boots = TFItems.ITEMS.register("steeleaf_boots", () -> new SteeleafArmorItem((IArmorMaterial)TwilightArmorMaterial.ARMOR_STEELEAF, EquipmentSlotType.FEET, defaultBuilder()));
        steeleaf_sword = TFItems.ITEMS.register("steeleaf_sword", () -> new SteeleafSwordItem((IItemTier)TwilightItemTier.TOOL_STEELEAF, defaultBuilder()));
        steeleaf_shovel = TFItems.ITEMS.register("steeleaf_shovel", () -> new SteeleafShovelItem((IItemTier)TwilightItemTier.TOOL_STEELEAF, defaultBuilder()));
        steeleaf_pickaxe = TFItems.ITEMS.register("steeleaf_pickaxe", () -> new SteeleafPickItem((IItemTier)TwilightItemTier.TOOL_STEELEAF, defaultBuilder()));
        steeleaf_axe = TFItems.ITEMS.register("steeleaf_axe", () -> new SteeleafAxeItem((IItemTier)TwilightItemTier.TOOL_STEELEAF, defaultBuilder()));
        steeleaf_hoe = TFItems.ITEMS.register("steeleaf_hoe", () -> new SteeleafHoeItem((IItemTier)TwilightItemTier.TOOL_STEELEAF, defaultBuilder()));
        minotaur_axe_gold = TFItems.ITEMS.register("minotaur_axe_gold", () -> new MinotaurAxeItem((IItemTier)ItemTier.GOLD, defaultBuilder().func_208103_a(Rarity.COMMON)));
        minotaur_axe = TFItems.ITEMS.register("minotaur_axe", () -> new MinotaurAxeItem((IItemTier)ItemTier.DIAMOND, defaultBuilder().func_208103_a(Rarity.UNCOMMON)));
        mazebreaker_pickaxe = TFItems.ITEMS.register("mazebreaker_pickaxe", () -> new MazebreakerPickItem((IItemTier)ItemTier.DIAMOND, defaultBuilder().setNoRepair().func_208103_a(Rarity.RARE)));
        transformation_powder = TFItems.ITEMS.register("transformation_powder", () -> new TransformPowderItem(defaultBuilder()));
        raw_meef = TFItems.ITEMS.register("raw_meef", () -> new Item(defaultBuilder().func_221540_a(TFItems.MEEF_RAW)));
        cooked_meef = TFItems.ITEMS.register("cooked_meef", () -> new Item(defaultBuilder().func_221540_a(TFItems.MEEF_COOKED)));
        meef_stroganoff = TFItems.ITEMS.register("meef_stroganoff", () -> new SoupItem(defaultBuilder().func_221540_a(TFItems.MEEF_STROGANOFF).func_200917_a(1)));
        maze_wafer = TFItems.ITEMS.register("maze_wafer", () -> new Item(defaultBuilder().func_221540_a(TFItems.MAZE_WAFER)));
        magic_map_empty = TFItems.ITEMS.register("magic_map_empty", () -> new EmptyMagicMapItem(defaultBuilder()));
        maze_map_empty = TFItems.ITEMS.register("maze_map_empty", () -> new EmptyMazeMapItem(false, defaultBuilder()));
        ore_map_empty = TFItems.ITEMS.register("ore_map_empty", () -> new EmptyMazeMapItem(true, defaultBuilder()));
        ore_magnet = TFItems.ITEMS.register("ore_magnet", () -> new OreMagnetItem(defaultBuilder().func_200918_c(12)));
        crumble_horn = TFItems.ITEMS.register("crumble_horn", () -> new CrumbleHornItem(defaultBuilder().func_200918_c(1024).func_208103_a(Rarity.RARE)));
        peacock_fan = TFItems.ITEMS.register("peacock_fan", () -> new PeacockFanItem(defaultBuilder().func_200918_c(1024).func_208103_a(Rarity.RARE)));
        moonworm_queen = TFItems.ITEMS.register("moonworm_queen", () -> new MoonwormQueenItem(defaultBuilder().setNoRepair().func_200918_c(256).func_208103_a(Rarity.RARE)));
        charm_of_life_1 = TFItems.ITEMS.register("charm_of_life_1", () -> new CuriosCharmItem(defaultBuilder().func_208103_a(Rarity.UNCOMMON)));
        charm_of_life_2 = TFItems.ITEMS.register("charm_of_life_2", () -> new CuriosCharmItem(defaultBuilder().func_208103_a(Rarity.UNCOMMON)));
        charm_of_keeping_1 = TFItems.ITEMS.register("charm_of_keeping_1", () -> new CuriosCharmItem(defaultBuilder().func_208103_a(Rarity.UNCOMMON)));
        charm_of_keeping_2 = TFItems.ITEMS.register("charm_of_keeping_2", () -> new CuriosCharmItem(defaultBuilder().func_208103_a(Rarity.UNCOMMON)));
        charm_of_keeping_3 = TFItems.ITEMS.register("charm_of_keeping_3", () -> new CuriosCharmItem(defaultBuilder().func_208103_a(Rarity.UNCOMMON)));
        tower_key = TFItems.ITEMS.register("tower_key", () -> new Item(defaultBuilder().func_234689_a_().func_208103_a(Rarity.UNCOMMON)));
        borer_essence = TFItems.ITEMS.register("borer_essence", () -> new Item(defaultBuilder()));
        carminite = TFItems.ITEMS.register("carminite", () -> new Item(defaultBuilder()));
        experiment_115 = TFItems.ITEMS.register("experiment_115", () -> new Experiment115Item((Block)TFBlocks.experiment_115.get(), defaultBuilder().func_221540_a(TFItems.EXPERIMENT_115)));
        armor_shard = TFItems.ITEMS.register("armor_shard", () -> new Item(defaultBuilder()));
        knightmetal_ingot = TFItems.ITEMS.register("knightmetal_ingot", () -> new Item(defaultBuilder()));
        armor_shard_cluster = TFItems.ITEMS.register("armor_shard_cluster", () -> new Item(defaultBuilder()));
        knightmetal_helmet = TFItems.ITEMS.register("knightmetal_helmet", () -> new KnightmetalArmorItem((IArmorMaterial)TwilightArmorMaterial.ARMOR_KNIGHTLY, EquipmentSlotType.HEAD, defaultBuilder()));
        knightmetal_chestplate = TFItems.ITEMS.register("knightmetal_chestplate", () -> new KnightmetalArmorItem((IArmorMaterial)TwilightArmorMaterial.ARMOR_KNIGHTLY, EquipmentSlotType.CHEST, defaultBuilder()));
        knightmetal_leggings = TFItems.ITEMS.register("knightmetal_leggings", () -> new KnightmetalArmorItem((IArmorMaterial)TwilightArmorMaterial.ARMOR_KNIGHTLY, EquipmentSlotType.LEGS, defaultBuilder()));
        knightmetal_boots = TFItems.ITEMS.register("knightmetal_boots", () -> new KnightmetalArmorItem((IArmorMaterial)TwilightArmorMaterial.ARMOR_KNIGHTLY, EquipmentSlotType.FEET, defaultBuilder()));
        knightmetal_sword = TFItems.ITEMS.register("knightmetal_sword", () -> new KnightmetalSwordItem((IItemTier)TwilightItemTier.TOOL_KNIGHTLY, defaultBuilder()));
        knightmetal_pickaxe = TFItems.ITEMS.register("knightmetal_pickaxe", () -> new KnightmetalPickItem((IItemTier)TwilightItemTier.TOOL_KNIGHTLY, defaultBuilder()));
        knightmetal_axe = TFItems.ITEMS.register("knightmetal_axe", () -> new KnightmetalAxeItem((IItemTier)TwilightItemTier.TOOL_KNIGHTLY, defaultBuilder()));
        knightmetal_shield = TFItems.ITEMS.register("knightmetal_shield", () -> new KnightmetalShieldItem(defaultBuilder().func_200918_c(1024)));
        phantom_helmet = TFItems.ITEMS.register("phantom_helmet", () -> new PhantomArmorItem((IArmorMaterial)TwilightArmorMaterial.ARMOR_PHANTOM, EquipmentSlotType.HEAD, defaultBuilder().func_208103_a(Rarity.UNCOMMON)));
        phantom_chestplate = TFItems.ITEMS.register("phantom_chestplate", () -> new PhantomArmorItem((IArmorMaterial)TwilightArmorMaterial.ARMOR_PHANTOM, EquipmentSlotType.CHEST, defaultBuilder().func_208103_a(Rarity.UNCOMMON)));
        lamp_of_cinders = TFItems.ITEMS.register("lamp_of_cinders", () -> new LampOfCindersItem(defaultBuilder().func_234689_a_().func_200918_c(1024).func_208103_a(Rarity.UNCOMMON)));
        alpha_fur = TFItems.ITEMS.register("alpha_fur", () -> new Item(defaultBuilder().func_208103_a(Rarity.UNCOMMON)));
        yeti_helmet = TFItems.ITEMS.register("yeti_helmet", () -> new YetiArmorItem((IArmorMaterial)TwilightArmorMaterial.ARMOR_YETI, EquipmentSlotType.HEAD, defaultBuilder().func_208103_a(Rarity.UNCOMMON)));
        yeti_chestplate = TFItems.ITEMS.register("yeti_chestplate", () -> new YetiArmorItem((IArmorMaterial)TwilightArmorMaterial.ARMOR_YETI, EquipmentSlotType.CHEST, defaultBuilder().func_208103_a(Rarity.UNCOMMON)));
        yeti_leggings = TFItems.ITEMS.register("yeti_leggings", () -> new YetiArmorItem((IArmorMaterial)TwilightArmorMaterial.ARMOR_YETI, EquipmentSlotType.LEGS, defaultBuilder().func_208103_a(Rarity.UNCOMMON)));
        yeti_boots = TFItems.ITEMS.register("yeti_boots", () -> new YetiArmorItem((IArmorMaterial)TwilightArmorMaterial.ARMOR_YETI, EquipmentSlotType.FEET, defaultBuilder().func_208103_a(Rarity.UNCOMMON)));
        ice_bomb = TFItems.ITEMS.register("ice_bomb", () -> new IceBombItem(defaultBuilder().func_200917_a(16)));
        arctic_fur = TFItems.ITEMS.register("arctic_fur", () -> new Item(defaultBuilder()));
        arctic_helmet = TFItems.ITEMS.register("arctic_helmet", () -> new ArcticArmorItem((IArmorMaterial)TwilightArmorMaterial.ARMOR_ARCTIC, EquipmentSlotType.HEAD, defaultBuilder()));
        arctic_chestplate = TFItems.ITEMS.register("arctic_chestplate", () -> new ArcticArmorItem((IArmorMaterial)TwilightArmorMaterial.ARMOR_ARCTIC, EquipmentSlotType.CHEST, defaultBuilder()));
        arctic_leggings = TFItems.ITEMS.register("arctic_leggings", () -> new ArcticArmorItem((IArmorMaterial)TwilightArmorMaterial.ARMOR_ARCTIC, EquipmentSlotType.LEGS, defaultBuilder()));
        arctic_boots = TFItems.ITEMS.register("arctic_boots", () -> new ArcticArmorItem((IArmorMaterial)TwilightArmorMaterial.ARMOR_ARCTIC, EquipmentSlotType.FEET, defaultBuilder()));
        magic_beans = TFItems.ITEMS.register("magic_beans", () -> new MagicBeansItem(defaultBuilder()));
        giant_pickaxe = TFItems.ITEMS.register("giant_pickaxe", () -> new GiantPickItem((IItemTier)TwilightItemTier.TOOL_GIANT, defaultBuilder()));
        giant_sword = TFItems.ITEMS.register("giant_sword", () -> new GiantSwordItem((IItemTier)TwilightItemTier.TOOL_GIANT, defaultBuilder()));
        triple_bow = TFItems.ITEMS.register("triple_bow", () -> new TripleBowItem(defaultBuilder().func_208103_a(Rarity.UNCOMMON).func_200918_c(384)));
        seeker_bow = TFItems.ITEMS.register("seeker_bow", () -> new SeekerBowItem(defaultBuilder().func_208103_a(Rarity.UNCOMMON).func_200918_c(384)));
        ice_bow = TFItems.ITEMS.register("ice_bow", () -> new IceBowItem(defaultBuilder().func_208103_a(Rarity.UNCOMMON).func_200918_c(384)));
        ender_bow = TFItems.ITEMS.register("ender_bow", () -> new EnderBowItem(defaultBuilder().func_208103_a(Rarity.UNCOMMON).func_200918_c(384)));
        ice_sword = TFItems.ITEMS.register("ice_sword", () -> new IceSwordItem((IItemTier)TwilightItemTier.TOOL_ICE, defaultBuilder()));
        glass_sword = TFItems.ITEMS.register("glass_sword", () -> new GlassSwordItem((IItemTier)TwilightItemTier.TOOL_GLASS, defaultBuilder().setNoRepair().func_208103_a(Rarity.RARE)));
        knightmetal_ring = TFItems.ITEMS.register("knightmetal_ring", () -> new Item(defaultBuilder()));
        block_and_chain = TFItems.ITEMS.register("block_and_chain", () -> new ChainBlockItem(defaultBuilder().func_200918_c(99)));
        cube_talisman = TFItems.ITEMS.register("cube_talisman", () -> new Item(defaultBuilder().func_208103_a(Rarity.UNCOMMON)));
        cube_of_annihilation = TFItems.ITEMS.register("cube_of_annihilation", () -> new CubeOfAnnihilationItem(unstackable().func_208103_a(Rarity.UNCOMMON)));
        moon_dial = TFItems.ITEMS.register("moon_dial", () -> new Item(defaultBuilder()));
        TFItems.creativeTab = new ItemGroup("twilightforest") {
            public ItemStack func_78016_d() {
                return new ItemStack((IItemProvider)TFBlocks.twilight_portal_miniature_structure.get());
            }
        };
    }
}
