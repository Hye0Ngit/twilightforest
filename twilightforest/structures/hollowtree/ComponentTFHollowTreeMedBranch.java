// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.hollowtree;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockLog;
import twilightforest.block.TFBlocks;
import net.minecraft.world.World;
import java.util.Random;
import net.minecraft.world.gen.structure.StructureComponent;
import java.util.List;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.util.EnumFacing;
import twilightforest.world.feature.TFGenerator;
import twilightforest.TFFeature;
import net.minecraft.util.math.BlockPos;

public class ComponentTFHollowTreeMedBranch extends StructureTFTreeComponent
{
    BlockPos src;
    BlockPos dest;
    double length;
    double angle;
    double tilt;
    boolean leafy;
    
    public ComponentTFHollowTreeMedBranch() {
    }
    
    protected ComponentTFHollowTreeMedBranch(final TFFeature feature, final int i, final int sx, final int sy, final int sz, final double length, final double angle, final double tilt, final boolean leafy) {
        super(feature, i);
        this.src = new BlockPos(sx, sy, sz);
        this.dest = TFGenerator.translate(this.src, length, angle, tilt);
        this.length = length;
        this.angle = angle;
        this.tilt = tilt;
        this.leafy = leafy;
        this.func_186164_a(EnumFacing.SOUTH);
        (this.field_74887_e = new StructureBoundingBox((Vec3i)this.src, (Vec3i)this.dest)).func_78888_b(this.makeExpandedBB(0.5, length, angle, tilt));
        this.field_74887_e.func_78888_b(this.makeExpandedBB(0.10000000149011612, length, 0.225, tilt));
        this.field_74887_e.func_78888_b(this.makeExpandedBB(0.10000000149011612, length, -0.225, tilt));
    }
    
    private StructureBoundingBox makeExpandedBB(final double outVar, final double branchLength, final double branchAngle, final double branchTilt) {
        final BlockPos branchSrc = TFGenerator.translate(this.src, this.length * outVar, this.angle, this.tilt);
        final BlockPos branchDest = TFGenerator.translate(branchSrc, branchLength, branchAngle, branchTilt);
        return new StructureBoundingBox((Vec3i)branchSrc, (Vec3i)branchDest);
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound tagCompound) {
        super.func_143012_a(tagCompound);
        tagCompound.func_74768_a("srcPosX", this.src.func_177958_n());
        tagCompound.func_74768_a("srcPosY", this.src.func_177956_o());
        tagCompound.func_74768_a("srcPosZ", this.src.func_177952_p());
        tagCompound.func_74768_a("destPosX", this.dest.func_177958_n());
        tagCompound.func_74768_a("destPosY", this.dest.func_177956_o());
        tagCompound.func_74768_a("destPosZ", this.dest.func_177952_p());
        tagCompound.func_74780_a("branchLength", this.length);
        tagCompound.func_74780_a("branchAngle", this.angle);
        tagCompound.func_74780_a("branchTilt", this.tilt);
        tagCompound.func_74757_a("branchLeafy", this.leafy);
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound tagCompound, final TemplateManager templateManager) {
        super.func_143011_b(tagCompound, templateManager);
        this.src = new BlockPos(tagCompound.func_74762_e("srcPosX"), tagCompound.func_74762_e("srcPosY"), tagCompound.func_74762_e("srcPosZ"));
        this.dest = new BlockPos(tagCompound.func_74762_e("destPosX"), tagCompound.func_74762_e("destPosY"), tagCompound.func_74762_e("destPosZ"));
        this.length = tagCompound.func_74769_h("branchLength");
        this.angle = tagCompound.func_74769_h("branchAngle");
        this.tilt = tagCompound.func_74769_h("branchTilt");
        this.leafy = tagCompound.func_74767_n("branchLeafy");
    }
    
    public void makeSmallBranch(final List<StructureComponent> list, final Random rand, final int index, final int x, final int y, final int z, final double branchLength, final double branchRotation, final double branchAngle, final boolean leafy) {
        final ComponentTFHollowTreeSmallBranch branch = new ComponentTFHollowTreeSmallBranch(this.getFeatureType(), index, x, y, z, branchLength, branchRotation, branchAngle, leafy);
        list.add(branch);
        branch.func_74861_a((StructureComponent)this, (List)list, rand);
    }
    
    public boolean func_74875_a(final World world, final Random random, final StructureBoundingBox sbb) {
        return this.addComponentParts(world, random, sbb, false);
    }
    
