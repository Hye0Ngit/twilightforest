// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.icetower;

import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.WorldGenLevel;
import java.util.Random;
import net.minecraft.core.Direction;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class IceTowerBossWingComponent extends IceTowerWingComponent
{
    public IceTowerBossWingComponent(final ServerLevel level, final CompoundTag nbt) {
        super(IceTowerPieces.TFITBoss, nbt);
        this.spawnListIndex = -1;
    }
    
    public IceTowerBossWingComponent(final TFFeature feature, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final Direction direction) {
        super(IceTowerPieces.TFITBoss, feature, index, x, y, z, wingSize, wingHeight, direction);
        this.spawnListIndex = -1;
    }
    
    @Override
    protected boolean shouldHaveBase(final Random rand) {
        return false;
    }
    
    @Override
    protected void placeFloor(final WorldGenLevel world, final Random rand, final BoundingBox sbb, final int floorHeight, final int floor) {
        for (int x = 1; x < this.size - 1; ++x) {
            for (int z = 1; z < this.size - 1; ++z) {
                final BlockState ice = ((rand.nextInt(4) == 0) ? Blocks.f_50126_ : Blocks.f_50354_).m_49966_();
                for (int thickness = 1 + rand.nextInt(2) + rand.nextInt(2) + rand.nextInt(2), y = 0; y < thickness; ++y) {
                    this.m_73434_(world, ice, x, floor * floorHeight + floorHeight - y, z, sbb);
                }
            }
        }
    }
    
    @Override
    protected void decorateFloor(final WorldGenLevel world, final Random rand, final int floor, final int bottom, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final BoundingBox sbb) {
        Rotation r = ladderDownDir;
        for (int y = 0; y < 3; ++y) {
            this.placeIceStairs(world, sbb, rand, bottom + y * 3, r);
            this.placeIceStairs(world, sbb, rand, bottom + y * 3, r.m_55952_(Rotation.CLOCKWISE_180));
            r = r.m_55952_(Rotation.CLOCKWISE_90);
        }
    }
    
    private void placeIceStairs(final WorldGenLevel world, final BoundingBox sbb, final Random rand, final int y, final Rotation rotation) {
        final BlockState packedIce = Blocks.f_50354_.m_49966_();
        this.fillBlocksRotated(world, sbb, 8, y + 1, 1, 10, y + 1, 3, packedIce, rotation);
        if (y > 1) {
            this.randomlyFillBlocksRotated(world, sbb, rand, 0.5f, 8, y, 1, 10, y, 3, packedIce, IceTowerBossWingComponent.AIR, rotation);
        }
        this.fillBlocksRotated(world, sbb, 11, y + 2, 1, 13, y + 2, 3, packedIce, rotation);
        this.randomlyFillBlocksRotated(world, sbb, rand, 0.5f, 11, y + 1, 1, 13, y + 1, 3, packedIce, IceTowerBossWingComponent.AIR, rotation);
        this.fillBlocksRotated(world, sbb, 11, y + 3, 4, 13, y + 3, 6, packedIce, rotation);
        this.randomlyFillBlocksRotated(world, sbb, rand, 0.5f, 11, y + 2, 4, 13, y + 2, 6, packedIce, IceTowerBossWingComponent.AIR, rotation);
    }
    
    @Override
    protected void decorateTopFloor(final WorldGenLevel world, final Random rand, final int floor, final int bottom, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final BoundingBox sbb) {
        for (int x = 1; x < this.size - 1; ++x) {
            for (int z = 1; z < this.size - 1; ++z) {
                final BlockState ice = ((rand.nextInt(10) == 0) ? Blocks.f_50141_ : Blocks.f_50354_).m_49966_();
                for (int thickness = rand.nextInt(2) + rand.nextInt(2), y = 0; y < thickness; ++y) {
                    this.m_73434_(world, ice, x, top - 1 - y, z, sbb);
                }
            }
        }
        final BlockState snowQueenSpawner = ((Block)TFBlocks.SNOW_QUEEN_BOSS_SPAWNER.get()).m_49966_();
        this.setBlockStateRotated(world, snowQueenSpawner, 7, top - 6, 7, Rotation.NONE, sbb);
        this.m_73535_(world, sbb, 5, top - 3, 5, 9, top - 1, 9);
    }
}
