// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

public class RenderTFDeer extends bgc
{
    private static final bjl textureLoc;
    
    public RenderTFDeer(final bbl par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }
    
    protected bjl a(final nm par1Entity) {
        return RenderTFDeer.textureLoc;
    }
    
    static {
        textureLoc = new bjl("twilightforest:textures/model/wilddeer.png");
    }
}
