// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ModelTFRedcap extends fa
{
    acf goblinRightEar;
    acf goblinLeftEar;
    
    public ModelTFRedcap() {
        (this.g = new acf((al)this, 0, 0)).a(-3.4f, 1.0f, -4.0f, 7, 7, 7, 0.0f);
        this.g.a(0.0f, 0.0f, 0.0f);
        (this.h = new acf((al)this, 32, 0)).a(-2.0f, 0.0f, -3.0f, 4, 5, 7, 0.0f);
        this.h.a(0.0f, 0.0f, 0.0f);
        (this.i = new acf((al)this, 12, 19)).a(-4.0f, 6.0f, -2.0f, 8, 9, 4, 0.0f);
        this.i.a(0.0f, 0.0f, 0.0f);
        (this.j = new acf((al)this, 36, 17)).a(-2.0f, 1.0f, -2.0f, 3, 12, 3, 0.0f);
        this.j.a(-5.0f, 5.0f, 0.0f);
        (this.k = new acf((al)this, 36, 17)).a(-1.0f, 1.0f, -2.0f, 3, 12, 3, 0.0f);
        this.k.a(5.0f, 5.0f, 0.0f);
        (this.l = new acf((al)this, 0, 20)).a(-2.0f, 2.0f, -1.0f, 3, 9, 3, 0.0f);
        this.l.a(-2.0f, 12.0f, 0.0f);
        (this.m = new acf((al)this, 0, 20)).a(-1.0f, 3.0f, -1.0f, 3, 9, 3, 0.0f);
        this.m.a(2.0f, 12.0f, 0.0f);
        (this.goblinRightEar = new acf((al)this, 48, 20)).a(3.0f, -2.0f, -1.0f, 2, 3, 1, 0.0f);
        this.goblinRightEar.a(0.0f, 3.0f, 0.0f);
        (this.goblinLeftEar = new acf((al)this, 48, 24)).a(-5.0f, -2.0f, -1.0f, 2, 3, 1, 0.0f);
        this.goblinLeftEar.a(0.0f, 3.0f, 0.0f);
        this.goblinLeftEar.i = true;
    }
    
    public void a(final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.a(f, f1, f2, f3, f4, f5);
        this.goblinRightEar.f = this.g.f;
        this.goblinRightEar.g = this.g.g;
        this.goblinRightEar.h = this.g.h;
        this.goblinLeftEar.f = this.g.f;
        this.goblinLeftEar.g = this.g.g;
        this.goblinLeftEar.h = this.g.h;
    }
    
    public void a(final ia entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.a(entity, f, f1, f2, f3, f4, f5);
        this.goblinRightEar.a(f5);
        this.goblinLeftEar.a(f5);
    }
}
