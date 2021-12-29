// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.List;
import twilightforest.structures.StructureTFComponent;

public abstract class StructureTFStrongholdComponent extends StructureTFComponent
{
    public List<t> doors;
    
    public StructureTFStrongholdComponent(final int i, final int facing, final int x, final int y, final int z) {
        super(i);
        this.f = this.generateBoundingBox(facing, x, y, z);
        this.setCoordBaseMode(facing);
    }
    
    public abstract age generateBoundingBox(final int p0, final int p1, final int p2, final int p3);
    
    public static age getComponentToAddBoundingBox(final int x, final int y, final int z, final int xOff, final int yOff, final int zOff, final int xSize, final int ySize, final int zSize, final int facing) {
        switch (facing) {
            case 0: {
                return new age(x + xOff, y + yOff, z + zOff, x + xSize - 1 + xOff, y + ySize - 1 + yOff, z + zSize - 1 + zOff);
            }
            case 1: {
                return new age(x - zSize + 1 + zOff, y + yOff, z + xOff, x + zOff, y + ySize - 1 + yOff, z + xSize - 1 + xOff);
            }
            case 2: {
                return new age(x - xSize + 1 - xOff, y + yOff, z - zSize + 1 + zOff, x - xOff, y + ySize - 1 + yOff, z + zOff);
            }
            case 3: {
                return new age(x + zOff, y + yOff, z - xSize + 1 - xOff, x + zSize - 1 + zOff, y + ySize - 1 + yOff, z - xOff);
            }
            default: {
                return new age(x + xOff, y + yOff, z + zOff, x + xSize - 1 + xOff, y + ySize - 1 + yOff, z + zSize - 1 + zOff);
            }
        }
    }
    
