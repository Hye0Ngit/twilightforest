// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.TFTreasure;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.world.World;

public class TFGenWell extends TFGenerator
{
    public boolean func_76484_a(final World world, final Random rand, final int x, final int y, final int z) {
        if (rand.nextInt(4) == 0) {
            return this.generate4x4Well(world, rand, x, y, z);
        }
        return this.generate3x3Well(world, rand, x, y, z);
    }
    
    public boolean generate3x3Well(final World world, final Random rand, final int x, final int y, final int z) {
        if (!this.isAreaSuitable(world, rand, x, y, z, 3, 4, 3)) {
            return false;
        }
        this.setBlock(world, x + 0, y, z + 0, Blocks.field_150341_Y);
        this.setBlock(world, x + 1, y, z + 0, Blocks.field_150341_Y);
        this.setBlock(world, x + 2, y, z + 0, Blocks.field_150341_Y);
        this.setBlock(world, x + 0, y, z + 2, Blocks.field_150341_Y);
        this.setBlock(world, x + 1, y, z + 2, Blocks.field_150341_Y);
        this.setBlock(world, x + 2, y, z + 2, Blocks.field_150341_Y);
        this.setBlock(world, x + 0, y, z + 1, Blocks.field_150341_Y);
        this.setBlock(world, x + 2, y, z + 1, Blocks.field_150341_Y);
        this.setBlock(world, x + 1, y, z + 1, Blocks.field_150355_j);
        this.setBlock(world, x + 0, y + 1, z + 0, Blocks.field_150422_aJ);
        this.setBlock(world, x + 2, y + 1, z + 0, Blocks.field_150422_aJ);
        this.setBlock(world, x + 0, y + 1, z + 2, Blocks.field_150422_aJ);
        this.setBlock(world, x + 2, y + 1, z + 2, Blocks.field_150422_aJ);
        this.setBlock(world, x + 0, y + 2, z + 0, Blocks.field_150422_aJ);
        this.setBlock(world, x + 2, y + 2, z + 0, Blocks.field_150422_aJ);
        this.setBlock(world, x + 0, y + 2, z + 2, Blocks.field_150422_aJ);
        this.setBlock(world, x + 2, y + 2, z + 2, Blocks.field_150422_aJ);
        this.setBlockAndMetadata(world, x + 0, y + 3, z + 0, (Block)Blocks.field_150376_bx, 0);
        this.setBlockAndMetadata(world, x + 1, y + 3, z + 0, (Block)Blocks.field_150376_bx, 0);
        this.setBlockAndMetadata(world, x + 2, y + 3, z + 0, (Block)Blocks.field_150376_bx, 0);
        this.setBlockAndMetadata(world, x + 0, y + 3, z + 2, (Block)Blocks.field_150376_bx, 0);
        this.setBlockAndMetadata(world, x + 1, y + 3, z + 2, (Block)Blocks.field_150376_bx, 0);
        this.setBlockAndMetadata(world, x + 2, y + 3, z + 2, (Block)Blocks.field_150376_bx, 0);
        this.setBlockAndMetadata(world, x + 0, y + 3, z + 1, (Block)Blocks.field_150376_bx, 0);
        this.setBlockAndMetadata(world, x + 2, y + 3, z + 1, (Block)Blocks.field_150376_bx, 0);
        this.setBlock(world, x + 1, y + 3, z + 1, Blocks.field_150344_f);
        boolean madeTreasure = false;
        for (int dy = -1; dy >= -20; --dy) {
            final Block dblock = world.func_147439_a(x + 1, y + dy, z + 1);
            if (dblock != Blocks.field_150346_d && dblock != Blocks.field_150349_c && dblock != Blocks.field_150351_n && dblock != Blocks.field_150348_b) {
                break;
            }
            if (!world.func_147439_a(x + 1, y + dy - 1, z + 1).func_149688_o().func_76220_a()) {
                break;
            }
            this.setBlock(world, x + 1, y + dy, z + 1, Blocks.field_150355_j);
            if (dy < -15 && !madeTreasure && rand.nextInt(8) == 0) {
                this.setBlock(world, x + 2, y + dy, z + 1, Blocks.field_150355_j);
                this.setBlock(world, x + 3, y + dy + 1, z + 1, Blocks.field_150350_a);
                this.setBlock(world, x + 3, y + dy, z + 1, Blocks.field_150350_a);
                TFTreasure.basement.generate(world, rand, x + 3, y + dy, z + 1);
                madeTreasure = true;
            }
        }
        return true;
    }
    
