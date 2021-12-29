// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.item.Item;
import java.util.Random;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.Block;
import net.minecraft.util.IIcon;
import net.minecraft.block.BlockLog;

public class BlockTFCinderLog extends BlockLog
{
    private IIcon topIcon;
    private IIcon cornerIcon;
    
    protected BlockTFCinderLog() {
        this.func_149711_c(1.0f);
        this.func_149672_a(Block.field_149766_f);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public IIcon func_149691_a(final int side, final int meta) {
        final int orient = meta & 0xC;
        return (orient == 12) ? this.cornerIcon : ((orient == 0 && (side == 1 || side == 0)) ? this.topIcon : ((orient == 4 && (side == 5 || side == 4)) ? this.topIcon : ((orient == 8 && (side == 2 || side == 3)) ? this.topIcon : this.field_149761_L)));
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister par1IconRegister) {
        this.field_149761_L = par1IconRegister.func_94245_a("TwilightForest:cinder_side");
        this.topIcon = par1IconRegister.func_94245_a("TwilightForest:cinder_top");
        this.cornerIcon = par1IconRegister.func_94245_a("TwilightForest:cinder_corner");
    }
    
    public Item func_149650_a(final int par1, final Random par2Random, final int par3) {
        return Item.func_150898_a(TFBlocks.cinderLog);
    }
}
