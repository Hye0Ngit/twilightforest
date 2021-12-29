// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.darktower;

import net.minecraft.core.Vec3i;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.RepeaterBlock;
import net.minecraft.world.level.block.DiodeBlock;
import net.minecraft.world.level.block.LeverBlock;
import net.minecraft.world.level.block.FaceAttachedHorizontalDirectionalBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.DirectionalBlock;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.entity.EntityType;
import twilightforest.entity.TFEntities;
import twilightforest.loot.TFTreasure;
import twilightforest.world.components.structures.TFStructureDecorator;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import twilightforest.world.components.structures.lichtower.TowerRoofFenceComponent;
import twilightforest.world.components.structures.lichtower.TowerRoofAttachedSlabComponent;
import twilightforest.world.components.structures.lichtower.TowerRoofSlabForwardsComponent;
import twilightforest.world.components.structures.lichtower.TowerRoofGableForwardsComponent;
import twilightforest.world.components.structures.lichtower.TowerRoofComponent;
import twilightforest.util.RotationUtil;
import net.minecraft.world.level.block.Rotation;
import twilightforest.world.components.structures.TFStructureComponentOld;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import java.util.Iterator;
import net.minecraft.core.Direction;
import twilightforest.world.registration.TFFeature;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import java.util.ArrayList;
import twilightforest.world.components.structures.lichtower.TowerWingComponent;

public class DarkTowerWingComponent extends TowerWingComponent
{
    protected boolean keyTower;
    protected ArrayList<EnumDarkTowerDoor> openingTypes;
    
    public DarkTowerWingComponent(final ServerLevel level, final CompoundTag nbt) {
        this(DarkTowerPieces.TFDTWin, nbt);
    }
    
    public DarkTowerWingComponent(final StructurePieceType piece, final CompoundTag nbt) {
        super(piece, nbt);
        this.keyTower = false;
        this.openingTypes = new ArrayList<EnumDarkTowerDoor>();
        this.keyTower = nbt.m_128471_("keyTower");
        this.readDoorsTypesFromArray(nbt.m_128465_("doorTypeInts"));
    }
    
    protected DarkTowerWingComponent(final StructurePieceType piece, final TFFeature feature, final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final Direction direction) {
        super(piece, feature, i, x, y, z, pSize, pHeight, direction);
        this.keyTower = false;
        this.openingTypes = new ArrayList<EnumDarkTowerDoor>();
    }
    
    private int[] getDoorsTypesAsIntArray() {
        final int[] ret = new int[this.openingTypes.size()];
        int idx = 0;
        for (final EnumDarkTowerDoor doorType : this.openingTypes) {
            ret[idx++] = doorType.ordinal();
        }
        return ret;
    }
    
    @Override
    protected void m_142347_(final ServerLevel level, final CompoundTag tagCompound) {
        super.m_142347_(level, tagCompound);
        tagCompound.m_128379_("keyTower", this.keyTower);
        tagCompound.m_128385_("doorTypeInts", this.getDoorsTypesAsIntArray());
    }
    
    private void readDoorsTypesFromArray(final int[] intArray) {
        for (final int typeInt : intArray) {
            this.openingTypes.add(EnumDarkTowerDoor.values()[typeInt]);
        }
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
        this.addOpening(0, 1, this.size / 2, Rotation.CLOCKWISE_180);
        this.makeARoof(parent, list, rand);
        this.makeABeard(parent, list, rand);
        if (this.size > 10) {
            for (final Rotation direction : RotationUtil.ROTATIONS) {
                final int[] dest = this.getValidOpening(rand, direction);
                final int childHeight = this.validateChildHeight(this.height - 4 + rand.nextInt(10) - rand.nextInt(10));
                final boolean madeWing = this.makeTowerWing(list, rand, this.m_73548_(), dest[0], dest[1], dest[2], this.size - 2, childHeight, direction);
                if (!madeWing && (direction == Rotation.CLOCKWISE_180 || rand.nextBoolean())) {
                    this.makeTowerBalcony(list, rand, this.m_73548_(), dest[0], dest[1], dest[2], direction);
                }
            }
        }
        else if (rand.nextInt(4) == 0) {
            final Rotation direction2 = RotationUtil.ROTATIONS[rand.nextInt(4)];
            final int[] dest2 = this.getValidOpening(rand, direction2);
            this.makeTowerBalcony(list, rand, this.m_73548_(), dest2[0], dest2[1], dest2[2], direction2);
        }
    }
    
    protected int validateChildHeight(final int childHeight) {
        return childHeight / 4 * 4 + 1;
    }
    
    @Override
    public void makeARoof(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        final int index = this.m_73548_();
        TowerRoofComponent towerRoofComponent = switch (rand.nextInt(5)) {
            case 2 -> new DarkTowerRoofCactusComponent(this.getFeatureType(), index, this, this.m_142171_().m_123341_(), this.m_142171_().m_123342_(), this.m_142171_().m_123343_());
            case 3 -> new DarkTowerRoofRingsComponent(this.getFeatureType(), index, this, this.m_142171_().m_123341_(), this.m_142171_().m_123342_(), this.m_142171_().m_123343_());
            case 4 -> new DarkTowerRoofFourPostComponent(this.getFeatureType(), index, this, this.m_142171_().m_123341_(), this.m_142171_().m_123342_(), this.m_142171_().m_123343_());
            default -> new DarkTowerRoofAntennaComponent(this.getFeatureType(), index, this, this.m_142171_().m_123341_(), this.m_142171_().m_123342_(), this.m_142171_().m_123343_());
        };
        final TowerRoofComponent roof = towerRoofComponent;
        list.m_142679_((StructurePiece)roof);
        roof.m_142537_((StructurePiece)this, list, rand);
        this.roofType = roof.getClass();
    }
    
