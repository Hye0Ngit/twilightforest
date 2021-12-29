// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.SoundType;
import net.minecraft.util.math.AxisAlignedBB;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.BlockLilyPad;

public class BlockTFHugeWaterLily extends BlockLilyPad implements ModelRegisterCallback
{
    private static final AxisAlignedBB AABB;
    
    protected BlockTFHugeWaterLily() {
        this.func_149672_a(SoundType.field_185850_c);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public AxisAlignedBB func_185496_a(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        return BlockTFHugeWaterLily.AABB;
    }
    
    protected boolean func_185514_i(final IBlockState state) {
        return state.func_177230_c() == Blocks.field_150355_j;
    }
    
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer func_180664_k() {
        return BlockRenderLayer.CUTOUT;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        ModelLoader.setCustomModelResourceLocation(Item.func_150898_a((Block)this), 0, new ModelResourceLocation(this.getRegistryName(), "inventory"));
    }
    
    static {
        AABB = new AxisAlignedBB(0.1, 0.1, 0.1, 0.9, 0.9, 0.9);
    }
}
