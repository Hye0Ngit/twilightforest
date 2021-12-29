// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.mushroomtower;

import net.minecraft.world.IBlockReader;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import twilightforest.structures.lichtower.TowerRoofComponent;
import java.util.Iterator;
import net.minecraft.util.math.MutableBoundingBox;
import twilightforest.util.RotationUtil;
import twilightforest.TwilightForestMod;
import net.minecraft.util.Rotation;
import twilightforest.structures.TFStructureComponentOld;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.util.Direction;
import twilightforest.TFFeature;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;
import twilightforest.structures.lichtower.TowerWingComponent;

public class MushroomTowerWingComponent extends TowerWingComponent
{
    private static final int RANGE = 200;
    protected static final int FLOOR_HEIGHT = 4;
    protected static final int MAIN_SIZE = 15;
    boolean hasBase;
    public boolean isAscender;
    
    public MushroomTowerWingComponent(final TemplateManager manager, final CompoundNBT nbt) {
        this(MushroomTowerPieces.TFMTWin, nbt);
    }
    
    public MushroomTowerWingComponent(final IStructurePieceType piece, final CompoundNBT nbt) {
        super(piece, nbt);
        this.hasBase = false;
        this.isAscender = false;
        this.hasBase = nbt.func_74767_n("hasBase");
        this.isAscender = nbt.func_74767_n("isAscender");
    }
    
    protected MushroomTowerWingComponent(final IStructurePieceType piece, final TFFeature feature, final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final Direction direction) {
        super(piece, feature, i, x, y, z, pSize, pHeight, direction);
        this.hasBase = false;
        this.isAscender = false;
    }
    
    @Override
    protected void func_143011_b(final CompoundNBT tagCompound) {
        super.func_143011_b(tagCompound);
        tagCompound.func_74757_a("hasBase", this.hasBase);
        tagCompound.func_74757_a("isAscender", this.isAscender);
    }
    
