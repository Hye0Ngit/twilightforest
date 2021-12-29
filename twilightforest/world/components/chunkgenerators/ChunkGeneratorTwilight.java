// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.chunkgenerators;

import com.mojang.datafixers.kinds.Applicative;
import com.mojang.datafixers.kinds.App;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraftforge.common.world.StructureSpawnManager;
import java.util.List;
import twilightforest.world.components.structures.start.TFStructureStart;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.biome.Biome;
import twilightforest.world.registration.biomes.BiomeKeys;
import net.minecraft.core.BlockPos;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.util.Mth;
import net.minecraft.world.level.WorldGenLevel;
import twilightforest.util.IntPair;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import twilightforest.world.registration.TFDimensions;
import net.minecraft.world.level.chunk.ChunkGenerator;
import twilightforest.world.registration.TFFeature;
import net.minecraft.world.level.ChunkPos;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.world.level.levelgen.synth.SurfaceNoise;
import net.minecraft.world.level.block.state.BlockState;
import java.util.Optional;
import com.mojang.serialization.Codec;

public class ChunkGeneratorTwilight extends ChunkGeneratorWrapper
{
    public static final Codec<ChunkGeneratorTwilight> CODEC;
    private final boolean genDarkForestCanopy;
    private final boolean monsterSpawnsBelowSeaLevel;
    private final Optional<Integer> darkForestCanopyHeight;
    private final BlockState defaultBlock;
    private final SurfaceNoise surfaceNoiseGetter;
    public final ConcurrentHashMap<ChunkPos, TFFeature> featureCache;
    
    public ChunkGeneratorTwilight(ChunkGenerator delegate, final boolean genDarkForestCanopy, final boolean monsterSpawnsBelowSeaLevel, final Optional<Integer> darkForestCanopyHeight, final boolean owSeed) {
        super(owSeed ? (delegate = delegate.m_6819_(TFDimensions.seed)) : delegate);
        this.featureCache = new ConcurrentHashMap<ChunkPos, TFFeature>();
        this.genDarkForestCanopy = genDarkForestCanopy;
        this.monsterSpawnsBelowSeaLevel = monsterSpawnsBelowSeaLevel;
        this.darkForestCanopyHeight = darkForestCanopyHeight;
        final ChunkGenerator chunkGenerator = delegate;
        if (chunkGenerator instanceof final NoiseBasedChunkGenerator noiseGen) {
            this.defaultBlock = noiseGen.f_64316_;
            this.surfaceNoiseGetter = noiseGen.f_64330_;
        }
        else {
            this.defaultBlock = Blocks.f_50069_.m_49966_();
            this.surfaceNoiseGetter = ((x, y, yScale, yMax) -> this.m_6337_());
        }
    }
    
    protected Codec<? extends ChunkGenerator> m_6909_() {
        return ChunkGeneratorTwilight.CODEC;
    }
    
    public ChunkGenerator m_6819_(final long newSeed) {
        return new ChunkGeneratorTwilight(this.delegate.m_6819_(newSeed), this.genDarkForestCanopy, this.monsterSpawnsBelowSeaLevel, this.darkForestCanopyHeight, false);
    }
    
    @Override
    public void m_7338_(final WorldGenRegion world, final ChunkAccess chunk) {
        this.deformTerrainForFeature(world, chunk);
        super.m_7338_(world, chunk);
        if (this.darkForestCanopyHeight.isPresent()) {
            this.addDarkForestCanopy(world, chunk, this.darkForestCanopyHeight.get());
        }
    }
    
