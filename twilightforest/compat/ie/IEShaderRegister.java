// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.compat.ie;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.RenderType;
import twilightforest.client.shader.ShaderUniform;
import blusunrize.immersiveengineering.api.shader.DynamicShaderLayer;
import twilightforest.TwilightForestMod;
import net.minecraft.client.renderer.texture.AtlasTexture;
import org.lwjgl.opengl.ARBShaderObjects;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.Minecraft;
import blusunrize.immersiveengineering.api.shader.impl.ShaderCaseBalloon;
import blusunrize.immersiveengineering.api.shader.impl.ShaderCaseBanner;
import blusunrize.immersiveengineering.api.shader.impl.ShaderCaseMinecart;
import blusunrize.immersiveengineering.api.shader.impl.ShaderCaseShield;
import blusunrize.immersiveengineering.api.shader.impl.ShaderCaseRailgun;
import blusunrize.immersiveengineering.api.shader.impl.ShaderCaseDrill;
import blusunrize.immersiveengineering.api.shader.impl.ShaderCaseChemthrower;
import blusunrize.immersiveengineering.api.shader.ShaderCase;
import java.util.Collection;
import blusunrize.immersiveengineering.api.shader.impl.ShaderCaseRevolver;
import java.util.Iterator;
import net.minecraft.item.crafting.Ingredient;
import twilightforest.item.TFItems;
import net.minecraft.util.IItemProvider;
import blusunrize.immersiveengineering.api.crafting.IngredientWithSize;
import java.util.Locale;
import twilightforest.client.shader.ShaderManager;
import com.google.common.collect.ImmutableList;
import net.minecraft.item.Rarity;
import blusunrize.immersiveengineering.api.shader.ShaderRegistry;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.function.BiConsumer;
import net.minecraft.util.ResourceLocation;
import blusunrize.immersiveengineering.api.shader.ShaderLayer;

public class IEShaderRegister
{
    private static final ShaderLayer NULL_LAYER;
    private static final ShaderLayer UNCOLORED_REVOLVER_LAYER;
    private static final ShaderLayer UNCOLORED_CHEMTHROW_LAYER;
    private static final ShaderLayer UNCOLORED_DRILL_LAYER;
    private static final ShaderLayer UNCOLORED_RAILGUN_LAYER;
    private static final ShaderLayer UNCOLORED_SHIELD_LAYER;
    private static final ShaderLayer UNCOLORED_MINECART_LAYER;
    private static final ShaderLayer UNCOLORED_BALLOON_LAYER;
    private static final ShaderLayer UNCOLORED_BANNER_LAYER;
    public static final ResourceLocation PROCESSED_REVOLVER_GRIP_LAYER;
    public static final ResourceLocation PROCESSED_REVOLVER_LAYER;
    public static final ResourceLocation PROCESSED_CHEMTHROW_LAYER;
    public static final ResourceLocation PROCESSED_DRILL_LAYER;
    public static final ResourceLocation PROCESSED_RAILGUN_LAYER;
    public static final ResourceLocation PROCESSED_SHIELD_LAYER;
    public static final ResourceLocation PROCESSED_BALLOON_LAYER;
    private static final ResourceLocation TEXTURE_STARS;
    private static final BiConsumer<IntConsumer, Boolean> TWILIGHT_TRICONSUMER;
    private static final BiConsumer<IntConsumer, Boolean> FIREFLY_TRICONSUMER;
    private static final BiConsumer<IntConsumer, Boolean> CARMINITE_TRICONSUMER;
    private static final BiConsumer<IntConsumer, Boolean> DEVICE_RED_ENERGY_TRICONSUMER;
    private static final BiConsumer<IntConsumer, Boolean> DEVICE_YELLOW_ENERGY_TRICONSUMER;
    private static final BiConsumer<IntConsumer, Boolean> AURORA_TRICONSUMER;
    private static final BiConsumer<IntConsumer, Boolean> RAM_TRICONSUMER;
    private static final ShaderLayerProvider<?> LAYER_PROVIDER;
    private static final ShaderLayerProvider<?> TOWER_DEVICE_SHADER_PROVIDER;
    private static final ShaderLayerProvider<?> YELLOW_CIRCUIT_SHADER_PROVIDER;
    private static List<ShaderRegistry.ShaderRegistryEntry> SHADERS;
    private static List<ShaderRegistry.ShaderRegistryEntry> NONBOSSES;
    private static final Rarity RARITY;
    
