// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.minotaurmaze;

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

public class MazeRuinsComponent extends TFStructureComponentOld
{
    public MazeRuinsComponent(final ServerLevel level, final CompoundTag nbt) {
        super(MinotaurMazePieces.TFMMRuins, nbt);
    }
    
    public MazeRuinsComponent(final TFFeature feature, final int i, final int x, final int y, final int z) {
        super(MinotaurMazePieces.TFMMRuins, feature, i, feature.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 0, 0, 0, Direction.SOUTH));
        this.m_73519_(Direction.SOUTH);
    }
    
    public void m_142537_(final StructurePiece structurecomponent, final StructurePieceAccessor list, final Random random) {
        super.m_142537_(structurecomponent, list, random);
        final MinotaurMazeComponent maze = new MinotaurMazeComponent(this.getFeatureType(), 1, this.f_73383_.m_162395_(), this.f_73383_.m_162396_() - 14, this.f_73383_.m_162398_(), 1);
        list.m_142679_((StructurePiece)maze);
        maze.m_142537_(this, list, random);
        final MazeEntranceShaftComponent mazeEnter = new MazeEntranceShaftComponent(this.getFeatureType(), 2, random, this.f_73383_.m_162395_() + 1, this.f_73383_.m_162396_(), this.f_73383_.m_162398_() + 1);
        list.m_142679_((StructurePiece)mazeEnter);
        mazeEnter.m_142537_(this, list, random);
        final MazeMoundComponent mazeAbove = new MazeMoundComponent(this.getFeatureType(), 2, random, this.f_73383_.m_162395_() - 14, this.f_73383_.m_162400_(), this.f_73383_.m_162398_() - 14);
        list.m_142679_((StructurePiece)mazeAbove);
        mazeAbove.m_142537_(this, list, random);
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        return true;
    }
}
