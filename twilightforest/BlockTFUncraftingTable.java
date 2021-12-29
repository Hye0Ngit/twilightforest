// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.List;

public class BlockTFUncraftingTable extends amj
{
    public static int tinkerTop;
    public static int tinkerSide;
    
    protected BlockTFUncraftingTable(final int par1) {
        super(par1, BlockTFUncraftingTable.tinkerSide, agb.d);
        this.c(2.5f);
        this.a(amj.e);
        this.a(th.c);
    }
    
    public int a(final int side, final int meta) {
        return (side == 1) ? BlockTFUncraftingTable.tinkerTop : BlockTFUncraftingTable.tinkerSide;
    }
    
    public boolean a(final xv world, final int x, final int y, final int z, final qx player, final int par6, final float par7, final float par8, final float par9) {
        player.openGui((Object)TwilightForestMod.instance, 1, world, x, y, z);
        return true;
    }
    
    public void a(final int par1, final th par2CreativeTabs, final List par3List) {
        par3List.add(new um(par1, 1, 0));
    }
    
    public String getTextureFile() {
        return "/twilightforest/terrain.png";
    }
    
    static {
        BlockTFUncraftingTable.tinkerTop = 39;
        BlockTFUncraftingTable.tinkerSide = 55;
    }
}
