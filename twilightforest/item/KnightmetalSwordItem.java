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
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.server.SAnimateHandPacket;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.item.SwordItem;

@Mod.EventBusSubscriber(modid = "twilightforest")
public class KnightmetalSwordItem extends SwordItem
{
    private static final int BONUS_DAMAGE = 2;
    
    public KnightmetalSwordItem(final IItemTier material, final Item.Properties props) {
        super(material, 3, -2.4f, props);
    }
    
    @SubscribeEvent
    public static void onDamage(final LivingAttackEvent evt) {
        final LivingEntity target = evt.getEntityLiving();
        if (!target.field_70170_p.field_72995_K && evt.getSource().func_76364_f() instanceof LivingEntity) {
            final ItemStack weapon = ((LivingEntity)evt.getSource().func_76364_f()).func_184614_ca();
            if (!weapon.func_190926_b() && ((target.func_70658_aO() > 0 && (weapon.func_77973_b() == TFItems.knightmetal_pickaxe.get() || weapon.func_77973_b() == TFItems.knightmetal_sword.get())) || (target.func_70658_aO() == 0 && weapon.func_77973_b() == TFItems.knightmetal_axe.get()))) {
                target.func_70097_a(DamageSource.field_76376_m, 2.0f);
                target.field_70172_ad = 0;
                ((ServerWorld)target.field_70170_p).func_72863_F().func_217216_a((Entity)target, (IPacket)new SAnimateHandPacket((Entity)target, 5));
            }
        }
    }
    
    @OnlyIn(Dist.CLIENT)
    public void func_77624_a(final ItemStack stack, @Nullable final World world, final List<ITextComponent> list, final ITooltipFlag flags) {
        super.func_77624_a(stack, world, (List)list, flags);
        list.add((ITextComponent)new TranslationTextComponent(this.func_77658_a() + ".tooltip"));
    }
}
