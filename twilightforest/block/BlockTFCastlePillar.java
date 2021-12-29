// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.block.properties.PropertyEnum;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import twilightforest.client.ModelUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.BlockLog;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import twilightforest.enums.CastlePillarVariant;
import net.minecraft.block.properties.IProperty;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.Block;

public class BlockTFCastlePillar extends Block implements ModelRegisterCallback
{
    public static final IProperty<CastlePillarVariant> VARIANT;
    
    BlockTFCastlePillar() {
        super(Material.field_151576_e, MapColor.field_151677_p);
        this.func_149711_c(100.0f);
        this.func_149752_b(35.0f);
        this.func_149672_a(SoundType.field_185851_d);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)BlockTFCastlePillar.VARIANT, (Comparable)CastlePillarVariant.ENCASED).func_177226_a((IProperty)BlockLog.field_176299_a, (Comparable)BlockLog.EnumAxis.Y));
    }
    
    public IBlockState getStateForPlacement(final World world, final BlockPos pos, final EnumFacing facing, final float hitX, final float hitY, final float hitZ, final int meta, final EntityLivingBase placer, final EnumHand hand) {
        final ItemStack stack = placer.func_184586_b(hand);
        return this.func_176223_P().func_177226_a((IProperty)BlockLog.field_176299_a, (Comparable)(((stack.func_77960_j() & 0x1) == 0x1) ? BlockLog.EnumAxis.NONE : BlockLog.EnumAxis.func_176870_a(facing.func_176740_k()))).func_177226_a((IProperty)BlockTFCastlePillar.VARIANT, (Comparable)CastlePillarVariant.values()[stack.func_77960_j() / 2 & 0x1]);
    }
    
    public BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { (IProperty)BlockLog.field_176299_a, BlockTFCastlePillar.VARIANT });
    }
    
    public int func_176201_c(final IBlockState state) {
        return ((CastlePillarVariant)state.func_177229_b((IProperty)BlockTFCastlePillar.VARIANT)).ordinal() << 2 | ((BlockLog.EnumAxis)state.func_177229_b((IProperty)BlockLog.field_176299_a)).ordinal();
    }
    
    @Deprecated
    public IBlockState func_176203_a(final int meta) {
        return this.func_176223_P().func_177226_a((IProperty)BlockTFCastlePillar.VARIANT, (Comparable)CastlePillarVariant.values()[(meta & 0xC) >> 2 & 0x1]).func_177226_a((IProperty)BlockLog.field_176299_a, (Comparable)BlockLog.EnumAxis.values()[meta & 0x3]);
    }
    
    public void func_149666_a(final CreativeTabs creativeTab, final NonNullList<ItemStack> list) {
        for (final CastlePillarVariant variant : CastlePillarVariant.values()) {
            list.add((Object)new ItemStack((Block)this, 1, variant.ordinal() * 2));
            list.add((Object)new ItemStack((Block)this, 1, variant.ordinal() * 2 + 1));
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        final CastlePillarVariant[] variantsList = CastlePillarVariant.values();
        for (int i = 0; i < variantsList.length; ++i) {
            ModelUtils.registerToState(this, i * 2, this.func_176223_P().func_177226_a((IProperty)BlockLog.field_176299_a, (Comparable)BlockLog.EnumAxis.Y).func_177226_a((IProperty)BlockTFCastlePillar.VARIANT, (Comparable)variantsList[i]));
            ModelUtils.registerToState(this, i * 2 + 1, this.func_176223_P().func_177226_a((IProperty)BlockLog.field_176299_a, (Comparable)BlockLog.EnumAxis.NONE).func_177226_a((IProperty)BlockTFCastlePillar.VARIANT, (Comparable)variantsList[i]));
        }
    }
    
    public int func_180651_a(final IBlockState state) {
        return ((CastlePillarVariant)state.func_177229_b((IProperty)BlockTFCastlePillar.VARIANT)).ordinal() << 1 | ((state.func_177229_b((IProperty)BlockLog.field_176299_a) == BlockLog.EnumAxis.NONE) ? 1 : 0);
    }
    
    protected ItemStack func_180643_i(final IBlockState state) {
        return new ItemStack((Block)this, 1, this.func_180651_a(state));
    }
    
    static {
        VARIANT = (IProperty)PropertyEnum.func_177709_a("variant", (Class)CastlePillarVariant.class);
    }
}
