// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.hollowtree;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import twilightforest.block.TFBlocks;
import twilightforest.world.TFGenerator;
import net.minecraft.util.ChunkCoordinates;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.structures.StructureTFComponent;

public class ComponentTFHollowTreeTrunk extends StructureTFComponent
{
    int radius;
    int height;
    int groundLevel;
    
    public ComponentTFHollowTreeTrunk() {
        this.groundLevel = -1;
    }
    
    public ComponentTFHollowTreeTrunk(final World world, final Random rand, final int index, final int x, final int y, final int z) {
        super(index);
        this.groundLevel = -1;
        this.height = rand.nextInt(64) + 32;
        this.radius = rand.nextInt(4) + 1;
        this.setCoordBaseMode(0);
        this.field_74887_e = new StructureBoundingBox(x, y, z, x + this.radius * 2 + 2, y + this.height, z + this.radius * 2 + 2);
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_143012_a(par1NBTTagCompound);
        par1NBTTagCompound.func_74768_a("trunkRadius", this.radius);
        par1NBTTagCompound.func_74768_a("trunkHeight", this.height);
        par1NBTTagCompound.func_74768_a("trunkGroundLevel", this.groundLevel);
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_143011_b(par1NBTTagCompound);
        this.radius = par1NBTTagCompound.func_74762_e("trunkRadius");
        this.height = par1NBTTagCompound.func_74762_e("trunkHeight");
        this.groundLevel = par1NBTTagCompound.func_74762_e("trunkGroundLevel");
    }
    
    public void func_74861_a(final StructureComponent structurecomponent, final List list, final Random rand) {
        final int index = this.func_74877_c();
        final int numBranches = rand.nextInt(3) + 3;
        for (int i = 0; i <= numBranches; ++i) {
            final int branchHeight = (int)(this.height * rand.nextDouble() * 0.9) + this.height / 10;
            final double branchRotation = rand.nextDouble();
            this.makeSmallBranch(list, rand, index + i + 1, branchHeight, 4, branchRotation, 0.35, true);
        }
        this.buildFullCrown(list, rand, index + numBranches + 1);
        this.buildBranchRing(list, rand, index, 3, 2, 6, 0, 0.75, 0.0, 3, 5, 3, false);
        this.buildBranchRing(list, rand, index, 1, 2, 8, 0, 0.9, 0.0, 3, 5, 3, false);
    }
    
