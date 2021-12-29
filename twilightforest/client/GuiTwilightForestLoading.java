// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import twilightforest.TwilightForestMod;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.client.gui.ScaledResolution;
import twilightforest.TFConfig;
import java.util.Random;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiScreen;

@SideOnly(Side.CLIENT)
public class GuiTwilightForestLoading extends GuiScreen
{
    private boolean isEntering;
    private boolean contentNeedsAssignment;
    private long lastWorldUpdateTick;
    private long seed;
    private BackgroundThemes backgroundTheme;
    private ItemStack item;
    private static final Random random;
    private static final float backgroundScale = 32.0f;
    
    GuiTwilightForestLoading() {
        this.contentNeedsAssignment = false;
        this.lastWorldUpdateTick = 0L;
    }
    
    void setEntering(final boolean isEntering) {
        this.isEntering = isEntering;
    }
    
    public void func_73866_w_() {
        this.field_146292_n.clear();
        this.assignContent();
    }
    
    protected void func_73869_a(final char typedChar, final int keyCode) {
    }
    
    public boolean func_73868_f() {
        return false;
    }
    
    public void func_73863_a(final int mouseX, final int mouseY, final float partialTicks) {
        if (this.contentNeedsAssignment) {
            this.assignContent();
            this.contentNeedsAssignment = false;
        }
        if (this.field_146297_k.field_71441_e != null && TFConfig.loadingScreen.cycleLoadingScreenFrequency != 0 && this.lastWorldUpdateTick != this.field_146297_k.field_71441_e.func_82737_E() % 240000L) {
            this.lastWorldUpdateTick = this.field_146297_k.field_71441_e.func_82737_E() % 240000L;
            if (this.lastWorldUpdateTick % TFConfig.loadingScreen.cycleLoadingScreenFrequency == 0L) {
                this.assignContent();
            }
        }
        final FontRenderer fontRenderer = this.field_146297_k.field_71466_p;
        final ScaledResolution resolution = new ScaledResolution(this.field_146297_k);
        this.drawBackground((float)resolution.func_78326_a(), (float)resolution.func_78328_b());
        this.drawBouncingWobblyItem(partialTicks, (float)resolution.func_78326_a(), (float)resolution.func_78328_b());
        final String loadTitle = I18n.func_74838_a("twilightforest.loading.title." + (this.isEntering ? "enter" : "leave"));
        GlStateManager.func_179094_E();
        GlStateManager.func_179109_b(resolution.func_78326_a() / 2.0f - fontRenderer.func_78256_a(loadTitle) / 4.0f, resolution.func_78328_b() / 3.0f, 0.0f);
        GlStateManager.func_179109_b(-(fontRenderer.func_78256_a(loadTitle) / 4.0f), 0.0f, 0.0f);
        fontRenderer.func_175063_a(loadTitle, 0.0f, 0.0f, 15658734);
        GlStateManager.func_179121_F();
        GlStateManager.func_179131_c(1.0f, 1.0f, 1.0f, 1.0f);
    }
    
    private void assignContent() {
        this.backgroundTheme = BackgroundThemes.values()[GuiTwilightForestLoading.random.nextInt(BackgroundThemes.values().length)];
        this.item = (ItemStack)TFConfig.loadingScreen.getLoadingScreenIcons().get(GuiTwilightForestLoading.random.nextInt(TFConfig.loadingScreen.getLoadingScreenIcons().size()));
        this.seed = GuiTwilightForestLoading.random.nextLong();
    }
    
    private void drawBackground(final float width, final float height) {
        GuiTwilightForestLoading.random.setSeed(this.seed);
        this.backgroundTheme.renderBackground(width, height);
        this.backgroundTheme.postRenderBackground(width, height);
    }
    
