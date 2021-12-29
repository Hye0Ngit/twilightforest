// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import java.util.Random;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Iterator;
import java.nio.IntBuffer;
import net.minecraft.nbt.NBTTagCompound;
import java.util.ArrayList;
import net.minecraft.util.ChunkCoordinates;
import java.util.List;
import twilightforest.structures.StructureTFComponent;

public abstract class StructureTFStrongholdComponent extends StructureTFComponent
{
    public List<ChunkCoordinates> doors;
    
    public StructureTFStrongholdComponent() {
        this.doors = new ArrayList<ChunkCoordinates>();
    }
    
    public StructureTFStrongholdComponent(final int i, final int facing, final int x, final int y, final int z) {
        super(i);
        this.doors = new ArrayList<ChunkCoordinates>();
        this.field_74887_e = this.generateBoundingBox(facing, x, y, z);
        this.setCoordBaseMode(facing);
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_143012_a(par1NBTTagCompound);
        par1NBTTagCompound.func_74783_a("doorInts", this.getDoorsAsIntArray());
    }
    
    private int[] getDoorsAsIntArray() {
        final IntBuffer ibuffer = IntBuffer.allocate(this.doors.size() * 3);
        for (final ChunkCoordinates door : this.doors) {
            ibuffer.put(door.field_71574_a);
            ibuffer.put(door.field_71572_b);
            ibuffer.put(door.field_71573_c);
        }
        return ibuffer.array();
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_143011_b(par1NBTTagCompound);
        this.readOpeningsFromArray(par1NBTTagCompound.func_74759_k("doorInts"));
    }
    
    private void readOpeningsFromArray(final int[] intArray) {
        for (int i = 0; i < intArray.length; i += 3) {
            final ChunkCoordinates door = new ChunkCoordinates(intArray[i], intArray[i + 1], intArray[i + 2]);
            this.doors.add(door);
        }
    }
    
    public abstract StructureBoundingBox generateBoundingBox(final int p0, final int p1, final int p2, final int p3);
    
    public static StructureBoundingBox getComponentToAddBoundingBox(final int x, final int y, final int z, final int xOff, final int yOff, final int zOff, final int xSize, final int ySize, final int zSize, final int facing) {
        switch (facing) {
            case 0: {
                return new StructureBoundingBox(x + xOff, y + yOff, z + zOff, x + xSize - 1 + xOff, y + ySize - 1 + yOff, z + zSize - 1 + zOff);
            }
            case 1: {
                return new StructureBoundingBox(x - zSize + 1 + zOff, y + yOff, z + xOff, x + zOff, y + ySize - 1 + yOff, z + xSize - 1 + xOff);
            }
            case 2: {
                return new StructureBoundingBox(x - xSize + 1 - xOff, y + yOff, z - zSize + 1 + zOff, x - xOff, y + ySize - 1 + yOff, z + zOff);
            }
            case 3: {
                return new StructureBoundingBox(x + zOff, y + yOff, z - xSize + 1 - xOff, x + zSize - 1 + zOff, y + ySize - 1 + yOff, z - xOff);
            }
            default: {
                return new StructureBoundingBox(x + xOff, y + yOff, z + zOff, x + xSize - 1 + xOff, y + ySize - 1 + yOff, z + zSize - 1 + zOff);
            }
        }
    }
    
