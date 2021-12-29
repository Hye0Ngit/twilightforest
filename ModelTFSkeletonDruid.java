// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ModelTFSkeletonDruid extends afg
{
    public acf dress;
    
    public ModelTFSkeletonDruid() {
        final float f = 0.0f;
        (this.i = new acf((al)this, 8, 16)).a(-4.0f, 0.0f, -2.0f, 8, 12, 4, f);
        this.i.a(0.0f, 0.0f + f, 0.0f);
        (this.j = new acf((al)this, 0, 16)).a(-1.0f, -2.0f, -1.0f, 2, 12, 2, f);
        this.j.a(-5.0f, 2.0f, 0.0f);
        this.k = new acf((al)this, 0, 16);
        this.k.i = true;
        this.k.a(-1.0f, -2.0f, -1.0f, 2, 12, 2, f);
        this.k.a(5.0f, 2.0f, 0.0f);
        (this.dress = new acf((al)this, 40, 16)).a(-4.0f, 12.0f, -2.0f, 8, 12, 4, f);
        this.dress.a(0.0f, 0.0f, 0.0f);
    }
    
    public void a(final ia entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.a(entity, f, f1, f2, f3, f4, f5);
        this.dress.a(f5);
    }
}