    protected final void deformTerrainForFeature(final WorldGenRegion primer, final ChunkAccess chunk) {
        final IntPair featureRelativePos = new IntPair();
        final TFFeature nearFeature = TFFeature.getNearestFeature(primer.m_143488_().f_45578_, primer.m_143488_().f_45579_, (WorldGenLevel)primer, featureRelativePos);
        if (!nearFeature.requiresTerraforming) {
            return;
        }
        final int relativeFeatureX = featureRelativePos.x;
        final int relativeFeatureZ = featureRelativePos.z;
        if (TFFeature.isTheseFeatures(nearFeature, TFFeature.SMALL_HILL, TFFeature.MEDIUM_HILL, TFFeature.LARGE_HILL, TFFeature.HYDRA_LAIR)) {
            final int hdiam = (nearFeature.size * 2 + 1) * 16;
            for (int xInChunk = 0; xInChunk < 16; ++xInChunk) {
                for (int zInChunk = 0; zInChunk < 16; ++zInChunk) {
                    final int featureDX = xInChunk - relativeFeatureX;
                    final int featureDZ = zInChunk - relativeFeatureZ;
                    final float dist = (float)(int)Mth.m_14116_((float)(featureDX * featureDX + featureDZ * featureDZ));
                    final float hheight = (float)(int)(Mth.m_14089_(dist / hdiam * 3.1415927f) * (hdiam / 3.0f));
                    this.raiseHills(primer, chunk, nearFeature, hdiam, xInChunk, zInChunk, featureDX, featureDZ, hheight);
                }
            }
        }
        else if (nearFeature == TFFeature.YETI_CAVE) {
            for (int xInChunk2 = 0; xInChunk2 < 16; ++xInChunk2) {
                for (int zInChunk2 = 0; zInChunk2 < 16; ++zInChunk2) {
                    final int featureDX2 = xInChunk2 - relativeFeatureX;
                    final int featureDZ2 = zInChunk2 - relativeFeatureZ;
                    this.deformTerrainForYetiLair(primer, nearFeature, xInChunk2, zInChunk2, featureDX2, featureDZ2);
                }
            }
        }
        else if (nearFeature == TFFeature.TROLL_CAVE) {
            this.deformTerrainForTrollCloud2(primer, chunk, nearFeature, relativeFeatureX, relativeFeatureZ);
        }
    }
    
    private void deformTerrainForTrollCloud2(final WorldGenRegion primer, final ChunkAccess chunkAccess, final TFFeature nearFeature, final int hx, final int hz) {
        for (int bx = 0; bx < 4; ++bx) {
            for (int bz = 0; bz < 4; ++bz) {
                final int dx = bx * 4 - hx - 2;
                final int dz = bz * 4 - hz - 2;
                final int regionX = primer.m_143488_().f_45578_ + 8 >> 4;
                final int regionZ = primer.m_143488_().f_45579_ + 8 >> 4;
                long seed = regionX * 3129871L ^ regionZ * 116129781L;
                seed = seed * seed * 42317861L + seed * 7L;
                final int num0 = (int)(seed >> 12 & 0x3L);
                final int num2 = (int)(seed >> 15 & 0x3L);
                final int num3 = (int)(seed >> 18 & 0x3L);
                final int num4 = (int)(seed >> 21 & 0x3L);
                final int num5 = (int)(seed >> 9 & 0x3L);
                final int num6 = (int)(seed >> 6 & 0x3L);
                final int num7 = (int)(seed >> 3 & 0x3L);
                final int num8 = (int)(seed >> 0 & 0x3L);
                final int dx2 = dx + num0 * 5 - num2 * 4;
                final int dz2 = dz + num3 * 4 - num4 * 5;
                final int dx3 = dx + num5 * 5 - num6 * 4;
                final int dz3 = dz + num7 * 4 - num8 * 5;
                final float dist0 = Mth.m_14116_((float)(dx * dx + dz * dz)) / 4.0f;
                final float dist2 = Mth.m_14116_((float)(dx2 * dx2 + dz2 * dz2)) / 3.5f;
                final float dist3 = Mth.m_14116_((float)(dx3 * dx3 + dz3 * dz3)) / 4.5f;
                final double dist4 = Math.min(dist0, Math.min(dist2, dist3));
                final float pr = primer.m_5822_().nextFloat();
                final double cv = dist4 - 7.0 - pr * 3.0f;
                int y = 166;
                int depth = 4;
                if (pr < 0.1f) {
                    ++y;
                }
                if (pr > 0.6f) {
                    ++depth;
                }
                if (pr > 0.9f) {
                    ++depth;
                }
                for (int sx = 0; sx < 4; ++sx) {
                    for (int sz = 0; sz < 4; ++sz) {
                        final int lx = bx * 4 + sx;
                        final int lz = bz * 4 + sz;
                        final BlockPos.MutableBlockPos movingPos = primer.m_143488_().m_45615_().m_122032_().m_122184_(lx, 0, lz);
                        final int dY = primer.m_6924_(Heightmap.Types.WORLD_SURFACE_WG, movingPos.m_123341_(), movingPos.m_123343_());
                        final int oceanFloor = primer.m_6924_(Heightmap.Types.OCEAN_FLOOR_WG, movingPos.m_123341_(), movingPos.m_123343_());
                        if (dist4 < 7.0 || cv < 0.05000000074505806) {
                            primer.m_7731_((BlockPos)movingPos.m_142448_(y), ((Block)TFBlocks.WISPY_CLOUD.get()).m_49966_(), 3);
                            for (int d = 1; d < depth; ++d) {
                                primer.m_7731_((BlockPos)movingPos.m_142448_(y - d), ((Block)TFBlocks.FLUFFY_CLOUD.get()).m_49966_(), 3);
                            }
                            primer.m_7731_((BlockPos)movingPos.m_142448_(y - depth), ((Block)TFBlocks.WISPY_CLOUD.get()).m_49966_(), 3);
                        }
                        else if (dist4 < 8.0 || cv < 1.0) {
                            for (int d = 1; d < depth; ++d) {
                                primer.m_7731_((BlockPos)movingPos.m_142448_(y - d), ((Block)TFBlocks.FLUFFY_CLOUD.get()).m_49966_(), 3);
                            }
                        }
                        forceHeightMapLevel(chunkAccess, Heightmap.Types.WORLD_SURFACE_WG, (BlockPos)movingPos, dY);
                        forceHeightMapLevel(chunkAccess, Heightmap.Types.WORLD_SURFACE, (BlockPos)movingPos, dY);
                        forceHeightMapLevel(chunkAccess, Heightmap.Types.OCEAN_FLOOR_WG, (BlockPos)movingPos, oceanFloor);
                        forceHeightMapLevel(chunkAccess, Heightmap.Types.OCEAN_FLOOR, (BlockPos)movingPos, oceanFloor);
                    }
                }
            }
        }
    }
    
