// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFHostileWolf extends ib
{
    public EntityTFHostileWolf(final ge world) {
        super(world);
        this.d(true);
        this.ap = 10;
        this.aM.a(4, (zc)new aba((ne)this, (Class)ih.class, 16.0f, 0, true));
    }
    
    public EntityTFHostileWolf(final ge world, final double x, final double y, final double z) {
        this(world);
        this.c(x, y, z);
    }
    
    public void F_() {
        super.F_();
        if (!this.bi.F && this.bi.q == 0) {
            this.X();
        }
    }
    
    public void a(final rq par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.b() instanceof ih) {
            ((ih)par1DamageSource.b()).a((xo)TFAchievementPage.twilightHunter);
        }
    }
}
