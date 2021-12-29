// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.finalcastle;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import twilightforest.util.RotationUtil;
import twilightforest.TwilightForestMod;
import net.minecraft.core.BlockPos;
import twilightforest.world.components.structures.TFStructureComponentOld;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.nbt.Tag;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.core.Direction;
import java.util.Random;
import twilightforest.world.registration.TFFeature;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;
import net.minecraft.world.level.block.state.BlockState;
import twilightforest.world.components.structures.lichtower.TowerWingComponent;

public class FinalCastleMazeTower13Component extends TowerWingComponent
{
    public static final int LOWEST_DOOR = 144;
    public static final int HIGHEST_DOOR = 222;
    public BlockState color;
    
    public FinalCastleMazeTower13Component(final StructurePieceType piece, final CompoundTag nbt) {
        super(piece, nbt);
        this.color = NbtUtils.m_129241_(nbt.m_128469_("color"));
    }
    
    public FinalCastleMazeTower13Component(final ServerLevel level, final CompoundTag nbt) {
        this(FinalCastlePieces.TFFCSiTo, nbt);
    }
    
    public FinalCastleMazeTower13Component(final StructurePieceType piece, final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final BlockState color, final Direction direction) {
        super(piece, feature, i, x, y, z);
        this.m_73519_(direction);
        this.color = color;
        this.size = 13;
        final int floors = rand.nextInt(3) + 2;
        this.height = floors * 8 + 1;
        int entranceFloor = rand.nextInt(floors);
        if (y - entranceFloor * 8 < 144) {
            entranceFloor = 0;
        }
        if (y + (floors - entranceFloor) * 8 > 222) {
            entranceFloor = floors - 1;
        }
        this.f_73383_ = feature.getComponentToAddBoundingBox(x, y, z, -6, -(entranceFloor * 8), -6, this.size - 1, this.height, this.size - 1, Direction.SOUTH);
        this.addOpening(0, entranceFloor * 8 + 1, this.size / 2, Rotation.CLOCKWISE_180);
    }
    
    @Override
    protected void m_142347_(final ServerLevel level, final CompoundTag tagCompound) {
        super.m_142347_(level, tagCompound);
        tagCompound.m_128365_("color", (Tag)NbtUtils.m_129202_(this.color));
    }
    
    public FinalCastleMazeTower13Component(final StructurePieceType piece, final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final int floors, final int entranceFloor, final BlockState color, final Direction direction) {
        super(piece, feature, i, x, y, z);
        this.m_73519_(direction);
        this.color = color;
        this.size = 13;
        this.height = floors * 8 + 1;
        this.f_73383_ = feature.getComponentToAddBoundingBox(x, y, z, -6, -(entranceFloor * 8), -6, this.size - 1, this.height, this.size - 1, Direction.SOUTH);
        this.addOpening(0, entranceFloor * 8 + 1, this.size / 2, Rotation.CLOCKWISE_180);
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
        final FinalCastleFoundation13Component foundation = new FinalCastleFoundation13Component(FinalCastlePieces.TFFCToF13, this.getFeatureType(), rand, 4, this, this.m_142171_().m_123341_(), this.m_142171_().m_123342_(), this.m_142171_().m_123343_());
        list.m_142679_((StructurePiece)foundation);
        foundation.m_142537_(this, list, rand);
        final TFStructureComponentOld roof = rand.nextBoolean() ? new FinalCastleRoof13ConicalComponent(this.getFeatureType(), rand, 4, this, this.m_142171_().m_123341_(), this.m_142171_().m_123342_(), this.m_142171_().m_123343_()) : new FinalCastleRoof13CrenellatedComponent(this.getFeatureType(), rand, 4, this, this.m_142171_().m_123341_(), this.m_142171_().m_123342_(), this.m_142171_().m_123343_());
        list.m_142679_((StructurePiece)roof);
        roof.m_142537_((StructurePiece)this, list, rand);
    }
    