    public static void initShaders() {
        IEShaderRegister.NONBOSSES = (List<ShaderRegistry.ShaderRegistryEntry>)ImmutableList.of((Object)registerShaderCases("Pinch Beetle", ModType.IMMERSIVE_ENGINEERING, "1_0", IEShaderRegister.RARITY, -4418777, -14412279, -14412279, -12303292, IEShaderRegister.LAYER_PROVIDER, (m, t, s, c) -> new ShaderLayer(m.provideTex(t, "1_6"), c)).setInfo("Twilight Forest", "Pinch Beetle", "pinch_beetle"), (Object)registerShaderCases("Snakestone", ModType.TWILIGHT_FOREST, "streaks", IEShaderRegister.RARITY, -6316129, -9934744, -10461088, -1, IEShaderRegister.LAYER_PROVIDER, (m, t, s, c) -> new ShaderLayer(ModType.TWILIGHT_FOREST.provideTex(t, "scales"), -11513776), (m, t, s, c) -> new ShaderLayer(ModType.IMMERSIVE_ENGINEERING.provideTex(t, "circuit"), -10987432)).setInfo("Twilight Forest", "Nagastone", "courtyard"), (Object)registerShaderCases("Mazestone", ModType.TWILIGHT_FOREST, "scales", IEShaderRegister.RARITY, -7431794, -11511472, -9405584, -1, IEShaderRegister.LAYER_PROVIDER).setInfo("Twilight Forest", "Mazestone", "mazestone"), (Object)registerShaderCases("Underbrick", ModType.TWILIGHT_FOREST, "scales", IEShaderRegister.RARITY, -8034235, -9011338, -10400461, -1, IEShaderRegister.LAYER_PROVIDER).setInfo("Twilight Forest", "Underbrick", "underbrick"), (Object)registerShaderCases("Ironwood", ModType.IMMERSIVE_ENGINEERING, "1_0", IEShaderRegister.RARITY, -9739935, -10531520, -10594485, -1, (m, t, s, c) -> new ShaderLayer(ModType.TWILIGHT_FOREST.provideTex(t, "streaks"), -8815549), IEShaderRegister.LAYER_PROVIDER).setInfo("Twilight Forest", "Ironwood", "ironwood"), (Object)registerShaderCases("Steeleaf", ModType.IMMERSIVE_ENGINEERING, "1_0", IEShaderRegister.RARITY, -11368646, -14798316, -12492240, -1, (m, t, s, c) -> new ShaderLayer(ModType.IMMERSIVE_ENGINEERING.provideTex(t, "1_4"), -12492240), (m, t, s, c) -> new ShaderLayer(ModType.TWILIGHT_FOREST.provideTex(t, "streaks"), -9592226), IEShaderRegister.LAYER_PROVIDER).setInfo("Twilight Forest", "Steeleaf", "steeleaf"), (Object)registerShaderCases("Knightly", ModType.IMMERSIVE_ENGINEERING, "1_0", IEShaderRegister.RARITY, -1573683, -11711413, -8352654, -1, IEShaderRegister.LAYER_PROVIDER).setInfo("Twilight Forest", "Knightly", "knightly"), (Object)registerShaderCases("Fiery", ModType.IMMERSIVE_ENGINEERING, "1_0", IEShaderRegister.RARITY, -15133933, -142243, -8964847, -1, IEShaderRegister.LAYER_PROVIDER).setInfo("Twilight Forest", "Fiery", "fiery"), (Object)registerShaderCases("Final Castle", ModType.TWILIGHT_FOREST, "scales", IEShaderRegister.RARITY, -1250586, -3621956, -16711681, -16711681, IEShaderRegister.LAYER_PROVIDER).setInfo("Twilight Forest", "Final Castle", "finalcastle"), (Object)registerShaderCases("Cube of Annihilation", ModType.IMMERSIVE_ENGINEERING, "1_0", IEShaderRegister.RARITY, -16777213, -15466432, -16777213, -15466432, (m, t, s, c) -> new ShaderLayer(m.provideTex(t, s), -15466432)).setInfo("Twilight Forest", "Cube of Annilation", "cube_of_annilation"));
        final ImmutableList.Builder<ShaderRegistry.ShaderRegistryEntry> listBuilder = (ImmutableList.Builder<ShaderRegistry.ShaderRegistryEntry>)ImmutableList.builder();
        listBuilder.addAll((Iterable)IEShaderRegister.NONBOSSES);
        listBuilder.add((Object[])new ShaderRegistry.ShaderRegistryEntry[] { registerShaderCases("Questing Ram", ModType.TWILIGHT_FOREST, "streaks", IEShaderRegister.RARITY, -400952, -6650519, -13685962, -7284497, IEShaderRegister.LAYER_PROVIDER, (m, t, s, c) -> new ShaderConsumerLayer(ModType.IMMERSIVE_ENGINEERING.provideTex(t, "circuit"), 814799087, IEShaderRegister.RAM_TRICONSUMER, ShaderManager.Uniforms.STAR_UNIFORMS)).setInfo("Twilight Forest", "Questing Ram", "questing_ram"), registerShaderCases("Naga", ModType.TWILIGHT_FOREST, "scales", IEShaderRegister.RARITY, -13476571, -15259375, -5909482, -1, IEShaderRegister.LAYER_PROVIDER, (m, t, s, c) -> new ShaderLayer(ModType.IMMERSIVE_ENGINEERING.provideTex(t, "shark"), -1)).setInfo("Twilight Forest", "Naga Boss", "naga"), registerShaderCases("Lich", ModType.IMMERSIVE_ENGINEERING, "1_0", IEShaderRegister.RARITY, -2106932, -3957760, -12974987, -1, IEShaderRegister.LAYER_PROVIDER).setInfo("Twilight Forest", "Twilight Lich Boss", "lich"), registerShaderCases("Minoshroom", ModType.IMMERSIVE_ENGINEERING, "1_6", IEShaderRegister.RARITY, -5763054, -5000269, -13374517, -1, IEShaderRegister.LAYER_PROVIDER).setInfo("Twilight Forest", "Minoshroom Miniboss", "minoshroom"), registerShaderCases("Hydra", ModType.TWILIGHT_FOREST, "scales", IEShaderRegister.RARITY, -15455936, -14057365, -980334, -1, IEShaderRegister.LAYER_PROVIDER, (m, t, s, c) -> new ShaderLayer(ModType.IMMERSIVE_ENGINEERING.provideTex(t, "shark"), -1)).setInfo("Twilight Forest", "Hydra Boss", "hydra"), registerShaderCases("Knight Phantom", ModType.IMMERSIVE_ENGINEERING, "1_0", IEShaderRegister.RARITY, -868193019, -13224652, -8758199, -1, IEShaderRegister.LAYER_PROVIDER).setInfo("Twilight Forest", "Knight Phantom Minibosses", "knight_phantom"), registerShaderCases("Ur-Ghast", ModType.IMMERSIVE_ENGINEERING, "1_2", IEShaderRegister.RARITY, -394759, -6670537, -11119018, -1, IEShaderRegister.LAYER_PROVIDER).setInfo("Twilight Forest", "Ur-Ghast", "ur-ghast"), registerShaderCases("Alpha Yeti", ModType.IMMERSIVE_ENGINEERING, "1_0", IEShaderRegister.RARITY, -197380, -11894578, -14336154, -1, IEShaderRegister.LAYER_PROVIDER).setInfo("Twilight Forest", "Alpha Yeti", "alpha_yeti"), registerShaderCases("Snow Queen", ModType.IMMERSIVE_ENGINEERING, "1_0", IEShaderRegister.RARITY, -2294785, -3957760, -16579191, -1, IEShaderRegister.LAYER_PROVIDER).setInfo("Twilight Forest", "Snow Queen", "snow_queen") });
        IEShaderRegister.SHADERS = (List<ShaderRegistry.ShaderRegistryEntry>)listBuilder.build();
    }
    
