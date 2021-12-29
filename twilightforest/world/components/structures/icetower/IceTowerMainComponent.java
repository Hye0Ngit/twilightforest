// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.icetower;

import java.util.Iterator;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.core.Vec3i;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.core.Direction;
import java.util.Random;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class IceTowerMainComponent extends IceTowerWingComponent
{
    public boolean hasBossWing;
    
    public IceTowerMainComponent(final ServerLevel level, final CompoundTag nbt) {
        super(IceTowerPieces.TFITMai, nbt);
        this.hasBossWing = false;
        this.hasBossWing = nbt.m_128471_("hasBossWing");
    }
    
    public IceTowerMainComponent(final TFFeature feature, final Random rand, final int index, final int x, final int y, final int z) {
        this(feature, rand, index, x + 11, y + 40, z + 11, Direction.NORTH);
    }
    
    public IceTowerMainComponent(final TFFeature feature, final Random rand, final int index, final int x, final int y, final int z, final Direction rotation) {
        super(IceTowerPieces.TFITMai, feature, index, x, y, z, 11, 31 + rand.nextInt(3) * 10, rotation);
        this.hasBossWing = false;
        if (this.deco == null) {
            this.deco = new IceTowerDecorator();
        }
    }
    
    @Override
    protected void m_142347_(final ServerLevel level, final CompoundTag tagCompound) {
        super.m_142347_(level, tagCompound);
        tagCompound.m_128379_("hasBossWing", this.hasBossWing);
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        super.m_142537_(parent, list, rand);
        final BoundingBox towerBB = new BoundingBox(this.f_73383_.m_162394_());
        if (list instanceof StructureStart) {
            final StructureStart<?> start = (StructureStart<?>)list;
            for (final StructurePiece structurecomponent : start.m_73602_()) {
                towerBB.m_162386_(structurecomponent.m_73547_());
            }
        }
        final BlockPos myDoor = this.openings.get(0);
        BlockPos entranceDoor = new BlockPos((Vec3i)myDoor);
        if (myDoor.m_123341_() == 0) {
            final int length = this.m_73547_().m_162395_() - towerBB.m_162395_();
            if (length >= 0) {
                entranceDoor = entranceDoor.m_142386_(length);
                this.makeEntranceBridge(list, rand, this.m_73548_() + 1, myDoor.m_123341_(), myDoor.m_123342_(), myDoor.m_123343_(), length, Rotation.CLOCKWISE_180);
            }
        }
        if (myDoor.m_123341_() == this.size - 1) {
            entranceDoor = entranceDoor.m_142385_(towerBB.m_162399_() - this.m_73547_().m_162399_());
        }
        if (myDoor.m_123343_() == 0) {
            entranceDoor = entranceDoor.m_142383_(towerBB.m_162398_() - this.m_73547_().m_162398_());
        }
        if (myDoor.m_123341_() == this.size - 1) {
            entranceDoor = entranceDoor.m_142383_(towerBB.m_162401_() - this.m_73547_().m_162401_());
        }
        this.makeEntranceTower(list, rand, this.m_73548_() + 1, entranceDoor.m_123341_(), entranceDoor.m_123342_(), entranceDoor.m_123343_(), 11, 11, this.f_73379_);
    }
    
    private void makeEntranceBridge(final StructurePieceAccessor list, final Random rand, final int index, final int x, final int y, final int z, final int length, final Rotation rotation) {
        final Direction direction = this.getStructureRelativeRotation(rotation);
        final BlockPos dest = this.offsetTowerCCoords(x, y, z, 5, direction);
        final IceTowerBridgeComponent bridge = new IceTowerBridgeComponent(this.getFeatureType(), index, dest.m_123341_(), dest.m_123342_(), dest.m_123343_(), length, direction);
        list.m_142679_((StructurePiece)bridge);
        if (list instanceof StructureStart) {
            final StructureStart<?> start = (StructureStart<?>)list;
            bridge.m_142537_(start.m_73602_().get(0), list, rand);
        }
    }
    
    public boolean makeEntranceTower(final StructurePieceAccessor list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final Rotation rotation) {
        final Direction direction = this.getStructureRelativeRotation(rotation);
        final int[] dx = this.offsetTowerCoords(x, y, z, wingSize, direction);
        final IceTowerWingComponent entrance = new IceTowerEntranceComponent(this.getFeatureType(), index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        list.m_142679_((StructurePiece)entrance);
        if (list instanceof StructureStart) {
            final StructureStart<?> start = (StructureStart<?>)list;
            entrance.m_142537_(start.m_73602_().get(0), list, rand);
        }
        this.addOpening(x, y, z, rotation);
        return true;
    }
}
