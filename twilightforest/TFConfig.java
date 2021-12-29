// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.function.Consumer;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import twilightforest.world.feature.TFGenCaveStalactite;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraft.block.Block;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import java.util.Optional;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "twilightforest")
public class TFConfig
{
    public static Common COMMON_CONFIG;
    public static Client CLIENT_CONFIG;
    private static final String config = "twilightforest.config.";
    
    @SubscribeEvent
    public static void onConfigChanged(final ModConfig.Reloading event) {
        if (event.getConfig().getModId().equals("twilightforest")) {
            build();
        }
    }
    
    public static void build() {
        TFConfig.CLIENT_CONFIG.LOADING_SCREEN.loadLoadingScreenIcons();
    }
    
    private static Optional<ItemStack> parseItemStack(final String string) {
        final ResourceLocation id = ResourceLocation.func_208304_a(string);
        if (id == null || !ForgeRegistries.ITEMS.containsKey(id)) {
            return Optional.empty();
        }
        return Optional.of(new ItemStack((IItemProvider)ForgeRegistries.ITEMS.getValue(id)));
    }
    
    private static Optional<Block> parseBlock(final String string) {
        final ResourceLocation id = ResourceLocation.func_208304_a(string);
        if (id == null || !ForgeRegistries.BLOCKS.containsKey(id)) {
            return Optional.empty();
        }
        return Optional.of((Block)ForgeRegistries.BLOCKS.getValue(id));
    }
    
    public static class Common
    {
        public Dimension DIMENSION;
        public ForgeConfigSpec.BooleanValue doCompat;
        public Performance PERFORMANCE;
        public ForgeConfigSpec.ConfigValue<String> originDimension;
        public ForgeConfigSpec.BooleanValue allowPortalsInOtherDimensions;
        public ForgeConfigSpec.BooleanValue adminOnlyPortals;
        public ForgeConfigSpec.BooleanValue disablePortalCreation;
        public ForgeConfigSpec.ConfigValue<List<? extends String>> portalCreationItems;
        public ForgeConfigSpec.BooleanValue checkPortalDestination;
        public ForgeConfigSpec.BooleanValue portalLightning;
        public ForgeConfigSpec.BooleanValue shouldReturnPortalBeUsable;
        public ForgeConfigSpec.BooleanValue progressionRuleDefault;
        public ForgeConfigSpec.BooleanValue disableUncrafting;
        public ForgeConfigSpec.BooleanValue casketUUIDLocking;
        public ShieldInteractions SHIELD_INTERACTIONS;
        
