// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class TileEntityTFLichSpawner extends anl
{
    public TileEntityTFLichSpawner() {
        this.a(TFCreatures.getSpawnerNameFor("Twilight Lich"));
        this.a = 0;
    }
    
    public boolean b() {
        final qx closestPlayer = this.k.a(this.l + 0.5, this.m + 0.5, this.n + 0.5, 9.0);
        return closestPlayer != null && closestPlayer.u > this.m - 2;
    }
    
    public void g() {
        this.c = this.b;
        if (!this.b()) {
            return;
        }
        final double d = this.l + this.k.u.nextFloat();
        final double d2 = this.m + this.k.u.nextFloat();
        final double d3 = this.n + this.k.u.nextFloat();
        this.k.a("smoke", d, d2, d3, 0.0, 0.0, 0.0);
        this.k.a("flame", d, d2, d3, 0.0, 0.0, 0.0);
        this.b += 1000.0f / (this.a + 200.0f);
        while (this.b > 360.0) {
            this.b -= 360.0;
            this.c -= 360.0;
        }
        if (!this.k.J) {
            if (this.a == -1) {
                this.updateDelay();
            }
            if (this.a > 0) {
                --this.a;
                return;
            }
            if (this.k.t == 0) {
                return;
            }
            final md entityliving = (md)lv.a(TFCreatures.getSpawnerNameFor("Twilight Lich"), this.k);
            if (entityliving == null) {
                return;
            }
            final int j = this.k.a((Class)entityliving.getClass(), anw.a().a((double)this.l, (double)this.m, (double)this.n, (double)(this.l + 1), (double)(this.m + 1), (double)(this.n + 1)).b(30.0, 30.0, 30.0)).size();
            if (j >= 1) {
                this.updateDelay();
                return;
            }
            final double d4 = this.l + (this.k.u.nextDouble() - this.k.u.nextDouble()) * 4.0;
            final double d5 = this.m + this.k.u.nextInt(3) - 1;
            final double d6 = this.n + (this.k.u.nextDouble() - this.k.u.nextDouble()) * 4.0;
            entityliving.b(d4, d5, d6, this.k.u.nextFloat() * 360.0f, 0.0f);
            if (!entityliving.bs()) {}
            this.k.d((lq)entityliving);
            for (int k = 0; k < 20; ++k) {
                final double d7 = this.l + 0.5 + (this.k.u.nextFloat() - 0.5) * 2.0;
                final double d8 = this.m + 0.5 + (this.k.u.nextFloat() - 0.5) * 2.0;
                final double d9 = this.n + 0.5 + (this.k.u.nextFloat() - 0.5) * 2.0;
                this.k.a("smoke", d7, d8, d9, 0.0, 0.0, 0.0);
                this.k.a("flame", d7, d8, d9, 0.0, 0.0, 0.0);
            }
            entityliving.aR();
            this.updateDelay();
            this.k.e(this.l, this.m, this.n, 0);
        }
    }
    
    private void updateDelay() {
        this.a = 200 + this.k.u.nextInt(600);
    }
}
