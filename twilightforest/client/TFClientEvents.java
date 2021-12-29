// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import twilightforest.client.renderer.TFWeatherRenderer;
import net.minecraft.world.World;
import twilightforest.world.TFWorld;
import twilightforest.block.TFBlocks;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.client.settings.GameSettings;
import twilightforest.TFConfig;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraft.entity.EntityLivingBase;
import twilightforest.TFEventListener;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.renderer.texture.TextureMap;
import twilightforest.compat.ie.IEShaderRegister;
import twilightforest.compat.TFCompat;
import twilightforest.client.texture.GradientMappedTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import twilightforest.client.texture.MoltenFieryTexture;
import twilightforest.block.RegisterBlockEvent;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import twilightforest.client.texture.GradientNode;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(modid = "twilightforest", value = { Side.CLIENT })
public class TFClientEvents
{
    public static final GradientNode[] KNIGHTMETAL_GRADIENT_MAP;
    public static final GradientNode[] FIERY_ESSENCE_GRADIENT_MAP;
    public static final GradientNode[] EASY_GRAYSCALING_MAP;
    public static int time;
    private static int rotationTickerI;
    private static int sineTickerI;
    public static float rotationTicker;
    public static float sineTicker;
    public static final float PI = 3.1415927f;
    private static final int SINE_TICKER_BOUND = 627;
    
    @SubscribeEvent
    public static void texStitch(final TextureStitchEvent.Pre evt) {
        final TextureMap map = evt.getMap();
        map.func_174942_a(new ResourceLocation("twilightforest", "particles/snow_0"));
        map.func_174942_a(new ResourceLocation("twilightforest", "particles/snow_1"));
        map.func_174942_a(new ResourceLocation("twilightforest", "particles/snow_2"));
        map.func_174942_a(new ResourceLocation("twilightforest", "particles/snow_3"));
        map.func_174942_a(new ResourceLocation("twilightforest", "particles/annihilate_particle"));
        map.func_174942_a(new ResourceLocation("twilightforest", "particles/firefly"));
        map.func_174942_a(new ResourceLocation("twilightforest", "particles/fallen_leaf"));
        map.setTextureEntry((TextureAtlasSprite)new MoltenFieryTexture(new ResourceLocation("minecraft", "blocks/lava_still"), RegisterBlockEvent.moltenFieryStill));
        map.setTextureEntry((TextureAtlasSprite)new MoltenFieryTexture(new ResourceLocation("minecraft", "blocks/lava_flow"), RegisterBlockEvent.moltenFieryFlow));
        map.setTextureEntry((TextureAtlasSprite)new GradientMappedTexture(new ResourceLocation("minecraft", "blocks/lava_still"), RegisterBlockEvent.moltenKnightmetalStill, true, TFClientEvents.KNIGHTMETAL_GRADIENT_MAP));
        map.setTextureEntry((TextureAtlasSprite)new GradientMappedTexture(new ResourceLocation("minecraft", "blocks/lava_flow"), RegisterBlockEvent.moltenKnightmetalFlow, true, TFClientEvents.KNIGHTMETAL_GRADIENT_MAP));
        map.setTextureEntry((TextureAtlasSprite)new GradientMappedTexture(new ResourceLocation("minecraft", "blocks/water_still"), RegisterBlockEvent.essenceFieryStill, true, TFClientEvents.FIERY_ESSENCE_GRADIENT_MAP));
        map.setTextureEntry((TextureAtlasSprite)new GradientMappedTexture(new ResourceLocation("minecraft", "blocks/water_flow"), RegisterBlockEvent.essenceFieryFlow, true, TFClientEvents.FIERY_ESSENCE_GRADIENT_MAP));
        if (TFCompat.IMMERSIVEENGINEERING.isActivated()) {
            map.setTextureEntry((TextureAtlasSprite)new GradientMappedTexture(new ResourceLocation("immersiveengineering", "revolvers/shaders/revolver_grip"), IEShaderRegister.PROCESSED_REVOLVER_GRIP_LAYER, true, TFClientEvents.EASY_GRAYSCALING_MAP));
            map.setTextureEntry((TextureAtlasSprite)new GradientMappedTexture(new ResourceLocation("immersiveengineering", "revolvers/shaders/revolver_0"), IEShaderRegister.PROCESSED_REVOLVER_LAYER, true, TFClientEvents.EASY_GRAYSCALING_MAP));
            map.setTextureEntry((TextureAtlasSprite)new GradientMappedTexture(new ResourceLocation("immersiveengineering", "items/shaders/chemthrower_0"), IEShaderRegister.PROCESSED_CHEMTHROW_LAYER, true, TFClientEvents.EASY_GRAYSCALING_MAP));
            map.setTextureEntry((TextureAtlasSprite)new GradientMappedTexture(new ResourceLocation("immersiveengineering", "items/shaders/drill_diesel_0"), IEShaderRegister.PROCESSED_DRILL_LAYER, true, TFClientEvents.EASY_GRAYSCALING_MAP));
            map.setTextureEntry((TextureAtlasSprite)new GradientMappedTexture(new ResourceLocation("immersiveengineering", "items/shaders/railgun_0"), IEShaderRegister.PROCESSED_RAILGUN_LAYER, true, TFClientEvents.EASY_GRAYSCALING_MAP));
            map.setTextureEntry((TextureAtlasSprite)new GradientMappedTexture(new ResourceLocation("immersiveengineering", "items/shaders/shield_0"), IEShaderRegister.PROCESSED_SHIELD_LAYER, true, TFClientEvents.EASY_GRAYSCALING_MAP));
            map.setTextureEntry((TextureAtlasSprite)new GradientMappedTexture(new ResourceLocation("immersiveengineering", "blocks/shaders/balloon_0"), IEShaderRegister.PROCESSED_BALLOON_LAYER, true, TFClientEvents.EASY_GRAYSCALING_MAP));
            final String[] types = { "1_0", "1_2", "1_4", "1_5", "1_6" };
            for (final IEShaderRegister.CaseType caseType : IEShaderRegister.CaseType.everythingButMinecart()) {
                for (final String type : types) {
                    map.setTextureEntry((TextureAtlasSprite)new GradientMappedTexture(IEShaderRegister.ModType.IMMERSIVE_ENGINEERING.provideTex(caseType, type), IEShaderRegister.ModType.TWILIGHT_FOREST.provideTex(caseType, type), true, TFClientEvents.EASY_GRAYSCALING_MAP));
                }
            }
        }
    }
    
