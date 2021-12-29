// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TileEntityTFBossSpawner extends ze
{
    public TileEntityTFBossSpawner() {
        this.a("Naga");
        this.a = 0;
    }
    
    public boolean c() {
        return this.c.a(this.d + 0.5, this.e + 0.5, this.f + 0.5, 50.0) != null;
    }
    
    public void b() {
        this.j = this.b;
        if (!this.c()) {
            return;
        }
        final double d = this.d + this.c.w.nextFloat();
        final double d2 = this.e + this.c.w.nextFloat();
        final double d3 = this.f + this.c.w.nextFloat();
        this.c.a("smoke", d, d2, d3, 0.0, 0.0, 0.0);
        this.c.a("flame", d, d2, d3, 0.0, 0.0, 0.0);
        this.b += 1000.0f / (this.a + 200.0f);
        while (this.b > 360.0) {
            this.b -= 360.0;
            this.j -= 360.0;
        }
        if (!this.c.I) {
            if (this.a == -1) {
                this.updateDelay();
            }
            if (this.a > 0) {
                --this.a;
                return;
            }
            if (this.c.v == 0) {
                return;
            }
            final nq entityliving = (nq)afw.a(this.a(), this.c);
            if (entityliving == null) {
                return;
            }
            final int j = this.c.a((Class)entityliving.getClass(), c.b((double)this.d, (double)this.e, (double)this.f, (double)(this.d + 1), (double)(this.e + 1), (double)(this.f + 1)).b(100.0, 20.0, 100.0)).size();
            if (j >= 1) {
                this.updateDelay();
                return;
            }
            final double d4 = this.d + (this.c.w.nextDouble() - this.c.w.nextDouble()) * 4.0;
            final double d5 = this.e + this.c.w.nextInt(3) - 1;
            final double d6 = this.f + (this.c.w.nextDouble() - this.c.w.nextDouble()) * 4.0;
            entityliving.c(d4, d5, d6, this.c.w.nextFloat() * 360.0f, 0.0f);
            if (!entityliving.i()) {}
            this.c.a((ia)entityliving);
            for (int k = 0; k < 20; ++k) {
                final double d7 = this.d + 0.5 + (this.c.w.nextFloat() - 0.5) * 2.0;
                final double d8 = this.e + 0.5 + (this.c.w.nextFloat() - 0.5) * 2.0;
                final double d9 = this.f + 0.5 + (this.c.w.nextFloat() - 0.5) * 2.0;
                this.c.a("smoke", d7, d8, d9, 0.0, 0.0, 0.0);
                this.c.a("flame", d7, d8, d9, 0.0, 0.0, 0.0);
            }
            ((EntityTFNaga)entityliving).setHome(this.d, this.e, this.f);
            entityliving.af();
            this.updateDelay();
            this.c.g(this.d, this.e, this.f, 0);
        }
    }
    
    private void updateDelay() {
        this.a = 200 + this.c.w.nextInt(600);
    }
}
