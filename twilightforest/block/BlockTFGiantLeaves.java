// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import twilightforest.TFConfig;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.init.Blocks;

public class BlockTFGiantLeaves extends BlockTFGiantBlock
{
    public BlockTFGiantLeaves() {
        super(Blocks.field_150362_t.func_176223_P());
        this.func_149711_c(12.8f);
        this.func_149713_g(1);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public int func_149717_k(final IBlockState state) {
        return TFConfig.performance.leavesLightOpacity;
    }
    
    @Deprecated
    public boolean func_149662_c(final IBlockState state) {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    @Deprecated
    public boolean func_176225_a(final IBlockState state, final IBlockAccess world, final BlockPos pos, final EnumFacing side) {
        switch (side) {
            case DOWN: {
                return (pos.func_177956_o() & 0x3) == 0x0;
            }
            case UP: {
                return (pos.func_177956_o() & 0x3) == 0x3;
            }
            case NORTH: {
                return (pos.func_177952_p() & 0x3) == 0x0;
            }
            case SOUTH: {
                return (pos.func_177952_p() & 0x3) == 0x3;
            }
            case WEST: {
                return (pos.func_177958_n() & 0x3) == 0x0;
            }
            case EAST: {
                return (pos.func_177958_n() & 0x3) == 0x3;
            }
            default: {
                return super.func_176225_a(state, world, pos, side);
            }
        }
    }
}
