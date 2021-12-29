// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import twilightforest.TwilightForestMod;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import java.util.function.Supplier;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import com.mojang.math.Vector3f;
import com.mojang.blaze3d.platform.Window;
import net.minecraft.client.gui.Font;
import net.minecraft.client.resources.language.I18n;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.chat.NarratorChatListener;
import twilightforest.TFConfig;
import java.util.Random;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.gui.screens.Screen;

@OnlyIn(Dist.CLIENT)
public class LoadingScreenGui extends Screen
{
    private boolean isEntering;
    private boolean contentNeedsAssignment;
    private long ticks;
    private long seed;
    private BackgroundThemes backgroundTheme;
    private ItemStack item;
    private static final Random random;
    private static final float backgroundScale = 32.0f;
    private static final TFConfig.Client.LoadingScreen LOADING_SCREEN;
    
    LoadingScreenGui() {
        super(NarratorChatListener.f_93310_);
        this.contentNeedsAssignment = false;
        this.ticks = 0L;
    }
    
    void setEntering(final boolean isEntering) {
        this.isEntering = isEntering;
    }
    
    protected void m_7856_() {
        this.f_169369_.clear();
        this.assignContent();
    }
    
    public boolean m_7043_() {
        return false;
    }
    
    public void m_96624_() {
        if (this.f_96541_ != null && this.f_96541_.f_91073_ != null && (int)LoadingScreenGui.LOADING_SCREEN.cycleLoadingScreenFrequency.get() != 0) {
            final long ticks = this.ticks + 1L;
            this.ticks = ticks;
            if (ticks % (int)LoadingScreenGui.LOADING_SCREEN.cycleLoadingScreenFrequency.get() == 0L) {
                this.assignContent();
            }
        }
    }
    
    public void m_6305_(final PoseStack ms, final int mouseX, final int mouseY, final float partialTicks) {
        if (this.contentNeedsAssignment) {
            this.assignContent();
            this.contentNeedsAssignment = false;
        }
        final Font fontRenderer = this.f_96541_.f_91062_;
        final Window resolution = this.f_96541_.m_91268_();
        this.drawBackground((float)resolution.m_85445_(), (float)resolution.m_85446_());
        final PoseStack stack = RenderSystem.m_157191_();
        RenderSystem.m_157182_();
        this.drawBouncingWobblyItem(stack, partialTicks, (float)resolution.m_85445_(), (float)resolution.m_85446_());
        RenderSystem.m_157182_();
        final String loadTitle = I18n.m_118938_("twilightforest.loading.title." + (this.isEntering ? "enter" : "leave"), new Object[0]);
        ms.m_85836_();
        ms.m_85837_((double)(resolution.m_85445_() / 2.0f - fontRenderer.m_92895_(loadTitle) / 4.0f), (double)(resolution.m_85446_() / 3.0f), 0.0);
        ms.m_85837_((double)(-(fontRenderer.m_92895_(loadTitle) / 4.0f)), 0.0, 0.0);
        fontRenderer.m_92750_(ms, loadTitle, 0.0f, 0.0f, 15658734);
        ms.m_85849_();
        RenderSystem.m_157429_(1.0f, 1.0f, 1.0f, 1.0f);
    }
    
    private void assignContent() {
        this.backgroundTheme = BackgroundThemes.values()[LoadingScreenGui.random.nextInt(BackgroundThemes.values().length)];
        this.item = (ItemStack)LoadingScreenGui.LOADING_SCREEN.getLoadingScreenIcons().get(LoadingScreenGui.random.nextInt(LoadingScreenGui.LOADING_SCREEN.getLoadingScreenIcons().size()));
        this.seed = LoadingScreenGui.random.nextLong();
    }
    
    private void drawBackground(final float width, final float height) {
        LoadingScreenGui.random.setSeed(this.seed);
        this.backgroundTheme.renderBackground(width, height);
        this.backgroundTheme.postRenderBackground(width, height);
    }
    
