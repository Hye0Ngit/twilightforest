// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.util.text.ITextComponent;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import twilightforest.entity.projectile.TwilightWandBoltEntity;
import twilightforest.TFSounds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.item.Item;

public class TwilightWandItem extends Item
{
    protected TwilightWandItem(final Item.Properties props) {
        super(props);
    }
    
    public ActionResult<ItemStack> func_77659_a(final World world, final PlayerEntity player, final Hand hand) {
        final ItemStack stack = player.func_184586_b(hand);
        if (stack.func_77952_i() == stack.func_77958_k()) {
            return (ActionResult<ItemStack>)ActionResult.func_226251_d_((Object)player.func_184586_b(hand));
        }
        player.func_184185_a(TFSounds.SCEPTER_PEARL, 1.0f, (world.field_73012_v.nextFloat() - world.field_73012_v.nextFloat()) * 0.2f + 1.0f);
        if (!world.field_72995_K) {
            world.func_217376_c((Entity)new TwilightWandBoltEntity(world, (LivingEntity)player));
            stack.func_96631_a(1, TwilightWandItem.field_77697_d, (ServerPlayerEntity)null);
        }
        return (ActionResult<ItemStack>)ActionResult.func_226248_a_((Object)player.func_184586_b(hand));
    }
    
    public float getXpRepairRatio(final ItemStack stack) {
        return 1.0f;
    }
    
    @OnlyIn(Dist.CLIENT)
    public void func_77624_a(final ItemStack stack, @Nullable final World world, final List<ITextComponent> tooltip, final ITooltipFlag flags) {
        super.func_77624_a(stack, world, (List)tooltip, flags);
        tooltip.add((ITextComponent)new TranslationTextComponent("twilightforest.scepter_charges", new Object[] { stack.func_77958_k() - stack.func_77952_i() }));
    }
}
