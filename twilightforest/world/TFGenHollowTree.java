// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.TFBlocks;
import java.util.Random;

public class TFGenHollowTree extends TFGenerator
{
    protected Random treeRNG;
    protected int x;
    protected int y;
    protected int z;
    protected int height;
    protected int diameter;
    protected int treeBlock;
    protected int treeMeta;
    protected int branchMeta;
    protected int leafBlock;
    protected int leafMeta;
    protected int rootBlock;
    private int rootMeta;
    static int treesMade;
    static long totalTime;
    int leafBlobsMade;
    int leavesMade;
    
    public TFGenHollowTree() {
        this(false);
    }
    
    public TFGenHollowTree(final boolean par1) {
        super(par1);
        this.treeBlock = TFBlocks.log.cm;
        this.treeMeta = 0;
        this.branchMeta = 12;
        this.leafBlock = TFBlocks.leaves.cm;
        this.leafMeta = 0;
        this.rootBlock = TFBlocks.root.cm;
        this.rootMeta = 0;
    }
    
    @Override
    public boolean a(final xv world, final Random random, final int treeX, final int treeY, final int treeZ) {
        final long startTime = System.currentTimeMillis();
        this.worldObj = world;
        this.treeRNG = random;
        this.x = treeX;
        this.y = treeY;
        this.z = treeZ;
        this.leafBlobsMade = 0;
        this.height = this.treeRNG.nextInt(TFWorld.WORLDHEIGHT / 2) + 32;
        this.diameter = this.treeRNG.nextInt(4) + 1;
        if (this.y < 1 || this.y + this.height + this.diameter > TFWorld.WORLDHEIGHT) {
            return false;
        }
        for (int crownRadius = this.diameter * 4 + 8, dx = -crownRadius; dx <= crownRadius; ++dx) {
            for (int dz = -crownRadius; dz <= crownRadius; ++dz) {
                for (int dy = this.height - crownRadius; dy <= this.height + crownRadius; ++dy) {
                    final int whatsThere = this.worldObj.a(dx + this.x, dy + this.y, dz + this.z);
                    if (whatsThere != 0 && whatsThere != amj.N.cm) {
                        return false;
                    }
                }
            }
        }
        final int j1 = world.a(this.x, this.y - 1, this.z);
        if (j1 != amj.x.cm && j1 != amj.y.cm) {
            return false;
        }
        this.buildTrunk();
        for (int numFireflies = this.treeRNG.nextInt(3 * this.diameter) + 5, i = 0; i <= numFireflies; ++i) {
            final int fHeight = (int)(this.height * this.treeRNG.nextDouble() * 0.9) + this.height / 10;
            final double fAngle = this.treeRNG.nextDouble();
            this.addFirefly(fHeight, fAngle);
        }
        for (int numFireflies = this.treeRNG.nextInt(3 * this.diameter) + 5, i = 0; i <= numFireflies; ++i) {
            final int fHeight = (int)(this.height * this.treeRNG.nextDouble() * 0.9) + this.height / 10;
            final double fAngle = this.treeRNG.nextDouble();
            this.addCicada(fHeight, fAngle);
        }
        this.buildFullCrown();
        for (int numBranches = this.treeRNG.nextInt(3) + 3, k = 0; k <= numBranches; ++k) {
            final int branchHeight = (int)(this.height * this.treeRNG.nextDouble() * 0.9) + this.height / 10;
            final double branchRotation = this.treeRNG.nextDouble();
            this.makeSmallBranch(branchHeight, 4.0, branchRotation, 0.35, true);
        }
        this.buildBranchRing(3, 2, 6, 0, 0.75, 0.0, 3, 5, 3, false);
        this.buildBranchRing(1, 2, 8, 0, 0.9, 0.0, 3, 5, 3, false);
        ++TFGenHollowTree.treesMade;
        final long timeSpent = System.currentTimeMillis() - startTime;
        TFGenHollowTree.totalTime += timeSpent;
        return true;
    }
    
    protected void buildFullCrown() {
        final int crownRadius = this.diameter * 4 + 4;
        final int bvar = this.diameter + 2;
        this.buildBranchRing(this.height - crownRadius, 0, crownRadius, 0, 0.35, 0.0, bvar, bvar + 2, 2, true);
        this.buildBranchRing(this.height - crownRadius / 2, 0, crownRadius, 0, 0.28, 0.0, bvar, bvar + 2, 1, true);
        this.buildBranchRing(this.height, 0, crownRadius, 0, 0.15, 0.0, 2, 4, 2, true);
        this.buildBranchRing(this.height, 0, crownRadius / 2, 0, 0.05, 0.0, bvar, bvar + 2, 1, true);
    }
    
