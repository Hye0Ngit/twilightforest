import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public abstract class StructureTFComponent extends ln
{
    public StructureTFComponent(final int i) {
        super(i);
    }
    
    public static xv getComponentToAddBoundingBox(final int x, final int y, final int z, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ, final int dir) {
        switch (dir) {
            default: {
                return new xv(x + minX, y + minY, z + minZ, x + maxX + minX, y + maxY + minY, z + maxZ + minZ);
            }
            case 0: {
                return new xv(x + minX, y + minY, z + minZ, x + maxX + minX, y + maxY + minY, z + maxZ + minZ);
            }
            case 1: {
                return new xv(x - maxZ + minZ, y + minY, z + minX, x + minZ, y + maxY + minY, z + maxX + minX);
            }
            case 2: {
                return new xv(x - maxX - minX, y + minY, z - maxZ - minZ, x - minX, y + maxY + minY, z - minZ);
            }
            case 3: {
                return new xv(x + minZ, y + minY, z - maxX, x + maxZ + minZ, y + maxY + minY, z + minX);
            }
        }
    }
    
    protected void placeSpawnerAtCurrentPosition(final ge world, final Random rand, final int x, final int y, final int z, final String monsterID, final xv sbb) {
        final int dx = this.a(x, z);
        final int dy = this.b(y);
        final int dz = this.b(x, z);
        if (sbb.b(dx, dy, dz) && world.a(dx, dy, dz) != vz.as.bO) {
            world.e(dx, dy, dz, vz.as.bO);
            final dx tileEntitySpawner = (dx)world.b(dx, dy, dz);
            if (tileEntitySpawner != null) {
                tileEntitySpawner.a(monsterID);
            }
        }
    }
    
    protected void placeTreasureAtCurrentPosition(final ge world, final Random rand, final int x, final int y, final int z, final TFTreasure treasureType, final xv sbb) {
        final int dx = this.a(x, z);
        final int dy = this.b(y);
        final int dz = this.b(x, z);
        if (sbb.b(dx, dy, dz) && world.a(dx, dy, dz) != vz.au.bO) {
            treasureType.generate(world, rand, dx, dy, dz);
        }
    }
    
    protected int[] offsetTowerCoords(final int x, final int y, final int z, final int towerSize, final int direction) {
        final int dx = this.a(x, z);
        final int dy = this.b(y);
        final int dz = this.b(x, z);
        if (direction == 0) {
            return new int[] { dx + 1, dy - 1, dz - towerSize / 2 };
        }
        if (direction == 1) {
            return new int[] { dx + towerSize / 2, dy - 1, dz + 1 };
        }
        if (direction == 2) {
            return new int[] { dx - 1, dy - 1, dz + towerSize / 2 };
        }
        if (direction == 3) {
            return new int[] { dx - towerSize / 2, dy - 1, dz - 1 };
        }
        return new int[] { x, y, z };
    }
    
    public int[] getOffsetAsIfRotated(final int[] src, final int rotation) {
        final int temp = this.h;
        final int[] dest = new int[3];
        this.h = rotation;
        dest[0] = this.a(src[0], src[2]);
        dest[1] = this.b(src[1]);
        dest[2] = this.b(src[0], src[2]);
        this.h = temp;
        return dest;
    }
    
    protected int a(final int x, final int z) {
        switch (this.h) {
            case 0: {
                return this.g.a + x;
            }
            case 1: {
                return this.g.d - z;
            }
            case 2: {
                return this.g.d - x;
            }
            case 3: {
                return this.g.a + z;
            }
            default: {
                return x;
            }
        }
    }
    
    protected int b(final int x, final int z) {
        switch (this.h) {
            case 0: {
                return this.g.c + z;
            }
            case 1: {
                return this.g.c + x;
            }
            case 2: {
                return this.g.f - z;
            }
            case 3: {
                return this.g.f - x;
            }
            default: {
                return z;
            }
        }
    }
}
