// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.Random;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.item.TFItems;

public class BlockTFLog extends ape
{
    public static lx sprTop;
    public static lx sprOakSide;
    public static lx sprCanopySide;
    public static lx sprMangroveSide;
    public static lx sprDarkwoodSide;
    
    protected BlockTFLog(final int i) {
        super(i);
        this.c(2.0f);
        this.a(aou.g);
        this.a((uy)TFItems.creativeTab);
    }
    
    public lx a(final int side, final int meta) {
        final int orient = meta & 0xC;
        final int woodType = meta & 0x3;
        return (orient == 0 && (side == 1 || side == 0)) ? BlockTFLog.sprTop : ((orient == 4 && (side == 5 || side == 4)) ? BlockTFLog.sprTop : ((orient == 8 && (side == 2 || side == 3)) ? BlockTFLog.sprTop : ((woodType == 1) ? BlockTFLog.sprCanopySide : ((woodType == 2) ? BlockTFLog.sprMangroveSide : ((woodType == 3) ? BlockTFLog.sprDarkwoodSide : BlockTFLog.sprOakSide)))));
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ly par1IconRegister) {
        BlockTFLog.sprTop = par1IconRegister.a("twilightforest:oak_top");
        BlockTFLog.sprOakSide = par1IconRegister.a("twilightforest:oak_side");
        BlockTFLog.sprCanopySide = par1IconRegister.a("twilightforest:canopy_side");
        BlockTFLog.sprMangroveSide = par1IconRegister.a("twilightforest:mangrove_side");
        BlockTFLog.sprDarkwoodSide = par1IconRegister.a("twilightforest:darkwood_side");
    }
    
    public int a(final int par1, final Random par2Random, final int par3) {
        return TFBlocks.log.cz;
    }
}
