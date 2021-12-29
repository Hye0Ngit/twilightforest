// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.TFTreasure;
import java.util.Random;

public abstract class StructureTFComponent extends aes
{
    private static final StructureTFStrongholdStones strongholdStones;
    
    public StructureTFComponent(final int i) {
        super(i);
    }
    
    public static acg getComponentToAddBoundingBox(final int x, final int y, final int z, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ, final int dir) {
        switch (dir) {
            default: {
                return new acg(x + minX, y + minY, z + minZ, x + maxX + minX, y + maxY + minY, z + maxZ + minZ);
            }
            case 0: {
                return new acg(x + minX, y + minY, z + minZ, x + maxX + minX, y + maxY + minY, z + maxZ + minZ);
            }
            case 1: {
                return new acg(x - maxZ + minZ, y + minY, z + minX, x + minZ, y + maxY + minY, z + maxX + minX);
            }
            case 2: {
                return new acg(x - maxX - minX, y + minY, z - maxZ - minZ, x - minX, y + maxY + minY, z - minZ);
            }
            case 3: {
                return new acg(x + minZ, y + minY, z - maxX, x + maxZ + minZ, y + maxY + minY, z + minX);
            }
        }
    }
    
    protected void placeSpawnerAtCurrentPosition(final xv world, final Random rand, final int x, final int y, final int z, final String monsterID, final acg sbb) {
        final int dx = this.a(x, z);
        final int dy = this.a(y);
        final int dz = this.b(x, z);
        if (sbb.b(dx, dy, dz) && world.a(dx, dy, dz) != amj.av.cm) {
            world.e(dx, dy, dz, amj.av.cm);
            final anl tileEntitySpawner = (anl)world.q(dx, dy, dz);
            if (tileEntitySpawner != null) {
                tileEntitySpawner.a(monsterID);
            }
        }
    }
    
    protected void placeTreasureAtCurrentPosition(final xv world, final Random rand, final int x, final int y, final int z, final TFTreasure treasureType, final acg sbb) {
        final int dx = this.a(x, z);
        final int dy = this.a(y);
        final int dz = this.b(x, z);
        if (sbb.b(dx, dy, dz) && world.a(dx, dy, dz) != amj.ax.cm) {
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
    
    protected int a(final xv par1World, final int par2, final int par3, final int par4, final acg par5StructureBoundingBox) {
        return super.a(par1World, par2, par3, par4, par5StructureBoundingBox);
    }
    
    protected void a(final xv par1World, final int par2, final int par3, final int par4, final int par5, final int par6, final acg par7StructureBoundingBox) {
        super.a(par1World, par2, par3, par4, par5, par6, par7StructureBoundingBox);
    }
    
    public static aet getStrongholdStones() {
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
    
    public boolean generatePost(final xv par1World, final Random par2Random, final acg par3StructureBoundingBox) {
        return false;
    }
    
    static {
        strongholdStones = new StructureTFStrongholdStones();
    }
}
