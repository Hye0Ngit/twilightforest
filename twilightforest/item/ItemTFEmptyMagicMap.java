// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.TFAchievementPage;
import twilightforest.TFMagicMapData;

public class ItemTFEmptyMagicMap extends ux
{
    protected ItemTFEmptyMagicMap(final int par1) {
        super(par1);
        this.a((uy)TFItems.creativeTab);
    }
    
    public wg a(final wg par1ItemStack, final zv par2World, final sk par3EntityPlayer) {
        final wg mapItem = new wg(TFItems.magicMap, 1, par2World.b("magicmap"));
        final String mapName = "magicmap_" + mapItem.k();
        final ajf mapData = new TFMagicMapData(mapName);
        par2World.a(mapName, (aji)mapData);
        mapData.d = 4;
        final int step = 128 * (1 << mapData.d);
        mapData.a = (int)(Math.round(par3EntityPlayer.u / step) * step);
        mapData.b = (int)(Math.round(par3EntityPlayer.w / step) * step);
        mapData.c = (byte)par2World.t.h;
        mapData.c();
        --par1ItemStack.a;
        if (mapItem.c == TFItems.magicMap.cp) {
            par3EntityPlayer.a((ka)TFAchievementPage.twilightMagicMap);
        }
        if (par1ItemStack.a <= 0) {
            return mapItem;
        }
        if (!par3EntityPlayer.bK.a(mapItem.m())) {
            par3EntityPlayer.c(mapItem);
        }
        return par1ItemStack;
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ly par1IconRegister) {
        this.ct = par1IconRegister.a("twilightforest:" + this.a().substring(5));
    }
}
