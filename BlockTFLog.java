import java.util.ArrayList;
import java.util.Random;
import forge.ITextureProvider;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class BlockTFLog extends wy implements ITextureProvider
{
    public static int sprTop;
    public static int sprOakSide;
    public static int sprCanopySide;
    public static int sprMangroveSide;
    
    protected BlockTFLog(final int i) {
        super(i);
    }
    
    public int a(final int side, final int meta) {
        if (side <= 1 && meta > 7) {
            return BlockTFLog.sprTop;
        }
        if ((meta & 0x7) <= 0) {
            return BlockTFLog.sprOakSide;
        }
        if ((meta & 0x7) == 0x1) {
            return BlockTFLog.sprCanopySide;
        }
        return BlockTFLog.sprMangroveSide;
    }
    
    public void d(final ge par1World, final int x, final int y, final int z) {
        final byte range = 4;
        final int rangePlus = range + 1;
        if (par1World.a(x - rangePlus, y - rangePlus, z - rangePlus, x + rangePlus, y + rangePlus, z + rangePlus)) {
            for (int var7 = -range; var7 <= range; ++var7) {
                for (int var8 = -range; var8 <= range; ++var8) {
                    for (int var9 = -range; var9 <= range; ++var9) {
                        final int var10 = par1World.a(x + var7, y + var8, z + var9);
                        if (var10 == vz.K.bO || var10 == TFBlocks.leaves.bO) {
                            final int var11 = par1World.c(x + var7, y + var8, z + var9);
                            if ((var11 & 0x8) == 0x0) {
                                par1World.d(x + var7, y + var8, z + var9, var11 | 0x8);
                            }
                        }
                    }
                }
            }
        }
        if (par1World.a(x, y + 1, z) == this.bO) {
            par1World.c(x, y + 1, z, par1World.c(x, y + 1, z) | 0x8);
            par1World.j(x, y + 1, z);
        }
        if (par1World.a(x, y - 1, z) == this.bO) {
            par1World.c(x, y - 1, z, par1World.c(x, y - 1, z) | 0x8);
            par1World.j(x, y - 1, z);
        }
    }
    
    public int a(final int i, final Random random, final int j) {
        return TFBlocks.wood.bO;
    }
    
    protected int c(final int par1) {
        return par1 | 0x8;
    }
    
    public boolean canSilkHarvest(final ge world, final ih player, final int x, final int y, final int z, final int metadata) {
        return true;
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new kp((vz)this, 1, 0));
        itemList.add(new kp((vz)this, 1, 1));
        itemList.add(new kp((vz)this, 1, 2));
        itemList.add(new kp((vz)this, 1, 8));
        itemList.add(new kp((vz)this, 1, 9));
        itemList.add(new kp((vz)this, 1, 10));
    }
    
    public String getTextureFile() {
        return "/twilightforest/terrain.png";
    }
    
    static {
        BlockTFLog.sprTop = 0;
        BlockTFLog.sprOakSide = 1;
        BlockTFLog.sprCanopySide = 2;
        BlockTFLog.sprMangroveSide = 3;
    }
}
