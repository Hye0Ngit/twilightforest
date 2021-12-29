// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.util;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.Item;
import net.minecraft.util.NonNullList;
import twilightforest.compat.Baubles;
import net.minecraft.entity.player.EntityPlayer;
import twilightforest.compat.TFCompat;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraft.item.ItemStack;
import java.util.function.Predicate;
import net.minecraft.entity.EntityLivingBase;

public class TFItemStackUtils
{
    public static boolean consumeInventoryItem(final EntityLivingBase living, final Predicate<ItemStack> matcher, int count) {
        final IItemHandler inv = (IItemHandler)living.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, (EnumFacing)null);
        if (inv == null) {
            return false;
        }
        boolean consumedSome = false;
        for (int i = 0; i < inv.getSlots() && count > 0; ++i) {
            final ItemStack stack = inv.getStackInSlot(i);
            if (matcher.test(stack)) {
                final ItemStack consumed = inv.extractItem(i, count, false);
                count -= consumed.func_190916_E();
                consumedSome = true;
            }
        }
        if (TFCompat.BAUBLES.isActivated() && living instanceof EntityPlayer) {
            consumedSome |= Baubles.consumeInventoryItem((EntityPlayer)living, matcher, count);
        }
        return consumedSome;
    }
    
    public static NonNullList<ItemStack> splitToSize(final ItemStack stack) {
        final NonNullList<ItemStack> result = (NonNullList<ItemStack>)NonNullList.func_191196_a();
        final int size = stack.func_77976_d();
        while (!stack.func_190926_b()) {
            result.add((Object)stack.func_77979_a(size));
        }
        return result;
    }
    
    public static boolean hasToolMaterial(final ItemStack stack, final Item.ToolMaterial material) {
        final Item item = stack.func_77973_b();
        return (item instanceof ItemTool && material.toString().equals(((ItemTool)item).func_77861_e())) || (item instanceof ItemSword && material.toString().equals(((ItemSword)item).func_150932_j())) || (item instanceof ItemHoe && material.toString().equals(((ItemHoe)item).func_77842_f()));
    }
    
    public static void clearInfoTag(final ItemStack stack, final String key) {
        final NBTTagCompound nbt = stack.func_77978_p();
        if (nbt != null) {
            nbt.func_82580_o(key);
            if (nbt.func_82582_d()) {
                stack.func_77982_d((NBTTagCompound)null);
            }
        }
    }
}
