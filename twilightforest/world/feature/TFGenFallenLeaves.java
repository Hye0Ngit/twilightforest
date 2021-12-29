// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.PlantVariant;
import twilightforest.block.BlockTFPlant;
import twilightforest.block.TFBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.gen.feature.WorldGenerator;

public class TFGenFallenLeaves extends WorldGenerator
{
    private final IBlockState state;
    
    public TFGenFallenLeaves() {
        this.state = TFBlocks.twilight_plant.func_176223_P().func_177226_a((IProperty)BlockTFPlant.VARIANT, (Comparable)PlantVariant.FALLEN_LEAVES);
    }
    
    public boolean func_180709_b(final World worldIn, final Random rand, BlockPos position) {
        do {
            final IBlockState state = worldIn.func_180495_p(position.func_177977_b());
            if (worldIn.func_175623_d(position)) {
                if (state.func_185904_a() == Material.field_151577_b) {
                    break;
                }
                if (state.func_185904_a() == Material.field_151578_c) {
                    break;
                }
            }
            position = position.func_177977_b();
        } while (position.func_177956_o() > 31);
        for (int x = 0; x < 5; ++x) {
            for (int z = 0; z < 5; ++z) {
                if (rand.nextInt(3) == 0) {
                    boolean flag = false;
                    int y = 2;
                    do {
                        final IBlockState state2 = worldIn.func_180495_p(position.func_177982_a(x, y, z).func_177977_b());
                        if (worldIn.func_175623_d(position.func_177982_a(x, y, z)) && (state2.func_185904_a() == Material.field_151577_b || state2.func_185904_a() == Material.field_151578_c)) {
                            flag = true;
                            break;
                        }
                    } while (--y >= -2);
                    if (flag) {
                        final BlockPos pos = position.func_177982_a(x, y, z);
                        if (((BlockBush)this.state.func_177230_c()).func_180671_f(worldIn, pos, this.state)) {
                            worldIn.func_180501_a(pos, this.state, 18);
                        }
                    }
                }
            }
        }
        return true;
    }
}
