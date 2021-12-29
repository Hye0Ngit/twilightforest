// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import twilightforest.features.GenDruidHut;
import twilightforest.world.feature.TFGenFallenSmallLog;
import twilightforest.world.feature.TFGenFallenHollowLog;
import twilightforest.world.feature.TFGenHollowStump;
import twilightforest.world.feature.TFGenGroveRuins;
import twilightforest.world.feature.TFGenMonolith;
import twilightforest.world.feature.TFGenFoundation;
import twilightforest.world.feature.TFGenOutsideStalagmite;
import twilightforest.world.feature.TFGenWell;
import twilightforest.world.feature.TFGenStoneCircle;
import java.util.ArrayList;
import javax.annotation.Nullable;
import net.minecraft.util.WeightedRandom;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockStone;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import twilightforest.TFFeature;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.world.feature.TFGenerator;
import java.util.function.Supplier;
import twilightforest.TFConfig;
import twilightforest.world.feature.TFGenTorchBerries;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import twilightforest.world.feature.TFGenWoodRoots;
import twilightforest.world.feature.TFGenPlantRoots;
import twilightforest.world.feature.TFGenMangroveTree;
import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.init.Blocks;
import twilightforest.world.feature.TFGenMyceliumBlob;
import twilightforest.world.feature.TFGenCanopyMushroom;
import twilightforest.world.feature.TFGenCanopyTree;
import java.util.List;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.biome.BiomeDecorator;

public class TFBiomeDecorator extends BiomeDecorator
{
    WorldGenerator canopyTreeGen;
    WorldGenerator alternateCanopyGen;
    private final WorldGenerator myceliumBlobGen;
    private final WorldGenerator extraLakeGen;
    private final WorldGenerator extraLavaPoolGen;
    private final WorldGenerator mangroveTreeGen;
    private final WorldGenerator plantRootGen;
    private final WorldGenerator woodRootGen;
    private final WorldGenerator caveWaterGen;
    private final WorldGenerator torchBerryGen;
    public float canopyPerChunk;
    public boolean hasCanopy;
    public float alternateCanopyChance;
    public int myceliumPerChunk;
    public int mangrovesPerChunk;
    public int lakesPerChunk;
    public float lavaPoolChance;
    private static final List<RuinEntry> ruinList;
    
    public TFBiomeDecorator() {
        this.canopyTreeGen = (WorldGenerator)new TFGenCanopyTree();
        this.alternateCanopyGen = (WorldGenerator)new TFGenCanopyMushroom();
        this.myceliumBlobGen = new TFGenMyceliumBlob(5);
        this.extraLakeGen = (WorldGenerator)new WorldGenLakes((Block)Blocks.field_150355_j);
        this.extraLavaPoolGen = (WorldGenerator)new WorldGenLakes((Block)Blocks.field_150353_l);
        this.mangroveTreeGen = (WorldGenerator)new TFGenMangroveTree();
        this.plantRootGen = new TFGenPlantRoots();
        this.woodRootGen = new TFGenWoodRoots();
        this.caveWaterGen = (WorldGenerator)new WorldGenLiquids((Block)Blocks.field_150358_i);
        this.torchBerryGen = new TFGenTorchBerries();
        this.canopyPerChunk = TFConfig.performance.canopyCoverage;
        this.hasCanopy = true;
        this.alternateCanopyChance = 0.0f;
        this.myceliumPerChunk = 0;
        this.mangrovesPerChunk = 0;
        this.lakesPerChunk = 0;
        this.lavaPoolChance = 0.0f;
    }
    
    private static void addRuin(final Supplier<TFGenerator> generator, final int weight) {
        if (weight > 0) {
            TFBiomeDecorator.ruinList.add(new RuinEntry(generator.get(), weight));
        }
    }
    
    public void func_180292_a(final World world, final Random rand, final Biome biome, final BlockPos pos) {
        final TFFeature nearFeature = TFFeature.getNearestFeature(pos.func_177958_n() >> 4, pos.func_177952_p() >> 4, world);
        if (!nearFeature.areChunkDecorationsEnabled) {
            this.decorateUnderground(world, rand, pos);
            this.decorateOnlyOres(world, rand, pos);
        }
        else {
            super.func_180292_a(world, rand, biome, pos);
        }
    }
    
