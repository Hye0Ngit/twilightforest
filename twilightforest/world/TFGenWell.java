// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.TFTreasure;
import net.minecraft.block.Block;
import java.util.Random;
import net.minecraft.world.World;

public class TFGenWell extends TFGenerator
{
    @Override
    public boolean func_76484_a(final World world, final Random rand, final int x, final int y, final int z) {
        if (rand.nextInt(4) == 0) {
            return this.generate4x4Well(world, rand, x, y, z);
        }
        return this.generate3x3Well(world, rand, x, y, z);
    }
    
    public boolean generate3x3Well(final World world, final Random rand, final int x, final int y, final int z) {
        if (!this.isAreaClear(world, rand, x, y, z, 3, 4, 3)) {
            return false;
        }
        this.putBlock(world, x + 0, y, z + 0, Block.field_72087_ao.field_71990_ca, true);
        this.putBlock(world, x + 1, y, z + 0, Block.field_72087_ao.field_71990_ca, true);
        this.putBlock(world, x + 2, y, z + 0, Block.field_72087_ao.field_71990_ca, true);
        this.putBlock(world, x + 0, y, z + 2, Block.field_72087_ao.field_71990_ca, true);
        this.putBlock(world, x + 1, y, z + 2, Block.field_72087_ao.field_71990_ca, true);
        this.putBlock(world, x + 2, y, z + 2, Block.field_72087_ao.field_71990_ca, true);
        this.putBlock(world, x + 0, y, z + 1, Block.field_72087_ao.field_71990_ca, true);
        this.putBlock(world, x + 2, y, z + 1, Block.field_72087_ao.field_71990_ca, true);
        this.putBlock(world, x + 1, y, z + 1, Block.field_71943_B.field_71990_ca, true);
        this.putBlock(world, x + 0, y + 1, z + 0, Block.field_72031_aZ.field_71990_ca, true);
        this.putBlock(world, x + 2, y + 1, z + 0, Block.field_72031_aZ.field_71990_ca, true);
        this.putBlock(world, x + 0, y + 1, z + 2, Block.field_72031_aZ.field_71990_ca, true);
        this.putBlock(world, x + 2, y + 1, z + 2, Block.field_72031_aZ.field_71990_ca, true);
        this.putBlock(world, x + 0, y + 2, z + 0, Block.field_72031_aZ.field_71990_ca, true);
        this.putBlock(world, x + 2, y + 2, z + 0, Block.field_72031_aZ.field_71990_ca, true);
        this.putBlock(world, x + 0, y + 2, z + 2, Block.field_72031_aZ.field_71990_ca, true);
        this.putBlock(world, x + 2, y + 2, z + 2, Block.field_72031_aZ.field_71990_ca, true);
        this.putBlockAndMetadata(world, x + 0, y + 3, z + 0, Block.field_72092_bO.field_71990_ca, 0, true);
        this.putBlockAndMetadata(world, x + 1, y + 3, z + 0, Block.field_72092_bO.field_71990_ca, 0, true);
        this.putBlockAndMetadata(world, x + 2, y + 3, z + 0, Block.field_72092_bO.field_71990_ca, 0, true);
        this.putBlockAndMetadata(world, x + 0, y + 3, z + 2, Block.field_72092_bO.field_71990_ca, 0, true);
        this.putBlockAndMetadata(world, x + 1, y + 3, z + 2, Block.field_72092_bO.field_71990_ca, 0, true);
        this.putBlockAndMetadata(world, x + 2, y + 3, z + 2, Block.field_72092_bO.field_71990_ca, 0, true);
        this.putBlockAndMetadata(world, x + 0, y + 3, z + 1, Block.field_72092_bO.field_71990_ca, 0, true);
        this.putBlockAndMetadata(world, x + 2, y + 3, z + 1, Block.field_72092_bO.field_71990_ca, 0, true);
        this.putBlock(world, x + 1, y + 3, z + 1, Block.field_71988_x.field_71990_ca, true);
        boolean madeTreasure = false;
        for (int dy = -1; dy >= -20; --dy) {
            final int dblock = world.func_72798_a(x + 1, y + dy, z + 1);
            if (dblock != Block.field_71979_v.field_71990_ca && dblock != Block.field_71980_u.field_71990_ca && dblock != Block.field_71940_F.field_71990_ca && dblock != Block.field_71981_t.field_71990_ca) {
                break;
            }
            if (!world.func_72803_f(x + 1, y + dy - 1, z + 1).func_76220_a()) {
                break;
            }
            this.putBlock(world, x + 1, y + dy, z + 1, Block.field_71943_B.field_71990_ca, true);
            if (dy < -15 && !madeTreasure && rand.nextInt(8) == 0) {
                this.putBlock(world, x + 2, y + dy, z + 1, Block.field_71943_B.field_71990_ca, true);
                this.putBlock(world, x + 3, y + dy + 1, z + 1, 0, true);
                this.putBlock(world, x + 3, y + dy, z + 1, 0, true);
                TFTreasure.basement.generate(world, rand, x + 3, y + dy, z + 1);
                madeTreasure = true;
            }
        }
        return true;
    }
    
