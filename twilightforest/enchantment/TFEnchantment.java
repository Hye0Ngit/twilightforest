// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enchantment;

import twilightforest.item.ItemTFYetiArmor;
import net.minecraft.item.ItemStack;
import twilightforest.item.ItemTFFieryArmor;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.enchantment.Enchantment;

public class TFEnchantment extends Enchantment
{
    protected TFEnchantment(final int par1, final int par2, final EnumEnchantmentType par3EnumEnchantmentType) {
        super(par1, par2, par3EnumEnchantmentType);
    }
    
    public static int getFieryAuraLevel(final InventoryPlayer par0InventoryPlayer, final DamageSource par1DamageSource) {
        int modifier = 0;
        for (int i = 0; i < par0InventoryPlayer.field_70460_b.length; ++i) {
            final ItemStack armor = par0InventoryPlayer.field_70460_b[i];
            if (armor != null && armor.func_77973_b() instanceof ItemTFFieryArmor) {
                modifier += 5;
            }
        }
        return modifier;
    }
    
    public static int getChillAuraLevel(final InventoryPlayer par0InventoryPlayer, final DamageSource par1DamageSource) {
        int modifier = 0;
        for (int i = 0; i < par0InventoryPlayer.field_70460_b.length; ++i) {
            final ItemStack armor = par0InventoryPlayer.field_70460_b[i];
            if (armor != null && armor.func_77973_b() instanceof ItemTFYetiArmor) {
                ++modifier;
            }
        }
        return modifier;
    }
}