    public static List<ShaderRegistry.ShaderRegistryEntry> getAllTwilightShaders() {
        return IEShaderRegister.SHADERS;
    }
    
    public static List<ShaderRegistry.ShaderRegistryEntry> getAllNonbossShaders() {
        return IEShaderRegister.NONBOSSES;
    }
    
    @SafeVarargs
    private static ShaderRegistry.ShaderRegistryEntry registerShaderCasesTopped(final String name, final ModType mod, final String overlayType, final Rarity rarity, final int bodyColor, final int colorSecondary, final int gripColor, final int colorBlade, final ShaderLayerProvider<? extends ShaderLayer>[] providers, final ShaderLayerProvider<? extends ShaderLayer>... extraProviders) {
        final ResourceLocation modName = new ResourceLocation("twilightforest", name.toLowerCase(Locale.ROOT).replace(" ", "_"));
        ShaderRegistry.registerShader_Item(modName, rarity, gripColor, bodyColor, colorSecondary);
        registerShaderCaseRevolver(modName, gripColor, bodyColor, colorBlade, rarity, provideFromProviders(mod, CaseType.REVOLVER, overlayType, colorSecondary, providers), provideFromProviders(mod, CaseType.REVOLVER, overlayType, colorSecondary, extraProviders));
        registerShaderCaseChemthrower(modName, gripColor, bodyColor, rarity, provideFromProviders(mod, CaseType.CHEMICAL_THROWER, overlayType, colorSecondary, providers), provideFromProviders(mod, CaseType.CHEMICAL_THROWER, overlayType, colorSecondary, extraProviders));
        registerShaderCaseDrill(modName, gripColor, bodyColor, colorBlade, rarity, provideFromProviders(mod, CaseType.DRILL, overlayType, colorSecondary, providers), provideFromProviders(mod, CaseType.DRILL, overlayType, colorSecondary, extraProviders));
        registerShaderCaseRailgun(modName, gripColor, bodyColor, rarity, provideFromProviders(mod, CaseType.RAILGUN, overlayType, colorSecondary, providers), provideFromProviders(mod, CaseType.RAILGUN, overlayType, colorSecondary, extraProviders));
        registerShaderCaseShield(modName, gripColor, bodyColor, rarity, provideFromProviders(mod, CaseType.SHIELD, overlayType, colorSecondary, providers), provideFromProviders(mod, CaseType.SHIELD, overlayType, colorSecondary, extraProviders));
        registerShaderCaseMinecart(modName, gripColor, bodyColor, rarity, provideFromProviders(mod, CaseType.MINECART, overlayType, colorSecondary, providers), provideFromProviders(mod, CaseType.MINECART, overlayType + ".png", colorSecondary, extraProviders));
        registerShaderCaseBalloon(modName, gripColor, bodyColor, rarity, provideFromProviders(mod, CaseType.BALLOON, overlayType, colorSecondary, providers), provideFromProviders(mod, CaseType.BALLOON, overlayType, colorSecondary, extraProviders));
        registerShaderCaseBanner(modName, gripColor, bodyColor, rarity, provideFromProviders(mod, CaseType.BALLOON, overlayType, colorSecondary, providers), provideFromProviders(mod, CaseType.BANNER, overlayType, colorSecondary, extraProviders));
        for (final ShaderRegistry.IShaderRegistryMethod method : ShaderRegistry.shaderRegistrationMethods) {
            method.apply(modName, overlayType, rarity, gripColor, bodyColor, colorSecondary, colorBlade, (String)null, 0);
        }
        return ShaderRegistry.shaderRegistry.get(modName).setCrateLoot(false).setBagLoot(false).setInLowerBags(false).setReplicationCost(() -> {
            new IngredientWithSize(Ingredient.func_199804_a(new IItemProvider[] { (IItemProvider)TFItems.ore_meter.get() }));
            return;
        });
    }
    
