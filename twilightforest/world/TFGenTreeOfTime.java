// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import java.util.Random;
import twilightforest.block.TFBlocks;

public class TFGenTreeOfTime extends TFGenHollowTree
{
    public TFGenTreeOfTime(final boolean par1) {
        super(par1);
        this.treeBlock = TFBlocks.magicLog.cm;
        this.treeMeta = 0;
        this.branchMeta = (this.treeMeta | 0xC);
        this.leafBlock = TFBlocks.magicLeaves.cm;
        this.leafMeta = 0;
    }
    
    @Override
    public boolean a(final yc world, final Random random, final int treeX, final int treeY, final int treeZ) {
        this.worldObj = world;
        this.treeRNG = random;
        this.x = treeX;
        this.y = treeY;
        this.z = treeZ;
        this.height = 8;
        this.diameter = 1;
        if (this.y < 1 || this.y + this.height + this.diameter > TFWorld.WORLDHEIGHT) {
            System.out.println("Failed with hollow tree of height " + this.height);
            return false;
        }
        final int j1 = world.a(this.x, this.y - 1, this.z);
        if (j1 != amq.x.cm && j1 != amq.y.cm) {
            return false;
        }
        this.buildTrunk();
        this.buildTinyCrown();
        this.buildBranchRing(1, 0, 12, 0, 0.75, 0.0, 3, 5, 3, false);
        this.buildBranchRing(1, 2, 18, 0, 0.9, 0.0, 3, 5, 3, false);
        return true;
    }
    
    protected void buildTinyCrown() {
        final int crownRadius = 4;
        final int bvar = 1;
        this.buildBranchRing(this.height - crownRadius, 0, crownRadius, 0, 0.35, 0.0, bvar, bvar + 2, 1, true);
        this.buildBranchRing(this.height - crownRadius / 2, 0, crownRadius, 0, 0.28, 0.0, bvar, bvar + 2, 1, true);
        this.buildBranchRing(this.height, 0, crownRadius, 0, 0.15, 0.0, 2, 4, 0, true);
        this.buildBranchRing(this.height, 0, crownRadius / 2, 0, 0.05, 0.0, bvar, bvar + 2, 0, true);
    }
    
    public boolean XXXXXgenerate(final yc world, final Random rand, final int x, final int y, final int z) {
        this.worldObj = world;
        final int height = 9 + rand.nextInt(4);
        final agi under = world.g(x, y - 1, z);
        if (under != agi.b && under != agi.c) {
            return false;
        }
        this.drawBresehnam(x, y, z, x, y + height, z, this.treeBlock, this.treeMeta, true);
        this.makeNode(x, y, z);
        this.makeNode(x, y + height, z);
        this.drawCircle(x, y + height - 1, z, 2, this.leafBlock, this.leafMeta, false);
        this.drawCircle(x, y + height, z, 3, this.leafBlock, this.leafMeta, false);
        this.drawCircle(x, y + height + 1, z, 2, this.leafBlock, this.leafMeta, false);
        this.drawCircle(x - 3, y + height - 1, z, 1, this.leafBlock, this.leafMeta, false);
        this.drawCircle(x - 2, y + height + 0, z, 2, this.leafBlock, this.leafMeta, false);
        this.drawCircle(x - 3, y + height + 0, z, 2, this.leafBlock, this.leafMeta, false);
        this.drawCircle(x - 3, y + height + 1, z, 1, this.leafBlock, this.leafMeta, false);
        this.drawBresehnam(x - 1, y + height - 6, z, x - 4, y + height - 6, z, this.treeBlock, this.treeMeta | 0x4, true);
        this.drawBresehnam(x - 4, y + height - 6, z, x - 4, y + height - 4, z, this.treeBlock, this.treeMeta, true);
        this.makeNode(x - 4, y + height - 4, z);
        this.drawCircle(x - 4, y + height - 3, z, 1, this.leafBlock, this.leafMeta, false);
        this.drawCircle(x - 4, y + height - 4, z, 2, this.leafBlock, this.leafMeta, false);
        this.drawCircle(x - 4, y + height - 5, z, 1, this.leafBlock, this.leafMeta, false);
        this.drawCircle(x - 5, y + height - 3, z, 1, this.leafBlock, this.leafMeta, false);
        this.drawCircle(x - 7, y + height - 4, z, 2, this.leafBlock, this.leafMeta, false);
        this.drawCircle(x - 5, y + height - 5, z, 1, this.leafBlock, this.leafMeta, false);
        this.putBlockAndMetadata(x, y + 2, z, TFBlocks.magicLogSpecial.cm, this.treeMeta, true);
        return true;
    }
    
    protected void makeNode(final int x, final int y, final int z) {
        this.putBlockAndMetadata(x + 1, y, z + 0, this.treeBlock, this.treeMeta | 0x4, true);
        this.putBlockAndMetadata(x + 0, y, z + 1, this.treeBlock, this.treeMeta | 0x8, true);
        this.putBlockAndMetadata(x - 1, y, z + 0, this.treeBlock, this.treeMeta | 0x4, true);
        this.putBlockAndMetadata(x + 0, y, z - 1, this.treeBlock, this.treeMeta | 0x8, true);
        this.putBlockAndMetadata(x - 2, y, z + 0, this.treeBlock, this.treeMeta | 0x4, true);
    }
}
