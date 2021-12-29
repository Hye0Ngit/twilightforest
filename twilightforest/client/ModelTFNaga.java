// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import twilightforest.EntityTFNagaSegment;
import twilightforest.EntityTFNaga;

public class ModelTFNaga extends awt
{
    public axx head;
    public axx body;
    
    public ModelTFNaga() {
        (this.head = new axx((awt)this, 0, 0)).a(-8.0f, -12.0f, -8.0f, 16, 16, 16, 0.0f);
        this.head.a(0.0f, 0.0f, 0.0f);
        (this.body = new axx((awt)this, 0, 0)).a(-8.0f, -4.0f, -8.0f, 16, 16, 16, 0.0f);
        this.body.a(0.0f, 0.0f, 0.0f);
    }
    
    public void a(final lq entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.a(entity, f, f1, f2, f3, f4, f5);
        this.a(f, f1, f2, f3, f4, f5, entity);
        if (entity instanceof EntityTFNaga) {
            this.head.a(f5 * 2.0f);
        }
        else if (entity instanceof EntityTFNagaSegment) {
            this.body.a(f5 * 2.0f);
        }
        else {
            this.head.a(f5 * 2.0f);
        }
    }
}
