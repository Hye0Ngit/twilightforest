// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.compat.ie;

import twilightforest.TwilightForestMod;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.GlStateManager;
import blusunrize.immersiveengineering.client.ClientUtils;
import blusunrize.immersiveengineering.api.shader.ShaderCaseBalloon;
import blusunrize.immersiveengineering.api.shader.ShaderCaseMinecart;
import blusunrize.immersiveengineering.api.shader.ShaderCaseShield;
import blusunrize.immersiveengineering.api.shader.ShaderCaseRailgun;
import blusunrize.immersiveengineering.api.shader.ShaderCaseDrill;
import blusunrize.immersiveengineering.api.shader.ShaderCaseChemthrower;
import java.util.Collection;
import blusunrize.immersiveengineering.api.shader.ShaderCaseRevolver;
import java.util.Iterator;
import blusunrize.immersiveengineering.api.crafting.IngredientStack;
import net.minecraft.item.ItemStack;
import twilightforest.item.TFItems;
import twilightforest.client.shader.ShaderUniform;
import com.google.common.collect.ImmutableList;
import twilightforest.client.shader.ShaderManager;
import net.minecraft.item.EnumRarity;
import blusunrize.immersiveengineering.api.shader.ShaderRegistry;
import java.util.List;
import java.util.function.IntConsumer;
import org.apache.logging.log4j.util.TriConsumer;
import net.minecraft.util.ResourceLocation;
import blusunrize.immersiveengineering.api.shader.ShaderCase;

public class IEShaderRegister
{
    private static final ShaderCase.ShaderLayer NULL_LAYER;
    private static final ShaderCase.ShaderLayer UNCOLORED_REVOLVER_LAYER;
    private static final ShaderCase.ShaderLayer UNCOLORED_CHEMTHROW_LAYER;
    private static final ShaderCase.ShaderLayer UNCOLORED_DRILL_LAYER;
    private static final ShaderCase.ShaderLayer UNCOLORED_RAILGUN_LAYER;
    private static final ShaderCase.ShaderLayer UNCOLORED_SHIELD_LAYER;
    private static final ShaderCase.ShaderLayer UNCOLORED_MINECART_LAYER;
    private static final ShaderCase.ShaderLayer UNCOLORED_BALLOON_LAYER;
    public static final ResourceLocation PROCESSED_REVOLVER_GRIP_LAYER;
    public static final ResourceLocation PROCESSED_REVOLVER_LAYER;
    public static final ResourceLocation PROCESSED_CHEMTHROW_LAYER;
    public static final ResourceLocation PROCESSED_DRILL_LAYER;
    public static final ResourceLocation PROCESSED_RAILGUN_LAYER;
    public static final ResourceLocation PROCESSED_SHIELD_LAYER;
    public static final ResourceLocation PROCESSED_BALLOON_LAYER;
    private static final ResourceLocation TEXTURE_STARS;
    private static final TriConsumer<IntConsumer, Boolean, Float> TWILIGHT_TRICONSUMER;
    private static final TriConsumer<IntConsumer, Boolean, Float> FIREFLY_TRICONSUMER;
    private static final TriConsumer<IntConsumer, Boolean, Float> CARMINITE_TRICONSUMER;
    private static final TriConsumer<IntConsumer, Boolean, Float> DEVICE_RED_ENERGY_TRICONSUMER;
    private static final TriConsumer<IntConsumer, Boolean, Float> DEVICE_YELLOW_ENERGY_TRICONSUMER;
    private static final TriConsumer<IntConsumer, Boolean, Float> AURORA_TRICONSUMER;
    private static final TriConsumer<IntConsumer, Boolean, Float> RAM_TRICONSUMER;
    private static final ShaderLayerProvider<?> LAYER_PROVIDER;
    private static final ShaderLayerProvider<?> TOWER_DEVICE_SHADER_PROVIDER;
    private static final ShaderLayerProvider<?> YELLOW_CIRCUIT_SHADER_PROVIDER;
    private static List<ShaderRegistry.ShaderRegistryEntry> SHADERS;
    private static List<ShaderRegistry.ShaderRegistryEntry> NONBOSSES;
    private static final EnumRarity RARITY;
    
