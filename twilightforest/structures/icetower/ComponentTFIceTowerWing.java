// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.icetower;

import twilightforest.structures.lichtower.ComponentTFTowerRoof;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockRotatedPillar;
import twilightforest.loot.TFTreasure;
import java.util.Iterator;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.BlockPos;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import twilightforest.util.RotationUtil;
import net.minecraft.util.Rotation;
import twilightforest.structures.StructureTFComponentOld;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;
import twilightforest.structures.lichtower.ComponentTFTowerWing;

public class ComponentTFIceTowerWing extends ComponentTFTowerWing
{
    protected static final int SIZE = 11;
    private static final int RANGE = 17;
    boolean hasBase;
    protected int treasureFloor;
    
    public ComponentTFIceTowerWing() {
        this.hasBase = false;
        this.treasureFloor = -1;
    }
    
    protected ComponentTFIceTowerWing(final TFFeature feature, final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final EnumFacing direction) {
        super(feature, i, x, y, z, pSize, pHeight, direction);
        this.hasBase = false;
        this.treasureFloor = -1;
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound tagCompound) {
        super.func_143012_a(tagCompound);
        tagCompound.func_74757_a("hasBase", this.hasBase);
        tagCompound.func_74768_a("treasureFloor", this.treasureFloor);
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound tagCompound, final TemplateManager templateManager) {
        super.func_143011_b(tagCompound, templateManager);
        this.hasBase = tagCompound.func_74767_n("hasBase");
        this.treasureFloor = tagCompound.func_74762_e("treasureFloor");
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponentOld) {
            this.deco = ((StructureTFComponentOld)parent).deco;
        }
        this.addOpening(0, 1, this.size / 2, Rotation.CLOCKWISE_180);
        this.hasBase = this.shouldHaveBase(rand);
        if (this.func_74877_c() < 5) {
            final Rotation dirOffset = RotationUtil.ROTATIONS[rand.nextInt(RotationUtil.ROTATIONS.length)];
            for (final Rotation rotation : RotationUtil.ROTATIONS) {
                final Rotation dir = dirOffset.func_185830_a(rotation);
                final int[] dest = this.getValidOpening(rand, dir);
                if (this.func_74877_c() == 4 && parent instanceof ComponentTFIceTowerMain && !((ComponentTFIceTowerMain)parent).hasBossWing) {
                    final boolean hasBoss = this.makeBossTowerWing(list, rand, this.func_74877_c() + 1, dest[0], dest[1], dest[2], 15, 41, dir);
                    ((ComponentTFIceTowerMain)parent).hasBossWing = hasBoss;
                }
                else {
                    final int childHeight = (rand.nextInt(2) + rand.nextInt(2) + 2) * 10 + 1;
                    this.makeTowerWing(list, rand, this.func_74877_c() + 1, dest[0], dest[1], dest[2], 11, childHeight, dir);
                }
            }
        }
        final int floors = this.height / 10;
        if (this.treasureFloor == -1 && floors > 1) {
            this.treasureFloor = rand.nextInt(floors - 1);
        }
        this.makeARoof(parent, list, rand);
        if (!this.hasBase) {
            this.makeABeard(parent, list, rand);
        }
    }
    
    protected boolean shouldHaveBase(final Random rand) {
        return this.func_74877_c() == 0 || rand.nextBoolean();
    }
    
    private boolean isOutOfRange(final StructureComponent parent, final int nx, final int ny, final int nz, final int range) {
        final StructureBoundingBox sbb = parent.func_74874_b();
        final int centerX = sbb.field_78897_a + (sbb.field_78893_d - sbb.field_78897_a + 1) / 2;
        final int centerZ = sbb.field_78896_c + (sbb.field_78892_f - sbb.field_78896_c + 1) / 2;
        return Math.abs(nx - centerX) > range || Math.abs(nz - centerZ) > range;
    }
    
    @Override
    public boolean makeTowerWing(final List<StructureComponent> list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final Rotation rotation) {
        final EnumFacing direction = this.getStructureRelativeRotation(rotation);
        final int[] dx = this.offsetTowerCoords(x, y, z, wingSize, direction);
        if (this.isOutOfRange(list.get(0), dx[0], dx[1], dx[2], 17)) {
            return false;
        }
        final ComponentTFIceTowerWing wing = new ComponentTFIceTowerWing(this.getFeatureType(), index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        final StructureComponent intersect = StructureComponent.func_74883_a((List)list, wing.func_74874_b());
        if (intersect == null || intersect == this) {
            list.add(wing);
            wing.func_74861_a(list.get(0), list, rand);
            this.addOpening(x, y, z, rotation);
            return true;
        }
        return false;
    }
    
    public boolean makeBossTowerWing(final List<StructureComponent> list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final Rotation rotation) {
        final EnumFacing direction = this.getStructureRelativeRotation(rotation);
        final int[] dx = this.offsetTowerCoords(x, y, z, wingSize, direction);
        final ComponentTFIceTowerWing wing = new ComponentTFIceTowerBossWing(this.getFeatureType(), index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        final StructureComponent intersect = StructureComponent.func_74883_a((List)list, wing.func_74874_b());
        if (intersect == null || intersect == this) {
            list.add(wing);
            wing.func_74861_a(list.get(0), list, rand);
            this.addOpening(x, y, z, rotation);
            return true;
        }
        return false;
    }
    
    @Override
    protected int getYByStairs(final int rx, final Random rand, final Rotation direction) {
        final int floors = this.height / 10;
        return 11 + rand.nextInt(floors - 1) * 10;
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        final Random decoRNG = new Random(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
        this.func_74882_a(world, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1, false, rand, this.deco.randomBlocks);
        this.func_74878_a(world, sbb, 1, 1, 1, this.size - 2, this.height - 2, this.size - 2);
        if (this.hasBase) {
            for (int x = 0; x < this.size; ++x) {
                for (int z = 0; z < this.size; ++z) {
                    this.func_175808_b(world, this.deco.blockState, x, -1, z, sbb);
                }
            }
        }
        this.nullifySkyLightForBoundingBox(world);
        this.makeFloorsForTower(world, decoRNG, sbb);
        this.makeOpenings(world, sbb);
        return true;
    }
    
    @Override
    public void nullifySkyLightForBoundingBox(final World world) {
        this.nullifySkyLight(world, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b + 1, this.field_74887_e.field_78896_c + 1, this.field_74887_e.field_78893_d - 1, this.field_74887_e.field_78894_e - 1, this.field_74887_e.field_78892_f - 1);
    }
    
    protected void makeFloorsForTower(final World world, final Random decoRNG, final StructureBoundingBox sbb) {
        final int floors = this.height / 10;
        final Rotation ladderDir = Rotation.COUNTERCLOCKWISE_90;
        Rotation downLadderDir = null;
        final int floorHeight = 10;
        for (int i = 0; i < floors - 1; ++i) {
            this.placeFloor(world, decoRNG, sbb, floorHeight, i);
            downLadderDir = ladderDir.func_185830_a(Rotation.CLOCKWISE_90);
            this.decorateFloor(world, decoRNG, i, i * floorHeight, i * floorHeight + floorHeight, ladderDir, downLadderDir, sbb);
        }
        final int topFloor = floors - 1;
        this.decorateTopFloor(world, decoRNG, topFloor, topFloor * floorHeight, topFloor * floorHeight + floorHeight, ladderDir, downLadderDir, sbb);
    }
    
    protected void placeFloor(final World world, final Random rand, final StructureBoundingBox sbb, final int floorHeight, final int floor) {
        for (int x = 1; x < this.size - 1; ++x) {
            for (int z = 1; z < this.size - 1; ++z) {
                this.func_175811_a(world, this.deco.floorState, x, floor * floorHeight + floorHeight, z, sbb);
            }
        }
    }
    
    @Override
    protected void makeDoorOpening(final World world, final int dx, final int dy, final int dz, final StructureBoundingBox sbb) {
        super.makeDoorOpening(world, dx, dy, dz, sbb);
        if (this.func_175807_a(world, dx, dy + 2, dz, sbb).func_177230_c() != Blocks.field_150350_a) {
            this.func_175811_a(world, this.deco.accentState, dx, dy + 2, dz, sbb);
        }
    }
    
    @Override
    protected void decorateFloor(final World world, final Random rand, final int floor, final int bottom, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final StructureBoundingBox sbb) {
        final boolean hasTreasure = this.treasureFloor == floor;
        switch (rand.nextInt(8)) {
            case 0: {
                if (this.isNoDoorAreaRotated(9, bottom + 5, 1, 10, top + 1, 7, ladderUpDir)) {
                    this.decorateWraparoundWallSteps(world, rand, bottom, top, ladderUpDir, ladderDownDir, hasTreasure, sbb);
                    break;
                }
            }
            case 1: {
                if (this.isNoDoorAreaRotated(7, bottom, 0, 10, top + 1, 10, ladderUpDir)) {
                    this.decorateFarWallSteps(world, rand, bottom, top, ladderUpDir, ladderDownDir, hasTreasure, sbb);
                    break;
                }
            }
            case 2: {
                if (this.isNoDoorAreaRotated(9, bottom + 5, 1, 10, top + 1, 7, ladderUpDir)) {
                    this.decorateWraparoundWallStepsPillars(world, rand, bottom, top, ladderUpDir, ladderDownDir, hasTreasure, sbb);
                    break;
                }
            }
            case 3: {
                this.decoratePlatform(world, rand, bottom, top, ladderUpDir, ladderDownDir, hasTreasure, sbb);
                break;
            }
            case 4: {
                this.decoratePillarParkour(world, rand, bottom, top, ladderUpDir, ladderDownDir, hasTreasure, sbb);
                break;
            }
            case 5: {
                this.decoratePillarPlatforms(world, rand, bottom, top, ladderUpDir, ladderDownDir, hasTreasure, sbb);
                break;
            }
            case 6: {
                this.decoratePillarPlatformsOutside(world, rand, bottom, top, ladderUpDir, ladderDownDir, hasTreasure, sbb);
                break;
            }
            default: {
                this.decorateQuadPillarStairs(world, rand, bottom, top, ladderUpDir, ladderDownDir, hasTreasure, sbb);
                break;
            }
        }
    }
    
    private boolean isNoDoorAreaRotated(final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ, final Rotation rotation) {
        boolean isClear = true;
        StructureBoundingBox exclusionBox = null;
        switch (rotation) {
            default: {
                exclusionBox = new StructureBoundingBox(minX, minY, minZ, maxX, maxY, maxZ);
                break;
            }
            case CLOCKWISE_90: {
                exclusionBox = new StructureBoundingBox(this.size - 1 - maxZ, minY, minX, this.size - 1 - minZ, maxY, maxX);
                break;
            }
            case CLOCKWISE_180: {
                exclusionBox = new StructureBoundingBox(this.size - 1 - maxX, minY, this.size - 1 - maxZ, this.size - 1 - minX, maxY, this.size - 1 - minZ);
                break;
            }
            case COUNTERCLOCKWISE_90: {
                exclusionBox = new StructureBoundingBox(minZ, minY, this.size - 1 - maxX, maxZ, maxY, this.size - 1 - minX);
                break;
            }
        }
        for (final BlockPos door : this.openings) {
            if (exclusionBox.func_175898_b((Vec3i)door)) {
                isClear = false;
            }
        }
        return isClear;
    }
    
    protected void decorateTopFloor(final World world, final Random rand, final int floor, final int bottom, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final StructureBoundingBox sbb) {
        if (rand.nextBoolean()) {
            this.decoratePillarsCorners(world, rand, bottom, top, ladderDownDir, sbb);
        }
        else {
            this.decoratePillarsGrid(world, rand, bottom, top, ladderDownDir, sbb);
        }
        if (this.isDeadEnd()) {
            this.decorateTopFloorTreasure(world, rand, bottom, top, ladderDownDir, sbb);
        }
    }
    
    private void decorateTopFloorTreasure(final World world, final Random rand, final int bottom, final int top, final Rotation rotation, final StructureBoundingBox sbb) {
        this.fillBlocksRotated(world, sbb, 5, bottom + 1, 5, 5, bottom + 4, 5, this.deco.pillarState, rotation);
        this.placeTreasureAtCurrentPosition(world, null, 5, bottom + 5, 5, TFTreasure.aurora_room, sbb);
    }
    
    private void decoratePillars(final World world, final Random rand, final int bottom, final int top, final Rotation rotation, final StructureBoundingBox sbb) {
        this.fillBlocksRotated(world, sbb, 3, bottom + 1, 3, 3, top - 1, 3, this.deco.pillarState, rotation);
        this.fillBlocksRotated(world, sbb, 7, bottom + 1, 3, 7, top - 1, 3, this.deco.pillarState, rotation);
        this.fillBlocksRotated(world, sbb, 3, bottom + 1, 7, 3, top - 1, 7, this.deco.pillarState, rotation);
        this.fillBlocksRotated(world, sbb, 7, bottom + 1, 7, 7, top - 1, 7, this.deco.pillarState, rotation);
    }
    
    private void decoratePillarsGrid(final World world, final Random rand, final int bottom, final int top, final Rotation rotation, final StructureBoundingBox sbb) {
        final IBlockState pillarEW = this.deco.pillarState.func_177226_a((IProperty)BlockRotatedPillar.field_176298_M, (Comparable)EnumFacing.Axis.Z);
        final IBlockState pillarNS = this.deco.pillarState.func_177226_a((IProperty)BlockRotatedPillar.field_176298_M, (Comparable)EnumFacing.Axis.X);
        this.fillBlocksRotated(world, sbb, 3, bottom + 5, 1, 3, bottom + 5, 9, pillarEW, rotation);
        this.fillBlocksRotated(world, sbb, 7, bottom + 5, 1, 7, bottom + 5, 9, pillarEW, rotation);
        this.fillBlocksRotated(world, sbb, 1, bottom + 5, 3, 9, bottom + 5, 3, pillarNS, rotation);
        this.fillBlocksRotated(world, sbb, 1, bottom + 5, 7, 9, bottom + 5, 7, pillarNS, rotation);
        this.decoratePillars(world, rand, bottom, top, rotation, sbb);
    }
    
    private void decoratePillarsCorners(final World world, final Random rand, final int bottom, final int top, final Rotation rotation, final StructureBoundingBox sbb) {
        final IBlockState pillarEW = this.deco.pillarState.func_177226_a((IProperty)BlockRotatedPillar.field_176298_M, (Comparable)EnumFacing.Axis.Z);
        final IBlockState pillarNS = this.deco.pillarState.func_177226_a((IProperty)BlockRotatedPillar.field_176298_M, (Comparable)EnumFacing.Axis.X);
        this.fillBlocksRotated(world, sbb, 3, bottom + 5, 1, 3, bottom + 5, 9, pillarEW, rotation);
        this.fillBlocksRotated(world, sbb, 7, bottom + 5, 1, 7, bottom + 5, 9, pillarEW, rotation);
        this.fillBlocksRotated(world, sbb, 1, bottom + 5, 3, 9, bottom + 5, 3, pillarNS, rotation);
        this.fillBlocksRotated(world, sbb, 1, bottom + 5, 7, 9, bottom + 5, 7, pillarNS, rotation);
        this.fillAirRotated(world, sbb, 3, bottom + 5, 3, 7, bottom + 5, 7, rotation);
        this.decoratePillars(world, rand, bottom, top, rotation, sbb);
    }
    
    private void decorateFarWallSteps(final World world, final Random rand, final int bottom, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final boolean hasTreasure, final StructureBoundingBox sbb) {
        for (int z = 1; z < 10; ++z) {
            final int y = bottom + 10 - z / 2;
            this.setBlockStateRotated(world, (z % 2 == 0) ? this.deco.pillarState : this.deco.platformState, 9, y, z, ladderUpDir, sbb);
            for (int by = bottom + 1; by < y; ++by) {
                this.setBlockStateRotated(world, this.deco.pillarState, 9, by, z, ladderUpDir, sbb);
            }
        }
        for (int z = 1; z < 10; ++z) {
            final int y = bottom + 1 + z / 2;
            this.setBlockStateRotated(world, (z % 2 == 0) ? this.deco.platformState : this.deco.pillarState, 8, y, z, ladderUpDir, sbb);
            for (int by = bottom + 1; by < y; ++by) {
                this.setBlockStateRotated(world, this.deco.pillarState, 8, by, z, ladderUpDir, sbb);
            }
        }
        this.setBlockStateRotated(world, this.deco.platformState, 7, bottom + 1, 1, ladderUpDir, sbb);
        for (int z = 2; z < 7; ++z) {
            this.setBlockStateRotated(world, ComponentTFIceTowerWing.AIR, 9, top, z, ladderUpDir, sbb);
        }
        final IBlockState pillarNS = this.deco.pillarState.func_177226_a((IProperty)BlockRotatedPillar.field_176298_M, (Comparable)EnumFacing.Axis.X);
        if (hasTreasure) {
            this.placeTreasureRotated(world, 1, bottom + 8, 5, ladderUpDir, TFTreasure.aurora_cache, false, sbb);
            this.setBlockStateRotated(world, pillarNS, 1, bottom + 7, 5, ladderUpDir, sbb);
        }
    }
    
    private void decorateWraparoundWallSteps(final World world, final Random rand, final int bottom, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final boolean hasTreasure, final StructureBoundingBox sbb) {
        final IBlockState topPlatform = this.deco.platformState.func_177226_a((IProperty)BlockSlab.field_176554_a, (Comparable)BlockSlab.EnumBlockHalf.TOP);
        final IBlockState bottomPlatform = this.deco.platformState.func_177226_a((IProperty)BlockSlab.field_176554_a, (Comparable)BlockSlab.EnumBlockHalf.BOTTOM);
        for (int z = 1; z < 10; ++z) {
            final int y = bottom + 10 - z / 2;
            this.setBlockStateRotated(world, (z % 2 == 0) ? topPlatform : bottomPlatform, 9, y, z, ladderUpDir, sbb);
        }
        for (int x = 1; x < 9; ++x) {
            final int y = bottom + 2 + (x - 1) / 2;
            this.setBlockStateRotated(world, (x % 2 == 0) ? topPlatform : bottomPlatform, x, y, 9, ladderUpDir, sbb);
        }
        this.setBlockStateRotated(world, topPlatform, 1, bottom + 1, 8, ladderUpDir, sbb);
        this.setBlockStateRotated(world, this.deco.platformState, 1, bottom + 1, 7, ladderUpDir, sbb);
        for (int z = 2; z < 7; ++z) {
            this.setBlockStateRotated(world, ComponentTFIceTowerWing.AIR, 9, top, z, ladderUpDir, sbb);
        }
        if (hasTreasure) {
            this.placeTreasureRotated(world, 1, bottom + 5, 5, ladderUpDir, TFTreasure.aurora_cache, false, sbb);
            final IBlockState pillarNS = this.deco.pillarState.func_177226_a((IProperty)BlockRotatedPillar.field_176298_M, (Comparable)EnumFacing.Axis.X);
            this.setBlockStateRotated(world, pillarNS, 1, bottom + 4, 5, ladderUpDir, sbb);
        }
    }
    
    private void decorateWraparoundWallStepsPillars(final World world, final Random rand, final int bottom, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final boolean hasTreasure, final StructureBoundingBox sbb) {
        final Rotation rotation = ladderDownDir;
        final IBlockState pillarEW = this.deco.pillarState.func_177226_a((IProperty)BlockRotatedPillar.field_176298_M, (Comparable)EnumFacing.Axis.Z);
        final IBlockState pillarNS = this.deco.pillarState.func_177226_a((IProperty)BlockRotatedPillar.field_176298_M, (Comparable)EnumFacing.Axis.X);
        this.decorateWraparoundWallSteps(world, rand, bottom, top, ladderUpDir, ladderDownDir, false, sbb);
        this.decoratePillars(world, rand, bottom, top, rotation, sbb);
        this.fillBlocksRotated(world, sbb, 3, bottom + 5, 1, 3, bottom + 5, 2, pillarEW, rotation);
        this.fillBlocksRotated(world, sbb, 7, bottom + 5, 1, 7, bottom + 5, 2, pillarEW, rotation);
        this.fillBlocksRotated(world, sbb, 8, bottom + 5, 3, 9, bottom + 5, 3, pillarNS, rotation);
        this.fillBlocksRotated(world, sbb, 8, bottom + 5, 7, 9, bottom + 5, 7, pillarNS, rotation);
        this.fillBlocksRotated(world, sbb, 1, bottom + 2, 3, 2, bottom + 2, 3, pillarNS, rotation);
        this.fillBlocksRotated(world, sbb, 1, bottom + 6, 3, 2, bottom + 6, 3, pillarNS, rotation);
        this.fillBlocksRotated(world, sbb, 1, bottom + 4, 7, 2, bottom + 4, 7, pillarNS, rotation);
        this.fillBlocksRotated(world, sbb, 1, bottom + 8, 7, 2, bottom + 8, 7, pillarNS, rotation);
        this.fillBlocksRotated(world, sbb, 3, bottom + 6, 8, 3, bottom + 6, 9, pillarEW, rotation);
        this.fillBlocksRotated(world, sbb, 7, bottom + 8, 8, 7, bottom + 8, 9, pillarEW, rotation);
        if (hasTreasure) {
            this.placeTreasureRotated(world, 7, bottom + 6, 1, ladderUpDir, TFTreasure.aurora_cache, false, sbb);
        }
    }
    
    private void decoratePlatform(final World world, final Random rand, final int bottom, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final boolean hasTreasure, final StructureBoundingBox sbb) {
        final IBlockState topPlatform = this.deco.platformState.func_177226_a((IProperty)BlockSlab.field_176554_a, (Comparable)BlockSlab.EnumBlockHalf.TOP);
        final IBlockState bottomPlatform = this.deco.platformState.func_177226_a((IProperty)BlockSlab.field_176554_a, (Comparable)BlockSlab.EnumBlockHalf.BOTTOM);
        this.decoratePillars(world, rand, bottom, top, ladderDownDir, sbb);
        this.fillBlocksRotated(world, sbb, 3, bottom + 5, 3, 7, bottom + 5, 7, this.deco.floorState, ladderDownDir);
        for (int z = 6; z < 10; ++z) {
            final int y = bottom - 2 + z / 2;
            this.setBlockStateRotated(world, (z % 2 == 1) ? topPlatform : bottomPlatform, 1, y, z, ladderDownDir, sbb);
        }
        for (int x = 2; x < 6; ++x) {
            final int y = bottom + 2 + x / 2;
            this.setBlockStateRotated(world, (x % 2 == 1) ? topPlatform : bottomPlatform, x, y, 9, ladderDownDir, sbb);
        }
        this.setBlockStateRotated(world, this.deco.platformState, 5, bottom + 5, 8, ladderDownDir, sbb);
        this.setBlockStateRotated(world, this.deco.platformState, 5, bottom + 6, 2, ladderUpDir, sbb);
        for (int x = 5; x < 10; ++x) {
            final int y = bottom + 4 + x / 2;
            this.setBlockStateRotated(world, (x % 2 == 1) ? topPlatform : bottomPlatform, x, y, 1, ladderUpDir, sbb);
            if (x > 6) {
                this.setBlockStateRotated(world, ComponentTFIceTowerWing.AIR, x, top, 1, ladderUpDir, sbb);
            }
        }
        for (int z = 2; z < 5; ++z) {
            final int y = bottom + 8 + z / 2;
            this.setBlockStateRotated(world, ComponentTFIceTowerWing.AIR, 9, top, z, ladderUpDir, sbb);
            this.setBlockStateRotated(world, (z % 2 == 1) ? topPlatform : bottomPlatform, 9, y, z, ladderUpDir, sbb);
        }
        if (hasTreasure) {
            this.placeTreasureRotated(world, 3, bottom + 6, 5, ladderDownDir, TFTreasure.aurora_cache, false, sbb);
        }
    }
    
    private void decorateQuadPillarStairs(final World world, final Random rand, final int bottom, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final boolean hasTreasure, final StructureBoundingBox sbb) {
        this.decoratePillars(world, rand, bottom, top, ladderDownDir, sbb);
        final IBlockState topPlatform = this.deco.platformState.func_177226_a((IProperty)BlockSlab.field_176554_a, (Comparable)BlockSlab.EnumBlockHalf.TOP);
        final IBlockState bottomPlatform = this.deco.platformState.func_177226_a((IProperty)BlockSlab.field_176554_a, (Comparable)BlockSlab.EnumBlockHalf.BOTTOM);
        for (int z = 6; z < 9; ++z) {
            final int y = bottom - 2 + z / 2;
            this.setBlockStateRotated(world, (z % 2 == 1) ? topPlatform : bottomPlatform, 2, y, z, ladderDownDir, sbb);
        }
        for (int x = 3; x < 9; ++x) {
            final int y = bottom + 1 + x / 2;
            this.setBlockStateRotated(world, (x % 2 == 1) ? topPlatform : bottomPlatform, x, y, 8, ladderDownDir, sbb);
        }
        for (int z = 7; z > 1; --z) {
            final int y = top - 2 - (z - 1) / 2;
            if (z < 4) {
                this.setBlockStateRotated(world, ComponentTFIceTowerWing.AIR, 8, top, z, ladderDownDir, sbb);
            }
            this.setBlockStateRotated(world, (z % 2 == 1) ? topPlatform : bottomPlatform, 8, y, z, ladderDownDir, sbb);
        }
        for (int x = 7; x > 3; --x) {
            final int y = top + 1 - (x - 1) / 2;
            this.setBlockStateRotated(world, ComponentTFIceTowerWing.AIR, x, top, 2, ladderDownDir, sbb);
            this.setBlockStateRotated(world, (x % 2 == 1) ? topPlatform : bottomPlatform, x, y, 2, ladderDownDir, sbb);
        }
        if (hasTreasure) {
            this.placeTreasureRotated(world, 3, bottom + 7, 7, ladderUpDir, TFTreasure.aurora_cache, false, sbb);
        }
    }
    
    private void decoratePillarPlatforms(final World world, final Random rand, final int bottom, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final boolean hasTreasure, final StructureBoundingBox sbb) {
        Rotation r = ladderUpDir;
        for (int i = 1; i < 10; ++i) {
            r = r.func_185830_a(Rotation.CLOCKWISE_90);
            this.fillBlocksRotated(world, sbb, 2, bottom + i, 2, 4, bottom + i, 4, this.deco.floorState, this.field_186169_c);
        }
        this.fillAirRotated(world, sbb, 2, top, 2, 8, top, 4, ladderUpDir);
        this.fillAirRotated(world, sbb, 2, top, 2, 4, top, 6, ladderUpDir);
        this.setBlockStateRotated(world, this.deco.platformState, 7, top, 3, ladderUpDir, sbb);
        this.setBlockStateRotated(world, this.deco.platformState, 3, top, 3, ladderUpDir, sbb);
        this.decoratePillars(world, rand, bottom, top, ladderUpDir, sbb);
        if (hasTreasure) {
            this.placeTreasureRotated(world, 3, bottom + 5, 2, ladderUpDir, TFTreasure.aurora_cache, false, sbb);
        }
    }
    
    private void decoratePillarPlatformsOutside(final World world, final Random rand, final int bottom, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final boolean hasTreasure, final StructureBoundingBox sbb) {
        for (int i = 0; i < 2; ++i) {
            for (final Rotation r : RotationUtil.ROTATIONS) {
                if (i != 0 || r != Rotation.NONE) {
                    final Rotation rotation = ladderUpDir.func_185830_a(r);
                    this.fillBlocksRotated(world, sbb, 1, bottom + i, 1, 3, bottom + i, 3, this.deco.platformState, rotation);
                    this.fillBlocksRotated(world, sbb, 4, bottom + i, 1, 6, bottom + i, 3, this.deco.floorState, rotation);
                }
            }
        }
        final Rotation rotation2 = ladderUpDir.func_185830_a(Rotation.CLOCKWISE_180);
        this.fillAirRotated(world, sbb, 5, top, 8, 9, top, 9, rotation2);
        this.fillAirRotated(world, sbb, 8, top, 6, 9, top, 9, rotation2);
        this.fillBlocksRotated(world, sbb, 8, top - 2, 7, 9, top - 2, 7, this.deco.platformState, rotation2);
        this.fillBlocksRotated(world, sbb, 8, top - 2, 8, 9, top - 2, 9, this.deco.floorState, rotation2);
        this.fillBlocksRotated(world, sbb, 7, top - 1, 8, 7, top - 1, 9, this.deco.platformState, rotation2);
        this.fillBlocksRotated(world, sbb, 6, top - 1, 8, 6, top - 1, 9, this.deco.platformState.func_177226_a((IProperty)BlockSlab.field_176554_a, (Comparable)BlockSlab.EnumBlockHalf.TOP), rotation2);
        this.fillBlocksRotated(world, sbb, 5, top - 0, 8, 5, top - 0, 9, this.deco.platformState, rotation2);
        this.decoratePillars(world, rand, bottom, top, ladderUpDir, sbb);
        if (hasTreasure) {
            this.placeTreasureRotated(world, 3, bottom + 5, 2, ladderUpDir, TFTreasure.aurora_cache, false, sbb);
        }
    }
    
    private void decoratePillarParkour(final World world, final Random rand, final int bottom, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final boolean hasTreasure, final StructureBoundingBox sbb) {
        final Rotation rotation = ladderDownDir;
        final IBlockState pillarEW = this.deco.pillarState.func_177226_a((IProperty)BlockRotatedPillar.field_176298_M, (Comparable)EnumFacing.Axis.Z);
        final IBlockState pillarNS = this.deco.pillarState.func_177226_a((IProperty)BlockRotatedPillar.field_176298_M, (Comparable)EnumFacing.Axis.X);
        this.decoratePillars(world, rand, bottom, top, rotation, sbb);
        this.setBlockStateRotated(world, this.deco.pillarState, 5, bottom + 1, 5, rotation, sbb);
        this.fillBlocksRotated(world, sbb, 5, bottom + 2, 7, 5, bottom + 2, 9, pillarEW, rotation);
        this.fillBlocksRotated(world, sbb, 1, bottom + 3, 7, 2, bottom + 3, 7, pillarNS, rotation);
        this.fillBlocksRotated(world, sbb, 3, bottom + 3, 8, 3, bottom + 3, 9, pillarEW, rotation);
        this.fillBlocksRotated(world, sbb, 1, bottom + 7, 7, 2, bottom + 7, 7, pillarNS, rotation);
        this.fillBlocksRotated(world, sbb, 3, bottom + 7, 8, 3, bottom + 7, 9, pillarEW, rotation);
        this.fillAirRotated(world, sbb, 3, bottom + 4, 7, 3, bottom + 6, 7, rotation);
        this.fillBlocksRotated(world, sbb, 1, bottom + 4, 5, 2, bottom + 4, 5, pillarNS, rotation);
        this.fillBlocksRotated(world, sbb, 3, bottom + 5, 1, 3, bottom + 5, 2, pillarEW, rotation);
        this.fillBlocksRotated(world, sbb, 1, bottom + 5, 3, 2, bottom + 5, 3, pillarNS, rotation);
        this.fillAirRotated(world, sbb, 3, bottom + 6, 3, 3, bottom + 8, 3, rotation);
        this.fillBlocksRotated(world, sbb, 5, bottom + 6, 1, 5, bottom + 6, 2, pillarEW, rotation);
        this.fillAirRotated(world, sbb, 7, bottom + 8, 3, 7, bottom + 10, 3, rotation);
        this.fillBlocksRotated(world, sbb, 7, bottom + 7, 1, 7, bottom + 7, 2, pillarEW, rotation);
        this.fillBlocksRotated(world, sbb, 8, bottom + 7, 3, 9, bottom + 7, 3, pillarNS, rotation);
        this.fillBlocksRotated(world, sbb, 8, bottom + 8, 5, 9, bottom + 8, 5, pillarNS, rotation);
        this.fillBlocksRotated(world, sbb, 8, bottom + 9, 7, 9, bottom + 9, 7, pillarNS, rotation);
        this.fillBlocksRotated(world, sbb, 7, bottom + 9, 8, 7, bottom + 9, 9, pillarEW, rotation);
        this.fillAirRotated(world, sbb, 2, top, 2, 8, top, 4, ladderUpDir);
        this.fillAirRotated(world, sbb, 2, top, 2, 4, top, 6, ladderUpDir);
        if (hasTreasure) {
            this.placeTreasureRotated(world, 8, bottom + 8, 7, ladderUpDir, TFTreasure.aurora_cache, false, sbb);
        }
    }
    
    @Override
    public void makeARoof(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        final int index = this.func_74877_c();
        this.tryToFitRoof(list, rand, new ComponentTFIceTowerRoof(this.getFeatureType(), index + 1, this));
    }
    
    @Override
    public void makeABeard(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        final int index = this.func_74877_c();
        final ComponentTFIceTowerBeard beard = new ComponentTFIceTowerBeard(this.getFeatureType(), index + 1, this);
        list.add(beard);
        beard.func_74861_a((StructureComponent)this, (List)list, rand);
    }
}
