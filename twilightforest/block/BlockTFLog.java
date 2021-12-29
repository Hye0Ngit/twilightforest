// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.Random;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.Block;
import net.minecraft.util.Icon;
import net.minecraft.block.BlockLog;

public class BlockTFLog extends BlockLog
{
    public static Icon sprOakSide;
    public static Icon sprOakTop;
    public static Icon sprCanopySide;
    public static Icon sprCanopyTop;
    public static Icon sprMangroveSide;
    public static Icon sprMangroveTop;
    public static Icon sprDarkwoodSide;
    public static Icon sprDarkwoodTop;
    
    protected BlockTFLog(final int i) {
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
    public void func_94332_a(final IconRegister par1IconRegister) {
        BlockTFLog.sprOakSide = par1IconRegister.func_94245_a("twilightforest:oak_side");
        BlockTFLog.sprOakTop = par1IconRegister.func_94245_a("twilightforest:oak_top");
        BlockTFLog.sprCanopySide = par1IconRegister.func_94245_a("twilightforest:canopy_side");
        BlockTFLog.sprCanopyTop = par1IconRegister.func_94245_a("twilightforest:canopy_top");
        BlockTFLog.sprMangroveSide = par1IconRegister.func_94245_a("twilightforest:mangrove_side");
        BlockTFLog.sprMangroveTop = par1IconRegister.func_94245_a("twilightforest:mangrove_top");
        BlockTFLog.sprDarkwoodSide = par1IconRegister.func_94245_a("twilightforest:darkwood_side");
        BlockTFLog.sprDarkwoodTop = par1IconRegister.func_94245_a("twilightforest:darkwood_top");
    }
    
    public int func_71885_a(final int par1, final Random par2Random, final int par3) {
        return TFBlocks.log.field_71990_ca;
    }
}
