// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.block.TFBlocks;
import java.util.Random;

public class TFGenFallenHollowLog extends TFGenerator
{
    @Override
    public boolean a(final abv world, final Random rand, final int x, final int y, final int z) {
        return rand.nextBoolean() ? this.makeLog4Z(world, rand, x, y, z) : this.makeLog4X(world, rand, x, y, z);
    }
    
    private boolean makeLog4Z(final abv world, final Random rand, final int x, final int y, final int z) {
        if (!this.isAreaClear(world, rand, x, y, z, 9, 3, 4)) {
            return false;
        }
        this.makeNegativeZJaggy(world, x, y, z, rand.nextInt(3), 0, 0);
        this.makeNegativeZJaggy(world, x, y, z, rand.nextInt(3), 3, 0);
        this.makeNegativeZJaggy(world, x, y, z, rand.nextInt(3), 0, 1);
        this.makeNegativeZJaggy(world, x, y, z, rand.nextInt(3), 3, 1);
        this.makeNegativeZJaggy(world, x, y, z, rand.nextInt(3), 1, 2);
        this.makeNegativeZJaggy(world, x, y, z, rand.nextInt(3), 2, 2);
        this.makePositiveZJaggy(world, x, y, z, rand.nextInt(3), 0, 0);
        this.makePositiveZJaggy(world, x, y, z, rand.nextInt(3), 3, 0);
        this.makePositiveZJaggy(world, x, y, z, rand.nextInt(3), 0, 1);
        this.makePositiveZJaggy(world, x, y, z, rand.nextInt(3), 3, 1);
        this.makePositiveZJaggy(world, x, y, z, rand.nextInt(3), 1, 2);
        this.makePositiveZJaggy(world, x, y, z, rand.nextInt(3), 2, 2);
        for (int dz = 0; dz < 4; ++dz) {
            if (rand.nextBoolean()) {
                this.a(world, x + 1, y - 1, z + dz + 3, TFBlocks.log.cF, 8);
                if (rand.nextBoolean()) {
                    this.a(world, x + 1, y + 0, z + dz + 3, TFBlocks.plant.cF, 3);
                }
            }
            else {
                this.a(world, x + 1, y - 1, z + dz + 3, aqw.A.cF, 0);
                this.a(world, x + 1, y + 0, z + dz + 3, TFBlocks.plant.cF, 3);
            }
            if (rand.nextBoolean()) {
                this.a(world, x + 2, y - 1, z + dz + 3, TFBlocks.log.cF, 8);
                if (rand.nextBoolean()) {
                    this.a(world, x + 2, y + 0, z + dz + 3, TFBlocks.plant.cF, 3);
                }
            }
            else {
                this.a(world, x + 2, y - 1, z + dz + 3, aqw.A.cF, 0);
                this.a(world, x + 2, y + 0, z + dz + 3, TFBlocks.plant.cF, 3);
            }
            this.a(world, x + 0, y + 0, z + dz + 3, TFBlocks.log.cF, 8);
            this.a(world, x + 3, y + 0, z + dz + 3, TFBlocks.log.cF, 8);
            this.a(world, x + 0, y + 1, z + dz + 3, TFBlocks.log.cF, 8);
            this.a(world, x + 3, y + 1, z + dz + 3, TFBlocks.log.cF, 8);
            this.a(world, x + 1, y + 2, z + dz + 3, TFBlocks.log.cF, 8);
            this.a(world, x + 2, y + 2, z + dz + 3, TFBlocks.log.cF, 8);
            if (rand.nextBoolean()) {
                this.a(world, x + 1, y + 3, z + dz + 3, TFBlocks.plant.cF, 3);
            }
            if (rand.nextBoolean()) {
                this.a(world, x + 2, y + 3, z + dz + 3, TFBlocks.plant.cF, 3);
            }
        }
        final int offZ = rand.nextInt(3) + 2;
        final boolean plusX = rand.nextBoolean();
        for (int dz2 = 0; dz2 < 3; ++dz2) {
            if (rand.nextBoolean()) {
                this.a(world, x + (plusX ? 3 : 0), y + 2, z + dz2 + offZ, TFBlocks.leaves.cF, 0);
                if (rand.nextBoolean()) {
                    this.a(world, x + (plusX ? 3 : 0), y + 3, z + dz2 + offZ, TFBlocks.leaves.cF, 0);
                }
                if (rand.nextBoolean()) {
                    this.a(world, x + (plusX ? 4 : -1), y + 2, z + dz2 + offZ, TFBlocks.leaves.cF, 0);
                }
            }
        }
        this.a(world, x + (plusX ? 0 : 3), y + 2, z + rand.nextInt(4) + 3, TFBlocks.firefly.cF, 0);
        return true;
    }
    
    private void makeNegativeZJaggy(final abv world, final int x, final int y, final int z, final int length, final int dx, final int dy) {
        for (int dz = -length; dz < 0; ++dz) {
            this.a(world, x + dx, y + dy, z + dz + 3, TFBlocks.log.cF, 8);
        }
    }
    
