import java.util.List;
import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class StructureTFCourtyardStart extends wg
{
    public StructureTFCourtyardStart(final ge world, final Random rand, final int chunkX, final int chunkZ) {
        final int x = (chunkX << 4) + 8;
        final int z = (chunkZ << 4) + 8;
        final int y = TFWorld.SEALEVEL + 1;
        final ComponentTFNagaCourtyard courtyard = new ComponentTFNagaCourtyard(world, rand, 0, x, y, z);
        this.a.add(courtyard);
        courtyard.a((ln)courtyard, (List)this.a, rand);
        this.d();
    }
}
