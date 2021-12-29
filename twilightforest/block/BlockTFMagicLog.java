// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.item.ItemStack;
import java.util.List;
import net.minecraft.world.World;
import java.util.Random;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.Block;
import net.minecraft.util.Icon;
import net.minecraft.block.BlockLog;

public class BlockTFMagicLog extends BlockLog
{
    public static final int META_TIME = 0;
    public static final int META_TRANS = 1;
    public static final int META_MINE = 2;
    public static final int META_SORT = 3;
    public static Icon SPR_TIMESIDE;
    public static Icon SPR_TIMETOP;
    public static Icon SPR_TIMECLOCK;
    public static Icon SPR_TIMECLOCKOFF;
    public static Icon SPR_TRANSSIDE;
    public static Icon SPR_TRANSTOP;
    public static Icon SPR_TRANSHEART;
    public static Icon SPR_TRANSHEARTOFF;
    public static Icon SPR_MINESIDE;
    public static Icon SPR_MINETOP;
    public static Icon SPR_MINEGEM;
    public static Icon SPR_MINEGEMOFF;
    public static Icon SPR_SORTSIDE;
    public static Icon SPR_SORTTOP;
    public static Icon SPR_SORTEYE;
    public static Icon SPR_SORTEYEOFF;
    
    protected BlockTFMagicLog(final int i) {
        super(i);
        this.func_71848_c(2.0f);
        this.func_71884_a(Block.field_71967_e);
        this.func_71849_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public Icon func_71858_a(final int side, final int meta) {
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
    public void func_94332_a(final IconRegister par1IconRegister) {
        BlockTFMagicLog.SPR_TIMESIDE = par1IconRegister.func_94245_a("TwilightForest:time_side");
        BlockTFMagicLog.SPR_TIMETOP = par1IconRegister.func_94245_a("TwilightForest:time_section");
        BlockTFMagicLog.SPR_TIMECLOCK = par1IconRegister.func_94245_a("TwilightForest:time_clock");
        BlockTFMagicLog.SPR_TIMECLOCKOFF = par1IconRegister.func_94245_a("TwilightForest:time_clock_off");
        BlockTFMagicLog.SPR_TRANSSIDE = par1IconRegister.func_94245_a("TwilightForest:trans_side");
        BlockTFMagicLog.SPR_TRANSTOP = par1IconRegister.func_94245_a("TwilightForest:trans_section");
        BlockTFMagicLog.SPR_TRANSHEART = par1IconRegister.func_94245_a("TwilightForest:trans_heart");
        BlockTFMagicLog.SPR_TRANSHEARTOFF = par1IconRegister.func_94245_a("TwilightForest:trans_heart_off");
        BlockTFMagicLog.SPR_MINESIDE = par1IconRegister.func_94245_a("TwilightForest:mine_side");
        BlockTFMagicLog.SPR_MINETOP = par1IconRegister.func_94245_a("TwilightForest:mine_section");
        BlockTFMagicLog.SPR_MINEGEM = par1IconRegister.func_94245_a("TwilightForest:mine_gem");
        BlockTFMagicLog.SPR_MINEGEMOFF = par1IconRegister.func_94245_a("TwilightForest:mine_gem_off");
        BlockTFMagicLog.SPR_SORTSIDE = par1IconRegister.func_94245_a("TwilightForest:sort_side");
        BlockTFMagicLog.SPR_SORTTOP = par1IconRegister.func_94245_a("TwilightForest:sort_section");
        BlockTFMagicLog.SPR_SORTEYE = par1IconRegister.func_94245_a("TwilightForest:sort_eye");
        BlockTFMagicLog.SPR_SORTEYEOFF = par1IconRegister.func_94245_a("TwilightForest:sort_eye_off");
    }
    
    public int func_71885_a(final int par1, final Random par2Random, final int par3) {
        return this.field_71990_ca;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_71862_a(final World world, final int x, final int y, final int z, final Random rand) {
    }
    
    public void func_71879_a(final int par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 1));
        par3List.add(new ItemStack(par1, 1, 2));
        par3List.add(new ItemStack(par1, 1, 3));
    }
}
