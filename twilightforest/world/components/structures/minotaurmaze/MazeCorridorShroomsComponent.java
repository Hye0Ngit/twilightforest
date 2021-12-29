// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.minotaurmaze;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import java.util.Random;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.core.Direction;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class MazeCorridorShroomsComponent extends MazeCorridorComponent
{
    public MazeCorridorShroomsComponent(final ServerLevel level, final CompoundTag nbt) {
        super(MinotaurMazePieces.TFMMCS, nbt);
    }
    
    public MazeCorridorShroomsComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final Direction rotation) {
        super(MinotaurMazePieces.TFMMCS, feature, i, x, y, z, rotation);
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        for (int x = 1; x < 5; ++x) {
            for (int z = 0; z < 5; ++z) {
                if (rand.nextInt(2) > 0) {
                    this.m_73434_(world, Blocks.f_50195_.m_49966_(), x, 0, z, sbb);
                }
                if (rand.nextInt(2) > 0) {
                    this.m_73434_(world, rand.nextBoolean() ? Blocks.f_50073_.m_49966_() : Blocks.f_50072_.m_49966_(), x, 1, z, sbb);
                }
            }
        }
        final boolean mushFlag = rand.nextBoolean();
        BlockState mushType = (mushFlag ? Blocks.f_50181_ : Blocks.f_50180_).m_49966_();
        final BlockState fullStem = Blocks.f_50182_.m_49966_();
        final BlockState stem = (BlockState)((BlockState)fullStem.m_61124_((Property)HugeMushroomBlock.f_54131_, (Comparable)false)).m_61124_((Property)HugeMushroomBlock.f_54132_, (Comparable)false);
        int mushY = rand.nextInt(4) + 1;
        int mushZ = rand.nextInt(4) + 1;
        this.m_73434_(world, fullStem, 1, mushY - 1, mushZ, sbb);
        this.m_73441_(world, sbb, 1, 1, mushZ, 1, mushY, mushZ, stem, MazeCorridorShroomsComponent.AIR, false);
        this.m_73441_(world, sbb, 1, mushY, mushZ - 1, 2, mushY, mushZ + 1, mushType, MazeCorridorShroomsComponent.AIR, false);
        mushType = (mushFlag ? Blocks.f_50180_ : Blocks.f_50181_).m_49966_();
        mushY = rand.nextInt(4) + 1;
        mushZ = rand.nextInt(4) + 1;
        this.m_73441_(world, sbb, 4, 1, mushZ, 4, mushY, mushZ, stem, MazeCorridorShroomsComponent.AIR, false);
        this.m_73441_(world, sbb, 3, mushY, mushZ - 1, 4, mushY, mushZ + 1, mushType, MazeCorridorShroomsComponent.AIR, false);
        return true;
    }
}
