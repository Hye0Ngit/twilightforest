// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.TFTreasure;
import java.util.Random;

public class TFGenWell extends TFGenerator
{
    @Override
    public boolean a(final yc world, final Random rand, final int x, final int y, final int z) {
        if (rand.nextInt(4) == 0) {
            return this.generate4x4Well(world, rand, x, y, z);
        }
        return this.generate3x3Well(world, rand, x, y, z);
    }
    
    public boolean generate3x3Well(final yc world, final Random rand, final int x, final int y, final int z) {
        this.worldObj = world;
        if (!this.isAreaClear(world, rand, x, y, z, 3, 4, 3)) {
            return false;
        }
        this.putBlock(x + 0, y, z + 0, amq.ar.cm, true);
        this.putBlock(x + 1, y, z + 0, amq.ar.cm, true);
        this.putBlock(x + 2, y, z + 0, amq.ar.cm, true);
        this.putBlock(x + 0, y, z + 2, amq.ar.cm, true);
        this.putBlock(x + 1, y, z + 2, amq.ar.cm, true);
        this.putBlock(x + 2, y, z + 2, amq.ar.cm, true);
        this.putBlock(x + 0, y, z + 1, amq.ar.cm, true);
        this.putBlock(x + 2, y, z + 1, amq.ar.cm, true);
        this.putBlock(x + 1, y, z + 1, amq.E.cm, true);
        this.putBlock(x + 0, y + 1, z + 0, amq.bc.cm, true);
        this.putBlock(x + 2, y + 1, z + 0, amq.bc.cm, true);
        this.putBlock(x + 0, y + 1, z + 2, amq.bc.cm, true);
        this.putBlock(x + 2, y + 1, z + 2, amq.bc.cm, true);
        this.putBlock(x + 0, y + 2, z + 0, amq.bc.cm, true);
        this.putBlock(x + 2, y + 2, z + 0, amq.bc.cm, true);
        this.putBlock(x + 0, y + 2, z + 2, amq.bc.cm, true);
        this.putBlock(x + 2, y + 2, z + 2, amq.bc.cm, true);
        this.putBlockAndMetadata(x + 0, y + 3, z + 0, amq.bR.cm, 0, true);
        this.putBlockAndMetadata(x + 1, y + 3, z + 0, amq.bR.cm, 0, true);
        this.putBlockAndMetadata(x + 2, y + 3, z + 0, amq.bR.cm, 0, true);
        this.putBlockAndMetadata(x + 0, y + 3, z + 2, amq.bR.cm, 0, true);
        this.putBlockAndMetadata(x + 1, y + 3, z + 2, amq.bR.cm, 0, true);
        this.putBlockAndMetadata(x + 2, y + 3, z + 2, amq.bR.cm, 0, true);
        this.putBlockAndMetadata(x + 0, y + 3, z + 1, amq.bR.cm, 0, true);
        this.putBlockAndMetadata(x + 2, y + 3, z + 1, amq.bR.cm, 0, true);
        this.putBlock(x + 1, y + 3, z + 1, amq.A.cm, true);
        boolean madeTreasure = false;
        for (int dy = -1; dy >= -20; --dy) {
            final int dblock = world.a(x + 1, y + dy, z + 1);
            if (dblock != amq.y.cm && dblock != amq.x.cm && dblock != amq.I.cm && dblock != amq.w.cm) {
                break;
            }
            if (!world.g(x + 1, y + dy - 1, z + 1).a()) {
                break;
            }
            this.putBlock(x + 1, y + dy, z + 1, amq.E.cm, true);
            if (dy < -15 && !madeTreasure && rand.nextInt(8) == 0) {
                this.putBlock(x + 2, y + dy, z + 1, amq.E.cm, true);
                this.putBlock(x + 3, y + dy + 1, z + 1, 0, true);
                this.putBlock(x + 3, y + dy, z + 1, 0, true);
                TFTreasure.basement.generate(this.worldObj, rand, x + 3, y + dy, z + 1);
                madeTreasure = true;
            }
        }
        return true;
    }
    
