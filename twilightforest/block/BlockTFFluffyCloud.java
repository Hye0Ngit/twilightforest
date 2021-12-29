// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

public class BlockTFFluffyCloud extends Block
{
    protected BlockTFFluffyCloud() {
        super(Material.field_151598_x);
        this.func_149672_a(BlockTFFluffyCloud.field_149775_l);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_149711_c(0.8f);
        this.func_149658_d("TwilightForest:fluffy_cloud");
    }
}
