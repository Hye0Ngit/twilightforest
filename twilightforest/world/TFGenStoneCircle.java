// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.block.Block;
import java.util.Random;
import net.minecraft.world.World;

public class TFGenStoneCircle extends TFGenerator
{
    @Override
    public boolean func_76484_a(final World world, final Random rand, final int x, final int y, final int z) {
        if (!this.isAreaClear(world, rand, x - 3, y, z - 3, 6, 4, 6)) {
            return false;
        }
        for (int cy = 0; cy <= 2; ++cy) {
            this.putBlock(world, x - 3, y + cy, z, Block.field_72087_ao.field_71990_ca, true);
            this.putBlock(world, x + 3, y + cy, z, Block.field_72087_ao.field_71990_ca, true);
            this.putBlock(world, x, y + cy, z - 3, Block.field_72087_ao.field_71990_ca, true);
            this.putBlock(world, x, y + cy, z + 3, Block.field_72087_ao.field_71990_ca, true);
            this.putBlock(world, x - 2, y + cy, z - 2, Block.field_72087_ao.field_71990_ca, true);
            this.putBlock(world, x + 2, y + cy, z - 2, Block.field_72087_ao.field_71990_ca, true);
            this.putBlock(world, x - 2, y + cy, z + 2, Block.field_72087_ao.field_71990_ca, true);
            this.putBlock(world, x + 2, y + cy, z + 2, Block.field_72087_ao.field_71990_ca, true);
        }
        return true;
    }
}
