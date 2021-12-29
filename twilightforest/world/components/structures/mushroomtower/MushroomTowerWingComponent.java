// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.mushroomtower;

import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import twilightforest.world.components.structures.lichtower.TowerRoofComponent;
import java.util.Iterator;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import twilightforest.util.RotationUtil;
import twilightforest.TwilightForestMod;
import net.minecraft.world.level.block.Rotation;
import twilightforest.world.components.structures.TFStructureComponentOld;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.core.Direction;
import twilightforest.world.registration.TFFeature;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import twilightforest.world.components.structures.lichtower.TowerWingComponent;

public class MushroomTowerWingComponent extends TowerWingComponent
{
    private static final int RANGE = 200;
    protected static final int FLOOR_HEIGHT = 4;
    protected static final int MAIN_SIZE = 15;
    boolean hasBase;
    public boolean isAscender;
    
    public MushroomTowerWingComponent(final ServerLevel level, final CompoundTag nbt) {
        this(MushroomTowerPieces.TFMTWin, nbt);
    }
    
    public MushroomTowerWingComponent(final StructurePieceType piece, final CompoundTag nbt) {
        super(piece, nbt);
        this.hasBase = false;
        this.isAscender = false;
        this.hasBase = nbt.m_128471_("hasBase");
        this.isAscender = nbt.m_128471_("isAscender");
    }
    
    protected MushroomTowerWingComponent(final StructurePieceType piece, final TFFeature feature, final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final Direction direction) {
        super(piece, feature, i, x, y, z, pSize, pHeight, direction);
        this.hasBase = false;
        this.isAscender = false;
    }
    
    @Override
    protected void m_142347_(final ServerLevel level, final CompoundTag tagCompound) {
        super.m_142347_(level, tagCompound);
        tagCompound.m_128379_("hasBase", this.hasBase);
        tagCompound.m_128379_("isAscender", this.isAscender);
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
        this.addOpening(0, 1, this.size / 2, Rotation.CLOCKWISE_180);
        this.hasBase = (this.size > 3);
        if (this.isAscender) {
            final int[] dest = this.getValidOpening(rand, Rotation.CLOCKWISE_180);
            dest[1] = this.height - 3;
            final int childHeight = (rand.nextInt(3) + rand.nextInt(3) + 2) * 4 + 1;
            final boolean madeIt = this.makeMainBridge(list, rand, this.m_73548_() + 1, dest[0], dest[1], dest[2], childHeight, Rotation.CLOCKWISE_180);
            if (!madeIt) {
                TwilightForestMod.LOGGER.info("Did not make bridge back to new main");
            }
            else {
                TwilightForestMod.LOGGER.debug("Made bridge back to new main");
            }
        }
        if (this.m_73548_() < 5 && this.size > 6) {
            for (final Rotation i : RotationUtil.ROTATIONS) {
                if (this.size >= 15 || i != Rotation.CLOCKWISE_180) {
                    final int[] dest2 = this.getValidOpening(rand, i);
                    final int childHeight2 = (rand.nextInt(2) + rand.nextInt(2) + 2) * 4 + 1;
                    this.makeBridge(list, rand, this.m_73548_() + 1, dest2[0], dest2[1], dest2[2], this.size - 4, childHeight2, i);
                }
            }
        }
        if (this.isHighest(this.f_73383_, this.size, list) || !this.hasBase) {
            this.makeARoof(parent, list, rand);
        }
    }
    
    private boolean isOutOfRange(final StructurePiece parent, final int nx, final int nz, final int range) {
        final BoundingBox sbb = parent.m_73547_();
        final int centerX = sbb.m_162395_() + (sbb.m_162399_() - sbb.m_162395_() + 1) / 2;
        final int centerZ = sbb.m_162398_() + (sbb.m_162401_() - sbb.m_162398_() + 1) / 2;
        return Math.abs(nx - centerX) > range || Math.abs(nz - centerZ) > range;
    }
    
