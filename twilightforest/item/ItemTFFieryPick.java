// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import java.util.Iterator;
import java.util.ArrayList;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;

public class ItemTFFieryPick extends ItemPickaxe
{
    protected ItemTFFieryPick(final Item.ToolMaterial par2EnumToolMaterial) {
        super(par2EnumToolMaterial);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public boolean func_150894_a(final ItemStack par1ItemStack, final World par2World, final Block blockID, final int x, final int y, final int z, final EntityLivingBase par7EntityLiving) {
        if (super.func_150894_a(par1ItemStack, par2World, blockID, x, y, z, par7EntityLiving) && this.func_150897_b(blockID)) {
            if (par2World.field_72995_K) {
                final int meta = par2World.func_72805_g(x, y, z);
                final ArrayList<ItemStack> items = blockID.getDrops(par2World, x, y, z, meta, 0);
                for (final ItemStack input : items) {
                    final ItemStack result = FurnaceRecipes.func_77602_a().func_151395_a(input);
                    if (result != null) {
                        for (int var1 = 0; var1 < 5; ++var1) {
                            final double rx = ItemTFFieryPick.field_77697_d.nextGaussian() * 0.02;
                            final double ry = ItemTFFieryPick.field_77697_d.nextGaussian() * 0.02;
                            final double rz = ItemTFFieryPick.field_77697_d.nextGaussian() * 0.02;
                            final double magnitude = 20.0;
                            par2World.func_72869_a("flame", x + 0.5 + rx * magnitude, y + 0.5 + ry * magnitude, z + 0.5 + rz * magnitude, -rx, -ry, -rz);
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
    
    public boolean func_77644_a(final ItemStack par1ItemStack, final EntityLivingBase par2EntityLiving, final EntityLivingBase par3EntityLiving) {
        final boolean result = super.func_77644_a(par1ItemStack, par2EntityLiving, par3EntityLiving);
        if (result && !par2EntityLiving.func_70045_F()) {
            if (par2EntityLiving.field_70170_p.field_72995_K) {
                for (int var1 = 0; var1 < 20; ++var1) {
                    final double var2 = ItemTFFieryPick.field_77697_d.nextGaussian() * 0.02;
                    final double var3 = ItemTFFieryPick.field_77697_d.nextGaussian() * 0.02;
                    final double var4 = ItemTFFieryPick.field_77697_d.nextGaussian() * 0.02;
                    final double var5 = 10.0;
                    par2EntityLiving.field_70170_p.func_72869_a("flame", par2EntityLiving.field_70165_t + ItemTFFieryPick.field_77697_d.nextFloat() * par2EntityLiving.field_70130_N * 2.0f - par2EntityLiving.field_70130_N - var2 * var5, par2EntityLiving.field_70163_u + ItemTFFieryPick.field_77697_d.nextFloat() * par2EntityLiving.field_70131_O - var3 * var5, par2EntityLiving.field_70161_v + ItemTFFieryPick.field_77697_d.nextFloat() * par2EntityLiving.field_70130_N * 2.0f - par2EntityLiving.field_70130_N - var4 * var5, var2, var3, var4);
                }
            }
            else {
                par2EntityLiving.func_70015_d(15);
            }
        }
        return result;
    }
    
    public EnumRarity func_77613_e(final ItemStack par1ItemStack) {
        return EnumRarity.rare;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_77624_a(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        super.func_77624_a(par1ItemStack, par2EntityPlayer, par3List, par4);
        par3List.add("Auto-smelting");
    }
    
    public boolean func_82789_a(final ItemStack par1ItemStack, final ItemStack par2ItemStack) {
        return par2ItemStack.func_77973_b() == TFItems.fieryIngot || super.func_82789_a(par1ItemStack, par2ItemStack);
    }
    
    public boolean func_150897_b(final Block par1Block) {
        return par1Block == Blocks.field_150343_Z || super.func_150897_b(par1Block);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IIconRegister par1IconRegister) {
        this.field_77791_bV = par1IconRegister.func_94245_a("TwilightForest:" + this.func_77658_a().substring(5));
    }
}
