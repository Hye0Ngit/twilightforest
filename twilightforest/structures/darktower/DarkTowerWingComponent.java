// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.darktower;

import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.block.LadderBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.state.properties.Half;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.RepeaterBlock;
import net.minecraft.block.RedstoneDiodeBlock;
import net.minecraft.block.LeverBlock;
import net.minecraft.block.HorizontalFaceBlock;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.state.properties.AttachFace;
import net.minecraft.state.Property;
import net.minecraft.block.DirectionalBlock;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.state.properties.SlabType;
import net.minecraft.entity.EntityType;
import twilightforest.entity.TFEntities;
import twilightforest.loot.TFTreasure;
import twilightforest.structures.TFStructureDecorator;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import twilightforest.structures.lichtower.TowerRoofFenceComponent;
import twilightforest.structures.lichtower.TowerRoofAttachedSlabComponent;
import twilightforest.structures.lichtower.TowerRoofSlabForwardsComponent;
import twilightforest.structures.lichtower.TowerRoofGableForwardsComponent;
import twilightforest.structures.lichtower.TowerRoofComponent;
import twilightforest.util.RotationUtil;
import net.minecraft.util.Rotation;
import twilightforest.structures.TFStructureComponentOld;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import java.util.Iterator;
import net.minecraft.util.Direction;
import twilightforest.TFFeature;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;
import java.util.ArrayList;
import twilightforest.structures.lichtower.TowerWingComponent;

public class DarkTowerWingComponent extends TowerWingComponent
{
    protected boolean keyTower;
    protected ArrayList<EnumDarkTowerDoor> openingTypes;
    
    public DarkTowerWingComponent(final TemplateManager manager, final CompoundNBT nbt) {
        this(DarkTowerPieces.TFDTWin, nbt);
    }
    
    public DarkTowerWingComponent(final IStructurePieceType piece, final CompoundNBT nbt) {
        super(piece, nbt);
        this.keyTower = false;
        this.openingTypes = new ArrayList<EnumDarkTowerDoor>();
        this.keyTower = nbt.func_74767_n("keyTower");
        this.readDoorsTypesFromArray(nbt.func_74759_k("doorTypeInts"));
    }
    
