// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

public class ModelTFRedcap extends aww
{
    ayf goblinRightEar;
    ayf goblinLeftEar;
    
    public ModelTFRedcap() {
        (this.c = new ayf((axa)this, 0, 0)).a(-3.4f, 1.0f, -4.0f, 7, 7, 7, 0.0f);
        this.c.a(0.0f, 0.0f, 0.0f);
        (this.d = new ayf((axa)this, 32, 0)).a(-2.0f, 0.0f, -3.0f, 4, 5, 7, 0.0f);
        this.d.a(0.0f, 0.0f, 0.0f);
        (this.e = new ayf((axa)this, 12, 19)).a(-4.0f, 6.0f, -2.0f, 8, 9, 4, 0.0f);
        this.e.a(0.0f, 0.0f, 0.0f);
        (this.f = new ayf((axa)this, 36, 17)).a(-2.0f, -2.0f, -2.0f, 3, 12, 3, 0.0f);
        this.f.a(-5.0f, 8.0f, 0.0f);
        (this.g = new ayf((axa)this, 36, 17)).a(-1.0f, -2.0f, -2.0f, 3, 12, 3, 0.0f);
        this.g.a(5.0f, 8.0f, 0.0f);
        (this.h = new ayf((axa)this, 0, 20)).a(-2.0f, 2.0f, -1.0f, 3, 9, 3, 0.0f);
        this.h.a(-2.0f, 12.0f, 0.0f);
        (this.i = new ayf((axa)this, 0, 20)).a(-1.0f, 3.0f, -1.0f, 3, 9, 3, 0.0f);
        this.i.a(2.0f, 12.0f, 0.0f);
        (this.goblinRightEar = new ayf((axa)this, 48, 20)).a(3.0f, -2.0f, -1.0f, 2, 3, 1, 0.0f);
        this.goblinRightEar.a(0.0f, 3.0f, 0.0f);
        (this.goblinLeftEar = new ayf((axa)this, 48, 24)).a(-5.0f, -2.0f, -1.0f, 2, 3, 1, 0.0f);
        this.goblinLeftEar.a(0.0f, 3.0f, 0.0f);
        this.goblinLeftEar.i = true;
    }
    
    public void a(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final lq entity) {
        super.a(f, f1, f2, f3, f4, f5, entity);
        this.goblinRightEar.f = this.c.f;
        this.goblinRightEar.g = this.c.g;
        this.goblinRightEar.h = this.c.h;
        this.goblinLeftEar.f = this.c.f;
        this.goblinLeftEar.g = this.c.g;
        this.goblinLeftEar.h = this.c.h;
    }
    
    public void a(final lq entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.a(entity, f, f1, f2, f3, f4, f5);
        this.goblinRightEar.a(f5);
        this.goblinLeftEar.a(f5);
    }
}
