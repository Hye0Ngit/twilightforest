// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.hollowtree;

import net.minecraft.util.math.Vec3i;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockVine;
import net.minecraft.init.Blocks;
import twilightforest.block.TFBlocks;
import twilightforest.world.feature.TFGenerator;
import net.minecraft.util.math.BlockPos;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;
import java.util.Random;
import net.minecraft.world.World;

public class ComponentTFHollowTreeTrunk extends StructureTFTreeComponent
{
    int radius;
    int height;
    int groundLevel;
    
    public ComponentTFHollowTreeTrunk() {
        this.groundLevel = -1;
    }
    
    public ComponentTFHollowTreeTrunk(final World world, final Random rand, final int index, final int x, final int y, final int z) {
        super(TFFeature.NOTHING, index);
        this.groundLevel = -1;
        this.height = rand.nextInt(64) + 32;
        this.radius = rand.nextInt(4) + 1;
        this.func_186164_a(EnumFacing.SOUTH);
        this.field_74887_e = new StructureBoundingBox(x, y, z, x + this.radius * 2 + 2, y + this.height, z + this.radius * 2 + 2);
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound tagCompound) {
        super.func_143012_a(tagCompound);
        tagCompound.func_74768_a("trunkRadius", this.radius);
        tagCompound.func_74768_a("trunkHeight", this.height);
        tagCompound.func_74768_a("trunkGroundLevel", this.groundLevel);
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound tagCompound, final TemplateManager templateManager) {
        super.func_143011_b(tagCompound, templateManager);
        this.radius = tagCompound.func_74762_e("trunkRadius");
        this.height = tagCompound.func_74762_e("trunkHeight");
        this.groundLevel = tagCompound.func_74762_e("trunkGroundLevel");
    }
    
    public void func_74861_a(final StructureComponent structurecomponent, final List<StructureComponent> list, final Random rand) {
        final int index = this.func_74877_c();
        final int numBranches = rand.nextInt(3) + 3;
        for (int i = 0; i <= numBranches; ++i) {
            final int branchHeight = (int)(this.height * rand.nextDouble() * 0.5) + this.height / 10;
            final double branchRotation = rand.nextDouble();
            this.makeSmallBranch(list, rand, index + i + 1, branchHeight, 4, branchRotation, 0.35, true);
        }
        this.buildFullCrown(list, rand, index + numBranches + 1);
        this.buildBranchRing(list, rand, index, 3, 2, 6, 0.75, 0.1, 3, 5, BranchSize.ROOT, false);
        this.buildBranchRing(list, rand, index, 1, 2, 8, 0.9, 0.1, 3, 5, BranchSize.ROOT, false);
    }
    
    protected void buildFullCrown(final List<StructureComponent> list, final Random rand, int index) {
        final int crownRadius = this.radius * 4 + 4;
        final int minBranches = this.radius + 3;
        index += this.buildBranchRing(list, rand, index, this.height - crownRadius, 4, crownRadius, 0.35, 0.1, minBranches, minBranches + 2, BranchSize.LARGE, true);
        index += this.buildBranchRing(list, rand, index, this.height - crownRadius / 2, 4, (int)(crownRadius * 0.8), 0.25, 0.2, minBranches, minBranches + 2, BranchSize.MEDIUM, true);
        index += this.buildBranchRing(list, rand, index, this.height - 2, 2, crownRadius / 2, 0.05, 0.2, minBranches, minBranches + 2, BranchSize.MEDIUM, true);
    }
    
    protected int buildBranchRing(final List<StructureComponent> list, final Random rand, final int index, final int branchHeight, final int heightVar, final int length, final double tilt, final double tiltVar, final int minBranches, final int maxBranches, final BranchSize size, final boolean leafy) {
        final int numBranches = rand.nextInt(maxBranches - minBranches + 1) + minBranches;
        final double rotationPerBranch = 1.0 / numBranches;
        final double branchOffset = rand.nextDouble();
        final double branchTilt = tilt + rand.nextDouble() * tiltVar;
        for (int i = 0; i < numBranches; ++i) {
            final int dHeight = branchHeight - heightVar + ((heightVar > 0) ? rand.nextInt(2 * heightVar) : 0);
            final double branchRotation = i * rotationPerBranch + branchOffset;
            final BlockPos pos = this.getBranchSrc(dHeight, branchRotation);
            StructureTFTreeComponent branch = this.branchFor(index, pos, length, branchRotation, branchTilt, leafy, size);
            if (!this.branchIntersectsDungeon(branch, list)) {
                list.add(branch);
                branch.func_74861_a((StructureComponent)this, (List)list, rand);
            }
            else if (size == BranchSize.LARGE || size == BranchSize.MEDIUM) {
                branch = this.branchFor(index, pos, length / 2, branchRotation, branchTilt, leafy, BranchSize.MEDIUM);
                if (!this.branchIntersectsDungeon(branch, list)) {
                    list.add(branch);
                    branch.func_74861_a((StructureComponent)this, (List)list, rand);
                }
            }
        }
        return numBranches;
    }
    