    protected void func_150513_a(final Biome biome, final World world, final Random randomGenerator) {
        if (randomGenerator.nextInt(6) == 0) {
            final int rx = this.field_180294_c.func_177958_n() + randomGenerator.nextInt(14) + 8;
            final int rz = this.field_180294_c.func_177952_p() + randomGenerator.nextInt(14) + 8;
            final TFGenerator rf = this.randomFeature(randomGenerator);
            if (rf != null) {
                rf.func_180709_b(world, randomGenerator, new BlockPos(rx, world.func_189649_b(rx, rz), rz));
            }
        }
        if (this.hasCanopy) {
            this.canopyPerChunk = TFConfig.performance.canopyCoverage;
            for (int nc = (int)this.canopyPerChunk + ((randomGenerator.nextFloat() < this.canopyPerChunk - (int)this.canopyPerChunk) ? 1 : 0), i = 0; i < nc; ++i) {
                final int rx2 = this.field_180294_c.func_177958_n() + randomGenerator.nextInt(16) + 8;
                final int rz2 = this.field_180294_c.func_177952_p() + randomGenerator.nextInt(16) + 8;
                final BlockPos genPos = new BlockPos(rx2, world.func_189649_b(rx2, rz2), rz2);
                if (this.alternateCanopyChance > 0.0f && randomGenerator.nextFloat() < this.alternateCanopyChance) {
                    this.alternateCanopyGen.func_180709_b(world, randomGenerator, genPos);
                }
                else {
                    this.canopyTreeGen.func_180709_b(world, randomGenerator, genPos);
                }
            }
        }
        for (int j = 0; j < this.mangrovesPerChunk; ++j) {
            final int rx3 = this.field_180294_c.func_177958_n() + randomGenerator.nextInt(16) + 8;
            final int rz3 = this.field_180294_c.func_177952_p() + randomGenerator.nextInt(16) + 8;
            this.mangroveTreeGen.func_180709_b(world, randomGenerator, new BlockPos(rx3, world.func_189649_b(rx3, rz3), rz3));
        }
        for (int j = 0; j < this.lakesPerChunk; ++j) {
            final int rx3 = this.field_180294_c.func_177958_n() + randomGenerator.nextInt(16) + 8;
            final int rz3 = this.field_180294_c.func_177952_p() + randomGenerator.nextInt(16) + 8;
            this.extraLakeGen.func_180709_b(world, randomGenerator, new BlockPos(rx3, world.func_189649_b(rx3, rz3), rz3));
        }
        if (randomGenerator.nextFloat() < this.lavaPoolChance) {
            final int rx = this.field_180294_c.func_177958_n() + randomGenerator.nextInt(16) + 8;
            final int rz = this.field_180294_c.func_177952_p() + randomGenerator.nextInt(16) + 8;
            this.extraLavaPoolGen.func_180709_b(world, randomGenerator, new BlockPos(rx, world.func_189649_b(rx, rz), rz));
        }
        for (int j = 0; j < this.myceliumPerChunk; ++j) {
            final int rx3 = this.field_180294_c.func_177958_n() + randomGenerator.nextInt(16) + 8;
            final int rz3 = this.field_180294_c.func_177952_p() + randomGenerator.nextInt(16) + 8;
            this.myceliumBlobGen.func_180709_b(world, randomGenerator, new BlockPos(rx3, world.func_189649_b(rx3, rz3), rz3));
        }
        super.func_150513_a(biome, world, randomGenerator);
        this.decorateUnderground(world, randomGenerator, this.field_180294_c);
    }
    
    protected void decorateUnderground(final World world, final Random rand, final BlockPos pos) {
        for (int i = 0; i < 12; ++i) {
            final int rx = pos.func_177958_n() + rand.nextInt(16) + 8;
            final int ry = 64;
            final int rz = pos.func_177952_p() + rand.nextInt(16) + 8;
            this.plantRootGen.func_180709_b(world, rand, new BlockPos(rx, ry, rz));
        }
        for (int i = 0; i < 20; ++i) {
            final int rx = pos.func_177958_n() + rand.nextInt(16) + 8;
            final int ry = rand.nextInt(64);
            final int rz = pos.func_177952_p() + rand.nextInt(16) + 8;
            this.woodRootGen.func_180709_b(world, rand, new BlockPos(rx, ry, rz));
        }
        if (this.field_76808_K) {
            for (int i = 0; i < 50; ++i) {
                final int rx = pos.func_177958_n() + rand.nextInt(16) + 8;
                final int ry = rand.nextInt(24) + 4;
                final int rz = pos.func_177952_p() + rand.nextInt(16) + 8;
                this.caveWaterGen.func_180709_b(world, rand, new BlockPos(rx, ry, rz));
            }
        }
        for (int i = 0; i < 3; ++i) {
            final int rx = pos.func_177958_n() + rand.nextInt(16) + 8;
            final int ry = 64;
            final int rz = pos.func_177952_p() + rand.nextInt(16) + 8;
            this.torchBerryGen.func_180709_b(world, rand, new BlockPos(rx, ry, rz));
        }
    }
    
