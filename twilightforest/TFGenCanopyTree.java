// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Random;

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
    private int rootBlock;
    private int rootMeta;
    
    public TFGenCanopyTree() {
        this.treeBlock = TFBlocks.wood.bO;
        this.treeMeta = 1;
        this.leafBlock = TFBlocks.leaves.bO;
        this.leafMeta = 1;
        this.rootBlock = TFBlocks.wood.bO;
        this.rootMeta = 6;
    }
    
    @Override
    public boolean a(final xd world, final Random random, final int treeX, final int treeY, final int treeZ) {
        this.worldObj = world;
        this.treeRNG = random;
        final int blockUnder = world.a(treeX, treeY - 1, treeZ);
        if ((blockUnder != pb.u.bO && blockUnder != pb.v.bO) || this.y >= TFWorld.WORLDHEIGHT - this.treeHeight) {
            return false;
        }
        this.x = treeX;
        this.y = treeY;
        this.z = treeZ;
        this.treeHeight = 20;
        if (this.treeRNG.nextInt(3) == 0) {
            this.treeHeight += this.treeRNG.nextInt(5);
            if (this.treeRNG.nextInt(8) == 0) {
                this.treeHeight += this.treeRNG.nextInt(5);
            }
        }
        this.buildBranch(0, this.treeHeight, 0.0, 0.0, true);
        final int numBranches = 3 + this.treeRNG.nextInt(2);
        double offset = this.treeRNG.nextDouble();
        for (int b = 0; b < numBranches; ++b) {
            this.buildBranch(this.treeHeight - 10 + b, 9.0, 0.3 * b + offset, 0.2, false);
        }
        if (this.hasAirAround((ali)world, this.x, this.y - 1, this.z)) {
            world.b(this.x, this.y - 1, this.z, this.treeBlock, this.treeMeta);
        }
        else {
            world.b(this.x, this.y - 1, this.z, this.rootBlock, this.rootMeta);
        }
        final int numRoots = 3 + this.treeRNG.nextInt(2);
        offset = this.treeRNG.nextDouble();
        for (int b2 = 0; b2 < numRoots; ++b2) {
            this.buildRoot(offset, b2);
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
            this.putBlockAndMetadata(this.x + 1, this.y + height, this.z, TFBlocks.critter.bO, 0, false);
        }
        else if (iAngle == 1) {
            this.putBlockAndMetadata(this.x - 1, this.y + height, this.z, TFBlocks.critter.bO, 0, false);
        }
        else if (iAngle == 2) {
            this.putBlockAndMetadata(this.x, this.y + height, this.z + 1, TFBlocks.critter.bO, 0, false);
        }
        else if (iAngle == 3) {
            this.putBlockAndMetadata(this.x, this.y + height, this.z - 1, TFBlocks.critter.bO, 0, false);
        }
    }
    
    private void buildRoot(final double offset, final int b) {
        final int[] dest = TFGenerator.translate(this.x, this.y - b - 2, this.z, 6.0, 0.3 * b + offset, 0.8);
        this.drawRoot(this.x, this.y - b - 2, this.z, dest[0], dest[1], dest[2]);
    }
    
    protected void drawRoot(final int sx, final int sy, final int sz, final int dx, final int dy, final int dz) {
        if (this.worldObj.f(dx, dy, dz).a()) {
            this.drawBresehnam(sx, sy, sz, dx, dy, dz, this.rootBlock, this.rootMeta, true);
        }
        else {
            final int[] lineArray = this.getBresehnamArray(sx, sy, sz, dx, dy, dz);
            for (int i = 0; i < lineArray.length; i += 3) {
                if (this.worldObj.a(lineArray[i + 0], lineArray[i + 1], lineArray[i + 2]) > 0 || this.isNearSolid((ali)this.worldObj, lineArray[i + 0], lineArray[i + 1], lineArray[i + 2])) {
                    this.worldObj.b(lineArray[i + 0], lineArray[i + 1], lineArray[i + 2], this.rootBlock, this.rootMeta);
                }
            }
        }
    }
}
