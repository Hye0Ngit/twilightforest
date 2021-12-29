// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.darktower;

import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.block.Rotation;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.core.Direction;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class DarkTowerEntranceBridgeComponent extends DarkTowerBridgeComponent
{
    public DarkTowerEntranceBridgeComponent(final ServerLevel level, final CompoundTag nbt) {
        super(DarkTowerPieces.TFDTEB, nbt);
    }
    
    protected DarkTowerEntranceBridgeComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final Direction direction) {
        super(DarkTowerPieces.TFDTEB, feature, i, x, y, z, pSize, pHeight, direction);
    }
    
    @Override
    public boolean makeTowerWing(final StructurePieceAccessor list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final Rotation rotation) {
        final Direction direction = this.getStructureRelativeRotation(rotation);
        final int[] dx = this.offsetTowerCoords(x, y, z, wingSize, direction);
        final DarkTowerWingComponent wing = new DarkTowerEntranceComponent(this.getFeatureType(), index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        list.m_142679_((StructurePiece)wing);
        wing.m_142537_(this, list, rand);
        this.addOpening(x, y, z, rotation);
        return true;
    }
}
