// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import net.minecraft.block.material.Material;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.gen.structure.StructurePieceBlockSelector;
import twilightforest.TFTreasure;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityMobSpawner;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.gen.structure.StructureComponent;

public abstract class StructureTFComponent extends StructureComponent
{
    private static final StructureTFStrongholdStones strongholdStones;
    public StructureTFDecorator deco;
    public int spawnListIndex;
    
    public StructureTFComponent() {
        this.deco = null;
        this.spawnListIndex = 0;
    }
    
    public StructureTFComponent(final int i) {
        super(i);
        this.deco = null;
        this.spawnListIndex = 0;
    }
    
    protected void func_143012_a(final NBTTagCompound par1NBTTagCompound) {
        par1NBTTagCompound.func_74768_a("si", this.spawnListIndex);
        final String s = "deco";
        final StructureTFDecorator deco = this.deco;
        par1NBTTagCompound.func_74778_a(s, StructureTFDecorator.getDecoString(this.deco));
    }
    
    protected void func_143011_b(final NBTTagCompound par1NBTTagCompound) {
        this.spawnListIndex = par1NBTTagCompound.func_74762_e("si");
        this.deco = StructureTFDecorator.getDecoFor(par1NBTTagCompound.func_74779_i("deco"));
    }
    
    public static StructureBoundingBox getComponentToAddBoundingBox(final int x, final int y, final int z, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ, final int dir) {
        switch (dir) {
            default: {
                return new StructureBoundingBox(x + minX, y + minY, z + minZ, x + maxX + minX, y + maxY + minY, z + maxZ + minZ);
            }
            case 0: {
                return new StructureBoundingBox(x + minX, y + minY, z + minZ, x + maxX + minX, y + maxY + minY, z + maxZ + minZ);
            }
            case 1: {
                return new StructureBoundingBox(x - maxZ + minZ, y + minY, z + minX, x + minZ, y + maxY + minY, z + maxX + minX);
            }
            case 2: {
                return new StructureBoundingBox(x - maxX - minX, y + minY, z - maxZ - minZ, x - minX, y + maxY + minY, z - minZ);
            }
            case 3: {
                return new StructureBoundingBox(x + minZ, y + minY, z - maxX, x + maxZ + minZ, y + maxY + minY, z + minX);
            }
        }
    }
    
    protected TileEntityMobSpawner placeSpawnerAtCurrentPosition(final World world, final Random rand, final int x, final int y, final int z, final String monsterID, final StructureBoundingBox sbb) {
        TileEntityMobSpawner tileEntitySpawner = null;
        final int dx = this.func_74865_a(x, z);
        final int dy = this.func_74862_a(y);
        final int dz = this.func_74873_b(x, z);
        if (sbb.func_78890_b(dx, dy, dz) && world.func_72798_a(dx, dy, dz) != Block.field_72065_as.field_71990_ca) {
            world.func_72832_d(dx, dy, dz, Block.field_72065_as.field_71990_ca, 0, 2);
            tileEntitySpawner = (TileEntityMobSpawner)world.func_72796_p(dx, dy, dz);
            if (tileEntitySpawner != null) {
                tileEntitySpawner.func_98049_a().func_98272_a(monsterID);
            }
        }
        return tileEntitySpawner;
    }
    
    protected TileEntityMobSpawner placeSpawnerRotated(final World world, final int x, final int y, final int z, final int rotation, final String monsterID, final StructureBoundingBox sbb) {
        TileEntityMobSpawner tileEntitySpawner = null;
        final int dx = this.getXWithOffsetAsIfRotated(x, z, rotation);
        final int dy = this.func_74862_a(y);
        final int dz = this.getZWithOffsetAsIfRotated(x, z, rotation);
        if (sbb.func_78890_b(dx, dy, dz) && world.func_72798_a(dx, dy, dz) != Block.field_72065_as.field_71990_ca) {
            world.func_72832_d(dx, dy, dz, Block.field_72065_as.field_71990_ca, 0, 2);
            tileEntitySpawner = (TileEntityMobSpawner)world.func_72796_p(dx, dy, dz);
            if (tileEntitySpawner != null) {
                tileEntitySpawner.func_98049_a().func_98272_a(monsterID);
            }
        }
        return tileEntitySpawner;
    }
    
    protected void placeTreasureAtCurrentPosition(final World world, final Random rand, final int x, final int y, final int z, final TFTreasure treasureType, final StructureBoundingBox sbb) {
        this.placeTreasureAtCurrentPosition(world, rand, x, y, z, treasureType, false, sbb);
    }
    