    public static void initShaders() {
        IEShaderRegister.NONBOSSES = (List<ShaderRegistry.ShaderRegistryEntry>)ImmutableList.of((Object)registerShaderCases("Twilight", ModType.TWILIGHT_FOREST, "1_4", IEShaderRegister.RARITY, -11770789, -14146241, -16733696, -1, (m, t, s, c) -> new ShaderConsumerLayer(m.provideTex(t, s), -1, IEShaderRegister.TWILIGHT_TRICONSUMER, ShaderManager.Uniforms.STAR_UNIFORMS)).setInfo("Twilight Forest", "Twilight Forest", "twilightforest"), (Object)registerShaderCases("Firefly", ModType.TWILIGHT_FOREST, "1_6", IEShaderRegister.RARITY, -10075840, -681681, -4129024, -4129024, IEShaderRegister.LAYER_PROVIDER, (m, t, s, c) -> new ShaderConsumerLayer(ModType.TWILIGHT_FOREST.provideTex(t, "processed"), -1, IEShaderRegister.FIREFLY_TRICONSUMER, ShaderManager.Uniforms.TIME_UNIFORM)).setInfo("Twilight Forest", "Firefly", "firefly"), (Object)registerShaderCases("Pinch Beetle", ModType.TWILIGHT_FOREST, "1_0", IEShaderRegister.RARITY, -4418777, -14412279, -14412279, -12303292, IEShaderRegister.LAYER_PROVIDER, (m, t, s, c) -> new ShaderCase.ShaderLayer(m.provideTex(t, "1_6"), c)).setInfo("Twilight Forest", "Pinch Beetle", "pinch_beetle"), (Object)registerShaderCases("Snakestone", ModType.TWILIGHT_FOREST, "streaks", IEShaderRegister.RARITY, -6316129, -9934744, -10461088, -1, IEShaderRegister.LAYER_PROVIDER, (m, t, s, c) -> new ShaderCase.ShaderLayer(ModType.TWILIGHT_FOREST.provideTex(t, "scales"), -11513776), (m, t, s, c) -> new ShaderCase.ShaderLayer(ModType.IMMERSIVE_ENGINEERING.provideTex(t, "circuit"), -10987432)).setInfo("Twilight Forest", "Nagastone", "courtyard"), (Object)registerShaderCases("Mazestone", ModType.TWILIGHT_FOREST, "scales", IEShaderRegister.RARITY, -7431794, -11511472, -9405584, -1, IEShaderRegister.LAYER_PROVIDER).setInfo("Twilight Forest", "Mazestone", "mazestone"), (Object)registerShaderCases("Underbrick", ModType.TWILIGHT_FOREST, "scales", IEShaderRegister.RARITY, -8034235, -9011338, -10400461, -1, IEShaderRegister.LAYER_PROVIDER).setInfo("Twilight Forest", "Underbrick", "underbrick"), (Object)registerShaderCasesTopped("Towerwood", ModType.TWILIGHT_FOREST, "1_0", IEShaderRegister.RARITY, -5872326, -664941, -8168907, -1, new ShaderLayerProvider[] { IEShaderRegister.LAYER_PROVIDER, IEShaderRegister.YELLOW_CIRCUIT_SHADER_PROVIDER }, IEShaderRegister.TOWER_DEVICE_SHADER_PROVIDER).setInfo("Twilight Forest", "Towerwood Planks", "towerwood"), (Object)registerShaderCasesTopped("Carminite", ModType.TWILIGHT_FOREST, "carminite", IEShaderRegister.RARITY, -9306112, -65536, -65536, -65536, new ShaderLayerProvider[] { (m, t, s, c) -> new ShaderConsumerLayer(m.provideTex(t, s), -1, IEShaderRegister.CARMINITE_TRICONSUMER, ShaderManager.Uniforms.STAR_UNIFORMS) }, IEShaderRegister.TOWER_DEVICE_SHADER_PROVIDER).setInfo("Twilight Forest", "Carminite", "carminite"), (Object)registerShaderCases("Auroralized", ModType.TWILIGHT_FOREST, "1_5", IEShaderRegister.RARITY, -16711681, -16711936, -16776961, -1, (m, t, s, c) -> new ShaderConsumerLayer(m.provideTex(t, s), -1, IEShaderRegister.AURORA_TRICONSUMER, ShaderManager.Uniforms.TIME_UNIFORM)).setInfo("Twilight Forest", "Aurora Palace", "aurora"), (Object)registerShaderCases("Ironwood", ModType.TWILIGHT_FOREST, "1_0", IEShaderRegister.RARITY, -9739935, -10531520, -10594485, -1, (m, t, s, c) -> new ShaderCase.ShaderLayer(ModType.TWILIGHT_FOREST.provideTex(t, "streaks"), -8815549), IEShaderRegister.LAYER_PROVIDER).setInfo("Twilight Forest", "Ironwood", "ironwood"), (Object)registerShaderCases("Steeleaf", ModType.TWILIGHT_FOREST, "1_0", IEShaderRegister.RARITY, -11368646, -14798316, -12492240, -1, (m, t, s, c) -> new ShaderCase.ShaderLayer(ModType.IMMERSIVE_ENGINEERING.provideTex(t, "1_4"), -12492240), (m, t, s, c) -> new ShaderCase.ShaderLayer(ModType.TWILIGHT_FOREST.provideTex(t, "streaks"), -9592226), IEShaderRegister.LAYER_PROVIDER).setInfo("Twilight Forest", "Steeleaf", "steeleaf"), (Object)registerShaderCases("Knightly", ModType.TWILIGHT_FOREST, "1_0", IEShaderRegister.RARITY, -1573683, -11711413, -8352654, -1, IEShaderRegister.LAYER_PROVIDER).setInfo("Twilight Forest", "Knightly", "knightly"), (Object[])new ShaderRegistry.ShaderRegistryEntry[] { registerShaderCases("Fiery", ModType.TWILIGHT_FOREST, "1_0", IEShaderRegister.RARITY, -15133933, -142243, -8964847, -1, IEShaderRegister.LAYER_PROVIDER).setInfo("Twilight Forest", "Fiery", "fiery"), registerShaderCases("Final Castle", ModType.TWILIGHT_FOREST, "scales", IEShaderRegister.RARITY, -1250586, -3621956, -16711681, -16711681, IEShaderRegister.LAYER_PROVIDER).setInfo("Twilight Forest", "Final Castle", "finalcastle"), registerShaderCases("Cube of Annihilation", ModType.TWILIGHT_FOREST, "1_0", IEShaderRegister.RARITY, -16777213, -15466432, -16777213, -15466432, (m, t, s, c) -> new ShaderCase.ShaderLayer(m.provideTex(t, s), -15466432)).setInfo("Twilight Forest", "Cube of Annilation", "cube_of_annilation") });
        final ImmutableList.Builder<ShaderRegistry.ShaderRegistryEntry> listBuilder = (ImmutableList.Builder<ShaderRegistry.ShaderRegistryEntry>)ImmutableList.builder();
        listBuilder.addAll((Iterable)IEShaderRegister.NONBOSSES);
        listBuilder.add((Object[])new ShaderRegistry.ShaderRegistryEntry[] { registerShaderCases("Questing Ram", ModType.TWILIGHT_FOREST, "streaks", IEShaderRegister.RARITY, -400952, -6650519, -13685962, -7284497, IEShaderRegister.LAYER_PROVIDER, (m, t, s, c) -> new ShaderConsumerLayer(ModType.IMMERSIVE_ENGINEERING.provideTex(t, "circuit"), 814799087, IEShaderRegister.RAM_TRICONSUMER, new ShaderUniform[0])).setInfo("Twilight Forest", "Questing Ram", "questing_ram"), registerShaderCases("Naga", ModType.TWILIGHT_FOREST, "scales", IEShaderRegister.RARITY, -13476571, -15259375, -5909482, -1, IEShaderRegister.LAYER_PROVIDER, (m, t, s, c) -> new ShaderCase.ShaderLayer(ModType.IMMERSIVE_ENGINEERING.provideTex(t, "shark"), -1)).setInfo("Twilight Forest", "Naga Boss", "naga"), registerShaderCases("Lich", ModType.TWILIGHT_FOREST, "1_0", IEShaderRegister.RARITY, -2106932, -3957760, -12974987, -1, IEShaderRegister.LAYER_PROVIDER).setInfo("Twilight Forest", "Twilight Lich Boss", "lich"), registerShaderCases("Minoshroom", ModType.TWILIGHT_FOREST, "1_6", IEShaderRegister.RARITY, -5763054, -5000269, -13374517, -1, IEShaderRegister.LAYER_PROVIDER).setInfo("Twilight Forest", "Minoshroom Miniboss", "minoshroom"), registerShaderCases("Hydra", ModType.TWILIGHT_FOREST, "scales", IEShaderRegister.RARITY, -15455936, -14057365, -980334, -1, IEShaderRegister.LAYER_PROVIDER, (m, t, s, c) -> new ShaderCase.ShaderLayer(ModType.IMMERSIVE_ENGINEERING.provideTex(t, "shark"), -1)).setInfo("Twilight Forest", "Hydra Boss", "hydra"), registerShaderCases("Knight Phantom", ModType.TWILIGHT_FOREST, "1_0", IEShaderRegister.RARITY, -868193019, -13224652, -8758199, -1, IEShaderRegister.LAYER_PROVIDER).setInfo("Twilight Forest", "Knight Phantom Minibosses", "knight_phantom"), registerShaderCases("Ur-Ghast", ModType.TWILIGHT_FOREST, "1_2", IEShaderRegister.RARITY, -394759, -6670537, -11119018, -1, IEShaderRegister.LAYER_PROVIDER).setInfo("Twilight Forest", "Ur-Ghast", "ur-ghast"), registerShaderCases("Alpha Yeti", ModType.TWILIGHT_FOREST, "1_0", IEShaderRegister.RARITY, -197380, -11894578, -14336154, -1, IEShaderRegister.LAYER_PROVIDER).setInfo("Twilight Forest", "Alpha Yeti", "alpha_yeti"), registerShaderCases("Snow Queen", ModType.TWILIGHT_FOREST, "1_0", IEShaderRegister.RARITY, -2294785, -3957760, -16579191, -1, IEShaderRegister.LAYER_PROVIDER).setInfo("Twilight Forest", "Snow Queen", "snow_queen") });
        IEShaderRegister.SHADERS = (List<ShaderRegistry.ShaderRegistryEntry>)listBuilder.build();
    }
    
