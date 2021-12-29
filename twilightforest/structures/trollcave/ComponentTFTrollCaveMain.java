// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.trollcave;

import twilightforest.TFTreasure;
import twilightforest.world.TFGenCaveStalactite;
import net.minecraft.block.Block;
import twilightforest.biomes.TFBiomeBase;
import twilightforest.block.TFBlocks;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.util.ChunkCoordinates;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.nbt.NBTTagCompound;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.world.TFGenMyceliumBlob;
import twilightforest.structures.StructureTFComponent;

public class ComponentTFTrollCaveMain extends StructureTFComponent
{
    protected int size;
    protected int height;
    public static final TFGenMyceliumBlob uberousGen;
    
    public ComponentTFTrollCaveMain() {
    }
    
    public ComponentTFTrollCaveMain(final int index) {
        super(index);
    }
    
    public ComponentTFTrollCaveMain(final World world, final Random rand, final int i, final int x, int y, final int z) {
        this.setCoordBaseMode(0);
        y += 10;
        this.size = 30;
        this.height = 20;
        final int radius = this.size / 2;
        this.field_74887_e = StructureTFComponent.getComponentToAddBoundingBox(x, y, z, -radius, -this.height, -radius, this.size, this.height, this.size, 0);
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_143012_a(par1NBTTagCompound);
        par1NBTTagCompound.func_74768_a("size", this.size);
        par1NBTTagCompound.func_74768_a("height", this.height);
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_143011_b(par1NBTTagCompound);
        this.size = par1NBTTagCompound.func_74762_e("size");
        this.height = par1NBTTagCompound.func_74762_e("height");
    }
    