    @SafeVarargs
    private static ShaderRegistry.ShaderRegistryEntry registerShaderCases(final String name, final ModType type, final String overlayType, final Rarity rarity, final int bodyColor, final int colorSecondary, final int gripColor, final int colorBlade, final ShaderLayerProvider<? extends ShaderLayer>... providers) {
        return registerShaderCasesTopped(name, type, overlayType, rarity, bodyColor, colorSecondary, gripColor, colorBlade, providers, (ShaderLayerProvider<? extends ShaderLayer>[])new ShaderLayerProvider[0]);
    }
    
    private static ShaderLayer[] provideFromProviders(final ModType mod, final CaseType type, final String suffix, final int color, final ShaderLayerProvider<? extends ShaderLayer>[] layerProviders) {
        final ShaderLayer[] array = new ShaderLayer[layerProviders.length];
        for (int i = 0; i < layerProviders.length; ++i) {
            array[i] = (ShaderLayer)layerProviders[i].get(mod, type, suffix, color);
        }
        return array;
    }
    
    private static ShaderCaseRevolver registerShaderCaseRevolver(final ResourceLocation name, final int gripColor, final int bodyColor, final int bladeColor, final Rarity rarity, final ShaderLayer[] additionalLayers, final ShaderLayer... topLayers) {
        final ImmutableList.Builder<ShaderLayer> shaderLayerBuilder = (ImmutableList.Builder<ShaderLayer>)ImmutableList.builder();
        return (ShaderCaseRevolver)ShaderRegistry.registerShaderCase(name, (ShaderCase)new ShaderCaseRevolver((Collection)shaderLayerBuilder.add((Object[])new ShaderLayer[] { new ShaderLayer(IEShaderRegister.PROCESSED_REVOLVER_GRIP_LAYER, gripColor), new ShaderLayer(IEShaderRegister.PROCESSED_REVOLVER_LAYER, bodyColor), new ShaderLayer(IEShaderRegister.PROCESSED_REVOLVER_LAYER, bladeColor) }).add((Object[])additionalLayers).add((Object)IEShaderRegister.UNCOLORED_REVOLVER_LAYER).add((Object[])topLayers).build()), rarity);
    }
    
