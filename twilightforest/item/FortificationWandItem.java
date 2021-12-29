// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.entity.player.ServerPlayerEntity;
import twilightforest.capabilities.shield.IShieldCapability;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.util.text.ITextComponent;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraftforge.common.capabilities.Capability;
import twilightforest.capabilities.CapabilityList;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import javax.annotation.Nonnull;
import net.minecraft.util.Hand;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.item.Item;

public class FortificationWandItem extends Item
{
    protected FortificationWandItem(final Item.Properties props) {
        super(props);
    }
    
    @Nonnull
    public ActionResult<ItemStack> func_77659_a(final World world, final PlayerEntity player, @Nonnull final Hand hand) {
        final ItemStack stack = player.func_184586_b(hand);
        if (stack.func_77952_i() == stack.func_77958_k()) {
            return (ActionResult<ItemStack>)ActionResult.func_226251_d_((Object)stack);
        }
        if (!world.field_72995_K) {
            player.getCapability((Capability)CapabilityList.SHIELDS).ifPresent(cap -> {
                cap.replenishShields();
                stack.func_96631_a(1, FortificationWandItem.field_77697_d, (ServerPlayerEntity)null);
            });
        }
        if (!player.func_184812_l_()) {
            player.func_184811_cZ().func_185145_a((Item)this, 1200);
        }
        return (ActionResult<ItemStack>)ActionResult.func_226248_a_((Object)stack);
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