    private void drawBouncingWobblyItem(final PoseStack stack, final float partialTicks, final float width, final float height) {
        final float sineTicker = (TFClientEvents.sineTicker + partialTicks) * ((Double)LoadingScreenGui.LOADING_SCREEN.frequency.get()).floatValue();
        final float sineTicker2 = (TFClientEvents.sineTicker + 314.0f + partialTicks) * ((Double)LoadingScreenGui.LOADING_SCREEN.frequency.get()).floatValue();
        stack.m_85836_();
        stack.m_85837_((double)(width - width / 30.0f * ((Double)LoadingScreenGui.LOADING_SCREEN.scale.get()).floatValue()), (double)(height - height / 10.0f), 0.0);
        if (LoadingScreenGui.LOADING_SCREEN.enable.get()) {
            stack.m_85845_(Vector3f.f_122227_.m_122240_(Mth.m_14031_(sineTicker / ((Double)LoadingScreenGui.LOADING_SCREEN.tiltRange.get()).floatValue()) * ((Double)LoadingScreenGui.LOADING_SCREEN.tiltConstant.get()).floatValue()));
            stack.m_85841_((Mth.m_14031_((sineTicker2 + 180.0f) / ((Double)LoadingScreenGui.LOADING_SCREEN.tiltRange.get()).floatValue() * 2.0f) / ((Double)LoadingScreenGui.LOADING_SCREEN.scaleDeviation.get()).floatValue() + 2.0f) * (((Double)LoadingScreenGui.LOADING_SCREEN.scale.get()).floatValue() / 2.0f), (Mth.m_14031_((sineTicker + 180.0f) / ((Double)LoadingScreenGui.LOADING_SCREEN.tiltRange.get()).floatValue() * 2.0f) / ((Double)LoadingScreenGui.LOADING_SCREEN.scaleDeviation.get()).floatValue() + 2.0f) * (((Double)LoadingScreenGui.LOADING_SCREEN.scale.get()).floatValue() / 2.0f), 1.0f);
        }
        stack.m_85837_(-8.0, -16.5, 0.0);
        this.f_96541_.m_91291_().m_115203_(this.item, 0, 0);
        stack.m_85849_();
    }
    
    static {
        random = new Random();
        LOADING_SCREEN = TFConfig.CLIENT_CONFIG.LOADING_SCREEN;
    }
    
