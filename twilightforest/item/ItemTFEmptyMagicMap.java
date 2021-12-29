// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.TFAchievementPage;
import twilightforest.TFMagicMapData;

public class ItemTFEmptyMagicMap extends wu
{
    protected ItemTFEmptyMagicMap(final int par1) {
        super(par1);
        this.a((wv)TFItems.creativeTab);
    }
    
    public yd a(final yd par1ItemStack, final abv par2World, final ue par3EntityPlayer) {
        final yd mapItem = new yd(TFItems.magicMap, 1, par2World.b("magicmap"));
        final String mapName = "magicmap_" + mapItem.k();
        final alf mapData = new TFMagicMapData(mapName);
        par2World.a(mapName, (ali)mapData);
        mapData.d = 4;
        final int step = 128 * (1 << mapData.d);
        mapData.a = (int)(Math.round(par3EntityPlayer.u / step) * step);
        mapData.b = (int)(Math.round(par3EntityPlayer.w / step) * step);
        mapData.c = (byte)par2World.t.i;
        mapData.c();
        --par1ItemStack.b;
        if (mapItem.d == TFItems.magicMap.cv) {
            par3EntityPlayer.a((kt)TFAchievementPage.twilightMagicMap);
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