    protected void buildWeakCrown() {
        final int crownRadius = 8;
        final int bvar = 2;
        this.buildBranchRing(this.height - crownRadius, 0, crownRadius, 0, 0.35, 0.0, bvar, bvar + 2, 1, true);
        this.buildBranchRing(this.height - crownRadius / 2, 0, crownRadius, 0, 0.28, 0.0, bvar, bvar + 2, 1, true);
        this.buildBranchRing(this.height, 0, crownRadius, 0, 0.15, 0.0, 2, 4, 1, true);
        this.buildBranchRing(this.height, 0, crownRadius / 2, 0, 0.05, 0.0, bvar, bvar + 2, 1, true);
    }
    
    protected void buildBranchRing(final int branchHeight, final int heightVar, final int length, final int lengthVar, final double tilt, final double tiltVar, final int minBranches, final int maxBranches, final int size, final boolean leafy) {
        final int numBranches = this.treeRNG.nextInt(maxBranches - minBranches) + minBranches;
        final double branchRotation = 1.0 / (numBranches + 1);
        final double branchOffset = this.treeRNG.nextDouble();
        for (int i = 0; i <= numBranches; ++i) {
            int dHeight;
            if (heightVar > 0) {
                dHeight = branchHeight - heightVar + this.treeRNG.nextInt(2 * heightVar);
            }
            else {
                dHeight = branchHeight;
            }
            if (size == 2) {
                this.makeLargeBranch(dHeight, length, i * branchRotation + branchOffset, tilt, leafy);
            }
            else if (size == 1) {
                this.makeMedBranch(dHeight, length, i * branchRotation + branchOffset, tilt, leafy);
            }
            else if (size == 3) {
                this.makeRoot(dHeight, length, i * branchRotation + branchOffset, tilt);
            }
            else {
                this.makeSmallBranch(dHeight, length, i * branchRotation + branchOffset, tilt, leafy);
            }
        }
    }
    
    protected void buildTrunk() {
        final int hollow = this.diameter / 2;
        for (int dx = -this.diameter; dx <= this.diameter; ++dx) {
            for (int dz = -this.diameter; dz <= this.diameter; ++dz) {
                for (int dy = -4; dy < 0; ++dy) {
                    final int ax = Math.abs(dx);
                    final int az = Math.abs(dz);
                    final int dist = (int)(Math.max(ax, az) + Math.min(ax, az) * 0.5);
                    if (dist <= this.diameter) {
                        if (this.hasAirAround((yf)this.worldObj, dx + this.x, dy + this.y, dz + this.z)) {
                            this.worldObj.c(dx + this.x, dy + this.y, dz + this.z, this.treeBlock, this.treeMeta);
                        }
                        else {
                            this.worldObj.c(dx + this.x, dy + this.y, dz + this.z, this.rootBlock, this.rootMeta);
                        }
                    }
                }
            }
        }
        for (int dx = -this.diameter; dx <= this.diameter; ++dx) {
            for (int dz = -this.diameter; dz <= this.diameter; ++dz) {
                for (int dy = 0; dy <= this.height; ++dy) {
                    final int ax = Math.abs(dx);
                    final int az = Math.abs(dz);
                    final int dist = (int)(Math.max(ax, az) + Math.min(ax, az) * 0.5);
                    if (dist <= this.diameter && dist > hollow) {
                        this.putBlock(dx + this.x, dy + this.y, dz + this.z, this.treeBlock, true);
                    }
                    if (dist <= hollow) {}
                    if (dist == hollow && dx == hollow) {
                        this.putBlockAndMetadata(dx + this.x, dy + this.y, dz + this.z, amj.bx.cm, 8, true);
                    }
                }
            }
        }
    }
    
    protected void makeMedBranch(final int branchHeight, final double length, final double angle, final double tilt, final boolean leafy) {
        final int sx = this.x;
        final int sy = this.y + branchHeight;
        final int sz = this.z;
        final int[] src = TFGenerator.translate(sx, sy, sz, this.diameter, angle, 0.5);
        this.makeMedBranch(src[0], src[1], src[2], length, angle, tilt, leafy);
    }
    
    protected void makeMedBranch(final int sx, final int sy, final int sz, final double length, final double angle, final double tilt, final boolean leafy) {
        final int[] src = { sx, sy, sz };
        final int[] dest = TFGenerator.translate(src[0], src[1], src[2], length, angle, tilt);
        this.drawBresehnam(src[0], src[1], src[2], dest[0], dest[1], dest[2], this.treeBlock, this.branchMeta, true);
        if (leafy) {
            this.drawBlob(dest[0], dest[1], dest[2], 2, this.leafBlock, false);
        }
        final int numShoots = this.treeRNG.nextInt(2) + 1;
        final double angleInc = 0.8 / numShoots;
        for (int i = 0; i <= numShoots; ++i) {
            final double angleVar = angleInc * i - 0.4;
            final double outVar = this.treeRNG.nextDouble() * 0.8 + 0.2;
            final double tiltVar = this.treeRNG.nextDouble() * 0.75 + 0.15;
            final int[] bsrc = TFGenerator.translate(src[0], src[1], src[2], length * outVar, angle, tilt);
            final double slength = length * 0.4;
            this.makeSmallBranch(bsrc[0], bsrc[1], bsrc[2], slength, angle + angleVar, tilt * tiltVar, leafy);
        }
    }
    
