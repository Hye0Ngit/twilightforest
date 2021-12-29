// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.hollowtree;

import net.minecraft.world.IBlockAccess;
import net.minecraft.block.Block;
import twilightforest.block.TFBlocks;
import net.minecraft.world.World;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import twilightforest.world.TFGenerator;
import net.minecraft.util.ChunkCoordinates;
import twilightforest.structures.StructureTFComponent;

public class ComponentTFHollowTreeMedBranch extends StructureTFComponent
{
    ChunkCoordinates src;
    ChunkCoordinates dest;
    double length;
    double angle;
    double tilt;
    boolean leafy;
    
    public ComponentTFHollowTreeMedBranch() {
    }
    
    protected ComponentTFHollowTreeMedBranch(final int i, final int sx, final int sy, final int sz, final double length, final double angle, final double tilt, final boolean leafy) {
        super(i);
        this.src = new ChunkCoordinates(sx, sy, sz);
        this.dest = TFGenerator.translateCoords(this.src.field_71574_a, this.src.field_71572_b, this.src.field_71573_c, length, angle, tilt);
        this.length = length;
        this.angle = angle;
        this.tilt = tilt;
        this.leafy = leafy;
        this.setCoordBaseMode(0);
        (this.field_74887_e = new StructureBoundingBox(Math.min(this.src.field_71574_a, this.dest.field_71574_a), Math.min(this.src.field_71572_b, this.dest.field_71572_b), Math.min(this.src.field_71573_c, this.dest.field_71573_c), Math.max(this.src.field_71574_a, this.dest.field_71574_a), Math.max(this.src.field_71572_b, this.dest.field_71572_b), Math.max(this.src.field_71573_c, this.dest.field_71573_c))).func_78888_b(this.makeExpandedBB(0.5, length, angle, tilt));
        this.field_74887_e.func_78888_b(this.makeExpandedBB(0.10000000149011612, length, 0.225, tilt));
        this.field_74887_e.func_78888_b(this.makeExpandedBB(0.10000000149011612, length, -0.225, tilt));
    }
    
    private StructureBoundingBox makeExpandedBB(final double outVar, final double branchLength, final double branchAngle, final double branchTilt) {
        final ChunkCoordinates branchSrc = TFGenerator.translateCoords(this.src.field_71574_a, this.src.field_71572_b, this.src.field_71573_c, this.length * outVar, this.angle, this.tilt);
        final ChunkCoordinates branchDest = TFGenerator.translateCoords(branchSrc.field_71574_a, branchSrc.field_71572_b, branchSrc.field_71573_c, branchLength, branchAngle, branchTilt);
        return new StructureBoundingBox(Math.min(branchSrc.field_71574_a, branchDest.field_71574_a), Math.min(branchSrc.field_71572_b, branchDest.field_71572_b), Math.min(branchSrc.field_71573_c, branchDest.field_71573_c), Math.max(branchSrc.field_71574_a, branchDest.field_71574_a), Math.max(branchSrc.field_71572_b, branchDest.field_71572_b), Math.max(branchSrc.field_71573_c, branchDest.field_71573_c));
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_143012_a(par1NBTTagCompound);
        par1NBTTagCompound.func_74768_a("srcPosX", this.src.field_71574_a);
        par1NBTTagCompound.func_74768_a("srcPosY", this.src.field_71572_b);
        par1NBTTagCompound.func_74768_a("srcPosZ", this.src.field_71573_c);
        par1NBTTagCompound.func_74768_a("destPosX", this.dest.field_71574_a);
        par1NBTTagCompound.func_74768_a("destPosY", this.dest.field_71572_b);
        par1NBTTagCompound.func_74768_a("destPosZ", this.dest.field_71573_c);
        par1NBTTagCompound.func_74780_a("branchLength", this.length);
        par1NBTTagCompound.func_74780_a("branchAngle", this.angle);
        par1NBTTagCompound.func_74780_a("branchTilt", this.tilt);
        par1NBTTagCompound.func_74757_a("branchLeafy", this.leafy);
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_143011_b(par1NBTTagCompound);
        this.src = new ChunkCoordinates(par1NBTTagCompound.func_74762_e("srcPosX"), par1NBTTagCompound.func_74762_e("srcPosY"), par1NBTTagCompound.func_74762_e("srcPosZ"));
        this.dest = new ChunkCoordinates(par1NBTTagCompound.func_74762_e("destPosX"), par1NBTTagCompound.func_74762_e("destPosY"), par1NBTTagCompound.func_74762_e("destPosZ"));
        this.length = par1NBTTagCompound.func_74769_h("branchLength");
        this.angle = par1NBTTagCompound.func_74769_h("branchAngle");
        this.tilt = par1NBTTagCompound.func_74769_h("branchTilt");
        this.leafy = par1NBTTagCompound.func_74767_n("branchLeafy");
    }
    
