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
import net.minecraft.init.Enchantments;
import net.minecraft.util.NonNullList;
import net.minecraft.entity.Entity;
import twilightforest.util.ParticleHelper;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.entity.EntityLivingBase;
import javax.annotation.Nonnull;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.EnumRarity;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.item.ItemSword;

public class ItemTFFierySword extends ItemSword implements ModelRegisterCallback
{
    private static final EnumRarity RARITY;
    
    public ItemTFFierySword(final Item.ToolMaterial toolMaterial) {
        super(toolMaterial);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    @Nonnull
    public EnumRarity func_77613_e(final ItemStack stack) {
        return stack.func_77948_v() ? ((EnumRarity.RARE.compareTo((Enum)ItemTFFierySword.RARITY) > 0) ? EnumRarity.RARE : ItemTFFierySword.RARITY) : ItemTFFierySword.RARITY;
    }
    
    public boolean func_77644_a(final ItemStack stack, final EntityLivingBase target, final EntityLivingBase attacker) {
        final boolean result = super.func_77644_a(stack, target, attacker);
        if (result && !target.field_70170_p.field_72995_K && !target.func_70045_F()) {
            ParticleHelper.spawnParticles((Entity)target, EnumParticleTypes.FLAME, 20, 0.02, new int[0]);
        }
        return result;
    }
    
    public void func_150895_a(final CreativeTabs tab, final NonNullList<ItemStack> list) {
        if (this.func_194125_a(tab)) {
            final ItemStack stack = new ItemStack((Item)this);
            stack.func_77966_a(Enchantments.field_77334_n, 2);
            list.add((Object)stack);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void func_77624_a(final ItemStack stack, @Nullable final World world, final List<String> tooltip, final ITooltipFlag flags) {
        super.func_77624_a(stack, world, (List)tooltip, flags);
        tooltip.add(I18n.func_135052_a(this.func_77658_a() + ".tooltip", new Object[0]));
    }
    
    static {
        RARITY = EnumRarity.UNCOMMON;
    }
}
