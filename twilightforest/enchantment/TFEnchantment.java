// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enchantment;

import twilightforest.TwilightForestMod;
import net.minecraft.item.ItemStack;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.enchantment.Enchantment;

public class TFEnchantment extends Enchantment
{
    public static final Enchantment fieryAura;
    public static final Enchantment chillAura;
    
    protected TFEnchantment(final int par1, final int par2, final EnumEnchantmentType par3EnumEnchantmentType) {
        super(par1, par2, par3EnumEnchantmentType);
    }
    
    public static int getReactFireLevel(final InventoryPlayer par0InventoryPlayer, final DamageSource par1DamageSource) {
        int modifier = 0;
        for (int i = 0; i < par0InventoryPlayer.field_70460_b.length; ++i) {
            final ItemStack armor = par0InventoryPlayer.field_70460_b[i];
            if (armor != null && armor.func_77948_v()) {
                final int level = EnchantmentHelper.func_77506_a(TFEnchantment.fieryAura.field_77352_x, armor);
                if (level > 0) {
                    modifier += (6 + level * level) / 2;
                }
            }
        }
        return modifier;
    }
    
    public static int getChillAuraLevel(final InventoryPlayer par0InventoryPlayer, final DamageSource par1DamageSource) {
        int modifier = 0;
        for (int i = 0; i < par0InventoryPlayer.field_70460_b.length; ++i) {
            final ItemStack armor = par0InventoryPlayer.field_70460_b[i];
            if (armor != null && armor.func_77948_v()) {
                final int level = EnchantmentHelper.func_77506_a(TFEnchantment.chillAura.field_77352_x, armor);
                if (level > 0) {
                    ++modifier;
                }
            }
        }
        return modifier;
    }
    
    static {
        fieryAura = new EnchantmentTFFireReact(TwilightForestMod.idEnchantmentFieryAura, 2);
        chillAura = new EnchantmentTFChillAura(TwilightForestMod.idEnchantmentChillAura, 2);
    }
}
