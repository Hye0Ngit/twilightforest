import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFBighorn extends eh
{
    public EntityTFBighorn(final ge world) {
        super(world);
        this.ae = "/twilightforest/bighorn.png";
        this.b(0.9f, 1.3f);
    }
    
    public EntityTFBighorn(final ge world, final double x, final double y, final double z) {
        this(world);
        this.c(x, y, z);
    }
    
    public static int getRandomFleeceColor(final Random random) {
        if (random.nextInt(2) == 0) {
            return 12;
        }
        return random.nextInt(15);
    }
    
    public void d_(final int i) {
        if (i == 0) {
            super.d_(getRandomFleeceColor(this.bS));
        }
        else {
            super.d_(i);
        }
    }
    
    public br a(final br entityanimal) {
        final EntityTFBighorn otherParent = (EntityTFBighorn)entityanimal;
        final EntityTFBighorn babySheep = new EntityTFBighorn(this.bi);
        if (this.bS.nextBoolean()) {
            babySheep.d_(this.x());
        }
        else {
            babySheep.d_(otherParent.x());
        }
        return (br)babySheep;
    }
    
    public void a(final rq par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.b() instanceof ih) {
            ((ih)par1DamageSource.b()).a((xo)TFAchievementPage.twilightHunter);
        }
    }
}
