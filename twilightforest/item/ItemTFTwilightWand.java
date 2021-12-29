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
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import twilightforest.entity.EntityTFTwilightWandBolt;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumActionResult;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;

public class ItemTFTwilightWand extends ItemTF
{
    protected ItemTFTwilightWand(final EnumRarity rarity) {
        super(rarity);
        this.field_77777_bU = 1;
        this.func_77656_e(99);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public ActionResult<ItemStack> func_77659_a(final World world, final EntityPlayer player, final EnumHand hand) {
        final ItemStack stack = player.func_184586_b(hand);
        if (stack.func_77952_i() == stack.func_77958_k()) {
            return (ActionResult<ItemStack>)ActionResult.newResult(EnumActionResult.FAIL, (Object)player.func_184586_b(hand));
        }
        player.func_184185_a(SoundEvents.field_187557_bK, 1.0f, (world.field_73012_v.nextFloat() - world.field_73012_v.nextFloat()) * 0.2f + 1.0f);
        if (!world.field_72995_K) {
            world.func_72838_d((Entity)new EntityTFTwilightWandBolt(world, (EntityLivingBase)player));
            stack.func_77972_a(1, (EntityLivingBase)player);
        }
        return (ActionResult<ItemStack>)ActionResult.newResult(EnumActionResult.SUCCESS, (Object)player.func_184586_b(hand));
    }
    
    public float getXpRepairRatio(final ItemStack stack) {
        return 1.0f;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_77624_a(final ItemStack stack, @Nullable final World world, final List<String> tooltip, final ITooltipFlag flags) {
        super.func_77624_a(stack, world, (List)tooltip, flags);
        tooltip.add(I18n.func_135052_a("twilightforest.scepter_charges", new Object[] { stack.func_77958_k() - stack.func_77952_i() }));
    }
}
