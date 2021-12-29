// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature;

import net.minecraft.world.level.LevelAccessor;
import twilightforest.util.FeatureUtil;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.LeavesBlock;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;

public class TFGenFallenHollowLog extends Feature<NoneFeatureConfiguration>
{
    final BlockState mossPatch;
    final BlockState oakLeaves;
    final BlockState oakLogWithZAxis;
    final BlockState oakLogWithXAxis;
    final BlockState grass;
    final BlockState firefly;
    
    public TFGenFallenHollowLog(final Codec<NoneFeatureConfiguration> configIn) {
        super((Codec)configIn);
        this.mossPatch = ((Block)TFBlocks.MOSS_PATCH.get()).m_49966_();
        this.oakLeaves = (BlockState)((Block)TFBlocks.TWILIGHT_OAK_LEAVES.get()).m_49966_().m_61124_((Property)LeavesBlock.f_54419_, (Comparable)true);
        this.oakLogWithZAxis = (BlockState)((RotatedPillarBlock)TFBlocks.TWILIGHT_OAK_LOG.get()).m_49966_().m_61124_((Property)RotatedPillarBlock.f_55923_, (Comparable)Direction.Axis.Z);
        this.oakLogWithXAxis = (BlockState)((RotatedPillarBlock)TFBlocks.TWILIGHT_OAK_LOG.get()).m_49966_().m_61124_((Property)RotatedPillarBlock.f_55923_, (Comparable)Direction.Axis.X);
        this.grass = Blocks.f_50440_.m_49966_();
        this.firefly = ((Block)TFBlocks.FIREFLY.get()).m_49966_();
    }
    
    public boolean m_142674_(final FeaturePlaceContext<NoneFeatureConfiguration> ctx) {
        final WorldGenLevel world = ctx.m_159774_();
        final BlockPos pos = ctx.m_159777_();
        final Random rand = ctx.m_159776_();
        return rand.nextBoolean() ? this.makeLog4Z(world, rand, pos) : this.makeLog4X(world, rand, pos);
    }
    
