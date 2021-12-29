// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

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
import twilightforest.world.TFGenerator;
import twilightforest.world.TFGenHugeCanopyTree;
import twilightforest.TFFeature;
import java.util.Random;
import java.util.List;
import twilightforest.world.TFGenHangBerries;
import twilightforest.world.TFGenWoodRoots;
import twilightforest.world.TFGenPlantRoots;
import twilightforest.world.TFGenMangroveTree;
import twilightforest.world.TFGenMyceliumBlob;
import twilightforest.world.TFGenHollowTree;
import twilightforest.world.TFGenCanopyMushroom;
import twilightforest.world.TFGenCanopyTree;

public class TFBiomeDecorator extends act
{
    TFGenCanopyTree canopyTreeGen;
    TFGenCanopyMushroom canopyMushroomGen;
    TFGenHollowTree hollowTreeGen;
    TFGenMyceliumBlob myceliumBlobGen;
    afl extraLakeGen;
    afl extraLavaPoolGen;
    TFGenMangroveTree mangroveTreeGen;
    TFGenPlantRoots plantRootGen;
    TFGenWoodRoots woodRootGen;
    afv caveWaterGen;
    TFGenHangBerries hangBerryGen;
    public int canopyPerChunk;
    public float chanceCanopyIsMushroom;
    public int myceliumPerChunk;
    public int mangrovesPerChunk;
    public int lakesPerChunk;
    public float lavaPoolChance;
    static final List<RuinEntry> ruinList;
    
    public TFBiomeDecorator(final acp biomegenbase) {
        super(biomegenbase);
        this.canopyTreeGen = new TFGenCanopyTree();
        this.canopyMushroomGen = new TFGenCanopyMushroom();
        this.mangroveTreeGen = new TFGenMangroveTree();
        this.myceliumBlobGen = new TFGenMyceliumBlob(5);
        this.hollowTreeGen = new TFGenHollowTree();
        this.extraLakeGen = new afl(aqw.G.cF);
        this.extraLavaPoolGen = new afl(aqw.I.cF);
        this.plantRootGen = new TFGenPlantRoots();
        this.woodRootGen = new TFGenWoodRoots();
        this.caveWaterGen = new afv(aqw.F.cF);
        this.hangBerryGen = new TFGenHangBerries();
        this.canopyPerChunk = 1;
        this.chanceCanopyIsMushroom = 0.0f;
        this.myceliumPerChunk = 0;
        this.lakesPerChunk = 0;
        this.lavaPoolChance = 0.0f;
        this.mangrovesPerChunk = 0;
    }
    
