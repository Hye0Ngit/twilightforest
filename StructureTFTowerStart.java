import java.util.List;
import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class StructureTFTowerStart extends uj
{
    public StructureTFTowerStart(final fq world, final Random rand, final int chunkX, final int chunkZ) {
        final int x = (chunkX << 4) + 8;
        final int z = (chunkZ << 4) + 8;
        final int y = 30;
        final ComponentTFTowerMain mainTower = new ComponentTFTowerMain(world, rand, 0, x, y, z);
        this.a.add(mainTower);
        mainTower.a(mainTower, this.a, rand);
        this.d();
    }
}
