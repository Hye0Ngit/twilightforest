// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import java.util.Random;
import net.minecraft.world.World;

public class TFGenFireJet extends TFGenerator
{
    private int plantBlockId;
    private int plantBlockMeta;
    
    public TFGenFireJet(final int id, final int meta) {
        this.plantBlockId = id;
        this.plantBlockMeta = meta;
    }
    
    @Override
    public boolean func_76484_a(final World world, final Random rand, final int x, final int y, final int z) {
        for (int var6 = 0; var6 < 4; ++var6) {
            final int dx = x + rand.nextInt(8) - rand.nextInt(8);
            final int dy = y + rand.nextInt(4) - rand.nextInt(4);
            final int dz = z + rand.nextInt(8) - rand.nextInt(8);
            if (world.func_72799_c(dx, dy, dz) && world.func_72937_j(dx, dy, dz) && world.func_72803_f(dx, dy - 1, dz) == Material.field_76247_b && world.func_72803_f(dx + 1, dy - 1, dz) == Material.field_76247_b && world.func_72803_f(dx - 1, dy - 1, dz) == Material.field_76247_b && world.func_72803_f(dx, dy - 1, dz + 1) == Material.field_76247_b && world.func_72803_f(dx, dy - 1, dz - 1) == Material.field_76247_b) {
                world.func_72832_d(dx, dy - 1, dz, this.plantBlockId, this.plantBlockMeta, 0);
                for (int rx = -2; rx <= 2; ++rx) {
                    for (int rz = -2; rz <= 2; ++rz) {
                        if ((rx == 1 || rx == 0 || rx == -1) && (rz == 1 || rz == 0 || rz == -1)) {
                            world.func_72832_d(dx + rx, dy - 2, dz + rz, Block.field_71944_C.field_71990_ca, 0, 0);
                        }
                        else if (world.func_72803_f(dx + rx, dy - 2, dz + rz) != Material.field_76256_h) {
                            world.func_72832_d(dx + rx, dy - 2, dz + rz, Block.field_71981_t.field_71990_ca, 0, 0);
                        }
                        world.func_72832_d(dx + rx, dy - 3, dz + rz, Block.field_71981_t.field_71990_ca, 0, 0);
                    }
                }
            }
        }
        return true;
    }
}