    public static List<ShaderRegistry.ShaderRegistryEntry> getAllTwilightShaders() {
        return IEShaderRegister.SHADERS;
    }
    
    public static List<ShaderRegistry.ShaderRegistryEntry> getAllNonbossShaders() {
        return IEShaderRegister.NONBOSSES;
    }
    
    @SafeVarargs
    private static ShaderRegistry.ShaderRegistryEntry registerShaderCasesTopped(final String name, final ModType mod, final String overlayType, final EnumRarity rarity, final int bodyColor, final int colorSecondary, final int gripColor, final int colorBlade, final ShaderLayerProvider<? extends ShaderCase.ShaderLayer>[] providers, final ShaderLayerProvider<? extends ShaderCase.ShaderLayer>... extraProviders) {
        ShaderRegistry.registerShader_Item(name, rarity, gripColor, bodyColor, colorSecondary);
        registerShaderCaseRevolver(name, gripColor, bodyColor, colorBlade, rarity, provideFromProviders(mod, CaseType.REVOLVER, overlayType, colorSecondary, providers), provideFromProviders(mod, CaseType.REVOLVER, overlayType, colorSecondary, extraProviders));
        registerShaderCaseChemthrower(name, gripColor, bodyColor, rarity, provideFromProviders(mod, CaseType.CHEMICAL_THROWER, overlayType, colorSecondary, providers), provideFromProviders(mod, CaseType.CHEMICAL_THROWER, overlayType, colorSecondary, extraProviders));
        registerShaderCaseDrill(name, gripColor, bodyColor, colorBlade, rarity, provideFromProviders(mod, CaseType.DRILL, overlayType, colorSecondary, providers), provideFromProviders(mod, CaseType.DRILL, overlayType, colorSecondary, extraProviders));
        registerShaderCaseRailgun(name, gripColor, bodyColor, rarity, provideFromProviders(mod, CaseType.RAILGUN, overlayType, colorSecondary, providers), provideFromProviders(mod, CaseType.RAILGUN, overlayType, colorSecondary, extraProviders));
        registerShaderCaseShield(name, gripColor, bodyColor, rarity, provideFromProviders(mod, CaseType.SHIELD, overlayType, colorSecondary, providers), provideFromProviders(mod, CaseType.SHIELD, overlayType, colorSecondary, extraProviders));
        registerShaderCaseMinecart(name, gripColor, bodyColor, rarity, provideFromProviders(mod, CaseType.MINECART, overlayType, colorSecondary, providers), provideFromProviders(mod, CaseType.MINECART, overlayType + ".png", colorSecondary, extraProviders));
        registerShaderCaseBalloon(name, gripColor, bodyColor, rarity, provideFromProviders(mod, CaseType.BALLOON, overlayType, colorSecondary, providers), provideFromProviders(mod, CaseType.BALLOON, overlayType, colorSecondary, extraProviders));
        for (final ShaderRegistry.IShaderRegistryMethod method : ShaderRegistry.shaderRegistrationMethods) {
            method.apply(name, overlayType, rarity, gripColor, bodyColor, colorSecondary, colorBlade, (String)null, 0);
        }
        return ShaderRegistry.shaderRegistry.get(name).setCrateLoot(false).setBagLoot(false).setInLowerBags(false).setReplicationCost(new IngredientStack(new ItemStack(TFItems.ore_meter)));
    }
    
