// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraftforge.common.IPlantable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockHugeMushroom;
import net.minecraft.init.Blocks;

public class TFGenCanopyMushroom extends TFTreeGenerator
{
    public TFGenCanopyMushroom() {
        this(false);
    }
    
    public TFGenCanopyMushroom(final boolean notify) {
        super(notify);
        this.treeState = Blocks.field_150419_aX.func_176223_P().func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.STEM);
        this.branchState = Blocks.field_150419_aX.func_176223_P().func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.ALL_STEM);
        this.leafState = Blocks.field_150419_aX.func_176223_P().func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.CENTER);
        this.source = (IPlantable)Blocks.field_150337_Q;
    }
    
    public boolean func_180709_b(final World world, final Random random, final BlockPos pos) {
        int treeHeight = 12;
        if (random.nextInt(3) == 0) {
            treeHeight += random.nextInt(5);
            if (random.nextInt(8) == 0) {
                treeHeight += random.nextInt(5);
            }
        }
        if (pos.func_177956_o() >= 256 - treeHeight - 1) {
            return false;
        }
        final Block blockUnder = world.func_180495_p(pos.func_177977_b()).func_177230_c();
        if (blockUnder != Blocks.field_150349_c && blockUnder != Blocks.field_150346_d && blockUnder != Blocks.field_150391_bh) {
            return false;
        }
        final IBlockState baseState = ((random.nextInt(3) == 0) ? Blocks.field_150419_aX : Blocks.field_150420_aW).func_176223_P();
        this.treeState = baseState.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.STEM);
        this.branchState = baseState.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.ALL_STEM);
        this.leafState = baseState.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.CENTER);
        this.buildBranch(world, pos, 0, treeHeight, 0.0, 0.0, true, random);
        final int numBranches = 3 + random.nextInt(2);
        final double offset = random.nextDouble();
        for (int b = 0; b < numBranches; ++b) {
            this.buildBranch(world, pos, treeHeight - 5 + b, 9.0, 0.3 * b + offset, 0.2, false, random);
        }
        return true;
    }
    
    private void buildBranch(final World world, final BlockPos pos, final int height, final double length, final double angle, final double tilt, final boolean trunk, final Random treeRNG) {
        final BlockPos src = pos.func_177981_b(height);
        final BlockPos dest = TFGenerator.translate(src, length, angle, tilt);
        if (world.func_175697_a(dest, 5)) {
            if (src.func_177958_n() != dest.func_177958_n() || src.func_177952_p() != dest.func_177952_p()) {
                TFGenerator.drawBresehnam(this, world, src, new BlockPos(dest.func_177958_n(), src.func_177956_o(), dest.func_177952_p()), this.branchState);
                TFGenerator.drawBresehnam(this, world, new BlockPos(dest.func_177958_n(), src.func_177956_o() + 1, dest.func_177952_p()), dest.func_177977_b(), this.treeState);
            }
            else {
                TFGenerator.drawBresehnam(this, world, src, dest.func_177977_b(), this.treeState);
            }
            if (trunk) {
                this.addFirefly(world, pos, 3 + treeRNG.nextInt(7), treeRNG.nextDouble());
            }
            this.drawMushroomCircle(world, dest, 4, this.leafState);
        }
    }
    
    private void drawMushroomCircle(final World world, final BlockPos pos, final int rad, final IBlockState baseState) {
        for (byte dx = 0; dx <= rad; ++dx) {
            for (byte dz = 0; dz <= rad; ++dz) {
                int dist = (int)(Math.max(dx, dz) + Math.min(dx, dz) * 0.5);
                if (dx == 3 && dz == 3) {
                    dist = 6;
                }
                if (dx == 0) {
                    if (dz < rad) {
                        this.func_175903_a(world, pos.func_177982_a(0, 0, (int)dz), baseState);
                        this.func_175903_a(world, pos.func_177982_a(0, 0, -dz), baseState);
                    }
                    else {
                        this.func_175903_a(world, pos.func_177982_a(0, 0, (int)dz), baseState.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.SOUTH));
                        this.func_175903_a(world, pos.func_177982_a(0, 0, -dz), baseState.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.NORTH));
                    }
                }
                else if (dz == 0) {
                    if (dx < rad) {
                        this.func_175903_a(world, pos.func_177982_a((int)dx, 0, 0), baseState);
                        this.func_175903_a(world, pos.func_177982_a(-dx, 0, 0), baseState);
                    }
                    else {
                        this.func_175903_a(world, pos.func_177982_a((int)dx, 0, 0), baseState.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.EAST));
                        this.func_175903_a(world, pos.func_177982_a(-dx, 0, 0), baseState.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.WEST));
                    }
                }
                else if (dist < rad) {
                    this.func_175903_a(world, pos.func_177982_a((int)dx, 0, (int)dz), baseState);
                    this.func_175903_a(world, pos.func_177982_a((int)dx, 0, -dz), baseState);
                    this.func_175903_a(world, pos.func_177982_a(-dx, 0, (int)dz), baseState);
                    this.func_175903_a(world, pos.func_177982_a(-dx, 0, -dz), baseState);
                }
                else if (dist == rad) {
                    this.func_175903_a(world, pos.func_177982_a((int)dx, 0, (int)dz), baseState.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.SOUTH_EAST));
                    this.func_175903_a(world, pos.func_177982_a((int)dx, 0, -dz), baseState.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.NORTH_EAST));
                    this.func_175903_a(world, pos.func_177982_a(-dx, 0, (int)dz), baseState.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.SOUTH_WEST));
                    this.func_175903_a(world, pos.func_177982_a(-dx, 0, -dz), baseState.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.NORTH_WEST));
                }
            }
        }
    }
}
