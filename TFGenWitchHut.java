import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFGenWitchHut extends TFGenerator
{
    @Override
    public boolean a(final ry world, final Random rand, final int x, final int y, final int z) {
        return this.generateTinyHut(world, rand, x, y, z);
    }
    
    public boolean generateTinyHut(final ry world, final Random rand, final int x, final int y, final int z) {
        this.worldObj = world;
        if (!this.isAreaClear(world, rand, x, y, z, 5, 7, 6)) {
            return false;
        }
        this.putBlock(x + 1, y + 0, z + 1, this.randStone(rand, 1), true);
        this.putBlock(x + 2, y + 0, z + 1, this.randStone(rand, 1), true);
        this.putBlock(x + 3, y + 0, z + 1, this.randStone(rand, 1), true);
        this.putBlock(x + 5, y + 0, z + 1, this.randStone(rand, 1), true);
        this.putBlock(x + 0, y + 0, z + 2, (byte)yy.al.bM, true);
        this.putBlock(x + 1, y + 0, z + 2, (byte)yy.al.bM, true);
        this.putBlock(x + 5, y + 0, z + 2, this.randStone(rand, 1), true);
        this.putBlock(x + 0, y + 0, z + 3, (byte)yy.al.bM, true);
        this.putBlock(x + 5, y + 0, z + 3, this.randStone(rand, 1), true);
        this.putBlock(x + 0, y + 0, z + 4, (byte)yy.al.bM, true);
        this.putBlock(x + 1, y + 0, z + 4, (byte)yy.al.bM, true);
        this.putBlock(x + 5, y + 0, z + 4, this.randStone(rand, 1), true);
        this.putBlock(x + 1, y + 0, z + 5, this.randStone(rand, 1), true);
        this.putBlock(x + 2, y + 0, z + 5, this.randStone(rand, 1), true);
        this.putBlock(x + 3, y + 0, z + 5, this.randStone(rand, 1), true);
        this.putBlock(x + 5, y + 0, z + 5, this.randStone(rand, 1), true);
        this.putBlock(x + 1, y + 1, z + 1, this.randStone(rand, 2), true);
        this.putBlock(x + 3, y + 1, z + 1, this.randStone(rand, 2), true);
        this.putBlock(x + 5, y + 1, z + 1, this.randStone(rand, 2), true);
        this.putBlock(x + 0, y + 1, z + 2, (byte)yy.al.bM, true);
        this.putBlock(x + 1, y + 1, z + 2, (byte)yy.al.bM, true);
        this.putBlock(x + 5, y + 1, z + 2, this.randStone(rand, 2), true);
        this.putBlock(x + 0, y + 1, z + 3, (byte)yy.al.bM, true);
        this.putBlock(x + 0, y + 1, z + 4, (byte)yy.al.bM, true);
        this.putBlock(x + 1, y + 1, z + 4, (byte)yy.al.bM, true);
        this.putBlock(x + 5, y + 1, z + 4, this.randStone(rand, 2), true);
        this.putBlock(x + 1, y + 1, z + 5, this.randStone(rand, 2), true);
        this.putBlock(x + 3, y + 1, z + 5, this.randStone(rand, 2), true);
        this.putBlock(x + 5, y + 1, z + 5, this.randStone(rand, 2), true);
        this.putBlock(x + 1, y + 2, z + 1, this.randStone(rand, 3), true);
        this.putBlock(x + 2, y + 2, z + 1, this.randStone(rand, 3), true);
        this.putBlock(x + 3, y + 2, z + 1, this.randStone(rand, 3), true);
        this.putBlock(x + 4, y + 2, z + 1, this.randStone(rand, 3), true);
        this.putBlock(x + 5, y + 2, z + 1, this.randStone(rand, 3), true);
        this.putBlock(x + 0, y + 2, z + 2, (byte)yy.al.bM, true);
        this.putBlock(x + 1, y + 2, z + 2, (byte)yy.al.bM, true);
        this.putBlock(x + 5, y + 2, z + 2, this.randStone(rand, 3), true);
        this.putBlock(x + 0, y + 2, z + 3, (byte)yy.al.bM, true);
        this.putBlock(x + 5, y + 2, z + 3, this.randStone(rand, 3), true);
        this.putBlock(x + 0, y + 2, z + 4, (byte)yy.al.bM, true);
        this.putBlock(x + 1, y + 2, z + 4, (byte)yy.al.bM, true);
        this.putBlock(x + 5, y + 2, z + 4, this.randStone(rand, 1), true);
        this.putBlock(x + 1, y + 2, z + 5, this.randStone(rand, 3), true);
        this.putBlock(x + 2, y + 2, z + 5, this.randStone(rand, 3), true);
        this.putBlock(x + 3, y + 2, z + 5, this.randStone(rand, 3), true);
        this.putBlock(x + 4, y + 2, z + 5, this.randStone(rand, 3), true);
        this.putBlock(x + 5, y + 2, z + 5, this.randStone(rand, 3), true);
        this.putBlock(x + 0, y + 3, z + 2, (byte)yy.al.bM, true);
        this.putBlock(x + 0, y + 3, z + 3, (byte)yy.al.bM, true);
        this.putBlock(x + 0, y + 3, z + 4, (byte)yy.al.bM, true);
        this.putBlock(x + 2, y + 3, z + 1, this.randStone(rand, 4), true);
        this.putBlock(x + 3, y + 3, z + 1, this.randStone(rand, 4), true);
        this.putBlock(x + 4, y + 3, z + 1, this.randStone(rand, 4), true);
        this.putBlock(x + 2, y + 3, z + 5, this.randStone(rand, 4), true);
        this.putBlock(x + 3, y + 3, z + 5, this.randStone(rand, 4), true);
        this.putBlock(x + 4, y + 3, z + 5, this.randStone(rand, 4), true);
        this.putBlock(x + 0, y + 4, z + 3, (byte)yy.al.bM, true);
        this.putBlock(x + 3, y + 4, z + 1, this.randStone(rand, 5), true);
        this.putBlock(x + 3, y + 4, z + 5, this.randStone(rand, 5), true);
        this.putBlock(x + 0, y + 5, z + 3, (byte)yy.al.bM, true);
        this.putBlock(x + 0, y + 6, z + 3, (byte)yy.al.bM, true);
        this.putBlockAndMetadata(x + 0, y + 2, z + 0, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 0, y + 2, z + 1, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 0, y + 2, z + 5, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 0, y + 2, z + 6, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 6, y + 2, z + 0, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 6, y + 2, z + 1, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 6, y + 2, z + 2, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 6, y + 2, z + 3, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 6, y + 2, z + 4, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 6, y + 2, z + 5, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 6, y + 2, z + 6, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 1, y + 3, z + 0, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 1, y + 3, z + 1, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 1, y + 3, z + 2, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 1, y + 3, z + 4, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 1, y + 3, z + 5, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 1, y + 3, z + 6, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 5, y + 3, z + 0, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 5, y + 3, z + 1, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 5, y + 3, z + 2, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 5, y + 3, z + 3, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 5, y + 3, z + 4, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 5, y + 3, z + 5, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 5, y + 3, z + 6, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 1, y + 4, z + 0, (byte)yy.ak.bM, 2, true);
        this.putBlockAndMetadata(x + 2, y + 4, z + 0, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 2, y + 4, z + 1, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 2, y + 4, z + 2, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 2, y + 4, z + 3, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 2, y + 4, z + 4, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 2, y + 4, z + 5, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 2, y + 4, z + 6, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 1, y + 4, z + 6, (byte)yy.ak.bM, 2, true);
        this.putBlockAndMetadata(x + 5, y + 4, z + 0, (byte)yy.ak.bM, 2, true);
        this.putBlockAndMetadata(x + 4, y + 4, z + 0, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 4, y + 4, z + 1, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 4, y + 4, z + 2, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 4, y + 4, z + 3, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 4, y + 4, z + 4, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 4, y + 4, z + 5, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 4, y + 4, z + 6, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 5, y + 4, z + 6, (byte)yy.ak.bM, 2, true);
        this.putBlockAndMetadata(x + 2, y + 5, z + 0, (byte)yy.ak.bM, 2, true);
        this.putBlockAndMetadata(x + 2, y + 5, z + 1, (byte)yy.ak.bM, 2, true);
        this.putBlockAndMetadata(x + 4, y + 5, z + 0, (byte)yy.ak.bM, 2, true);
        this.putBlockAndMetadata(x + 4, y + 5, z + 1, (byte)yy.ak.bM, 2, true);
        this.putBlockAndMetadata(x + 3, y + 5, z + 0, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 3, y + 5, z + 1, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 3, y + 5, z + 2, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 3, y + 5, z + 3, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 3, y + 5, z + 4, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 3, y + 5, z + 5, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 3, y + 5, z + 6, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 2, y + 5, z + 5, (byte)yy.ak.bM, 2, true);
        this.putBlockAndMetadata(x + 2, y + 5, z + 6, (byte)yy.ak.bM, 2, true);
        this.putBlockAndMetadata(x + 4, y + 5, z + 5, (byte)yy.ak.bM, 2, true);
        this.putBlockAndMetadata(x + 4, y + 5, z + 6, (byte)yy.ak.bM, 2, true);
        this.putBlockAndMetadata(x + 3, y + 6, z + 0, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 3, y + 6, z + 1, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 3, y + 6, z + 2, (byte)yy.ak.bM, 2, true);
        this.putBlockAndMetadata(x + 3, y + 6, z + 4, (byte)yy.ak.bM, 2, true);
        this.putBlockAndMetadata(x + 3, y + 6, z + 5, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 3, y + 6, z + 6, (byte)yy.aj.bM, 2, true);
        this.putBlockAndMetadata(x + 3, y + 7, z + 0, (byte)yy.ak.bM, 2, true);
        this.putBlockAndMetadata(x + 3, y + 7, z + 6, (byte)yy.ak.bM, 2, true);
        this.putBlock(x + 1, y - 1, z + 3, (byte)yy.bb.bM, true);
        this.putBlock(x + 1, y + 0, z + 3, (byte)yy.ar.bM, true);
        this.worldObj.g(x + 3, y + 1, z + 3, yy.as.bM);
        final ze ms = (ze)world.b(x + 3, y + 1, z + 3);
        ms.a("Skeleton Druid");
        return true;
    }
}
