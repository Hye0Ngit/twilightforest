// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.entity.Entity;
import twilightforest.entity.passive.EntityTFPenguin;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;

public class TFGenPenguins extends TFGenerator
{
    public boolean func_180709_b(final World world, final Random rand, final BlockPos pos) {
        for (int i = 0; i < 10; ++i) {
            BlockPos dPos = pos.func_177982_a(rand.nextInt(8) - rand.nextInt(8), 0, rand.nextInt(8) - rand.nextInt(8));
            dPos = world.func_175672_r(dPos);
            if (dPos.func_177956_o() > 0) {
                final EntityTFPenguin penguin = new EntityTFPenguin(world);
                penguin.func_174828_a(dPos, rand.nextFloat() * 360.0f, 0.0f);
                world.func_72838_d((Entity)penguin);
            }
        }
        return true;
    }
}
