// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Random;

public class TFBiomeDecorator extends yg
{
    TFGenCanopyTree canopyTreeGen;
    TFGenCanopyMushroom canopyMushroomGen;
    TFGenHollowTree hollowTreeGen;
    TFGenMyceliumBlob myceliumBlobGen;
    cs extraLakeGen;
    TFGenMangroveTree mangroveTreeGen;
    TFGenPlantRoots plantRootGen;
    TFGenWoodRoots woodRootGen;
    rp caveWaterGen;
    TFGenHangBerries hangBerryGen;
    public int canopyPerChunk;
    public float chanceCanopyIsMushroom;
    public int myceliumPerChunk;
    public int mangrovesPerChunk;
    public int lakesPerChunk;
    
    public TFBiomeDecorator(final abn biomegenbase) {
        super(biomegenbase);
        this.canopyTreeGen = new TFGenCanopyTree();
        this.canopyMushroomGen = new TFGenCanopyMushroom();
        this.mangroveTreeGen = new TFGenMangroveTree();
        this.myceliumBlobGen = new TFGenMyceliumBlob(5);
        this.hollowTreeGen = new TFGenHollowTree();
        this.extraLakeGen = new cs(pb.B.bO);
        this.plantRootGen = new TFGenPlantRoots();
        this.woodRootGen = new TFGenWoodRoots();
        this.caveWaterGen = new rp(pb.A.bO);
        this.hangBerryGen = new TFGenHangBerries();
        this.canopyPerChunk = 1;
        this.chanceCanopyIsMushroom = 0.0f;
        this.myceliumPerChunk = 0;
        this.lakesPerChunk = 0;
        this.mangrovesPerChunk = 0;
    }
    
    public void a(final xd world, final Random rand, final int mapX, final int mapZ) {
        final TFFeature nearFeature = TFFeature.getNearestFeature(mapX >> 4, mapZ >> 4, world);
        final TFFeature hereFeature = TFFeature.getFeatureDirectlyAt(mapX >> 4, mapZ >> 4, world);
        if (!nearFeature.chunkDecorationsEnabled) {
            this.decorateUnderground(world, rand, mapX, mapZ);
            this.decorateOnlyOres(world, rand, mapX, mapZ);
        }
        else {
            if (hereFeature == TFFeature.glacierMaze) {
                new TFGenGlacierMaze(1).a(world, rand, mapX + 8, TFWorld.SEALEVEL + 10, mapZ + 8);
            }
            this.decorateUnderground(world, rand, mapX, mapZ);
            if (rand.nextInt(24) == 0) {
                final int rx = mapX + rand.nextInt(16) + 8;
                final int rz = mapZ + rand.nextInt(16) + 8;
                final int ry = world.e(rx, rz);
                this.hollowTreeGen.a(world, rand, rx, ry, rz);
            }
            if (rand.nextInt(6) == 0) {
                final int rx = mapX + rand.nextInt(16) + 8;
                final int rz = mapZ + rand.nextInt(16) + 8;
                final int ry = world.e(rx, rz);
                final TFGenerator rf = this.randomFeature(rand);
                if (rf.a(world, rand, rx, ry, rz)) {}
            }
            for (int nc = this.canopyPerChunk + rand.nextInt(2), i = 0; i < nc; ++i) {
                final int rx2 = mapX + rand.nextInt(16) + 8;
                final int rz2 = mapZ + rand.nextInt(16) + 8;
                final int ry2 = world.e(rx2, rz2);
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
            for (int i = 0; i < this.lakesPerChunk; ++i) {
                final int rx2 = mapX + rand.nextInt(16) + 8;
                final int rz2 = mapZ + rand.nextInt(16) + 8;
                final int ry2 = world.e(rx2, rz2);
                this.extraLakeGen.a(world, rand, rx2, ry2, rz2);
            }
            for (int i = 0; i < this.myceliumPerChunk; ++i) {
                final int rx2 = mapX + rand.nextInt(16) + 8;
                final int rz2 = mapZ + rand.nextInt(16) + 8;
                final int ry2 = world.e(rx2, rz2);
                this.myceliumBlobGen.a(world, rand, rx2, ry2, rz2);
            }
            for (int i = 0; i < this.mangrovesPerChunk; ++i) {
                final int rx2 = mapX + rand.nextInt(16) + 8;
                final int rz2 = mapZ + rand.nextInt(16) + 8;
                final int ry2 = world.e(rx2, rz2);
                this.mangroveTreeGen.a(world, rand, rx2, ry2, rz2);
            }
            super.a(world, rand, mapX, mapZ);
        }
    }
    
    protected void decorateUnderground(final xd world, final Random rand, final int mapX, final int mapZ) {
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
    
    public void decorateOnlyOres(final xd world, final Random rand, final int mapX, final int mapZ) {
        this.a = world;
        this.b = rand;
        this.c = mapX;
        this.d = mapZ;
        this.b();
        this.a = null;
        this.b = null;
    }
    
    public TFGenerator randomFeature(final Random rand) {
        final int rf = rand.nextInt(6);
        switch (rf) {
            case 0: {
                return new TFGenStoneCircle();
            }
            case 1: {
                return new TFGenWell();
            }
            case 2: {
                return new TFGenWitchHut();
            }
            case 3: {
                return new TFGenOutsideStalagmite();
            }
            case 4: {
                return new TFGenFoundation();
            }
            case 5: {
                return new TFGenMonolith();
            }
            default: {
                return new TFGenStoneCircle();
            }
        }
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
}
