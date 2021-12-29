import java.util.List;
import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class StructureTFHedgeMazeStart extends uj
{
    public StructureTFHedgeMazeStart(final fq world, final Random rand, final int chunkX, final int chunkZ) {
        final int x = (chunkX << 4) + 8;
        final int z = (chunkZ << 4) + 8;
        final int y = world.e + 1;
        final ComponentTFHedgeMaze hedgeMaze = new ComponentTFHedgeMaze(world, rand, 0, x, y, z);
        this.a.add(hedgeMaze);
        hedgeMaze.a((ki)hedgeMaze, (List)this.a, rand);
        this.d();
    }
}
