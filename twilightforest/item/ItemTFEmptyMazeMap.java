// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.TFAchievementPage;
import twilightforest.TFMazeMapData;

public class ItemTFEmptyMazeMap extends wu
{
    boolean mapOres;
    
    protected ItemTFEmptyMazeMap(final int par1, final boolean mapOres) {
        super(par1);
        this.a((wv)TFItems.creativeTab);
        this.mapOres = mapOres;
    }
    
    public yd a(final yd par1ItemStack, final abv par2World, final ue par3EntityPlayer) {
        final yd mapItem = new yd(this.mapOres ? TFItems.oreMap : TFItems.mazeMap, 1, par2World.b("mazemap"));
        final String var5 = "mazemap_" + mapItem.k();
        final TFMazeMapData mapData = new TFMazeMapData(var5);
        par2World.a(var5, (ali)mapData);
        mapData.d = 0;
        final int step = 128 * (1 << mapData.d);
        mapData.a = (int)(Math.round(par3EntityPlayer.u / step) * step) + 10;
        mapData.b = (int)(Math.round(par3EntityPlayer.w / step) * step) + 10;
        mapData.yCenter = lr.c(par3EntityPlayer.v);
        mapData.c = par2World.t.i;
        mapData.c();
        --par1ItemStack.b;
        if (mapItem.d == TFItems.mazeMap.cv) {
            par3EntityPlayer.a((kt)TFAchievementPage.twilightMazeMap);
        }
        if (mapItem.d == TFItems.oreMap.cv) {
            par3EntityPlayer.a((kt)TFAchievementPage.twilightOreMap);
        }
        if (par1ItemStack.b <= 0) {
            return mapItem;
        }
        if (!par3EntityPlayer.bn.a(mapItem.m())) {
            par3EntityPlayer.b(mapItem);
        }
        return par1ItemStack;
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ms par1IconRegister) {
        this.cz = par1IconRegister.a("TwilightForest:" + this.a().substring(5));
    }
}
