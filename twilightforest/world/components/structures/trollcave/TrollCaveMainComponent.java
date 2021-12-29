// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.trollcave;

import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import java.util.List;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import com.google.common.collect.ImmutableList;
import twilightforest.world.registration.BlockConstants;
import twilightforest.world.registration.TFBiomeFeatures;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.NoiseEffect;
import twilightforest.loot.TFTreasure;
import net.minecraft.world.level.Level;
import twilightforest.util.WorldUtil;
import twilightforest.world.components.feature.BlockSpikeFeature;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.tags.Tag;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Rotation;
import twilightforest.util.RotationUtil;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.core.Direction;
import twilightforest.world.registration.TFFeature;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.biome.Biome;
import java.util.function.Predicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import twilightforest.world.components.feature.config.SpikeConfig;
import twilightforest.world.components.structures.TFStructureComponentOld;

public class TrollCaveMainComponent extends TFStructureComponentOld
{
    protected static final SpikeConfig STONE_STALACTITE;
    protected static final SpikeConfig STONE_STALAGMITE;
    protected int size;
    protected int height;
    public static final ConfiguredFeature<?, ?> uberousGen;
    protected static final Predicate<Biome> highlands;
    
    public TrollCaveMainComponent(final ServerLevel level, final CompoundTag nbt) {
        this(TrollCavePieces.TFTCMai, nbt);
    }
    
    public TrollCaveMainComponent(final StructurePieceType piece, final CompoundTag nbt) {
        super(piece, nbt);
        this.size = nbt.m_128451_("size");
        this.height = nbt.m_128451_("height");
    }
    
    public TrollCaveMainComponent(final StructurePieceType type, final TFFeature feature, final int i, final int x, int y, final int z) {
        super(type, feature, i, x, y, z);
        this.m_73519_(Direction.SOUTH);
        y += 10;
        this.size = 30;
        this.height = 20;
        final int radius = this.size / 2;
        this.f_73383_ = feature.getComponentToAddBoundingBox(x, y, z, -radius, -this.height, -radius, this.size, this.height, this.size, Direction.SOUTH);
    }
    
