// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import twilightforest.entity.EntityTFNaga;

public class RenderTFNaga extends bcj
{
    public RenderTFNaga(final axa modelbase, final float f) {
        super(modelbase, f);
    }
    
    public void a(final lq entity, final double d, final double d1, final double d2, final float f, final float f1) {
        super.a(entity, d, d1, d2, f, f1);
        if (entity instanceof EntityTFNaga) {
            bai.a((pl)entity, false);
        }
    }
}