        public Common(final ForgeConfigSpec.Builder builder) {
            this.DIMENSION = new Dimension();
            this.PERFORMANCE = new Performance();
            this.SHIELD_INTERACTIONS = new ShieldInteractions();
            builder.comment("Settings that are not reversible without consequences.").push("Dimension Settings");
            this.DIMENSION.newPlayersSpawnInTF = builder.translation("twilightforest.config.spawn_in_tf").comment("If true, players spawning for the first time will spawn in the Twilight Forest.").define("newPlayersSpawnInTF", false);
            this.DIMENSION.skylightForest = builder.translation("twilightforest.config.skylight_forest").worldRestart().comment("If true, Twilight Forest will generate as a void except for Major Structures").define("skylightForest", false);
            this.DIMENSION.skylightOaks = builder.translation("twilightforest.config.skylight_oaks").worldRestart().comment("If true, giant Twilight Oaks will also spawn in void worlds").define("skylightOaks", true);
            this.DIMENSION.twilightForestID = (ForgeConfigSpec.ConfigValue<String>)builder.translation("twilightforest.config.twilight_dimension_id").worldRestart().comment("Destination dimension for Twilight Portals and some other logic as well").define("twilightDimensionID", (Object)"twilightforest:twilightforest");
            builder.comment("Weights for various small features").push("World-Gen Weights");
            this.DIMENSION.worldGenWeights.stoneCircleWeight = builder.translation("twilightforest.config.stone_circle_weight").worldRestart().defineInRange("stoneCircleWeight", 10, 0, Integer.MAX_VALUE);
            this.DIMENSION.worldGenWeights.wellWeight = builder.translation("twilightforest.config.well_weight").worldRestart().defineInRange("wellWeight", 10, 0, Integer.MAX_VALUE);
            this.DIMENSION.worldGenWeights.stalagmiteWeight = builder.translation("twilightforest.config.stalagmite_weight").worldRestart().defineInRange("stalagmiteWeight", 12, 0, Integer.MAX_VALUE);
            this.DIMENSION.worldGenWeights.foundationWeight = builder.translation("twilightforest.config.foundation_weight").worldRestart().defineInRange("foundationWeight", 10, 0, Integer.MAX_VALUE);
            this.DIMENSION.worldGenWeights.monolithWeight = builder.translation("twilightforest.config.monolith_weight").worldRestart().defineInRange("monolithWeight", 10, 0, Integer.MAX_VALUE);
            this.DIMENSION.worldGenWeights.groveRuinsWeight = builder.translation("twilightforest.config.grove_ruins_weight").worldRestart().defineInRange("groveRuinsWeight", 5, 0, Integer.MAX_VALUE);
            this.DIMENSION.worldGenWeights.hollowStumpWeight = builder.translation("twilightforest.config.hollow_stump_weight").worldRestart().defineInRange("hollowStumpWeight", 12, 0, Integer.MAX_VALUE);
            this.DIMENSION.worldGenWeights.fallenHollowLogWeight = builder.translation("twilightforest.config.fallen_hollow_log_weight").worldRestart().defineInRange("fallenHollowLogWeight", 10, 0, Integer.MAX_VALUE);
            this.DIMENSION.worldGenWeights.fallenSmallLogWeight = builder.translation("twilightforest.config.fallen_small_log_weight").worldRestart().defineInRange("fallenSmallLogWeight", 10, 0, Integer.MAX_VALUE);
            this.DIMENSION.worldGenWeights.druidHutWeight = builder.translation("twilightforest.config.druid_hut_weight").worldRestart().defineInRange("druidHutWeight", 10, 0, Integer.MAX_VALUE);
            builder.pop().comment("Defines custom stalactites generated in hollow hills.\nFormat is \"modid:block size maxLength minHeight weight\", where the properties are:\nSize - the maximum length of the stalactite relative to the space between hill floor and ceiling,\nMax length - maximum length of a stalactite in blocks,\nMin height - minimum space between the hill floor and the stalactite to let it generate,\nWeight - how often it generates.\n\nFor example: \"minecraft:iron_ore 0.7 8 1 24\" would add a stalactite equal to the default iron ore stalactite.").push("Custom Hollow Hill Stalactites");
            this.DIMENSION.hollowHillStalactites.largeHill = (ForgeConfigSpec.ConfigValue<List<? extends String>>)builder.translation("twilightforest.config.large_hill").worldRestart().comment("Blocks generating as stalactites in large hills only").defineList("largeHill", (List)new ArrayList(), s -> s instanceof String);
            this.DIMENSION.hollowHillStalactites.mediumHill = (ForgeConfigSpec.ConfigValue<List<? extends String>>)builder.translation("twilightforest.config.medium_hill").worldRestart().comment("Blocks generating as stalactites in medium and large hills").defineList("mediumHill", (List)new ArrayList(), s -> s instanceof String);
            this.DIMENSION.hollowHillStalactites.smallHill = (ForgeConfigSpec.ConfigValue<List<? extends String>>)builder.translation("twilightforest.config.small_hill").worldRestart().comment("Blocks generating as stalactites in all hills").defineList("smallHill", (List)new ArrayList(), s -> s instanceof String);
            this.DIMENSION.hollowHillStalactites.useConfigOnly = builder.translation("twilightforest.config.stalactite_config_only").worldRestart().comment("If true, default stalactites and stalactites defined by other mods will not be used.").define("useConfigOnly", false);
            builder.pop();
            builder.pop();
            this.doCompat = builder.worldRestart().comment("Should TF Compatibility load? Turn off if TF's Compatibility is causing crashes or if not desired.").define("doCompat", true);
            builder.comment("Lets you sacrifice various things to improve world performance.").push("Performance Tweaks");
            this.PERFORMANCE.canopyCoverage = builder.translation("twilightforest.config.canopy_coverage").comment("Amount of canopy coverage. Lower numbers improve chunk generation speed at the cost of a thinner forest.").defineInRange("canopyCoverage", 1.7000000476837158, 0.0, Double.MAX_VALUE);
            this.PERFORMANCE.twilightOakChance = builder.translation("twilightforest.config.twilight_oaks").comment("Chance that a chunk in the Twilight Forest will contain a twilight oak tree. Higher numbers reduce the number of trees, increasing performance.").defineInRange("twilightOakChance", 48, 1, Integer.MAX_VALUE);
            this.PERFORMANCE.leavesLightOpacity = builder.translation("twilightforest.config.leaves_light_opacity").comment("This controls the opacity of leaves, changing the amount of light blocked. Can be used to decrease complexity in some lighting checks.").defineInRange("leavesLightOpacity", 1, 0, 255);
            this.PERFORMANCE.glacierPackedIce = builder.translation("twilightforest.config.glacier_packed_ice").comment("Setting this true will make Twilight Glaciers generate with Packed Ice instead of regular translucent Ice, decreasing amount of light checking calculations.").define("glacierPackedIce", false);
            this.PERFORMANCE.enableSkylight = builder.translation("twilightforest.config.enable_skylight").comment("If the dimension has per-block skylight values. Disabling this will significantly improve world generation performance, at the cost of flat lighting everywhere.\nWARNING: Once chunks are loaded without skylight, that data is lost and cannot easily be regenerated. Be careful!").worldRestart().define("enableSkylight", true);
            builder.pop();
            this.originDimension = (ForgeConfigSpec.ConfigValue<String>)builder.translation("twilightforest.config.origin_dimension").comment("The dimension you can always travel to the Twilight Forest from, as well as the dimension you will return to. Defaults to the overworld. (domain:regname).").define("originDimension", (Object)"minecraft:overworld");
            this.allowPortalsInOtherDimensions = builder.translation("twilightforest.config.portals_in_other_dimensions").comment("Allow portals to the Twilight Forest to be made outside of the 'origin' dimension. May be considered an exploit.").define("allowPortalsInOtherDimensions", false);
            this.adminOnlyPortals = builder.translation("twilightforest.config.admin_portals").comment("Allow portals only for admins (Operators). This severely reduces the range in which the mod usually scans for valid portal conditions, and it scans near ops only.").define("adminOnlyPortals", false);
            this.disablePortalCreation = builder.translation("twilightforest.config.portals").comment("Disable Twilight Forest portal creation entirely. Provided for server operators looking to restrict action to the dimension.").define("disablePortalCreation", false);
            this.checkPortalDestination = builder.translation("twilightforest.config.check_portal_destination").comment("Determines if new portals should be pre-checked for safety. If enabled, portals will fail to form rather than redirect to a safe alternate destination.\nNote that enabling this also reduces the rate at which portal formation checks are performed.").define("checkPortalDestination", false);
            this.portalLightning = builder.translation("twilightforest.config.portal_lighting").comment("Set this true if you want the lightning that zaps the portal to not set things on fire. For those who don't like fun.").define("portalLightning", false);
            this.shouldReturnPortalBeUsable = builder.translation("twilightforest.config.portal_return").comment("If false, the return portal will require the activation item.").define("shouldReturnPortalBeUsable", true);
            this.progressionRuleDefault = builder.translation("twilightforest.config.progression_default").comment("Sets the default value of the game rule controlling enforced progression.").define("progressionRuleDefault", true);
            this.disableUncrafting = builder.worldRestart().translation("twilightforest.config.uncrafting").comment("Disable the uncrafting function of the uncrafting table. Provided as an option when interaction with other mods produces exploitable recipes.").define("disableUncrafting", false);
            this.casketUUIDLocking = builder.worldRestart().translation("twilightforest.config.casket_uuid_locking").comment("If true, Keepsake Caskets that are spawned when a player dies will not be accessible by other players. Use this if you dont want people taking from other people's death caskets. NOTE: server operators will still be able to open locked caskets.").define("uuid_locking", false);
            builder.comment("We recommend downloading the Shield Parry mod for parrying, but these controls remain for without.").push("Shield Parrying");
            this.SHIELD_INTERACTIONS.parryNonTwilightAttacks = builder.translation("twilightforest.config.parry_non_twilight").comment("Set to true to parry non-Twilight projectiles.").define("parryNonTwilightAttacks", false);
            this.SHIELD_INTERACTIONS.shieldParryTicksArrow = builder.translation("twilightforest.config.parry_window_arrow").comment("The amount of ticks after raising a shield that makes it OK to parry an arrow.").defineInRange("shieldParryTicksArrow", 40, 0, Integer.MAX_VALUE);
            this.SHIELD_INTERACTIONS.shieldParryTicksFireball = builder.translation("twilightforest.config.parry_window_fireball").comment("The amount of ticks after raising a shield that makes it OK to parry a fireball.").defineInRange("shieldParryTicksFireball", 40, 0, Integer.MAX_VALUE);
            this.SHIELD_INTERACTIONS.shieldParryTicksThrowable = builder.translation("twilightforest.config.parry_window_throwable").comment("The amount of ticks after raising a shield that makes it OK to parry a thrown item.").defineInRange("shieldParryTicksThrowable", 40, 0, Integer.MAX_VALUE);
            this.SHIELD_INTERACTIONS.shieldParryTicksBeam = builder.translation("twilightforest.config.parry_window_beam").defineInRange("shieldParryTicksBeam", 10, 0, Integer.MAX_VALUE);
            builder.pop();
        }
        
