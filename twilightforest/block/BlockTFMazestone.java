// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.block.properties.PropertyEnum;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import twilightforest.client.ModelUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityLivingBase;
import twilightforest.item.ItemTFMazebreakerPick;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import twilightforest.enums.MazestoneVariant;
import net.minecraft.block.properties.IProperty;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.Block;

public class BlockTFMazestone extends Block implements ModelRegisterCallback
{
    public static final IProperty<MazestoneVariant> VARIANT;
    
    public BlockTFMazestone() {
        super(Material.field_151576_e);
        this.func_149711_c(100.0f);
        this.func_149752_b(5.0f);
        this.func_149672_a(SoundType.field_185851_d);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)BlockTFMazestone.VARIANT, (Comparable)MazestoneVariant.PLAIN));
    }
    
    public BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { BlockTFMazestone.VARIANT });
    }
    
    public int func_176201_c(final IBlockState state) {
        return ((MazestoneVariant)state.func_177229_b((IProperty)BlockTFMazestone.VARIANT)).ordinal();
    }
    
    @Deprecated
    public IBlockState func_176203_a(final int meta) {
        return this.func_176223_P().func_177226_a((IProperty)BlockTFMazestone.VARIANT, (Comparable)MazestoneVariant.values()[meta]);
    }
    
    public void func_176208_a(final World world, final BlockPos pos, final IBlockState state, final EntityPlayer player) {
        super.func_176208_a(world, pos, state, player);
        final ItemStack stack = player.func_184586_b(EnumHand.MAIN_HAND);
        if (!world.field_72995_K && !stack.func_190926_b() && stack.func_77973_b().func_77645_m() && !(stack.func_77973_b() instanceof ItemTFMazebreakerPick)) {
            stack.func_77972_a(16, (EntityLivingBase)player);
        }
    }
    
    public void func_149666_a(final CreativeTabs creativeTab, final NonNullList<ItemStack> list) {
        for (final MazestoneVariant variant : MazestoneVariant.values()) {
            list.add((Object)new ItemStack((Block)this, 1, variant.ordinal()));
        }
    }
    
    public int func_180651_a(final IBlockState state) {
        return this.func_176201_c(state);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        ModelUtils.registerToStateSingleVariant(this, BlockTFMazestone.VARIANT);
    }
    
    static {
        VARIANT = (IProperty)PropertyEnum.func_177709_a("variant", (Class)MazestoneVariant.class);
    }
}
