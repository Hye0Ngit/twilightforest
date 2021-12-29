// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.world.gen.feature.IFeatureConfig;
import twilightforest.util.FeatureUtil;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.ISeedReader;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.state.Property;
import net.minecraft.block.LeavesBlock;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class TFGenFallenHollowLog extends Feature<NoFeatureConfig>
{
    final BlockState mossPatch;
    final BlockState oakLeaves;
    final BlockState oakLogWithZAxis;
    final BlockState oakLogWithXAxis;
    final BlockState grass;
    final BlockState firefly;
    
    public TFGenFallenHollowLog(final Codec<NoFeatureConfig> configIn) {
        super((Codec)configIn);
        this.mossPatch = ((Block)TFBlocks.moss_patch.get()).func_176223_P();
        this.oakLeaves = (BlockState)((Block)TFBlocks.oak_leaves.get()).func_176223_P().func_206870_a((Property)LeavesBlock.field_208495_b, (Comparable)true);
        this.oakLogWithZAxis = (BlockState)((RotatedPillarBlock)TFBlocks.oak_log.get()).func_176223_P().func_206870_a((Property)RotatedPillarBlock.field_176298_M, (Comparable)Direction.Axis.Z);
        this.oakLogWithXAxis = (BlockState)((RotatedPillarBlock)TFBlocks.oak_log.get()).func_176223_P().func_206870_a((Property)RotatedPillarBlock.field_176298_M, (Comparable)Direction.Axis.X);
        this.grass = Blocks.field_196658_i.func_176223_P();
        this.firefly = ((Block)TFBlocks.firefly.get()).func_176223_P();
    }
    
    public boolean generate(final ISeedReader world, final ChunkGenerator generator, final Random rand, final BlockPos pos, final NoFeatureConfig config) {
        return rand.nextBoolean() ? this.makeLog4Z((IWorld)world, rand, pos) : this.makeLog4X((IWorld)world, rand, pos);
    }
    
    private boolean makeLog4Z(final IWorld world, final Random rand, final BlockPos pos) {
        if (!FeatureUtil.isAreaSuitable(world, pos, 9, 3, 4)) {
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
                world.func_180501_a(pos.func_177982_a(1, -1, dz + 3), this.oakLogWithZAxis, 3);
                if (rand.nextBoolean()) {
                    world.func_180501_a(pos.func_177982_a(1, 0, dz + 3), this.mossPatch, 3);
                }
            }
            else {
                world.func_180501_a(pos.func_177982_a(1, -1, dz + 3), this.grass, 3);
                world.func_180501_a(pos.func_177982_a(1, 0, dz + 3), this.mossPatch, 3);
            }
            if (rand.nextBoolean()) {
                world.func_180501_a(pos.func_177982_a(2, -1, dz + 3), this.oakLogWithZAxis, 3);
                if (rand.nextBoolean()) {
                    world.func_180501_a(pos.func_177982_a(2, 0, dz + 3), this.mossPatch, 3);
                }
            }
            else {
                world.func_180501_a(pos.func_177982_a(2, -1, dz + 3), this.grass, 3);
                world.func_180501_a(pos.func_177982_a(2, 0, dz + 3), this.mossPatch, 3);
            }
            world.func_180501_a(pos.func_177982_a(0, 0, dz + 3), this.oakLogWithZAxis, 3);
            world.func_180501_a(pos.func_177982_a(3, 0, dz + 3), this.oakLogWithZAxis, 3);
            world.func_180501_a(pos.func_177982_a(0, 1, dz + 3), this.oakLogWithZAxis, 3);
            world.func_180501_a(pos.func_177982_a(3, 1, dz + 3), this.oakLogWithZAxis, 3);
            world.func_180501_a(pos.func_177982_a(1, 2, dz + 3), this.oakLogWithZAxis, 3);
            world.func_180501_a(pos.func_177982_a(2, 2, dz + 3), this.oakLogWithZAxis, 3);
            if (rand.nextBoolean()) {
                world.func_180501_a(pos.func_177982_a(1, 3, dz + 3), this.mossPatch, 3);
            }
            if (rand.nextBoolean()) {
                world.func_180501_a(pos.func_177982_a(2, 3, dz + 3), this.mossPatch, 3);
            }
        }
        final int offZ = rand.nextInt(3) + 2;
        final boolean plusX = rand.nextBoolean();
        for (int dz2 = 0; dz2 < 3; ++dz2) {
            if (rand.nextBoolean()) {
                world.func_180501_a(pos.func_177982_a(plusX ? 3 : 0, 2, dz2 + offZ), this.oakLeaves, 3);
                if (rand.nextBoolean()) {
                    world.func_180501_a(pos.func_177982_a(plusX ? 3 : 0, 3, dz2 + offZ), this.oakLeaves, 3);
                }
                if (rand.nextBoolean()) {
                    world.func_180501_a(pos.func_177982_a(plusX ? 4 : -1, 2, dz2 + offZ), this.oakLeaves, 3);
                }
            }
        }
        world.func_180501_a(pos.func_177982_a(plusX ? 0 : 3, 2, rand.nextInt(4) + 3), this.firefly, 3);
        return true;
    }
    
    private void makeNegativeZJaggy(final IWorld world, final BlockPos pos, final int length, final int dx, final int dy) {
        for (int dz = -length; dz < 0; ++dz) {
            world.func_180501_a(pos.func_177982_a(dx, dy, dz + 3), this.oakLogWithZAxis, 3);
        }
    }
    
    private void makePositiveZJaggy(final IWorld world, final BlockPos pos, final int length, final int dx, final int dy) {
        for (int dz = 0; dz < length; ++dz) {
            world.func_180501_a(pos.func_177982_a(dx, dy, dz + 7), this.oakLogWithZAxis, 3);
        }
    }
    
    private boolean makeLog4X(final IWorld world, final Random rand, final BlockPos pos) {
        if (!FeatureUtil.isAreaSuitable(world, pos, 4, 3, 9)) {
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
                world.func_180501_a(pos.func_177982_a(dx + 3, -1, 1), this.oakLogWithXAxis, 3);
                if (rand.nextBoolean()) {
                    world.func_180501_a(pos.func_177982_a(dx + 3, 0, 1), this.mossPatch, 3);
                }
            }
            else {
                world.func_180501_a(pos.func_177982_a(dx + 3, -1, 1), this.grass, 3);
                world.func_180501_a(pos.func_177982_a(dx + 3, 0, 1), this.mossPatch, 3);
            }
            if (rand.nextBoolean()) {
                world.func_180501_a(pos.func_177982_a(dx + 3, -1, 2), this.oakLogWithXAxis, 3);
                if (rand.nextBoolean()) {
                    world.func_180501_a(pos.func_177982_a(dx + 3, 0, 2), this.mossPatch, 3);
                }
            }
            else {
                world.func_180501_a(pos.func_177982_a(dx + 3, -1, 2), this.grass, 3);
                world.func_180501_a(pos.func_177982_a(dx + 3, 0, 2), this.mossPatch, 3);
            }
            world.func_180501_a(pos.func_177982_a(dx + 3, 0, 0), this.oakLogWithXAxis, 3);
            world.func_180501_a(pos.func_177982_a(dx + 3, 0, 3), this.oakLogWithXAxis, 3);
            world.func_180501_a(pos.func_177982_a(dx + 3, 1, 0), this.oakLogWithXAxis, 3);
            world.func_180501_a(pos.func_177982_a(dx + 3, 1, 3), this.oakLogWithXAxis, 3);
            world.func_180501_a(pos.func_177982_a(dx + 3, 2, 1), this.oakLogWithXAxis, 3);
            world.func_180501_a(pos.func_177982_a(dx + 3, 2, 2), this.oakLogWithXAxis, 3);
            if (rand.nextBoolean()) {
                world.func_180501_a(pos.func_177982_a(dx + 3, 3, 1), this.mossPatch, 3);
            }
            if (rand.nextBoolean()) {
                world.func_180501_a(pos.func_177982_a(dx + 3, 3, 2), this.mossPatch, 3);
            }
        }
        final int offX = rand.nextInt(3) + 2;
        final boolean plusZ = rand.nextBoolean();
        for (int dx2 = 0; dx2 < 3; ++dx2) {
            if (rand.nextBoolean()) {
                world.func_180501_a(pos.func_177982_a(dx2 + offX, 2, plusZ ? 3 : 0), this.oakLeaves, 3);
                if (rand.nextBoolean()) {
                    world.func_180501_a(pos.func_177982_a(dx2 + offX, 3, plusZ ? 3 : 0), this.oakLeaves, 3);
                }
                if (rand.nextBoolean()) {
                    world.func_180501_a(pos.func_177982_a(dx2 + offX, 2, plusZ ? 4 : -1), this.oakLeaves, 3);
                }
            }
        }
        world.func_180501_a(pos.func_177982_a(rand.nextInt(4) + 3, 2, plusZ ? 0 : 3), this.firefly, 3);
        return true;
    }
    
    private void makeNegativeXJaggy(final IWorld world, final BlockPos pos, final int length, final int dz, final int dy) {
        for (int dx = -length; dx < 0; ++dx) {
            world.func_180501_a(pos.func_177982_a(dx + 3, dy, dz), this.oakLogWithXAxis, 3);
        }
    }
    
    private void makePositiveXJaggy(final IWorld world, final BlockPos pos, final int length, final int dz, final int dy) {
        for (int dx = 0; dx < length; ++dx) {
            world.func_180501_a(pos.func_177982_a(dx + 7, dy, dz), this.oakLogWithXAxis, 3);
        }
    }
}
