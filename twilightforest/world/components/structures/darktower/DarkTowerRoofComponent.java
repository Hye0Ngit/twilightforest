// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.darktower;

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
import twilightforest.world.components.structures.lichtower.TowerWingComponent;
import twilightforest.world.registration.TFFeature;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import twilightforest.world.components.structures.lichtower.TowerRoofComponent;

public class DarkTowerRoofComponent extends TowerRoofComponent
{
    public DarkTowerRoofComponent(final ServerLevel level, final CompoundTag nbt) {
        this(DarkTowerPieces.TFDTRooS, nbt);
    }
    
    public DarkTowerRoofComponent(final StructurePieceType piece, final CompoundTag nbt) {
        super(piece, nbt);
    }
    
    public DarkTowerRoofComponent(final StructurePieceType piece, final TFFeature feature, final int i, final TowerWingComponent wing, final int x, final int y, final int z) {
        super(piece, feature, i, x, y, z);
        this.m_73519_(wing.m_73549_());
        this.size = wing.size;
        this.height = 12;
        this.makeCapBB(wing);
        this.spawnListIndex = 1;
    }
    
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        for (int x = 0; x <= this.size - 1; ++x) {
            for (int z = 0; z <= this.size - 1; ++z) {
                if (x == 0 || x == this.size - 1 || z == 0 || z == this.size - 1) {
                    this.m_73434_(world, this.deco.fenceState, x, 1, z, sbb);
                }
            }
        }
        this.m_73434_(world, this.deco.accentState, 0, 1, 0, sbb);
        this.m_73434_(world, this.deco.accentState, this.size - 1, 1, 0, sbb);
        this.m_73434_(world, this.deco.accentState, 0, 1, this.size - 1, sbb);
        this.m_73434_(world, this.deco.accentState, this.size - 1, 1, this.size - 1, sbb);
        return true;
    }
}
