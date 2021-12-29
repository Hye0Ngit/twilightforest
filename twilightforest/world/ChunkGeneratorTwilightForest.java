// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import java.util.Iterator;
import net.minecraft.world.WorldEntitySpawner;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockFalling;
import twilightforest.block.TFBlocks;
import twilightforest.TFFeature;
import twilightforest.util.IntPair;
import net.minecraft.block.Block;
import twilightforest.biomes.TFBiomes;
import twilightforest.TFConfig;
import net.minecraft.world.biome.Biome;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.World;
import net.minecraft.world.gen.NoiseGeneratorOctaves;

public class ChunkGeneratorTwilightForest extends ChunkGeneratorTFBase
{
    private final NoiseGeneratorOctaves noiseGen4;
    private final TFGenCaves caveGenerator;
    private final TFGenRavine ravineGenerator;
    
    public ChunkGeneratorTwilightForest(final World world, final long seed, final boolean enableFeatures) {
        super(world, seed, enableFeatures, true);
        this.caveGenerator = new TFGenCaves();
        this.ravineGenerator = new TFGenRavine();
        this.noiseGen4 = new NoiseGeneratorOctaves(this.rand, 4);
    }
    
    public Chunk func_185932_a(final int x, final int z) {
        this.rand.setSeed(ChunkGeneratorTFBase.getSeed(x, z));
        final ChunkBitArray data = new ChunkBitArray();
        this.setBlocksInChunk(x, z, data);
        this.squishTerrain(data);
        final ChunkPrimer primer = new DirectChunkPrimer();
        this.initPrimer(primer, data);
        this.addDarkForestCanopy2(x, z, primer);
        this.addGlaciers(x, z, primer, this.biomesForGeneration = this.world.func_72959_q().func_76933_b(this.biomesForGeneration, x * 16, z * 16, 16, 16));
        this.deformTerrainForFeature(x, z, primer);
        this.replaceBiomeBlocks(x, z, primer, this.biomesForGeneration);
        this.caveGenerator.func_186125_a(this.world, x, z, primer);
        this.ravineGenerator.func_186125_a(this.world, x, z, primer);
        this.generateFeatures(x, z, primer);
        this.hollowTreeGenerator.func_186125_a(this.world, x, z, primer);
        return this.makeChunk(x, z, primer);
    }
    
    @Override
    protected void initPrimer(final ChunkPrimer primer, final ChunkBitArray data) {
        final IBlockState water = Blocks.field_150355_j.func_176223_P();
        final IBlockState stone = Blocks.field_150348_b.func_176223_P();
        for (int x = 0; x < 16; ++x) {
            for (int z = 0; z < 16; ++z) {
                for (int y = 0; y < 256; ++y) {
                    final boolean solid = data.get(ChunkGeneratorTFBase.getIndex(x, y, z));
                    if (y < 31 && !solid) {
                        primer.func_177855_a(x, y, z, water);
                    }
                    else if (solid) {
                        primer.func_177855_a(x, y, z, stone);
                    }
                }
            }
        }
    }
    
    private void addGlaciers(final int chunkX, final int chunkZ, final ChunkPrimer primer, final Biome[] biomes) {
        final IBlockState glacierBase = Blocks.field_150351_n.func_176223_P();
        final IBlockState glacierMain = TFConfig.performance.glacierPackedIce ? Blocks.field_150403_cj.func_176223_P() : Blocks.field_150432_aD.func_176223_P();
        final IBlockState glacierTop = Blocks.field_150432_aD.func_176223_P();
        for (int z = 0; z < 16; ++z) {
            for (int x = 0; x < 16; ++x) {
                final Biome biome = biomes[(x & 0xF) | (z & 0xF) << 4];
                if (biome == TFBiomes.glacier) {
                    int gBase = -1;
                    for (int y = 127; y >= 0; --y) {
                        final Block currentBlock = primer.func_177856_a(x, y, z).func_177230_c();
                        if (currentBlock == Blocks.field_150348_b) {
                            gBase = y + 1;
                            primer.func_177855_a(x, y, z, glacierBase);
                            break;
                        }
                    }
                    final int gHeight = 32;
                    final int gTop = Math.min(gBase + gHeight, 127);
                    for (int y2 = gBase; y2 < gTop; ++y2) {
                        primer.func_177855_a(x, y2, z, glacierMain);
                    }
                    primer.func_177855_a(x, gTop, z, glacierTop);
                }
            }
        }
    }
    