        public static class Dimension
        {
            public ForgeConfigSpec.BooleanValue newPlayersSpawnInTF;
            public ForgeConfigSpec.BooleanValue skylightForest;
            public ForgeConfigSpec.BooleanValue skylightOaks;
            public ForgeConfigSpec.ConfigValue<String> twilightForestID;
            public WorldGenWeights worldGenWeights;
            public HollowHillStalactites hollowHillStalactites;
            
            public Dimension() {
                this.worldGenWeights = new WorldGenWeights();
                this.hollowHillStalactites = new HollowHillStalactites();
            }
            
            public static class WorldGenWeights
            {
                public ForgeConfigSpec.IntValue stoneCircleWeight;
                public ForgeConfigSpec.IntValue wellWeight;
                public ForgeConfigSpec.IntValue stalagmiteWeight;
                public ForgeConfigSpec.IntValue foundationWeight;
                public ForgeConfigSpec.IntValue monolithWeight;
                public ForgeConfigSpec.IntValue groveRuinsWeight;
                public ForgeConfigSpec.IntValue hollowStumpWeight;
                public ForgeConfigSpec.IntValue fallenHollowLogWeight;
                public ForgeConfigSpec.IntValue fallenSmallLogWeight;
                public ForgeConfigSpec.IntValue druidHutWeight;
            }
            
