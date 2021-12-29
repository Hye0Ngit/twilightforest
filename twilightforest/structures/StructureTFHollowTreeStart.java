// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import java.util.List;
import java.util.Random;

public class StructureTFHollowTreeStart extends afb
{
    public StructureTFHollowTreeStart(final yc world, final Random rand, final int chunkX, final int chunkZ) {
        final int x = (chunkX << 4) + 8;
        final int z = (chunkZ << 4) + 8;
        final int y = 30;
        final ComponentTFHollowTreeTrunk trunk = new ComponentTFHollowTreeTrunk(world, rand, 0, x, y, z);
        this.a.add(trunk);
        trunk.a(trunk, this.a, rand);
        this.c();
    }
}
