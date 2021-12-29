// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer;

import java.util.Random;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.util.math.Vec3d;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.vertex.VertexBuffer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.client.IRenderHandler;

@SideOnly(Side.CLIENT)
public class TFSkyRenderer extends IRenderHandler
{
    private boolean vboEnabled;
    private int starGLCallList;
    private VertexBuffer starVBO;
    
    public TFSkyRenderer() {
        this.vboEnabled = OpenGlHelper.func_176075_f();
        this.generateStars();
    }
    
    @SideOnly(Side.CLIENT)
    public void render(final float partialTicks, final WorldClient world, final Minecraft mc) {
        final boolean flag = this.vboEnabled;
        this.vboEnabled = OpenGlHelper.func_176075_f();
        if (flag != this.vboEnabled) {
            this.generateStars();
        }
        final RenderGlobal rg = mc.field_71438_f;
        final int pass = EntityRenderer.field_78517_a ? EntityRenderer.field_78515_b : 2;
        GlStateManager.func_179090_x();
        final Vec3d vec3d = world.func_72833_a(mc.func_175606_aa(), partialTicks);
        float f = (float)vec3d.field_72450_a;
        float f2 = (float)vec3d.field_72448_b;
        float f3 = (float)vec3d.field_72449_c;
        if (pass != 2) {
            final float f4 = (f * 30.0f + f2 * 59.0f + f3 * 11.0f) / 100.0f;
            final float f5 = (f * 30.0f + f2 * 70.0f) / 100.0f;
            final float f6 = (f * 30.0f + f3 * 70.0f) / 100.0f;
            f = f4;
            f2 = f5;
            f3 = f6;
        }
        GlStateManager.func_179124_c(f, f2, f3);
        final Tessellator tessellator = Tessellator.func_178181_a();
        final BufferBuilder bufferbuilder = tessellator.func_178180_c();
        GlStateManager.func_179132_a(false);
        GlStateManager.func_179127_m();
        GlStateManager.func_179124_c(f, f2, f3);
        if (this.vboEnabled) {
            rg.field_175012_t.func_177359_a();
            GlStateManager.func_187410_q(32884);
            GlStateManager.func_187420_d(3, 5126, 12, 0);
            rg.field_175012_t.func_177358_a(7);
            rg.field_175012_t.func_177361_b();
            GlStateManager.func_187429_p(32884);
        }
        else {
            GlStateManager.func_179148_o(rg.field_72771_w);
        }
        GlStateManager.func_179106_n();
        GlStateManager.func_179118_c();
        GlStateManager.func_179147_l();
        GlStateManager.func_187428_a(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        RenderHelper.func_74518_a();
        GlStateManager.func_179098_w();
        GlStateManager.func_187428_a(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.func_179094_E();
        final float f7 = 1.0f - world.func_72867_j(partialTicks);
        GlStateManager.func_179131_c(1.0f, 1.0f, 1.0f, f7);
        GlStateManager.func_179114_b(-90.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.func_179114_b(world.func_72826_c(partialTicks) * 360.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.func_179090_x();
        final float f8 = 1.0f;
        if (f8 > 0.0f) {
            GlStateManager.func_179131_c(f8, f8, f8, f8);
            if (this.vboEnabled) {
                this.starVBO.func_177359_a();
                GlStateManager.func_187410_q(32884);
                GlStateManager.func_187420_d(3, 5126, 12, 0);
                this.starVBO.func_177358_a(7);
                this.starVBO.func_177361_b();
                GlStateManager.func_187429_p(32884);
            }
            else {
                GlStateManager.func_179148_o(this.starGLCallList);
            }
        }
        GlStateManager.func_179131_c(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.func_179084_k();
        GlStateManager.func_179141_d();
        GlStateManager.func_179127_m();
        GlStateManager.func_179121_F();
        GlStateManager.func_179090_x();
        GlStateManager.func_179124_c(0.0f, 0.0f, 0.0f);
        final double d0 = mc.field_71439_g.func_174824_e(partialTicks).field_72448_b - world.func_72919_O();
        if (d0 < 0.0) {
            GlStateManager.func_179094_E();
            GlStateManager.func_179109_b(0.0f, 12.0f, 0.0f);
            if (this.vboEnabled) {
                rg.field_175011_u.func_177359_a();
                GlStateManager.func_187410_q(32884);
                GlStateManager.func_187420_d(3, 5126, 12, 0);
                rg.field_175011_u.func_177358_a(7);
                rg.field_175011_u.func_177361_b();
                GlStateManager.func_187429_p(32884);
            }
            else {
                GlStateManager.func_179148_o(rg.field_72781_x);
            }
            GlStateManager.func_179121_F();
            final float f9 = 1.0f;
            final float f10 = -(float)(d0 + 65.0);
            final float f11 = -1.0f;
            bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181706_f);
            bufferbuilder.func_181662_b(-1.0, (double)f10, 1.0).func_181669_b(0, 0, 0, 255).func_181675_d();
            bufferbuilder.func_181662_b(1.0, (double)f10, 1.0).func_181669_b(0, 0, 0, 255).func_181675_d();
            bufferbuilder.func_181662_b(1.0, -1.0, 1.0).func_181669_b(0, 0, 0, 255).func_181675_d();
            bufferbuilder.func_181662_b(-1.0, -1.0, 1.0).func_181669_b(0, 0, 0, 255).func_181675_d();
            bufferbuilder.func_181662_b(-1.0, -1.0, -1.0).func_181669_b(0, 0, 0, 255).func_181675_d();
            bufferbuilder.func_181662_b(1.0, -1.0, -1.0).func_181669_b(0, 0, 0, 255).func_181675_d();
            bufferbuilder.func_181662_b(1.0, (double)f10, -1.0).func_181669_b(0, 0, 0, 255).func_181675_d();
            bufferbuilder.func_181662_b(-1.0, (double)f10, -1.0).func_181669_b(0, 0, 0, 255).func_181675_d();
            bufferbuilder.func_181662_b(1.0, -1.0, -1.0).func_181669_b(0, 0, 0, 255).func_181675_d();
            bufferbuilder.func_181662_b(1.0, -1.0, 1.0).func_181669_b(0, 0, 0, 255).func_181675_d();
            bufferbuilder.func_181662_b(1.0, (double)f10, 1.0).func_181669_b(0, 0, 0, 255).func_181675_d();
            bufferbuilder.func_181662_b(1.0, (double)f10, -1.0).func_181669_b(0, 0, 0, 255).func_181675_d();
            bufferbuilder.func_181662_b(-1.0, (double)f10, -1.0).func_181669_b(0, 0, 0, 255).func_181675_d();
            bufferbuilder.func_181662_b(-1.0, (double)f10, 1.0).func_181669_b(0, 0, 0, 255).func_181675_d();
            bufferbuilder.func_181662_b(-1.0, -1.0, 1.0).func_181669_b(0, 0, 0, 255).func_181675_d();
            bufferbuilder.func_181662_b(-1.0, -1.0, -1.0).func_181669_b(0, 0, 0, 255).func_181675_d();
            bufferbuilder.func_181662_b(-1.0, -1.0, -1.0).func_181669_b(0, 0, 0, 255).func_181675_d();
            bufferbuilder.func_181662_b(-1.0, -1.0, 1.0).func_181669_b(0, 0, 0, 255).func_181675_d();
            bufferbuilder.func_181662_b(1.0, -1.0, 1.0).func_181669_b(0, 0, 0, 255).func_181675_d();
            bufferbuilder.func_181662_b(1.0, -1.0, -1.0).func_181669_b(0, 0, 0, 255).func_181675_d();
            tessellator.func_78381_a();
        }
        if (world.field_73011_w.func_76561_g()) {
            GlStateManager.func_179124_c(f * 0.2f + 0.04f, f2 * 0.2f + 0.04f, f3 * 0.6f + 0.1f);
        }
        else {
            GlStateManager.func_179124_c(f, f2, f3);
        }
        GlStateManager.func_179094_E();
        GlStateManager.func_179109_b(0.0f, -(float)(d0 - 16.0), 0.0f);
        GlStateManager.func_179148_o(rg.field_72781_x);
        GlStateManager.func_179121_F();
        GlStateManager.func_179098_w();
        GlStateManager.func_179132_a(true);
    }
    
    private void generateStars() {
        final Tessellator tessellator = Tessellator.func_178181_a();
        final BufferBuilder bufferbuilder = tessellator.func_178180_c();
        if (this.starVBO != null) {
            this.starVBO.func_177362_c();
        }
        if (this.starGLCallList >= 0) {
            GLAllocation.func_74523_b(this.starGLCallList);
            this.starGLCallList = -1;
        }
        if (this.vboEnabled) {
            this.starVBO = new VertexBuffer(DefaultVertexFormats.field_181705_e);
            this.renderStars(bufferbuilder);
            bufferbuilder.func_178977_d();
            bufferbuilder.func_178965_a();
            this.starVBO.func_181722_a(bufferbuilder.func_178966_f());
        }
        else {
            this.starGLCallList = GLAllocation.func_74526_a(1);
            GlStateManager.func_179094_E();
            GlStateManager.func_187423_f(this.starGLCallList, 4864);
            this.renderStars(bufferbuilder);
            tessellator.func_78381_a();
            GlStateManager.func_187415_K();
            GlStateManager.func_179121_F();
        }
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
                    bufferBuilder.func_181662_b(d6 + d26, d7 + d24, d8 + d27).func_181675_d();
                }
            }
        }
    }
}
