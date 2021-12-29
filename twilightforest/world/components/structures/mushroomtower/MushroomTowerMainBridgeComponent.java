// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.mushroomtower;

import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.block.Rotation;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.core.Direction;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class MushroomTowerMainBridgeComponent extends MushroomTowerBridgeComponent
{
    public MushroomTowerMainBridgeComponent(final ServerLevel level, final CompoundTag nbt) {
        super(MushroomTowerPieces.TFMTMB, nbt);
    }
    
    protected MushroomTowerMainBridgeComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final int pHeight, final Direction direction) {
        super(MushroomTowerPieces.TFMTMB, feature, i, x, y, z, 11, pHeight, direction);
    }
    
    @Override
    public boolean makeTowerWing(final StructurePieceAccessor list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final Rotation rotation) {
        final Direction direction = this.getStructureRelativeRotation(rotation);
        int[] dx = this.offsetTowerCoords(x, y, z, 15, direction);
        dx = this.adjustCoordinates(dx[0], dx[1], dx[2], 15, direction, list);
        final MushroomTowerMainComponent wing = new MushroomTowerMainComponent(this.getFeatureType(), index, dx[0], dx[1], dx[2], 15, wingHeight, direction);
        list.m_142679_((StructurePiece)wing);
        if (list instanceof StructureStart) {
            final StructureStart<?> start = (StructureStart<?>)list;
            wing.m_142537_(start.m_73602_().get(0), list, rand);
        }
        this.addOpening(x, y, z, rotation);
        return true;
    }
}
