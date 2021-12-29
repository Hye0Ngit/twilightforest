// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.darktower;

import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockLadder;
import net.minecraft.block.BlockLog;
import twilightforest.enums.WoodVariant;
import twilightforest.block.BlockTFLog;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockRedstoneRepeater;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.BlockLever;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.TowerDeviceVariant;
import twilightforest.block.BlockTFTowerDevice;
import twilightforest.block.TFBlocks;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockPlanks;
import net.minecraft.util.ResourceLocation;
import twilightforest.util.TFEntityNames;
import twilightforest.loot.TFTreasure;
import twilightforest.structures.StructureTFDecorator;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import twilightforest.structures.lichtower.ComponentTFTowerRoofFence;
import twilightforest.structures.lichtower.ComponentTFTowerRoofAttachedSlab;
import twilightforest.structures.lichtower.ComponentTFTowerRoofSlabForwards;
import twilightforest.structures.lichtower.ComponentTFTowerRoofGableForwards;
import twilightforest.structures.lichtower.ComponentTFTowerRoof;
import twilightforest.util.RotationUtil;
import net.minecraft.util.Rotation;
import twilightforest.structures.StructureTFComponentOld;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.template.TemplateManager;
import java.util.Iterator;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;
import java.util.ArrayList;
import twilightforest.structures.lichtower.ComponentTFTowerWing;

public class ComponentTFDarkTowerWing extends ComponentTFTowerWing
{
    protected boolean keyTower;
    protected ArrayList<EnumDarkTowerDoor> openingTypes;
    
    public ComponentTFDarkTowerWing() {
        this.keyTower = false;
        this.openingTypes = new ArrayList<EnumDarkTowerDoor>();
    }
    