    public void a(final aiq parent, final List list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponent) {
            this.deco = ((StructureTFComponent)parent).deco;
        }
    }
    
    protected void addNewComponent(final aiq entrance, final List list, final Random random, final int facing, final int x, final int y, final int z) {
        final int index = this.h + 1;
        final int nFacing = (this.g + facing) % 4;
        final int nx = this.a(x, z);
        final int ny = this.a(y);
        final int nz = this.b(x, z);
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
            nextComponent.a(entrance, list, random);
            this.addDoorwayTo(x, y, z, facing);
        }
    }
    
    protected StructureTFStrongholdComponent findBreakInComponent(final List<StructureTFStrongholdComponent> list, final int x, final int y, final int z) {
        for (final StructureTFStrongholdComponent component : list) {
            if (component.f != null && component.f.b(x, y, z)) {
                return component;
            }
        }
        return null;
    }
    
    protected void addNewUpperComponent(final aiq parent, final List list, final Random random, final int facing, final int x, final int y, final int z) {
        StructureTFStrongholdComponent attempted = null;
        final int index = this.h + 1;
        final int nFacing = (this.g + facing) % 4;
        final int nx = this.a(x, z);
        final int ny = this.a(y);
        final int nz = this.b(x, z);
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
        if (attempted != null && aiq.a(list, attempted.b()) == null) {
            list.add(attempted);
            attempted.a(parent, list, random);
        }
    }
    
    private boolean isOutOfRange(final aiq parent, final int nx, final int ny, final int nz, final int range) {
        return Math.abs(nx - parent.b().a) > range || Math.abs(nz - parent.b().c) > range;
    }
    
    protected void placeDoorwayAt(final abv world, final Random rand, final int x, final int y, final int z, final age sbb) {
        if (x == 0 || x == this.getXSize()) {
            this.a(world, sbb, x, y, z - 2, x, y + 3, z + 2, this.deco.fenceID, this.deco.fenceMeta, 0, 0, false);
            this.a(world, sbb, x, y, z - 1, x, y + 3, z + 1);
        }
        else {
            this.a(world, sbb, x - 2, y, z, x + 2, y + 3, z, this.deco.fenceID, this.deco.fenceMeta, 0, 0, false);
            this.a(world, sbb, x - 1, y, z, x + 1, y + 3, z);
        }
    }
    
    protected int getXSize() {
        switch (this.getCoordBaseMode()) {
            default: {
                return this.f.b() - 1;
            }
            case 1:
            case 3: {
                return this.f.d() - 1;
            }
        }
    }
    
    protected void placeSmallDoorwayAt(final abv world, final Random rand, final int facing, final int x, final int y, final int z, final age sbb) {
        if (facing == 0 || facing == 2) {
            this.a(world, sbb, x - 1, y, z, x + 1, y + 1, z, aqw.cg.cF, 0, 0, 0, true);
            this.a(world, sbb, x, y, z, x, y + 1, z);
        }
        else {
            this.a(world, sbb, x, y, z - 1, x, y + 1, z + 1, aqw.cg.cF, 0, 0, 0, true);
            this.a(world, sbb, x, y, z, x, y + 1, z);
        }
    }
    
    public void placeCornerStatue(final abv world, final int x, final int y, final int z, final int facing, final age sbb) {
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
            this.a(world, this.deco.pillarID, this.deco.pillarMeta, x, y + sy, z, sbb);
        }
        this.a(world, aqw.be.cF, 0, x + 0, y + 4, z + oz, sbb);
        this.a(world, aqw.be.cF, 0, x + ox, y + 4, z + 0, sbb);
        this.a(world, this.deco.stairID, this.getStairMeta(smz), x + 0, y + 3, z + oz, sbb);
        this.a(world, this.deco.stairID, this.getStairMeta(smx), x + ox, y + 3, z + 0, sbb);
        this.a(world, this.deco.stairID, this.getStairMeta(smz) + 4, x + 0, y + 2, z + oz, sbb);
        this.a(world, this.deco.stairID, this.getStairMeta(smx) + 4, x + ox, y + 2, z + 0, sbb);
        this.a(world, this.deco.stairID, this.getStairMeta(smx) + 4, x + ox, y + 2, z + oz, sbb);
        this.a(world, aqw.cg.cF, 0, x + ox, y + 0, z + oz, sbb);
        this.a(world, aqw.cg.cF, 0, x + ox, y + 1, z + oz, sbb);
        this.a(world, this.deco.stairID, this.getStairMeta(smz), x + 0, y + 0, z + oz, sbb);
        this.a(world, this.deco.stairID, this.getStairMeta(smx), x + ox, y + 0, z + 0, sbb);
    }
    
    public void placeWallStatue(final abv world, final int x, final int y, final int z, final int facing, final age sbb) {
        int ox = 1;
        int oz = 1;
        for (int sy = 0; sy < 5; ++sy) {
            this.a(world, this.deco.pillarID, this.deco.pillarMeta, x, y + sy, z, sbb);
        }
        if (facing == 0 || facing == 2) {
            if (facing == 2) {
                ox = -ox;
                oz = -oz;
            }
            this.a(world, aqw.be.cF, 0, x - ox, y + 4, z, sbb);
            this.a(world, aqw.be.cF, 0, x + ox, y + 4, z, sbb);
            this.a(world, this.deco.stairID, this.getStairMeta(0 + facing), x - ox, y + 3, z, sbb);
            this.a(world, this.deco.stairID, this.getStairMeta(2 + facing), x + ox, y + 3, z, sbb);
            this.a(world, this.deco.stairID, this.getStairMeta(1 + facing), x - ox, y + 3, z - oz, sbb);
            this.a(world, this.deco.stairID, this.getStairMeta(1 + facing), x + ox, y + 3, z - oz, sbb);
            this.a(world, this.deco.stairID, this.getStairMeta(0 + facing) + 4, x - ox, y + 2, z, sbb);
            this.a(world, this.deco.stairID, this.getStairMeta(2 + facing) + 4, x + ox, y + 2, z, sbb);
            this.a(world, this.deco.stairID, this.getStairMeta(1 + facing) + 4, x + 0, y + 2, z - oz, sbb);
            this.a(world, this.deco.stairID, this.getStairMeta(1 + facing) + 4, x - ox, y + 2, z - oz, sbb);
            this.a(world, this.deco.stairID, this.getStairMeta(1 + facing) + 4, x + ox, y + 2, z - oz, sbb);
            this.a(world, aqw.cg.cF, 0, x, y + 0, z - oz, sbb);
            this.a(world, aqw.cg.cF, 0, x, y + 1, z - oz, sbb);
            this.a(world, this.deco.stairID, this.getStairMeta(0 + facing), x - ox, y + 0, z + 0, sbb);
            this.a(world, this.deco.stairID, this.getStairMeta(2 + facing), x + ox, y + 0, z + 0, sbb);
        }
        else {
            if (facing == 3) {
                oz = -oz;
                ox = -ox;
            }
            this.a(world, aqw.be.cF, 0, x, y + 4, z - oz, sbb);
            this.a(world, aqw.be.cF, 0, x, y + 4, z + oz, sbb);
            this.a(world, this.deco.stairID, this.getStairMeta(0 + facing), x, y + 3, z - oz, sbb);
            this.a(world, this.deco.stairID, this.getStairMeta(2 + facing), x, y + 3, z + oz, sbb);
            this.a(world, this.deco.stairID, this.getStairMeta(1 + facing), x + ox, y + 3, z - oz, sbb);
            this.a(world, this.deco.stairID, this.getStairMeta(1 + facing), x + ox, y + 3, z + oz, sbb);
            this.a(world, this.deco.stairID, this.getStairMeta(0 + facing) + 4, x, y + 2, z - oz, sbb);
            this.a(world, this.deco.stairID, this.getStairMeta(2 + facing) + 4, x, y + 2, z + oz, sbb);
            this.a(world, this.deco.stairID, this.getStairMeta(1 + facing) + 4, x + oz, y + 2, z + 0, sbb);
            this.a(world, this.deco.stairID, this.getStairMeta(1 + facing) + 4, x + ox, y + 2, z - oz, sbb);
            this.a(world, this.deco.stairID, this.getStairMeta(1 + facing) + 4, x + ox, y + 2, z + oz, sbb);
            this.a(world, aqw.cg.cF, 0, x + ox, y + 0, z, sbb);
            this.a(world, aqw.cg.cF, 0, x + ox, y + 1, z, sbb);
            this.a(world, this.deco.stairID, this.getStairMeta(0 + facing), x, y + 0, z - ox, sbb);
            this.a(world, this.deco.stairID, this.getStairMeta(2 + facing), x, y + 0, z + ox, sbb);
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
        if (this.doors == null) {
            this.doors = new ArrayList<t>();
        }
        this.doors.add(new t(dx, dy, dz));
    }
    
    protected boolean isValidBreakInPoint(final int wx, final int wy, final int wz) {
        if (wy < this.f.b || wy > this.f.e) {
            return false;
        }
        if (wx == this.f.a || wx == this.f.d) {
            return wz > this.f.c && wz < this.f.f;
        }
        return (wz == this.f.c || wz == this.f.f) && wx > this.f.a && wx < this.f.d;
    }
    
    protected int getRelativeX(final int x, final int z) {
        switch (this.getCoordBaseMode()) {
            case 0: {
                return x - this.f.a;
            }
            case 2: {
                return this.f.d - x;
            }
            case 1: {
                return z - this.f.c;
            }
            case 3: {
                return this.f.f - z;
            }
            default: {
                return x;
            }
        }
    }
    
    protected int getRelativeY(final int par1) {
        return par1 - this.f.b;
    }
    
    protected int getRelativeZ(final int x, final int z) {
        switch (this.getCoordBaseMode()) {
            case 0: {
                return z - this.f.c;
            }
            case 2: {
                return this.f.f - z;
            }
            case 1: {
                return this.f.d - x;
            }
            case 3: {
                return x - this.f.a;
            }
            default: {
                return z;
            }
        }
    }
    
    public void placeDoors(final abv world, final Random rand, final age sbb) {
        if (this.doors != null) {
            for (final t doorCoords : this.doors) {
                this.placeDoorwayAt(world, rand, doorCoords.a, doorCoords.b, doorCoords.c, sbb);
            }
        }
    }
    
    protected void placeStrongholdWalls(final abv world, final age sbb, final int sx, final int sy, final int sz, final int dx, final int dy, final int dz, final Random rand, final air randomBlocks) {
        for (int y = sy; y <= dy; ++y) {
            for (int x = sx; x <= dx; ++x) {
                for (int z = sz; z <= dz; ++z) {
                    final boolean wall = y == sy || y == dy || x == sx || x == dx || z == sz || z == dz;
                    final int blockID = this.a(world, x, y, z, sbb);
                    if (blockID == 0) {
                        if (wall) {
                            this.a(world, aqw.B.cF, 0, x, y, z, sbb);
                        }
                    }
                    else if (!wall || blockID != aqw.A.cF) {
                        randomBlocks.a(rand, x, y, z, wall);
                        this.a(world, randomBlocks.a(), randomBlocks.b(), x, y, z, sbb);
                    }
                }
            }
        }
    }
    
    protected void placeUpperStrongholdWalls(final abv world, final age sbb, final int sx, final int sy, final int sz, final int dx, final int dy, final int dz, final Random rand, final air randomBlocks) {
        for (int y = sy; y <= dy; ++y) {
            for (int x = sx; x <= dx; ++x) {
                for (int z = sz; z <= dz; ++z) {
                    final boolean wall = y == sy || y == dy || x == sx || x == dx || z == sz || z == dz;
                    final int blockID = this.a(world, x, y, z, sbb);
                    if ((blockID > 0 && (aqw.s[blockID].cU == ajz.e || aqw.s[blockID].cU == ajz.b || aqw.s[blockID].cU == ajz.c)) || (blockID == 0 && rand.nextInt(3) == 0 && this.a(world, x, y - 1, z, sbb) == aqw.br.cF)) {
                        randomBlocks.a(rand, x, y, z, wall);
                        this.a(world, randomBlocks.a(), randomBlocks.b(), x, y, z, sbb);
                    }
                }
            }
        }
    }
}
