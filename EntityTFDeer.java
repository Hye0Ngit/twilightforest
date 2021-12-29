// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFDeer extends cn
{
    public EntityTFDeer(final ge world) {
        super(world);
        this.ae = "/twilightforest/wilddeer.png";
        this.b(0.7f, 2.3f);
    }
    
    public EntityTFDeer(final ge world, final double x, final double y, final double z) {
        this(world);
        this.c(x, y, z);
    }
    
    protected String i() {
        return null;
    }
    
    public boolean b(final ih entityplayer) {
        final kp itemstack = entityplayer.k.d();
        return (itemstack == null || itemstack.c != id.av.bP) && super.b(entityplayer);
    }
    
    public br a(final br entityanimal) {
        return (br)new EntityTFDeer(this.bi);
    }
    
    public void a(final rq par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.b() instanceof ih) {
            ((ih)par1DamageSource.b()).a((xo)TFAchievementPage.twilightHunter);
        }
    }
}
