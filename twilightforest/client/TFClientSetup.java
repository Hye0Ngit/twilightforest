// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.MainMenuScreen;
import twilightforest.TFConfig;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraft.resources.IResourcePack;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fml.ModList;
import net.minecraft.resources.ResourcePackInfo;
import net.minecraft.client.renderer.entity.EntityRenderer;
import twilightforest.client.renderer.entity.IceLayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import twilightforest.client.renderer.entity.ShieldLayer;
import java.util.function.Consumer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraft.client.Minecraft;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.client.renderer.Atlases;
import twilightforest.block.TFBlocks;
import twilightforest.TwilightForestMod;
import net.minecraft.client.world.DimensionRenderInfo;
import twilightforest.inventory.TFContainers;
import twilightforest.tileentity.TFTileEntities;
import twilightforest.entity.TFEntities;
import net.minecraftforge.common.MinecraftForge;
import twilightforest.item.FieryArmorItem;
import twilightforest.item.ArcticArmorItem;
import twilightforest.item.YetiArmorItem;
import twilightforest.item.PhantomArmorItem;
import twilightforest.item.KnightmetalArmorItem;
import twilightforest.item.TFItems;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = { Dist.CLIENT }, bus = Mod.EventBusSubscriber.Bus.MOD, modid = "twilightforest")
public class TFClientSetup
{
    public static boolean optifinePresent;
    
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
        KnightmetalArmorItem.initArmorModel();
        PhantomArmorItem.initArmorModel();
        YetiArmorItem.initArmorModel();
        ArcticArmorItem.initArmorModel();
        FieryArmorItem.initArmorModel();
        MinecraftForge.EVENT_BUS.register((Object)new LoadingScreenListener());
        RenderLayerRegistration.init();
        TFEntities.registerEntityRenderer();
        TFTileEntities.registerTileEntityRenders();
        TFContainers.renderScreens();
        final TwilightForestRenderInfo renderInfo = new TwilightForestRenderInfo(128.0f, false, DimensionRenderInfo.FogType.NONE, false, false);
        DimensionRenderInfo.field_239208_a_.put((Object)TwilightForestMod.prefix("renderer"), (Object)renderInfo);
        evt.enqueueWork(() -> {
            Atlases.addWoodType(TFBlocks.TWILIGHT_OAK);
            Atlases.addWoodType(TFBlocks.CANOPY);
            Atlases.addWoodType(TFBlocks.MANGROVE);
            Atlases.addWoodType(TFBlocks.DARKWOOD);
            Atlases.addWoodType(TFBlocks.TIMEWOOD);
            Atlases.addWoodType(TFBlocks.TRANSFORMATION);
            Atlases.addWoodType(TFBlocks.MINING);
            Atlases.addWoodType(TFBlocks.SORTING);
        });
    }
    
    public static void addLegacyPack() {
        if (Minecraft.func_71410_x() == null) {
            return;
        }
        Minecraft.func_71410_x().func_195548_H().addPackFinder((consumer, iFactory) -> consumer.accept(ResourcePackInfo.func_195793_a(TwilightForestMod.prefix("classic_textures").toString(), false, () -> new TwilightLegacyPack(ModList.get().getModFileById("twilightforest").getFile()), iFactory, ResourcePackInfo.Priority.TOP, iTextComponent -> iTextComponent)));
    }
    
    @SubscribeEvent
    public static void loadComplete(final FMLLoadCompleteEvent evt) {
        Minecraft.func_71410_x().func_175598_ae().field_78729_o.values().forEach(r -> {
            if (r instanceof LivingRenderer) {
                attachRenderLayers((net.minecraft.client.renderer.entity.LivingRenderer<LivingEntity, EntityModel>)r);
            }
            return;
        });
        Minecraft.func_71410_x().func_175598_ae().getSkinMap().values().forEach(TFClientSetup::attachRenderLayers);
    }
    
    private static <T extends LivingEntity, M extends EntityModel<T>> void attachRenderLayers(final LivingRenderer<T, M> renderer) {
        renderer.func_177094_a((LayerRenderer)new ShieldLayer<Object, Object>((net.minecraft.client.renderer.entity.IEntityRenderer<?, ?>)renderer));
        renderer.func_177094_a((LayerRenderer)new IceLayer<Object, Object>((net.minecraft.client.renderer.entity.IEntityRenderer<?, ?>)renderer));
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
            if (TFClientSetup.optifinePresent && !ForgeEvents.optifineWarningShown && !(boolean)TFConfig.CLIENT_CONFIG.disableOptifineNagScreen.get() && event.getGui() instanceof MainMenuScreen) {
                ForgeEvents.optifineWarningShown = true;
                Minecraft.func_71410_x().func_147108_a((Screen)new OptifineWarningScreen(event.getGui()));
            }
        }
        
        static {
            ForgeEvents.optifineWarningShown = false;
        }
    }
}