    public void func_74861_a(final StructureComponent structurecomponent, final List list, final Random rand) {
        final int index = this.func_74877_c();
    }
    
    public void makeSmallBranch(final List list, final Random rand, final int index, final int x, final int y, final int z, final double branchLength, final double branchRotation, final double branchAngle, final boolean leafy) {
        final ComponentTFHollowTreeSmallBranch branch = new ComponentTFHollowTreeSmallBranch(index, x, y, z, branchLength, branchRotation, branchAngle, leafy);
        list.add(branch);
        branch.func_74861_a(this, list, rand);
    }
    
    public boolean func_74875_a(final World world, final Random random, final StructureBoundingBox sbb) {
        final ChunkCoordinates rSrc = new ChunkCoordinates(this.src.field_71574_a - this.field_74887_e.field_78897_a, this.src.field_71572_b - this.field_74887_e.field_78895_b, this.src.field_71573_c - this.field_74887_e.field_78896_c);
        final ChunkCoordinates rDest = new ChunkCoordinates(this.dest.field_71574_a - this.field_74887_e.field_78897_a, this.dest.field_71572_b - this.field_74887_e.field_78895_b, this.dest.field_71573_c - this.field_74887_e.field_78896_c);
        this.drawBresehnam(world, sbb, rSrc.field_71574_a, rSrc.field_71572_b, rSrc.field_71573_c, rDest.field_71574_a, rDest.field_71572_b, rDest.field_71573_c, TFBlocks.log, 12);
        this.drawBresehnam(world, sbb, rSrc.field_71574_a, rSrc.field_71572_b + 1, rSrc.field_71573_c, rDest.field_71574_a, rDest.field_71572_b, rDest.field_71573_c, TFBlocks.log, 12);
        final Random decoRNG = new Random(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
        final int numShoots = Math.min(decoRNG.nextInt(3) + 1, (int)(this.length / 5.0));
        final double angleInc = 0.8 / numShoots;
        for (int i = 0; i < numShoots; ++i) {
            final double angleVar = angleInc * i - 0.4;
            final double outVar = decoRNG.nextDouble() * 0.8 + 0.2;
            final double tiltVar = decoRNG.nextDouble() * 0.75 + 0.15;
            final ChunkCoordinates bSrc = TFGenerator.translateCoords(rSrc.field_71574_a, rSrc.field_71572_b, rSrc.field_71573_c, this.length * outVar, this.angle, this.tilt);
            final double slength = this.length * 0.4;
            this.drawSmallBranch(world, sbb, bSrc.field_71574_a, bSrc.field_71572_b, bSrc.field_71573_c, Math.max(this.length * 0.30000001192092896, 2.0), this.angle + angleVar, this.tilt, this.leafy);
        }
        if (this.leafy) {
            for (int numLeafBalls = Math.min(decoRNG.nextInt(3) + 1, (int)(this.length / 5.0)), j = 0; j < numLeafBalls; ++j) {
                final double slength = (decoRNG.nextFloat() * 0.6f + 0.2f) * this.length;
                final ChunkCoordinates bdst = TFGenerator.translateCoords(rSrc.field_71574_a, rSrc.field_71572_b, rSrc.field_71573_c, slength, this.angle, this.tilt);
                this.makeLeafBlob(world, sbb, bdst.field_71574_a, bdst.field_71572_b, bdst.field_71573_c, decoRNG.nextBoolean() ? 2 : 3);
            }
            this.makeLeafBlob(world, sbb, rDest.field_71574_a, rDest.field_71572_b, rDest.field_71573_c, 3);
        }
        return true;
    }
    
    protected void drawBresehnam(final World world, final StructureBoundingBox sbb, final int x1, final int y1, final int z1, final int x2, final int y2, final int z2, final Block blockValue, final int metaValue) {
        if (x1 == x2 && z1 == z2) {
            for (int l = Math.max(y1, y2), i = Math.min(y1, y2); i < l; ++i) {
                this.func_151550_a(world, blockValue, metaValue, x1, i, z1, sbb);
            }
        }
        else {
            final ChunkCoordinates[] bresehnamArrayCoords;
            final ChunkCoordinates[] lineCoords = bresehnamArrayCoords = TFGenerator.getBresehnamArrayCoords(x1, y1, z1, x2, y2, z2);
            for (final ChunkCoordinates coords : bresehnamArrayCoords) {
                this.func_151550_a(world, blockValue, metaValue, coords.field_71574_a, coords.field_71572_b, coords.field_71573_c, sbb);
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
                        this.placeLeafBlock(world, TFBlocks.leaves, 0, sx + dx, sy + dy, sz + dz, sbb);
                        this.placeLeafBlock(world, TFBlocks.leaves, 0, sx + dx, sy + dy, sz - dz, sbb);
                        this.placeLeafBlock(world, TFBlocks.leaves, 0, sx - dx, sy + dy, sz + dz, sbb);
                        this.placeLeafBlock(world, TFBlocks.leaves, 0, sx - dx, sy + dy, sz - dz, sbb);
                        this.placeLeafBlock(world, TFBlocks.leaves, 0, sx + dx, sy - dy, sz + dz, sbb);
                        this.placeLeafBlock(world, TFBlocks.leaves, 0, sx + dx, sy - dy, sz - dz, sbb);
                        this.placeLeafBlock(world, TFBlocks.leaves, 0, sx - dx, sy - dy, sz + dz, sbb);
                        this.placeLeafBlock(world, TFBlocks.leaves, 0, sx - dx, sy - dy, sz - dz, sbb);
                    }
                }
            }
        }
    }
    
    protected void placeLeafBlock(final World world, final Block blockID, final int meta, final int x, final int y, final int z, final StructureBoundingBox sbb) {
        final int offX = this.func_74865_a(x, z);
        final int offY = this.func_74862_a(y);
        final int offZ = this.func_74873_b(x, z);
        if (sbb.func_78890_b(offX, offY, offZ)) {
            final Block whatsThere = world.func_147439_a(offX, offY, offZ);
            if (whatsThere == null || whatsThere.canBeReplacedByLeaves((IBlockAccess)world, offX, offY, offZ)) {
                world.func_147465_d(offX, offY, offZ, blockID, meta, 2);
            }
        }
    }
    
    protected void drawSmallBranch(final World world, final StructureBoundingBox sbb, final int sx, final int sy, final int sz, final double branchLength, final double branchAngle, final double branchTilt, final boolean leafy) {
        final ChunkCoordinates branchDest = TFGenerator.translateCoords(sx, sy, sz, branchLength, branchAngle, branchTilt);
        this.drawBresehnam(world, sbb, sx, sy, sz, branchDest.field_71574_a, branchDest.field_71572_b, branchDest.field_71573_c, TFBlocks.log, 12);
        this.makeLeafBlob(world, sbb, branchDest.field_71574_a, branchDest.field_71572_b, branchDest.field_71573_c, 2);
    }
}
