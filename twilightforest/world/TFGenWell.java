// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.TFTreasure;
import java.util.Random;

public class TFGenWell extends TFGenerator
{
    @Override
    public boolean a(final zv world, final Random rand, final int x, final int y, final int z) {
        if (rand.nextInt(4) == 0) {
            return this.generate4x4Well(world, rand, x, y, z);
        }
        return this.generate3x3Well(world, rand, x, y, z);
    }
    
    public boolean generate3x3Well(final zv world, final Random rand, final int x, final int y, final int z) {
        if (!this.isAreaClear(world, rand, x, y, z, 3, 4, 3)) {
            return false;
        }
        this.putBlock(world, x + 0, y, z + 0, aou.as.cz, true);
        this.putBlock(world, x + 1, y, z + 0, aou.as.cz, true);
        this.putBlock(world, x + 2, y, z + 0, aou.as.cz, true);
        this.putBlock(world, x + 0, y, z + 2, aou.as.cz, true);
        this.putBlock(world, x + 1, y, z + 2, aou.as.cz, true);
        this.putBlock(world, x + 2, y, z + 2, aou.as.cz, true);
        this.putBlock(world, x + 0, y, z + 1, aou.as.cz, true);
        this.putBlock(world, x + 2, y, z + 1, aou.as.cz, true);
        this.putBlock(world, x + 1, y, z + 1, aou.F.cz, true);
        this.putBlock(world, x + 0, y + 1, z + 0, aou.bd.cz, true);
        this.putBlock(world, x + 2, y + 1, z + 0, aou.bd.cz, true);
        this.putBlock(world, x + 0, y + 1, z + 2, aou.bd.cz, true);
        this.putBlock(world, x + 2, y + 1, z + 2, aou.bd.cz, true);
        this.putBlock(world, x + 0, y + 2, z + 0, aou.bd.cz, true);
        this.putBlock(world, x + 2, y + 2, z + 0, aou.bd.cz, true);
        this.putBlock(world, x + 0, y + 2, z + 2, aou.bd.cz, true);
        this.putBlock(world, x + 2, y + 2, z + 2, aou.bd.cz, true);
        this.putBlockAndMetadata(world, x + 0, y + 3, z + 0, aou.bS.cz, 0, true);
        this.putBlockAndMetadata(world, x + 1, y + 3, z + 0, aou.bS.cz, 0, true);
        this.putBlockAndMetadata(world, x + 2, y + 3, z + 0, aou.bS.cz, 0, true);
        this.putBlockAndMetadata(world, x + 0, y + 3, z + 2, aou.bS.cz, 0, true);
        this.putBlockAndMetadata(world, x + 1, y + 3, z + 2, aou.bS.cz, 0, true);
        this.putBlockAndMetadata(world, x + 2, y + 3, z + 2, aou.bS.cz, 0, true);
        this.putBlockAndMetadata(world, x + 0, y + 3, z + 1, aou.bS.cz, 0, true);
        this.putBlockAndMetadata(world, x + 2, y + 3, z + 1, aou.bS.cz, 0, true);
        this.putBlock(world, x + 1, y + 3, z + 1, aou.B.cz, true);
        boolean madeTreasure = false;
        for (int dy = -1; dy >= -20; --dy) {
            final int dblock = world.a(x + 1, y + dy, z + 1);
            if (dblock != aou.z.cz && dblock != aou.y.cz && dblock != aou.J.cz && dblock != aou.x.cz) {
                break;
            }
            if (!world.g(x + 1, y + dy - 1, z + 1).a()) {
                break;
            }
            this.putBlock(world, x + 1, y + dy, z + 1, aou.F.cz, true);
            if (dy < -15 && !madeTreasure && rand.nextInt(8) == 0) {
                this.putBlock(world, x + 2, y + dy, z + 1, aou.F.cz, true);
                this.putBlock(world, x + 3, y + dy + 1, z + 1, 0, true);
                this.putBlock(world, x + 3, y + dy, z + 1, 0, true);
                TFTreasure.basement.generate(world, rand, x + 3, y + dy, z + 1);
                madeTreasure = true;
            }
        }
        return true;
    }
    
