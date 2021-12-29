// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.block.TFBlocks;

public class TFGenTreeOfTransformation extends TFGenCanopyTree
{
    public TFGenTreeOfTransformation() {
        this(false);
    }
    
    public TFGenTreeOfTransformation(final boolean notify) {
        super(notify);
        this.treeBlock = TFBlocks.magicLog.cz;
        this.treeMeta = 1;
        this.branchMeta = (this.treeMeta | 0xC);
        this.leafBlock = TFBlocks.magicLeaves.cz;
        this.leafMeta = 1;
        this.minHeight = 11;
        this.chanceAddFirstFive = Integer.MAX_VALUE;
        this.chanceAddSecondFive = Integer.MAX_VALUE;
    }
}
