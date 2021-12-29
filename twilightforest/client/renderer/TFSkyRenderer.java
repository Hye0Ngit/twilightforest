// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer;

import java.util.Random;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.util.math.vector.Vector3f;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.FogRenderer;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.world.ClientWorld;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.renderer.vertex.VertexBuffer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ISkyRenderHandler;

@OnlyIn(Dist.CLIENT)
public class TFSkyRenderer implements ISkyRenderHandler
{
    private VertexBuffer starVBO;
    private final VertexFormat vertexBufferFormat;
    
    public TFSkyRenderer() {
        this.vertexBufferFormat = DefaultVertexFormats.field_181705_e;
        this.generateStars();
    }
    
    @OnlyIn(Dist.CLIENT)
    public void render(final int ticks, final float partialTicks, final MatrixStack ms, final ClientWorld world, final Minecraft mc) {
        final WorldRenderer rg = mc.field_71438_f;
        RenderSystem.disableTexture();
        final Vector3d vec3d = world.func_228318_a_(mc.field_71460_t.func_215316_n().func_216780_d(), partialTicks);
        final float f = (float)vec3d.field_72450_a;
        final float f2 = (float)vec3d.field_72448_b;
        final float f3 = (float)vec3d.field_72449_c;
        FogRenderer.func_228373_b_();
        final Tessellator tessellator = Tessellator.func_178181_a();
        final BufferBuilder bufferbuilder = tessellator.func_178180_c();
        RenderSystem.depthMask(false);
        RenderSystem.enableFog();
        RenderSystem.color3f(f, f2, f3);
        rg.field_175012_t.func_177359_a();
        this.vertexBufferFormat.func_227892_a_(0L);
        rg.field_175012_t.func_227874_a_(ms.func_227866_c_().func_227870_a_(), 7);
        VertexBuffer.func_177361_b();
        this.vertexBufferFormat.func_227895_d_();
        RenderSystem.disableFog();
        RenderSystem.disableAlphaTest();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        ms.func_227860_a_();
        ms.func_227863_a_(Vector3f.field_229181_d_.func_229187_a_(-90.0f));
        ms.func_227863_a_(Vector3f.field_229179_b_.func_229187_a_(world.func_242415_f(partialTicks) * 360.0f));
        final float f4 = 1.0f;
        RenderSystem.color4f(f4, f4, f4, f4);
        this.starVBO.func_177359_a();
        this.vertexBufferFormat.func_227892_a_(0L);
        this.starVBO.func_227874_a_(ms.func_227866_c_().func_227870_a_(), 7);
        VertexBuffer.func_177361_b();
        this.vertexBufferFormat.func_227895_d_();
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.disableBlend();
        RenderSystem.enableAlphaTest();
        RenderSystem.enableFog();
        ms.func_227865_b_();
        RenderSystem.color3f(0.0f, 0.0f, 0.0f);
        final double d0 = mc.field_71439_g.func_174824_e(partialTicks).field_72448_b - 30.0;
        if (d0 < 0.0) {
            ms.func_227860_a_();
            ms.func_227861_a_(0.0, 12.0, 0.0);
            rg.field_175011_u.func_177359_a();
            this.vertexBufferFormat.func_227892_a_(0L);
            rg.field_175011_u.func_227874_a_(ms.func_227866_c_().func_227870_a_(), 7);
            VertexBuffer.func_177361_b();
            this.vertexBufferFormat.func_227895_d_();
            ms.func_227865_b_();
            final float f5 = -(float)(d0 + 65.0);
            bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181706_f);
            bufferbuilder.func_225582_a_(-1.0, (double)f5, 1.0).func_225586_a_(0, 0, 0, 255).func_181675_d();
            bufferbuilder.func_225582_a_(1.0, (double)f5, 1.0).func_225586_a_(0, 0, 0, 255).func_181675_d();
            bufferbuilder.func_225582_a_(1.0, -1.0, 1.0).func_225586_a_(0, 0, 0, 255).func_181675_d();
            bufferbuilder.func_225582_a_(-1.0, -1.0, 1.0).func_225586_a_(0, 0, 0, 255).func_181675_d();
            bufferbuilder.func_225582_a_(-1.0, -1.0, -1.0).func_225586_a_(0, 0, 0, 255).func_181675_d();
            bufferbuilder.func_225582_a_(1.0, -1.0, -1.0).func_225586_a_(0, 0, 0, 255).func_181675_d();
            bufferbuilder.func_225582_a_(1.0, (double)f5, -1.0).func_225586_a_(0, 0, 0, 255).func_181675_d();
            bufferbuilder.func_225582_a_(-1.0, (double)f5, -1.0).func_225586_a_(0, 0, 0, 255).func_181675_d();
            bufferbuilder.func_225582_a_(1.0, -1.0, -1.0).func_225586_a_(0, 0, 0, 255).func_181675_d();
            bufferbuilder.func_225582_a_(1.0, -1.0, 1.0).func_225586_a_(0, 0, 0, 255).func_181675_d();
            bufferbuilder.func_225582_a_(1.0, (double)f5, 1.0).func_225586_a_(0, 0, 0, 255).func_181675_d();
            bufferbuilder.func_225582_a_(1.0, (double)f5, -1.0).func_225586_a_(0, 0, 0, 255).func_181675_d();
            bufferbuilder.func_225582_a_(-1.0, (double)f5, -1.0).func_225586_a_(0, 0, 0, 255).func_181675_d();
            bufferbuilder.func_225582_a_(-1.0, (double)f5, 1.0).func_225586_a_(0, 0, 0, 255).func_181675_d();
            bufferbuilder.func_225582_a_(-1.0, -1.0, 1.0).func_225586_a_(0, 0, 0, 255).func_181675_d();
            bufferbuilder.func_225582_a_(-1.0, -1.0, -1.0).func_225586_a_(0, 0, 0, 255).func_181675_d();
            bufferbuilder.func_225582_a_(-1.0, -1.0, -1.0).func_225586_a_(0, 0, 0, 255).func_181675_d();
            bufferbuilder.func_225582_a_(-1.0, -1.0, 1.0).func_225586_a_(0, 0, 0, 255).func_181675_d();
            bufferbuilder.func_225582_a_(1.0, -1.0, 1.0).func_225586_a_(0, 0, 0, 255).func_181675_d();
            bufferbuilder.func_225582_a_(1.0, -1.0, -1.0).func_225586_a_(0, 0, 0, 255).func_181675_d();
            tessellator.func_78381_a();
        }
        if (world.func_239132_a_().func_239216_b_()) {
            RenderSystem.color3f(f * 0.2f + 0.04f, f2 * 0.2f + 0.04f, f3 * 0.6f + 0.1f);
        }
        else {
            RenderSystem.color3f(f, f2, f3);
        }
        RenderSystem.enableTexture();
        RenderSystem.depthMask(true);
        RenderSystem.disableFog();
    }
    
    private void generateStars() {
        final Tessellator tessellator = Tessellator.func_178181_a();
        final BufferBuilder bufferbuilder = tessellator.func_178180_c();
        if (this.starVBO != null) {
            this.starVBO.close();
        }
        this.starVBO = new VertexBuffer(DefaultVertexFormats.field_181705_e);
        this.renderStars(bufferbuilder);
        bufferbuilder.func_178977_d();
        this.starVBO.func_227875_a_(bufferbuilder);
    }
    
    private void renderStars(final BufferBuilder bufferBuilder) {
        final Random random = new Random(10842L);
        bufferBuilder.func_181668_a(7, DefaultVertexFormats.field_181705_e);
        for (int i = 0; i < 3000; ++i) {
            double d0 = random.nextFloat() * 2.0f - 1.0f;
            double d2 = random.nextFloat() * 2.0f - 1.0f;
            double d3 = random.nextFloat() * 2.0f - 1.0f;
            final double d4 = 0.15f + random.nextFloat() * 0.1f;
            double d5 = d0 * d0 + d2 * d2 + d3 * d3;
            if (d5 < 1.0 && d5 > 0.01) {
                d5 = 1.0 / Math.sqrt(d5);
                d0 *= d5;
                d2 *= d5;
                d3 *= d5;
                final double d6 = d0 * 100.0;
                final double d7 = d2 * 100.0;
                final double d8 = d3 * 100.0;
                final double d9 = Math.atan2(d0, d3);
                final double d10 = Math.sin(d9);
                final double d11 = Math.cos(d9);
                final double d12 = Math.atan2(Math.sqrt(d0 * d0 + d3 * d3), d2);
                final double d13 = Math.sin(d12);
                final double d14 = Math.cos(d12);
                final double d15 = random.nextDouble() * 3.141592653589793 * 2.0;
                final double d16 = Math.sin(d15);
                final double d17 = Math.cos(d15);
                for (int j = 0; j < 4; ++j) {
                    final double d18 = 0.0;
                    final double d19 = ((j & 0x2) - 1) * d4;
                    final double d20 = ((j + 1 & 0x2) - 1) * d4;
                    final double d21 = 0.0;
                    final double d22 = d19 * d17 - d20 * d16;
                    final double d23 = d20 * d17 + d19 * d16;
                    final double d24 = d22 * d13 + 0.0 * d14;
                    final double d25 = 0.0 * d13 - d22 * d14;
                    final double d26 = d25 * d10 - d23 * d11;
                    final double d27 = d23 * d10 + d25 * d11;
                    bufferBuilder.func_225582_a_(d6 + d26, d7 + d24, d8 + d27).func_181675_d();
                }
            }
        }
    }
}
