// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.minotaurmaze;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import twilightforest.util.HugeMushroomUtil;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.core.Direction;
import java.util.Random;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class MazeMushRoomComponent extends MazeRoomComponent
{
    public MazeMushRoomComponent(final ServerLevel level, final CompoundTag nbt) {
        super(MinotaurMazePieces.TFMMMR, nbt);
    }
    
    public MazeMushRoomComponent(final TFFeature feature, final int i, final Random rand, final int x, final int y, final int z) {
        super(MinotaurMazePieces.TFMMMR, feature, i, rand, x, y, z);
        this.m_73519_(Direction.SOUTH);
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        super.m_7832_(world, manager, generator, rand, sbb, chunkPosIn, blockPos);
        for (int x = 1; x < 14; ++x) {
            for (int z = 1; z < 14; ++z) {
                final int dist = (int)Math.round(7.0 / Math.sqrt((7.5 - x) * (7.5 - x) + (7.5 - z) * (7.5 - z)));
                if (rand.nextInt(dist + 1) > 0) {
                    this.m_73434_(world, Blocks.f_50195_.m_49966_(), x, 0, z, sbb);
                }
                if (rand.nextInt(dist) > 0) {
                    this.m_73434_(world, (rand.nextBoolean() ? Blocks.f_50073_ : Blocks.f_50072_).m_49966_(), x, 1, z, sbb);
                }
            }
        }
        final BlockState redMushroomBlock = Blocks.f_50181_.m_49966_();
        final BlockState brownMushroomBlock = Blocks.f_50180_.m_49966_();
        final BlockState stemMushroomBlock = Blocks.f_50182_.m_49966_();
        this.makeMediumMushroom(world, sbb, 5, 2, 9, redMushroomBlock);
        this.makeMediumMushroom(world, sbb, 5, 3, 9, redMushroomBlock);
        this.makeMediumMushroom(world, sbb, 9, 2, 5, redMushroomBlock);
        this.makeMediumMushroom(world, sbb, 6, 3, 4, brownMushroomBlock);
        this.makeMediumMushroom(world, sbb, 10, 1, 9, brownMushroomBlock);
        this.m_73434_(world, stemMushroomBlock, 1, 2, 1, sbb);
        this.m_73434_(world, HugeMushroomUtil.getState(HugeMushroomUtil.HugeMushroomType.CENTER, redMushroomBlock), 1, 3, 1, sbb);
        this.m_73434_(world, HugeMushroomUtil.getState(HugeMushroomUtil.HugeMushroomType.NORTH_WEST, redMushroomBlock), 2, 3, 1, sbb);
        this.m_73434_(world, HugeMushroomUtil.getState(HugeMushroomUtil.HugeMushroomType.NORTH_WEST, redMushroomBlock), 1, 3, 2, sbb);
        this.m_73434_(world, stemMushroomBlock, 14, 3, 1, sbb);
        this.m_73434_(world, HugeMushroomUtil.getState(HugeMushroomUtil.HugeMushroomType.CENTER, brownMushroomBlock), 14, 4, 1, sbb);
        this.m_73434_(world, HugeMushroomUtil.getState(HugeMushroomUtil.HugeMushroomType.NORTH_EAST, brownMushroomBlock), 13, 4, 1, sbb);
        this.m_73434_(world, HugeMushroomUtil.getState(HugeMushroomUtil.HugeMushroomType.NORTH_EAST, brownMushroomBlock), 14, 4, 2, sbb);
        this.m_73434_(world, stemMushroomBlock, 1, 1, 14, sbb);
        this.m_73434_(world, HugeMushroomUtil.getState(HugeMushroomUtil.HugeMushroomType.CENTER, brownMushroomBlock), 1, 2, 14, sbb);
        this.m_73434_(world, HugeMushroomUtil.getState(HugeMushroomUtil.HugeMushroomType.SOUTH_WEST, brownMushroomBlock), 2, 2, 14, sbb);
        this.m_73434_(world, HugeMushroomUtil.getState(HugeMushroomUtil.HugeMushroomType.SOUTH_WEST, brownMushroomBlock), 1, 2, 13, sbb);
        this.m_73434_(world, HugeMushroomUtil.getState(HugeMushroomUtil.HugeMushroomType.CENTER, brownMushroomBlock), 14, 1, 14, sbb);
        this.m_73434_(world, HugeMushroomUtil.getState(HugeMushroomUtil.HugeMushroomType.SOUTH_EAST, brownMushroomBlock), 13, 1, 14, sbb);
        this.m_73434_(world, HugeMushroomUtil.getState(HugeMushroomUtil.HugeMushroomType.SOUTH_EAST, brownMushroomBlock), 14, 1, 13, sbb);
        return true;
    }
    
    private void makeMediumMushroom(final WorldGenLevel world, final BoundingBox sbb, final int mx, final int my, final int mz, final BlockState redMushroomBlock) {
        final BlockState mushroomStem = (BlockState)((BlockState)Blocks.f_50182_.m_49966_().m_61124_((Property)HugeMushroomBlock.f_54132_, (Comparable)false)).m_61124_((Property)HugeMushroomBlock.f_54131_, (Comparable)false);
        this.m_73434_(world, HugeMushroomUtil.getState(HugeMushroomUtil.HugeMushroomType.CENTER, redMushroomBlock), mx, my, mz, sbb);
        this.m_73434_(world, HugeMushroomUtil.getState(HugeMushroomUtil.HugeMushroomType.WEST, redMushroomBlock), mx + 1, my, mz, sbb);
        this.m_73434_(world, HugeMushroomUtil.getState(HugeMushroomUtil.HugeMushroomType.NORTH_WEST, redMushroomBlock), mx + 1, my, mz + 1, sbb);
        this.m_73434_(world, HugeMushroomUtil.getState(HugeMushroomUtil.HugeMushroomType.NORTH, redMushroomBlock), mx, my, mz + 1, sbb);
        this.m_73434_(world, HugeMushroomUtil.getState(HugeMushroomUtil.HugeMushroomType.NORTH_EAST, redMushroomBlock), mx - 1, my, mz + 1, sbb);
        this.m_73434_(world, HugeMushroomUtil.getState(HugeMushroomUtil.HugeMushroomType.EAST, redMushroomBlock), mx - 1, my, mz, sbb);
        this.m_73434_(world, HugeMushroomUtil.getState(HugeMushroomUtil.HugeMushroomType.SOUTH_EAST, redMushroomBlock), mx - 1, my, mz - 1, sbb);
        this.m_73434_(world, HugeMushroomUtil.getState(HugeMushroomUtil.HugeMushroomType.SOUTH, redMushroomBlock), mx, my, mz - 1, sbb);
        this.m_73434_(world, HugeMushroomUtil.getState(HugeMushroomUtil.HugeMushroomType.SOUTH_WEST, redMushroomBlock), mx + 1, my, mz - 1, sbb);
        for (int y = 1; y < my; ++y) {
            this.m_73434_(world, mushroomStem, mx, y, mz, sbb);
        }
    }
}
