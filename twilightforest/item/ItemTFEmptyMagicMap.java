// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.TFMagicMapData;

public class ItemTFEmptyMagicMap extends ti
{
    protected ItemTFEmptyMagicMap(final int par1) {
        super(par1);
        this.a((tj)TFItems.creativeTab);
    }
    
    public ur a(final ur par1ItemStack, final yc par2World, final qx par3EntityPlayer) {
        final ur var4 = new ur(TFItems.magicMap, 1, par2World.b("magicmap"));
        final String var5 = "magicmap_" + var4.j();
        final ahn mapData = new TFMagicMapData(var5);
        par2World.a(var5, (ahq)mapData);
        mapData.d = 4;
        final int step = 128 * (1 << mapData.d);
        mapData.a = (int)(Math.round(par3EntityPlayer.t / step) * step);
        mapData.b = (int)(Math.round(par3EntityPlayer.v / step) * step);
        mapData.c = (byte)par2World.u.h;
        mapData.c();
        --par1ItemStack.a;
        if (par1ItemStack.a <= 0) {
            return var4;
        }
        if (!par3EntityPlayer.bJ.a(var4.l())) {
            par3EntityPlayer.c(var4);
        }
        return par1ItemStack;
    }
    
    public String getTextureFile() {
        return "/twilightforest/items.png";
    }
}
