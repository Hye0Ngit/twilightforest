import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFGenGlacierMaze extends TFGenerator
{
    int size;
    TFMaze maze;
    Random rand;
    
    public TFGenGlacierMaze(final int size) {
        this.size = size;
    }
    
    @Override
    public boolean a(final fq world, final Random rand, final int x, final int y, final int z) {
        this.worldObj = world;
        this.rand = rand;
        final int sx = x - 7 - this.size * 16;
        final int sz = z - 7 - this.size * 16;
        final int msize = 15;
        this.maze = new TFMaze(msize, msize);
        this.maze.oddBias = 2;
        this.maze.wallBlockID = ud.aV.bO;
        this.maze.torchBlockID = ud.aV.bO;
        this.maze.type = 5;
        this.maze.tall = 3;
        this.maze.generateRecursiveBacktracker(0, 0);
        this.maze.add4Exits();
        this.maze.carveToWorld(this.worldObj, sx, y, sz);
        return true;
    }
}
