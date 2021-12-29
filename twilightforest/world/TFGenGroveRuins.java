// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import java.util.Random;

public class TFGenGroveRuins extends TFGenerator
{
    @Override
    public boolean a(final abv world, final Random rand, final int x, final int y, final int z) {
        if (rand.nextBoolean()) {
            return this.generateLargeArch(world, rand, x, y, z);
        }
        return this.generateSmallArch(world, rand, x, y, z);
    }
    
    private boolean generateLargeArch(final abv world, final Random rand, final int x, final int y, final int z) {
        if (!this.isAreaClear(world, rand, x, y, z, 2, 7, 6)) {
            return false;
        }
        for (int dy = -2; dy <= 7; ++dy) {
            this.a(world, x + 0, y + dy, z + 1, aqw.br.cF, 1);
            this.a(world, x + 1, y + dy, z + 1, aqw.br.cF, 1);
            this.a(world, x + 0, y + dy, z + 2, aqw.br.cF, 1);
            this.a(world, x + 1, y + dy, z + 2, aqw.br.cF, 1);
        }
        this.a(world, x + 0, y - 1, z + 3, aqw.br.cF, 1);
        this.a(world, x + 1, y - 1, z + 3, aqw.br.cF, 1);
        this.a(world, x + 0, y - 2, z + 3, aqw.br.cF, 1);
        this.a(world, x + 1, y - 2, z + 3, aqw.br.cF, 1);
        this.a(world, x + 0, y - 1, z + 4, aqw.br.cF, 1);
        this.a(world, x + 1, y - 1, z + 4, aqw.br.cF, 1);
        this.a(world, x + 0, y - 2, z + 4, aqw.br.cF, 1);
        this.a(world, x + 1, y - 2, z + 4, aqw.br.cF, 1);
        this.a(world, x + 0, y - 1, z + 5, aqw.br.cF, 1);
        this.a(world, x + 1, y - 2, z + 5, aqw.br.cF, 1);
        this.a(world, x + 0, y + 6, z + 3, aqw.br.cF, 1);
        this.a(world, x + 1, y + 6, z + 3, aqw.br.cF, 1);
        this.a(world, x + 0, y + 7, z + 3, aqw.br.cF, 1);
        this.a(world, x + 1, y + 7, z + 3, aqw.br.cF, 1);
        this.a(world, x + 0, y + 6, z + 4, aqw.br.cF, 1);
        this.a(world, x + 1, y + 6, z + 4, aqw.br.cF, 1);
        this.a(world, x + 0, y + 7, z + 4, aqw.br.cF, 1);
        this.a(world, x + 1, y + 7, z + 4, aqw.br.cF, 1);
        this.a(world, x + 1, y + 7, z + 5, aqw.br.cF, 1);
        this.a(world, x + 0, y + 5, z + 0, aqw.br.cF, 3);
        return true;
    }
    
    private boolean generateSmallArch(final abv world, final Random rand, final int x, final int y, final int z) {
        if (!this.isAreaClear(world, rand, x, y, z, 7, 5, 9)) {
            return false;
        }
        this.a(world, x + 0, y + 4, z + 0, aqw.br.cF, 3);
        this.a(world, x + 0, y + 3, z + 0, aqw.br.cF, 3);
        this.a(world, x + 1, y + 4, z + 0, aqw.br.cF, 3);
        this.a(world, x + 2, y + 4, z + 0, aqw.br.cF, 3);
        this.a(world, x + 0, y + 4, z + 1, aqw.br.cF, 3);
        this.a(world, x + 0, y + 4, z + 2, aqw.br.cF, 3);
        for (int dy = -1; dy <= 5; ++dy) {
            this.a(world, x + 3, y + dy, z + 0, aqw.br.cF, 1);
        }
        this.a(world, x + 4, y - 1, z + 0, aqw.br.cF, 1);
        this.a(world, x + 5, y - 1, z + 0, aqw.br.cF, 1);
        this.a(world, x + 6, y - 1, z + 0, aqw.br.cF, 1);
        this.a(world, x + 4, y + 5, z + 0, aqw.br.cF, 1);
        this.a(world, x + 5, y + 5, z + 0, aqw.br.cF, 1);
        for (int dy = -1; dy <= 5; ++dy) {
            this.a(world, x + 0, y + dy, z + 3, aqw.br.cF, 1);
            this.a(world, x + 0, y + dy, z + 7, aqw.br.cF, 1);
        }
        for (int dz = 4; dz < 7; ++dz) {
            this.a(world, x + 0, y - 1, z + dz, aqw.br.cF, 1);
            this.a(world, x + 0, y + 5, z + dz, aqw.br.cF, 1);
        }
        this.a(world, x + 0, y + 4, z + 8, aqw.br.cF, 3);
        return true;
    }
}
