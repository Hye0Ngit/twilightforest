import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFGenWell extends TFGenerator
{
    @Override
    public boolean a(final wz world, final Random rand, final int x, final int y, final int z) {
        if (rand.nextInt(4) == 0) {
            return this.generate4x4Well(world, rand, x, y, z);
        }
        return this.generate3x3Well(world, rand, x, y, z);
    }
    
    public boolean generate3x3Well(final wz world, final Random rand, final int x, final int y, final int z) {
        this.worldObj = world;
        if (!this.isAreaClear(world, rand, x, y, z, 3, 4, 3)) {
            return false;
        }
        this.putBlock(x + 0, y, z + 0, ox.ao.bO, true);
        this.putBlock(x + 1, y, z + 0, ox.ao.bO, true);
        this.putBlock(x + 2, y, z + 0, ox.ao.bO, true);
        this.putBlock(x + 0, y, z + 2, ox.ao.bO, true);
        this.putBlock(x + 1, y, z + 2, ox.ao.bO, true);
        this.putBlock(x + 2, y, z + 2, ox.ao.bO, true);
        this.putBlock(x + 0, y, z + 1, ox.ao.bO, true);
        this.putBlock(x + 2, y, z + 1, ox.ao.bO, true);
        this.putBlock(x + 1, y, z + 1, ox.B.bO, true);
        this.putBlock(x + 0, y + 1, z + 0, ox.aZ.bO, true);
        this.putBlock(x + 2, y + 1, z + 0, ox.aZ.bO, true);
        this.putBlock(x + 0, y + 1, z + 2, ox.aZ.bO, true);
        this.putBlock(x + 2, y + 1, z + 2, ox.aZ.bO, true);
        this.putBlock(x + 0, y + 2, z + 0, ox.aZ.bO, true);
        this.putBlock(x + 2, y + 2, z + 0, ox.aZ.bO, true);
        this.putBlock(x + 0, y + 2, z + 2, ox.aZ.bO, true);
        this.putBlock(x + 2, y + 2, z + 2, ox.aZ.bO, true);
        this.putBlockAndMetadata(x + 0, y + 3, z + 0, ox.ak.bO, 2, true);
        this.putBlockAndMetadata(x + 1, y + 3, z + 0, ox.ak.bO, 2, true);
        this.putBlockAndMetadata(x + 2, y + 3, z + 0, ox.ak.bO, 2, true);
        this.putBlockAndMetadata(x + 0, y + 3, z + 2, ox.ak.bO, 2, true);
        this.putBlockAndMetadata(x + 1, y + 3, z + 2, ox.ak.bO, 2, true);
        this.putBlockAndMetadata(x + 2, y + 3, z + 2, ox.ak.bO, 2, true);
        this.putBlockAndMetadata(x + 0, y + 3, z + 1, ox.ak.bO, 2, true);
        this.putBlockAndMetadata(x + 2, y + 3, z + 1, ox.ak.bO, 2, true);
        this.putBlock(x + 1, y + 3, z + 1, ox.x.bO, true);
        for (int dy = -1; dy >= -20; --dy) {
            final int dblock = world.a(x + 1, y + dy, z + 1);
            if (dblock != ox.v.bO && dblock != ox.u.bO && dblock != ox.F.bO && dblock != ox.t.bO) {
                break;
            }
            if (!world.f(x + 1, y + dy - 1, z + 1).a()) {
                break;
            }
            this.putBlock(x + 1, y + dy, z + 1, ox.B.bO, true);
        }
        return true;
    }
    
    public boolean generate4x4Well(final wz world, final Random rand, final int x, final int y, final int z) {
        this.worldObj = world;
        if (!this.isAreaClear(world, rand, x, y, z, 4, 4, 4)) {
            return false;
        }
        this.putBlock(x + 0, y, z + 0, ox.ao.bO, true);
        this.putBlock(x + 1, y, z + 0, ox.ao.bO, true);
        this.putBlock(x + 2, y, z + 0, ox.ao.bO, true);
        this.putBlock(x + 3, y, z + 0, ox.ao.bO, true);
        this.putBlock(x + 0, y, z + 3, ox.ao.bO, true);
        this.putBlock(x + 1, y, z + 3, ox.ao.bO, true);
        this.putBlock(x + 2, y, z + 3, ox.ao.bO, true);
        this.putBlock(x + 3, y, z + 3, ox.ao.bO, true);
        this.putBlock(x + 0, y, z + 1, ox.ao.bO, true);
        this.putBlock(x + 0, y, z + 2, ox.ao.bO, true);
        this.putBlock(x + 3, y, z + 1, ox.ao.bO, true);
        this.putBlock(x + 3, y, z + 2, ox.ao.bO, true);
        this.putBlock(x + 1, y, z + 1, ox.B.bO, true);
        this.putBlock(x + 2, y, z + 1, ox.B.bO, true);
        this.putBlock(x + 1, y, z + 2, ox.B.bO, true);
        this.putBlock(x + 2, y, z + 2, ox.B.bO, true);
        this.putBlock(x + 0, y + 1, z + 0, ox.aZ.bO, true);
        this.putBlock(x + 3, y + 1, z + 0, ox.aZ.bO, true);
        this.putBlock(x + 0, y + 1, z + 3, ox.aZ.bO, true);
        this.putBlock(x + 3, y + 1, z + 3, ox.aZ.bO, true);
        this.putBlock(x + 0, y + 2, z + 0, ox.aZ.bO, true);
        this.putBlock(x + 3, y + 2, z + 0, ox.aZ.bO, true);
        this.putBlock(x + 0, y + 2, z + 3, ox.aZ.bO, true);
        this.putBlock(x + 3, y + 2, z + 3, ox.aZ.bO, true);
        this.putBlockAndMetadata(x + 0, y + 3, z + 0, ox.ak.bO, 2, true);
        this.putBlockAndMetadata(x + 1, y + 3, z + 0, ox.ak.bO, 2, true);
        this.putBlockAndMetadata(x + 2, y + 3, z + 0, ox.ak.bO, 2, true);
        this.putBlockAndMetadata(x + 3, y + 3, z + 0, ox.ak.bO, 2, true);
        this.putBlockAndMetadata(x + 0, y + 3, z + 3, ox.ak.bO, 2, true);
        this.putBlockAndMetadata(x + 1, y + 3, z + 3, ox.ak.bO, 2, true);
        this.putBlockAndMetadata(x + 2, y + 3, z + 3, ox.ak.bO, 2, true);
        this.putBlockAndMetadata(x + 3, y + 3, z + 3, ox.ak.bO, 2, true);
        this.putBlockAndMetadata(x + 0, y + 3, z + 1, ox.ak.bO, 2, true);
        this.putBlockAndMetadata(x + 0, y + 3, z + 2, ox.ak.bO, 2, true);
        this.putBlockAndMetadata(x + 3, y + 3, z + 1, ox.ak.bO, 2, true);
        this.putBlockAndMetadata(x + 3, y + 3, z + 2, ox.ak.bO, 2, true);
        this.putBlock(x + 1, y + 3, z + 1, ox.x.bO, true);
        this.putBlock(x + 2, y + 3, z + 1, ox.x.bO, true);
        this.putBlock(x + 1, y + 3, z + 2, ox.x.bO, true);
        this.putBlock(x + 2, y + 3, z + 2, ox.x.bO, true);
        for (int dx = 1; dx <= 2; ++dx) {
            for (int dz = 1; dz <= 2; ++dz) {
                for (int dy = -1; dy >= -20; --dy) {
                    final int dblock = world.a(x + dx, y + dy, z + dz);
                    if (dblock != ox.v.bO && dblock != ox.u.bO && dblock != ox.F.bO && dblock != ox.t.bO) {
                        break;
                    }
                    if (!world.f(x + dx, y + dy - 1, z + dz).a()) {
                        break;
                    }
                    this.putBlock(x + dx, y + dy, z + dz, ox.B.bO, true);
                }
            }
        }
        return true;
    }
}
