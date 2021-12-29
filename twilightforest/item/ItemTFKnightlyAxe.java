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
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.item.ItemAxe;

public class ItemTFKnightlyAxe extends ItemAxe implements ModelRegisterCallback
{
    protected ItemTFKnightlyAxe(final Item.ToolMaterial material) {
        super(material, 6.0f + material.func_78000_c(), material.func_77998_b() * 0.05f - 3.4f);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_77624_a(final ItemStack stack, @Nullable final World world, final List<String> tooltips, final ITooltipFlag flags) {
        super.func_77624_a(stack, world, (List)tooltips, flags);
        tooltips.add(I18n.func_135052_a(this.func_77658_a() + ".tooltip", new Object[0]));
    }
}
