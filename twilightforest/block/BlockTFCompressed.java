// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.DamageSource;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import java.util.List;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import twilightforest.client.ModelUtils;
import java.util.Collection;
import java.util.ArrayList;
import net.minecraft.item.ItemShears;
import net.minecraft.entity.player.EntityPlayer;
import javax.annotation.Nullable;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import twilightforest.enums.CompressedVariant;
import net.minecraft.block.properties.IProperty;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.Block;

public class BlockTFCompressed extends Block implements ModelRegisterCallback
{
    public static final IProperty<CompressedVariant> VARIANT;
    
    public BlockTFCompressed() {
        super(Material.field_151573_f, MapColor.field_151668_h);
        this.func_149711_c(5.0f);
        this.func_149752_b(10.0f);
        this.func_149672_a(SoundType.field_185852_e);
        this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)BlockTFCompressed.VARIANT, (Comparable)CompressedVariant.IRONWOOD));
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { BlockTFCompressed.VARIANT });
    }
    
    public int func_176201_c(final IBlockState state) {
        return ((CompressedVariant)state.func_177229_b((IProperty)BlockTFCompressed.VARIANT)).ordinal();
    }
    
    public IBlockState func_176203_a(final int meta) {
        return this.func_176223_P().func_177226_a((IProperty)BlockTFCompressed.VARIANT, (Comparable)CompressedVariant.values()[meta]);
    }
    
    public void func_149666_a(final CreativeTabs tab, final NonNullList<ItemStack> list) {
        for (final CompressedVariant variation : CompressedVariant.values()) {
            list.add((Object)new ItemStack((Block)this, 1, variation.ordinal()));
        }
    }
    
    @SideOnly(Side.CLIENT)
    public int func_185484_c(final IBlockState state, final IBlockAccess source, final BlockPos pos) {
        return (state.func_177229_b((IProperty)BlockTFCompressed.VARIANT) == CompressedVariant.FIERY) ? 15728880 : super.func_185484_c(state, source, pos);
    }
    
    public boolean func_149710_n(final IBlockState state) {
        return state.func_177229_b((IProperty)BlockTFCompressed.VARIANT) == CompressedVariant.FIERY || super.func_149710_n(state);
    }
    
    public SoundType getSoundType(final IBlockState state, final World world, final BlockPos pos, @Nullable final Entity entity) {
        return ((CompressedVariant)state.func_177229_b((IProperty)BlockTFCompressed.VARIANT)).soundType;
    }
    
    public Material func_149688_o(final IBlockState state) {
        return ((CompressedVariant)state.func_177229_b((IProperty)BlockTFCompressed.VARIANT)).material;
    }
    
    public MapColor func_180659_g(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        return ((CompressedVariant)state.func_177229_b((IProperty)BlockTFCompressed.VARIANT)).mapColor;
    }
    
    public float func_180647_a(final IBlockState state, final EntityPlayer player, final World worldIn, final BlockPos pos) {
        return (state.func_177229_b((IProperty)BlockTFCompressed.VARIANT) == CompressedVariant.ARCTIC_FUR && player.func_184614_ca().func_77973_b() instanceof ItemShears) ? 0.2f : super.func_180647_a(state, player, worldIn, pos);
    }
    
    public float func_176195_g(final IBlockState blockState, final World worldIn, final BlockPos pos) {
        switch ((CompressedVariant)blockState.func_177229_b((IProperty)BlockTFCompressed.VARIANT)) {
            default: {
                return super.func_176195_g(blockState, worldIn, pos);
            }
            case ARCTIC_FUR: {
                return 0.8f;
            }
            case CARMINITE: {
                return 0.0f;
            }
        }
    }
    
    public boolean isBeaconBase(final IBlockAccess worldObj, final BlockPos pos, final BlockPos beacon) {
        return true;
    }
    
    public int func_180651_a(final IBlockState state) {
        return this.func_176201_c(state);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        final List<CompressedVariant> variants = new ArrayList<CompressedVariant>(BlockTFCompressed.VARIANT.func_177700_c());
        for (int i = 0; i < variants.size(); ++i) {
            if (i != CompressedVariant.FIERY.ordinal()) {
                ModelUtils.registerToState(this, i, this.func_176223_P().func_177226_a((IProperty)BlockTFCompressed.VARIANT, (Comparable)variants.get(i)));
            }
        }
        final ModelResourceLocation mrl = new ModelResourceLocation(this.getRegistryName(), "inventory_fiery");
        ModelLoader.setCustomModelResourceLocation(Item.func_150898_a((Block)this), CompressedVariant.FIERY.ordinal(), mrl);
    }
    
    public void func_176199_a(final World worldIn, final BlockPos pos, final Entity entityIn) {
        if (!entityIn.func_70045_F() && entityIn instanceof EntityLivingBase && !EnchantmentHelper.func_189869_j((EntityLivingBase)entityIn) && worldIn.func_180495_p(pos).func_177229_b((IProperty)BlockTFCompressed.VARIANT) == CompressedVariant.FIERY) {
            entityIn.func_70097_a(DamageSource.field_190095_e, 1.0f);
        }
        super.func_176199_a(worldIn, pos, entityIn);
    }
    
    public void func_180658_a(final World worldIn, final BlockPos pos, final Entity entityIn, final float fallDistance) {
        switch ((CompressedVariant)worldIn.func_180495_p(pos).func_177229_b((IProperty)BlockTFCompressed.VARIANT)) {
            case STEELLEAF: {
                entityIn.func_180430_e(fallDistance, 0.75f);
                break;
            }
            case ARCTIC_FUR: {
                entityIn.func_180430_e(fallDistance, 0.1f);
                break;
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer func_180664_k() {
        return BlockRenderLayer.CUTOUT;
    }
    
    public boolean isFireSource(final World world, final BlockPos pos, final EnumFacing face) {
        return CompressedVariant.FIERY == world.func_180495_p(pos).func_177229_b((IProperty)BlockTFCompressed.VARIANT);
    }
    
    public boolean isStickyBlock(final IBlockState state) {
        return state.func_177229_b((IProperty)BlockTFCompressed.VARIANT) == CompressedVariant.CARMINITE;
    }
    
    @Deprecated
    @SideOnly(Side.CLIENT)
    public boolean func_176225_a(final IBlockState blockState, final IBlockAccess blockAccess, final BlockPos pos, final EnumFacing side) {
        if (blockState.func_177229_b((IProperty)BlockTFCompressed.VARIANT) == CompressedVariant.FIERY) {
            final IBlockState state = blockAccess.func_180495_p(pos.func_177972_a(side));
            return state.func_177230_c() != this || state.func_177229_b((IProperty)BlockTFCompressed.VARIANT) != CompressedVariant.FIERY;
        }
        return super.func_176225_a(blockState, blockAccess, pos, side);
    }
    
    static {
        VARIANT = (IProperty)PropertyEnum.func_177709_a("variant", (Class)CompressedVariant.class);
    }
}