    @SubscribeEvent
    public static boolean preOverlay(final RenderGameOverlayEvent.Pre event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.HEALTHMOUNT && TFEventListener.isRidingUnfriendly((EntityLivingBase)Minecraft.func_71410_x().field_71439_g)) {
            event.setCanceled(true);
            return false;
        }
        return true;
    }
    
    @SubscribeEvent
    public static void renderLivingPost(final RenderLivingEvent.Post<EntityLivingBase> event) {
        for (final RenderEffect effect : RenderEffect.VALUES) {
            if (effect.shouldRender(event.getEntity(), false)) {
                effect.render(event.getEntity(), (RenderLivingBase<? extends EntityLivingBase>)event.getRenderer(), event.getX(), event.getY(), event.getZ(), event.getPartialRenderTick(), false);
            }
        }
    }
    
    @SubscribeEvent
    public static void renderWorldLast(final RenderWorldLastEvent event) {
        if (!TFConfig.firstPersonEffects) {
            return;
        }
        final GameSettings settings = Minecraft.func_71410_x().field_71474_y;
        if (settings.field_74320_O != 0 || settings.field_74319_N) {
            return;
        }
        final Entity entity = Minecraft.func_71410_x().func_175606_aa();
        if (entity instanceof EntityLivingBase) {
            final Render<? extends Entity> renderer = (Render<? extends Entity>)Minecraft.func_71410_x().func_175598_ae().func_78713_a(entity);
            if (renderer instanceof RenderLivingBase) {
                for (final RenderEffect effect : RenderEffect.VALUES) {
                    if (effect.shouldRender((EntityLivingBase)entity, true)) {
                        effect.render((EntityLivingBase)entity, (RenderLivingBase<? extends EntityLivingBase>)renderer, 0.0, 0.0, 0.0, event.getPartialTicks(), true);
                    }
                }
            }
        }
    }
    
    @SubscribeEvent
    public static void renderTick(final TickEvent.RenderTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            final Minecraft minecraft = Minecraft.func_71410_x();
            final boolean fancyGraphics = minecraft.field_71474_y.field_74347_j;
            TFBlocks.twilight_leaves.func_150122_b(fancyGraphics);
            TFBlocks.twilight_leaves_3.func_150122_b(fancyGraphics);
            TFBlocks.magic_leaves.func_150122_b(fancyGraphics);
            if (minecraft.field_71441_e != null && TFWorld.isTwilightForest((World)minecraft.field_71441_e) && minecraft.field_71456_v != null) {
                minecraft.field_71456_v.field_73843_a = 0.0f;
            }
            if (minecraft.field_71439_g != null && TFEventListener.isRidingUnfriendly((EntityLivingBase)minecraft.field_71439_g) && minecraft.field_71456_v != null) {
                minecraft.field_71456_v.func_110326_a("", false);
            }
        }
    }
    
    @SubscribeEvent
    public static void clientTick(final TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END) {
            return;
        }
        ++TFClientEvents.time;
        final Minecraft mc = Minecraft.func_71410_x();
        final float partial = mc.func_184121_ak();
        TFClientEvents.rotationTickerI = ((TFClientEvents.rotationTickerI >= 359) ? 0 : (TFClientEvents.rotationTickerI + 1));
        TFClientEvents.sineTickerI = ((TFClientEvents.sineTickerI >= 627) ? 0 : (TFClientEvents.sineTickerI + 1));
        TFClientEvents.rotationTicker = TFClientEvents.rotationTickerI + partial;
        TFClientEvents.sineTicker += partial;
        BugModelAnimationHelper.animate();
        if (!mc.func_147113_T() && mc.field_71441_e != null && mc.field_71441_e.field_73011_w.getWeatherRenderer() instanceof TFWeatherRenderer) {
            ((TFWeatherRenderer)mc.field_71441_e.field_73011_w.getWeatherRenderer()).tick();
        }
    }
    
    static {
        KNIGHTMETAL_GRADIENT_MAP = new GradientNode[] { new GradientNode(0.0f, -13422030), new GradientNode(0.1f, -9800866), new GradientNode(0.15f, -8352654), new GradientNode(0.3f, -6048879), new GradientNode(0.6f, -3877202), new GradientNode(1.0f, -1573683) };
        FIERY_ESSENCE_GRADIENT_MAP = new GradientNode[] { new GradientNode(0.2f, -12773609), new GradientNode(0.8f, -10745077) };
        EASY_GRAYSCALING_MAP = new GradientNode[] { new GradientNode(0.0f, -8355712), new GradientNode(0.5f, -5592406), new GradientNode(1.0f, -1) };
        TFClientEvents.time = 0;
        TFClientEvents.rotationTickerI = 0;
        TFClientEvents.sineTickerI = 0;
        TFClientEvents.rotationTicker = 0.0f;
        TFClientEvents.sineTicker = 0.0f;
    }
}