    private void raiseHills(final WorldGenRegion world, final ChunkAccess chunk, final TFFeature nearFeature, final int hdiam, final int xInChunk, final int zInChunk, final int featureDX, final int featureDZ, final float hillHeight) {
        final BlockPos.MutableBlockPos movingPos = world.m_143488_().m_45615_().m_142082_(xInChunk, 0, zInChunk).m_122032_();
        final int groundHeight = chunk.m_5885_(Heightmap.Types.OCEAN_FLOOR_WG, movingPos.m_123341_(), movingPos.m_123343_());
        final float noiseRaw = (float)(this.surfaceNoiseGetter.m_5495_((double)(movingPos.m_123341_() / 64.0f), (double)(movingPos.m_123343_() / 64.0f), 1.0, 256.0) * 32.0);
        final float totalHeightRaw = groundHeight * 0.75f + this.m_6337_() * 0.25f + hillHeight + noiseRaw;
        final int totalHeight = (int)(((int)totalHeightRaw >> 1) * 0.375f + totalHeightRaw * 0.625f);
        for (int y = groundHeight; y <= totalHeight; ++y) {
            world.m_7731_((BlockPos)movingPos.m_142448_(y), this.defaultBlock, 3);
        }
        int hollow = Math.min((int)hillHeight - 4 - nearFeature.size, totalHeight - 3);
        if (nearFeature == TFFeature.HYDRA_LAIR) {
            final int mx = featureDX + 16;
            final int mz = featureDZ + 16;
            final int mdist = (int)Mth.m_14116_((float)(mx * mx + mz * mz));
            final int mheight = (int)(Mth.m_14089_(mdist / (hdiam / 1.5f) * 3.1415927f) * (hdiam / 1.5f));
            hollow = Math.max(mheight - 4, hollow);
        }
        for (int hollowFloor = (nearFeature == TFFeature.HYDRA_LAIR) ? this.m_6337_() : (this.m_6337_() - 5 - (hollow >> 3)), y2 = hollowFloor + 1; y2 < hollowFloor + hollow; ++y2) {
            world.m_7731_((BlockPos)movingPos.m_142448_(y2), Blocks.f_50016_.m_49966_(), 3);
        }
    }
    
