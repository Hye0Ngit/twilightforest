import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFBighorn extends hm
{
    public EntityTFBighorn(final ry world) {
        super(world);
        this.aA = "/twilightforest/bighorn.png";
        this.a(0.9f, 1.3f);
    }
    
    public static int getRandomFleeceColor(final Random random) {
        if (random.nextInt(2) == 0) {
            return 12;
        }
        return random.nextInt(15);
    }
    
    public void c(final int i) {
        if (i == 0) {
            super.c(getRandomFleeceColor(this.Y));
        }
        else {
            super.c(i);
        }
    }
    
    protected fx a(final fx entityanimal) {
        final EntityTFBighorn otherParent = (EntityTFBighorn)entityanimal;
        final EntityTFBighorn babySheep = new EntityTFBighorn(this.o);
        if (this.Y.nextBoolean()) {
            babySheep.c(this.l());
        }
        else {
            babySheep.c(otherParent.l());
        }
        return (fx)babySheep;
    }
}
