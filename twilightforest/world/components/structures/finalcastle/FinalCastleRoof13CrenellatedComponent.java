// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.finalcastle;

import net.minecraft.world.level.block.Rotation;
import twilightforest.util.RotationUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import java.util.Random;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import twilightforest.world.components.structures.TFStructureComponentOld;

public class FinalCastleRoof13CrenellatedComponent extends TFStructureComponentOld
{
    public FinalCastleRoof13CrenellatedComponent(final ServerLevel level, final CompoundTag nbt) {
        super(FinalCastlePieces.TFFCRo13Cr, nbt);
    }
    
    public FinalCastleRoof13CrenellatedComponent(final TFFeature feature, final Random rand, final int i, final TFStructureComponentOld sideTower, final int x, final int y, final int z) {
        super(FinalCastlePieces.TFFCRo13Cr, feature, i, x, y, z);
        final int height = 5;
        this.m_73519_(sideTower.m_73549_());
        this.f_73383_ = new BoundingBox(sideTower.m_73547_().m_162395_() - 2, sideTower.m_73547_().m_162400_() - 1, sideTower.m_73547_().m_162398_() - 2, sideTower.m_73547_().m_162399_() + 2, sideTower.m_73547_().m_162400_() + height - 1, sideTower.m_73547_().m_162401_() + 2);
    }
    
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random randomIn, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final int size = this.f_73383_.m_162399_() - this.f_73383_.m_162395_();
        for (final Rotation rotation : RotationUtil.ROTATIONS) {
            this.fillBlocksRotated(world, sbb, 0, -1, 0, 3, 3, 3, this.deco.blockState, rotation);
            this.setBlockStateRotated(world, this.deco.blockState, 1, -2, 2, rotation, sbb);
            this.setBlockStateRotated(world, this.deco.blockState, 1, -2, 1, rotation, sbb);
            this.setBlockStateRotated(world, this.deco.blockState, 2, -2, 1, rotation, sbb);
            this.fillBlocksRotated(world, sbb, 4, 0, 1, size - 4, 1, 1, this.deco.blockState, rotation);
            for (int x = 5; x < size - 5; x += 4) {
                this.fillBlocksRotated(world, sbb, x, 0, 0, x + 2, 3, 2, this.deco.blockState, rotation);
                this.setBlockStateRotated(world, this.deco.blockState, x + 1, -1, 1, rotation, sbb);
                this.setBlockStateRotated(world, this.deco.blockState, x + 1, -2, 1, rotation, sbb);
            }
        }
        return true;
    }
}
