// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.icetower;

import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import twilightforest.world.components.structures.TFStructureComponentOld;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.core.Direction;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import twilightforest.world.components.structures.lichtower.TowerWingComponent;

public class IceTowerStairsComponent extends TowerWingComponent
{
    public IceTowerStairsComponent(final ServerLevel level, final CompoundTag nbt) {
        super(IceTowerPieces.TFITSt, nbt);
    }
    
    public IceTowerStairsComponent(final TFFeature feature, final int index, final int x, final int y, final int z, final int size, final int height, final Direction direction) {
        super(IceTowerPieces.TFITSt, feature, index, x, y, z, size, height, direction);
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        for (int x = 1; x < this.size; ++x) {
            this.placeStairs(world, sbb, x, 1 - x, 5);
            for (int z = 0; z <= x; ++z) {
                if (z > 0 && z <= this.size / 2) {
                    this.placeStairs(world, sbb, x, 1 - x, 5 - z);
                    this.placeStairs(world, sbb, x, 1 - x, 5 + z);
                }
                if (x <= this.size / 2) {
                    this.placeStairs(world, sbb, z, 1 - x, 5 - x);
                    this.placeStairs(world, sbb, z, 1 - x, 5 + x);
                }
            }
        }
        this.m_73434_(world, this.deco.blockState, 0, 0, 5, sbb);
        return true;
    }
    
    private void placeStairs(final WorldGenLevel world, final BoundingBox sbb, final int x, final int y, final int z) {
        if (this.m_73398_((BlockGetter)world, x, y, z, sbb).m_60767_().m_76336_()) {
            this.m_73434_(world, this.deco.blockState, x, y, z, sbb);
            this.m_73434_(world, this.deco.blockState, x, y - 1, z, sbb);
        }
    }
}