    protected void makeSmallBranch(final int sx, final int sy, final int sz, final double length, final double angle, final double tilt, final boolean leafy) {
        final int[] src = { sx, sy, sz };
        final int[] dest = TFGenerator.translate(src[0], src[1], src[2], length, angle, tilt);
        this.drawBresehnam(src[0], src[1], src[2], dest[0], dest[1], dest[2], this.treeBlock, this.branchMeta, true);
        if (leafy) {
            final byte leafRad = (byte)(this.treeRNG.nextInt(2) + 1);
            this.drawBlob(dest[0], dest[1], dest[2], leafRad, this.leafBlock, false);
        }
    }
    
    protected void makeSmallBranch(final int branchHeight, final double length, final double angle, final double tilt, final boolean leafy) {
        final int sx = this.x;
        final int sy = this.y + branchHeight;
        final int sz = this.z;
        final int[] src = TFGenerator.translate(sx, sy, sz, this.diameter, angle, 0.5);
        this.makeSmallBranch(src[0], src[1], src[2], length, angle, tilt, leafy);
    }
    
    protected void makeRoot(final int branchHeight, final double length, final double angle, final double tilt) {
        final int[] src = TFGenerator.translate(this.x, this.y + branchHeight, this.z, this.diameter, angle, 0.5);
        final int[] dest = TFGenerator.translate(src[0], src[1], src[2], length, angle, tilt);
        final int[] lineArray = TFGenerator.getBresehnamArray(src[0], src[1], src[2], dest[0], dest[1], dest[2]);
        boolean stillAboveGround = true;
        for (int i = 0; i < lineArray.length; i += 3) {
            if (stillAboveGround && this.hasAirAround((yf)this.worldObj, lineArray[i + 0], lineArray[i + 1], lineArray[i + 2])) {
                this.worldObj.c(lineArray[i + 0], lineArray[i + 1], lineArray[i + 2], this.treeBlock, this.branchMeta);
                this.worldObj.c(lineArray[i + 0], lineArray[i + 1] - 1, lineArray[i + 2], this.treeBlock, this.branchMeta);
            }
            else {
                this.worldObj.c(lineArray[i + 0], lineArray[i + 1], lineArray[i + 2], this.rootBlock, this.rootMeta);
                this.worldObj.c(lineArray[i + 0], lineArray[i + 1] - 1, lineArray[i + 2], this.rootBlock, this.rootMeta);
                stillAboveGround = false;
            }
        }
    }
    
    protected void makeLargeBranch(final int sx, final int sy, final int sz, final double length, final double angle, final double tilt, final boolean leafy) {
        final int[] src = { sx, sy, sz };
        final int[] dest = TFGenerator.translate(src[0], src[1], src[2], length, angle, tilt);
        this.drawBresehnam(src[0], src[1], src[2], dest[0], dest[1], dest[2], this.treeBlock, this.branchMeta, true);
        for (int reinforcements = this.treeRNG.nextInt(3), i = 0; i <= reinforcements; ++i) {
            final int vx = ((i & 0x2) == 0x0) ? 1 : 0;
            final int vy = ((i & 0x1) == 0x0) ? 1 : -1;
            final int vz = ((i & 0x2) != 0x0) ? 1 : 0;
            this.drawBresehnam(src[0] + vx, src[1] + vy, src[2] + vz, dest[0], dest[1], dest[2], this.treeBlock, this.branchMeta, true);
        }
        if (leafy) {
            this.drawBlob(dest[0], dest[1] + 1, dest[2], 3, this.leafBlock, false);
        }
        for (int numMedBranches = this.treeRNG.nextInt((int)(length / 6.0)) + this.treeRNG.nextInt(2) + 1, j = 0; j <= numMedBranches; ++j) {
            final double outVar = this.treeRNG.nextDouble() * 0.3 + 0.3;
            final double angleVar = this.treeRNG.nextDouble() * 0.225 * (((j & 0x1) == 0x0) ? 1.0 : -1.0);
            final int[] bsrc = TFGenerator.translate(src[0], src[1], src[2], length * outVar, angle, tilt);
            this.makeMedBranch(bsrc[0], bsrc[1], bsrc[2], length * 0.6, angle + angleVar, tilt, leafy);
        }
        for (int numSmallBranches = this.treeRNG.nextInt(2) + 1, k = 0; k <= numSmallBranches; ++k) {
            final double outVar2 = this.treeRNG.nextDouble() * 0.25 + 0.25;
            final double angleVar2 = this.treeRNG.nextDouble() * 0.25 * (((k & 0x1) == 0x0) ? 1.0 : -1.0);
            final int[] bsrc2 = TFGenerator.translate(src[0], src[1], src[2], length * outVar2, angle, tilt);
            this.makeSmallBranch(bsrc2[0], bsrc2[1], bsrc2[2], Math.max(length * 0.3, 2.0), angle + angleVar2, tilt, leafy);
        }
    }
    
