import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFBiomeDecorator extends yc
{
    TFGenCanopyTree canopyTreeGen;
    TFGenCanopyMushroom canopyMushroomGen;
    TFGenHollowTree hollowTreeGen;
    TFGenMyceliumBlob myceliumBlobGen;
    cq extraLakeGen;
    TFGenMangroveTree mangroveTreeGen;
    public int canopyPerChunk;
    public float chanceCanopyIsMushroom;
    public int myceliumPerChunk;
    public int mangrovesPerChunk;
    public int lakesPerChunk;
    
    public TFBiomeDecorator(final abi biomegenbase) {
        super(biomegenbase);
        this.canopyTreeGen = new TFGenCanopyTree();
        this.canopyMushroomGen = new TFGenCanopyMushroom();
        this.mangroveTreeGen = new TFGenMangroveTree();
        this.myceliumBlobGen = new TFGenMyceliumBlob(5);
        this.hollowTreeGen = new TFGenHollowTree();
        this.extraLakeGen = new cq(ox.B.bO);
        this.canopyPerChunk = 1;
        this.chanceCanopyIsMushroom = 0.0f;
        this.myceliumPerChunk = 0;
        this.lakesPerChunk = 0;
        this.mangrovesPerChunk = 0;
    }
    
    public void a(final wz world, final Random rand, final int mapX, final int mapZ) {
        final int nearType = ChunkProviderTwilightForest.nearestFeatureType(mapX >> 4, mapZ >> 4, world);
        final int hereType = ChunkProviderTwilightForest.featureType(mapX >> 4, mapZ >> 4, world);
        if (nearType != 4 && nearType != 5 && nearType != 6) {
            if (nearType != 9) {
                if (hereType == 7) {
                    new TFGenGlacierMaze(1).a(world, rand, mapX + 8, TFWorld.SEALEVEL + 10, mapZ + 8);
                }
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
                    else {
                        this.canopyTreeGen.a(world, rand, rx2, ry2, rz2);
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
}
