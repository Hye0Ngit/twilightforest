// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.courtyard;

import net.minecraft.world.level.levelgen.feature.NoiseEffect;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import java.util.Random;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockRotProcessor;

public class CourtyardMain extends StructureMazeGenerator
{
    static int ROW_OF_CELLS;
    static int RADIUS;
    static int DIAMETER;
    static final float HEDGE_FLOOF = 0.5f;
    static final float WALL_DECAY = 0.1f;
    static final float WALL_INTEGRITY = 0.95f;
    static final BlockRotProcessor WALL_INTEGRITY_PROCESSOR;
    static final BlockRotProcessor WALL_DECAY_PROCESSOR;
    
    public CourtyardMain(final ServerLevel level, final CompoundTag nbt) {
        super(level.m_8875_(), NagaCourtyardPieces.TFNCMn, nbt);
    }
    
    public CourtyardMain(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final StructureManager structureManager) {
        super(NagaCourtyardPieces.TFNCMn, feature, rand, i, CourtyardMain.ROW_OF_CELLS, CourtyardMain.ROW_OF_CELLS, x, y, z, structureManager);
        this.m_73519_(Direction.NORTH);
        this.f_73383_ = feature.getComponentToAddBoundingBox(x, y, z, -CourtyardMain.RADIUS / 2, -1, -CourtyardMain.RADIUS / 2, CourtyardMain.RADIUS, 10, CourtyardMain.RADIUS, this.m_73549_());
        this.sizeConstraints = feature.getComponentToAddBoundingBox(x, y, z, -CourtyardMain.RADIUS, -1, -CourtyardMain.RADIUS, CourtyardMain.RADIUS * 2, 10, CourtyardMain.RADIUS * 2, this.m_73549_());
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.m_73434_(world, ((Block)TFBlocks.NAGA_BOSS_SPAWNER.get()).m_49966_(), CourtyardMain.RADIUS / 2, 3, CourtyardMain.RADIUS / 2, sbb);
        return true;
    }
    
    @Override
    public NoiseEffect m_142318_() {
        return NoiseEffect.NONE;
    }
    
    static {
        CourtyardMain.ROW_OF_CELLS = 8;
        CourtyardMain.RADIUS = (int)((CourtyardMain.ROW_OF_CELLS - 2) / 2.0f * 12.0f + 8.0f);
        CourtyardMain.DIAMETER = 2 * CourtyardMain.RADIUS + 1;
        WALL_INTEGRITY_PROCESSOR = new BlockRotProcessor(0.95f);
        WALL_DECAY_PROCESSOR = new BlockRotProcessor(0.1f);
    }
}
