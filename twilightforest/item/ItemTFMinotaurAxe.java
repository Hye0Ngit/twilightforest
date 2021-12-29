// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import javax.annotation.Nonnull;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.network.Packet;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.server.SPacketAnimation;
import net.minecraft.world.WorldServer;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.EnumRarity;
import net.minecraftforge.fml.common.Mod;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.item.ItemAxe;

@Mod.EventBusSubscriber(modid = "twilightforest")
public class ItemTFMinotaurAxe extends ItemAxe implements ModelRegisterCallback
{
    private static final int BONUS_CHARGING_DAMAGE = 7;
    private final EnumRarity RARITY;
    
    protected ItemTFMinotaurAxe(final Item.ToolMaterial material, final EnumRarity rarity) {
        super(material, 6.0f + material.func_78000_c(), material.func_77998_b() * 0.05f - 3.4f);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
        this.RARITY = rarity;
    }
    
    public void func_150895_a(final CreativeTabs tab, final NonNullList<ItemStack> list) {
        if (this.func_194125_a(tab)) {
            final ItemStack istack = new ItemStack((Item)this);
            list.add((Object)istack);
        }
    }
    
    @SubscribeEvent
    public static void onAttack(final LivingAttackEvent evt) {
        final EntityLivingBase target = evt.getEntityLiving();
        final Entity source = evt.getSource().func_76364_f();
        if (!target.field_70170_p.field_72995_K && source instanceof EntityLivingBase && source.func_70051_ag()) {
            final ItemStack weapon = ((EntityLivingBase)evt.getSource().func_76364_f()).func_184614_ca();
            if (!weapon.func_190926_b() && weapon.func_77973_b() == TFItems.minotaur_axe) {
                target.func_70097_a(DamageSource.field_76376_m, 7.0f);
                target.field_70172_ad = 0;
                ((WorldServer)target.field_70170_p).func_73039_n().func_151248_b((Entity)target, (Packet)new SPacketAnimation((Entity)target, 5));
            }
        }
    }
    
    public int func_77619_b() {
        return Item.ToolMaterial.GOLD.func_77995_e();
    }
    
    @SideOnly(Side.CLIENT)
    public void func_77624_a(final ItemStack stack, @Nullable final World world, final List<String> tooltip, final ITooltipFlag flags) {
        super.func_77624_a(stack, world, (List)tooltip, flags);
        tooltip.add(I18n.func_135052_a(this.func_77658_a() + ".tooltip", new Object[0]));
    }
    
    @Nonnull
    public EnumRarity func_77613_e(final ItemStack stack) {
        return stack.func_77948_v() ? ((EnumRarity.RARE.compareTo((Enum)this.RARITY) > 0) ? EnumRarity.RARE : this.RARITY) : this.RARITY;
    }
}
