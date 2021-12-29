// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

public class ModelTFSkeletonDruid extends aww
{
    public ayf dress;
    
    public ModelTFSkeletonDruid() {
        final float f = 0.0f;
        (this.e = new ayf((axa)this, 8, 16)).a(-4.0f, 0.0f, -2.0f, 8, 12, 4, f);
        this.e.a(0.0f, 0.0f + f, 0.0f);
        (this.f = new ayf((axa)this, 0, 16)).a(-1.0f, -2.0f, -1.0f, 2, 12, 2, f);
        this.f.a(-5.0f, 2.0f, 0.0f);
        this.g = new ayf((axa)this, 0, 16);
        this.g.i = true;
        this.g.a(-1.0f, -2.0f, -1.0f, 2, 12, 2, f);
        this.g.a(5.0f, 2.0f, 0.0f);
        (this.h = new ayf((axa)this, 0, 16)).a(-1.0f, 0.0f, -1.0f, 2, 12, 2);
        this.h.a(-2.0f, 12.0f, 0.0f);
        this.i = new ayf((axa)this, 0, 16);
        this.i.i = true;
        this.i.a(-1.0f, 0.0f, -1.0f, 2, 12, 2);
        this.i.a(2.0f, 12.0f, 0.0f);
        (this.dress = new ayf((axa)this, 40, 16)).a(-4.0f, 12.0f, -2.0f, 8, 12, 4, f);
        this.dress.a(0.0f, 0.0f, 0.0f);
    }
    
    public void a(final lq entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.a(entity, f, f1, f2, f3, f4, f5);
        this.dress.a(f5);
    }
}
