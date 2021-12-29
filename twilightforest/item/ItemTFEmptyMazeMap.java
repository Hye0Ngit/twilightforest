// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.TFAchievementPage;
import twilightforest.TFMazeMapData;

public class ItemTFEmptyMazeMap extends ux
{
    boolean mapOres;
    
    protected ItemTFEmptyMazeMap(final int par1, final boolean mapOres) {
        super(par1);
        this.a((uy)TFItems.creativeTab);
        this.mapOres = mapOres;
    }
    
    public wg a(final wg par1ItemStack, final zv par2World, final sk par3EntityPlayer) {
        final wg mapItem = new wg(this.mapOres ? TFItems.oreMap : TFItems.mazeMap, 1, par2World.b("mazemap"));
        final String var5 = "mazemap_" + mapItem.k();
        final TFMazeMapData mapData = new TFMazeMapData(var5);
        par2World.a(var5, (aji)mapData);
        mapData.d = 0;
        final int step = 128 * (1 << mapData.d);
        mapData.a = (int)(Math.round(par3EntityPlayer.u / step) * step) + 10;
        mapData.b = (int)(Math.round(par3EntityPlayer.w / step) * step) + 10;
        mapData.yCenter = kx.c(par3EntityPlayer.v);
        mapData.c = par2World.t.h;
        mapData.c();
        --par1ItemStack.a;
        if (mapItem.c == TFItems.mazeMap.cp) {
            par3EntityPlayer.a((ka)TFAchievementPage.twilightMazeMap);
        }
        if (mapItem.c == TFItems.oreMap.cp) {
            par3EntityPlayer.a((ka)TFAchievementPage.twilightOreMap);
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
