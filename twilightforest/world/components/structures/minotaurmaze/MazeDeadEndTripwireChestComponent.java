// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.minotaurmaze;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.TntBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
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

public class MazeDeadEndTripwireChestComponent extends MazeDeadEndChestComponent
{
    public MazeDeadEndTripwireChestComponent(final ServerLevel level, final CompoundTag nbt) {
        super(MinotaurMazePieces.TFMMDETC, nbt);
    }
    
    public MazeDeadEndTripwireChestComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final Direction rotation) {
        super(MinotaurMazePieces.TFMMDETC, feature, i, x, y, z, rotation);
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        super.m_7832_(world, manager, generator, rand, sbb, chunkPosIn, blockPos);
        this.placeTripwire(world, 1, 1, 2, 3, Direction.EAST, sbb);
        final BlockState tnt = (BlockState)Blocks.f_50077_.m_49966_().m_61124_((Property)TntBlock.f_57419_, (Comparable)true);
        this.m_73434_(world, tnt, 0, 0, 2, sbb);
        this.m_73434_(world, MazeDeadEndTripwireChestComponent.AIR, 0, -1, 2, sbb);
        this.m_73434_(world, MazeDeadEndTripwireChestComponent.AIR, 1, -1, 2, sbb);
        this.m_73434_(world, tnt, 2, 0, 4, sbb);
        this.m_73434_(world, tnt, 3, 0, 4, sbb);
        this.m_73434_(world, tnt, 2, 0, 3, sbb);
        this.m_73434_(world, tnt, 3, 0, 3, sbb);
        return true;
    }
}
