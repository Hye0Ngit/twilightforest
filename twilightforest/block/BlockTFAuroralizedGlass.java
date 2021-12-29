// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.util.BlockRenderLayer;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.BlockGlass;

public class BlockTFAuroralizedGlass extends BlockGlass implements ModelRegisterCallback
{
    public BlockTFAuroralizedGlass() {
        super(Material.field_151588_w, false);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public BlockRenderLayer func_180664_k() {
        return BlockRenderLayer.TRANSLUCENT;
    }
}
