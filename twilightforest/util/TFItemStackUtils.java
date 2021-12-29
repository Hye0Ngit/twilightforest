// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.util;

import net.minecraftforge.items.IItemHandler;
import java.util.Collection;
import java.util.List;
import java.util.Collections;
import net.minecraft.nbt.CompoundNBT;
import java.util.Iterator;
import net.minecraft.util.NonNullList;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.items.CapabilityItemHandler;
import twilightforest.TwilightForestMod;
import net.minecraft.item.ItemStack;
import java.util.function.Predicate;
import net.minecraft.entity.LivingEntity;

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
                    innerCount -= consumed.func_190916_E();
                    consumedSome = true;
                }
            }
            return consumedSome;
        }).orElse(false);
    }
    
    public static boolean consumeInventoryItem(final PlayerEntity player, final Item item) {
        return consumeInventoryItem((NonNullList<ItemStack>)player.field_71071_by.field_70460_b, item) || consumeInventoryItem((NonNullList<ItemStack>)player.field_71071_by.field_70462_a, item) || consumeInventoryItem((NonNullList<ItemStack>)player.field_71071_by.field_184439_c, item);
    }
    
    public static boolean consumeInventoryItem(final NonNullList<ItemStack> stacks, final Item item) {
        for (final ItemStack stack : stacks) {
            if (stack.func_77973_b() == item) {
                stack.func_190918_g(1);
                final CompoundNBT nbt = stack.func_196082_o();
                if (nbt.func_74764_b("BlockStateTag")) {
                    final CompoundNBT damageNbt = nbt.func_74775_l("BlockStateTag");
                    if (damageNbt.func_74764_b("damage")) {
                        TFItemStackUtils.damage = damageNbt.func_74762_e("damage");
                    }
                }
                return true;
            }
        }
        return false;
    }
    
    public static NonNullList<ItemStack> sortArmorForCasket(final PlayerEntity player) {
        final NonNullList<ItemStack> armor = (NonNullList<ItemStack>)player.field_71071_by.field_70460_b;
        Collections.reverse((List<?>)armor);
        return armor;
    }
    
    public static NonNullList<ItemStack> sortInvForCasket(final PlayerEntity player) {
        final NonNullList<ItemStack> inv = (NonNullList<ItemStack>)player.field_71071_by.field_70462_a;
        final NonNullList<ItemStack> sorted = (NonNullList<ItemStack>)NonNullList.func_191196_a();
        sorted.addAll((Collection)inv.subList(9, 36));
        sorted.addAll((Collection)inv.subList(0, 9));
        return sorted;
    }
    
    public static NonNullList<ItemStack> splitToSize(final ItemStack stack) {
        final NonNullList<ItemStack> result = (NonNullList<ItemStack>)NonNullList.func_191196_a();
        final int size = stack.func_77976_d();
        while (!stack.func_190926_b()) {
            result.add((Object)stack.func_77979_a(size));
        }
        return result;
    }
    
    public static void clearInfoTag(final ItemStack stack, final String key) {
        final CompoundNBT nbt = stack.func_77978_p();
        if (nbt != null) {
            nbt.func_82580_o(key);
            if (nbt.isEmpty()) {
                stack.func_77982_d((CompoundNBT)null);
            }
        }
    }
    
    static {
        TFItemStackUtils.damage = 0;
    }
}