    public boolean generate4x4Well(final yc world, final Random rand, final int x, final int y, final int z) {
        this.worldObj = world;
        if (!this.isAreaClear(world, rand, x, y, z, 4, 4, 4)) {
            return false;
        }
        this.putBlock(x + 0, y, z + 0, amq.ar.cm, true);
        this.putBlock(x + 1, y, z + 0, amq.ar.cm, true);
        this.putBlock(x + 2, y, z + 0, amq.ar.cm, true);
        this.putBlock(x + 3, y, z + 0, amq.ar.cm, true);
        this.putBlock(x + 0, y, z + 3, amq.ar.cm, true);
        this.putBlock(x + 1, y, z + 3, amq.ar.cm, true);
        this.putBlock(x + 2, y, z + 3, amq.ar.cm, true);
        this.putBlock(x + 3, y, z + 3, amq.ar.cm, true);
        this.putBlock(x + 0, y, z + 1, amq.ar.cm, true);
        this.putBlock(x + 0, y, z + 2, amq.ar.cm, true);
        this.putBlock(x + 3, y, z + 1, amq.ar.cm, true);
        this.putBlock(x + 3, y, z + 2, amq.ar.cm, true);
        this.putBlock(x + 1, y, z + 1, amq.E.cm, true);
        this.putBlock(x + 2, y, z + 1, amq.E.cm, true);
        this.putBlock(x + 1, y, z + 2, amq.E.cm, true);
        this.putBlock(x + 2, y, z + 2, amq.E.cm, true);
        this.putBlock(x + 0, y + 1, z + 0, amq.bc.cm, true);
        this.putBlock(x + 3, y + 1, z + 0, amq.bc.cm, true);
        this.putBlock(x + 0, y + 1, z + 3, amq.bc.cm, true);
        this.putBlock(x + 3, y + 1, z + 3, amq.bc.cm, true);
        this.putBlock(x + 0, y + 2, z + 0, amq.bc.cm, true);
        this.putBlock(x + 3, y + 2, z + 0, amq.bc.cm, true);
        this.putBlock(x + 0, y + 2, z + 3, amq.bc.cm, true);
        this.putBlock(x + 3, y + 2, z + 3, amq.bc.cm, true);
        this.putBlockAndMetadata(x + 0, y + 3, z + 0, amq.bR.cm, 0, true);
        this.putBlockAndMetadata(x + 1, y + 3, z + 0, amq.bR.cm, 0, true);
        this.putBlockAndMetadata(x + 2, y + 3, z + 0, amq.bR.cm, 0, true);
        this.putBlockAndMetadata(x + 3, y + 3, z + 0, amq.bR.cm, 0, true);
        this.putBlockAndMetadata(x + 0, y + 3, z + 3, amq.bR.cm, 0, true);
        this.putBlockAndMetadata(x + 1, y + 3, z + 3, amq.bR.cm, 0, true);
        this.putBlockAndMetadata(x + 2, y + 3, z + 3, amq.bR.cm, 0, true);
        this.putBlockAndMetadata(x + 3, y + 3, z + 3, amq.bR.cm, 0, true);
        this.putBlockAndMetadata(x + 0, y + 3, z + 1, amq.bR.cm, 0, true);
        this.putBlockAndMetadata(x + 0, y + 3, z + 2, amq.bR.cm, 0, true);
        this.putBlockAndMetadata(x + 3, y + 3, z + 1, amq.bR.cm, 0, true);
        this.putBlockAndMetadata(x + 3, y + 3, z + 2, amq.bR.cm, 0, true);
        this.putBlock(x + 1, y + 3, z + 1, amq.A.cm, true);
        this.putBlock(x + 2, y + 3, z + 1, amq.A.cm, true);
        this.putBlock(x + 1, y + 3, z + 2, amq.A.cm, true);
        this.putBlock(x + 2, y + 3, z + 2, amq.A.cm, true);
        for (int dx = 1; dx <= 2; ++dx) {
            for (int dz = 1; dz <= 2; ++dz) {
                for (int dy = -1; dy >= -20; --dy) {
                    final int dblock = world.a(x + dx, y + dy, z + dz);
                    if (dblock != amq.y.cm && dblock != amq.x.cm && dblock != amq.I.cm && dblock != amq.w.cm) {
                        break;
                    }
                    if (!world.g(x + dx, y + dy - 1, z + dz).a()) {
                        break;
                    }
                    this.putBlock(x + dx, y + dy, z + dz, amq.E.cm, true);
                }
            }
        }
        return true;
    }
}
