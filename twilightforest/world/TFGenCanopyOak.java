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
        this.treeBlock = TFBlocks.log.field_71990_ca;
        this.treeMeta = 0;
        this.branchMeta = 12;
        this.leafBlock = TFBlocks.leaves.field_71990_ca;
        this.leafMeta = 0;
        this.rootBlock = TFBlocks.root.field_71990_ca;
        this.rootMeta = 0;
    }
}