    public boolean generate4x4Well(final World world, final Random rand, final int x, final int y, final int z) {
        if (!this.isAreaClear(world, rand, x, y, z, 4, 4, 4)) {
            return false;
        }
        this.putBlock(world, x + 0, y, z + 0, Block.field_72087_ao.field_71990_ca, true);
        this.putBlock(world, x + 1, y, z + 0, Block.field_72087_ao.field_71990_ca, true);
        this.putBlock(world, x + 2, y, z + 0, Block.field_72087_ao.field_71990_ca, true);
        this.putBlock(world, x + 3, y, z + 0, Block.field_72087_ao.field_71990_ca, true);
        this.putBlock(world, x + 0, y, z + 3, Block.field_72087_ao.field_71990_ca, true);
        this.putBlock(world, x + 1, y, z + 3, Block.field_72087_ao.field_71990_ca, true);
        this.putBlock(world, x + 2, y, z + 3, Block.field_72087_ao.field_71990_ca, true);
        this.putBlock(world, x + 3, y, z + 3, Block.field_72087_ao.field_71990_ca, true);
        this.putBlock(world, x + 0, y, z + 1, Block.field_72087_ao.field_71990_ca, true);
        this.putBlock(world, x + 0, y, z + 2, Block.field_72087_ao.field_71990_ca, true);
        this.putBlock(world, x + 3, y, z + 1, Block.field_72087_ao.field_71990_ca, true);
        this.putBlock(world, x + 3, y, z + 2, Block.field_72087_ao.field_71990_ca, true);
        this.putBlock(world, x + 1, y, z + 1, Block.field_71943_B.field_71990_ca, true);
        this.putBlock(world, x + 2, y, z + 1, Block.field_71943_B.field_71990_ca, true);
        this.putBlock(world, x + 1, y, z + 2, Block.field_71943_B.field_71990_ca, true);
        this.putBlock(world, x + 2, y, z + 2, Block.field_71943_B.field_71990_ca, true);
        this.putBlock(world, x + 0, y + 1, z + 0, Block.field_72031_aZ.field_71990_ca, true);
        this.putBlock(world, x + 3, y + 1, z + 0, Block.field_72031_aZ.field_71990_ca, true);
        this.putBlock(world, x + 0, y + 1, z + 3, Block.field_72031_aZ.field_71990_ca, true);
        this.putBlock(world, x + 3, y + 1, z + 3, Block.field_72031_aZ.field_71990_ca, true);
        this.putBlock(world, x + 0, y + 2, z + 0, Block.field_72031_aZ.field_71990_ca, true);
        this.putBlock(world, x + 3, y + 2, z + 0, Block.field_72031_aZ.field_71990_ca, true);
        this.putBlock(world, x + 0, y + 2, z + 3, Block.field_72031_aZ.field_71990_ca, true);
        this.putBlock(world, x + 3, y + 2, z + 3, Block.field_72031_aZ.field_71990_ca, true);
        this.putBlockAndMetadata(world, x + 0, y + 3, z + 0, Block.field_72092_bO.field_71990_ca, 0, true);
        this.putBlockAndMetadata(world, x + 1, y + 3, z + 0, Block.field_72092_bO.field_71990_ca, 0, true);
        this.putBlockAndMetadata(world, x + 2, y + 3, z + 0, Block.field_72092_bO.field_71990_ca, 0, true);
        this.putBlockAndMetadata(world, x + 3, y + 3, z + 0, Block.field_72092_bO.field_71990_ca, 0, true);
        this.putBlockAndMetadata(world, x + 0, y + 3, z + 3, Block.field_72092_bO.field_71990_ca, 0, true);
        this.putBlockAndMetadata(world, x + 1, y + 3, z + 3, Block.field_72092_bO.field_71990_ca, 0, true);
        this.putBlockAndMetadata(world, x + 2, y + 3, z + 3, Block.field_72092_bO.field_71990_ca, 0, true);
        this.putBlockAndMetadata(world, x + 3, y + 3, z + 3, Block.field_72092_bO.field_71990_ca, 0, true);
        this.putBlockAndMetadata(world, x + 0, y + 3, z + 1, Block.field_72092_bO.field_71990_ca, 0, true);
        this.putBlockAndMetadata(world, x + 0, y + 3, z + 2, Block.field_72092_bO.field_71990_ca, 0, true);
        this.putBlockAndMetadata(world, x + 3, y + 3, z + 1, Block.field_72092_bO.field_71990_ca, 0, true);
        this.putBlockAndMetadata(world, x + 3, y + 3, z + 2, Block.field_72092_bO.field_71990_ca, 0, true);
        this.putBlock(world, x + 1, y + 3, z + 1, Block.field_71988_x.field_71990_ca, true);
        this.putBlock(world, x + 2, y + 3, z + 1, Block.field_71988_x.field_71990_ca, true);
        this.putBlock(world, x + 1, y + 3, z + 2, Block.field_71988_x.field_71990_ca, true);
        this.putBlock(world, x + 2, y + 3, z + 2, Block.field_71988_x.field_71990_ca, true);
        for (int dx = 1; dx <= 2; ++dx) {
            for (int dz = 1; dz <= 2; ++dz) {
                for (int dy = -1; dy >= -20; --dy) {
                    final int dblock = world.func_72798_a(x + dx, y + dy, z + dz);
                    if (dblock != Block.field_71979_v.field_71990_ca && dblock != Block.field_71980_u.field_71990_ca && dblock != Block.field_71940_F.field_71990_ca && dblock != Block.field_71981_t.field_71990_ca) {
                        break;
                    }
                    if (!world.func_72803_f(x + dx, y + dy - 1, z + dz).func_76220_a()) {
                        break;
                    }
                    this.putBlock(world, x + dx, y + dy, z + dz, Block.field_71943_B.field_71990_ca, true);
                }
            }
        }
        return true;
    }
}