    private static ShaderCaseChemthrower registerShaderCaseChemthrower(final ResourceLocation name, final int gripColor, final int bodyColor, final Rarity rarity, final ShaderLayer[] additionalLayers, final ShaderLayer... topLayers) {
        final ImmutableList.Builder<ShaderLayer> shaderLayerBuilder = (ImmutableList.Builder<ShaderLayer>)ImmutableList.builder();
        return (ShaderCaseChemthrower)ShaderRegistry.registerShaderCase(name, (ShaderCase)new TFShaderCaseChemthrower(3 + additionalLayers.length, (Collection<ShaderLayer>)shaderLayerBuilder.add((Object[])new ShaderLayer[] { new ShaderLayer(IEShaderRegister.PROCESSED_CHEMTHROW_LAYER, gripColor), new ShaderLayer(IEShaderRegister.PROCESSED_CHEMTHROW_LAYER, bodyColor) }).add((Object[])additionalLayers).add((Object)IEShaderRegister.UNCOLORED_CHEMTHROW_LAYER).add((Object[])topLayers).build()), rarity);
    }
    
    private static ShaderCaseDrill registerShaderCaseDrill(final ResourceLocation name, final int gripColor, final int bodyColor, final int bladeColor, final Rarity rarity, final ShaderLayer[] additionalLayers, final ShaderLayer... topLayers) {
        final ImmutableList.Builder<ShaderLayer> shaderLayerBuilder = (ImmutableList.Builder<ShaderLayer>)ImmutableList.builder();
        return (ShaderCaseDrill)ShaderRegistry.registerShaderCase(name, (ShaderCase)new TFShaderCaseDrill(5 + additionalLayers.length, (Collection<ShaderLayer>)shaderLayerBuilder.add((Object[])new ShaderLayer[] { new ShaderLayer(IEShaderRegister.PROCESSED_DRILL_LAYER, gripColor), new ShaderLayer(IEShaderRegister.PROCESSED_DRILL_LAYER, bodyColor) }).add((Object)IEShaderRegister.UNCOLORED_DRILL_LAYER).add((Object[])additionalLayers).add((Object)IEShaderRegister.UNCOLORED_DRILL_LAYER).add((Object)IEShaderRegister.NULL_LAYER).add((Object[])topLayers).build()), rarity);
    }
    
    private static ShaderCaseRailgun registerShaderCaseRailgun(final ResourceLocation name, final int gripColor, final int bodyColor, final Rarity rarity, final ShaderLayer[] additionalLayers, final ShaderLayer... topLayers) {
        final ImmutableList.Builder<ShaderLayer> shaderLayerBuilder = (ImmutableList.Builder<ShaderLayer>)ImmutableList.builder();
        return (ShaderCaseRailgun)ShaderRegistry.registerShaderCase(name, (ShaderCase)new TFShaderCaseRailgun(3 + additionalLayers.length, (Collection<ShaderLayer>)shaderLayerBuilder.add((Object[])new ShaderLayer[] { new ShaderLayer(IEShaderRegister.PROCESSED_RAILGUN_LAYER, gripColor), new ShaderLayer(IEShaderRegister.PROCESSED_RAILGUN_LAYER, bodyColor) }).add((Object[])additionalLayers).add((Object)IEShaderRegister.UNCOLORED_RAILGUN_LAYER).add((Object[])topLayers).build()), rarity);
    }
    
