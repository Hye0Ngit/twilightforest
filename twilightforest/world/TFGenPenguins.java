// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.entity.Entity;
import twilightforest.entity.passive.EntityTFPenguin;
import java.util.Random;
import net.minecraft.world.World;

public class TFGenPenguins extends TFGenerator
{
    @Override
    public boolean func_76484_a(final World world, final Random rand, final int x, final int y, final int z) {
        for (int i = 0; i < 10; ++i) {
            final int dx = x + rand.nextInt(8) - rand.nextInt(8);
            final int dz = z + rand.nextInt(8) - rand.nextInt(8);
            final int dy = world.func_72825_h(dx, dz);
            final EntityTFPenguin penguin = new EntityTFPenguin(world);
            penguin.func_70012_b((double)dx, (double)dy, (double)dz, rand.nextFloat() * 360.0f, 0.0f);
            world.func_72838_d((Entity)penguin);
        }
        return true;
    }
}
