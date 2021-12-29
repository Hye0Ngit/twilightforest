// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityAITFMagicAttack extends abd
{
    public EntityAITFMagicAttack(final ne par1EntityLiving, final float par2, final int par3, final int par4) {
        super(par1EntityLiving, par2, par3, par4);
    }
    
    public void e() {
        final double var1 = 100.0;
        final double var2 = this.b.e(this.c.bm, this.c.bw.b, this.c.bo);
        final boolean var3 = this.b.am().a((tv)this.c);
        if (var3) {
            ++this.f;
        }
        else {
            this.f = 0;
        }
        if (var2 <= var1 && this.f >= 20) {
            this.b.al().f();
        }
        else {
            this.b.al().a(this.c, this.e);
        }
        this.b.ai().a((tv)this.c, 30.0f, 30.0f);
        this.d = Math.max(this.d - 1, 0);
        if (this.d <= 0 && var2 <= var1 && var3) {
            this.doRangedAttack();
            this.d = this.h;
        }
    }
    
    protected void doRangedAttack() {
        if (this.g == 1) {
            final bj projectile = new EntityTFNatureBolt(this.a, this.b);
            final double tx = this.c.bm - this.b.bm;
            final double ty = this.c.bn + this.c.B() - 1.100000023841858 - projectile.bn;
            final double tz = this.c.bo - this.b.bo;
            final float heightOffset = kb.a(tx * tx + tz * tz) * 0.2f;
            projectile.a(tx, ty + heightOffset, tz, 0.6f, 6.0f);
            this.a.a((tv)this.b, "mob.ghast.fireball", 1.0f, 1.0f / (this.b.an().nextFloat() * 0.4f + 0.8f));
            this.a.b((tv)projectile);
        }
    }
}
