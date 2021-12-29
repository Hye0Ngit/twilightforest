// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class ItemTFIronwoodHoe extends uj
{
    public ItemTFIronwoodHoe(final int par1, final ul par2EnumToolMaterial) {
        super(par1, par2EnumToolMaterial);
    }
    
    public String getTextureFile() {
        return "/twilightforest/items.png";
    }
    
    public boolean a(final um par1ItemStack, final um par2ItemStack) {
        return par2ItemStack.c == TFItems.ironwoodIngot.cg || super.a(par1ItemStack, par2ItemStack);
    }
}
