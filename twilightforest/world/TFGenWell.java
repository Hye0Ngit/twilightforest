// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.TFTreasure;
import java.util.Random;

public class TFGenWell extends TFGenerator
{
    @Override
    public boolean a(final abv world, final Random rand, final int x, final int y, final int z) {
        if (rand.nextInt(4) == 0) {
            return this.generate4x4Well(world, rand, x, y, z);
        }
        return this.generate3x3Well(world, rand, x, y, z);
    }
    
    public boolean generate3x3Well(final abv world, final Random rand, final int x, final int y, final int z) {
        if (!this.isAreaClear(world, rand, x, y, z, 3, 4, 3)) {
            return false;
        }
        this.putBlock(world, x + 0, y, z + 0, aqw.at.cF, true);
        this.putBlock(world, x + 1, y, z + 0, aqw.at.cF, true);
        this.putBlock(world, x + 2, y, z + 0, aqw.at.cF, true);
        this.putBlock(world, x + 0, y, z + 2, aqw.at.cF, true);
        this.putBlock(world, x + 1, y, z + 2, aqw.at.cF, true);
        this.putBlock(world, x + 2, y, z + 2, aqw.at.cF, true);
        this.putBlock(world, x + 0, y, z + 1, aqw.at.cF, true);
        this.putBlock(world, x + 2, y, z + 1, aqw.at.cF, true);
        this.putBlock(world, x + 1, y, z + 1, aqw.G.cF, true);
        this.putBlock(world, x + 0, y + 1, z + 0, aqw.be.cF, true);
        this.putBlock(world, x + 2, y + 1, z + 0, aqw.be.cF, true);
        this.putBlock(world, x + 0, y + 1, z + 2, aqw.be.cF, true);
        this.putBlock(world, x + 2, y + 1, z + 2, aqw.be.cF, true);
        this.putBlock(world, x + 0, y + 2, z + 0, aqw.be.cF, true);
        this.putBlock(world, x + 2, y + 2, z + 0, aqw.be.cF, true);
        this.putBlock(world, x + 0, y + 2, z + 2, aqw.be.cF, true);
        this.putBlock(world, x + 2, y + 2, z + 2, aqw.be.cF, true);
        this.putBlockAndMetadata(world, x + 0, y + 3, z + 0, aqw.bT.cF, 0, true);
        this.putBlockAndMetadata(world, x + 1, y + 3, z + 0, aqw.bT.cF, 0, true);
        this.putBlockAndMetadata(world, x + 2, y + 3, z + 0, aqw.bT.cF, 0, true);
        this.putBlockAndMetadata(world, x + 0, y + 3, z + 2, aqw.bT.cF, 0, true);
        this.putBlockAndMetadata(world, x + 1, y + 3, z + 2, aqw.bT.cF, 0, true);
        this.putBlockAndMetadata(world, x + 2, y + 3, z + 2, aqw.bT.cF, 0, true);
        this.putBlockAndMetadata(world, x + 0, y + 3, z + 1, aqw.bT.cF, 0, true);
        this.putBlockAndMetadata(world, x + 2, y + 3, z + 1, aqw.bT.cF, 0, true);
        this.putBlock(world, x + 1, y + 3, z + 1, aqw.C.cF, true);
        boolean madeTreasure = false;
        for (int dy = -1; dy >= -20; --dy) {
            final int dblock = world.a(x + 1, y + dy, z + 1);
            if (dblock != aqw.A.cF && dblock != aqw.z.cF && dblock != aqw.K.cF && dblock != aqw.y.cF) {
                break;
            }
            if (!world.g(x + 1, y + dy - 1, z + 1).a()) {
                break;
            }
            this.putBlock(world, x + 1, y + dy, z + 1, aqw.G.cF, true);
            if (dy < -15 && !madeTreasure && rand.nextInt(8) == 0) {
                this.putBlock(world, x + 2, y + dy, z + 1, aqw.G.cF, true);
                this.putBlock(world, x + 3, y + dy + 1, z + 1, 0, true);
                this.putBlock(world, x + 3, y + dy, z + 1, 0, true);
                TFTreasure.basement.generate(world, rand, x + 3, y + dy, z + 1);
                madeTreasure = true;
            }
        }
        return true;
    }
    
