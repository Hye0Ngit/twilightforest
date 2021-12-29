// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import net.minecraftforge.client.model.ModelLoader;
import twilightforest.client.renderer.entity.ShieldLayer;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraftforge.client.event.TextureStitchEvent;
import twilightforest.client.model.item.FullbrightBakedModel;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import java.util.Objects;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import twilightforest.block.TFBlocks;
import twilightforest.item.TFItems;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.IWeatherRenderHandler;
import twilightforest.client.renderer.TFWeatherRenderer;
import twilightforest.TwilightForestMod;
import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.event.TickEvent;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.client.GameSettings;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.settings.PointOfView;
import twilightforest.TFConfig;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.entity.LivingEntity;
import twilightforest.TFEventListener;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = "twilightforest", value = { Dist.CLIENT })
public class TFClientEvents
{
    public static int time;
    private static int rotationTickerI;
    private static int sineTickerI;
    public static float rotationTicker;
    public static float sineTicker;
    public static final float PI = 3.1415927f;
    private static final int SINE_TICKER_BOUND = 627;
    
    @SubscribeEvent
    public static void preOverlay(final RenderGameOverlayEvent.Pre event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.HEALTHMOUNT && TFEventListener.isRidingUnfriendly((LivingEntity)Minecraft.func_71410_x().field_71439_g)) {
            event.setCanceled(true);
        }
    }
    
    @SubscribeEvent
    public static void renderWorldLast(final RenderWorldLastEvent event) {
        if (!(boolean)TFConfig.CLIENT_CONFIG.firstPersonEffects.get()) {
            return;
        }
        final GameSettings settings = Minecraft.func_71410_x().field_71474_y;
        if (settings.func_243230_g() != PointOfView.FIRST_PERSON || settings.field_74319_N) {
            return;
        }
        final Entity entity = Minecraft.func_71410_x().func_175606_aa();
        if (entity instanceof LivingEntity) {
            final EntityRenderer<? extends Entity> renderer = (EntityRenderer<? extends Entity>)Minecraft.func_71410_x().func_175598_ae().func_78713_a(entity);
            if (renderer instanceof LivingRenderer) {
                for (final RenderEffect effect : RenderEffect.VALUES) {
                    if (effect.shouldRender((LivingEntity)entity, true)) {
                        effect.render((LivingEntity)entity, (EntityModel<? extends LivingEntity>)((LivingRenderer)renderer).func_217764_d(), 0.0, 0.0, 0.0, event.getPartialTicks(), true);
                    }
                }
            }
        }
    }
    
    @SubscribeEvent
    public static void renderTick(final TickEvent.RenderTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            final Minecraft minecraft = Minecraft.func_71410_x();
            if (minecraft.field_71441_e != null && "twilightforest".equals(minecraft.field_71441_e.func_234923_W_().func_240901_a_().func_110624_b()) && minecraft.field_71456_v != null) {
                minecraft.field_71456_v.field_73843_a = 0.0f;
            }
            if (minecraft.field_71439_g != null && TFEventListener.isRidingUnfriendly((LivingEntity)minecraft.field_71439_g) && minecraft.field_71456_v != null) {
                minecraft.field_71456_v.func_175188_a(StringTextComponent.field_240750_d_, false);
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
        final DimensionRenderInfo info = (DimensionRenderInfo)DimensionRenderInfo.field_239208_a_.get((Object)TwilightForestMod.prefix("renderer"));
        if (!mc.func_147113_T() && mc.field_71441_e != null && info instanceof TwilightForestRenderInfo) {
            final IWeatherRenderHandler weatherRenderer = info.getWeatherRenderHandler();
            if (weatherRenderer instanceof TFWeatherRenderer) {
                ((TFWeatherRenderer)weatherRenderer).tick();
            }
        }
    }
    
    static {
        TFClientEvents.time = 0;
        TFClientEvents.rotationTickerI = 0;
        TFClientEvents.sineTickerI = 0;
        TFClientEvents.rotationTicker = 0.0f;
        TFClientEvents.sineTicker = 0.0f;
    }
    
    @Mod.EventBusSubscriber(modid = "twilightforest", value = { Dist.CLIENT }, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModBusEvents
    {
        @SubscribeEvent
        public static void modelBake(final ModelBakeEvent event) {
            fullbrightItem(event, TFItems.fiery_ingot);
            fullbrightItem(event, TFItems.fiery_boots);
            fullbrightItem(event, TFItems.fiery_chestplate);
            fullbrightItem(event, TFItems.fiery_helmet);
            fullbrightItem(event, TFItems.fiery_leggings);
            fullbrightItem(event, TFItems.fiery_pickaxe);
            fullbrightItem(event, TFItems.fiery_sword);
            fullbright(event, TFBlocks.fiery_block.getId(), "");
        }
        
        private static void fullbrightItem(final ModelBakeEvent event, final RegistryObject<Item> item) {
            fullbright(event, Objects.requireNonNull(item.getId()), "inventory");
        }
        
        private static void fullbright(final ModelBakeEvent event, final ResourceLocation rl, final String state) {
            final ModelResourceLocation mrl = new ModelResourceLocation(rl, state);
            event.getModelRegistry().put(mrl, new FullbrightBakedModel(event.getModelRegistry().get(mrl)));
        }
        
        @SubscribeEvent
        public static void texStitch(final TextureStitchEvent.Pre evt) {
            final AtlasTexture map = evt.getMap();
        }
        
        @SubscribeEvent
        public static void registerModels(final ModelRegistryEvent event) {
            ModelLoader.addSpecialModel((ResourceLocation)ShieldLayer.LOC);
            ModelLoader.addSpecialModel((ResourceLocation)new ModelResourceLocation(TwilightForestMod.prefix("trophy"), "inventory"));
            ModelLoader.addSpecialModel((ResourceLocation)new ModelResourceLocation(TwilightForestMod.prefix("trophy_minor"), "inventory"));
            ModelLoader.addSpecialModel((ResourceLocation)new ModelResourceLocation(TwilightForestMod.prefix("trophy_quest"), "inventory"));
            ModelLoader.addSpecialModel(TwilightForestMod.prefix("block/casket_obsidian"));
            ModelLoader.addSpecialModel(TwilightForestMod.prefix("block/casket_stone"));
            ModelLoader.addSpecialModel(TwilightForestMod.prefix("block/casket_basalt"));
        }
    }
}
