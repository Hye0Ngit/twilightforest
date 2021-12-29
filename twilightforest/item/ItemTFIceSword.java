// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.Potion;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class ItemTFIceSword extends ItemSword
{
    public ItemTFIceSword(final Item.ToolMaterial par2EnumToolMaterial) {
        super(par2EnumToolMaterial);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
        this.func_111206_d("TwilightForest:iceSword");
    }
    
    public boolean func_82789_a(final ItemStack par1ItemStack, final ItemStack par2ItemStack) {
        return par2ItemStack.func_77973_b() == Item.func_150898_a(Blocks.field_150403_cj) || super.func_82789_a(par1ItemStack, par2ItemStack);
    }
    
    public boolean func_77644_a(final ItemStack par1ItemStack, final EntityLivingBase par2EntityLiving, final EntityLivingBase par3EntityLiving) {
        final boolean result = super.func_77644_a(par1ItemStack, par2EntityLiving, par3EntityLiving);
        if (result) {
            final int chillLevel = 2;
            par2EntityLiving.func_70690_d(new PotionEffect(Potion.field_76421_d.field_76415_H, 200, chillLevel, true));
        }
        return result;
    }
    
    public boolean onLeftClickEntity(final ItemStack stack, final EntityPlayer player, final Entity entity) {
        if (player.field_70170_p.field_72995_K) {
            for (int var1 = 0; var1 < 20; ++var1) {
                final double px = entity.field_70165_t + ItemTFIceSword.field_77697_d.nextFloat() * entity.field_70130_N * 2.0f - entity.field_70130_N;
                final double py = entity.field_70163_u + ItemTFIceSword.field_77697_d.nextFloat() * entity.field_70131_O;
                final double pz = entity.field_70161_v + ItemTFIceSword.field_77697_d.nextFloat() * entity.field_70130_N * 2.0f - entity.field_70130_N;
                TwilightForestMod.proxy.spawnParticle(entity.field_70170_p, "snowstuff", px, py, pz, 0.0, 0.0, 0.0);
            }
        }
        return false;
    }
}
