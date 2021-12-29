// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import java.util.Random;
import twilightforest.block.TFBlocks;

public class TFGenSortingTree extends TFGenerator
{
    protected int treeBlock;
    protected int treeMeta;
    protected int branchMeta;
    protected int leafBlock;
    protected int leafMeta;
    protected int rootBlock;
    protected int rootMeta;
    
    public TFGenSortingTree() {
        this(false);
    }
    
    public TFGenSortingTree(final boolean notify) {
        super(notify);
        this.treeBlock = TFBlocks.magicLog.cF;
        this.treeMeta = 3;
        this.branchMeta = (this.treeMeta | 0xC);
        this.leafBlock = TFBlocks.magicLeaves.cF;
        this.leafMeta = 3;
        this.rootBlock = TFBlocks.root.cF;
        this.rootMeta = 0;
    }
    
    @Override
    public boolean a(final abv world, final Random rand, final int x, final int y, final int z) {
        final ajz materialUnder = world.g(x, y - 1, z);
        if ((materialUnder != ajz.b && materialUnder != ajz.c) || y >= TFWorld.MAXHEIGHT - 12) {
            return false;
        }
        for (int dy = 0; dy < 4; ++dy) {
            this.putBlockAndMetadata(world, x, y + dy, z, this.treeBlock, this.treeMeta, true);
        }
        this.putLeaves(world, x, y + 2, z, false);
        this.putLeaves(world, x, y + 3, z, false);
        this.putBlockAndMetadata(world, x, y + 1, z, TFBlocks.magicLogSpecial.cF, 3, true);
        return true;
    }
    
    protected void putLeaves(final abv world, final int bx, final int by, final int bz, final boolean bushy) {
        for (int lx = -1; lx <= 1; ++lx) {
            for (int ly = -1; ly <= 1; ++ly) {
                for (int lz = -1; lz <= 1; ++lz) {
                    if (bushy || Math.abs(ly) <= 0 || Math.abs(lx) + Math.abs(lz) <= 1) {
                        this.putBlockAndMetadata(world, bx + lx, by + ly, bz + lz, this.leafBlock, this.leafMeta, false);
                    }
                }
            }
        }
    }
}
