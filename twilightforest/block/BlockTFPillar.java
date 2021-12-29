// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.block.properties.IProperty;
import net.minecraft.util.EnumFacing;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.BlockRotatedPillar;

public class BlockTFPillar extends BlockRotatedPillar implements ModelRegisterCallback
{
    protected BlockTFPillar(final Material material) {
        super(material);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)BlockTFPillar.field_176298_M, (Comparable)EnumFacing.Axis.Y));
    }
}
