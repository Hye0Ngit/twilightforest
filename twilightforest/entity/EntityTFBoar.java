// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;

public class EntityTFBoar extends qh
{
    public EntityTFBoar(final zv world) {
        super(world);
        this.aH = "/mods/twilightforest/textures/model/wildboar.png";
        this.a(0.9f, 0.9f);
    }
    
    public EntityTFBoar(final zv world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    public qb createChild(final mm entityanimal) {
        return (qb)new EntityTFBoar(this.q);
    }
    
    public void a(final mg par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof sk) {
            ((sk)par1DamageSource.h()).a((ka)TFAchievementPage.twilightHunter);
        }
    }
}
