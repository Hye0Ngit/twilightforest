// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.block.TFBlocks;

public abstract class TFTreeGenerator extends TFGenerator
{
    protected int treeBlock;
    protected int treeMeta;
    protected int branchMeta;
    protected int leafBlock;
    protected int leafMeta;
    protected int rootBlock;
    protected int rootMeta;
    
    public TFTreeGenerator() {
        this(false);
    }
    
    public TFTreeGenerator(final boolean par1) {
        super(par1);
        this.treeBlock = TFBlocks.log.cF;
        this.treeMeta = 3;
        this.branchMeta = 15;
        this.leafBlock = TFBlocks.hedge.cF;
        this.leafMeta = 1;
        this.rootBlock = TFBlocks.root.cF;
        this.rootMeta = 0;
    }
    
    protected void buildRoot(final abv world, final int x, final int y, final int z, final double offset, final int b) {
        final int[] dest = TFGenerator.translate(x, y - b - 2, z, 5.0, 0.3 * b + offset, 0.8);
        final int[] lineArray = TFGenerator.getBresehnamArray(x, y - b - 2, z, dest[0], dest[1], dest[2]);
        for (int i = 0; i < lineArray.length; i += 3) {
            this.placeRootBlock(world, lineArray[i + 0], lineArray[i + 1], lineArray[i + 2], this.rootBlock, this.rootMeta);
        }
    }
    
    protected void placeRootBlock(final abv world, final int x, final int y, final int z, final int block, final int meta) {
        if (canRootGrowIn(world, x, y, z)) {
            this.a(world, x, y, z, block, meta);
        }
    }
    
    public static boolean canRootGrowIn(final abv world, final int x, final int y, final int z) {
        final int blockID = world.a(x, y, z);
        if (blockID == 0) {
            return TFGenerator.isNearSolid((ace)world, x, y, z);
        }
        return blockID != aqw.E.cF && blockID != aqw.au.cF && blockID != TFBlocks.shield.cF;
    }
}
