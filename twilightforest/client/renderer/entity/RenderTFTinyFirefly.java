// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.entity.passive.EntityTFMobileFirefly;
import net.minecraft.entity.Entity;
import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import twilightforest.entity.passive.EntityTFTinyFirefly;
import net.minecraft.util.ResourceLocation;
import twilightforest.client.model.ModelTFTinyFirefly;
import net.minecraft.client.renderer.entity.Render;

public class RenderTFTinyFirefly extends Render
{
    ModelTFTinyFirefly fireflyModel;
    private static final ResourceLocation textureLoc;
    
    public RenderTFTinyFirefly() {
        this.fireflyModel = new ModelTFTinyFirefly();
    }
    
    public void doRenderTinyFirefly(final EntityTFTinyFirefly firefly, final double x, final double y, final double z, final float brightness, final float size) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x, (float)y + 0.5f, (float)z);
        final FloatBuffer modelview = BufferUtils.createFloatBuffer(16);
        GL11.glGetFloat(2982, modelview);
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
        this.field_76990_c.field_78724_e.func_110577_a(RenderTFTinyFirefly.textureLoc);
        GL11.glColorMask(true, true, true, true);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(3008);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, brightness);
        this.fireflyModel.glow1.func_78785_a(0.0625f * size);
        GL11.glDisable(3042);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPopMatrix();
    }
    
    public void func_76986_a(final Entity entity, final double d, final double d1, final double d2, final float f, final float f1) {
        if (entity instanceof EntityTFTinyFirefly) {
            final EntityTFTinyFirefly firefly = (EntityTFTinyFirefly)entity;
            this.doRenderTinyFirefly(firefly, d, d1, d2, firefly.getGlowBrightness(), firefly.glowSize);
        }
        else if (entity instanceof EntityTFMobileFirefly) {
            final EntityTFMobileFirefly firefly2 = (EntityTFMobileFirefly)entity;
            this.doRenderTinyFirefly(null, d, d1, d2, firefly2.getGlowBrightness(), 1.0f);
        }
    }
    
    protected ResourceLocation func_110775_a(final Entity par1Entity) {
        return RenderTFTinyFirefly.textureLoc;
    }
    
    static {
        textureLoc = new ResourceLocation("twilightforest:textures/model/firefly-tiny.png");
    }
}