    protected void placeTreasureAtCurrentPosition(final World world, final Random rand, final int x, final int y, final int z, final TFTreasure treasureType, final boolean trapped, final StructureBoundingBox sbb) {
        final int dx = this.func_74865_a(x, z);
        final int dy = this.func_74862_a(y);
        final int dz = this.func_74873_b(x, z);
        if (sbb.func_78890_b(dx, dy, dz) && world.func_72798_a(dx, dy, dz) != Block.field_72077_au.field_71990_ca) {
            treasureType.generate(world, rand, dx, dy, dz, trapped ? Block.field_94347_ck.field_71990_ca : Block.field_72077_au.field_71990_ca);
        }
    }
    
    protected void placeTreasureRotated(final World world, final int x, final int y, final int z, final int rotation, final TFTreasure treasureType, final StructureBoundingBox sbb) {
        this.placeTreasureRotated(world, x, y, z, rotation, treasureType, false, sbb);
    }
    
    protected void placeTreasureRotated(final World world, final int x, final int y, final int z, final int rotation, final TFTreasure treasureType, final boolean trapped, final StructureBoundingBox sbb) {
        final int dx = this.getXWithOffsetAsIfRotated(x, z, rotation);
        final int dy = this.func_74862_a(y);
        final int dz = this.getZWithOffsetAsIfRotated(x, z, rotation);
        if (sbb.func_78890_b(dx, dy, dz) && world.func_72798_a(dx, dy, dz) != Block.field_72077_au.field_71990_ca) {
            treasureType.generate(world, null, dx, dy, dz, trapped ? Block.field_94347_ck.field_71990_ca : Block.field_72077_au.field_71990_ca);
        }
    }
    
    protected int[] offsetTowerCoords(final int x, final int y, final int z, final int towerSize, final int direction) {
        final int dx = this.func_74865_a(x, z);
        final int dy = this.func_74862_a(y);
        final int dz = this.func_74873_b(x, z);
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
        dest[0] = this.func_74865_a(src[0], src[2]);
        dest[1] = this.func_74862_a(src[1]);
        dest[2] = this.func_74873_b(src[0], src[2]);
        this.setCoordBaseMode(temp);
        return dest;
    }
    
    protected int func_74865_a(final int x, final int z) {
        switch (this.getCoordBaseMode()) {
            case 0: {
                return this.field_74887_e.field_78897_a + x;
            }
            case 1: {
                return this.field_74887_e.field_78893_d - z;
            }
            case 2: {
                return this.field_74887_e.field_78893_d - x;
            }
            case 3: {
                return this.field_74887_e.field_78897_a + z;
            }
            default: {
                return x;
            }
        }
    }
    
    protected int func_74862_a(final int par1) {
        return super.func_74862_a(par1);
    }
    
    protected int func_74873_b(final int x, final int z) {
        switch (this.getCoordBaseMode()) {
            case 0: {
                return this.field_74887_e.field_78896_c + z;
            }
            case 1: {
                return this.field_74887_e.field_78896_c + x;
            }
            case 2: {
                return this.field_74887_e.field_78892_f - z;
            }
            case 3: {
                return this.field_74887_e.field_78892_f - x;
            }
            default: {
                return z;
            }
        }
    }
    
    protected int getXWithOffsetAsIfRotated(final int x, final int z, final int rotation) {
        if (this.field_74885_f < 0) {
            return x;
        }
        switch ((this.field_74885_f + rotation) % 4) {
            case 0: {
                return this.field_74887_e.field_78897_a + x;
            }
            case 1: {
                return this.field_74887_e.field_78893_d - z;
            }
            case 2: {
                return this.field_74887_e.field_78893_d - x;
            }
            case 3: {
                return this.field_74887_e.field_78897_a + z;
            }
            default: {
                return x;
            }
        }
    }
    
    protected int getZWithOffsetAsIfRotated(final int x, final int z, final int rotation) {
        if (this.field_74885_f < 0) {
            return x;
        }
        switch ((this.field_74885_f + rotation) % 4) {
            case 0: {
                return this.field_74887_e.field_78896_c + z;
            }
            case 1: {
                return this.field_74887_e.field_78896_c + x;
            }
            case 2: {
                return this.field_74887_e.field_78892_f - z;
            }
            case 3: {
                return this.field_74887_e.field_78892_f - x;
            }
            default: {
                return z;
            }
        }
    }
    
    public int getCoordBaseMode() {
        return this.field_74885_f;
    }
    
    public void setCoordBaseMode(final int coordBaseMode) {
        this.field_74885_f = coordBaseMode;
    }
    
