// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import java.util.List;
import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import twilightforest.TwilightForestMod;
import net.minecraft.world.IBlockAccess;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.Block;
import net.minecraft.util.IIcon;
import net.minecraft.block.BlockLeaves;

public class BlockTFMagicLeaves extends BlockLeaves
{
    int oakColor;
    int canopyColor;
    int mangroveColor;
    public static final int META_TIME = 0;
    public static final int META_TRANS = 1;
    public static final int META_MINE = 2;
    public static final int META_SORT = 3;
    public static IIcon SPR_TIMELEAVES;
    public static IIcon SPR_TIMEFX;
    public static IIcon SPR_TRANSLEAVES;
    public static IIcon SPR_TRANSFX;
    public static IIcon SPR_SORTLEAVES;
    public static IIcon SPR_SORTFX;
    
    protected BlockTFMagicLeaves() {
        this.oakColor = 4764952;
        this.canopyColor = 6330464;
        this.mangroveColor = 8431445;
        this.func_149711_c(0.2f);
        this.func_149713_g(2);
        this.func_149672_a(Block.field_149779_h);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public int func_149741_i(final int par1) {
        switch (par1 & 0x3) {
            case 0: {
                return 6986775;
            }
            case 1: {
                return 7130346;
            }
            case 2: {
                return 16576836;
            }
            case 3: {
                return 3558403;
            }
            default: {
                return 16777215;
            }
        }
    }
    
    public int func_149720_d(final IBlockAccess world, final int x, final int y, final int z) {
        final int leafType = world.func_72805_g(x, y, z) & 0x3;
        int red = 0;
        int green = 0;
        int blue = 0;
        if (leafType == 0) {
            int fade = x * 16 + y * 16 + z * 16;
            if ((fade & 0x100) != 0x0) {
                fade = 255 - (fade & 0xFF);
            }
            fade &= 0xFF;
            final float spring = (255 - fade) / 255.0f;
            final float fall = fade / 255.0f;
            red = (int)(spring * 106.0f + fall * 251.0f);
            green = (int)(spring * 156.0f + fall * 108.0f);
            blue = (int)(spring * 23.0f + fall * 27.0f);
        }
        else if (leafType == 2) {
            int fade = x * 31 + y * 33 + z * 32;
            if ((fade & 0x100) != 0x0) {
                fade = 255 - (fade & 0xFF);
            }
            fade &= 0xFF;
            final float spring = (255 - fade) / 255.0f;
            final float fall = fade / 255.0f;
            red = (int)(spring * 252.0f + fall * 237.0f);
            green = (int)(spring * 241.0f + fall * 172.0f);
            blue = (int)(spring * 68.0f + fall * 9.0f);
        }
        else if (leafType == 1) {
            int fade = x * 27 + y * 63 + z * 39;
            if ((fade & 0x100) != 0x0) {
                fade = 255 - (fade & 0xFF);
            }
            fade &= 0xFF;
            final float spring = (255 - fade) / 255.0f;
            final float fall = fade / 255.0f;
            red = (int)(spring * 108.0f + fall * 96.0f);
            green = (int)(spring * 204.0f + fall * 107.0f);
            blue = (int)(spring * 234.0f + fall * 121.0f);
        }
        else if (leafType == 3) {
            int fade = x * 63 + y * 63 + z * 63;
            if ((fade & 0x100) != 0x0) {
                fade = 255 - (fade & 0xFF);
            }
            fade &= 0xFF;
            final float spring = (255 - fade) / 255.0f;
            final float fall = fade / 255.0f;
            red = (int)(spring * 54.0f + fall * 168.0f);
            green = (int)(spring * 76.0f + fall * 199.0f);
            blue = (int)(spring * 3.0f + fall * 43.0f);
        }
        return red << 16 | green << 8 | blue;
    }
    
    public int func_149645_b() {
        return TwilightForestMod.proxy.getMagicLeavesBlockRenderID();
    }
    
    public int func_149701_w() {
        return 0;
    }
    
    public boolean func_149662_c() {
        return false;
    }
    
    public IIcon func_149691_a(final int side, final int meta) {
        switch (meta & 0x3) {
            default: {
                return BlockTFMagicLeaves.SPR_TIMELEAVES;
            }
            case 1: {
                return BlockTFMagicLeaves.SPR_TRANSLEAVES;
            }
            case 3: {
                return BlockTFMagicLeaves.SPR_SORTLEAVES;
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister par1IconRegister) {
        BlockTFMagicLeaves.SPR_TIMELEAVES = par1IconRegister.func_94245_a("TwilightForest:time_leaves");
        BlockTFMagicLeaves.SPR_TRANSLEAVES = par1IconRegister.func_94245_a("TwilightForest:trans_leaves");
        BlockTFMagicLeaves.SPR_SORTLEAVES = par1IconRegister.func_94245_a("TwilightForest:sort_leaves");
    }
    
    public boolean func_149646_a(final IBlockAccess iblockaccess, final int i, final int j, final int k, final int side) {
        return Blocks.field_150362_t.func_149646_a(iblockaccess, i, j, k, side);
    }
    
    public void func_149666_a(final Item par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 1));
        par3List.add(new ItemStack(par1, 1, 2));
        par3List.add(new ItemStack(par1, 1, 3));
    }
    
    public void func_149734_b(final World par1World, final int x, final int y, final int z, final Random par5Random) {
        final int meta = par1World.func_72805_g(x, y, z);
        if ((meta & 0x3) == 0x1) {
            for (int i = 0; i < 1; ++i) {
                this.sparkleRunes(par1World, x, y, z, par5Random);
            }
        }
    }
    
    private void sparkleRunes(final World world, final int x, final int y, final int z, final Random rand) {
        final double offset = 0.0625;
        final int side = rand.nextInt(5) + 1;
        double rx = x + rand.nextFloat();
        double ry = y + rand.nextFloat();
        double rz = z + rand.nextFloat();
        if (side == 0 && world.func_147437_c(x, y + 1, z)) {
            ry = y + 1 + offset;
        }
        if (side == 1 && world.func_147437_c(x, y - 1, z)) {
            ry = y + 0 - offset;
        }
        if (side == 2 && world.func_147437_c(x, y, z + 1)) {
            rz = z + 1 + offset;
        }
        if (side == 3 && world.func_147437_c(x, y, z - 1)) {
            rz = z + 0 - offset;
        }
        if (side == 4 && world.func_147437_c(x + 1, y, z)) {
            rx = x + 1 + offset;
        }
        if (side == 5 && world.func_147437_c(x - 1, y, z)) {
            rx = x + 0 - offset;
        }
        if (rx < x || rx > x + 1 || ry < y || ry > y + 1 || rz < z || rz > z + 1) {
            TwilightForestMod.proxy.spawnParticle(world, "leafrune", rx, ry, rz, 0.0, 0.0, 0.0);
        }
    }
    
    public String[] func_150125_e() {
        return null;
    }
}
