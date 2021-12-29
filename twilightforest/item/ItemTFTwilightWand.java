// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.EnumAction;
import net.minecraft.entity.EntityLivingBase;
import twilightforest.entity.EntityTFTwilightWandBolt;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

public class ItemTFTwilightWand extends ItemTF
{
    protected ItemTFTwilightWand() {
        this.field_77777_bU = 1;
        this.func_77656_e(99);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public ItemStack func_77659_a(final ItemStack par1ItemStack, final World worldObj, final EntityPlayer player) {
        if (par1ItemStack.func_77960_j() < this.func_77612_l()) {
            player.func_71008_a(par1ItemStack, this.func_77626_a(par1ItemStack));
        }
        else {
            player.func_71034_by();
        }
        return par1ItemStack;
    }
    
    public void onUsingTick(final ItemStack stack, final EntityPlayer player, final int count) {
        if (stack.func_77960_j() >= this.func_77612_l()) {
            player.func_71034_by();
            return;
        }
        if (count % 6 == 0) {
            final World worldObj = player.field_70170_p;
            worldObj.func_72956_a((Entity)player, "mob.ghast.fireball", 1.0f, (worldObj.field_73012_v.nextFloat() - worldObj.field_73012_v.nextFloat()) * 0.2f + 1.0f);
            if (!worldObj.field_72995_K) {
                worldObj.func_72838_d((Entity)new EntityTFTwilightWandBolt(worldObj, (EntityLivingBase)player));
                stack.func_77972_a(1, (EntityLivingBase)player);
            }
        }
    }
    
    public int func_77626_a(final ItemStack par1ItemStack) {
        return 72000;
    }
    
    public EnumAction func_77661_b(final ItemStack par1ItemStack) {
        return EnumAction.bow;
    }
    
    @Override
    public EnumRarity func_77613_e(final ItemStack par1ItemStack) {
        return EnumRarity.rare;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_77624_a(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        super.func_77624_a(par1ItemStack, par2EntityPlayer, par3List, par4);
        par3List.add(par1ItemStack.func_77958_k() - par1ItemStack.func_77960_j() + " charges left");
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void func_94581_a(final IIconRegister par1IconRegister) {
        this.field_77791_bV = par1IconRegister.func_94245_a("TwilightForest:" + this.func_77658_a().substring(5));
    }
}
