// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.entity.passive.EntityTFBird;

public class RenderTFBird extends bhb
{
    private final bjl textureLoc;
    
    public RenderTFBird(final bbl par1ModelBase, final float par2, final String textureName) {
        super(par1ModelBase, par2);
        this.textureLoc = new bjl("twilightforest:textures/model/" + textureName);
    }
    
    public void renderTFBird(final EntityTFBird par1EntityTFBird, final double par2, final double par4, final double par6, final float par8, final float par9) {
        super.a((of)par1EntityTFBird, par2, par4, par6, par8, par9);
    }
    
    protected float getWingRotation(final EntityTFBird par1EntityTFBird, final float time) {
        final float var3 = par1EntityTFBird.lastFlapLength + (par1EntityTFBird.flapLength - par1EntityTFBird.lastFlapLength) * time;
        final float var4 = par1EntityTFBird.lastFlapIntensity + (par1EntityTFBird.flapIntensity - par1EntityTFBird.lastFlapIntensity) * time;
        return (lr.a(var3) + 1.0f) * var4;
    }
    
    protected float b(final oe par1EntityLiving, final float par2) {
        return this.getWingRotation((EntityTFBird)par1EntityLiving, par2);
    }
    
    public void a(final of par1EntityLiving, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.renderTFBird((EntityTFBird)par1EntityLiving, par2, par4, par6, par8, par9);
    }
    
    public void a(final nm par1Entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        this.renderTFBird((EntityTFBird)par1Entity, par2, par4, par6, par8, par9);
    }
    
    protected bjl a(final nm par1Entity) {
        return this.textureLoc;
    }
}
