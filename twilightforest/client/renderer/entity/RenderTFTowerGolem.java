// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import org.lwjgl.opengl.GL11;
import twilightforest.entity.EntityTFTowerGolem;

public class RenderTFTowerGolem extends bhb
{
    private static final bjl textureLoc;
    
    public RenderTFTowerGolem(final bbl par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }
    
    protected void a(final oe par1EntityLiving, final float par2, final float par3, final float par4) {
        this.rotateTowerGolem((EntityTFTowerGolem)par1EntityLiving, par2, par3, par4);
    }
    
    private void rotateTowerGolem(final EntityTFTowerGolem par1EntityLiving, final float par2, final float par3, final float par4) {
        super.a((oe)par1EntityLiving, par2, par3, par4);
        if (par1EntityLiving.aG >= 0.01) {
            final float var5 = 13.0f;
            final float var6 = par1EntityLiving.aH - par1EntityLiving.aG * (1.0f - par4) + 6.0f;
            final float var7 = (Math.abs(var6 % var5 - var5 * 0.5f) - var5 * 0.25f) / (var5 * 0.25f);
            GL11.glRotatef(6.5f * var7, 0.0f, 0.0f, 1.0f);
        }
    }
    
    protected bjl a(final nm par1Entity) {
        return RenderTFTowerGolem.textureLoc;
    }
    
    static {
        textureLoc = new bjl("twilightforest:textures/model/carminitegolem.png");
    }
}
