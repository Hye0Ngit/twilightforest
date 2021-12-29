// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.TFFeature;
import java.util.Iterator;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockFalling;
import net.minecraft.world.biome.Biome;
import net.minecraft.block.state.IBlockState;
import twilightforest.biomes.TFBiomes;
import net.minecraft.init.Blocks;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.Chunk;
import twilightforest.TFConfig;
import net.minecraft.world.World;

public class ChunkGeneratorTwilightVoid extends ChunkGeneratorTFBase
{
    private final boolean generateHollowTrees;
    
    public ChunkGeneratorTwilightVoid(final World world, final long seed, final boolean enableFeatures) {
        super(world, seed, enableFeatures, false);
        this.generateHollowTrees = TFConfig.dimension.skylightOaks;
    }
    
    public Chunk func_185932_a(final int x, final int z) {
        this.rand.setSeed(ChunkGeneratorTFBase.getSeed(x, z));
        final ChunkBitArray data = new ChunkBitArray();
        this.setBlocksInChunk(x, z, data);
        this.squishTerrain(data);
        this.biomesForGeneration = this.world.func_72959_q().func_76933_b(this.biomesForGeneration, x * 16, z * 16, 16, 16);
        final ChunkPrimer primer = new DirectChunkPrimer();
        this.initPrimer(primer, data);
        this.deformTerrainForFeature(x, z, primer);
        this.replaceBiomeBlocks(x, z, primer, this.biomesForGeneration);
        this.generateFeatures(x, z, primer);
        if (this.generateHollowTrees) {
            this.hollowTreeGenerator.func_186125_a(this.world, x, z, primer);
        }
        return this.makeChunk(x, z, primer);
    }
    
    @Override
    protected void initPrimer(final ChunkPrimer primer, final ChunkBitArray data) {
        final IBlockState stone = Blocks.field_150348_b.func_176223_P();
        for (int x = 0; x < 16; ++x) {
            for (int z = 0; z < 16; ++z) {
                final Biome biome = this.biomesForGeneration[(x & 0xF) | (z & 0xF) << 4];
                if (biome == TFBiomes.highlandsCenter) {
                    for (int y = 0; y < 256; ++y) {
                        if (data.get(ChunkGeneratorTFBase.getIndex(x, y, z))) {
                            primer.func_177855_a(x, y, z, stone);
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
        this.rand.setSeed(this.world.func_72905_C());
        final long k = this.rand.nextLong() / 2L * 2L + 1L;
        final long l = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed(x * k + z * l ^ this.world.func_72905_C());
        final boolean flag = false;
        final ChunkPos chunkpos = new ChunkPos(x, z);
        ForgeEventFactory.onChunkPopulate(true, (IChunkGenerator)this, this.world, this.rand, x, z, flag);
        for (final MapGenTFMajorFeature generator : this.featureGenerators.values()) {
            generator.func_175794_a(this.world, this.rand, chunkpos);
        }
        if (this.generateHollowTrees) {
            this.hollowTreeGenerator.func_175794_a(this.world, this.rand, chunkpos);
        }
        blockpos = blockpos.func_177982_a(8, 0, 8);
        if (TerrainGen.populate((IChunkGenerator)this, this.world, this.rand, x, z, flag, PopulateChunkEvent.Populate.EventType.ICE)) {
            for (int k2 = 0; k2 < 16; ++k2) {
                for (int j2 = 0; j2 < 16; ++j2) {
                    final BlockPos blockpos2 = this.world.func_175725_q(blockpos.func_177982_a(k2, 0, j2));
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
    protected void deformTerrainForTrollCaves(final ChunkPrimer primer, final TFFeature nearFeature, final int x, final int z, final int dx, final int dz) {
        final int radius = (nearFeature.size * 2 + 1) * 8;
        final int dist = (int)Math.sqrt(dx * dx + dz * dz);
        if (dist > radius) {
            return;
        }
        final Biome biome = this.biomesForGeneration[(x & 0xF) | (z & 0xF) << 4];
        if (biome != TFBiomes.highlands) {
            return;
        }
        for (int y = 0; y < 60; ++y) {
            if (primer.func_177856_a(x, y, z).func_177230_c() != Blocks.field_150348_b) {
                primer.func_177855_a(x, y, z, Blocks.field_150348_b.func_176223_P());
            }
        }
    }
    
    @Override
    public void func_180514_a(final Chunk chunk, final int x, final int z) {
        super.func_180514_a(chunk, x, z);
        if (this.generateHollowTrees) {
            this.hollowTreeGenerator.func_186125_a(this.world, x, z, (ChunkPrimer)null);
        }
    }
}
