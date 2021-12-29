import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFGenWell extends TFGenerator
{
    @Override
    public boolean a(final ry world, final Random rand, final int x, final int y, final int z) {
        if (rand.nextInt(4) == 0) {
            return this.generate4x4Well(world, rand, x, y, z);
        }
        return this.generate3x3Well(world, rand, x, y, z);
    }
    
    public boolean generate3x3Well(final ry world, final Random rand, final int x, final int y, final int z) {
        this.worldObj = world;
        if (!this.isAreaClear(world, rand, x, y, z, 3, 4, 3)) {
            return false;
        }
        this.putBlock(x + 0, y, z + 0, yy.ao.bM, true);
        this.putBlock(x + 1, y, z + 0, yy.ao.bM, true);
        this.putBlock(x + 2, y, z + 0, yy.ao.bM, true);
        this.putBlock(x + 0, y, z + 2, yy.ao.bM, true);
        this.putBlock(x + 1, y, z + 2, yy.ao.bM, true);
        this.putBlock(x + 2, y, z + 2, yy.ao.bM, true);
        this.putBlock(x + 0, y, z + 1, yy.ao.bM, true);
        this.putBlock(x + 2, y, z + 1, yy.ao.bM, true);
        this.putBlock(x + 1, y, z + 1, yy.B.bM, true);
        this.putBlock(x + 0, y + 1, z + 0, yy.aZ.bM, true);
        this.putBlock(x + 2, y + 1, z + 0, yy.aZ.bM, true);
        this.putBlock(x + 0, y + 1, z + 2, yy.aZ.bM, true);
        this.putBlock(x + 2, y + 1, z + 2, yy.aZ.bM, true);
        this.putBlock(x + 0, y + 2, z + 0, yy.aZ.bM, true);
        this.putBlock(x + 2, y + 2, z + 0, yy.aZ.bM, true);
        this.putBlock(x + 0, y + 2, z + 2, yy.aZ.bM, true);
        this.putBlock(x + 2, y + 2, z + 2, yy.aZ.bM, true);
        this.putBlockAndMetadata(x + 0, y + 3, z + 0, yy.ak.bM, 2, true);
        this.putBlockAndMetadata(x + 1, y + 3, z + 0, yy.ak.bM, 2, true);
        this.putBlockAndMetadata(x + 2, y + 3, z + 0, yy.ak.bM, 2, true);
        this.putBlockAndMetadata(x + 0, y + 3, z + 2, yy.ak.bM, 2, true);
        this.putBlockAndMetadata(x + 1, y + 3, z + 2, yy.ak.bM, 2, true);
        this.putBlockAndMetadata(x + 2, y + 3, z + 2, yy.ak.bM, 2, true);
        this.putBlockAndMetadata(x + 0, y + 3, z + 1, yy.ak.bM, 2, true);
        this.putBlockAndMetadata(x + 2, y + 3, z + 1, yy.ak.bM, 2, true);
        this.putBlock(x + 1, y + 3, z + 1, yy.x.bM, true);
        for (int dy = -1; dy >= -20; --dy) {
            final int dblock = world.a(x + 1, y + dy, z + 1);
            if (dblock != yy.v.bM && dblock != yy.u.bM && dblock != yy.F.bM && dblock != yy.t.bM) {
                break;
            }
            if (!world.e(x + 1, y + dy - 1, z + 1).b()) {
                break;
            }
            this.putBlock(x + 1, y + dy, z + 1, yy.B.bM, true);
        }
        return true;
    }
    
    public boolean generate4x4Well(final ry world, final Random rand, final int x, final int y, final int z) {
        this.worldObj = world;
        if (!this.isAreaClear(world, rand, x, y, z, 4, 4, 4)) {
            return false;
        }
        this.putBlock(x + 0, y, z + 0, yy.ao.bM, true);
        this.putBlock(x + 1, y, z + 0, yy.ao.bM, true);
        this.putBlock(x + 2, y, z + 0, yy.ao.bM, true);
        this.putBlock(x + 3, y, z + 0, yy.ao.bM, true);
        this.putBlock(x + 0, y, z + 3, yy.ao.bM, true);
        this.putBlock(x + 1, y, z + 3, yy.ao.bM, true);
        this.putBlock(x + 2, y, z + 3, yy.ao.bM, true);
        this.putBlock(x + 3, y, z + 3, yy.ao.bM, true);
        this.putBlock(x + 0, y, z + 1, yy.ao.bM, true);
        this.putBlock(x + 0, y, z + 2, yy.ao.bM, true);
        this.putBlock(x + 3, y, z + 1, yy.ao.bM, true);
        this.putBlock(x + 3, y, z + 2, yy.ao.bM, true);
        this.putBlock(x + 1, y, z + 1, yy.B.bM, true);
        this.putBlock(x + 2, y, z + 1, yy.B.bM, true);
        this.putBlock(x + 1, y, z + 2, yy.B.bM, true);
        this.putBlock(x + 2, y, z + 2, yy.B.bM, true);
        this.putBlock(x + 0, y + 1, z + 0, yy.aZ.bM, true);
        this.putBlock(x + 3, y + 1, z + 0, yy.aZ.bM, true);
        this.putBlock(x + 0, y + 1, z + 3, yy.aZ.bM, true);
        this.putBlock(x + 3, y + 1, z + 3, yy.aZ.bM, true);
        this.putBlock(x + 0, y + 2, z + 0, yy.aZ.bM, true);
        this.putBlock(x + 3, y + 2, z + 0, yy.aZ.bM, true);
        this.putBlock(x + 0, y + 2, z + 3, yy.aZ.bM, true);
        this.putBlock(x + 3, y + 2, z + 3, yy.aZ.bM, true);
        this.putBlockAndMetadata(x + 0, y + 3, z + 0, yy.ak.bM, 2, true);
        this.putBlockAndMetadata(x + 1, y + 3, z + 0, yy.ak.bM, 2, true);
        this.putBlockAndMetadata(x + 2, y + 3, z + 0, yy.ak.bM, 2, true);
        this.putBlockAndMetadata(x + 3, y + 3, z + 0, yy.ak.bM, 2, true);
        this.putBlockAndMetadata(x + 0, y + 3, z + 3, yy.ak.bM, 2, true);
        this.putBlockAndMetadata(x + 1, y + 3, z + 3, yy.ak.bM, 2, true);
        this.putBlockAndMetadata(x + 2, y + 3, z + 3, yy.ak.bM, 2, true);
        this.putBlockAndMetadata(x + 3, y + 3, z + 3, yy.ak.bM, 2, true);
        this.putBlockAndMetadata(x + 0, y + 3, z + 1, yy.ak.bM, 2, true);
        this.putBlockAndMetadata(x + 0, y + 3, z + 2, yy.ak.bM, 2, true);
        this.putBlockAndMetadata(x + 3, y + 3, z + 1, yy.ak.bM, 2, true);
        this.putBlockAndMetadata(x + 3, y + 3, z + 2, yy.ak.bM, 2, true);
        this.putBlock(x + 1, y + 3, z + 1, yy.x.bM, true);
        this.putBlock(x + 2, y + 3, z + 1, yy.x.bM, true);
        this.putBlock(x + 1, y + 3, z + 2, yy.x.bM, true);
        this.putBlock(x + 2, y + 3, z + 2, yy.x.bM, true);
        for (int dx = 1; dx <= 2; ++dx) {
            for (int dz = 1; dz <= 2; ++dz) {
                for (int dy = -1; dy >= -20; --dy) {
                    final int dblock = world.a(x + dx, y + dy, z + dz);
                    if (dblock != yy.v.bM && dblock != yy.u.bM && dblock != yy.F.bM && dblock != yy.t.bM) {
                        break;
                    }
                    if (!world.e(x + dx, y + dy - 1, z + dz).b()) {
                        break;
                    }
                    this.putBlock(x + dx, y + dy, z + dz, yy.B.bM, true);
                }
            }
        }
        return true;
    }
}
