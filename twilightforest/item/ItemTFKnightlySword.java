// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.server.SPacketAnimation;
import net.minecraft.world.WorldServer;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.item.ItemSword;

@Mod.EventBusSubscriber(modid = "twilightforest")
public class ItemTFKnightlySword extends ItemSword implements ModelRegisterCallback
{
    private static final int BONUS_DAMAGE = 2;
    
    public ItemTFKnightlySword(final Item.ToolMaterial material) {
        super(material);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    @SubscribeEvent
    public static void onDamage(final LivingAttackEvent evt) {
        final EntityLivingBase target = evt.getEntityLiving();
        if (!target.field_70170_p.field_72995_K && evt.getSource().func_76364_f() instanceof EntityLivingBase) {
            final ItemStack weapon = ((EntityLivingBase)evt.getSource().func_76364_f()).func_184614_ca();
            if (!weapon.func_190926_b() && ((target.func_70658_aO() > 0 && (weapon.func_77973_b() == TFItems.knightmetal_pickaxe || weapon.func_77973_b() == TFItems.knightmetal_sword)) || (target.func_70658_aO() == 0 && weapon.func_77973_b() == TFItems.knightmetal_axe))) {
                target.func_70097_a(DamageSource.field_76376_m, 2.0f);
                target.field_70172_ad = 0;
                ((WorldServer)target.field_70170_p).func_73039_n().func_151248_b((Entity)target, (Packet)new SPacketAnimation((Entity)target, 5));
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void func_77624_a(final ItemStack stack, @Nullable final World world, final List<String> list, final ITooltipFlag flags) {
        super.func_77624_a(stack, world, (List)list, flags);
        list.add(I18n.func_135052_a(this.func_77658_a() + ".tooltip", new Object[0]));
    }
}