    public boolean generate4x4Well(final abv world, final Random rand, final int x, final int y, final int z) {
        if (!this.isAreaClear(world, rand, x, y, z, 4, 4, 4)) {
            return false;
        }
        this.putBlock(world, x + 0, y, z + 0, aqw.at.cF, true);
        this.putBlock(world, x + 1, y, z + 0, aqw.at.cF, true);
        this.putBlock(world, x + 2, y, z + 0, aqw.at.cF, true);
        this.putBlock(world, x + 3, y, z + 0, aqw.at.cF, true);
        this.putBlock(world, x + 0, y, z + 3, aqw.at.cF, true);
        this.putBlock(world, x + 1, y, z + 3, aqw.at.cF, true);
        this.putBlock(world, x + 2, y, z + 3, aqw.at.cF, true);
        this.putBlock(world, x + 3, y, z + 3, aqw.at.cF, true);
        this.putBlock(world, x + 0, y, z + 1, aqw.at.cF, true);
        this.putBlock(world, x + 0, y, z + 2, aqw.at.cF, true);
        this.putBlock(world, x + 3, y, z + 1, aqw.at.cF, true);
        this.putBlock(world, x + 3, y, z + 2, aqw.at.cF, true);
        this.putBlock(world, x + 1, y, z + 1, aqw.G.cF, true);
        this.putBlock(world, x + 2, y, z + 1, aqw.G.cF, true);
        this.putBlock(world, x + 1, y, z + 2, aqw.G.cF, true);
        this.putBlock(world, x + 2, y, z + 2, aqw.G.cF, true);
        this.putBlock(world, x + 0, y + 1, z + 0, aqw.be.cF, true);
        this.putBlock(world, x + 3, y + 1, z + 0, aqw.be.cF, true);
        this.putBlock(world, x + 0, y + 1, z + 3, aqw.be.cF, true);
        this.putBlock(world, x + 3, y + 1, z + 3, aqw.be.cF, true);
        this.putBlock(world, x + 0, y + 2, z + 0, aqw.be.cF, true);
        this.putBlock(world, x + 3, y + 2, z + 0, aqw.be.cF, true);
        this.putBlock(world, x + 0, y + 2, z + 3, aqw.be.cF, true);
        this.putBlock(world, x + 3, y + 2, z + 3, aqw.be.cF, true);
        this.putBlockAndMetadata(world, x + 0, y + 3, z + 0, aqw.bT.cF, 0, true);
        this.putBlockAndMetadata(world, x + 1, y + 3, z + 0, aqw.bT.cF, 0, true);
        this.putBlockAndMetadata(world, x + 2, y + 3, z + 0, aqw.bT.cF, 0, true);
        this.putBlockAndMetadata(world, x + 3, y + 3, z + 0, aqw.bT.cF, 0, true);
        this.putBlockAndMetadata(world, x + 0, y + 3, z + 3, aqw.bT.cF, 0, true);
        this.putBlockAndMetadata(world, x + 1, y + 3, z + 3, aqw.bT.cF, 0, true);
        this.putBlockAndMetadata(world, x + 2, y + 3, z + 3, aqw.bT.cF, 0, true);
        this.putBlockAndMetadata(world, x + 3, y + 3, z + 3, aqw.bT.cF, 0, true);
        this.putBlockAndMetadata(world, x + 0, y + 3, z + 1, aqw.bT.cF, 0, true);
        this.putBlockAndMetadata(world, x + 0, y + 3, z + 2, aqw.bT.cF, 0, true);
        this.putBlockAndMetadata(world, x + 3, y + 3, z + 1, aqw.bT.cF, 0, true);
        this.putBlockAndMetadata(world, x + 3, y + 3, z + 2, aqw.bT.cF, 0, true);
        this.putBlock(world, x + 1, y + 3, z + 1, aqw.C.cF, true);
        this.putBlock(world, x + 2, y + 3, z + 1, aqw.C.cF, true);
        this.putBlock(world, x + 1, y + 3, z + 2, aqw.C.cF, true);
        this.putBlock(world, x + 2, y + 3, z + 2, aqw.C.cF, true);
        for (int dx = 1; dx <= 2; ++dx) {
            for (int dz = 1; dz <= 2; ++dz) {
                for (int dy = -1; dy >= -20; --dy) {
                    final int dblock = world.a(x + dx, y + dy, z + dz);
                    if (dblock != aqw.A.cF && dblock != aqw.z.cF && dblock != aqw.K.cF && dblock != aqw.y.cF) {
                        break;
                    }
                    if (!world.g(x + dx, y + dy - 1, z + dz).a()) {
                        break;
                    }
                    this.putBlock(world, x + dx, y + dy, z + dz, aqw.G.cF, true);
                }
            }
        }
        return true;
    }
}