            public static class HollowHillStalactites
            {
                public ForgeConfigSpec.ConfigValue<List<? extends String>> largeHill;
                public ForgeConfigSpec.ConfigValue<List<? extends String>> mediumHill;
                public ForgeConfigSpec.ConfigValue<List<? extends String>> smallHill;
                public ForgeConfigSpec.BooleanValue useConfigOnly;
                
                public void load() {
                    this.registerHill((List<? extends String>)this.smallHill.get(), 1);
                    this.registerHill((List<? extends String>)this.mediumHill.get(), 2);
                    this.registerHill((List<? extends String>)this.largeHill.get(), 3);
                }
                
                private void registerHill(final List<? extends String> definitions, final int tier) {
                    for (final String definition : definitions) {
                        if (!this.parseStalactite(definition, tier)) {
                            TwilightForestMod.LOGGER.warn("Invalid hollow hill stalactite definition: {}", (Object)definition);
                        }
                    }
                }
                
                private boolean parseStalactite(final String definition, final int tier) {
                    final String[] split = definition.split(" ");
                    if (split.length != 5) {
                        return false;
                    }
                    final Optional<Block> block = parseBlock(split[0]);
                    if (!block.isPresent()) {
                        return false;
                    }
                    try {
                        TFGenCaveStalactite.addStalactite(tier, block.get().func_176223_P(), Float.parseFloat(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]));
                    }
                    catch (NumberFormatException e) {
                        return false;
                    }
                    return true;
                }
            }
        }
        
