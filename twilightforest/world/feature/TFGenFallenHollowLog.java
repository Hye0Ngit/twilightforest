// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.init.Blocks;
import net.minecraft.block.BlockLog;
import twilightforest.block.BlockTFLog;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.PlantVariant;
import twilightforest.block.BlockTFPlant;
import twilightforest.block.TFBlocks;
import net.minecraft.block.state.IBlockState;

public class TFGenFallenHollowLog extends TFGenerator
{
    final IBlockState mossPatch;
    final IBlockState oakLeaves;
    final IBlockState oakLogWithZAxis;
    final IBlockState oakLogWithXAxis;
    final IBlockState dirt;
    final IBlockState firefly;
    
    public TFGenFallenHollowLog() {
        this.mossPatch = TFBlocks.twilight_plant.func_176223_P().func_177226_a((IProperty)BlockTFPlant.VARIANT, (Comparable)PlantVariant.MOSSPATCH);
        this.oakLeaves = TFBlocks.twilight_leaves.func_176223_P().func_177226_a((IProperty)BlockLeaves.field_176236_b, (Comparable)false);
        this.oakLogWithZAxis = TFBlocks.twilight_log.func_176223_P().func_177226_a((IProperty)BlockTFLog.field_176299_a, (Comparable)BlockLog.EnumAxis.Z);
        this.oakLogWithXAxis = TFBlocks.twilight_log.func_176223_P().func_177226_a((IProperty)BlockTFLog.field_176299_a, (Comparable)BlockLog.EnumAxis.X);
        this.dirt = Blocks.field_150346_d.func_176223_P();
        this.firefly = TFBlocks.firefly.func_176223_P();
    }
    
    public boolean func_180709_b(final World world, final Random rand, final BlockPos pos) {
        return rand.nextBoolean() ? this.makeLog4Z(world, rand, pos) : this.makeLog4X(world, rand, pos);
    }
    
