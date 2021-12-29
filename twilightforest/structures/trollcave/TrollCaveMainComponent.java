// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.trollcave;

import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.DepthAverageConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.feature.SphereReplaceConfig;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.gen.feature.FeatureSpread;
import twilightforest.worldgen.BlockConstants;
import twilightforest.loot.TFTreasure;
import net.minecraft.world.gen.feature.IFeatureConfig;
import twilightforest.world.feature.config.CaveStalactiteConfig;
import twilightforest.world.feature.TFBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.util.math.vector.Vector3i;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.tags.ITag;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import twilightforest.util.RotationUtil;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.util.Direction;
import twilightforest.TFFeature;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.world.biome.Biome;
import java.util.function.Predicate;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import twilightforest.structures.TFStructureComponentOld;

public class TrollCaveMainComponent extends TFStructureComponentOld
{
    protected int size;
    protected int height;
    public static final ConfiguredFeature<?, ?> uberousGen;
    protected static final Predicate<Biome> highlands;
    
    public TrollCaveMainComponent(final TemplateManager manager, final CompoundNBT nbt) {
        this(TrollCavePieces.TFTCMai, nbt);
    }
    
    public TrollCaveMainComponent(final IStructurePieceType piece, final CompoundNBT nbt) {
        super(piece, nbt);
        this.size = nbt.func_74762_e("size");
        this.height = nbt.func_74762_e("height");
    }
    
    public TrollCaveMainComponent(final IStructurePieceType type, final TFFeature feature, final int index) {
        super(type, feature, index);
    }
    
    public TrollCaveMainComponent(final IStructurePieceType type, final TFFeature feature, final int i, final int x, int y, final int z) {
        this(type, feature, i);
        this.func_186164_a(Direction.SOUTH);
        y += 10;
        this.size = 30;
        this.height = 20;
        final int radius = this.size / 2;
        this.field_74887_e = feature.getComponentToAddBoundingBox(x, y, z, -radius, -this.height, -radius, this.size, this.height, this.size, Direction.SOUTH);
    }
    
