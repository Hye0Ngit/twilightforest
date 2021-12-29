// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.List;
import twilightforest.TwilightForestMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.item.TFItems;

public class BlockTFUncraftingTable extends aqw
{
    public static mr tinkerTop;
    public static mr tinkerSide;
    
    protected BlockTFUncraftingTable(final int par1) {
        super(par1, ajz.d);
        this.c(2.5f);
        this.a(aqw.h);
        this.a((wv)TFItems.creativeTab);
    }
    
    public mr a(final int side, final int meta) {
        return (side == 1) ? BlockTFUncraftingTable.tinkerTop : BlockTFUncraftingTable.tinkerSide;
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ms par1IconRegister) {
        BlockTFUncraftingTable.tinkerTop = par1IconRegister.a("TwilightForest:uncrafting_top");
        BlockTFUncraftingTable.tinkerSide = par1IconRegister.a("TwilightForest:uncrafting_side");
    }
    
    public boolean a(final abv world, final int x, final int y, final int z, final ue player, final int par6, final float par7, final float par8, final float par9) {
        player.openGui((Object)TwilightForestMod.instance, 1, world, x, y, z);
        return true;
    }
    
    public void a(final int par1, final wv par2CreativeTabs, final List par3List) {
        par3List.add(new yd(par1, 1, 0));
    }
}
