// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.stats.Stats;
import net.minecraft.util.math.MathHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.item.Item;
import net.minecraft.item.AbstractMapItem;

public class EmptyMagicMapItem extends AbstractMapItem
{
    protected EmptyMagicMapItem(final Item.Properties props) {
        super(props);
    }
    
    public ActionResult<ItemStack> func_77659_a(final World worldIn, final PlayerEntity playerIn, final Hand handIn) {
        final ItemStack itemstack = MagicMapItem.setupNewMap(worldIn, MathHelper.func_76128_c(playerIn.func_226277_ct_()), MathHelper.func_76128_c(playerIn.func_226281_cx_()), (byte)4, true, false);
        final ItemStack itemstack2 = playerIn.func_184586_b(handIn);
        if (!playerIn.field_71075_bZ.field_75098_d) {
            itemstack2.func_190918_g(1);
        }
        if (itemstack2.func_190926_b()) {
            return (ActionResult<ItemStack>)ActionResult.func_226248_a_((Object)itemstack);
        }
        if (!playerIn.field_71071_by.func_70441_a(itemstack.func_77946_l())) {
            playerIn.func_71019_a(itemstack, false);
        }
        playerIn.func_71029_a(Stats.field_75929_E.func_199076_b((Object)this));
        return (ActionResult<ItemStack>)ActionResult.func_226248_a_((Object)itemstack2);
    }
}
