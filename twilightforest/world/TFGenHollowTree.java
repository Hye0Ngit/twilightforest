// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import java.util.Random;
import twilightforest.block.TFBlocks;

public class TFGenHollowTree extends TFGenerator
{
    protected int treeBlock;
    protected int treeMeta;
    protected int branchMeta;
    protected int leafBlock;
    protected int leafMeta;
    protected int rootBlock;
    protected int rootMeta;
    static int treesMade;
    static long totalTime;
    int leafBlobsMade;
    int leavesMade;
    
    public TFGenHollowTree() {
        this(false);
    }
    
    public TFGenHollowTree(final boolean par1) {
        super(par1);
        this.treeBlock = TFBlocks.log.cz;
        this.treeMeta = 0;
        this.branchMeta = 12;
        this.leafBlock = TFBlocks.leaves.cz;
        this.leafMeta = 0;
        this.rootBlock = TFBlocks.root.cz;
        this.rootMeta = 0;
    }
    
    @Override
    public boolean a(final zv world, final Random random, final int x, final int y, final int z) {
        final long startTime = System.currentTimeMillis();
        this.leafBlobsMade = 0;
        final int height = random.nextInt(64) + 32;
        final int diameter = random.nextInt(4) + 1;
        if (y < 1 || y + height + diameter > TFWorld.MAXHEIGHT) {
            return false;
        }
        for (int crownRadius = diameter * 4 + 8, dx = -crownRadius; dx <= crownRadius; ++dx) {
            for (int dz = -crownRadius; dz <= crownRadius; ++dz) {
                for (int dy = height - crownRadius; dy <= height + crownRadius; ++dy) {
                    final int whatsThere = world.a(dx + x, dy + y, dz + z);
                    if (whatsThere != 0 && whatsThere != aou.O.cz) {
                        return false;
                    }
                }
            }
        }
        final int j1 = world.a(x, y - 1, z);
        if (j1 != aou.y.cz && j1 != aou.z.cz) {
            return false;
        }
        this.buildTrunk(world, random, x, y, z, diameter, height);
        for (int numFireflies = random.nextInt(3 * diameter) + 5, i = 0; i <= numFireflies; ++i) {
            final int fHeight = (int)(height * random.nextDouble() * 0.9) + height / 10;
            final double fAngle = random.nextDouble();
            this.addFirefly(world, x, y, z, diameter, fHeight, fAngle);
        }
        for (int numFireflies = random.nextInt(3 * diameter) + 5, i = 0; i <= numFireflies; ++i) {
            final int fHeight = (int)(height * random.nextDouble() * 0.9) + height / 10;
            final double fAngle = random.nextDouble();
            this.addCicada(world, x, y, z, diameter, fHeight, fAngle);
        }
        this.buildFullCrown(world, random, x, y, z, diameter, height);
        for (int numBranches = random.nextInt(3) + 3, k = 0; k <= numBranches; ++k) {
            final int branchHeight = (int)(height * random.nextDouble() * 0.9) + height / 10;
            final double branchRotation = random.nextDouble();
            this.makeSmallBranch(world, random, x, y, z, diameter, branchHeight, 4.0, branchRotation, 0.35, true);
        }
        this.buildBranchRing(world, random, x, y, z, diameter, 3, 2, 6, 0, 0.75, 0.0, 3, 5, 3, false);
        this.buildBranchRing(world, random, x, y, z, diameter, 1, 2, 8, 0, 0.9, 0.0, 3, 5, 3, false);
        ++TFGenHollowTree.treesMade;
        final long timeSpent = System.currentTimeMillis() - startTime;
        TFGenHollowTree.totalTime += timeSpent;
        return true;
    }
    
    protected void buildFullCrown(final zv world, final Random random, final int x, final int y, final int z, final int diameter, final int height) {
        final int crownRadius = diameter * 4 + 4;
        final int bvar = diameter + 2;
        this.buildBranchRing(world, random, x, y, z, diameter, height - crownRadius, 0, crownRadius, 0, 0.35, 0.0, bvar, bvar + 2, 2, true);
        this.buildBranchRing(world, random, x, y, z, diameter, height - crownRadius / 2, 0, crownRadius, 0, 0.28, 0.0, bvar, bvar + 2, 1, true);
        this.buildBranchRing(world, random, x, y, z, diameter, height, 0, crownRadius, 0, 0.15, 0.0, 2, 4, 2, true);
        this.buildBranchRing(world, random, x, y, z, diameter, height, 0, crownRadius / 2, 0, 0.05, 0.0, bvar, bvar + 2, 1, true);
    }
    
