// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.block.TFBlocks;
import java.util.Random;

public class TFGenFallenSmallLog extends TFGenerator
{
    @Override
    public boolean a(final abv world, final Random rand, final int x, final int y, final int z) {
        final boolean goingX = rand.nextBoolean();
        final int length = rand.nextInt(4) + 3;
        if (goingX) {
            if (!this.isAreaClear(world, rand, x, y, z, length, 3, 2)) {
                return false;
            }
        }
        else if (!this.isAreaClear(world, rand, x, y, z, 3, length, 2)) {
            return false;
        }
        switch (rand.nextInt(7)) {
            default: {
                final int logID = TFBlocks.log.cF;
                final int logMeta = 0;
            }
            case 1: {
                final int logID = TFBlocks.log.cF;
                final int logMeta = 1;
            }
            case 2: {
                final int logID = TFBlocks.log.cF;
                final int logMeta = 2;
            }
            case 3: {
                final int logID = aqw.O.cF;
                final int logMeta = 0;
            }
            case 4: {
                final int logID = aqw.O.cF;
                final int logMeta = 1;
            }
            case 5: {
                final int logID = aqw.O.cF;
                final int logMeta = 2;
            }
            case 6: {
                final int logID = aqw.O.cF;
                int logMetaBranch;
                int logMeta = logMetaBranch = 3;
                if (goingX) {
                    logMeta |= 0x4;
                    logMetaBranch |= 0x8;
                    for (int lx = 0; lx < length; ++lx) {
                        this.a(world, x + lx, y + 0, z + 1, logID, logMeta);
                        if (rand.nextInt(3) > 0) {
                            this.a(world, x + lx, y + 1, z + 1, TFBlocks.plant.cF, 3);
                        }
                    }
                }
                else {
                    logMeta |= 0x8;
                    logMetaBranch |= 0x4;
                    for (int lz = 0; lz < length; ++lz) {
                        this.a(world, x + 1, y + 0, z + lz, logID, logMeta);
                        if (rand.nextInt(3) > 0) {
                            this.a(world, x + 1, y + 1, z + lz, TFBlocks.plant.cF, 3);
                        }
                    }
                }
                if (rand.nextInt(3) > 0) {
                    if (goingX) {
                        final int bx = rand.nextInt(length);
                        final int bz = rand.nextBoolean() ? 2 : 0;
                        this.a(world, x + bx, y + 0, z + bz, logID, logMetaBranch);
                        if (rand.nextBoolean()) {
                            this.a(world, x + bx, y + 1, z + bz, TFBlocks.plant.cF, 3);
                        }
                    }
                    else {
                        final int bx = rand.nextBoolean() ? 2 : 0;
                        final int bz = rand.nextInt(length);
                        this.a(world, x + bx, y + 0, z + bz, logID, logMetaBranch);
                        if (rand.nextBoolean()) {
                            this.a(world, x + bx, y + 1, z + bz, TFBlocks.plant.cF, 3);
                        }
                    }
                }
                return true;
            }
        }
    }
}
