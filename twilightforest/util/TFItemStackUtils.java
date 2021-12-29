// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.util;

import net.minecraftforge.items.IItemHandler;
import java.util.Collection;
import java.util.List;
import java.util.Collections;
import net.minecraft.nbt.CompoundTag;
import java.util.Iterator;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.items.CapabilityItemHandler;
import twilightforest.TwilightForestMod;
import net.minecraft.world.item.ItemStack;
import java.util.function.Predicate;
import net.minecraft.world.entity.LivingEntity;

public class TFItemStackUtils
{
    public static int damage;
    
    @Deprecated
    public static boolean consumeInventoryItem(final LivingEntity living, final Predicate<ItemStack> matcher, final int count) {
        TwilightForestMod.LOGGER.warn("consumeInventoryItem accessed! Forge requires the player to be alive before we can access this cap. This cap is most likely being accessed for an Afterdeath Charm!");
        return living.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).map(inv -> {
            int innerCount = count;
            boolean consumedSome = false;
            for (int i = 0; i < inv.getSlots() && innerCount > 0; ++i) {
                final ItemStack stack = inv.getStackInSlot(i);
                if (matcher.test(stack)) {
                    final ItemStack consumed = inv.extractItem(i, innerCount, false);
                    innerCount -= consumed.m_41613_();
                    consumedSome = true;
                }
            }
            return consumedSome;
        }).orElse(false);
    }
    
    public static boolean consumeInventoryItem(final Player player, final Item item) {
        return consumeInventoryItem((NonNullList<ItemStack>)player.m_150109_().f_35975_, item) || consumeInventoryItem((NonNullList<ItemStack>)player.m_150109_().f_35974_, item) || consumeInventoryItem((NonNullList<ItemStack>)player.m_150109_().f_35976_, item);
    }
    
    public static boolean consumeInventoryItem(final NonNullList<ItemStack> stacks, final Item item) {
        for (final ItemStack stack : stacks) {
            if (stack.m_41720_() == item) {
                stack.m_41774_(1);
                final CompoundTag nbt = stack.m_41784_();
                if (nbt.m_128441_("BlockStateTag")) {
                    final CompoundTag damageNbt = nbt.m_128469_("BlockStateTag");
                    if (damageNbt.m_128441_("damage")) {
                        TFItemStackUtils.damage = damageNbt.m_128451_("damage");
                    }
                }
                return true;
            }
        }
        return false;
    }
    
    public static NonNullList<ItemStack> sortArmorForCasket(final Player player) {
        final NonNullList<ItemStack> armor = (NonNullList<ItemStack>)player.m_150109_().f_35975_;
        Collections.reverse((List<?>)armor);
        return armor;
    }
    
    public static NonNullList<ItemStack> sortInvForCasket(final Player player) {
        final NonNullList<ItemStack> inv = (NonNullList<ItemStack>)player.m_150109_().f_35974_;
        final NonNullList<ItemStack> sorted = (NonNullList<ItemStack>)NonNullList.m_122779_();
        sorted.addAll((Collection)inv.subList(9, 36));
        sorted.addAll((Collection)inv.subList(0, 9));
        return sorted;
    }
    
    public static NonNullList<ItemStack> splitToSize(final ItemStack stack) {
        final NonNullList<ItemStack> result = (NonNullList<ItemStack>)NonNullList.m_122779_();
        final int size = stack.m_41741_();
        while (!stack.m_41619_()) {
            result.add((Object)stack.m_41620_(size));
        }
        return result;
    }
    
    public static void clearInfoTag(final ItemStack stack, final String key) {
        final CompoundTag nbt = stack.m_41783_();
        if (nbt != null) {
            nbt.m_128473_(key);
            if (nbt.m_128456_()) {
                stack.m_41751_((CompoundTag)null);
            }
        }
    }
    
    static {
        TFItemStackUtils.damage = 0;
    }
}
