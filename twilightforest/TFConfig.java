// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.function.Consumer;
import java.util.Objects;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import twilightforest.world.components.feature.BlockSpikeFeature;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.item.ItemStack;
import java.util.Optional;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "twilightforest")
public class TFConfig
{
    public static Common COMMON_CONFIG;
    public static Client CLIENT_CONFIG;
    private static final String config = "twilightforest.config.";
    
    @SubscribeEvent
    public static void onConfigChanged(final ModConfigEvent.Reloading event) {
        if (event.getConfig().getModId().equals("twilightforest")) {
            TFConfig.COMMON_CONFIG.portalLockingAdvancement = new ResourceLocation((String)TFConfig.COMMON_CONFIG.portalAdvancementLock.get());
            build();
        }
    }
    
    @Deprecated
    public static ResourceLocation getPortalLockingAdvancement() {
        if (TFConfig.COMMON_CONFIG.portalLockingAdvancement == null) {
            TFConfig.COMMON_CONFIG.portalLockingAdvancement = new ResourceLocation((String)TFConfig.COMMON_CONFIG.portalAdvancementLock.get());
        }
        return TFConfig.COMMON_CONFIG.portalLockingAdvancement;
    }
    
    public static void build() {
        TFConfig.CLIENT_CONFIG.LOADING_SCREEN.loadLoadingScreenIcons();
    }
    
    private static Optional<ItemStack> parseItemStack(final String string) {
        final ResourceLocation id = ResourceLocation.m_135820_(string);
        if (id == null || !ForgeRegistries.ITEMS.containsKey(id)) {
            return Optional.empty();
        }
        return Optional.of(new ItemStack((ItemLike)ForgeRegistries.ITEMS.getValue(id)));
    }
    
    private static Optional<Block> parseBlock(final String string) {
        final ResourceLocation id = ResourceLocation.m_135820_(string);
        if (id == null || !ForgeRegistries.BLOCKS.containsKey(id)) {
            return Optional.empty();
        }
        return Optional.ofNullable((Block)ForgeRegistries.BLOCKS.getValue(id));
    }
    
    public static class Common
    {
        public Dimension DIMENSION;
        public ForgeConfigSpec.BooleanValue doCompat;
        public ForgeConfigSpec.ConfigValue<String> originDimension;
        public ForgeConfigSpec.BooleanValue allowPortalsInOtherDimensions;
        public ForgeConfigSpec.BooleanValue adminOnlyPortals;
        public ForgeConfigSpec.BooleanValue disablePortalCreation;
        public ForgeConfigSpec.BooleanValue checkPortalDestination;
        public ForgeConfigSpec.BooleanValue portalLightning;
        public ForgeConfigSpec.BooleanValue shouldReturnPortalBeUsable;
        public ForgeConfigSpec.ConfigValue<String> portalAdvancementLock;
        public ForgeConfigSpec.BooleanValue casketUUIDLocking;
        public ForgeConfigSpec.BooleanValue disableSkullCandles;
        public UncraftingStuff UNCRAFTING_STUFFS;
        public ShieldInteractions SHIELD_INTERACTIONS;
        public ResourceLocation portalLockingAdvancement;
        
