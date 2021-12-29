// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.darktower;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import twilightforest.world.components.structures.TFStructureComponentOld;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.core.Direction;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import twilightforest.world.components.structures.lichtower.TowerWingComponent;

public class DarkTowerBalconyComponent extends TowerWingComponent
{
    public DarkTowerBalconyComponent(final ServerLevel level, final CompoundTag nbt) {
        super(DarkTowerPieces.TFDTBal, nbt);
    }
    
    protected DarkTowerBalconyComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final Direction direction) {
        super(DarkTowerPieces.TFDTBal, feature, i, x, y, z, 5, 5, direction);
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.m_73441_(world, sbb, 0, 0, 0, 2, 0, 4, this.deco.accentState, Blocks.f_50016_.m_49966_(), false);
        this.m_73441_(world, sbb, 0, 0, 1, 1, 0, 3, this.deco.blockState, Blocks.f_50016_.m_49966_(), false);
        this.m_73441_(world, sbb, 0, 1, 0, 2, 1, 4, this.deco.fenceState, Blocks.f_50016_.m_49966_(), false);
        this.m_73434_(world, this.deco.accentState, 2, 1, 0, sbb);
        this.m_73434_(world, this.deco.accentState, 2, 1, 4, sbb);
        this.m_73535_(world, sbb, 0, 1, 1, 1, 1, 3);
        return true;
    }
}