    protected void buildWeakCrown(final zv world, final Random random, final int x, final int y, final int z, final int diameter, final int height) {
        final int crownRadius = 8;
        final int bvar = 2;
        this.buildBranchRing(world, random, x, y, z, diameter, height - crownRadius, 0, crownRadius, 0, 0.35, 0.0, bvar, bvar + 2, 1, true);
        this.buildBranchRing(world, random, x, y, z, diameter, height - crownRadius / 2, 0, crownRadius, 0, 0.28, 0.0, bvar, bvar + 2, 1, true);
        this.buildBranchRing(world, random, x, y, z, diameter, height, 0, crownRadius, 0, 0.15, 0.0, 2, 4, 1, true);
        this.buildBranchRing(world, random, x, y, z, diameter, height, 0, crownRadius / 2, 0, 0.05, 0.0, bvar, bvar + 2, 1, true);
    }
    
    protected void buildBranchRing(final zv world, final Random random, final int x, final int y, final int z, final int diameter, final int branchHeight, final int heightVar, final int length, final int lengthVar, final double tilt, final double tiltVar, final int minBranches, final int maxBranches, final int size, final boolean leafy) {
        final int numBranches = random.nextInt(maxBranches - minBranches) + minBranches;
        final double branchRotation = 1.0 / (numBranches + 1);
        final double branchOffset = random.nextDouble();
        for (int i = 0; i <= numBranches; ++i) {
            int dHeight;
            if (heightVar > 0) {
                dHeight = branchHeight - heightVar + random.nextInt(2 * heightVar);
            }
            else {
                dHeight = branchHeight;
            }
            if (size == 2) {
                this.makeLargeBranch(world, random, x, y, z, diameter, dHeight, length, i * branchRotation + branchOffset, tilt, leafy);
            }
            else if (size == 1) {
                this.makeMedBranch(world, random, x, y, z, diameter, dHeight, length, i * branchRotation + branchOffset, tilt, leafy);
            }
            else if (size == 3) {
                this.makeRoot(world, random, x, y, z, diameter, dHeight, length, i * branchRotation + branchOffset, tilt);
            }
            else {
                this.makeSmallBranch(world, random, x, y, z, diameter, dHeight, length, i * branchRotation + branchOffset, tilt, leafy);
            }
        }
    }
    
    protected void buildTrunk(final zv world, final Random random, final int x, final int y, final int z, final int diameter, final int height) {
        final int hollow = diameter / 2;
        for (int dx = -diameter; dx <= diameter; ++dx) {
            for (int dz = -diameter; dz <= diameter; ++dz) {
                for (int dy = -4; dy < 0; ++dy) {
                    final int ax = Math.abs(dx);
                    final int az = Math.abs(dz);
                    final int dist = (int)(Math.max(ax, az) + Math.min(ax, az) * 0.5);
                    if (dist <= diameter) {
                        if (this.hasAirAround((aae)world, dx + x, dy + y, dz + z)) {
                            this.a(world, dx + x, dy + y, dz + z, this.treeBlock, this.treeMeta);
                        }
                        else {
                            this.a(world, dx + x, dy + y, dz + z, this.rootBlock, this.rootMeta);
                        }
                    }
                }
            }
        }
        for (int dx = -diameter; dx <= diameter; ++dx) {
            for (int dz = -diameter; dz <= diameter; ++dz) {
                for (int dy = 0; dy <= height; ++dy) {
                    final int ax = Math.abs(dx);
                    final int az = Math.abs(dz);
                    final int dist = (int)(Math.max(ax, az) + Math.min(ax, az) * 0.5);
                    if (dist <= diameter && dist > hollow) {
                        this.putBlockAndMetadata(world, dx + x, dy + y, dz + z, this.treeBlock, this.treeMeta, true);
                    }
                    if (dist <= hollow) {}
                    if (dist == hollow && dx == hollow) {
                        this.putBlockAndMetadata(world, dx + x, dy + y, dz + z, aou.by.cz, 8, true);
                    }
                }
            }
        }
    }
    