    private void drawBouncingWobblyItem(final float partialTicks, final float width, final float height) {
        final float sineTicker = (TFClientEvents.sineTicker + partialTicks) * TFConfig.loadingScreen.frequency;
        final float sineTicker2 = (TFClientEvents.sineTicker + 314.0f + partialTicks) * TFConfig.loadingScreen.frequency;
        GlStateManager.func_179094_E();
        GlStateManager.func_179109_b(width - width / 30.0f * TFConfig.loadingScreen.scale, height - height / 10.0f, 0.0f);
        if (TFConfig.loadingScreen.enable) {
            GlStateManager.func_179114_b(MathHelper.func_76126_a(sineTicker / TFConfig.loadingScreen.tiltRange) * TFConfig.loadingScreen.tiltConstant, 0.0f, 0.0f, 1.0f);
            GlStateManager.func_179152_a((MathHelper.func_76126_a((sineTicker2 + 180.0f) / TFConfig.loadingScreen.tiltRange * 2.0f) / TFConfig.loadingScreen.scaleDeviation + 2.0f) * (TFConfig.loadingScreen.scale / 2.0f), (MathHelper.func_76126_a((sineTicker + 180.0f) / TFConfig.loadingScreen.tiltRange * 2.0f) / TFConfig.loadingScreen.scaleDeviation + 2.0f) * (TFConfig.loadingScreen.scale / 2.0f), 1.0f);
        }
        GlStateManager.func_179109_b(-8.0f, -16.5f, 0.0f);
        RenderHelper.func_74520_c();
        OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, 32.0f, 32.0f);
        this.field_146297_k.func_175599_af().func_180450_b(this.item, 0, 0);
        RenderHelper.func_74518_a();
        GlStateManager.func_179121_F();
    }
    
    static {
        random = new Random();
    }
    
    public enum BackgroundThemes
    {
        LABYRINTH(new ResourceLocation[] { TwilightForestMod.prefix("textures/blocks/mazestone_brick.png"), TwilightForestMod.prefix("textures/blocks/mazestone_brick.png"), TwilightForestMod.prefix("textures/blocks/mazestone_cracked.png") }) {
            private final ResourceLocation mazestoneDecor;
            
            {
                this.mazestoneDecor = TwilightForestMod.prefix("textures/blocks/mazestone_decorative.png");
            }
            
            @Override
            void postRenderBackground(final float width, final float height) {
                final Tessellator tessellator = Tessellator.func_178181_a();
                final BufferBuilder buffer = tessellator.func_178180_c();
                Minecraft.func_71410_x().func_110434_K().func_110577_a(this.mazestoneDecor);
                buffer.func_181668_a(7, DefaultVertexFormats.field_181709_i);
                buffer.func_181662_b(0.0, 24.0, 0.0).func_187315_a(0.0, 0.75).func_181666_a(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                buffer.func_181662_b((double)width, 24.0, 0.0).func_187315_a((double)(width / 32.0f), 0.75).func_181666_a(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                buffer.func_181662_b((double)width, 8.0, 0.0).func_187315_a((double)(width / 32.0f), 0.25).func_181666_a(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                buffer.func_181662_b(0.0, 8.0, 0.0).func_187315_a(0.0, 0.25).func_181666_a(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                tessellator.func_78381_a();
                final float halfScale = 16.0f;
                final float bottomGrid = height - height % halfScale;
                buffer.func_181668_a(7, DefaultVertexFormats.field_181709_i);
                buffer.func_181662_b(0.0, (double)bottomGrid, 0.0).func_187315_a(0.0, 0.75).func_181666_a(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                buffer.func_181662_b((double)width, (double)bottomGrid, 0.0).func_187315_a((double)(width / 32.0f), 0.75).func_181666_a(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                buffer.func_181662_b((double)width, (double)(bottomGrid - halfScale), 0.0).func_187315_a((double)(width / 32.0f), 0.25).func_181666_a(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                buffer.func_181662_b(0.0, (double)(bottomGrid - halfScale), 0.0).func_187315_a(0.0, 0.25).func_181666_a(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                tessellator.func_78381_a();
            }
        }, 
        STRONGHOLD(new ResourceLocation[] { TwilightForestMod.prefix("textures/blocks/knightbrick.png"), TwilightForestMod.prefix("textures/blocks/knightbrick_mossy.png"), TwilightForestMod.prefix("textures/blocks/knightbrick_cracked.png") }), 
        DARKTOWER(new ResourceLocation[] { TwilightForestMod.prefix("textures/blocks/towerwood_planks.png"), TwilightForestMod.prefix("textures/blocks/towerwood_planks.png"), TwilightForestMod.prefix("textures/blocks/towerwood_mossy.png"), TwilightForestMod.prefix("textures/blocks/towerwood_cracked.png"), TwilightForestMod.prefix("textures/blocks/towerwood_alt.png") }) {
            private final ResourceLocation towerwoodEncased;
            private final float stretch = 0.985f;
            private final float offset = 0.4f;
            private final float depth = 1.15f;
            
            {
                this.towerwoodEncased = TwilightForestMod.prefix("textures/blocks/towerwood_encased.png");
                this.stretch = 0.985f;
                this.offset = 0.4f;
                this.depth = 1.15f;
            }
            
            @Override
            void renderBackground(final float width, final float height) {
                final float headerDepthHeight = 37.360405f;
                final float footerDepthHeight = height - 37.360405f;
                GlStateManager.func_179140_f();
                GlStateManager.func_179106_n();
                final Tessellator tessellator = Tessellator.func_178181_a();
                final BufferBuilder buffer = tessellator.func_178180_c();
                GlStateManager.func_179131_c(0.9f, 0.9f, 0.9f, 1.0f);
                for (float x = 32.0f; x < width + 32.0f; x += 32.0f) {
                    for (float y = 69.360405f; y < footerDepthHeight + 32.0f; y += 32.0f) {
                        Minecraft.func_71410_x().func_110434_K().func_110577_a(this.getBackgroundMaterials()[GuiTwilightForestLoading.random.nextInt(this.getBackgroundMaterials().length)]);
                        buffer.func_181668_a(7, DefaultVertexFormats.field_181709_i);
                        buffer.func_181662_b((double)(x - 32.0f), (double)y, 0.0).func_187315_a(0.0, 1.0).func_181666_a(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                        buffer.func_181662_b((double)x, (double)y, 0.0).func_187315_a(1.0, 1.0).func_181666_a(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                        buffer.func_181662_b((double)x, (double)(y - 32.0f), 0.0).func_187315_a(1.0, 0.0).func_181666_a(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                        buffer.func_181662_b((double)(x - 32.0f), (double)(y - 32.0f), 0.0).func_187315_a(0.0, 0.0).func_181666_a(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                        tessellator.func_78381_a();
                    }
                }
            }
            
            @Override
            void postRenderBackground(final float width, final float height) {
                final Tessellator tessellator = Tessellator.func_178181_a();
                final BufferBuilder buffer = tessellator.func_178180_c();
                Minecraft.func_71410_x().func_110434_K().func_110577_a(this.towerwoodEncased);
                final float textureHeaderXMin = 0.39400002f;
                final float textureHeaderXMax = width / 32.0f * 0.985f + 0.4f;
                final float headerBottom = 32.48731f;
                final float headerDepthHeight = 37.360405f;
                final float footerTop = height - 32.48731f;
                final float footerDepthHeight = height - 37.360405f;
                buffer.func_181668_a(7, DefaultVertexFormats.field_181709_i);
                buffer.func_181662_b(0.0, 32.487308502197266, 0.0).func_187315_a(0.39400002360343933, 1.0).func_181666_a(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                buffer.func_181662_b((double)width, 32.487308502197266, 0.0).func_187315_a((double)textureHeaderXMax, 1.0).func_181666_a(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                buffer.func_181662_b((double)width, 0.0, 0.0).func_187315_a((double)textureHeaderXMax, 0.0).func_181666_a(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                buffer.func_181662_b(0.0, 0.0, 0.0).func_187315_a(0.39400002360343933, 0.0).func_181666_a(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                tessellator.func_78381_a();
                buffer.func_181668_a(7, DefaultVertexFormats.field_181709_i);
                buffer.func_181662_b(0.0, 37.36040496826172, 0.0).func_187315_a(0.0, 1.0).func_181666_a(0.25f, 0.25f, 0.25f, 1.0f).func_181675_d();
                buffer.func_181662_b((double)width, 37.36040496826172, 0.0).func_187315_a((double)(width / 32.0f), 1.0).func_181666_a(0.25f, 0.25f, 0.25f, 1.0f).func_181675_d();
                buffer.func_181662_b((double)width, 32.487308502197266, 0.0).func_187315_a((double)textureHeaderXMax, 0.0).func_181666_a(0.25f, 0.25f, 0.25f, 1.0f).func_181675_d();
                buffer.func_181662_b(0.0, 32.487308502197266, 0.0).func_187315_a(0.39400002360343933, 0.0).func_181666_a(0.25f, 0.25f, 0.25f, 1.0f).func_181675_d();
                tessellator.func_78381_a();
                buffer.func_181668_a(7, DefaultVertexFormats.field_181709_i);
                buffer.func_181662_b(0.0, (double)height, 0.0).func_187315_a(0.39400002360343933, 1.0).func_181666_a(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                buffer.func_181662_b((double)width, (double)height, 0.0).func_187315_a((double)textureHeaderXMax, 1.0).func_181666_a(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                buffer.func_181662_b((double)width, (double)footerTop, 0.0).func_187315_a((double)textureHeaderXMax, 0.0).func_181666_a(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                buffer.func_181662_b(0.0, (double)footerTop, 0.0).func_187315_a(0.39400002360343933, 0.0).func_181666_a(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                tessellator.func_78381_a();
                buffer.func_181668_a(7, DefaultVertexFormats.field_181709_i);
                buffer.func_181662_b(0.0, (double)footerTop, 0.0).func_187315_a(0.39400002360343933, 1.0).func_181666_a(0.75f, 0.75f, 0.75f, 1.0f).func_181675_d();
                buffer.func_181662_b((double)width, (double)footerTop, 0.0).func_187315_a((double)textureHeaderXMax, 1.0).func_181666_a(0.75f, 0.75f, 0.75f, 1.0f).func_181675_d();
                buffer.func_181662_b((double)width, (double)footerDepthHeight, 0.0).func_187315_a((double)(width / 32.0f), 0.0).func_181666_a(0.75f, 0.75f, 0.75f, 1.0f).func_181675_d();
                buffer.func_181662_b(0.0, (double)footerDepthHeight, 0.0).func_187315_a(0.0, 0.0).func_181666_a(0.75f, 0.75f, 0.75f, 1.0f).func_181675_d();
                tessellator.func_78381_a();
            }
        }, 
        FINALCASTLE(new ResourceLocation[] { TwilightForestMod.prefix("textures/blocks/castleblock_brick.png"), TwilightForestMod.prefix("textures/blocks/castleblock_brick.png"), TwilightForestMod.prefix("textures/blocks/castleblock_brick.png"), TwilightForestMod.prefix("textures/blocks/castleblock_brick.png"), TwilightForestMod.prefix("textures/blocks/castleblock_brick.png"), TwilightForestMod.prefix("textures/blocks/castleblock_cracked.png"), TwilightForestMod.prefix("textures/blocks/castleblock_faded.png") }) {
            private final ResourceLocation[] magic;
            private final int[] colors;
            
            {
                this.magic = new ResourceLocation[] { TwilightForestMod.prefix("textures/blocks/castleblock_magic_0.png"), TwilightForestMod.prefix("textures/blocks/castleblock_magic_1.png"), TwilightForestMod.prefix("textures/blocks/castleblock_magic_2.png"), TwilightForestMod.prefix("textures/blocks/castleblock_magic_3.png"), TwilightForestMod.prefix("textures/blocks/castleblock_magic_4.png"), TwilightForestMod.prefix("textures/blocks/castleblock_magic_5.png"), TwilightForestMod.prefix("textures/blocks/castleblock_magic_6.png"), TwilightForestMod.prefix("textures/blocks/castleblock_magic_7.png") };
                this.colors = new int[] { 16711935, 65535, 16776960, 4915330 };
            }
            
            @Override
            void postRenderBackground(final float width, final float height) {
                GlStateManager.func_179140_f();
                GlStateManager.func_179106_n();
                final Tessellator tessellator = Tessellator.func_178181_a();
                final BufferBuilder buffer = tessellator.func_178180_c();
                final int color = this.colors[GuiTwilightForestLoading.random.nextInt(this.colors.length)];
                final int r = color >> 16 & 0xFF;
                final int g = color >> 8 & 0xFF;
                final int b = color & 0xFF;
                for (float x = 32.0f; x < width + 32.0f; x += 32.0f) {
                    Minecraft.func_71410_x().func_110434_K().func_110577_a(this.magic[GuiTwilightForestLoading.random.nextInt(this.magic.length)]);
                    buffer.func_181668_a(7, DefaultVertexFormats.field_181709_i);
                    buffer.func_181662_b((double)(x - 32.0f), 48.0, 0.0).func_187315_a(0.0, 1.0).func_181669_b(r, g, b, 255).func_181675_d();
                    buffer.func_181662_b((double)x, 48.0, 0.0).func_187315_a(1.0, 1.0).func_181669_b(r, g, b, 255).func_181675_d();
                    buffer.func_181662_b((double)x, 16.0, 0.0).func_187315_a(1.0, 0.0).func_181669_b(r, g, b, 255).func_181675_d();
                    buffer.func_181662_b((double)(x - 32.0f), 16.0, 0.0).func_187315_a(0.0, 0.0).func_181669_b(r, g, b, 255).func_181675_d();
                    tessellator.func_78381_a();
                }
                for (float x = 32.0f; x < width + 32.0f; x += 32.0f) {
                    Minecraft.func_71410_x().func_110434_K().func_110577_a(this.magic[GuiTwilightForestLoading.random.nextInt(this.magic.length)]);
                    buffer.func_181668_a(7, DefaultVertexFormats.field_181709_i);
                    buffer.func_181662_b((double)(x - 32.0f), (double)(height - 16.0f), 0.0).func_187315_a(0.0, 1.0).func_181669_b(r, g, b, 255).func_181675_d();
                    buffer.func_181662_b((double)x, (double)(height - 16.0f), 0.0).func_187315_a(1.0, 1.0).func_181669_b(r, g, b, 255).func_181675_d();
                    buffer.func_181662_b((double)x, (double)(height - 32.0f - 16.0f), 0.0).func_187315_a(1.0, 0.0).func_181669_b(r, g, b, 255).func_181675_d();
                    buffer.func_181662_b((double)(x - 32.0f), (double)(height - 32.0f - 16.0f), 0.0).func_187315_a(0.0, 0.0).func_181669_b(r, g, b, 255).func_181675_d();
                    tessellator.func_78381_a();
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
            GlStateManager.func_179140_f();
            GlStateManager.func_179106_n();
            final Tessellator tessellator = Tessellator.func_178181_a();
            final BufferBuilder buffer = tessellator.func_178180_c();
            GlStateManager.func_179131_c(0.9f, 0.9f, 0.9f, 1.0f);
            for (float x = 32.0f; x < width + 32.0f; x += 32.0f) {
                for (float y = 32.0f; y < height + 32.0f; y += 32.0f) {
                    Minecraft.func_71410_x().func_110434_K().func_110577_a(this.getBackgroundMaterials()[GuiTwilightForestLoading.random.nextInt(this.getBackgroundMaterials().length)]);
                    buffer.func_181668_a(7, DefaultVertexFormats.field_181709_i);
                    buffer.func_181662_b((double)(x - 32.0f), (double)y, 0.0).func_187315_a(0.0, 1.0).func_181666_a(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                    buffer.func_181662_b((double)x, (double)y, 0.0).func_187315_a(1.0, 1.0).func_181666_a(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                    buffer.func_181662_b((double)x, (double)(y - 32.0f), 0.0).func_187315_a(1.0, 0.0).func_181666_a(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                    buffer.func_181662_b((double)(x - 32.0f), (double)(y - 32.0f), 0.0).func_187315_a(0.0, 0.0).func_181666_a(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                    tessellator.func_78381_a();
                }
            }
        }
        
        void postRenderBackground(final float width, final float height) {
        }
    }
}