    public enum BackgroundThemes
    {
        LABYRINTH(new ResourceLocation[] { TwilightForestMod.prefix("textures/block/mazestone_brick.png"), TwilightForestMod.prefix("textures/block/mazestone_brick.png"), TwilightForestMod.prefix("textures/block/cracked_mazestone.png") }) {
            private final ResourceLocation mazestoneDecor;
            
            {
                this.mazestoneDecor = TwilightForestMod.prefix("textures/block/decorative_mazestone.png");
            }
            
            @Override
            void postRenderBackground(final float width, final float height) {
                final Tesselator tessellator = Tesselator.m_85913_();
                final BufferBuilder buffer = tessellator.m_85915_();
                RenderSystem.m_157456_(0, this.mazestoneDecor);
                buffer.m_166779_(VertexFormat.Mode.QUADS, DefaultVertexFormat.f_85819_);
                buffer.m_5483_(0.0, 24.0, 0.0).m_7421_(0.0f, 0.75f).m_85950_(0.5f, 0.5f, 0.5f, 1.0f).m_5752_();
                buffer.m_5483_((double)width, 24.0, 0.0).m_7421_(width / 32.0f, 0.75f).m_85950_(0.5f, 0.5f, 0.5f, 1.0f).m_5752_();
                buffer.m_5483_((double)width, 8.0, 0.0).m_7421_(width / 32.0f, 0.25f).m_85950_(0.5f, 0.5f, 0.5f, 1.0f).m_5752_();
                buffer.m_5483_(0.0, 8.0, 0.0).m_7421_(0.0f, 0.25f).m_85950_(0.5f, 0.5f, 0.5f, 1.0f).m_5752_();
                tessellator.m_85914_();
                final float halfScale = 16.0f;
                final float bottomGrid = height - height % halfScale;
                buffer.m_166779_(VertexFormat.Mode.QUADS, DefaultVertexFormat.f_85819_);
                buffer.m_5483_(0.0, (double)bottomGrid, 0.0).m_7421_(0.0f, 0.75f).m_85950_(0.5f, 0.5f, 0.5f, 1.0f).m_5752_();
                buffer.m_5483_((double)width, (double)bottomGrid, 0.0).m_7421_(width / 32.0f, 0.75f).m_85950_(0.5f, 0.5f, 0.5f, 1.0f).m_5752_();
                buffer.m_5483_((double)width, (double)(bottomGrid - halfScale), 0.0).m_7421_(width / 32.0f, 0.25f).m_85950_(0.5f, 0.5f, 0.5f, 1.0f).m_5752_();
                buffer.m_5483_(0.0, (double)(bottomGrid - halfScale), 0.0).m_7421_(0.0f, 0.25f).m_85950_(0.5f, 0.5f, 0.5f, 1.0f).m_5752_();
                tessellator.m_85914_();
            }
        }, 
        STRONGHOLD(new ResourceLocation[] { TwilightForestMod.prefix("textures/block/underbrick.png"), TwilightForestMod.prefix("textures/block/mossy_underbrick.png"), TwilightForestMod.prefix("textures/block/cracked_underbrick.png") }), 
        DARKTOWER(new ResourceLocation[] { TwilightForestMod.prefix("textures/block/towerwood.png"), TwilightForestMod.prefix("textures/block/towerwood.png"), TwilightForestMod.prefix("textures/block/mossy_towerwood.png"), TwilightForestMod.prefix("textures/block/cracked_towerwood.png"), TwilightForestMod.prefix("textures/block/cracked_towerwood_alt.png") }) {
            private final ResourceLocation towerwoodEncased;
            private final float stretch = 0.985f;
            private final float depth = 1.15f;
            
            {
                this.towerwoodEncased = TwilightForestMod.prefix("textures/block/encased_towerwood.png");
                this.stretch = 0.985f;
                this.depth = 1.15f;
            }
            
            @Override
            void renderBackground(final float width, final float height) {
                final float headerDepthHeight = 37.360405f;
                final float footerDepthHeight = height - 37.360405f;
                final Tesselator tessellator = Tesselator.m_85913_();
                final BufferBuilder buffer = tessellator.m_85915_();
                RenderSystem.m_157429_(0.9f, 0.9f, 0.9f, 1.0f);
                for (float x = 32.0f; x < width + 32.0f; x += 32.0f) {
                    for (float y = 69.360405f; y < footerDepthHeight + 32.0f; y += 32.0f) {
                        RenderSystem.m_157456_(0, this.getBackgroundMaterials()[LoadingScreenGui.random.nextInt(this.getBackgroundMaterials().length)]);
                        buffer.m_166779_(VertexFormat.Mode.QUADS, DefaultVertexFormat.f_85819_);
                        buffer.m_5483_((double)(x - 32.0f), (double)y, 0.0).m_7421_(0.0f, 1.0f).m_85950_(0.5f, 0.5f, 0.5f, 1.0f).m_5752_();
                        buffer.m_5483_((double)x, (double)y, 0.0).m_7421_(1.0f, 1.0f).m_85950_(0.5f, 0.5f, 0.5f, 1.0f).m_5752_();
                        buffer.m_5483_((double)x, (double)(y - 32.0f), 0.0).m_7421_(1.0f, 0.0f).m_85950_(0.5f, 0.5f, 0.5f, 1.0f).m_5752_();
                        buffer.m_5483_((double)(x - 32.0f), (double)(y - 32.0f), 0.0).m_7421_(0.0f, 0.0f).m_85950_(0.5f, 0.5f, 0.5f, 1.0f).m_5752_();
                        tessellator.m_85914_();
                    }
                }
            }
            
            @Override
            void postRenderBackground(final float width, final float height) {
                final Tesselator tessellator = Tesselator.m_85913_();
                final BufferBuilder buffer = tessellator.m_85915_();
                RenderSystem.m_157456_(0, this.towerwoodEncased);
                final float offset = 0.4f;
                final float textureHeaderXMin = 0.985f * offset;
                final float textureHeaderXMax = width / 32.0f * 0.985f + offset;
                final float headerBottom = 32.48731f;
                final float headerDepthHeight = 37.360405f;
                final float footerTop = height - 32.48731f;
                final float footerDepthHeight = height - 37.360405f;
                buffer.m_166779_(VertexFormat.Mode.QUADS, DefaultVertexFormat.f_85819_);
                buffer.m_5483_(0.0, 32.487308502197266, 0.0).m_7421_(textureHeaderXMin, 1.0f).m_85950_(0.5f, 0.5f, 0.5f, 1.0f).m_5752_();
                buffer.m_5483_((double)width, 32.487308502197266, 0.0).m_7421_(textureHeaderXMax, 1.0f).m_85950_(0.5f, 0.5f, 0.5f, 1.0f).m_5752_();
                buffer.m_5483_((double)width, 0.0, 0.0).m_7421_(textureHeaderXMax, 0.0f).m_85950_(0.5f, 0.5f, 0.5f, 1.0f).m_5752_();
                buffer.m_5483_(0.0, 0.0, 0.0).m_7421_(textureHeaderXMin, 0.0f).m_85950_(0.5f, 0.5f, 0.5f, 1.0f).m_5752_();
                tessellator.m_85914_();
                buffer.m_166779_(VertexFormat.Mode.QUADS, DefaultVertexFormat.f_85819_);
                buffer.m_5483_(0.0, 37.36040496826172, 0.0).m_7421_(0.0f, 1.0f).m_85950_(0.25f, 0.25f, 0.25f, 1.0f).m_5752_();
                buffer.m_5483_((double)width, 37.36040496826172, 0.0).m_7421_(width / 32.0f, 1.0f).m_85950_(0.25f, 0.25f, 0.25f, 1.0f).m_5752_();
                buffer.m_5483_((double)width, 32.487308502197266, 0.0).m_7421_(textureHeaderXMax, 0.0f).m_85950_(0.25f, 0.25f, 0.25f, 1.0f).m_5752_();
                buffer.m_5483_(0.0, 32.487308502197266, 0.0).m_7421_(textureHeaderXMin, 0.0f).m_85950_(0.25f, 0.25f, 0.25f, 1.0f).m_5752_();
                tessellator.m_85914_();
                buffer.m_166779_(VertexFormat.Mode.QUADS, DefaultVertexFormat.f_85819_);
                buffer.m_5483_(0.0, (double)height, 0.0).m_7421_(textureHeaderXMin, 1.0f).m_85950_(0.5f, 0.5f, 0.5f, 1.0f).m_5752_();
                buffer.m_5483_((double)width, (double)height, 0.0).m_7421_(textureHeaderXMax, 1.0f).m_85950_(0.5f, 0.5f, 0.5f, 1.0f).m_5752_();
                buffer.m_5483_((double)width, (double)footerTop, 0.0).m_7421_(textureHeaderXMax, 0.0f).m_85950_(0.5f, 0.5f, 0.5f, 1.0f).m_5752_();
                buffer.m_5483_(0.0, (double)footerTop, 0.0).m_7421_(textureHeaderXMin, 0.0f).m_85950_(0.5f, 0.5f, 0.5f, 1.0f).m_5752_();
                tessellator.m_85914_();
                buffer.m_166779_(VertexFormat.Mode.QUADS, DefaultVertexFormat.f_85819_);
                buffer.m_5483_(0.0, (double)footerTop, 0.0).m_7421_(textureHeaderXMin, 1.0f).m_85950_(0.75f, 0.75f, 0.75f, 1.0f).m_5752_();
                buffer.m_5483_((double)width, (double)footerTop, 0.0).m_7421_(textureHeaderXMax, 1.0f).m_85950_(0.75f, 0.75f, 0.75f, 1.0f).m_5752_();
                buffer.m_5483_((double)width, (double)footerDepthHeight, 0.0).m_7421_(width / 32.0f, 0.0f).m_85950_(0.75f, 0.75f, 0.75f, 1.0f).m_5752_();
                buffer.m_5483_(0.0, (double)footerDepthHeight, 0.0).m_7421_(0.0f, 0.0f).m_85950_(0.75f, 0.75f, 0.75f, 1.0f).m_5752_();
                tessellator.m_85914_();
            }
        }, 
        FINALCASTLE(new ResourceLocation[] { TwilightForestMod.prefix("textures/block/castle_brick.png"), TwilightForestMod.prefix("textures/block/castle_brick.png"), TwilightForestMod.prefix("textures/block/castle_brick.png"), TwilightForestMod.prefix("textures/block/castle_brick.png"), TwilightForestMod.prefix("textures/block/castle_brick.png"), TwilightForestMod.prefix("textures/block/cracked_castle_brick.png"), TwilightForestMod.prefix("textures/block/worn_castle_brick.png") }) {
            private final ResourceLocation[] magic;
            private final int[] colors;
            
            {
                this.magic = new ResourceLocation[] { TwilightForestMod.prefix("textures/block/castleblock_magic_0.png"), TwilightForestMod.prefix("textures/block/castleblock_magic_1.png"), TwilightForestMod.prefix("textures/block/castleblock_magic_2.png"), TwilightForestMod.prefix("textures/block/castleblock_magic_3.png"), TwilightForestMod.prefix("textures/block/castleblock_magic_4.png"), TwilightForestMod.prefix("textures/block/castleblock_magic_5.png"), TwilightForestMod.prefix("textures/block/castleblock_magic_6.png"), TwilightForestMod.prefix("textures/block/castleblock_magic_7.png") };
                this.colors = new int[] { 16711935, 65535, 16776960, 4915330 };
            }
            
            @Override
            void postRenderBackground(final float width, final float height) {
                final Tesselator tessellator = Tesselator.m_85913_();
                final BufferBuilder buffer = tessellator.m_85915_();
                final int color = this.colors[LoadingScreenGui.random.nextInt(this.colors.length)];
                final int r = color >> 16 & 0xFF;
                final int g = color >> 8 & 0xFF;
                final int b = color & 0xFF;
                for (float x = 32.0f; x < width + 32.0f; x += 32.0f) {
                    RenderSystem.m_157456_(0, this.magic[LoadingScreenGui.random.nextInt(this.magic.length)]);
                    buffer.m_166779_(VertexFormat.Mode.QUADS, DefaultVertexFormat.f_85819_);
                    buffer.m_5483_((double)(x - 32.0f), 48.0, 0.0).m_7421_(0.0f, 1.0f).m_6122_(r, g, b, 255).m_5752_();
                    buffer.m_5483_((double)x, 48.0, 0.0).m_7421_(1.0f, 1.0f).m_6122_(r, g, b, 255).m_5752_();
                    buffer.m_5483_((double)x, 16.0, 0.0).m_7421_(1.0f, 0.0f).m_6122_(r, g, b, 255).m_5752_();
                    buffer.m_5483_((double)(x - 32.0f), 16.0, 0.0).m_7421_(0.0f, 0.0f).m_6122_(r, g, b, 255).m_5752_();
                    tessellator.m_85914_();
                }
                for (float x = 32.0f; x < width + 32.0f; x += 32.0f) {
                    RenderSystem.m_157456_(0, this.magic[LoadingScreenGui.random.nextInt(this.magic.length)]);
                    buffer.m_166779_(VertexFormat.Mode.QUADS, DefaultVertexFormat.f_85819_);
                    buffer.m_5483_((double)(x - 32.0f), (double)(height - 16.0f), 0.0).m_7421_(0.0f, 1.0f).m_6122_(r, g, b, 255).m_5752_();
                    buffer.m_5483_((double)x, (double)(height - 16.0f), 0.0).m_7421_(1.0f, 1.0f).m_6122_(r, g, b, 255).m_5752_();
                    buffer.m_5483_((double)x, (double)(height - 32.0f - 16.0f), 0.0).m_7421_(1.0f, 0.0f).m_6122_(r, g, b, 255).m_5752_();
                    buffer.m_5483_((double)(x - 32.0f), (double)(height - 32.0f - 16.0f), 0.0).m_7421_(0.0f, 0.0f).m_6122_(r, g, b, 255).m_5752_();
                    tessellator.m_85914_();
                }
            }
        };
        