    public void buildTowards(final StructurePiece parent, final StructurePieceAccessor list, final Random rand, final BlockPos dest) {
        this.m_142537_(parent, list, rand);
        if (this.m_73548_() < 20) {
            if (this.isWithinRange(dest.m_123341_(), dest.m_123343_(), this.f_73383_.m_162395_() + 6, this.f_73383_.m_162398_() + 6, 30)) {
                final int howFar = 20;
                if (!this.buildEndTowerTowards(list, rand, dest, this.findBestDirectionTowards(dest), howFar) && !this.buildEndTowerTowards(list, rand, dest, this.findSecondDirectionTowards(dest), howFar) && !this.buildEndTowerTowards(list, rand, dest, this.findThirdDirectionTowards(dest), howFar)) {
                    TwilightForestMod.LOGGER.info("Could not build final tower");
                }
            }
            else {
                final int howFar = 14 + rand.nextInt(24);
                Direction facing = this.findBestDirectionTowards(dest);
                if (facing == this.m_73549_() || !this.buildContinueTowerTowards(list, rand, dest, facing, howFar)) {
                    facing = this.findSecondDirectionTowards(dest);
                    if (facing == this.m_73549_() || !this.buildContinueTowerTowards(list, rand, dest, facing, howFar)) {
                        facing = this.findThirdDirectionTowards(dest);
                        if ((facing == this.m_73549_() || !this.buildContinueTowerTowards(list, rand, dest, facing, howFar)) && !this.buildContinueTowerTowards(list, rand, dest, this.m_73549_(), howFar)) {
                            TwilightForestMod.LOGGER.info("Could not build tower randomly");
                        }
                    }
                }
            }
        }
        else {
            TwilightForestMod.LOGGER.info("Built 15 towers without reaching destination");
        }
        this.buildNonCriticalTowers(parent, list, rand);
    }
    
    protected void buildNonCriticalTowers(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        Direction dir = RotationUtil.getRandomFacing(rand);
        final Rotation relativeRotation = RotationUtil.getRelativeRotation(this.m_73549_(), dir);
        if (!this.openingTowards[relativeRotation.ordinal()] && !this.buildDamagedTower(list, rand, dir)) {
            dir = RotationUtil.getRandomFacing(rand);
            if (!this.buildDamagedTower(list, rand, dir)) {}
        }
    }
    
    private Direction findBestDirectionTowards(final BlockPos dest) {
        final int cx = this.f_73383_.m_162395_() + 6;
        final int cz = this.f_73383_.m_162398_() + 6;
        final int dx = cx - dest.m_123341_();
        final int dz = cz - dest.m_123343_();
        Direction absoluteDir;
        if (Math.abs(dx) > Math.abs(dz)) {
            absoluteDir = ((dx >= 0) ? Direction.EAST : Direction.WEST);
        }
        else {
            absoluteDir = ((dz >= 0) ? Direction.SOUTH : Direction.NORTH);
        }
        return absoluteDir;
    }
    
    private Direction findSecondDirectionTowards(final BlockPos dest) {
        final int cx = this.f_73383_.m_162395_() + 6;
        final int cz = this.f_73383_.m_162398_() + 6;
        final int dx = cx - dest.m_123341_();
        final int dz = cz - dest.m_123343_();
        Direction absoluteDir;
        if (Math.abs(dx) < Math.abs(dz)) {
            absoluteDir = ((dx >= 0) ? Direction.EAST : Direction.WEST);
        }
        else {
            absoluteDir = ((dz >= 0) ? Direction.SOUTH : Direction.NORTH);
        }
        return absoluteDir;
    }
    
    private Direction findThirdDirectionTowards(final BlockPos dest) {
        final Direction first = this.findBestDirectionTowards(dest);
        final Direction second = this.findSecondDirectionTowards(dest);
        final Direction[] array;
        final Direction[] cardinals = array = new Direction[] { Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST };
        for (final Direction f : array) {
            if (f != first && f != second && f != Rotation.CLOCKWISE_180.m_55954_(this.m_73549_())) {
                return f;
            }
        }
        return this.m_73549_();
    }
    
