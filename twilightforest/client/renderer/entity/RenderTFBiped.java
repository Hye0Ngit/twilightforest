// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

public class RenderTFBiped extends bgr
{
    private final bjl textureLoc;
    
    public RenderTFBiped(final bbg modelBiped, final float scale, final String textureName) {
        super(modelBiped, scale);
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
