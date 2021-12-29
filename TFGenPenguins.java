import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFGenPenguins extends TFGenerator
{
    @Override
    public boolean a(final wz world, final Random rand, final int x, final int y, final int z) {
        for (int i = 0; i < 10; ++i) {
            final int dx = x + rand.nextInt(8) - rand.nextInt(8);
            final int dz = z + rand.nextInt(8) - rand.nextInt(8);
            final int dy = world.g(dx, dz);
            final EntityTFPenguin penguin = new EntityTFPenguin(world);
            penguin.c((double)dx, (double)dy, (double)dz, rand.nextFloat() * 360.0f, 0.0f);
            world.a((nk)penguin);
        }
        return true;
    }
}
