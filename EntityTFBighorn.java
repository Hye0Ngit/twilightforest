import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFBighorn extends dt
{
    public EntityTFBighorn(final fq world) {
        super(world);
        this.ae = "/twilightforest/bighorn.png";
        this.b(0.9f, 1.3f);
    }
    
    public static int getRandomFleeceColor(final Random random) {
        if (random.nextInt(2) == 0) {
            return 12;
        }
        return random.nextInt(15);
    }
    
    public void b(final int i) {
        if (i == 0) {
            super.b(getRandomFleeceColor(this.bS));
        }
        else {
            super.b(i);
        }
    }
    
    protected bm a(final bm entityanimal) {
        final EntityTFBighorn otherParent = (EntityTFBighorn)entityanimal;
        final EntityTFBighorn babySheep = new EntityTFBighorn(this.bi);
        if (this.bS.nextBoolean()) {
            babySheep.b(this.w());
        }
        else {
            babySheep.b(otherParent.w());
        }
        return (bm)babySheep;
    }
}
