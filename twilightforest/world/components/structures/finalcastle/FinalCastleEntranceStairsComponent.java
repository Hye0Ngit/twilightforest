// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.finalcastle;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.core.Direction;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import twilightforest.world.components.structures.TFStructureComponentOld;

public class FinalCastleEntranceStairsComponent extends TFStructureComponentOld
{
    public FinalCastleEntranceStairsComponent(final ServerLevel level, final CompoundTag nbt) {
        super(FinalCastlePieces.TFFCEnSt, nbt);
    }
    
    public FinalCastleEntranceStairsComponent(final TFFeature feature, final int index, final int x, final int y, final int z, final Direction direction) {
        super(FinalCastlePieces.TFFCEnSt, feature, index, x, y, z);
        this.m_73519_(direction);
        this.f_73383_ = TFStructureComponentOld.getComponentToAddBoundingBox2(x, y, z, 0, -1, -5, 12, 0, 12, direction);
    }
    
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random randomIn, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        for (int size = 13, x = 1; x < size; ++x) {
            this.placeStairs(world, sbb, x, 1 - x, 5, Direction.EAST);
            for (int z = 0; z <= x; ++z) {
                if (z > 0 && z <= size / 2) {
                    this.placeStairs(world, sbb, x, 1 - x, 5 - z, Direction.EAST);
                    this.placeStairs(world, sbb, x, 1 - x, 5 + z, Direction.EAST);
                }
                if (x <= size / 2) {
                    this.placeStairs(world, sbb, z, 1 - x, 5 - x, Direction.NORTH);
                    this.placeStairs(world, sbb, z, 1 - x, 5 + x, Direction.SOUTH);
                }
            }
        }
        this.m_73528_(world, this.deco.blockState, 0, 0, 5, sbb);
        return true;
    }
    
    private void placeStairs(final WorldGenLevel world, final BoundingBox sbb, final int x, final int y, final int z, final Direction facing) {
        if (this.m_73398_((BlockGetter)world, x, y, z, sbb).m_60767_().m_76336_()) {
            this.m_73434_(world, (BlockState)this.deco.stairState.m_61124_((Property)StairBlock.f_56841_, (Comparable)facing), x, y, z, sbb);
            this.m_73528_(world, this.deco.blockState, x, y - 1, z, sbb);
        }
    }
}