    protected int func_74866_a(final World par1World, final int par2, final int par3, final int par4, final StructureBoundingBox par5StructureBoundingBox) {
        return super.func_74866_a(par1World, par2, par3, par4, par5StructureBoundingBox);
    }
    
    protected void func_74864_a(final World par1World, final int par2, final int par3, final int par4, final int par5, final int par6, final StructureBoundingBox par7StructureBoundingBox) {
        super.func_74864_a(par1World, par2, par3, par4, par5, par6, par7StructureBoundingBox);
    }
    
    protected void placeBlockRotated(final World world, final int blockID, final int meta, final int x, final int y, final int z, final int rotation, final StructureBoundingBox sbb) {
        final int dx = this.getXWithOffsetAsIfRotated(x, z, rotation);
        final int dy = this.func_74862_a(y);
        final int dz = this.getZWithOffsetAsIfRotated(x, z, rotation);
        if (sbb.func_78890_b(dx, dy, dz)) {
            world.func_72832_d(dx, dy, dz, blockID, meta, 2);
        }
    }
    
    protected int getBlockIDRotated(final World world, final int x, final int y, final int z, final int rotation, final StructureBoundingBox sbb) {
        final int dx = this.getXWithOffsetAsIfRotated(x, z, rotation);
        final int dy = this.func_74862_a(y);
        final int dz = this.getZWithOffsetAsIfRotated(x, z, rotation);
        if (sbb.func_78890_b(dx, dy, dz)) {
            return world.func_72798_a(dx, dy, dz);
        }
        return 0;
    }
    
    protected void fillBlocksRotated(final World world, final StructureBoundingBox sbb, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ, final int blockID, final int meta, final int rotation) {
        for (int dx = minY; dx <= maxY; ++dx) {
            for (int dy = minX; dy <= maxX; ++dy) {
                for (int dz = minZ; dz <= maxZ; ++dz) {
                    this.placeBlockRotated(world, blockID, meta, dy, dx, dz, rotation, sbb);
                }
            }
        }
    }
    
    protected void fillAirRotated(final World world, final StructureBoundingBox sbb, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ, final int rotation) {
        this.fillBlocksRotated(world, sbb, minX, minY, minZ, maxX, maxY, maxZ, 0, 0, rotation);
    }
    
    public static StructurePieceBlockSelector getStrongholdStones() {
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
    
    public void nullifySkyLightForBoundingBox(final World world) {
        this.nullifySkyLight(world, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b - 1, this.field_74887_e.field_78896_c - 1, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78894_e + 1, this.field_74887_e.field_78892_f + 1);
    }
    
    public void nullifySkyLightAtCurrentPosition(final World world, final int sx, final int sy, final int sz, final int dx, final int dy, final int dz) {
        this.nullifySkyLight(world, this.func_74865_a(sx, sz), this.func_74862_a(sy), this.func_74873_b(sx, sz), this.func_74865_a(dx, dz), this.func_74862_a(dy), this.func_74873_b(dx, dz));
    }
    
    public void nullifySkyLight(final World world, final int sx, final int sy, final int sz, final int dx, final int dy, final int dz) {
        for (int x = sx; x <= dx; ++x) {
            for (int z = sz; z <= dz; ++z) {
                for (int y = sy; y <= dy; ++y) {
                    world.func_72915_b(EnumSkyBlock.Sky, x, y, z, 0);
                }
            }
        }
    }
    
    protected int getAverageGroundLevel(final World world, final StructureBoundingBox sbb) {
        int totalHeight = 0;
        int heightCount = 0;
        for (int bz = this.field_74887_e.field_78896_c; bz <= this.field_74887_e.field_78892_f; ++bz) {
            for (int by = this.field_74887_e.field_78897_a; by <= this.field_74887_e.field_78893_d; ++by) {
                if (sbb.func_78890_b(by, 64, bz)) {
                    totalHeight += Math.max(world.func_72825_h(by, bz), world.field_73011_w.func_76557_i());
                    ++heightCount;
                }
            }
        }
        if (heightCount == 0) {
            return -1;
        }
        return totalHeight / heightCount;
    }
    
    protected int getSampledDirtLevel(final World world, final StructureBoundingBox sbb) {
        int dirtLevel = 256;
        for (int y = 90; y > 0; --y) {
            final int cx = sbb.func_78881_e();
            final int cz = sbb.func_78891_g();
            final Material material = world.func_72803_f(cx, y, cz);
            if (material == Material.field_76248_c || material == Material.field_76246_e || material == Material.field_76247_b) {
                dirtLevel = y;
                break;
            }
        }
        return dirtLevel;
    }
    
    static {
        strongholdStones = new StructureTFStrongholdStones();
    }
}
