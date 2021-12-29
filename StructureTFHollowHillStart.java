import java.util.List;
import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class StructureTFHollowHillStart extends pc
{
    public StructureTFHollowHillStart(final wz world, final Random rand, final int chunkX, final int chunkZ) {
        final int x = (chunkX << 4) + 8;
        final int z = (chunkZ << 4) + 8;
        final int y = TFWorld.SEALEVEL + 1;
        final int hsize = ChunkProviderTwilightForest.featureType(chunkX, chunkZ, world);
        final ComponentTFHollowHill hollowHill = new ComponentTFHollowHill(world, rand, 0, hsize, x, y, z);
        this.a.add(hollowHill);
        hollowHill.a(hollowHill, this.a, rand);
        this.c();
    }
}
