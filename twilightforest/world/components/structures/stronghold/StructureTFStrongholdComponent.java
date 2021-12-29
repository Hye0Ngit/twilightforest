// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.stronghold;

import net.minecraft.world.level.levelgen.feature.NoiseEffect;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.Block;
import twilightforest.TFConfig;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.minecraft.world.level.block.Rotation;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.server.level.ServerLevel;
import java.util.Iterator;
import java.nio.IntBuffer;
import net.minecraft.core.Direction;
import twilightforest.world.registration.TFFeature;
import java.util.ArrayList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;
import net.minecraft.core.BlockPos;
import java.util.List;
import twilightforest.world.components.structures.TFStructureComponentOld;

public abstract class StructureTFStrongholdComponent extends TFStructureComponentOld
{
    public List<BlockPos> doors;
    
    public StructureTFStrongholdComponent(final StructurePieceType piece, final CompoundTag nbt) {
        super(piece, nbt);
        this.doors = new ArrayList<BlockPos>();
        this.readOpeningsFromArray(nbt.m_128465_("doorInts"));
    }
    
    public StructureTFStrongholdComponent(final StructurePieceType type, final TFFeature feature, final int i, final Direction facing, final int x, final int y, final int z) {
        super(type, feature, i, x, y, z);
        this.doors = new ArrayList<BlockPos>();
        this.f_73383_ = this.generateBoundingBox(facing, x, y, z);
        this.m_73519_(facing);
    }
    
    private int[] getDoorsAsIntArray() {
        final IntBuffer ibuffer = IntBuffer.allocate(this.doors.size() * 3);
        for (final BlockPos door : this.doors) {
            ibuffer.put(door.m_123341_());
            ibuffer.put(door.m_123342_());
            ibuffer.put(door.m_123343_());
        }
        return ibuffer.array();
    }
    
    @Override
    protected void m_142347_(final ServerLevel level, final CompoundTag tagCompound) {
        super.m_142347_(level, tagCompound);
        tagCompound.m_128385_("doorInts", this.getDoorsAsIntArray());
    }
    
    private void readOpeningsFromArray(final int[] intArray) {
        for (int i = 0; i < intArray.length; i += 3) {
            final BlockPos door = new BlockPos(intArray[i], intArray[i + 1], intArray[i + 2]);
            this.doors.add(door);
        }
    }
    
    public abstract BoundingBox generateBoundingBox(final Direction p0, final int p1, final int p2, final int p3);
    
