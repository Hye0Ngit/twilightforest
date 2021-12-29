// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.util.ActionResultType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityType;
import twilightforest.entity.boss.IceBombEntity;
import twilightforest.entity.TFEntities;
import twilightforest.TFSounds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.item.Item;

public class IceBombItem extends Item
{
    public IceBombItem(final Item.Properties props) {
        super(props);
    }
    
    public ActionResult<ItemStack> func_77659_a(final World world, final PlayerEntity player, final Hand hand) {
        player.func_184185_a(TFSounds.ICEBOMB_FIRED, 0.5f, 0.4f / (IceBombItem.field_77697_d.nextFloat() * 0.4f + 0.8f));
        if (!world.field_72995_K) {
            if (!player.field_71075_bZ.field_75098_d) {
                player.func_184586_b(hand).func_190918_g(1);
            }
            final IceBombEntity ice = new IceBombEntity(TFEntities.thrown_ice, world, (LivingEntity)player);
            ice.func_234612_a_((Entity)player, player.field_70125_A, player.field_70177_z, -20.0f, 0.75f, 1.0f);
            world.func_217376_c((Entity)ice);
        }
        return (ActionResult<ItemStack>)new ActionResult(ActionResultType.SUCCESS, (Object)player.func_184586_b(hand));
    }
}
