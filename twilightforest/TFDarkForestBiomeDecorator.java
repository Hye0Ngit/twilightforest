// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Random;

public class TFDarkForestBiomeDecorator extends TFBiomeDecorator
{
    TFGenDarkCanopyTree darkCanopyTreeGen;
    
    public TFDarkForestBiomeDecorator(final TFBiomeDarkForest tfBiomeDarkForest) {
        super(tfBiomeDarkForest);
        this.darkCanopyTreeGen = new TFGenDarkCanopyTree();
    }
    
    @Override
    public void a(final xd world, final Random rand, final int mapX, final int mapZ) {
        for (int nc = this.canopyPerChunk + rand.nextInt(2), i = 0; i < nc; ++i) {
            final int rx = mapX + rand.nextInt(16) + 8;
            final int rz = mapZ + rand.nextInt(16) + 8;
            final int ry = world.e(rx, rz);
            this.darkCanopyTreeGen.a(world, rand, rx, ry, rz);
        }
        for (int i = 0; i < this.z; ++i) {
            final int rx = mapX + rand.nextInt(16) + 8;
            final int rz = mapZ + rand.nextInt(16) + 8;
            final int ry = this.getGroundLevel(world, rx, rz);
            final li var5 = this.e.a(rand);
            var5.a(1.0, 1.0, 1.0);
            var5.a(world, rand, rx, ry, rz);
        }
        for (int i = 0; i < this.C; ++i) {
            final int rx = mapX + rand.nextInt(16) + 8;
            final int rz = mapZ + rand.nextInt(16) + 8;
            final int ry = rand.nextInt(128);
            new abw(pb.Y.bO).a(world, rand, rx, ry, rz);
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
                new to(TFBlocks.plant.bO, 9).a(world, rand, rx, ry, rz);
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
        this.decorateUnderground(world, rand, mapX, mapZ);
        this.decorateOnlyOres(world, rand, mapX, mapZ);
    }
    
    public int getGroundLevel(final xd world, final int x, final int z) {
        final ack chunk = world.c(x, z);
        int lastDirt = TFWorld.SEALEVEL;
        for (int y = TFWorld.SEALEVEL; y < TFWorld.WORLDHEIGHT - 1; ++y) {
            final int blockID = chunk.a(x & 0xF, y, z & 0xF);
            if (blockID == pb.u.bO) {
                return y + 1;
            }
            if (blockID == pb.u.bO || blockID == pb.u.bO || blockID == pb.u.bO) {
                lastDirt = y + 1;
            }
        }
        return lastDirt;
    }
}
