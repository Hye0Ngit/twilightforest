// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import com.google.common.collect.ImmutableList;
import twilightforest.world.feature.TFGenCaveStalactite;
import net.minecraft.init.Blocks;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Item;
import java.util.Optional;
import java.util.List;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import java.util.ArrayList;
import java.util.function.Consumer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import twilightforest.world.WorldProviderTwilightForest;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.block.state.IBlockState;
import com.google.common.collect.ImmutableSet;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.common.config.Config;

@Config(modid = "twilightforest")
@Mod.EventBusSubscriber(modid = "twilightforest")
public class TFConfig
{
    @Config.Ignore
    private static final String config = "twilightforest.config.";
    @Config.LangKey("twilightforest.config.dimension")
    @Config.Comment({ "Settings that are not reversible without consequences." })
    public static Dimension dimension;
    @Config.RequiresMcRestart
    @Config.LangKey("twilightforest.config.compat")
    @Config.Comment({ "Should TF Compatibility load? Turn off if TF's Compatibility is causing crashes or if not desired." })
    public static boolean doCompat;
    @Config.LangKey("twilightforest.config.performance")
    @Config.Comment({ "Lets you sacrifice various things to improve world performance." })
    public static Performance performance;
    @Config.LangKey("twilightforest.config.silent_cicadas")
    @Config.Comment({ "Make cicadas silent for those having sound library problems, or otherwise finding them annoying." })
    public static boolean silentCicadas;
    @Config.LangKey("twilightforest.config.first_person_effects")
    @Config.Comment({ "Controls whether various effects from the mod are rendered while in first-person view. Turn this off if you find them distracting." })
    public static boolean firstPersonEffects;
    @Config.LangKey("twilightforest.config.origin_dimension")
    @Config.Comment({ "The dimension you can always travel to the Twilight Forest from, as well as the dimension you will return to. Defaults to the overworld." })
    public static int originDimension;
    @Config.LangKey("twilightforest.config.portals_in_other_dimensions")
    @Config.Comment({ "Allow portals to the Twilight Forest to be made outside of the 'origin' dimension. May be considered an exploit." })
    public static boolean allowPortalsInOtherDimensions;
    @Config.LangKey("twilightforest.config.admin_portals")
    @Config.Comment({ "Allow portals only for admins (Operators). This severely reduces the range in which the mod usually scans for valid portal conditions, and it scans near ops only." })
    public static boolean adminOnlyPortals;
    @Config.LangKey("twilightforest.config.portals")
    @Config.Comment({ "Disable Twilight Forest portal creation entirely. Provided for server operators looking to restrict action to the dimension." })
    public static boolean disablePortalCreation;
    @Config.LangKey("twilightforest.config.portal_creator")
    @Config.Comment({ "Registry String IDs of items used to create the Twilight Forest Portal. (domain:regname:meta) meta is optional." })
    public static String[] portalCreationItems;
    @Config.LangKey("twilightforest.config.check_portal_destination")
    @Config.Comment({ "Determines if new portals should be pre-checked for safety. If enabled, portals will fail to form rather than redirect to a safe alternate destination.\nNote that enabling this also reduces the rate at which portal formation checks are performed." })
    public static boolean checkPortalDestination;
    @Config.LangKey("twilightforest.config.portal_lighting")
    @Config.Comment({ "Set this true if you want the lightning that zaps the portal to not set things on fire. For those who don't like fun." })
    public static boolean portalLightning;
    @Config.LangKey("twilightforest.config.portal_return")
    @Config.Comment({ "If false, the return portal will require the activation item." })
    public static boolean shouldReturnPortalBeUsable;
    @Config.LangKey("twilightforest.config.progression_default")
    @Config.Comment({ "Sets the default value of the game rule controlling enforced progression." })
    public static boolean progressionRuleDefault;
    @Config.RequiresMcRestart
    @Config.LangKey("twilightforest.config.uncrafting")
    @Config.Comment({ "Disable the uncrafting function of the uncrafting table. Provided as an option when interaction with other mods produces exploitable recipes." })
    public static boolean disableUncrafting;
    @Config.LangKey("twilightforest.config.antibuilder_blacklist")
    @Config.Comment({ "Anti-Builder blacklist. (domain:block:meta) meta is optional." })
    public static String[] antibuilderBlacklist;
    @Config.LangKey("twilightforest.config.animate_trophyitem")
    @Config.Comment({ "Rotate trophy heads on item model. Has no performance impact at all. For those who don't like fun." })
    public static boolean rotateTrophyHeadsGui;
    @Config.LangKey("twilightforest.config.shield_parry")
    @Config.Comment({ "We recommend downloading the Shield Parry mod for parrying, but these controls remain for without." })
    public static ShieldInteractions shieldInteractions;
    @Config.LangKey("twilightforest.config.loading_screen")
    @Config.Comment({ "Client only: Controls for the Loading screen" })
    public static final LoadingScreen loadingScreen;
    @Config.Ignore
    private static ImmutableSet<IBlockState> disallowBreakingBlockList;
    @Config.Ignore
    public static Ingredient portalIngredient;
    