    @SafeVarargs
    private static ShaderRegistry.ShaderRegistryEntry registerShaderCases(final String name, final ModType type, final String overlayType, final EnumRarity rarity, final int bodyColor, final int colorSecondary, final int gripColor, final int colorBlade, final ShaderLayerProvider<? extends ShaderCase.ShaderLayer>... providers) {
        return registerShaderCasesTopped(name, type, overlayType, rarity, bodyColor, colorSecondary, gripColor, colorBlade, providers, (ShaderLayerProvider<? extends ShaderCase.ShaderLayer>[])new ShaderLayerProvider[0]);
    }
    
    private static ShaderCase.ShaderLayer[] provideFromProviders(final ModType mod, final CaseType type, final String suffix, final int color, final ShaderLayerProvider<? extends ShaderCase.ShaderLayer>[] layerProviders) {
        final ShaderCase.ShaderLayer[] array = new ShaderCase.ShaderLayer[layerProviders.length];
        for (int i = 0; i < layerProviders.length; ++i) {
            array[i] = (ShaderCase.ShaderLayer)layerProviders[i].get(mod, type, suffix, color);
        }
        return array;
    }
    
    private static ShaderCaseRevolver registerShaderCaseRevolver(final String name, final int gripColor, final int bodyColor, final int bladeColor, final EnumRarity rarity, final ShaderCase.ShaderLayer[] additionalLayers, final ShaderCase.ShaderLayer... topLayers) {
        final ImmutableList.Builder<ShaderCase.ShaderLayer> shaderLayerBuilder = (ImmutableList.Builder<ShaderCase.ShaderLayer>)ImmutableList.builder();
        return (ShaderCaseRevolver)ShaderRegistry.registerShaderCase(name, (ShaderCase)new ShaderCaseRevolver((Collection)shaderLayerBuilder.add((Object[])new ShaderCase.ShaderLayer[] { new ShaderCase.ShaderLayer(IEShaderRegister.PROCESSED_REVOLVER_GRIP_LAYER, gripColor), new ShaderCase.ShaderLayer(IEShaderRegister.PROCESSED_REVOLVER_LAYER, bodyColor), new ShaderCase.ShaderLayer(IEShaderRegister.PROCESSED_REVOLVER_LAYER, bladeColor) }).add((Object[])additionalLayers).add((Object)IEShaderRegister.UNCOLORED_REVOLVER_LAYER).add((Object[])topLayers).build()), rarity);
    }
    
