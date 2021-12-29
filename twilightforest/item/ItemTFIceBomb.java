// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.util.EnumActionResult;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import twilightforest.entity.boss.EntityTFIceBomb;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ItemTFIceBomb extends ItemTF
{
    public ItemTFIceBomb() {
        this.func_77625_d(16);
    }
    
    public ActionResult<ItemStack> func_77659_a(final World world, final EntityPlayer player, final EnumHand hand) {
        player.func_184185_a(SoundEvents.field_187737_v, 0.5f, 0.4f / (ItemTFIceBomb.field_77697_d.nextFloat() * 0.4f + 0.8f));
        if (!world.field_72995_K) {
            if (!player.field_71075_bZ.field_75098_d) {
                player.func_184586_b(hand).func_190918_g(1);
            }
            final EntityTFIceBomb ice = new EntityTFIceBomb(world, (EntityLivingBase)player);
            ice.func_184538_a((Entity)player, player.field_70125_A, player.field_70177_z, -20.0f, 0.75f, 1.0f);
            world.func_72838_d((Entity)ice);
        }
        return (ActionResult<ItemStack>)ActionResult.newResult(EnumActionResult.SUCCESS, (Object)player.func_184586_b(hand));
    }
}
