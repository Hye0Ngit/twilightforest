// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.block.properties.PropertyEnum;
import twilightforest.client.ModelUtils;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import twilightforest.enums.TowerDeviceVariant;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.AxisAlignedBB;
import twilightforest.enums.TowerTranslucentVariant;
import net.minecraft.block.properties.IProperty;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.Block;

public class BlockTFTowerTranslucent extends Block implements ModelRegisterCallback
{
    public static final IProperty<TowerTranslucentVariant> VARIANT;
    private static final AxisAlignedBB REAPPEARING_BB;
    
    public BlockTFTowerTranslucent() {
        super(Material.field_151592_s);
        this.func_149711_c(50.0f);
        this.func_149752_b(2000.0f);
        this.func_149672_a(SoundType.field_185852_e);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)BlockTFTowerTranslucent.VARIANT, (Comparable)TowerTranslucentVariant.REAPPEARING_INACTIVE));
    }
    
    public BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { BlockTFTowerTranslucent.VARIANT });
    }
    
    public int func_176201_c(final IBlockState state) {
        return ((TowerTranslucentVariant)state.func_177229_b((IProperty)BlockTFTowerTranslucent.VARIANT)).ordinal();
    }
    
    @Deprecated
    public IBlockState func_176203_a(final int meta) {
        return this.func_176223_P().func_177226_a((IProperty)BlockTFTowerTranslucent.VARIANT, (Comparable)TowerTranslucentVariant.values()[meta]);
    }
    
    @Deprecated
    public boolean func_149662_c(final IBlockState state) {
        return false;
    }
    
    @Deprecated
    public boolean func_149686_d(final IBlockState state) {
        return false;
    }
    
    public int func_149738_a(final World world) {
        return 15;
    }
    
    public Item func_180660_a(final IBlockState state, final Random random, final int fortune) {
        return Items.field_190931_a;
    }
    
    public boolean canSilkHarvest(final World world, final BlockPos pos, final IBlockState state, final EntityPlayer player) {
        return false;
    }
    
    @Deprecated
    public AxisAlignedBB func_180646_a(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        switch ((TowerTranslucentVariant)state.func_177229_b((IProperty)BlockTFTowerTranslucent.VARIANT)) {
            case REAPPEARING_INACTIVE:
            case REAPPEARING_ACTIVE: {
                return BlockTFTowerTranslucent.field_185506_k;
            }
            default: {
                return super.func_180646_a(state, world, pos);
            }
        }
    }
    
    @Deprecated
    public AxisAlignedBB func_185496_a(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        switch ((TowerTranslucentVariant)state.func_177229_b((IProperty)BlockTFTowerTranslucent.VARIANT)) {
            case REAPPEARING_INACTIVE:
            case REAPPEARING_ACTIVE: {
                return BlockTFTowerTranslucent.REAPPEARING_BB;
            }
            default: {
                return BlockTFTowerTranslucent.field_185505_j;
            }
        }
    }
    
    @Deprecated
    public BlockFaceShape func_193383_a(final IBlockAccess worldIn, final IBlockState state, final BlockPos pos, final EnumFacing face) {
        switch ((TowerTranslucentVariant)state.func_177229_b((IProperty)BlockTFTowerTranslucent.VARIANT)) {
            case REAPPEARING_INACTIVE:
            case REAPPEARING_ACTIVE: {
                return BlockFaceShape.UNDEFINED;
            }
            default: {
                return super.func_193383_a(worldIn, state, pos, face);
            }
        }
    }
    
    @Deprecated
    public float func_176195_g(final IBlockState state, final World world, final BlockPos pos) {
        switch ((TowerTranslucentVariant)state.func_177229_b((IProperty)BlockTFTowerTranslucent.VARIANT)) {
            case REVERTER_REPLACEMENT:
            case REACTOR_DEBRIS: {
                return 0.3f;
            }
            default: {
                return super.func_176195_g(state, world, pos);
            }
        }
    }
    
    public boolean func_176205_b(final IBlockAccess world, final BlockPos pos) {
        switch ((TowerTranslucentVariant)world.func_180495_p(pos).func_177229_b((IProperty)BlockTFTowerTranslucent.VARIANT)) {
            case REAPPEARING_INACTIVE:
            case REAPPEARING_ACTIVE: {
                return true;
            }
            default: {
                return false;
            }
        }
    }
    
    public void func_180650_b(final World world, final BlockPos pos, final IBlockState state, final Random random) {
        if (world.field_72995_K) {
            return;
        }
        final TowerTranslucentVariant variant = (TowerTranslucentVariant)state.func_177229_b((IProperty)BlockTFTowerTranslucent.VARIANT);
        if (variant == TowerTranslucentVariant.BUILT_ACTIVE) {
            world.func_175698_g(pos);
            world.func_175722_b(pos, (Block)this, false);
            world.func_184133_a((EntityPlayer)null, pos, SoundEvents.field_187638_cR, SoundCategory.BLOCKS, 0.3f, 0.5f);
            for (final EnumFacing e : EnumFacing.field_82609_l) {
                BlockTFTowerDevice.checkAndActivateVanishBlock(world, pos.func_177972_a(e));
            }
        }
        else if (variant == TowerTranslucentVariant.REAPPEARING_ACTIVE) {
            world.func_175656_a(pos, TFBlocks.tower_device.func_176223_P().func_177226_a((IProperty)BlockTFTowerDevice.VARIANT, (Comparable)TowerDeviceVariant.REAPPEARING_INACTIVE));
            world.func_175722_b(pos, (Block)this, false);
            world.func_184133_a((EntityPlayer)null, pos, SoundEvents.field_187883_gR, SoundCategory.BLOCKS, 0.3f, 0.5f);
        }
        else if (variant == TowerTranslucentVariant.REAPPEARING_INACTIVE) {
            BlockTFTowerDevice.changeToActiveVanishBlock(world, pos, TowerTranslucentVariant.REAPPEARING_ACTIVE);
        }
    }
    
    public void func_149666_a(final CreativeTabs creativeTab, final NonNullList<ItemStack> list) {
    }
    
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer func_180664_k() {
        return BlockRenderLayer.CUTOUT;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        ModelUtils.registerToStateSingleVariant(this, BlockTFTowerTranslucent.VARIANT);
    }
    
    static {
        VARIANT = (IProperty)PropertyEnum.func_177709_a("variant", (Class)TowerTranslucentVariant.class);
        REAPPEARING_BB = new AxisAlignedBB(0.375, 0.375, 0.375, 0.625, 0.625, 0.625);
    }
}
