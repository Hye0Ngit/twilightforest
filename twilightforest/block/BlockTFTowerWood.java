// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.block.properties.PropertyEnum;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import twilightforest.client.ModelUtils;
import net.minecraft.util.EnumFacing;
import net.minecraft.entity.Entity;
import twilightforest.entity.EntityTFTowerTermite;
import net.minecraft.world.World;
import java.util.Random;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import twilightforest.enums.TowerWoodVariant;
import net.minecraft.block.properties.IProperty;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.Block;

public class BlockTFTowerWood extends Block implements ModelRegisterCallback
{
    public static final IProperty<TowerWoodVariant> VARIANT;
    
    public BlockTFTowerWood() {
        super(Material.field_151575_d, MapColor.field_151676_q);
        this.func_149711_c(40.0f);
        this.func_149752_b(10.0f);
        this.func_149672_a(SoundType.field_185848_a);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)BlockTFTowerWood.VARIANT, (Comparable)TowerWoodVariant.PLAIN));
    }
    
    public BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { BlockTFTowerWood.VARIANT });
    }
    
    public int func_176201_c(final IBlockState state) {
        return ((TowerWoodVariant)state.func_177229_b((IProperty)BlockTFTowerWood.VARIANT)).ordinal();
    }
    
    @Deprecated
    public IBlockState func_176203_a(final int meta) {
        return this.func_176223_P().func_177226_a((IProperty)BlockTFTowerWood.VARIANT, (Comparable)TowerWoodVariant.values()[meta]);
    }
    
    public MapColor func_180659_g(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        return (state.func_177229_b((IProperty)BlockTFTowerWood.VARIANT) == TowerWoodVariant.ENCASED) ? MapColor.field_151658_d : super.func_180659_g(state, world, pos);
    }
    
    public void func_149666_a(final CreativeTabs creativeTab, final NonNullList<ItemStack> list) {
        for (final TowerWoodVariant variant : TowerWoodVariant.values()) {
            list.add((Object)new ItemStack((Block)this, 1, variant.ordinal()));
        }
    }
    
    public int func_180651_a(final IBlockState state) {
        return this.func_176201_c(state);
    }
    
    public int quantityDropped(final IBlockState state, final int fortune, final Random random) {
        if (state.func_177229_b((IProperty)BlockTFTowerWood.VARIANT) == TowerWoodVariant.INFESTED) {
            return 0;
        }
        return super.quantityDropped(state, fortune, random);
    }
    
    @Deprecated
    public float func_176195_g(final IBlockState state, final World world, final BlockPos pos) {
        if (state.func_177229_b((IProperty)BlockTFTowerWood.VARIANT) == TowerWoodVariant.INFESTED) {
            return 0.75f;
        }
        return super.func_176195_g(state, world, pos);
    }
    
    public void func_180653_a(final World world, final BlockPos pos, final IBlockState state, final float chance, final int fortune) {
        if (!world.field_72995_K && state.func_177229_b((IProperty)BlockTFTowerWood.VARIANT) == TowerWoodVariant.INFESTED) {
            final EntityTFTowerTermite termite = new EntityTFTowerTermite(world);
            termite.func_70012_b(pos.func_177958_n() + 0.5, (double)pos.func_177956_o(), pos.func_177952_p() + 0.5, 0.0f, 0.0f);
            world.func_72838_d((Entity)termite);
            termite.func_70656_aK();
        }
        super.func_180653_a(world, pos, state, chance, fortune);
    }
    
    public int getFlammability(final IBlockAccess world, final BlockPos pos, final EnumFacing side) {
        return 1;
    }
    
    public int getFireSpreadSpeed(final IBlockAccess world, final BlockPos pos, final EnumFacing side) {
        return 0;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        ModelUtils.registerToStateSingleVariant(this, BlockTFTowerWood.VARIANT);
    }
    
    static {
        VARIANT = (IProperty)PropertyEnum.func_177709_a("variant", (Class)TowerWoodVariant.class);
    }
}
