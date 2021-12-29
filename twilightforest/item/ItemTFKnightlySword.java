// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.util.StatCollector;
import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemSword;

public class ItemTFKnightlySword extends ItemSword
{
    private static final int BONUS_DAMAGE = 2;
    private Entity bonusDamageEntity;
    private EntityPlayer bonusDamagePlayer;
    
    public ItemTFKnightlySword(final Item.ToolMaterial par2EnumToolMaterial) {
        super(par2EnumToolMaterial);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public EnumRarity func_77613_e(final ItemStack par1ItemStack) {
        return EnumRarity.rare;
    }
    
    public boolean func_82789_a(final ItemStack par1ItemStack, final ItemStack par2ItemStack) {
        return par2ItemStack.func_77973_b() == TFItems.knightMetal || super.func_82789_a(par1ItemStack, par2ItemStack);
    }
    
    public boolean onLeftClickEntity(final ItemStack stack, final EntityPlayer player, final Entity entity) {
        if (entity instanceof EntityLivingBase && ((EntityLivingBase)entity).func_70658_aO() > 0) {
            this.bonusDamageEntity = entity;
            this.bonusDamagePlayer = player;
        }
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IIconRegister par1IconRegister) {
        this.field_77791_bV = par1IconRegister.func_94245_a("TwilightForest:" + this.func_77658_a().substring(5));
    }
    
    @SideOnly(Side.CLIENT)
    public void func_77624_a(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        super.func_77624_a(par1ItemStack, par2EntityPlayer, par3List, par4);
        par3List.add(StatCollector.func_74838_a(this.func_77658_a() + ".tooltip"));
    }
}