    protected DarkTowerWingComponent(final IStructurePieceType piece, final TFFeature feature, final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final Direction direction) {
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
    protected void func_143011_b(final CompoundNBT tagCompound) {
        super.func_143011_b(tagCompound);
        tagCompound.func_74757_a("keyTower", this.keyTower);
        tagCompound.func_74783_a("doorTypeInts", this.getDoorsTypesAsIntArray());
    }
    
    private void readDoorsTypesFromArray(final int[] intArray) {
        for (final int typeInt : intArray) {
            this.openingTypes.add(EnumDarkTowerDoor.values()[typeInt]);
        }
    }
    
    @Override
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
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
                final boolean madeWing = this.makeTowerWing(list, rand, this.func_74877_c(), dest[0], dest[1], dest[2], this.size - 2, childHeight, direction);
                if (!madeWing && (direction == Rotation.CLOCKWISE_180 || rand.nextBoolean())) {
                    this.makeTowerBalcony(list, rand, this.func_74877_c(), dest[0], dest[1], dest[2], direction);
                }
            }
        }
        else if (rand.nextInt(4) == 0) {
            final Rotation direction2 = RotationUtil.ROTATIONS[rand.nextInt(4)];
            final int[] dest2 = this.getValidOpening(rand, direction2);
            this.makeTowerBalcony(list, rand, this.func_74877_c(), dest2[0], dest2[1], dest2[2], direction2);
        }
    }
    
    protected int validateChildHeight(final int childHeight) {
        return childHeight / 4 * 4 + 1;
    }
    
    @Override
    public void makeARoof(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
        final int index = this.func_74877_c();
        TowerRoofComponent roof = null;
        switch (rand.nextInt(5)) {
            default: {
                roof = new DarkTowerRoofAntennaComponent(this.getFeatureType(), index, this);
                break;
            }
            case 2: {
                roof = new DarkTowerRoofCactusComponent(this.getFeatureType(), index, this);
                break;
            }
            case 3: {
                roof = new DarkTowerRoofRingsComponent(this.getFeatureType(), index, this);
                break;
            }
            case 4: {
                roof = new DarkTowerRoofFourPostComponent(this.getFeatureType(), index, this);
                break;
            }
        }
        list.add(roof);
        roof.func_74861_a((StructurePiece)this, (List)list, rand);
        this.roofType = roof.getClass();
    }
    
    @Override
    protected void makeAttachedRoof(final List<StructurePiece> list, final Random rand) {
        final int index = this.func_74877_c();
        if (this.roofType == null && rand.nextInt(32) != 0) {
            this.tryToFitRoof(list, rand, new TowerRoofGableForwardsComponent(this.getFeatureType(), index + 1, this));
        }
        if (this.roofType == null && rand.nextInt(8) != 0) {
            this.tryToFitRoof(list, rand, new TowerRoofSlabForwardsComponent(this.getFeatureType(), index + 1, this));
        }
        if (this.roofType == null && rand.nextInt(32) != 0) {
            final TowerRoofComponent roof = new TowerRoofAttachedSlabComponent(this.getFeatureType(), index + 1, this);
            this.tryToFitRoof(list, rand, roof);
        }
        if (this.roofType == null) {
            final TowerRoofComponent roof = new TowerRoofFenceComponent(this.getFeatureType(), index + 1, this);
            this.tryToFitRoof(list, rand, roof);
        }
    }
    
    @Override
    public void makeABeard(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
        final DarkTowerBeardComponent beard = new DarkTowerBeardComponent(this.getFeatureType(), this.func_74877_c() + 1, this);
        list.add(beard);
        beard.func_74861_a((StructurePiece)this, (List)list, rand);
    }
    
    @Override
    public boolean makeTowerWing(final List<StructurePiece> list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final Rotation rotation) {
        if (wingHeight < 8) {
            return false;
        }
        final Direction direction = this.getStructureRelativeRotation(rotation);
        final int[] dx = this.offsetTowerCoords(x, y, z, 5, direction);
        if (dx[1] + wingHeight > 250) {
            return false;
        }
        final DarkTowerBridgeComponent bridge = new DarkTowerBridgeComponent(DarkTowerPieces.TFDTBri, this.getFeatureType(), index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        StructurePiece intersect = StructurePiece.func_74883_a((List)list, bridge.func_74874_b());
        if (intersect != null && intersect != this) {
            return false;
        }
        intersect = StructurePiece.func_74883_a((List)list, bridge.getWingBB());
        if (intersect == null || intersect == this) {
            list.add(bridge);
            bridge.func_74861_a(this, list, rand);
            this.addOpening(x, y, z, rotation);
            return true;
        }
        return false;
    }
    
    protected boolean makeTowerBalcony(final List<StructurePiece> list, final Random rand, final int index, final int x, final int y, final int z, final Rotation rotation) {
        final Direction direction = this.getStructureRelativeRotation(rotation);
        final int[] dx = this.offsetTowerCoords(x, y, z, 5, direction);
        final DarkTowerBalconyComponent balcony = new DarkTowerBalconyComponent(this.getFeatureType(), index, dx[0], dx[1], dx[2], direction);
        final StructurePiece intersect = StructurePiece.func_74883_a((List)list, balcony.func_74874_b());
        if (intersect == null || intersect == this) {
            list.add(balcony);
            balcony.func_74861_a(this, list, rand);
            this.addOpening(x, y, z, rotation, EnumDarkTowerDoor.REAPPEARING);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final Random decoRNG = new Random(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
        this.makeEncasedWalls(world, rand, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1);
        this.func_74878_a(world, sbb, 1, 1, 1, this.size - 2, this.height - 2, this.size - 2);
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
    
    protected void destroyTower(final ISeedReader world, final Random decoRNG, final int x, final int y, final int z, final int amount, final MutableBoundingBox sbb) {
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
    
    private void netherTransformBlob(final ISeedReader world, final Random inRand, final int sx, final int sy, final int sz, final int rad, final MutableBoundingBox sbb) {
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
    
    private void testAndChangeToNetherrack(final ISeedReader world, final Random rand, final int x, final int y, final int z, final MutableBoundingBox sbb) {
        if (this.func_175807_a((IBlockReader)world, x, y, z, sbb).func_177230_c() != Blocks.field_150350_a) {
            this.func_175811_a(world, Blocks.field_150424_aL.func_176223_P(), x, y, z, sbb);
            if (this.func_175807_a((IBlockReader)world, x, y + 1, z, sbb).func_177230_c() == Blocks.field_150350_a && rand.nextBoolean()) {
                this.func_175811_a(world, Blocks.field_150480_ab.func_176223_P(), x, y + 1, z, sbb);
            }
        }
    }
    
    private void drawBlob(final ISeedReader world, final int sx, final int sy, final int sz, final int rad, final BlockState state, final MutableBoundingBox sbb) {
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
                        this.func_175811_a(world, state, sx + dx, sy + dy, sz + dz, sbb);
                        this.func_175811_a(world, state, sx + dx, sy + dy, sz - dz, sbb);
                        this.func_175811_a(world, state, sx - dx, sy + dy, sz + dz, sbb);
                        this.func_175811_a(world, state, sx - dx, sy + dy, sz - dz, sbb);
                        this.func_175811_a(world, state, sx + dx, sy - dy, sz + dz, sbb);
                        this.func_175811_a(world, state, sx + dx, sy - dy, sz - dz, sbb);
                        this.func_175811_a(world, state, sx - dx, sy - dy, sz + dz, sbb);
                        this.func_175811_a(world, state, sx - dx, sy - dy, sz - dz, sbb);
                    }
                }
            }
        }
    }
    
    private void addHalfFloors(final ISeedReader world, final Random rand, final MutableBoundingBox sbb, int bottom, final int top) {
        final int spacing = 4;
        Rotation rotation = RotationUtil.ROTATIONS[(this.field_74887_e.field_78895_b + bottom) % 3];
        if (bottom == 0) {
            bottom += spacing;
        }
        for (int y = bottom; y < top; y += spacing) {
            rotation = rotation.func_185830_a(Rotation.CLOCKWISE_180);
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
        rotation = rotation.func_185830_a(Rotation.CLOCKWISE_180);
        this.addStairsDown(world, sbb, rotation, this.height - 1, this.size - 2, spacing);
    }
    
    protected void makeHalfFloor(final ISeedReader world, final MutableBoundingBox sbb, final Rotation rotation, final int y) {
        this.fillBlocksRotated(world, sbb, this.size / 2, y, 1, this.size - 2, y, this.size - 2, this.deco.blockState, rotation);
        this.fillBlocksRotated(world, sbb, this.size / 2 - 1, y, 1, this.size / 2 - 1, y, this.size - 2, this.deco.accentState, rotation);
    }
    
    protected void makeFullFloor(final ISeedReader world, final MutableBoundingBox sbb, final int y) {
        this.func_175804_a(world, sbb, 1, y, 1, this.size - 2, y, this.size - 2, this.deco.blockState, Blocks.field_150350_a.func_176223_P(), false);
        this.func_175804_a(world, sbb, this.size / 2, y, 1, this.size / 2, y, this.size - 2, this.deco.accentState, Blocks.field_150350_a.func_176223_P(), true);
    }
    
    protected void decorateTreasureRoom(final ISeedReader world, final MutableBoundingBox sbb, final Rotation rotation, final int y, final int spacing, final TFStructureDecorator myDeco) {
        final int x = this.size / 2;
        final int z = this.size / 2;
        this.makePillarFrame(world, sbb, this.deco, rotation, x - 1, y, z - 1, true);
        this.setBlockStateRotated(world, myDeco.platformState, x, y + 1, z, rotation, sbb);
        this.placeTreasureAtCurrentPosition(world, x, y + 2, z, this.isKeyTower() ? TFTreasure.darktower_key : TFTreasure.darktower_cache, sbb);
    }
    
    private void decorateSpawner(final ISeedReader world, final Random rand, final MutableBoundingBox sbb, final Rotation rotation, final int y) {
        final int x = (this.size > 9) ? 4 : 3;
        final int z = (this.size > 9) ? 5 : 4;
        EntityType<?> mobID;
        if (this.size > 9) {
            mobID = (EntityType<?>)(rand.nextBoolean() ? TFEntities.tower_golem : TFEntities.tower_broodling);
        }
        else {
            mobID = TFEntities.tower_broodling;
        }
        this.makePillarFrame(world, sbb, this.deco, rotation, x, y, z, true);
        this.setSpawnerRotated(world, x + 1, y + 2, z + 1, rotation, mobID, sbb);
    }
    
    private void decorateLounge(final ISeedReader world, final MutableBoundingBox sbb, final Rotation rotation, final int y) {
        int cx = (this.size > 9) ? 9 : 7;
        final int cz = (this.size > 9) ? 4 : 3;
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.SOUTH, false), cx, y + 1, cz, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.WEST, false), cx, y + 1, cz + 1, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.NORTH, false), cx, y + 1, cz + 2, rotation, sbb);
        cx = ((this.size > 9) ? 5 : 3);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.SOUTH, true), cx, y + 1, cz, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getSlabState(Blocks.field_196624_br.func_176223_P(), SlabType.TOP), cx, y + 1, cz + 1, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.NORTH, true), cx, y + 1, cz + 2, rotation, sbb);
    }
    
    private void decorateReappearingFloor(final ISeedReader world, final MutableBoundingBox sbb, final Rotation rotation, final int y) {
        final BlockState inactiveReappearing = ((Block)TFBlocks.reappearing_block.get()).func_176223_P();
        final BlockState woodenPressurePlate = Blocks.field_196663_cq.func_176223_P();
        this.fillBlocksRotated(world, sbb, 4, y, 3, 7, y, 5, inactiveReappearing, rotation);
        this.fillBlocksRotated(world, sbb, 4, y + 1, 2, 7, y + 1, 2, woodenPressurePlate, rotation);
        this.fillBlocksRotated(world, sbb, 4, y + 1, 6, 7, y + 1, 6, woodenPressurePlate, rotation);
    }
    
    private void decorateExperimentLamp(final ISeedReader world, final MutableBoundingBox sbb, final Rotation rotation, final int y) {
        final int cx = (this.size > 9) ? 5 : 3;
        final int cz = (this.size > 9) ? 5 : 4;
        final BlockState redstoneLamp = Blocks.field_150379_bu.func_176223_P();
        this.setBlockStateRotated(world, (BlockState)Blocks.field_150320_F.func_176223_P().func_206870_a((Property)DirectionalBlock.field_176387_N, (Comparable)Direction.UP), cx, y + 1, cz, rotation, sbb);
        this.setBlockStateRotated(world, redstoneLamp, cx, y + 2, cz, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.accentState, cx, y + 1, cz + 1, rotation, sbb);
        this.setBlockStateRotated(world, getLeverState(Blocks.field_150442_at.func_176223_P(), AttachFace.WALL, Direction.NORTH, false), cx, y + 1, cz + 2, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.accentState, cx, y + 3, cz - 1, rotation, sbb);
        this.setBlockStateRotated(world, getLeverState(Blocks.field_150442_at.func_176223_P(), AttachFace.WALL, Direction.SOUTH, true), cx, y + 3, cz - 2, rotation, sbb);
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
        return (BlockState)((BlockState)((BlockState)initialState.func_206870_a((Property)HorizontalBlock.field_185512_D, (Comparable)direction)).func_206870_a((Property)HorizontalFaceBlock.field_196366_M, (Comparable)face)).func_206870_a((Property)LeverBlock.field_176359_b, (Comparable)isPowered);
    }
    
    private void decorateExperimentPulser(final ISeedReader world, final MutableBoundingBox sbb, final Rotation rotation, final int y) {
        final int cx = (this.size > 9) ? 6 : 5;
        final int cz = (this.size > 9) ? 4 : 3;
        final BlockState redstoneWire = Blocks.field_150488_af.func_176223_P();
        final BlockState woodenPressurePlate = Blocks.field_196663_cq.func_176223_P();
        final BlockState stickyPiston = (BlockState)Blocks.field_150320_F.func_176223_P().func_206870_a((Property)DirectionalBlock.field_176387_N, (Comparable)Direction.SOUTH);
        final BlockState unpoweredRepeater = (BlockState)((BlockState)((BlockState)Blocks.field_196633_cV.func_176223_P().func_206870_a((Property)RedstoneDiodeBlock.field_196348_c, (Comparable)false)).func_206870_a((Property)HorizontalBlock.field_185512_D, (Comparable)Direction.WEST)).func_206870_a((Property)RepeaterBlock.field_176410_b, (Comparable)2);
        this.setBlockStateRotated(world, stickyPiston, cx, y + 1, cz + 1, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.accentState, cx, y + 1, cz, rotation, sbb);
        this.setBlockStateRotated(world, redstoneWire, cx + 1, y + 1, cz, rotation, sbb);
        this.setBlockStateRotated(world, woodenPressurePlate, cx + 2, y + 1, cz, rotation, sbb);
        this.setBlockStateRotated(world, unpoweredRepeater, cx - 1, y + 1, cz, rotation, sbb);
        this.setBlockStateRotated(world, redstoneWire, cx - 2, y + 1, cz, rotation, sbb);
        this.setBlockStateRotated(world, redstoneWire, cx - 2, y + 1, cz + 1, rotation, sbb);
        this.setBlockStateRotated(world, redstoneWire, cx - 1, y + 1, cz + 1, rotation, sbb);
    }
    
    private void decorateLibrary(final ISeedReader world, final MutableBoundingBox sbb, final Rotation rotation, final int y) {
        int bx = (this.size > 9) ? 4 : 3;
        int bz = (this.size > 9) ? 3 : 2;
        this.makeSmallBookshelf(world, sbb, rotation, y, bx, bz);
        bx = ((this.size > 9) ? 9 : 7);
        bz = ((this.size > 9) ? 3 : 2);
        this.makeSmallBookshelf(world, sbb, rotation, y, bx, bz);
    }
    
    protected void makeSmallBookshelf(final ISeedReader world, final MutableBoundingBox sbb, final Rotation rotation, final int y, final int bx, final int bz) {
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.NORTH, false), bx, y + 1, bz, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.NORTH, true), bx, y + 2, bz, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.SOUTH, false), bx, y + 1, bz + 3, rotation, sbb);
        this.setBlockStateRotated(world, TFStructureComponentOld.getStairState(this.deco.stairState, Direction.SOUTH, true), bx, y + 2, bz + 3, rotation, sbb);
        final BlockState bookshelf = Blocks.field_150342_X.func_176223_P();
        this.setBlockStateRotated(world, bookshelf, bx, y + 1, bz + 1, rotation, sbb);
        this.setBlockStateRotated(world, bookshelf, bx, y + 2, bz + 1, rotation, sbb);
        this.setBlockStateRotated(world, bookshelf, bx, y + 1, bz + 2, rotation, sbb);
        this.setBlockStateRotated(world, bookshelf, bx, y + 2, bz + 2, rotation, sbb);
    }
    
    private void decoratePuzzleChest(final ISeedReader world, final MutableBoundingBox sbb, final Rotation rotation, final int y) {
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
        this.setBlockStateRotated(world, (BlockState)Blocks.field_150320_F.func_176223_P().func_206870_a((Property)DirectionalBlock.field_176387_N, (Comparable)Direction.NORTH), x + 1, y + 3, z - 1, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.accentState, x + 1, y + 3, z - 2, rotation, sbb);
        this.setBlockStateRotated(world, getLeverState(Blocks.field_150442_at.func_176223_P(), AttachFace.WALL, Direction.WEST, false), x + 2, y + 3, z - 2, rotation, sbb);
        this.placeTreasureRotated(world, x + 1, y + 2, z + 1, this.func_186165_e(), rotation, TFTreasure.darktower_cache, sbb);
    }
    
    protected void makePillarFrame(final ISeedReader world, final MutableBoundingBox sbb, final TFStructureDecorator myDeco, final Rotation rotation, final int x, final int y, final int z, final boolean fenced) {
        this.makePillarFrame(world, sbb, myDeco, rotation, x, y, z, 3, 3, 3, fenced);
    }
    
    protected void makePillarFrame(final ISeedReader world, final MutableBoundingBox sbb, final TFStructureDecorator myDeco, final Rotation rotation, final int x, final int y, final int z, final int width, final int height, final int length, final boolean fenced) {
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
                        this.setBlockStateRotated(world, (BlockState)southStairs.func_206870_a((Property)StairsBlock.field_176308_b, (Comparable)Half.TOP), x + dx, y + height, z + dz, rotation, sbb);
                    }
                    else if (dx == width - 1) {
                        final BlockState northStairs = TFStructureComponentOld.getStairState(this.deco.stairState, Direction.EAST, false);
                        this.setBlockStateRotated(world, northStairs, x + dx, y + 1, z + dz, rotation, sbb);
                        this.setBlockStateRotated(world, (BlockState)northStairs.func_206870_a((Property)StairsBlock.field_176308_b, (Comparable)Half.TOP), x + dx, y + height, z + dz, rotation, sbb);
                    }
                    else if (dz == 0) {
                        final BlockState westStairs = TFStructureComponentOld.getStairState(this.deco.stairState, Direction.NORTH, false);
                        this.setBlockStateRotated(world, westStairs, x + dx, y + 1, z + dz, rotation, sbb);
                        this.setBlockStateRotated(world, (BlockState)westStairs.func_206870_a((Property)StairsBlock.field_176308_b, (Comparable)Half.TOP), x + dx, y + height, z + dz, rotation, sbb);
                    }
                    else if (dz == length - 1) {
                        final BlockState eastStairs = TFStructureComponentOld.getStairState(this.deco.stairState, Direction.SOUTH, false);
                        this.setBlockStateRotated(world, eastStairs, x + dx, y + 1, z + dz, rotation, sbb);
                        this.setBlockStateRotated(world, (BlockState)eastStairs.func_206870_a((Property)StairsBlock.field_176308_b, (Comparable)Half.TOP), x + dx, y + height, z + dz, rotation, sbb);
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
    
    protected void addStairsDown(final ISeedReader world, final MutableBoundingBox sbb, final Rotation rotation, final int y, final int sz, final int spacing) {
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
    
    protected void addSmallTimberBeams(final ISeedReader world, final Random rand, final MutableBoundingBox sbb, int bottom, final int top) {
        final int spacing = 4;
        Rotation rotation = Rotation.NONE;
        if (bottom == 0) {
            bottom += spacing;
        }
        for (int y = bottom; y < top; y += spacing) {
            rotation = rotation.func_185830_a(Rotation.CLOCKWISE_90);
            if (y >= top - spacing && this.isDeadEnd()) {
                this.makeTimberFloor(world, sbb, rotation, y);
                final TFStructureDecorator logDeco = new StructureDecoratorDarkTower();
                logDeco.pillarState = ((RotatedPillarBlock)TFBlocks.dark_log.get()).func_176223_P();
                logDeco.platformState = ((RotatedPillarBlock)TFBlocks.dark_log.get()).func_176223_P();
                this.decorateTreasureRoom(world, sbb, rotation, y, 4, logDeco);
            }
            else {
                final int y2;
                this.makeSmallTimberBeams(world, rand, sbb, rotation, y2, (y2 = y) == bottom && bottom != spacing);
            }
        }
    }
    
    protected void makeTimberFloor(final ISeedReader world, final MutableBoundingBox sbb, final Rotation rotation, final int y) {
        final BlockState beamID = ((RotatedPillarBlock)TFBlocks.dark_log.get()).func_176223_P();
        final BlockState beamStateNS = (BlockState)beamID.func_206870_a((Property)RotatedPillarBlock.field_176298_M, (Comparable)Direction.Axis.Z);
        final BlockState beamStateUD = (BlockState)beamID.func_206870_a((Property)RotatedPillarBlock.field_176298_M, (Comparable)Direction.Axis.Y);
        final BlockState beamStateEW = (BlockState)beamID.func_206870_a((Property)RotatedPillarBlock.field_176298_M, (Comparable)Direction.Axis.X);
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
            final BlockState ladder = Blocks.field_150468_ap.func_176223_P();
            this.setBlockStateRotated(world, beamStateUD, 2, y - by, 2, rotation, sbb);
            this.setBlockStateRotated(world, (BlockState)ladder.func_206870_a((Property)LadderBlock.field_176382_a, (Comparable)Direction.WEST), 3, y - by, 2, rotation, sbb);
            this.setBlockStateRotated(world, beamStateUD, 6, y - by, 6, rotation, sbb);
            this.setBlockStateRotated(world, (BlockState)ladder.func_206870_a((Property)LadderBlock.field_176382_a, (Comparable)Direction.EAST), 5, y - by, 6, rotation, sbb);
        }
        this.setBlockStateRotated(world, DarkTowerWingComponent.AIR, 3, y, 2, rotation, sbb);
        this.setBlockStateRotated(world, DarkTowerWingComponent.AIR, 5, y, 6, rotation, sbb);
    }
    
    protected void makeSmallTimberBeams(final ISeedReader world, final Random rand, final MutableBoundingBox sbb, final Rotation rotation, final int y, final boolean bottom) {
        final BlockState beamID = ((RotatedPillarBlock)TFBlocks.dark_log.get()).func_176223_P();
        final BlockState beamStateNS = (BlockState)beamID.func_206870_a((Property)RotatedPillarBlock.field_176298_M, (Comparable)Direction.Axis.X);
        final BlockState beamStateUD = (BlockState)beamID.func_206870_a((Property)RotatedPillarBlock.field_176298_M, (Comparable)Direction.Axis.Y);
        final BlockState beamStateEW = (BlockState)beamID.func_206870_a((Property)RotatedPillarBlock.field_176298_M, (Comparable)Direction.Axis.Z);
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
            final BlockState ladder = Blocks.field_150468_ap.func_176223_P();
            if (!bottom || this.checkPost(world, x2, y - 4, z2, rotation, sbb)) {
                this.setBlockStateRotated(world, beamStateUD, x2, y - by, z2, rotation, sbb);
                this.setBlockStateRotated(world, (BlockState)ladder.func_206870_a((Property)LadderBlock.field_176382_a, (Comparable)Direction.WEST), x2 + 1, y - by, z2, rotation, sbb);
            }
            if (!bottom || this.checkPost(world, x3, y - 4, z3, rotation, sbb)) {
                this.setBlockStateRotated(world, beamStateUD, x3, y - by, z3, rotation, sbb);
                this.setBlockStateRotated(world, (BlockState)ladder.func_206870_a((Property)LadderBlock.field_176382_a, (Comparable)Direction.EAST), x3 - 1, y - by, z3, rotation, sbb);
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
        switch (rand.nextInt(3)) {
            default: {
                return i;
            }
            case 1: {
                return j;
            }
            case 2: {
                return k;
            }
        }
    }
    
    protected boolean checkPost(final ISeedReader world, final int x, final int y, final int z, final Rotation rotation, final MutableBoundingBox sbb) {
        final int worldX = this.getXWithOffsetRotated(x, z, rotation);
        final int worldY = this.func_74862_a(y);
        final int worldZ = this.getZWithOffsetRotated(x, z, rotation);
        final BlockPos vec = new BlockPos(worldX, worldY, worldZ);
        if (!sbb.func_175898_b((Vector3i)vec)) {
            return false;
        }
        final BlockState blockState = world.func_180495_p(vec);
        return blockState.func_177230_c() != Blocks.field_150350_a && blockState != this.deco.accentState;
    }
    
    protected void makeEncasedWalls(final ISeedReader world, final Random rand, final MutableBoundingBox sbb, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ) {
        for (int x = minX; x <= maxX; ++x) {
            for (int y = minY; y <= maxY; ++y) {
                for (int z = minZ; z <= maxZ; ++z) {
                    if (x == minX || x == maxX || y == minY || y == maxY || z == minZ || z == maxZ) {
                        if (((y == minY || y == maxY) && (x == minY || x == maxX || z == minZ || z == maxZ)) || ((z == minZ || z == maxZ) && (x == minY || x == maxX || y == minY || y == maxY))) {
                            this.func_175811_a(world, this.deco.accentState, x, y, z, sbb);
                        }
                        else {
                            final StructurePiece.BlockSelector blocker = this.deco.randomBlocks;
                            blocker.func_75062_a(rand, x, y, z, true);
                            this.func_175811_a(world, blocker.func_180780_a(), x, y, z, sbb);
                        }
                    }
                }
            }
        }
        this.func_175811_a(world, this.deco.accentState, minX + 1, minY + 1, minZ, sbb);
        this.func_175811_a(world, this.deco.accentState, minX + 1, minY + 1, maxZ, sbb);
        this.func_175811_a(world, this.deco.accentState, maxX - 1, minY + 1, minZ, sbb);
        this.func_175811_a(world, this.deco.accentState, maxX - 1, minY + 1, maxZ, sbb);
        this.func_175811_a(world, this.deco.accentState, minX + 1, maxY - 1, minZ, sbb);
        this.func_175811_a(world, this.deco.accentState, minX + 1, maxY - 1, maxZ, sbb);
        this.func_175811_a(world, this.deco.accentState, maxX - 1, maxY - 1, minZ, sbb);
        this.func_175811_a(world, this.deco.accentState, maxX - 1, maxY - 1, maxZ, sbb);
        this.func_175811_a(world, this.deco.accentState, minX, minY + 1, minZ + 1, sbb);
        this.func_175811_a(world, this.deco.accentState, minX, minY + 1, maxZ - 1, sbb);
        this.func_175811_a(world, this.deco.accentState, maxX, minY + 1, minZ + 1, sbb);
        this.func_175811_a(world, this.deco.accentState, maxX, minY + 1, maxZ - 1, sbb);
        this.func_175811_a(world, this.deco.accentState, minX, maxY - 1, minZ + 1, sbb);
        this.func_175811_a(world, this.deco.accentState, minX, maxY - 1, maxZ - 1, sbb);
        this.func_175811_a(world, this.deco.accentState, maxX, maxY - 1, minZ + 1, sbb);
        this.func_175811_a(world, this.deco.accentState, maxX, maxY - 1, maxZ - 1, sbb);
        this.func_175811_a(world, this.deco.accentState, minX + 1, minY, minZ + 1, sbb);
        this.func_175811_a(world, this.deco.accentState, minX + 1, minY, maxZ - 1, sbb);
        this.func_175811_a(world, this.deco.accentState, maxX - 1, minY, minZ + 1, sbb);
        this.func_175811_a(world, this.deco.accentState, maxX - 1, minY, maxZ - 1, sbb);
        this.func_175811_a(world, this.deco.accentState, minX + 1, maxY, minZ + 1, sbb);
        this.func_175811_a(world, this.deco.accentState, minX + 1, maxY, maxZ - 1, sbb);
        this.func_175811_a(world, this.deco.accentState, maxX - 1, maxY, minZ + 1, sbb);
        this.func_175811_a(world, this.deco.accentState, maxX - 1, maxY, maxZ - 1, sbb);
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
    protected void makeOpenings(final ISeedReader world, final MutableBoundingBox sbb) {
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
                default: {
                    this.makeDoorOpening(world, doorCoords.func_177958_n(), doorCoords.func_177956_o(), doorCoords.func_177952_p(), sbb);
                    break;
                }
                case REAPPEARING: {
                    this.makeReappearingDoorOpening(world, doorCoords.func_177958_n(), doorCoords.func_177956_o(), doorCoords.func_177952_p(), sbb);
                    break;
                }
                case LOCKED: {
                    this.makeLockedDoorOpening(world, doorCoords.func_177958_n(), doorCoords.func_177956_o(), doorCoords.func_177952_p(), sbb);
                    break;
                }
            }
        }
    }
    
    @Override
    protected void makeDoorOpening(final ISeedReader world, final int dx, final int dy, final int dz, final MutableBoundingBox sbb) {
        final BlockState inactiveVanish = ((Block)TFBlocks.vanishing_block.get()).func_176223_P();
        if (dx == 0 || dx == this.size - 1) {
            this.func_175804_a(world, sbb, dx, dy - 1, dz - 2, dx, dy + 3, dz + 2, this.deco.accentState, DarkTowerWingComponent.AIR, false);
            this.func_175804_a(world, sbb, dx, dy, dz - 1, dx, dy + 2, dz + 1, inactiveVanish, DarkTowerWingComponent.AIR, false);
        }
        if (dz == 0 || dz == this.size - 1) {
            this.func_175804_a(world, sbb, dx - 2, dy - 1, dz, dx + 2, dy + 3, dz, this.deco.accentState, DarkTowerWingComponent.AIR, false);
            this.func_175804_a(world, sbb, dx - 1, dy, dz, dx + 1, dy + 2, dz, inactiveVanish, DarkTowerWingComponent.AIR, false);
        }
    }
    
    protected void makeReappearingDoorOpening(final ISeedReader world, final int dx, final int dy, final int dz, final MutableBoundingBox sbb) {
        final BlockState inactiveReappearing = ((Block)TFBlocks.reappearing_block.get()).func_176223_P();
        if (dx == 0 || dx == this.size - 1) {
            this.func_175804_a(world, sbb, dx, dy - 1, dz - 2, dx, dy + 3, dz + 2, this.deco.accentState, DarkTowerWingComponent.AIR, false);
            this.func_175804_a(world, sbb, dx, dy, dz - 1, dx, dy + 2, dz + 1, inactiveReappearing, DarkTowerWingComponent.AIR, false);
        }
        if (dz == 0 || dz == this.size - 1) {
            this.func_175804_a(world, sbb, dx - 2, dy - 1, dz, dx + 2, dy + 3, dz, this.deco.accentState, DarkTowerWingComponent.AIR, false);
            this.func_175804_a(world, sbb, dx - 1, dy, dz, dx + 1, dy + 2, dz, inactiveReappearing, DarkTowerWingComponent.AIR, false);
        }
    }
    
    protected void makeLockedDoorOpening(final ISeedReader world, final int dx, final int dy, final int dz, final MutableBoundingBox sbb) {
        final BlockState lockedVanish = ((Block)TFBlocks.locked_vanishing_block.get()).func_176223_P();
        final BlockState inactiveVanish = ((Block)TFBlocks.vanishing_block.get()).func_176223_P();
        if (dx == 0 || dx == this.size - 1) {
            this.func_175804_a(world, sbb, dx, dy - 1, dz - 2, dx, dy + 3, dz + 2, this.deco.accentState, DarkTowerWingComponent.AIR, false);
            this.func_175804_a(world, sbb, dx, dy, dz - 1, dx, dy + 2, dz + 1, inactiveVanish, DarkTowerWingComponent.AIR, false);
            this.func_175811_a(world, lockedVanish, dx, dy, dz + 1, sbb);
            this.func_175811_a(world, lockedVanish, dx, dy, dz - 1, sbb);
            this.func_175811_a(world, lockedVanish, dx, dy + 2, dz + 1, sbb);
            this.func_175811_a(world, lockedVanish, dx, dy + 2, dz - 1, sbb);
        }
        if (dz == 0 || dz == this.size - 1) {
            this.func_175804_a(world, sbb, dx - 2, dy - 1, dz, dx + 2, dy + 3, dz, this.deco.accentState, DarkTowerWingComponent.AIR, false);
            this.func_175804_a(world, sbb, dx - 1, dy, dz, dx + 1, dy + 2, dz, inactiveVanish, DarkTowerWingComponent.AIR, false);
            this.func_175811_a(world, lockedVanish, dx + 1, dy, dz, sbb);
            this.func_175811_a(world, lockedVanish, dx - 1, dy, dz, sbb);
            this.func_175811_a(world, lockedVanish, dx + 1, dy + 2, dz, sbb);
            this.func_175811_a(world, lockedVanish, dx - 1, dy + 2, dz, sbb);
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
