// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import java.util.Random;

public class TFGenOutsideStalagmite extends TFGenCaveStalactite
{
    public TFGenOutsideStalagmite() {
        super((byte)aou.x.cz, 1.0, false);
    }
    
    @Override
    public boolean a(final zv world, final Random rand, final int x, final int y, final int z) {
        final int length = rand.nextInt(10) + 5;
        return this.isAreaClear(world, rand, x, y, z, 1, length, 1) && this.makeSpike(world, rand, x, y - 1, z, length);
    }
}
