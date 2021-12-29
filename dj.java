// 
// Decompiled by Procyon v0.6-prerelease
// 

public class dj extends ow
{
    public int a;
    private String d;
    public double b;
    public double c;
    
    public dj() {
        this.a = -1;
        this.c = 0.0;
        this.d = "Pig";
        this.a = 20;
    }
    
    public void a(final String s) {
        this.d = s;
    }
    
    public boolean c() {
        return this.k.a(this.l + 0.5, this.m + 0.5, this.n + 0.5, 16.0) != null;
    }
    
    public void l_() {
        this.c = this.b;
        if (!this.c()) {
            return;
        }
        final double d = this.l + this.k.w.nextFloat();
        final double d2 = this.m + this.k.w.nextFloat();
        final double d3 = this.n + this.k.w.nextFloat();
        this.k.a("smoke", d, d2, d3, 0.0, 0.0, 0.0);
        this.k.a("flame", d, d2, d3, 0.0, 0.0, 0.0);
        this.b += 1000.0f / (this.a + 200.0f);
        while (this.b > 360.0) {
            this.b -= 360.0;
            this.c -= 360.0;
        }
        if (!this.k.I) {
            if (this.a == -1) {
                this.e();
            }
            if (this.a > 0) {
                --this.a;
                return;
            }
            final byte byte0 = 4;
            for (int i = 0; i < byte0; ++i) {
                final lx entityliving = (lx)jo.a(this.d, this.k);
                if (entityliving == null) {
                    return;
                }
                final int j = this.k.a((Class)entityliving.getClass(), fb.b((double)this.l, (double)this.m, (double)this.n, (double)(this.l + 1), (double)(this.m + 1), (double)(this.n + 1)).b(8.0, 4.0, 8.0)).size();
                if (j >= 6) {
                    this.e();
                    return;
                }
                if (entityliving != null) {
                    final double d4 = this.l + (this.k.w.nextDouble() - this.k.w.nextDouble()) * 4.0;
                    final double d5 = this.m + this.k.w.nextInt(3) - 1;
                    final double d6 = this.n + (this.k.w.nextDouble() - this.k.w.nextDouble()) * 4.0;
                    entityliving.c(d4, d5, d6, this.k.w.nextFloat() * 360.0f, 0.0f);
                    if (entityliving.g()) {
                        this.k.b((se)entityliving);
                        this.k.f(2004, this.l, this.m, this.n, 0);
                        entityliving.ao();
                        this.e();
                    }
                }
            }
        }
        super.l_();
    }
    
    private void e() {
        this.a = 200 + this.k.w.nextInt(600);
    }
    
    public void a(final nu nbttagcompound) {
        super.a(nbttagcompound);
        this.d = nbttagcompound.j("EntityId");
        this.a = nbttagcompound.e("Delay");
    }
    
    public void b(final nu nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.a("EntityId", this.d);
        nbttagcompound.a("Delay", (short)this.a);
    }
    
    public String getMobID() {
        return this.d;
    }
}
