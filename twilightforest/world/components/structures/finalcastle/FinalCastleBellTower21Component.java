// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.finalcastle;

import net.minecraft.world.level.block.state.BlockState;
import twilightforest.util.RotationUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.block.Rotation;
import twilightforest.world.components.structures.TFStructureComponentOld;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.Direction;
import java.util.Random;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class FinalCastleBellTower21Component extends FinalCastleMazeTower13Component
{
    private static final int FLOORS = 8;
    
    public FinalCastleBellTower21Component(final ServerLevel level, final CompoundTag nbt) {
        super(FinalCastlePieces.TFFCBelTo, nbt);
    }
    
    public FinalCastleBellTower21Component(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final Direction direction) {
        super(FinalCastlePieces.TFFCBelTo, feature, rand, i, x, y, z, 8, 1, ((Block)TFBlocks.BLUE_CASTLE_RUNE_BRICK.get()).m_49966_(), direction);
        this.size = 21;
        final int floors = 8;
        this.height = floors * 8 + 1;
        this.f_73383_ = TFStructureComponentOld.getComponentToAddBoundingBox2(x, y, z, -6, -8, -this.size / 2, this.size - 1, this.height, this.size - 1, direction);
        this.openings.clear();
        this.addOpening(0, 9, this.size / 2, Rotation.CLOCKWISE_180);
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
        final FinalCastleBellFoundation21Component foundation = new FinalCastleBellFoundation21Component(this.getFeatureType(), rand, 4, this, this.m_142171_().m_123341_(), this.m_142171_().m_123342_(), this.m_142171_().m_123343_());
        list.m_142679_((StructurePiece)foundation);
        foundation.m_142537_(this, list, rand);
        final TFStructureComponentOld roof = new FinalCastleRoof13CrenellatedComponent(this.getFeatureType(), rand, 4, this, this.m_142171_().m_123341_(), this.m_142171_().m_123342_(), this.m_142171_().m_123343_());
        list.m_142679_((StructurePiece)roof);
        roof.m_142537_((StructurePiece)this, list, rand);
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        super.m_7832_(world, manager, generator, rand, sbb, chunkPosIn, blockPos);
        final BlockState fieldBlock = ((Block)TFBlocks.BLUE_FORCE_FIELD.get()).m_49966_();
        for (final Rotation rotation : RotationUtil.ROTATIONS) {
            int y = 48;
            for (int x = 5; x < this.size - 4; x += 2) {
                this.fillBlocksRotated(world, sbb, x, y, 0, x, y + 14, 0, fieldBlock, rotation);
            }
            y = 24;
            for (int x = 1; x < this.size - 1; x += 8) {
                this.fillBlocksRotated(world, sbb, x, y, 0, x, y + 14, 0, fieldBlock, rotation);
                this.fillBlocksRotated(world, sbb, x + 2, y, 0, x + 2, y + 14, 0, fieldBlock, rotation);
            }
        }
        this.placeSignAtCurrentPosition(world, 7, 9, 8, "Parkour area 2", "mini-boss 1", sbb);
        return true;
    }
}
