// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.material.Material;

public class TFGenWebs extends TFGenerator
{
    private static boolean isValidMaterial(final Material material) {
        return material == Material.field_151584_j || material == Material.field_151575_d;
    }
    
    public boolean func_180709_b(final World world, final Random random, BlockPos pos) {
        while (pos.func_177956_o() > 31 && world.func_175623_d(pos)) {
            pos = pos.func_177977_b();
        }
        if (!isValidMaterial(world.func_180495_p(pos).func_185904_a())) {
            return false;
        }
        while (!world.func_175623_d(pos.func_177977_b())) {
            pos = pos.func_177977_b();
            if (pos.func_177956_o() <= 31 || !isValidMaterial(world.func_180495_p(pos).func_185904_a())) {
                return false;
            }
        }
        world.func_180501_a(pos.func_177977_b(), Blocks.field_150321_G.func_176223_P(), 18);
        return true;
    }
}