    public StructureTFTreeComponent branchFor(final int index, final BlockPos pos, final int branchLength, final double branchRotation, final double branchAngle, final boolean leafy, final BranchSize size) {
        switch (size) {
            case LARGE: {
                return new ComponentTFHollowTreeLargeBranch(this.getFeatureType(), index, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p(), branchLength, branchRotation, branchAngle, leafy);
            }
            default: {
                return new ComponentTFHollowTreeSmallBranch(this.getFeatureType(), index, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p(), branchLength, branchRotation, branchAngle, leafy);
            }
            case MEDIUM: {
                return new ComponentTFHollowTreeMedBranch(this.getFeatureType(), index, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p(), branchLength, branchRotation, branchAngle, leafy);
            }
            case ROOT: {
                return new ComponentTFHollowTreeRoot(this.getFeatureType(), index, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p(), branchLength, branchRotation, branchAngle, false);
            }
        }
    }
    
    public void makeSmallBranch(final List<StructureComponent> list, final Random rand, final int index, final int branchHeight, final int branchLength, final double branchRotation, final double branchAngle, final boolean leafy) {
        final BlockPos bSrc = this.getBranchSrc(branchHeight, branchRotation);
        final ComponentTFHollowTreeSmallBranch branch = new ComponentTFHollowTreeSmallBranch(this.getFeatureType(), index, bSrc.func_177958_n(), bSrc.func_177956_o(), bSrc.func_177952_p(), branchLength, branchRotation, branchAngle, leafy);
        if (!this.branchIntersectsDungeon(branch, list)) {
            list.add(branch);
            branch.func_74861_a((StructureComponent)this, (List)list, rand);
        }
    }
    
    private BlockPos getBranchSrc(final int branchHeight, final double branchRotation) {
        return TFGenerator.translate(new BlockPos(this.field_74887_e.field_78897_a + this.radius + 1, this.field_74887_e.field_78895_b + branchHeight, this.field_74887_e.field_78896_c + this.radius + 1), this.radius, branchRotation, 0.5);
    }
    
    public boolean func_74875_a(final World world, final Random random, final StructureBoundingBox sbb) {
        return this.addComponentParts(world, random, sbb, false);
    }
    
    @Override
    public boolean addComponentParts(final World world, final Random random, final StructureBoundingBox sbb, final boolean drawLeaves) {
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
                        this.func_175811_a(world, TFBlocks.twilight_log.func_176223_P(), dx + 1, dy, dz + 1, sbb);
                    }
                }
                if (dist <= this.radius) {
                    this.func_175808_b(world, TFBlocks.twilight_log.func_176223_P(), dx + 1, -1, dz + 1, sbb);
                }
                if (dist == hollow && dx == hollow + this.radius) {
                    this.func_175808_b(world, Blocks.field_150395_bd.func_176223_P().func_177226_a((IProperty)BlockVine.field_176278_M, (Comparable)true), dx + 1, this.height, dz + 1, sbb);
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
        final BlockPos bugSpot = TFGenerator.translate(new BlockPos(this.radius + 1, fHeight, this.radius + 1), this.radius + 1, fAngle, 0.5);
        fAngle %= 1.0;
        EnumFacing insectDirection = EnumFacing.DOWN;
        if (fAngle > 0.875 || fAngle <= 0.125) {
            insectDirection = EnumFacing.SOUTH;
        }
        else if (fAngle > 0.125 && fAngle <= 0.375) {
            insectDirection = EnumFacing.EAST;
        }
        else if (fAngle > 0.375 && fAngle <= 0.625) {
            insectDirection = EnumFacing.NORTH;
        }
        else if (fAngle > 0.625 && fAngle <= 0.875) {
            insectDirection = EnumFacing.WEST;
        }
        final IBlockState block = (random.nextBoolean() ? TFBlocks.firefly : TFBlocks.cicada).func_176223_P();
        this.addInsect(world, block.func_177226_a((IProperty)BlockDirectional.field_176387_N, (Comparable)insectDirection), bugSpot.func_177958_n(), bugSpot.func_177956_o(), bugSpot.func_177952_p(), sbb);
    }
    
    private void addInsect(final World world, final IBlockState blockState, final int posX, final int posY, final int posZ, final StructureBoundingBox sbb) {
        final BlockPos pos = this.getBlockPosWithOffset(posX, posY, posZ);
        final IBlockState whatsThere = world.func_180495_p(pos);
        if (sbb.func_175898_b((Vec3i)pos) && whatsThere == ComponentTFHollowTreeTrunk.AIR && blockState.func_177230_c().func_176196_c(world, pos)) {
            world.func_180501_a(pos, blockState, 2);
        }
    }
    
    enum BranchSize
    {
        SMALL, 
        MEDIUM, 
        LARGE, 
        ROOT;
    }
}
