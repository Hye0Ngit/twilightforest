// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer;

import java.util.Random;
import net.minecraft.client.renderer.ShaderInstance;
import com.mojang.blaze3d.vertex.BufferBuilder;
import net.minecraft.world.phys.Vec3;
import net.minecraft.client.renderer.LevelRenderer;
import com.mojang.math.Vector3f;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.vertex.Tesselator;
import net.minecraft.client.renderer.FogRenderer;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexBuffer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ISkyRenderHandler;

@OnlyIn(Dist.CLIENT)
public class TFSkyRenderer implements ISkyRenderHandler
{
    private VertexBuffer starVBO;
    private final VertexFormat vertexBufferFormat;
    
    public TFSkyRenderer() {
        this.vertexBufferFormat = DefaultVertexFormat.f_85814_;
        this.generateStars();
    }
    
    @OnlyIn(Dist.CLIENT)
    public void render(final int ticks, final float partialTicks, final PoseStack ms, final ClientLevel world, final Minecraft mc) {
        final LevelRenderer rg = mc.f_91060_;
        RenderSystem.m_69472_();
        final Vec3 vec3d = world.m_171660_(mc.f_91063_.m_109153_().m_90583_(), partialTicks);
        final float f = (float)vec3d.f_82479_;
        final float f2 = (float)vec3d.f_82480_;
        final float f3 = (float)vec3d.f_82481_;
        FogRenderer.m_109036_();
        final Tesselator tessellator = Tesselator.m_85913_();
        final BufferBuilder bufferbuilder = tessellator.m_85915_();
        RenderSystem.m_69458_(false);
        RenderSystem.m_157429_(f, f2, f3, 1.0f);
        final ShaderInstance shaderinstance = RenderSystem.m_157196_();
        rg.f_109472_.m_85921_();
        rg.f_109472_.m_166867_(ms.m_85850_().m_85861_(), RenderSystem.m_157192_(), shaderinstance);
        VertexBuffer.m_85931_();
        this.vertexBufferFormat.m_86024_();
        RenderSystem.m_69478_();
        RenderSystem.m_69453_();
        RenderSystem.m_69416_(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        ms.m_85836_();
        ms.m_85845_(Vector3f.f_122225_.m_122240_(-90.0f));
        ms.m_85845_(Vector3f.f_122223_.m_122240_(world.m_46942_(partialTicks) * 360.0f));
        final float f4 = 1.0f;
        RenderSystem.m_157429_(f4, f4, f4, f4);
        this.starVBO.m_85921_();
        this.starVBO.m_166867_(ms.m_85850_().m_85861_(), RenderSystem.m_157192_(), shaderinstance);
        VertexBuffer.m_85931_();
        this.vertexBufferFormat.m_86024_();
        RenderSystem.m_157429_(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.m_69461_();
        ms.m_85849_();
        RenderSystem.m_157429_(0.0f, 0.0f, 0.0f, 1.0f);
        final double d0 = mc.f_91074_.m_20299_(partialTicks).f_82480_ + (world.m_5736_() - 10);
        if (d0 < 0.0) {
            ms.m_85836_();
            ms.m_85837_(0.0, 12.0, 0.0);
            rg.f_109473_.m_85921_();
            rg.f_109473_.m_166867_(ms.m_85850_().m_85861_(), RenderSystem.m_157192_(), shaderinstance);
            VertexBuffer.m_85931_();
            this.vertexBufferFormat.m_86024_();
            ms.m_85849_();
            final float f5 = -(float)(d0 + 65.0);
            bufferbuilder.m_166779_(VertexFormat.Mode.QUADS, DefaultVertexFormat.f_85815_);
            bufferbuilder.m_5483_(-1.0, (double)f5, 1.0).m_6122_(0, 0, 0, 255).m_5752_();
            bufferbuilder.m_5483_(1.0, (double)f5, 1.0).m_6122_(0, 0, 0, 255).m_5752_();
            bufferbuilder.m_5483_(1.0, -1.0, 1.0).m_6122_(0, 0, 0, 255).m_5752_();
            bufferbuilder.m_5483_(-1.0, -1.0, 1.0).m_6122_(0, 0, 0, 255).m_5752_();
            bufferbuilder.m_5483_(-1.0, -1.0, -1.0).m_6122_(0, 0, 0, 255).m_5752_();
            bufferbuilder.m_5483_(1.0, -1.0, -1.0).m_6122_(0, 0, 0, 255).m_5752_();
            bufferbuilder.m_5483_(1.0, (double)f5, -1.0).m_6122_(0, 0, 0, 255).m_5752_();
            bufferbuilder.m_5483_(-1.0, (double)f5, -1.0).m_6122_(0, 0, 0, 255).m_5752_();
            bufferbuilder.m_5483_(1.0, -1.0, -1.0).m_6122_(0, 0, 0, 255).m_5752_();
            bufferbuilder.m_5483_(1.0, -1.0, 1.0).m_6122_(0, 0, 0, 255).m_5752_();
            bufferbuilder.m_5483_(1.0, (double)f5, 1.0).m_6122_(0, 0, 0, 255).m_5752_();
            bufferbuilder.m_5483_(1.0, (double)f5, -1.0).m_6122_(0, 0, 0, 255).m_5752_();
            bufferbuilder.m_5483_(-1.0, (double)f5, -1.0).m_6122_(0, 0, 0, 255).m_5752_();
            bufferbuilder.m_5483_(-1.0, (double)f5, 1.0).m_6122_(0, 0, 0, 255).m_5752_();
            bufferbuilder.m_5483_(-1.0, -1.0, 1.0).m_6122_(0, 0, 0, 255).m_5752_();
            bufferbuilder.m_5483_(-1.0, -1.0, -1.0).m_6122_(0, 0, 0, 255).m_5752_();
            bufferbuilder.m_5483_(-1.0, -1.0, -1.0).m_6122_(0, 0, 0, 255).m_5752_();
            bufferbuilder.m_5483_(-1.0, -1.0, 1.0).m_6122_(0, 0, 0, 255).m_5752_();
            bufferbuilder.m_5483_(1.0, -1.0, 1.0).m_6122_(0, 0, 0, 255).m_5752_();
            bufferbuilder.m_5483_(1.0, -1.0, -1.0).m_6122_(0, 0, 0, 255).m_5752_();
            tessellator.m_85914_();
        }
        if (world.m_104583_().m_108882_()) {
            RenderSystem.m_157429_(f * 0.2f + 0.04f, f2 * 0.2f + 0.04f, f3 * 0.6f + 0.1f, 1.0f);
        }
        else {
            RenderSystem.m_157429_(f, f2, f3, 1.0f);
        }
        RenderSystem.m_69493_();
        RenderSystem.m_69458_(true);
    }
    
    private void generateStars() {
        final Tesselator tessellator = Tesselator.m_85913_();
        final BufferBuilder bufferbuilder = tessellator.m_85915_();
        if (this.starVBO != null) {
            this.starVBO.close();
        }
        this.starVBO = new VertexBuffer();
        this.renderStars(bufferbuilder);
        bufferbuilder.m_85721_();
        this.starVBO.m_85925_(bufferbuilder);
    }
    
    private void renderStars(final BufferBuilder bufferBuilder) {
        final Random random = new Random(10842L);
        bufferBuilder.m_166779_(VertexFormat.Mode.QUADS, DefaultVertexFormat.f_85814_);
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
                    bufferBuilder.m_5483_(d6 + d26, d7 + d24, d8 + d27).m_5752_();
                }
            }
        }
    }
}
