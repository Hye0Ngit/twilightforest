// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import net.minecraft.util.WeightedRandomItem;
import twilightforest.world.TFGenFallenSmallLog;
import twilightforest.world.TFGenFallenHollowLog;
import twilightforest.world.TFGenHollowStump;
import twilightforest.world.TFGenGroveRuins;
import twilightforest.world.TFGenMonolith;
import twilightforest.world.TFGenFoundation;
import twilightforest.world.TFGenOutsideStalagmite;
import twilightforest.world.TFGenWitchHut;
import twilightforest.world.TFGenWell;
import twilightforest.world.TFGenStoneCircle;
import java.util.ArrayList;
import java.util.Collection;
import net.minecraft.util.WeightedRandom;
import twilightforest.world.TFGenerator;
import twilightforest.world.TFGenHugeCanopyTree;
import twilightforest.TFFeature;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import java.util.List;
import twilightforest.world.TFGenHangBerries;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import twilightforest.world.TFGenWoodRoots;
import twilightforest.world.TFGenPlantRoots;
import twilightforest.world.TFGenMangroveTree;
import net.minecraft.world.gen.feature.WorldGenLakes;
import twilightforest.world.TFGenMyceliumBlob;
import twilightforest.world.TFGenHollowTree;
import twilightforest.world.TFGenCanopyMushroom;
import twilightforest.world.TFGenCanopyTree;
import net.minecraft.world.biome.BiomeDecorator;

public class TFBiomeDecorator extends BiomeDecorator
{
    TFGenCanopyTree canopyTreeGen;
    TFGenCanopyMushroom canopyMushroomGen;
    TFGenHollowTree hollowTreeGen;
    TFGenMyceliumBlob myceliumBlobGen;
    WorldGenLakes extraLakeGen;
    WorldGenLakes extraLavaPoolGen;
    TFGenMangroveTree mangroveTreeGen;
    TFGenPlantRoots plantRootGen;
    TFGenWoodRoots woodRootGen;
    WorldGenLiquids caveWaterGen;
    TFGenHangBerries hangBerryGen;
    public int canopyPerChunk;
    public float chanceCanopyIsMushroom;
    public int myceliumPerChunk;
    public int mangrovesPerChunk;
    public int lakesPerChunk;
    public float lavaPoolChance;
    static final List ruinList;
    
    public TFBiomeDecorator(final BiomeGenBase biomegenbase) {
        super(biomegenbase);
        this.canopyTreeGen = new TFGenCanopyTree();
        this.canopyMushroomGen = new TFGenCanopyMushroom();
        this.mangroveTreeGen = new TFGenMangroveTree();
        this.myceliumBlobGen = new TFGenMyceliumBlob(5);
        this.hollowTreeGen = new TFGenHollowTree();
        this.extraLakeGen = new WorldGenLakes(Block.field_71943_B.field_71990_ca);
        this.extraLavaPoolGen = new WorldGenLakes(Block.field_71938_D.field_71990_ca);
        this.plantRootGen = new TFGenPlantRoots();
        this.woodRootGen = new TFGenWoodRoots();
        this.caveWaterGen = new WorldGenLiquids(Block.field_71942_A.field_71990_ca);
        this.hangBerryGen = new TFGenHangBerries();
        this.canopyPerChunk = 1;
        this.chanceCanopyIsMushroom = 0.0f;
        this.myceliumPerChunk = 0;
        this.lakesPerChunk = 0;
        this.lavaPoolChance = 0.0f;
        this.mangrovesPerChunk = 0;
    }
    
    public void func_76796_a(final World world, final Random rand, final int mapX, final int mapZ) {
        final TFFeature nearFeature = TFFeature.getNearestFeature(mapX >> 4, mapZ >> 4, world);
        final TFFeature hereFeature = TFFeature.getFeatureDirectlyAt(mapX >> 4, mapZ >> 4, world);
        if (!nearFeature.chunkDecorationsEnabled) {
            this.decorateUnderground(world, rand, mapX, mapZ);
            this.decorateOnlyOres(world, rand, mapX, mapZ);
        }
        else {
            if (rand.nextInt(24) == 0) {
                final int rx = mapX + rand.nextInt(16) + 8;
                final int rz = mapZ + rand.nextInt(16) + 8;
                final int ry = world.func_72976_f(rx, rz);
                this.hollowTreeGen.func_76484_a(world, rand, rx, ry, rz);
            }
            if (rand.nextInt(6) == 0) {
                final int rx = mapX + rand.nextInt(16) + 8;
                final int rz = mapZ + rand.nextInt(16) + 8;
                final int ry = world.func_72976_f(rx, rz);
                final TFGenerator rf = this.randomFeature(rand);
                if (rf.func_76484_a(world, rand, rx, ry, rz)) {}
            }
            for (int nc = this.canopyPerChunk + rand.nextInt(2), i = 0; i < nc; ++i) {
                final int rx2 = mapX + rand.nextInt(16) + 8;
                final int rz2 = mapZ + rand.nextInt(16) + 8;
                final int ry2 = world.func_72976_f(rx2, rz2);
                if (this.chanceCanopyIsMushroom > 0.0f && rand.nextFloat() <= this.chanceCanopyIsMushroom) {
                    this.canopyMushroomGen.func_76484_a(world, rand, rx2, ry2, rz2);
                }
                else if (rand.nextInt(24) > 0) {
                    this.canopyTreeGen.func_76484_a(world, rand, rx2, ry2, rz2);
                }
                else {
                    new TFGenHugeCanopyTree().func_76484_a(world, rand, rx2, ry2, rz2);
                }
            }
            for (int i = 0; i < this.mangrovesPerChunk; ++i) {
                final int rx2 = mapX + rand.nextInt(16) + 8;
                final int rz2 = mapZ + rand.nextInt(16) + 8;
                final int ry2 = world.func_72976_f(rx2, rz2);
                this.mangroveTreeGen.func_76484_a(world, rand, rx2, ry2, rz2);
            }
            super.func_76796_a(world, rand, mapX, mapZ);
        }
    }
    
