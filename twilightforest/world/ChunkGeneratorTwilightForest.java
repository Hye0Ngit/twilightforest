// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import com.mojang.datafixers.kinds.Applicative;
import java.util.function.Function;
import com.mojang.datafixers.kinds.App;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.BlockPos;
import twilightforest.block.TFBlocks;
import net.minecraft.world.ISeedReader;
import twilightforest.TFFeature;
import twilightforest.util.IntPair;
import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;
import net.minecraft.block.BlockState;
import twilightforest.worldgen.biomes.BiomeKeys;
import twilightforest.TFConfig;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.WorldGenRegion;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.DimensionSettings;
import java.util.function.Supplier;
import net.minecraft.world.biome.provider.BiomeProvider;
import com.mojang.serialization.Codec;

public class ChunkGeneratorTwilightForest extends ChunkGeneratorTwilightBase
{
    public static final Codec<ChunkGeneratorTwilightForest> CODEC;
    private long seed;
    
    public ChunkGeneratorTwilightForest(final BiomeProvider provider, final long seed, final Supplier<DimensionSettings> settings) {
        super(provider, seed, settings, true);
        this.seed = seed;
    }
    
    protected Codec<? extends ChunkGenerator> func_230347_a_() {
        return (Codec<? extends ChunkGenerator>)ChunkGeneratorTwilightForest.CODEC;
    }
    
    public ChunkGenerator func_230349_a_(final long l) {
        return (ChunkGenerator)new ChunkGeneratorTwilightForest(this.field_222542_c.func_230320_a_(l), l, this.dimensionSettings);
    }
    
    private Supplier<DimensionSettings> getDimensionSettings() {
        return this.dimensionSettings;
    }
    
    public void func_230352_b_(final IWorld world, final StructureManager p_230352_2_, final IChunk chunk) {
        super.func_230352_b_(world, p_230352_2_, chunk);
        if (!(world instanceof WorldGenRegion)) {
            return;
        }
        final WorldGenRegion primer = (WorldGenRegion)world;
        this.addDarkForestCanopy2(primer);
        this.addGlaciers(primer);
        this.deformTerrainForFeature(primer);
    }
    
    private void addGlaciers(final WorldGenRegion primer) {
        final BlockState glacierBase = Blocks.field_150351_n.func_176223_P();
        final BlockState glacierMain = TFConfig.COMMON_CONFIG.PERFORMANCE.glacierPackedIce.get() ? Blocks.field_150403_cj.func_176223_P() : Blocks.field_150432_aD.func_176223_P();
        final BlockState glacierTop = Blocks.field_150432_aD.func_176223_P();
        for (int z = 0; z < 16; ++z) {
            for (int x = 0; x < 16; ++x) {
                final Biome biome = primer.func_226691_t_(this.getPos(primer).func_206849_h().func_177982_a(x, 0, z));
                if (BiomeKeys.GLACIER.func_240901_a_().equals((Object)biome.getRegistryName())) {
                    int gBase = -1;
                    for (int y = 127; y >= 0; --y) {
                        final Block currentBlock = primer.func_180495_p(this.withY(this.getPos(primer).func_206849_h().func_177982_a(x, 0, z), y)).func_177230_c();
                        if (currentBlock == Blocks.field_150348_b) {
                            gBase = y + 1;
                            primer.func_180501_a(this.withY(this.getPos(primer).func_206849_h().func_177982_a(x, 0, z), y), glacierBase, 3);
                            break;
                        }
                    }
                    final int gHeight = 32;
                    final int gTop = Math.min(gBase + gHeight, 127);
                    for (int y2 = gBase; y2 < gTop; ++y2) {
                        primer.func_180501_a(this.withY(this.getPos(primer).func_206849_h().func_177982_a(x, 0, z), y2), glacierMain, 3);
                    }
                    primer.func_180501_a(this.withY(this.getPos(primer).func_206849_h().func_177982_a(x, 0, z), gTop), glacierTop, 3);
                }
            }
        }
    }
    
    private void addDarkForestCanopy2(final WorldGenRegion primer) {
        final BlockPos blockpos = this.getPos(primer).func_206849_h();
        final int[] thicks = new int[25];
        boolean biomeFound = false;
        for (int z = 0; z < 5; ++z) {
            for (int x = 0; x < 5; ++x) {
                for (int bx = -1; bx <= 1; ++bx) {
                    for (int bz = -1; bz <= 1; ++bz) {
                        final BlockPos p = blockpos.func_177982_a(x + bx << 2, 0, z + bz << 2);
                        final Biome biome = this.field_222542_c.func_225526_b_(p.func_177958_n() >> 2, 0, p.func_177952_p() >> 2);
                        if (BiomeKeys.DARK_FOREST.func_240901_a_().equals((Object)biome.getRegistryName()) || BiomeKeys.DARK_FOREST_CENTER.func_240901_a_().equals((Object)biome.getRegistryName())) {
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
        final TFFeature nearFeature = TFFeature.getNearestFeature(this.getPos(primer).field_77276_a, this.getPos(primer).field_77275_b, (ISeedReader)primer, nearCenter);
        final double d = 0.03125;
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
                    final int rx = x2 - hx;
                    final int rz = z2 - hz;
                    final int dist = (int)Math.sqrt(rx * rx + rz * rz);
                    if (dist < 24) {
                        thickness -= 24 - dist;
                    }
                }
                if (thickness > 1.0f) {
                    int topLevel = -1;
                    for (int y = 127; y >= 0; --y) {
                        final Block currentBlock = primer.func_180495_p(this.withY(this.getPos(primer).func_206849_h().func_177982_a(x2, 0, z2), y)).func_177230_c();
                        if (currentBlock == Blocks.field_150355_j) {
                            break;
                        }
                        if (currentBlock == Blocks.field_150348_b) {
                            topLevel = y;
                            break;
                        }
                    }
                    if (topLevel != -1) {
                        final int noise = Math.min(3, (int)(this.field_222571_r.func_215460_a((blockpos.func_177958_n() + x2) * 0.0625, (blockpos.func_177952_p() + z2) * 0.0625, 0.0625, x2 * 0.0625) * 15.0 / 1.25));
                        int treeBottom = topLevel + 12 - (int)(thickness * 0.5f);
                        final int treeTop = treeBottom + (int)(thickness * 1.5f);
                        treeBottom -= noise;
                        final BlockState darkLeaves = ((Block)TFBlocks.dark_leaves.get()).func_176223_P();
                        for (int y2 = treeBottom; y2 < treeTop; ++y2) {
                            primer.func_180501_a(this.withY(this.getPos(primer).func_206849_h().func_177982_a(x2, 0, z2), y2), darkLeaves, 3);
                        }
                    }
                }
            }
        }
    }
    
    static {
        CODEC = RecordCodecBuilder.create(instance -> instance.group((App)BiomeProvider.field_235202_a_.fieldOf("biome_source").forGetter((Function)ChunkGenerator::func_202090_b), (App)Codec.LONG.fieldOf("seed").stable().orElseGet(() -> TFDimensions.seed).forGetter(obj -> obj.seed), (App)DimensionSettings.field_236098_b_.fieldOf("settings").forGetter((Function)ChunkGeneratorTwilightForest::getDimensionSettings)).apply((Applicative)instance, instance.stable((Object)ChunkGeneratorTwilightForest::new)));
    }
}
