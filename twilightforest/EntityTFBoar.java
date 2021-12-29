// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFBoar extends pd
{
    public EntityTFBoar(final xv world) {
        super(world);
        this.aF = "/twilightforest/wildboar.png";
        this.a(0.9f, 0.9f);
    }
    
    public EntityTFBoar(final xv world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    public ox func_90011_a(final ln entityanimal) {
        return (ox)new EntityTFBoar(this.p);
    }
    
    public void a(final lh par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.f() instanceof qx) {
            ((qx)par1DamageSource.f()).a((jl)TFAchievementPage.twilightHunter);
        }
    }
}
