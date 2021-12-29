// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TileEntityTFBossSpawner extends dx
{
    public TileEntityTFBossSpawner() {
        this.a("Naga");
        this.a = 0;
    }
    
    public boolean c() {
        return this.k.a(this.l + 0.5, this.m + 0.5, this.n + 0.5, 50.0) != null;
    }
    
    public void q_() {
        this.c = this.b;
        if (!this.c()) {
            return;
        }
        final double d = this.l + this.k.r.nextFloat();
        final double d2 = this.m + this.k.r.nextFloat();
        final double d3 = this.n + this.k.r.nextFloat();
        this.k.a("smoke", d, d2, d3, 0.0, 0.0, 0.0);
        this.k.a("flame", d, d2, d3, 0.0, 0.0, 0.0);
        this.b += 1000.0f / (this.a + 200.0f);
        while (this.b > 360.0) {
            this.b -= 360.0;
            this.c -= 360.0;
        }
        if (!this.k.F) {
            if (this.a == -1) {
                this.updateDelay();
            }
            if (this.a > 0) {
                --this.a;
                return;
            }
            if (this.k.q == 0) {
                return;
            }
            final ne entityliving = (ne)kr.a(this.getMobID(), this.k);
            if (entityliving == null) {
                return;
            }
            final int j = this.k.a((Class)entityliving.getClass(), fp.b((double)this.l, (double)this.m, (double)this.n, (double)(this.l + 1), (double)(this.m + 1), (double)(this.n + 1)).b(100.0, 20.0, 100.0)).size();
            if (j >= 1) {
                this.updateDelay();
                return;
            }
            final double d4 = this.l + (this.k.r.nextDouble() - this.k.r.nextDouble()) * 4.0;
            final double d5 = this.m + this.k.r.nextInt(3) - 1;
            final double d6 = this.n + (this.k.r.nextDouble() - this.k.r.nextDouble()) * 4.0;
            entityliving.c(d4, d5, d6, this.k.r.nextFloat() * 360.0f, 0.0f);
            if (!entityliving.l()) {}
            this.k.b((tv)entityliving);
            for (int k = 0; k < 20; ++k) {
                final double d7 = this.l + 0.5 + (this.k.r.nextFloat() - 0.5) * 2.0;
                final double d8 = this.m + 0.5 + (this.k.r.nextFloat() - 0.5) * 2.0;
                final double d9 = this.n + 0.5 + (this.k.r.nextFloat() - 0.5) * 2.0;
                this.k.a("smoke", d7, d8, d9, 0.0, 0.0, 0.0);
                this.k.a("flame", d7, d8, d9, 0.0, 0.0, 0.0);
            }
            ((EntityTFNaga)entityliving).setHome(this.l, this.m, this.n);
            entityliving.aC();
            this.updateDelay();
            this.k.e(this.l, this.m, this.n, 0);
        }
    }
    
    private void updateDelay() {
        this.a = 200 + this.k.r.nextInt(600);
    }
    
    private String getMobID() {
        return "Naga";
    }
}
