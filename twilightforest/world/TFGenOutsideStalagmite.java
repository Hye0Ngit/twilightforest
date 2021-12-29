// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.init.Blocks;

public class TFGenOutsideStalagmite extends TFGenCaveStalactite
{
    public TFGenOutsideStalagmite() {
        super(Blocks.field_150348_b, 1.0f, false);
    }
    
    @Override
    public boolean func_76484_a(final World world, final Random rand, final int x, final int y, final int z) {
        final int length = rand.nextInt(10) + 5;
        return this.isAreaSuitable(world, rand, x, y, z, 1, length, 1) && this.makeSpike(world, rand, x, y - 1, z, length);
    }
}
