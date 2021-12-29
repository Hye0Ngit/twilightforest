// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFHedgeSpider extends vq
{
    public EntityTFHedgeSpider(final ry world) {
        super(world);
        this.aA = "/twilightforest/hedgespider.png";
    }
    
    public boolean i() {
        boolean flag = this.o.a(this.C) && this.o.a((ia)this, this.C).size() == 0 && !this.o.b(this.C);
        final int i = me.c(this.s);
        final int j = me.c(this.C.b);
        final int k = me.c(this.u);
        flag &= (this.a(i, j, k) >= 0.0f);
        return flag;
    }
}