    public void decorateOnlyOres(final World world, final Random rand, final BlockPos pos) {
        this.field_180294_c = pos;
        if (this.field_180293_d == null) {
            this.field_180293_d = ChunkGeneratorSettings.Factory.func_177865_a(world.func_72912_H().func_82571_y()).func_177864_b();
            this.field_180294_c = pos;
            this.field_76823_i = (WorldGenerator)new WorldGenMinable(Blocks.field_150346_d.func_176223_P(), this.field_180293_d.field_177789_I);
            this.field_76820_j = (WorldGenerator)new WorldGenMinable(Blocks.field_150351_n.func_176223_P(), this.field_180293_d.field_177785_M);
            this.field_180296_j = (WorldGenerator)new WorldGenMinable(Blocks.field_150348_b.func_176223_P().func_177226_a((IProperty)BlockStone.field_176247_a, (Comparable)BlockStone.EnumType.GRANITE), this.field_180293_d.field_177796_Q);
            this.field_180297_k = (WorldGenerator)new WorldGenMinable(Blocks.field_150348_b.func_176223_P().func_177226_a((IProperty)BlockStone.field_176247_a, (Comparable)BlockStone.EnumType.DIORITE), this.field_180293_d.field_177792_U);
            this.field_180295_l = (WorldGenerator)new WorldGenMinable(Blocks.field_150348_b.func_176223_P().func_177226_a((IProperty)BlockStone.field_176247_a, (Comparable)BlockStone.EnumType.ANDESITE), this.field_180293_d.field_177800_Y);
            this.field_76821_k = (WorldGenerator)new WorldGenMinable(Blocks.field_150365_q.func_176223_P(), this.field_180293_d.field_177844_ac);
            this.field_76818_l = (WorldGenerator)new WorldGenMinable(Blocks.field_150366_p.func_176223_P(), this.field_180293_d.field_177848_ag);
            this.field_76819_m = (WorldGenerator)new WorldGenMinable(Blocks.field_150352_o.func_176223_P(), this.field_180293_d.field_177828_ak);
            this.field_180299_p = (WorldGenerator)new WorldGenMinable(Blocks.field_150450_ax.func_176223_P(), this.field_180293_d.field_177836_ao);
            this.field_180298_q = (WorldGenerator)new WorldGenMinable(Blocks.field_150482_ag.func_176223_P(), this.field_180293_d.field_177814_as);
            this.field_76831_p = (WorldGenerator)new WorldGenMinable(Blocks.field_150369_x.func_176223_P(), this.field_180293_d.field_177822_aw);
        }
        this.func_76797_b(world, rand);
    }
    
    @Nullable
    public TFGenerator randomFeature(final Random rand) {
        return TFBiomeDecorator.ruinList.isEmpty() ? null : ((RuinEntry)WeightedRandom.func_76271_a(rand, (List)TFBiomeDecorator.ruinList)).generator;
    }
    
    public void setTreesPerChunk(final int treesPerChunk) {
        this.field_76832_z = treesPerChunk;
    }
    
    public void setBigMushroomsPerChunk(final int bigMushroomsPerChunk) {
        this.field_76807_J = bigMushroomsPerChunk;
    }
    
    public void setClayPerChunk(final int clayPerChunk) {
        this.field_76806_I = clayPerChunk;
    }
    
    public void setDeadBushPerChunk(final int deadBushPerChunk) {
        this.field_76804_C = deadBushPerChunk;
    }
    
    public void setMushroomsPerChunk(final int mushroomsPerChunk) {
        this.field_76798_D = mushroomsPerChunk;
    }
    
    public void setFlowersPerChunk(final int flowersPerChunk) {
        this.field_76802_A = flowersPerChunk;
    }
    
    public void setReedsPerChunk(final int reedsPerChunk) {
        this.field_76799_E = reedsPerChunk;
    }
    
    public void setWaterlilyPerChunk(final int waterlilyPerChunk) {
        this.field_76833_y = waterlilyPerChunk;
    }
    
    public void setGrassPerChunk(final int grassPerChunk) {
        this.field_76803_B = grassPerChunk;
    }
    
    static {
        ruinList = new ArrayList<RuinEntry>();
        addRuin((Supplier<TFGenerator>)TFGenStoneCircle::new, TFConfig.dimension.worldGenWeights.stoneCircleWeight);
        addRuin((Supplier<TFGenerator>)TFGenWell::new, TFConfig.dimension.worldGenWeights.wellWeight);
        addRuin((Supplier<TFGenerator>)TFGenOutsideStalagmite::new, TFConfig.dimension.worldGenWeights.stalagmiteWeight);
        addRuin((Supplier<TFGenerator>)TFGenFoundation::new, TFConfig.dimension.worldGenWeights.foundationWeight);
        addRuin((Supplier<TFGenerator>)TFGenMonolith::new, TFConfig.dimension.worldGenWeights.monolithWeight);
        addRuin((Supplier<TFGenerator>)TFGenGroveRuins::new, TFConfig.dimension.worldGenWeights.groveRuinsWeight);
        addRuin((Supplier<TFGenerator>)TFGenHollowStump::new, TFConfig.dimension.worldGenWeights.hollowStumpWeight);
        addRuin((Supplier<TFGenerator>)TFGenFallenHollowLog::new, TFConfig.dimension.worldGenWeights.fallenHollowLogWeight);
        addRuin((Supplier<TFGenerator>)TFGenFallenSmallLog::new, TFConfig.dimension.worldGenWeights.fallenSmallLogWeight);
        addRuin((Supplier<TFGenerator>)GenDruidHut::new, TFConfig.dimension.worldGenWeights.druidHutWeight);
    }
    
    private static class RuinEntry extends WeightedRandom.Item
    {
        public final TFGenerator generator;
        
        RuinEntry(final TFGenerator generator, final int weight) {
            super(weight);
            this.generator = generator;
        }
    }
}
