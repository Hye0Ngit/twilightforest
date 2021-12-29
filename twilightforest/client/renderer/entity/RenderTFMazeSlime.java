// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

public class RenderTFMazeSlime extends bhk
{
    private static final bjl textureLoc;
    
    public RenderTFMazeSlime(final bbl par1ModelBase, final bbl par2ModelBase, final float par3) {
        super(par1ModelBase, par2ModelBase, par3);
    }
    
    protected bjl a(final nm par1Entity) {
        return RenderTFMazeSlime.textureLoc;
    }
    
    static {
        textureLoc = new bjl("twilightforest:textures/model/mazeslime.png");
    }
}
