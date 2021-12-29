// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import java.util.EnumMap;
import net.minecraftforge.client.model.ModelLoader;
import twilightforest.client.renderer.entity.ShieldLayer;
import java.util.stream.Stream;
import net.minecraft.client.renderer.texture.TextureAtlas;
import java.util.function.Consumer;
import java.util.function.Function;
import net.minecraft.client.resources.model.Material;
import twilightforest.client.renderer.tileentity.TwilightChestRenderer;
import net.minecraft.client.renderer.Sheets;
import net.minecraftforge.client.event.TextureStitchEvent;
import twilightforest.client.model.item.TintIndexAwareFullbrightBakedModel;
import net.minecraft.world.level.block.Block;
import java.util.Objects;
import java.util.function.UnaryOperator;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraft.resources.ResourceLocation;
import java.util.Iterator;
import twilightforest.client.model.item.ShaderBagItemModel;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.level.ItemLike;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import java.util.Locale;
import net.minecraft.world.item.Rarity;
import blusunrize.immersiveengineering.api.shader.ShaderRegistry;
import net.minecraftforge.fml.ModList;
import twilightforest.client.model.item.FullbrightBakedModel;
import twilightforest.block.TFBlocks;
import twilightforest.item.TFItems;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.model.IModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.Tag;
import net.minecraft.tags.StaticTagHelper;
import twilightforest.data.ItemTagGenerator;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.client.IWeatherRenderHandler;
import twilightforest.client.renderer.TFWeatherRenderer;
import twilightforest.TwilightForestMod;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.network.chat.TextComponent;
import net.minecraftforge.event.TickEvent;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.Options;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.CameraType;
import twilightforest.TFConfig;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.world.entity.LivingEntity;
import twilightforest.TFEventListener;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.gui.ForgeIngameGui;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraft.network.chat.MutableComponent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = "twilightforest", value = { Dist.CLIENT })
public class TFClientEvents
{
    private static final MutableComponent WIP_TEXT_0;
    private static final MutableComponent WIP_TEXT_1;
    private static final MutableComponent NYI_TEXT;
    public static int time;
    private static int rotationTickerI;
    private static int sineTickerI;
    public static float rotationTicker;
    public static float sineTicker;
    public static final float PI = 3.1415927f;
    private static final int SINE_TICKER_BOUND = 627;
    
    @SubscribeEvent
    public static void preOverlay(final RenderGameOverlayEvent.PreLayer event) {
        if (event.getOverlay() == ForgeIngameGui.MOUNT_HEALTH_ELEMENT && TFEventListener.isRidingUnfriendly((LivingEntity)Minecraft.m_91087_().f_91074_)) {
            event.setCanceled(true);
        }
    }
    
    @SubscribeEvent
    public static void renderWorldLast(final RenderWorldLastEvent event) {
        if (!(boolean)TFConfig.CLIENT_CONFIG.firstPersonEffects.get()) {
            return;
        }
        final Options settings = Minecraft.m_91087_().f_91066_;
        if (settings.m_92176_() != CameraType.FIRST_PERSON || settings.f_92062_) {
            return;
        }
        final Entity entity = Minecraft.m_91087_().m_91288_();
        if (entity instanceof LivingEntity) {
            final EntityRenderer<? extends Entity> renderer = (EntityRenderer<? extends Entity>)Minecraft.m_91087_().m_91290_().m_114382_(entity);
            if (renderer instanceof final LivingEntityRenderer livingEntityRenderer) {
                for (final RenderEffect effect : RenderEffect.VALUES) {
                    if (effect.shouldRender((LivingEntity)entity, true)) {
                        effect.render((LivingEntity)entity, (EntityModel<? extends LivingEntity>)livingEntityRenderer.m_7200_(), 0.0, 0.0, 0.0, event.getPartialTicks(), true);
                    }
                }
            }
        }
    }
    
