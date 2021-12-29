// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enchantment;

import net.minecraft.world.item.enchantment.Enchantments;
import java.util.Random;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;

public class FireReactEnchantment extends LootOnlyEnchantment
{
    public FireReactEnchantment(final Enchantment.Rarity rarity) {
        super(rarity, EnchantmentCategory.ARMOR, new EquipmentSlot[] { EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET });
    }
    
    public boolean m_6081_(final ItemStack pStack) {
        return pStack.m_41720_() instanceof ArmorItem || super.m_6081_(pStack);
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
    
    public void m_7675_(final LivingEntity user, final Entity attacker, final int level) {
        final Random random = user.m_21187_();
        if (shouldHit(level, random, attacker)) {
            attacker.m_20254_(2 + random.nextInt(level) * 3);
        }
    }
    
    public static boolean shouldHit(final int level, final Random pRnd, final Entity attacker) {
        return level > 0 && !attacker.m_5825_() && pRnd.nextFloat() < 0.15f * level;
    }
    
    protected boolean m_5975_(final Enchantment other) {
        return super.m_5975_(other) && other != TFEnchantments.CHILL_AURA.get() && other != Enchantments.f_44972_;
    }
}
