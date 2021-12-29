// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.finalcastle;

import net.minecraft.core.Vec3i;
import twilightforest.util.BoundingBoxUtils;
import net.minecraft.world.level.block.state.BlockState;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Rotation;
import twilightforest.world.components.structures.TFStructureComponentOld;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.core.Direction;
import java.util.Random;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class FinalCastleDungeonExitComponent extends FinalCastleDungeonRoom31Component
{
    public FinalCastleDungeonExitComponent(final ServerLevel level, final CompoundTag nbt) {
        super(FinalCastlePieces.TFFCDunEx, nbt);
    }
    
    public FinalCastleDungeonExitComponent(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final Direction direction, final int level) {
        super(FinalCastlePieces.TFFCDunEx, feature, rand, i, x, y, z, direction, level);
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        if (parent instanceof final TFStructureComponentOld tfStructureComponentOld) {
            this.deco = tfStructureComponentOld.deco;
        }
        final Rotation bestDir = this.findStairDirectionTowards(parent.m_73547_().m_162395_(), parent.m_73547_().m_162398_());
        final FinalCastleDungeonStepsComponent steps0 = new FinalCastleDungeonStepsComponent(this.getFeatureType(), rand, 5, this.f_73383_.m_162398_() + 15, this.f_73383_.m_162396_(), this.f_73383_.m_162398_() + 15, bestDir.m_55954_(Direction.SOUTH));
        list.m_142679_((StructurePiece)steps0);
        steps0.m_142537_(this, list, rand);
        if (this.level == 1) {
            steps0.buildLevelUnder(parent, list, rand, this.level + 1);
        }
        else {
            steps0.buildBossRoomUnder(parent, list, rand);
        }
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        if (!super.m_7832_(world, manager, generator, rand, sbb, chunkPosIn, blockPos)) {
            return false;
        }
        final BlockState castleDoor = ((Block)TFBlocks.PINK_CASTLE_DOOR.get()).m_49966_();
        this.m_73441_(world, sbb, 7, 0, 16, 7, 3, 18, castleDoor, FinalCastleDungeonExitComponent.AIR, false);
        this.m_73441_(world, sbb, 7, 4, 16, 7, 4, 18, this.deco.blockState, this.deco.blockState, false);
        return true;
    }
    
    public Rotation findStairDirectionTowards(final int x, final int z) {
        final Vec3i center = BoundingBoxUtils.getCenter(this.f_73383_);
        final int dx = center.m_123341_() - x;
        final int dz = center.m_123343_() - z;
        Rotation absoluteDir;
        if (Math.abs(dz) >= Math.abs(dx)) {
            absoluteDir = ((dz >= 0) ? Rotation.CLOCKWISE_180 : Rotation.NONE);
        }
        else {
            absoluteDir = ((dx >= 0) ? Rotation.COUNTERCLOCKWISE_90 : Rotation.CLOCKWISE_90);
        }
        return absoluteDir;
    }
    
    @Override
    protected BlockState getForceFieldColor(final Random decoRNG) {
        return ((Block)TFBlocks.PINK_FORCE_FIELD.get()).m_49966_();
    }
    
    @Override
    protected BlockState getRuneColor(final BlockState fieldColor) {
        return ((Block)TFBlocks.PINK_CASTLE_RUNE_BRICK.get()).m_49966_();
    }
}
