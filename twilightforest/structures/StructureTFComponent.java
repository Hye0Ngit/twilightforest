// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.TFTreasure;
import java.util.Random;

public abstract class StructureTFComponent extends aez
{
    private static final StructureTFStrongholdStones strongholdStones;
    protected StructureTFDecorator deco;
    
    public StructureTFComponent(final int i) {
        super(i);
        this.deco = null;
    }
    
    public static acn getComponentToAddBoundingBox(final int x, final int y, final int z, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ, final int dir) {
        switch (dir) {
            default: {
                return new acn(x + minX, y + minY, z + minZ, x + maxX + minX, y + maxY + minY, z + maxZ + minZ);
            }
            case 0: {
                return new acn(x + minX, y + minY, z + minZ, x + maxX + minX, y + maxY + minY, z + maxZ + minZ);
            }
            case 1: {
                return new acn(x - maxZ + minZ, y + minY, z + minX, x + minZ, y + maxY + minY, z + maxX + minX);
            }
            case 2: {
                return new acn(x - maxX - minX, y + minY, z - maxZ - minZ, x - minX, y + maxY + minY, z - minZ);
            }
            case 3: {
                return new acn(x + minZ, y + minY, z - maxX, x + maxZ + minZ, y + maxY + minY, z + minX);
            }
        }
    }
    
    protected void placeSpawnerAtCurrentPosition(final yc world, final Random rand, final int x, final int y, final int z, final String monsterID, final acn sbb) {
        final int dx = this.a(x, z);
        final int dy = this.a(y);
        final int dz = this.b(x, z);
        if (sbb.b(dx, dy, dz) && world.a(dx, dy, dz) != amq.av.cm) {
            world.e(dx, dy, dz, amq.av.cm);
            final ans tileEntitySpawner = (ans)world.q(dx, dy, dz);
            if (tileEntitySpawner != null) {
                tileEntitySpawner.a(monsterID);
            }
        }
    }
    
    protected void placeTreasureAtCurrentPosition(final yc world, final Random rand, final int x, final int y, final int z, final TFTreasure treasureType, final acn sbb) {
        final int dx = this.a(x, z);
        final int dy = this.a(y);
        final int dz = this.b(x, z);
        if (sbb.b(dx, dy, dz) && world.a(dx, dy, dz) != amq.ax.cm) {
            treasureType.generate(world, rand, dx, dy, dz);
        }
    }
    
    protected int[] offsetTowerCoords(final int x, final int y, final int z, final int towerSize, final int direction) {
        final int dx = this.a(x, z);
        final int dy = this.a(y);
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
        final int temp = this.getCoordBaseMode();
        final int[] dest = new int[3];
        this.setCoordBaseMode(rotation);
        dest[0] = this.a(src[0], src[2]);
        dest[1] = this.a(src[1]);
        dest[2] = this.b(src[0], src[2]);
        this.setCoordBaseMode(temp);
        return dest;
    }
    
    protected int a(final int x, final int z) {
        switch (this.getCoordBaseMode()) {
            case 0: {
                return this.e.a + x;
            }
            case 1: {
                return this.e.d - z;
            }
            case 2: {
                return this.e.d - x;
            }
            case 3: {
                return this.e.a + z;
            }
            default: {
                return x;
            }
        }
    }
    
    protected int b(final int x, final int z) {
        switch (this.getCoordBaseMode()) {
            case 0: {
                return this.e.c + z;
            }
            case 1: {
                return this.e.c + x;
            }
            case 2: {
                return this.e.f - z;
            }
            case 3: {
                return this.e.f - x;
            }
            default: {
                return z;
            }
        }
    }
    
    protected int a(final int y) {
        return super.a(y);
    }
    
    public int getCoordBaseMode() {
        return this.f;
    }
    
    public void setCoordBaseMode(final int coordBaseMode) {
        this.f = coordBaseMode;
    }
    
    protected int a(final yc par1World, final int par2, final int par3, final int par4, final acn par5StructureBoundingBox) {
        return super.a(par1World, par2, par3, par4, par5StructureBoundingBox);
    }
    
    protected void a(final yc par1World, final int par2, final int par3, final int par4, final int par5, final int par6, final acn par7StructureBoundingBox) {
        super.a(par1World, par2, par3, par4, par5, par6, par7StructureBoundingBox);
    }
    
    public static afa getStrongholdStones() {
        return StructureTFComponent.strongholdStones;
    }
    
    protected int getStairMeta(final int dir) {
        switch ((this.getCoordBaseMode() + dir) % 4) {
            case 0: {
                return 0;
            }
            case 1: {
                return 2;
            }
            case 2: {
                return 1;
            }
            case 3: {
                return 3;
            }
            default: {
                return -1;
            }
        }
    }
    
    public void nullifySkyLightForBoundingBox(final yc world) {
        this.nullifySkyLight(world, this.e.a - 1, this.e.b - 1, this.e.c - 1, this.e.d + 1, this.e.e + 1, this.e.f + 1);
    }
    
    public void nullifySkyLightAtCurrentPosition(final yc world, final int sx, final int sy, final int sz, final int dx, final int dy, final int dz) {
        this.nullifySkyLight(world, this.a(sx, sz), this.a(sy), this.b(sx, sz), this.a(dx, dz), this.a(dy), this.b(dx, dz));
    }
    
    public void nullifySkyLight(final yc world, final int sx, final int sy, final int sz, final int dx, final int dy, final int dz) {
        for (int x = sx; x <= dx; ++x) {
            for (int z = sz; z <= dz; ++z) {
                for (int y = sy; y <= dy; ++y) {
                    world.b(yo.a, x, y, z, 0);
                }
            }
        }
    }
    
    static {
        strongholdStones = new StructureTFStrongholdStones();
    }
}