        private final ResourceLocation[] backgroundMaterials;
        
        private BackgroundThemes(final ResourceLocation[] backgroundMaterials) {
            this.backgroundMaterials = backgroundMaterials;
        }
        
        ResourceLocation[] getBackgroundMaterials() {
            return this.backgroundMaterials;
        }
        
        void renderBackground(final float width, final float height) {
            RenderSystem.m_157427_((Supplier)GameRenderer::m_172817_);
            final Tesselator tessellator = Tesselator.m_85913_();
            final BufferBuilder buffer = tessellator.m_85915_();
            RenderSystem.m_157429_(0.9f, 0.9f, 0.9f, 1.0f);
            for (float x = 32.0f; x < width + 32.0f; x += 32.0f) {
                for (float y = 32.0f; y < height + 32.0f; y += 32.0f) {
                    RenderSystem.m_157456_(0, this.getBackgroundMaterials()[LoadingScreenGui.random.nextInt(this.getBackgroundMaterials().length)]);
                    buffer.m_166779_(VertexFormat.Mode.QUADS, DefaultVertexFormat.f_85819_);
                    buffer.m_5483_((double)(x - 32.0f), (double)y, 0.0).m_7421_(0.0f, 1.0f).m_85950_(0.5f, 0.5f, 0.5f, 1.0f).m_5752_();
                    buffer.m_5483_((double)x, (double)y, 0.0).m_7421_(1.0f, 1.0f).m_85950_(0.5f, 0.5f, 0.5f, 1.0f).m_5752_();
                    buffer.m_5483_((double)x, (double)(y - 32.0f), 0.0).m_7421_(1.0f, 0.0f).m_85950_(0.5f, 0.5f, 0.5f, 1.0f).m_5752_();
                    buffer.m_5483_((double)(x - 32.0f), (double)(y - 32.0f), 0.0).m_7421_(0.0f, 0.0f).m_85950_(0.5f, 0.5f, 0.5f, 1.0f).m_5752_();
                    tessellator.m_85914_();
                }
            }
        }
        
        void postRenderBackground(final float width, final float height) {
        }
    }
}
