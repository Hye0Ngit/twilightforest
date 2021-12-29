// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class TileEntityTFNagaSpawner extends cj
{
    public TileEntityTFNagaSpawner() {
        this.a("Naga");
        this.a = 0;
    }
    
    public boolean t_() {
        return this.i.a(this.j + 0.5, this.k + 0.5, this.l + 0.5, 50.0) != null;
    }
    
    public void n_() {
        this.c = this.b;
        if (!this.t_()) {
            return;
        }
        final double d = this.j + this.i.r.nextFloat();
        final double d2 = this.k + this.i.r.nextFloat();
        final double d3 = this.l + this.i.r.nextFloat();
        this.i.a("smoke", d, d2, d3, 0.0, 0.0, 0.0);
        this.i.a("flame", d, d2, d3, 0.0, 0.0, 0.0);
        this.b += 1000.0f / (this.a + 200.0f);
        while (this.b > 360.0) {
            this.b -= 360.0;
            this.c -= 360.0;
        }
        if (!this.i.F) {
            if (this.a == -1) {
                this.updateDelay();
            }
            if (this.a > 0) {
                --this.a;
                return;
            }
            if (this.i.q == 0) {
                return;
            }
            final acq entityliving = (acq)aao.a("Naga", this.i);
            if (entityliving == null) {
                return;
            }
            final int j = this.i.a((Class)entityliving.getClass(), wu.b((double)this.j, (double)this.k, (double)this.l, (double)(this.j + 1), (double)(this.k + 1), (double)(this.l + 1)).b(100.0, 20.0, 100.0)).size();
            if (j >= 1) {
                this.updateDelay();
                return;
            }
            final double d4 = this.j + (this.i.r.nextDouble() - this.i.r.nextDouble()) * 4.0;
            final double d5 = this.k + this.i.r.nextInt(3) - 1;
            final double d6 = this.l + (this.i.r.nextDouble() - this.i.r.nextDouble()) * 4.0;
            entityliving.c(d4, d5, d6, this.i.r.nextFloat() * 360.0f, 0.0f);
            if (!entityliving.i()) {}
            this.i.a((nn)entityliving);
            for (int k = 0; k < 20; ++k) {
                final double d7 = this.j + 0.5 + (this.i.r.nextFloat() - 0.5) * 2.0;
                final double d8 = this.k + 0.5 + (this.i.r.nextFloat() - 0.5) * 2.0;
                final double d9 = this.l + 0.5 + (this.i.r.nextFloat() - 0.5) * 2.0;
                this.i.a("smoke", d7, d8, d9, 0.0, 0.0, 0.0);
                this.i.a("flame", d7, d8, d9, 0.0, 0.0, 0.0);
            }
            ((EntityTFNaga)entityliving).setHome(this.j, this.k, this.l);
            entityliving.ba();
            this.updateDelay();
            this.i.g(this.j, this.k, this.l, 0);
        }
    }
    
    private void updateDelay() {
        this.a = 200 + this.i.r.nextInt(600);
    }
}
