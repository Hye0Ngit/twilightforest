// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.finalcastle;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.core.Direction;
import java.util.Random;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class FinalCastleDungeonEntranceComponent extends FinalCastleDungeonRoom31Component
{
    public boolean hasExit;
    
    public FinalCastleDungeonEntranceComponent(final ServerLevel level, final CompoundTag nbt) {
        super(FinalCastlePieces.TFFCDunEn, nbt);
        this.hasExit = false;
    }
    
    public FinalCastleDungeonEntranceComponent(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final Direction direction, final int level) {
        super(FinalCastlePieces.TFFCDunEn, feature, rand, i, x, y, z, direction, level);
        this.hasExit = false;
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        this.deco = new StructureTFDecoratorCastle();
        this.deco.blockState = ((Block)TFBlocks.YELLOW_CASTLE_RUNE_BRICK.get()).m_49966_();
        this.deco.fenceState = ((Block)TFBlocks.PINK_FORCE_FIELD.get()).m_49966_();
        super.m_142537_(this, list, rand);
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        if (!super.m_7832_(world, manager, generator, rand, sbb, chunkPosIn, blockPos)) {
            return false;
        }
        final BlockState stairs = (BlockState)this.deco.stairState.m_61124_((Property)StairBlock.f_56841_, (Comparable)Direction.SOUTH);
        final BlockState deadRock = ((Block)TFBlocks.DEADROCK.get()).m_49966_();
        for (int y = 0; y <= this.height; ++y) {
            final int x = this.size / 2 - 2;
            final int z = this.size / 2 - y + 2;
            this.m_73441_(world, sbb, x, 0, z, x + 4, y - 1, z, deadRock, deadRock, false);
            this.m_73441_(world, sbb, x, y, z, x + 4, y, z, stairs, stairs, false);
            this.m_73535_(world, sbb, x, y + 1, z, x + 4, y + 6, z);
        }
        final BlockState castleDoor = ((Block)TFBlocks.PINK_CASTLE_DOOR.get()).m_49966_();
        this.m_73441_(world, sbb, 23, 0, 12, 23, 3, 14, castleDoor, FinalCastleDungeonEntranceComponent.AIR, false);
        this.m_73441_(world, sbb, 23, 4, 12, 23, 4, 14, this.deco.blockState, this.deco.blockState, false);
        return true;
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