    @Override
    public boolean makeTowerWing(final StructurePieceAccessor list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final Rotation rotation) {
        final Direction direction = this.getStructureRelativeRotation(rotation);
        int[] dx = this.offsetTowerCoords(x, y, z, wingSize, direction);
        if (this.isOutOfRange(this, dx[0], dx[2], 200)) {
            return false;
        }
        if (wingSize > 3) {
            dx = this.adjustCoordinates(dx[0], dx[1], dx[2], wingSize, direction, list);
        }
        final MushroomTowerWingComponent wing = new MushroomTowerWingComponent(MushroomTowerPieces.TFMTWin, this.getFeatureType(), index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        final StructurePiece intersect = list.m_141921_(wing.m_73547_());
        if (intersect == null || intersect == this || intersect instanceof TowerRoofMushroomComponent) {
            if (this instanceof MushroomTowerBridgeComponent && this.isAscender) {
                wing.isAscender = true;
            }
            list.m_142679_((StructurePiece)wing);
            wing.m_142537_(this, list, rand);
            this.addOpening(x, y, z, rotation);
            return true;
        }
        return false;
    }
    
    protected int[] adjustCoordinates(final int x, final int y, final int z, final int wingSize, final Direction direction, final StructurePieceAccessor list) {
        if (list instanceof StructureStart) {
            final StructureStart<?> start = (StructureStart<?>)list;
            for (final StructurePiece obj : start.m_73602_()) {
                if (obj instanceof TowerWingComponent && !(obj instanceof MushroomTowerBridgeComponent)) {
                    final TowerWingComponent otherWing = (TowerWingComponent)obj;
                    if (wingSize == otherWing.size && otherWing.m_73547_().m_71019_(x - 3, z - 3, x + 3, z + 3)) {
                        return switch (direction) {
                            case SOUTH -> new int[] { otherWing.m_73547_().m_162395_(), y, otherWing.m_73547_().m_162398_() };
                            case WEST -> new int[] { otherWing.m_73547_().m_162399_(), y, otherWing.m_73547_().m_162398_() };
                            case NORTH -> new int[] { otherWing.m_73547_().m_162399_(), y, otherWing.m_73547_().m_162401_() };
                            case EAST -> new int[] { otherWing.m_73547_().m_162395_(), y, otherWing.m_73547_().m_162401_() };
                            default -> new int[] { x, y, z };
                        };
                    }
                    continue;
                }
            }
        }
        return new int[] { x, y, z };
    }
    
    private boolean isHighest(final BoundingBox boundingBox, final int size, final StructurePieceAccessor list) {
        final BoundingBox boxAbove = new BoundingBox(boundingBox.m_162394_());
        if (list instanceof StructureStart) {
            final StructureStart<?> start = (StructureStart<?>)list;
            for (final StructurePiece obj : start.m_73602_()) {
                if (this != obj && obj instanceof TowerWingComponent && !(obj instanceof MushroomTowerBridgeComponent)) {
                    final TowerWingComponent otherWing = (TowerWingComponent)obj;
                    if (size == otherWing.size && otherWing.m_73547_().m_71049_(boxAbove)) {
                        return false;
                    }
                    continue;
                }
            }
        }
        return true;
    }
    
    @Override
    public void makeARoof(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        TowerRoofComponent roof = new TowerRoofMushroomComponent(this.getFeatureType(), this.m_73548_() + 1, this, 1.6f, this.m_142171_().m_123341_(), this.m_142171_().m_123342_(), this.m_142171_().m_123343_());
        if (!(list.m_141921_(roof.m_73547_()) instanceof TowerRoofMushroomComponent)) {
            roof = new TowerRoofMushroomComponent(this.getFeatureType(), this.m_73548_() + 1, this, 1.0f, this.m_142171_().m_123341_(), this.m_142171_().m_123342_(), this.m_142171_().m_123343_());
            if (!(list.m_141921_(roof.m_73547_()) instanceof TowerRoofMushroomComponent)) {
                roof = new TowerRoofMushroomComponent(this.getFeatureType(), this.m_73548_() + 1, this, 0.6f, this.m_142171_().m_123341_(), this.m_142171_().m_123342_(), this.m_142171_().m_123343_());
            }
        }
        list.m_142679_((StructurePiece)roof);
        roof.m_142537_((StructurePiece)this, list, rand);
    }
    
    @Override
    protected boolean makeBridge(final StructurePieceAccessor list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final Rotation rotation) {
        return this.makeBridge(list, rand, index, x, y, z, wingSize, wingHeight, rotation, false);
    }
    
    protected boolean makeBridge(final StructurePieceAccessor list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, int wingHeight, final Rotation rotation, final boolean ascender) {
        final Direction direction = this.getStructureRelativeRotation(rotation);
        final int[] dx = this.offsetTowerCoords(x, y, z, 3, direction);
        if (wingSize == 3) {
            wingHeight = 4;
        }
        final MushroomTowerBridgeComponent bridge = new MushroomTowerBridgeComponent(MushroomTowerPieces.TFMTBri, this.getFeatureType(), index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        bridge.isAscender = ascender;
        StructurePiece intersect = list.m_141921_(bridge.m_73547_());
        if (intersect != null && intersect != this) {
            return false;
        }
        intersect = list.m_141921_(bridge.getWingBB());
        if (intersect == null || intersect == this) {
            list.m_142679_((StructurePiece)bridge);
            bridge.m_142537_(this, list, rand);
            this.addOpening(x, y, z, rotation);
            return true;
        }
        return false;
    }
    
    private boolean makeMainBridge(final StructurePieceAccessor list, final Random rand, final int index, final int x, final int y, final int z, final int wingHeight, final Rotation rotation) {
        final Direction direction = this.getStructureRelativeRotation(rotation);
        final int[] dx = this.offsetTowerCoords(x, y, z, 3, direction);
        final MushroomTowerMainBridgeComponent bridge = new MushroomTowerMainBridgeComponent(this.getFeatureType(), index, dx[0], dx[1], dx[2], wingHeight, direction);
        list.m_142679_((StructurePiece)bridge);
        bridge.m_142537_(this, list, rand);
        this.addOpening(x, y, z, rotation);
        return true;
    }
    
    @Override
    public int[] getValidOpening(final Random rand, final Rotation direction) {
        final int wLength = Math.min(this.size / 3, 3);
        final int offset = (this.size - wLength) / 2;
        if (direction == Rotation.NONE || direction == Rotation.CLOCKWISE_180) {
            final int rx = (direction == Rotation.NONE) ? (this.size - 1) : 0;
            final int rz = offset + rand.nextInt(wLength);
            final int ry = this.getYByStairs(rz, rand, direction);
            return new int[] { rx, ry, rz };
        }
        if (direction == Rotation.CLOCKWISE_90 || direction == Rotation.COUNTERCLOCKWISE_90) {
            final int rx = offset + rand.nextInt(wLength);
            final int rz = (direction == Rotation.CLOCKWISE_90) ? (this.size - 1) : 0;
            final int ry = this.getYByStairs(rx, rand, direction);
            return new int[] { rx, ry, rz };
        }
        return new int[] { 0, 0, 0 };
    }
    
    @Override
    protected int getYByStairs(final int rx, final Random rand, final Rotation direction) {
        final int floors = this.height / 4;
        return 5 + rand.nextInt(floors - 1) * 4;
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.makeTrunk(world, sbb);
        this.makeFloorsForTower(world, sbb);
        this.makeOpenings(world, sbb);
        return true;
    }
    
    private void makeTrunk(final WorldGenLevel world, final BoundingBox sbb) {
        final int diameter = this.size / 2;
        final int hollow = (int)(diameter * 0.8);
        for (int dx = -diameter; dx <= diameter; ++dx) {
            for (int dz = -diameter; dz <= diameter; ++dz) {
                final int ax = Math.abs(dx);
                final int az = Math.abs(dz);
                final int dist = (int)(Math.max(ax, az) + Math.min(ax, az) * 0.4);
                if (dist <= diameter) {
                    this.m_73434_(world, this.deco.floorState, dx + diameter, 0, dz + diameter, sbb);
                    this.m_73434_(world, this.deco.floorState, dx + diameter, this.height, dz + diameter, sbb);
                    if (dist > hollow) {
                        for (int dy = 0; dy <= this.height; ++dy) {
                            this.m_73434_(world, this.deco.blockState, dx + diameter, dy, dz + diameter, sbb);
                        }
                    }
                    else {
                        for (int dy = 1; dy <= this.height - 1; ++dy) {
                            this.m_73434_(world, MushroomTowerWingComponent.AIR, dx + diameter, dy, dz + diameter, sbb);
                        }
                    }
                    if (this.hasBase) {
                        this.m_73528_(world, this.deco.blockState, dx + diameter, -1, dz + diameter, sbb);
                    }
                }
            }
        }
    }
    
    private void makeFloorsForTower(final WorldGenLevel world, final BoundingBox sbb) {
        for (int floors = this.height / 4, i = 0; i < floors; ++i) {
            this.placeFloor(world, i * 4, sbb);
        }
    }
    
    private void placeFloor(final WorldGenLevel world, final int dy, final BoundingBox sbb) {
        final int diameter = this.size / 2;
        final int hollow = (int)(diameter * 0.8);
        for (int dx = -diameter; dx <= diameter; ++dx) {
            for (int dz = -diameter; dz <= diameter; ++dz) {
                final int ax = Math.abs(dx);
                final int az = Math.abs(dz);
                final int dist = (int)(Math.max(ax, az) + Math.min(ax, az) * 0.4);
                if (dist <= hollow) {
                    this.m_73434_(world, this.isAscender ? Blocks.f_50743_.m_49966_() : this.deco.floorState, dx + diameter, dy, dz + diameter, sbb);
                }
            }
        }
    }
    
    @Override
    protected void makeDoorOpening(final WorldGenLevel world, final int dx, final int dy, final int dz, final BoundingBox sbb) {
        super.makeDoorOpening(world, dx, dy, dz, sbb);
        if (this.m_73398_((BlockGetter)world, dx, dy + 2, dz, sbb).m_60734_() != Blocks.f_50016_) {
            this.m_73434_(world, this.deco.accentState, dx, dy + 2, dz, sbb);
        }
    }
    
    @Override
    protected void decorateFloor(final WorldGenLevel world, final Random rand, final int floor, final int bottom, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final BoundingBox sbb) {
    }
}
