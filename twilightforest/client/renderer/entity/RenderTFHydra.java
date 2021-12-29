// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.entity.EntityTFHydra;

public class RenderTFHydra extends bhb
{
    private static final bjl textureLoc;
    
    public RenderTFHydra(final bbl modelbase, final float f) {
        super(modelbase, f);
    }
    
    public void a(final nm entity, final double d, final double d1, final double d2, final float f, final float f1) {
        super.a(entity, d, d1, d2, f, f1);
        bew.a((sf)entity, false);
    }
    
    protected float a(final oe par1EntityLiving) {
        return 0.0f;
    }
    
    protected bjl a(final nm par1Entity) {
        return RenderTFHydra.textureLoc;
    }
    
    static {
        textureLoc = new bjl("twilightforest:textures/model/hydra4.png");
    }
}
