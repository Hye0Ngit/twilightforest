// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import org.lwjgl.opengl.GL11;
import twilightforest.entity.EntityTFTowerGolem;
import net.minecraft.entity.EntityLiving;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;

public class RenderTFTowerGolem extends RenderLiving
{
    public RenderTFTowerGolem(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }
    
    protected void func_77043_a(final EntityLiving par1EntityLiving, final float par2, final float par3, final float par4) {
        this.rotateTowerGolem((EntityTFTowerGolem)par1EntityLiving, par2, par3, par4);
    }
    
    private void rotateTowerGolem(final EntityTFTowerGolem par1EntityLiving, final float par2, final float par3, final float par4) {
        super.func_77043_a((EntityLiving)par1EntityLiving, par2, par3, par4);
        if (par1EntityLiving.field_70721_aZ >= 0.01) {
            final float var5 = 13.0f;
            final float var6 = par1EntityLiving.field_70754_ba - par1EntityLiving.field_70721_aZ * (1.0f - par4) + 6.0f;
            final float var7 = (Math.abs(var6 % var5 - var5 * 0.5f) - var5 * 0.25f) / (var5 * 0.25f);
            GL11.glRotatef(6.5f * var7, 0.0f, 0.0f, 1.0f);
        }
    }
}
