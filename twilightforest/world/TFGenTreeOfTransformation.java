// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import java.util.Random;
import twilightforest.block.TFBlocks;

public class TFGenTreeOfTransformation extends TFGenCanopyTree
{
    public TFGenTreeOfTransformation() {
        this(false);
    }
    
    public TFGenTreeOfTransformation(final boolean notify) {
        super(notify);
        this.treeBlock = TFBlocks.magicLog.cF;
        this.treeMeta = 1;
        this.branchMeta = (this.treeMeta | 0xC);
        this.leafBlock = TFBlocks.magicLeaves.cF;
        this.leafMeta = 1;
        this.minHeight = 11;
        this.chanceAddFirstFive = Integer.MAX_VALUE;
        this.chanceAddSecondFive = Integer.MAX_VALUE;
    }
    
    @Override
    public boolean a(final abv world, final Random random, final int x, final int y, final int z) {
        if (super.a(world, random, x, y, z)) {
            this.putBlockAndMetadata(world, x, y + 3, z, TFBlocks.magicLogSpecial.cF, 1, true);
            return true;
        }
        return false;
    }
}
