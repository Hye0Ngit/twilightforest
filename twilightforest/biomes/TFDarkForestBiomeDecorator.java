// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import twilightforest.world.TFWorld;
import twilightforest.block.TFBlocks;
import twilightforest.TFFeature;
import java.util.Random;
import twilightforest.world.TFGenDarkCanopyTree;

public class TFDarkForestBiomeDecorator extends TFBiomeDecorator
{
    TFGenDarkCanopyTree darkCanopyTreeGen;
    
    public TFDarkForestBiomeDecorator(final TFBiomeDarkForest tfBiomeDarkForest) {
        super(tfBiomeDarkForest);
        this.darkCanopyTreeGen = new TFGenDarkCanopyTree();
    }
    
    @Override
    public void a(final zv world, final Random rand, final int mapX, final int mapZ) {
        final TFFeature nearFeature = TFFeature.getNearestFeature(mapX >> 4, mapZ >> 4, world);
        if (nearFeature.chunkDecorationsEnabled) {
            for (int nc = this.canopyPerChunk + rand.nextInt(2), i = 0; i < nc; ++i) {
                final int rx = mapX + rand.nextInt(16) + 8;
                final int rz = mapZ + rand.nextInt(16) + 8;
                final int ry = world.f(rx, rz);
                this.darkCanopyTreeGen.a(world, rand, rx, ry, rz);
            }
            for (int i = 0; i < this.z; ++i) {
                final int rx = mapX + rand.nextInt(16) + 8;
                final int rz = mapZ + rand.nextInt(16) + 8;
                final int ry = this.getGroundLevel(world, rx, rz);
                final add var5 = this.e.a(rand);
                var5.a(1.0, 1.0, 1.0);
                var5.a(world, rand, rx, ry, rz);
            }
            for (int i = 0; i < this.C; ++i) {
                final int rx = mapX + rand.nextInt(16) + 8;
                final int rz = mapZ + rand.nextInt(16) + 8;
                final int ry = rand.nextInt(128);
                new adb(aou.ac.cz).a(world, rand, rx, ry, rz);
            }
            for (int i = 0; i < this.D; ++i) {
                if (rand.nextInt(8) == 0) {
                    final int rx = mapX + rand.nextInt(16) + 8;
                    final int rz = mapZ + rand.nextInt(16) + 8;
                    final int ry = this.getGroundLevel(world, rx, rz);
                    this.s.a(world, rand, rx, ry, rz);
                }
                if (rand.nextInt(16) == 0) {
                    final int rx = mapX + rand.nextInt(16) + 8;
                    final int rz = mapZ + rand.nextInt(16) + 8;
                    final int ry = this.getGroundLevel(world, rx, rz);
                    this.t.a(world, rand, rx, ry, rz);
                }
                if (rand.nextInt(24) == 0) {
                    final int rx = mapX + rand.nextInt(16) + 8;
                    final int rz = mapZ + rand.nextInt(16) + 8;
                    final int ry = this.getGroundLevel(world, rx, rz);
                    new ady(TFBlocks.plant.cz, 9).a(world, rand, rx, ry, rz);
                }
            }
            if (rand.nextInt(4) == 0) {
                final int rx2 = mapX + rand.nextInt(16) + 8;
                final int rz2 = mapZ + rand.nextInt(16) + 8;
                final int ry2 = rand.nextInt(128);
                this.s.a(world, rand, rx2, ry2, rz2);
            }
            if (rand.nextInt(8) == 0) {
                final int rx2 = mapX + rand.nextInt(16) + 8;
                final int rz2 = mapZ + rand.nextInt(16) + 8;
                final int ry2 = rand.nextInt(128);
                this.t.a(world, rand, rx2, ry2, rz2);
            }
        }
        this.decorateUnderground(world, rand, mapX, mapZ);
        this.decorateOnlyOres(world, rand, mapX, mapZ);
    }
    
    public int getGroundLevel(final zv world, final int x, final int z) {
        final abq chunk = world.d(x, z);
        int lastDirt = TFWorld.SEALEVEL;
        for (int y = TFWorld.SEALEVEL; y < TFWorld.WORLDHEIGHT - 1; ++y) {
            final int blockID = chunk.a(x & 0xF, y, z & 0xF);
            if (blockID == aou.y.cz) {
                return y + 1;
            }
            if (blockID == aou.y.cz || blockID == aou.y.cz || blockID == aou.y.cz) {
                lastDirt = y + 1;
            }
        }
        return lastDirt;
    }
}
