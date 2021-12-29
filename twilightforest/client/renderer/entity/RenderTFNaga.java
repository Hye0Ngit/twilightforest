// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.entity.EntityTFNaga;

public class RenderTFNaga extends bhb
{
    private static final bjl textureLoc;
    
    public RenderTFNaga(final bbl modelbase, final float f) {
        super(modelbase, f);
    }
    
    public void a(final nm entity, final double d, final double d1, final double d2, final float f, final float f1) {
        super.a(entity, d, d1, d2, f, f1);
        if (entity instanceof EntityTFNaga && ((EntityTFNaga)entity).an() != null) {
            final EntityTFNaga naga = (EntityTFNaga)entity;
            for (int i = 0; i < naga.an().length; ++i) {
                if (!naga.an()[i].M) {
                    bgi.a.a(naga.an()[i], f1);
                }
            }
            bew.a((sf)naga, false);
        }
    }
    
    protected bjl a(final nm par1Entity) {
        return RenderTFNaga.textureLoc;
    }
    
    static {
        textureLoc = new bjl("twilightforest:textures/model/nagahead.png");
    }
}
