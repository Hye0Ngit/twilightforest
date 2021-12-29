// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import twilightforest.client.ModelUtils;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.client.renderer.block.statemap.StateMap;
import java.util.List;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.NonNullList;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.Block;
import net.minecraft.block.state.BlockStateContainer;
import twilightforest.TFConfig;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import twilightforest.enums.Leaves3Variant;
import net.minecraft.block.properties.IProperty;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.BlockLeaves;

public class BlockTFLeaves3 extends BlockLeaves implements ModelRegisterCallback
{
    public static final IProperty<Leaves3Variant> VARIANT;
    
    protected BlockTFLeaves3() {
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_149713_g(1);
        this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)BlockTFLeaves3.field_176236_b, (Comparable)true).func_177226_a((IProperty)BlockTFLeaves3.field_176237_a, (Comparable)true).func_177226_a((IProperty)BlockTFLeaves3.VARIANT, (Comparable)Leaves3Variant.THORN));
    }
    
    public int func_149717_k(final IBlockState state) {
        return TFConfig.performance.leavesLightOpacity;
    }
    
    public int func_176201_c(final IBlockState state) {
        int i = 0;
        i |= ((Leaves3Variant)state.func_177229_b((IProperty)BlockTFLeaves3.VARIANT)).ordinal();
        if (!(boolean)state.func_177229_b((IProperty)BlockTFLeaves3.field_176237_a)) {
            i |= 0x4;
        }
        if (state.func_177229_b((IProperty)BlockTFLeaves3.field_176236_b)) {
            i |= 0x8;
        }
        return i;
    }
    
    @Deprecated
    public IBlockState func_176203_a(final int meta) {
        final int variant = meta & 0x3;
        final Leaves3Variant[] values = Leaves3Variant.values();
        return this.func_176223_P().func_177226_a((IProperty)BlockTFLeaves3.VARIANT, (Comparable)values[variant % values.length]).func_177226_a((IProperty)BlockTFLeaves3.field_176237_a, (Comparable)((meta & 0x4) == 0x0)).func_177226_a((IProperty)BlockTFLeaves3.field_176236_b, (Comparable)((meta & 0x8) > 0));
    }
    
    public BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { (IProperty)BlockTFLeaves3.field_176236_b, (IProperty)BlockTFLeaves3.field_176237_a, BlockTFLeaves3.VARIANT });
    }
    
    public BlockPlanks.EnumType func_176233_b(final int meta) {
        return BlockPlanks.EnumType.OAK;
    }
    
    public ItemStack func_185473_a(final World world, final BlockPos pos, final IBlockState state) {
        return new ItemStack((Block)this, 1, ((Leaves3Variant)state.func_177229_b((IProperty)BlockTFLeaves3.VARIANT)).ordinal());
    }
    
    public Item func_180660_a(final IBlockState state, final Random random, final int fortune) {
        return TFItems.magic_beans;
    }
    
    public void func_149666_a(final CreativeTabs creativeTab, final NonNullList<ItemStack> list) {
        for (int n = Leaves3Variant.values().length, i = 0; i < n; ++i) {
            list.add((Object)new ItemStack((Block)this, 1, i));
        }
    }
    
    public boolean canBeReplacedByLeaves(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        return true;
    }
    
    public List<ItemStack> onSheared(final ItemStack item, final IBlockAccess world, final BlockPos pos, final int fortune) {
        return (List<ItemStack>)NonNullList.func_191197_a(1, (Object)new ItemStack((Block)this, 1, ((Leaves3Variant)world.func_180495_p(pos).func_177229_b((IProperty)BlockTFLeaves3.VARIANT)).ordinal()));
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        final IStateMapper stateMapper = (IStateMapper)new StateMap.Builder().func_178442_a(new IProperty[] { (IProperty)BlockTFLeaves3.field_176236_b, (IProperty)BlockTFLeaves3.field_176237_a }).func_178441_a();
        ModelLoader.setCustomStateMapper((Block)this, stateMapper);
        ModelUtils.registerToStateSingleVariant((Block)this, BlockTFLeaves3.VARIANT, stateMapper);
    }
    
    public int getFlammability(final IBlockAccess world, final BlockPos pos, final EnumFacing face) {
        return 60;
    }
    
    public int getFireSpreadSpeed(final IBlockAccess world, final BlockPos pos, final EnumFacing face) {
        return 30;
    }
    
    public ItemStack func_180643_i(final IBlockState state) {
        return new ItemStack((Block)this, 1, ((Leaves3Variant)state.func_177229_b((IProperty)BlockTFLeaves3.VARIANT)).ordinal());
    }
    
    static {
        VARIANT = (IProperty)PropertyEnum.func_177709_a("variant", (Class)Leaves3Variant.class);
    }
}