    private void addDarkForestCanopy2(final int chunkX, final int chunkZ, final ChunkPrimer primer) {
        final int[] thicks = new int[25];
        boolean biomeFound = false;
        for (int z = 0; z < 5; ++z) {
            for (int x = 0; x < 5; ++x) {
                for (int bx = -1; bx <= 1; ++bx) {
                    for (int bz = -1; bz <= 1; ++bz) {
                        final Biome biome = this.biomesForGeneration[x + bx + 2 + (z + bz + 2) * 10];
                        if (biome == TFBiomes.darkForest || biome == TFBiomes.darkForestCenter) {
                            final int[] array = thicks;
                            final int n = x + z * 5;
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
        final TFFeature nearFeature = TFFeature.getNearestFeature(chunkX, chunkZ, this.world, nearCenter);
        final double d = 0.03125;
        this.depthBuffer = this.noiseGen4.func_76304_a(this.depthBuffer, chunkX * 16, chunkZ * 16, 0, 16, 16, 1, d * 2.0, d * 2.0, d * 2.0);
        for (int z2 = 0; z2 < 16; ++z2) {
            for (int x2 = 0; x2 < 16; ++x2) {
                final int qx = x2 / 4;
                final int qz = z2 / 4;
                final float xweight = x2 % 4 * 0.25f + 0.125f;
                final float zweight = z2 % 4 * 0.25f + 0.125f;
                float thickness = 0.0f;
                thickness += thicks[qx + qz * 5] * (1.0f - xweight) * (1.0f - zweight);
                thickness += thicks[qx + 1 + qz * 5] * xweight * (1.0f - zweight);
                thickness += thicks[qx + (qz + 1) * 5] * (1.0f - xweight) * zweight;
                thickness += thicks[qx + 1 + (qz + 1) * 5] * xweight * zweight;
                thickness -= 4.0f;
                if (nearFeature == TFFeature.DARK_TOWER) {
                    final int hx = nearCenter.x;
                    final int hz = nearCenter.z;
                    final int dx = x2 - hx;
                    final int dz = z2 - hz;
                    final int dist = (int)Math.sqrt(dx * dx + dz * dz);
                    if (dist < 24) {
                        thickness -= 24 - dist;
                    }
                }
                if (thickness > 1.0f) {
                    int topLevel = -1;
                    for (int y = 127; y >= 0; --y) {
                        final Block currentBlock = primer.func_177856_a(x2, y, z2).func_177230_c();
                        if (currentBlock == Blocks.field_150355_j) {
                            break;
                        }
                        if (currentBlock == Blocks.field_150348_b) {
                            topLevel = y;
                            break;
                        }
                    }
                    if (topLevel != -1) {
                        final int noise = Math.min(3, (int)(this.depthBuffer[(z2 & 0xF) | (x2 & 0xF) << 4] / 1.25));
                        int treeBottom = topLevel + 12 - (int)(thickness * 0.5f);
                        final int treeTop = treeBottom + (int)(thickness * 1.5f);
                        treeBottom -= noise;
                        final IBlockState darkLeaves = TFBlocks.dark_leaves.func_176223_P();
                        for (int y2 = treeBottom; y2 < treeTop; ++y2) {
                            primer.func_177855_a(x2, y2, z2, darkLeaves);
                        }
                    }
                }
            }
        }
    }
    
    public void func_185931_b(final int x, final int z) {
        BlockFalling.field_149832_M = true;
        final int i = x * 16;
        final int j = z * 16;
        BlockPos blockpos = new BlockPos(i, 0, j);
        final Biome biome = this.world.func_180494_b(blockpos.func_177982_a(16, 0, 16));
        this.rand.setSeed(this.world.func_72905_C());
        final long k = this.rand.nextLong() / 2L * 2L + 1L;
        final long l = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed(x * k + z * l ^ this.world.func_72905_C());
        final boolean flag = false;
        final ChunkPos chunkpos = new ChunkPos(x, z);
        ForgeEventFactory.onChunkPopulate(true, (IChunkGenerator)this, this.world, this.rand, x, z, flag);
        boolean disableFeatures = false;
        for (final MapGenTFMajorFeature generator : this.featureGenerators.values()) {
            if (generator.func_175794_a(this.world, this.rand, chunkpos)) {
                disableFeatures = true;
            }
        }
        disableFeatures = (disableFeatures || !TFFeature.getNearestFeature(x, z, this.world).areChunkDecorationsEnabled);
        this.hollowTreeGenerator.func_175794_a(this.world, this.rand, chunkpos);
        if (!disableFeatures && this.rand.nextInt(4) == 0 && TerrainGen.populate((IChunkGenerator)this, this.world, this.rand, x, x, flag, PopulateChunkEvent.Populate.EventType.LAKE)) {
            final int i2 = blockpos.func_177958_n() + this.rand.nextInt(16) + 8;
            final int i3 = this.rand.nextInt(256);
            final int i4 = blockpos.func_177952_p() + this.rand.nextInt(16) + 8;
            if (i3 < 31 || this.allowSurfaceLakes(biome)) {
                new WorldGenLakes((Block)Blocks.field_150355_j).func_180709_b(this.world, this.rand, new BlockPos(i2, i3, i4));
            }
        }
        if (!disableFeatures && this.rand.nextInt(32) == 0 && TerrainGen.populate((IChunkGenerator)this, this.world, this.rand, x, z, flag, PopulateChunkEvent.Populate.EventType.LAVA)) {
            final int j2 = blockpos.func_177958_n() + this.rand.nextInt(16) + 8;
            final int j3 = this.rand.nextInt(this.rand.nextInt(248) + 8);
            final int j4 = blockpos.func_177952_p() + this.rand.nextInt(16) + 8;
            if (j3 < 31 || (this.allowSurfaceLakes(biome) && this.rand.nextInt(10) == 0)) {
                new WorldGenLakes((Block)Blocks.field_150353_l).func_180709_b(this.world, this.rand, new BlockPos(j2, j3, j4));
            }
        }
        if (TerrainGen.populate((IChunkGenerator)this, this.world, this.rand, x, z, flag, PopulateChunkEvent.Populate.EventType.DUNGEON)) {
            for (int k2 = 0; k2 < 8; ++k2) {
                final int k3 = blockpos.func_177958_n() + this.rand.nextInt(16) + 8;
                final int k4 = this.rand.nextInt(256);
                final int l2 = blockpos.func_177952_p() + this.rand.nextInt(16) + 8;
                new WorldGenDungeons().func_180709_b(this.world, this.rand, new BlockPos(k3, k4, l2));
            }
        }
        biome.func_180624_a(this.world, this.rand, new BlockPos(i, 0, j));
        if (TerrainGen.populate((IChunkGenerator)this, this.world, this.rand, x, z, flag, PopulateChunkEvent.Populate.EventType.ANIMALS)) {
            WorldEntitySpawner.func_77191_a(this.world, biome, i + 8, j + 8, 16, 16, this.rand);
        }
        blockpos = blockpos.func_177982_a(8, 0, 8);
        if (TerrainGen.populate((IChunkGenerator)this, this.world, this.rand, x, z, flag, PopulateChunkEvent.Populate.EventType.ICE)) {
            for (int k5 = 0; k5 < 16; ++k5) {
                for (int j5 = 0; j5 < 16; ++j5) {
                    final BlockPos blockpos2 = this.world.func_175725_q(blockpos.func_177982_a(k5, 0, j5));
                    final BlockPos blockpos3 = blockpos2.func_177977_b();
                    if (this.world.func_175675_v(blockpos3)) {
                        this.world.func_180501_a(blockpos3, Blocks.field_150432_aD.func_176223_P(), 18);
                    }
                    if (this.world.func_175708_f(blockpos2, true)) {
                        this.world.func_180501_a(blockpos2, Blocks.field_150431_aC.func_176223_P(), 18);
                    }
                }
            }
        }
        ForgeEventFactory.onChunkPopulate(false, (IChunkGenerator)this, this.world, this.rand, x, z, flag);
        BlockFalling.field_149832_M = false;
    }
    
    @Override
    public void func_180514_a(final Chunk chunk, final int x, final int z) {
        super.func_180514_a(chunk, x, z);
        this.hollowTreeGenerator.func_186125_a(this.world, x, z, (ChunkPrimer)null);
    }
}
