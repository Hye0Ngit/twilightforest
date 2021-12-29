// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;
import java.util.Random;

public class EntityTFBighorn extends qi
{
    public EntityTFBighorn(final zv world) {
        super(world);
        this.aH = "/mods/twilightforest/textures/model/bighorn.png";
        this.a(0.9f, 1.3f);
    }
    
    public EntityTFBighorn(final zv world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    public static int getRandomFleeceColor(final Random random) {
        if (random.nextInt(2) == 0) {
            return 12;
        }
        return random.nextInt(15);
    }
    
    public void bJ() {
        this.s(getRandomFleeceColor(this.q.s));
    }
    
    public qb createChild(final mm entityanimal) {
        final EntityTFBighorn otherParent = (EntityTFBighorn)entityanimal;
        final EntityTFBighorn babySheep = new EntityTFBighorn(this.q);
        if (this.ab.nextBoolean()) {
            babySheep.s(this.m());
        }
        else {
            babySheep.s(otherParent.m());
        }
        return (qb)babySheep;
    }
    
    public void a(final mg par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof sk) {
            ((sk)par1DamageSource.h()).a((ka)TFAchievementPage.twilightHunter);
        }
    }
}