    private static ShaderCaseChemthrower registerShaderCaseChemthrower(final String name, final int gripColor, final int bodyColor, final EnumRarity rarity, final ShaderCase.ShaderLayer[] additionalLayers, final ShaderCase.ShaderLayer... topLayers) {
        final ImmutableList.Builder<ShaderCase.ShaderLayer> shaderLayerBuilder = (ImmutableList.Builder<ShaderCase.ShaderLayer>)ImmutableList.builder();
        return (ShaderCaseChemthrower)ShaderRegistry.registerShaderCase(name, (ShaderCase)new TFShaderCaseChemthrower(3 + additionalLayers.length, (Collection<ShaderCase.ShaderLayer>)shaderLayerBuilder.add((Object[])new ShaderCase.ShaderLayer[] { new ShaderCase.ShaderLayer(IEShaderRegister.PROCESSED_CHEMTHROW_LAYER, gripColor), new ShaderCase.ShaderLayer(IEShaderRegister.PROCESSED_CHEMTHROW_LAYER, bodyColor) }).add((Object[])additionalLayers).add((Object)IEShaderRegister.UNCOLORED_CHEMTHROW_LAYER).add((Object[])topLayers).build()), rarity);
    }
    
    private static ShaderCaseDrill registerShaderCaseDrill(final String name, final int gripColor, final int bodyColor, final int bladeColor, final EnumRarity rarity, final ShaderCase.ShaderLayer[] additionalLayers, final ShaderCase.ShaderLayer... topLayers) {
        final ImmutableList.Builder<ShaderCase.ShaderLayer> shaderLayerBuilder = (ImmutableList.Builder<ShaderCase.ShaderLayer>)ImmutableList.builder();
        return (ShaderCaseDrill)ShaderRegistry.registerShaderCase(name, (ShaderCase)new TFShaderCaseDrill(5 + additionalLayers.length, (Collection<ShaderCase.ShaderLayer>)shaderLayerBuilder.add((Object[])new ShaderCase.ShaderLayer[] { new ShaderCase.ShaderLayer(IEShaderRegister.PROCESSED_DRILL_LAYER, gripColor), new ShaderCase.ShaderLayer(IEShaderRegister.PROCESSED_DRILL_LAYER, bodyColor) }).add((Object)IEShaderRegister.UNCOLORED_DRILL_LAYER).add((Object[])additionalLayers).add((Object)IEShaderRegister.UNCOLORED_DRILL_LAYER).add((Object)IEShaderRegister.NULL_LAYER).add((Object[])topLayers).build()), rarity);
    }
    
    private static ShaderCaseRailgun registerShaderCaseRailgun(final String name, final int gripColor, final int bodyColor, final EnumRarity rarity, final ShaderCase.ShaderLayer[] additionalLayers, final ShaderCase.ShaderLayer... topLayers) {
        final ImmutableList.Builder<ShaderCase.ShaderLayer> shaderLayerBuilder = (ImmutableList.Builder<ShaderCase.ShaderLayer>)ImmutableList.builder();
        return (ShaderCaseRailgun)ShaderRegistry.registerShaderCase(name, (ShaderCase)new TFShaderCaseRailgun(3 + additionalLayers.length, (Collection<ShaderCase.ShaderLayer>)shaderLayerBuilder.add((Object[])new ShaderCase.ShaderLayer[] { new ShaderCase.ShaderLayer(IEShaderRegister.PROCESSED_RAILGUN_LAYER, gripColor), new ShaderCase.ShaderLayer(IEShaderRegister.PROCESSED_RAILGUN_LAYER, bodyColor) }).add((Object[])additionalLayers).add((Object)IEShaderRegister.UNCOLORED_RAILGUN_LAYER).add((Object[])topLayers).build()), rarity);
    }
    