    @SubscribeEvent
    public static void renderTick(final TickEvent.RenderTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            final Minecraft minecraft = Minecraft.m_91087_();
            if (minecraft.f_91073_ != null && "twilightforest".equals(minecraft.f_91073_.m_46472_().m_135782_().m_135827_()) && minecraft.f_91065_ != null) {
                minecraft.f_91065_.f_92980_ = 0.0f;
            }
            if (minecraft.f_91074_ != null && TFEventListener.isRidingUnfriendly((LivingEntity)minecraft.f_91074_) && minecraft.f_91065_ != null) {
                minecraft.f_91065_.m_93063_(TextComponent.f_131282_, false);
            }
        }
    }
    
    @SubscribeEvent
    public static void clientTick(final TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END) {
            return;
        }
        ++TFClientEvents.time;
        final Minecraft mc = Minecraft.m_91087_();
        final float partial = mc.m_91296_();
        TFClientEvents.rotationTickerI = ((TFClientEvents.rotationTickerI >= 359) ? 0 : (TFClientEvents.rotationTickerI + 1));
        TFClientEvents.sineTickerI = ((TFClientEvents.sineTickerI >= 627) ? 0 : (TFClientEvents.sineTickerI + 1));
        TFClientEvents.rotationTicker = TFClientEvents.rotationTickerI + partial;
        TFClientEvents.sineTicker += partial;
        BugModelAnimationHelper.animate();
        final DimensionSpecialEffects info = (DimensionSpecialEffects)DimensionSpecialEffects.f_108857_.get((Object)TwilightForestMod.prefix("renderer"));
        if (!mc.m_91104_() && mc.f_91073_ != null && info instanceof TwilightForestRenderInfo) {
            final IWeatherRenderHandler weatherRenderer = info.getWeatherRenderHandler();
            if (weatherRenderer instanceof final TFWeatherRenderer tfWeatherRenderer) {
                tfWeatherRenderer.tick();
            }
        }
    }
    
    @SubscribeEvent
    public static void tooltipEvent(final ItemTooltipEvent event) {
        final ItemStack item = event.getItemStack();
        final Tag.Named<Item> wip2 = ItemTagGenerator.WIP;
        boolean b = false;
        Label_0044: {
            if (wip2 instanceof StaticTagHelper.Wrapper) {
                final StaticTagHelper.Wrapper<Item> wrappedWIP = (StaticTagHelper.Wrapper<Item>)wip2;
                if (wrappedWIP.f_13251_ != null && item.m_150922_((Tag)wrappedWIP)) {
                    b = true;
                    break Label_0044;
                }
            }
            b = false;
        }
        final boolean wip = b;
        boolean b2 = false;
        Label_0091: {
            if (!wip) {
                final Tag.Named<Item> nyi2 = ItemTagGenerator.NYI;
                if (nyi2 instanceof StaticTagHelper.Wrapper) {
                    final StaticTagHelper.Wrapper<Item> wrappedNYI = (StaticTagHelper.Wrapper<Item>)nyi2;
                    if (wrappedNYI.f_13251_ != null && item.m_150922_((Tag)wrappedNYI)) {
                        b2 = true;
                        break Label_0091;
                    }
                }
            }
            b2 = false;
        }
        final boolean nyi = b2;
        if (!wip && !nyi) {
            return;
        }
        if (wip) {
            event.getToolTip().add(TFClientEvents.WIP_TEXT_0);
            event.getToolTip().add(TFClientEvents.WIP_TEXT_1);
        }
        else {
            event.getToolTip().add(TFClientEvents.NYI_TEXT);
        }
    }
    
    static {
        WIP_TEXT_0 = new TranslatableComponent("twilightforest.misc.wip0").m_6270_(Style.f_131099_.m_131140_(ChatFormatting.RED));
        WIP_TEXT_1 = new TranslatableComponent("twilightforest.misc.wip1").m_6270_(Style.f_131099_.m_131140_(ChatFormatting.RED));
        NYI_TEXT = new TranslatableComponent("twilightforest.misc.nyi").m_6270_(Style.f_131099_.m_131140_(ChatFormatting.RED));
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
        public static void registerLoaders(final ModelRegistryEvent event) {
            ModelLoaderRegistry.registerLoader(TwilightForestMod.prefix("patch"), (IModelLoader)PatchModelLoader.INSTANCE);
        }
        
        @Deprecated
        @SubscribeEvent
        public static void modelBake(final ModelBakeEvent event) {
            fullbrightItem(event, TFItems.FIERY_INGOT);
            fullbrightItem(event, TFItems.FIERY_BOOTS);
            fullbrightItem(event, TFItems.FIERY_CHESTPLATE);
            fullbrightItem(event, TFItems.FIERY_HELMET);
            fullbrightItem(event, TFItems.FIERY_LEGGINGS);
            fullbrightItem(event, TFItems.FIERY_PICKAXE);
            fullbrightItem(event, TFItems.FIERY_SWORD);
            fullbrightBlock(event, TFBlocks.FIERY_BLOCK);
            tintedFullbrightBlock(event, TFBlocks.PINK_CASTLE_RUNE_BRICK, FullbrightBakedModel::disableCache);
            tintedFullbrightBlock(event, TFBlocks.BLUE_CASTLE_RUNE_BRICK, FullbrightBakedModel::disableCache);
            tintedFullbrightBlock(event, TFBlocks.YELLOW_CASTLE_RUNE_BRICK, FullbrightBakedModel::disableCache);
            tintedFullbrightBlock(event, TFBlocks.VIOLET_CASTLE_RUNE_BRICK, FullbrightBakedModel::disableCache);
            if (ModList.get().isLoaded("immersiveengineering")) {
                for (Rarity rarity : ShaderRegistry.rarityWeightMap.keySet()) {
                    final ResourceLocation itemRL = TwilightForestMod.prefix("shader_bag_" + rarity.name().toLowerCase(Locale.US).replace(':', '_'));
                    final ModelResourceLocation mrl = new ModelResourceLocation(itemRL, "inventory");
                    event.getModelRegistry().put(mrl, new ShaderBagItemModel(event.getModelRegistry().get(mrl), new ItemStack((ItemLike)ForgeRegistries.ITEMS.getValue(itemRL))));
                }
            }
        }
        
        private static void fullbrightItem(final ModelBakeEvent event, final RegistryObject<Item> item) {
            fullbrightItem(event, item, f -> f);
        }
        
        private static void fullbrightItem(final ModelBakeEvent event, final RegistryObject<Item> item, final UnaryOperator<FullbrightBakedModel> process) {
            fullbright(event, Objects.requireNonNull(item.getId()), "inventory", process);
        }
        
        private static void fullbrightBlock(final ModelBakeEvent event, final RegistryObject<Block> block) {
            fullbrightBlock(event, block, f -> f);
        }
        
        private static void fullbrightBlock(final ModelBakeEvent event, final RegistryObject<Block> block, final UnaryOperator<FullbrightBakedModel> process) {
            fullbright(event, Objects.requireNonNull(block.getId()), "inventory", process);
            fullbright(event, Objects.requireNonNull(block.getId()), "", process);
        }
        
        private static void fullbright(final ModelBakeEvent event, final ResourceLocation rl, final String state, final UnaryOperator<FullbrightBakedModel> process) {
            final ModelResourceLocation mrl = new ModelResourceLocation(rl, state);
            event.getModelRegistry().put(mrl, process.apply(new FullbrightBakedModel(event.getModelRegistry().get(mrl))));
        }
        
        private static void tintedFullbrightItem(final ModelBakeEvent event, final RegistryObject<Item> item) {
            tintedFullbrightItem(event, item, f -> f);
        }
        
        private static void tintedFullbrightItem(final ModelBakeEvent event, final RegistryObject<Item> item, final UnaryOperator<FullbrightBakedModel> process) {
            tintedFullbright(event, Objects.requireNonNull(item.getId()), "inventory", process);
        }
        
        private static void tintedFullbrightBlock(final ModelBakeEvent event, final RegistryObject<Block> block) {
            tintedFullbrightBlock(event, block, f -> f);
        }
        
        private static void tintedFullbrightBlock(final ModelBakeEvent event, final RegistryObject<Block> block, final UnaryOperator<FullbrightBakedModel> process) {
            tintedFullbright(event, Objects.requireNonNull(block.getId()), "inventory", process);
            tintedFullbright(event, Objects.requireNonNull(block.getId()), "", process);
        }
        
        private static void tintedFullbright(final ModelBakeEvent event, final ResourceLocation rl, final String state, final UnaryOperator<FullbrightBakedModel> process) {
            final ModelResourceLocation mrl = new ModelResourceLocation(rl, state);
            event.getModelRegistry().put(mrl, process.apply(new TintIndexAwareFullbrightBakedModel(event.getModelRegistry().get(mrl))));
        }
        
        @SubscribeEvent
        public static void texStitch(final TextureStitchEvent.Pre evt) {
            final TextureAtlas map = evt.getMap();
            if (Sheets.f_110740_.equals((Object)map.m_118330_())) {
                final Stream<Object> map2 = TwilightChestRenderer.MATERIALS.values().stream().flatMap(e -> e.values().stream()).map((Function<? super Object, ?>)Material::m_119203_);
                Objects.requireNonNull(evt);
                map2.forEach((Consumer<? super Object>)evt::addSprite);
            }
            evt.addSprite(TwilightForestMod.prefix("block/mosspatch"));
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
