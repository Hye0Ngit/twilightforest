// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.ArrayList;
import java.util.Random;
import forge.ITextureProvider;

public class BlockTFLog extends pp implements ITextureProvider
{
    public static int sprTop;
    public static int sprOakSide;
    public static int sprCanopySide;
    public static int sprMangroveSide;
    public static int sprDarkwoodSide;
    public static int spRootSide;
    public static int spOreRootSide;
    public static int sprRottenSide;
    public static final int HIGHEST_WOOD_META = 4;
    public static final int ROOT_META = 6;
    public static final int OREROOT_META = 14;
    
    protected BlockTFLog(final int i) {
        super(i);
        this.c(2.0f);
        this.a(pb.e);
    }
    
    public int a(final int side, final int meta) {
        final int maskedMeta = meta & 0x7;
        if (side <= 1 && meta > 7 && maskedMeta <= 4) {
            return BlockTFLog.sprTop;
        }
        if (maskedMeta <= 0) {
            return BlockTFLog.sprOakSide;
        }
        if (maskedMeta == 1) {
            return BlockTFLog.sprCanopySide;
        }
        if (maskedMeta == 2) {
            return BlockTFLog.sprMangroveSide;
        }
        if (maskedMeta == 3) {
            return BlockTFLog.sprDarkwoodSide;
        }
        if (meta == 6) {
            return BlockTFLog.spRootSide;
        }
        if (meta == 14) {
            return BlockTFLog.spOreRootSide;
        }
        if (maskedMeta == 7) {
            return BlockTFLog.sprRottenSide;
        }
        return BlockTFLog.sprOakSide;
    }
    
    public void b_(final xd par1World, final int x, final int y, final int z) {
        final int meta = par1World.e(x, y, z);
        if ((meta & 0x7) > 4) {
            return;
        }
        final byte range = 4;
        final int rangePlus = range + 1;
        if (par1World.b(x - rangePlus, y - rangePlus, z - rangePlus, x + rangePlus, y + rangePlus, z + rangePlus)) {
            for (int var7 = -range; var7 <= range; ++var7) {
                for (int var8 = -range; var8 <= range; ++var8) {
                    for (int var9 = -range; var9 <= range; ++var9) {
                        final int var10 = par1World.a(x + var7, y + var8, z + var9);
                        if (var10 == pb.K.bO || var10 == TFBlocks.leaves.bO) {
                            final int var11 = par1World.e(x + var7, y + var8, z + var9);
                            if ((var11 & 0x8) == 0x0) {
                                par1World.c(x + var7, y + var8, z + var9, var11 | 0x8);
                            }
                        }
                    }
                }
            }
        }
        if (par1World.a(x, y + 1, z) == this.bO && par1World.e(x, y + 1, z) <= 4) {
            par1World.f(x, y + 1, z, par1World.e(x, y + 1, z) | 0x8);
            par1World.k(x, y + 1, z);
        }
        if (par1World.a(x, y - 1, z) == this.bO && par1World.e(x, y - 1, z) <= 4) {
            par1World.f(x, y - 1, z, par1World.e(x, y - 1, z) | 0x8);
            par1World.k(x, y - 1, z);
        }
    }
    
    public int a(final int meta, final Random random, final int j) {
        switch (meta) {
            case 6: {
                return yr.D.bQ;
            }
            case 14: {
                return TFItems.liveRoot.bQ;
            }
            default: {
                return this.bO;
            }
        }
    }
    
    protected int c(final int meta) {
        switch (meta) {
            case 6: {
                return 0;
            }
            case 14: {
                return 0;
            }
            default: {
                return meta | 0x8;
            }
        }
    }
    
    public int quantityDropped(final int meta, final int fortune, final Random random) {
        switch (meta) {
            case 6: {
                return 3 + random.nextInt(2);
            }
            default: {
                return super.quantityDropped(meta, fortune, random);
            }
        }
    }
    
    public boolean canSilkHarvest(final xd world, final yw player, final int x, final int y, final int z, final int metadata) {
        return true;
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new aan((pb)this, 1, 0));
        itemList.add(new aan((pb)this, 1, 1));
        itemList.add(new aan((pb)this, 1, 2));
        itemList.add(new aan((pb)this, 1, 3));
        itemList.add(new aan((pb)this, 1, 6));
        itemList.add(new aan((pb)this, 1, 7));
        itemList.add(new aan((pb)this, 1, 8));
        itemList.add(new aan((pb)this, 1, 9));
        itemList.add(new aan((pb)this, 1, 10));
        itemList.add(new aan((pb)this, 1, 11));
        itemList.add(new aan((pb)this, 1, 14));
    }
    
    public String getTextureFile() {
        return "/twilightforest/terrain.png";
    }
    
    static {
        BlockTFLog.sprTop = 0;
        BlockTFLog.sprOakSide = 1;
        BlockTFLog.sprCanopySide = 2;
        BlockTFLog.sprMangroveSide = 3;
        BlockTFLog.sprDarkwoodSide = 12;
        BlockTFLog.spRootSide = 13;
        BlockTFLog.spOreRootSide = 14;
        BlockTFLog.sprRottenSide = 15;
    }
}