    protected void makeLargeBranch(final int branchHeight, final double length, final double angle, final double tilt, final boolean leafy) {
        final int sx = this.x;
        final int sy = this.y + branchHeight;
        final int sz = this.z;
        final int[] src = TFGenerator.translate(sx, sy, sz, this.diameter, angle, 0.5);
        this.makeLargeBranch(src[0], src[1], src[2], length, angle, tilt, leafy);
    }
    
    protected void addFirefly(final int fHeight, double fAngle) {
        final int[] src = TFGenerator.translate(this.x, this.y + fHeight, this.z, this.diameter + 1, fAngle, 0.5);
        fAngle %= 1.0;
        int tmeta = 0;
        if (fAngle > 0.875 || fAngle <= 0.125) {
            tmeta = 3;
        }
        else if (fAngle > 0.125 && fAngle <= 0.375) {
            tmeta = 1;
        }
        else if (fAngle > 0.375 && fAngle <= 0.625) {
            tmeta = 4;
        }
        else if (fAngle > 0.625 && fAngle <= 0.875) {
            tmeta = 2;
        }
        if (TFBlocks.firefly.b(this.worldObj, src[0], src[1], src[2])) {
            this.putBlockAndMetadata(src[0], src[1], src[2], TFBlocks.firefly.cm, tmeta, false);
        }
    }
    
    protected void addCicada(final int fHeight, double fAngle) {
        final int[] src = TFGenerator.translate(this.x, this.y + fHeight, this.z, this.diameter + 1, fAngle, 0.5);
        fAngle %= 1.0;
        int tmeta = 1;
        if (fAngle > 0.875 || fAngle <= 0.125) {
            tmeta = 3;
        }
        else if (fAngle > 0.125 && fAngle <= 0.375) {
            tmeta = 1;
        }
        else if (fAngle > 0.375 && fAngle <= 0.625) {
            tmeta = 4;
        }
        else if (fAngle > 0.625 && fAngle <= 0.875) {
            tmeta = 2;
        }
        if (TFBlocks.cicada.b(this.worldObj, src[0], src[1], src[2])) {
            this.putBlockAndMetadata(src[0], src[1], src[2], TFBlocks.cicada.cm, tmeta, false);
        }
    }
    
    protected void drawBlob(final int sx, final int sy, final int sz, final int rad, final int blockValue, final boolean priority) {
        for (byte dx = 0; dx <= rad; ++dx) {
            for (byte dy = 0; dy <= rad; ++dy) {
                for (byte dz = 0; dz <= rad; ++dz) {
                    byte dist = 0;
                    if (dx >= dy && dx >= dz) {
                        dist = (byte)(dx + (byte)(Math.max(dy, dz) * 0.5 + Math.min(dy, dz) * 0.25));
                    }
                    else if (dy >= dx && dy >= dz) {
                        dist = (byte)(dy + (byte)(Math.max(dx, dz) * 0.5 + Math.min(dx, dz) * 0.25));
                    }
                    else {
                        dist = (byte)(dz + (byte)(Math.max(dx, dy) * 0.5 + Math.min(dx, dy) * 0.25));
                    }
                    if (dist <= rad) {
                        this.putBlock(sx + dx, sy + dy, sz + dz, blockValue, priority);
                        this.putBlock(sx + dx, sy + dy, sz - dz, blockValue, priority);
                        this.putBlock(sx - dx, sy + dy, sz + dz, blockValue, priority);
                        this.putBlock(sx - dx, sy + dy, sz - dz, blockValue, priority);
                        this.putBlock(sx + dx, sy - dy, sz + dz, blockValue, priority);
                        this.putBlock(sx + dx, sy - dy, sz - dz, blockValue, priority);
                        this.putBlock(sx - dx, sy - dy, sz + dz, blockValue, priority);
                        this.putBlock(sx - dx, sy - dy, sz - dz, blockValue, priority);
                    }
                }
            }
        }
        ++this.leafBlobsMade;
    }
    
    static {
        TFGenHollowTree.treesMade = 0;
        TFGenHollowTree.totalTime = 0L;
    }
}
