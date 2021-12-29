// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.List;
import twilightforest.TwilightForestMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.item.TFItems;

public class BlockTFUncraftingTable extends aou
{
    public static lx tinkerTop;
    public static lx tinkerSide;
    
    protected BlockTFUncraftingTable(final int par1) {
        super(par1, ahz.d);
        this.c(2.5f);
        this.a(aou.g);
        this.a((uy)TFItems.creativeTab);
    }
    
    public lx a(final int side, final int meta) {
        return (side == 1) ? BlockTFUncraftingTable.tinkerTop : BlockTFUncraftingTable.tinkerSide;
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ly par1IconRegister) {
        BlockTFUncraftingTable.tinkerTop = par1IconRegister.a("twilightforest:uncrafting_top");
        BlockTFUncraftingTable.tinkerSide = par1IconRegister.a("twilightforest:uncrafting_side");
    }
    
    public boolean a(final zv world, final int x, final int y, final int z, final sk player, final int par6, final float par7, final float par8, final float par9) {
        player.openGui((Object)TwilightForestMod.instance, 1, world, x, y, z);
        return true;
    }
    
    public void a(final int par1, final uy par2CreativeTabs, final List par3List) {
        par3List.add(new wg(par1, 1, 0));
    }
}