    private void makePositiveZJaggy(final abv world, final int x, final int y, final int z, final int length, final int dx, final int dy) {
        for (int dz = 0; dz < length; ++dz) {
            this.a(world, x + dx, y + dy, z + dz + 7, TFBlocks.log.cF, 8);
        }
    }
    
    private boolean makeLog4X(final abv world, final Random rand, final int x, final int y, final int z) {
        if (!this.isAreaClear(world, rand, x, y, z, 4, 3, 9)) {
            return false;
        }
        this.makeNegativeXJaggy(world, x, y, z, rand.nextInt(3), 0, 0);
        this.makeNegativeXJaggy(world, x, y, z, rand.nextInt(3), 3, 0);
        this.makeNegativeXJaggy(world, x, y, z, rand.nextInt(3), 0, 1);
        this.makeNegativeXJaggy(world, x, y, z, rand.nextInt(3), 3, 1);
        this.makeNegativeXJaggy(world, x, y, z, rand.nextInt(3), 1, 2);
        this.makeNegativeXJaggy(world, x, y, z, rand.nextInt(3), 2, 2);
        this.makePositiveXJaggy(world, x, y, z, rand.nextInt(3), 0, 0);
        this.makePositiveXJaggy(world, x, y, z, rand.nextInt(3), 3, 0);
        this.makePositiveXJaggy(world, x, y, z, rand.nextInt(3), 0, 1);
        this.makePositiveXJaggy(world, x, y, z, rand.nextInt(3), 3, 1);
        this.makePositiveXJaggy(world, x, y, z, rand.nextInt(3), 1, 2);
        this.makePositiveXJaggy(world, x, y, z, rand.nextInt(3), 2, 2);
        for (int dx = 0; dx < 4; ++dx) {
            if (rand.nextBoolean()) {
                this.a(world, x + dx + 3, y - 1, z + 1, TFBlocks.log.cF, 4);
                if (rand.nextBoolean()) {
                    this.a(world, x + dx + 3, y, z + 1, TFBlocks.plant.cF, 3);
                }
            }
            else {
                this.a(world, x + dx + 3, y - 1, z + 1, aqw.A.cF, 0);
                this.a(world, x + dx + 3, y, z + 1, TFBlocks.plant.cF, 3);
            }
            if (rand.nextBoolean()) {
                this.a(world, x + dx + 3, y - 1, z + 2, TFBlocks.log.cF, 4);
                if (rand.nextBoolean()) {
                    this.a(world, x + dx + 3, y, z + 2, TFBlocks.plant.cF, 3);
                }
            }
            else {
                this.a(world, x + dx + 3, y - 1, z + 2, aqw.A.cF, 0);
                this.a(world, x + dx + 3, y, z + 2, TFBlocks.plant.cF, 3);
            }
            this.a(world, x + dx + 3, y + 0, z + 0, TFBlocks.log.cF, 4);
            this.a(world, x + dx + 3, y + 0, z + 3, TFBlocks.log.cF, 4);
            this.a(world, x + dx + 3, y + 1, z + 0, TFBlocks.log.cF, 4);
            this.a(world, x + dx + 3, y + 1, z + 3, TFBlocks.log.cF, 4);
            this.a(world, x + dx + 3, y + 2, z + 1, TFBlocks.log.cF, 4);
            this.a(world, x + dx + 3, y + 2, z + 2, TFBlocks.log.cF, 4);
            if (rand.nextBoolean()) {
                this.a(world, x + dx + 3, y + 3, z + 1, TFBlocks.plant.cF, 3);
            }
            if (rand.nextBoolean()) {
                this.a(world, x + dx + 3, y + 3, z + 2, TFBlocks.plant.cF, 3);
            }
        }
        final int offX = rand.nextInt(3) + 2;
        final boolean plusZ = rand.nextBoolean();
        for (int dx2 = 0; dx2 < 3; ++dx2) {
            if (rand.nextBoolean()) {
                this.a(world, x + dx2 + offX, y + 2, z + (plusZ ? 3 : 0), TFBlocks.leaves.cF, 0);
                if (rand.nextBoolean()) {
                    this.a(world, x + dx2 + offX, y + 3, z + (plusZ ? 3 : 0), TFBlocks.leaves.cF, 0);
                }
                if (rand.nextBoolean()) {
                    this.a(world, x + dx2 + offX, y + 2, z + (plusZ ? 4 : -1), TFBlocks.leaves.cF, 0);
                }
            }
        }
        this.a(world, x + rand.nextInt(4) + 3, y + 2, z + (plusZ ? 0 : 3), TFBlocks.firefly.cF, 0);
        return true;
    }
    
    private void makeNegativeXJaggy(final abv world, final int x, final int y, final int z, final int length, final int dz, final int dy) {
        for (int dx = -length; dx < 0; ++dx) {
            this.a(world, x + 3 + dx, y + dy, z + dz, TFBlocks.log.cF, 4);
        }
    }
    
    private void makePositiveXJaggy(final abv world, final int x, final int y, final int z, final int length, final int dz, final int dy) {
        for (int dx = 0; dx < length; ++dx) {
            this.a(world, x + dx + 7, y + dy, z + dz, TFBlocks.log.cF, 4);
        }
    }
}