    @Override
    protected void func_143011_b(final CompoundNBT tagCompound) {
        super.func_143011_b(tagCompound);
        tagCompound.func_74768_a("size", this.size);
        tagCompound.func_74768_a("height", this.height);
    }
    
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
        for (final Rotation caveRotation : RotationUtil.ROTATIONS) {
            final BlockPos dest = this.getValidOpening(rand, caveRotation);
            this.makeSmallerCave(list, rand, this.func_74877_c() + 1, dest.func_177958_n(), dest.func_177956_o(), dest.func_177952_p(), 18, 15, caveRotation);
        }
        final CloudCastleComponent castle = new CloudCastleComponent(this.getFeatureType(), this.func_74877_c() + 1, this.field_74887_e.field_78897_a + (this.field_74887_e.field_78893_d - this.field_74887_e.field_78897_a) / 2, 168, this.field_74887_e.field_78896_c + (this.field_74887_e.field_78892_f - this.field_74887_e.field_78896_c) / 2);
        list.add(castle);
        castle.func_74861_a(this, list, rand);
        final TrollVaultComponent vault = new TrollVaultComponent(this.getFeatureType(), this.func_74877_c() + 1, this.field_74887_e.field_78897_a + (this.field_74887_e.field_78893_d - this.field_74887_e.field_78897_a) / 2, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + (this.field_74887_e.field_78892_f - this.field_74887_e.field_78896_c) / 2);
        list.add(vault);
        vault.func_74861_a((StructurePiece)this, (List)list, rand);
    }
    
    protected boolean makeSmallerCave(final List<StructurePiece> list, final Random rand, final int index, final int x, final int y, final int z, final int caveSize, final int caveHeight, final Rotation rotation) {
        final Direction direction = this.getStructureRelativeRotation(rotation);
        final BlockPos dest = this.offsetTowerCCoords(x, y, z, caveSize, direction);
        final TrollCaveConnectComponent cave = new TrollCaveConnectComponent(this.getFeatureType(), index, dest.func_177958_n(), dest.func_177956_o(), dest.func_177952_p(), caveSize, caveHeight, direction);
        final StructurePiece intersect = StructurePiece.func_74883_a((List)list, cave.func_74874_b());
        if (intersect == null || intersect == this) {
            list.add(cave);
            cave.func_74861_a(list.get(0), list, rand);
            return true;
        }
        return false;
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final Random decoRNG = new Random(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
        this.hollowCaveMiddle(world, sbb, rand, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1);
        for (int i = 0; i < 128; ++i) {
            final BlockPos dest = this.getCoordsInCave(decoRNG);
            this.generateBlockStalactite(world, generator, decoRNG, Blocks.field_150348_b, 0.7f, true, dest.func_177958_n(), 3, dest.func_177952_p(), sbb);
        }
        for (int i = 0; i < 32; ++i) {
            final BlockPos dest = this.getCoordsInCave(decoRNG);
            this.generateBlockStalactite(world, generator, decoRNG, Blocks.field_150348_b, 0.5f, false, dest.func_177958_n(), 3, dest.func_177952_p(), sbb);
        }
        for (int i = 0; i < 32; ++i) {
            final BlockPos dest = this.getCoordsInCave(decoRNG);
            this.generateAtSurface(world, generator, TrollCaveMainComponent.uberousGen, decoRNG, dest.func_177958_n(), 60, dest.func_177952_p(), sbb);
        }
        return true;
    }
    
    protected BlockPos getCoordsInCave(final Random rand) {
        return new BlockPos(rand.nextInt(this.size - 1), rand.nextInt(this.height - 1), rand.nextInt(this.size - 1));
    }
    
    protected BlockPos getCenterBiasedCaveCoords(final Random rand) {
        return new BlockPos(this.size - rand.nextInt(this.size / 2), rand.nextInt(this.height - 1), this.size - rand.nextInt(this.size / 2));
    }
    
    protected void hollowCaveMiddle(final ISeedReader world, final MutableBoundingBox boundingBox, final Random rand, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ) {
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
                    else if (dist == threshold && rand.nextInt(4) == 0 && this.func_175807_a((IBlockReader)world, x, y, z, boundingBox).func_177230_c().func_203417_a((ITag)BlockTags.field_242172_aH)) {
                        this.func_175811_a(world, ((Block)TFBlocks.trollsteinn.get()).func_176223_P(), x, y, z, boundingBox);
                    }
                }
            }
        }
    }
    
    public BlockPos getValidOpening(final Random rand, final Rotation direction) {
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
    protected BlockPos offsetTowerCCoords(final int x, final int y, final int z, final int towerSize, final Direction direction) {
        final int dx = this.func_74865_a(x, z);
        final int dy = this.func_74862_a(y);
        final int dz = this.func_74873_b(x, z);
        if (direction == Direction.SOUTH) {
            return new BlockPos(dx - 1, dy - 1, dz - towerSize / 2);
        }
        if (direction == Direction.WEST) {
            return new BlockPos(dx + towerSize / 2, dy - 1, dz - 1);
        }
        if (direction == Direction.NORTH) {
            return new BlockPos(dx + 1, dy - 1, dz + towerSize / 2);
        }
        if (direction == Direction.EAST) {
            return new BlockPos(dx - towerSize / 2, dy - 1, dz + 1);
        }
        return new BlockPos(x, y, z);
    }
    
    protected void generateBlockStalactite(final ISeedReader world, final ChunkGenerator generator, final Random rand, final Block blockToGenerate, final float length, final boolean up, final int x, final int y, final int z, final MutableBoundingBox sbb) {
        final int dx = this.func_74865_a(x, z);
        final int dy = this.func_74862_a(y);
        final int dz = this.func_74873_b(x, z);
        final BlockPos pos = new BlockPos(dx, dy, dz);
        if (sbb.func_175898_b((Vector3i)pos)) {
            ((Feature)TFBiomeFeatures.CAVE_STALACTITE.get()).func_225566_b_((IFeatureConfig)new CaveStalactiteConfig(blockToGenerate.func_176223_P(), length, -1, -1, up)).func_242765_a(world, generator, rand, pos);
        }
    }
    
    protected void generateAtSurface(final ISeedReader world, final ChunkGenerator generator, final ConfiguredFeature<?, ?> feature, final Random rand, final int x, final int y, final int z, final MutableBoundingBox sbb) {
        final int dx = this.func_74865_a(x, z);
        int dy = y;
        final int dz = this.func_74873_b(x, z);
        final BlockPos.Mutable pos = new BlockPos.Mutable(dx, dy, dz);
        if (sbb.func_175898_b((Vector3i)pos)) {
            for (dy = y; dy < y + 32; ++dy) {
                pos.func_185336_p(dy);
                if (world.func_175623_d((BlockPos)pos)) {
                    break;
                }
            }
            feature.func_242765_a(world, generator, rand, pos.func_185334_h());
        }
    }
    
    protected void makeTreasureCrate(final ISeedReader world, final MutableBoundingBox sbb) {
        final int mid = this.size / 2;
        this.func_175804_a(world, sbb, mid - 2, 0, mid - 2, mid + 1, 3, mid + 1, Blocks.field_150343_Z.func_176223_P(), Blocks.field_150343_Z.func_176223_P(), false);
        this.func_74878_a(world, sbb, mid - 1, 1, mid - 1, mid, 2, mid);
        this.placeTreasureAtCurrentPosition(world, mid, 1, mid, TFTreasure.troll_garden, false, sbb);
    }
    
    static {
        uberousGen = ((Feature)TFBiomeFeatures.MYCELIUM_BLOB.get()).func_225566_b_((IFeatureConfig)new SphereReplaceConfig(BlockConstants.UBEROUS_SOIL, FeatureSpread.func_242253_a(5, 6), 1, (List)ImmutableList.of((Object)BlockConstants.PODZOL, (Object)BlockConstants.COARSE_DIRT, (Object)BlockConstants.DIRT))).func_227228_a_(Placement.field_242910_o.func_227446_a_((IPlacementConfig)new DepthAverageConfig(60, 10)));
        highlands = (biome -> false);
    }
}
