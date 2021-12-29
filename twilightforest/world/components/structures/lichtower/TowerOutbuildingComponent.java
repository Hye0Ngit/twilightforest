// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.lichtower;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Rotation;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.core.Direction;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class TowerOutbuildingComponent extends TowerWingComponent
{
    public TowerOutbuildingComponent(final ServerLevel level, final CompoundTag nbt) {
        super(LichTowerPieces.TFLTOut, nbt);
    }
    
    protected TowerOutbuildingComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final Direction direction) {
        super(LichTowerPieces.TFLTOut, feature, i, x, y, z, pSize, pHeight, direction);
    }
    
    @Override
    public void makeABeard(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
    }
    
    @Override
    public boolean makeTowerWing(final StructurePieceAccessor list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final Rotation direction) {
        return y > 7 && super.makeTowerWing(list, rand, index, x, y, z, wingSize, wingHeight, direction);
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final BlockState cobblestone = Blocks.f_50652_.m_49966_();
        for (int x = 0; x < this.size; ++x) {
            for (int z = 0; z < this.size; ++z) {
                this.m_73528_(world, cobblestone, x, -1, z, sbb);
            }
        }
        return super.m_7832_(world, manager, generator, rand, sbb, chunkPosIn, blockPos);
    }
}
