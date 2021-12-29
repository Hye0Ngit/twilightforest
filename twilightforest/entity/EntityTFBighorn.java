// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;
import java.util.Random;

public class EntityTFBighorn extends pe
{
    public EntityTFBighorn(final yc world) {
        super(world);
        this.aG = "/twilightforest/bighorn.png";
        this.a(0.9f, 1.3f);
    }
    
    public EntityTFBighorn(final yc world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    public static int getRandomFleeceColor(final Random random) {
        if (random.nextInt(2) == 0) {
            return 12;
        }
        return random.nextInt(15);
    }
    
    public void bG() {
        this.s(getRandomFleeceColor(this.p.t));
    }
    
    public ox func_90011_a(final ln entityanimal) {
        final EntityTFBighorn otherParent = (EntityTFBighorn)entityanimal;
        final EntityTFBighorn babySheep = new EntityTFBighorn(this.p);
        if (this.aa.nextBoolean()) {
            babySheep.s(this.m());
        }
        else {
            babySheep.s(otherParent.m());
        }
        return (ox)babySheep;
    }
    
    public void a(final lh par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.f() instanceof qx) {
            ((qx)par1DamageSource.f()).a((jl)TFAchievementPage.twilightHunter);
        }
    }
}
