// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.Block;

public class BlockTFFluffyCloud extends Block implements ModelRegisterCallback
{
    protected BlockTFFluffyCloud() {
        super(Material.field_151598_x);
        this.func_149672_a(SoundType.field_185854_g);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_149711_c(0.8f);
    }
}
