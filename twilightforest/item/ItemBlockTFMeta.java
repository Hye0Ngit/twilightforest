// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

public class ItemBlockTFMeta extends xh
{
    private final aou myBlock;
    
    public ItemBlockTFMeta(final int par1) {
        super(par1);
        this.a(true);
        this.e(0);
        this.myBlock = aou.r[par1 + 256];
    }
    
    public int a(final int i) {
        return i;
    }
    
    public String d(final wg itemstack) {
        final int meta = itemstack.k();
        return super.a() + "." + meta;
    }
    
    public lx a_(final int par1) {
        return this.myBlock.a(2, par1);
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final wg par1ItemStack, final sk par2EntityPlayer, final List par3List, final boolean par4) {
        super.a(par1ItemStack, par2EntityPlayer, par3List, par4);
        if (par1ItemStack.s().contains("[WIP]")) {
            par3List.add("This block is a work in progress");
            par3List.add("and may have bugs or unintended");
            par3List.add("effects that may damage your world.");
            par3List.add("Use with caution.");
        }
        if (par1ItemStack.s().contains("[NYI]")) {
            par3List.add("This block has effects");
            par3List.add("that are not yet implemented.");
        }
    }
}
