// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import java.util.Random;
import twilightforest.block.TFBlocks;

public class TFGenSmallTwilightOak extends TFGenerator
{
    protected final int minTreeHeight;
    protected int treeBlock;
    protected int treeMeta;
    protected int branchMeta;
    protected int leafBlock;
    protected int leafMeta;
    protected int rootBlock;
    protected int rootMeta;
    
    public TFGenSmallTwilightOak(final boolean par1) {
        this(par1, 4);
    }
    
    public TFGenSmallTwilightOak(final boolean par1, final int par2) {
        super(par1);
        this.treeBlock = TFBlocks.log.cz;
        this.treeMeta = 0;
        this.branchMeta = (this.treeMeta | 0xC);
        this.leafBlock = TFBlocks.leaves.cz;
        this.leafMeta = 0;
        this.rootBlock = TFBlocks.root.cz;
        this.rootMeta = 0;
        this.minTreeHeight = par2;
    }
    
    @Override
    public boolean a(final zv par1World, final Random par2Random, final int x, final int y, final int z) {
        final int height = par2Random.nextInt(3) + this.minTreeHeight;
        boolean allClear = true;
        if (y < 1 || y + height + 1 > 256) {
            return false;
        }
        for (int cy = y; cy <= y + 1 + height; ++cy) {
            byte width = 1;
            if (cy == y) {
                width = 0;
            }
            if (cy >= y + 1 + height - 2) {
                width = 2;
            }
            for (int cx = x - width; cx <= x + width && allClear; ++cx) {
                for (int cz = z - width; cz <= z + width && allClear; ++cz) {
                    if (cy >= 0 && cy < 256) {
                        final int blockID = par1World.a(cx, cy, cz);
                        final aou block = aou.r[blockID];
                        if (blockID != 0 && !block.isLeaves(par1World, cx, cy, cz) && blockID != aou.y.cz && blockID != aou.z.cz && !block.isWood(par1World, cx, cy, cz)) {
                            allClear = false;
                        }
                    }
                    else {
                        allClear = false;
                    }
                }
            }
        }
        if (!allClear) {
            return false;
        }
        int cy = par1World.a(x, y - 1, z);
        if ((cy == aou.y.cz || cy == aou.z.cz) && y < 256 - height - 1) {
            this.a(par1World, x, y - 1, z, aou.z.cz);
            final byte width = 3;
            final byte var18 = 0;
            for (int cz = y - width + height; cz <= y + height; ++cz) {
                final int blockID = cz - (y + height);
                for (int treeWidth = var18 + 1 - blockID / 2, tx = x - treeWidth; tx <= x + treeWidth; ++tx) {
                    final int var19 = tx - x;
                    for (int tz = z - treeWidth; tz <= z + treeWidth; ++tz) {
                        final int var20 = tz - z;
                        final aou block2 = aou.r[par1World.a(tx, cz, tz)];
                        if ((Math.abs(var19) != treeWidth || Math.abs(var20) != treeWidth || (par2Random.nextInt(2) != 0 && blockID != 0)) && (block2 == null || block2.canBeReplacedByLeaves(par1World, tx, cz, tz))) {
                            this.a(par1World, tx, cz, tz, this.leafBlock, this.leafMeta);
                        }
                    }
                }
            }
            for (int cz = 0; cz < height; ++cz) {
                final int blockID = par1World.a(x, y + cz, z);
                final aou block3 = aou.r[blockID];
                if (blockID == 0 || block3 == null || block3.isLeaves(par1World, x, y + cz, z)) {
                    this.a(par1World, x, y + cz, z, this.treeBlock, this.treeMeta);
                }
            }
            return true;
        }
        return false;
    }
}
