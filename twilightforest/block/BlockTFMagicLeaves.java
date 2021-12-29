// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.Random;
import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.TwilightForestMod;
import twilightforest.item.TFItems;

public class BlockTFMagicLeaves extends aow
{
    int oakColor;
    int canopyColor;
    int mangroveColor;
    private int[] c;
    public static final int META_TIME = 0;
    public static final int META_TRANS = 1;
    public static final int META_MINE = 2;
    public static final int META_SORT = 3;
    public static mr SPR_TIMELEAVES;
    public static mr SPR_TIMEFX;
    public static mr SPR_TRANSLEAVES;
    public static mr SPR_TRANSFX;
    public static mr SPR_SORTLEAVES;
    public static mr SPR_SORTFX;
    
    protected BlockTFMagicLeaves(final int i) {
        super(i);
        this.oakColor = 4764952;
        this.canopyColor = 6330464;
        this.mangroveColor = 8431445;
        this.c(0.2f);
        this.k(2);
        this.a(aqw.j);
        this.a((wv)TFItems.creativeTab);
    }
    
    public int b(final int par1) {
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
    
    public int c(final ace world, final int x, final int y, final int z) {
        final int leafType = world.h(x, y, z) & 0x3;
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
    
    public int d() {
        return TwilightForestMod.proxy.getMagicLeavesBlockRenderID();
    }
    
    public int n() {
        return 0;
    }
    
    public boolean c() {
        return false;
    }
    
    public mr a(final int side, final int meta) {
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
    public void a(final ms par1IconRegister) {
        BlockTFMagicLeaves.SPR_TIMELEAVES = par1IconRegister.a("TwilightForest:time_leaves");
        BlockTFMagicLeaves.SPR_TRANSLEAVES = par1IconRegister.a("TwilightForest:trans_leaves");
        BlockTFMagicLeaves.SPR_SORTLEAVES = par1IconRegister.a("TwilightForest:sort_leaves");
    }
    
    public boolean a(final ace iblockaccess, final int i, final int j, final int k, final int l) {
        return aqw.P.a(iblockaccess, i, j, k, l);
    }
    
    public void a(final int par1, final wv par2CreativeTabs, final List par3List) {
        par3List.add(new yd(par1, 1, 0));
        par3List.add(new yd(par1, 1, 1));
        par3List.add(new yd(par1, 1, 2));
        par3List.add(new yd(par1, 1, 3));
    }
    
    public void b(final abv par1World, final int x, final int y, final int z, final Random par5Random) {
        final int meta = par1World.h(x, y, z);
        if ((meta & 0x3) == 0x1) {
            for (int i = 0; i < 1; ++i) {
                this.sparkleRunes(par1World, x, y, z, par5Random);
            }
        }
    }
    
    private void sparkleRunes(final abv world, final int x, final int y, final int z, final Random rand) {
        final double offset = 0.0625;
        final int side = rand.nextInt(5) + 1;
        double rx = x + rand.nextFloat();
        double ry = y + rand.nextFloat();
        double rz = z + rand.nextFloat();
        if (side == 0 && world.c(x, y + 1, z)) {
            ry = y + 1 + offset;
        }
        if (side == 1 && world.c(x, y - 1, z)) {
            ry = y + 0 - offset;
        }
        if (side == 2 && world.c(x, y, z + 1)) {
            rz = z + 1 + offset;
        }
        if (side == 3 && world.c(x, y, z - 1)) {
            rz = z + 0 - offset;
        }
        if (side == 4 && world.c(x + 1, y, z)) {
            rx = x + 1 + offset;
        }
        if (side == 5 && world.c(x - 1, y, z)) {
            rx = x + 0 - offset;
        }
        if (rx < x || rx > x + 1 || ry < y || ry > y + 1 || rz < z || rz > z + 1) {
            TwilightForestMod.proxy.spawnParticle("leafrune", rx, ry, rz, 0.0, 0.0, 0.0);
        }
    }
}
