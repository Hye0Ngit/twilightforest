// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.trollcave;

import net.minecraft.core.Vec3i;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.core.Direction;
import twilightforest.world.registration.TFFeature;
import net.minecraft.data.worldgen.Features;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import java.util.List;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import com.google.common.collect.ImmutableList;
import net.minecraft.util.valueproviders.UniformInt;
import twilightforest.world.registration.BlockConstants;
import twilightforest.world.registration.TFBiomeFeatures;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class TrollCaveGardenComponent extends TrollCaveMainComponent
{
    private final ConfiguredFeature<?, ?> myceliumBlobGen;
    private final ConfiguredFeature<?, ?> dirtGen;
    private final ConfiguredFeature<?, ?> smallUberousGen;
    private final ConfiguredFeature<?, ?> bigRedMushroomGen;
    private final ConfiguredFeature<?, ?> bigBrownMushroomGen;
    private final ConfiguredFeature<?, ?> bigMushgloomGen;
    
    public TrollCaveGardenComponent(final ServerLevel level, final CompoundTag nbt) {
        super(TrollCavePieces.TFTCGard, nbt);
        this.myceliumBlobGen = (ConfiguredFeature<?, ?>)((Feature)TFBiomeFeatures.MYCELIUM_BLOB.get()).m_65815_((FeatureConfiguration)new DiskConfiguration(BlockConstants.MYCELIUM, (IntProvider)UniformInt.m_146622_(3, 5), 0, (List)ImmutableList.of((Object)BlockConstants.STONE, (Object)BlockConstants.DEADROCK)));
        this.dirtGen = (ConfiguredFeature<?, ?>)((Feature)TFBiomeFeatures.MYCELIUM_BLOB.get()).m_65815_((FeatureConfiguration)new DiskConfiguration(BlockConstants.DIRT, (IntProvider)UniformInt.m_146622_(2, 5), 0, (List)ImmutableList.of((Object)BlockConstants.STONE, (Object)BlockConstants.DEADROCK)));
        this.smallUberousGen = (ConfiguredFeature<?, ?>)((Feature)TFBiomeFeatures.MYCELIUM_BLOB.get()).m_65815_((FeatureConfiguration)new DiskConfiguration(BlockConstants.UBEROUS_SOIL, (IntProvider)UniformInt.m_146622_(2, 3), 0, (List)ImmutableList.of((Object)BlockConstants.PODZOL, (Object)BlockConstants.COARSE_DIRT, (Object)BlockConstants.DIRT)));
        this.bigRedMushroomGen = (ConfiguredFeature<?, ?>)Features.f_126947_;
        this.bigBrownMushroomGen = (ConfiguredFeature<?, ?>)Features.f_126946_;
        this.bigMushgloomGen = (ConfiguredFeature<?, ?>)((Feature)TFBiomeFeatures.BIG_MUSHGLOOM.get()).m_65815_((FeatureConfiguration)FeatureConfiguration.f_67737_);
    }
    
    public TrollCaveGardenComponent(final TFFeature feature, final int index, final int x, final int y, final int z, final int caveSize, final int caveHeight, final Direction direction) {
        super(TrollCavePieces.TFTCGard, feature, index, x, y, z);
        this.myceliumBlobGen = (ConfiguredFeature<?, ?>)((Feature)TFBiomeFeatures.MYCELIUM_BLOB.get()).m_65815_((FeatureConfiguration)new DiskConfiguration(BlockConstants.MYCELIUM, (IntProvider)UniformInt.m_146622_(3, 5), 0, (List)ImmutableList.of((Object)BlockConstants.STONE, (Object)BlockConstants.DEADROCK)));
        this.dirtGen = (ConfiguredFeature<?, ?>)((Feature)TFBiomeFeatures.MYCELIUM_BLOB.get()).m_65815_((FeatureConfiguration)new DiskConfiguration(BlockConstants.DIRT, (IntProvider)UniformInt.m_146622_(2, 5), 0, (List)ImmutableList.of((Object)BlockConstants.STONE, (Object)BlockConstants.DEADROCK)));
        this.smallUberousGen = (ConfiguredFeature<?, ?>)((Feature)TFBiomeFeatures.MYCELIUM_BLOB.get()).m_65815_((FeatureConfiguration)new DiskConfiguration(BlockConstants.UBEROUS_SOIL, (IntProvider)UniformInt.m_146622_(2, 3), 0, (List)ImmutableList.of((Object)BlockConstants.PODZOL, (Object)BlockConstants.COARSE_DIRT, (Object)BlockConstants.DIRT)));
        this.bigRedMushroomGen = (ConfiguredFeature<?, ?>)Features.f_126947_;
        this.bigBrownMushroomGen = (ConfiguredFeature<?, ?>)Features.f_126946_;
        this.bigMushgloomGen = (ConfiguredFeature<?, ?>)((Feature)TFBiomeFeatures.BIG_MUSHGLOOM.get()).m_65815_((FeatureConfiguration)FeatureConfiguration.f_67737_);
        this.size = caveSize;
        this.height = caveHeight;
        this.m_73519_(direction);
        this.f_73383_ = feature.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1, direction);
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.hollowCaveMiddle(world, sbb, rand, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1);
        final Random decoRNG = new Random(world.m_7328_() + this.f_73383_.m_162395_() * 321534781L ^ this.f_73383_.m_162398_() * 756839L);
        this.makeTreasureCrate(world, sbb);
        for (int i = 0; i < 24; ++i) {
            final BlockPos dest = (BlockPos)this.getCoordsInCave(decoRNG);
            this.generate(world, generator, this.dirtGen, decoRNG, dest.m_123341_(), 0, dest.m_123343_(), sbb);
        }
        for (int i = 0; i < 16; ++i) {
            final BlockPos dest = (BlockPos)this.getCoordsInCave(decoRNG);
            this.generate(world, generator, this.myceliumBlobGen, decoRNG, dest.m_123341_(), 0, dest.m_123343_(), sbb);
        }
        for (int i = 0; i < 16; ++i) {
            final BlockPos dest = (BlockPos)this.getCoordsInCave(decoRNG);
            this.generate(world, generator, this.smallUberousGen, decoRNG, dest.m_123341_(), 0, dest.m_123343_(), sbb);
            this.generateAtSurface(world, generator, this.smallUberousGen, decoRNG, dest.m_123341_(), dest.m_123343_(), sbb);
        }
        for (int i = 0; i < 16; ++i) {
            final BlockPos.MutableBlockPos dest2 = this.getCoordsInCave(decoRNG);
            this.setBlockStateRotated(world, Blocks.f_50195_.m_49966_(), dest2.m_123341_(), dest2.m_142448_(0).m_123342_(), dest2.m_123343_(), this.f_73379_, sbb);
            this.generate(world, generator, this.bigMushgloomGen, decoRNG, dest2.m_123341_(), dest2.m_142448_(1).m_123342_(), dest2.m_123343_(), sbb);
        }
        for (int i = 0; i < 32; ++i) {
            final BlockPos.MutableBlockPos dest2 = this.getCoordsInCave(decoRNG);
            this.setBlockStateRotated(world, Blocks.f_50195_.m_49966_(), dest2.m_123341_(), dest2.m_142448_(0).m_123342_(), dest2.m_123343_(), this.f_73379_, sbb);
            this.generate(world, generator, rand.nextBoolean() ? this.bigBrownMushroomGen : this.bigRedMushroomGen, decoRNG, dest2.m_123341_(), dest2.m_142448_(1).m_123342_(), dest2.m_123343_(), sbb);
        }
        for (int i = 0; i < 128; ++i) {
            final BlockPos dest = (BlockPos)this.getCoordsInCave(decoRNG);
            this.generateBlockSpike(world, TrollCaveGardenComponent.STONE_STALACTITE, (Vec3i)dest.m_175288_(this.height), sbb);
        }
        return true;
    }
    
    protected void generate(final WorldGenLevel world, final ChunkGenerator generator, final ConfiguredFeature<?, ?> feature, final Random rand, final int x, final int y, final int z, final BoundingBox sbb) {
        final int dx = this.m_73392_(x, z);
        final int dy = this.m_73544_(y);
        final int dz = this.m_73525_(x, z);
        final BlockPos pos = new BlockPos(dx, dy, dz);
        if (sbb.m_71051_((Vec3i)pos)) {
            feature.m_65385_(world, generator, rand, pos);
        }
    }
}