    protected ComponentTFDarkTowerWing(final TFFeature feature, final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final EnumFacing direction) {
        super(feature, i, x, y, z, pSize, pHeight, direction);
        this.keyTower = false;
        this.openingTypes = new ArrayList<EnumDarkTowerDoor>();
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound tagCompound) {
        super.func_143012_a(tagCompound);
        tagCompound.func_74757_a("keyTower", this.keyTower);
        tagCompound.func_74783_a("doorTypeInts", this.getDoorsTypesAsIntArray());
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
    protected void func_143011_b(final NBTTagCompound tagCompound, final TemplateManager templateManager) {
        super.func_143011_b(tagCompound, templateManager);
        this.keyTower = tagCompound.func_74767_n("keyTower");
        this.readDoorsTypesFromArray(tagCompound.func_74759_k("doorTypeInts"));
    }
    
    private void readDoorsTypesFromArray(final int[] intArray) {
        for (final int typeInt : intArray) {
            this.openingTypes.add(EnumDarkTowerDoor.values()[typeInt]);
        }
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponentOld) {
            this.deco = ((StructureTFComponentOld)parent).deco;
        }
        this.addOpening(0, 1, this.size / 2, Rotation.CLOCKWISE_180);
        this.makeARoof(parent, list, rand);
        this.makeABeard(parent, list, rand);
        if (this.size > 10) {
            for (final Rotation direction : RotationUtil.ROTATIONS) {
                final int[] dest = this.getValidOpening(rand, direction);
                final int childSize = this.size - 2;
                final int childHeight = this.validateChildHeight(this.height - 4 + rand.nextInt(10) - rand.nextInt(10), childSize);
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
    
    protected int validateChildHeight(final int childHeight, final int childSize) {
        return childHeight / 4 * 4 + 1;
    }
    
    @Override
    public void makeARoof(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        final int index = this.func_74877_c();
        ComponentTFTowerRoof roof = null;
        switch (rand.nextInt(5)) {
            default: {
                roof = new ComponentTFDarkTowerRoofAntenna(this.getFeatureType(), index, this);
                break;
            }
            case 2: {
                roof = new ComponentTFDarkTowerRoofCactus(this.getFeatureType(), index, this);
                break;
            }
            case 3: {
                roof = new ComponentTFDarkTowerRoofRings(this.getFeatureType(), index, this);
                break;
            }
            case 4: {
                roof = new ComponentTFDarkTowerRoofFourPost(this.getFeatureType(), index, this);
                break;
            }
        }
        list.add(roof);
        roof.func_74861_a((StructureComponent)this, (List)list, rand);
        this.roofType = roof.getClass();
    }
    
    @Override
    protected void makeAttachedRoof(final List<StructureComponent> list, final Random rand) {
        final int index = this.func_74877_c();
        if (this.roofType == null && rand.nextInt(32) != 0) {
            this.tryToFitRoof(list, rand, new ComponentTFTowerRoofGableForwards(this.getFeatureType(), index + 1, this));
        }
        if (this.roofType == null && rand.nextInt(8) != 0) {
            this.tryToFitRoof(list, rand, new ComponentTFTowerRoofSlabForwards(this.getFeatureType(), index + 1, this));
        }
        if (this.roofType == null && rand.nextInt(32) != 0) {
            final ComponentTFTowerRoof roof = new ComponentTFTowerRoofAttachedSlab(this.getFeatureType(), index + 1, this);
            this.tryToFitRoof(list, rand, roof);
        }
        if (this.roofType == null) {
            final ComponentTFTowerRoof roof = new ComponentTFTowerRoofFence(this.getFeatureType(), index + 1, this);
            this.tryToFitRoof(list, rand, roof);
        }
    }
    
    @Override
    public void makeABeard(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        final ComponentTFDarkTowerBeard beard = new ComponentTFDarkTowerBeard(this.getFeatureType(), this.func_74877_c() + 1, this);
        list.add(beard);
        beard.func_74861_a((StructureComponent)this, (List)list, rand);
    }
    
    @Override
    public boolean makeTowerWing(final List<StructureComponent> list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final Rotation rotation) {
        if (wingHeight < 8) {
            return false;
        }
        final EnumFacing direction = this.getStructureRelativeRotation(rotation);
        final int[] dx = this.offsetTowerCoords(x, y, z, 5, direction);
        if (dx[1] + wingHeight > 250) {
            return false;
        }
        final ComponentTFDarkTowerBridge bridge = new ComponentTFDarkTowerBridge(this.getFeatureType(), index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        StructureComponent intersect = StructureComponent.func_74883_a((List)list, bridge.func_74874_b());
        if (intersect != null && intersect != this) {
            return false;
        }
        intersect = StructureComponent.func_74883_a((List)list, bridge.getWingBB());
        if (intersect == null || intersect == this) {
            list.add(bridge);
            bridge.func_74861_a(this, list, rand);
            this.addOpening(x, y, z, rotation);
            return true;
        }
        return false;
    }
    
    protected boolean makeTowerBalcony(final List<StructureComponent> list, final Random rand, final int index, final int x, final int y, final int z, final Rotation rotation) {
        final EnumFacing direction = this.getStructureRelativeRotation(rotation);
        final int[] dx = this.offsetTowerCoords(x, y, z, 5, direction);
        final ComponentTFDarkTowerBalcony balcony = new ComponentTFDarkTowerBalcony(this.getFeatureType(), index, dx[0], dx[1], dx[2], direction);
        final StructureComponent intersect = StructureComponent.func_74883_a((List)list, balcony.func_74874_b());
        if (intersect == null || intersect == this) {
            list.add(balcony);
            balcony.func_74861_a(this, list, rand);
            this.addOpening(x, y, z, rotation, EnumDarkTowerDoor.REAPPEARING);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        final Random decoRNG = new Random(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
        this.makeEncasedWalls(world, rand, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1);
        this.func_74878_a(world, sbb, 1, 1, 1, this.size - 2, this.height - 2, this.size - 2);
        this.nullifySkyLightForBoundingBox(world);
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
    
    protected void destroyTower(final World world, final Random decoRNG, final int x, final int y, final int z, final int amount, final StructureBoundingBox sbb) {
        final int initialRadius = decoRNG.nextInt(amount) + amount;
        this.drawBlob(world, x, y, z, initialRadius, ComponentTFDarkTowerWing.AIR, sbb);
        for (int i = 0; i < 3; ++i) {
            final int dx = x + (initialRadius - 1) * (decoRNG.nextBoolean() ? 1 : -1);
            final int dy = y + (initialRadius - 1) * (decoRNG.nextBoolean() ? 1 : -1);
            final int dz = z + (initialRadius - 1) * (decoRNG.nextBoolean() ? 1 : -1);
            this.netherTransformBlob(world, decoRNG, dx, dy, dz, initialRadius - 1, sbb);
            this.drawBlob(world, dx, dy, dz, initialRadius - 2, ComponentTFDarkTowerWing.AIR, sbb);
        }
    }
    
    private void netherTransformBlob(final World world, final Random inRand, final int sx, final int sy, final int sz, final int rad, final StructureBoundingBox sbb) {
        final Random rand = new Random(inRand.nextLong());
        for (byte dx = 0; dx <= rad; ++dx) {
            for (byte dy = 0; dy <= rad; ++dy) {
                for (byte dz = 0; dz <= rad; ++dz) {
                    byte dist = 0;
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
    
    private void testAndChangeToNetherrack(final World world, final Random rand, final int x, final int y, final int z, final StructureBoundingBox sbb) {
        if (this.func_175807_a(world, x, y, z, sbb).func_177230_c() != Blocks.field_150350_a) {
            this.func_175811_a(world, Blocks.field_150424_aL.func_176223_P(), x, y, z, sbb);
            if (this.func_175807_a(world, x, y + 1, z, sbb).func_177230_c() == Blocks.field_150350_a && rand.nextBoolean()) {
                this.func_175811_a(world, Blocks.field_150480_ab.func_176223_P(), x, y + 1, z, sbb);
            }
        }
    }
    
    private void drawBlob(final World world, final int sx, final int sy, final int sz, final int rad, final IBlockState state, final StructureBoundingBox sbb) {
        for (byte dx = 0; dx <= rad; ++dx) {
            for (byte dy = 0; dy <= rad; ++dy) {
                for (byte dz = 0; dz <= rad; ++dz) {
                    byte dist = 0;
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
    
    private void addHalfFloors(final World world, final Random rand, final StructureBoundingBox sbb, int bottom, final int top) {
        final int spacing = 4;
        Rotation rotation = RotationUtil.ROTATIONS[(this.field_74887_e.field_78895_b + bottom) % 3];
        if (bottom == 0) {
            bottom += spacing;
        }
        for (int y = bottom; y < top; y += spacing) {
            rotation = rotation.func_185830_a(Rotation.CLOCKWISE_180);
            if (y >= top - spacing) {
                this.makeFullFloor(world, sbb, rotation, y, spacing);
                if (this.isDeadEnd()) {
                    this.decorateTreasureRoom(world, sbb, rotation, y, 4, this.deco);
                }
            }
            else {
                this.makeHalfFloor(world, sbb, rotation, y, spacing);
                switch (rand.nextInt(8)) {
                    case 0: {
                        if (this.size < 11) {
                            this.decorateReappearingFloor(world, rand, sbb, rotation, y);
                            break;
                        }
                    }
                    case 1: {
                        this.decorateSpawner(world, rand, sbb, rotation, y);
                        break;
                    }
                    case 2: {
                        this.decorateLounge(world, rand, sbb, rotation, y);
                        break;
                    }
                    case 3: {
                        this.decorateLibrary(world, rand, sbb, rotation, y);
                        break;
                    }
                    case 4: {
                        this.decorateExperimentPulser(world, rand, sbb, rotation, y);
                        break;
                    }
                    case 5: {
                        this.decorateExperimentLamp(world, rand, sbb, rotation, y);
                        break;
                    }
                    case 6: {
                        this.decoratePuzzleChest(world, rand, sbb, rotation, y);
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
    
    protected void makeHalfFloor(final World world, final StructureBoundingBox sbb, final Rotation rotation, final int y, final int spacing) {
        this.fillBlocksRotated(world, sbb, this.size / 2, y, 1, this.size - 2, y, this.size - 2, this.deco.blockState, rotation);
        this.fillBlocksRotated(world, sbb, this.size / 2 - 1, y, 1, this.size / 2 - 1, y, this.size - 2, this.deco.accentState, rotation);
    }
    
    protected void makeFullFloor(final World world, final StructureBoundingBox sbb, final Rotation rotation, final int y, final int spacing) {
        this.func_175804_a(world, sbb, 1, y, 1, this.size - 2, y, this.size - 2, this.deco.blockState, Blocks.field_150350_a.func_176223_P(), false);
        this.func_175804_a(world, sbb, this.size / 2, y, 1, this.size / 2, y, this.size - 2, this.deco.accentState, Blocks.field_150350_a.func_176223_P(), true);
    }
    
    protected void decorateTreasureRoom(final World world, final StructureBoundingBox sbb, final Rotation rotation, final int y, final int spacing, final StructureTFDecorator myDeco) {
        final int x = this.size / 2;
        final int z = this.size / 2;
        this.makePillarFrame(world, sbb, this.deco, rotation, x - 1, y, z - 1, true);
        this.setBlockStateRotated(world, myDeco.platformState, x, y + 1, z, rotation, sbb);
        this.placeTreasureAtCurrentPosition(world, null, x, y + 2, z, this.isKeyTower() ? TFTreasure.darktower_key : TFTreasure.darktower_cache, sbb);
    }
    
    private void decorateSpawner(final World world, final Random rand, final StructureBoundingBox sbb, final Rotation rotation, final int y) {
        final int x = (this.size > 9) ? 4 : 3;
        final int z = (this.size > 9) ? 5 : 4;
        ResourceLocation mobID;
        if (this.size > 9) {
            mobID = (rand.nextBoolean() ? TFEntityNames.TOWER_GOLEM : TFEntityNames.TOWER_BROODLING);
        }
        else {
            mobID = TFEntityNames.TOWER_BROODLING;
        }
        this.makePillarFrame(world, sbb, this.deco, rotation, x, y, z, true);
        this.setSpawnerRotated(world, x + 1, y + 2, z + 1, rotation, mobID, sbb);
    }
    
    private void decorateLounge(final World world, final Random rand, final StructureBoundingBox sbb, final Rotation rotation, final int y) {
        int cx = (this.size > 9) ? 9 : 7;
        final int cz = (this.size > 9) ? 4 : 3;
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.SOUTH, rotation, false), cx, y + 1, cz + 0, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.WEST, rotation, false), cx, y + 1, cz + 1, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.NORTH, rotation, false), cx, y + 1, cz + 2, rotation, sbb);
        cx = ((this.size > 9) ? 5 : 3);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.SOUTH, rotation, true), cx, y + 1, cz + 0, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getSlabState(Blocks.field_150376_bx.func_176223_P(), BlockPlanks.EnumType.SPRUCE, BlockSlab.EnumBlockHalf.TOP), cx, y + 1, cz + 1, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.NORTH, rotation, true), cx, y + 1, cz + 2, rotation, sbb);
    }
    
    private void decorateReappearingFloor(final World world, final Random rand, final StructureBoundingBox sbb, final Rotation rotation, final int y) {
        final IBlockState inactiveReappearing = TFBlocks.tower_device.func_176223_P().func_177226_a((IProperty)BlockTFTowerDevice.VARIANT, (Comparable)TowerDeviceVariant.REAPPEARING_INACTIVE);
        final IBlockState woodenPressurePlate = Blocks.field_150452_aw.func_176223_P();
        this.fillBlocksRotated(world, sbb, 4, y, 3, 7, y, 5, inactiveReappearing, rotation);
        this.fillBlocksRotated(world, sbb, 4, y + 1, 2, 7, y + 1, 2, woodenPressurePlate, rotation);
        this.fillBlocksRotated(world, sbb, 4, y + 1, 6, 7, y + 1, 6, woodenPressurePlate, rotation);
    }
    
    private void decorateExperimentLamp(final World world, final Random rand, final StructureBoundingBox sbb, final Rotation rotation, final int y) {
        final int cx = (this.size > 9) ? 5 : 3;
        final int cz = (this.size > 9) ? 5 : 4;
        final IBlockState redstoneLamp = Blocks.field_150379_bu.func_176223_P();
        this.setBlockStateRotated(world, Blocks.field_150320_F.func_176223_P().func_177226_a((IProperty)BlockDirectional.field_176387_N, (Comparable)EnumFacing.UP), cx, y + 1, cz, rotation, sbb);
        this.setBlockStateRotated(world, redstoneLamp, cx, y + 2, cz, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.accentState, cx, y + 1, cz + 1, rotation, sbb);
        this.setBlockStateRotated(world, getLeverState(Blocks.field_150442_at.func_176223_P(), BlockLever.EnumOrientation.NORTH, rotation, false), cx, y + 1, cz + 2, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.accentState, cx, y + 3, cz - 1, rotation, sbb);
        this.setBlockStateRotated(world, getLeverState(Blocks.field_150442_at.func_176223_P(), BlockLever.EnumOrientation.SOUTH, rotation, true), cx, y + 3, cz - 2, rotation, sbb);
    }
    
    protected static IBlockState getLeverState(final IBlockState initialState, BlockLever.EnumOrientation direction, final Rotation rotation, final boolean isPowered) {
        switch (direction) {
            case UP_X: {
                if (rotation == Rotation.CLOCKWISE_90 || rotation == Rotation.COUNTERCLOCKWISE_90) {
                    direction = BlockLever.EnumOrientation.UP_Z;
                    break;
                }
                break;
            }
            case UP_Z: {
                if (rotation == Rotation.CLOCKWISE_90 || rotation == Rotation.COUNTERCLOCKWISE_90) {
                    direction = BlockLever.EnumOrientation.UP_X;
                    break;
                }
                break;
            }
            case DOWN_X: {
                if (rotation == Rotation.CLOCKWISE_90 || rotation == Rotation.COUNTERCLOCKWISE_90) {
                    direction = BlockLever.EnumOrientation.DOWN_Z;
                    break;
                }
                break;
            }
            case DOWN_Z: {
                if (rotation == Rotation.CLOCKWISE_90 || rotation == Rotation.COUNTERCLOCKWISE_90) {
                    direction = BlockLever.EnumOrientation.DOWN_X;
                    break;
                }
                break;
            }
        }
        return initialState.func_177226_a((IProperty)BlockLever.field_176360_a, (Comparable)direction).func_177226_a((IProperty)BlockLever.field_176359_b, (Comparable)isPowered);
    }
    
    private void decorateExperimentPulser(final World world, final Random rand, final StructureBoundingBox sbb, final Rotation rotation, final int y) {
        final int cx = (this.size > 9) ? 6 : 5;
        final int cz = (this.size > 9) ? 4 : 3;
        final IBlockState redstoneWire = Blocks.field_150488_af.func_176223_P();
        final IBlockState woodenPressurePlate = Blocks.field_150452_aw.func_176223_P();
        final IBlockState stickyPiston = Blocks.field_150320_F.func_176223_P().func_177226_a((IProperty)BlockDirectional.field_176387_N, (Comparable)EnumFacing.SOUTH);
        final IBlockState unpoweredRepeater = Blocks.field_150413_aR.func_176223_P().func_177226_a((IProperty)BlockHorizontal.field_185512_D, (Comparable)EnumFacing.WEST).func_177226_a((IProperty)BlockRedstoneRepeater.field_176410_b, (Comparable)2);
        this.setBlockStateRotated(world, stickyPiston, cx, y + 1, cz + 1, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.accentState, cx, y + 1, cz, rotation, sbb);
        this.setBlockStateRotated(world, redstoneWire, cx + 1, y + 1, cz, rotation, sbb);
        this.setBlockStateRotated(world, woodenPressurePlate, cx + 2, y + 1, cz, rotation, sbb);
        this.setBlockStateRotated(world, unpoweredRepeater, cx - 1, y + 1, cz, rotation, sbb);
        this.setBlockStateRotated(world, redstoneWire, cx - 2, y + 1, cz, rotation, sbb);
        this.setBlockStateRotated(world, redstoneWire, cx - 2, y + 1, cz + 1, rotation, sbb);
        this.setBlockStateRotated(world, redstoneWire, cx - 1, y + 1, cz + 1, rotation, sbb);
    }
    
    private void decorateLibrary(final World world, final Random rand, final StructureBoundingBox sbb, final Rotation rotation, final int y) {
        int bx = (this.size > 9) ? 4 : 3;
        int bz = (this.size > 9) ? 3 : 2;
        this.makeSmallBookshelf(world, sbb, rotation, y, bx, bz);
        bx = ((this.size > 9) ? 9 : 7);
        bz = ((this.size > 9) ? 3 : 2);
        this.makeSmallBookshelf(world, sbb, rotation, y, bx, bz);
    }
    
    protected void makeSmallBookshelf(final World world, final StructureBoundingBox sbb, final Rotation rotation, final int y, final int bx, final int bz) {
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.NORTH, rotation, false), bx, y + 1, bz + 0, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.NORTH, rotation, true), bx, y + 2, bz + 0, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.SOUTH, rotation, false), bx, y + 1, bz + 3, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.SOUTH, rotation, true), bx, y + 2, bz + 3, rotation, sbb);
        final IBlockState bookshelf = Blocks.field_150342_X.func_176223_P();
        this.setBlockStateRotated(world, bookshelf, bx, y + 1, bz + 1, rotation, sbb);
        this.setBlockStateRotated(world, bookshelf, bx, y + 2, bz + 1, rotation, sbb);
        this.setBlockStateRotated(world, bookshelf, bx, y + 1, bz + 2, rotation, sbb);
        this.setBlockStateRotated(world, bookshelf, bx, y + 2, bz + 2, rotation, sbb);
    }
    
    private void decoratePuzzleChest(final World world, final Random rand, final StructureBoundingBox sbb, final Rotation rotation, final int y) {
        final int x = (this.size > 9) ? 4 : 3;
        final int z = (this.size > 9) ? 5 : 4;
        this.makePillarFrame(world, sbb, this.deco, rotation, x, y, z, true);
        this.setBlockStateRotated(world, this.deco.platformState, x + 1, y + 1, z + 1, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.blockState, x + 2, y + 1, z + 1, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.blockState, x + 0, y + 1, z + 1, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.blockState, x + 1, y + 1, z + 2, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.blockState, x + 1, y + 1, z + 0, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.blockState, x + 2, y + 3, z + 1, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.blockState, x + 0, y + 3, z + 1, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.blockState, x + 1, y + 3, z + 2, rotation, sbb);
        this.setBlockStateRotated(world, ComponentTFDarkTowerWing.AIR, x + 1, y + 3, z + 0, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.blockState, x + 1, y + 3, z + 1, rotation, sbb);
        this.setBlockStateRotated(world, Blocks.field_150320_F.func_176223_P().func_177226_a((IProperty)BlockDirectional.field_176387_N, (Comparable)EnumFacing.NORTH), x + 1, y + 3, z - 1, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.accentState, x + 1, y + 3, z - 2, rotation, sbb);
        this.setBlockStateRotated(world, getLeverState(Blocks.field_150442_at.func_176223_P(), BlockLever.EnumOrientation.WEST, rotation, false), x + 2, y + 3, z - 2, rotation, sbb);
        this.placeTreasureRotated(world, x + 1, y + 2, z + 1, rotation, TFTreasure.darktower_cache, sbb);
    }
    
    protected void makePillarFrame(final World world, final StructureBoundingBox sbb, final StructureTFDecorator myDeco, final Rotation rotation, final int x, final int y, final int z, final boolean fenced) {
        this.makePillarFrame(world, sbb, myDeco, rotation, x, y, z, 3, 3, 3, fenced);
    }
    
    protected void makePillarFrame(final World world, final StructureBoundingBox sbb, final StructureTFDecorator myDeco, final Rotation rotation, final int x, final int y, final int z, final int width, final int height, final int length, final boolean fenced) {
        for (int dx = 0; dx < width; ++dx) {
            for (int dz = 0; dz < length; ++dz) {
                if ((dx % 3 == 0 || dx == width - 1) && (dz % 3 == 0 || dz == length - 1)) {
                    for (int py = 1; py <= height; ++py) {
                        this.setBlockStateRotated(world, myDeco.pillarState, x + dx, y + py, z + dz, rotation, sbb);
                    }
                }
                else {
                    if (dx == 0) {
                        final IBlockState southStairs = StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.WEST, rotation, false);
                        this.setBlockStateRotated(world, southStairs, x + dx, y + 1, z + dz, rotation, sbb);
                        this.setBlockStateRotated(world, southStairs.func_177226_a((IProperty)BlockStairs.field_176308_b, (Comparable)BlockStairs.EnumHalf.TOP), x + dx, y + height, z + dz, rotation, sbb);
                    }
                    else if (dx == width - 1) {
                        final IBlockState northStairs = StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.EAST, rotation, false);
                        this.setBlockStateRotated(world, northStairs, x + dx, y + 1, z + dz, rotation, sbb);
                        this.setBlockStateRotated(world, northStairs.func_177226_a((IProperty)BlockStairs.field_176308_b, (Comparable)BlockStairs.EnumHalf.TOP), x + dx, y + height, z + dz, rotation, sbb);
                    }
                    else if (dz == 0) {
                        final IBlockState westStairs = StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.NORTH, rotation, false);
                        this.setBlockStateRotated(world, westStairs, x + dx, y + 1, z + dz, rotation, sbb);
                        this.setBlockStateRotated(world, westStairs.func_177226_a((IProperty)BlockStairs.field_176308_b, (Comparable)BlockStairs.EnumHalf.TOP), x + dx, y + height, z + dz, rotation, sbb);
                    }
                    else if (dz == length - 1) {
                        final IBlockState eastStairs = StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.SOUTH, rotation, false);
                        this.setBlockStateRotated(world, eastStairs, x + dx, y + 1, z + dz, rotation, sbb);
                        this.setBlockStateRotated(world, eastStairs.func_177226_a((IProperty)BlockStairs.field_176308_b, (Comparable)BlockStairs.EnumHalf.TOP), x + dx, y + height, z + dz, rotation, sbb);
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
    
    protected void addStairsDown(final World world, final StructureBoundingBox sbb, final Rotation rotation, final int y, final int sz, final int spacing) {
        for (int i = 0; i < spacing; ++i) {
            final int sx = this.size - 3 - i;
            this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.WEST, rotation, false), sx, y - i, sz, rotation, sbb);
            this.setBlockStateRotated(world, this.deco.accentState, sx, y - 1 - i, sz, rotation, sbb);
            this.setBlockStateRotated(world, ComponentTFDarkTowerWing.AIR, sx, y + 1 - i, sz, rotation, sbb);
            this.setBlockStateRotated(world, ComponentTFDarkTowerWing.AIR, sx, y + 2 - i, sz, rotation, sbb);
            this.setBlockStateRotated(world, ComponentTFDarkTowerWing.AIR, sx - 1, y + 2 - i, sz, rotation, sbb);
            this.setBlockStateRotated(world, ComponentTFDarkTowerWing.AIR, sx, y + 3 - i, sz, rotation, sbb);
            this.setBlockStateRotated(world, ComponentTFDarkTowerWing.AIR, sx - 1, y + 3 - i, sz, rotation, sbb);
        }
    }
    
    protected void addSmallTimberBeams(final World world, final Random rand, final StructureBoundingBox sbb, int bottom, final int top) {
        final int spacing = 4;
        Rotation rotation = Rotation.NONE;
        if (bottom == 0) {
            bottom += spacing;
        }
        for (int y = bottom; y < top; y += spacing) {
            rotation = rotation.func_185830_a(Rotation.CLOCKWISE_90);
            if (y >= top - spacing && this.isDeadEnd()) {
                this.makeTimberFloor(world, rand, sbb, rotation, y, spacing);
                final StructureTFDecorator logDeco = new StructureDecoratorDarkTower();
                logDeco.pillarState = TFBlocks.twilight_log.func_176223_P().func_177226_a((IProperty)BlockTFLog.VARIANT, (Comparable)WoodVariant.DARK);
                logDeco.platformState = TFBlocks.twilight_log.func_176223_P().func_177226_a((IProperty)BlockTFLog.VARIANT, (Comparable)WoodVariant.DARK);
                this.decorateTreasureRoom(world, sbb, rotation, y, 4, logDeco);
            }
            else {
                final int y2;
                this.makeSmallTimberBeams(world, rand, sbb, rotation, y2, (y2 = y) == bottom && bottom != spacing, y >= top - spacing);
            }
        }
    }
    
    protected void makeTimberFloor(final World world, final Random rand, final StructureBoundingBox sbb, final Rotation rotation, final int y, final int spacing) {
        final IBlockState beamID = TFBlocks.twilight_log.func_176223_P().func_177226_a((IProperty)BlockTFLog.VARIANT, (Comparable)WoodVariant.DARK);
        final IBlockState beamStateNS = beamID.func_177226_a((IProperty)BlockLog.field_176299_a, (Comparable)BlockLog.EnumAxis.Z);
        final IBlockState beamStateUD = beamID.func_177226_a((IProperty)BlockLog.field_176299_a, (Comparable)BlockLog.EnumAxis.Y);
        final IBlockState beamStateEW = beamID.func_177226_a((IProperty)BlockLog.field_176299_a, (Comparable)BlockLog.EnumAxis.X);
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
            final IBlockState ladder = Blocks.field_150468_ap.func_176223_P();
            this.setBlockStateRotated(world, beamStateUD, 2, y - by, 2, rotation, sbb);
            this.setBlockStateRotated(world, ladder.func_177226_a((IProperty)BlockLadder.field_176382_a, (Comparable)EnumFacing.WEST), 3, y - by, 2, rotation, sbb);
            this.setBlockStateRotated(world, beamStateUD, 6, y - by, 6, rotation, sbb);
            this.setBlockStateRotated(world, ladder.func_177226_a((IProperty)BlockLadder.field_176382_a, (Comparable)EnumFacing.EAST), 5, y - by, 6, rotation, sbb);
        }
        this.setBlockStateRotated(world, ComponentTFDarkTowerWing.AIR, 3, y, 2, rotation, sbb);
        this.setBlockStateRotated(world, ComponentTFDarkTowerWing.AIR, 5, y, 6, rotation, sbb);
    }
    
    protected void makeSmallTimberBeams(final World world, final Random rand, final StructureBoundingBox sbb, final Rotation rotation, final int y, final boolean bottom, final boolean top) {
        final IBlockState beamID = TFBlocks.twilight_log.func_176223_P().func_177226_a((IProperty)BlockTFLog.VARIANT, (Comparable)WoodVariant.DARK);
        final IBlockState beamStateNS = beamID.func_177226_a((IProperty)BlockLog.field_176299_a, (Comparable)BlockLog.EnumAxis.X);
        final IBlockState beamStateUD = beamID.func_177226_a((IProperty)BlockLog.field_176299_a, (Comparable)BlockLog.EnumAxis.Y);
        final IBlockState beamStateEW = beamID.func_177226_a((IProperty)BlockLog.field_176299_a, (Comparable)BlockLog.EnumAxis.Z);
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
            final IBlockState ladder = Blocks.field_150468_ap.func_176223_P();
            if (!bottom || this.checkPost(world, x2, y - 4, z2, rotation, sbb)) {
                this.setBlockStateRotated(world, beamStateUD, x2, y - by, z2, rotation, sbb);
                this.setBlockStateRotated(world, ladder.func_177226_a((IProperty)BlockLadder.field_176382_a, (Comparable)EnumFacing.WEST), x2 + 1, y - by, z2, rotation, sbb);
            }
            if (!bottom || this.checkPost(world, x3, y - 4, z3, rotation, sbb)) {
                this.setBlockStateRotated(world, beamStateUD, x3, y - by, z3, rotation, sbb);
                this.setBlockStateRotated(world, ladder.func_177226_a((IProperty)BlockLadder.field_176382_a, (Comparable)EnumFacing.EAST), x3 - 1, y - by, z3, rotation, sbb);
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
    
    protected boolean checkPost(final World world, final int x, final int y, final int z, final Rotation rotation, final StructureBoundingBox sbb) {
        final int worldX = this.getXWithOffsetRotated(x, z, rotation);
        final int worldY = this.func_74862_a(y);
        final int worldZ = this.getZWithOffsetRotated(x, z, rotation);
        final BlockPos vec = new BlockPos(worldX, worldY, worldZ);
        if (!sbb.func_175898_b((Vec3i)vec)) {
            return false;
        }
        final IBlockState blockState = world.func_180495_p(vec);
        return blockState.func_177230_c() != Blocks.field_150350_a && blockState != this.deco.accentState;
    }
    
    protected void makeEncasedWalls(final World world, final Random rand, final StructureBoundingBox sbb, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ) {
        for (int x = minX; x <= maxX; ++x) {
            for (int y = minY; y <= maxY; ++y) {
                for (int z = minZ; z <= maxZ; ++z) {
                    if (x == minX || x == maxX || y == minY || y == maxY || z == minZ || z == maxZ) {
                        if (((x == minY || x == maxX) && (y == minY || y == maxY || z == minZ || z == maxZ)) || ((y == minY || y == maxY) && (x == minY || x == maxX || z == minZ || z == maxZ)) || ((z == minZ || z == maxZ) && (x == minY || x == maxX || y == minY || y == maxY))) {
                            this.func_175811_a(world, this.deco.accentState, x, y, z, sbb);
                        }
                        else {
                            final StructureComponent.BlockSelector blocker = this.deco.randomBlocks;
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
    protected void makeOpenings(final World world, final StructureBoundingBox sbb) {
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
    protected void makeDoorOpening(final World world, final int dx, final int dy, final int dz, final StructureBoundingBox sbb) {
        this.nullifySkyLightAtCurrentPosition(world, dx - 3, dy - 1, dz - 3, dx + 3, dy + 3, dz + 3);
        final IBlockState inactiveVanish = TFBlocks.tower_device.func_176223_P().func_177226_a((IProperty)BlockTFTowerDevice.VARIANT, (Comparable)TowerDeviceVariant.VANISH_INACTIVE);
        if (dx == 0 || dx == this.size - 1) {
            this.func_175804_a(world, sbb, dx, dy - 1, dz - 2, dx, dy + 3, dz + 2, this.deco.accentState, ComponentTFDarkTowerWing.AIR, false);
            this.func_175804_a(world, sbb, dx, dy, dz - 1, dx, dy + 2, dz + 1, inactiveVanish, ComponentTFDarkTowerWing.AIR, false);
        }
        if (dz == 0 || dz == this.size - 1) {
            this.func_175804_a(world, sbb, dx - 2, dy - 1, dz, dx + 2, dy + 3, dz, this.deco.accentState, ComponentTFDarkTowerWing.AIR, false);
            this.func_175804_a(world, sbb, dx - 1, dy, dz, dx + 1, dy + 2, dz, inactiveVanish, ComponentTFDarkTowerWing.AIR, false);
        }
    }
    
    protected void makeReappearingDoorOpening(final World world, final int dx, final int dy, final int dz, final StructureBoundingBox sbb) {
        this.nullifySkyLightAtCurrentPosition(world, dx - 3, dy - 1, dz - 3, dx + 3, dy + 3, dz + 3);
        final IBlockState inactiveReappearing = TFBlocks.tower_device.func_176223_P().func_177226_a((IProperty)BlockTFTowerDevice.VARIANT, (Comparable)TowerDeviceVariant.REAPPEARING_INACTIVE);
        if (dx == 0 || dx == this.size - 1) {
            this.func_175804_a(world, sbb, dx, dy - 1, dz - 2, dx, dy + 3, dz + 2, this.deco.accentState, ComponentTFDarkTowerWing.AIR, false);
            this.func_175804_a(world, sbb, dx, dy, dz - 1, dx, dy + 2, dz + 1, inactiveReappearing, ComponentTFDarkTowerWing.AIR, false);
        }
        if (dz == 0 || dz == this.size - 1) {
            this.func_175804_a(world, sbb, dx - 2, dy - 1, dz, dx + 2, dy + 3, dz, this.deco.accentState, ComponentTFDarkTowerWing.AIR, false);
            this.func_175804_a(world, sbb, dx - 1, dy, dz, dx + 1, dy + 2, dz, inactiveReappearing, ComponentTFDarkTowerWing.AIR, false);
        }
    }
    
    protected void makeLockedDoorOpening(final World world, final int dx, final int dy, final int dz, final StructureBoundingBox sbb) {
        this.nullifySkyLightAtCurrentPosition(world, dx - 3, dy - 1, dz - 3, dx + 3, dy + 3, dz + 3);
        final IBlockState lockedVanish = TFBlocks.tower_device.func_176223_P().func_177226_a((IProperty)BlockTFTowerDevice.VARIANT, (Comparable)TowerDeviceVariant.VANISH_LOCKED);
        final IBlockState inactiveVanish = TFBlocks.tower_device.func_176223_P().func_177226_a((IProperty)BlockTFTowerDevice.VARIANT, (Comparable)TowerDeviceVariant.VANISH_INACTIVE);
        if (dx == 0 || dx == this.size - 1) {
            this.func_175804_a(world, sbb, dx, dy - 1, dz - 2, dx, dy + 3, dz + 2, this.deco.accentState, ComponentTFDarkTowerWing.AIR, false);
            this.func_175804_a(world, sbb, dx, dy, dz - 1, dx, dy + 2, dz + 1, inactiveVanish, ComponentTFDarkTowerWing.AIR, false);
            this.func_175811_a(world, lockedVanish, dx, dy + 0, dz + 1, sbb);
            this.func_175811_a(world, lockedVanish, dx, dy + 0, dz - 1, sbb);
            this.func_175811_a(world, lockedVanish, dx, dy + 2, dz + 1, sbb);
            this.func_175811_a(world, lockedVanish, dx, dy + 2, dz - 1, sbb);
        }
        if (dz == 0 || dz == this.size - 1) {
            this.func_175804_a(world, sbb, dx - 2, dy - 1, dz, dx + 2, dy + 3, dz, this.deco.accentState, ComponentTFDarkTowerWing.AIR, false);
            this.func_175804_a(world, sbb, dx - 1, dy, dz, dx + 1, dy + 2, dz, inactiveVanish, ComponentTFDarkTowerWing.AIR, false);
            this.func_175811_a(world, lockedVanish, dx + 1, dy + 0, dz, sbb);
            this.func_175811_a(world, lockedVanish, dx - 1, dy + 0, dz, sbb);
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
