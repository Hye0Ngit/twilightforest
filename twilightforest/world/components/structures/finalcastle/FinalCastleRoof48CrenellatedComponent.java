// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.finalcastle;

import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import twilightforest.util.RotationUtil;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import twilightforest.world.components.structures.TFStructureComponentOld;

public class FinalCastleRoof48CrenellatedComponent extends TFStructureComponentOld
{
    public FinalCastleRoof48CrenellatedComponent(final ServerLevel level, final CompoundTag nbt) {
        super(FinalCastlePieces.TFFCRo48Cr, nbt);
    }
    
    public FinalCastleRoof48CrenellatedComponent(final TFFeature feature, final int i, final TFStructureComponentOld keep, final int x, final int y, final int z) {
        super(FinalCastlePieces.TFFCRo48Cr, feature, i, x, y, z);
        final int height = 5;
        this.m_73519_(keep.m_73549_());
        this.f_73383_ = new BoundingBox(keep.m_73547_().m_162395_() - 2, keep.m_73547_().m_162400_() - 1, keep.m_73547_().m_162398_() - 2, keep.m_73547_().m_162399_() + 2, keep.m_73547_().m_162400_() + height - 1, keep.m_73547_().m_162401_() + 2);
    }
    
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random randomIn, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final BlockState castleMagic = ((Block)TFBlocks.VIOLET_CASTLE_RUNE_BRICK.get()).m_49966_();
        this.m_73441_(world, sbb, 2, 2, 2, 50, 2, 50, castleMagic, castleMagic, false);
        for (final Rotation rotation : RotationUtil.ROTATIONS) {
            this.fillBlocksRotated(world, sbb, 3, 1, 1, 45, 3, 1, this.deco.blockState, rotation);
            for (int i = 10; i < 41; i += 5) {
                this.fillBlocksRotated(world, sbb, i, 1, 0, i + 2, 5, 2, this.deco.blockState, rotation);
                this.setBlockStateRotated(world, this.deco.blockState, i + 1, 0, 1, rotation, sbb);
            }
        }
        return true;
    }
}
