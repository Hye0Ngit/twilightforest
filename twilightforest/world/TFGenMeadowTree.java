// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import java.util.Random;
import net.minecraft.world.World;
import twilightforest.block.TFBlocks;

public class TFGenMeadowTree extends TFGenHollowTree
{
    private int treeBlock;
    private int treeMeta;
    private int leafBlock;
    private int leafMeta;
    private int rootBlock;
    private int rootMeta;
    static int treesMade;
    static long totalTime;
    int leafBlobsMade;
    int leavesMade;
    
    public TFGenMeadowTree() {
        this.treeBlock = TFBlocks.log.field_71990_ca;
        this.treeMeta = 0;
        this.leafBlock = TFBlocks.leaves.field_71990_ca;
        this.leafMeta = 0;
        this.rootBlock = TFBlocks.root.field_71990_ca;
        this.rootMeta = 0;
    }
    
    @Override
    public boolean func_76484_a(final World world, final Random random, final int treeX, final int treeY, final int treeZ) {
        final long startTime = System.currentTimeMillis();
        this.leafBlobsMade = 0;
        final int height = 30;
        final int diameter = 7;
        return false;
    }
    
    static {
        TFGenMeadowTree.treesMade = 0;
        TFGenMeadowTree.totalTime = 0L;
    }
}