    private void deformTerrainForYetiLair(final WorldGenRegion primer, final TFFeature nearFeature, final int xInChunk, final int zInChunk, final int featureDX, final int featureDZ) {
        float squishFactor = 0.0f;
        int topHeight = this.m_6337_() + 24;
        final int outerBoundary = (nearFeature.size * 2 + 1) * 8 - 8;
        if (featureDX <= -outerBoundary) {
            squishFactor = (-featureDX - outerBoundary) / 8.0f;
        }
        else if (featureDX >= outerBoundary) {
            squishFactor = (featureDX - outerBoundary) / 8.0f;
        }
        if (featureDZ <= -outerBoundary) {
            squishFactor = Math.max(squishFactor, (-featureDZ - outerBoundary) / 8.0f);
        }
        else if (featureDZ >= outerBoundary) {
            squishFactor = Math.max(squishFactor, (featureDZ - outerBoundary) / 8.0f);
        }
        final int caveBoundary = nearFeature.size * 2 * 8 - 8;
        final int offset = Math.min(Math.abs(featureDX), Math.abs(featureDZ));
        int hollowCeiling = this.m_6337_() + 40 - offset * 4;
        if (featureDX >= -caveBoundary && featureDZ >= -caveBoundary && featureDX <= caveBoundary && featureDZ <= caveBoundary) {
            hollowCeiling = this.m_6337_() + 16;
        }
        hollowCeiling -= offset / 6;
        hollowCeiling = Math.min(hollowCeiling, this.m_6337_() + 16);
        int hollowFloor = this.m_6337_() - 4 + offset / 6;
        final BlockPos.MutableBlockPos movingPos = primer.m_143488_().m_45615_().m_142082_(xInChunk, 0, zInChunk).m_122032_();
        if (squishFactor > 0.0f) {
            for (int y = primer.m_141937_(); y <= primer.m_151558_(); ++y) {
                if (!this.defaultBlock.equals(primer.m_8055_((BlockPos)movingPos.m_142448_(y)))) {
                    topHeight += (int)((y - topHeight) * squishFactor);
                    hollowFloor += (int)((y - hollowFloor) * squishFactor);
                    break;
                }
            }
        }
        for (int y = primer.m_141937_(); y < topHeight; ++y) {
            final Block b = primer.m_8055_((BlockPos)movingPos.m_142448_(y)).m_60734_();
            if (b == Blocks.f_50016_ || b == Blocks.f_49990_) {
                primer.m_7731_((BlockPos)movingPos.m_142448_(y), this.defaultBlock, 3);
            }
        }
        for (int y = hollowFloor + 1; y < hollowCeiling; ++y) {
            primer.m_7731_((BlockPos)movingPos.m_142448_(y), Blocks.f_50016_.m_49966_(), 3);
        }
        if (hollowFloor < hollowCeiling && hollowFloor < this.m_6337_() + 3) {
            primer.m_7731_((BlockPos)movingPos.m_142448_(hollowFloor), Blocks.f_50354_.m_49966_(), 3);
        }
    }
    
    private void addDarkForestCanopy(final WorldGenRegion primer, final ChunkAccess chunk, final int height) {
        final BlockPos blockpos = primer.m_143488_().m_45615_();
        final int[] thicks = new int[25];
        boolean biomeFound = false;
        for (int dZ = 0; dZ < 5; ++dZ) {
            for (int dX = 0; dX < 5; ++dX) {
                for (int bx = -1; bx <= 1; ++bx) {
                    for (int bz = -1; bz <= 1; ++bz) {
                        final BlockPos p = blockpos.m_142082_(dX + bx << 2, 0, dZ + bz << 2);
                        final Biome biome = this.f_62137_.m_7158_(p.m_123341_() >> 2, 0, p.m_123343_() >> 2);
                        if (BiomeKeys.DARK_FOREST.m_135782_().equals((Object)biome.getRegistryName()) || BiomeKeys.DARK_FOREST_CENTER.m_135782_().equals((Object)biome.getRegistryName())) {
                            final int[] array = thicks;
                            final int n = dX + dZ * 5;
                            ++array[n];
                            biomeFound = true;
                        }
                    }
                }
            }
        }
        if (!biomeFound) {
            return;
        }
        final IntPair nearCenter = new IntPair();
        final TFFeature nearFeature = TFFeature.getNearestFeature(primer.m_143488_().f_45578_, primer.m_143488_().f_45579_, (WorldGenLevel)primer, nearCenter);
        final double d = 0.03125;
        for (int dZ2 = 0; dZ2 < 16; ++dZ2) {
            for (int dX2 = 0; dX2 < 16; ++dX2) {
                final int qx = dX2 >> 2;
                final int qz = dZ2 >> 2;
                final float xweight = dX2 % 4 * 0.25f + 0.125f;
                final float zweight = dZ2 % 4 * 0.25f + 0.125f;
                float thickness = thicks[qx + qz * 5] * (1.0f - xweight) * (1.0f - zweight) + thicks[qx + 1 + qz * 5] * xweight * (1.0f - zweight) + thicks[qx + (qz + 1) * 5] * (1.0f - xweight) * zweight + thicks[qx + 1 + (qz + 1) * 5] * xweight * zweight - 4.0f;
                if (nearFeature == TFFeature.DARK_TOWER) {
                    final int hx = nearCenter.x;
                    final int hz = nearCenter.z;
                    final int rx = dX2 - hx;
                    final int rz = dZ2 - hz;
                    final int dist = (int)Mth.m_14116_((float)(rx * rx + rz * rz));
                    if (dist < 24) {
                        thickness -= 24 - dist;
                    }
                }
                if (thickness > 1.0f) {
                    final int dY = chunk.m_5885_(Heightmap.Types.WORLD_SURFACE_WG, dX2, dZ2);
                    final int oceanFloor = chunk.m_5885_(Heightmap.Types.OCEAN_FLOOR_WG, dX2, dZ2);
                    final BlockPos pos = primer.m_143488_().m_45615_().m_142082_(dX2, dY, dZ2);
                    if (!chunk.m_8055_(pos).m_60767_().m_76332_()) {
                        final int noise = Math.min(3, (int)(this.surfaceNoiseGetter.m_5495_((blockpos.m_123341_() + dX2) * 0.0625, (blockpos.m_123343_() + dZ2) * 0.0625, 0.0625, dX2 * 0.0625) * 15.0 / 1.25));
                        int treeBottom = pos.m_123342_() + height - (int)(thickness * 0.5f);
                        final int treeTop = treeBottom + (int)(thickness * 1.5f);
                        treeBottom -= noise;
                        final BlockState darkLeaves = ((Block)TFBlocks.HARDENED_DARK_LEAVES.get()).m_49966_();
                        for (int y = treeBottom; y < treeTop; ++y) {
                            primer.m_7731_(pos.m_175288_(y), darkLeaves, 3);
                        }
                        forceHeightMapLevel(chunk, Heightmap.Types.WORLD_SURFACE_WG, pos, dY);
                        forceHeightMapLevel(chunk, Heightmap.Types.WORLD_SURFACE, pos, dY);
                        forceHeightMapLevel(chunk, Heightmap.Types.OCEAN_FLOOR_WG, pos, oceanFloor);
                        forceHeightMapLevel(chunk, Heightmap.Types.OCEAN_FLOOR, pos, oceanFloor);
                    }
                }
            }
        }
    }
    
