// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import twilightforest.TFAchievementPage;
import java.util.Random;

public class EntityTFBighorn extends ry
{
    public EntityTFBighorn(final abv world) {
        super(world);
        this.a(0.9f, 1.3f);
    }
    
    public EntityTFBighorn(final abv world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    public static int a(final Random random) {
        if (random.nextInt(2) == 0) {
            return 12;
        }
        return random.nextInt(15);
    }
    
    public oh a(oh par1EntityLivingData) {
        par1EntityLivingData = super.a(par1EntityLivingData);
        this.p(a(this.q.s));
        return par1EntityLivingData;
    }
    
    public ro createChild(final nj entityanimal) {
        final EntityTFBighorn otherParent = (EntityTFBighorn)entityanimal;
        final EntityTFBighorn babySheep = new EntityTFBighorn(this.q);
        if (this.ab.nextBoolean()) {
            babySheep.p(this.bT());
        }
        else {
            babySheep.p(otherParent.bT());
        }
        return (ro)babySheep;
    }
    
    public void a(final na par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof ue) {
            ((ue)par1DamageSource.h()).a((kt)TFAchievementPage.twilightHunter);
        }
    }
}