    @Override
    protected void makeAttachedRoof(final StructurePieceAccessor list, final Random rand) {
        final int index = this.m_73548_();
        if (this.roofType == null && rand.nextInt(32) != 0) {
            this.tryToFitRoof(list, rand, new TowerRoofGableForwardsComponent(this.getFeatureType(), index + 1, this, this.m_142171_().m_123341_(), this.m_142171_().m_123342_(), this.m_142171_().m_123343_()));
        }
        if (this.roofType == null && rand.nextInt(8) != 0) {
            this.tryToFitRoof(list, rand, new TowerRoofSlabForwardsComponent(this.getFeatureType(), index + 1, this, this.m_142171_().m_123341_(), this.m_142171_().m_123342_(), this.m_142171_().m_123343_()));
        }
        if (this.roofType == null && rand.nextInt(32) != 0) {
            final TowerRoofComponent roof = new TowerRoofAttachedSlabComponent(this.getFeatureType(), index + 1, this, this.m_142171_().m_123341_(), this.m_142171_().m_123342_(), this.m_142171_().m_123343_());
            this.tryToFitRoof(list, rand, roof);
        }
        if (this.roofType == null) {
            final TowerRoofComponent roof = new TowerRoofFenceComponent(this.getFeatureType(), index + 1, this, this.m_142171_().m_123341_(), this.m_142171_().m_123342_(), this.m_142171_().m_123343_());
            this.tryToFitRoof(list, rand, roof);
        }
    }
    
    @Override
    public void makeABeard(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        final DarkTowerBeardComponent beard = new DarkTowerBeardComponent(this.getFeatureType(), this.m_73548_() + 1, this, this.m_142171_().m_123341_(), this.m_142171_().m_123342_(), this.m_142171_().m_123343_());
        list.m_142679_((StructurePiece)beard);
        beard.m_142537_((StructurePiece)this, list, rand);
    }
    
