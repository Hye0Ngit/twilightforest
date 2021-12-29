import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFGenHugeCanopyTree extends TFGenerator
{
    private Random treeRNG;
    private int x;
    private int y;
    private int z;
    private int treeHeight;
    private int treeBlock;
    private int treeMeta;
    private int leafBlock;
    private int leafMeta;
    
    @Override
    public boolean a(final ge world, final Random random, final int treeX, final int treeY, final int treeZ) {
        this.worldObj = world;
        this.treeRNG = random;
        final int blockUnder = world.a(treeX, treeY - 1, treeZ);
        if ((blockUnder != vz.u.bO && blockUnder != vz.v.bO) || this.y >= TFWorld.WORLDHEIGHT - this.treeHeight) {
            return false;
        }
        this.x = treeX;
        this.y = treeY;
        this.z = treeZ;
        this.treeBlock = TFBlocks.wood.bO;
        this.treeMeta = 1;
        this.leafBlock = TFBlocks.leaves.bO;
        this.leafMeta = 1;
        this.treeHeight = 35;
        if (this.treeRNG.nextInt(3) == 0) {
            this.treeHeight += this.treeRNG.nextInt(10);
            if (this.treeRNG.nextInt(8) == 0) {
                this.treeHeight += this.treeRNG.nextInt(10);
            }
        }
        this.buildTrunk(-3, this.treeHeight, 0.0, 0.0, true);
        final int numBranches = 5 + this.treeRNG.nextInt(3);
        final double offset = this.treeRNG.nextDouble();
        for (int b = 0; b < numBranches; ++b) {
            this.buildBranch(this.treeHeight - 23 + (int)(b * 1.5), 17.0, 0.3 * b + offset, 0.25, false);
        }
        return true;
    }
    
    void buildBranch(final int height, final double length, final double angle, final double tilt, final boolean firefly) {
        final int[] src = { this.x, this.y + height, this.z };
        final int[] dest = TFGenerator.translate(src[0], src[1], src[2], length, angle, tilt);
        this.drawBresehnam(src[0], src[1], src[2], dest[0], dest[1], dest[2], this.treeBlock, this.treeMeta, true);
        this.drawBresehnam(src[0], src[1] - 1, src[2], dest[0], dest[1] - 1, dest[2], this.treeBlock, this.treeMeta, true);
        if (firefly) {
            this.addFirefly(3 + this.treeRNG.nextInt(7), this.treeRNG.nextDouble());
        }
        this.makeLeafNode(dest);
    }
    
    protected void makeLeafNode(final int[] dest) {
        this.drawBresehnam(dest[0], dest[1], dest[2], dest[0] + 4, dest[1], dest[2] + 0, this.treeBlock, this.treeMeta, true);
        this.drawBresehnam(dest[0], dest[1], dest[2], dest[0] - 4, dest[1], dest[2] + 0, this.treeBlock, this.treeMeta, true);
        this.drawBresehnam(dest[0], dest[1], dest[2], dest[0] + 0, dest[1], dest[2] + 4, this.treeBlock, this.treeMeta, true);
        this.drawBresehnam(dest[0], dest[1], dest[2], dest[0] + 0, dest[1], dest[2] - 4, this.treeBlock, this.treeMeta, true);
        this.putBlockAndMetadata(dest[0] + 5, dest[1], dest[2] + 1, this.treeBlock, this.treeMeta, true);
        this.putBlockAndMetadata(dest[0] + 5, dest[1], dest[2] - 1, this.treeBlock, this.treeMeta, true);
        this.putBlockAndMetadata(dest[0] - 5, dest[1], dest[2] + 1, this.treeBlock, this.treeMeta, true);
        this.putBlockAndMetadata(dest[0] - 5, dest[1], dest[2] - 1, this.treeBlock, this.treeMeta, true);
        this.putBlockAndMetadata(dest[0] + 1, dest[1], dest[2] + 5, this.treeBlock, this.treeMeta, true);
        this.putBlockAndMetadata(dest[0] - 1, dest[1], dest[2] + 5, this.treeBlock, this.treeMeta, true);
        this.putBlockAndMetadata(dest[0] + 1, dest[1], dest[2] - 5, this.treeBlock, this.treeMeta, true);
        this.putBlockAndMetadata(dest[0] - 1, dest[1], dest[2] - 5, this.treeBlock, this.treeMeta, true);
        this.drawBresehnam(dest[0] + 1, dest[1], dest[2] + 0, dest[0] + 4, dest[1], dest[2] + 3, this.treeBlock, this.treeMeta, true);
        this.drawBresehnam(dest[0] - 1, dest[1], dest[2] + 0, dest[0] - 4, dest[1], dest[2] - 3, this.treeBlock, this.treeMeta, true);
        this.drawBresehnam(dest[0] + 0, dest[1], dest[2] + 1, dest[0] - 3, dest[1], dest[2] + 4, this.treeBlock, this.treeMeta, true);
        this.drawBresehnam(dest[0] + 0, dest[1], dest[2] - 1, dest[0] + 3, dest[1], dest[2] - 4, this.treeBlock, this.treeMeta, true);
        this.drawCircle(dest[0], dest[1] - 2, dest[2], 4, this.leafBlock, this.leafMeta, false);
        this.drawCircle(dest[0], dest[1] - 1, dest[2], 7, this.leafBlock, this.leafMeta, false);
        this.drawCircle(dest[0], dest[1], dest[2], 8, this.leafBlock, this.leafMeta, false);
        this.drawCircle(dest[0], dest[1] + 1, dest[2], 6, this.leafBlock, this.leafMeta, false);
        this.drawCircle(dest[0], dest[1] + 2, dest[2], 3, this.leafBlock, this.leafMeta, false);
    }
    
    void buildTrunk(final int height, final double length, final double angle, final double tilt, final boolean firefly) {
        final int[] src = { this.x, this.y + height, this.z };
        final int[] dest = TFGenerator.translate(src[0], src[1], src[2], length, angle, tilt);
        this.drawBresehnam(src[0], src[1], src[2], dest[0], dest[1], dest[2], this.treeBlock, this.treeMeta, true);
        this.drawBresehnam(src[0] + 1, src[1], src[2], dest[0] + 1, dest[1], dest[2], this.treeBlock, this.treeMeta, true);
        this.drawBresehnam(src[0] + 1, src[1], src[2] + 1, dest[0] + 1, dest[1], dest[2] + 1, this.treeBlock, this.treeMeta, true);
        this.drawBresehnam(src[0], src[1], src[2] + 1, dest[0], dest[1], dest[2] + 1, this.treeBlock, this.treeMeta, true);
        this.makeLeafNode(dest);
    }
    
    private void addFirefly(final int height, final double angle) {
        final int iAngle = (int)(angle * 4.0);
        if (iAngle == 0) {
            this.putBlockAndMetadata(this.x + 1, this.y + height, this.z, TFBlocks.firefly.bO, 1, false);
        }
        else if (iAngle == 1) {
            this.putBlockAndMetadata(this.x - 1, this.y + height, this.z, TFBlocks.firefly.bO, 2, false);
        }
        else if (iAngle == 2) {
            this.putBlockAndMetadata(this.x, this.y + height, this.z + 1, TFBlocks.firefly.bO, 3, false);
        }
        else if (iAngle == 3) {
            this.putBlockAndMetadata(this.x, this.y + height, this.z - 1, TFBlocks.firefly.bO, 4, false);
        }
    }
}
