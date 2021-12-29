import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFGenMangroveTree extends TFGenerator
{
    private Random treeRNG;
    private int x;
    private int y;
    private int z;
    private int height;
    private int treeBlock;
    private int treeMeta;
    private int leafBlock;
    private int leafMeta;
    
    @Override
    public boolean a(final ge world, final Random random, final int treeX, final int treeY, final int treeZ) {
        this.worldObj = world;
        this.treeRNG = random;
        this.x = treeX;
        this.y = treeY;
        this.z = treeZ;
        this.treeBlock = TFBlocks.wood.bO;
        this.treeMeta = 2;
        this.leafBlock = TFBlocks.leaves.bO;
        this.leafMeta = 2;
        final int blockUnder = world.a(this.x, this.y - 1, this.z);
        if (blockUnder != vz.B.bO || this.y >= 128 - this.height - 1) {
            return false;
        }
        this.buildBranch(5, 6 + this.treeRNG.nextInt(3), 0.0, 0.0);
        final int numBranches = this.treeRNG.nextInt(3);
        double offset = this.treeRNG.nextDouble();
        for (int b = 0; b < numBranches; ++b) {
            this.buildBranch(7 + b, 6 + this.treeRNG.nextInt(2), 0.3 * b + offset, 0.25);
        }
        final int numRoots = 3 + this.treeRNG.nextInt(2);
        offset = this.treeRNG.nextDouble();
        for (int i = 0; i < numRoots; ++i) {
            final double rTilt = 0.75 + this.treeRNG.nextDouble() * 0.1;
            this.buildRoot(5, 8.0, 0.4 * i + offset, rTilt);
        }
        this.addFirefly(5 + this.treeRNG.nextInt(5), this.treeRNG.nextDouble());
        return true;
    }
    
    void buildBranch(final int height, final double length, final double angle, final double tilt) {
        final int[] src = { this.x, this.y + height, this.z };
        final int[] dest = TFGenerator.translate(src[0], src[1], src[2], length, angle, tilt);
        this.drawBresehnam(src[0], src[1], src[2], dest[0], dest[1], dest[2], this.treeBlock, this.treeMeta, true);
        final int bSize = 2 + this.treeRNG.nextInt(3);
        if (bSize > 2) {
            this.putBlockAndMetadata(dest[0] + 1, dest[1], dest[2], this.treeBlock, this.treeMeta, true);
            this.putBlockAndMetadata(dest[0] - 1, dest[1], dest[2], this.treeBlock, this.treeMeta, true);
            this.putBlockAndMetadata(dest[0], dest[1], dest[2] + 1, this.treeBlock, this.treeMeta, true);
            this.putBlockAndMetadata(dest[0], dest[1], dest[2] - 1, this.treeBlock, this.treeMeta, true);
        }
        this.drawCircle(dest[0], dest[1] - 1, dest[2], (byte)(bSize - 1), this.leafBlock, this.leafMeta, false);
        this.drawCircle(dest[0], dest[1], dest[2], (byte)bSize, this.leafBlock, this.leafMeta, false);
        this.drawCircle(dest[0], dest[1] + 1, dest[2], (byte)(bSize - 2), this.leafBlock, this.leafMeta, false);
    }
    
    void buildRoot(final int height, final double length, final double angle, final double tilt) {
        final int[] src = { this.x, this.y + height, this.z };
        final int[] dest = TFGenerator.translate(src[0], src[1], src[2], length, angle, tilt);
        this.drawBresehnam(src[0], src[1], src[2], dest[0], dest[1], dest[2], this.treeBlock, this.treeMeta, true);
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
