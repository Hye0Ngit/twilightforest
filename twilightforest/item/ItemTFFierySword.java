// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.util.StatCollector;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import java.util.List;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class ItemTFFierySword extends ItemSword
{
    public ItemTFFierySword(final Item.ToolMaterial par2EnumToolMaterial) {
        super(par2EnumToolMaterial);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public void func_150895_a(final Item par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        final ItemStack istack = new ItemStack(par1, 1, 0);
        par3List.add(istack);
    }
    
    public EnumRarity func_77613_e(final ItemStack par1ItemStack) {
        return EnumRarity.rare;
    }
    
    public boolean func_82789_a(final ItemStack par1ItemStack, final ItemStack par2ItemStack) {
        return par2ItemStack.func_77973_b() == TFItems.fieryIngot || super.func_82789_a(par1ItemStack, par2ItemStack);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IIconRegister par1IconRegister) {
        this.field_77791_bV = par1IconRegister.func_94245_a("TwilightForest:" + this.func_77658_a().substring(5));
    }
    
    public boolean func_77644_a(final ItemStack par1ItemStack, final EntityLivingBase par2EntityLiving, final EntityLivingBase par3EntityLiving) {
        final boolean result = super.func_77644_a(par1ItemStack, par2EntityLiving, par3EntityLiving);
        if (result && !par2EntityLiving.func_70045_F()) {
            if (par2EntityLiving.field_70170_p.field_72995_K) {
                for (int var1 = 0; var1 < 20; ++var1) {
                    final double var2 = ItemTFFierySword.field_77697_d.nextGaussian() * 0.02;
                    final double var3 = ItemTFFierySword.field_77697_d.nextGaussian() * 0.02;
                    final double var4 = ItemTFFierySword.field_77697_d.nextGaussian() * 0.02;
                    final double var5 = 10.0;
                    par2EntityLiving.field_70170_p.func_72869_a("flame", par2EntityLiving.field_70165_t + ItemTFFierySword.field_77697_d.nextFloat() * par2EntityLiving.field_70130_N * 2.0f - par2EntityLiving.field_70130_N - var2 * var5, par2EntityLiving.field_70163_u + ItemTFFierySword.field_77697_d.nextFloat() * par2EntityLiving.field_70131_O - var3 * var5, par2EntityLiving.field_70161_v + ItemTFFierySword.field_77697_d.nextFloat() * par2EntityLiving.field_70130_N * 2.0f - par2EntityLiving.field_70130_N - var4 * var5, var2, var3, var4);
                }
            }
            else {
                par2EntityLiving.func_70015_d(15);
            }
        }
        return result;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_77624_a(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        super.func_77624_a(par1ItemStack, par2EntityPlayer, par3List, par4);
        par3List.add(StatCollector.func_74838_a(this.func_77658_a() + ".tooltip"));
    }
}