    protected void makeMedBranch(final zv world, final Random random, final int x, final int y, final int z, final int diameter, final int branchHeight, final double length, final double angle, final double tilt, final boolean leafy) {
        final int sx = x;
        final int sy = y + branchHeight;
        final int sz = z;
        final int[] src = TFGenerator.translate(sx, sy, sz, diameter, angle, 0.5);
        this.makeMedBranch(world, random, src[0], src[1], src[2], length, angle, tilt, leafy);
    }
    
    protected void makeMedBranch(final zv world, final Random random, final int sx, final int sy, final int sz, final double length, final double angle, final double tilt, final boolean leafy) {
        final int[] src = { sx, sy, sz };
        final int[] dest = TFGenerator.translate(src[0], src[1], src[2], length, angle, tilt);
        this.drawBresehnam(world, src[0], src[1], src[2], dest[0], dest[1], dest[2], this.treeBlock, this.branchMeta, true);
        if (leafy) {
            this.drawBlob(world, dest[0], dest[1], dest[2], 2, this.leafBlock, this.leafMeta, false);
        }
        final int numShoots = random.nextInt(2) + 1;
        final double angleInc = 0.8 / numShoots;
        for (int i = 0; i <= numShoots; ++i) {
            final double angleVar = angleInc * i - 0.4;
            final double outVar = random.nextDouble() * 0.8 + 0.2;
            final double tiltVar = random.nextDouble() * 0.75 + 0.15;
            final int[] bsrc = TFGenerator.translate(src[0], src[1], src[2], length * outVar, angle, tilt);
            final double slength = length * 0.4;
            this.makeSmallBranch(world, random, bsrc[0], bsrc[1], bsrc[2], slength, angle + angleVar, tilt * tiltVar, leafy);
        }
    }
    
    protected void makeSmallBranch(final zv world, final Random random, final int sx, final int sy, final int sz, final double length, final double angle, final double tilt, final boolean leafy) {
        final int[] src = { sx, sy, sz };
        final int[] dest = TFGenerator.translate(src[0], src[1], src[2], length, angle, tilt);
        this.drawBresehnam(world, src[0], src[1], src[2], dest[0], dest[1], dest[2], this.treeBlock, this.branchMeta, true);
        if (leafy) {
            final byte leafRad = (byte)(random.nextInt(2) + 1);
            this.drawBlob(world, dest[0], dest[1], dest[2], leafRad, this.leafBlock, this.leafMeta, false);
        }
    }
    
    protected void makeSmallBranch(final zv world, final Random random, final int x, final int y, final int z, final int diameter, final int branchHeight, final double length, final double angle, final double tilt, final boolean leafy) {
        final int sx = x;
        final int sy = y + branchHeight;
        final int sz = z;
        final int[] src = TFGenerator.translate(sx, sy, sz, diameter, angle, 0.5);
        this.makeSmallBranch(world, random, src[0], src[1], src[2], length, angle, tilt, leafy);
    }
    
    protected void makeRoot(final zv world, final Random random, final int x, final int y, final int z, final int diameter, final int branchHeight, final double length, final double angle, final double tilt) {
        final int[] src = TFGenerator.translate(x, y + branchHeight, z, diameter, angle, 0.5);
        final int[] dest = TFGenerator.translate(src[0], src[1], src[2], length, angle, tilt);
        final int[] lineArray = TFGenerator.getBresehnamArray(src[0], src[1], src[2], dest[0], dest[1], dest[2]);
        boolean stillAboveGround = true;
        for (int i = 0; i < lineArray.length; i += 3) {
            if (stillAboveGround && this.hasAirAround((aae)world, lineArray[i + 0], lineArray[i + 1], lineArray[i + 2])) {
                this.a(world, lineArray[i + 0], lineArray[i + 1], lineArray[i + 2], this.treeBlock, this.branchMeta);
                this.a(world, lineArray[i + 0], lineArray[i + 1] - 1, lineArray[i + 2], this.treeBlock, this.branchMeta);
            }
            else {
                this.a(world, lineArray[i + 0], lineArray[i + 1], lineArray[i + 2], this.rootBlock, this.rootMeta);
                this.a(world, lineArray[i + 0], lineArray[i + 1] - 1, lineArray[i + 2], this.rootBlock, this.rootMeta);
                stillAboveGround = false;
            }
        }
    }
    