    protected void func_76794_a() {
        super.func_76794_a();
        this.decorateUnderground(this.field_76815_a, this.field_76813_b, this.field_76814_c, this.field_76811_d);
        for (int i = 0; i < this.lakesPerChunk; ++i) {
            final int rx = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            final int rz = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            final int ry = this.field_76815_a.func_72976_f(rx, rz);
            this.extraLakeGen.func_76484_a(this.field_76815_a, this.field_76813_b, rx, ry, rz);
        }
        if (this.field_76813_b.nextFloat() <= this.lavaPoolChance) {
            final int rx2 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            final int rz2 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            final int ry2 = this.field_76815_a.func_72976_f(rx2, rz2);
            this.extraLavaPoolGen.func_76484_a(this.field_76815_a, this.field_76813_b, rx2, ry2, rz2);
        }
        for (int i = 0; i < this.myceliumPerChunk; ++i) {
            final int rx = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            final int rz = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            final int ry = this.field_76815_a.func_72976_f(rx, rz);
            this.myceliumBlobGen.func_76484_a(this.field_76815_a, this.field_76813_b, rx, ry, rz);
        }
    }
    
    protected void decorateUnderground(final World world, final Random rand, final int mapX, final int mapZ) {
        for (int i = 0; i < 12; ++i) {
            final int rx = mapX + rand.nextInt(16) + 8;
            final byte ry = 64;
            final int rz = mapZ + rand.nextInt(16) + 8;
            this.plantRootGen.func_76484_a(world, rand, rx, ry, rz);
        }
        for (int i = 0; i < 20; ++i) {
            final int rx = mapX + rand.nextInt(16) + 8;
            final int ry2 = rand.nextInt(64);
            final int rz = mapZ + rand.nextInt(16) + 8;
            this.woodRootGen.func_76484_a(world, rand, rx, ry2, rz);
        }
        for (int i = 0; i < 50; ++i) {
            final int rx = mapX + rand.nextInt(16) + 8;
            final int ry2 = rand.nextInt(24) + 4;
            final int rz = mapZ + rand.nextInt(16) + 8;
            this.caveWaterGen.func_76484_a(world, rand, rx, ry2, rz);
        }
        for (int i = 0; i < 3; ++i) {
            final int rx = mapX + rand.nextInt(16) + 8;
            final int ry2 = 64;
            final int rz = mapZ + rand.nextInt(16) + 8;
            this.hangBerryGen.func_76484_a(world, rand, rx, ry2, rz);
        }
    }
    
    public void decorateOnlyOres(final World world, final Random rand, final int mapX, final int mapZ) {
        this.field_76815_a = world;
        this.field_76813_b = rand;
        this.field_76814_c = mapX;
        this.field_76811_d = mapZ;
        this.func_76797_b();
        this.field_76815_a = null;
        this.field_76813_b = null;
    }
    
    public TFGenerator randomFeature(final Random rand) {
        return ((RuinEntry)WeightedRandom.func_76271_a(rand, (Collection)TFBiomeDecorator.ruinList)).generator;
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
        (ruinList = new ArrayList()).add(new RuinEntry(new TFGenStoneCircle(), 10));
        TFBiomeDecorator.ruinList.add(new RuinEntry(new TFGenWell(), 10));
        TFBiomeDecorator.ruinList.add(new RuinEntry(new TFGenWitchHut(), 5));
        TFBiomeDecorator.ruinList.add(new RuinEntry(new TFGenOutsideStalagmite(), 12));
        TFBiomeDecorator.ruinList.add(new RuinEntry(new TFGenFoundation(), 10));
        TFBiomeDecorator.ruinList.add(new RuinEntry(new TFGenMonolith(), 10));
        TFBiomeDecorator.ruinList.add(new RuinEntry(new TFGenGroveRuins(), 5));
        TFBiomeDecorator.ruinList.add(new RuinEntry(new TFGenHollowStump(), 12));
        TFBiomeDecorator.ruinList.add(new RuinEntry(new TFGenFallenHollowLog(), 10));
        TFBiomeDecorator.ruinList.add(new RuinEntry(new TFGenFallenSmallLog(), 10));
    }
    
    static class RuinEntry extends WeightedRandomItem
    {
        public final TFGenerator generator;
        
        public RuinEntry(final TFGenerator generator, final int weight) {
            super(weight);
            this.generator = generator;
        }
    }
}
