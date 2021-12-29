// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantment;
import cpw.mods.fml.common.eventhandler.Event;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.item.ItemBow;

public abstract class ItemTFBowBase extends ItemBow
{
    private IIcon[] iconArray;
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IIconRegister par1IconRegister) {
        this.field_77791_bV = par1IconRegister.func_94245_a(this.func_111208_A() + "_standby");
        this.iconArray = new IIcon[ItemTFBowBase.field_94601_a.length];
        for (int i = 0; i < this.iconArray.length; ++i) {
            this.iconArray[i] = par1IconRegister.func_94245_a(this.func_111208_A() + "_" + ItemTFBowBase.field_94601_a[i]);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon func_94599_c(final int par1) {
        return this.iconArray[par1];
    }
    
    public IIcon getIcon(final ItemStack stack, final int renderPass, final EntityPlayer player, final ItemStack usingItem, final int useRemaining) {
        if (usingItem != null) {
            final int j = usingItem.func_77988_m() - useRemaining;
            if (j >= 18) {
                return this.func_94599_c(2);
            }
            if (j > 13) {
                return this.func_94599_c(1);
            }
            if (j > 0) {
                return this.func_94599_c(0);
            }
        }
        return this.getIcon(stack, renderPass);
    }
    
    public void func_77615_a(final ItemStack itemstack, final World world, final EntityPlayer entityPlayer, final int itemInUseCount) {
        int charge = this.func_77626_a(itemstack) - itemInUseCount;
        final ArrowLooseEvent event = new ArrowLooseEvent(entityPlayer, itemstack, charge);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (event.isCanceled()) {
            return;
        }
        charge = event.charge;
        final boolean isNoPickup = entityPlayer.field_71075_bZ.field_75098_d || EnchantmentHelper.func_77506_a(Enchantment.field_77342_w.field_77352_x, itemstack) > 0;
        if (isNoPickup || entityPlayer.field_71071_by.func_146028_b(Items.field_151032_g)) {
            float velocity = charge / 20.0f;
            velocity = (velocity * velocity + velocity * 2.0f) / 3.0f;
            if (velocity < 0.1) {
                return;
            }
            if (velocity > 1.0f) {
                velocity = 1.0f;
            }
            final EntityArrow entityarrow = this.getArrow(world, entityPlayer, velocity * 2.0f);
            if (velocity == 1.0f) {
                entityarrow.func_70243_d(true);
            }
            final int powerLevel = EnchantmentHelper.func_77506_a(Enchantment.field_77345_t.field_77352_x, itemstack);
            if (powerLevel > 0) {
                entityarrow.func_70239_b(entityarrow.func_70242_d() + powerLevel * 0.5 + 0.5);
            }
            final int punchLevel = EnchantmentHelper.func_77506_a(Enchantment.field_77344_u.field_77352_x, itemstack);
            if (punchLevel > 0) {
                entityarrow.func_70240_a(punchLevel);
            }
            if (EnchantmentHelper.func_77506_a(Enchantment.field_77343_v.field_77352_x, itemstack) > 0) {
                entityarrow.func_70015_d(100);
            }
            itemstack.func_77972_a(1, (EntityLivingBase)entityPlayer);
            world.func_72956_a((Entity)entityPlayer, "random.bow", 1.0f, 1.0f / (ItemTFBowBase.field_77697_d.nextFloat() * 0.4f + 1.2f) + velocity * 0.5f);
            if (isNoPickup) {
                entityarrow.field_70251_a = 2;
            }
            else {
                entityPlayer.field_71071_by.func_146026_a(Items.field_151032_g);
            }
            if (!world.field_72995_K) {
                world.func_72838_d((Entity)entityarrow);
            }
        }
    }
    
    protected EntityArrow getArrow(final World world, final EntityPlayer entityPlayer, final float velocity) {
        return new EntityArrow(world, (EntityLivingBase)entityPlayer, velocity);
    }
}
