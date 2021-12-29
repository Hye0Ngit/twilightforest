// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.TitleScreen;
import twilightforest.TFConfig;
import net.minecraftforge.client.event.GuiScreenEvent;
import twilightforest.client.renderer.entity.IceLayer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import twilightforest.client.renderer.entity.ShieldLayer;
import java.util.stream.Stream;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.Map;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.world.entity.player.Player;
import java.util.Objects;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.client.renderer.Sheets;
import twilightforest.block.TFBlocks;
import twilightforest.TwilightForestMod;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import twilightforest.inventory.TFContainers;
import twilightforest.block.entity.TFBlockEntities;
import net.minecraftforge.common.MinecraftForge;
import twilightforest.item.TFItems;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import java.lang.reflect.Field;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = { Dist.CLIENT }, bus = Mod.EventBusSubscriber.Bus.MOD, modid = "twilightforest")
public class TFClientSetup
{
    public static boolean optifinePresent;
    private static Field field_EntityRenderersEvent$AddLayers_renderers;
    
    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent evt) {
        try {
            Class.forName("net.optifine.Config");
            TFClientSetup.optifinePresent = true;
        }
        catch (ClassNotFoundException e) {
            TFClientSetup.optifinePresent = false;
        }
        TFItems.addItemModelProperties();
        MinecraftForge.EVENT_BUS.register((Object)new LoadingScreenListener());
        RenderLayerRegistration.init();
        TFBlockEntities.registerTileEntityRenders();
        TFContainers.renderScreens();
        final TwilightForestRenderInfo renderInfo = new TwilightForestRenderInfo(128.0f, false, DimensionSpecialEffects.SkyType.NONE, false, false);
        DimensionSpecialEffects.f_108857_.put((Object)TwilightForestMod.prefix("renderer"), (Object)renderInfo);
        evt.enqueueWork(() -> {
            Sheets.addWoodType(TFBlocks.TWILIGHT_OAK);
            Sheets.addWoodType(TFBlocks.CANOPY);
            Sheets.addWoodType(TFBlocks.MANGROVE);
            Sheets.addWoodType(TFBlocks.DARKWOOD);
            Sheets.addWoodType(TFBlocks.TIMEWOOD);
            Sheets.addWoodType(TFBlocks.TRANSFORMATION);
            Sheets.addWoodType(TFBlocks.MINING);
            Sheets.addWoodType(TFBlocks.SORTING);
        });
    }
    
    @SubscribeEvent
    public static void attachRenderLayers(final EntityRenderersEvent.AddLayers event) {
        if (TFClientSetup.field_EntityRenderersEvent$AddLayers_renderers == null) {
            try {
                (TFClientSetup.field_EntityRenderersEvent$AddLayers_renderers = EntityRenderersEvent.AddLayers.class.getDeclaredField("renderers")).setAccessible(true);
            }
            catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        if (TFClientSetup.field_EntityRenderersEvent$AddLayers_renderers != null) {
            event.getSkins().forEach(renderer -> {
                final LivingEntityRenderer skin = event.getSkin(renderer);
                attachRenderLayers((net.minecraft.client.renderer.entity.LivingEntityRenderer<LivingEntity, EntityModel>)Objects.requireNonNull(skin));
                return;
            });
            try {
                final Stream stream = ((Map)TFClientSetup.field_EntityRenderersEvent$AddLayers_renderers.get(event)).values().stream();
                final Class<LivingEntityRenderer> obj = LivingEntityRenderer.class;
                Objects.requireNonNull(obj);
                final Stream filter = stream.filter(obj::isInstance);
                final Class<LivingEntityRenderer> obj2 = LivingEntityRenderer.class;
                Objects.requireNonNull(obj2);
                filter.map(obj2::cast).forEach(TFClientSetup::attachRenderLayers);
            }
            catch (IllegalAccessException e2) {
                e2.printStackTrace();
            }
        }
    }
    
    private static <T extends LivingEntity, M extends EntityModel<T>> void attachRenderLayers(final LivingEntityRenderer<T, M> renderer) {
        renderer.m_115326_((RenderLayer)new ShieldLayer<Object, Object>((net.minecraft.client.renderer.entity.RenderLayerParent<?, ?>)renderer));
        renderer.m_115326_((RenderLayer)new IceLayer<Object, Object>((net.minecraft.client.renderer.entity.RenderLayerParent<?, ?>)renderer));
    }
    
    static {
        TFClientSetup.optifinePresent = false;
    }
    
    @Mod.EventBusSubscriber(value = { Dist.CLIENT }, bus = Mod.EventBusSubscriber.Bus.FORGE, modid = "twilightforest")
    public static class ForgeEvents
    {
        private static boolean optifineWarningShown;
        
        @SubscribeEvent
        public static void showOptifineWarning(final GuiScreenEvent.InitGuiEvent.Post event) {
            if (TFClientSetup.optifinePresent && !ForgeEvents.optifineWarningShown && !(boolean)TFConfig.CLIENT_CONFIG.disableOptifineNagScreen.get() && event.getGui() instanceof TitleScreen) {
                ForgeEvents.optifineWarningShown = true;
                Minecraft.m_91087_().m_91152_((Screen)new OptifineWarningScreen(event.getGui()));
            }
        }
        
        static {
            ForgeEvents.optifineWarningShown = false;
        }
    }
}