    private boolean makeLog4Z(final World world, final Random rand, final BlockPos pos) {
        if (!TFGenerator.isAreaSuitable(world, rand, pos, 9, 3, 4)) {
            return false;
        }
        this.makeNegativeZJaggy(world, pos, rand.nextInt(3), 0, 0);
        this.makeNegativeZJaggy(world, pos, rand.nextInt(3), 3, 0);
        this.makeNegativeZJaggy(world, pos, rand.nextInt(3), 0, 1);
        this.makeNegativeZJaggy(world, pos, rand.nextInt(3), 3, 1);
        this.makeNegativeZJaggy(world, pos, rand.nextInt(3), 1, 2);
        this.makeNegativeZJaggy(world, pos, rand.nextInt(3), 2, 2);
        this.makePositiveZJaggy(world, pos, rand.nextInt(3), 0, 0);
        this.makePositiveZJaggy(world, pos, rand.nextInt(3), 3, 0);
        this.makePositiveZJaggy(world, pos, rand.nextInt(3), 0, 1);
        this.makePositiveZJaggy(world, pos, rand.nextInt(3), 3, 1);
        this.makePositiveZJaggy(world, pos, rand.nextInt(3), 1, 2);
        this.makePositiveZJaggy(world, pos, rand.nextInt(3), 2, 2);
        for (int dz = 0; dz < 4; ++dz) {
            if (rand.nextBoolean()) {
                this.func_175903_a(world, pos.func_177982_a(1, -1, dz + 3), this.oakLogWithZAxis);
                if (rand.nextBoolean()) {
                    this.func_175903_a(world, pos.func_177982_a(1, 0, dz + 3), this.mossPatch);
                }
            }
            else {
                this.func_175903_a(world, pos.func_177982_a(1, -1, dz + 3), this.dirt);
                this.func_175903_a(world, pos.func_177982_a(1, 0, dz + 3), this.mossPatch);
            }
            if (rand.nextBoolean()) {
                this.func_175903_a(world, pos.func_177982_a(2, -1, dz + 3), this.oakLogWithZAxis);
                if (rand.nextBoolean()) {
                    this.func_175903_a(world, pos.func_177982_a(2, 0, dz + 3), this.mossPatch);
                }
            }
            else {
                this.func_175903_a(world, pos.func_177982_a(2, -1, dz + 3), this.dirt);
                this.func_175903_a(world, pos.func_177982_a(2, 0, dz + 3), this.mossPatch);
            }
            this.func_175903_a(world, pos.func_177982_a(0, 0, dz + 3), this.oakLogWithZAxis);
            this.func_175903_a(world, pos.func_177982_a(3, 0, dz + 3), this.oakLogWithZAxis);
            this.func_175903_a(world, pos.func_177982_a(0, 1, dz + 3), this.oakLogWithZAxis);
            this.func_175903_a(world, pos.func_177982_a(3, 1, dz + 3), this.oakLogWithZAxis);
            this.func_175903_a(world, pos.func_177982_a(1, 2, dz + 3), this.oakLogWithZAxis);
            this.func_175903_a(world, pos.func_177982_a(2, 2, dz + 3), this.oakLogWithZAxis);
            if (rand.nextBoolean()) {
                this.func_175903_a(world, pos.func_177982_a(1, 3, dz + 3), this.mossPatch);
            }
            if (rand.nextBoolean()) {
                this.func_175903_a(world, pos.func_177982_a(2, 3, dz + 3), this.mossPatch);
            }
        }
        final int offZ = rand.nextInt(3) + 2;
        final boolean plusX = rand.nextBoolean();
        for (int dz2 = 0; dz2 < 3; ++dz2) {
            if (rand.nextBoolean()) {
                this.func_175903_a(world, pos.func_177982_a(plusX ? 3 : 0, 2, dz2 + offZ), this.oakLeaves);
                if (rand.nextBoolean()) {
                    this.func_175903_a(world, pos.func_177982_a(plusX ? 3 : 0, 3, dz2 + offZ), this.oakLeaves);
                }
                if (rand.nextBoolean()) {
                    this.func_175903_a(world, pos.func_177982_a(plusX ? 4 : -1, 2, dz2 + offZ), this.oakLeaves);
                }
            }
        }
        this.func_175903_a(world, pos.func_177982_a(plusX ? 0 : 3, 2, rand.nextInt(4) + 3), this.firefly);
        return true;
    }
    
    private void makeNegativeZJaggy(final World world, final BlockPos pos, final int length, final int dx, final int dy) {
        for (int dz = -length; dz < 0; ++dz) {
            this.func_175903_a(world, pos.func_177982_a(dx, dy, dz + 3), this.oakLogWithZAxis);
        }
    }
    
    private void makePositiveZJaggy(final World world, final BlockPos pos, final int length, final int dx, final int dy) {
        for (int dz = 0; dz < length; ++dz) {
            this.func_175903_a(world, pos.func_177982_a(dx, dy, dz + 7), this.oakLogWithZAxis);
        }
    }
    