    private boolean buildContinueTowerTowards(final StructurePieceAccessor list, final Random rand, final BlockPos dest, final Direction facing, final int howFar) {
        BlockPos opening = this.getValidOpeningCC(rand, facing);
        final int adjustmentRange = 60;
        if (this.isWithinRange(dest.m_123341_(), dest.m_123343_(), this.f_73383_.m_162395_() + 6, this.f_73383_.m_162398_() + 6, adjustmentRange)) {
            opening = new BlockPos(opening.m_123341_(), this.adjustOpening(opening.m_123342_(), dest), opening.m_123343_());
        }
        final BlockPos tc = this.offsetTowerCCoords(opening.m_123341_(), opening.m_123342_(), opening.m_123343_(), howFar, facing);
        if (!(list instanceof StructureStart)) {
            return false;
        }
        final StructureStart<?> start2 = (StructureStart<?>)list;
        final StructurePiece start3 = start2.m_73602_().get(0);
        final int centerX = start3.m_73547_().m_162395_() + 128 >> 8 << 8;
        final int centerZ = start3.m_73547_().m_162398_() + 128 >> 8 << 8;
        if (!this.isWithinRange(centerX, centerZ, tc.m_123341_(), tc.m_123343_(), 128)) {
            TwilightForestMod.LOGGER.info("tower out of range");
            return false;
        }
        final FinalCastleMazeTower13Component sTower = new FinalCastleMazeTower13Component(FinalCastlePieces.TFFCSiTo, this.getFeatureType(), rand, this.m_73548_() + 1, tc.m_123341_(), tc.m_123342_(), tc.m_123343_(), this.color, facing);
        final BoundingBox largerBB = new BoundingBox(sTower.m_73547_().m_162394_());
        final StructurePiece intersect = list.m_141921_(largerBB);
        if (intersect == null) {
            list.m_142679_((StructurePiece)sTower);
            sTower.buildTowards(this, list, rand, dest);
            final BlockPos bc = this.offsetTowerCCoords(opening.m_123341_(), opening.m_123342_(), opening.m_123343_(), 1, facing);
            final FinalCastleBridgeComponent bridge = new FinalCastleBridgeComponent(this.getFeatureType(), this.m_73548_() + 1, bc.m_123341_(), bc.m_123342_(), bc.m_123343_(), howFar - 7, facing);
            list.m_142679_((StructurePiece)bridge);
            bridge.m_142537_(this, list, rand);
            this.addOpening(opening.m_123341_(), opening.m_123342_() + 1, opening.m_123343_(), facing);
            return true;
        }
        TwilightForestMod.LOGGER.info("tower blocked by {}", (Object)intersect);
        return false;
    }
    
    protected boolean buildDamagedTower(final StructurePieceAccessor list, final Random rand, final Direction facing) {
        final BlockPos opening = this.getValidOpeningCC(rand, facing);
        final int howFar = 14 + rand.nextInt(24);
        final BlockPos tc = this.offsetTowerCCoords(opening.m_123341_(), opening.m_123342_(), opening.m_123343_(), howFar, facing);
        final FinalCastleMazeTower13Component eTower = this.makeNewDamagedTower(rand, facing, tc);
        final BoundingBox largerBB = new BoundingBox(eTower.m_73547_().m_162394_());
        final StructurePiece intersect = list.m_141921_(largerBB);
        if (intersect == null) {
            list.m_142679_((StructurePiece)eTower);
            eTower.m_142537_(this, list, rand);
            final BlockPos bc = this.offsetTowerCCoords(opening.m_123341_(), opening.m_123342_(), opening.m_123343_(), 1, facing);
            final FinalCastleBridgeComponent bridge = new FinalCastleBridgeComponent(this.getFeatureType(), this.m_73548_() + 1, bc.m_123341_(), bc.m_123342_(), bc.m_123343_(), howFar - 7, facing);
            list.m_142679_((StructurePiece)bridge);
            bridge.m_142537_(this, list, rand);
            this.addOpening(opening.m_123341_(), opening.m_123342_() + 1, opening.m_123343_(), facing);
            return true;
        }
        return false;
    }
    
    protected FinalCastleMazeTower13Component makeNewDamagedTower(final Random rand, final Direction facing, final BlockPos tc) {
        return new FinalCastleDamagedTowerComponent(FinalCastlePieces.TFFCDamT, this.getFeatureType(), rand, this.m_73548_() + 1, tc.m_123341_(), tc.m_123342_(), tc.m_123343_(), facing);
    }
    
    private int adjustOpening(final int posY, final BlockPos dest) {
        int openY = posY;
        final int realOpeningY = this.m_73544_(openY);
        if (realOpeningY - dest.m_123342_() < 12) {
            openY = this.height - 9;
        }
        else if (dest.m_123342_() - realOpeningY < 12) {
            openY = 0;
        }
        return openY;
    }
    
