// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.compat;

import baubles.api.BaubleType;
import baubles.api.cap.BaublesCapabilities;
import javax.annotation.Nullable;
import net.minecraft.util.EnumFacing;
import javax.annotation.Nonnull;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import java.util.Iterator;
import net.minecraftforge.items.ItemHandlerHelper;
import twilightforest.TwilightForestMod;
import net.minecraft.util.NonNullList;
import baubles.api.cap.IBaublesItemHandler;
import baubles.api.BaublesApi;
import net.minecraft.item.ItemStack;
import java.util.function.Predicate;
import net.minecraft.entity.player.EntityPlayer;

public class Baubles
{
    public static boolean consumeInventoryItem(final EntityPlayer player, final Predicate<ItemStack> matcher, int count) {
        final IBaublesItemHandler baubles = BaublesApi.getBaublesHandler(player);
        boolean consumedSome = false;
        for (int slots = baubles.getSlots(), i = 0; i < slots && count > 0; ++i) {
            final ItemStack stack = baubles.getStackInSlot(i);
            if (matcher.test(stack)) {
                final ItemStack consumed = baubles.extractItem(i, count, false);
                count -= consumed.func_190916_E();
                consumedSome = true;
            }
        }
        return consumedSome;
    }
    
    public static NonNullList<ItemStack> keepBaubles(final EntityPlayer player) {
        final IBaublesItemHandler baubles = BaublesApi.getBaublesHandler(player);
        final NonNullList<ItemStack> kept = (NonNullList<ItemStack>)NonNullList.func_191197_a(baubles.getSlots(), (Object)ItemStack.field_190927_a);
        for (int i = 0; i < baubles.getSlots(); ++i) {
            kept.set(i, (Object)baubles.getStackInSlot(i).func_77946_l());
            baubles.setStackInSlot(i, ItemStack.field_190927_a);
        }
        return kept;
    }
    
    public static void returnBaubles(final EntityPlayer player, final NonNullList<ItemStack> items) {
        final IBaublesItemHandler baubles = BaublesApi.getBaublesHandler(player);
        if (items.size() != baubles.getSlots()) {
            TwilightForestMod.LOGGER.warn("The list size doesn't equal amount of bauble slots, wtf did you do?");
            giveItems(player, items);
            return;
        }
        final NonNullList<ItemStack> displaced = (NonNullList<ItemStack>)NonNullList.func_191196_a();
        for (int i = 0; i < baubles.getSlots(); ++i) {
            final ItemStack kept = (ItemStack)items.get(i);
            if (!kept.func_190926_b()) {
                final ItemStack existing = baubles.getStackInSlot(i);
                baubles.setStackInSlot(i, kept);
                if (!existing.func_190926_b()) {
                    displaced.add((Object)existing);
                }
            }
        }
        giveItems(player, displaced);
    }
    
    private static void giveItems(final EntityPlayer player, final NonNullList<ItemStack> items) {
        for (final ItemStack stack : items) {
            ItemHandlerHelper.giveItemToPlayer(player, stack);
        }
    }
    
    public static final class BasicBaubleProvider implements ICapabilityProvider
    {
        public boolean hasCapability(@Nonnull final Capability<?> capability, @Nullable final EnumFacing facing) {
            return capability == BaublesCapabilities.CAPABILITY_ITEM_BAUBLE;
        }
        
        @Nullable
        public <T> T getCapability(@Nonnull final Capability<T> capability, @Nullable final EnumFacing facing) {
            return (capability == BaublesCapabilities.CAPABILITY_ITEM_BAUBLE) ? (itemStack -> BaubleType.TRINKET) : null;
        }
    }
}
