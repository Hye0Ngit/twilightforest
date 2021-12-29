// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.TFTreasure;
import java.util.Random;

public abstract class StructureTFComponent extends agq
{
    private static final StructureTFStrongholdStones strongholdStones;
    private static final StructureTFTowerWoods towerWoods;
    public StructureTFDecorator deco;
    public int spawnListIndex;
    
    public StructureTFComponent(final int i) {
        super(i);
        this.deco = null;
        this.spawnListIndex = 0;
    }
    
    public static aee getComponentToAddBoundingBox(final int x, final int y, final int z, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ, final int dir) {
        switch (dir) {
            default: {
                return new aee(x + minX, y + minY, z + minZ, x + maxX + minX, y + maxY + minY, z + maxZ + minZ);
            }
            case 0: {
                return new aee(x + minX, y + minY, z + minZ, x + maxX + minX, y + maxY + minY, z + maxZ + minZ);
            }
            case 1: {
                return new aee(x - maxZ + minZ, y + minY, z + minX, x + minZ, y + maxY + minY, z + maxX + minX);
            }
            case 2: {
                return new aee(x - maxX - minX, y + minY, z - maxZ - minZ, x - minX, y + maxY + minY, z - minZ);
            }
            case 3: {
                return new aee(x + minZ, y + minY, z - maxX, x + maxZ + minZ, y + maxY + minY, z + minX);
            }
        }
    }
    
    protected aqd placeSpawnerAtCurrentPosition(final zv world, final Random rand, final int x, final int y, final int z, final String monsterID, final aee sbb) {
        aqd tileEntitySpawner = null;
        final int dx = this.a(x, z);
        final int dy = this.a(y);
        final int dz = this.b(x, z);
        if (sbb.b(dx, dy, dz) && world.a(dx, dy, dz) != aou.aw.cz) {
            world.f(dx, dy, dz, aou.aw.cz, 0, 2);
            tileEntitySpawner = (aqd)world.r(dx, dy, dz);
            if (tileEntitySpawner != null) {
                tileEntitySpawner.a().a(monsterID);
            }
        }
        return tileEntitySpawner;
    }
    
    protected aqd placeSpawnerRotated(final zv world, final int x, final int y, final int z, final int rotation, final String monsterID, final aee sbb) {
        aqd tileEntitySpawner = null;
        final int dx = this.getXWithOffsetAsIfRotated(x, z, rotation);
        final int dy = this.a(y);
        final int dz = this.getZWithOffsetAsIfRotated(x, z, rotation);
        if (sbb.b(dx, dy, dz) && world.a(dx, dy, dz) != aou.aw.cz) {
            world.f(dx, dy, dz, aou.aw.cz, 0, 2);
            tileEntitySpawner = (aqd)world.r(dx, dy, dz);
            if (tileEntitySpawner != null) {
                tileEntitySpawner.a().a(monsterID);
            }
        }
        return tileEntitySpawner;
    }
    
    protected void placeTreasureAtCurrentPosition(final zv world, final Random rand, final int x, final int y, final int z, final TFTreasure treasureType, final aee sbb) {
        final int dx = this.a(x, z);
        final int dy = this.a(y);
        final int dz = this.b(x, z);
        if (sbb.b(dx, dy, dz) && world.a(dx, dy, dz) != aou.ay.cz) {
            treasureType.generate(world, rand, dx, dy, dz);
        }
    }
    
