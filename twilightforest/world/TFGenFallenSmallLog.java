// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.block.Block;
import twilightforest.block.TFBlocks;
import java.util.Random;
import net.minecraft.world.World;

public class TFGenFallenSmallLog extends TFGenerator
{
    @Override
    public boolean func_76484_a(final World world, final Random rand, final int x, final int y, final int z) {
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
                final int logID = TFBlocks.log.field_71990_ca;
                final int logMeta = 0;
            }
            case 1: {
                final int logID = TFBlocks.log.field_71990_ca;
                final int logMeta = 1;
            }
            case 2: {
                final int logID = TFBlocks.log.field_71990_ca;
                final int logMeta = 2;
            }
            case 3: {
                final int logID = Block.field_71951_J.field_71990_ca;
                final int logMeta = 0;
            }
            case 4: {
                final int logID = Block.field_71951_J.field_71990_ca;
                final int logMeta = 1;
            }
            case 5: {
                final int logID = Block.field_71951_J.field_71990_ca;
                final int logMeta = 2;
            }
            case 6: {
                final int logID = Block.field_71951_J.field_71990_ca;
                int logMetaBranch;
                int logMeta = logMetaBranch = 3;
                if (goingX) {
                    logMeta |= 0x4;
                    logMetaBranch |= 0x8;
                    for (int lx = 0; lx < length; ++lx) {
                        this.func_76485_a(world, x + lx, y + 0, z + 1, logID, logMeta);
                        if (rand.nextInt(3) > 0) {
                            this.func_76485_a(world, x + lx, y + 1, z + 1, TFBlocks.plant.field_71990_ca, 3);
                        }
                    }
                }
                else {
                    logMeta |= 0x8;
                    logMetaBranch |= 0x4;
                    for (int lz = 0; lz < length; ++lz) {
                        this.func_76485_a(world, x + 1, y + 0, z + lz, logID, logMeta);
                        if (rand.nextInt(3) > 0) {
                            this.func_76485_a(world, x + 1, y + 1, z + lz, TFBlocks.plant.field_71990_ca, 3);
                        }
                    }
                }
                if (rand.nextInt(3) > 0) {
                    if (goingX) {
                        final int bx = rand.nextInt(length);
                        final int bz = rand.nextBoolean() ? 2 : 0;
                        this.func_76485_a(world, x + bx, y + 0, z + bz, logID, logMetaBranch);
                        if (rand.nextBoolean()) {
                            this.func_76485_a(world, x + bx, y + 1, z + bz, TFBlocks.plant.field_71990_ca, 3);
                        }
                    }
                    else {
                        final int bx = rand.nextBoolean() ? 2 : 0;
                        final int bz = rand.nextInt(length);
                        this.func_76485_a(world, x + bx, y + 0, z + bz, logID, logMetaBranch);
                        if (rand.nextBoolean()) {
                            this.func_76485_a(world, x + bx, y + 1, z + bz, TFBlocks.plant.field_71990_ca, 3);
                        }
                    }
                }
                return true;
            }
        }
    }
}
