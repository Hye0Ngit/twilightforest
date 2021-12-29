// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import twilightforest.EntityTFNaga;

public class RenderTFNaga extends bby
{
    public RenderTFNaga(final awt modelbase, final float f) {
        super(modelbase, f);
    }
    
    public void a(final lq entity, final double d, final double d1, final double d2, final float f, final float f1) {
        super.a(entity, d, d1, d2, f, f1);
        if (entity instanceof EntityTFNaga) {
            azx.a((pl)entity, false);
        }
    }
}
