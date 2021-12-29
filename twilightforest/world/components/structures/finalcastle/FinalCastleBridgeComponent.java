// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.finalcastle;

import net.minecraft.util.Mth;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.RotatedPillarBlock;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
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

public class FinalCastleBridgeComponent extends TFStructureComponentOld
{
    public FinalCastleBridgeComponent(final ServerLevel level, final CompoundTag nbt) {
        super(FinalCastlePieces.TFFCBri, nbt);
    }
    
    public FinalCastleBridgeComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final int length, final Direction direction) {
        super(FinalCastlePieces.TFFCBri, feature, i, x, y, z);
        this.m_73519_(direction);
        this.f_73383_ = TFStructureComponentOld.getComponentToAddBoundingBox2(x, y, z, 0, -1, -3, length - 1, 5, 6, direction);
    }
    
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final int length = (this.m_73549_() == Direction.SOUTH || this.m_73549_() == Direction.NORTH) ? (this.f_73383_.m_162399_() - this.f_73383_.m_162395_()) : (this.f_73383_.m_162401_() - this.f_73383_.m_162398_());
        this.m_73464_(world, sbb, 0, 0, 0, length, 1, 6, false, rand, this.deco.randomBlocks);
        final BlockState castlePillar = (BlockState)((Block)TFBlocks.BOLD_CASTLE_BRICK_PILLAR.get()).m_49966_().m_61124_((Property)RotatedPillarBlock.f_55923_, (Comparable)Direction.Axis.X);
        this.m_73441_(world, sbb, 0, 2, 0, length, 2, 0, castlePillar, castlePillar, false);
        this.m_73441_(world, sbb, 0, 2, 6, length, 2, 6, castlePillar, castlePillar, false);
        for (int l3 = length / 3, i = 0; i < l3; ++i) {
            final int sl = l3 - (int)(Mth.m_14089_((l3 - i) / (float)l3 * 1.6f) * l3);
            this.m_73464_(world, sbb, i, -sl, 0, i, 0, 0, false, rand, this.deco.randomBlocks);
            this.m_73464_(world, sbb, i, -sl, 6, i, 0, 6, false, rand, this.deco.randomBlocks);
            this.m_73464_(world, sbb, length - i, -sl, 0, length - i, 0, 0, false, rand, this.deco.randomBlocks);
            this.m_73464_(world, sbb, length - i, -sl, 6, length - i, 0, 6, false, rand, this.deco.randomBlocks);
        }
        this.m_73441_(world, sbb, 0, 2, 1, 0, 7, 1, this.deco.pillarState, this.deco.pillarState, false);
        this.m_73441_(world, sbb, 0, 2, 5, 0, 7, 5, this.deco.pillarState, this.deco.pillarState, false);
        this.m_73441_(world, sbb, 0, 6, 2, 0, 6, 4, this.deco.accentState, this.deco.accentState, false);
        this.m_73434_(world, this.deco.pillarState, 0, 7, 3, sbb);
        this.m_73441_(world, sbb, length, 2, 1, length, 7, 1, this.deco.pillarState, this.deco.pillarState, false);
        this.m_73441_(world, sbb, length, 2, 5, length, 7, 5, this.deco.pillarState, this.deco.pillarState, false);
        this.m_73441_(world, sbb, length, 6, 2, length, 6, 4, this.deco.accentState, this.deco.accentState, false);
        this.m_73434_(world, this.deco.pillarState, length, 7, 3, sbb);
        return true;
    }
}
