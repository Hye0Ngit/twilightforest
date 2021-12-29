// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import twilightforest.client.ModelUtils;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.client.renderer.block.statemap.StateMap;
import java.util.List;
import net.minecraft.world.IBlockAccess;
import twilightforest.client.particle.TFParticleType;
import twilightforest.TwilightForestMod;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.BlockPlanks;
import java.util.Random;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.block.Block;
import net.minecraft.block.state.BlockStateContainer;
import twilightforest.TFConfig;
import net.minecraft.block.state.IBlockState;
import twilightforest.enums.MagicWoodVariant;
import net.minecraft.block.properties.IProperty;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.BlockLeaves;

public class BlockTFMagicLeaves extends BlockLeaves implements ModelRegisterCallback
{
    protected BlockTFMagicLeaves() {
        this.func_149711_c(0.2f);
        this.func_149713_g(1);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)BlockTFMagicLeaves.field_176236_b, (Comparable)true).func_177226_a((IProperty)BlockTFMagicLeaves.field_176237_a, (Comparable)true).func_177226_a((IProperty)BlockTFMagicLog.VARIANT, (Comparable)MagicWoodVariant.TIME));
    }
    
    public int func_149717_k(final IBlockState state) {
        return TFConfig.performance.leavesLightOpacity;
    }
    
    public BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { BlockTFMagicLog.VARIANT, (IProperty)BlockTFMagicLeaves.field_176236_b, (IProperty)BlockTFMagicLeaves.field_176237_a });
    }
    
    public int func_176201_c(final IBlockState state) {
        int i = 0;
        i |= ((MagicWoodVariant)state.func_177229_b((IProperty)BlockTFMagicLog.VARIANT)).ordinal();
        if (!(boolean)state.func_177229_b((IProperty)BlockTFMagicLeaves.field_176237_a)) {
            i |= 0x4;
        }
        if (state.func_177229_b((IProperty)BlockTFMagicLeaves.field_176236_b)) {
            i |= 0x8;
        }
        return i;
    }
    
    @Deprecated
    public IBlockState func_176203_a(final int meta) {
        final int variant = meta & 0x3;
        final MagicWoodVariant[] values = MagicWoodVariant.values();
        return this.func_176223_P().func_177226_a((IProperty)BlockTFMagicLog.VARIANT, (Comparable)values[variant % values.length]).func_177226_a((IProperty)BlockTFMagicLeaves.field_176237_a, (Comparable)((meta & 0x4) == 0x0)).func_177226_a((IProperty)BlockTFMagicLeaves.field_176236_b, (Comparable)((meta & 0x8) > 0));
    }
    
    public void func_149666_a(final CreativeTabs creativeTab, final NonNullList<ItemStack> list) {
        list.add((Object)new ItemStack((Block)this, 1, 0));
        list.add((Object)new ItemStack((Block)this, 1, 1));
        list.add((Object)new ItemStack((Block)this, 1, 2));
        list.add((Object)new ItemStack((Block)this, 1, 3));
    }
    
    public void func_180655_c(final IBlockState state, final World world, final BlockPos pos, final Random random) {
        if (state.func_177229_b((IProperty)BlockTFMagicLog.VARIANT) == MagicWoodVariant.TRANS) {
            for (int i = 0; i < 1; ++i) {
                this.sparkleRunes(world, pos, random);
            }
        }
    }
    
    public BlockPlanks.EnumType func_176233_b(final int meta) {
        return BlockPlanks.EnumType.OAK;
    }
    
    private void sparkleRunes(final World world, final BlockPos pos, final Random rand) {
        final double offset = 0.0625;
        final EnumFacing side = EnumFacing.func_176741_a(rand);
        double rx = pos.func_177958_n() + rand.nextFloat();
        double ry = pos.func_177956_o() + rand.nextFloat();
        double rz = pos.func_177952_p() + rand.nextFloat();
        if (side == EnumFacing.DOWN && world.func_175623_d(pos.func_177984_a())) {
            ry = pos.func_177956_o() + 1 + offset;
        }
        if (side == EnumFacing.UP && world.func_175623_d(pos.func_177977_b())) {
            ry = pos.func_177956_o() + 0 - offset;
        }
        if (side == EnumFacing.NORTH && world.func_175623_d(pos.func_177968_d())) {
            rz = pos.func_177952_p() + 1 + offset;
        }
        if (side == EnumFacing.SOUTH && world.func_175623_d(pos.func_177978_c())) {
            rz = pos.func_177952_p() + 0 - offset;
        }
        if (side == EnumFacing.WEST && world.func_175623_d(pos.func_177974_f())) {
            rx = pos.func_177958_n() + 1 + offset;
        }
        if (side == EnumFacing.EAST && world.func_175623_d(pos.func_177976_e())) {
            rx = pos.func_177958_n() + 0 - offset;
        }
        if (rx < pos.func_177958_n() || rx > pos.func_177958_n() + 1 || ry < pos.func_177956_o() || ry > pos.func_177956_o() + 1 || rz < pos.func_177952_p() || rz > pos.func_177952_p() + 1) {
            TwilightForestMod.proxy.spawnParticle(TFParticleType.LEAF_RUNE, rx, ry, rz, 0.0, 0.0, 0.0);
        }
    }
    
    public List<ItemStack> onSheared(final ItemStack item, final IBlockAccess world, final BlockPos pos, final int fortune) {
        return (List<ItemStack>)NonNullList.func_191197_a(1, (Object)new ItemStack((Block)this, 1, ((MagicWoodVariant)world.func_180495_p(pos).func_177229_b((IProperty)BlockTFMagicLog.VARIANT)).ordinal()));
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        final IStateMapper stateMapper = (IStateMapper)new StateMap.Builder().func_178442_a(new IProperty[] { (IProperty)BlockTFMagicLeaves.field_176236_b, (IProperty)BlockTFMagicLeaves.field_176237_a }).func_178441_a();
        ModelLoader.setCustomStateMapper((Block)this, stateMapper);
        ModelUtils.registerToStateSingleVariant((Block)this, BlockTFMagicLog.VARIANT, stateMapper);
    }
    
    protected boolean func_149700_E() {
        return false;
    }
    
    public int func_180651_a(final IBlockState state) {
        return ((MagicWoodVariant)state.func_177229_b((IProperty)BlockTFMagicLog.VARIANT)).ordinal();
    }
    
    public int func_149745_a(final Random random) {
        return 0;
    }
    
    public Item func_180660_a(final IBlockState state, final Random rand, final int fortune) {
        return Items.field_190931_a;
    }
    
    public void getDrops(final NonNullList<ItemStack> drops, final IBlockAccess world, final BlockPos pos, final IBlockState state, final int fortune) {
    }
}
