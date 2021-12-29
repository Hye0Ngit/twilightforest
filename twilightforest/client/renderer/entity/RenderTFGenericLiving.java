// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

public class RenderTFGenericLiving extends bhb
{
    final bjl textureLoc;
    
    public RenderTFGenericLiving(final bbl par1ModelBase, final float par2, final String textureName) {
        super(par1ModelBase, par2);
        if (textureName.startsWith("textures")) {
            this.textureLoc = new bjl(textureName);
        }
        else {
            this.textureLoc = new bjl("twilightforest:textures/model/" + textureName);
        }
    }
    
    protected bjl a(final nm par1Entity) {
        return this.textureLoc;
    }
}
