// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.item.Item;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumActionResult;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.item.ItemMapBase;

public class ItemTFEmptyMagicMap extends ItemMapBase implements ModelRegisterCallback
{
    protected ItemTFEmptyMagicMap() {
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public ActionResult<ItemStack> func_77659_a(final World worldIn, final EntityPlayer playerIn, final EnumHand handIn) {
        final ItemStack itemstack = ItemTFMagicMap.setupNewMap(worldIn, playerIn.field_70165_t, playerIn.field_70161_v, (byte)4, true, false);
        final ItemStack itemstack2 = playerIn.func_184586_b(handIn);
        itemstack2.func_190918_g(1);
        if (itemstack2.func_190926_b()) {
            return (ActionResult<ItemStack>)new ActionResult(EnumActionResult.SUCCESS, (Object)itemstack);
        }
        if (!playerIn.field_71071_by.func_70441_a(itemstack.func_77946_l())) {
            playerIn.func_71019_a(itemstack, false);
        }
        playerIn.func_71029_a(StatList.func_188057_b((Item)this));
        return (ActionResult<ItemStack>)new ActionResult(EnumActionResult.SUCCESS, (Object)itemstack2);
    }
}