    private boolean makeLog4Z(final WorldGenLevel world, final Random rand, final BlockPos pos) {
        if (!FeatureUtil.isAreaSuitable(world, pos, 4, 3, 9)) {
            return false;
        }
        this.makeNegativeZJaggy((LevelAccessor)world, pos, rand.nextInt(3), 0, 0);
        this.makeNegativeZJaggy((LevelAccessor)world, pos, rand.nextInt(3), 3, 0);
        this.makeNegativeZJaggy((LevelAccessor)world, pos, rand.nextInt(3), 0, 1);
        this.makeNegativeZJaggy((LevelAccessor)world, pos, rand.nextInt(3), 3, 1);
        this.makeNegativeZJaggy((LevelAccessor)world, pos, rand.nextInt(3), 1, 2);
        this.makeNegativeZJaggy((LevelAccessor)world, pos, rand.nextInt(3), 2, 2);
        this.makePositiveZJaggy((LevelAccessor)world, pos, rand.nextInt(3), 0, 0);
        this.makePositiveZJaggy((LevelAccessor)world, pos, rand.nextInt(3), 3, 0);
        this.makePositiveZJaggy((LevelAccessor)world, pos, rand.nextInt(3), 0, 1);
        this.makePositiveZJaggy((LevelAccessor)world, pos, rand.nextInt(3), 3, 1);
        this.makePositiveZJaggy((LevelAccessor)world, pos, rand.nextInt(3), 1, 2);
        this.makePositiveZJaggy((LevelAccessor)world, pos, rand.nextInt(3), 2, 2);
        for (int dz = 0; dz < 4; ++dz) {
            if (rand.nextBoolean()) {
                world.m_7731_(pos.m_142082_(1, -1, dz + 3), this.oakLogWithZAxis, 3);
                if (rand.nextBoolean()) {
                    world.m_7731_(pos.m_142082_(1, 0, dz + 3), this.mossPatch, 3);
                    this.m_159739_(world, pos.m_142082_(1, -1, dz + 3));
                }
            }
            else {
                world.m_7731_(pos.m_142082_(1, -1, dz + 3), this.grass, 3);
                world.m_7731_(pos.m_142082_(1, 0, dz + 3), this.mossPatch, 3);
                this.m_159739_(world, pos.m_142082_(1, -1, dz + 3));
            }
            if (rand.nextBoolean()) {
                world.m_7731_(pos.m_142082_(2, -1, dz + 3), this.oakLogWithZAxis, 3);
                if (rand.nextBoolean()) {
                    world.m_7731_(pos.m_142082_(2, 0, dz + 3), this.mossPatch, 3);
                    this.m_159739_(world, pos.m_142082_(2, -1, dz + 3));
                }
            }
            else {
                world.m_7731_(pos.m_142082_(2, -1, dz + 3), this.grass, 3);
                world.m_7731_(pos.m_142082_(2, 0, dz + 3), this.mossPatch, 3);
                this.m_159739_(world, pos.m_142082_(2, -1, dz + 3));
            }
            world.m_7731_(pos.m_142082_(0, 0, dz + 3), this.oakLogWithZAxis, 3);
            world.m_7731_(pos.m_142082_(3, 0, dz + 3), this.oakLogWithZAxis, 3);
            world.m_7731_(pos.m_142082_(0, 1, dz + 3), this.oakLogWithZAxis, 3);
            world.m_7731_(pos.m_142082_(3, 1, dz + 3), this.oakLogWithZAxis, 3);
            world.m_7731_(pos.m_142082_(1, 2, dz + 3), this.oakLogWithZAxis, 3);
            world.m_7731_(pos.m_142082_(2, 2, dz + 3), this.oakLogWithZAxis, 3);
            if (rand.nextBoolean()) {
                world.m_7731_(pos.m_142082_(1, 3, dz + 3), this.mossPatch, 3);
                this.m_159739_(world, pos.m_142082_(1, 2, dz + 3));
            }
            if (rand.nextBoolean()) {
                world.m_7731_(pos.m_142082_(2, 3, dz + 3), this.mossPatch, 3);
                this.m_159739_(world, pos.m_142082_(2, 2, dz + 3));
            }
        }
        final int offZ = rand.nextInt(3) + 2;
        final boolean plusX = rand.nextBoolean();
        for (int dz2 = 0; dz2 < 3; ++dz2) {
            if (rand.nextBoolean()) {
                world.m_7731_(pos.m_142082_(plusX ? 3 : 0, 2, dz2 + offZ), this.oakLeaves, 3);
                if (rand.nextBoolean()) {
                    world.m_7731_(pos.m_142082_(plusX ? 3 : 0, 3, dz2 + offZ), this.oakLeaves, 3);
                }
                if (rand.nextBoolean()) {
                    world.m_7731_(pos.m_142082_(plusX ? 4 : -1, 2, dz2 + offZ), this.oakLeaves, 3);
                }
            }
        }
        world.m_7731_(pos.m_142082_(plusX ? 0 : 3, 2, rand.nextInt(4) + 3), this.firefly, 3);
        return true;
    }
    
    private void makeNegativeZJaggy(final LevelAccessor world, final BlockPos pos, final int length, final int dx, final int dy) {
        for (int dz = -length; dz < 0; ++dz) {
            world.m_7731_(pos.m_142082_(dx, dy, dz + 3), this.oakLogWithZAxis, 3);
        }
    }
    
    private void makePositiveZJaggy(final LevelAccessor world, final BlockPos pos, final int length, final int dx, final int dy) {
        for (int dz = 0; dz < length; ++dz) {
            world.m_7731_(pos.m_142082_(dx, dy, dz + 7), this.oakLogWithZAxis, 3);
        }
    }
    
