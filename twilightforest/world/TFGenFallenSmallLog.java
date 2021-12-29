// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import twilightforest.block.TFBlocks;
import java.util.Random;
import net.minecraft.world.World;

public class TFGenFallenSmallLog extends TFGenerator
{
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
                final Block logID = TFBlocks.log;
                final int logMeta = 0;
            }
            case 1: {
                final Block logID = TFBlocks.log;
                final int logMeta = 1;
            }
            case 2: {
                final Block logID = TFBlocks.log;
                final int logMeta = 2;
            }
            case 3: {
                final Block logID = Blocks.field_150364_r;
                final int logMeta = 0;
            }
            case 4: {
                final Block logID = Blocks.field_150364_r;
                final int logMeta = 1;
            }
            case 5: {
                final Block logID = Blocks.field_150364_r;
                final int logMeta = 2;
            }
            case 6: {
                final Block logID = Blocks.field_150364_r;
                int logMetaBranch;
                int logMeta = logMetaBranch = 3;
                if (goingX) {
                    logMeta |= 0x4;
                    logMetaBranch |= 0x8;
                    for (int lx = 0; lx < length; ++lx) {
                        this.setBlockAndMetadata(world, x + lx, y + 0, z + 1, logID, logMeta);
                        if (rand.nextInt(3) > 0) {
                            this.setBlockAndMetadata(world, x + lx, y + 1, z + 1, TFBlocks.plant, 3);
                        }
                    }
                }
                else {
                    logMeta |= 0x8;
                    logMetaBranch |= 0x4;
                    for (int lz = 0; lz < length; ++lz) {
                        this.setBlockAndMetadata(world, x + 1, y + 0, z + lz, logID, logMeta);
                        if (rand.nextInt(3) > 0) {
                            this.setBlockAndMetadata(world, x + 1, y + 1, z + lz, TFBlocks.plant, 3);
                        }
                    }
                }
                if (rand.nextInt(3) > 0) {
                    if (goingX) {
                        final int bx = rand.nextInt(length);
                        final int bz = rand.nextBoolean() ? 2 : 0;
                        this.setBlockAndMetadata(world, x + bx, y + 0, z + bz, logID, logMetaBranch);
                        if (rand.nextBoolean()) {
                            this.setBlockAndMetadata(world, x + bx, y + 1, z + bz, TFBlocks.plant, 3);
                        }
                    }
                    else {
                        final int bx = rand.nextBoolean() ? 2 : 0;
                        final int bz = rand.nextInt(length);
                        this.setBlockAndMetadata(world, x + bx, y + 0, z + bz, logID, logMetaBranch);
                        if (rand.nextBoolean()) {
                            this.setBlockAndMetadata(world, x + bx, y + 1, z + bz, TFBlocks.plant, 3);
                        }
                    }
                }
                return true;
            }
        }
    }
}
