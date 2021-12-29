// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.Random;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.item.TFItems;

public class BlockTFLog extends arg
{
    public static mr sprOakSide;
    public static mr sprOakTop;
    public static mr sprCanopySide;
    public static mr sprCanopyTop;
    public static mr sprMangroveSide;
    public static mr sprMangroveTop;
    public static mr sprDarkwoodSide;
    public static mr sprDarkwoodTop;
    
    protected BlockTFLog(final int i) {
        super(i);
        this.c(2.0f);
        this.a(aqw.h);
        this.a((wv)TFItems.creativeTab);
    }
    
    public mr a(final int side, final int meta) {
        final int orient = meta & 0xC;
        final int woodType = meta & 0x3;
        switch (woodType) {
            default: {
                return (orient == 0 && (side == 1 || side == 0)) ? BlockTFLog.sprOakTop : ((orient == 4 && (side == 5 || side == 4)) ? BlockTFLog.sprOakTop : ((orient == 8 && (side == 2 || side == 3)) ? BlockTFLog.sprOakTop : BlockTFLog.sprOakSide));
            }
            case 1: {
                return (orient == 0 && (side == 1 || side == 0)) ? BlockTFLog.sprCanopyTop : ((orient == 4 && (side == 5 || side == 4)) ? BlockTFLog.sprCanopyTop : ((orient == 8 && (side == 2 || side == 3)) ? BlockTFLog.sprCanopyTop : BlockTFLog.sprCanopySide));
            }
            case 2: {
                return (orient == 0 && (side == 1 || side == 0)) ? BlockTFLog.sprMangroveTop : ((orient == 4 && (side == 5 || side == 4)) ? BlockTFLog.sprMangroveTop : ((orient == 8 && (side == 2 || side == 3)) ? BlockTFLog.sprMangroveTop : BlockTFLog.sprMangroveSide));
            }
            case 3: {
                return (orient == 0 && (side == 1 || side == 0)) ? BlockTFLog.sprDarkwoodTop : ((orient == 4 && (side == 5 || side == 4)) ? BlockTFLog.sprDarkwoodTop : ((orient == 8 && (side == 2 || side == 3)) ? BlockTFLog.sprDarkwoodTop : BlockTFLog.sprDarkwoodSide));
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ms par1IconRegister) {
        BlockTFLog.sprOakSide = par1IconRegister.a("TwilightForest:oak_side");
        BlockTFLog.sprOakTop = par1IconRegister.a("TwilightForest:oak_top");
        BlockTFLog.sprCanopySide = par1IconRegister.a("TwilightForest:canopy_side");
        BlockTFLog.sprCanopyTop = par1IconRegister.a("TwilightForest:canopy_top");
        BlockTFLog.sprMangroveSide = par1IconRegister.a("TwilightForest:mangrove_side");
        BlockTFLog.sprMangroveTop = par1IconRegister.a("TwilightForest:mangrove_top");
        BlockTFLog.sprDarkwoodSide = par1IconRegister.a("TwilightForest:darkwood_side");
        BlockTFLog.sprDarkwoodTop = par1IconRegister.a("TwilightForest:darkwood_top");
    }
    
    public int a(final int par1, final Random par2Random, final int par3) {
        return TFBlocks.log.cF;
    }
}