    private boolean buildEndTowerTowards(final StructurePieceAccessor list, final Random rand, final BlockPos dest, final Direction facing, final int howFar) {
        BlockPos opening = this.getValidOpeningCC(rand, facing);
        opening = new BlockPos(opening.m_123341_(), this.adjustOpening(opening.m_123342_(), dest), opening.m_123343_());
        final BlockPos tc = this.offsetTowerCCoords(opening.m_123341_(), opening.m_123342_(), opening.m_123343_(), howFar, facing);
        FinalCastleMazeTower13Component eTower;
        if (this.color == ((Block)TFBlocks.PINK_CASTLE_RUNE_BRICK.get()).m_49966_()) {
            eTower = new FinalCastleEntranceTowerComponent(this.getFeatureType(), rand, this.m_73548_() + 1, tc.m_123341_(), tc.m_123342_(), tc.m_123343_(), facing);
        }
        else {
            eTower = new FinalCastleBellTower21Component(this.getFeatureType(), rand, this.m_73548_() + 1, tc.m_123341_(), tc.m_123342_(), tc.m_123343_(), facing);
        }
        final BoundingBox largerBB = new BoundingBox(eTower.m_73547_().m_162394_());
        final StructurePiece intersect = list.m_141921_(largerBB);
        if (intersect == null) {
            list.m_142679_((StructurePiece)eTower);
            eTower.m_142537_(this, list, rand);
            final BlockPos bc = this.offsetTowerCCoords(opening.m_123341_(), opening.m_123342_(), opening.m_123343_(), 1, facing);
            final FinalCastleBridgeComponent bridge = new FinalCastleBridgeComponent(this.getFeatureType(), this.m_73548_() + 1, bc.m_123341_(), bc.m_123342_(), bc.m_123343_(), howFar - 7, facing);
            list.m_142679_((StructurePiece)bridge);
            bridge.m_142537_(this, list, rand);
            this.addOpening(opening.m_123341_(), opening.m_123342_() + 1, opening.m_123343_(), facing);
            return true;
        }
        return false;
    }
    
    private boolean isWithinRange(final int centerX, final int centerZ, final int posX, final int posZ, final int range) {
        final boolean inRange = Math.abs(centerX - posX) < range && Math.abs(centerZ - posZ) < range;
        if (!inRange) {}
        return inRange;
    }
    
    public BlockPos getValidOpeningCC(final Random rand, final Direction facing) {
        final Rotation relative = RotationUtil.getRelativeRotation(this.m_73549_(), facing);
        final int floors = this.height / 8;
        if (relative == Rotation.NONE || relative == Rotation.CLOCKWISE_180) {
            final int rx = (relative == Rotation.NONE) ? 12 : 0;
            final int rz = 6;
            final int ry = rand.nextInt(floors) * 8;
            return new BlockPos(rx, ry, rz);
        }
        if (relative == Rotation.CLOCKWISE_90 || relative == Rotation.COUNTERCLOCKWISE_90) {
            final int rx = 6;
            final int rz = (relative == Rotation.CLOCKWISE_90) ? 12 : 0;
            final int ry = rand.nextInt(floors) * 8;
            return new BlockPos(rx, ry, rz);
        }
        return new BlockPos(0, 0, 0);
    }
    
    @Override
    protected BlockPos offsetTowerCCoords(final int x, final int y, final int z, final int howFar, final Direction direction) {
        int dx = this.m_73392_(x, z);
        final int dy = this.m_73544_(y);
        int dz = this.m_73525_(x, z);
        switch (direction) {
            case SOUTH: {
                dx += howFar;
                break;
            }
            case WEST: {
                dz += howFar;
                break;
            }
            case NORTH: {
                dx -= howFar;
                break;
            }
            case EAST: {
                dz -= howFar;
                break;
            }
        }
        return new BlockPos(dx, dy, dz);
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel worldIn, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final Random decoRNG = new Random(worldIn.m_7328_() + this.f_73383_.m_162395_() * 321534781L ^ this.f_73383_.m_162398_() * 756839L);
        this.m_73464_(worldIn, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1, false, rand, this.deco.randomBlocks);
        for (int x = 0; x < this.size; ++x) {
            for (int z = 0; z < this.size; ++z) {
                this.m_73528_(worldIn, this.deco.blockState, x, -1, z, sbb);
            }
        }
        for (int numBranches = 2 + decoRNG.nextInt(4) + decoRNG.nextInt(3), i = 0; i < numBranches; ++i) {
            this.makeGlyphBranches(worldIn, decoRNG, this.getGlyphColour(), sbb);
        }
        this.addFloors(worldIn, decoRNG, sbb);
        this.makeOpenings(worldIn, sbb);
        return true;
    }
    
    public BlockState getGlyphColour() {
        if (this.color == null) {
            TwilightForestMod.LOGGER.warn("Final Castle tower has null for glyph color, this is a bug.");
            return ((Block)TFBlocks.BLUE_CASTLE_RUNE_BRICK.get()).m_49966_();
        }
        return this.color;
    }
    
