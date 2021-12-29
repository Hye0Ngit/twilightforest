// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.Block;
import twilightforest.loot.TFTreasure;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;

public class TFGenWell extends TFGenerator
{
    public boolean func_180709_b(final World world, final Random rand, final BlockPos pos) {
        if (rand.nextInt(4) == 0) {
            return this.generate4x4Well(world, rand, pos);
        }
        return this.generate3x3Well(world, rand, pos);
    }
    
    public boolean generate3x3Well(final World world, final Random rand, final BlockPos pos) {
        if (!TFGenerator.isAreaSuitable(world, rand, pos, 3, 4, 3)) {
            return false;
        }
        this.func_175903_a(world, pos, Blocks.field_150341_Y.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(1, 0, 0), Blocks.field_150341_Y.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(2, 0, 0), Blocks.field_150341_Y.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(0, 0, 2), Blocks.field_150341_Y.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(1, 0, 2), Blocks.field_150341_Y.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(2, 0, 2), Blocks.field_150341_Y.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(0, 0, 1), Blocks.field_150341_Y.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(2, 0, 1), Blocks.field_150341_Y.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(1, 0, 1), Blocks.field_150355_j.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(0, 1, 0), Blocks.field_180407_aO.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(2, 1, 0), Blocks.field_180407_aO.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(0, 1, 2), Blocks.field_180407_aO.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(2, 1, 2), Blocks.field_180407_aO.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(0, 2, 0), Blocks.field_180407_aO.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(2, 2, 0), Blocks.field_180407_aO.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(0, 2, 2), Blocks.field_180407_aO.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(2, 2, 2), Blocks.field_180407_aO.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(0, 3, 0), Blocks.field_150376_bx.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(1, 3, 0), Blocks.field_150376_bx.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(2, 3, 0), Blocks.field_150376_bx.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(0, 3, 2), Blocks.field_150376_bx.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(1, 3, 2), Blocks.field_150376_bx.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(2, 3, 2), Blocks.field_150376_bx.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(0, 3, 1), Blocks.field_150376_bx.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(2, 3, 1), Blocks.field_150376_bx.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(1, 3, 1), Blocks.field_150344_f.func_176223_P());
        boolean madeTreasure = false;
        for (int dy = -1; dy >= -20; --dy) {
            final Block dblock = world.func_180495_p(pos.func_177982_a(1, dy, 1)).func_177230_c();
            if (dblock != Blocks.field_150346_d && dblock != Blocks.field_150349_c && dblock != Blocks.field_150351_n && dblock != Blocks.field_150348_b) {
                break;
            }
            if (!world.func_180495_p(pos.func_177982_a(1, dy - 1, 1)).func_185904_a().func_76220_a()) {
                break;
            }
            this.func_175903_a(world, pos.func_177982_a(1, dy, 1), Blocks.field_150355_j.func_176223_P());
            if (dy < -15 && !madeTreasure && rand.nextInt(8) == 0) {
                this.func_175903_a(world, pos.func_177982_a(2, dy, 1), Blocks.field_150355_j.func_176223_P());
                this.func_175903_a(world, pos.func_177982_a(3, dy + 1, 1), Blocks.field_150350_a.func_176223_P());
                this.func_175903_a(world, pos.func_177982_a(3, dy, 1), Blocks.field_150350_a.func_176223_P());
                TFTreasure.basement.generateChest(world, pos.func_177982_a(3, dy, 1), false);
                madeTreasure = true;
            }
        }
        return true;
    }
    
    private boolean generate4x4Well(final World world, final Random rand, final BlockPos pos) {
        if (!TFGenerator.isAreaSuitable(world, rand, pos, 4, 4, 4)) {
            return false;
        }
        this.func_175903_a(world, pos, Blocks.field_150341_Y.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(1, 0, 0), Blocks.field_150341_Y.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(2, 0, 0), Blocks.field_150341_Y.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(3, 0, 0), Blocks.field_150341_Y.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(0, 0, 3), Blocks.field_150341_Y.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(1, 0, 3), Blocks.field_150341_Y.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(2, 0, 3), Blocks.field_150341_Y.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(3, 0, 3), Blocks.field_150341_Y.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(0, 0, 1), Blocks.field_150341_Y.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(0, 0, 2), Blocks.field_150341_Y.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(3, 0, 1), Blocks.field_150341_Y.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(3, 0, 2), Blocks.field_150341_Y.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(1, 0, 1), Blocks.field_150355_j.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(2, 0, 1), Blocks.field_150355_j.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(1, 0, 2), Blocks.field_150355_j.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(2, 0, 2), Blocks.field_150355_j.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(0, 1, 0), Blocks.field_180407_aO.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(3, 1, 0), Blocks.field_180407_aO.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(0, 1, 3), Blocks.field_180407_aO.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(3, 1, 3), Blocks.field_180407_aO.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(0, 2, 0), Blocks.field_180407_aO.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(3, 2, 0), Blocks.field_180407_aO.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(0, 2, 3), Blocks.field_180407_aO.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(3, 2, 3), Blocks.field_180407_aO.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(0, 3, 0), Blocks.field_150376_bx.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(1, 3, 0), Blocks.field_150376_bx.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(2, 3, 0), Blocks.field_150376_bx.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(3, 3, 0), Blocks.field_150376_bx.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(0, 3, 3), Blocks.field_150376_bx.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(1, 3, 3), Blocks.field_150376_bx.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(2, 3, 3), Blocks.field_150376_bx.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(3, 3, 3), Blocks.field_150376_bx.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(0, 3, 1), Blocks.field_150376_bx.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(0, 3, 2), Blocks.field_150376_bx.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(3, 3, 1), Blocks.field_150376_bx.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(3, 3, 2), Blocks.field_150376_bx.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(1, 3, 1), Blocks.field_150344_f.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(2, 3, 1), Blocks.field_150344_f.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(1, 3, 2), Blocks.field_150344_f.func_176223_P());
        this.func_175903_a(world, pos.func_177982_a(2, 3, 2), Blocks.field_150344_f.func_176223_P());
        for (int dx = 1; dx <= 2; ++dx) {
            for (int dz = 1; dz <= 2; ++dz) {
                for (int dy = -1; dy >= -20; --dy) {
                    final BlockPos dPos = pos.func_177982_a(dx, dy, dz);
                    final IBlockState dState = world.func_180495_p(dPos);
                    final Block dblock = dState.func_177230_c();
                    if (dblock != Blocks.field_150346_d && dblock != Blocks.field_150349_c && dblock != Blocks.field_150351_n && dblock != Blocks.field_150348_b) {
                        break;
                    }
                    if (!world.func_180495_p(dPos.func_177977_b()).func_185904_a().func_76220_a()) {
                        break;
                    }
                    this.func_175903_a(world, dPos, Blocks.field_150355_j.func_176223_P());
                }
            }
        }
        return true;
    }
}