    private static ShaderCaseShield registerShaderCaseShield(final ResourceLocation name, final int gripColor, final int bodyColor, final Rarity rarity, final ShaderLayer[] additionalLayers, final ShaderLayer... topLayers) {
        final ImmutableList.Builder<ShaderLayer> shaderLayerBuilder = (ImmutableList.Builder<ShaderLayer>)ImmutableList.builder();
        return (ShaderCaseShield)ShaderRegistry.registerShaderCase(name, (ShaderCase)new TFShaderCaseShield(3 + additionalLayers.length, (Collection<ShaderLayer>)shaderLayerBuilder.add((Object[])new ShaderLayer[] { new ShaderLayer(IEShaderRegister.PROCESSED_SHIELD_LAYER, gripColor), new ShaderLayer(IEShaderRegister.PROCESSED_SHIELD_LAYER, bodyColor) }).add((Object[])additionalLayers).add((Object)IEShaderRegister.UNCOLORED_SHIELD_LAYER).add((Object[])topLayers).build()), rarity);
    }
    
    private static ShaderCaseMinecart registerShaderCaseMinecart(final ResourceLocation name, final int bodyColor, final int secondaryColor, final Rarity rarity, final ShaderLayer[] additionalLayers, final ShaderLayer... topLayers) {
        final ImmutableList.Builder<ShaderLayer> shaderLayerBuilder = (ImmutableList.Builder<ShaderLayer>)ImmutableList.builder();
        return (ShaderCaseMinecart)ShaderRegistry.registerShaderCase(name, (ShaderCase)new ShaderCaseMinecart((Collection)shaderLayerBuilder.add((Object[])new ShaderLayer[] { new ShaderLayer(new ResourceLocation("immersiveengineering", "textures/models/shaders/minecart_0.png"), bodyColor), new ShaderLayer(new ResourceLocation("immersiveengineering", "textures/models/shaders/minecart_1_0.png"), secondaryColor) }).add((Object[])additionalLayers).add((Object)IEShaderRegister.UNCOLORED_MINECART_LAYER).add((Object[])topLayers).build()), rarity);
    }
    
    public static ShaderCaseBanner registerShaderCaseBanner(final ResourceLocation name, final int bodyColor, final int secondaryColor, final Rarity rarity, final ShaderLayer[] additionalLayers, final ShaderLayer... topLayers) {
        final ImmutableList.Builder<ShaderLayer> shaderLayerBuilder = (ImmutableList.Builder<ShaderLayer>)ImmutableList.builder();
        return (ShaderCaseBanner)ShaderRegistry.registerShaderCase(name, (ShaderCase)new ShaderCaseBanner((Collection)shaderLayerBuilder.add((Object[])new ShaderLayer[] { new ShaderLayer(new ResourceLocation("immersiveengineering", "block/shaders/banner_0"), bodyColor), new ShaderLayer(new ResourceLocation("immersiveengineering", "block/shaders/banner_1_0"), secondaryColor) }).add((Object[])additionalLayers).add((Object)IEShaderRegister.UNCOLORED_BANNER_LAYER).add((Object[])topLayers).build()), rarity);
    }
    
    private static ShaderCaseBalloon registerShaderCaseBalloon(final ResourceLocation name, final int gripColor, final int bodyColor, final Rarity rarity, final ShaderLayer[] additionalLayers, final ShaderLayer... topLayers) {
        final ImmutableList.Builder<ShaderLayer> shaderLayerBuilder = (ImmutableList.Builder<ShaderLayer>)ImmutableList.builder();
        return (ShaderCaseBalloon)ShaderRegistry.registerShaderCase(name, (ShaderCase)new ShaderCaseBalloon((Collection)shaderLayerBuilder.add((Object[])new ShaderLayer[] { new ShaderLayer(IEShaderRegister.PROCESSED_BALLOON_LAYER, gripColor), new ShaderLayer(IEShaderRegister.PROCESSED_BALLOON_LAYER, bodyColor) }).add((Object[])additionalLayers).add((Object)IEShaderRegister.UNCOLORED_BALLOON_LAYER).add((Object[])topLayers).build()), rarity);
    }
    
