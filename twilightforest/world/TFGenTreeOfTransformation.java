// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import java.util.Random;
import net.minecraft.world.World;
import twilightforest.block.TFBlocks;

public class TFGenTreeOfTransformation extends TFGenCanopyTree
{
    public TFGenTreeOfTransformation() {
        this(false);
    }
    
    public TFGenTreeOfTransformation(final boolean notify) {
        super(notify);
        this.treeBlock = TFBlocks.magicLog.field_71990_ca;
        this.treeMeta = 1;
        this.branchMeta = (this.treeMeta | 0xC);
        this.leafBlock = TFBlocks.magicLeaves.field_71990_ca;
        this.leafMeta = 1;
        this.minHeight = 11;
        this.chanceAddFirstFive = Integer.MAX_VALUE;
        this.chanceAddSecondFive = Integer.MAX_VALUE;
    }
    
    @Override
    public boolean func_76484_a(final World world, final Random random, final int x, final int y, final int z) {
        if (super.func_76484_a(world, random, x, y, z)) {
            this.putBlockAndMetadata(world, x, y + 3, z, TFBlocks.magicLogSpecial.field_71990_ca, 1, true);
            return true;
        }
        return false;
    }
}
