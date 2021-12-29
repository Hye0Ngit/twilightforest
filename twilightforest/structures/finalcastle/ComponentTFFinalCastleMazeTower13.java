// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import twilightforest.block.BlockTFCastleDoor;
import twilightforest.block.TFBlocks;
import net.minecraft.world.World;
import twilightforest.block.BlockTFCastleMagic;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import twilightforest.util.RotationUtil;
import twilightforest.TwilightForestMod;
import net.minecraft.util.math.BlockPos;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.util.Rotation;
import twilightforest.structures.StructureTFComponentOld;
import net.minecraft.util.EnumFacing;
import java.util.Random;
import twilightforest.TFFeature;
import net.minecraft.item.EnumDyeColor;
import twilightforest.structures.lichtower.ComponentTFTowerWing;

public class ComponentTFFinalCastleMazeTower13 extends ComponentTFTowerWing
{
    public static final int LOWEST_DOOR = 144;
    public static final int HIGHEST_DOOR = 222;
    public EnumDyeColor color;
    
    public ComponentTFFinalCastleMazeTower13() {
    }
    
    public ComponentTFFinalCastleMazeTower13(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final EnumDyeColor color, final EnumFacing direction) {
        super(feature, i);
        this.func_186164_a(direction);
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
        this.field_74887_e = StructureTFComponentOld.getComponentToAddBoundingBox(x, y, z, -6, 0 - entranceFloor * 8, -6, this.size - 1, this.height, this.size - 1, EnumFacing.SOUTH);
        this.addOpening(0, entranceFloor * 8 + 1, this.size / 2, Rotation.CLOCKWISE_180);
    }
    
