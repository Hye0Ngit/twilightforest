// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.block.material.Material;
import twilightforest.block.TFBlocks;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class TFGenHugeWaterLily extends WorldGenerator
{
    public boolean func_180709_b(final World world, final Random random, final BlockPos pos) {
        for (int i = 0; i < 4; ++i) {
            final BlockPos pos_ = pos.func_177982_a(random.nextInt(8) - random.nextInt(8), random.nextInt(4) - random.nextInt(4), random.nextInt(8) - random.nextInt(8));
            if (this.shouldPlacePadAt(world, pos_)) {
                world.func_180501_a(pos_, TFBlocks.huge_waterlily.func_176223_P(), 18);
            }
        }
        return true;
    }
    
    private boolean shouldPlacePadAt(final World world, final BlockPos pos) {
        return world.func_175623_d(pos) && world.func_180495_p(pos.func_177977_b()).func_185904_a() == Material.field_151586_h;
    }
}
