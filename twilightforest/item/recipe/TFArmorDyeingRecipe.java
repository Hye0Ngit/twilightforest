// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item.recipe;

import net.minecraft.item.EnumDyeColor;
import java.util.List;
import net.minecraftforge.oredict.DyeUtils;
import twilightforest.item.ItemTFArcticArmor;
import com.google.common.collect.Lists;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.crafting.RecipesArmorDyes;

public class TFArmorDyeingRecipe extends RecipesArmorDyes
{
    public boolean func_77569_a(final InventoryCrafting inv, final World worldIn) {
        ItemStack itemstack = ItemStack.field_190927_a;
        final List<ItemStack> list = Lists.newArrayList();
        for (int i = 0; i < inv.func_70302_i_(); ++i) {
            final ItemStack itemstack2 = inv.func_70301_a(i);
            if (!itemstack2.func_190926_b()) {
                if (itemstack2.func_77973_b() instanceof ItemTFArcticArmor) {
                    itemstack = itemstack2;
                }
                else {
                    if (!DyeUtils.isDye(itemstack2)) {
                        return false;
                    }
                    list.add(itemstack2);
                }
            }
        }
        return !itemstack.func_190926_b() && !list.isEmpty();
    }
    
    public ItemStack func_77572_b(final InventoryCrafting inv) {
        ItemStack stackAccumulator = ItemStack.field_190927_a;
        final int[] aint = new int[3];
        int i = 0;
        int j = 0;
        ItemTFArcticArmor arcticArmor = null;
        for (int k = 0; k < inv.func_70302_i_(); ++k) {
            final ItemStack stackInSlot = inv.func_70301_a(k);
            if (!stackInSlot.func_190926_b()) {
                if (stackInSlot.func_77973_b() instanceof ItemTFArcticArmor) {
                    arcticArmor = (ItemTFArcticArmor)stackInSlot.func_77973_b();
                    stackAccumulator = stackInSlot.func_77946_l();
                    stackAccumulator.func_190920_e(1);
                    if (arcticArmor.func_82816_b_(stackInSlot)) {
                        final int l = arcticArmor.func_82814_b(stackAccumulator);
                        final float f = (l >> 16 & 0xFF) / 255.0f;
                        final float f2 = (l >> 8 & 0xFF) / 255.0f;
                        final float f3 = (l & 0xFF) / 255.0f;
                        i += (int)(Math.max(f, Math.max(f2, f3)) * 255.0f);
                        aint[0] += (int)(f * 255.0f);
                        aint[1] += (int)(f2 * 255.0f);
                        aint[2] += (int)(f3 * 255.0f);
                        ++j;
                    }
                }
                else {
                    if (!DyeUtils.isDye(stackInSlot)) {
                        return ItemStack.field_190927_a;
                    }
                    final float[] afloat = DyeUtils.colorFromStack(stackInSlot).get().func_193349_f();
                    final int l2 = (int)(afloat[0] * 255.0f);
                    final int i2 = (int)(afloat[1] * 255.0f);
                    final int j2 = (int)(afloat[2] * 255.0f);
                    i += Math.max(l2, Math.max(i2, j2));
                    final int[] array = aint;
                    final int n = 0;
                    array[n] += l2;
                    final int[] array2 = aint;
                    final int n2 = 1;
                    array2[n2] += i2;
                    final int[] array3 = aint;
                    final int n3 = 2;
                    array3[n3] += j2;
                    ++j;
                }
            }
        }
        if (arcticArmor == null) {
            return ItemStack.field_190927_a;
        }
        int i3 = aint[0] / j;
        int j3 = aint[1] / j;
        int k2 = aint[2] / j;
        final float f4 = i / (float)j;
        final float f5 = (float)Math.max(i3, Math.max(j3, k2));
        i3 = (int)(i3 * f4 / f5);
        j3 = (int)(j3 * f4 / f5);
        k2 = (int)(k2 * f4 / f5);
        int k3 = (i3 << 8) + j3;
        k3 = (k3 << 8) + k2;
        arcticArmor.func_82813_b(stackAccumulator, k3);
        return stackAccumulator;
    }
}