    public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponent) {
            this.deco = ((StructureTFComponent)parent).deco;
        }
    }
    
    protected void addNewComponent(final StructureComponent entrance, final List list, final Random random, final int facing, final int x, final int y, final int z) {
        final int index = this.field_74886_g + 1;
        final int nFacing = (this.field_74885_f + facing) % 4;
        final int nx = this.func_74865_a(x, z);
        final int ny = this.func_74862_a(y);
        final int nz = this.func_74873_b(x, z);
        if (index > 50 || this.isOutOfRange(entrance, nx, ny, nz, 112)) {
            return;
        }
        final StructureTFStrongholdComponent breakIn = this.findBreakInComponent(list, nx, ny, nz);
        if (breakIn != null && breakIn.attemptToBreakIn(nx, ny, nz)) {
            this.addDoorwayTo(x, y, z, facing);
            return;
        }
        final TFStrongholdPieces pieceList = ((ComponentTFStrongholdEntrance)entrance).lowerPieces;
        final StructureTFStrongholdComponent nextComponent = pieceList.getNextComponent(entrance, list, random, index, nFacing, nx, ny, nz);
        if (nextComponent != null) {
            list.add(nextComponent);
            nextComponent.func_74861_a(entrance, list, random);
            this.addDoorwayTo(x, y, z, facing);
        }
    }
    
    protected StructureTFStrongholdComponent findBreakInComponent(final List<StructureTFStrongholdComponent> list, final int x, final int y, final int z) {
        for (final StructureTFStrongholdComponent component : list) {
            if (component.field_74887_e != null && component.field_74887_e.func_78890_b(x, y, z)) {
                return component;
            }
        }
        return null;
    }
    
    protected void addNewUpperComponent(final StructureComponent parent, final List list, final Random random, final int facing, final int x, final int y, final int z) {
        StructureTFStrongholdComponent attempted = null;
        final int index = this.field_74886_g + 1;
        final int nFacing = (this.field_74885_f + facing) % 4;
        final int nx = this.func_74865_a(x, z);
        final int ny = this.func_74862_a(y);
        final int nz = this.func_74873_b(x, z);
        if (index > 100 || this.isOutOfRange(parent, nx, ny, nz, 48)) {
            return;
        }
        switch (random.nextInt(5)) {
            default: {
                attempted = new ComponentTFStrongholdUpperTIntersection(index, nFacing, nx, ny, nz);
                break;
            }
            case 1: {
                attempted = new ComponentTFStrongholdUpperLeftTurn(index, nFacing, nx, ny, nz);
                break;
            }
            case 2: {
                attempted = new ComponentTFStrongholdUpperRightTurn(index, nFacing, nx, ny, nz);
                break;
            }
            case 3: {
                attempted = new ComponentTFStrongholdUpperCorridor(index, nFacing, nx, ny, nz);
                break;
            }
            case 4: {
                attempted = new ComponentTFStrongholdUpperAscender(index, nFacing, nx, ny, nz);
                break;
            }
        }
        if (attempted != null && StructureComponent.func_74883_a(list, attempted.func_74874_b()) == null) {
            list.add(attempted);
            attempted.func_74861_a(parent, list, random);
        }
    }
    
    private boolean isOutOfRange(final StructureComponent parent, final int nx, final int ny, final int nz, final int range) {
        return Math.abs(nx - parent.func_74874_b().field_78897_a) > range || Math.abs(nz - parent.func_74874_b().field_78896_c) > range;
    }
    
    protected void placeDoorwayAt(final World world, final Random rand, final int x, final int y, final int z, final StructureBoundingBox sbb) {
        if (x == 0 || x == this.getXSize()) {
            this.func_151556_a(world, sbb, x, y, z - 2, x, y + 3, z + 2, this.deco.fenceID, this.deco.fenceMeta, Blocks.field_150350_a, 0, false);
            this.func_74878_a(world, sbb, x, y, z - 1, x, y + 3, z + 1);
        }
        else {
            this.func_151556_a(world, sbb, x - 2, y, z, x + 2, y + 3, z, this.deco.fenceID, this.deco.fenceMeta, Blocks.field_150350_a, 0, false);
            this.func_74878_a(world, sbb, x - 1, y, z, x + 1, y + 3, z);
        }
    }
    
    protected int getXSize() {
        switch (this.getCoordBaseMode()) {
            default: {
                return this.field_74887_e.func_78883_b() - 1;
            }
            case 1:
            case 3: {
                return this.field_74887_e.func_78880_d() - 1;
            }
        }
    }
    
    protected void placeSmallDoorwayAt(final World world, final Random rand, final int facing, final int x, final int y, final int z, final StructureBoundingBox sbb) {
        if (facing == 0 || facing == 2) {
            this.func_151556_a(world, sbb, x - 1, y, z, x + 1, y + 1, z, Blocks.field_150463_bK, 0, Blocks.field_150350_a, 0, true);
            this.func_74878_a(world, sbb, x, y, z, x, y + 1, z);
        }
        else {
            this.func_151556_a(world, sbb, x, y, z - 1, x, y + 1, z + 1, Blocks.field_150463_bK, 0, Blocks.field_150350_a, 0, true);
            this.func_74878_a(world, sbb, x, y, z, x, y + 1, z);
        }
    }
    
    public void placeCornerStatue(final World world, final int x, final int y, final int z, final int facing, final StructureBoundingBox sbb) {
        int ox = 1;
        int oz = 1;
        int smx = 2;
        int smz = 3;
        switch (facing) {
            case 1: {
                oz = -1;
                smz = 1;
                break;
            }
            case 2: {
                ox = -1;
                smx = 0;
                break;
            }
            case 3: {
                ox = -1;
                oz = -1;
                smx = 0;
                smz = 1;
                break;
            }
        }
        for (int sy = 0; sy < 5; ++sy) {
            this.func_151550_a(world, this.deco.pillarID, this.deco.pillarMeta, x, y + sy, z, sbb);
        }
        this.func_151550_a(world, Blocks.field_150422_aJ, 0, x + 0, y + 4, z + oz, sbb);
        this.func_151550_a(world, Blocks.field_150422_aJ, 0, x + ox, y + 4, z + 0, sbb);
        this.func_151550_a(world, this.deco.stairID, this.getStairMeta(smz), x + 0, y + 3, z + oz, sbb);
        this.func_151550_a(world, this.deco.stairID, this.getStairMeta(smx), x + ox, y + 3, z + 0, sbb);
        this.func_151550_a(world, this.deco.stairID, this.getStairMeta(smz) + 4, x + 0, y + 2, z + oz, sbb);
        this.func_151550_a(world, this.deco.stairID, this.getStairMeta(smx) + 4, x + ox, y + 2, z + 0, sbb);
        this.func_151550_a(world, this.deco.stairID, this.getStairMeta(smx) + 4, x + ox, y + 2, z + oz, sbb);
        this.func_151550_a(world, Blocks.field_150463_bK, 0, x + ox, y + 0, z + oz, sbb);
        this.func_151550_a(world, Blocks.field_150463_bK, 0, x + ox, y + 1, z + oz, sbb);
        this.func_151550_a(world, this.deco.stairID, this.getStairMeta(smz), x + 0, y + 0, z + oz, sbb);
        this.func_151550_a(world, this.deco.stairID, this.getStairMeta(smx), x + ox, y + 0, z + 0, sbb);
    }
    
    public void placeWallStatue(final World world, final int x, final int y, final int z, final int facing, final StructureBoundingBox sbb) {
        int ox = 1;
        int oz = 1;
        for (int sy = 0; sy < 5; ++sy) {
            this.func_151550_a(world, this.deco.pillarID, this.deco.pillarMeta, x, y + sy, z, sbb);
        }
        if (facing == 0 || facing == 2) {
            if (facing == 2) {
                ox = -ox;
                oz = -oz;
            }
            this.func_151550_a(world, Blocks.field_150422_aJ, 0, x - ox, y + 4, z, sbb);
            this.func_151550_a(world, Blocks.field_150422_aJ, 0, x + ox, y + 4, z, sbb);
            this.func_151550_a(world, this.deco.stairID, this.getStairMeta(0 + facing), x - ox, y + 3, z, sbb);
            this.func_151550_a(world, this.deco.stairID, this.getStairMeta(2 + facing), x + ox, y + 3, z, sbb);
            this.func_151550_a(world, this.deco.stairID, this.getStairMeta(1 + facing), x - ox, y + 3, z - oz, sbb);
            this.func_151550_a(world, this.deco.stairID, this.getStairMeta(1 + facing), x + ox, y + 3, z - oz, sbb);
            this.func_151550_a(world, this.deco.stairID, this.getStairMeta(0 + facing) + 4, x - ox, y + 2, z, sbb);
            this.func_151550_a(world, this.deco.stairID, this.getStairMeta(2 + facing) + 4, x + ox, y + 2, z, sbb);
            this.func_151550_a(world, this.deco.stairID, this.getStairMeta(1 + facing) + 4, x + 0, y + 2, z - oz, sbb);
            this.func_151550_a(world, this.deco.stairID, this.getStairMeta(1 + facing) + 4, x - ox, y + 2, z - oz, sbb);
            this.func_151550_a(world, this.deco.stairID, this.getStairMeta(1 + facing) + 4, x + ox, y + 2, z - oz, sbb);
            this.func_151550_a(world, Blocks.field_150463_bK, 0, x, y + 0, z - oz, sbb);
            this.func_151550_a(world, Blocks.field_150463_bK, 0, x, y + 1, z - oz, sbb);
            this.func_151550_a(world, this.deco.stairID, this.getStairMeta(0 + facing), x - ox, y + 0, z + 0, sbb);
            this.func_151550_a(world, this.deco.stairID, this.getStairMeta(2 + facing), x + ox, y + 0, z + 0, sbb);
        }
        else {
            if (facing == 3) {
                oz = -oz;
                ox = -ox;
            }
            this.func_151550_a(world, Blocks.field_150422_aJ, 0, x, y + 4, z - oz, sbb);
            this.func_151550_a(world, Blocks.field_150422_aJ, 0, x, y + 4, z + oz, sbb);
            this.func_151550_a(world, this.deco.stairID, this.getStairMeta(0 + facing), x, y + 3, z - oz, sbb);
            this.func_151550_a(world, this.deco.stairID, this.getStairMeta(2 + facing), x, y + 3, z + oz, sbb);
            this.func_151550_a(world, this.deco.stairID, this.getStairMeta(1 + facing), x + ox, y + 3, z - oz, sbb);
            this.func_151550_a(world, this.deco.stairID, this.getStairMeta(1 + facing), x + ox, y + 3, z + oz, sbb);
            this.func_151550_a(world, this.deco.stairID, this.getStairMeta(0 + facing) + 4, x, y + 2, z - oz, sbb);
            this.func_151550_a(world, this.deco.stairID, this.getStairMeta(2 + facing) + 4, x, y + 2, z + oz, sbb);
            this.func_151550_a(world, this.deco.stairID, this.getStairMeta(1 + facing) + 4, x + oz, y + 2, z + 0, sbb);
            this.func_151550_a(world, this.deco.stairID, this.getStairMeta(1 + facing) + 4, x + ox, y + 2, z - oz, sbb);
            this.func_151550_a(world, this.deco.stairID, this.getStairMeta(1 + facing) + 4, x + ox, y + 2, z + oz, sbb);
            this.func_151550_a(world, Blocks.field_150463_bK, 0, x + ox, y + 0, z, sbb);
            this.func_151550_a(world, Blocks.field_150463_bK, 0, x + ox, y + 1, z, sbb);
            this.func_151550_a(world, this.deco.stairID, this.getStairMeta(0 + facing), x, y + 0, z - ox, sbb);
            this.func_151550_a(world, this.deco.stairID, this.getStairMeta(2 + facing), x, y + 0, z + ox, sbb);
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
    
    public void addDoorwayTo(final int dx, final int dy, final int dz, final int facing) {
        switch (facing) {
            case 0: {
                this.addDoor(dx, dy, dz - 1);
                break;
            }
            case 1: {
                this.addDoor(dx + 1, dy, dz);
                break;
            }
            case 2: {
                this.addDoor(dx, dy, dz + 1);
                break;
            }
            case 3: {
                this.addDoor(dx - 1, dy, dz);
                break;
            }
        }
    }
    
    public void addDoor(final int dx, final int dy, final int dz) {
        this.doors.add(new ChunkCoordinates(dx, dy, dz));
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
        switch (this.getCoordBaseMode()) {
            case 0: {
                return x - this.field_74887_e.field_78897_a;
            }
            case 2: {
                return this.field_74887_e.field_78893_d - x;
            }
            case 1: {
                return z - this.field_74887_e.field_78896_c;
            }
            case 3: {
                return this.field_74887_e.field_78892_f - z;
            }
            default: {
                return x;
            }
        }
    }
    
    protected int getRelativeY(final int par1) {
        return par1 - this.field_74887_e.field_78895_b;
    }
    
    protected int getRelativeZ(final int x, final int z) {
        switch (this.getCoordBaseMode()) {
            case 0: {
                return z - this.field_74887_e.field_78896_c;
            }
            case 2: {
                return this.field_74887_e.field_78892_f - z;
            }
            case 1: {
                return this.field_74887_e.field_78893_d - x;
            }
            case 3: {
                return x - this.field_74887_e.field_78897_a;
            }
            default: {
                return z;
            }
        }
    }
    
    public void placeDoors(final World world, final Random rand, final StructureBoundingBox sbb) {
        if (this.doors != null) {
            for (final ChunkCoordinates doorCoords : this.doors) {
                this.placeDoorwayAt(world, rand, doorCoords.field_71574_a, doorCoords.field_71572_b, doorCoords.field_71573_c, sbb);
            }
        }
    }
    
    protected void placeStrongholdWalls(final World world, final StructureBoundingBox sbb, final int sx, final int sy, final int sz, final int dx, final int dy, final int dz, final Random rand, final StructureComponent.BlockSelector randomBlocks) {
        for (int y = sy; y <= dy; ++y) {
            for (int x = sx; x <= dx; ++x) {
                for (int z = sz; z <= dz; ++z) {
                    final boolean wall = y == sy || y == dy || x == sx || x == dx || z == sz || z == dz;
                    final Block blockID = this.func_151548_a(world, x, y, z, sbb);
                    if (blockID == Blocks.field_150350_a) {
                        if (wall) {
                            this.func_151550_a(world, Blocks.field_150347_e, 0, x, y, z, sbb);
                        }
                    }
                    else if (y == sy || y == dy) {
                        final StructureComponent.BlockSelector strongBlocks = StructureTFComponent.getStrongholdStones();
                        strongBlocks.func_75062_a(rand, x, y, z, wall);
                        this.func_151550_a(world, strongBlocks.func_151561_a(), strongBlocks.func_75064_b(), x, y, z, sbb);
                    }
                    else if (!wall || blockID != Blocks.field_150346_d) {
                        randomBlocks.func_75062_a(rand, x, y, z, wall);
                        this.func_151550_a(world, randomBlocks.func_151561_a(), randomBlocks.func_75064_b(), x, y, z, sbb);
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
                    final Block blockID = this.func_151548_a(world, x, y, z, sbb);
                    if ((blockID != Blocks.field_150350_a && (blockID.func_149688_o() == Material.field_151576_e || blockID.func_149688_o() == Material.field_151577_b || blockID.func_149688_o() == Material.field_151578_c)) || (blockID == Blocks.field_150350_a && rand.nextInt(3) == 0 && this.func_151548_a(world, x, y - 1, z, sbb) == Blocks.field_150417_aV)) {
                        if (y == sy || y == dy) {
                            final StructureComponent.BlockSelector strongBlocks = StructureTFComponent.getStrongholdStones();
                            strongBlocks.func_75062_a(rand, x, y, z, wall);
                            this.func_151550_a(world, strongBlocks.func_151561_a(), strongBlocks.func_75064_b(), x, y, z, sbb);
                        }
                        else {
                            randomBlocks.func_75062_a(rand, x, y, z, wall);
                            this.func_151550_a(world, randomBlocks.func_151561_a(), randomBlocks.func_75064_b(), x, y, z, sbb);
                        }
                    }
                }
            }
        }
    }
}