    static {
        NULL_LAYER = new ShaderLayer((ResourceLocation)null, -1);
        UNCOLORED_REVOLVER_LAYER = new ShaderLayer(new ResourceLocation("immersiveengineering", "revolvers/shaders/revolver_uncoloured"), -1);
        UNCOLORED_CHEMTHROW_LAYER = new ShaderLayer(new ResourceLocation("immersiveengineering", "item/shaders/chemthrower_uncoloured"), -1);
        UNCOLORED_DRILL_LAYER = new ShaderLayer(new ResourceLocation("immersiveengineering", "item/shaders/drill_diesel_uncoloured"), -1);
        UNCOLORED_RAILGUN_LAYER = new ShaderLayer(new ResourceLocation("immersiveengineering", "item/shaders/railgun_uncoloured"), -1);
        UNCOLORED_SHIELD_LAYER = new ShaderLayer(new ResourceLocation("immersiveengineering", "item/shaders/shield_uncoloured"), -1);
        UNCOLORED_MINECART_LAYER = new ShaderLayer(new ResourceLocation("immersiveengineering", "textures/models/shaders/minecart_uncoloured.png"), -1);
        UNCOLORED_BALLOON_LAYER = new ShaderLayer(new ResourceLocation("immersiveengineering", "block/shaders/balloon_uncoloured"), -1);
        UNCOLORED_BANNER_LAYER = new ShaderLayer(new ResourceLocation("immersiveengineering", "block/shaders/banner_uncoloured"), -1);
        PROCESSED_REVOLVER_GRIP_LAYER = new ResourceLocation("immersiveengineering", "revolvers/shaders/revolver_grip");
        PROCESSED_REVOLVER_LAYER = new ResourceLocation("immersiveengineering", "revolvers/shaders/revolver_0");
        PROCESSED_CHEMTHROW_LAYER = new ResourceLocation("immersiveengineering", "item/shaders/chemthrower_0");
        PROCESSED_DRILL_LAYER = new ResourceLocation("immersiveengineering", "item/shaders/drill_diesel_0");
        PROCESSED_RAILGUN_LAYER = new ResourceLocation("immersiveengineering", "item/shaders/railgun_0");
        PROCESSED_SHIELD_LAYER = new ResourceLocation("immersiveengineering", "item/shaders/shield_0");
        PROCESSED_BALLOON_LAYER = new ResourceLocation("immersiveengineering", "block/shaders/balloon_0");
        TEXTURE_STARS = new ResourceLocation("textures/entity/end_portal.png");
        TWILIGHT_TRICONSUMER = ((shaderCallback, pre) -> {
            if (pre) {
                ShaderManager.useShader(ShaderManager.twilightSkyShader, shaderCallback);
                ARBShaderObjects.glCreateShaderObjectARB(35667);
                Minecraft.func_71410_x().func_110434_K().func_110577_a(IEShaderRegister.TEXTURE_STARS);
            }
            else {
                ShaderManager.releaseShader();
            }
            ARBShaderObjects.glCreateShaderObjectARB(35720);
            Minecraft.func_71410_x().func_110434_K().func_110577_a(AtlasTexture.field_110575_b);
            return;
        });
        FIREFLY_TRICONSUMER = ((shaderCallback, pre) -> {
            if (pre) {
                ShaderManager.useShader(ShaderManager.fireflyShader, shaderCallback);
            }
            else {
                ShaderManager.releaseShader();
            }
            return;
        });
        CARMINITE_TRICONSUMER = ((shaderCallback, pre) -> {
            if (pre) {
                ShaderManager.useShader(ShaderManager.carminiteShader, shaderCallback);
            }
            else {
                ShaderManager.releaseShader();
            }
            return;
        });
        DEVICE_RED_ENERGY_TRICONSUMER = ((shaderCallback, pre) -> {
            if (pre) {
                ShaderManager.useShader(ShaderManager.towerDeviceShader, shaderCallback);
            }
            else {
                ShaderManager.releaseShader();
            }
            return;
        });
        DEVICE_YELLOW_ENERGY_TRICONSUMER = ((shaderCallback, pre) -> {
            if (pre) {
                GlStateManager.func_227692_c_(3553, 10240, 9729);
                ShaderManager.useShader(ShaderManager.yellowCircuitShader, shaderCallback);
            }
            else {
                ShaderManager.releaseShader();
                GlStateManager.func_227692_c_(3553, 10240, 9728);
            }
            return;
        });
        AURORA_TRICONSUMER = ((shaderCallback, pre) -> {
            if (pre) {
                ShaderManager.useShader(ShaderManager.auroraShader, shaderCallback);
            }
            else {
                ShaderManager.releaseShader();
            }
            return;
        });
        RAM_TRICONSUMER = ((shaderCallback, pre) -> {
            if (pre) {
                Minecraft.func_71410_x().field_71460_t.func_228384_l_().func_205108_b();
            }
            else {
                Minecraft.func_71410_x().field_71460_t.func_228384_l_().func_205109_c();
            }
            return;
        });
        LAYER_PROVIDER = ((m, t, s, c) -> new ShaderLayer(m.provideTex(t, s), c));
        TOWER_DEVICE_SHADER_PROVIDER = ((m, t, s, c) -> new ShaderConsumerLayer(ModType.TWILIGHT_FOREST.provideTex(t, "energy"), -1, IEShaderRegister.DEVICE_RED_ENERGY_TRICONSUMER, ShaderManager.Uniforms.STAR_UNIFORMS));
        YELLOW_CIRCUIT_SHADER_PROVIDER = ((m, t, s, c) -> new ShaderConsumerLayer(ModType.IMMERSIVE_ENGINEERING.provideTex(t, "circuit"), -4526590, IEShaderRegister.DEVICE_YELLOW_ENERGY_TRICONSUMER, ShaderManager.Uniforms.STAR_UNIFORMS));
        RARITY = TwilightForestMod.getRarity();
    }
    
