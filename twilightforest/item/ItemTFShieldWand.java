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
import net.minecraft.item.Item;
import net.minecraft.entity.EntityLivingBase;
import twilightforest.capabilities.shield.IShieldCapability;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import twilightforest.capabilities.CapabilityList;
import net.minecraft.util.EnumActionResult;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import javax.annotation.Nonnull;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;

public class ItemTFShieldWand extends ItemTF
{
    protected ItemTFShieldWand(final EnumRarity rarity) {
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
        if (!world.field_72995_K && player.hasCapability((Capability)CapabilityList.SHIELDS, (EnumFacing)null)) {
            final IShieldCapability cap = (IShieldCapability)player.getCapability((Capability)CapabilityList.SHIELDS, (EnumFacing)null);
            if (cap != null) {
                cap.replenishShields();
            }
            stack.func_77972_a(1, (EntityLivingBase)player);
        }
        if (!player.func_184812_l_()) {
            player.func_184811_cZ().func_185145_a((Item)this, 1200);
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
