// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class ItemTFEmptyMazeMap extends tg
{
    boolean mapOres;
    
    protected ItemTFEmptyMazeMap(final int par1, final boolean mapOres) {
        super(par1);
        this.a(th.f);
        this.mapOres = mapOres;
    }
    
    public um a(final um par1ItemStack, final xv par2World, final qx par3EntityPlayer) {
        final um var4 = new um(this.mapOres ? TFItems.oreMap : TFItems.mazeMap, 1, par2World.b("mazemap"));
        final String var5 = "mazemap_" + var4.j();
        final TFMazeMapData mapData = new TFMazeMapData(var5);
        par2World.a(var5, (ahj)mapData);
        mapData.d = 0;
        final int step = 128 * (1 << mapData.d);
        mapData.a = (int)(Math.round(par3EntityPlayer.t / step) * step) + 10;
        mapData.b = (int)(Math.round(par3EntityPlayer.v / step) * step) + 10;
        mapData.yCenter = ke.c(par3EntityPlayer.u);
        mapData.c = par2World.v.h;
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
