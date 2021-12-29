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

public class FinalCastleFoundation48Component extends TFStructureComponentOld
{
    public FinalCastleFoundation48Component(final ServerLevel level, final CompoundTag nbt) {
        super(FinalCastlePieces.TFFCToF48, nbt);
    }
    
    public FinalCastleFoundation48Component(final TFFeature feature, final Random rand, final int i, final TFStructureComponentOld sideTower, final int x, final int y, final int z) {
        super(FinalCastlePieces.TFFCToF48, feature, i, x, y, z);
        this.m_73519_(sideTower.m_73549_());
        this.f_73383_ = new BoundingBox(sideTower.m_73547_().m_162395_(), sideTower.m_73547_().m_162396_(), sideTower.m_73547_().m_162398_(), sideTower.m_73547_().m_162399_(), sideTower.m_73547_().m_162400_() - 1, sideTower.m_73547_().m_162401_());
    }
    
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random randomIn, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        for (int x = 4; x < 45; ++x) {
            for (int z = 4; z < 45; ++z) {
                this.m_73528_(world, this.deco.blockState, x, -1, z, sbb);
            }
        }
        final int mid = 16;
        for (final Rotation rotation : RotationUtil.ROTATIONS) {
            this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 3, -2, 3, rotation, sbb);
            this.fillBlocksRotated(world, sbb, 2, -2, 1, 46, -1, 1, this.deco.blockState, rotation);
            this.fillBlocksRotated(world, sbb, 2, -4, 2, 45, -1, 2, this.deco.blockState, rotation);
            this.fillBlocksRotated(world, sbb, 4, -6, 3, 44, -1, 3, this.deco.blockState, rotation);
            for (int i = 9; i < 45; i += 6) {
                this.makePiling(world, sbb, mid, rotation, i);
            }
            this.makePiling(world, sbb, mid, rotation, 4);
            this.makePiling(world, sbb, mid, rotation, 44);
        }
        this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 21, -2, 0, Rotation.CLOCKWISE_90, sbb);
        this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 21, -4, 1, Rotation.CLOCKWISE_90, sbb);
        this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 21, -6, 2, Rotation.CLOCKWISE_90, sbb);
        this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 27, -2, 0, Rotation.CLOCKWISE_90, sbb);
        this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 27, -4, 1, Rotation.CLOCKWISE_90, sbb);
        this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 27, -6, 2, Rotation.CLOCKWISE_90, sbb);
        return true;
    }
    
    private void makePiling(final WorldGenLevel world, final BoundingBox sbb, final int mid, final Rotation rotation, final int i) {
        this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, i, -7, 3, rotation, sbb);
        this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, i, -mid, 2, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.blockState, i, -1, 0, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.blockState, i, -3, 1, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.blockState, i, -5, 2, rotation, sbb);
    }
}
