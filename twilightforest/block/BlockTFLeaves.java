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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.Block;
import net.minecraft.block.state.BlockStateContainer;
import twilightforest.TFConfig;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import twilightforest.enums.LeavesVariant;
import net.minecraft.block.properties.IProperty;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.BlockLeaves;

public class BlockTFLeaves extends BlockLeaves implements ModelRegisterCallback
{
    public static final IProperty<LeavesVariant> VARIANT;
    
    protected BlockTFLeaves() {
        this.func_149711_c(0.2f);
        this.func_149713_g(1);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)BlockTFLeaves.field_176236_b, (Comparable)true).func_177226_a((IProperty)BlockTFLeaves.field_176237_a, (Comparable)true).func_177226_a((IProperty)BlockTFLeaves.VARIANT, (Comparable)LeavesVariant.OAK));
    }
    
    public int func_149717_k(final IBlockState state) {
        return TFConfig.performance.leavesLightOpacity;
    }
    
    public BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { (IProperty)BlockTFLeaves.field_176236_b, (IProperty)BlockTFLeaves.field_176237_a, BlockTFLeaves.VARIANT });
    }
    
    @Deprecated
    public IBlockState func_176203_a(final int meta) {
        final LeavesVariant variant = LeavesVariant.values()[meta & 0x3];
        return this.func_176223_P().func_177226_a((IProperty)BlockTFLeaves.VARIANT, (Comparable)variant).func_177226_a((IProperty)BlockTFLeaves.field_176237_a, (Comparable)((meta & 0x4) == 0x0)).func_177226_a((IProperty)BlockTFLeaves.field_176236_b, (Comparable)((meta & 0x8) > 0));
    }
    
    public int func_176201_c(final IBlockState state) {
        int i = ((LeavesVariant)state.func_177229_b((IProperty)BlockTFLeaves.VARIANT)).ordinal();
        if (!(boolean)state.func_177229_b((IProperty)BlockTFLeaves.field_176237_a)) {
            i |= 0x4;
        }
        if (state.func_177229_b((IProperty)BlockTFLeaves.field_176236_b)) {
            i |= 0x8;
        }
        return i;
    }
    
    public BlockPlanks.EnumType func_176233_b(final int meta) {
        return BlockPlanks.EnumType.OAK;
    }
    
    public void func_149666_a(final CreativeTabs creativeTab, final NonNullList<ItemStack> list) {
        list.add((Object)new ItemStack((Block)this, 1, 0));
        list.add((Object)new ItemStack((Block)this, 1, 1));
        list.add((Object)new ItemStack((Block)this, 1, 2));
        list.add((Object)new ItemStack((Block)this, 1, 3));
    }
    
    public Item func_180660_a(final IBlockState state, final Random random, final int fortune) {
        return Item.func_150898_a((Block)TFBlocks.twilight_sapling);
    }
    
    public int func_180651_a(final IBlockState state) {
        final LeavesVariant leafType = (LeavesVariant)state.func_177229_b((IProperty)BlockTFLeaves.VARIANT);
        return (leafType == LeavesVariant.RAINBOAK) ? 9 : leafType.ordinal();
    }
    
    public ItemStack func_180643_i(final IBlockState state) {
        return new ItemStack((Block)this, 1, ((LeavesVariant)state.func_177229_b((IProperty)BlockTFLeaves.VARIANT)).ordinal());
    }
    
    public ItemStack getPickBlock(final IBlockState state, final RayTraceResult target, final World world, final BlockPos pos, final EntityPlayer player) {
        return new ItemStack((Block)this, 1, ((LeavesVariant)state.func_177229_b((IProperty)BlockTFLeaves.VARIANT)).ordinal());
    }
    
    public int func_176232_d(final IBlockState state) {
        return (state.func_177229_b((IProperty)BlockTFLeaves.VARIANT) == LeavesVariant.MANGROVE) ? 20 : 40;
    }
    
    public List<ItemStack> onSheared(final ItemStack item, final IBlockAccess world, final BlockPos pos, final int fortune) {
        return (List<ItemStack>)NonNullList.func_191197_a(1, (Object)new ItemStack((Block)this, 1, ((LeavesVariant)world.func_180495_p(pos).func_177229_b((IProperty)BlockTFLeaves.VARIANT)).ordinal()));
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        final IStateMapper stateMapper = (IStateMapper)new StateMap.Builder().func_178442_a(new IProperty[] { (IProperty)BlockTFLeaves.field_176236_b, (IProperty)BlockTFLeaves.field_176237_a }).func_178441_a();
        ModelLoader.setCustomStateMapper((Block)this, stateMapper);
        ModelUtils.registerToStateSingleVariant((Block)this, BlockTFLeaves.VARIANT, stateMapper);
    }
    
    public int getFlammability(final IBlockAccess world, final BlockPos pos, final EnumFacing face) {
        return 60;
    }
    
    public int getFireSpreadSpeed(final IBlockAccess world, final BlockPos pos, final EnumFacing face) {
        return 30;
    }
    
    static {
        VARIANT = (IProperty)PropertyEnum.func_177709_a("variant", (Class)LeavesVariant.class);
    }
}