    public boolean generate4x4Well(final zv world, final Random rand, final int x, final int y, final int z) {
        if (!this.isAreaClear(world, rand, x, y, z, 4, 4, 4)) {
            return false;
        }
        this.putBlock(world, x + 0, y, z + 0, aou.as.cz, true);
        this.putBlock(world, x + 1, y, z + 0, aou.as.cz, true);
        this.putBlock(world, x + 2, y, z + 0, aou.as.cz, true);
        this.putBlock(world, x + 3, y, z + 0, aou.as.cz, true);
        this.putBlock(world, x + 0, y, z + 3, aou.as.cz, true);
        this.putBlock(world, x + 1, y, z + 3, aou.as.cz, true);
        this.putBlock(world, x + 2, y, z + 3, aou.as.cz, true);
        this.putBlock(world, x + 3, y, z + 3, aou.as.cz, true);
        this.putBlock(world, x + 0, y, z + 1, aou.as.cz, true);
        this.putBlock(world, x + 0, y, z + 2, aou.as.cz, true);
        this.putBlock(world, x + 3, y, z + 1, aou.as.cz, true);
        this.putBlock(world, x + 3, y, z + 2, aou.as.cz, true);
        this.putBlock(world, x + 1, y, z + 1, aou.F.cz, true);
        this.putBlock(world, x + 2, y, z + 1, aou.F.cz, true);
        this.putBlock(world, x + 1, y, z + 2, aou.F.cz, true);
        this.putBlock(world, x + 2, y, z + 2, aou.F.cz, true);
        this.putBlock(world, x + 0, y + 1, z + 0, aou.bd.cz, true);
        this.putBlock(world, x + 3, y + 1, z + 0, aou.bd.cz, true);
        this.putBlock(world, x + 0, y + 1, z + 3, aou.bd.cz, true);
        this.putBlock(world, x + 3, y + 1, z + 3, aou.bd.cz, true);
        this.putBlock(world, x + 0, y + 2, z + 0, aou.bd.cz, true);
        this.putBlock(world, x + 3, y + 2, z + 0, aou.bd.cz, true);
        this.putBlock(world, x + 0, y + 2, z + 3, aou.bd.cz, true);
        this.putBlock(world, x + 3, y + 2, z + 3, aou.bd.cz, true);
        this.putBlockAndMetadata(world, x + 0, y + 3, z + 0, aou.bS.cz, 0, true);
        this.putBlockAndMetadata(world, x + 1, y + 3, z + 0, aou.bS.cz, 0, true);
        this.putBlockAndMetadata(world, x + 2, y + 3, z + 0, aou.bS.cz, 0, true);
        this.putBlockAndMetadata(world, x + 3, y + 3, z + 0, aou.bS.cz, 0, true);
        this.putBlockAndMetadata(world, x + 0, y + 3, z + 3, aou.bS.cz, 0, true);
        this.putBlockAndMetadata(world, x + 1, y + 3, z + 3, aou.bS.cz, 0, true);
        this.putBlockAndMetadata(world, x + 2, y + 3, z + 3, aou.bS.cz, 0, true);
        this.putBlockAndMetadata(world, x + 3, y + 3, z + 3, aou.bS.cz, 0, true);
        this.putBlockAndMetadata(world, x + 0, y + 3, z + 1, aou.bS.cz, 0, true);
        this.putBlockAndMetadata(world, x + 0, y + 3, z + 2, aou.bS.cz, 0, true);
        this.putBlockAndMetadata(world, x + 3, y + 3, z + 1, aou.bS.cz, 0, true);
        this.putBlockAndMetadata(world, x + 3, y + 3, z + 2, aou.bS.cz, 0, true);
        this.putBlock(world, x + 1, y + 3, z + 1, aou.B.cz, true);
        this.putBlock(world, x + 2, y + 3, z + 1, aou.B.cz, true);
        this.putBlock(world, x + 1, y + 3, z + 2, aou.B.cz, true);
        this.putBlock(world, x + 2, y + 3, z + 2, aou.B.cz, true);
        for (int dx = 1; dx <= 2; ++dx) {
            for (int dz = 1; dz <= 2; ++dz) {
                for (int dy = -1; dy >= -20; --dy) {
                    final int dblock = world.a(x + dx, y + dy, z + dz);
                    if (dblock != aou.z.cz && dblock != aou.y.cz && dblock != aou.J.cz && dblock != aou.x.cz) {
                        break;
                    }
                    if (!world.g(x + dx, y + dy - 1, z + dz).a()) {
                        break;
                    }
                    this.putBlock(world, x + dx, y + dy, z + dz, aou.F.cz, true);
                }
            }
        }
        return true;
    }
}