    @Override
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
        this.addOpening(0, 1, this.size / 2, Rotation.CLOCKWISE_180);
        this.hasBase = (this.size > 3);
        if (this.isAscender) {
            final int[] dest = this.getValidOpening(rand, Rotation.CLOCKWISE_180);
            dest[1] = this.height - 3;
            final int childHeight = (rand.nextInt(3) + rand.nextInt(3) + 2) * 4 + 1;
            final boolean madeIt = this.makeMainBridge(list, rand, this.func_74877_c() + 1, dest[0], dest[1], dest[2], childHeight, Rotation.CLOCKWISE_180);
            if (!madeIt) {
                TwilightForestMod.LOGGER.info("Did not make bridge back to new main");
            }
            else {
                TwilightForestMod.LOGGER.debug("Made bridge back to new main");
            }
        }
        if (this.func_74877_c() < 5 && this.size > 6) {
            for (final Rotation i : RotationUtil.ROTATIONS) {
                if (this.size >= 15 || i != Rotation.CLOCKWISE_180) {
                    final int[] dest2 = this.getValidOpening(rand, i);
                    final int childHeight2 = (rand.nextInt(2) + rand.nextInt(2) + 2) * 4 + 1;
                    this.makeBridge(list, rand, this.func_74877_c() + 1, dest2[0], dest2[1], dest2[2], this.size - 4, childHeight2, i);
                }
            }
        }
        if (this.isHighest(this.field_74887_e, this.size, list) || !this.hasBase) {
            this.makeARoof(parent, list, rand);
        }
    }
    
    private boolean isOutOfRange(final StructurePiece parent, final int nx, final int nz, final int range) {
        final MutableBoundingBox sbb = parent.func_74874_b();
        final int centerX = sbb.field_78897_a + (sbb.field_78893_d - sbb.field_78897_a + 1) / 2;
        final int centerZ = sbb.field_78896_c + (sbb.field_78892_f - sbb.field_78896_c + 1) / 2;
        return Math.abs(nx - centerX) > range || Math.abs(nz - centerZ) > range;
    }
    
    @Override
    public boolean makeTowerWing(final List<StructurePiece> list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final Rotation rotation) {
        final Direction direction = this.getStructureRelativeRotation(rotation);
        int[] dx = this.offsetTowerCoords(x, y, z, wingSize, direction);
        if (this.isOutOfRange(list.get(0), dx[0], dx[2], 200)) {
            return false;
        }
        if (wingSize > 3) {
            dx = this.adjustCoordinates(dx[0], dx[1], dx[2], wingSize, direction, list);
        }
        final MushroomTowerWingComponent wing = new MushroomTowerWingComponent(MushroomTowerPieces.TFMTWin, this.getFeatureType(), index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        final StructurePiece intersect = StructurePiece.func_74883_a((List)list, wing.func_74874_b());
        if (intersect == null || intersect == this || intersect instanceof TowerRoofMushroomComponent) {
            if (this instanceof MushroomTowerBridgeComponent && this.isAscender) {
                wing.isAscender = true;
            }
            list.add(wing);
            wing.func_74861_a(list.get(0), list, rand);
            this.addOpening(x, y, z, rotation);
            return true;
        }
        return false;
    }
    
    protected int[] adjustCoordinates(final int x, final int y, final int z, final int wingSize, final Direction direction, final List<StructurePiece> list) {
        for (final Object obj : list) {
            if (obj instanceof TowerWingComponent && !(obj instanceof MushroomTowerBridgeComponent)) {
                final TowerWingComponent otherWing = (TowerWingComponent)obj;
                if (wingSize != otherWing.size || !otherWing.func_74874_b().func_78885_a(x - 3, z - 3, x + 3, z + 3)) {
                    continue;
                }
                switch (direction) {
                    case SOUTH: {
                        return new int[] { otherWing.func_74874_b().field_78897_a, y, otherWing.func_74874_b().field_78896_c };
                    }
                    case WEST: {
                        return new int[] { otherWing.func_74874_b().field_78893_d, y, otherWing.func_74874_b().field_78896_c };
                    }
                    case NORTH: {
                        return new int[] { otherWing.func_74874_b().field_78893_d, y, otherWing.func_74874_b().field_78892_f };
                    }
                    case EAST: {
                        return new int[] { otherWing.func_74874_b().field_78897_a, y, otherWing.func_74874_b().field_78892_f };
                    }
                    default: {
                        return new int[] { x, y, z };
                    }
                }
            }
        }
        return new int[] { x, y, z };
    }
    
    private boolean isHighest(final MutableBoundingBox boundingBox, final int size, final List<StructurePiece> list) {
        final MutableBoundingBox boxAbove = new MutableBoundingBox(boundingBox);
        boxAbove.field_78894_e = 256;
        for (final Object obj : list) {
            if (this != obj && obj instanceof TowerWingComponent && !(obj instanceof MushroomTowerBridgeComponent)) {
                final TowerWingComponent otherWing = (TowerWingComponent)obj;
                if (size == otherWing.size && otherWing.func_74874_b().func_78884_a(boxAbove)) {
                    return false;
                }
                continue;
            }
        }
        return true;
    }
    
    @Override
    public void makeARoof(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
        TowerRoofComponent roof = new TowerRoofMushroomComponent(this.getFeatureType(), this.func_74877_c() + 1, this, 1.6f);
        if (!(StructurePiece.func_74883_a((List)list, roof.func_74874_b()) instanceof TowerRoofMushroomComponent)) {
            roof = new TowerRoofMushroomComponent(this.getFeatureType(), this.func_74877_c() + 1, this, 1.0f);
            if (!(StructurePiece.func_74883_a((List)list, roof.func_74874_b()) instanceof TowerRoofMushroomComponent)) {
                roof = new TowerRoofMushroomComponent(this.getFeatureType(), this.func_74877_c() + 1, this, 0.6f);
            }
        }
        list.add(roof);
        roof.func_74861_a((StructurePiece)this, (List)list, rand);
    }
    
    @Override
    protected boolean makeBridge(final List<StructurePiece> list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final Rotation rotation) {
        return this.makeBridge(list, rand, index, x, y, z, wingSize, wingHeight, rotation, false);
    }
    
    protected boolean makeBridge(final List<StructurePiece> list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, int wingHeight, final Rotation rotation, final boolean ascender) {
        final Direction direction = this.getStructureRelativeRotation(rotation);
        final int[] dx = this.offsetTowerCoords(x, y, z, 3, direction);
        if (wingSize == 3) {
            wingHeight = 4;
        }
        final MushroomTowerBridgeComponent bridge = new MushroomTowerBridgeComponent(MushroomTowerPieces.TFMTBri, this.getFeatureType(), index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        bridge.isAscender = ascender;
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
    
    private boolean makeMainBridge(final List<StructurePiece> list, final Random rand, final int index, final int x, final int y, final int z, final int wingHeight, final Rotation rotation) {
        final Direction direction = this.getStructureRelativeRotation(rotation);
        final int[] dx = this.offsetTowerCoords(x, y, z, 3, direction);
        final MushroomTowerMainBridgeComponent bridge = new MushroomTowerMainBridgeComponent(this.getFeatureType(), index, dx[0], dx[1], dx[2], wingHeight, direction);
        list.add(bridge);
        bridge.func_74861_a(this, list, rand);
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
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.makeTrunk(world, sbb);
        this.makeFloorsForTower(world, sbb);
        this.makeOpenings(world, sbb);
        return true;
    }
    
    private void makeTrunk(final ISeedReader world, final MutableBoundingBox sbb) {
        final int diameter = this.size / 2;
        final int hollow = (int)(diameter * 0.8);
        for (int dx = -diameter; dx <= diameter; ++dx) {
            for (int dz = -diameter; dz <= diameter; ++dz) {
                final int ax = Math.abs(dx);
                final int az = Math.abs(dz);
                final int dist = (int)(Math.max(ax, az) + Math.min(ax, az) * 0.4);
                if (dist <= diameter) {
                    this.func_175811_a(world, this.deco.floorState, dx + diameter, 0, dz + diameter, sbb);
                    this.func_175811_a(world, this.deco.floorState, dx + diameter, this.height, dz + diameter, sbb);
                    if (dist > hollow) {
                        for (int dy = 0; dy <= this.height; ++dy) {
                            this.func_175811_a(world, this.deco.blockState, dx + diameter, dy, dz + diameter, sbb);
                        }
                    }
                    else {
                        for (int dy = 1; dy <= this.height - 1; ++dy) {
                            this.func_175811_a(world, MushroomTowerWingComponent.AIR, dx + diameter, dy, dz + diameter, sbb);
                        }
                    }
                    if (this.hasBase) {
                        this.func_175808_b(world, this.deco.blockState, dx + diameter, -1, dz + diameter, sbb);
                    }
                }
            }
        }
    }
    
    private void makeFloorsForTower(final ISeedReader world, final MutableBoundingBox sbb) {
        for (int floors = this.height / 4, i = 0; i < floors; ++i) {
            this.placeFloor(world, i * 4, sbb);
        }
    }
    
    private void placeFloor(final ISeedReader world, final int dy, final MutableBoundingBox sbb) {
        final int diameter = this.size / 2;
        final int hollow = (int)(diameter * 0.8);
        for (int dx = -diameter; dx <= diameter; ++dx) {
            for (int dz = -diameter; dz <= diameter; ++dz) {
                final int ax = Math.abs(dx);
                final int az = Math.abs(dz);
                final int dist = (int)(Math.max(ax, az) + Math.min(ax, az) * 0.4);
                if (dist <= hollow) {
                    this.func_175811_a(world, this.isAscender ? Blocks.field_196668_q.func_176223_P() : this.deco.floorState, dx + diameter, dy, dz + diameter, sbb);
                }
            }
        }
    }
    
    @Override
    protected void makeDoorOpening(final ISeedReader world, final int dx, final int dy, final int dz, final MutableBoundingBox sbb) {
        super.makeDoorOpening(world, dx, dy, dz, sbb);
        if (this.func_175807_a((IBlockReader)world, dx, dy + 2, dz, sbb).func_177230_c() != Blocks.field_150350_a) {
            this.func_175811_a(world, this.deco.accentState, dx, dy + 2, dz, sbb);
        }
    }
    
    @Override
    protected void decorateFloor(final ISeedReader world, final Random rand, final int floor, final int bottom, final int top, final Rotation ladderUpDir, final Rotation ladderDownDir, final MutableBoundingBox sbb) {
    }
}