    protected void placeTreasureRotated(final zv world, final int x, final int y, final int z, final int rotation, final TFTreasure treasureType, final aee sbb) {
        final int dx = this.getXWithOffsetAsIfRotated(x, z, rotation);
        final int dy = this.a(y);
        final int dz = this.getZWithOffsetAsIfRotated(x, z, rotation);
        if (sbb.b(dx, dy, dz) && world.a(dx, dy, dz) != aou.ay.cz) {
            treasureType.generate(world, null, dx, dy, dz);
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
    
    protected int a(final int par1) {
        return super.a(par1);
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
    
    protected int getXWithOffsetAsIfRotated(final int x, final int z, final int rotation) {
        if (this.f < 0) {
            return x;
        }
        switch ((this.f + rotation) % 4) {
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
    
    protected int getZWithOffsetAsIfRotated(final int x, final int z, final int rotation) {
        if (this.f < 0) {
            return x;
        }
        switch ((this.f + rotation) % 4) {
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
    
    public int getCoordBaseMode() {
        return this.f;
    }
    
    public void setCoordBaseMode(final int coordBaseMode) {
        this.f = coordBaseMode;
    }
    
    protected int a(final zv par1World, final int par2, final int par3, final int par4, final aee par5StructureBoundingBox) {
        return super.a(par1World, par2, par3, par4, par5StructureBoundingBox);
    }
    
    protected void a(final zv par1World, final int par2, final int par3, final int par4, final int par5, final int par6, final aee par7StructureBoundingBox) {
        super.a(par1World, par2, par3, par4, par5, par6, par7StructureBoundingBox);
    }
    
    protected void placeBlockRotated(final zv world, final int blockID, final int meta, final int x, final int y, final int z, final int rotation, final aee sbb) {
        final int dx = this.getXWithOffsetAsIfRotated(x, z, rotation);
        final int dy = this.a(y);
        final int dz = this.getZWithOffsetAsIfRotated(x, z, rotation);
        if (sbb.b(dx, dy, dz)) {
            world.f(dx, dy, dz, blockID, meta, 2);
        }
    }
    
    protected int getBlockIDRotated(final zv world, final int x, final int y, final int z, final int rotation, final aee sbb) {
        final int dx = this.getXWithOffsetAsIfRotated(x, z, rotation);
        final int dy = this.a(y);
        final int dz = this.getZWithOffsetAsIfRotated(x, z, rotation);
        if (sbb.b(dx, dy, dz)) {
            return world.a(dx, dy, dz);
        }
        return 0;
    }
    
    protected void fillBlocksRotated(final zv world, final aee sbb, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ, final int blockID, final int meta, final int rotation) {
        for (int dx = minY; dx <= maxY; ++dx) {
            for (int dy = minX; dy <= maxX; ++dy) {
                for (int dz = minZ; dz <= maxZ; ++dz) {
                    this.placeBlockRotated(world, blockID, meta, dy, dx, dz, rotation, sbb);
                }
            }
        }
    }
    
    protected void fillAirRotated(final zv world, final aee sbb, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ, final int rotation) {
        this.fillBlocksRotated(world, sbb, minX, minY, minZ, maxX, maxY, maxZ, 0, 0, rotation);
    }
    
    public static agr getStrongholdStones() {
        return StructureTFComponent.strongholdStones;
    }
    
    public static agr getTowerWoods() {
        return StructureTFComponent.towerWoods;
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
    
    protected int getLadderMeta(final int ladderDir) {
        switch ((this.getCoordBaseMode() + ladderDir) % 4) {
            case 0: {
                return 4;
            }
            case 1: {
                return 2;
            }
            case 2: {
                return 5;
            }
            case 3: {
                return 3;
            }
            default: {
                return -1;
            }
        }
    }
    
    protected int getLadderMeta(final int ladderDir, final int rotation) {
        return this.getLadderMeta(ladderDir + rotation);
    }
    
    public void nullifySkyLightForBoundingBox(final zv world) {
        this.nullifySkyLight(world, this.e.a - 1, this.e.b - 1, this.e.c - 1, this.e.d + 1, this.e.e + 1, this.e.f + 1);
    }
    
    public void nullifySkyLightAtCurrentPosition(final zv world, final int sx, final int sy, final int sz, final int dx, final int dy, final int dz) {
        this.nullifySkyLight(world, this.a(sx, sz), this.a(sy), this.b(sx, sz), this.a(dx, dz), this.a(dy), this.b(dx, dz));
    }
    
    public void nullifySkyLight(final zv world, final int sx, final int sy, final int sz, final int dx, final int dy, final int dz) {
        for (int x = sx; x <= dx; ++x) {
            for (int z = sz; z <= dz; ++z) {
                for (int y = sy; y <= dy; ++y) {
                    world.b(aag.a, x, y, z, 0);
                }
            }
        }
    }
    
    static {
        strongholdStones = new StructureTFStrongholdStones();
        towerWoods = new StructureTFTowerWoods();
    }
}
