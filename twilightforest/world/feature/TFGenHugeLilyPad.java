// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import twilightforest.enums.HugeLilypadPiece;
import net.minecraft.block.properties.IProperty;
import twilightforest.block.BlockTFHugeLilyPad;
import twilightforest.block.TFBlocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class TFGenHugeLilyPad extends WorldGenerator
{
    public boolean func_180709_b(final World world, final Random random, final BlockPos pos) {
        for (int i = 0; i < 10; ++i) {
            final BlockPos dPos = pos.func_177982_a(random.nextInt(8) - random.nextInt(8), random.nextInt(4) - random.nextInt(4), random.nextInt(8) - random.nextInt(8));
            if (this.shouldPlacePadAt(world, dPos) && world.func_175697_a(dPos, 1)) {
                final EnumFacing horizontal = EnumFacing.func_176731_b(random.nextInt(4));
                final IBlockState lilypad = TFBlocks.huge_lilypad.func_176223_P().func_177226_a((IProperty)BlockTFHugeLilyPad.FACING, (Comparable)horizontal);
                world.func_180501_a(dPos, lilypad.func_177226_a((IProperty)BlockTFHugeLilyPad.PIECE, (Comparable)HugeLilypadPiece.NW), 18);
                world.func_180501_a(dPos.func_177974_f(), lilypad.func_177226_a((IProperty)BlockTFHugeLilyPad.PIECE, (Comparable)HugeLilypadPiece.NE), 18);
                world.func_180501_a(dPos.func_177974_f().func_177968_d(), lilypad.func_177226_a((IProperty)BlockTFHugeLilyPad.PIECE, (Comparable)HugeLilypadPiece.SE), 18);
                world.func_180501_a(dPos.func_177968_d(), lilypad.func_177226_a((IProperty)BlockTFHugeLilyPad.PIECE, (Comparable)HugeLilypadPiece.SW), 18);
            }
        }
        return true;
    }
    
    private boolean shouldPlacePadAt(final World world, final BlockPos pos) {
        return world.func_175623_d(pos) && world.func_180495_p(pos.func_177977_b()).func_185904_a() == Material.field_151586_h && world.func_175623_d(pos.func_177974_f()) && world.func_180495_p(pos.func_177974_f().func_177977_b()).func_185904_a() == Material.field_151586_h && world.func_175623_d(pos.func_177968_d()) && world.func_180495_p(pos.func_177968_d().func_177977_b()).func_185904_a() == Material.field_151586_h && world.func_175623_d(pos.func_177974_f().func_177968_d()) && world.func_180495_p(pos.func_177974_f().func_177968_d().func_177977_b()).func_185904_a() == Material.field_151586_h;
    }
}
