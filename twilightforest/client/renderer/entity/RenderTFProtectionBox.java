// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.EntityLivingBase;
import twilightforest.entity.EntityTFProtectionBox;
import org.lwjgl.opengl.GL11;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import twilightforest.client.model.ModelTFProtectionBox;
import net.minecraft.client.renderer.entity.Render;

public class RenderTFProtectionBox extends Render
{
    private ModelTFProtectionBox boxModel;
    private static final ResourceLocation textureLoc;
    
    public RenderTFProtectionBox() {
        this.boxModel = new ModelTFProtectionBox();
        this.field_76989_e = 0.5f;
    }
    
    public void func_76986_a(final Entity var1, final double x, final double y, final double z, final float var8, final float partialTick) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x, (float)y, (float)z);
        this.func_110776_a(RenderTFProtectionBox.textureLoc);
        final float f1 = var1.field_70173_aa + partialTick;
        GL11.glMatrixMode(5890);
        GL11.glLoadIdentity();
        final float f2 = f1 * 0.05f;
        final float f3 = f1 * 0.05f;
        GL11.glTranslatef(f2, f3, 0.0f);
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glMatrixMode(5888);
        GL11.glColorMask(true, true, true, true);
        GL11.glEnable(3042);
        GL11.glDisable(2884);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3008);
        GL11.glDisable(2896);
        float alpha = 1.0f;
        if (((EntityTFProtectionBox)var1).lifeTime < 20) {
            alpha = ((EntityTFProtectionBox)var1).lifeTime / 20.0f;
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, alpha);
        this.boxModel.func_78088_a(var1, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
        GL11.glDisable(3042);
        GL11.glEnable(2884);
        GL11.glMatrixMode(5890);
        GL11.glLoadIdentity();
        GL11.glMatrixMode(5888);
        GL11.glPopMatrix();
    }
    
    protected void preRenderCallback(final EntityLivingBase par1EntityLiving, final float par2) {
        final float scale = 1.0f;
        GL11.glScalef(scale, scale, scale);
    }
    
    protected ResourceLocation func_110775_a(final Entity par1Entity) {
        return RenderTFProtectionBox.textureLoc;
    }
    
    static {
        textureLoc = new ResourceLocation("twilightforest:textures/model/protectionbox.png");
    }
}
