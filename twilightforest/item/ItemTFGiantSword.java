// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.init.Items;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class ItemTFGiantSword extends ItemSword
{
    private GiantItemIcon giantIcon;
    
    public ItemTFGiantSword(final Item.ToolMaterial par2EnumToolMaterial) {
        super(par2EnumToolMaterial);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public boolean func_82789_a(final ItemStack par1ItemStack, final ItemStack par2ItemStack) {
        return par2ItemStack.func_77973_b() == TFItems.ironwoodIngot || super.func_82789_a(par1ItemStack, par2ItemStack);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IIconRegister par1IconRegister) {
        this.field_77791_bV = Items.field_151052_q.func_77617_a(0);
        this.giantIcon = new GiantItemIcon(this.field_77791_bV, 0.1875f, 0.3125f);
    }
    
    public IIcon getIcon(final ItemStack stack, final int pass) {
        if (pass == -1) {
            return (IIcon)this.giantIcon;
        }
        return super.getIcon(stack, pass);
    }
}