    public void a(final abv world, final Random rand, final int mapX, final int mapZ) {
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
                final int ry = world.f(rx, rz);
                this.hollowTreeGen.a(world, rand, rx, ry, rz);
            }
            if (rand.nextInt(6) == 0) {
                final int rx = mapX + rand.nextInt(16) + 8;
                final int rz = mapZ + rand.nextInt(16) + 8;
                final int ry = world.f(rx, rz);
                final TFGenerator rf = this.randomFeature(rand);
                if (rf.a(world, rand, rx, ry, rz)) {}
            }
            for (int nc = this.canopyPerChunk + rand.nextInt(2), i = 0; i < nc; ++i) {
                final int rx2 = mapX + rand.nextInt(16) + 8;
                final int rz2 = mapZ + rand.nextInt(16) + 8;
                final int ry2 = world.f(rx2, rz2);
                if (this.chanceCanopyIsMushroom > 0.0f && rand.nextFloat() <= this.chanceCanopyIsMushroom) {
                    this.canopyMushroomGen.a(world, rand, rx2, ry2, rz2);
                }
                else if (rand.nextInt(24) > 0) {
                    this.canopyTreeGen.a(world, rand, rx2, ry2, rz2);
                }
                else {
                    new TFGenHugeCanopyTree().a(world, rand, rx2, ry2, rz2);
                }
            }
            for (int i = 0; i < this.mangrovesPerChunk; ++i) {
                final int rx2 = mapX + rand.nextInt(16) + 8;
                final int rz2 = mapZ + rand.nextInt(16) + 8;
                final int ry2 = world.f(rx2, rz2);
                this.mangroveTreeGen.a(world, rand, rx2, ry2, rz2);
            }
            super.a(world, rand, mapX, mapZ);
        }
    }
    
    protected void a() {
        super.a();
        this.decorateUnderground(this.a, this.b, this.c, this.d);
        for (int i = 0; i < this.lakesPerChunk; ++i) {
            final int rx = this.c + this.b.nextInt(16) + 8;
            final int rz = this.d + this.b.nextInt(16) + 8;
            final int ry = this.a.f(rx, rz);
            this.extraLakeGen.a(this.a, this.b, rx, ry, rz);
        }
        if (this.b.nextFloat() <= this.lavaPoolChance) {
            final int rx2 = this.c + this.b.nextInt(16) + 8;
            final int rz2 = this.d + this.b.nextInt(16) + 8;
            final int ry2 = this.a.f(rx2, rz2);
            this.extraLavaPoolGen.a(this.a, this.b, rx2, ry2, rz2);
        }
        for (int i = 0; i < this.myceliumPerChunk; ++i) {
            final int rx = this.c + this.b.nextInt(16) + 8;
            final int rz = this.d + this.b.nextInt(16) + 8;
            final int ry = this.a.f(rx, rz);
            this.myceliumBlobGen.a(this.a, this.b, rx, ry, rz);
        }
    }
    
    protected void decorateUnderground(final abv world, final Random rand, final int mapX, final int mapZ) {
        for (int i = 0; i < 12; ++i) {
            final int rx = mapX + rand.nextInt(16) + 8;
            final byte ry = 64;
            final int rz = mapZ + rand.nextInt(16) + 8;
            this.plantRootGen.a(world, rand, rx, ry, rz);
        }
        for (int i = 0; i < 20; ++i) {
            final int rx = mapX + rand.nextInt(16) + 8;
            final int ry2 = rand.nextInt(64);
            final int rz = mapZ + rand.nextInt(16) + 8;
            this.woodRootGen.a(world, rand, rx, ry2, rz);
        }
        for (int i = 0; i < 50; ++i) {
            final int rx = mapX + rand.nextInt(16) + 8;
            final int ry2 = rand.nextInt(24) + 4;
            final int rz = mapZ + rand.nextInt(16) + 8;
            this.caveWaterGen.a(world, rand, rx, ry2, rz);
        }
        for (int i = 0; i < 3; ++i) {
            final int rx = mapX + rand.nextInt(16) + 8;
            final int ry2 = 64;
            final int rz = mapZ + rand.nextInt(16) + 8;
            this.hangBerryGen.a(world, rand, rx, ry2, rz);
        }
    }
    
    public void decorateOnlyOres(final abv world, final Random rand, final int mapX, final int mapZ) {
        this.a = world;
        this.b = rand;
        this.c = mapX;
        this.d = mapZ;
        this.b();
        this.a = null;
        this.b = null;
    }
    
    public TFGenerator randomFeature(final Random rand) {
        return ((RuinEntry)mh.a(rand, (Collection)TFBiomeDecorator.ruinList)).generator;
    }
    
    public void setTreesPerChunk(final int treesPerChunk) {
        this.z = treesPerChunk;
    }
    
    public void setBigMushroomsPerChunk(final int bigMushroomsPerChunk) {
        this.J = bigMushroomsPerChunk;
    }
    
    public void setClayPerChunk(final int clayPerChunk) {
        this.I = clayPerChunk;
    }
    
    public void setDeadBushPerChunk(final int deadBushPerChunk) {
        this.C = deadBushPerChunk;
    }
    
    public void setMushroomsPerChunk(final int mushroomsPerChunk) {
        this.D = mushroomsPerChunk;
    }
    
    public void setFlowersPerChunk(final int flowersPerChunk) {
        this.A = flowersPerChunk;
    }
    
    public void setReedsPerChunk(final int reedsPerChunk) {
        this.E = reedsPerChunk;
    }
    
    public void setWaterlilyPerChunk(final int waterlilyPerChunk) {
        this.y = waterlilyPerChunk;
    }
    
    public void setGrassPerChunk(final int grassPerChunk) {
        this.B = grassPerChunk;
    }
    
    static {
        (ruinList = new ArrayList<RuinEntry>()).add(new RuinEntry(new TFGenStoneCircle(), 10));
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
    
    static class RuinEntry extends mi
    {
        public final TFGenerator generator;
        
        public RuinEntry(final TFGenerator generator, final int weight) {
            super(weight);
            this.generator = generator;
        }
    }
}