    public static BoundingBox getComponentToAddBoundingBox(final int x, final int y, final int z, final int xOff, final int yOff, final int zOff, final int xSize, final int ySize, final int zSize, final Direction facing) {
        return switch (facing) {
            case WEST -> new BoundingBox(x - zSize + 1 + zOff, y + yOff, z + xOff, x + zOff, y + ySize - 1 + yOff, z + xSize - 1 + xOff);
            case NORTH -> new BoundingBox(x - xSize + 1 - xOff, y + yOff, z - zSize + 1 + zOff, x - xOff, y + ySize - 1 + yOff, z + zOff);
            case EAST -> new BoundingBox(x + zOff, y + yOff, z - xSize + 1 - xOff, x + zSize - 1 + zOff, y + ySize - 1 + yOff, z - xOff);
            default -> new BoundingBox(x + xOff, y + yOff, z + zOff, x + xSize - 1 + xOff, y + ySize - 1 + yOff, z + zSize - 1 + zOff);
        };
    }
    
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
    }
    
    protected void addNewComponent(final StructurePiece entrance, final StructurePieceAccessor list, final Random random, final Rotation facing, final int x, final int y, final int z) {
        final int index = this.f_73384_ + 1;
        final Direction nFacing = this.getStructureRelativeRotation(facing);
        final int nx = this.m_73392_(x, z);
        final int ny = this.m_73544_(y);
        final int nz = this.m_73525_(x, z);
        if (index > 50 || this.isOutOfRange(entrance, nx, nz, 112)) {
            return;
        }
        final StructureTFStrongholdComponent breakIn = (StructureTFStrongholdComponent)this.findBreakInComponent(list, nx, ny, nz);
        if (breakIn != null && breakIn.attemptToBreakIn(nx, ny, nz)) {
            this.addDoorwayTo(x, y, z, facing);
            return;
        }
        final StrongholdPieces pieceList = ((StrongholdEntranceComponent)entrance).lowerPieces;
        final StructurePiece nextComponent = pieceList.getNextComponent(entrance, list, random, this.getFeatureType(), index, nFacing, nx, ny, nz);
        if (nextComponent != null) {
            list.m_142679_(nextComponent);
            nextComponent.m_142537_(entrance, list, random);
            this.addDoorwayTo(x, y, z, facing);
        }
    }
    
    protected StructurePiece findBreakInComponent(final StructurePieceAccessor list, final int x, final int y, final int z) {
        final BlockPos pos = new BlockPos(x, y, z);
        if (list instanceof StructureStart) {
            final StructureStart<?> start = (StructureStart<?>)list;
            for (final StructurePiece component : start.m_73602_()) {
                if (component.m_73547_() != null && component.m_73547_().m_71051_((Vec3i)pos)) {
                    return component;
                }
            }
        }
        return null;
    }
    
    protected void addNewUpperComponent(final StructurePiece parent, final StructurePieceAccessor list, final Random random, final Rotation facing, final int x, final int y, final int z) {
        final int index = this.f_73384_ + 1;
        final Direction nFacing = this.getStructureRelativeRotation(facing);
        final int nx = this.m_73392_(x, z);
        final int ny = this.m_73544_(y);
        final int nz = this.m_73525_(x, z);
        if (index > 100 || this.isOutOfRange(parent, nx, nz, 48)) {
            return;
        }
        StructureTFStrongholdComponent structureTFStrongholdComponent = switch (random.nextInt(5)) {
            case 1 -> new StrongholdUpperLeftTurnComponent(this.getFeatureType(), index, nFacing, nx, ny, nz);
            case 2 -> new StrongholdUpperRightTurnComponent(this.getFeatureType(), index, nFacing, nx, ny, nz);
            case 3 -> new StrongholdUpperCorridorComponent(this.getFeatureType(), index, nFacing, nx, ny, nz);
            case 4 -> new StrongholdUpperAscenderComponent(this.getFeatureType(), index, nFacing, nx, ny, nz);
            default -> new StrongholdUpperTIntersectionComponent(this.getFeatureType(), index, nFacing, nx, ny, nz);
        };
        final StructureTFStrongholdComponent attempted = structureTFStrongholdComponent;
        if (attempted != null && list.m_141921_(attempted.m_73547_()) == null) {
            list.m_142679_((StructurePiece)attempted);
            attempted.m_142537_(parent, list, random);
        }
    }
    
    private boolean isOutOfRange(final StructurePiece parent, final int nx, final int nz, final int range) {
        return Math.abs(nx - parent.m_73547_().m_162395_()) > range || Math.abs(nz - parent.m_73547_().m_162398_()) > range;
    }
    
    protected void placeDoorwayAt(final WorldGenLevel world, final int x, final int y, final int z, final BoundingBox sbb) {
        if (x == 0 || x == this.getXSize()) {
            this.m_73441_(world, sbb, x, y, z - 2, x, y + 3, z + 2, this.deco.fenceState, Blocks.f_50016_.m_49966_(), false);
            this.m_73535_(world, sbb, x, y, z - 1, x, y + 3, z + 1);
        }
        else {
            this.m_73441_(world, sbb, x - 2, y, z, x + 2, y + 3, z, this.deco.fenceState, Blocks.f_50016_.m_49966_(), false);
            this.m_73535_(world, sbb, x - 1, y, z, x + 1, y + 3, z);
        }
    }
    
    protected int getXSize() {
        return switch (this.m_73549_()) {
            case WEST,  EAST -> this.f_73383_.m_71058_() - 1;
            default -> this.f_73383_.m_71056_() - 1;
        };
    }
    
    protected void placeSmallDoorwayAt(final WorldGenLevel world, final int facing, final int x, final int y, final int z, final BoundingBox sbb) {
        if (facing == 0 || facing == 2) {
            this.m_73441_(world, sbb, x - 1, y, z, x + 1, y + 1, z, Blocks.f_50274_.m_49966_(), Blocks.f_50016_.m_49966_(), true);
        }
        else {
            this.m_73441_(world, sbb, x, y, z - 1, x, y + 1, z + 1, Blocks.f_50274_.m_49966_(), Blocks.f_50016_.m_49966_(), true);
        }
        this.m_73535_(world, sbb, x, y, z, x, y + 1, z);
    }
    
    public void placeCornerStatue(final WorldGenLevel world, final int x, final int y, final int z, final int facing, final BoundingBox sbb) {
        int ox = 1;
        int oz = 1;
        Direction smx = Direction.EAST;
        Direction smz = Direction.SOUTH;
        switch (facing) {
            case 1: {
                oz = -1;
                smz = Direction.SOUTH;
                break;
            }
            case 2: {
                ox = -1;
                smx = Direction.WEST;
                break;
            }
            case 3: {
                ox = -1;
                oz = -1;
                smx = Direction.WEST;
                smz = Direction.NORTH;
                break;
            }
        }
        for (int sy = 0; sy < 5; ++sy) {
            this.m_73434_(world, this.deco.pillarState, x, y + sy, z, sbb);
        }
        this.m_73434_(world, Blocks.f_50132_.m_49966_(), x, y + 4, z + oz, sbb);
        this.m_73434_(world, Blocks.f_50132_.m_49966_(), x + ox, y + 4, z, sbb);
        this.m_73434_(world, TFStructureComponentOld.getStairState(this.deco.stairState, smz, false), x, y + 3, z + oz, sbb);
        this.m_73434_(world, TFStructureComponentOld.getStairState(this.deco.stairState, smx, false), x + ox, y + 3, z, sbb);
        this.m_73434_(world, TFStructureComponentOld.getStairState(this.deco.stairState, smz, true), x, y + 2, z + oz, sbb);
        this.m_73434_(world, TFStructureComponentOld.getStairState(this.deco.stairState, smx, true), x + ox, y + 2, z, sbb);
        this.m_73434_(world, TFStructureComponentOld.getStairState(this.deco.stairState, smx, true), x + ox, y + 2, z + oz, sbb);
        this.m_73434_(world, Blocks.f_50274_.m_49966_(), x + ox, y, z + oz, sbb);
        this.m_73434_(world, Blocks.f_50274_.m_49966_(), x + ox, y + 1, z + oz, sbb);
        this.m_73434_(world, TFStructureComponentOld.getStairState(this.deco.stairState, smz, false), x, y, z + oz, sbb);
        this.m_73434_(world, TFStructureComponentOld.getStairState(this.deco.stairState, smx, false), x + ox, y, z, sbb);
    }
    
    public void placeWallStatue(final WorldGenLevel world, final int x, final int y, final int z, final Rotation facing, final BoundingBox sbb) {
        int ox = 1;
        int oz = 1;
        for (int sy = 0; sy < 5; ++sy) {
            this.m_73434_(world, this.deco.pillarState, x, y + sy, z, sbb);
        }
        if (facing == Rotation.NONE || facing == Rotation.CLOCKWISE_180) {
            if (facing == Rotation.CLOCKWISE_180) {
                ox = -ox;
                oz = -oz;
            }
            this.m_73434_(world, Blocks.f_50132_.m_49966_(), x - ox, y + 4, z, sbb);
            this.m_73434_(world, Blocks.f_50132_.m_49966_(), x + ox, y + 4, z, sbb);
            this.m_73434_(world, TFStructureComponentOld.getStairState(this.deco.stairState, facing.m_55952_(Rotation.NONE).m_55954_(Direction.WEST), false), x - ox, y + 3, z, sbb);
            this.m_73434_(world, TFStructureComponentOld.getStairState(this.deco.stairState, facing.m_55952_(Rotation.CLOCKWISE_180).m_55954_(Direction.WEST), false), x + ox, y + 3, z, sbb);
            this.m_73434_(world, TFStructureComponentOld.getStairState(this.deco.stairState, facing.m_55952_(Rotation.CLOCKWISE_90).m_55954_(Direction.WEST), false), x - ox, y + 3, z - oz, sbb);
            this.m_73434_(world, TFStructureComponentOld.getStairState(this.deco.stairState, facing.m_55952_(Rotation.CLOCKWISE_90).m_55954_(Direction.WEST), false), x + ox, y + 3, z - oz, sbb);
            this.m_73434_(world, TFStructureComponentOld.getStairState(this.deco.stairState, facing.m_55952_(Rotation.NONE).m_55954_(Direction.WEST), true), x - ox, y + 2, z, sbb);
            this.m_73434_(world, TFStructureComponentOld.getStairState(this.deco.stairState, facing.m_55952_(Rotation.CLOCKWISE_180).m_55954_(Direction.WEST), true), x + ox, y + 2, z, sbb);
            this.m_73434_(world, TFStructureComponentOld.getStairState(this.deco.stairState, facing.m_55952_(Rotation.CLOCKWISE_90).m_55954_(Direction.WEST), true), x, y + 2, z - oz, sbb);
            this.m_73434_(world, TFStructureComponentOld.getStairState(this.deco.stairState, facing.m_55952_(Rotation.CLOCKWISE_90).m_55954_(Direction.WEST), true), x - ox, y + 2, z - oz, sbb);
            this.m_73434_(world, TFStructureComponentOld.getStairState(this.deco.stairState, facing.m_55952_(Rotation.CLOCKWISE_90).m_55954_(Direction.WEST), true), x + ox, y + 2, z - oz, sbb);
            this.m_73434_(world, Blocks.f_50274_.m_49966_(), x, y, z - oz, sbb);
            this.m_73434_(world, Blocks.f_50274_.m_49966_(), x, y + 1, z - oz, sbb);
            this.m_73434_(world, TFStructureComponentOld.getStairState(this.deco.stairState, facing.m_55952_(Rotation.NONE).m_55954_(Direction.WEST), false), x - ox, y, z, sbb);
            this.m_73434_(world, TFStructureComponentOld.getStairState(this.deco.stairState, facing.m_55952_(Rotation.CLOCKWISE_180).m_55954_(Direction.WEST), false), x + ox, y, z, sbb);
        }
        else {
            if (facing == Rotation.COUNTERCLOCKWISE_90) {
                oz = -oz;
                ox = -ox;
            }
            this.m_73434_(world, Blocks.f_50132_.m_49966_(), x, y + 4, z - oz, sbb);
            this.m_73434_(world, Blocks.f_50132_.m_49966_(), x, y + 4, z + oz, sbb);
            this.m_73434_(world, TFStructureComponentOld.getStairState(this.deco.stairState, facing.m_55952_(Rotation.NONE).m_55954_(Direction.WEST), false), x, y + 3, z - oz, sbb);
            this.m_73434_(world, TFStructureComponentOld.getStairState(this.deco.stairState, facing.m_55952_(Rotation.CLOCKWISE_180).m_55954_(Direction.WEST), false), x, y + 3, z + oz, sbb);
            this.m_73434_(world, TFStructureComponentOld.getStairState(this.deco.stairState, facing.m_55952_(Rotation.CLOCKWISE_90).m_55954_(Direction.WEST), false), x + ox, y + 3, z - oz, sbb);
            this.m_73434_(world, TFStructureComponentOld.getStairState(this.deco.stairState, facing.m_55952_(Rotation.CLOCKWISE_90).m_55954_(Direction.WEST), false), x + ox, y + 3, z + oz, sbb);
            this.m_73434_(world, TFStructureComponentOld.getStairState(this.deco.stairState, facing.m_55952_(Rotation.NONE).m_55954_(Direction.WEST), true), x, y + 2, z - oz, sbb);
            this.m_73434_(world, TFStructureComponentOld.getStairState(this.deco.stairState, facing.m_55952_(Rotation.CLOCKWISE_180).m_55954_(Direction.WEST), true), x, y + 2, z + oz, sbb);
            this.m_73434_(world, TFStructureComponentOld.getStairState(this.deco.stairState, facing.m_55952_(Rotation.CLOCKWISE_90).m_55954_(Direction.WEST), true), x + oz, y + 2, z, sbb);
            this.m_73434_(world, TFStructureComponentOld.getStairState(this.deco.stairState, facing.m_55952_(Rotation.CLOCKWISE_90).m_55954_(Direction.WEST), true), x + ox, y + 2, z - oz, sbb);
            this.m_73434_(world, TFStructureComponentOld.getStairState(this.deco.stairState, facing.m_55952_(Rotation.CLOCKWISE_90).m_55954_(Direction.WEST), true), x + ox, y + 2, z + oz, sbb);
            this.m_73434_(world, Blocks.f_50274_.m_49966_(), x + ox, y, z, sbb);
            this.m_73434_(world, Blocks.f_50274_.m_49966_(), x + ox, y + 1, z, sbb);
            this.m_73434_(world, TFStructureComponentOld.getStairState(this.deco.stairState, facing.m_55952_(Rotation.NONE).m_55954_(Direction.WEST), false), x, y, z - ox, sbb);
            this.m_73434_(world, TFStructureComponentOld.getStairState(this.deco.stairState, facing.m_55952_(Rotation.CLOCKWISE_180).m_55954_(Direction.WEST), false), x, y, z + ox, sbb);
        }
    }
    
    public boolean attemptToBreakIn(final int wx, final int wy, final int wz) {
        if (!this.isValidBreakInPoint(wx, wy, wz)) {
            return false;
        }
        final int dx = this.getRelativeX(wx, wz);
        final int dy = this.getRelativeY(wy);
        final int dz = this.getRelativeZ(wx, wz);
        this.addDoor(dx, dy, dz);
        return true;
    }
    
    public void addDoorwayTo(final int dx, final int dy, final int dz, final Rotation facing) {
        switch (facing) {
            case NONE: {
                this.addDoor(dx, dy, dz - 1);
                break;
            }
            case CLOCKWISE_90: {
                this.addDoor(dx + 1, dy, dz);
                break;
            }
            case CLOCKWISE_180: {
                this.addDoor(dx, dy, dz + 1);
                break;
            }
            case COUNTERCLOCKWISE_90: {
                this.addDoor(dx - 1, dy, dz);
                break;
            }
        }
    }
    
    public void addDoor(final int dx, final int dy, final int dz) {
        this.doors.add(new BlockPos(dx, dy, dz));
    }
    
    protected boolean isValidBreakInPoint(final int wx, final int wy, final int wz) {
        if (wy < this.f_73383_.m_162396_() || wy > this.f_73383_.m_162400_()) {
            return false;
        }
        if (wx == this.f_73383_.m_162395_() || wx == this.f_73383_.m_162399_()) {
            return wz > this.f_73383_.m_162398_() && wz < this.f_73383_.m_162401_();
        }
        return (wz == this.f_73383_.m_162398_() || wz == this.f_73383_.m_162401_()) && wx > this.f_73383_.m_162395_() && wx < this.f_73383_.m_162399_();
    }
    
    protected int getRelativeX(final int x, final int z) {
        return switch (this.m_73549_()) {
            case SOUTH -> x - this.f_73383_.m_162395_();
            case NORTH -> this.f_73383_.m_162399_() - x;
            case WEST -> z - this.f_73383_.m_162398_();
            case EAST -> this.f_73383_.m_162401_() - z;
            default -> x;
        };
    }
    
    protected int getRelativeY(final int y) {
        return y - this.f_73383_.m_162396_();
    }
    
    protected int getRelativeZ(final int x, final int z) {
        return switch (this.m_73549_()) {
            case SOUTH -> z - this.f_73383_.m_162398_();
            case NORTH -> this.f_73383_.m_162401_() - z;
            case WEST -> this.f_73383_.m_162399_() - x;
            case EAST -> x - this.f_73383_.m_162395_();
            default -> z;
        };
    }
    
    public void placeDoors(final WorldGenLevel world, final BoundingBox sbb) {
        if (this.doors != null) {
            for (final BlockPos doorCoords : this.doors) {
                this.placeDoorwayAt(world, doorCoords.m_123341_(), doorCoords.m_123342_(), doorCoords.m_123343_(), sbb);
            }
        }
    }
    
    protected void placeStrongholdWalls(final WorldGenLevel world, final BoundingBox sbb, final int sx, final int sy, final int sz, final int dx, final int dy, final int dz, final Random rand, final StructurePiece.BlockSelector randomBlocks) {
        for (int y = sy; y <= dy; ++y) {
            for (int x = sx; x <= dx; ++x) {
                for (int z = sz; z <= dz; ++z) {
                    final boolean wall = y == sy || y == dy || x == sx || x == dx || z == sz || z == dz;
                    final Block blockID = this.m_73398_((BlockGetter)world, x, y, z, sbb).m_60734_();
                    if (blockID == Blocks.f_50016_ && !(boolean)TFConfig.COMMON_CONFIG.DIMENSION.skylightForest.get()) {
                        if (wall) {
                            this.m_73434_(world, Blocks.f_50652_.m_49966_(), x, y, z, sbb);
                        }
                    }
                    else if (y == sy || y == dy) {
                        final StructurePiece.BlockSelector strongBlocks = TFStructureComponentOld.getStrongholdStones();
                        strongBlocks.m_7889_(rand, x, y, z, wall);
                        this.m_73434_(world, strongBlocks.m_73555_(), x, y, z, sbb);
                    }
                    else if (!wall || blockID != Blocks.f_50493_) {
                        randomBlocks.m_7889_(rand, x, y, z, wall);
                        this.m_73434_(world, randomBlocks.m_73555_(), x, y, z, sbb);
                    }
                }
            }
        }
    }
    
    protected void placeUpperStrongholdWalls(final WorldGenLevel world, final BoundingBox sbb, final int sx, final int sy, final int sz, final int dx, final int dy, final int dz, final Random rand, final StructurePiece.BlockSelector randomBlocks) {
        for (int y = sy; y <= dy; ++y) {
            for (int x = sx; x <= dx; ++x) {
                for (int z = sz; z <= dz; ++z) {
                    final boolean wall = y == sy || y == dy || x == sx || x == dx || z == sz || z == dz;
                    final BlockState state = this.m_73398_((BlockGetter)world, x, y, z, sbb);
                    final Block blockID = state.m_60734_();
                    if ((blockID != Blocks.f_50016_ && (state.m_60767_() == Material.f_76278_ || state.m_60767_() == Material.f_76315_ || state.m_60767_() == Material.f_76314_)) || (blockID == Blocks.f_50016_ && rand.nextInt(3) == 0 && this.m_73398_((BlockGetter)world, x, y - 1, z, sbb).m_60734_() == Blocks.f_50222_)) {
                        if (y == sy || y == dy) {
                            final StructurePiece.BlockSelector strongBlocks = TFStructureComponentOld.getStrongholdStones();
                            strongBlocks.m_7889_(rand, x, y, z, wall);
                            this.m_73434_(world, strongBlocks.m_73555_(), x, y, z, sbb);
                        }
                        else {
                            randomBlocks.m_7889_(rand, x, y, z, wall);
                            this.m_73434_(world, randomBlocks.m_73555_(), x, y, z, sbb);
                        }
                    }
                }
            }
        }
    }
    
    @Override
    public NoiseEffect m_142318_() {
        return this.isComponentProtected() ? NoiseEffect.BURY : NoiseEffect.NONE;
    }
    
    public interface Factory<T extends StructureTFStrongholdComponent>
    {
        T newInstance(final TFFeature p0, final int p1, final Direction p2, final int p3, final int p4, final int p5);
    }
}