        public static class Performance
        {
            public ForgeConfigSpec.DoubleValue canopyCoverage;
            public ForgeConfigSpec.IntValue twilightOakChance;
            public ForgeConfigSpec.IntValue leavesLightOpacity;
            public ForgeConfigSpec.BooleanValue glacierPackedIce;
            public ForgeConfigSpec.BooleanValue enableSkylight;
            public boolean shadersSupported;
            
            public Performance() {
                this.shadersSupported = true;
            }
        }
        
        public static class ShieldInteractions
        {
            public ForgeConfigSpec.BooleanValue parryNonTwilightAttacks;
            public ForgeConfigSpec.IntValue shieldParryTicksArrow;
            public ForgeConfigSpec.IntValue shieldParryTicksFireball;
            public ForgeConfigSpec.IntValue shieldParryTicksThrowable;
            public ForgeConfigSpec.IntValue shieldParryTicksBeam;
        }
    }
    
    public static class Client
    {
        public ForgeConfigSpec.BooleanValue silentCicadas;
        public ForgeConfigSpec.BooleanValue firstPersonEffects;
        public ForgeConfigSpec.BooleanValue rotateTrophyHeadsGui;
        public ForgeConfigSpec.BooleanValue disableOptifineNagScreen;
        public final LoadingScreen LOADING_SCREEN;
        
        public Client(final ForgeConfigSpec.Builder builder) {
            this.LOADING_SCREEN = new LoadingScreen();
            this.silentCicadas = builder.translation("twilightforest.config.silent_cicadas").comment("Make cicadas silent for those having sound library problems, or otherwise finding them annoying.").define("silentCicadas", false);
            this.firstPersonEffects = builder.translation("twilightforest.config.first_person_effects").comment("Controls whether various effects from the mod are rendered while in first-person view. Turn this off if you find them distracting.").define("firstPersonEffects", true);
            this.rotateTrophyHeadsGui = builder.translation("twilightforest.config.animate_trophyitem").comment("Rotate trophy heads on item model. Has no performance impact at all. For those who don't like fun.").define("rotateTrophyHeadsGui", true);
            this.disableOptifineNagScreen = builder.translation("twilightforest.config.optifine").comment("Disable the nag screen when Optifine is installed.").define("disableOptifineNagScreen", false);
            builder.comment("Client only: Controls for the Loading screen").push("Loading Screen");
            this.LOADING_SCREEN.enable = builder.translation("twilightforest.config.loading_icon_enable").comment("Wobble the Loading icon. Has no performance impact at all. For those who don't like fun.").define("enable", true);
            this.LOADING_SCREEN.cycleLoadingScreenFrequency = builder.translation("twilightforest.config.loading_screen_swap_frequency").comment("How many ticks between each loading screen change. Set to 0 to not cycle at all.").defineInRange("cycleLoadingScreenFrequency", 0, 0, Integer.MAX_VALUE);
            this.LOADING_SCREEN.frequency = builder.translation("twilightforest.config.loading_icon_wobble_bounce_frequency").comment("Frequency of wobble and bounce.").defineInRange("frequency", 5.0, 0.0, Double.MAX_VALUE);
            this.LOADING_SCREEN.scale = builder.translation("twilightforest.config.loading_icon_scale").comment("Scale of whole bouncy loading icon.").defineInRange("scale", 3.0, 0.0, Double.MAX_VALUE);
            this.LOADING_SCREEN.scaleDeviation = builder.translation("twilightforest.config.loading_icon_bounciness").comment("How much the loading icon bounces.").defineInRange("scaleDeviation", 5.25, 0.0, Double.MAX_VALUE);
            this.LOADING_SCREEN.tiltRange = builder.translation("twilightforest.config.loading_icon_tilting").comment("How far the loading icon wobbles.").defineInRange("tiltRange", 11.25, 0.0, 360.0);
            this.LOADING_SCREEN.tiltConstant = builder.translation("twilightforest.config.loading_icon_tilt_pushback").comment("Pushback value to re-center the wobble of loading icon.").defineInRange("tiltConstant", 22.5, 0.0, 360.0);
            this.LOADING_SCREEN.loadingIconStacks = (ForgeConfigSpec.ConfigValue<List<? extends String>>)builder.translation("twilightforest.config.loading_icon_stacks").comment("List of items to be used for the wobbling Loading Icon. (domain:item).").defineList("loadingIconStacks", (List)Arrays.asList("twilightforest:experiment_115", "twilightforest:magic_map", "twilightforest:charm_of_life_2", "twilightforest:charm_of_keeping_3", "twilightforest:phantom_helmet", "twilightforest:lamp_of_cinders", "twilightforest:carminite", "twilightforest:block_and_chain", "twilightforest:yeti_helmet", "twilightforest:hydra_chop", "twilightforest:magic_beans", "twilightforest:ironwood_raw", "twilightforest:naga_scale", "twilightforest:experiment_115{think:1}", "twilightforest:twilight_portal_miniature_structure", "twilightforest:lich_tower_miniature_structure", "twilightforest:knightmetal_block", "twilightforest:ghast_trap", "twilightforest:time_sapling", "twilightforest:transformation_sapling", "twilightforest:mining_sapling", "twilightforest:sorting_sapling", "twilightforest:rainboak_sapling", "twilightforest:borer_essence"), s -> s instanceof String && ResourceLocation.func_208304_a((String)s) != null);
            builder.pop();
        }
        
        public static class LoadingScreen
        {
            public ForgeConfigSpec.BooleanValue enable;
            public ForgeConfigSpec.IntValue cycleLoadingScreenFrequency;
            public ForgeConfigSpec.DoubleValue frequency;
            public ForgeConfigSpec.DoubleValue scale;
            public ForgeConfigSpec.DoubleValue scaleDeviation;
            public ForgeConfigSpec.DoubleValue tiltRange;
            public ForgeConfigSpec.DoubleValue tiltConstant;
            public ForgeConfigSpec.ConfigValue<List<? extends String>> loadingIconStacks;
            private ImmutableList<ItemStack> loadingScreenIcons;
            
            public ImmutableList<ItemStack> getLoadingScreenIcons() {
                return this.loadingScreenIcons;
            }
            
            void loadLoadingScreenIcons() {
                final ImmutableList.Builder<ItemStack> iconList = (ImmutableList.Builder<ItemStack>)ImmutableList.builder();
                iconList.addAll((Iterable)IMCHandler.getLoadingIconStacks());
                for (final String s : (List)this.loadingIconStacks.get()) {
                    parseItemStack(s).ifPresent(iconList::add);
                }
                this.loadingScreenIcons = (ImmutableList<ItemStack>)iconList.build();
            }
        }
    }
}