    protected void makeLargeBranch(final zv world, final Random random, final int sx, final int sy, final int sz, final double length, final double angle, final double tilt, final boolean leafy) {
        final int[] src = { sx, sy, sz };
        final int[] dest = TFGenerator.translate(src[0], src[1], src[2], length, angle, tilt);
        this.drawBresehnam(world, src[0], src[1], src[2], dest[0], dest[1], dest[2], this.treeBlock, this.branchMeta, true);
        for (int reinforcements = random.nextInt(3), i = 0; i <= reinforcements; ++i) {
            final int vx = ((i & 0x2) == 0x0) ? 1 : 0;
            final int vy = ((i & 0x1) == 0x0) ? 1 : -1;
            final int vz = ((i & 0x2) != 0x0) ? 1 : 0;
            this.drawBresehnam(world, src[0] + vx, src[1] + vy, src[2] + vz, dest[0], dest[1], dest[2], this.treeBlock, this.branchMeta, true);
        }
        if (leafy) {
            this.drawBlob(world, dest[0], dest[1] + 1, dest[2], 3, this.leafBlock, this.leafMeta, false);
        }
        for (int numMedBranches = random.nextInt((int)(length / 6.0)) + random.nextInt(2) + 1, j = 0; j <= numMedBranches; ++j) {
            final double outVar = random.nextDouble() * 0.3 + 0.3;
            final double angleVar = random.nextDouble() * 0.225 * (((j & 0x1) == 0x0) ? 1.0 : -1.0);
            final int[] bsrc = TFGenerator.translate(src[0], src[1], src[2], length * outVar, angle, tilt);
            this.makeMedBranch(world, random, bsrc[0], bsrc[1], bsrc[2], length * 0.6, angle + angleVar, tilt, leafy);
        }
        for (int numSmallBranches = random.nextInt(2) + 1, k = 0; k <= numSmallBranches; ++k) {
            final double outVar2 = random.nextDouble() * 0.25 + 0.25;
            final double angleVar2 = random.nextDouble() * 0.25 * (((k & 0x1) == 0x0) ? 1.0 : -1.0);
            final int[] bsrc2 = TFGenerator.translate(src[0], src[1], src[2], length * outVar2, angle, tilt);
            this.makeSmallBranch(world, random, bsrc2[0], bsrc2[1], bsrc2[2], Math.max(length * 0.3, 2.0), angle + angleVar2, tilt, leafy);
        }
    }
    
    protected void makeLargeBranch(final zv world, final Random random, final int x, final int y, final int z, final int diameter, final int branchHeight, final double length, final double angle, final double tilt, final boolean leafy) {
        final int sx = x;
        final int sy = y + branchHeight;
        final int sz = z;
        final int[] src = TFGenerator.translate(sx, sy, sz, diameter, angle, 0.5);
        this.makeLargeBranch(world, random, src[0], src[1], src[2], length, angle, tilt, leafy);
    }
    
    protected void addFirefly(final zv world, final int x, final int y, final int z, final int diameter, final int fHeight, double fAngle) {
        final int[] src = TFGenerator.translate(x, y + fHeight, z, diameter + 1, fAngle, 0.5);
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
        if (TFBlocks.firefly.c(world, src[0], src[1], src[2])) {
            this.putBlockAndMetadata(world, src[0], src[1], src[2], TFBlocks.firefly.cz, tmeta, false);
        }
    }
    
    protected void addCicada(final zv world, final int x, final int y, final int z, final int diameter, final int fHeight, double fAngle) {
        final int[] src = TFGenerator.translate(x, y + fHeight, z, diameter + 1, fAngle, 0.5);
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
        if (TFBlocks.cicada.c(world, src[0], src[1], src[2])) {
            this.putBlockAndMetadata(world, src[0], src[1], src[2], TFBlocks.cicada.cz, tmeta, false);
        }
    }
    
    static {
        TFGenHollowTree.treesMade = 0;
        TFGenHollowTree.totalTime = 0L;
    }
}
