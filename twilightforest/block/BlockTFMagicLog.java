// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.List;
import java.util.Random;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.item.TFItems;

public class BlockTFMagicLog extends ape
{
    public static final int META_TIME = 0;
    public static final int META_TRANS = 1;
    public static final int META_MINE = 2;
    public static final int META_SORT = 3;
    public static lx SPR_TIMESIDE;
    public static lx SPR_TIMETOP;
    public static lx SPR_TIMECLOCK;
    public static lx SPR_TIMECLOCKOFF;
    public static lx SPR_TRANSSIDE;
    public static lx SPR_TRANSTOP;
    public static lx SPR_TRANSHEART;
    public static lx SPR_TRANSHEARTOFF;
    public static lx SPR_MINESIDE;
    public static lx SPR_MINETOP;
    public static lx SPR_MINEGEM;
    public static lx SPR_MINEGEMOFF;
    public static lx SPR_SORTSIDE;
    public static lx SPR_SORTTOP;
    public static lx SPR_SORTEYE;
    public static lx SPR_SORTEYEOFF;
    
    protected BlockTFMagicLog(final int i) {
        super(i);
        this.c(2.0f);
        this.a(aou.g);
        this.a((uy)TFItems.creativeTab);
    }
    
    public lx a(final int side, final int meta) {
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
    public void a(final ly par1IconRegister) {
        BlockTFMagicLog.SPR_TIMESIDE = par1IconRegister.a("twilightforest:time_side");
        BlockTFMagicLog.SPR_TIMETOP = par1IconRegister.a("twilightforest:time_section");
        BlockTFMagicLog.SPR_TIMECLOCK = par1IconRegister.a("twilightforest:time_clock");
        BlockTFMagicLog.SPR_TIMECLOCKOFF = par1IconRegister.a("twilightforest:time_clock_off");
        BlockTFMagicLog.SPR_TRANSSIDE = par1IconRegister.a("twilightforest:trans_side");
        BlockTFMagicLog.SPR_TRANSTOP = par1IconRegister.a("twilightforest:trans_section");
        BlockTFMagicLog.SPR_TRANSHEART = par1IconRegister.a("twilightforest:trans_heart");
        BlockTFMagicLog.SPR_TRANSHEARTOFF = par1IconRegister.a("twilightforest:trans_heart_off");
        BlockTFMagicLog.SPR_MINESIDE = par1IconRegister.a("twilightforest:mine_side");
        BlockTFMagicLog.SPR_MINETOP = par1IconRegister.a("twilightforest:mine_section");
        BlockTFMagicLog.SPR_MINEGEM = par1IconRegister.a("twilightforest:mine_gem");
        BlockTFMagicLog.SPR_MINEGEMOFF = par1IconRegister.a("twilightforest:mine_gem_off");
        BlockTFMagicLog.SPR_SORTSIDE = par1IconRegister.a("twilightforest:sort_side");
        BlockTFMagicLog.SPR_SORTTOP = par1IconRegister.a("twilightforest:sort_section");
        BlockTFMagicLog.SPR_SORTEYE = par1IconRegister.a("twilightforest:sort_eye");
        BlockTFMagicLog.SPR_SORTEYEOFF = par1IconRegister.a("twilightforest:sort_eye_off");
    }
    
    public int a(final int par1, final Random par2Random, final int par3) {
        return this.cz;
    }
    
    @SideOnly(Side.CLIENT)
    public void b(final zv world, final int x, final int y, final int z, final Random rand) {
    }
    
    public void a(final int par1, final uy par2CreativeTabs, final List par3List) {
        par3List.add(new wg(par1, 1, 0));
        par3List.add(new wg(par1, 1, 1));
        par3List.add(new wg(par1, 1, 2));
        par3List.add(new wg(par1, 1, 3));
    }
}
