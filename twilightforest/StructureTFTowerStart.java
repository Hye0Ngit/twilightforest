// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.List;
import java.util.Random;

public class StructureTFTowerStart extends pg
{
    public StructureTFTowerStart(final xd world, final Random rand, final int chunkX, final int chunkZ) {
        final int x = (chunkX << 4) + 8;
        final int z = (chunkZ << 4) + 8;
        final int y = 30;
        final ComponentTFTowerMain mainTower = new ComponentTFTowerMain(world, rand, 0, x, y, z);
        this.a.add(mainTower);
        mainTower.a(mainTower, this.a, rand);
        this.c();
    }
}