    @Override
    public boolean makeTowerWing(final StructurePieceAccessor list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final Rotation rotation) {
        if (wingHeight < 8) {
            return false;
        }
        final Direction direction = this.getStructureRelativeRotation(rotation);
        final int[] dx = this.offsetTowerCoords(x, y, z, 5, direction);
        if (dx[1] + wingHeight > 250) {
            return false;
        }
        final DarkTowerBridgeComponent bridge = new DarkTowerBridgeComponent(DarkTowerPieces.TFDTBri, this.getFeatureType(), index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
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
    
    protected boolean makeTowerBalcony(final StructurePieceAccessor list, final Random rand, final int index, final int x, final int y, final int z, final Rotation rotation) {
        final Direction direction = this.getStructureRelativeRotation(rotation);
        final int[] dx = this.offsetTowerCoords(x, y, z, 5, direction);
        final DarkTowerBalconyComponent balcony = new DarkTowerBalconyComponent(this.getFeatureType(), index, dx[0], dx[1], dx[2], direction);
        final StructurePiece intersect = list.m_141921_(balcony.m_73547_());
        if (intersect == null || intersect == this) {
            list.m_142679_((StructurePiece)balcony);
            balcony.m_142537_(this, list, rand);
            this.addOpening(x, y, z, rotation, EnumDarkTowerDoor.REAPPEARING);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final Random decoRNG = new Random(world.m_7328_() + this.f_73383_.m_162395_() * 321534781L ^ this.f_73383_.m_162398_() * 756839L);
        this.makeEncasedWalls(world, rand, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1);
        this.m_73535_(world, sbb, 1, 1, 1, this.size - 2, this.height - 2, this.size - 2);
        if (this.size > 9) {
            this.addHalfFloors(world, decoRNG, sbb, 4, this.height - 1);
        }
        else if (decoRNG.nextInt(3) == 0) {
            this.addSmallTimberBeams(world, decoRNG, sbb, 4, this.height - 1);
        }
        else {
            this.addHalfFloors(world, decoRNG, sbb, 4, this.height - 1);
        }
        this.makeOpenings(world, sbb);
        if (decoRNG.nextBoolean() && !this.isKeyTower() && this.height > 8) {
            int blobs = 1;
            if (this.size > 9 && decoRNG.nextBoolean()) {
                ++blobs;
            }
            for (int i = 0; i < blobs; ++i) {
                final int x = decoRNG.nextInt(this.size);
                final int y = decoRNG.nextInt(this.height - 7) + 2;
                final int z = decoRNG.nextInt(this.size);
                this.destroyTower(world, decoRNG, x, y, z, 3, sbb);
            }
        }
        return true;
    }
    
    protected void destroyTower(final WorldGenLevel world, final Random decoRNG, final int x, final int y, final int z, final int amount, final BoundingBox sbb) {
        final int initialRadius = decoRNG.nextInt(amount) + amount;
        this.drawBlob(world, x, y, z, initialRadius, DarkTowerWingComponent.AIR, sbb);
        for (int i = 0; i < 3; ++i) {
            final int dx = x + (initialRadius - 1) * (decoRNG.nextBoolean() ? 1 : -1);
            final int dy = y + (initialRadius - 1) * (decoRNG.nextBoolean() ? 1 : -1);
            final int dz = z + (initialRadius - 1) * (decoRNG.nextBoolean() ? 1 : -1);
            this.netherTransformBlob(world, decoRNG, dx, dy, dz, initialRadius - 1, sbb);
            this.drawBlob(world, dx, dy, dz, initialRadius - 2, DarkTowerWingComponent.AIR, sbb);
        }
    }
    
    private void netherTransformBlob(final WorldGenLevel world, final Random inRand, final int sx, final int sy, final int sz, final int rad, final BoundingBox sbb) {
        final Random rand = new Random(inRand.nextLong());
        for (byte dx = 0; dx <= rad; ++dx) {
            for (byte dy = 0; dy <= rad; ++dy) {
                for (byte dz = 0; dz <= rad; ++dz) {
                    byte dist;
                    if (dx >= dy && dx >= dz) {
                        dist = (byte)(dx + (byte)(Math.max(dy, dz) * 0.5 + Math.min(dy, dz) * 0.25));
                    }
                    else if (dy >= dx && dy >= dz) {
                        dist = (byte)(dy + (byte)(Math.max(dx, dz) * 0.5 + Math.min(dx, dz) * 0.25));
                    }
                    else {
                        dist = (byte)(dz + (byte)(Math.max(dx, dy) * 0.5 + Math.min(dx, dy) * 0.25));
                    }
                    if (dist <= rad) {
                        this.testAndChangeToNetherrack(world, rand, sx + dx, sy + dy, sz + dz, sbb);
                        this.testAndChangeToNetherrack(world, rand, sx + dx, sy + dy, sz + dz, sbb);
                        this.testAndChangeToNetherrack(world, rand, sx + dx, sy + dy, sz - dz, sbb);
                        this.testAndChangeToNetherrack(world, rand, sx - dx, sy + dy, sz + dz, sbb);
                        this.testAndChangeToNetherrack(world, rand, sx - dx, sy + dy, sz - dz, sbb);
                        this.testAndChangeToNetherrack(world, rand, sx + dx, sy - dy, sz + dz, sbb);
                        this.testAndChangeToNetherrack(world, rand, sx + dx, sy - dy, sz - dz, sbb);
                        this.testAndChangeToNetherrack(world, rand, sx - dx, sy - dy, sz + dz, sbb);
                        this.testAndChangeToNetherrack(world, rand, sx - dx, sy - dy, sz - dz, sbb);
                    }
                }
            }
        }
    }
    
    private void testAndChangeToNetherrack(final WorldGenLevel world, final Random rand, final int x, final int y, final int z, final BoundingBox sbb) {
        if (this.m_73398_((BlockGetter)world, x, y, z, sbb).m_60734_() != Blocks.f_50016_) {
            this.m_73434_(world, Blocks.f_50134_.m_49966_(), x, y, z, sbb);
            if (this.m_73398_((BlockGetter)world, x, y + 1, z, sbb).m_60734_() == Blocks.f_50016_ && rand.nextBoolean()) {
                this.m_73434_(world, Blocks.f_50083_.m_49966_(), x, y + 1, z, sbb);
            }
        }
    }
    
    private void drawBlob(final WorldGenLevel world, final int sx, final int sy, final int sz, final int rad, final BlockState state, final BoundingBox sbb) {
        for (byte dx = 0; dx <= rad; ++dx) {
            for (byte dy = 0; dy <= rad; ++dy) {
                for (byte dz = 0; dz <= rad; ++dz) {
                    byte dist;
                    if (dx >= dy && dx >= dz) {
                        dist = (byte)(dx + (byte)(Math.max(dy, dz) * 0.5 + Math.min(dy, dz) * 0.25));
                    }
                    else if (dy >= dx && dy >= dz) {
                        dist = (byte)(dy + (byte)(Math.max(dx, dz) * 0.5 + Math.min(dx, dz) * 0.25));
                    }
                    else {
                        dist = (byte)(dz + (byte)(Math.max(dx, dy) * 0.5 + Math.min(dx, dy) * 0.25));
                    }
                    if (dist <= rad) {
                        this.m_73434_(world, state, sx + dx, sy + dy, sz + dz, sbb);
                        this.m_73434_(world, state, sx + dx, sy + dy, sz - dz, sbb);
                        this.m_73434_(world, state, sx - dx, sy + dy, sz + dz, sbb);
                        this.m_73434_(world, state, sx - dx, sy + dy, sz - dz, sbb);
                        this.m_73434_(world, state, sx + dx, sy - dy, sz + dz, sbb);
                        this.m_73434_(world, state, sx + dx, sy - dy, sz - dz, sbb);
                        this.m_73434_(world, state, sx - dx, sy - dy, sz + dz, sbb);
                        this.m_73434_(world, state, sx - dx, sy - dy, sz - dz, sbb);
                    }
                }
            }
        }
    }
    
    private void addHalfFloors(final WorldGenLevel world, final Random rand, final BoundingBox sbb, int bottom, final int top) {
        final int spacing = 4;
        Rotation rotation = RotationUtil.ROTATIONS[(this.f_73383_.m_162396_() + bottom) % 3];
        if (bottom == 0) {
            bottom += spacing;
        }
        for (int y = bottom; y < top; y += spacing) {
            rotation = rotation.m_55952_(Rotation.CLOCKWISE_180);
            if (y >= top - spacing) {
                this.makeFullFloor(world, sbb, y);
                if (this.isDeadEnd()) {
                    this.decorateTreasureRoom(world, sbb, rotation, y, 4, this.deco);
                }
            }
            else {
                this.makeHalfFloor(world, sbb, rotation, y);
                switch (rand.nextInt(8)) {
                    case 0: {
                        if (this.size < 11) {
                            this.decorateReappearingFloor(world, sbb, rotation, y);
                            break;
                        }
                    }
                    case 1: {
                        this.decorateSpawner(world, rand, sbb, rotation, y);
                        break;
                    }
                    case 2: {
                        this.decorateLounge(world, sbb, rotation, y);
                        break;
                    }
                    case 3: {
                        this.decorateLibrary(world, sbb, rotation, y);
                        break;
                    }
                    case 4: {
                        this.decorateExperimentPulser(world, sbb, rotation, y);
                        break;
                    }
                    case 5: {
                        this.decorateExperimentLamp(world, sbb, rotation, y);
                        break;
                    }
                    case 6: {
                        this.decoratePuzzleChest(world, sbb, rotation, y);
                        break;
                    }
                }
            }
            this.addStairsDown(world, sbb, rotation, y, this.size - 2, spacing);
            if (this.size > 9) {
                this.addStairsDown(world, sbb, rotation, y, this.size - 3, spacing);
            }
        }
        rotation = rotation.m_55952_(Rotation.CLOCKWISE_180);
        this.addStairsDown(world, sbb, rotation, this.height - 1, this.size - 2, spacing);
    }
    
    protected void makeHalfFloor(final WorldGenLevel world, final BoundingBox sbb, final Rotation rotation, final int y) {
        this.fillBlocksRotated(world, sbb, this.size / 2, y, 1, this.size - 2, y, this.size - 2, this.deco.blockState, rotation);
        this.fillBlocksRotated(world, sbb, this.size / 2 - 1, y, 1, this.size / 2 - 1, y, this.size - 2, this.deco.accentState, rotation);
    }
    
    protected void makeFullFloor(final WorldGenLevel world, final BoundingBox sbb, final int y) {
        this.m_73441_(world, sbb, 1, y, 1, this.size - 2, y, this.size - 2, this.deco.blockState, Blocks.f_50016_.m_49966_(), false);
        this.m_73441_(world, sbb, this.size / 2, y, 1, this.size / 2, y, this.size - 2, this.deco.accentState, Blocks.f_50016_.m_49966_(), true);
    }
    
    protected void decorateTreasureRoom(final WorldGenLevel world, final BoundingBox sbb, final Rotation rotation, final int y, final int spacing, final TFStructureDecorator myDeco) {
        final int x = this.size / 2;
        final int z = this.size / 2;
        this.makePillarFrame(world, sbb, this.deco, rotation, x - 1, y, z - 1, true);
        this.setBlockStateRotated(world, myDeco.platformState, x, y + 1, z, rotation, sbb);
        this.placeTreasureAtCurrentPosition(world, x, y + 2, z, this.isKeyTower() ? TFTreasure.DARKTOWER_KEY : TFTreasure.DARKTOWER_CACHE, sbb);
    }
    
    private void decorateSpawner(final WorldGenLevel world, final Random rand, final BoundingBox sbb, final Rotation rotation, final int y) {
        final int x = (this.size > 9) ? 4 : 3;
        final int z = (this.size > 9) ? 5 : 4;
        EntityType<?> mobID;
        if (this.size > 9) {
            mobID = (EntityType<?>)(rand.nextBoolean() ? TFEntities.CARMINITE_GOLEM : TFEntities.CARMINITE_BROODLING);
        }
        else {
            mobID = TFEntities.CARMINITE_BROODLING;
        }
        this.makePillarFrame(world, sbb, this.deco, rotation, x, y, z, true);
        this.setSpawnerRotated(world, x + 1, y + 2, z + 1, rotation, mobID, sbb);
    }
    
    private void decorateLounge(final WorldGenLevel world, final BoundingBox sbb, final Rotation rotation, final int y) {
        int cx = (this.size > 9) ? 9 : 7;
        final int cz = (this.size > 9) ? 4 : 3;
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.SOUTH, false), cx, y + 1, cz, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.WEST, false), cx, y + 1, cz + 1, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.NORTH, false), cx, y + 1, cz + 2, rotation, sbb);
        cx = ((this.size > 9) ? 5 : 3);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.SOUTH, true), cx, y + 1, cz, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getSlabState(Blocks.f_50399_.m_49966_(), SlabType.TOP), cx, y + 1, cz + 1, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.NORTH, true), cx, y + 1, cz + 2, rotation, sbb);
    }
    
    private void decorateReappearingFloor(final WorldGenLevel world, final BoundingBox sbb, final Rotation rotation, final int y) {
        final BlockState inactiveReappearing = ((Block)TFBlocks.REAPPEARING_BLOCK.get()).m_49966_();
        final BlockState woodenPressurePlate = Blocks.f_50167_.m_49966_();
        this.fillBlocksRotated(world, sbb, 4, y, 3, 7, y, 5, inactiveReappearing, rotation);
        this.fillBlocksRotated(world, sbb, 4, y + 1, 2, 7, y + 1, 2, woodenPressurePlate, rotation);
        this.fillBlocksRotated(world, sbb, 4, y + 1, 6, 7, y + 1, 6, woodenPressurePlate, rotation);
    }
    
    private void decorateExperimentLamp(final WorldGenLevel world, final BoundingBox sbb, final Rotation rotation, final int y) {
        final int cx = (this.size > 9) ? 5 : 3;
        final int cz = (this.size > 9) ? 5 : 4;
        final BlockState redstoneLamp = Blocks.f_50261_.m_49966_();
        this.setBlockStateRotated(world, (BlockState)Blocks.f_50032_.m_49966_().m_61124_((Property)DirectionalBlock.f_52588_, (Comparable)Direction.UP), cx, y + 1, cz, rotation, sbb);
        this.setBlockStateRotated(world, redstoneLamp, cx, y + 2, cz, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.accentState, cx, y + 1, cz + 1, rotation, sbb);
        this.setBlockStateRotated(world, getLeverState(Blocks.f_50164_.m_49966_(), AttachFace.WALL, Direction.NORTH, false), cx, y + 1, cz + 2, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.accentState, cx, y + 3, cz - 1, rotation, sbb);
        this.setBlockStateRotated(world, getLeverState(Blocks.f_50164_.m_49966_(), AttachFace.WALL, Direction.SOUTH, true), cx, y + 3, cz - 2, rotation, sbb);
    }
    
    protected static BlockState getLeverState(final BlockState initialState, final AttachFace face, Direction direction, final boolean isPowered) {
        switch (direction) {
            case NORTH:
            case SOUTH:
            case EAST:
            case WEST: {
                break;
            }
            default: {
                direction = Direction.NORTH;
                break;
            }
        }
        return (BlockState)((BlockState)((BlockState)initialState.m_61124_((Property)HorizontalDirectionalBlock.f_54117_, (Comparable)direction)).m_61124_((Property)FaceAttachedHorizontalDirectionalBlock.f_53179_, (Comparable)face)).m_61124_((Property)LeverBlock.f_54622_, (Comparable)isPowered);
    }
    
    private void decorateExperimentPulser(final WorldGenLevel world, final BoundingBox sbb, final Rotation rotation, final int y) {
        final int cx = (this.size > 9) ? 6 : 5;
        final int cz = (this.size > 9) ? 4 : 3;
        final BlockState redstoneWire = Blocks.f_50088_.m_49966_();
        final BlockState woodenPressurePlate = Blocks.f_50167_.m_49966_();
        final BlockState stickyPiston = (BlockState)Blocks.f_50032_.m_49966_().m_61124_((Property)DirectionalBlock.f_52588_, (Comparable)Direction.SOUTH);
        final BlockState unpoweredRepeater = (BlockState)((BlockState)((BlockState)Blocks.f_50146_.m_49966_().m_61124_((Property)DiodeBlock.f_52496_, (Comparable)false)).m_61124_((Property)HorizontalDirectionalBlock.f_54117_, (Comparable)Direction.WEST)).m_61124_((Property)RepeaterBlock.f_55798_, (Comparable)2);
        this.setBlockStateRotated(world, stickyPiston, cx, y + 1, cz + 1, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.accentState, cx, y + 1, cz, rotation, sbb);
        this.setBlockStateRotated(world, redstoneWire, cx + 1, y + 1, cz, rotation, sbb);
        this.setBlockStateRotated(world, woodenPressurePlate, cx + 2, y + 1, cz, rotation, sbb);
        this.setBlockStateRotated(world, unpoweredRepeater, cx - 1, y + 1, cz, rotation, sbb);
        this.setBlockStateRotated(world, redstoneWire, cx - 2, y + 1, cz, rotation, sbb);
        this.setBlockStateRotated(world, redstoneWire, cx - 2, y + 1, cz + 1, rotation, sbb);
        this.setBlockStateRotated(world, redstoneWire, cx - 1, y + 1, cz + 1, rotation, sbb);
    }
    
    private void decorateLibrary(final WorldGenLevel world, final BoundingBox sbb, final Rotation rotation, final int y) {
        int bx = (this.size > 9) ? 4 : 3;
        int bz = (this.size > 9) ? 3 : 2;
        this.makeSmallBookshelf(world, sbb, rotation, y, bx, bz);
        bx = ((this.size > 9) ? 9 : 7);
        bz = ((this.size > 9) ? 3 : 2);
        this.makeSmallBookshelf(world, sbb, rotation, y, bx, bz);
    }
    
    protected void makeSmallBookshelf(final WorldGenLevel world, final BoundingBox sbb, final Rotation rotation, final int y, final int bx, final int bz) {
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.NORTH, false), bx, y + 1, bz, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.NORTH, true), bx, y + 2, bz, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.SOUTH, false), bx, y + 1, bz + 3, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.SOUTH, true), bx, y + 2, bz + 3, rotation, sbb);
        final BlockState bookshelf = Blocks.f_50078_.m_49966_();
        this.setBlockStateRotated(world, bookshelf, bx, y + 1, bz + 1, rotation, sbb);
        this.setBlockStateRotated(world, bookshelf, bx, y + 2, bz + 1, rotation, sbb);
        this.setBlockStateRotated(world, bookshelf, bx, y + 1, bz + 2, rotation, sbb);
        this.setBlockStateRotated(world, bookshelf, bx, y + 2, bz + 2, rotation, sbb);
    }
    
    private void decoratePuzzleChest(final WorldGenLevel world, final BoundingBox sbb, final Rotation rotation, final int y) {
        final int x = (this.size > 9) ? 4 : 3;
        final int z = (this.size > 9) ? 5 : 4;
        this.makePillarFrame(world, sbb, this.deco, rotation, x, y, z, true);
        this.setBlockStateRotated(world, this.deco.platformState, x + 1, y + 1, z + 1, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.blockState, x + 2, y + 1, z + 1, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.blockState, x, y + 1, z + 1, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.blockState, x + 1, y + 1, z + 2, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.blockState, x + 1, y + 1, z, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.blockState, x + 2, y + 3, z + 1, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.blockState, x, y + 3, z + 1, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.blockState, x + 1, y + 3, z + 2, rotation, sbb);
        this.setBlockStateRotated(world, DarkTowerWingComponent.AIR, x + 1, y + 3, z, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.blockState, x + 1, y + 3, z + 1, rotation, sbb);
        this.setBlockStateRotated(world, (BlockState)Blocks.f_50032_.m_49966_().m_61124_((Property)DirectionalBlock.f_52588_, (Comparable)Direction.NORTH), x + 1, y + 3, z - 1, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.accentState, x + 1, y + 3, z - 2, rotation, sbb);
        this.setBlockStateRotated(world, getLeverState(Blocks.f_50164_.m_49966_(), AttachFace.WALL, Direction.WEST, false), x + 2, y + 3, z - 2, rotation, sbb);
        this.placeTreasureRotated(world, x + 1, y + 2, z + 1, this.m_73549_(), rotation, TFTreasure.DARKTOWER_CACHE, sbb);
    }
    
    protected void makePillarFrame(final WorldGenLevel world, final BoundingBox sbb, final TFStructureDecorator myDeco, final Rotation rotation, final int x, final int y, final int z, final boolean fenced) {
        this.makePillarFrame(world, sbb, myDeco, rotation, x, y, z, 3, 3, 3, fenced);
    }
    
    protected void makePillarFrame(final WorldGenLevel world, final BoundingBox sbb, final TFStructureDecorator myDeco, final Rotation rotation, final int x, final int y, final int z, final int width, final int height, final int length, final boolean fenced) {
        for (int dx = 0; dx < width; ++dx) {
            for (int dz = 0; dz < length; ++dz) {
                if ((dx % 3 == 0 || dx == width - 1) && (dz % 3 == 0 || dz == length - 1)) {
                    for (int py = 1; py <= height; ++py) {
                        this.setBlockStateRotated(world, myDeco.pillarState, x + dx, y + py, z + dz, rotation, sbb);
                    }
                }
                else {
                    if (dx == 0) {
                        final BlockState southStairs = TFStructureComponentOld.getStairState(this.deco.stairState, Direction.WEST, false);
                        this.setBlockStateRotated(world, southStairs, x + dx, y + 1, z + dz, rotation, sbb);
                        this.setBlockStateRotated(world, (BlockState)southStairs.m_61124_((Property)StairBlock.f_56842_, (Comparable)Half.TOP), x + dx, y + height, z + dz, rotation, sbb);
                    }
                    else if (dx == width - 1) {
                        final BlockState northStairs = TFStructureComponentOld.getStairState(this.deco.stairState, Direction.EAST, false);
                        this.setBlockStateRotated(world, northStairs, x + dx, y + 1, z + dz, rotation, sbb);
                        this.setBlockStateRotated(world, (BlockState)northStairs.m_61124_((Property)StairBlock.f_56842_, (Comparable)Half.TOP), x + dx, y + height, z + dz, rotation, sbb);
                    }
                    else if (dz == 0) {
                        final BlockState westStairs = TFStructureComponentOld.getStairState(this.deco.stairState, Direction.NORTH, false);
                        this.setBlockStateRotated(world, westStairs, x + dx, y + 1, z + dz, rotation, sbb);
                        this.setBlockStateRotated(world, (BlockState)westStairs.m_61124_((Property)StairBlock.f_56842_, (Comparable)Half.TOP), x + dx, y + height, z + dz, rotation, sbb);
                    }
                    else if (dz == length - 1) {
                        final BlockState eastStairs = TFStructureComponentOld.getStairState(this.deco.stairState, Direction.SOUTH, false);
                        this.setBlockStateRotated(world, eastStairs, x + dx, y + 1, z + dz, rotation, sbb);
                        this.setBlockStateRotated(world, (BlockState)eastStairs.m_61124_((Property)StairBlock.f_56842_, (Comparable)Half.TOP), x + dx, y + height, z + dz, rotation, sbb);
                    }
                    if (fenced && (dx == 0 || dx == width - 1 || dz == 0 || dz == length - 1)) {
                        for (int fy = 2; fy <= height - 1; ++fy) {
                            this.setBlockStateRotated(world, myDeco.fenceState, x + dx, y + fy, z + dz, rotation, sbb);
                        }
                    }
                }
            }
        }
    }
    
    protected void addStairsDown(final WorldGenLevel world, final BoundingBox sbb, final Rotation rotation, final int y, final int sz, final int spacing) {
        for (int i = 0; i < spacing; ++i) {
            final int sx = this.size - 3 - i;
            this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.WEST, false), sx, y - i, sz, rotation, sbb);
            this.setBlockStateRotated(world, this.deco.accentState, sx, y - 1 - i, sz, rotation, sbb);
            this.setBlockStateRotated(world, DarkTowerWingComponent.AIR, sx, y + 1 - i, sz, rotation, sbb);
            this.setBlockStateRotated(world, DarkTowerWingComponent.AIR, sx, y + 2 - i, sz, rotation, sbb);
            this.setBlockStateRotated(world, DarkTowerWingComponent.AIR, sx - 1, y + 2 - i, sz, rotation, sbb);
            this.setBlockStateRotated(world, DarkTowerWingComponent.AIR, sx, y + 3 - i, sz, rotation, sbb);
            this.setBlockStateRotated(world, DarkTowerWingComponent.AIR, sx - 1, y + 3 - i, sz, rotation, sbb);
        }
    }
    
    protected void addSmallTimberBeams(final WorldGenLevel world, final Random rand, final BoundingBox sbb, int bottom, final int top) {
        final int spacing = 4;
        Rotation rotation = Rotation.NONE;
        if (bottom == 0) {
            bottom += spacing;
        }
        for (int y = bottom; y < top; y += spacing) {
            rotation = rotation.m_55952_(Rotation.CLOCKWISE_90);
            if (y >= top - spacing && this.isDeadEnd()) {
                this.makeTimberFloor(world, sbb, rotation, y);
                final TFStructureDecorator logDeco = new StructureDecoratorDarkTower();
                logDeco.pillarState = ((RotatedPillarBlock)TFBlocks.DARK_LOG.get()).m_49966_();
                logDeco.platformState = ((RotatedPillarBlock)TFBlocks.DARK_LOG.get()).m_49966_();
                this.decorateTreasureRoom(world, sbb, rotation, y, 4, logDeco);
            }
            else {
                final int y2;
                this.makeSmallTimberBeams(world, rand, sbb, rotation, y2, (y2 = y) == bottom && bottom != spacing);
            }
        }
    }
    
    protected void makeTimberFloor(final WorldGenLevel world, final BoundingBox sbb, final Rotation rotation, final int y) {
        final BlockState beamID = ((RotatedPillarBlock)TFBlocks.DARK_LOG.get()).m_49966_();
        final BlockState beamStateNS = (BlockState)beamID.m_61124_((Property)RotatedPillarBlock.f_55923_, (Comparable)Direction.Axis.Z);
        final BlockState beamStateUD = (BlockState)beamID.m_61124_((Property)RotatedPillarBlock.f_55923_, (Comparable)Direction.Axis.Y);
        final BlockState beamStateEW = (BlockState)beamID.m_61124_((Property)RotatedPillarBlock.f_55923_, (Comparable)Direction.Axis.X);
        for (int z = 1; z < this.size - 1; ++z) {
            for (int x = 1; x < this.size - 1; ++x) {
                if (x < z) {
                    this.setBlockStateRotated(world, beamStateNS, x, y, z, rotation, sbb);
                }
                else {
                    this.setBlockStateRotated(world, beamStateEW, x, y, z, rotation, sbb);
                }
            }
        }
        for (int by = 1; by < 4; ++by) {
            final BlockState ladder = Blocks.f_50155_.m_49966_();
            this.setBlockStateRotated(world, beamStateUD, 2, y - by, 2, rotation, sbb);
            this.setBlockStateRotated(world, (BlockState)ladder.m_61124_((Property)LadderBlock.f_54337_, (Comparable)Direction.WEST), 3, y - by, 2, rotation, sbb);
            this.setBlockStateRotated(world, beamStateUD, 6, y - by, 6, rotation, sbb);
            this.setBlockStateRotated(world, (BlockState)ladder.m_61124_((Property)LadderBlock.f_54337_, (Comparable)Direction.EAST), 5, y - by, 6, rotation, sbb);
        }
        this.setBlockStateRotated(world, DarkTowerWingComponent.AIR, 3, y, 2, rotation, sbb);
        this.setBlockStateRotated(world, DarkTowerWingComponent.AIR, 5, y, 6, rotation, sbb);
    }
    
    protected void makeSmallTimberBeams(final WorldGenLevel world, final Random rand, final BoundingBox sbb, final Rotation rotation, final int y, final boolean bottom) {
        final BlockState beamID = ((RotatedPillarBlock)TFBlocks.DARK_LOG.get()).m_49966_();
        final BlockState beamStateNS = (BlockState)beamID.m_61124_((Property)RotatedPillarBlock.f_55923_, (Comparable)Direction.Axis.X);
        final BlockState beamStateUD = (BlockState)beamID.m_61124_((Property)RotatedPillarBlock.f_55923_, (Comparable)Direction.Axis.Y);
        final BlockState beamStateEW = (BlockState)beamID.m_61124_((Property)RotatedPillarBlock.f_55923_, (Comparable)Direction.Axis.Z);
        for (int z = 1; z < this.size - 1; ++z) {
            this.setBlockStateRotated(world, beamStateEW, 2, y, z, rotation, sbb);
            this.setBlockStateRotated(world, beamStateEW, 6, y, z, rotation, sbb);
        }
        int z = this.pickBetweenExcluding(3, this.size - 3, rand, 2, 2, 6);
        for (int x = 3; x < 6; ++x) {
            this.setBlockStateRotated(world, beamStateNS, x, y, z, rotation, sbb);
        }
        final int x2 = 2;
        final int z2 = rand.nextBoolean() ? 2 : 6;
        final int x3 = 6;
        final int z3 = rand.nextBoolean() ? 2 : 6;
        for (int by = 1; by < 4; ++by) {
            final BlockState ladder = Blocks.f_50155_.m_49966_();
            if (!bottom || this.checkPost(world, x2, y - 4, z2, rotation, sbb)) {
                this.setBlockStateRotated(world, beamStateUD, x2, y - by, z2, rotation, sbb);
                this.setBlockStateRotated(world, (BlockState)ladder.m_61124_((Property)LadderBlock.f_54337_, (Comparable)Direction.WEST), x2 + 1, y - by, z2, rotation, sbb);
            }
            if (!bottom || this.checkPost(world, x3, y - 4, z3, rotation, sbb)) {
                this.setBlockStateRotated(world, beamStateUD, x3, y - by, z3, rotation, sbb);
                this.setBlockStateRotated(world, (BlockState)ladder.m_61124_((Property)LadderBlock.f_54337_, (Comparable)Direction.EAST), x3 - 1, y - by, z3, rotation, sbb);
            }
        }
    }
    
    protected int pickBetweenExcluding(final int low, final int high, final Random rand, final int k, final int l, final int m) {
        int result;
        do {
            result = rand.nextInt(high - low) + low;
        } while (result == k || result == l || result == m);
        return result;
    }
    
    protected int pickFrom(final Random rand, final int i, final int j, final int k) {
        return switch (rand.nextInt(3)) {
            case 1 -> j;
            case 2 -> k;
            default -> i;
        };
    }
    
    protected boolean checkPost(final WorldGenLevel world, final int x, final int y, final int z, final Rotation rotation, final BoundingBox sbb) {
        final int worldX = this.getXWithOffsetRotated(x, z, rotation);
        final int worldY = this.m_73544_(y);
        final int worldZ = this.getZWithOffsetRotated(x, z, rotation);
        final BlockPos vec = new BlockPos(worldX, worldY, worldZ);
        if (!sbb.m_71051_((Vec3i)vec)) {
            return false;
        }
        final BlockState blockState = world.m_8055_(vec);
        return blockState.m_60734_() != Blocks.f_50016_ && blockState != this.deco.accentState;
    }
    
    protected void makeEncasedWalls(final WorldGenLevel world, final Random rand, final BoundingBox sbb, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ) {
        for (int x = minX; x <= maxX; ++x) {
            for (int y = minY; y <= maxY; ++y) {
                for (int z = minZ; z <= maxZ; ++z) {
                    if (x == minX || x == maxX || y == minY || y == maxY || z == minZ || z == maxZ) {
                        if (((y == minY || y == maxY) && (x == minY || x == maxX || z == minZ || z == maxZ)) || ((z == minZ || z == maxZ) && (x == minY || x == maxX || y == minY || y == maxY))) {
                            this.m_73434_(world, this.deco.accentState, x, y, z, sbb);
                        }
                        else {
                            final StructurePiece.BlockSelector blocker = this.deco.randomBlocks;
                            blocker.m_7889_(rand, x, y, z, true);
                            this.m_73434_(world, blocker.m_73555_(), x, y, z, sbb);
                        }
                    }
                }
            }
        }
        this.m_73434_(world, this.deco.accentState, minX + 1, minY + 1, minZ, sbb);
        this.m_73434_(world, this.deco.accentState, minX + 1, minY + 1, maxZ, sbb);
        this.m_73434_(world, this.deco.accentState, maxX - 1, minY + 1, minZ, sbb);
        this.m_73434_(world, this.deco.accentState, maxX - 1, minY + 1, maxZ, sbb);
        this.m_73434_(world, this.deco.accentState, minX + 1, maxY - 1, minZ, sbb);
        this.m_73434_(world, this.deco.accentState, minX + 1, maxY - 1, maxZ, sbb);
        this.m_73434_(world, this.deco.accentState, maxX - 1, maxY - 1, minZ, sbb);
        this.m_73434_(world, this.deco.accentState, maxX - 1, maxY - 1, maxZ, sbb);
        this.m_73434_(world, this.deco.accentState, minX, minY + 1, minZ + 1, sbb);
        this.m_73434_(world, this.deco.accentState, minX, minY + 1, maxZ - 1, sbb);
        this.m_73434_(world, this.deco.accentState, maxX, minY + 1, minZ + 1, sbb);
        this.m_73434_(world, this.deco.accentState, maxX, minY + 1, maxZ - 1, sbb);
        this.m_73434_(world, this.deco.accentState, minX, maxY - 1, minZ + 1, sbb);
        this.m_73434_(world, this.deco.accentState, minX, maxY - 1, maxZ - 1, sbb);
        this.m_73434_(world, this.deco.accentState, maxX, maxY - 1, minZ + 1, sbb);
        this.m_73434_(world, this.deco.accentState, maxX, maxY - 1, maxZ - 1, sbb);
        this.m_73434_(world, this.deco.accentState, minX + 1, minY, minZ + 1, sbb);
        this.m_73434_(world, this.deco.accentState, minX + 1, minY, maxZ - 1, sbb);
        this.m_73434_(world, this.deco.accentState, maxX - 1, minY, minZ + 1, sbb);
        this.m_73434_(world, this.deco.accentState, maxX - 1, minY, maxZ - 1, sbb);
        this.m_73434_(world, this.deco.accentState, minX + 1, maxY, minZ + 1, sbb);
        this.m_73434_(world, this.deco.accentState, minX + 1, maxY, maxZ - 1, sbb);
        this.m_73434_(world, this.deco.accentState, maxX - 1, maxY, minZ + 1, sbb);
        this.m_73434_(world, this.deco.accentState, maxX - 1, maxY, maxZ - 1, sbb);
    }
    
    @Override
    public int[] getValidOpening(final Random rand, final Rotation direction) {
        final int verticalOffset = (this.size == 19) ? 5 : 4;
        if (direction == Rotation.NONE || direction == Rotation.CLOCKWISE_180) {
            final int rx = (direction == Rotation.NONE) ? (this.size - 1) : 0;
            final int rz = this.size / 2;
            final int ry = this.height - verticalOffset;
            return new int[] { rx, ry, rz };
        }
        if (direction == Rotation.CLOCKWISE_90 || direction == Rotation.COUNTERCLOCKWISE_90) {
            final int rx = this.size / 2;
            final int rz = (direction == Rotation.CLOCKWISE_90) ? (this.size - 1) : 0;
            final int ry = this.height - verticalOffset;
            return new int[] { rx, ry, rz };
        }
        return new int[] { 0, 0, 0 };
    }
    
    @Override
    public void addOpening(final int dx, final int dy, final int dz, final Rotation direction) {
        this.addOpening(dx, dy, dz, direction, EnumDarkTowerDoor.VANISHING);
    }
    
    protected void addOpening(final int dx, final int dy, final int dz, final Rotation direction, final EnumDarkTowerDoor type) {
        super.addOpening(dx, dy, dz, direction);
        this.openingTypes.add(this.openings.indexOf(new BlockPos(dx, dy, dz)), type);
    }
    
    @Override
    protected void makeOpenings(final WorldGenLevel world, final BoundingBox sbb) {
        for (int i = 0; i < this.openings.size(); ++i) {
            final BlockPos doorCoords = this.openings.get(i);
            EnumDarkTowerDoor doorType;
            if (this.openingTypes.size() > i) {
                doorType = this.openingTypes.get(i);
            }
            else {
                doorType = EnumDarkTowerDoor.VANISHING;
            }
            switch (doorType) {
                case REAPPEARING: {
                    this.makeReappearingDoorOpening(world, doorCoords.m_123341_(), doorCoords.m_123342_(), doorCoords.m_123343_(), sbb);
                    break;
                }
                case LOCKED: {
                    this.makeLockedDoorOpening(world, doorCoords.m_123341_(), doorCoords.m_123342_(), doorCoords.m_123343_(), sbb);
                    break;
                }
                default: {
                    this.makeDoorOpening(world, doorCoords.m_123341_(), doorCoords.m_123342_(), doorCoords.m_123343_(), sbb);
                    break;
                }
            }
        }
    }
    
    @Override
    protected void makeDoorOpening(final WorldGenLevel world, final int dx, final int dy, final int dz, final BoundingBox sbb) {
        final BlockState inactiveVanish = ((Block)TFBlocks.VANISHING_BLOCK.get()).m_49966_();
        if (dx == 0 || dx == this.size - 1) {
            this.m_73441_(world, sbb, dx, dy - 1, dz - 2, dx, dy + 3, dz + 2, this.deco.accentState, DarkTowerWingComponent.AIR, false);
            this.m_73441_(world, sbb, dx, dy, dz - 1, dx, dy + 2, dz + 1, inactiveVanish, DarkTowerWingComponent.AIR, false);
        }
        if (dz == 0 || dz == this.size - 1) {
            this.m_73441_(world, sbb, dx - 2, dy - 1, dz, dx + 2, dy + 3, dz, this.deco.accentState, DarkTowerWingComponent.AIR, false);
            this.m_73441_(world, sbb, dx - 1, dy, dz, dx + 1, dy + 2, dz, inactiveVanish, DarkTowerWingComponent.AIR, false);
        }
    }
    
    protected void makeReappearingDoorOpening(final WorldGenLevel world, final int dx, final int dy, final int dz, final BoundingBox sbb) {
        final BlockState inactiveReappearing = ((Block)TFBlocks.REAPPEARING_BLOCK.get()).m_49966_();
        if (dx == 0 || dx == this.size - 1) {
            this.m_73441_(world, sbb, dx, dy - 1, dz - 2, dx, dy + 3, dz + 2, this.deco.accentState, DarkTowerWingComponent.AIR, false);
            this.m_73441_(world, sbb, dx, dy, dz - 1, dx, dy + 2, dz + 1, inactiveReappearing, DarkTowerWingComponent.AIR, false);
        }
        if (dz == 0 || dz == this.size - 1) {
            this.m_73441_(world, sbb, dx - 2, dy - 1, dz, dx + 2, dy + 3, dz, this.deco.accentState, DarkTowerWingComponent.AIR, false);
            this.m_73441_(world, sbb, dx - 1, dy, dz, dx + 1, dy + 2, dz, inactiveReappearing, DarkTowerWingComponent.AIR, false);
        }
    }
    
    protected void makeLockedDoorOpening(final WorldGenLevel world, final int dx, final int dy, final int dz, final BoundingBox sbb) {
        final BlockState lockedVanish = ((Block)TFBlocks.LOCKED_VANISHING_BLOCK.get()).m_49966_();
        final BlockState inactiveVanish = ((Block)TFBlocks.VANISHING_BLOCK.get()).m_49966_();
        if (dx == 0 || dx == this.size - 1) {
            this.m_73441_(world, sbb, dx, dy - 1, dz - 2, dx, dy + 3, dz + 2, this.deco.accentState, DarkTowerWingComponent.AIR, false);
            this.m_73441_(world, sbb, dx, dy, dz - 1, dx, dy + 2, dz + 1, inactiveVanish, DarkTowerWingComponent.AIR, false);
            this.m_73434_(world, lockedVanish, dx, dy, dz + 1, sbb);
            this.m_73434_(world, lockedVanish, dx, dy, dz - 1, sbb);
            this.m_73434_(world, lockedVanish, dx, dy + 2, dz + 1, sbb);
            this.m_73434_(world, lockedVanish, dx, dy + 2, dz - 1, sbb);
        }
        if (dz == 0 || dz == this.size - 1) {
            this.m_73441_(world, sbb, dx - 2, dy - 1, dz, dx + 2, dy + 3, dz, this.deco.accentState, DarkTowerWingComponent.AIR, false);
            this.m_73441_(world, sbb, dx - 1, dy, dz, dx + 1, dy + 2, dz, inactiveVanish, DarkTowerWingComponent.AIR, false);
            this.m_73434_(world, lockedVanish, dx + 1, dy, dz, sbb);
            this.m_73434_(world, lockedVanish, dx - 1, dy, dz, sbb);
            this.m_73434_(world, lockedVanish, dx + 1, dy + 2, dz, sbb);
            this.m_73434_(world, lockedVanish, dx - 1, dy + 2, dz, sbb);
        }
    }
    
    @Override
    public boolean isDeadEnd() {
        int nonBalconies = 0;
        for (final EnumDarkTowerDoor type : this.openingTypes) {
            if (type != EnumDarkTowerDoor.REAPPEARING) {
                ++nonBalconies;
            }
        }
        return nonBalconies <= 1;
    }
    
    public boolean isKeyTower() {
        return this.keyTower;
    }
    
    public void setKeyTower(final boolean keyTower) {
        this.keyTower = keyTower;
    }
}