    private void addFloors(final WorldGenLevel world, final Random rand, final BoundingBox sbb) {
        final int floors = this.highestOpening / 8 + 1;
        Rotation rotation = Rotation.CLOCKWISE_90;
        for (int i = 1; i < floors; ++i) {
            this.m_73441_(world, sbb, 1, i * 8, 1, 11, i * 8, 11, this.deco.blockState, this.deco.blockState, false);
            rotation = rotation.m_55952_(Rotation.CLOCKWISE_180);
            this.addStairsDown(world, sbb, rotation, i * 8);
        }
        if (this.hasAccessibleRoof()) {
            this.addStairsDown(world, sbb, RotationUtil.ROTATIONS[floors + 2 & 0x3], this.height - 1);
        }
    }
    
    protected boolean hasAccessibleRoof() {
        return this.height - this.highestOpening < 9;
    }
    
    private void addStairsDown(final WorldGenLevel world, final BoundingBox sbb, final Rotation rotation, final int y) {
        for (int i = 0; i < 4; ++i) {
            final int sx = 8 - i;
            final int sy = y - i;
            final int sz = 9;
            this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.WEST, false), sx, sy, sz, rotation, sbb);
            this.setBlockStateRotated(world, this.deco.blockState, sx, sy - 1, sz, rotation, sbb);
            this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.WEST, false), sx, sy, sz - 1, rotation, sbb);
            this.setBlockStateRotated(world, this.deco.blockState, sx, sy - 1, sz - 1, rotation, sbb);
            this.fillAirRotated(world, sbb, sx, sy + 1, sz - 1, sx, sy + 3, sz, rotation);
        }
        this.fillBlocksRotated(world, sbb, 3, y - 4, 8, 4, y - 4, 9, this.deco.blockState, rotation);
        for (int i = 0; i < 4; ++i) {
            final int sx = 4;
            final int sy = y - i - 4;
            final int sz = 7 - i;
            this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.NORTH, false), sx, sy, sz, rotation, sbb);
            this.setBlockStateRotated(world, this.deco.blockState, sx, sy - 1, sz, rotation, sbb);
            this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.NORTH, false), sx - 1, sy, sz, rotation, sbb);
            this.setBlockStateRotated(world, this.deco.blockState, sx - 1, sy - 1, sz, rotation, sbb);
            this.fillAirRotated(world, sbb, sx, sy + 1, sz, sx - 1, sy + 3, sz, rotation);
        }
    }
    
    @Override
    protected void makeDoorOpening(final WorldGenLevel world, final int dx, final int dy, final int dz, final BoundingBox sbb) {
        final BlockState doorState = this.doorColor();
        if (dx == 0 || dx == this.size - 1) {
            this.m_73441_(world, sbb, dx, dy - 1, dz - 2, dx, dy + 4, dz + 2, this.deco.accentState, FinalCastleMazeTower13Component.AIR, false);
            this.m_73441_(world, sbb, dx, dy, dz - 1, dx, dy + 3, dz + 1, doorState, FinalCastleMazeTower13Component.AIR, false);
        }
        if (dz == 0 || dz == this.size - 1) {
            this.m_73441_(world, sbb, dx - 2, dy - 1, dz, dx + 2, dy + 4, dz, this.deco.accentState, FinalCastleMazeTower13Component.AIR, false);
            this.m_73441_(world, sbb, dx - 1, dy, dz, dx + 1, dy + 3, dz, doorState, FinalCastleMazeTower13Component.AIR, false);
        }
    }
    
    public BlockState doorColor() {
        if (this.color == ((Block)TFBlocks.PINK_CASTLE_RUNE_BRICK.get()).m_49966_()) {
            return ((Block)TFBlocks.PINK_CASTLE_DOOR.get()).m_49966_();
        }
        if (this.color == ((Block)TFBlocks.BLUE_CASTLE_RUNE_BRICK.get()).m_49966_()) {
            return ((Block)TFBlocks.BLUE_CASTLE_DOOR.get()).m_49966_();
        }
        if (this.color == ((Block)TFBlocks.YELLOW_CASTLE_RUNE_BRICK.get()).m_49966_()) {
            return ((Block)TFBlocks.YELLOW_CASTLE_DOOR.get()).m_49966_();
        }
        if (this.color == ((Block)TFBlocks.VIOLET_CASTLE_RUNE_BRICK.get()).m_49966_()) {
            return ((Block)TFBlocks.VIOLET_CASTLE_DOOR.get()).m_49966_();
        }
        TwilightForestMod.LOGGER.warn("Couldn't add door to tower, rune color couldn't be read");
        return Blocks.f_50016_.m_49966_();
    }
}
