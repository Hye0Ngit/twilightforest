// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.util.StringTranslate;
import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;

public class ItemTFKnightlyAxe extends ItemAxe
{
    private static final int BONUS_DAMAGE = 2;
    private int myDamageVsEntity;
    private EntityPlayer bonusDamagePlayer;
    private Entity bonusDamageEntity;
    
    protected ItemTFKnightlyAxe(final int par1, final EnumToolMaterial par2EnumToolMaterial) {
        super(par1, par2EnumToolMaterial);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
        this.myDamageVsEntity = 4 + par2EnumToolMaterial.func_78000_c();
    }
    
    public EnumRarity func_77613_e(final ItemStack par1ItemStack) {
        return EnumRarity.rare;
    }
    
    public boolean func_82789_a(final ItemStack par1ItemStack, final ItemStack par2ItemStack) {
        return par2ItemStack.field_77993_c == TFItems.knightMetal.field_77779_bT || super.func_82789_a(par1ItemStack, par2ItemStack);
    }
    
    public boolean onLeftClickEntity(final ItemStack stack, final EntityPlayer player, final Entity entity) {
        if (entity instanceof EntityLiving && ((EntityLiving)entity).func_70658_aO() == 0) {
            this.bonusDamageEntity = entity;
            this.bonusDamagePlayer = player;
        }
        return false;
    }
    
    public int func_77649_a(final Entity par1Entity) {
        if (this.bonusDamagePlayer != null && this.bonusDamageEntity != null && par1Entity == this.bonusDamageEntity) {
            this.bonusDamagePlayer.func_71047_c(par1Entity);
            this.bonusDamagePlayer = null;
            this.bonusDamageEntity = null;
            return this.myDamageVsEntity + 2;
        }
        return super.func_77649_a(par1Entity);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IconRegister par1IconRegister) {
        this.field_77791_bV = par1IconRegister.func_94245_a("twilightforest:" + this.func_77658_a().substring(5));
    }
    
    @SideOnly(Side.CLIENT)
    public void func_77624_a(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        super.func_77624_a(par1ItemStack, par2EntityPlayer, par3List, par4);
        par3List.add(StringTranslate.func_74808_a().func_74805_b(this.func_77658_a() + ".tooltip"));
    }
}