    @Override
    public boolean addComponentParts(final World world, final Random random, final StructureBoundingBox sbb, final boolean drawLeaves) {
        final BlockPos rSrc = this.src.func_177982_a(-this.field_74887_e.field_78897_a, -this.field_74887_e.field_78895_b, -this.field_74887_e.field_78896_c);
        final BlockPos rDest = this.dest.func_177982_a(-this.field_74887_e.field_78897_a, -this.field_74887_e.field_78895_b, -this.field_74887_e.field_78896_c);
        if (!drawLeaves) {
            final IBlockState log = TFBlocks.twilight_log.func_176223_P().func_177226_a((IProperty)BlockLog.field_176299_a, (Comparable)BlockLog.EnumAxis.NONE);
            this.drawBresehnam(world, sbb, rSrc.func_177958_n(), rSrc.func_177956_o(), rSrc.func_177952_p(), rDest.func_177958_n(), rDest.func_177956_o(), rDest.func_177952_p(), log);
            this.drawBresehnam(world, sbb, rSrc.func_177958_n(), rSrc.func_177956_o() + 1, rSrc.func_177952_p(), rDest.func_177958_n(), rDest.func_177956_o(), rDest.func_177952_p(), log);
        }
        final Random decoRNG = new Random(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
        final int numShoots = Math.min(decoRNG.nextInt(3) + 1, (int)(this.length / 5.0));
        final double angleInc = 0.8 / numShoots;
        for (int i = 0; i < numShoots; ++i) {
            final double angleVar = angleInc * i - 0.4;
            final double outVar = decoRNG.nextDouble() * 0.8 + 0.2;
            final BlockPos bSrc = TFGenerator.translate(rSrc, this.length * outVar, this.angle, this.tilt);
            this.drawSmallBranch(world, sbb, bSrc.func_177958_n(), bSrc.func_177956_o(), bSrc.func_177952_p(), Math.max(this.length * 0.30000001192092896, 2.0), this.angle + angleVar, this.tilt, drawLeaves);
        }
        if (drawLeaves) {
            for (int numLeafBalls = Math.min(decoRNG.nextInt(3) + 1, (int)(this.length / 5.0)), j = 0; j < numLeafBalls; ++j) {
                final double slength = (decoRNG.nextFloat() * 0.6f + 0.2f) * this.length;
                final BlockPos bdst = TFGenerator.translate(rSrc, slength, this.angle, this.tilt);
                this.makeLeafBlob(world, sbb, bdst.func_177958_n(), bdst.func_177956_o(), bdst.func_177952_p(), decoRNG.nextBoolean() ? 2 : 3);
            }
            this.makeLeafBlob(world, sbb, rDest.func_177958_n(), rDest.func_177956_o(), rDest.func_177952_p(), 3);
        }
        return true;
    }
    
    protected void drawBresehnam(final World world, final StructureBoundingBox sbb, final int x1, final int y1, final int z1, final int x2, final int y2, final int z2, final IBlockState blockState) {
        if (x1 == x2 && z1 == z2) {
            for (int l = Math.max(y1, y2), i = Math.min(y1, y2); i < l; ++i) {
                this.func_175811_a(world, blockState, x1, i, z1, sbb);
            }
        }
        else {
            final BlockPos[] bresehnamArrays;
            final BlockPos[] lineCoords = bresehnamArrays = TFGenerator.getBresehnamArrays(x1, y1, z1, x2, y2, z2);
            for (final BlockPos coords : bresehnamArrays) {
                this.func_175811_a(world, blockState, coords.func_177958_n(), coords.func_177956_o(), coords.func_177952_p(), sbb);
            }
        }
    }
    
    protected void makeLeafBlob(final World world, final StructureBoundingBox sbb, final int sx, final int sy, final int sz, final int radius) {
        for (int dx = 0; dx <= radius; ++dx) {
            for (int dy = 0; dy <= radius; ++dy) {
                for (int dz = 0; dz <= radius; ++dz) {
                    int dist = 0;
                    if (dx >= dy && dx >= dz) {
                        dist = (int)(dx + (Math.max(dy, dz) * 0.5f + Math.min(dy, dz) * 0.25f));
                    }
                    else if (dy >= dx && dy >= dz) {
                        dist = (int)(dy + (Math.max(dx, dz) * 0.5f + Math.min(dx, dz) * 0.25f));
                    }
                    else {
                        dist = (int)(dz + (Math.max(dx, dy) * 0.5f + Math.min(dx, dy) * 0.25f));
                    }
                    if (dist <= radius) {
                        final IBlockState leaves = TFBlocks.twilight_leaves.func_176223_P().func_177226_a((IProperty)BlockLeaves.field_176236_b, (Comparable)false);
                        this.placeLeafBlock(world, leaves, sx + dx, sy + dy, sz + dz, sbb);
                        this.placeLeafBlock(world, leaves, sx + dx, sy + dy, sz - dz, sbb);
                        this.placeLeafBlock(world, leaves, sx - dx, sy + dy, sz + dz, sbb);
                        this.placeLeafBlock(world, leaves, sx - dx, sy + dy, sz - dz, sbb);
                        this.placeLeafBlock(world, leaves, sx + dx, sy - dy, sz + dz, sbb);
                        this.placeLeafBlock(world, leaves, sx + dx, sy - dy, sz - dz, sbb);
                        this.placeLeafBlock(world, leaves, sx - dx, sy - dy, sz + dz, sbb);
                        this.placeLeafBlock(world, leaves, sx - dx, sy - dy, sz - dz, sbb);
                    }
                }
            }
        }
    }
    
    protected void drawSmallBranch(final World world, final StructureBoundingBox sbb, final int sx, final int sy, final int sz, final double branchLength, final double branchAngle, final double branchTilt, final boolean drawLeaves) {
        final BlockPos branchDest = TFGenerator.translate(new BlockPos(sx, sy, sz), branchLength, branchAngle, branchTilt);
        if (!drawLeaves) {
            final IBlockState log = TFBlocks.twilight_log.func_176223_P().func_177226_a((IProperty)BlockLog.field_176299_a, (Comparable)BlockLog.EnumAxis.NONE);
            this.drawBresehnam(world, sbb, sx, sy, sz, branchDest.func_177958_n(), branchDest.func_177956_o(), branchDest.func_177952_p(), log);
        }
        else {
            this.makeLeafBlob(world, sbb, branchDest.func_177958_n(), branchDest.func_177956_o(), branchDest.func_177952_p(), 2);
        }
    }
}
