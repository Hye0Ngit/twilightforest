// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFDeer extends un
{
    public EntityTFDeer(final xd world) {
        super(world);
        this.bm = "/twilightforest/wilddeer.png";
        this.a(0.7f, 2.3f);
    }
    
    public EntityTFDeer(final xd world, final double x, final double y, final double z) {
        this(world);
        this.d(x, y, z);
    }
    
    protected String m() {
        return null;
    }
    
    public boolean c(final yw entityplayer) {
        final aan itemstack = entityplayer.ap.b();
        return (itemstack == null || itemstack.c != yr.aw.bQ) && super.c(entityplayer);
    }
    
    public bc a(final bc entityanimal) {
        return (bc)new EntityTFDeer(this.k);
    }
    
    public void a(final md par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.b() instanceof yw) {
            ((yw)par1DamageSource.b()).a((ajw)TFAchievementPage.twilightHunter);
        }
    }
}