    public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
        for (int i = 0; i < 4; ++i) {
            final ChunkCoordinates dest = this.getValidOpening(rand, 5, i);
            this.makeSmallerCave(list, rand, this.func_74877_c() + 1, dest.field_71574_a, dest.field_71572_b, dest.field_71573_c, 18, 15, i);
        }
        final ComponentTFCloudCastle castle = new ComponentTFCloudCastle(this.func_74877_c() + 1, this.field_74887_e.field_78897_a + (this.field_74887_e.field_78893_d - this.field_74887_e.field_78897_a) / 2, 168, this.field_74887_e.field_78896_c + (this.field_74887_e.field_78892_f - this.field_74887_e.field_78896_c) / 2);
        list.add(castle);
        castle.func_74861_a(this, list, rand);
        final ComponentTFTrollVault vault = new ComponentTFTrollVault(this.func_74877_c() + 1, this.field_74887_e.field_78897_a + (this.field_74887_e.field_78893_d - this.field_74887_e.field_78897_a) / 2, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + (this.field_74887_e.field_78892_f - this.field_74887_e.field_78896_c) / 2);
        list.add(vault);
        vault.func_74861_a(this, list, rand);
    }
    
    protected boolean makeSmallerCave(final List<StructureComponent> list, final Random rand, final int index, final int x, final int y, final int z, final int caveSize, final int caveHeight, final int rotation) {
        final int direction = (this.getCoordBaseMode() + rotation) % 4;
        final ChunkCoordinates dest = this.offsetTowerCCoords(x, y, z, caveSize, direction);
        final ComponentTFTrollCaveConnect cave = new ComponentTFTrollCaveConnect(index, dest.field_71574_a, dest.field_71572_b, dest.field_71573_c, caveSize, caveHeight, direction);
        final StructureComponent intersect = StructureComponent.func_74883_a((List)list, cave.func_74874_b());
        if (intersect == null || intersect == this) {
            list.add(cave);
            cave.func_74861_a(list.get(0), list, rand);
            return true;
        }
        return false;
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        final Random decoRNG = new Random(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
        this.hollowCaveMiddle(world, sbb, rand, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1);
        for (int i = 0; i < 128; ++i) {
            final ChunkCoordinates dest = this.getCoordsInCave(decoRNG);
            this.generateBlockStalactite(world, decoRNG, Blocks.field_150348_b, 0.7f, true, dest.field_71574_a, 3, dest.field_71573_c, sbb);
        }
        for (int i = 0; i < 32; ++i) {
            final ChunkCoordinates dest = this.getCoordsInCave(decoRNG);
            this.generateBlockStalactite(world, decoRNG, Blocks.field_150348_b, 0.5f, false, dest.field_71574_a, 3, dest.field_71573_c, sbb);
        }
        for (int i = 0; i < 32; ++i) {
            final ChunkCoordinates dest = this.getCoordsInCave(decoRNG);
            this.generateAtSurface(world, ComponentTFTrollCaveMain.uberousGen, decoRNG, dest.field_71574_a, 60, dest.field_71573_c, sbb);
        }
        return true;
    }
    
    protected ChunkCoordinates getCoordsInCave(final Random rand) {
        return new ChunkCoordinates(rand.nextInt(this.size - 1), rand.nextInt(this.height - 1), rand.nextInt(this.size - 1));
    }
    
    protected void hollowCaveMiddle(final World par1World, final StructureBoundingBox par2StructureBoundingBox, final Random rand, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ) {
        final int threshold = this.size / 5;
        for (int y = minY; y <= maxY; ++y) {
            for (int x = minX; x <= maxX; ++x) {
                for (int z = minZ; z <= maxZ; ++z) {
                    final int ex = Math.min(x - minX, maxX - x);
                    final int ey = Math.min((y - minY) * 2, maxY - y);
                    final int ez = Math.min(z - minZ, maxZ - z);
                    final double dist = Math.sqrt(ex * ey * ez);
                    if (dist > threshold) {
                        this.func_151550_a(par1World, Blocks.field_150350_a, 0, x, y, z, par2StructureBoundingBox);
                    }
                    else if (dist == threshold && rand.nextInt(4) == 0 && this.func_151548_a(par1World, x, y, z, par2StructureBoundingBox) == Blocks.field_150348_b) {
                        this.func_151550_a(par1World, TFBlocks.trollSteinn, 0, x, y, z, par2StructureBoundingBox);
                    }
                }
            }
        }
    }
    
    public ChunkCoordinates getValidOpening(final Random rand, final int caveHeight, final int direction) {
        final int offset = this.size / 4;
        final int wLength = this.size - offset * 2;
        if (direction == 0 || direction == 2) {
            final int rx = (direction == 0) ? (this.size - 1) : 0;
            final int rz = offset + rand.nextInt(wLength);
            final int ry = rand.nextInt(offset) - rand.nextInt(offset);
            return new ChunkCoordinates(rx, ry, rz);
        }
        if (direction == 1 || direction == 3) {
            final int rx = offset + rand.nextInt(wLength);
            final int rz = (direction == 1) ? (this.size - 1) : 0;
            final int ry = rand.nextInt(offset) - rand.nextInt(offset);
            return new ChunkCoordinates(rx, ry, rz);
        }
        return null;
    }
    
    @Override
    protected ChunkCoordinates offsetTowerCCoords(final int x, final int y, final int z, final int towerSize, final int direction) {
        final int dx = this.func_74865_a(x, z);
        final int dy = this.func_74862_a(y);
        final int dz = this.func_74873_b(x, z);
        if (direction == 0) {
            return new ChunkCoordinates(dx - 1, dy - 1, dz - towerSize / 2);
        }
        if (direction == 1) {
            return new ChunkCoordinates(dx + towerSize / 2, dy - 1, dz - 1);
        }
        if (direction == 2) {
            return new ChunkCoordinates(dx + 1, dy - 1, dz + towerSize / 2);
        }
        if (direction == 3) {
            return new ChunkCoordinates(dx - towerSize / 2, dy - 1, dz + 1);
        }
        return new ChunkCoordinates(x, y, z);
    }
    
    public boolean isBoundingBoxOutOfHighlands(final World world, final StructureBoundingBox sbb) {
        final int minX = this.field_74887_e.field_78897_a - 1;
        final int minZ = this.field_74887_e.field_78896_c - 1;
        final int maxX = this.field_74887_e.field_78893_d + 1;
        final int maxZ = this.field_74887_e.field_78892_f + 1;
        for (int x = minX; x <= maxX; ++x) {
            for (int z = minZ; z <= maxZ; ++z) {
                if (world.func_72807_a(x, z) != TFBiomeBase.highlands) {
                    return true;
                }
            }
        }
        return false;
    }
    
    protected void generateBlockStalactite(final World world, final Random rand, final Block blockToGenerate, final float length, final boolean up, final int x, final int y, final int z, final StructureBoundingBox sbb) {
        final int dx = this.func_74865_a(x, z);
        final int dy = this.func_74862_a(y);
        final int dz = this.func_74873_b(x, z);
        if (sbb.func_78890_b(dx, dy, dz)) {
            new TFGenCaveStalactite(blockToGenerate, length, up).func_76484_a(world, rand, dx, dy, dz);
        }
    }
    
    protected void generateAtSurface(final World world, final WorldGenerator generator, final Random rand, final int x, final int y, final int z, final StructureBoundingBox sbb) {
        final int dx = this.func_74865_a(x, z);
        int dy = y;
        final int dz = this.func_74873_b(x, z);
        if (sbb.func_78890_b(dx, dy, dz)) {
            for (dy = y; dy < y + 32 && !world.func_147437_c(dx, dy, dz); ++dy) {}
            generator.func_76484_a(world, rand, dx, dy, dz);
        }
    }
    
    protected void makeTreasureCrate(final World world, final Random rand, final StructureBoundingBox sbb) {
        final int mid = this.size / 2;
        this.func_151549_a(world, sbb, mid - 2, 0, mid - 2, mid + 1, 3, mid + 1, Blocks.field_150343_Z, Blocks.field_150343_Z, false);
        this.func_74878_a(world, sbb, mid - 1, 1, mid - 1, mid + 0, 2, mid + 0);
        this.placeTreasureAtCurrentPosition(world, rand, mid, 1, mid, TFTreasure.troll_garden, false, sbb);
    }
    
    static {
        uberousGen = new TFGenMyceliumBlob(TFBlocks.uberousSoil, 4);
    }
}
