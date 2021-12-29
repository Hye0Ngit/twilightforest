// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFHedgeSpider extends cu
{
    public EntityTFHedgeSpider(final fq world) {
        super(world);
        this.ae = "/twilightforest/hedgespider.png";
    }
    
    public boolean g() {
        boolean flag = this.bi.a(this.bw) && this.bi.a((se)this, this.bw).size() == 0 && !this.bi.c(this.bw);
        final int i = iy.b(this.bm);
        final int j = iy.b(this.bw.b);
        final int k = iy.b(this.bo);
        flag &= (this.a(i, j, k) >= 0.0f);
        return flag;
    }
}
