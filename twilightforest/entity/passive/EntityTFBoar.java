// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import twilightforest.TFAchievementPage;

public class EntityTFBoar extends rx
{
    public EntityTFBoar(final abv world) {
        super(world);
        this.a(0.9f, 0.9f);
    }
    
    public EntityTFBoar(final abv world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    public ro createChild(final nj entityanimal) {
        return (ro)new EntityTFBoar(this.q);
    }
    
    public void a(final na par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof ue) {
            ((ue)par1DamageSource.h()).a((kt)TFAchievementPage.twilightHunter);
        }
    }
}
