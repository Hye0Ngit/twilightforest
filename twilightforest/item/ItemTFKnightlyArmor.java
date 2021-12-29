// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.TwilightForestMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

public class ItemTFKnightlyArmor extends wg
{
    public ItemTFKnightlyArmor(final int par1, final wi par2EnumArmorMaterial, final int renderIndex, final int armorType) {
        super(par1, par2EnumArmorMaterial, renderIndex, armorType);
        this.a((wv)TFItems.creativeTab);
    }
    
    public yp f(final yd par1ItemStack) {
        return yp.c;
    }
    
    public String getArmorTexture(final yd itemstack, final nm entity, final int slot, final int layer) {
        if (slot == 2) {
            return "twilightforest:textures/armor/knightly_2.png";
        }
        return "twilightforest:textures/armor/knightly_1.png";
    }
    
    public void a(final int par1, final wv par2CreativeTabs, final List par3List) {
        final yd istack = new yd(par1, 1, 0);
        par3List.add(istack);
    }
    
    public boolean a(final yd par1ItemStack, final yd par2ItemStack) {
        return par2ItemStack.d == TFItems.knightMetal.cv || super.a(par1ItemStack, par2ItemStack);
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ms par1IconRegister) {
        this.cz = par1IconRegister.a("TwilightForest:" + this.a().substring(5));
    }
    
    @SideOnly(Side.CLIENT)
    public bbg getArmorModel(final oe entityLiving, final yd itemStack, final int armorSlot) {
        return TwilightForestMod.proxy.getKnightlyArmorModel(armorSlot);
    }
}
