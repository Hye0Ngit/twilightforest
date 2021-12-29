// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.Iterator;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.Block;

public class BlockTFHugeStalk extends Block implements ModelRegisterCallback
{
    protected BlockTFHugeStalk() {
        super(Material.field_151575_d, MapColor.field_151669_i);
        this.func_149711_c(1.25f);
        this.func_149752_b(7.0f);
        this.func_149672_a(SoundType.field_185850_c);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public boolean canSustainLeaves(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        return true;
    }
    
    public void func_180663_b(final World worldIn, final BlockPos pos, final IBlockState state) {
        final int i = 4;
        final int j = 5;
        if (worldIn.func_175707_a(pos.func_177982_a(-5, -5, -5), pos.func_177982_a(5, 5, 5))) {
            for (final BlockPos blockpos : BlockPos.func_177980_a(pos.func_177982_a(-4, -4, -4), pos.func_177982_a(4, 4, 4))) {
                final IBlockState iblockstate = worldIn.func_180495_p(blockpos);
                if (iblockstate.func_177230_c().isLeaves(iblockstate, (IBlockAccess)worldIn, blockpos)) {
                    iblockstate.func_177230_c().beginLeavesDecay(iblockstate, worldIn, blockpos);
                }
            }
        }
    }
}
