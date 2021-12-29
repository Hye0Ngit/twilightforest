// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import java.util.Random;

public class BlockTFMagicLog extends amt
{
    public static int sprTimeTop;
    public static int sprTimeSide;
    public static int sprTimeClock;
    
    protected BlockTFMagicLog(final int i) {
        super(i);
        this.c(2.0f);
        this.a(amj.e);
    }
    
    public int a(final int side, final int meta) {
        final int orient = meta & 0xC;
        final int woodType = meta & 0x3;
        return (orient == 0 && (side == 1 || side == 0)) ? BlockTFMagicLog.sprTimeTop : ((orient == 4 && (side == 5 || side == 4)) ? BlockTFMagicLog.sprTimeTop : ((orient == 8 && (side == 2 || side == 3)) ? BlockTFMagicLog.sprTimeTop : BlockTFMagicLog.sprTimeSide));
    }
    
    public int a(final int par1, final Random par2Random, final int par3) {
        return this.cm;
    }
    
    public String getTextureFile() {
        return "/twilightforest/terrain.png";
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final xv world, final int x, final int y, final int z, final Random rand) {
    }
    
    static {
        BlockTFMagicLog.sprTimeTop = 113;
        BlockTFMagicLog.sprTimeSide = 112;
        BlockTFMagicLog.sprTimeClock = 114;
    }
}
