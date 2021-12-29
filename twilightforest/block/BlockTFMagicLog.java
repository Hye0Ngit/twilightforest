// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import twilightforest.item.TFItems;

public class BlockTFMagicLog extends ana
{
    public static int sprTimeTop;
    public static int sprTimeSide;
    public static int sprTimeClock;
    
    protected BlockTFMagicLog(final int i) {
        super(i);
        this.c(2.0f);
        this.a(amq.e);
        this.a((tj)TFItems.creativeTab);
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
    public void a(final yc world, final int x, final int y, final int z, final Random rand) {
    }
    
    public void a(final int par1, final tj par2CreativeTabs, final List par3List) {
        par3List.add(new ur(par1, 1, 0));
    }
    
    static {
        BlockTFMagicLog.sprTimeTop = 113;
        BlockTFMagicLog.sprTimeSide = 112;
        BlockTFMagicLog.sprTimeClock = 114;
    }
}
