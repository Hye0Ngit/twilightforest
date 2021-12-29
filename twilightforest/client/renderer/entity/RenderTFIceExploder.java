// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import org.lwjgl.opengl.GL11;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.model.ModelBiped;
import twilightforest.client.model.ModelTFIceExploder;

public class RenderTFIceExploder extends RenderTFBiped
{
    public RenderTFIceExploder() {
        super(new ModelTFIceExploder(), 1.0f, "iceexploder.png");
    }
    
    protected void func_77041_b(final EntityLivingBase par1EntityLivingBase, final float partialTick) {
        final float bounce = par1EntityLivingBase.field_70173_aa + partialTick;
        GL11.glTranslatef(0.0f, MathHelper.func_76126_a(bounce * 0.2f) * 0.15f, 0.0f);
        float f1 = (float)par1EntityLivingBase.field_70725_aQ;
        if (f1 > 0.0f) {
            final float f2 = 1.0f + MathHelper.func_76126_a(f1 * 100.0f) * f1 * 0.01f;
            if (f1 < 0.0f) {
                f1 = 0.0f;
            }
            if (f1 > 1.0f) {
                f1 = 1.0f;
            }
            f1 *= f1;
            f1 *= f1;
            final float f3 = (1.0f + f1 * 0.4f) * f2;
            final float f4 = (1.0f + f1 * 0.1f) / f2;
            GL11.glScalef(f3, f4, f3);
        }
    }
    
    protected void func_77043_a(final EntityLivingBase par1EntityLivingBase, final float par2, final float par3, final float par4) {
        GL11.glRotatef(180.0f - par3, 0.0f, 1.0f, 0.0f);
    }
    
    protected int func_77030_a(final EntityLivingBase par1EntityLivingBase, final float par2, final float par3) {
        if (par1EntityLivingBase.field_70725_aQ <= 0) {
            return 0;
        }
        final float f2 = par1EntityLivingBase.field_70725_aQ + par3;
        if ((int)(f2 / 2.0f) % 2 == 0) {
            return 0;
        }
        int i = (int)(f2 * 0.2f * 255.0f);
        if (i < 0) {
            i = 0;
        }
        if (i > 255) {
            i = 255;
        }
        final short short1 = 255;
        final short short2 = 255;
        final short short3 = 255;
        return i << 24 | short1 << 16 | short2 << 8 | short3;
    }
}
