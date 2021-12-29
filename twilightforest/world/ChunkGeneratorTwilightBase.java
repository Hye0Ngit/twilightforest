// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import com.google.common.collect.ImmutableList;
import net.minecraftforge.common.world.StructureSpawnManager;
import twilightforest.structures.start.TFStructure;
import net.minecraft.world.biome.MobSpawnInfo;
import java.util.List;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.block.Blocks;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.ISeedReader;
import twilightforest.TFFeature;
import twilightforest.util.IntPair;
import net.minecraft.world.gen.WorldGenRegion;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.DimensionSettings;
import java.util.function.Supplier;
import net.minecraft.world.gen.NoiseChunkGenerator;

public abstract class ChunkGeneratorTwilightBase extends NoiseChunkGenerator
{
    protected final long seed;
    protected final Supplier<DimensionSettings> dimensionSettings;
    private final boolean shouldGenerateBedrock;
    
    public ChunkGeneratorTwilightBase(final BiomeProvider provider, final long seed, final Supplier<DimensionSettings> settings, final boolean shouldGenerateBedrock) {
        super(provider, seed, (Supplier)settings);
        this.seed = seed;
        this.dimensionSettings = settings;
        this.shouldGenerateBedrock = shouldGenerateBedrock;
    }
    
    public ChunkGeneratorTwilightBase(final BiomeProvider provider, final long seed, final Supplier<DimensionSettings> settings) {
        this(provider, seed, settings, true);
    }
    
    public int func_205470_d() {
        return 32;
    }
    
    protected static int getIndex(final int x, final int y, final int z) {
        return x << 12 | z << 8 | y;
    }
    
    protected final void squishTerrain(final ChunkBitArray data) {
        final int squishHeight = 128;
        for (int x = 0; x < 16; ++x) {
            for (int z = 0; z < 16; ++z) {
                for (int y = 0; y < squishHeight; ++y) {
                    data.set(getIndex(x, y, z), data.get(getIndex(x, y * 2 + 1, z)));
                }
                for (int y = squishHeight; y < 256; ++y) {
                    data.clear(getIndex(x, y, z));
                }
            }
        }
    }
    
    protected final void deformTerrainForFeature(final WorldGenRegion primer) {
        final IntPair nearCenter = new IntPair();
        final TFFeature nearFeature = TFFeature.getNearestFeature(this.getPos(primer).field_77276_a, this.getPos(primer).field_77275_b, (ISeedReader)primer, nearCenter);
        if (!nearFeature.isTerrainAltered) {
            return;
        }
        final int hx = nearCenter.x;
        final int hz = nearCenter.z;
        if (nearFeature == TFFeature.TROLL_CAVE) {
            this.deformTerrainForTrollCloud2(primer, nearFeature, hx, hz);
        }
        for (int x = 0; x < 16; ++x) {
            for (int z = 0; z < 16; ++z) {
                final int dx = x - hx;
                final int dz = z - hz;
                if (nearFeature == TFFeature.SMALL_HILL || nearFeature == TFFeature.MEDIUM_HILL || nearFeature == TFFeature.LARGE_HILL || nearFeature == TFFeature.HYDRA_LAIR) {
                    final int hdiam = (nearFeature.size * 2 + 1) * 16;
                    final int dist = (int)Math.sqrt(dx * dx + dz * dz);
                    final int hheight = (int)(Math.cos(dist / (float)hdiam * 3.141592653589793) * (hdiam / 3.0f));
                    this.raiseHills(primer, nearFeature, hdiam, x, z, dx, dz, hheight);
                }
                else if (nearFeature == TFFeature.HEDGE_MAZE || nearFeature == TFFeature.NAGA_COURTYARD || nearFeature == TFFeature.QUEST_GROVE) {
                    this.flattenTerrainForFeature(primer, nearFeature, x, z, dx, dz);
                }
                else if (nearFeature == TFFeature.YETI_CAVE) {
                    this.deformTerrainForYetiLair(primer, nearFeature, x, z, dx, dz);
                }
                else if (nearFeature == TFFeature.TROLL_CAVE) {
                    this.deformTerrainForTrollCaves(primer, nearFeature, x, z, dx, dz);
                }
            }
        }
    }
    