        public Common(final ForgeConfigSpec.Builder builder) {
            this.DIMENSION = new Dimension();
            this.UNCRAFTING_STUFFS = new UncraftingStuff();
            this.SHIELD_INTERACTIONS = new ShieldInteractions();
            builder.comment("Settings that are not reversible without consequences.").push("Dimension Settings");
            this.DIMENSION.newPlayersSpawnInTF = builder.translation("twilightforest.config.spawn_in_tf").comment("If true, players spawning for the first time will spawn in the Twilight Forest.").define("newPlayersSpawnInTF", false);
            this.DIMENSION.portalForNewPlayerSpawn = builder.translation("twilightforest.config.portal_for_new_player").comment("If true, the return portal will spawn for new players that were sent to the TF if `spawn_in_tf` is true.").define("portalForNewPlayer", true);
            this.DIMENSION.skylightForest = builder.translation("twilightforest.config.skylight_forest").worldRestart().comment("If true, Twilight Forest will generate as a void except for Major Structures").define("skylightForest", false);
            this.DIMENSION.skylightOaks = builder.translation("twilightforest.config.skylight_oaks").worldRestart().comment("If true, giant Twilight Oaks will also spawn in void worlds").define("skylightOaks", true);
            this.DIMENSION.portalDestinationID = (ForgeConfigSpec.ConfigValue<String>)builder.translation("twilightforest.config.portal_destination_id").worldRestart().comment("Marked dimension ID for Twilight Portals and some other Twilight mod logic as well").define("portalDestinationID", (Object)"twilightforest:twilight_forest");
            builder.pop().comment("""
                                  Defines custom stalactites generated in hollow hills.
                                  Format is "modid:block size maxLength minHeight weight", where the properties are:
                                  Size - the maximum length of the stalactite relative to the space between hill floor and ceiling,
                                  Max length - maximum length of a stalactite in blocks,
                                  Min height - minimum space between the hill floor and the stalactite to let it generate,
                                  Weight - how often it generates.
                                  
                                  For example: "minecraft:iron_ore 0.7 8 1 24" would add a stalactite equal to the default iron ore stalactite.""").push("Custom Hollow Hill Stalactites");
            this.DIMENSION.hollowHillStalactites.largeHill = (ForgeConfigSpec.ConfigValue<List<? extends String>>)builder.translation("twilightforest.config.large_hill").worldRestart().comment("Blocks generating as stalactites in large hills only").defineList("largeHill", (List)new ArrayList(), s -> s instanceof String);
            this.DIMENSION.hollowHillStalactites.mediumHill = (ForgeConfigSpec.ConfigValue<List<? extends String>>)builder.translation("twilightforest.config.medium_hill").worldRestart().comment("Blocks generating as stalactites in medium and large hills").defineList("mediumHill", (List)new ArrayList(), s -> s instanceof String);
            this.DIMENSION.hollowHillStalactites.smallHill = (ForgeConfigSpec.ConfigValue<List<? extends String>>)builder.translation("twilightforest.config.small_hill").worldRestart().comment("Blocks generating as stalactites in all hills").defineList("smallHill", (List)new ArrayList(), s -> s instanceof String);
            this.DIMENSION.hollowHillStalactites.useConfigOnly = builder.translation("twilightforest.config.stalactite_config_only").worldRestart().comment("If true, default stalactites and stalactites defined by other mods will not be used.").define("useConfigOnly", false);
            builder.pop();
            this.doCompat = builder.worldRestart().comment("Should TF Compatibility load? Turn off if TF's Compatibility is causing crashes or if not desired.").define("doCompat", true);
            this.originDimension = (ForgeConfigSpec.ConfigValue<String>)builder.translation("twilightforest.config.origin_dimension").comment("The dimension you can always travel to the Twilight Forest from, as well as the dimension you will return to. Defaults to the overworld. (domain:regname).").define("originDimension", (Object)"minecraft:overworld");
            this.allowPortalsInOtherDimensions = builder.translation("twilightforest.config.portals_in_other_dimensions").comment("Allow portals to the Twilight Forest to be made outside of the 'origin' dimension. May be considered an exploit.").define("allowPortalsInOtherDimensions", false);
            this.adminOnlyPortals = builder.translation("twilightforest.config.admin_portals").comment("Allow portals only for admins (Operators). This severely reduces the range in which the mod usually scans for valid portal conditions, and it scans near ops only.").define("adminOnlyPortals", false);
            this.disablePortalCreation = builder.translation("twilightforest.config.portals").comment("Disable Twilight Forest portal creation entirely. Provided for server operators looking to restrict action to the dimension.").define("disablePortalCreation", false);
            this.checkPortalDestination = builder.translation("twilightforest.config.check_portal_destination").comment("Determines if new portals should be pre-checked for safety. If enabled, portals will fail to form rather than redirect to a safe alternate destination.\nNote that enabling this also reduces the rate at which portal formation checks are performed.").define("checkPortalDestination", false);
            this.portalLightning = builder.translation("twilightforest.config.portal_lighting").comment("Set this true if you want the lightning that zaps the portal to not set things on fire. For those who don't like fun.").define("portalLightning", false);
            this.shouldReturnPortalBeUsable = builder.translation("twilightforest.config.portal_return").comment("If false, the return portal will require the activation item.").define("shouldReturnPortalBeUsable", true);
            this.portalAdvancementLock = (ForgeConfigSpec.ConfigValue<String>)builder.translation("twilightforest.config.portal_unlocked_by_advancement").comment("Use a valid advancement resource location as a string. For example, using the string \"minecraft:story/mine_diamond\" will lock the portal behind the \"Diamonds!\" advancement. Invalid/Empty Advancement resource IDs will leave the portal entirely unlocked.").define("portalUnlockedByAdvancement", (Object)"");
            this.casketUUIDLocking = builder.worldRestart().translation("twilightforest.config.casket_uuid_locking").comment("If true, Keepsake Caskets that are spawned when a player dies will not be accessible by other players. Use this if you dont want people taking from other people's death caskets. NOTE: server operators will still be able to open locked caskets.").define("uuid_locking", false);
            this.disableSkullCandles = builder.translation("twilightforest.config.disable_skull_candles").comment("If true, disables the ability to make Skull Candles by right clicking a vanilla skull with a candle. Turn this on if you're having mod conflict issues for some reason.").define("skull_candles", false);
            builder.comment("Settings for all things related to the uncrafting table.").push("Uncrafting Table");
            this.UNCRAFTING_STUFFS.disableUncraftingRecipes = (ForgeConfigSpec.ConfigValue<List<? extends String>>)builder.worldRestart().translation("twilightforest.config.uncrafting_recipes").comment("""
                                                                                                                                                                                                          If you don't want to disable uncrafting altogether, and would rather disable certain recipes, this is for you.
                                                                                                                                                                                                          To add a recipe, add the mod id followed by the name of the recipe. You can check this in things like JEI.
                                                                                                                                                                                                          Example: "twilightforest:moonworm_queen" will disable uncrafting the moonworm queen into itself and 3 torchberries.
                                                                                                                                                                                                          If an item has multiple crafting recipes and you wish to disable them all, add the item to the "twilightforest:banned_uncraftables" item tag.
                                                                                                                                                                                                          If you have a problematic ingredient, like infested towerwood for example, add the item to the "twilightforest:banned_uncrafting_ingredients" item tag.""").defineList("disableUncraftingRecipes", (List)new ArrayList(), s -> s instanceof String);
            this.UNCRAFTING_STUFFS.blacklistedUncraftingModIds = (ForgeConfigSpec.ConfigValue<List<? extends String>>)builder.worldRestart().translation("twilightforest.config.uncrafting_mod_ids").comment("""
                                                                                                                                                                                                             Here, you can disable all items from certain mods from being uncrafted.
                                                                                                                                                                                                             Input a valid mod id to disable all uncrafting recipes from that mod.
                                                                                                                                                                                                             Example: "twilightforest" will disable all uncrafting recipes from this mod.""").defineList("blacklistedUncraftingModIds", (List)new ArrayList(), s -> s instanceof String);
            this.UNCRAFTING_STUFFS.flipUncraftingModIdList = builder.worldRestart().translation("twilightforest.config.uncrafting_mod_id_flip").comment("If true, this will invert the above option from a blacklist to a whitelist.").define("flipIdList", false);
            this.UNCRAFTING_STUFFS.disableUncrafting = builder.worldRestart().translation("twilightforest.config.uncrafting").comment("Disable the uncrafting function of the uncrafting table. Recommended as a last resort if there's too many things to change about its behavior.").define("disableUncrafting", false);
            builder.pop();
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
            public ForgeConfigSpec.BooleanValue portalForNewPlayerSpawn;
            public ForgeConfigSpec.BooleanValue skylightForest;
            public ForgeConfigSpec.BooleanValue skylightOaks;
            public ForgeConfigSpec.ConfigValue<String> portalDestinationID;
            public HollowHillStalactites hollowHillStalactites;
            
            public Dimension() {
                this.hollowHillStalactites = new HollowHillStalactites();
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
                    final Optional<Block> block = TFConfig.parseBlock(split[0]);
                    if (block.isEmpty()) {
                        return false;
                    }
                    try {
                        BlockSpikeFeature.registerStalactite(tier, block.get().m_49966_(), Float.parseFloat(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]));
                    }
                    catch (NumberFormatException e) {
                        return false;
                    }
                    return true;
                }
            }
        }
        
        public static class UncraftingStuff
        {
            public ForgeConfigSpec.BooleanValue disableUncrafting;
            public ForgeConfigSpec.ConfigValue<List<? extends String>> disableUncraftingRecipes;
            public ForgeConfigSpec.ConfigValue<List<? extends String>> blacklistedUncraftingModIds;
            public ForgeConfigSpec.BooleanValue flipUncraftingModIdList;
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
        public ForgeConfigSpec.BooleanValue disableHereBeDragons;
        public ForgeConfigSpec.BooleanValue disableLockedBiomeToasts;
        public final LoadingScreen LOADING_SCREEN;
        
        public Client(final ForgeConfigSpec.Builder builder) {
            this.LOADING_SCREEN = new LoadingScreen();
            this.silentCicadas = builder.translation("twilightforest.config.silent_cicadas").comment("Make cicadas silent for those having sound library problems, or otherwise finding them annoying.").define("silentCicadas", false);
            this.firstPersonEffects = builder.translation("twilightforest.config.first_person_effects").comment("Controls whether various effects from the mod are rendered while in first-person view. Turn this off if you find them distracting.").define("firstPersonEffects", true);
            this.rotateTrophyHeadsGui = builder.translation("twilightforest.config.animate_trophyitem").comment("Rotate trophy heads on item model. Has no performance impact at all. For those who don't like fun.").define("rotateTrophyHeadsGui", true);
            this.disableOptifineNagScreen = builder.translation("twilightforest.config.optifine").comment("Disable the nag screen when Optifine is installed.").define("disableOptifineNagScreen", false);
            this.disableHereBeDragons = builder.translation("twilightforest.config.dragons").comment("Disable the Here Be Dragons experimental warning screen.").define("disableHereBeDragons", false);
            this.disableLockedBiomeToasts = builder.translation("twilightforest.config.locked_toasts").comment("Disables the toasts that appear when a biome is locked. Not recommended if you're not familiar with progression.").define("disableLockedBiomeToasts", false);
            builder.comment("Client only: Controls for the Loading screen").push("Loading Screen");
            this.LOADING_SCREEN.enable = builder.translation("twilightforest.config.loading_icon_enable").comment("Wobble the Loading icon. Has no performance impact at all. For those who don't like fun.").define("enable", true);
            this.LOADING_SCREEN.cycleLoadingScreenFrequency = builder.translation("twilightforest.config.loading_screen_swap_frequency").comment("How many ticks between each loading screen change. Set to 0 to not cycle at all.").defineInRange("cycleLoadingScreenFrequency", 0, 0, Integer.MAX_VALUE);
            this.LOADING_SCREEN.frequency = builder.translation("twilightforest.config.loading_icon_wobble_bounce_frequency").comment("Frequency of wobble and bounce.").defineInRange("frequency", 5.0, 0.0, Double.MAX_VALUE);
            this.LOADING_SCREEN.scale = builder.translation("twilightforest.config.loading_icon_scale").comment("Scale of whole bouncy loading icon.").defineInRange("scale", 3.0, 0.0, Double.MAX_VALUE);
            this.LOADING_SCREEN.scaleDeviation = builder.translation("twilightforest.config.loading_icon_bounciness").comment("How much the loading icon bounces.").defineInRange("scaleDeviation", 5.25, 0.0, Double.MAX_VALUE);
            this.LOADING_SCREEN.tiltRange = builder.translation("twilightforest.config.loading_icon_tilting").comment("How far the loading icon wobbles.").defineInRange("tiltRange", 11.25, 0.0, 360.0);
            this.LOADING_SCREEN.tiltConstant = builder.translation("twilightforest.config.loading_icon_tilt_pushback").comment("Pushback value to re-center the wobble of loading icon.").defineInRange("tiltConstant", 22.5, 0.0, 360.0);
            this.LOADING_SCREEN.loadingIconStacks = (ForgeConfigSpec.ConfigValue<List<? extends String>>)builder.translation("twilightforest.config.loading_icon_stacks").comment("List of items to be used for the wobbling Loading Icon. (domain:item).").defineList("loadingIconStacks", (List)Arrays.asList("twilightforest:experiment_115", "twilightforest:magic_map", "twilightforest:charm_of_life_2", "twilightforest:charm_of_keeping_3", "twilightforest:phantom_helmet", "twilightforest:lamp_of_cinders", "twilightforest:carminite", "twilightforest:block_and_chain", "twilightforest:yeti_helmet", "twilightforest:hydra_chop", "twilightforest:magic_beans", "twilightforest:ironwood_raw", "twilightforest:naga_scale", "twilightforest:twilight_portal_miniature_structure", "twilightforest:lich_tower_miniature_structure", "twilightforest:knightmetal_block", "twilightforest:ghast_trap", "twilightforest:time_sapling", "twilightforest:transformation_sapling", "twilightforest:mining_sapling", "twilightforest:sorting_sapling", "twilightforest:rainboak_sapling", "twilightforest:borer_essence"), s -> s instanceof String && ResourceLocation.m_135820_((String)s) != null);
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
                    final Optional<ItemStack> itemStack = TFConfig.parseItemStack(s);
                    final ImmutableList.Builder<ItemStack> obj = iconList;
                    Objects.requireNonNull(obj);
                    itemStack.ifPresent(obj::add);
                }
                this.loadingScreenIcons = (ImmutableList<ItemStack>)iconList.build();
            }
        }
    }
}
