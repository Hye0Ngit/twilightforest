// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.compat.tcon.trait;

import net.minecraft.util.NonNullList;
import slimeknights.tconstruct.library.utils.ToolHelper;
import net.minecraft.entity.EntityLivingBase;
import twilightforest.util.TFItemStackUtils;
import twilightforest.enums.CompressedVariant;
import twilightforest.item.TFItems;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitSynergy extends AbstractTrait
{
    private static final float REPAIR_DAMPENER = 0.00390625f;
    
    public TraitSynergy() {
        super("synergy", TextFormatting.GREEN);
    }
    
    public void onUpdate(final ItemStack tool, final World world, final Entity entity, final int itemSlot, final boolean isSelected) {
        if (!world.field_72995_K && entity instanceof EntityPlayer && !(entity instanceof FakePlayer)) {
            if (!InventoryPlayer.func_184435_e(itemSlot) && ((EntityPlayer)entity).func_184592_cb() != tool) {
                return;
            }
            if (!needsRepair(tool)) {
                return;
            }
            int healPower = 0;
            final NonNullList<ItemStack> playerInv = (NonNullList<ItemStack>)((EntityPlayer)entity).field_71071_by.field_70462_a;
            for (int i = 0; i < 9; ++i) {
                if (i != itemSlot) {
                    final ItemStack stack = (ItemStack)playerInv.get(i);
                    if (stack.func_77973_b() == TFItems.steeleaf_ingot) {
                        healPower += stack.func_190916_E();
                    }
                    else if (stack.func_77973_b() == TFItems.block_storage && stack.func_77960_j() == CompressedVariant.STEELLEAF.ordinal()) {
                        healPower += stack.func_190916_E() * 9;
                    }
                    else if (TFItemStackUtils.hasToolMaterial(stack, TFItems.TOOL_STEELEAF)) {
                        ++healPower;
                    }
                }
            }
            ToolHelper.healTool(tool, averageInt(healPower * 0.00390625f), (EntityLivingBase)entity);
        }
    }
    
    private static boolean needsRepair(final ItemStack itemStack) {
        return !itemStack.func_190926_b() && itemStack.func_77952_i() > 0 && !ToolHelper.isBroken(itemStack);
    }
    
    private static int averageInt(final float value) {
        final double floor = Math.floor(value);
        final double rem = value - floor;
        return (int)floor + ((Math.random() < rem) ? 1 : 0);
    }
}
