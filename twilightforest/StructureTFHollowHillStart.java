// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.List;
import java.util.Random;

public class StructureTFHollowHillStart extends pg
{
    public StructureTFHollowHillStart(final xd world, final Random rand, final int chunkX, final int chunkZ) {
        final int x = (chunkX << 4) + 8;
        final int z = (chunkZ << 4) + 8;
        final int y = TFWorld.SEALEVEL + 1;
        final int hsize = TFFeature.getFeatureDirectlyAt(chunkX, chunkZ, world).size;
        final ComponentTFHollowHill hollowHill = new ComponentTFHollowHill(world, rand, 0, hsize, x, y, z);
        this.a.add(hollowHill);
        hollowHill.a(hollowHill, this.a, rand);
        this.c();
    }
}