    private boolean makeLog4X(final World world, final Random rand, final BlockPos pos) {
        if (!TFGenerator.isAreaSuitable(world, rand, pos, 4, 3, 9)) {
            return false;
        }
        this.makeNegativeXJaggy(world, pos, rand.nextInt(3), 0, 0);
        this.makeNegativeXJaggy(world, pos, rand.nextInt(3), 3, 0);
        this.makeNegativeXJaggy(world, pos, rand.nextInt(3), 0, 1);
        this.makeNegativeXJaggy(world, pos, rand.nextInt(3), 3, 1);
        this.makeNegativeXJaggy(world, pos, rand.nextInt(3), 1, 2);
        this.makeNegativeXJaggy(world, pos, rand.nextInt(3), 2, 2);
        this.makePositiveXJaggy(world, pos, rand.nextInt(3), 0, 0);
        this.makePositiveXJaggy(world, pos, rand.nextInt(3), 3, 0);
        this.makePositiveXJaggy(world, pos, rand.nextInt(3), 0, 1);
        this.makePositiveXJaggy(world, pos, rand.nextInt(3), 3, 1);
        this.makePositiveXJaggy(world, pos, rand.nextInt(3), 1, 2);
        this.makePositiveXJaggy(world, pos, rand.nextInt(3), 2, 2);
        for (int dx = 0; dx < 4; ++dx) {
            if (rand.nextBoolean()) {
                this.func_175903_a(world, pos.func_177982_a(dx + 3, -1, 1), this.oakLogWithXAxis);
                if (rand.nextBoolean()) {
                    this.func_175903_a(world, pos.func_177982_a(dx + 3, 0, 1), this.mossPatch);
                }
            }
            else {
                this.func_175903_a(world, pos.func_177982_a(dx + 3, -1, 1), this.dirt);
                this.func_175903_a(world, pos.func_177982_a(dx + 3, 0, 1), this.mossPatch);
            }
            if (rand.nextBoolean()) {
                this.func_175903_a(world, pos.func_177982_a(dx + 3, -1, 2), this.oakLogWithXAxis);
                if (rand.nextBoolean()) {
                    this.func_175903_a(world, pos.func_177982_a(dx + 3, 0, 2), this.mossPatch);
                }
            }
            else {
                this.func_175903_a(world, pos.func_177982_a(dx + 3, -1, 2), this.dirt);
                this.func_175903_a(world, pos.func_177982_a(dx + 3, 0, 2), this.mossPatch);
            }
            this.func_175903_a(world, pos.func_177982_a(dx + 3, 0, 0), this.oakLogWithXAxis);
            this.func_175903_a(world, pos.func_177982_a(dx + 3, 0, 3), this.oakLogWithXAxis);
            this.func_175903_a(world, pos.func_177982_a(dx + 3, 1, 0), this.oakLogWithXAxis);
            this.func_175903_a(world, pos.func_177982_a(dx + 3, 1, 3), this.oakLogWithXAxis);
            this.func_175903_a(world, pos.func_177982_a(dx + 3, 2, 1), this.oakLogWithXAxis);
            this.func_175903_a(world, pos.func_177982_a(dx + 3, 2, 2), this.oakLogWithXAxis);
            if (rand.nextBoolean()) {
                this.func_175903_a(world, pos.func_177982_a(dx + 3, 3, 1), this.mossPatch);
            }
            if (rand.nextBoolean()) {
                this.func_175903_a(world, pos.func_177982_a(dx + 3, 3, 2), this.mossPatch);
            }
        }
        final int offX = rand.nextInt(3) + 2;
        final boolean plusZ = rand.nextBoolean();
        for (int dx2 = 0; dx2 < 3; ++dx2) {
            if (rand.nextBoolean()) {
                this.func_175903_a(world, pos.func_177982_a(dx2 + offX, 2, plusZ ? 3 : 0), this.oakLeaves);
                if (rand.nextBoolean()) {
                    this.func_175903_a(world, pos.func_177982_a(dx2 + offX, 3, plusZ ? 3 : 0), this.oakLeaves);
                }
                if (rand.nextBoolean()) {
                    this.func_175903_a(world, pos.func_177982_a(dx2 + offX, 2, plusZ ? 4 : -1), this.oakLeaves);
                }
            }
        }
        this.func_175903_a(world, pos.func_177982_a(rand.nextInt(4) + 3, 2, plusZ ? 0 : 3), this.firefly);
        return true;
    }
    
    private void makeNegativeXJaggy(final World world, final BlockPos pos, final int length, final int dz, final int dy) {
        for (int dx = -length; dx < 0; ++dx) {
            this.func_175903_a(world, pos.func_177982_a(dx + 3, dy, dz), this.oakLogWithXAxis);
        }
    }
    
    private void makePositiveXJaggy(final World world, final BlockPos pos, final int length, final int dz, final int dy) {
        for (int dx = 0; dx < length; ++dx) {
            this.func_175903_a(world, pos.func_177982_a(dx + 7, dy, dz), this.oakLogWithXAxis);
        }
    }
}
