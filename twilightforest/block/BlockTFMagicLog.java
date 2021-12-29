// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.List;
import java.util.Random;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.item.TFItems;

public class BlockTFMagicLog extends arg
{
    public static final int META_TIME = 0;
    public static final int META_TRANS = 1;
    public static final int META_MINE = 2;
    public static final int META_SORT = 3;
    public static mr SPR_TIMESIDE;
    public static mr SPR_TIMETOP;
    public static mr SPR_TIMECLOCK;
    public static mr SPR_TIMECLOCKOFF;
    public static mr SPR_TRANSSIDE;
    public static mr SPR_TRANSTOP;
    public static mr SPR_TRANSHEART;
    public static mr SPR_TRANSHEARTOFF;
    public static mr SPR_MINESIDE;
    public static mr SPR_MINETOP;
    public static mr SPR_MINEGEM;
    public static mr SPR_MINEGEMOFF;
    public static mr SPR_SORTSIDE;
    public static mr SPR_SORTTOP;
    public static mr SPR_SORTEYE;
    public static mr SPR_SORTEYEOFF;
    
    protected BlockTFMagicLog(final int i) {
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
                return (orient == 0 && (side == 1 || side == 0)) ? BlockTFMagicLog.SPR_TIMETOP : ((orient == 4 && (side == 5 || side == 4)) ? BlockTFMagicLog.SPR_TIMETOP : ((orient == 8 && (side == 2 || side == 3)) ? BlockTFMagicLog.SPR_TIMETOP : BlockTFMagicLog.SPR_TIMESIDE));
            }
            case 1: {
                return (orient == 0 && (side == 1 || side == 0)) ? BlockTFMagicLog.SPR_TRANSTOP : ((orient == 4 && (side == 5 || side == 4)) ? BlockTFMagicLog.SPR_TRANSTOP : ((orient == 8 && (side == 2 || side == 3)) ? BlockTFMagicLog.SPR_TRANSTOP : BlockTFMagicLog.SPR_TRANSSIDE));
            }
            case 2: {
                return (orient == 0 && (side == 1 || side == 0)) ? BlockTFMagicLog.SPR_MINETOP : ((orient == 4 && (side == 5 || side == 4)) ? BlockTFMagicLog.SPR_MINETOP : ((orient == 8 && (side == 2 || side == 3)) ? BlockTFMagicLog.SPR_MINETOP : BlockTFMagicLog.SPR_MINESIDE));
            }
            case 3: {
                return (orient == 0 && (side == 1 || side == 0)) ? BlockTFMagicLog.SPR_SORTTOP : ((orient == 4 && (side == 5 || side == 4)) ? BlockTFMagicLog.SPR_SORTTOP : ((orient == 8 && (side == 2 || side == 3)) ? BlockTFMagicLog.SPR_SORTTOP : BlockTFMagicLog.SPR_SORTSIDE));
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ms par1IconRegister) {
        BlockTFMagicLog.SPR_TIMESIDE = par1IconRegister.a("TwilightForest:time_side");
        BlockTFMagicLog.SPR_TIMETOP = par1IconRegister.a("TwilightForest:time_section");
        BlockTFMagicLog.SPR_TIMECLOCK = par1IconRegister.a("TwilightForest:time_clock");
        BlockTFMagicLog.SPR_TIMECLOCKOFF = par1IconRegister.a("TwilightForest:time_clock_off");
        BlockTFMagicLog.SPR_TRANSSIDE = par1IconRegister.a("TwilightForest:trans_side");
        BlockTFMagicLog.SPR_TRANSTOP = par1IconRegister.a("TwilightForest:trans_section");
        BlockTFMagicLog.SPR_TRANSHEART = par1IconRegister.a("TwilightForest:trans_heart");
        BlockTFMagicLog.SPR_TRANSHEARTOFF = par1IconRegister.a("TwilightForest:trans_heart_off");
        BlockTFMagicLog.SPR_MINESIDE = par1IconRegister.a("TwilightForest:mine_side");
        BlockTFMagicLog.SPR_MINETOP = par1IconRegister.a("TwilightForest:mine_section");
        BlockTFMagicLog.SPR_MINEGEM = par1IconRegister.a("TwilightForest:mine_gem");
        BlockTFMagicLog.SPR_MINEGEMOFF = par1IconRegister.a("TwilightForest:mine_gem_off");
        BlockTFMagicLog.SPR_SORTSIDE = par1IconRegister.a("TwilightForest:sort_side");
        BlockTFMagicLog.SPR_SORTTOP = par1IconRegister.a("TwilightForest:sort_section");
        BlockTFMagicLog.SPR_SORTEYE = par1IconRegister.a("TwilightForest:sort_eye");
        BlockTFMagicLog.SPR_SORTEYEOFF = par1IconRegister.a("TwilightForest:sort_eye_off");
    }
    
    public int a(final int par1, final Random par2Random, final int par3) {
        return this.cF;
    }
    
    @SideOnly(Side.CLIENT)
    public void b(final abv world, final int x, final int y, final int z, final Random rand) {
    }
    
    public void a(final int par1, final wv par2CreativeTabs, final List par3List) {
        par3List.add(new yd(par1, 1, 0));
        par3List.add(new yd(par1, 1, 1));
        par3List.add(new yd(par1, 1, 2));
        par3List.add(new yd(par1, 1, 3));
    }
}
