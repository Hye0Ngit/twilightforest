// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import java.nio.FloatBuffer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;
import org.lwjgl.BufferUtils;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import twilightforest.client.model.entity.ModelTFTinyFirefly;
import net.minecraft.util.ResourceLocation;
import twilightforest.entity.passive.EntityTFMobileFirefly;
import net.minecraft.client.renderer.entity.Render;

public class RenderTFMobileFirefly extends Render<EntityTFMobileFirefly>
{
    private static final ResourceLocation textureLoc;
    private final ModelTFTinyFirefly fireflyModel;
    
    public RenderTFMobileFirefly(final RenderManager manager) {
        super(manager);
        this.fireflyModel = new ModelTFTinyFirefly();
    }
    
    private void doRenderTinyFirefly(final EntityTFMobileFirefly firefly, final double x, final double y, final double z, final float brightness, final float size) {
        GlStateManager.func_179094_E();
        GlStateManager.func_179109_b((float)x, (float)y + 0.5f, (float)z);
        final FloatBuffer modelview = BufferUtils.createFloatBuffer(16);
        GlStateManager.func_179111_a(2982, modelview);
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                final int index = i * 4 + j;
                if (i == j) {
                    modelview.put(index, 1.0f);
                }
                else {
                    modelview.put(index, 0.0f);
                }
            }
        }
        GL11.glLoadMatrix(modelview);
        this.func_180548_c((Entity)firefly);
        GlStateManager.func_179135_a(true, true, true, true);
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b(770, 771);
        GlStateManager.func_179141_d();
        GlStateManager.func_179140_f();
        GlStateManager.func_179131_c(1.0f, 1.0f, 1.0f, brightness);
        this.fireflyModel.glow1.func_78785_a(0.0625f * size);
        GlStateManager.func_179084_k();
        GlStateManager.func_179145_e();
        GlStateManager.func_179131_c(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.func_179121_F();
    }
    
    public void doRender(final EntityTFMobileFirefly firefly, final double x, final double y, final double z, final float yaw, final float partialTicks) {
        this.doRenderTinyFirefly(firefly, x, y, z, firefly.getGlowBrightness(), 1.0f);
    }
    
    protected ResourceLocation getEntityTexture(final EntityTFMobileFirefly entity) {
        return RenderTFMobileFirefly.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("firefly-tiny.png");
    }
}
