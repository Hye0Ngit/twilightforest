// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.world.IBlockAccess;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.Rotation;

public class TFGenLampposts extends TFGenerator
{
    private static final Rotation[] ROTATIONS;
    private final IBlockState lamp;
    
    public TFGenLampposts(final IBlockState state) {
        this.lamp = state;
    }
    
    public boolean func_180709_b(final World world, final Random rand, final BlockPos pos) {
        if (world.func_180495_p(pos.func_177977_b()).func_177230_c() != Blocks.field_150349_c) {
            return false;
        }
        final int height = 1 + rand.nextInt(4);
        for (int dy = 0; dy <= height; ++dy) {
            final IBlockState state = world.func_180495_p(pos.func_177981_b(dy));
            if (!state.func_177230_c().isAir(state, (IBlockAccess)world, pos.func_177981_b(dy)) && !state.func_177230_c().func_176200_f((IBlockAccess)world, pos.func_177981_b(dy))) {
                return false;
            }
        }
        for (int dy = 0; dy < height; ++dy) {
            world.func_180501_a(pos.func_177981_b(dy), Blocks.field_180407_aO.func_176223_P(), 18);
        }
        world.func_180501_a(pos.func_177981_b(height), this.lamp.func_185907_a(TFGenLampposts.ROTATIONS[rand.nextInt(TFGenLampposts.ROTATIONS.length)]), 18);
        return true;
    }
    
    static {
        ROTATIONS = Rotation.values();
    }
}