    private boolean makeLog4X(final WorldGenLevel world, final Random rand, final BlockPos pos) {
        if (!FeatureUtil.isAreaSuitable(world, pos, 9, 3, 4)) {
            return false;
        }
        this.makeNegativeXJaggy((LevelAccessor)world, pos, rand.nextInt(3), 0, 0);
        this.makeNegativeXJaggy((LevelAccessor)world, pos, rand.nextInt(3), 3, 0);
        this.makeNegativeXJaggy((LevelAccessor)world, pos, rand.nextInt(3), 0, 1);
        this.makeNegativeXJaggy((LevelAccessor)world, pos, rand.nextInt(3), 3, 1);
        this.makeNegativeXJaggy((LevelAccessor)world, pos, rand.nextInt(3), 1, 2);
        this.makeNegativeXJaggy((LevelAccessor)world, pos, rand.nextInt(3), 2, 2);
        this.makePositiveXJaggy((LevelAccessor)world, pos, rand.nextInt(3), 0, 0);
        this.makePositiveXJaggy((LevelAccessor)world, pos, rand.nextInt(3), 3, 0);
        this.makePositiveXJaggy((LevelAccessor)world, pos, rand.nextInt(3), 0, 1);
        this.makePositiveXJaggy((LevelAccessor)world, pos, rand.nextInt(3), 3, 1);
        this.makePositiveXJaggy((LevelAccessor)world, pos, rand.nextInt(3), 1, 2);
        this.makePositiveXJaggy((LevelAccessor)world, pos, rand.nextInt(3), 2, 2);
        for (int dx = 0; dx < 4; ++dx) {
            if (rand.nextBoolean()) {
                world.m_7731_(pos.m_142082_(dx + 3, -1, 1), this.oakLogWithXAxis, 3);
                if (rand.nextBoolean()) {
                    world.m_7731_(pos.m_142082_(dx + 3, 0, 1), this.mossPatch, 3);
                    this.m_159739_(world, pos.m_142082_(dx + 3, -1, 1));
                }
            }
            else {
                world.m_7731_(pos.m_142082_(dx + 3, -1, 1), this.grass, 3);
                world.m_7731_(pos.m_142082_(dx + 3, 0, 1), this.mossPatch, 3);
                this.m_159739_(world, pos.m_142082_(dx + 3, -1, 1));
            }
            if (rand.nextBoolean()) {
                world.m_7731_(pos.m_142082_(dx + 3, -1, 2), this.oakLogWithXAxis, 3);
                if (rand.nextBoolean()) {
                    world.m_7731_(pos.m_142082_(dx + 3, 0, 2), this.mossPatch, 3);
                    this.m_159739_(world, pos.m_142082_(dx + 3, -1, 2));
                }
            }
            else {
                world.m_7731_(pos.m_142082_(dx + 3, -1, 2), this.grass, 3);
                world.m_7731_(pos.m_142082_(dx + 3, 0, 2), this.mossPatch, 3);
                this.m_159739_(world, pos.m_142082_(dx + 3, -1, 2));
            }
            world.m_7731_(pos.m_142082_(dx + 3, 0, 0), this.oakLogWithXAxis, 3);
            world.m_7731_(pos.m_142082_(dx + 3, 0, 3), this.oakLogWithXAxis, 3);
            world.m_7731_(pos.m_142082_(dx + 3, 1, 0), this.oakLogWithXAxis, 3);
            world.m_7731_(pos.m_142082_(dx + 3, 1, 3), this.oakLogWithXAxis, 3);
            world.m_7731_(pos.m_142082_(dx + 3, 2, 1), this.oakLogWithXAxis, 3);
            world.m_7731_(pos.m_142082_(dx + 3, 2, 2), this.oakLogWithXAxis, 3);
            if (rand.nextBoolean()) {
                world.m_7731_(pos.m_142082_(dx + 3, 3, 1), this.mossPatch, 3);
                this.m_159739_(world, pos.m_142082_(dx + 3, 2, 1));
            }
            if (rand.nextBoolean()) {
                world.m_7731_(pos.m_142082_(dx + 3, 3, 2), this.mossPatch, 3);
                this.m_159739_(world, pos.m_142082_(dx + 3, 2, 2));
            }
        }
        final int offX = rand.nextInt(3) + 2;
        final boolean plusZ = rand.nextBoolean();
        for (int dx2 = 0; dx2 < 3; ++dx2) {
            if (rand.nextBoolean()) {
                world.m_7731_(pos.m_142082_(dx2 + offX, 2, plusZ ? 3 : 0), this.oakLeaves, 3);
                if (rand.nextBoolean()) {
                    world.m_7731_(pos.m_142082_(dx2 + offX, 3, plusZ ? 3 : 0), this.oakLeaves, 3);
                }
                if (rand.nextBoolean()) {
                    world.m_7731_(pos.m_142082_(dx2 + offX, 2, plusZ ? 4 : -1), this.oakLeaves, 3);
                }
            }
        }
        world.m_7731_(pos.m_142082_(rand.nextInt(4) + 3, 2, plusZ ? 0 : 3), this.firefly, 3);
        return true;
    }
    
    private void makeNegativeXJaggy(final LevelAccessor world, final BlockPos pos, final int length, final int dz, final int dy) {
        for (int dx = -length; dx < 0; ++dx) {
            world.m_7731_(pos.m_142082_(dx + 3, dy, dz), this.oakLogWithXAxis, 3);
        }
    }
    
    private void makePositiveXJaggy(final LevelAccessor world, final BlockPos pos, final int length, final int dz, final int dy) {
        for (int dx = 0; dx < length; ++dx) {
            world.m_7731_(pos.m_142082_(dx + 7, dy, dz), this.oakLogWithXAxis, 3);
        }
    }
}
