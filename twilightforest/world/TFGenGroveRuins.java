// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.world.World;

public class TFGenGroveRuins extends TFGenerator
{
    public boolean func_76484_a(final World world, final Random rand, final int x, final int y, final int z) {
        if (rand.nextBoolean()) {
            return this.generateLargeArch(world, rand, x, y, z);
        }
        return this.generateSmallArch(world, rand, x, y, z);
    }
    
    private boolean generateLargeArch(final World world, final Random rand, final int x, final int y, final int z) {
        if (!this.isAreaSuitable(world, rand, x, y, z, 2, 7, 6)) {
            return false;
        }
        for (int dy = -2; dy <= 7; ++dy) {
            this.setBlockAndMetadata(world, x + 0, y + dy, z + 1, Blocks.field_150417_aV, 1);
            this.setBlockAndMetadata(world, x + 1, y + dy, z + 1, Blocks.field_150417_aV, 1);
            this.setBlockAndMetadata(world, x + 0, y + dy, z + 2, Blocks.field_150417_aV, 1);
            this.setBlockAndMetadata(world, x + 1, y + dy, z + 2, Blocks.field_150417_aV, 1);
        }
        this.setBlockAndMetadata(world, x + 0, y - 1, z + 3, Blocks.field_150417_aV, 1);
        this.setBlockAndMetadata(world, x + 1, y - 1, z + 3, Blocks.field_150417_aV, 1);
        this.setBlockAndMetadata(world, x + 0, y - 2, z + 3, Blocks.field_150417_aV, 1);
        this.setBlockAndMetadata(world, x + 1, y - 2, z + 3, Blocks.field_150417_aV, 1);
        this.setBlockAndMetadata(world, x + 0, y - 1, z + 4, Blocks.field_150417_aV, 1);
        this.setBlockAndMetadata(world, x + 1, y - 1, z + 4, Blocks.field_150417_aV, 1);
        this.setBlockAndMetadata(world, x + 0, y - 2, z + 4, Blocks.field_150417_aV, 1);
        this.setBlockAndMetadata(world, x + 1, y - 2, z + 4, Blocks.field_150417_aV, 1);
        this.setBlockAndMetadata(world, x + 0, y - 1, z + 5, Blocks.field_150417_aV, 1);
        this.setBlockAndMetadata(world, x + 1, y - 2, z + 5, Blocks.field_150417_aV, 1);
        this.setBlockAndMetadata(world, x + 0, y + 6, z + 3, Blocks.field_150417_aV, 1);
        this.setBlockAndMetadata(world, x + 1, y + 6, z + 3, Blocks.field_150417_aV, 1);
        this.setBlockAndMetadata(world, x + 0, y + 7, z + 3, Blocks.field_150417_aV, 1);
        this.setBlockAndMetadata(world, x + 1, y + 7, z + 3, Blocks.field_150417_aV, 1);
        this.setBlockAndMetadata(world, x + 0, y + 6, z + 4, Blocks.field_150417_aV, 1);
        this.setBlockAndMetadata(world, x + 1, y + 6, z + 4, Blocks.field_150417_aV, 1);
        this.setBlockAndMetadata(world, x + 0, y + 7, z + 4, Blocks.field_150417_aV, 1);
        this.setBlockAndMetadata(world, x + 1, y + 7, z + 4, Blocks.field_150417_aV, 1);
        this.setBlockAndMetadata(world, x + 1, y + 7, z + 5, Blocks.field_150417_aV, 1);
        this.setBlockAndMetadata(world, x + 0, y + 5, z + 0, Blocks.field_150417_aV, 3);
        return true;
    }
    
    private boolean generateSmallArch(final World world, final Random rand, final int x, final int y, final int z) {
        if (!this.isAreaSuitable(world, rand, x, y, z, 7, 5, 9)) {
            return false;
        }
        this.setBlockAndMetadata(world, x + 0, y + 4, z + 0, Blocks.field_150417_aV, 3);
        this.setBlockAndMetadata(world, x + 0, y + 3, z + 0, Blocks.field_150417_aV, 3);
        this.setBlockAndMetadata(world, x + 1, y + 4, z + 0, Blocks.field_150417_aV, 3);
        this.setBlockAndMetadata(world, x + 2, y + 4, z + 0, Blocks.field_150417_aV, 3);
        this.setBlockAndMetadata(world, x + 0, y + 4, z + 1, Blocks.field_150417_aV, 3);
        this.setBlockAndMetadata(world, x + 0, y + 4, z + 2, Blocks.field_150417_aV, 3);
        for (int dy = -1; dy <= 5; ++dy) {
            this.setBlockAndMetadata(world, x + 3, y + dy, z + 0, Blocks.field_150417_aV, 1);
        }
        this.setBlockAndMetadata(world, x + 4, y - 1, z + 0, Blocks.field_150417_aV, 1);
        this.setBlockAndMetadata(world, x + 5, y - 1, z + 0, Blocks.field_150417_aV, 1);
        this.setBlockAndMetadata(world, x + 6, y - 1, z + 0, Blocks.field_150417_aV, 1);
        this.setBlockAndMetadata(world, x + 4, y + 5, z + 0, Blocks.field_150417_aV, 1);
        this.setBlockAndMetadata(world, x + 5, y + 5, z + 0, Blocks.field_150417_aV, 1);
        for (int dy = -1; dy <= 5; ++dy) {
            this.setBlockAndMetadata(world, x + 0, y + dy, z + 3, Blocks.field_150417_aV, 1);
            this.setBlockAndMetadata(world, x + 0, y + dy, z + 7, Blocks.field_150417_aV, 1);
        }
        for (int dz = 4; dz < 7; ++dz) {
            this.setBlockAndMetadata(world, x + 0, y - 1, z + dz, Blocks.field_150417_aV, 1);
            this.setBlockAndMetadata(world, x + 0, y + 5, z + dz, Blocks.field_150417_aV, 1);
        }
        this.setBlockAndMetadata(world, x + 0, y + 4, z + 8, Blocks.field_150417_aV, 3);
        return true;
    }
}
