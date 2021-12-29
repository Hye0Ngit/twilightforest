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
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import twilightforest.client.ModelRegisterCallback;

public class BlockTFNagastonePillar extends BlockTFDirectionalRotatedPillar implements ModelRegisterCallback
{
    protected BlockTFNagastonePillar() {
        super(Material.field_151576_e);
        this.func_149672_a(SoundType.field_185851_d);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)BlockTFNagastonePillar.field_176298_M, (Comparable)EnumFacing.Axis.Y).func_177226_a((IProperty)BlockTFNagastonePillar.REVERSED, (Comparable)false));
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerModel() {
        ModelUtils.registerToState((Block)this, 0, this.func_176223_P());
    }
}
