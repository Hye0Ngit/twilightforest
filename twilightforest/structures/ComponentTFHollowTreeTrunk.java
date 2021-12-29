// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.TFBlocks;
import twilightforest.world.TFGenerator;
import java.util.List;
import java.util.Random;

public class ComponentTFHollowTreeTrunk extends StructureTFComponent
{
    int radius;
    int height;
    
    public ComponentTFHollowTreeTrunk(final xv world, final Random rand, final int index, final int x, final int y, final int z) {
        super(index);
        this.height = rand.nextInt(64) + 32;
        this.radius = rand.nextInt(4) + 1;
        this.setCoordBaseMode(0);
        this.e = new acg(x, y, z, x + this.radius * 2, y + this.height, z + this.radius * 2);
    }
    
    public void a(final aes structurecomponent, final List list, final Random rand) {
        final int index = this.c();
        final ComponentTFLeafSphere leafBlob = new ComponentTFLeafSphere(index + 1, this.e.d, this.e.e, this.e.f, 3);
        list.add(leafBlob);
        leafBlob.a((aes)this, list, rand);
        final int numBranches = rand.nextInt(3) + 3;
        for (int i = 0; i <= numBranches; ++i) {
            final int branchHeight = (int)(this.height * rand.nextDouble() * 0.9) + this.height / 10;
            final double branchRotation = rand.nextDouble();
            this.makeMedBranch(list, rand, index + i + 1, branchHeight, 4, branchRotation, 0.35, true);
        }
        this.buildFullCrown(list, rand, index + numBranches + 1);
    }
    
    protected void buildFullCrown(final List list, final Random rand, int index) {
        final int crownRadius = this.radius * 4 + 4;
        final int bvar = this.radius + 2;
        index += this.buildBranchRing(list, rand, index, this.height - crownRadius, 0, crownRadius, 0, 0.35, 0.0, bvar, bvar + 2, 2, true);
        index += this.buildBranchRing(list, rand, index, this.height - crownRadius / 2, 0, crownRadius, 0, 0.28, 0.0, bvar, bvar + 2, 1, true);
        index += this.buildBranchRing(list, rand, index, this.height, 0, crownRadius, 0, 0.15, 0.0, 2, 5, 2, true);
        index += this.buildBranchRing(list, rand, index, this.height, 0, crownRadius / 2, 0, 0.05, 0.0, bvar, bvar + 2, 1, true);
    }
    
    protected int buildBranchRing(final List list, final Random rand, final int index, final int branchHeight, final int heightVar, final int length, final int lengthVar, final double tilt, final double tiltVar, final int minBranches, final int maxBranches, final int size, final boolean leafy) {
        final int numBranches = rand.nextInt(maxBranches - minBranches + 1) + minBranches;
        final double branchRotation = 1.0 / numBranches;
        final double branchOffset = rand.nextDouble();
        for (int i = 0; i <= numBranches; ++i) {
            int dHeight;
            if (heightVar > 0) {
                dHeight = branchHeight - heightVar + rand.nextInt(2 * heightVar);
            }
            else {
                dHeight = branchHeight;
            }
            if (size == 2) {
                this.makeLargeBranch(list, rand, index, dHeight, length, i * branchRotation + branchOffset, tilt, leafy);
            }
            else if (size == 1) {
                this.makeMedBranch(list, rand, index, dHeight, length, i * branchRotation + branchOffset, tilt, leafy);
            }
            else if (size != 3) {
                this.makeSmallBranch(list, rand, index, dHeight, length, i * branchRotation + branchOffset, tilt, leafy);
            }
        }
        return numBranches;
    }
    
    public void makeSmallBranch(final List list, final Random rand, final int index, final int branchHeight, final int branchLength, final double branchRotation, final double branchAngle, final boolean leafy) {
        final int[] bSrc = TFGenerator.translate(this.e.a + this.radius, this.e.b + branchHeight, this.e.c + this.radius, this.radius, branchRotation, 0.5);
        final ComponentTFHollowTreeSmallBranch branch = new ComponentTFHollowTreeSmallBranch(index, bSrc[0], bSrc[1], bSrc[2], branchLength, branchRotation, branchAngle, leafy);
        list.add(branch);
        branch.a(this, list, rand);
    }
    
    public void makeMedBranch(final List list, final Random rand, final int index, final int branchHeight, final int branchLength, final double branchRotation, final double branchAngle, final boolean leafy) {
        final int[] bSrc = TFGenerator.translate(this.e.a + this.radius, this.e.b + branchHeight, this.e.c + this.radius, this.radius, branchRotation, 0.5);
        final ComponentTFHollowTreeMedBranch branch = new ComponentTFHollowTreeMedBranch(index, bSrc[0], bSrc[1], bSrc[2], branchLength, branchRotation, branchAngle, leafy);
        list.add(branch);
        branch.a(this, list, rand);
    }
    
    public void makeLargeBranch(final List list, final Random rand, final int index, final int branchHeight, final int branchLength, final double branchRotation, final double branchAngle, final boolean leafy) {
        final int[] bSrc = TFGenerator.translate(this.e.a + this.radius, this.e.b + branchHeight, this.e.c + this.radius, this.radius, branchRotation, 0.5);
        final ComponentTFHollowTreeLargeBranch branch = new ComponentTFHollowTreeLargeBranch(index, bSrc[0], bSrc[1], bSrc[2], branchLength, branchRotation, branchAngle, leafy);
        list.add(branch);
        branch.a(this, list, rand);
    }
    
    public boolean a(final xv world, final Random random, final acg sbb) {
        final int hollow = this.radius / 2;
        for (int dx = 0; dx <= 2 * this.radius; ++dx) {
            for (int dz = 0; dz <= 2 * this.radius; ++dz) {
                for (int dy = 0; dy <= this.height; ++dy) {
                    final int ax = Math.abs(dx - this.radius);
                    final int az = Math.abs(dz - this.radius);
                    final int dist = (int)(Math.max(ax, az) + Math.min(ax, az) * 0.5);
                    if (dist <= this.radius && dist > hollow) {
                        this.a(world, TFBlocks.log.cm, 0, dx, dy, dz, sbb);
                    }
                    if (dist == hollow && dx == hollow + this.radius) {
                        this.a(world, amj.aI.cm, 4, dx, dy, dz, sbb);
                    }
                }
            }
        }
        return true;
    }
}