    public boolean generate4x4Well(final World world, final Random rand, final int x, final int y, final int z) {
        if (!this.isAreaSuitable(world, rand, x, y, z, 4, 4, 4)) {
            return false;
        }
        this.setBlock(world, x + 0, y, z + 0, Blocks.field_150341_Y);
        this.setBlock(world, x + 1, y, z + 0, Blocks.field_150341_Y);
        this.setBlock(world, x + 2, y, z + 0, Blocks.field_150341_Y);
        this.setBlock(world, x + 3, y, z + 0, Blocks.field_150341_Y);
        this.setBlock(world, x + 0, y, z + 3, Blocks.field_150341_Y);
        this.setBlock(world, x + 1, y, z + 3, Blocks.field_150341_Y);
        this.setBlock(world, x + 2, y, z + 3, Blocks.field_150341_Y);
        this.setBlock(world, x + 3, y, z + 3, Blocks.field_150341_Y);
        this.setBlock(world, x + 0, y, z + 1, Blocks.field_150341_Y);
        this.setBlock(world, x + 0, y, z + 2, Blocks.field_150341_Y);
        this.setBlock(world, x + 3, y, z + 1, Blocks.field_150341_Y);
        this.setBlock(world, x + 3, y, z + 2, Blocks.field_150341_Y);
        this.setBlock(world, x + 1, y, z + 1, Blocks.field_150355_j);
        this.setBlock(world, x + 2, y, z + 1, Blocks.field_150355_j);
        this.setBlock(world, x + 1, y, z + 2, Blocks.field_150355_j);
        this.setBlock(world, x + 2, y, z + 2, Blocks.field_150355_j);
        this.setBlock(world, x + 0, y + 1, z + 0, Blocks.field_150422_aJ);
        this.setBlock(world, x + 3, y + 1, z + 0, Blocks.field_150422_aJ);
        this.setBlock(world, x + 0, y + 1, z + 3, Blocks.field_150422_aJ);
        this.setBlock(world, x + 3, y + 1, z + 3, Blocks.field_150422_aJ);
        this.setBlock(world, x + 0, y + 2, z + 0, Blocks.field_150422_aJ);
        this.setBlock(world, x + 3, y + 2, z + 0, Blocks.field_150422_aJ);
        this.setBlock(world, x + 0, y + 2, z + 3, Blocks.field_150422_aJ);
        this.setBlock(world, x + 3, y + 2, z + 3, Blocks.field_150422_aJ);
        this.setBlockAndMetadata(world, x + 0, y + 3, z + 0, (Block)Blocks.field_150376_bx, 0);
        this.setBlockAndMetadata(world, x + 1, y + 3, z + 0, (Block)Blocks.field_150376_bx, 0);
        this.setBlockAndMetadata(world, x + 2, y + 3, z + 0, (Block)Blocks.field_150376_bx, 0);
        this.setBlockAndMetadata(world, x + 3, y + 3, z + 0, (Block)Blocks.field_150376_bx, 0);
        this.setBlockAndMetadata(world, x + 0, y + 3, z + 3, (Block)Blocks.field_150376_bx, 0);
        this.setBlockAndMetadata(world, x + 1, y + 3, z + 3, (Block)Blocks.field_150376_bx, 0);
        this.setBlockAndMetadata(world, x + 2, y + 3, z + 3, (Block)Blocks.field_150376_bx, 0);
        this.setBlockAndMetadata(world, x + 3, y + 3, z + 3, (Block)Blocks.field_150376_bx, 0);
        this.setBlockAndMetadata(world, x + 0, y + 3, z + 1, (Block)Blocks.field_150376_bx, 0);
        this.setBlockAndMetadata(world, x + 0, y + 3, z + 2, (Block)Blocks.field_150376_bx, 0);
        this.setBlockAndMetadata(world, x + 3, y + 3, z + 1, (Block)Blocks.field_150376_bx, 0);
        this.setBlockAndMetadata(world, x + 3, y + 3, z + 2, (Block)Blocks.field_150376_bx, 0);
        this.setBlock(world, x + 1, y + 3, z + 1, Blocks.field_150344_f);
        this.setBlock(world, x + 2, y + 3, z + 1, Blocks.field_150344_f);
        this.setBlock(world, x + 1, y + 3, z + 2, Blocks.field_150344_f);
        this.setBlock(world, x + 2, y + 3, z + 2, Blocks.field_150344_f);
        for (int dx = 1; dx <= 2; ++dx) {
            for (int dz = 1; dz <= 2; ++dz) {
                for (int dy = -1; dy >= -20; --dy) {
                    final Block dblock = world.func_147439_a(x + dx, y + dy, z + dz);
                    if (dblock != Blocks.field_150346_d && dblock != Blocks.field_150349_c && dblock != Blocks.field_150351_n && dblock != Blocks.field_150348_b) {
                        break;
                    }
                    if (!world.func_147439_a(x + dx, y + dy - 1, z + dz).func_149688_o().func_76220_a()) {
                        break;
                    }
                    this.setBlock(world, x + dx, y + dy, z + dz, Blocks.field_150355_j);
                }
            }
        }
        return true;
    }
}
