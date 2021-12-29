// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.Block;

public class TFGenOutsideStalagmite extends TFGenCaveStalactite
{
    public TFGenOutsideStalagmite() {
        super((byte)Block.field_71981_t.field_71990_ca, 1.0f, false);
    }
    
    @Override
    public boolean func_76484_a(final World world, final Random rand, final int x, final int y, final int z) {
        final int length = rand.nextInt(10) + 5;
        return this.isAreaClear(world, rand, x, y, z, 1, length, 1) && this.makeSpike(world, rand, x, y - 1, z, length);
    }
}
