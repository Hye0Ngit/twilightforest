// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFBoar extends yl
{
    public EntityTFBoar(final ge world) {
        super(world);
        this.ae = "/twilightforest/wildboar.png";
        this.b(0.9f, 0.9f);
    }
    
    public EntityTFBoar(final ge world, final double x, final double y, final double z) {
        this(world);
        this.c(x, y, z);
    }
    
    public br a(final br entityanimal) {
        return (br)new EntityTFBoar(this.bi);
    }
    
    public void a(final rq par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.b() instanceof ih) {
            ((ih)par1DamageSource.b()).a((xo)TFAchievementPage.twilightHunter);
        }
    }
}
