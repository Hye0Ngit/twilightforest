// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFHedgeSpider extends bz
{
    public EntityTFHedgeSpider(final wz world) {
        super(world);
        this.bm = "/twilightforest/hedgespider.png";
    }
    
    public boolean h() {
        boolean flag = this.k.a(this.y) && this.k.a((nk)this, this.y).size() == 0 && !this.k.b(this.y);
        final int i = gh.c(this.o);
        final int j = gh.c(this.y.b);
        final int k = gh.c(this.q);
        flag &= (this.a(i, j, k) >= 0.0f);
        return flag;
    }
}