    private static ShaderCaseShield registerShaderCaseShield(final String name, final int gripColor, final int bodyColor, final EnumRarity rarity, final ShaderCase.ShaderLayer[] additionalLayers, final ShaderCase.ShaderLayer... topLayers) {
        final ImmutableList.Builder<ShaderCase.ShaderLayer> shaderLayerBuilder = (ImmutableList.Builder<ShaderCase.ShaderLayer>)ImmutableList.builder();
        return (ShaderCaseShield)ShaderRegistry.registerShaderCase(name, (ShaderCase)new TFShaderCaseShield(3 + additionalLayers.length, (Collection<ShaderCase.ShaderLayer>)shaderLayerBuilder.add((Object[])new ShaderCase.ShaderLayer[] { new ShaderCase.ShaderLayer(IEShaderRegister.PROCESSED_SHIELD_LAYER, gripColor), new ShaderCase.ShaderLayer(IEShaderRegister.PROCESSED_SHIELD_LAYER, bodyColor) }).add((Object[])additionalLayers).add((Object)IEShaderRegister.UNCOLORED_SHIELD_LAYER).add((Object[])topLayers).build()), rarity);
    }
    
    private static ShaderCaseMinecart registerShaderCaseMinecart(final String name, final int bodyColor, final int secondaryColor, final EnumRarity rarity, final ShaderCase.ShaderLayer[] additionalLayers, final ShaderCase.ShaderLayer... topLayers) {
        final ImmutableList.Builder<ShaderCase.ShaderLayer> shaderLayerBuilder = (ImmutableList.Builder<ShaderCase.ShaderLayer>)ImmutableList.builder();
        return (ShaderCaseMinecart)ShaderRegistry.registerShaderCase(name, (ShaderCase)new ShaderCaseMinecart((Collection)shaderLayerBuilder.add((Object[])new ShaderCase.ShaderLayer[] { new ShaderCase.ShaderLayer(new ResourceLocation("immersiveengineering", "textures/models/shaders/minecart_0.png"), bodyColor), new ShaderCase.ShaderLayer(new ResourceLocation("immersiveengineering", "textures/models/shaders/minecart_1_0.png"), secondaryColor) }).add((Object[])additionalLayers).add((Object)IEShaderRegister.UNCOLORED_MINECART_LAYER).add((Object[])topLayers).build()), rarity);
    }
    
    private static ShaderCaseBalloon registerShaderCaseBalloon(final String name, final int gripColor, final int bodyColor, final EnumRarity rarity, final ShaderCase.ShaderLayer[] additionalLayers, final ShaderCase.ShaderLayer... topLayers) {
        final ImmutableList.Builder<ShaderCase.ShaderLayer> shaderLayerBuilder = (ImmutableList.Builder<ShaderCase.ShaderLayer>)ImmutableList.builder();
        return (ShaderCaseBalloon)ShaderRegistry.registerShaderCase(name, (ShaderCase)new ShaderCaseBalloon((Collection)shaderLayerBuilder.add((Object[])new ShaderCase.ShaderLayer[] { new ShaderCase.ShaderLayer(IEShaderRegister.PROCESSED_BALLOON_LAYER, gripColor), new ShaderCase.ShaderLayer(IEShaderRegister.PROCESSED_BALLOON_LAYER, bodyColor) }).add((Object[])additionalLayers).add((Object)IEShaderRegister.UNCOLORED_BALLOON_LAYER).add((Object[])topLayers).build()), rarity);
    }
    
