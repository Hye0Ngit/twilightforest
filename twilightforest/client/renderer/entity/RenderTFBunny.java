// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.entity.passive.EntityTFBunny;

public class RenderTFBunny extends bhb
{
    final bjl textureLocDutch;
    final bjl textureLocWhite;
    final bjl textureLocBrown;
    
    public RenderTFBunny(final bbl par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
        this.textureLocDutch = new bjl("twilightforest:textures/model/bunnydutch.png");
        this.textureLocWhite = new bjl("twilightforest:textures/model/bunnywhite.png");
        this.textureLocBrown = new bjl("twilightforest:textures/model/bunnybrown.png");
    }
    
    protected bjl a(final nm par1Entity) {
        if (!(par1Entity instanceof EntityTFBunny)) {
            return this.textureLocDutch;
        }
        switch (((EntityTFBunny)par1Entity).getBunnyType()) {
            default: {
                return this.textureLocDutch;
            }
            case 2: {
                return this.textureLocWhite;
            }
            case 3: {
                return this.textureLocBrown;
            }
        }
    }
}
