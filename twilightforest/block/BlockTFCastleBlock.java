// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import twilightforest.client.ModelUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.entity.EntityLivingBase;
import twilightforest.item.ItemTFMazebreakerPick;
import net.minecraft.item.ItemTool;
import net.minecraft.item.ItemStack;
import javax.annotation.Nullable;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import twilightforest.enums.CastleBrickVariant;
import net.minecraft.block.properties.IProperty;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.Block;

public class BlockTFCastleBlock extends Block implements ModelRegisterCallback
{
    public static final IProperty<CastleBrickVariant> VARIANT;
    
    public BlockTFCastleBlock() {
        super(Material.field_151576_e, MapColor.field_151677_p);
        this.func_149711_c(100.0f);
        this.func_149752_b(35.0f);
        this.func_149672_a(SoundType.field_185851_d);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)BlockTFCastleBlock.VARIANT, (Comparable)CastleBrickVariant.NORMAL));
    }
    
    public BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { BlockTFCastleBlock.VARIANT });
    }
    
    public int func_176201_c(final IBlockState state) {
        return ((CastleBrickVariant)state.func_177229_b((IProperty)BlockTFCastleBlock.VARIANT)).ordinal();
    }
    
    @Deprecated
    public IBlockState func_176203_a(final int meta) {
        return this.func_176223_P().func_177226_a((IProperty)BlockTFCastleBlock.VARIANT, (Comparable)CastleBrickVariant.values()[meta]);
    }
    
    public MapColor func_180659_g(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        return (state.func_177229_b((IProperty)BlockTFCastleBlock.VARIANT) == CastleBrickVariant.ROOF) ? MapColor.field_151670_w : super.func_180659_g(state, world, pos);
    }
    
    public void func_180657_a(final World world, final EntityPlayer player, final BlockPos pos, final IBlockState state, @Nullable final TileEntity te, final ItemStack stack) {
        final ItemStack cei = player.func_184614_ca();
        if (cei.func_77973_b() instanceof ItemTool && !(cei.func_77973_b() instanceof ItemTFMazebreakerPick)) {
            cei.func_77972_a(16, (EntityLivingBase)player);
        }
        super.func_180657_a(world, player, pos, state, te, stack);
    }
    
    public void func_149666_a(final CreativeTabs creativeTab, final NonNullList<ItemStack> items) {
        for (final CastleBrickVariant variant : CastleBrickVariant.values()) {
            items.add((Object)new ItemStack((Block)this, 1, variant.ordinal()));
        }
    }
    
    public int func_180651_a(final IBlockState state) {
        return this.func_176201_c(state);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        ModelUtils.registerToStateSingleVariant(this, BlockTFCastleBlock.VARIANT);
    }
    
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer func_180664_k() {
        return BlockRenderLayer.CUTOUT;
    }
    
    static {
        VARIANT = (IProperty)PropertyEnum.func_177709_a("variant", (Class)CastleBrickVariant.class);
    }
}
