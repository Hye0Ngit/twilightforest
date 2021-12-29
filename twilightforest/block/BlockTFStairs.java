// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import twilightforest.client.ModelUtils;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.EnumFacing;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.state.IBlockState;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.BlockStairs;

public class BlockTFStairs extends BlockStairs implements ModelRegisterCallback
{
    protected BlockTFStairs(final IBlockState modelState) {
        super(modelState);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.field_149783_u = true;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        ModelUtils.registerToState((Block)this, 0, this.func_176223_P().func_177226_a((IProperty)BlockTFStairs.field_176309_a, (Comparable)EnumFacing.EAST));
    }
}
