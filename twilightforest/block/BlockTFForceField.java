// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.Collection;
import net.minecraft.block.properties.PropertyEnum;
import com.google.common.collect.ImmutableList;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.entity.Entity;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.item.EnumDyeColor;
import java.util.List;
import twilightforest.client.ModelRegisterCallback;

public class BlockTFForceField extends BlockTFConnectableRotatedPillar implements ModelRegisterCallback
{
    public static final List<EnumDyeColor> VALID_COLORS;
    public static final IProperty<EnumDyeColor> COLOR;
    
    BlockTFForceField() {
        super(Material.field_175972_I, 2.0);
        this.func_149722_s();
        this.func_149752_b(Float.MAX_VALUE);
        this.func_149715_a(0.13333334f);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_180632_j(this.func_176223_P().func_177226_a((IProperty)BlockTFForceField.COLOR, (Comparable)EnumDyeColor.PURPLE));
    }
    
    public int func_176201_c(final IBlockState state) {
        return BlockTFForceField.VALID_COLORS.indexOf(state.func_177229_b((IProperty)BlockTFForceField.COLOR)) + (((EnumFacing.Axis)state.func_177229_b((IProperty)BlockTFForceField.field_176298_M)).ordinal() + 1) % 3 * 5;
    }
    
    public IBlockState func_176203_a(final int meta) {
        return this.func_176223_P().func_177226_a((IProperty)BlockTFForceField.COLOR, (Comparable)BlockTFForceField.VALID_COLORS.get(meta % 5)).func_177226_a((IProperty)BlockTFForceField.field_176298_M, (Comparable)EnumFacing.Axis.values()[(meta / 5 + 1) % 3]);
    }
    
    @Override
    protected IProperty[] getAdditionalProperties() {
        return new IProperty[] { BlockTFForceField.COLOR };
    }
    
    @Override
    protected AxisAlignedBB getSidedAABBStraight(final EnumFacing facing, final EnumFacing.Axis axis) {
        return this.makeQuickAABB((facing == EnumFacing.EAST || axis == EnumFacing.Axis.X) ? 16.0 : this.boundingBoxWidthLower, (facing == EnumFacing.UP || axis == EnumFacing.Axis.Y) ? 16.0 : this.boundingBoxWidthLower, (facing == EnumFacing.SOUTH || axis == EnumFacing.Axis.Z) ? 16.0 : this.boundingBoxWidthLower, (facing == EnumFacing.WEST || axis == EnumFacing.Axis.X) ? 0.0 : this.boundingBoxWidthUpper, (facing == EnumFacing.DOWN || axis == EnumFacing.Axis.Y) ? 0.0 : this.boundingBoxWidthUpper, (facing == EnumFacing.NORTH || axis == EnumFacing.Axis.Z) ? 0.0 : this.boundingBoxWidthUpper);
    }
    
    @Override
    protected boolean canConnectTo(final IBlockState state, final IBlockState otherState, final IBlockAccess world, final BlockPos pos, final EnumFacing connectTo) {
        final BlockFaceShape blockFaceShape = otherState.func_193401_d(world, pos, connectTo);
        return blockFaceShape == BlockFaceShape.SOLID || blockFaceShape == BlockFaceShape.MIDDLE_POLE_THIN || super.canConnectTo(state, otherState, world, pos, connectTo);
    }
    
    public Item func_180660_a(final IBlockState state, final Random rand, final int fortune) {
        return Items.field_190931_a;
    }
    
    public void func_149666_a(final CreativeTabs creativeTab, final NonNullList<ItemStack> list) {
        for (int i = 0; i < BlockTFForceField.COLOR.func_177700_c().size(); ++i) {
            list.add((Object)new ItemStack((Block)this, 1, i));
        }
    }
    
    @Override
    public boolean func_149662_c(final IBlockState state) {
        return false;
    }
    
    @Override
    public boolean func_149686_d(final IBlockState state) {
        return false;
    }
    
    public BlockFaceShape func_193383_a(final IBlockAccess world, final IBlockState state, final BlockPos pos, final EnumFacing face) {
        return (face.func_176740_k() != state.func_177229_b((IProperty)BlockTFForceField.field_176298_M)) ? BlockFaceShape.MIDDLE_POLE_THIN : BlockFaceShape.CENTER_SMALL;
    }
    
    public int func_180651_a(final IBlockState state) {
        return BlockTFForceField.VALID_COLORS.indexOf(state.func_177229_b((IProperty)BlockTFForceField.COLOR));
    }
    
    public boolean canEntityDestroy(final IBlockState state, final IBlockAccess world, final BlockPos pos, final Entity entity) {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer func_180664_k() {
        return BlockRenderLayer.TRANSLUCENT;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean func_176225_a(final IBlockState blockState, final IBlockAccess blockAccess, final BlockPos pos, final EnumFacing side) {
        return blockAccess.func_180495_p(pos.func_177972_a(side)).func_177230_c() != this && super.func_176225_a(blockState, blockAccess, pos, side);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerModel() {
        final ModelResourceLocation mrl = new ModelResourceLocation(this.getRegistryName(), "inventory");
        for (int i = 0; i < BlockTFForceField.VALID_COLORS.size(); ++i) {
            ModelLoader.setCustomModelResourceLocation(Item.func_150898_a((Block)this), i, mrl);
        }
    }
    
    static {
        VALID_COLORS = (List)ImmutableList.of((Object)EnumDyeColor.PURPLE, (Object)EnumDyeColor.PINK, (Object)EnumDyeColor.ORANGE, (Object)EnumDyeColor.GREEN, (Object)EnumDyeColor.BLUE);
        COLOR = (IProperty)PropertyEnum.func_177707_a("color", (Class)EnumDyeColor.class, (Collection)BlockTFForceField.VALID_COLORS);
    }
}
