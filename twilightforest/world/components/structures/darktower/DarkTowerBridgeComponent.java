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
import net.minecraft.world.level.block.Rotation;
import twilightforest.world.components.structures.TFStructureComponentOld;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.core.Direction;
import twilightforest.world.registration.TFFeature;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;
import twilightforest.world.components.structures.lichtower.TowerWingComponent;

public class DarkTowerBridgeComponent extends TowerWingComponent
{
    private int dSize;
    private int dHeight;
    
    public DarkTowerBridgeComponent(final StructurePieceType piece, final CompoundTag nbt) {
        super(piece, nbt);
    }
    
    public DarkTowerBridgeComponent(final ServerLevel level, final CompoundTag nbt) {
        super(DarkTowerPieces.TFDTBri, nbt);
    }
    
    protected DarkTowerBridgeComponent(final StructurePieceType type, final TFFeature feature, final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final Direction direction) {
        super(type, feature, i, x, y, z, 5, 5, direction);
        this.dSize = pSize;
        this.dHeight = pHeight;
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
        this.makeTowerWing(list, rand, this.m_73548_(), 4, 1, 2, this.dSize, this.dHeight, Rotation.NONE);
    }
    
    @Override
    public boolean makeTowerWing(final StructurePieceAccessor list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final Rotation rotation) {
        if (wingHeight < 6) {
            return false;
        }
        final Direction direction = this.getStructureRelativeRotation(rotation);
        final int[] dx = this.offsetTowerCoords(x, y, z, wingSize, direction);
        if (dx[1] + wingHeight > 255) {
            return false;
        }
        final TowerWingComponent wing = new DarkTowerWingComponent(DarkTowerPieces.TFDTWin, this.getFeatureType(), index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        final StructurePiece intersect = list.m_141921_(wing.m_73547_());
        if (intersect == null || intersect == this) {
            list.m_142679_((StructurePiece)wing);
            wing.m_142537_(this, list, rand);
            this.addOpening(x, y, z, rotation);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.m_73441_(world, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1, this.deco.blockState, this.deco.blockState, false);
        for (int x = 0; x < this.size; ++x) {
            this.m_73434_(world, this.deco.accentState, x, 0, 0, sbb);
            this.m_73434_(world, this.deco.accentState, x, this.height - 1, 0, sbb);
            this.m_73434_(world, this.deco.accentState, x, 0, this.size - 1, sbb);
            this.m_73434_(world, this.deco.accentState, x, this.height - 1, this.size - 1, sbb);
        }
        this.m_73535_(world, sbb, 0, 1, 1, this.size - 1, this.height - 2, this.size - 2);
        return true;
    }
    
    public BoundingBox getWingBB() {
        final int[] dest = this.offsetTowerCoords(4, 1, 2, this.dSize, this.m_73549_());
        return this.getFeatureType().getComponentToAddBoundingBox(dest[0], dest[1], dest[2], 0, 0, 0, this.dSize - 1, this.dHeight - 1, this.dSize - 1, this.m_73549_());
    }
}