    @Override
    protected void m_142347_(final ServerLevel level, final CompoundTag tagCompound) {
        super.m_142347_(level, tagCompound);
        tagCompound.m_128405_("size", this.size);
        tagCompound.m_128405_("height", this.height);
    }
    
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        for (final Rotation caveRotation : RotationUtil.ROTATIONS) {
            final BlockPos dest = this.getValidOpening(rand, caveRotation);
            this.makeSmallerCave(list, rand, this.m_73548_() + 1, dest.m_123341_(), dest.m_123342_(), dest.m_123343_(), 18, 15, caveRotation);
        }
        final CloudCastleComponent castle = new CloudCastleComponent(this.getFeatureType(), this.m_73548_() + 1, this.f_73383_.m_162395_() + (this.f_73383_.m_162399_() - this.f_73383_.m_162395_()) / 2, 168, this.f_73383_.m_162398_() + (this.f_73383_.m_162401_() - this.f_73383_.m_162398_()) / 2);
        list.m_142679_((StructurePiece)castle);
        castle.m_142537_(this, list, rand);
        final TrollVaultComponent vault = new TrollVaultComponent(this.getFeatureType(), this.m_73548_() + 1, this.f_73383_.m_162395_() + (this.f_73383_.m_162399_() - this.f_73383_.m_162395_()) / 2, this.f_73383_.m_162396_(), this.f_73383_.m_162398_() + (this.f_73383_.m_162401_() - this.f_73383_.m_162398_()) / 2);
        list.m_142679_((StructurePiece)vault);
        vault.m_142537_((StructurePiece)this, list, rand);
    }
    
    protected boolean makeSmallerCave(final StructurePieceAccessor list, final Random rand, final int index, final int x, final int y, final int z, final int caveSize, final int caveHeight, final Rotation rotation) {
        final Direction direction = this.getStructureRelativeRotation(rotation);
        final BlockPos dest = this.offsetTowerCCoords(x, y, z, caveSize, direction);
        final TrollCaveConnectComponent cave = new TrollCaveConnectComponent(this.getFeatureType(), index, dest.m_123341_(), dest.m_123342_(), dest.m_123343_(), caveSize, caveHeight, direction);
        final StructurePiece intersect = list.m_141921_(cave.m_73547_());
        if (intersect == null || intersect == this) {
            list.m_142679_((StructurePiece)cave);
            cave.m_142537_(this, list, rand);
            return true;
        }
        return false;
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final Random decoRNG = new Random(world.m_7328_() + this.f_73383_.m_162395_() * 321534781L ^ this.f_73383_.m_162398_() * 756839L);
        this.hollowCaveMiddle(world, sbb, rand, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1);
        for (int i = 0; i < 128; ++i) {
            final BlockPos dest = (BlockPos)this.getCoordsInCave(decoRNG);
            this.generateBlockSpike(world, TrollCaveMainComponent.STONE_STALACTITE, (Vec3i)dest.m_175288_(this.height), sbb);
        }
        for (int i = 0; i < 32; ++i) {
            final BlockPos dest = (BlockPos)this.getCoordsInCave(decoRNG);
            this.generateBlockSpike(world, TrollCaveMainComponent.STONE_STALAGMITE, (Vec3i)dest.m_175288_(0), sbb);
        }
        for (int i = 0; i < 32; ++i) {
            final BlockPos dest = (BlockPos)this.getCoordsInCave(decoRNG);
            this.generateAtSurface(world, generator, TrollCaveMainComponent.uberousGen, decoRNG, dest.m_123341_(), dest.m_123343_(), sbb);
        }
        return true;
    }
    
    protected BlockPos.MutableBlockPos getCoordsInCave(final Random rand) {
        return new BlockPos.MutableBlockPos(rand.nextInt(this.size - 1), rand.nextInt(this.height - 1), rand.nextInt(this.size - 1));
    }
    
    protected BlockPos getCenterBiasedCaveCoords(final Random rand) {
        return new BlockPos(this.size - rand.nextInt(this.size / 2), rand.nextInt(this.height - 1), this.size - rand.nextInt(this.size / 2));
    }
    
    protected void hollowCaveMiddle(final WorldGenLevel world, final BoundingBox boundingBox, final Random rand, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ) {
        final int threshold = this.size / 5;
        for (int y = minY; y <= maxY; ++y) {
            for (int x = minX; x <= maxX; ++x) {
                for (int z = minZ; z <= maxZ; ++z) {
                    final int ex = Math.min(x - minX, maxX - x);
                    final int ey = Math.min((y - minY) * 2, maxY - y);
                    final int ez = Math.min(z - minZ, maxZ - z);
                    final double dist = Math.sqrt(ex * ey * ez);
                    if (dist > threshold) {
                        this.m_73434_(world, Blocks.f_50016_.m_49966_(), x, y, z, boundingBox);
                    }
                    else if (dist == threshold && rand.nextInt(4) == 0 && this.m_73398_((BlockGetter)world, x, y, z, boundingBox).m_60620_((Tag)BlockTags.f_13061_)) {
                        this.m_73434_(world, ((Block)TFBlocks.TROLLSTEINN.get()).m_49966_(), x, y, z, boundingBox);
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
        final int dx = this.m_73392_(x, z);
        final int dy = this.m_73544_(y);
        final int dz = this.m_73525_(x, z);
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
    
    protected void generateBlockSpike(final WorldGenLevel world, final SpikeConfig config, final Vec3i pos, final BoundingBox sbb) {
        this.generateBlockSpike(world, config, pos.m_123341_(), pos.m_123342_(), pos.m_123343_(), sbb);
    }
    
    protected void generateBlockSpike(final WorldGenLevel world, final SpikeConfig config, final int x, final int y, final int z, final BoundingBox sbb) {
        final int dx = this.m_73392_(x, z);
        final int dy = this.m_73544_(y);
        final int dz = this.m_73525_(x, z);
        final BlockPos pos = new BlockPos(dx, dy, dz);
        if (sbb.m_71051_((Vec3i)pos)) {
            final Random stalRNG = new Random(world.m_7328_() + dx * (long)dz);
            BlockSpikeFeature.startSpike(world, pos, config, stalRNG);
        }
    }
    
    protected void generateAtSurface(final WorldGenLevel world, final ChunkGenerator generator, final ConfiguredFeature<?, ?> feature, final Random rand, final int x, final int z, final BoundingBox sbb) {
        final int dx = this.m_73392_(x, z);
        final int dz = this.m_73525_(x, z);
        final BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(dx, WorldUtil.getSeaLevel((Level)world.m_6018_()) + 25, dz);
        for (int i = 0; i < 15; ++i) {
            pos.m_122184_(0, 1, 0);
            if (sbb.m_71051_((Vec3i)pos) && world.m_8055_(pos.m_7494_()).m_60795_()) {
                feature.m_65385_(world, generator, rand, (BlockPos)pos);
                break;
            }
        }
    }
    
    protected void makeTreasureCrate(final WorldGenLevel world, final BoundingBox sbb) {
        final int mid = this.size / 2;
        this.m_73441_(world, sbb, mid - 2, 0, mid - 2, mid + 1, 3, mid + 1, Blocks.f_50080_.m_49966_(), Blocks.f_50080_.m_49966_(), false);
        this.m_73535_(world, sbb, mid - 1, 1, mid - 1, mid, 2, mid);
        this.placeTreasureAtCurrentPosition(world, mid, 1, mid, TFTreasure.TROLL_GARDEN, false, sbb);
    }
    
    @Override
    public NoiseEffect m_142318_() {
        return NoiseEffect.BURY;
    }
    
    static {
        STONE_STALACTITE = new SpikeConfig((BlockStateProvider)new SimpleStateProvider(Blocks.f_50069_.m_49966_()), (IntProvider)UniformInt.m_146622_(6, 9), (IntProvider)UniformInt.m_146622_(3, 4), true);
        STONE_STALAGMITE = new SpikeConfig((BlockStateProvider)new SimpleStateProvider(Blocks.f_50069_.m_49966_()), (IntProvider)UniformInt.m_146622_(4, 7), (IntProvider)UniformInt.m_146622_(3, 4), false);
        uberousGen = ((Feature)TFBiomeFeatures.MYCELIUM_BLOB.get()).m_65815_((FeatureConfiguration)new DiskConfiguration(BlockConstants.UBEROUS_SOIL, (IntProvider)UniformInt.m_146622_(4, 8), 1, (List)ImmutableList.of((Object)BlockConstants.PODZOL, (Object)BlockConstants.COARSE_DIRT, (Object)BlockConstants.DIRT)));
        highlands = (biome -> false);
    }
}
