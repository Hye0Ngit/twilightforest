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
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.MainWindow;
import net.minecraft.client.gui.FontRenderer;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.resources.I18n;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.chat.NarratorChatListener;
import twilightforest.TFConfig;
import java.util.Random;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.gui.screen.Screen;

@OnlyIn(Dist.CLIENT)
public class LoadingScreenGui extends Screen
{
    private boolean isEntering;
    private boolean contentNeedsAssignment;
    private long lastWorldUpdateTick;
    private long seed;
    private BackgroundThemes backgroundTheme;
    private ItemStack item;
    private static final Random random;
    private static final float backgroundScale = 32.0f;
    private static final TFConfig.Client.LoadingScreen LOADING_SCREEN;
    
    LoadingScreenGui() {
        super(NarratorChatListener.field_216868_a);
        this.contentNeedsAssignment = false;
        this.lastWorldUpdateTick = 0L;
    }
    
    void setEntering(final boolean isEntering) {
        this.isEntering = isEntering;
    }
    
    protected void func_231160_c_() {
        this.field_230710_m_.clear();
        this.assignContent();
    }
    
    public boolean func_231177_au__() {
        return false;
    }
    
    public void func_230430_a_(final MatrixStack ms, final int mouseX, final int mouseY, final float partialTicks) {
        if (this.contentNeedsAssignment) {
            this.assignContent();
            this.contentNeedsAssignment = false;
        }
        if (this.field_230706_i_.field_71441_e != null && (int)LoadingScreenGui.LOADING_SCREEN.cycleLoadingScreenFrequency.get() != 0 && this.lastWorldUpdateTick != this.field_230706_i_.field_71441_e.func_82737_E() % 240000L) {
            this.lastWorldUpdateTick = this.field_230706_i_.field_71441_e.func_82737_E() % 240000L;
            if (this.lastWorldUpdateTick % (int)LoadingScreenGui.LOADING_SCREEN.cycleLoadingScreenFrequency.get() == 0L) {
                this.assignContent();
            }
        }
        final FontRenderer fontRenderer = this.field_230706_i_.field_71466_p;
        final MainWindow resolution = this.field_230706_i_.func_228018_at_();
        this.drawBackground((float)resolution.func_198107_o(), (float)resolution.func_198087_p());
        this.drawBouncingWobblyItem(partialTicks, (float)resolution.func_198107_o(), (float)resolution.func_198087_p());
        final String loadTitle = I18n.func_135052_a("twilightforest.loading.title." + (this.isEntering ? "enter" : "leave"), new Object[0]);
        ms.func_227860_a_();
        ms.func_227861_a_((double)(resolution.func_198107_o() / 2.0f - fontRenderer.func_78256_a(loadTitle) / 4.0f), (double)(resolution.func_198087_p() / 3.0f), 0.0);
        ms.func_227861_a_((double)(-(fontRenderer.func_78256_a(loadTitle) / 4.0f)), 0.0, 0.0);
        fontRenderer.func_238405_a_(ms, loadTitle, 0.0f, 0.0f, 15658734);
        ms.func_227865_b_();
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
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
    
    private void drawBouncingWobblyItem(final float partialTicks, final float width, final float height) {
        final float sineTicker = (TFClientEvents.sineTicker + partialTicks) * ((Double)LoadingScreenGui.LOADING_SCREEN.frequency.get()).floatValue();
        final float sineTicker2 = (TFClientEvents.sineTicker + 314.0f + partialTicks) * ((Double)LoadingScreenGui.LOADING_SCREEN.frequency.get()).floatValue();
        RenderSystem.pushMatrix();
        RenderSystem.translatef(width - width / 30.0f * ((Double)LoadingScreenGui.LOADING_SCREEN.scale.get()).floatValue(), height - height / 10.0f, 0.0f);
        if (LoadingScreenGui.LOADING_SCREEN.enable.get()) {
            RenderSystem.rotatef(MathHelper.func_76126_a(sineTicker / ((Double)LoadingScreenGui.LOADING_SCREEN.tiltRange.get()).floatValue()) * ((Double)LoadingScreenGui.LOADING_SCREEN.tiltConstant.get()).floatValue(), 0.0f, 0.0f, 1.0f);
            RenderSystem.scalef((MathHelper.func_76126_a((sineTicker2 + 180.0f) / ((Double)LoadingScreenGui.LOADING_SCREEN.tiltRange.get()).floatValue() * 2.0f) / ((Double)LoadingScreenGui.LOADING_SCREEN.scaleDeviation.get()).floatValue() + 2.0f) * (((Double)LoadingScreenGui.LOADING_SCREEN.scale.get()).floatValue() / 2.0f), (MathHelper.func_76126_a((sineTicker + 180.0f) / ((Double)LoadingScreenGui.LOADING_SCREEN.tiltRange.get()).floatValue() * 2.0f) / ((Double)LoadingScreenGui.LOADING_SCREEN.scaleDeviation.get()).floatValue() + 2.0f) * (((Double)LoadingScreenGui.LOADING_SCREEN.scale.get()).floatValue() / 2.0f), 1.0f);
        }
        RenderSystem.translatef(-8.0f, -16.5f, 0.0f);
        this.field_230706_i_.func_175599_af().func_180450_b(this.item, 0, 0);
        RenderSystem.popMatrix();
    }
    
    static {
        random = new Random();
        LOADING_SCREEN = TFConfig.CLIENT_CONFIG.LOADING_SCREEN;
    }
    
    public enum BackgroundThemes
    {
        LABYRINTH(new ResourceLocation[] { TwilightForestMod.prefix("textures/block/maze_stone_brick.png"), TwilightForestMod.prefix("textures/block/maze_stone_brick.png"), TwilightForestMod.prefix("textures/block/maze_stone_cracked.png") }) {
            private final ResourceLocation mazestoneDecor;
            
            {
                this.mazestoneDecor = TwilightForestMod.prefix("textures/block/maze_stone_decorative.png");
            }
            
            @Override
            void postRenderBackground(final float width, final float height) {
                final Tessellator tessellator = Tessellator.func_178181_a();
                final BufferBuilder buffer = tessellator.func_178180_c();
                Minecraft.func_71410_x().func_110434_K().func_110577_a(this.mazestoneDecor);
                buffer.func_181668_a(7, DefaultVertexFormats.field_181709_i);
                buffer.func_225582_a_(0.0, 24.0, 0.0).func_225583_a_(0.0f, 0.75f).func_227885_a_(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                buffer.func_225582_a_((double)width, 24.0, 0.0).func_225583_a_(width / 32.0f, 0.75f).func_227885_a_(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                buffer.func_225582_a_((double)width, 8.0, 0.0).func_225583_a_(width / 32.0f, 0.25f).func_227885_a_(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                buffer.func_225582_a_(0.0, 8.0, 0.0).func_225583_a_(0.0f, 0.25f).func_227885_a_(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                tessellator.func_78381_a();
                final float halfScale = 16.0f;
                final float bottomGrid = height - height % halfScale;
                buffer.func_181668_a(7, DefaultVertexFormats.field_181709_i);
                buffer.func_225582_a_(0.0, (double)bottomGrid, 0.0).func_225583_a_(0.0f, 0.75f).func_227885_a_(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                buffer.func_225582_a_((double)width, (double)bottomGrid, 0.0).func_225583_a_(width / 32.0f, 0.75f).func_227885_a_(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                buffer.func_225582_a_((double)width, (double)(bottomGrid - halfScale), 0.0).func_225583_a_(width / 32.0f, 0.25f).func_227885_a_(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                buffer.func_225582_a_(0.0, (double)(bottomGrid - halfScale), 0.0).func_225583_a_(0.0f, 0.25f).func_227885_a_(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                tessellator.func_78381_a();
            }
        }, 
        STRONGHOLD(new ResourceLocation[] { TwilightForestMod.prefix("textures/block/underbrick.png"), TwilightForestMod.prefix("textures/block/underbrick_mossy.png"), TwilightForestMod.prefix("textures/block/underbrick_cracked.png") }), 
        DARKTOWER(new ResourceLocation[] { TwilightForestMod.prefix("textures/block/tower_wood.png"), TwilightForestMod.prefix("textures/block/tower_wood.png"), TwilightForestMod.prefix("textures/block/tower_wood_mossy.png"), TwilightForestMod.prefix("textures/block/tower_wood_cracked.png"), TwilightForestMod.prefix("textures/block/tower_wood_cracked_alt.png") }) {
            private final ResourceLocation towerwoodEncased;
            private final float stretch = 0.985f;
            private final float depth = 1.15f;
            
            {
                this.towerwoodEncased = TwilightForestMod.prefix("textures/block/tower_wood_encased.png");
                this.stretch = 0.985f;
                this.depth = 1.15f;
            }
            
            @Override
            void renderBackground(final float width, final float height) {
                final float headerDepthHeight = 37.360405f;
                final float footerDepthHeight = height - 37.360405f;
                RenderSystem.disableLighting();
                RenderSystem.disableFog();
                final Tessellator tessellator = Tessellator.func_178181_a();
                final BufferBuilder buffer = tessellator.func_178180_c();
                RenderSystem.color4f(0.9f, 0.9f, 0.9f, 1.0f);
                for (float x = 32.0f; x < width + 32.0f; x += 32.0f) {
                    for (float y = 69.360405f; y < footerDepthHeight + 32.0f; y += 32.0f) {
                        Minecraft.func_71410_x().func_110434_K().func_110577_a(this.getBackgroundMaterials()[LoadingScreenGui.random.nextInt(this.getBackgroundMaterials().length)]);
                        buffer.func_181668_a(7, DefaultVertexFormats.field_181709_i);
                        buffer.func_225582_a_((double)(x - 32.0f), (double)y, 0.0).func_225583_a_(0.0f, 1.0f).func_227885_a_(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                        buffer.func_225582_a_((double)x, (double)y, 0.0).func_225583_a_(1.0f, 1.0f).func_227885_a_(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                        buffer.func_225582_a_((double)x, (double)(y - 32.0f), 0.0).func_225583_a_(1.0f, 0.0f).func_227885_a_(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                        buffer.func_225582_a_((double)(x - 32.0f), (double)(y - 32.0f), 0.0).func_225583_a_(0.0f, 0.0f).func_227885_a_(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                        tessellator.func_78381_a();
                    }
                }
            }
            
            @Override
            void postRenderBackground(final float width, final float height) {
                final Tessellator tessellator = Tessellator.func_178181_a();
                final BufferBuilder buffer = tessellator.func_178180_c();
                Minecraft.func_71410_x().func_110434_K().func_110577_a(this.towerwoodEncased);
                final float offset = 0.4f;
                final float textureHeaderXMin = 0.985f * offset;
                final float textureHeaderXMax = width / 32.0f * 0.985f + offset;
                final float headerBottom = 32.48731f;
                final float headerDepthHeight = 37.360405f;
                final float footerTop = height - 32.48731f;
                final float footerDepthHeight = height - 37.360405f;
                buffer.func_181668_a(7, DefaultVertexFormats.field_181709_i);
                buffer.func_225582_a_(0.0, 32.487308502197266, 0.0).func_225583_a_(textureHeaderXMin, 1.0f).func_227885_a_(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                buffer.func_225582_a_((double)width, 32.487308502197266, 0.0).func_225583_a_(textureHeaderXMax, 1.0f).func_227885_a_(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                buffer.func_225582_a_((double)width, 0.0, 0.0).func_225583_a_(textureHeaderXMax, 0.0f).func_227885_a_(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                buffer.func_225582_a_(0.0, 0.0, 0.0).func_225583_a_(textureHeaderXMin, 0.0f).func_227885_a_(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                tessellator.func_78381_a();
                buffer.func_181668_a(7, DefaultVertexFormats.field_181709_i);
                buffer.func_225582_a_(0.0, 37.36040496826172, 0.0).func_225583_a_(0.0f, 1.0f).func_227885_a_(0.25f, 0.25f, 0.25f, 1.0f).func_181675_d();
                buffer.func_225582_a_((double)width, 37.36040496826172, 0.0).func_225583_a_(width / 32.0f, 1.0f).func_227885_a_(0.25f, 0.25f, 0.25f, 1.0f).func_181675_d();
                buffer.func_225582_a_((double)width, 32.487308502197266, 0.0).func_225583_a_(textureHeaderXMax, 0.0f).func_227885_a_(0.25f, 0.25f, 0.25f, 1.0f).func_181675_d();
                buffer.func_225582_a_(0.0, 32.487308502197266, 0.0).func_225583_a_(textureHeaderXMin, 0.0f).func_227885_a_(0.25f, 0.25f, 0.25f, 1.0f).func_181675_d();
                tessellator.func_78381_a();
                buffer.func_181668_a(7, DefaultVertexFormats.field_181709_i);
                buffer.func_225582_a_(0.0, (double)height, 0.0).func_225583_a_(textureHeaderXMin, 1.0f).func_227885_a_(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                buffer.func_225582_a_((double)width, (double)height, 0.0).func_225583_a_(textureHeaderXMax, 1.0f).func_227885_a_(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                buffer.func_225582_a_((double)width, (double)footerTop, 0.0).func_225583_a_(textureHeaderXMax, 0.0f).func_227885_a_(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                buffer.func_225582_a_(0.0, (double)footerTop, 0.0).func_225583_a_(textureHeaderXMin, 0.0f).func_227885_a_(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                tessellator.func_78381_a();
                buffer.func_181668_a(7, DefaultVertexFormats.field_181709_i);
                buffer.func_225582_a_(0.0, (double)footerTop, 0.0).func_225583_a_(textureHeaderXMin, 1.0f).func_227885_a_(0.75f, 0.75f, 0.75f, 1.0f).func_181675_d();
                buffer.func_225582_a_((double)width, (double)footerTop, 0.0).func_225583_a_(textureHeaderXMax, 1.0f).func_227885_a_(0.75f, 0.75f, 0.75f, 1.0f).func_181675_d();
                buffer.func_225582_a_((double)width, (double)footerDepthHeight, 0.0).func_225583_a_(width / 32.0f, 0.0f).func_227885_a_(0.75f, 0.75f, 0.75f, 1.0f).func_181675_d();
                buffer.func_225582_a_(0.0, (double)footerDepthHeight, 0.0).func_225583_a_(0.0f, 0.0f).func_227885_a_(0.75f, 0.75f, 0.75f, 1.0f).func_181675_d();
                tessellator.func_78381_a();
            }
        }, 
        FINALCASTLE(new ResourceLocation[] { TwilightForestMod.prefix("textures/block/castle_brick.png"), TwilightForestMod.prefix("textures/block/castle_brick.png"), TwilightForestMod.prefix("textures/block/castle_brick.png"), TwilightForestMod.prefix("textures/block/castle_brick.png"), TwilightForestMod.prefix("textures/block/castle_brick.png"), TwilightForestMod.prefix("textures/block/castle_brick_cracked.png"), TwilightForestMod.prefix("textures/block/castle_brick_worn.png") }) {
            private final ResourceLocation[] magic;
            private final int[] colors;
            
            {
                this.magic = new ResourceLocation[] { TwilightForestMod.prefix("textures/block/castleblock_magic_0.png"), TwilightForestMod.prefix("textures/block/castleblock_magic_1.png"), TwilightForestMod.prefix("textures/block/castleblock_magic_2.png"), TwilightForestMod.prefix("textures/block/castleblock_magic_3.png"), TwilightForestMod.prefix("textures/block/castleblock_magic_4.png"), TwilightForestMod.prefix("textures/block/castleblock_magic_5.png"), TwilightForestMod.prefix("textures/block/castleblock_magic_6.png"), TwilightForestMod.prefix("textures/block/castleblock_magic_7.png") };
                this.colors = new int[] { 16711935, 65535, 16776960, 4915330 };
            }
            
            @Override
            void postRenderBackground(final float width, final float height) {
                RenderSystem.disableLighting();
                RenderSystem.disableFog();
                final Tessellator tessellator = Tessellator.func_178181_a();
                final BufferBuilder buffer = tessellator.func_178180_c();
                final int color = this.colors[LoadingScreenGui.random.nextInt(this.colors.length)];
                final int r = color >> 16 & 0xFF;
                final int g = color >> 8 & 0xFF;
                final int b = color & 0xFF;
                for (float x = 32.0f; x < width + 32.0f; x += 32.0f) {
                    Minecraft.func_71410_x().func_110434_K().func_110577_a(this.magic[LoadingScreenGui.random.nextInt(this.magic.length)]);
                    buffer.func_181668_a(7, DefaultVertexFormats.field_181709_i);
                    buffer.func_225582_a_((double)(x - 32.0f), 48.0, 0.0).func_225583_a_(0.0f, 1.0f).func_225586_a_(r, g, b, 255).func_181675_d();
                    buffer.func_225582_a_((double)x, 48.0, 0.0).func_225583_a_(1.0f, 1.0f).func_225586_a_(r, g, b, 255).func_181675_d();
                    buffer.func_225582_a_((double)x, 16.0, 0.0).func_225583_a_(1.0f, 0.0f).func_225586_a_(r, g, b, 255).func_181675_d();
                    buffer.func_225582_a_((double)(x - 32.0f), 16.0, 0.0).func_225583_a_(0.0f, 0.0f).func_225586_a_(r, g, b, 255).func_181675_d();
                    tessellator.func_78381_a();
                }
                for (float x = 32.0f; x < width + 32.0f; x += 32.0f) {
                    Minecraft.func_71410_x().func_110434_K().func_110577_a(this.magic[LoadingScreenGui.random.nextInt(this.magic.length)]);
                    buffer.func_181668_a(7, DefaultVertexFormats.field_181709_i);
                    buffer.func_225582_a_((double)(x - 32.0f), (double)(height - 16.0f), 0.0).func_225583_a_(0.0f, 1.0f).func_225586_a_(r, g, b, 255).func_181675_d();
                    buffer.func_225582_a_((double)x, (double)(height - 16.0f), 0.0).func_225583_a_(1.0f, 1.0f).func_225586_a_(r, g, b, 255).func_181675_d();
                    buffer.func_225582_a_((double)x, (double)(height - 32.0f - 16.0f), 0.0).func_225583_a_(1.0f, 0.0f).func_225586_a_(r, g, b, 255).func_181675_d();
                    buffer.func_225582_a_((double)(x - 32.0f), (double)(height - 32.0f - 16.0f), 0.0).func_225583_a_(0.0f, 0.0f).func_225586_a_(r, g, b, 255).func_181675_d();
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
            RenderSystem.disableLighting();
            RenderSystem.disableFog();
            final Tessellator tessellator = Tessellator.func_178181_a();
            final BufferBuilder buffer = tessellator.func_178180_c();
            RenderSystem.color4f(0.9f, 0.9f, 0.9f, 1.0f);
            for (float x = 32.0f; x < width + 32.0f; x += 32.0f) {
                for (float y = 32.0f; y < height + 32.0f; y += 32.0f) {
                    Minecraft.func_71410_x().func_110434_K().func_110577_a(this.getBackgroundMaterials()[LoadingScreenGui.random.nextInt(this.getBackgroundMaterials().length)]);
                    buffer.func_181668_a(7, DefaultVertexFormats.field_181709_i);
                    buffer.func_225582_a_((double)(x - 32.0f), (double)y, 0.0).func_225583_a_(0.0f, 1.0f).func_227885_a_(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                    buffer.func_225582_a_((double)x, (double)y, 0.0).func_225583_a_(1.0f, 1.0f).func_227885_a_(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                    buffer.func_225582_a_((double)x, (double)(y - 32.0f), 0.0).func_225583_a_(1.0f, 0.0f).func_227885_a_(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                    buffer.func_225582_a_((double)(x - 32.0f), (double)(y - 32.0f), 0.0).func_225583_a_(0.0f, 0.0f).func_227885_a_(0.5f, 0.5f, 0.5f, 1.0f).func_181675_d();
                    tessellator.func_78381_a();
                }
            }
        }
        
        void postRenderBackground(final float width, final float height) {
        }
    }
}
