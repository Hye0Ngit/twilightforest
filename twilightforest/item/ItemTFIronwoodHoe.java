// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

public class ItemTFIronwoodHoe extends uo
{
    public ItemTFIronwoodHoe(final int par1, final uq par2EnumToolMaterial) {
        super(par1, par2EnumToolMaterial);
        this.a((tj)TFItems.creativeTab);
    }
    
    public String getTextureFile() {
        return "/twilightforest/items.png";
    }
    
    public boolean a(final ur par1ItemStack, final ur par2ItemStack) {
        return par2ItemStack.c == TFItems.ironwoodIngot.cj || super.a(par1ItemStack, par2ItemStack);
    }
}
