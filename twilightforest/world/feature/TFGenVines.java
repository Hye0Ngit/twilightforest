// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import java.util.Iterator;
import net.minecraft.block.state.IBlockState;
import java.util.Set;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockVine;
import net.minecraft.init.Blocks;
import java.util.EnumSet;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class TFGenVines extends WorldGenerator
{
    public boolean func_180709_b(final World world, final Random rand, BlockPos position) {
        final BlockPos original = position;
        while (position.func_177956_o() > 31) {
            if (world.func_175623_d(position)) {
                final Set<EnumFacing> facings = EnumSet.noneOf(EnumFacing.class);
                for (final EnumFacing facing : EnumFacing.Plane.HORIZONTAL.func_179516_a()) {
                    if (Blocks.field_150395_bd.func_176198_a(world, position, facing.func_176734_d())) {
                        facings.add(facing);
                    }
                }
                if (!facings.isEmpty()) {
                    IBlockState vine = Blocks.field_150395_bd.func_176223_P();
                    for (final EnumFacing facing2 : facings) {
                        vine = vine.func_177226_a((IProperty)BlockVine.func_176267_a(facing2), (Comparable)true);
                    }
                    BlockPos down = position;
                    do {
                        world.func_180501_a(down, vine, 18);
                        down = down.func_177977_b();
                    } while (down.func_177956_o() >= 0 && world.func_175623_d(down));
                    return true;
                }
            }
            else {
                position = position.func_177982_a(rand.nextInt(4) - rand.nextInt(4), 0, rand.nextInt(4) - rand.nextInt(4));
                if (isOutsideBounds(7, original, position)) {
                    break;
                }
            }
            position = position.func_177977_b();
        }
        return false;
    }
    
    private static boolean isOutsideBounds(final int radius, final BlockPos original, final BlockPos pos) {
        return Math.abs(original.func_177958_n() - pos.func_177958_n()) > radius || Math.abs(original.func_177952_p() - pos.func_177952_p()) > radius;
    }
}