    protected void buildFullCrown(final List list, final Random rand, int index) {
        final int crownRadius = this.radius * 4 + 4;
        final int bvar = this.radius + 2;
        index += this.buildBranchRing(list, rand, index, this.height - crownRadius, 0, crownRadius, 0, 0.35, 0.0, bvar, bvar + 2, 2, true);
        index += this.buildBranchRing(list, rand, index, this.height - crownRadius / 2, 0, crownRadius, 0, 0.28, 0.0, bvar, bvar + 2, 1, true);
        index += this.buildBranchRing(list, rand, index, this.height, 0, crownRadius, 0, 0.15, 0.0, 2, 4, 2, true);
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
            else if (size == 3) {
                this.makeRoot(list, rand, index, dHeight, length, i * branchRotation + branchOffset, tilt);
            }
            else {
                this.makeSmallBranch(list, rand, index, dHeight, length, i * branchRotation + branchOffset, tilt, leafy);
            }
        }
        return numBranches;
    }
    
    public void makeSmallBranch(final List list, final Random rand, final int index, final int branchHeight, final int branchLength, final double branchRotation, final double branchAngle, final boolean leafy) {
        final ChunkCoordinates bSrc = this.getBranchSrc(branchHeight, branchRotation);
        final ComponentTFHollowTreeSmallBranch branch = new ComponentTFHollowTreeSmallBranch(index, bSrc.field_71574_a, bSrc.field_71572_b, bSrc.field_71573_c, branchLength, branchRotation, branchAngle, leafy);
        list.add(branch);
        branch.func_74861_a(this, list, rand);
    }
    
    public void makeMedBranch(final List list, final Random rand, final int index, final int branchHeight, final int branchLength, final double branchRotation, final double branchAngle, final boolean leafy) {
        final ChunkCoordinates bSrc = this.getBranchSrc(branchHeight, branchRotation);
        final ComponentTFHollowTreeMedBranch branch = new ComponentTFHollowTreeMedBranch(index, bSrc.field_71574_a, bSrc.field_71572_b, bSrc.field_71573_c, branchLength, branchRotation, branchAngle, leafy);
        list.add(branch);
        branch.func_74861_a(this, list, rand);
    }
    
    public void makeLargeBranch(final List list, final Random rand, final int index, final int branchHeight, final int branchLength, final double branchRotation, final double branchAngle, final boolean leafy) {
        final ChunkCoordinates bSrc = this.getBranchSrc(branchHeight, branchRotation);
        final ComponentTFHollowTreeMedBranch branch = new ComponentTFHollowTreeLargeBranch(index, bSrc.field_71574_a, bSrc.field_71572_b, bSrc.field_71573_c, branchLength, branchRotation, branchAngle, leafy);
        list.add(branch);
        branch.func_74861_a(this, list, rand);
    }
    
    public void makeRoot(final List list, final Random rand, final int index, final int branchHeight, final int branchLength, final double branchRotation, final double branchAngle) {
        final ChunkCoordinates bSrc = this.getBranchSrc(branchHeight, branchRotation);
        final ComponentTFHollowTreeRoot branch = new ComponentTFHollowTreeRoot(index, bSrc.field_71574_a, bSrc.field_71572_b, bSrc.field_71573_c, branchLength, branchRotation, branchAngle, false);
        list.add(branch);
        branch.func_74861_a(this, list, rand);
    }
    
    private ChunkCoordinates getBranchSrc(final int branchHeight, final double branchRotation) {
        return TFGenerator.translateCoords(this.field_74887_e.field_78897_a + this.radius + 1, this.field_74887_e.field_78895_b + branchHeight, this.field_74887_e.field_78896_c + this.radius + 1, this.radius, branchRotation, 0.5);
    }
    
    public boolean func_74875_a(final World world, final Random random, final StructureBoundingBox sbb) {
        if (this.groundLevel < 0) {
            this.groundLevel = this.getAverageGroundLevel(world, sbb);
            if (this.groundLevel < 0) {
                return true;
            }
            this.height = this.field_74887_e.field_78894_e - this.groundLevel;
            this.field_74887_e.field_78895_b = this.groundLevel;
        }
        final int hollow = this.radius / 2;
        for (int dx = 0; dx <= 2 * this.radius; ++dx) {
            for (int dz = 0; dz <= 2 * this.radius; ++dz) {
                final int ax = Math.abs(dx - this.radius);
                final int az = Math.abs(dz - this.radius);
                final int dist = (int)(Math.max(ax, az) + Math.min(ax, az) * 0.5);
                for (int dy = 0; dy <= this.height; ++dy) {
                    if (dist <= this.radius && dist > hollow) {
                        this.func_151550_a(world, TFBlocks.log, 0, dx + 1, dy, dz + 1, sbb);
                    }
                }
                if (dist <= this.radius) {
                    this.func_151554_b(world, TFBlocks.log, 0, dx + 1, -1, dz + 1, sbb);
                }
                if (dist == hollow && dx == hollow + this.radius) {
                    this.func_151554_b(world, Blocks.field_150395_bd, 8, dx + 1, this.height, dz + 1, sbb);
                }
            }
        }
        for (int numInsects = random.nextInt(3 * this.radius) + random.nextInt(3 * this.radius) + 10, i = 0; i <= numInsects; ++i) {
            final int fHeight = (int)(this.height * random.nextDouble() * 0.9) + this.height / 10;
            final double fAngle = random.nextDouble();
            this.addInsect(world, fHeight, fAngle, random, sbb);
        }
        return true;
    }
    
    protected void addInsect(final World world, final int fHeight, double fAngle, final Random random, final StructureBoundingBox sbb) {
        final ChunkCoordinates bugSpot = TFGenerator.translateCoords(this.radius + 1, fHeight, this.radius + 1, this.radius + 1, fAngle, 0.5);
        fAngle %= 1.0;
        int insectMeta = 0;
        if (fAngle > 0.875 || fAngle <= 0.125) {
            insectMeta = 3;
        }
        else if (fAngle > 0.125 && fAngle <= 0.375) {
            insectMeta = 1;
        }
        else if (fAngle > 0.375 && fAngle <= 0.625) {
            insectMeta = 4;
        }
        else if (fAngle > 0.625 && fAngle <= 0.875) {
            insectMeta = 2;
        }
        this.addInsect(world, random.nextBoolean() ? TFBlocks.firefly : TFBlocks.cicada, insectMeta, bugSpot.field_71574_a, bugSpot.field_71572_b, bugSpot.field_71573_c, sbb);
    }
    
    private void addInsect(final World world, final Block blockID, final int insectMeta, final int posX, final int posY, final int posZ, final StructureBoundingBox sbb) {
        final int ox = this.func_74865_a(posX, posZ);
        final int oy = this.func_74862_a(posY);
        final int oz = this.func_74873_b(posX, posZ);
        if (sbb.func_78890_b(ox, oy, oz) && blockID != null && blockID.func_149742_c(world, ox, oy, oz)) {
            world.func_147465_d(ox, oy, oz, blockID, insectMeta, 2);
        }
    }
}
