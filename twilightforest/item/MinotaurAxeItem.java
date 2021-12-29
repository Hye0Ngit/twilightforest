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
import net.minecraft.world.World;
import net.minecraft.item.ItemTier;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.server.SAnimateHandPacket;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.item.AxeItem;

@Mod.EventBusSubscriber(modid = "twilightforest")
public class MinotaurAxeItem extends AxeItem
{
    private static final int BONUS_CHARGING_DAMAGE = 7;
    
    protected MinotaurAxeItem(final IItemTier material, final Item.Properties props) {
        super(material, 6.0f, material.func_200928_b() * 0.05f - 3.4f, props);
    }
    
    @SubscribeEvent
    public static void onAttack(final LivingHurtEvent evt) {
        final LivingEntity target = evt.getEntityLiving();
        final Entity source = evt.getSource().func_76364_f();
        if (!target.field_70170_p.field_72995_K && source instanceof LivingEntity && source.func_70051_ag() && (evt.getSource().func_76355_l().equals("player") || evt.getSource().func_76355_l().equals("mob"))) {
            final ItemStack weapon = ((LivingEntity)evt.getSource().func_76364_f()).func_184614_ca();
            if (!weapon.func_190926_b() && weapon.func_77973_b() instanceof MinotaurAxeItem) {
                evt.setAmount(evt.getAmount() + 7.0f);
                ((ServerWorld)target.field_70170_p).func_72863_F().func_217216_a((Entity)target, (IPacket)new SAnimateHandPacket((Entity)target, 5));
            }
        }
    }
    
    public int func_77619_b() {
        return ItemTier.GOLD.func_200927_e();
    }
    
    @OnlyIn(Dist.CLIENT)
    public void func_77624_a(final ItemStack stack, @Nullable final World world, final List<ITextComponent> tooltip, final ITooltipFlag flags) {
        super.func_77624_a(stack, world, (List)tooltip, flags);
        tooltip.add((ITextComponent)new TranslationTextComponent(this.func_77658_a() + ".tooltip"));
    }
}