    static {
        NULL_LAYER = new ShaderCase.ShaderLayer((ResourceLocation)null, -1);
        UNCOLORED_REVOLVER_LAYER = new ShaderCase.ShaderLayer(new ResourceLocation("immersiveengineering", "revolvers/shaders/revolver_uncoloured"), -1);
        UNCOLORED_CHEMTHROW_LAYER = new ShaderCase.ShaderLayer(new ResourceLocation("immersiveengineering", "items/shaders/chemthrower_uncoloured"), -1);
        UNCOLORED_DRILL_LAYER = new ShaderCase.ShaderLayer(new ResourceLocation("immersiveengineering", "items/shaders/drill_diesel_uncoloured"), -1);
        UNCOLORED_RAILGUN_LAYER = new ShaderCase.ShaderLayer(new ResourceLocation("immersiveengineering", "items/shaders/railgun_uncoloured"), -1);
        UNCOLORED_SHIELD_LAYER = new ShaderCase.ShaderLayer(new ResourceLocation("immersiveengineering", "items/shaders/shield_uncoloured"), -1);
        UNCOLORED_MINECART_LAYER = new ShaderCase.ShaderLayer(new ResourceLocation("immersiveengineering", "textures/models/shaders/minecart_uncoloured.png"), -1);
        UNCOLORED_BALLOON_LAYER = new ShaderCase.ShaderLayer(new ResourceLocation("immersiveengineering", "blocks/shaders/balloon_uncoloured"), -1);
        PROCESSED_REVOLVER_GRIP_LAYER = new ResourceLocation("twilightforest", "items/immersiveengineering/revolver_grip_processed");
        PROCESSED_REVOLVER_LAYER = new ResourceLocation("twilightforest", "items/immersiveengineering/revolver_processed");
        PROCESSED_CHEMTHROW_LAYER = new ResourceLocation("twilightforest", "items/immersiveengineering/chemthrower_processed");
        PROCESSED_DRILL_LAYER = new ResourceLocation("twilightforest", "items/immersiveengineering/drill_processed");
        PROCESSED_RAILGUN_LAYER = new ResourceLocation("twilightforest", "items/immersiveengineering/railgun_processed");
        PROCESSED_SHIELD_LAYER = new ResourceLocation("twilightforest", "items/immersiveengineering/shield_processed");
        PROCESSED_BALLOON_LAYER = new ResourceLocation("twilightforest", "blocks/immersiveengineering/balloon_processed");
        TEXTURE_STARS = new ResourceLocation("textures/entity/end_portal.png");
        TWILIGHT_TRICONSUMER = ((shaderCallback, pre, partialTick) -> {
            if (pre) {
                ShaderManager.useShader(ShaderManager.twilightSkyShader, shaderCallback);
                OpenGlHelper.func_77473_a(OpenGlHelper.field_176096_r);
                Minecraft.func_71410_x().func_110434_K().func_110577_a(IEShaderRegister.TEXTURE_STARS);
                OpenGlHelper.func_77473_a(OpenGlHelper.field_77478_a);
                Minecraft.func_71410_x().func_110434_K().func_110577_a(TextureMap.field_110575_b);
            }
            else {
                ShaderManager.releaseShader();
                OpenGlHelper.func_77473_a(OpenGlHelper.field_77478_a);
                Minecraft.func_71410_x().func_110434_K().func_110577_a(TextureMap.field_110575_b);
            }
        });
        FIREFLY_TRICONSUMER = ((shaderCallback, pre, partialTick) -> {
            if (pre) {
                ShaderManager.useShader(ShaderManager.fireflyShader, shaderCallback);
            }
            else {
                ShaderManager.releaseShader();
            }
        });
        CARMINITE_TRICONSUMER = ((shaderCallback, pre, partialTick) -> {
            if (pre) {
                ShaderManager.useShader(ShaderManager.carminiteShader, shaderCallback);
            }
            else {
                ShaderManager.releaseShader();
            }
        });
        DEVICE_RED_ENERGY_TRICONSUMER = ((shaderCallback, pre, partialTick) -> {
            if (pre) {
                ShaderManager.useShader(ShaderManager.towerDeviceShader, shaderCallback);
            }
            else {
                ShaderManager.releaseShader();
            }
        });
        DEVICE_YELLOW_ENERGY_TRICONSUMER = ((shaderCallback, pre, partialTick) -> {
            if (pre) {
                GlStateManager.func_187421_b(3553, 10240, 9729);
                ShaderManager.useShader(ShaderManager.yellowCircuitShader, shaderCallback);
            }
            else {
                ShaderManager.releaseShader();
                GlStateManager.func_187421_b(3553, 10240, 9728);
            }
        });
        AURORA_TRICONSUMER = ((shaderCallback, pre, partialTick) -> {
            if (pre) {
                ShaderManager.useShader(ShaderManager.auroraShader, shaderCallback);
            }
            else {
                ShaderManager.releaseShader();
            }
        });
        RAM_TRICONSUMER = ((shaderCallback, pre, partialTick) -> ClientUtils.toggleLightmap((boolean)pre, true));
        LAYER_PROVIDER = ((m, t, s, c) -> new ShaderCase.ShaderLayer(m.provideTex(t, s), c));
        TOWER_DEVICE_SHADER_PROVIDER = ((m, t, s, c) -> new ShaderConsumerLayer(ModType.TWILIGHT_FOREST.provideTex(t, "energy"), -1, IEShaderRegister.DEVICE_RED_ENERGY_TRICONSUMER, ShaderManager.Uniforms.STAR_UNIFORMS));
        YELLOW_CIRCUIT_SHADER_PROVIDER = ((m, t, s, c) -> new ShaderConsumerLayer(ModType.IMMERSIVE_ENGINEERING.provideTex(t, "circuit"), -4526590, IEShaderRegister.DEVICE_YELLOW_ENERGY_TRICONSUMER, ShaderManager.Uniforms.STAR_UNIFORMS));
        RARITY = TwilightForestMod.getRarity();
        if (IEShaderRegister.RARITY != EnumRarity.EPIC) {
            ShaderRegistry.rarityWeightMap.put(IEShaderRegister.RARITY, 1);
        }
        initShaders();
    }
    
