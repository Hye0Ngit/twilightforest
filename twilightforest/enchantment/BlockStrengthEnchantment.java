// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enchantment;

import twilightforest.item.ChainBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;

public class BlockStrengthEnchantment extends LootOnlyEnchantment
{
    public BlockStrengthEnchantment(final Enchantment.Rarity rarity) {
        super(rarity, TFEnchantments.BLOCK_AND_CHAIN, new EquipmentSlot[] { EquipmentSlot.MAINHAND });
    }
    
    public int m_6183_(final int pEnchantmentLevel) {
        return 5 + (pEnchantmentLevel - 1) * 9;
    }
    
    public int m_6175_(final int pEnchantmentLevel) {
        return this.m_6183_(pEnchantmentLevel) + 15;
    }
    
    public int m_6586_() {
        return 3;
    }
    
    public boolean m_6081_(final ItemStack pStack) {
        return pStack.m_41720_() instanceof ChainBlockItem;
    }
    
    protected boolean m_5975_(final Enchantment other) {
        return super.m_5975_(other) && other != TFEnchantments.DESTRUCTION.get() && other != TFEnchantments.PRESERVATION.get();
    }
}
