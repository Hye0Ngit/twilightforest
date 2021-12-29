// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.trollcave;

import twilightforest.biomes.TFBiomes;
import twilightforest.loot.TFTreasure;
import twilightforest.world.feature.TFGenCaveStalactite;
import net.minecraft.util.math.Vec3i;
import net.minecraft.block.Block;
import twilightforest.block.TFBlocks;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import twilightforest.util.RotationUtil;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.TFFeature;
import net.minecraft.world.biome.Biome;
import java.util.function.Predicate;
import twilightforest.world.feature.TFGenMyceliumBlob;
import twilightforest.structures.StructureTFComponentOld;

public class ComponentTFTrollCaveMain extends StructureTFComponentOld
{
    protected int size;
    protected int height;
    public static final TFGenMyceliumBlob uberousGen;
    protected static final Predicate<Biome> highlands;
    
    public ComponentTFTrollCaveMain() {
    }
    
    public ComponentTFTrollCaveMain(final TFFeature feature, final int index) {
        super(feature, index);
    }
    
    public ComponentTFTrollCaveMain(final TFFeature feature, final World world, final Random rand, final int i, final int x, int y, final int z) {
        super(feature, i);
        this.func_186164_a(EnumFacing.SOUTH);
        y += 10;
        this.size = 30;
        this.height = 20;
        final int radius = this.size / 2;
        this.field_74887_e = StructureTFComponentOld.getComponentToAddBoundingBox(x, y, z, -radius, -this.height, -radius, this.size, this.height, this.size, EnumFacing.SOUTH);
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound tagCompound) {
        super.func_143012_a(tagCompound);
        tagCompound.func_74768_a("size", this.size);
        tagCompound.func_74768_a("height", this.height);
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound tagCompound, final TemplateManager templateManager) {
        super.func_143011_b(tagCompound, templateManager);
        this.size = tagCompound.func_74762_e("size");
        this.height = tagCompound.func_74762_e("height");
    }
    
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        for (final Rotation caveRotation : RotationUtil.ROTATIONS) {
            final BlockPos dest = this.getValidOpening(rand, 5, caveRotation);
            this.makeSmallerCave(list, rand, this.func_74877_c() + 1, dest.func_177958_n(), dest.func_177956_o(), dest.func_177952_p(), 18, 15, caveRotation);
        }
        final ComponentTFCloudCastle castle = new ComponentTFCloudCastle(this.getFeatureType(), this.func_74877_c() + 1, this.field_74887_e.field_78897_a + (this.field_74887_e.field_78893_d - this.field_74887_e.field_78897_a) / 2, 168, this.field_74887_e.field_78896_c + (this.field_74887_e.field_78892_f - this.field_74887_e.field_78896_c) / 2);
        list.add(castle);
        castle.func_74861_a(this, list, rand);
        final ComponentTFTrollVault vault = new ComponentTFTrollVault(this.getFeatureType(), this.func_74877_c() + 1, this.field_74887_e.field_78897_a + (this.field_74887_e.field_78893_d - this.field_74887_e.field_78897_a) / 2, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + (this.field_74887_e.field_78892_f - this.field_74887_e.field_78896_c) / 2);
        list.add(vault);
        vault.func_74861_a((StructureComponent)this, (List)list, rand);
    }
    
    protected boolean makeSmallerCave(final List<StructureComponent> list, final Random rand, final int index, final int x, final int y, final int z, final int caveSize, final int caveHeight, final Rotation rotation) {
        final EnumFacing direction = this.getStructureRelativeRotation(rotation);
        final BlockPos dest = this.offsetTowerCCoords(x, y, z, caveSize, direction);
        final ComponentTFTrollCaveConnect cave = new ComponentTFTrollCaveConnect(this.getFeatureType(), index, dest.func_177958_n(), dest.func_177956_o(), dest.func_177952_p(), caveSize, caveHeight, direction);
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
            final BlockPos dest = this.getCoordsInCave(decoRNG);
            this.generateBlockStalactite(world, decoRNG, Blocks.field_150348_b, 0.7f, true, dest.func_177958_n(), 3, dest.func_177952_p(), sbb);
        }
        for (int i = 0; i < 32; ++i) {
            final BlockPos dest = this.getCoordsInCave(decoRNG);
            this.generateBlockStalactite(world, decoRNG, Blocks.field_150348_b, 0.5f, false, dest.func_177958_n(), 3, dest.func_177952_p(), sbb);
        }
        for (int i = 0; i < 32; ++i) {
            final BlockPos dest = this.getCoordsInCave(decoRNG);
            this.generateAtSurface(world, ComponentTFTrollCaveMain.uberousGen, decoRNG, dest.func_177958_n(), 60, dest.func_177952_p(), sbb);
        }
        return true;
    }
    
    protected BlockPos getCoordsInCave(final Random rand) {
        return new BlockPos(rand.nextInt(this.size - 1), rand.nextInt(this.height - 1), rand.nextInt(this.size - 1));
    }
    
    protected void hollowCaveMiddle(final World world, final StructureBoundingBox boundingBox, final Random rand, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ) {
        final int threshold = this.size / 5;
        for (int y = minY; y <= maxY; ++y) {
            for (int x = minX; x <= maxX; ++x) {
                for (int z = minZ; z <= maxZ; ++z) {
                    final int ex = Math.min(x - minX, maxX - x);
                    final int ey = Math.min((y - minY) * 2, maxY - y);
                    final int ez = Math.min(z - minZ, maxZ - z);
                    final double dist = Math.sqrt(ex * ey * ez);
                    if (dist > threshold) {
                        this.func_175811_a(world, Blocks.field_150350_a.func_176223_P(), x, y, z, boundingBox);
                    }
                    else if (dist == threshold && rand.nextInt(4) == 0 && this.func_175807_a(world, x, y, z, boundingBox).func_177230_c() == Blocks.field_150348_b) {
                        this.func_175811_a(world, TFBlocks.trollsteinn.func_176223_P(), x, y, z, boundingBox);
                    }
                }
            }
        }
    }
    
    public BlockPos getValidOpening(final Random rand, final int caveHeight, final Rotation direction) {
        final int offset = this.size / 4;
        final int wLength = this.size - offset * 2;
        if (direction == Rotation.NONE || direction == Rotation.CLOCKWISE_180) {
            final int rx = (direction == Rotation.NONE) ? (this.size - 1) : 0;
            final int rz = offset + rand.nextInt(wLength);
            final int ry = rand.nextInt(offset) - rand.nextInt(offset);
            return new BlockPos(rx, ry, rz);
        }
        if (direction == Rotation.CLOCKWISE_90 || direction == Rotation.COUNTERCLOCKWISE_90) {
            final int rx = offset + rand.nextInt(wLength);
            final int rz = (direction == Rotation.CLOCKWISE_90) ? (this.size - 1) : 0;
            final int ry = rand.nextInt(offset) - rand.nextInt(offset);
            return new BlockPos(rx, ry, rz);
        }
        return null;
    }
    
    @Override
    protected BlockPos offsetTowerCCoords(final int x, final int y, final int z, final int towerSize, final EnumFacing direction) {
        final int dx = this.func_74865_a(x, z);
        final int dy = this.func_74862_a(y);
        final int dz = this.func_74873_b(x, z);
        if (direction == EnumFacing.SOUTH) {
            return new BlockPos(dx - 1, dy - 1, dz - towerSize / 2);
        }
        if (direction == EnumFacing.WEST) {
            return new BlockPos(dx + towerSize / 2, dy - 1, dz - 1);
        }
        if (direction == EnumFacing.NORTH) {
            return new BlockPos(dx + 1, dy - 1, dz + towerSize / 2);
        }
        if (direction == EnumFacing.EAST) {
            return new BlockPos(dx - towerSize / 2, dy - 1, dz + 1);
        }
        return new BlockPos(x, y, z);
    }
    
    protected void generateBlockStalactite(final World world, final Random rand, final Block blockToGenerate, final float length, final boolean up, final int x, final int y, final int z, final StructureBoundingBox sbb) {
        final int dx = this.func_74865_a(x, z);
        final int dy = this.func_74862_a(y);
        final int dz = this.func_74873_b(x, z);
        final BlockPos pos = new BlockPos(dx, dy, dz);
        if (sbb.func_175898_b((Vec3i)pos)) {
            new TFGenCaveStalactite(blockToGenerate, length, up).func_180709_b(world, rand, pos);
        }
    }
    
    protected void generateAtSurface(final World world, final WorldGenerator generator, final Random rand, final int x, final int y, final int z, final StructureBoundingBox sbb) {
        final int dx = this.func_74865_a(x, z);
        int dy = y;
        final int dz = this.func_74873_b(x, z);
        final BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(dx, dy, dz);
        if (sbb.func_175898_b((Vec3i)pos)) {
            for (dy = y; dy < y + 32; ++dy) {
                pos.func_185336_p(dy);
                if (world.func_175623_d((BlockPos)pos)) {
                    break;
                }
            }
            generator.func_180709_b(world, rand, pos.func_185334_h());
        }
    }
    
    protected void makeTreasureCrate(final World world, final Random rand, final StructureBoundingBox sbb) {
        final int mid = this.size / 2;
        this.func_175804_a(world, sbb, mid - 2, 0, mid - 2, mid + 1, 3, mid + 1, Blocks.field_150343_Z.func_176223_P(), Blocks.field_150343_Z.func_176223_P(), false);
        this.func_74878_a(world, sbb, mid - 1, 1, mid - 1, mid + 0, 2, mid + 0);
        this.placeTreasureAtCurrentPosition(world, rand, mid, 1, mid, TFTreasure.troll_garden, false, sbb);
    }
    
    static {
        uberousGen = new TFGenMyceliumBlob(TFBlocks.uberous_soil, 4);
        highlands = (biome -> biome == TFBiomes.highlands);
    }
}
