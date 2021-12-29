// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.util;

import net.minecraft.block.Blocks;
import java.util.Random;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;
import net.minecraft.item.DyeColor;
import java.util.function.Function;

public class ColorUtil
{
    public static final ColorUtil WOOL;
    public static final ColorUtil TERRACOTTA;
    public static final ColorUtil STAINED_GLASS;
    private final Function<DyeColor, Block> function;
    
    private ColorUtil(final Function<DyeColor, Block> function) {
        this.function = function;
    }
    
    public BlockState getColor(final DyeColor color) {
        return this.function.apply(color).func_176223_P();
    }
    
    public Block getRandomColor(final Random rand) {
        final DyeColor color = DyeColor.func_196056_a(rand.nextInt(16));
        return this.getColor(color).func_177230_c();
    }
    
    static {
        WOOL = new ColorUtil(color -> {
            switch (color) {
                default: {
                    return Blocks.field_196556_aL;
                }
                case ORANGE: {
                    return Blocks.field_196557_aM;
                }
                case MAGENTA: {
                    return Blocks.field_196558_aN;
                }
                case LIGHT_BLUE: {
                    return Blocks.field_196559_aO;
                }
                case YELLOW: {
                    return Blocks.field_196560_aP;
                }
                case LIME: {
                    return Blocks.field_196561_aQ;
                }
                case PINK: {
                    return Blocks.field_196562_aR;
                }
                case GRAY: {
                    return Blocks.field_196563_aS;
                }
                case LIGHT_GRAY: {
                    return Blocks.field_196564_aT;
                }
                case CYAN: {
                    return Blocks.field_196565_aU;
                }
                case PURPLE: {
                    return Blocks.field_196566_aV;
                }
                case BLUE: {
                    return Blocks.field_196567_aW;
                }
                case BROWN: {
                    return Blocks.field_196568_aX;
                }
                case GREEN: {
                    return Blocks.field_196569_aY;
                }
                case RED: {
                    return Blocks.field_196570_aZ;
                }
                case BLACK: {
                    return Blocks.field_196602_ba;
                }
            }
        });
        TERRACOTTA = new ColorUtil(color -> {
            switch (color) {
                default: {
                    return Blocks.field_196777_fo;
                }
                case ORANGE: {
                    return Blocks.field_196778_fp;
                }
                case MAGENTA: {
                    return Blocks.field_196780_fq;
                }
                case LIGHT_BLUE: {
                    return Blocks.field_196782_fr;
                }
                case YELLOW: {
                    return Blocks.field_196783_fs;
                }
                case LIME: {
                    return Blocks.field_196785_ft;
                }
                case PINK: {
                    return Blocks.field_196787_fu;
                }
                case GRAY: {
                    return Blocks.field_196789_fv;
                }
                case LIGHT_GRAY: {
                    return Blocks.field_196791_fw;
                }
                case CYAN: {
                    return Blocks.field_196793_fx;
                }
                case PURPLE: {
                    return Blocks.field_196795_fy;
                }
                case BLUE: {
                    return Blocks.field_196797_fz;
                }
                case BROWN: {
                    return Blocks.field_196719_fA;
                }
                case GREEN: {
                    return Blocks.field_196720_fB;
                }
                case RED: {
                    return Blocks.field_196721_fC;
                }
                case BLACK: {
                    return Blocks.field_196722_fD;
                }
            }
        });
        STAINED_GLASS = new ColorUtil(color -> {
            switch (color) {
                default: {
                    return Blocks.field_196807_gj;
                }
                case ORANGE: {
                    return Blocks.field_196808_gk;
                }
                case MAGENTA: {
                    return Blocks.field_196809_gl;
                }
                case LIGHT_BLUE: {
                    return Blocks.field_196810_gm;
                }
                case YELLOW: {
                    return Blocks.field_196811_gn;
                }
                case LIME: {
                    return Blocks.field_196812_go;
                }
                case PINK: {
                    return Blocks.field_196813_gp;
                }
                case GRAY: {
                    return Blocks.field_196815_gq;
                }
                case LIGHT_GRAY: {
                    return Blocks.field_196816_gr;
                }
                case CYAN: {
                    return Blocks.field_196818_gs;
                }
                case PURPLE: {
                    return Blocks.field_196819_gt;
                }
                case BLUE: {
                    return Blocks.field_196820_gu;
                }
                case BROWN: {
                    return Blocks.field_196821_gv;
                }
                case GREEN: {
                    return Blocks.field_196822_gw;
                }
                case RED: {
                    return Blocks.field_196823_gx;
                }
                case BLACK: {
                    return Blocks.field_196824_gy;
                }
            }
        });
    }
}
