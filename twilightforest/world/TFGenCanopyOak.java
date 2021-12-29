// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.block.TFBlocks;

public class TFGenCanopyOak extends TFGenCanopyTree
{
    public TFGenCanopyOak() {
        this(false);
    }
    
    public TFGenCanopyOak(final boolean par1) {
        super(par1);
        this.treeBlock = TFBlocks.log;
        this.treeMeta = 0;
        this.branchMeta = 12;
        this.leafBlock = TFBlocks.leaves;
        this.leafMeta = 0;
        this.rootBlock = TFBlocks.root;
        this.rootMeta = 0;
    }
}
