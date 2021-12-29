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
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import twilightforest.entity.TFEntities;
import twilightforest.entity.LoyalZombieEntity;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.entity.Entity;
import twilightforest.util.EntityUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import javax.annotation.Nonnull;
import net.minecraft.util.Hand;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.item.Item;

public class ZombieWandItem extends Item
{
    protected ZombieWandItem(final Item.Properties props) {
        super(props);
    }
    
    @Nonnull
    public ActionResult<ItemStack> func_77659_a(final World world, final PlayerEntity player, @Nonnull final Hand hand) {
        final ItemStack stack = player.func_184586_b(hand);
        if (stack.func_77952_i() == stack.func_77958_k()) {
            return (ActionResult<ItemStack>)ActionResult.func_226251_d_((Object)stack);
        }
        if (!world.field_72995_K) {
            final BlockRayTraceResult blockray = EntityUtil.rayTrace((Entity)player, 20.0);
            if (blockray.func_216346_c() != RayTraceResult.Type.MISS) {
                final LoyalZombieEntity zombie = (LoyalZombieEntity)TFEntities.loyal_zombie.func_200721_a(world);
                final Direction face = blockray.func_216354_b();
                zombie.func_70080_a((double)(blockray.func_216350_a().func_177958_n() + 0.5f + face.func_82601_c()), (double)(blockray.func_216350_a().func_177956_o() + face.func_96559_d()), (double)(blockray.func_216350_a().func_177952_p() + 0.5f + face.func_82599_e()), 1.0f, 1.0f);
                zombie.func_70903_f(true);
                zombie.func_184754_b(player.func_110124_au());
                zombie.func_195064_c(new EffectInstance(Effects.field_76420_g, 1200, 1));
                world.func_217376_c((Entity)zombie);
                stack.func_96631_a(1, ZombieWandItem.field_77697_d, (ServerPlayerEntity)null);
            }
        }
        return (ActionResult<ItemStack>)ActionResult.func_226251_d_((Object)stack);
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
