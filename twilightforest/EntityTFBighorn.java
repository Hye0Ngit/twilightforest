// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Random;

public class EntityTFBighorn extends cu
{
    public EntityTFBighorn(final xd world) {
        super(world);
        this.bm = "/twilightforest/bighorn.png";
        this.a(0.9f, 1.3f);
    }
    
    public EntityTFBighorn(final xd world, final double x, final double y, final double z) {
        this(world);
        this.d(x, y, z);
    }
    
    public static int getRandomFleeceColor(final Random random) {
        if (random.nextInt(2) == 0) {
            return 12;
        }
        return random.nextInt(15);
    }
    
    public void c_(final int i) {
        if (i == 0) {
            super.c_(getRandomFleeceColor(this.U));
        }
        else {
            super.c_(i);
        }
    }
    
    public bc a(final bc entityanimal) {
        final EntityTFBighorn otherParent = (EntityTFBighorn)entityanimal;
        final EntityTFBighorn babySheep = new EntityTFBighorn(this.k);
        if (this.U.nextBoolean()) {
            babySheep.c_(this.t());
        }
        else {
            babySheep.c_(otherParent.t());
        }
        return (bc)babySheep;
    }
    
    public void a(final md par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.b() instanceof yw) {
            ((yw)par1DamageSource.b()).a((ajw)TFAchievementPage.twilightHunter);
        }
    }
}
