// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import java.util.Iterator;
import java.util.ArrayList;
import net.minecraft.item.Item;
import twilightforest.TwilightForestMod;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;

public class ItemTFFieryPick extends ItemPickaxe
{
    protected ItemTFFieryPick(final int par1, final EnumToolMaterial par2EnumToolMaterial) {
        super(par1, par2EnumToolMaterial);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public boolean func_77660_a(final ItemStack par1ItemStack, final World par2World, final int blockID, final int x, final int y, final int z, final EntityLiving par7EntityLiving) {
        if (super.func_77660_a(par1ItemStack, par2World, blockID, x, y, z, par7EntityLiving)) {
            final int meta = par2World.func_72805_g(x, y, z);
            final ArrayList items = Block.field_71973_m[blockID].getBlockDropped(par2World, x, y, z, meta, 0);
            for (final ItemStack input : items) {
                final ItemStack result = FurnaceRecipes.func_77602_a().getSmeltingResult(input);
                if (result != null) {
                    if (!par2World.field_72995_K) {
                        final float floatXP = FurnaceRecipes.func_77602_a().func_77601_c(result.field_77993_c);
                        int smeltXP = (int)floatXP;
                        if (floatXP > smeltXP && par2World.field_73012_v.nextFloat() < floatXP - smeltXP) {
                            ++smeltXP;
                        }
                        while (smeltXP > 0) {
                            final int splitXP = EntityXPOrb.func_70527_a(smeltXP);
                            smeltXP -= splitXP;
                            par2World.func_72838_d((Entity)new EntityXPOrb(par2World, x + 0.5, y + 0.5, z + 0.5, splitXP));
                        }
                        par2World.func_72838_d((Entity)new EntityItem(par2World, x + 0.5, y + 0.5, z + 0.5, result.func_77946_l()));
                        TwilightForestMod.eventListener.supressDrop(input);
                    }
                    else {
                        for (int var1 = 0; var1 < 5; ++var1) {
                            final double rx = Item.field_77697_d.nextGaussian() * 0.02;
                            final double ry = Item.field_77697_d.nextGaussian() * 0.02;
                            final double rz = Item.field_77697_d.nextGaussian() * 0.02;
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
    
    public boolean func_77644_a(final ItemStack par1ItemStack, final EntityLiving par2EntityLiving, final EntityLiving par3EntityLiving) {
        final boolean result = super.func_77644_a(par1ItemStack, par2EntityLiving, par3EntityLiving);
        if (result && !par2EntityLiving.func_70045_F()) {
            if (par2EntityLiving.field_70170_p.field_72995_K) {
                for (int var1 = 0; var1 < 20; ++var1) {
                    final double var2 = Item.field_77697_d.nextGaussian() * 0.02;
                    final double var3 = Item.field_77697_d.nextGaussian() * 0.02;
                    final double var4 = Item.field_77697_d.nextGaussian() * 0.02;
                    final double var5 = 10.0;
                    par2EntityLiving.field_70170_p.func_72869_a("flame", par2EntityLiving.field_70165_t + Item.field_77697_d.nextFloat() * par2EntityLiving.field_70130_N * 2.0f - par2EntityLiving.field_70130_N - var2 * var5, par2EntityLiving.field_70163_u + Item.field_77697_d.nextFloat() * par2EntityLiving.field_70131_O - var3 * var5, par2EntityLiving.field_70161_v + Item.field_77697_d.nextFloat() * par2EntityLiving.field_70130_N * 2.0f - par2EntityLiving.field_70130_N - var4 * var5, var2, var3, var4);
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
        return par2ItemStack.field_77993_c == TFItems.fieryIngot.field_77779_bT || super.func_82789_a(par1ItemStack, par2ItemStack);
    }
    
    public boolean func_77641_a(final Block par1Block) {
        return par1Block == Block.field_72089_ap || super.func_77641_a(par1Block);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IconRegister par1IconRegister) {
        this.field_77791_bV = par1IconRegister.func_94245_a("twilightforest:" + this.func_77658_a().substring(5));
    }
}
