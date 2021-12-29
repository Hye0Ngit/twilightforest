import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFBighorn extends cs
{
    public EntityTFBighorn(final wz world) {
        super(world);
        this.bm = "/twilightforest/bighorn.png";
        this.a(0.9f, 1.3f);
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
    
    public bb a(final bb entityanimal) {
        final EntityTFBighorn otherParent = (EntityTFBighorn)entityanimal;
        final EntityTFBighorn babySheep = new EntityTFBighorn(this.k);
        if (this.U.nextBoolean()) {
            babySheep.c_(this.s());
        }
        else {
            babySheep.c_(otherParent.s());
        }
        return (bb)babySheep;
    }
}
