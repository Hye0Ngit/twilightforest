// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.ArrayList;
import java.util.Random;
import forge.IShearable;
import forge.ITextureProvider;

public class BlockTFPlant extends qk implements ITextureProvider, IShearable
{
    boolean[] isGrassColor;
    int[] lightValue;
    static int texRottenRight;
    static int texRottenLeft;
    public static final int TORCHBERRY_META = 13;
    public static final int ROOT_STRAND_META = 14;
    
    protected BlockTFPlant(final int par1) {
        super(par1, 16, acn.j);
        this.isGrassColor = new boolean[] { false, false, false, false, false, false, false, false, true, false, false, true, false, false, false, false };
        this.lightValue = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 8, 5, 0, 8, 0, 0 };
        this.bN = 16;
        this.a(true);
        final float var3 = 0.4f;
        this.a(0.5f - var3, 0.0f, 0.5f - var3, 0.5f + var3, 0.8f, 0.5f + var3);
        this.c(0.0f);
        this.a(pb.g);
    }
    
    public int a(final int par1, final int par2) {
        return 16 + par2;
    }
    
    public int i() {
        final double var1 = 0.5;
        final double var2 = 1.0;
        return zv.a(var1, var2);
    }
    
    public void a(final xd world, final int i, final int j, final int k) {
        super.a(world, i, j, k);
        world.a(i, j, k, this.bO, world.r.nextInt(50) + 20);
    }
    
    public boolean g(final xd world, final int x, final int y, final int z) {
        final int meta = world.e(x, y, z);
        return this.canBlockStay(world, x, y, z, meta);
    }
    
    public boolean canBlockStay(final xd world, final int x, final int y, final int z, final int meta) {
        switch (meta) {
            case 13:
            case 14: {
                return canPlaceRootBelow(world, x, y + 1, z);
            }
            case 15: {
                return world.a(x + 1, y, z) == TFBlocks.wood.bO || world.a(x - 1, y, z) == TFBlocks.wood.bO || world.a(x, y + 1, z) == TFBlocks.wood.bO || world.a(x, y - 1, z) == TFBlocks.wood.bO || world.a(x, y, z + 1) == TFBlocks.wood.bO || world.a(x, y, z - 1) == TFBlocks.wood.bO;
            }
            default: {
                return this.f_(world.a(x, y - 1, z));
            }
        }
    }
    
    protected boolean f_(final int underBlock) {
        return underBlock == pb.u.bO || underBlock == pb.v.bO || underBlock == pb.aA.bO;
    }
    
    public int d(final int par1) {
        return this.isGrassColor[par1] ? gu.c() : 16777215;
    }
    
    public int c(final ali par1IBlockAccess, final int par2, final int par3, final int par4) {
        final int meta = par1IBlockAccess.e(par2, par3, par4);
        return this.isGrassColor[meta] ? par1IBlockAccess.a(par2, par4).k() : 16777215;
    }
    
    public wu c(final xd par1World, final int x, final int y, final int z) {
        final int meta = par1World.e(x, y, z);
        switch (meta) {
            case 15: {
                return wu.b(x + 0.0625, y + 0.0625, z + 0.0625, x + 0.9375, y + 0.9375, z + 0.9375);
            }
            default: {
                return null;
            }
        }
    }
    
    public boolean a() {
        return false;
    }
    
    public boolean b() {
        return false;
    }
    
    public int d() {
        return mod_TwilightForest.plantRenderID;
    }
    
    public void a(final xd par1World, final int x, final int y, final int z, final Random par5Random) {
        final int meta = par1World.e(x, y, z);
        if (par1World.o(x, y, z) < this.lightValue[meta]) {
            par1World.c(wl.b, x, y, z);
        }
    }
    
    public int getLightValue(final ali world, final int x, final int y, final int z) {
        final int meta = world.e(x, y, z);
        return this.lightValue[meta];
    }
    
    public static boolean canPlaceRootBelow(final xd world, final int x, final int y, final int z) {
        final int blockID = world.a(x, y, z);
        if (pb.m[blockID] != null && (pb.m[blockID].cd == acn.c || pb.m[blockID].cd == acn.b)) {
            return true;
        }
        final int blockMeta = world.e(x, y, z);
        return (blockID == TFBlocks.plant.bO && blockMeta == 14) || (blockID == TFBlocks.wood.bO && blockMeta == 6);
    }
    
    public ArrayList getBlockDropped(final xd world, final int x, final int y, final int z, final int meta, final int fortune) {
        final ArrayList ret = new ArrayList();
        switch (meta) {
            case 13: {
                ret.add(new aan(TFItems.torchberries));
                break;
            }
            case 14: {
                break;
            }
            default: {
                ret.add(new aan((pb)this, 1, meta));
                break;
            }
        }
        return ret;
    }
    
    public boolean isShearable(final aan item, final xd world, final int x, final int y, final int z) {
        return true;
    }
    
    public ArrayList onSheared(final aan item, final xd world, final int x, final int y, final int z, final int fortune) {
        final ArrayList ret = new ArrayList();
        ret.add(new aan((pb)this, 1, world.e(x, y, z)));
        return ret;
    }
    
    public String getTextureFile() {
        return "/twilightforest/terrain.png";
    }
    
    public static boolean renderPlant(final vl renderblocks, final ali blockAccess, final int x, final int y, final int z, final pb block) {
        final int meta = blockAccess.e(x, y, z);
        if (meta == 15) {
            renderBlockRotten2(renderblocks, blockAccess, x, y, z, block);
        }
        else {
            renderblocks.j(block, x, y, z);
        }
        return true;
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new aan((pb)this, 1, 8));
        itemList.add(new aan((pb)this, 1, 9));
        itemList.add(new aan((pb)this, 1, 13));
        itemList.add(new aan((pb)this, 1, 14));
    }
    
    public void h() {
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }
    
    public static boolean renderBlockRotten(final vl renderblocks, final ali blockAccess, final int x, final int y, final int z, final pb block) {
        final adz tessellator = adz.a;
        final int texX = (BlockTFPlant.texRottenRight & 0xF) << 4;
        final int texY = BlockTFPlant.texRottenRight & 0xF0;
        final double ul = texX / 256.0f;
        final double ur = (texX + 15.99f) / 256.0f;
        final double bl = texY / 256.0f;
        final double br = (texY + 15.99f) / 256.0f;
        final int texX2 = (BlockTFPlant.texRottenLeft & 0xF) << 4;
        final int texY2 = BlockTFPlant.texRottenLeft & 0xF0;
        final double ul2 = texX2 / 256.0f;
        final double ur2 = (texX2 + 15.99f) / 256.0f;
        final double bl2 = texY2 / 256.0f;
        final double br2 = (texY2 + 15.99f) / 256.0f;
        final double x2 = x + 0.5 - 0.5;
        final double x3 = x + 0.5 + 0.5;
        final double y2 = y + 1.0;
        final double y3 = y + 0.0;
        final double z2 = z + 0.5 - 0.4375;
        final double z3 = z + 0.5 + 0.4375;
        tessellator.a(x2, y2, z2, ul, bl);
        tessellator.a(x2, y3, z2, ul, br);
        tessellator.a(x3, y3, z2, ur, br);
        tessellator.a(x3, y2, z2, ur, bl);
        tessellator.a(x3, y2, z2, ul2, br2);
        tessellator.a(x3, y3, z2, ur2, br2);
        tessellator.a(x2, y3, z2, ur2, bl2);
        tessellator.a(x2, y2, z2, ul2, bl2);
        return true;
    }
    
    public static boolean renderBlockHatch2(final vl renderblocks, final ali blockAccess, final int x, final int y, final int z, final pb block) {
        block.a(0.1875f, 0.0f, 0.1875f, 0.8125f, 1.0f, 0.8125f);
        renderblocks.o(block, x, y, z);
        block.a(0.0f, 0.1875f, 0.1875f, 1.0f, 0.8125f, 0.8125f);
        renderblocks.o(block, x, y, z);
        block.a(0.1875f, 0.1875f, 0.0f, 0.8125f, 0.8125f, 1.0f);
        renderblocks.o(block, x, y, z);
        if (blockAccess.a(x, y, z - 1) == TFBlocks.wood.bO) {
            renderblocks.d = 15;
            block.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.1875f);
            renderblocks.o(block, x, y, z);
            renderblocks.a();
        }
        if (blockAccess.a(x, y, z + 1) == TFBlocks.wood.bO) {
            renderblocks.d = 15;
            block.a(0.0f, 0.0f, 0.8125f, 1.0f, 1.0f, 1.0f);
            renderblocks.o(block, x, y, z);
            renderblocks.a();
        }
        if (blockAccess.a(x - 1, y, z) == TFBlocks.wood.bO) {
            renderblocks.d = 15;
            block.a(0.0f, 0.0f, 0.0f, 0.1875f, 1.0f, 1.0f);
            renderblocks.o(block, x, y, z);
            renderblocks.a();
        }
        if (blockAccess.a(x + 1, y, z) == TFBlocks.wood.bO) {
            block.a(0.8125f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
            renderblocks.d = 15;
            renderblocks.o(block, x, y, z);
            renderblocks.a();
        }
        if (blockAccess.a(x, y - 1, z) == TFBlocks.wood.bO) {
            renderblocks.d = 15;
            block.a(0.0f, 0.0f, 0.0f, 1.0f, 0.1875f, 1.0f);
            renderblocks.o(block, x, y, z);
            renderblocks.a();
        }
        if (blockAccess.a(x, y + 1, z) == TFBlocks.wood.bO) {
            block.a(0.0f, 0.8125f, 0.0f, 1.0f, 1.0f, 1.0f);
            renderblocks.d = 15;
            renderblocks.o(block, x, y, z);
            renderblocks.a();
        }
        block.h();
        return true;
    }
    
    public static boolean renderBlockRotten2(final vl renderblocks, final ali blockAccess, final int x, final int y, final int z, final pb block) {
        renderblocks.d = 15;
        if (blockAccess.a(x, y, z - 1) == TFBlocks.wood.bO) {
            setBlockBounds16(block, 1, 1, 0, 4, 6, 5);
            renderblocks.o(block, x, y, z);
            setBlockBounds16(block, 1, 6, 0, 6, 10, 10);
            renderblocks.o(block, x, y, z);
            setBlockBounds16(block, 1, 11, 0, 6, 15, 15);
            renderblocks.o(block, x, y, z);
            setBlockBounds16(block, 6, 9, 0, 10, 15, 10);
            renderblocks.o(block, x, y, z);
            setBlockBounds16(block, 11, 12, 0, 15, 15, 5);
            renderblocks.o(block, x, y, z);
        }
        if (blockAccess.a(x, y, z + 1) == TFBlocks.wood.bO) {
            setBlockBounds16(block, 1, 1, 11, 5, 6, 16);
            renderblocks.o(block, x, y, z);
            setBlockBounds16(block, 10, 6, 6, 15, 10, 16);
            renderblocks.o(block, x, y, z);
            setBlockBounds16(block, 10, 1, 1, 15, 6, 16);
            renderblocks.o(block, x, y, z);
            setBlockBounds16(block, 6, 1, 6, 10, 6, 16);
            renderblocks.o(block, x, y, z);
            setBlockBounds16(block, 11, 11, 11, 15, 15, 16);
            renderblocks.o(block, x, y, z);
        }
        if (blockAccess.a(x - 1, y, z) == TFBlocks.wood.bO) {
            setBlockBounds16(block, 0, 1, 1, 5, 6, 4);
            renderblocks.o(block, x, y, z);
            setBlockBounds16(block, 0, 6, 1, 10, 10, 6);
            renderblocks.o(block, x, y, z);
            setBlockBounds16(block, 0, 11, 1, 15, 15, 6);
            renderblocks.o(block, x, y, z);
            setBlockBounds16(block, 0, 9, 6, 10, 15, 10);
            renderblocks.o(block, x, y, z);
            setBlockBounds16(block, 0, 12, 11, 5, 15, 15);
            renderblocks.o(block, x, y, z);
        }
        if (blockAccess.a(x + 1, y, z) == TFBlocks.wood.bO) {
            setBlockBounds16(block, 11, 1, 1, 15, 6, 5);
            renderblocks.o(block, x, y, z);
            setBlockBounds16(block, 6, 6, 10, 16, 10, 15);
            renderblocks.o(block, x, y, z);
            setBlockBounds16(block, 1, 1, 10, 16, 6, 15);
            renderblocks.o(block, x, y, z);
            setBlockBounds16(block, 6, 1, 6, 16, 6, 10);
            renderblocks.o(block, x, y, z);
            setBlockBounds16(block, 11, 11, 11, 16, 15, 15);
            renderblocks.o(block, x, y, z);
        }
        if (blockAccess.a(x, y - 1, z) == TFBlocks.wood.bO) {
            setBlockBounds16(block, 1, 0, 1, 6, 5, 4);
            renderblocks.o(block, x, y, z);
            setBlockBounds16(block, 6, 0, 1, 10, 10, 6);
            renderblocks.o(block, x, y, z);
            setBlockBounds16(block, 11, 0, 1, 15, 15, 6);
            renderblocks.o(block, x, y, z);
            setBlockBounds16(block, 9, 0, 6, 15, 10, 10);
            renderblocks.o(block, x, y, z);
            setBlockBounds16(block, 12, 0, 11, 15, 5, 15);
            renderblocks.o(block, x, y, z);
        }
        if (blockAccess.a(x, y + 1, z) == TFBlocks.wood.bO) {
            setBlockBounds16(block, 1, 11, 1, 6, 16, 5);
            renderblocks.o(block, x, y, z);
            setBlockBounds16(block, 6, 6, 10, 10, 16, 15);
            renderblocks.o(block, x, y, z);
            setBlockBounds16(block, 1, 1, 10, 6, 16, 15);
            renderblocks.o(block, x, y, z);
            setBlockBounds16(block, 1, 6, 6, 6, 16, 10);
            renderblocks.o(block, x, y, z);
            setBlockBounds16(block, 11, 11, 11, 15, 16, 15);
            renderblocks.o(block, x, y, z);
        }
        renderblocks.a();
        block.h();
        return true;
    }
    
    static void setBlockBounds16(final pb block, final int x1, final int y1, final int z1, final int x2, final int y2, final int z2) {
        block.a(x1 / 16.0f, y1 / 16.0f, z1 / 16.0f, x2 / 16.0f, y2 / 16.0f, z2 / 16.0f);
    }
    
    public static boolean renderBlockHatch(final ali blockAccess, final int x, final int y, final int z, final pb block) {
        final adz var5 = adz.a;
        var5.b(block.d(blockAccess, x, y, z));
        var5.a(1.0f, 1.0f, 1.0f);
        renderBlockHatchImpl(block, blockAccess.e(x, y, z), x, y - 0.0625f, z);
        return true;
    }
    
    public static void renderBlockHatchImpl(final pb par1Block, final int par2, final double par3, final double par5, final double par7) {
        final adz tessellator = adz.a;
        final int textureIndex = par1Block.a(0, par2);
        final int texX = (textureIndex & 0xF) << 4;
        final int texY = textureIndex & 0xF0;
        final double ul = texX / 256.0f;
        final double ur = (texX + 15.99f) / 256.0f;
        final double bl = texY / 256.0f;
        final double br = (texY + 15.99f) / 256.0f;
        double x1 = par3 + 0.5 - 0.25;
        double x2 = par3 + 0.5 + 0.25;
        double y1 = par5 + 1.0;
        double y2 = par5 + 0.0;
        double z1 = par7 + 0.5 - 0.5;
        double z2 = par7 + 0.5 + 0.5;
        tessellator.a(x1, y1, z1, ul, bl);
        tessellator.a(x1, y2, z1, ul, br);
        tessellator.a(x1, y2, z2, ur, br);
        tessellator.a(x1, y1, z2, ur, bl);
        tessellator.a(x1, y1, z2, ul, bl);
        tessellator.a(x1, y2, z2, ul, br);
        tessellator.a(x1, y2, z1, ur, br);
        tessellator.a(x1, y1, z1, ur, bl);
        tessellator.a(x2, y1, z2, ul, bl);
        tessellator.a(x2, y2, z2, ul, br);
        tessellator.a(x2, y2, z1, ur, br);
        tessellator.a(x2, y1, z1, ur, bl);
        tessellator.a(x2, y1, z1, ul, bl);
        tessellator.a(x2, y2, z1, ul, br);
        tessellator.a(x2, y2, z2, ur, br);
        tessellator.a(x2, y1, z2, ur, bl);
        x1 = par3 + 0.5 - 0.5;
        x2 = par3 + 0.5 + 0.5;
        z1 = par7 + 0.5 - 0.25;
        z2 = par7 + 0.5 + 0.25;
        tessellator.a(x1, y1, z1, ul, bl);
        tessellator.a(x1, y2, z1, ul, br);
        tessellator.a(x2, y2, z1, ur, br);
        tessellator.a(x2, y1, z1, ur, bl);
        tessellator.a(x2, y1, z1, ul, bl);
        tessellator.a(x2, y2, z1, ul, br);
        tessellator.a(x1, y2, z1, ur, br);
        tessellator.a(x1, y1, z1, ur, bl);
        tessellator.a(x2, y1, z2, ul, bl);
        tessellator.a(x2, y2, z2, ul, br);
        tessellator.a(x1, y2, z2, ur, br);
        tessellator.a(x1, y1, z2, ur, bl);
        tessellator.a(x1, y1, z2, ul, bl);
        tessellator.a(x1, y2, z2, ul, br);
        tessellator.a(x2, y2, z2, ur, br);
        tessellator.a(x2, y1, z2, ur, bl);
        x1 = par3 + 0.0;
        x2 = par3 + 1.0;
        y1 = par5 + 0.5 - 0.25;
        y2 = par5 + 0.5 + 0.25;
        z1 = par7 + 0.0;
        z2 = par7 + 1.0;
        tessellator.a(x2, y1, z1, ul, bl);
        tessellator.a(x1, y1, z1, ul, br);
        tessellator.a(x1, y1, z2, ur, br);
        tessellator.a(x2, y1, z2, ur, bl);
        tessellator.a(x2, y1, z2, ul, bl);
        tessellator.a(x1, y1, z2, ul, br);
        tessellator.a(x1, y1, z1, ur, br);
        tessellator.a(x2, y1, z1, ur, bl);
        tessellator.a(x1, y2, z2, ul, bl);
        tessellator.a(x2, y2, z2, ul, br);
        tessellator.a(x2, y2, z1, ur, br);
        tessellator.a(x1, y2, z1, ur, bl);
        tessellator.a(x1, y2, z1, ul, bl);
        tessellator.a(x2, y2, z1, ul, br);
        tessellator.a(x2, y2, z2, ur, br);
        tessellator.a(x1, y2, z2, ur, bl);
    }
    
    static {
        BlockTFPlant.texRottenRight = 31;
        BlockTFPlant.texRottenLeft = 47;
    }
}
