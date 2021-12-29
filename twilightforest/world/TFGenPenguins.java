// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.entity.EntityTFPenguin;
import java.util.Random;

public class TFGenPenguins extends TFGenerator
{
    @Override
    public boolean a(final zv world, final Random rand, final int x, final int y, final int z) {
        for (int i = 0; i < 10; ++i) {
            final int dx = x + rand.nextInt(8) - rand.nextInt(8);
            final int dz = z + rand.nextInt(8) - rand.nextInt(8);
            final int dy = world.i(dx, dz);
            final EntityTFPenguin penguin = new EntityTFPenguin(world);
            penguin.b((double)dx, (double)dy, (double)dz, rand.nextFloat() * 360.0f, 0.0f);
            world.d((mp)penguin);
        }
        return true;
    }
}
