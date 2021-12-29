// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.util.ITooltipFlag;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.World;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.item.ItemShield;

public class ItemKnightlyShield extends ItemShield implements ModelRegisterCallback
{
    public ItemKnightlyShield() {
        this.func_77656_e(1024);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public String func_77653_i(final ItemStack stack) {
        return I18n.func_74838_a(this.func_77667_c(stack) + ".name").trim();
    }
    
    @SideOnly(Side.CLIENT)
    public void func_77624_a(final ItemStack stack, @Nullable final World worldIn, final List<String> tooltip, final ITooltipFlag flagIn) {
    }
    
    public boolean func_82789_a(final ItemStack toRepair, final ItemStack repair) {
        return repair.func_77973_b() == TFItems.knightmetal_ingot || (repair.func_77973_b() != Item.func_150898_a(Blocks.field_150344_f) && super.func_82789_a(toRepair, repair));
    }
    
    public boolean isShield(final ItemStack stack, @Nullable final EntityLivingBase entity) {
        return true;
    }
}
