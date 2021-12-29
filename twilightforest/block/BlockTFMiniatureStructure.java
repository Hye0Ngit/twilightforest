// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.block.properties.PropertyEnum;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import twilightforest.item.TFItems;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import twilightforest.enums.StructureVariant;
import net.minecraft.block.properties.IProperty;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.Block;

public class BlockTFMiniatureStructure extends Block implements ModelRegisterCallback
{
    public static final IProperty<StructureVariant> VARIANT;
    
    public BlockTFMiniatureStructure() {
        super(Material.field_175972_I);
        this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)BlockTFMiniatureStructure.VARIANT, (Comparable)StructureVariant.TWILIGHT_PORTAL));
    }
    
    public boolean func_149662_c(final IBlockState state) {
        return false;
    }
    
    public boolean func_149686_d(final IBlockState state) {
        return false;
    }
    
    public BlockFaceShape func_193383_a(final IBlockAccess world, final IBlockState state, final BlockPos pos, final EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
    }
    
    public BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { BlockTFMiniatureStructure.VARIANT });
    }
    
    public int func_176201_c(final IBlockState state) {
        return ((StructureVariant)state.func_177229_b((IProperty)BlockTFMiniatureStructure.VARIANT)).ordinal();
    }
    
    @Deprecated
    public IBlockState func_176203_a(final int meta) {
        return this.func_176223_P().func_177226_a((IProperty)BlockTFMiniatureStructure.VARIANT, (Comparable)StructureVariant.values()[meta]);
    }
    
    public void func_149666_a(final CreativeTabs tab, final NonNullList<ItemStack> list) {
        for (final StructureVariant variation : StructureVariant.values()) {
            list.add((Object)new ItemStack((Block)this, 1, variation.ordinal()));
        }
    }
    
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer func_180664_k() {
        return BlockRenderLayer.CUTOUT;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        for (final StructureVariant variation : StructureVariant.values()) {
            ModelLoader.setCustomModelResourceLocation(TFItems.miniature_structure, variation.ordinal(), new ModelResourceLocation("twilightforest:miniature_structure", "inventory_" + variation.func_176610_l()));
        }
    }
    
    static {
        VARIANT = (IProperty)PropertyEnum.func_177709_a("variant", (Class)StructureVariant.class);
    }
}
