// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

public class RenderTFBighorn extends bhh
{
    private static final bjl textureLoc;
    
    public RenderTFBighorn(final bbl par1ModelBase, final bbl par2ModelBase, final float par3) {
        super(par1ModelBase, par2ModelBase, par3);
    }
    
    protected bjl a(final nm par1Entity) {
        return RenderTFBighorn.textureLoc;
    }
    
    static {
        textureLoc = new bjl("twilightforest:textures/model/bighorn.png");
    }
}
