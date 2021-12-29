// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.entity.passive.EntityTFTinyBird;

public class RenderTFTinyBird extends RenderTFBird
{
    final bjl textureLocSparrow;
    final bjl textureLocFinch;
    final bjl textureLocCardinal;
    final bjl textureLocBluebird;
    
    public RenderTFTinyBird(final bbl par1ModelBase, final float par2) {
        super(par1ModelBase, par2, "tinybirdbrown.png");
        this.textureLocSparrow = new bjl("twilightforest:textures/model/tinybirdbrown.png");
        this.textureLocFinch = new bjl("twilightforest:textures/model/tinybirdgold.png");
        this.textureLocCardinal = new bjl("twilightforest:textures/model/tinybirdred.png");
        this.textureLocBluebird = new bjl("twilightforest:textures/model/tinybirdblue.png");
    }
    
    @Override
    protected bjl a(final nm par1Entity) {
        if (!(par1Entity instanceof EntityTFTinyBird)) {
            return this.textureLocSparrow;
        }
        switch (((EntityTFTinyBird)par1Entity).getBirdType()) {
            default: {
                return this.textureLocSparrow;
            }
            case 1: {
                return this.textureLocBluebird;
            }
            case 2: {
                return this.textureLocCardinal;
            }
            case 3: {
                return this.textureLocFinch;
            }
        }
    }
}