    static void forceHeightMapLevel(final ChunkAccess chunk, final Heightmap.Types type, final BlockPos pos, final int dY) {
        chunk.m_6005_(type).m_64245_(pos.m_123341_() & 0xF, pos.m_123343_() & 0xF, dY + 1);
    }
    
    @Override
    public WeightedRandomList<MobSpawnSettings.SpawnerData> m_142184_(final Biome biome, final StructureFeatureManager structureManager, final MobCategory mobCategory, final BlockPos pos) {
        if (!this.monsterSpawnsBelowSeaLevel) {
            return super.m_142184_(biome, structureManager, mobCategory, pos);
        }
        final List<MobSpawnSettings.SpawnerData> potentialStructureSpawns = TFStructureStart.gatherPotentialSpawns(structureManager, mobCategory, pos);
        if (potentialStructureSpawns != null) {
            return (WeightedRandomList<MobSpawnSettings.SpawnerData>)WeightedRandomList.m_146328_((List)potentialStructureSpawns);
        }
        final WeightedRandomList<MobSpawnSettings.SpawnerData> spawns = (WeightedRandomList<MobSpawnSettings.SpawnerData>)StructureSpawnManager.getStructureSpawns(structureManager, mobCategory, pos);
        if (spawns != null) {
            return spawns;
        }
        return (WeightedRandomList<MobSpawnSettings.SpawnerData>)((mobCategory == MobCategory.MONSTER && pos.m_123342_() >= this.m_6337_()) ? WeightedRandomList.m_146332_() : super.m_142184_(biome, structureManager, mobCategory, pos));
    }
    
    public TFFeature getFeatureCached(final ChunkPos chunk, final WorldGenLevel world) {
        return this.featureCache.computeIfAbsent(chunk, chunkPos -> TFFeature.generateFeature(chunkPos.f_45578_, chunkPos.f_45579_, world));
    }
    
    static {
        CODEC = RecordCodecBuilder.create(instance -> instance.group((App)ChunkGenerator.f_62136_.fieldOf("wrapped_generator").forGetter(o -> o.delegate), (App)Codec.BOOL.fieldOf("generate_dark_forest_canopy").forGetter(o -> o.genDarkForestCanopy), (App)Codec.BOOL.fieldOf("monster_spawns_below_sealevel").forGetter(o -> o.monsterSpawnsBelowSeaLevel), (App)Codec.INT.optionalFieldOf("dark_forest_canopy_height").forGetter(o -> o.darkForestCanopyHeight), (App)Codec.BOOL.fieldOf("use_overworld_seed").forGetter(o -> false)).apply((Applicative)instance, instance.stable((Object)ChunkGeneratorTwilight::new)));
    }
}