    private static class ShaderConsumerLayer extends ShaderCase.DynamicShaderLayer
    {
        private final TriConsumer<IntConsumer, Boolean, Float> render;
        private final IntConsumer shaderCallback;
        
        ShaderConsumerLayer(final ResourceLocation texture, final int colour, final TriConsumer<IntConsumer, Boolean, Float> render, final ShaderUniform... shaderParams) {
            super(texture, colour);
            this.render = render;
            this.shaderCallback = (shader -> {
                int i = 0;
                for (int length = shaderParams.length; i < length; ++i) {
                    final ShaderUniform param = shaderParams[i];
                    param.assignUniform(shader);
                }
            });
        }
        
        public void modifyRender(final boolean pre, final float partialTick) {
            this.render.accept((Object)this.shaderCallback, (Object)pre, (Object)partialTick);
        }
    }
    
    public enum ModType
    {
        IMMERSIVE_ENGINEERING("immersiveengineering") {
            @Override
            String getPath(final CaseType caseType, final String suffix) {
                switch (caseType) {
                    case REVOLVER: {
                        return "revolvers/shaders/revolver_" + suffix;
                    }
                    case CHEMICAL_THROWER: {
                        return "items/shaders/chemthrower_" + suffix;
                    }
                    case DRILL: {
                        return "items/shaders/drill_diesel_" + suffix;
                    }
                    case RAILGUN: {
                        return "items/shaders/railgun_" + suffix;
                    }
                    case SHIELD: {
                        return "items/shaders/shield_" + suffix;
                    }
                    case MINECART: {
                        return "textures/models/shaders/minecart_" + suffix + ".png";
                    }
                    case BALLOON: {
                        return "blocks/shaders/balloon_" + suffix;
                    }
                    default: {
                        return "";
                    }
                }
            }
        }, 
        TWILIGHT_FOREST("twilightforest") {
            @Override
            String getPath(final CaseType caseType, final String suffix) {
                switch (caseType) {
                    case REVOLVER: {
                        return "items/immersiveengineering/revolver_" + suffix;
                    }
                    case CHEMICAL_THROWER: {
                        return "items/immersiveengineering/chemthrower_" + suffix;
                    }
                    case DRILL: {
                        return "items/immersiveengineering/drill_" + suffix;
                    }
                    case RAILGUN: {
                        return "items/immersiveengineering/railgun_" + suffix;
                    }
                    case SHIELD: {
                        return "items/immersiveengineering/shield_" + suffix;
                    }
                    case MINECART: {
                        return "textures/model/immersiveengineering/minecart_" + suffix + ".png";
                    }
                    case BALLOON: {
                        return "blocks/immersiveengineering/balloon_" + suffix;
                    }
                    default: {
                        return "";
                    }
                }
            }
            
            @Override
            public ResourceLocation provideTex(final CaseType caseType, final String suffix) {
                if (caseType == CaseType.MINECART && suffix.startsWith("1_")) {
                    return IEShaderRegister$ModType$2.IMMERSIVE_ENGINEERING.provideTex(caseType, suffix);
                }
                return super.provideTex(caseType, suffix);
            }
        };
        
        private final String namespace;
        
        private ModType(final String namespace) {
            this.namespace = namespace;
        }
        
        abstract String getPath(final CaseType p0, final String p1);
        
        public ResourceLocation provideTex(final CaseType caseType, final String suffix) {
            return new ResourceLocation(this.namespace, this.getPath(caseType, suffix));
        }
    }
    
    public enum CaseType
    {
        REVOLVER, 
        CHEMICAL_THROWER, 
        DRILL, 
        RAILGUN, 
        SHIELD, 
        MINECART, 
        BALLOON;
        
        public static CaseType[] everythingButMinecart() {
            return new CaseType[] { CaseType.REVOLVER, CaseType.CHEMICAL_THROWER, CaseType.DRILL, CaseType.RAILGUN, CaseType.SHIELD, CaseType.BALLOON };
        }
    }
    
    @FunctionalInterface
    private interface ShaderLayerProvider<T extends ShaderCase.ShaderLayer>
    {
        T get(final ModType p0, final CaseType p1, final String p2, final int p3);
    }
}