    @SubscribeEvent
    public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals("twilightforest")) {
            TwilightForestMod.checkOriginDimension();
            ConfigManager.sync("twilightforest", Config.Type.INSTANCE);
            if (!event.isWorldRunning()) {
                WorldProviderTwilightForest.syncFromConfig();
            }
            build();
        }
    }
    
    public static void build() {
        loadAntiBuilderBlacklist();
        buildPortalIngredient();
        TFConfig.loadingScreen.loadLoadingScreenIcons();
    }
    
    private static void loadAntiBuilderBlacklist() {
        final ImmutableSet.Builder<IBlockState> builder = (ImmutableSet.Builder<IBlockState>)ImmutableSet.builder();
        builder.addAll((Iterable)IMCHandler.getBlacklistedBlocks());
        for (final String s : TFConfig.antibuilderBlacklist) {
            parseBlockState(s).ifPresent(builder::add);
        }
        TFConfig.disallowBreakingBlockList = (ImmutableSet<IBlockState>)builder.build();
    }
    
    public static ImmutableSet<IBlockState> getDisallowedBlocks() {
        return TFConfig.disallowBreakingBlockList;
    }
    
    private static void buildPortalIngredient() {
        final List<ItemStack> stacks = new ArrayList<ItemStack>();
        for (final String s : TFConfig.portalCreationItems) {
            parseItemStack(s, 32767).ifPresent(stacks::add);
        }
        if (stacks.isEmpty()) {
            stacks.add(new ItemStack(Items.field_151045_i));
        }
        TFConfig.portalIngredient = Ingredient.func_193369_a((ItemStack[])stacks.toArray(new ItemStack[0]));
    }
    
    private static Optional<ItemStack> parseItemStack(final String string, final int defaultMeta) {
        final String[] split = string.split(":");
        if (split.length < 2) {
            return Optional.empty();
        }
        final Item item = (Item)Item.field_150901_e.func_82594_a((Object)new ResourceLocation(split[0], split[1]));
        if (item == null || item == Items.field_190931_a) {
            return Optional.empty();
        }
        int meta = defaultMeta;
        if (split.length > 2) {
            try {
                meta = Integer.parseInt(split[2]);
            }
            catch (NumberFormatException e) {
                return Optional.empty();
            }
        }
        if (meta < 0 || meta > 32767) {
            return Optional.empty();
        }
        return Optional.of(new ItemStack(item, 1, meta));
    }
    
    private static Optional<IBlockState> parseBlockState(final String string) {
        final String[] split = string.split(":");
        if (split.length < 2) {
            return Optional.empty();
        }
        final Block block = (Block)Block.field_149771_c.func_82594_a((Object)new ResourceLocation(split[0], split[1]));
        if (block == Blocks.field_150350_a) {
            return Optional.empty();
        }
        if (split.length == 2) {
            return Optional.of(block.func_176223_P());
        }
        int meta;
        try {
            meta = Integer.parseInt(split[2]);
        }
        catch (NumberFormatException e) {
            return Optional.empty();
        }
        if (meta < 0 || meta > 15) {
            return Optional.empty();
        }
        return Optional.of(block.func_176203_a(meta));
    }
    
    static {
        TFConfig.dimension = new Dimension();
        TFConfig.doCompat = true;
        TFConfig.performance = new Performance();
        TFConfig.silentCicadas = false;
        TFConfig.firstPersonEffects = true;
        TFConfig.originDimension = 0;
        TFConfig.allowPortalsInOtherDimensions = false;
        TFConfig.adminOnlyPortals = false;
        TFConfig.disablePortalCreation = false;
        TFConfig.portalCreationItems = new String[] { "minecraft:diamond" };
        TFConfig.checkPortalDestination = false;
        TFConfig.portalLightning = false;
        TFConfig.shouldReturnPortalBeUsable = true;
        TFConfig.progressionRuleDefault = true;
        TFConfig.disableUncrafting = false;
        TFConfig.antibuilderBlacklist = new String[] { "minecraft:bedrock", "tombmanygraves:grave_block" };
        TFConfig.rotateTrophyHeadsGui = true;
        TFConfig.shieldInteractions = new ShieldInteractions();
        loadingScreen = new LoadingScreen();
    }
    
    public static class Dimension
    {
        @Config.LangKey("twilightforest.config.dimension_id")
        @Config.RequiresMcRestart
        @Config.Comment({ "What ID number to assign to the Twilight Forest dimension. Change if you are having conflicts with another mod." })
        public int dimensionID;
        @Config.LangKey("twilightforest.config.dimension_seed")
        @Config.RequiresWorldRestart
        @Config.Comment({ "If set, this will override the normal world seed when generating parts of the Twilight Forest Dimension." })
        public String twilightForestSeed;
        @Config.LangKey("twilightforest.config.spawn_in_tf")
        @Config.Comment({ "If true, players spawning for the first time will spawn in the Twilight Forest." })
        public boolean newPlayersSpawnInTF;
        @Config.LangKey("twilightforest.config.skylight_forest")
        @Config.RequiresWorldRestart
        @Config.Comment({ "If true, Twilight Forest will generate as a void except for Major Structures" })
        public boolean skylightForest;
        @Config.LangKey("twilightforest.config.skylight_oaks")
        @Config.RequiresWorldRestart
        @Config.Comment({ "If true, giant Twilight Oaks will also spawn in void worlds" })
        public boolean skylightOaks;
        @Config.LangKey("twilightforest.config.world_gen_weights")
        @Config.Comment({ "Weights for various small features" })
        @Config.RequiresMcRestart
        public WorldGenWeights worldGenWeights;
        @Config.LangKey("twilightforest.config.hollow_hill_stalactites")
        @Config.Comment({ "Defines custom stalactites generated in hollow hills.\nFormat is \"modid:block<:meta> size maxLength minHeight weight\", where the properties are:\nSize - the maximum length of the stalactite relative to the space between hill floor and ceiling,\nMax length - maximum length of a stalactite in blocks,\nMin height - minimum space between the hill floor and the stalactite to let it generate,\nWeight - how often it generates.\n\nFor example: \"minecraft:iron_ore 0.7 8 1 24\" would add a stalactite equal to the default iron ore stalactite." })
        @Config.RequiresMcRestart
        public HollowHillStalactites hollowHillStalactites;
        
        public Dimension() {
            this.dimensionID = 7;
            this.twilightForestSeed = "";
            this.newPlayersSpawnInTF = false;
            this.skylightForest = false;
            this.skylightOaks = true;
            this.worldGenWeights = new WorldGenWeights();
            this.hollowHillStalactites = new HollowHillStalactites();
        }
        
        public static class WorldGenWeights
        {
            @Config.LangKey("twilightforest.config.stone_circle_weight")
            @Config.RequiresMcRestart
            @Config.RangeInt(min = 0)
            public int stoneCircleWeight;
            @Config.LangKey("twilightforest.config.well_weight")
            @Config.RequiresMcRestart
            @Config.RangeInt(min = 0)
            public int wellWeight;
            @Config.LangKey("twilightforest.config.stalagmite_weight")
            @Config.RequiresMcRestart
            @Config.RangeInt(min = 0)
            public int stalagmiteWeight;
            @Config.LangKey("twilightforest.config.foundation_weight")
            @Config.RequiresMcRestart
            @Config.RangeInt(min = 0)
            public int foundationWeight;
            @Config.LangKey("twilightforest.config.monolith_weight")
            @Config.RequiresMcRestart
            @Config.RangeInt(min = 0)
            public int monolithWeight;
            @Config.LangKey("twilightforest.config.grove_ruins_weight")
            @Config.RequiresMcRestart
            @Config.RangeInt(min = 0)
            public int groveRuinsWeight;
            @Config.LangKey("twilightforest.config.hollow_stump_weight")
            @Config.RequiresMcRestart
            @Config.RangeInt(min = 0)
            public int hollowStumpWeight;
            @Config.LangKey("twilightforest.config.fallen_hollow_log_weight")
            @Config.RequiresMcRestart
            @Config.RangeInt(min = 0)
            public int fallenHollowLogWeight;
            @Config.LangKey("twilightforest.config.fallen_small_log_weight")
            @Config.RequiresMcRestart
            @Config.RangeInt(min = 0)
            public int fallenSmallLogWeight;
            @Config.LangKey("twilightforest.config.druid_hut_weight")
            @Config.RequiresMcRestart
            @Config.RangeInt(min = 0)
            public int druidHutWeight;
            
            public WorldGenWeights() {
                this.stoneCircleWeight = 10;
                this.wellWeight = 10;
                this.stalagmiteWeight = 12;
                this.foundationWeight = 10;
                this.monolithWeight = 10;
                this.groveRuinsWeight = 5;
                this.hollowStumpWeight = 12;
                this.fallenHollowLogWeight = 10;
                this.fallenSmallLogWeight = 10;
                this.druidHutWeight = 10;
            }
        }
        
        public static class HollowHillStalactites
        {
            @Config.LangKey("twilightforest.config.large_hill")
            @Config.RequiresMcRestart
            @Config.Comment({ "Blocks generating as stalactites in large hills only" })
            public String[] largeHill;
            @Config.LangKey("twilightforest.config.medium_hill")
            @Config.RequiresMcRestart
            @Config.Comment({ "Blocks generating as stalactites in medium and large hills" })
            public String[] mediumHill;
            @Config.LangKey("twilightforest.config.small_hill")
            @Config.RequiresMcRestart
            @Config.Comment({ "Blocks generating as stalactites in all hills" })
            public String[] smallHill;
            @Config.LangKey("twilightforest.config.stalactite_config_only")
            @Config.RequiresMcRestart
            @Config.Comment({ "If true, default stalactites and stalactites defined by other mods will not be used." })
            public boolean useConfigOnly;
            
            public HollowHillStalactites() {
                this.largeHill = new String[0];
                this.mediumHill = new String[0];
                this.smallHill = new String[0];
                this.useConfigOnly = false;
            }
            
            public void load() {
                this.registerHill(this.smallHill, 1);
                this.registerHill(this.mediumHill, 2);
                this.registerHill(this.largeHill, 3);
            }
            
            private void registerHill(final String[] definitions, final int tier) {
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
                final Optional<IBlockState> state = parseBlockState(split[0]);
                if (!state.isPresent()) {
                    return false;
                }
                try {
                    TFGenCaveStalactite.addStalactite(tier, state.get(), Float.parseFloat(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]));
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
        @Config.LangKey("twilightforest.config.canopy_coverage")
        @Config.RangeDouble(min = 0.0)
        @Config.Comment({ "Amount of canopy coverage. Lower numbers improve chunk generation speed at the cost of a thinner forest." })
        public float canopyCoverage;
        @Config.LangKey("twilightforest.config.twilight_oaks")
        @Config.RangeInt(min = 1)
        @Config.Comment({ "Chance that a chunk in the Twilight Forest will contain a twilight oak tree. Higher numbers reduce the number of trees, increasing performance." })
        public int twilightOakChance;
        @Config.LangKey("twilightforest.config.leaves_light_opacity")
        @Config.RangeInt(min = 0, max = 255)
        @Config.Comment({ "This controls the opacity of leaves, changing the amount of light blocked. Can be used to decrease complexity in some lighting checks." })
        public int leavesLightOpacity;
        @Config.LangKey("twilightforest.config.glacier_packed_ice")
        @Config.Comment({ "Setting this true will make Twilight Glaciers generate with Packed Ice instead of regular translucent Ice, decreasing amount of light checking calculations." })
        public boolean glacierPackedIce;
        @Config.LangKey("twilightforest.config.enable_skylight")
        @Config.Comment({ "If the dimension has per-block skylight values. Disabling this will significantly improve world generation performance, at the cost of flat lighting everywhere.\nWARNING: Once chunks are loaded without skylight, that data is lost and cannot easily be regenerated. Be careful!" })
        @Config.RequiresWorldRestart
        public boolean enableSkylight;
        @Config.Ignore
        public boolean shadersSupported;
        
        public Performance() {
            this.canopyCoverage = 1.7f;
            this.twilightOakChance = 48;
            this.leavesLightOpacity = 1;
            this.glacierPackedIce = false;
            this.enableSkylight = true;
            this.shadersSupported = true;
        }
    }
    
    public static class ShieldInteractions
    {
        @Config.LangKey("twilightforest.config.parry_non_twilight")
        @Config.Comment({ "Set to true to parry non-Twilight projectiles." })
        public boolean parryNonTwilightAttacks;
        @Config.LangKey("twilightforest.config.parry_window_arrow")
        @Config.RangeInt(min = 0)
        @Config.Comment({ "The amount of ticks after raising a shield that makes it OK to parry an arrow." })
        public int shieldParryTicksArrow;
        @Config.LangKey("twilightforest.config.parry_window_fireball")
        @Config.RangeInt(min = 0)
        @Config.Comment({ "The amount of ticks after raising a shield that makes it OK to parry a fireball." })
        public int shieldParryTicksFireball;
        @Config.LangKey("twilightforest.config.parry_window_throwable")
        @Config.RangeInt(min = 0)
        @Config.Comment({ "The amount of ticks after raising a shield that makes it OK to parry a thrown item." })
        public int shieldParryTicksThrowable;
        @Config.LangKey("twilightforest.config.parry_window_beam")
        @Config.RangeInt(min = 0)
        public int shieldParryTicksBeam;
        
        public ShieldInteractions() {
            this.parryNonTwilightAttacks = false;
            this.shieldParryTicksArrow = 40;
            this.shieldParryTicksFireball = 40;
            this.shieldParryTicksThrowable = 40;
            this.shieldParryTicksBeam = 10;
        }
    }
    
    public static class LoadingScreen
    {
        @Config.LangKey("twilightforest.config.loading_icon_enable")
        @Config.Comment({ "Wobble the Loading icon. Has no performance impact at all. For those who don't like fun." })
        public boolean enable;
        @Config.LangKey("twilightforest.config.loading_screen_swap_frequency")
        @Config.RangeInt(min = 0)
        @Config.Comment({ "How many ticks between each loading screen change. Set to 0 to not cycle at all." })
        public int cycleLoadingScreenFrequency;
        @Config.LangKey("twilightforest.config.loading_icon_wobble_bounce_frequency")
        @Config.RangeDouble(min = 0.0)
        @Config.Comment({ "Frequency of wobble and bounce." })
        public float frequency;
        @Config.LangKey("twilightforest.config.loading_icon_scale")
        @Config.RangeDouble(min = 0.0)
        @Config.Comment({ "Scale of whole bouncy loading icon." })
        public float scale;
        @Config.LangKey("twilightforest.config.loading_icon_bounciness")
        @Config.RangeDouble(min = 0.0)
        @Config.Comment({ "How much the loading icon bounces." })
        public float scaleDeviation;
        @Config.LangKey("twilightforest.config.loading_icon_tilting")
        @Config.RangeDouble(min = 0.0, max = 360.0)
        @Config.Comment({ "How far the loading icon wobbles." })
        public float tiltRange;
        @Config.LangKey("twilightforest.config.loading_icon_tilt_pushback")
        @Config.RangeDouble(min = 0.0, max = 360.0)
        @Config.Comment({ "Pushback value to re-center the wobble of loading icon." })
        public float tiltConstant;
        @Config.LangKey("twilightforest.config.loading_icon_stacks")
        @Config.Comment({ "List of items to be used for the wobbling Loading Icon. (domain:item:meta) meta is optional." })
        public String[] loadingIconStacks;
        @Config.Ignore
        private ImmutableList<ItemStack> loadingScreenIcons;
        
        public LoadingScreen() {
            this.enable = true;
            this.cycleLoadingScreenFrequency = 0;
            this.frequency = 5.0f;
            this.scale = 3.0f;
            this.scaleDeviation = 5.25f;
            this.tiltRange = 11.25f;
            this.tiltConstant = 22.5f;
            this.loadingIconStacks = new String[] { "twilightforest:experiment_115", "twilightforest:magic_map", "twilightforest:charm_of_life_2", "twilightforest:charm_of_keeping_3", "twilightforest:phantom_helmet", "twilightforest:lamp_of_cinders", "twilightforest:carminite", "twilightforest:block_and_chain", "twilightforest:yeti_helmet", "twilightforest:hydra_chop", "twilightforest:magic_beans", "twilightforest:ironwood_raw", "twilightforest:naga_scale", "twilightforest:experiment_115:2", "twilightforest:miniature_structure", "twilightforest:miniature_structure:6", "twilightforest:knightmetal_block", "twilightforest:tower_device:10", "twilightforest:twilight_sapling:5", "twilightforest:twilight_sapling:6", "twilightforest:twilight_sapling:7", "twilightforest:twilight_sapling:8", "twilightforest:twilight_sapling:9", "twilightforest:borer_essence" };
        }
        
        public ImmutableList<ItemStack> getLoadingScreenIcons() {
            return this.loadingScreenIcons;
        }
        
        void loadLoadingScreenIcons() {
            final ImmutableList.Builder<ItemStack> iconList = (ImmutableList.Builder<ItemStack>)ImmutableList.builder();
            iconList.addAll((Iterable)IMCHandler.getLoadingIconStacks());
            for (final String s : this.loadingIconStacks) {
                parseItemStack(s, 0).ifPresent(iconList::add);
            }
            this.loadingScreenIcons = (ImmutableList<ItemStack>)iconList.build();
        }
    }
}
