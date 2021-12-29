// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

public class BlockTFLapisBlock extends Block
{
    protected BlockTFLapisBlock() {
        super(Material.field_151573_f);
        this.func_149672_a(SoundType.field_185851_d);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_149711_c(3.0f);
        this.func_149752_b(5.0f);
    }
}