    protected void deformTerrainForTrollCaves(final WorldGenRegion primer, final TFFeature nearFeature, final int x, final int z, final int dx, final int dz) {
    }
    
    private void deformTerrainForTrollCloud2(final WorldGenRegion primer, final TFFeature nearFeature, final int hx, final int hz) {
        for (int bx = 0; bx < 4; ++bx) {
            for (int bz = 0; bz < 4; ++bz) {
                final int dx = bx * 4 - hx - 2;
                final int dz = bz * 4 - hz - 2;
                final int regionX = this.getPos(primer).field_77276_a + 8 >> 4;
                final int regionZ = this.getPos(primer).field_77275_b + 8 >> 4;
                long seed = (long)(regionX * 3129871) ^ regionZ * 116129781L;
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
                final double dist0 = Math.sqrt(dx * dx + dz * dz) / 4.0;
                final double dist2 = Math.sqrt(dx2 * dx2 + dz2 * dz2) / 3.5;
                final double dist3 = Math.sqrt(dx3 * dx3 + dz3 * dz3) / 4.5;
                final double dist4 = Math.min(dist0, Math.min(dist2, dist3));
                final float pr = primer.func_201674_k().nextFloat();
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
                        if (dist4 < 7.0 || cv < 0.05000000074505806) {
                            primer.func_180501_a(this.withY(this.getPos(primer).func_206849_h().func_177982_a(lx, 0, lz), y), ((Block)TFBlocks.wispy_cloud.get()).func_176223_P(), 3);
                            for (int d = 1; d < depth; ++d) {
                                primer.func_180501_a(this.withY(this.getPos(primer).func_206849_h().func_177982_a(lx, 0, lz), y - d), ((Block)TFBlocks.fluffy_cloud.get()).func_176223_P(), 3);
                            }
                            primer.func_180501_a(this.withY(this.getPos(primer).func_206849_h().func_177982_a(lx, 0, lz), y - depth), ((Block)TFBlocks.wispy_cloud.get()).func_176223_P(), 3);
                        }
                        else if (dist4 < 8.0 || cv < 1.0) {
                            for (int d = 1; d < depth; ++d) {
                                primer.func_180501_a(this.withY(this.getPos(primer).func_206849_h().func_177982_a(lx, 0, lz), y - d), ((Block)TFBlocks.fluffy_cloud.get()).func_176223_P(), 3);
                            }
                        }
                    }
                }
            }
        }
    }
    
    private void raiseHills(final WorldGenRegion primer, final TFFeature nearFeature, final int hdiam, final int x, final int z, final int dx, final int dz, final int hillHeight) {
        int oldGround = -1;
        int newGround = -1;
        boolean foundGroundLevel = false;
        for (int y = 31; y < 256; ++y) {
            final Block currentTerrain = primer.func_180495_p(this.withY(this.getPos(primer).func_206849_h().func_177982_a(x, 0, z), y)).func_177230_c();
            if (currentTerrain != Blocks.field_150348_b) {
                oldGround = y;
                newGround = y + hillHeight;
                foundGroundLevel = true;
                break;
            }
        }
        if (foundGroundLevel) {
            for (int y = oldGround; y <= newGround; ++y) {
                primer.func_180501_a(this.withY(this.getPos(primer).func_206849_h().func_177982_a(x, 0, z), y), Blocks.field_150348_b.func_176223_P(), 3);
            }
        }
        int hollow = hillHeight - 4 - nearFeature.size;
        if (nearFeature == TFFeature.HYDRA_LAIR) {
            final int mx = dx + 16;
            final int mz = dz + 16;
            final int mdist = (int)Math.sqrt(mx * mx + mz * mz);
            final int mheight = (int)(Math.cos(mdist / (hdiam / 1.5) * 3.141592653589793) * (hdiam / 1.5));
            hollow = Math.max(mheight - 4, hollow);
        }
        if (hollow < 0) {
            hollow = 0;
        }
        int hollowFloor = 26 - hollow / 8;
        if (nearFeature == TFFeature.HYDRA_LAIR) {
            hollowFloor = 31;
        }
        if (hillHeight > 0) {
            for (int y2 = 0; y2 < 31; ++y2) {
                if (primer.func_180495_p(this.withY(this.getPos(primer).func_206849_h().func_177982_a(x, 0, z), y2)).func_177230_c() != Blocks.field_150348_b) {
                    primer.func_180501_a(this.withY(this.getPos(primer).func_206849_h().func_177982_a(x, 0, z), y2), Blocks.field_150348_b.func_176223_P(), 3);
                }
            }
        }
        for (int y2 = hollowFloor + 1; y2 < hollowFloor + hollow; ++y2) {
            primer.func_180501_a(this.withY(this.getPos(primer).func_206849_h().func_177982_a(x, 0, z), y2), Blocks.field_150350_a.func_176223_P(), 3);
        }
    }
    
    private void flattenTerrainForFeature(final WorldGenRegion primer, final TFFeature nearFeature, final int x, final int z, final int dx, final int dz) {
        float squishFactor = 0.0f;
        int mazeHeight = 32;
        final int FEATURE_BOUNDARY = (nearFeature.size * 2 + 1) * 8 - 8;
        if (dx <= -FEATURE_BOUNDARY) {
            squishFactor = (-dx - FEATURE_BOUNDARY) / 8.0f;
        }
        else if (dx >= FEATURE_BOUNDARY) {
            squishFactor = (dx - FEATURE_BOUNDARY) / 8.0f;
        }
        if (dz <= -FEATURE_BOUNDARY) {
            squishFactor = Math.max(squishFactor, (-dz - FEATURE_BOUNDARY) / 8.0f);
        }
        else if (dz >= FEATURE_BOUNDARY) {
            squishFactor = Math.max(squishFactor, (dz - FEATURE_BOUNDARY) / 8.0f);
        }
        if (squishFactor > 0.0f) {
            for (int y = 0; y <= 127; ++y) {
                final Block currentTerrain = primer.func_180495_p(this.withY(this.getPos(primer).func_206849_h().func_177982_a(x, 0, z), y)).func_177230_c();
                if (currentTerrain != Blocks.field_150348_b) {
                    mazeHeight += (int)((y - mazeHeight) * squishFactor);
                    break;
                }
            }
        }
        for (int y = 0; y < mazeHeight; ++y) {
            final Block b = primer.func_180495_p(this.withY(this.getPos(primer).func_206849_h().func_177982_a(x, 0, z), y)).func_177230_c();
            if (b == Blocks.field_150350_a || b == Blocks.field_150355_j) {
                primer.func_180501_a(this.withY(this.getPos(primer).func_206849_h().func_177982_a(x, 0, z), y), Blocks.field_150348_b.func_176223_P(), 3);
            }
        }
        for (int y = mazeHeight; y <= 127; ++y) {
            final Block b = primer.func_180495_p(this.withY(this.getPos(primer).func_206849_h().func_177982_a(x, 0, z), y)).func_177230_c();
            if (b != Blocks.field_150350_a && b != Blocks.field_150355_j) {
                primer.func_180501_a(this.withY(this.getPos(primer).func_206849_h().func_177982_a(x, 0, z), y), Blocks.field_150350_a.func_176223_P(), 3);
            }
        }
    }
    
    private void deformTerrainForYetiLair(final WorldGenRegion primer, final TFFeature nearFeature, final int x, final int z, final int dx, final int dz) {
        float squishFactor = 0.0f;
        int topHeight = 55;
        final int outerBoundary = (nearFeature.size * 2 + 1) * 8 - 8;
        if (dx <= -outerBoundary) {
            squishFactor = (-dx - outerBoundary) / 8.0f;
        }
        else if (dx >= outerBoundary) {
            squishFactor = (dx - outerBoundary) / 8.0f;
        }
        if (dz <= -outerBoundary) {
            squishFactor = Math.max(squishFactor, (-dz - outerBoundary) / 8.0f);
        }
        else if (dz >= outerBoundary) {
            squishFactor = Math.max(squishFactor, (dz - outerBoundary) / 8.0f);
        }
        final int caveBoundary = nearFeature.size * 2 * 8 - 8;
        final int offset = Math.min(Math.abs(dx), Math.abs(dz));
        int hollowCeiling = 71 - offset * 4;
        if (dx >= -caveBoundary && dz >= -caveBoundary && dx <= caveBoundary && dz <= caveBoundary) {
            hollowCeiling = 47;
        }
        hollowCeiling -= offset / 6;
        hollowCeiling = Math.min(hollowCeiling, 47);
        int hollowFloor = 27 + offset / 6;
        if (squishFactor > 0.0f) {
            for (int y = 0; y <= 127; ++y) {
                final Block currentTerrain = primer.func_180495_p(this.withY(this.getPos(primer).func_206849_h().func_177982_a(x, 0, z), y)).func_177230_c();
                if (currentTerrain != Blocks.field_150348_b) {
                    topHeight += (int)((y - topHeight) * squishFactor);
                    hollowFloor += (int)((y - hollowFloor) * squishFactor);
                    break;
                }
            }
        }
        for (int y = 0; y < topHeight; ++y) {
            final Block b = primer.func_180495_p(this.withY(this.getPos(primer).func_206849_h().func_177982_a(x, 0, z), y)).func_177230_c();
            if (b == Blocks.field_150350_a || b == Blocks.field_150355_j) {
                primer.func_180501_a(this.withY(this.getPos(primer).func_206849_h().func_177982_a(x, 0, z), y), Blocks.field_150348_b.func_176223_P(), 3);
            }
        }
        for (int y = hollowFloor + 1; y < hollowCeiling; ++y) {
            primer.func_180501_a(this.withY(this.getPos(primer).func_206849_h().func_177982_a(x, 0, z), y), Blocks.field_150350_a.func_176223_P(), 3);
        }
        if (hollowFloor < hollowCeiling && hollowFloor < 34) {
            primer.func_180501_a(this.withY(this.getPos(primer).func_206849_h().func_177982_a(x, 0, z), hollowFloor), Blocks.field_150403_cj.func_176223_P(), 3);
        }
    }
    
    public final boolean shouldGenerateBedrock() {
        return this.shouldGenerateBedrock;
    }
    
    protected final ChunkPos getPos(final WorldGenRegion primer) {
        return new ChunkPos(primer.func_201679_a(), primer.func_201680_b());
    }
    
    protected final BlockPos withY(final BlockPos old, final int y) {
        return new BlockPos(old.func_177958_n(), y, old.func_177952_p());
    }
    
    public List<MobSpawnInfo.Spawners> func_230353_a_(final Biome biome, final StructureManager structureManager, final EntityClassification classification, final BlockPos pos) {
        final List<MobSpawnInfo.Spawners> potentialStructureSpawns = TFStructure.gatherPotentialSpawns(structureManager, classification, pos);
        if (potentialStructureSpawns != null) {
            return potentialStructureSpawns;
        }
        final List<MobSpawnInfo.Spawners> spawns = StructureSpawnManager.getStructureSpawns(structureManager, classification, pos);
        if (spawns != null) {
            return spawns;
        }
        return (List<MobSpawnInfo.Spawners>)((classification == EntityClassification.MONSTER && pos.func_177956_o() >= 31) ? ImmutableList.of() : super.func_230353_a_(biome, structureManager, classification, pos));
    }
}
