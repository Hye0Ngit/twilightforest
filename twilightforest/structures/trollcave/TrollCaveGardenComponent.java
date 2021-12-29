// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.trollcave;

import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import java.util.Random;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.util.Direction;
import twilightforest.TFFeature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.DepthAverageConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.feature.IFeatureConfig;
import java.util.List;
import net.minecraft.world.gen.feature.SphereReplaceConfig;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.gen.feature.FeatureSpread;
import twilightforest.worldgen.BlockConstants;
import twilightforest.world.feature.TFBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class TrollCaveGardenComponent extends TrollCaveMainComponent
{
    private final ConfiguredFeature<?, ?> myceliumBlobGen;
    private final ConfiguredFeature<?, ?> dirtGen;
    private final ConfiguredFeature<?, ?> smallUberousGen;
    private final ConfiguredFeature<?, ?> bigRedMushroomGen;
    private final ConfiguredFeature<?, ?> bigBrownMushroomGen;
    private final ConfiguredFeature<?, ?> bigMushgloomGen;
    
    public TrollCaveGardenComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(TrollCavePieces.TFTCGard, nbt);
        this.myceliumBlobGen = (ConfiguredFeature<?, ?>)((Feature)TFBiomeFeatures.MYCELIUM_BLOB.get()).func_225566_b_((IFeatureConfig)new SphereReplaceConfig(BlockConstants.MYCELIUM, FeatureSpread.func_242253_a(5, 2), 0, (List)ImmutableList.of((Object)BlockConstants.STONE, (Object)BlockConstants.DEADROCK))).func_227228_a_(Placement.field_242910_o.func_227446_a_((IPlacementConfig)new DepthAverageConfig(15, 10)));
        this.dirtGen = (ConfiguredFeature<?, ?>)((Feature)TFBiomeFeatures.MYCELIUM_BLOB.get()).func_225566_b_((IFeatureConfig)new SphereReplaceConfig(BlockConstants.DIRT, FeatureSpread.func_242253_a(5, 2), 0, (List)ImmutableList.of((Object)BlockConstants.STONE, (Object)BlockConstants.DEADROCK))).func_227228_a_(Placement.field_242910_o.func_227446_a_((IPlacementConfig)new DepthAverageConfig(15, 10)));
        this.smallUberousGen = (ConfiguredFeature<?, ?>)((Feature)TFBiomeFeatures.MYCELIUM_BLOB.get()).func_225566_b_((IFeatureConfig)new SphereReplaceConfig(BlockConstants.UBEROUS_SOIL, FeatureSpread.func_242253_a(4, 3), 0, (List)ImmutableList.of((Object)BlockConstants.PODZOL, (Object)BlockConstants.COARSE_DIRT, (Object)BlockConstants.DIRT))).func_227228_a_(Placement.field_242910_o.func_227446_a_((IPlacementConfig)new DepthAverageConfig(60, 10)));
        this.bigRedMushroomGen = (ConfiguredFeature<?, ?>)Features.field_243861_bG.func_227228_a_(Placement.field_242910_o.func_227446_a_((IPlacementConfig)new DepthAverageConfig(15, 10)));
        this.bigBrownMushroomGen = (ConfiguredFeature<?, ?>)Features.field_243860_bF.func_227228_a_(Placement.field_242910_o.func_227446_a_((IPlacementConfig)new DepthAverageConfig(15, 10)));
        this.bigMushgloomGen = (ConfiguredFeature<?, ?>)((Feature)TFBiomeFeatures.BIG_MUSHGLOOM.get()).func_225566_b_((IFeatureConfig)IFeatureConfig.field_202429_e).func_227228_a_(Placement.field_242910_o.func_227446_a_((IPlacementConfig)new DepthAverageConfig(15, 10)));
    }
    
    public TrollCaveGardenComponent(final TFFeature feature, final int index, final int x, final int y, final int z, final int caveSize, final int caveHeight, final Direction direction) {
        super(TrollCavePieces.TFTCGard, feature, index);
        this.myceliumBlobGen = (ConfiguredFeature<?, ?>)((Feature)TFBiomeFeatures.MYCELIUM_BLOB.get()).func_225566_b_((IFeatureConfig)new SphereReplaceConfig(BlockConstants.MYCELIUM, FeatureSpread.func_242253_a(5, 2), 0, (List)ImmutableList.of((Object)BlockConstants.STONE, (Object)BlockConstants.DEADROCK))).func_227228_a_(Placement.field_242910_o.func_227446_a_((IPlacementConfig)new DepthAverageConfig(15, 10)));
        this.dirtGen = (ConfiguredFeature<?, ?>)((Feature)TFBiomeFeatures.MYCELIUM_BLOB.get()).func_225566_b_((IFeatureConfig)new SphereReplaceConfig(BlockConstants.DIRT, FeatureSpread.func_242253_a(5, 2), 0, (List)ImmutableList.of((Object)BlockConstants.STONE, (Object)BlockConstants.DEADROCK))).func_227228_a_(Placement.field_242910_o.func_227446_a_((IPlacementConfig)new DepthAverageConfig(15, 10)));
        this.smallUberousGen = (ConfiguredFeature<?, ?>)((Feature)TFBiomeFeatures.MYCELIUM_BLOB.get()).func_225566_b_((IFeatureConfig)new SphereReplaceConfig(BlockConstants.UBEROUS_SOIL, FeatureSpread.func_242253_a(4, 3), 0, (List)ImmutableList.of((Object)BlockConstants.PODZOL, (Object)BlockConstants.COARSE_DIRT, (Object)BlockConstants.DIRT))).func_227228_a_(Placement.field_242910_o.func_227446_a_((IPlacementConfig)new DepthAverageConfig(60, 10)));
        this.bigRedMushroomGen = (ConfiguredFeature<?, ?>)Features.field_243861_bG.func_227228_a_(Placement.field_242910_o.func_227446_a_((IPlacementConfig)new DepthAverageConfig(15, 10)));
        this.bigBrownMushroomGen = (ConfiguredFeature<?, ?>)Features.field_243860_bF.func_227228_a_(Placement.field_242910_o.func_227446_a_((IPlacementConfig)new DepthAverageConfig(15, 10)));
        this.bigMushgloomGen = (ConfiguredFeature<?, ?>)((Feature)TFBiomeFeatures.BIG_MUSHGLOOM.get()).func_225566_b_((IFeatureConfig)IFeatureConfig.field_202429_e).func_227228_a_(Placement.field_242910_o.func_227446_a_((IPlacementConfig)new DepthAverageConfig(15, 10)));
        this.size = caveSize;
        this.height = caveHeight;
        this.func_186164_a(direction);
        this.field_74887_e = feature.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1, direction);
    }
    
    @Override
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.hollowCaveMiddle(world, sbb, rand, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1);
        final Random decoRNG = new Random(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
        this.makeTreasureCrate(world, sbb);
        for (int i = 0; i < 24; ++i) {
            final BlockPos dest = this.getCenterBiasedCaveCoords(decoRNG);
            this.generate(world, generator, this.dirtGen, decoRNG, dest.func_177958_n() * 4, 1, dest.func_177952_p() * 4, sbb);
        }
        for (int i = 0; i < 16; ++i) {
            final BlockPos dest = this.getCenterBiasedCaveCoords(decoRNG);
            this.generate(world, generator, this.myceliumBlobGen, decoRNG, dest.func_177958_n() * 4, 1, dest.func_177952_p() * 4, sbb);
        }
        for (int i = 0; i < 16; ++i) {
            final BlockPos dest = this.getCoordsInCave(decoRNG);
            this.generate(world, generator, this.smallUberousGen, decoRNG, dest.func_177958_n() * 4, 1, dest.func_177952_p() * 4, sbb);
            this.generateAtSurface(world, generator, this.smallUberousGen, decoRNG, dest.func_177958_n(), 60, dest.func_177952_p(), sbb);
        }
        for (int i = 0; i < 32; ++i) {
            final BlockPos dest = this.getCenterBiasedCaveCoords(decoRNG);
            this.generate(world, generator, this.bigMushgloomGen, decoRNG, dest.func_177958_n() * 4, 1, dest.func_177952_p() * 4, sbb);
        }
        for (int i = 0; i < 64; ++i) {
            final BlockPos dest = this.getCenterBiasedCaveCoords(decoRNG);
            this.generate(world, generator, rand.nextBoolean() ? this.bigBrownMushroomGen : this.bigRedMushroomGen, decoRNG, dest.func_177958_n() * 4, 1, dest.func_177952_p() * 4, sbb);
        }
        for (int i = 0; i < 128; ++i) {
            final BlockPos dest = this.getCoordsInCave(decoRNG);
            this.generateBlockStalactite(world, generator, decoRNG, Blocks.field_150348_b, 0.7f, true, dest.func_177958_n(), 3, dest.func_177952_p(), sbb);
        }
        return true;
    }
    
    protected void generate(final ISeedReader world, final ChunkGenerator generator, final ConfiguredFeature<?, ?> feature, final Random rand, final int x, final int y, final int z, final MutableBoundingBox sbb) {
        final int dx = this.func_74865_a(x, z);
        final int dy = this.func_74862_a(y);
        final int dz = this.func_74873_b(x, z);
        final BlockPos pos = new BlockPos(dx, dy, dz);
        if (sbb.func_175898_b((Vector3i)pos)) {
            feature.func_242765_a(world, generator, rand, pos);
        }
    }
}
