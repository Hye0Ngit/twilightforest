// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import twilightforest.TFConfig;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.Rotation;
import java.util.Random;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.template.TemplateManager;
import java.util.Iterator;
import java.nio.IntBuffer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;
import java.util.ArrayList;
import net.minecraft.util.math.BlockPos;
import java.util.List;
import twilightforest.structures.StructureTFComponentOld;

public abstract class StructureTFStrongholdComponent extends StructureTFComponentOld
{
    public List<BlockPos> doors;
    
    public StructureTFStrongholdComponent() {
        this.doors = new ArrayList<BlockPos>();
    }
    
    public StructureTFStrongholdComponent(final TFFeature feature, final int i, final EnumFacing facing, final int x, final int y, final int z) {
        super(feature, i);
        this.doors = new ArrayList<BlockPos>();
        this.field_74887_e = this.generateBoundingBox(facing, x, y, z);
        this.func_186164_a(facing);
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound tagCompound) {
        super.func_143012_a(tagCompound);
        tagCompound.func_74783_a("doorInts", this.getDoorsAsIntArray());
    }
    
    private int[] getDoorsAsIntArray() {
        final IntBuffer ibuffer = IntBuffer.allocate(this.doors.size() * 3);
        for (final BlockPos door : this.doors) {
            ibuffer.put(door.func_177958_n());
            ibuffer.put(door.func_177956_o());
            ibuffer.put(door.func_177952_p());
        }
        return ibuffer.array();
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound tagCompound, final TemplateManager templateManager) {
        super.func_143011_b(tagCompound, templateManager);
        this.readOpeningsFromArray(tagCompound.func_74759_k("doorInts"));
    }
    
    private void readOpeningsFromArray(final int[] intArray) {
        for (int i = 0; i < intArray.length; i += 3) {
            final BlockPos door = new BlockPos(intArray[i], intArray[i + 1], intArray[i + 2]);
            this.doors.add(door);
        }
    }
    
    public abstract StructureBoundingBox generateBoundingBox(final EnumFacing p0, final int p1, final int p2, final int p3);
    
