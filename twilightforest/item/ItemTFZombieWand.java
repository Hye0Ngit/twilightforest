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
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import twilightforest.entity.EntityTFLoyalZombie;
import net.minecraft.entity.Entity;
import twilightforest.util.EntityUtil;
import net.minecraft.util.EnumActionResult;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import javax.annotation.Nonnull;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;

public class ItemTFZombieWand extends ItemTF
{
    protected ItemTFZombieWand(final EnumRarity rarity) {
        super(rarity);
        this.field_77777_bU = 1;
        this.func_77656_e(9);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    @Nonnull
    public ActionResult<ItemStack> func_77659_a(final World world, final EntityPlayer player, @Nonnull final EnumHand hand) {
        final ItemStack stack = player.func_184586_b(hand);
        if (stack.func_77952_i() == stack.func_77958_k()) {
            return (ActionResult<ItemStack>)ActionResult.newResult(EnumActionResult.FAIL, (Object)stack);
        }
        if (!world.field_72995_K) {
            final RayTraceResult ray = EntityUtil.rayTrace((Entity)player, 20.0);
            if (ray != null && ray.field_72307_f != null) {
                final EntityTFLoyalZombie zombie = new EntityTFLoyalZombie(world);
                zombie.func_70080_a(ray.field_72307_f.field_72450_a, ray.field_72307_f.field_72448_b, ray.field_72307_f.field_72449_c, 1.0f, 1.0f);
                zombie.func_70903_f(true);
                zombie.func_184754_b(player.func_110124_au());
                zombie.func_70690_d(new PotionEffect(MobEffects.field_76420_g, 1200, 1));
                world.func_72838_d((Entity)zombie);
                stack.func_77972_a(1, (EntityLivingBase)player);
            }
        }
        return (ActionResult<ItemStack>)ActionResult.newResult(EnumActionResult.SUCCESS, (Object)stack);
    }
    
    public float getXpRepairRatio(final ItemStack stack) {
        return 0.1f;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_77624_a(final ItemStack stack, @Nullable final World world, final List<String> tooltip, final ITooltipFlag flags) {
        super.func_77624_a(stack, world, (List)tooltip, flags);
        tooltip.add(I18n.func_135052_a("twilightforest.scepter_charges", new Object[] { stack.func_77958_k() - stack.func_77952_i() }));
    }
}