    public ComponentTFFinalCastleMazeTower13(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final int floors, final int entranceFloor, final EnumDyeColor color, final EnumFacing direction) {
        super(feature, i);
        this.func_186164_a(direction);
        this.color = color;
        this.size = 13;
        this.height = floors * 8 + 1;
        this.field_74887_e = StructureTFComponentOld.getComponentToAddBoundingBox(x, y, z, -6, 0 - entranceFloor * 8, -6, this.size - 1, this.height, this.size - 1, EnumFacing.SOUTH);
        this.addOpening(0, entranceFloor * 8 + 1, this.size / 2, Rotation.CLOCKWISE_180);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponentOld) {
            this.deco = ((StructureTFComponentOld)parent).deco;
        }
        final ComponentTFFinalCastleFoundation13 foundation = new ComponentTFFinalCastleFoundation13(this.getFeatureType(), rand, 4, this);
        list.add(foundation);
        foundation.func_74861_a(this, list, rand);
        final StructureTFComponentOld roof = rand.nextBoolean() ? new ComponentTFFinalCastleRoof13Conical(this.getFeatureType(), rand, 4, this) : new ComponentTFFinalCastleRoof13Crenellated(this.getFeatureType(), rand, 4, this);
        list.add(roof);
        roof.func_74861_a((StructureComponent)this, (List)list, rand);
    }
    
    public void buildTowards(final StructureComponent parent, final List<StructureComponent> list, final Random rand, final BlockPos dest) {
        this.func_74861_a(parent, list, rand);
        if (this.func_74877_c() < 20) {
            if (this.isWithinRange(dest.func_177958_n(), dest.func_177952_p(), this.field_74887_e.field_78897_a + 6, this.field_74887_e.field_78896_c + 6, 30)) {
                TwilightForestMod.LOGGER.debug("We are within range of our destination, building final tower");
                final int howFar = 20;
                if (!this.buildEndTowerTowards(list, rand, dest, this.findBestDirectionTowards(dest), howFar) && !this.buildEndTowerTowards(list, rand, dest, this.findSecondDirectionTowards(dest), howFar) && !this.buildEndTowerTowards(list, rand, dest, this.findThirdDirectionTowards(dest), howFar)) {
                    TwilightForestMod.LOGGER.info("Could not build final tower");
                }
            }
            else {
                final int howFar = 14 + rand.nextInt(24);
                EnumFacing facing = this.findBestDirectionTowards(dest);
                if (facing == this.func_186165_e() || !this.buildContinueTowerTowards(list, rand, dest, facing, howFar)) {
                    facing = this.findSecondDirectionTowards(dest);
                    if (facing == this.func_186165_e() || !this.buildContinueTowerTowards(list, rand, dest, facing, howFar)) {
                        facing = this.findThirdDirectionTowards(dest);
                        if ((facing == this.func_186165_e() || !this.buildContinueTowerTowards(list, rand, dest, facing, howFar)) && !this.buildContinueTowerTowards(list, rand, dest, this.func_186165_e(), howFar)) {
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
    
    protected void buildNonCriticalTowers(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        EnumFacing dir = RotationUtil.getRandomFacing(rand);
        final Rotation relativeRotation = RotationUtil.getRelativeRotation(this.func_186165_e(), dir);
        if (!this.openingTowards[relativeRotation.ordinal()] && !this.buildDamagedTower(list, rand, dir)) {
            dir = RotationUtil.getRandomFacing(rand);
            if (!this.buildDamagedTower(list, rand, dir)) {}
        }
    }
    
    private EnumFacing findBestDirectionTowards(final BlockPos dest) {
        final int cx = this.field_74887_e.field_78897_a + 6;
        final int cz = this.field_74887_e.field_78896_c + 6;
        final int dx = cx - dest.func_177958_n();
        final int dz = cz - dest.func_177952_p();
        EnumFacing absoluteDir;
        if (Math.abs(dx) > Math.abs(dz)) {
            absoluteDir = ((dx >= 0) ? EnumFacing.EAST : EnumFacing.WEST);
        }
        else {
            absoluteDir = ((dz >= 0) ? EnumFacing.SOUTH : EnumFacing.NORTH);
        }
        TwilightForestMod.LOGGER.debug("Determining best direction!  center is at {}, {} and dest is at {}. offset is {}, {} so the best absolute direction is {}", (Object)cx, (Object)cz, (Object)dest, (Object)dx, (Object)dz, (Object)absoluteDir);
        return absoluteDir;
    }
    
    private EnumFacing findSecondDirectionTowards(final BlockPos dest) {
        final int cx = this.field_74887_e.field_78897_a + 6;
        final int cz = this.field_74887_e.field_78896_c + 6;
        final int dx = cx - dest.func_177958_n();
        final int dz = cz - dest.func_177952_p();
        EnumFacing absoluteDir;
        if (Math.abs(dx) < Math.abs(dz)) {
            absoluteDir = ((dx >= 0) ? EnumFacing.EAST : EnumFacing.WEST);
        }
        else {
            absoluteDir = ((dz >= 0) ? EnumFacing.SOUTH : EnumFacing.NORTH);
        }
        TwilightForestMod.LOGGER.debug("Determining second direction!  center is at {}, {} and dest is at {}. offset is {}, {} so the best absolute direction is {}", (Object)cx, (Object)cz, (Object)dest, (Object)dx, (Object)dz, (Object)absoluteDir);
        return absoluteDir;
    }
    
    private EnumFacing findThirdDirectionTowards(final BlockPos dest) {
        final EnumFacing first = this.findBestDirectionTowards(dest);
        final EnumFacing second = this.findSecondDirectionTowards(dest);
        final EnumFacing[] cardinals = { EnumFacing.NORTH, EnumFacing.SOUTH, EnumFacing.EAST, EnumFacing.WEST };
        TwilightForestMod.LOGGER.debug("Determining third direction!  first is {}, and second is {}", (Object)first, (Object)second);
        for (final EnumFacing f : cardinals) {
            if (f != first && f != second && f != Rotation.CLOCKWISE_180.func_185831_a(this.func_186165_e())) {
                return f;
            }
        }
        return this.func_186165_e();
    }
    
    private boolean buildContinueTowerTowards(final List<StructureComponent> list, final Random rand, final BlockPos dest, final EnumFacing facing, final int howFar) {
        BlockPos opening = this.getValidOpeningCC(rand, facing);
        final int adjustmentRange = 60;
        if (this.isWithinRange(dest.func_177958_n(), dest.func_177952_p(), this.field_74887_e.field_78897_a + 6, this.field_74887_e.field_78896_c + 6, adjustmentRange)) {
            opening = new BlockPos(opening.func_177958_n(), this.adjustOpening(opening.func_177956_o(), dest), opening.func_177952_p());
        }
        TwilightForestMod.LOGGER.debug("original direction is {}", (Object)facing);
        final BlockPos tc = this.offsetTowerCCoords(opening.func_177958_n(), opening.func_177956_o(), opening.func_177952_p(), howFar, facing);
        TwilightForestMod.LOGGER.debug("Our coord mode is {}, and direction is {}, so our door is going to be at {} and the new tower will appear at {}", (Object)this.func_186165_e(), (Object)facing, (Object)opening, (Object)tc);
        final StructureComponent start = list.get(0);
        final int centerX = start.func_74874_b().field_78897_a + 128 >> 8 << 8;
        final int centerZ = start.func_74874_b().field_78896_c + 128 >> 8 << 8;
        TwilightForestMod.LOGGER.debug("Testing range, uncorrected center is at {}, {}", (Object)centerX, (Object)centerZ);
        if (!this.isWithinRange(centerX, centerZ, tc.func_177958_n(), tc.func_177952_p(), 128)) {
            TwilightForestMod.LOGGER.info("tower out of range");
            return false;
        }
        final ComponentTFFinalCastleMazeTower13 sTower = new ComponentTFFinalCastleMazeTower13(this.getFeatureType(), rand, this.func_74877_c() + 1, tc.func_177958_n(), tc.func_177956_o(), tc.func_177952_p(), this.color, facing);
        final StructureBoundingBox structureBoundingBox;
        final StructureBoundingBox largerBB = structureBoundingBox = new StructureBoundingBox(sTower.func_74874_b());
        structureBoundingBox.field_78897_a -= 6;
        final StructureBoundingBox structureBoundingBox2 = largerBB;
        structureBoundingBox2.field_78896_c -= 6;
        final StructureBoundingBox structureBoundingBox3 = largerBB;
        structureBoundingBox3.field_78893_d += 6;
        final StructureBoundingBox structureBoundingBox4 = largerBB;
        structureBoundingBox4.field_78892_f += 6;
        largerBB.field_78895_b = 0;
        largerBB.field_78894_e = 255;
        final StructureComponent intersect = StructureComponent.func_74883_a((List)list, largerBB);
        if (intersect == null) {
            TwilightForestMod.LOGGER.debug("tower success!");
            list.add(sTower);
            sTower.buildTowards(this, list, rand, dest);
            final BlockPos bc = this.offsetTowerCCoords(opening.func_177958_n(), opening.func_177956_o(), opening.func_177952_p(), 1, facing);
            final ComponentTFFinalCastleBridge bridge = new ComponentTFFinalCastleBridge(this.getFeatureType(), this.func_74877_c() + 1, bc.func_177958_n(), bc.func_177956_o(), bc.func_177952_p(), howFar - 7, facing);
            list.add(bridge);
            bridge.func_74861_a(this, list, rand);
            this.addOpening(opening.func_177958_n(), opening.func_177956_o() + 1, opening.func_177952_p(), facing);
            return true;
        }
        TwilightForestMod.LOGGER.info("tower blocked by {}", (Object)intersect);
        return false;
    }
    
    protected boolean buildDamagedTower(final List<StructureComponent> list, final Random rand, final EnumFacing facing) {
        final BlockPos opening = this.getValidOpeningCC(rand, facing);
        final int howFar = 14 + rand.nextInt(24);
        final BlockPos tc = this.offsetTowerCCoords(opening.func_177958_n(), opening.func_177956_o(), opening.func_177952_p(), howFar, facing);
        final ComponentTFFinalCastleMazeTower13 eTower = this.makeNewDamagedTower(rand, facing, tc);
        final StructureBoundingBox structureBoundingBox;
        final StructureBoundingBox largerBB = structureBoundingBox = new StructureBoundingBox(eTower.func_74874_b());
        structureBoundingBox.field_78897_a -= 6;
        final StructureBoundingBox structureBoundingBox2 = largerBB;
        structureBoundingBox2.field_78896_c -= 6;
        final StructureBoundingBox structureBoundingBox3 = largerBB;
        structureBoundingBox3.field_78893_d += 6;
        final StructureBoundingBox structureBoundingBox4 = largerBB;
        structureBoundingBox4.field_78892_f += 6;
        final StructureComponent intersect = StructureComponent.func_74883_a((List)list, largerBB);
        if (intersect == null) {
            list.add(eTower);
            eTower.func_74861_a(this, list, rand);
            final BlockPos bc = this.offsetTowerCCoords(opening.func_177958_n(), opening.func_177956_o(), opening.func_177952_p(), 1, facing);
            final ComponentTFFinalCastleBridge bridge = new ComponentTFFinalCastleBridge(this.getFeatureType(), this.func_74877_c() + 1, bc.func_177958_n(), bc.func_177956_o(), bc.func_177952_p(), howFar - 7, facing);
            list.add(bridge);
            bridge.func_74861_a(this, list, rand);
            this.addOpening(opening.func_177958_n(), opening.func_177956_o() + 1, opening.func_177952_p(), facing);
            return true;
        }
        return false;
    }
    
    protected ComponentTFFinalCastleMazeTower13 makeNewDamagedTower(final Random rand, final EnumFacing facing, final BlockPos tc) {
        return new ComponentTFFinalCastleDamagedTower(this.getFeatureType(), rand, this.func_74877_c() + 1, tc.func_177958_n(), tc.func_177956_o(), tc.func_177952_p(), facing);
    }
    
    private int adjustOpening(final int posY, final BlockPos dest) {
        int openY = posY;
        final int realOpeningY = this.func_74862_a(openY);
        if (realOpeningY - dest.func_177956_o() < 12) {
            openY = this.height - 9;
        }
        else if (dest.func_177956_o() - realOpeningY < 12) {
            openY = 0;
        }
        return openY;
    }
    
    private boolean buildEndTowerTowards(final List<StructureComponent> list, final Random rand, final BlockPos dest, final EnumFacing facing, final int howFar) {
        BlockPos opening = this.getValidOpeningCC(rand, facing);
        opening = new BlockPos(opening.func_177958_n(), this.adjustOpening(opening.func_177956_o(), dest), opening.func_177952_p());
        final BlockPos tc = this.offsetTowerCCoords(opening.func_177958_n(), opening.func_177956_o(), opening.func_177952_p(), howFar, facing);
        ComponentTFFinalCastleMazeTower13 eTower;
        if (this.color == BlockTFCastleMagic.VALID_COLORS.get(0)) {
            eTower = new ComponentTFFinalCastleEntranceTower(this.getFeatureType(), rand, this.func_74877_c() + 1, tc.func_177958_n(), tc.func_177956_o(), tc.func_177952_p(), facing);
        }
        else {
            eTower = new ComponentTFFinalCastleBellTower21(this.getFeatureType(), rand, this.func_74877_c() + 1, tc.func_177958_n(), tc.func_177956_o(), tc.func_177952_p(), facing);
        }
        final StructureBoundingBox structureBoundingBox;
        final StructureBoundingBox largerBB = structureBoundingBox = new StructureBoundingBox(eTower.func_74874_b());
        structureBoundingBox.field_78897_a -= 6;
        final StructureBoundingBox structureBoundingBox2 = largerBB;
        structureBoundingBox2.field_78896_c -= 6;
        final StructureBoundingBox structureBoundingBox3 = largerBB;
        structureBoundingBox3.field_78893_d += 6;
        final StructureBoundingBox structureBoundingBox4 = largerBB;
        structureBoundingBox4.field_78892_f += 6;
        final StructureComponent intersect = StructureComponent.func_74883_a((List)list, largerBB);
        if (intersect == null) {
            list.add(eTower);
            eTower.func_74861_a(this, list, rand);
            final BlockPos bc = this.offsetTowerCCoords(opening.func_177958_n(), opening.func_177956_o(), opening.func_177952_p(), 1, facing);
            final ComponentTFFinalCastleBridge bridge = new ComponentTFFinalCastleBridge(this.getFeatureType(), this.func_74877_c() + 1, bc.func_177958_n(), bc.func_177956_o(), bc.func_177952_p(), howFar - 7, facing);
            list.add(bridge);
            bridge.func_74861_a(this, list, rand);
            this.addOpening(opening.func_177958_n(), opening.func_177956_o() + 1, opening.func_177952_p(), facing);
            return true;
        }
        return false;
    }
    
    private boolean isWithinRange(final int centerX, final int centerZ, final int posX, final int posZ, final int range) {
        final boolean inRange = Math.abs(centerX - posX) < range && Math.abs(centerZ - posZ) < range;
        if (!inRange) {}
        return inRange;
    }
    
    public BlockPos getValidOpeningCC(final Random rand, final EnumFacing facing) {
        final Rotation relative = RotationUtil.getRelativeRotation(this.func_186165_e(), facing);
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
    protected BlockPos offsetTowerCCoords(final int x, final int y, final int z, final int howFar, final EnumFacing direction) {
        int dx = this.func_74865_a(x, z);
        final int dy = this.func_74862_a(y);
        int dz = this.func_74873_b(x, z);
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
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        final Random decoRNG = new Random(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
        this.func_74882_a(world, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1, false, rand, this.deco.randomBlocks);
        for (int x = 0; x < this.size; ++x) {
            for (int z = 0; z < this.size; ++z) {
                this.func_175808_b(world, this.deco.blockState, x, -1, z, sbb);
            }
        }
        for (int numBranches = 2 + decoRNG.nextInt(4) + decoRNG.nextInt(3), i = 0; i < numBranches; ++i) {
            this.makeGlyphBranches(world, decoRNG, this.getGlyphColour(), sbb);
        }
        this.addFloors(world, decoRNG, sbb);
        this.makeOpenings(world, sbb);
        return true;
    }
    
    public EnumDyeColor getGlyphColour() {
        if (this.color == null) {
            TwilightForestMod.LOGGER.warn("Final Castle tower has null for glyph color, this is a bug.");
            return EnumDyeColor.BLUE;
        }
        return this.color;
    }
    
    private void addFloors(final World world, final Random rand, final StructureBoundingBox sbb) {
        final int floors = this.highestOpening / 8 + 1;
        Rotation rotation = Rotation.CLOCKWISE_90;
        for (int i = 1; i < floors; ++i) {
            this.func_175804_a(world, sbb, 1, i * 8, 1, 11, i * 8, 11, this.deco.blockState, this.deco.blockState, false);
            rotation = rotation.func_185830_a(Rotation.CLOCKWISE_180);
            this.addStairsDown(world, sbb, rotation, i * 8);
        }
        if (this.hasAccessibleRoof()) {
            this.addStairsDown(world, sbb, RotationUtil.ROTATIONS[floors + 2 & 0x3], this.height - 1);
        }
    }
    
    protected boolean hasAccessibleRoof() {
        return this.height - this.highestOpening < 9;
    }
    
    private void addStairsDown(final World world, final StructureBoundingBox sbb, final Rotation rotation, final int y) {
        for (int i = 0; i < 4; ++i) {
            final int sx = 8 - i;
            final int sy = y - i;
            final int sz = 9;
            this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.WEST, rotation, false), sx, sy, sz, rotation, sbb);
            this.setBlockStateRotated(world, this.deco.blockState, sx, sy - 1, sz, rotation, sbb);
            this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.WEST, rotation, false), sx, sy, sz - 1, rotation, sbb);
            this.setBlockStateRotated(world, this.deco.blockState, sx, sy - 1, sz - 1, rotation, sbb);
            this.fillAirRotated(world, sbb, sx, sy + 1, sz - 1, sx, sy + 3, sz, rotation);
        }
        this.fillBlocksRotated(world, sbb, 3, y - 4, 8, 4, y - 4, 9, this.deco.blockState, rotation);
        for (int i = 0; i < 4; ++i) {
            final int sx = 4;
            final int sy = y - i - 4;
            final int sz = 7 - i;
            this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.NORTH, rotation, false), sx, sy, sz, rotation, sbb);
            this.setBlockStateRotated(world, this.deco.blockState, sx, sy - 1, sz, rotation, sbb);
            this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.NORTH, rotation, false), sx - 1, sy, sz, rotation, sbb);
            this.setBlockStateRotated(world, this.deco.blockState, sx - 1, sy - 1, sz, rotation, sbb);
            this.fillAirRotated(world, sbb, sx, sy + 1, sz, sx - 1, sy + 3, sz, rotation);
        }
    }
    
    @Override
    protected void makeDoorOpening(final World world, final int dx, final int dy, final int dz, final StructureBoundingBox sbb) {
        final IBlockState doorState = TFBlocks.castle_door.func_176223_P().func_177226_a((IProperty)BlockTFCastleDoor.LOCK_INDEX, (Comparable)(this.getGlyphColour().func_176765_a() % 4));
        if (dx == 0 || dx == this.size - 1) {
            this.func_175804_a(world, sbb, dx, dy - 1, dz - 2, dx, dy + 4, dz + 2, this.deco.accentState, ComponentTFFinalCastleMazeTower13.AIR, false);
            this.func_175804_a(world, sbb, dx, dy, dz - 1, dx, dy + 3, dz + 1, doorState, ComponentTFFinalCastleMazeTower13.AIR, false);
        }
        if (dz == 0 || dz == this.size - 1) {
            this.func_175804_a(world, sbb, dx - 2, dy - 1, dz, dx + 2, dy + 4, dz, this.deco.accentState, ComponentTFFinalCastleMazeTower13.AIR, false);
            this.func_175804_a(world, sbb, dx - 1, dy, dz, dx + 1, dy + 3, dz, doorState, ComponentTFFinalCastleMazeTower13.AIR, false);
        }
    }
}
