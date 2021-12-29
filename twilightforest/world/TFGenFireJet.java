// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.init.Blocks;
import net.minecraft.block.material.Material;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.Block;

public class TFGenFireJet extends TFGenerator
{
    private Block plantBlockId;
    private int plantBlockMeta;
    
    public TFGenFireJet(final Block fireJet, final int meta) {
        this.plantBlockId = fireJet;
        this.plantBlockMeta = meta;
    }
    
    public boolean func_76484_a(final World world, final Random rand, final int x, final int y, final int z) {
        for (int var6 = 0; var6 < 4; ++var6) {
            final int dx = x + rand.nextInt(8) - rand.nextInt(8);
            final int dy = y + rand.nextInt(4) - rand.nextInt(4);
            final int dz = z + rand.nextInt(8) - rand.nextInt(8);
            if (world.func_147437_c(dx, dy, dz) && world.func_72937_j(dx, dy, dz) && world.func_147439_a(dx, dy - 1, dz).func_149688_o() == Material.field_151577_b && world.func_147439_a(dx + 1, dy - 1, dz).func_149688_o() == Material.field_151577_b && world.func_147439_a(dx - 1, dy - 1, dz).func_149688_o() == Material.field_151577_b && world.func_147439_a(dx, dy - 1, dz + 1).func_149688_o() == Material.field_151577_b && world.func_147439_a(dx, dy - 1, dz - 1).func_149688_o() == Material.field_151577_b) {
                world.func_147465_d(dx, dy - 1, dz, this.plantBlockId, this.plantBlockMeta, 0);
                for (int rx = -2; rx <= 2; ++rx) {
                    for (int rz = -2; rz <= 2; ++rz) {
                        if ((rx == 1 || rx == 0 || rx == -1) && (rz == 1 || rz == 0 || rz == -1)) {
                            world.func_147465_d(dx + rx, dy - 2, dz + rz, (Block)Blocks.field_150356_k, 0, 0);
                        }
                        else if (world.func_147439_a(dx + rx, dy - 2, dz + rz).func_149688_o() != Material.field_151587_i) {
                            world.func_147465_d(dx + rx, dy - 2, dz + rz, Blocks.field_150348_b, 0, 0);
                        }
                        world.func_147465_d(dx + rx, dy - 3, dz + rz, Blocks.field_150348_b, 0, 0);
                    }
                }
            }
        }
        return true;
    }
}
