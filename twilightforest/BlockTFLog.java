// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Random;

public class BlockTFLog extends amt
{
    public static int sprTop;
    public static int sprOakSide;
    public static int sprCanopySide;
    public static int sprMangroveSide;
    public static int sprDarkwoodSide;
    
    protected BlockTFLog(final int i) {
        super(i);
        this.c(2.0f);
        this.a(amj.e);
    }
    
    public int a(final int side, final int meta) {
        final int orient = meta & 0xC;
        final int woodType = meta & 0x3;
        return (orient == 0 && (side == 1 || side == 0)) ? BlockTFLog.sprTop : ((orient == 4 && (side == 5 || side == 4)) ? BlockTFLog.sprTop : ((orient == 8 && (side == 2 || side == 3)) ? BlockTFLog.sprTop : ((woodType == 1) ? BlockTFLog.sprCanopySide : ((woodType == 2) ? BlockTFLog.sprMangroveSide : ((woodType == 3) ? BlockTFLog.sprDarkwoodSide : BlockTFLog.sprOakSide)))));
    }
    
    public int a(final int par1, final Random par2Random, final int par3) {
        return TFBlocks.log.cm;
    }
    
    public String getTextureFile() {
        return "/twilightforest/terrain.png";
    }
    
    static {
        BlockTFLog.sprTop = 0;
        BlockTFLog.sprOakSide = 1;
        BlockTFLog.sprCanopySide = 2;
        BlockTFLog.sprMangroveSide = 3;
        BlockTFLog.sprDarkwoodSide = 12;
    }
}
