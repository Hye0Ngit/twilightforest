// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.block.TFBlocks;
import twilightforest.world.TFGenerator;
import java.util.Random;
import java.util.List;

public class ComponentTFHollowTreeLargeBranch extends ComponentTFHollowTreeMedBranch
{
    protected ComponentTFHollowTreeLargeBranch(final int i, final int sx, final int sy, final int sz, final double length, final double angle, final double tilt, final boolean leafy) {
        super(i, sx, sy, sz, length, angle, tilt, leafy);
    }
    
    @Override
    public void a(final aez structurecomponent, final List list, final Random rand) {
        final int index = this.c();
        if (this.leafy) {
            final ComponentTFLeafSphere leafBlob = new ComponentTFLeafSphere(index + 1, this.dest[0], this.dest[1], this.dest[2], 3);
            list.add(leafBlob);
            leafBlob.a((aez)this, list, rand);
        }
        final int numMedBranches = rand.nextInt((int)(this.length / 6.0)) + rand.nextInt(2) + 1;
        for (int i = 0; i <= numMedBranches; ++i) {
            final double outVar = rand.nextDouble() * 0.3 + 0.3;
            final double angleVar = rand.nextDouble() * 0.225 * (((i & 0x1) == 0x0) ? 1.0 : -1.0);
            final int[] bsrc = TFGenerator.translate(this.src[0], this.src[1], this.src[2], this.length * outVar, this.angle, this.tilt);
            this.makeMedBranch(list, rand, index + 2 + i, bsrc[0], bsrc[1], bsrc[2], this.length * 0.6, this.angle + angleVar, this.tilt, this.leafy);
        }
        for (int numSmallBranches = rand.nextInt(2) + 1, j = 0; j <= numSmallBranches; ++j) {
            final double outVar2 = rand.nextDouble() * 0.25 + 0.25;
            final double angleVar2 = rand.nextDouble() * 0.25 * (((j & 0x1) == 0x0) ? 1.0 : -1.0);
            final int[] bsrc2 = TFGenerator.translate(this.src[0], this.src[1], this.src[2], this.length * outVar2, this.angle, this.tilt);
            this.makeSmallBranch(list, rand, index + numMedBranches + 1 + j, bsrc2[0], bsrc2[1], bsrc2[2], Math.max(this.length * 0.3, 2.0), this.angle + angleVar2, this.tilt, this.leafy);
        }
    }
    
    public void makeMedBranch(final List list, final Random rand, final int index, final int x, final int y, final int z, final double branchLength, final double branchRotation, final double branchAngle, final boolean leafy) {
        final ComponentTFHollowTreeMedBranch branch = new ComponentTFHollowTreeMedBranch(index, x, y, z, branchLength, branchRotation, branchAngle, leafy);
        list.add(branch);
        branch.a(this, list, rand);
    }
    
    @Override
    public void makeSmallBranch(final List list, final Random rand, final int index, final int x, final int y, final int z, final double branchLength, final double branchRotation, final double branchAngle, final boolean leafy) {
        final ComponentTFHollowTreeSmallBranch branch = new ComponentTFHollowTreeSmallBranch(index, x, y, z, branchLength, branchRotation, branchAngle, leafy);
        list.add(branch);
        branch.a(this, list, rand);
    }
    
    @Override
    public boolean a(final yc world, final Random rand, final acn sbb) {
        final int[] rSrc = { this.src[0] - this.e.a, this.src[1] - this.e.b, this.src[2] - this.e.c };
        final int[] rDest = { this.dest[0] - this.e.a, this.dest[1] - this.e.b, this.dest[2] - this.e.c };
        this.drawBresehnam(world, sbb, rSrc[0], rSrc[1], rSrc[2], rDest[0], rDest[1], rDest[2], TFBlocks.log.cm, 0);
        for (int reinforcements = rand.nextInt(3), i = 0; i <= reinforcements; ++i) {
            final int vx = ((i & 0x2) == 0x0) ? 1 : 0;
            final int vy = ((i & 0x1) == 0x0) ? 1 : -1;
            final int vz = ((i & 0x2) != 0x0) ? 1 : 0;
            this.drawBresehnam(world, sbb, rSrc[0] + vx, rSrc[1] + vy, rSrc[2] + vz, rDest[0], rDest[1], rDest[2], TFBlocks.log.cm, 0);
        }
        return true;
    }
}
