// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.icetower;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Rotation;
import twilightforest.world.components.structures.TFStructureComponent;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import java.util.Random;
import net.minecraft.core.Direction;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class IceTowerEntranceComponent extends IceTowerWingComponent
{
    public IceTowerEntranceComponent(final ServerLevel level, final CompoundTag nbt) {
        super(IceTowerPieces.TFITEnt, nbt);
    }
    
    public IceTowerEntranceComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final Direction direction) {
        super(IceTowerPieces.TFITEnt, feature, i, x, y, z, pSize, pHeight, direction);
    }
    
    @Override
    protected boolean shouldHaveBase(final Random rand) {
        return true;
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponent) {
            final TFStructureComponent tfStructureComponent = (TFStructureComponent)parent;
            this.deco = tfStructureComponent.deco;
        }
        this.addOpening(0, 1, this.size / 2, Rotation.CLOCKWISE_180);
        this.addStairs(list, rand, this.m_73548_() + 1, this.size - 1, 1, this.size / 2, Rotation.NONE);
        this.addStairs(list, rand, this.m_73548_() + 1, this.size / 2, 1, 0, Rotation.COUNTERCLOCKWISE_90);
        this.addStairs(list, rand, this.m_73548_() + 1, this.size / 2, 1, this.size - 1, Rotation.CLOCKWISE_90);
        this.hasBase = this.shouldHaveBase(rand);
        this.makeARoof(parent, list, rand);
    }
    
    private boolean addStairs(final StructurePieceAccessor list, final Random rand, final int index, final int x, final int y, final int z, final Rotation rotation) {
        this.addOpening(x, y, z, rotation);
        final Direction direction = this.getStructureRelativeRotation(rotation);
        final BlockPos dx = this.offsetTowerCCoords(x, y, z, this.size, direction);
        final IceTowerStairsComponent entrance = new IceTowerStairsComponent(this.getFeatureType(), index, dx.m_123341_(), dx.m_123342_(), dx.m_123343_(), this.size, this.height, direction);
        list.m_142679_((StructurePiece)entrance);
        entrance.m_142537_(this, list, rand);
        return true;
    }
    
    @Override
    public boolean makeTowerWing(final StructurePieceAccessor list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final Rotation rotation) {
        return false;
    }
    
    @Override
    protected void makeFloorsForTower(final WorldGenLevel world, final Random rand, final BoundingBox sbb) {
        this.decoratePillarsCornersHigh(world, 0, 11, Rotation.NONE, sbb);
    }
    
    protected void decoratePillarsCornersHigh(final WorldGenLevel world, final int bottom, final int top, final Rotation rotation, final BoundingBox sbb) {
        final BlockState pillarXAxis = (BlockState)this.deco.pillarState.m_61124_((Property)RotatedPillarBlock.f_55923_, (Comparable)Direction.Axis.X);
        final BlockState pillarZAxis = (BlockState)this.deco.pillarState.m_61124_((Property)RotatedPillarBlock.f_55923_, (Comparable)Direction.Axis.Z);
        this.fillBlocksRotated(world, sbb, 3, bottom + 5, 1, 3, bottom + 5, 9, pillarZAxis, rotation);
        this.fillBlocksRotated(world, sbb, 7, bottom + 5, 1, 7, bottom + 5, 9, pillarZAxis, rotation);
        this.fillBlocksRotated(world, sbb, 1, bottom + 5, 3, 9, bottom + 5, 3, pillarXAxis, rotation);
        this.fillBlocksRotated(world, sbb, 1, bottom + 5, 7, 9, bottom + 5, 7, pillarXAxis, rotation);
        this.fillAirRotated(world, sbb, 3, bottom + 5, 3, 7, bottom + 5, 7, rotation);
        this.fillBlocksRotated(world, sbb, 3, bottom + 5, 3, 3, top - 1, 3, this.deco.pillarState, rotation);
        this.fillBlocksRotated(world, sbb, 7, bottom + 5, 3, 7, top - 1, 3, this.deco.pillarState, rotation);
        this.fillBlocksRotated(world, sbb, 3, bottom + 5, 7, 3, top - 1, 7, this.deco.pillarState, rotation);
        this.fillBlocksRotated(world, sbb, 7, bottom + 5, 7, 7, top - 1, 7, this.deco.pillarState, rotation);
    }
}
