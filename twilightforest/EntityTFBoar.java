// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFBoar extends qr
{
    public EntityTFBoar(final xd world) {
        super(world);
        this.bm = "/twilightforest/wildboar.png";
        this.a(0.9f, 0.9f);
    }
    
    public EntityTFBoar(final xd world, final double x, final double y, final double z) {
        this(world);
        this.d(x, y, z);
    }
    
    public bc a(final bc entityanimal) {
        return (bc)new EntityTFBoar(this.k);
    }
    
    public void a(final md par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.b() instanceof yw) {
            ((yw)par1DamageSource.b()).a((ajw)TFAchievementPage.twilightHunter);
        }
    }
}
