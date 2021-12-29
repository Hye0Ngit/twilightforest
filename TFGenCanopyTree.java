import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFGenCanopyTree extends TFGenerator
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
    public boolean a(final ry world, final Random random, final int treeX, final int treeY, final int treeZ) {
        this.worldObj = world;
        this.treeRNG = random;
        final int blockUnder = world.a(treeX, treeY - 1, treeZ);
        if ((blockUnder != yy.u.bM && blockUnder != yy.v.bM) || this.y >= 128 - this.treeHeight - 1) {
            return false;
        }
        this.x = treeX;
        this.y = treeY;
        this.z = treeZ;
        this.treeBlock = TFBlocks.wood.bM;
        this.treeMeta = 1;
        this.leafBlock = TFBlocks.leaves.bM;
        this.leafMeta = 1;
        this.treeHeight = 20;
        if (this.treeRNG.nextInt(3) == 0) {
            this.treeHeight += this.treeRNG.nextInt(5);
            if (this.treeRNG.nextInt(8) == 0) {
                this.treeHeight += this.treeRNG.nextInt(5);
            }
        }
        this.buildBranch(0, this.treeHeight, 0.0, 0.0, true);
        final int numBranches = 3 + this.treeRNG.nextInt(2);
        final double offset = this.treeRNG.nextDouble();
        for (int b = 0; b < numBranches; ++b) {
            this.buildBranch(this.treeHeight - 10 + b, 9.0, 0.3 * b + offset, 0.2, false);
        }
        return true;
    }
    
    void buildBranch(final int height, final double length, final double angle, final double tilt, final boolean firefly) {
        final int[] src = { this.x, this.y + height, this.z };
        final int[] dest = TFGenerator.translate(src[0], src[1], src[2], length, angle, tilt);
        this.drawBresehnam(src[0], src[1], src[2], dest[0], dest[1], dest[2], this.treeBlock, this.treeMeta, true);
        if (firefly) {
            this.addFirefly(3 + this.treeRNG.nextInt(7), this.treeRNG.nextDouble());
        }
        this.putBlockAndMetadata(dest[0] + 1, dest[1], dest[2], this.treeBlock, this.treeMeta, true);
        this.putBlockAndMetadata(dest[0] - 1, dest[1], dest[2], this.treeBlock, this.treeMeta, true);
        this.putBlockAndMetadata(dest[0], dest[1], dest[2] + 1, this.treeBlock, this.treeMeta, true);
        this.putBlockAndMetadata(dest[0], dest[1], dest[2] - 1, this.treeBlock, this.treeMeta, true);
        this.drawCircle(dest[0], dest[1] - 1, dest[2], 3, this.leafBlock, this.leafMeta, false);
        this.drawCircle(dest[0], dest[1], dest[2], 4, this.leafBlock, this.leafMeta, false);
        this.drawCircle(dest[0], dest[1] + 1, dest[2], 2, this.leafBlock, this.leafMeta, false);
    }
    
    private void addFirefly(final int height, final double angle) {
        final int iAngle = (int)(angle * 4.0);
        if (iAngle == 0) {
            this.putBlockAndMetadata(this.x + 1, this.y + height, this.z, TFBlocks.firefly.bM, 1, false);
        }
        else if (iAngle == 1) {
            this.putBlockAndMetadata(this.x - 1, this.y + height, this.z, TFBlocks.firefly.bM, 2, false);
        }
        else if (iAngle == 2) {
            this.putBlockAndMetadata(this.x, this.y + height, this.z + 1, TFBlocks.firefly.bM, 3, false);
        }
        else if (iAngle == 3) {
            this.putBlockAndMetadata(this.x, this.y + height, this.z - 1, TFBlocks.firefly.bM, 4, false);
        }
    }
}