    public static StructureBoundingBox getComponentToAddBoundingBox(final int x, final int y, final int z, final int xOff, final int yOff, final int zOff, final int xSize, final int ySize, final int zSize, final EnumFacing facing) {
        switch (facing) {
            case SOUTH: {
                return new StructureBoundingBox(x + xOff, y + yOff, z + zOff, x + xSize - 1 + xOff, y + ySize - 1 + yOff, z + zSize - 1 + zOff);
            }
            case WEST: {
                return new StructureBoundingBox(x - zSize + 1 + zOff, y + yOff, z + xOff, x + zOff, y + ySize - 1 + yOff, z + xSize - 1 + xOff);
            }
            case NORTH: {
                return new StructureBoundingBox(x - xSize + 1 - xOff, y + yOff, z - zSize + 1 + zOff, x - xOff, y + ySize - 1 + yOff, z + zOff);
            }
            case EAST: {
                return new StructureBoundingBox(x + zOff, y + yOff, z - xSize + 1 - xOff, x + zSize - 1 + zOff, y + ySize - 1 + yOff, z - xOff);
            }
            default: {
                return new StructureBoundingBox(x + xOff, y + yOff, z + zOff, x + xSize - 1 + xOff, y + ySize - 1 + yOff, z + zSize - 1 + zOff);
            }
        }
    }
    
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponentOld) {
            this.deco = ((StructureTFComponentOld)parent).deco;
        }
    }
    
    protected void addNewComponent(final StructureComponent entrance, final List<StructureComponent> list, final Random random, final Rotation facing, final int x, final int y, final int z) {
        final int index = this.field_74886_g + 1;
        final EnumFacing nFacing = this.getStructureRelativeRotation(facing);
        final int nx = this.func_74865_a(x, z);
        final int ny = this.func_74862_a(y);
        final int nz = this.func_74873_b(x, z);
        if (index > 50 || this.isOutOfRange(entrance, nx, ny, nz, 112)) {
            return;
        }
        final StructureTFStrongholdComponent breakIn = (StructureTFStrongholdComponent)this.findBreakInComponent(list, nx, ny, nz);
        if (breakIn != null && breakIn.attemptToBreakIn(nx, ny, nz)) {
            this.addDoorwayTo(x, y, z, facing);
            return;
        }
        final TFStrongholdPieces pieceList = ((ComponentTFStrongholdEntrance)entrance).lowerPieces;
        final StructureComponent nextComponent = pieceList.getNextComponent(entrance, list, random, this.getFeatureType(), index, nFacing, nx, ny, nz);
        if (nextComponent != null) {
            list.add(nextComponent);
            nextComponent.func_74861_a(entrance, (List)list, random);
            this.addDoorwayTo(x, y, z, facing);
        }
    }
    
    protected StructureComponent findBreakInComponent(final List<StructureComponent> list, final int x, final int y, final int z) {
        final BlockPos pos = new BlockPos(x, y, z);
        for (final StructureComponent component : list) {
            if (component.func_74874_b() != null && component.func_74874_b().func_175898_b((Vec3i)pos)) {
                return component;
            }
        }
        return null;
    }
    
    protected void addNewUpperComponent(final StructureComponent parent, final List<StructureComponent> list, final Random random, final Rotation facing, final int x, final int y, final int z) {
        StructureTFStrongholdComponent attempted = null;
        final int index = this.field_74886_g + 1;
        final EnumFacing nFacing = this.getStructureRelativeRotation(facing);
        final int nx = this.func_74865_a(x, z);
        final int ny = this.func_74862_a(y);
        final int nz = this.func_74873_b(x, z);
        if (index > 100 || this.isOutOfRange(parent, nx, ny, nz, 48)) {
            return;
        }
        switch (random.nextInt(5)) {
            default: {
                attempted = new ComponentTFStrongholdUpperTIntersection(this.getFeatureType(), index, nFacing, nx, ny, nz);
                break;
            }
            case 1: {
                attempted = new ComponentTFStrongholdUpperLeftTurn(this.getFeatureType(), index, nFacing, nx, ny, nz);
                break;
            }
            case 2: {
                attempted = new ComponentTFStrongholdUpperRightTurn(this.getFeatureType(), index, nFacing, nx, ny, nz);
                break;
            }
            case 3: {
                attempted = new ComponentTFStrongholdUpperCorridor(this.getFeatureType(), index, nFacing, nx, ny, nz);
                break;
            }
            case 4: {
                attempted = new ComponentTFStrongholdUpperAscender(this.getFeatureType(), index, nFacing, nx, ny, nz);
                break;
            }
        }
        if (attempted != null && StructureComponent.func_74883_a((List)list, attempted.func_74874_b()) == null) {
            list.add(attempted);
            attempted.func_74861_a(parent, list, random);
        }
    }
    
    private boolean isOutOfRange(final StructureComponent parent, final int nx, final int ny, final int nz, final int range) {
        return Math.abs(nx - parent.func_74874_b().field_78897_a) > range || Math.abs(nz - parent.func_74874_b().field_78896_c) > range;
    }
    
    protected void placeDoorwayAt(final World world, final Random rand, final int x, final int y, final int z, final StructureBoundingBox sbb) {
        if (x == 0 || x == this.getXSize()) {
            this.func_175804_a(world, sbb, x, y, z - 2, x, y + 3, z + 2, this.deco.fenceState, Blocks.field_150350_a.func_176223_P(), false);
            this.func_74878_a(world, sbb, x, y, z - 1, x, y + 3, z + 1);
        }
        else {
            this.func_175804_a(world, sbb, x - 2, y, z, x + 2, y + 3, z, this.deco.fenceState, Blocks.field_150350_a.func_176223_P(), false);
            this.func_74878_a(world, sbb, x - 1, y, z, x + 1, y + 3, z);
        }
    }
    
    protected int getXSize() {
        switch (this.func_186165_e()) {
            default: {
                return this.field_74887_e.func_78883_b() - 1;
            }
            case WEST:
            case EAST: {
                return this.field_74887_e.func_78880_d() - 1;
            }
        }
    }
    
    protected void placeSmallDoorwayAt(final World world, final Random rand, final int facing, final int x, final int y, final int z, final StructureBoundingBox sbb) {
        if (facing == 0 || facing == 2) {
            this.func_175804_a(world, sbb, x - 1, y, z, x + 1, y + 1, z, Blocks.field_150463_bK.func_176223_P(), Blocks.field_150350_a.func_176223_P(), true);
            this.func_74878_a(world, sbb, x, y, z, x, y + 1, z);
        }
        else {
            this.func_175804_a(world, sbb, x, y, z - 1, x, y + 1, z + 1, Blocks.field_150463_bK.func_176223_P(), Blocks.field_150350_a.func_176223_P(), true);
            this.func_74878_a(world, sbb, x, y, z, x, y + 1, z);
        }
    }
    
    public void placeCornerStatue(final World world, final int x, final int y, final int z, final int facing, final StructureBoundingBox sbb) {
        int ox = 1;
        int oz = 1;
        EnumFacing smx = EnumFacing.EAST;
        EnumFacing smz = EnumFacing.SOUTH;
        switch (facing) {
            case 1: {
                oz = -1;
                smz = EnumFacing.SOUTH;
                break;
            }
            case 2: {
                ox = -1;
                smx = EnumFacing.WEST;
                break;
            }
            case 3: {
                ox = -1;
                oz = -1;
                smx = EnumFacing.WEST;
                smz = EnumFacing.NORTH;
                break;
            }
        }
        for (int sy = 0; sy < 5; ++sy) {
            this.func_175811_a(world, this.deco.pillarState, x, y + sy, z, sbb);
        }
        this.func_175811_a(world, Blocks.field_180407_aO.func_176223_P(), x + 0, y + 4, z + oz, sbb);
        this.func_175811_a(world, Blocks.field_180407_aO.func_176223_P(), x + ox, y + 4, z + 0, sbb);
        this.func_175811_a(world, StructureTFComponentOld.getStairState(this.deco.stairState, smz, this.field_186169_c, false), x + 0, y + 3, z + oz, sbb);
        this.func_175811_a(world, StructureTFComponentOld.getStairState(this.deco.stairState, smx, this.field_186169_c, false), x + ox, y + 3, z + 0, sbb);
        this.func_175811_a(world, StructureTFComponentOld.getStairState(this.deco.stairState, smz, this.field_186169_c, true), x + 0, y + 2, z + oz, sbb);
        this.func_175811_a(world, StructureTFComponentOld.getStairState(this.deco.stairState, smx, this.field_186169_c, true), x + ox, y + 2, z + 0, sbb);
        this.func_175811_a(world, StructureTFComponentOld.getStairState(this.deco.stairState, smx, this.field_186169_c, true), x + ox, y + 2, z + oz, sbb);
        this.func_175811_a(world, Blocks.field_150463_bK.func_176223_P(), x + ox, y + 0, z + oz, sbb);
        this.func_175811_a(world, Blocks.field_150463_bK.func_176223_P(), x + ox, y + 1, z + oz, sbb);
        this.func_175811_a(world, StructureTFComponentOld.getStairState(this.deco.stairState, smz, this.field_186169_c, false), x + 0, y + 0, z + oz, sbb);
        this.func_175811_a(world, StructureTFComponentOld.getStairState(this.deco.stairState, smx, this.field_186169_c, false), x + ox, y + 0, z + 0, sbb);
    }
    
    public void placeWallStatue(final World world, final int x, final int y, final int z, final Rotation facing, final StructureBoundingBox sbb) {
        int ox = 1;
        int oz = 1;
        for (int sy = 0; sy < 5; ++sy) {
            this.func_175811_a(world, this.deco.pillarState, x, y + sy, z, sbb);
        }
        if (facing == Rotation.NONE || facing == Rotation.CLOCKWISE_180) {
            if (facing == Rotation.CLOCKWISE_180) {
                ox = -ox;
                oz = -oz;
            }
            this.func_175811_a(world, Blocks.field_180407_aO.func_176223_P(), x - ox, y + 4, z, sbb);
            this.func_175811_a(world, Blocks.field_180407_aO.func_176223_P(), x + ox, y + 4, z, sbb);
            this.func_175811_a(world, StructureTFComponentOld.getStairState(this.deco.stairState, facing.func_185830_a(Rotation.NONE).func_185831_a(EnumFacing.WEST), this.field_186169_c, false), x - ox, y + 3, z, sbb);
            this.func_175811_a(world, StructureTFComponentOld.getStairState(this.deco.stairState, facing.func_185830_a(Rotation.CLOCKWISE_180).func_185831_a(EnumFacing.WEST), this.field_186169_c, false), x + ox, y + 3, z, sbb);
            this.func_175811_a(world, StructureTFComponentOld.getStairState(this.deco.stairState, facing.func_185830_a(Rotation.CLOCKWISE_90).func_185831_a(EnumFacing.WEST), this.field_186169_c, false), x - ox, y + 3, z - oz, sbb);
            this.func_175811_a(world, StructureTFComponentOld.getStairState(this.deco.stairState, facing.func_185830_a(Rotation.CLOCKWISE_90).func_185831_a(EnumFacing.WEST), this.field_186169_c, false), x + ox, y + 3, z - oz, sbb);
            this.func_175811_a(world, StructureTFComponentOld.getStairState(this.deco.stairState, facing.func_185830_a(Rotation.NONE).func_185831_a(EnumFacing.WEST), this.field_186169_c, true), x - ox, y + 2, z, sbb);
            this.func_175811_a(world, StructureTFComponentOld.getStairState(this.deco.stairState, facing.func_185830_a(Rotation.CLOCKWISE_180).func_185831_a(EnumFacing.WEST), this.field_186169_c, true), x + ox, y + 2, z, sbb);
            this.func_175811_a(world, StructureTFComponentOld.getStairState(this.deco.stairState, facing.func_185830_a(Rotation.CLOCKWISE_90).func_185831_a(EnumFacing.WEST), this.field_186169_c, true), x + 0, y + 2, z - oz, sbb);
            this.func_175811_a(world, StructureTFComponentOld.getStairState(this.deco.stairState, facing.func_185830_a(Rotation.CLOCKWISE_90).func_185831_a(EnumFacing.WEST), this.field_186169_c, true), x - ox, y + 2, z - oz, sbb);
            this.func_175811_a(world, StructureTFComponentOld.getStairState(this.deco.stairState, facing.func_185830_a(Rotation.CLOCKWISE_90).func_185831_a(EnumFacing.WEST), this.field_186169_c, true), x + ox, y + 2, z - oz, sbb);
            this.func_175811_a(world, Blocks.field_150463_bK.func_176223_P(), x, y + 0, z - oz, sbb);
            this.func_175811_a(world, Blocks.field_150463_bK.func_176223_P(), x, y + 1, z - oz, sbb);
            this.func_175811_a(world, StructureTFComponentOld.getStairState(this.deco.stairState, facing.func_185830_a(Rotation.NONE).func_185831_a(EnumFacing.WEST), this.field_186169_c, false), x - ox, y + 0, z + 0, sbb);
            this.func_175811_a(world, StructureTFComponentOld.getStairState(this.deco.stairState, facing.func_185830_a(Rotation.CLOCKWISE_180).func_185831_a(EnumFacing.WEST), this.field_186169_c, false), x + ox, y + 0, z + 0, sbb);
        }
        else {
            if (facing == Rotation.COUNTERCLOCKWISE_90) {
                oz = -oz;
                ox = -ox;
            }
            this.func_175811_a(world, Blocks.field_180407_aO.func_176223_P(), x, y + 4, z - oz, sbb);
            this.func_175811_a(world, Blocks.field_180407_aO.func_176223_P(), x, y + 4, z + oz, sbb);
            this.func_175811_a(world, StructureTFComponentOld.getStairState(this.deco.stairState, facing.func_185830_a(Rotation.NONE).func_185831_a(EnumFacing.WEST), this.field_186169_c, false), x, y + 3, z - oz, sbb);
            this.func_175811_a(world, StructureTFComponentOld.getStairState(this.deco.stairState, facing.func_185830_a(Rotation.CLOCKWISE_180).func_185831_a(EnumFacing.WEST), this.field_186169_c, false), x, y + 3, z + oz, sbb);
            this.func_175811_a(world, StructureTFComponentOld.getStairState(this.deco.stairState, facing.func_185830_a(Rotation.CLOCKWISE_90).func_185831_a(EnumFacing.WEST), this.field_186169_c, false), x + ox, y + 3, z - oz, sbb);
            this.func_175811_a(world, StructureTFComponentOld.getStairState(this.deco.stairState, facing.func_185830_a(Rotation.CLOCKWISE_90).func_185831_a(EnumFacing.WEST), this.field_186169_c, false), x + ox, y + 3, z + oz, sbb);
            this.func_175811_a(world, StructureTFComponentOld.getStairState(this.deco.stairState, facing.func_185830_a(Rotation.NONE).func_185831_a(EnumFacing.WEST), this.field_186169_c, true), x, y + 2, z - oz, sbb);
            this.func_175811_a(world, StructureTFComponentOld.getStairState(this.deco.stairState, facing.func_185830_a(Rotation.CLOCKWISE_180).func_185831_a(EnumFacing.WEST), this.field_186169_c, true), x, y + 2, z + oz, sbb);
            this.func_175811_a(world, StructureTFComponentOld.getStairState(this.deco.stairState, facing.func_185830_a(Rotation.CLOCKWISE_90).func_185831_a(EnumFacing.WEST), this.field_186169_c, true), x + oz, y + 2, z + 0, sbb);
            this.func_175811_a(world, StructureTFComponentOld.getStairState(this.deco.stairState, facing.func_185830_a(Rotation.CLOCKWISE_90).func_185831_a(EnumFacing.WEST), this.field_186169_c, true), x + ox, y + 2, z - oz, sbb);
            this.func_175811_a(world, StructureTFComponentOld.getStairState(this.deco.stairState, facing.func_185830_a(Rotation.CLOCKWISE_90).func_185831_a(EnumFacing.WEST), this.field_186169_c, true), x + ox, y + 2, z + oz, sbb);
            this.func_175811_a(world, Blocks.field_150463_bK.func_176223_P(), x + ox, y + 0, z, sbb);
            this.func_175811_a(world, Blocks.field_150463_bK.func_176223_P(), x + ox, y + 1, z, sbb);
            this.func_175811_a(world, StructureTFComponentOld.getStairState(this.deco.stairState, facing.func_185830_a(Rotation.NONE).func_185831_a(EnumFacing.WEST), this.field_186169_c, false), x, y + 0, z - ox, sbb);
            this.func_175811_a(world, StructureTFComponentOld.getStairState(this.deco.stairState, facing.func_185830_a(Rotation.CLOCKWISE_180).func_185831_a(EnumFacing.WEST), this.field_186169_c, false), x, y + 0, z + ox, sbb);
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
        if (wy < this.field_74887_e.field_78895_b || wy > this.field_74887_e.field_78894_e) {
            return false;
        }
        if (wx == this.field_74887_e.field_78897_a || wx == this.field_74887_e.field_78893_d) {
            return wz > this.field_74887_e.field_78896_c && wz < this.field_74887_e.field_78892_f;
        }
        return (wz == this.field_74887_e.field_78896_c || wz == this.field_74887_e.field_78892_f) && wx > this.field_74887_e.field_78897_a && wx < this.field_74887_e.field_78893_d;
    }
    
    protected int getRelativeX(final int x, final int z) {
        switch (this.func_186165_e()) {
            case SOUTH: {
                return x - this.field_74887_e.field_78897_a;
            }
            case NORTH: {
                return this.field_74887_e.field_78893_d - x;
            }
            case WEST: {
                return z - this.field_74887_e.field_78896_c;
            }
            case EAST: {
                return this.field_74887_e.field_78892_f - z;
            }
            default: {
                return x;
            }
        }
    }
    
    protected int getRelativeY(final int y) {
        return y - this.field_74887_e.field_78895_b;
    }
    
    protected int getRelativeZ(final int x, final int z) {
        switch (this.func_186165_e()) {
            case SOUTH: {
                return z - this.field_74887_e.field_78896_c;
            }
            case NORTH: {
                return this.field_74887_e.field_78892_f - z;
            }
            case WEST: {
                return this.field_74887_e.field_78893_d - x;
            }
            case EAST: {
                return x - this.field_74887_e.field_78897_a;
            }
            default: {
                return z;
            }
        }
    }
    
    public void placeDoors(final World world, final Random rand, final StructureBoundingBox sbb) {
        if (this.doors != null) {
            for (final BlockPos doorCoords : this.doors) {
                this.placeDoorwayAt(world, rand, doorCoords.func_177958_n(), doorCoords.func_177956_o(), doorCoords.func_177952_p(), sbb);
            }
        }
    }
    
    protected void placeStrongholdWalls(final World world, final StructureBoundingBox sbb, final int sx, final int sy, final int sz, final int dx, final int dy, final int dz, final Random rand, final StructureComponent.BlockSelector randomBlocks) {
        for (int y = sy; y <= dy; ++y) {
            for (int x = sx; x <= dx; ++x) {
                for (int z = sz; z <= dz; ++z) {
                    final boolean wall = y == sy || y == dy || x == sx || x == dx || z == sz || z == dz;
                    final Block blockID = this.func_175807_a(world, x, y, z, sbb).func_177230_c();
                    if (blockID == Blocks.field_150350_a && !TFConfig.dimension.skylightForest) {
                        if (wall) {
                            this.func_175811_a(world, Blocks.field_150347_e.func_176223_P(), x, y, z, sbb);
                        }
                    }
                    else if (y == sy || y == dy) {
                        final StructureComponent.BlockSelector strongBlocks = StructureTFComponentOld.getStrongholdStones();
                        strongBlocks.func_75062_a(rand, x, y, z, wall);
                        this.func_175811_a(world, strongBlocks.func_180780_a(), x, y, z, sbb);
                    }
                    else if (!wall || blockID != Blocks.field_150346_d) {
                        randomBlocks.func_75062_a(rand, x, y, z, wall);
                        this.func_175811_a(world, randomBlocks.func_180780_a(), x, y, z, sbb);
                    }
                }
            }
        }
    }
    
    protected void placeUpperStrongholdWalls(final World world, final StructureBoundingBox sbb, final int sx, final int sy, final int sz, final int dx, final int dy, final int dz, final Random rand, final StructureComponent.BlockSelector randomBlocks) {
        for (int y = sy; y <= dy; ++y) {
            for (int x = sx; x <= dx; ++x) {
                for (int z = sz; z <= dz; ++z) {
                    final boolean wall = y == sy || y == dy || x == sx || x == dx || z == sz || z == dz;
                    final IBlockState state = this.func_175807_a(world, x, y, z, sbb);
                    final Block blockID = state.func_177230_c();
                    if ((blockID != Blocks.field_150350_a && (state.func_185904_a() == Material.field_151576_e || state.func_185904_a() == Material.field_151577_b || state.func_185904_a() == Material.field_151578_c)) || (blockID == Blocks.field_150350_a && rand.nextInt(3) == 0 && this.func_175807_a(world, x, y - 1, z, sbb).func_177230_c() == Blocks.field_150417_aV)) {
                        if (y == sy || y == dy) {
                            final StructureComponent.BlockSelector strongBlocks = StructureTFComponentOld.getStrongholdStones();
                            strongBlocks.func_75062_a(rand, x, y, z, wall);
                            this.func_175811_a(world, strongBlocks.func_180780_a(), x, y, z, sbb);
                        }
                        else {
                            randomBlocks.func_75062_a(rand, x, y, z, wall);
                            this.func_175811_a(world, randomBlocks.func_180780_a(), x, y, z, sbb);
                        }
                    }
                }
            }
        }
    }
    
    public interface Factory<T extends StructureTFStrongholdComponent>
    {
        T newInstance(final TFFeature p0, final int p1, final EnumFacing p2, final int p3, final int p4, final int p5);
    }
}
