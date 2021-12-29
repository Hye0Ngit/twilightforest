// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantment;
import cpw.mods.fml.common.eventhandler.Event;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

public class ItemTFTripleBow extends ItemTFBowBase
{
    public ItemTFTripleBow() {
        this.func_111206_d("TwilightForest:triplebow");
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    @Override
    public void func_77615_a(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer, final int par4) {
        int j = this.func_77626_a(par1ItemStack) - par4;
        final ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer, par1ItemStack, j);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (event.isCanceled()) {
            return;
        }
        j = event.charge;
        final boolean flag = par3EntityPlayer.field_71075_bZ.field_75098_d || EnchantmentHelper.func_77506_a(Enchantment.field_77342_w.field_77352_x, par1ItemStack) > 0;
        if (flag || par3EntityPlayer.field_71071_by.func_146028_b(Items.field_151032_g)) {
            float f = j / 20.0f;
            f = (f * f + f * 2.0f) / 3.0f;
            if (f < 0.1) {
                return;
            }
            if (f > 1.0f) {
                f = 1.0f;
            }
            final EntityArrow entityarrow = new EntityArrow(par2World, (EntityLivingBase)par3EntityPlayer, f * 2.0f);
            final EntityArrow entityArrow;
            final EntityArrow entityarrow2 = entityArrow = new EntityArrow(par2World, (EntityLivingBase)par3EntityPlayer, f * 2.0f);
            entityArrow.field_70181_x += 0.14999999664723873;
            final EntityArrow entityArrow2 = entityarrow2;
            entityArrow2.field_70163_u += 0.02500000037252903;
            final EntityArrow entityArrow3;
            final EntityArrow entityarrow3 = entityArrow3 = new EntityArrow(par2World, (EntityLivingBase)par3EntityPlayer, f * 2.0f);
            entityArrow3.field_70181_x -= 0.14999999664723873;
            final EntityArrow entityArrow4 = entityarrow3;
            entityArrow4.field_70163_u -= 0.02500000037252903;
            if (f == 1.0f) {
                entityarrow.func_70243_d(true);
                entityarrow2.func_70243_d(true);
                entityarrow3.func_70243_d(true);
            }
            final int k = EnchantmentHelper.func_77506_a(Enchantment.field_77345_t.field_77352_x, par1ItemStack);
            if (k > 0) {
                entityarrow.func_70239_b(entityarrow.func_70242_d() + k * 0.5 + 0.5);
                entityarrow2.func_70239_b(entityarrow.func_70242_d() + k * 0.5 + 0.5);
                entityarrow3.func_70239_b(entityarrow.func_70242_d() + k * 0.5 + 0.5);
            }
            final int l = EnchantmentHelper.func_77506_a(Enchantment.field_77344_u.field_77352_x, par1ItemStack);
            if (l > 0) {
                entityarrow.func_70240_a(l);
                entityarrow2.func_70240_a(l);
                entityarrow3.func_70240_a(l);
            }
            if (EnchantmentHelper.func_77506_a(Enchantment.field_77343_v.field_77352_x, par1ItemStack) > 0) {
                entityarrow.func_70015_d(100);
                entityarrow2.func_70015_d(100);
                entityarrow3.func_70015_d(100);
            }
            par1ItemStack.func_77972_a(1, (EntityLivingBase)par3EntityPlayer);
            par2World.func_72956_a((Entity)par3EntityPlayer, "random.bow", 1.0f, 1.0f / (ItemTFTripleBow.field_77697_d.nextFloat() * 0.4f + 1.2f) + f * 0.5f);
            if (flag) {
                entityarrow.field_70251_a = 2;
            }
            else {
                par3EntityPlayer.field_71071_by.func_146026_a(Items.field_151032_g);
            }
            entityarrow2.field_70251_a = 2;
            entityarrow3.field_70251_a = 2;
            if (!par2World.field_72995_K) {
                par2World.func_72838_d((Entity)entityarrow);
                par2World.func_72838_d((Entity)entityarrow2);
                par2World.func_72838_d((Entity)entityarrow3);
            }
        }
    }
}
