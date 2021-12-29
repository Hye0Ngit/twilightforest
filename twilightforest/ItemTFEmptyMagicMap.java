// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class ItemTFEmptyMagicMap extends tg
{
    protected ItemTFEmptyMagicMap(final int par1) {
        super(par1);
        this.a(th.f);
    }
    
    public um a(final um par1ItemStack, final xv par2World, final qx par3EntityPlayer) {
        final um var4 = new um(TFItems.magicMap, 1, par2World.b("magicmap"));
        final String var5 = "magicmap_" + var4.j();
        final ahg mapData = new TFMagicMapData(var5);
        par2World.a(var5, (ahj)mapData);
        mapData.d = 4;
        final int step = 128 * (1 << mapData.d);
        mapData.a = (int)(Math.round(par3EntityPlayer.t / step) * step);
        mapData.b = (int)(Math.round(par3EntityPlayer.v / step) * step);
        mapData.c = (byte)par2World.v.h;
        mapData.c();
        --par1ItemStack.a;
        if (par1ItemStack.a <= 0) {
            return var4;
        }
        if (!par3EntityPlayer.bI.a(var4.l())) {
            par3EntityPlayer.c(var4);
        }
        return par1ItemStack;
    }
    
    public String getTextureFile() {
        return "/twilightforest/items.png";
    }
}
