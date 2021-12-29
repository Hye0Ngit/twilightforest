// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ModelTFWraith extends wn
{
    public ql dress;
    
    public ModelTFWraith() {
        final float f = 0.0f;
        (this.dress = new ql((hl)this, 40, 16)).a(-4.0f, 12.0f, -2.0f, 8, 12, 4, f);
        this.dress.a(0.0f, 0.0f, 0.0f);
    }
    
    public void a(final nk entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        this.a(f, f1, f2, f3, f4, f5);
        this.c.a(f5);
        this.e.a(f5);
        this.f.a(f5);
        this.g.a(f5);
        this.dress.a(f5);
    }
}
