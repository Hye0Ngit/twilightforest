// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.finalcastle;

import twilightforest.util.RotationUtil;
import net.minecraft.world.level.block.Rotation;
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

public class FinalCastleRoof13PeakedComponent extends TFStructureComponentOld
{
    public FinalCastleRoof13PeakedComponent(final ServerLevel level, final CompoundTag nbt) {
        super(FinalCastlePieces.TFFCRo13Pk, nbt);
    }
    
    public FinalCastleRoof13PeakedComponent(final TFFeature feature, final Random rand, final int i, final TFStructureComponentOld sideTower, final int x, final int y, final int z) {
        super(FinalCastlePieces.TFFCRo13Pk, feature, i, x, y, z);
        final int height = 18;
        this.m_73519_(sideTower.m_73549_());
        this.f_73383_ = new BoundingBox(sideTower.m_73547_().m_162395_() - 2, sideTower.m_73547_().m_162400_() - 1, sideTower.m_73547_().m_162398_() - 2, sideTower.m_73547_().m_162399_() + 2, sideTower.m_73547_().m_162400_() + height - 1, sideTower.m_73547_().m_162401_() + 2);
    }
    
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random randomIn, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        for (int i = 0; i < 3; ++i) {
            this.m_73441_(world, sbb, 1, i, i, 15, i, i, this.deco.roofState, this.deco.roofState, false);
            this.m_73441_(world, sbb, 1, i, 16 - i, 15, i, 16 - i, this.deco.roofState, this.deco.roofState, false);
        }
        for (int i = 0; i < 3; ++i) {
            int dz = 3 + i;
            this.m_73441_(world, sbb, 2, 5 + (i - 1) * 2, dz, 14, 4 + i * 2, dz, this.deco.roofState, this.deco.roofState, false);
            this.m_73441_(world, sbb, 1, 1, dz, 1, 5 + (i - 1) * 2, dz, this.deco.roofState, this.deco.roofState, false);
            this.m_73441_(world, sbb, 1, 5 + (i - 1) * 2, dz - 1, 1, 4 + i * 2, dz, this.deco.blockState, this.deco.blockState, false);
            this.m_73441_(world, sbb, 15, 1, dz, 15, 5 + (i - 1) * 2, dz, this.deco.roofState, this.deco.roofState, false);
            this.m_73441_(world, sbb, 15, 5 + (i - 1) * 2, dz - 1, 15, 4 + i * 2, dz, this.deco.blockState, this.deco.blockState, false);
            dz = 13 - i;
            this.m_73441_(world, sbb, 2, 5 + (i - 1) * 2, dz, 14, 4 + i * 2, dz, this.deco.roofState, this.deco.roofState, false);
            this.m_73441_(world, sbb, 1, 1, dz, 1, 5 + (i - 1) * 2, dz, this.deco.roofState, this.deco.roofState, false);
            this.m_73441_(world, sbb, 1, 5 + (i - 1) * 2, dz, 1, 4 + i * 2, dz + 1, this.deco.blockState, this.deco.blockState, false);
            this.m_73441_(world, sbb, 15, 1, dz, 15, 5 + (i - 1) * 2, dz, this.deco.roofState, this.deco.roofState, false);
            this.m_73441_(world, sbb, 15, 5 + (i - 1) * 2, dz, 15, 4 + i * 2, dz + 1, this.deco.blockState, this.deco.blockState, false);
        }
        for (int i = 0; i < 3; ++i) {
            int dz = 6 + i;
            this.m_73441_(world, sbb, 2, 12 + (i - 1) * 3, dz, 14, 11 + i * 3, dz, this.deco.roofState, this.deco.roofState, false);
            this.m_73441_(world, sbb, 1, 1, dz, 1, 12 + (i - 1) * 3, dz, this.deco.roofState, this.deco.roofState, false);
            this.m_73441_(world, sbb, 1, 12 + (i - 1) * 3, dz - 1, 1, 11 + i * 3, dz, this.deco.blockState, this.deco.blockState, false);
            this.m_73441_(world, sbb, 15, 1, dz, 15, 12 + (i - 1) * 3, dz, this.deco.roofState, this.deco.roofState, false);
            this.m_73441_(world, sbb, 15, 12 + (i - 1) * 3, dz - 1, 15, 11 + i * 3, dz, this.deco.blockState, this.deco.blockState, false);
            dz = 10 - i;
            this.m_73441_(world, sbb, 2, 12 + (i - 1) * 3, dz, 14, 11 + i * 3, dz, this.deco.roofState, this.deco.roofState, false);
            this.m_73441_(world, sbb, 1, 1, dz, 1, 12 + (i - 1) * 3, dz, this.deco.roofState, this.deco.roofState, false);
            this.m_73441_(world, sbb, 1, 12 + (i - 1) * 3, dz, 1, 11 + i * 3, dz + 1, this.deco.blockState, this.deco.blockState, false);
            this.m_73441_(world, sbb, 15, 1, dz, 15, 12 + (i - 1) * 3, dz, this.deco.roofState, this.deco.roofState, false);
            this.m_73441_(world, sbb, 15, 12 + (i - 1) * 3, dz, 15, 11 + i * 3, dz + 1, this.deco.blockState, this.deco.blockState, false);
        }
        this.m_73441_(world, sbb, 1, 18, 8, 5, 18, 8, this.deco.roofState, this.deco.roofState, false);
        this.m_73441_(world, sbb, 11, 18, 8, 14, 18, 8, this.deco.roofState, this.deco.roofState, false);
        this.m_73441_(world, sbb, 0, 17, 8, 1, 19, 8, this.deco.roofState, this.deco.roofState, false);
        this.m_73441_(world, sbb, 15, 17, 8, 16, 19, 8, this.deco.roofState, this.deco.roofState, false);
        for (final Rotation rotation : new Rotation[] { Rotation.CLOCKWISE_90, Rotation.COUNTERCLOCKWISE_90 }) {
            this.fillBlocksRotated(world, sbb, 4, 0, 1, 12, 1, 1, this.deco.blockState, rotation);
            for (int j = 3; j < 13; j += 2) {
                this.fillBlocksRotated(world, sbb, j, -1, 1, j, 2, 1, this.deco.blockState, rotation);
            }
        }
        for (final Rotation rotation : RotationUtil.ROTATIONS) {
            this.fillBlocksRotated(world, sbb, 0, -1, 0, 3, 2, 3, this.deco.blockState, rotation);
            this.setBlockStateRotated(world, this.deco.blockState, 1, -2, 2, rotation, sbb);
            this.setBlockStateRotated(world, this.deco.blockState, 1, -2, 1, rotation, sbb);
            this.setBlockStateRotated(world, this.deco.blockState, 2, -2, 1, rotation, sbb);
        }
        return true;
    }
}