    private static class ShaderConsumerLayer extends DynamicShaderLayer
    {
        private final BiConsumer<IntConsumer, Boolean> render;
        private final IntConsumer shaderCallback;
        
        ShaderConsumerLayer(final ResourceLocation texture, final int colour, final BiConsumer<IntConsumer, Boolean> render, final ShaderUniform[] shaderParams) {
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
        
        @OnlyIn(Dist.CLIENT)
        public RenderType getRenderType(final RenderType baseType) {
            if (this.render == null) {
                return baseType;
            }
            return new RenderType("shader_" + baseType + this.render, DefaultVertexFormats.field_176600_a, 7, 256, false, true, () -> {
                baseType.func_228547_a_();
                this.render.accept(this.shaderCallback, true);
            }, () -> {
                this.render.accept(this.shaderCallback, false);
                baseType.func_228549_b_();
            }) {};
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
                        return "item/shaders/chemthrower_" + suffix;
                    }
                    case DRILL: {
                        return "item/shaders/drill_diesel_" + suffix;
                    }
                    case RAILGUN: {
                        return "item/shaders/railgun_" + suffix;
                    }
                    case SHIELD: {
                        return "item/shaders/shield_" + suffix;
                    }
                    case MINECART: {
                        return "textures/models/shaders/minecart_" + suffix + ".png";
                    }
                    case BALLOON: {
                        return "block/shaders/balloon_" + suffix;
                    }
                    case BANNER: {
                        return "block/shaders/banner_" + suffix;
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
                        return "block/immersiveengineering/balloon_" + suffix;
                    }
                    case BANNER: {
                        return "block/immersiveengineering/banner_" + suffix;
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
        BALLOON, 
        BANNER;
        
        public static CaseType[] everythingButMinecart() {
            return new CaseType[] { CaseType.REVOLVER, CaseType.CHEMICAL_THROWER, CaseType.DRILL, CaseType.RAILGUN, CaseType.SHIELD, CaseType.BALLOON, CaseType.BANNER };
        }
    }
    
    @FunctionalInterface
    private interface ShaderLayerProvider<T extends ShaderLayer>
    {
        T get(final ModType p0, final CaseType p1, final String p2, final int p3);
    }
}
