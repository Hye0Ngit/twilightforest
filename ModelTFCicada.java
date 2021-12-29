// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ModelTFCicada extends al
{
    public acf legs;
    public acf fatbody;
    public acf skinnybody;
    public acf eye1;
    public acf eye2;
    public acf wings;
    
    public ModelTFCicada() {
        (this.legs = new acf((al)this, 0, 21)).a(-4.0f, 7.9f, -5.0f, 8, 1, 9, 0.0f);
        (this.fatbody = new acf((al)this, 0, 11)).a(-2.0f, 6.0f, -4.0f, 4, 2, 6, 0.0f);
        (this.skinnybody = new acf((al)this, 0, 0)).a(-1.0f, 7.0f, -5.0f, 2, 1, 8, 0.0f);
        (this.eye1 = new acf((al)this, 20, 15)).a(1.0f, 5.0f, 2.0f, 2, 2, 2, 0.0f);
        (this.eye2 = new acf((al)this, 20, 15)).a(-3.0f, 5.0f, 2.0f, 2, 2, 2, 0.0f);
        (this.wings = new acf((al)this, 20, 0)).a(-4.0f, 5.0f, -7.0f, 8, 1, 8, 0.0f);
    }
    
    public void render(final float f5) {
        this.legs.a(f5);
        this.fatbody.a(f5);
        this.skinnybody.a(f5);
        this.eye1.a(f5);
        this.eye2.a(f5);
        this.wings.a(f5);
    }
    
    public void a(final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
    }
}
