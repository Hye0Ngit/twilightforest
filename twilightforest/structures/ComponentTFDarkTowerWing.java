// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.TFBlocks;
import java.util.Random;
import java.util.List;

public class ComponentTFDarkTowerWing extends ComponentTFTowerWing
{
    protected ComponentTFDarkTowerWing(final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final int direction) {
        super(i, x, y, z, pSize, pHeight, direction);
    }
    
    @Override
    public void a(final aes parent, final List list, final Random rand) {
        this.addOpening(0, 1, this.size / 2, 2);
        this.makeABeard(parent, list, rand);
        if (this.size > 8) {
            for (int i = 0; i < 4; ++i) {
                final int[] dest = this.getValidOpening(rand, i);
                this.makeTowerWing(list, rand, 1, dest[0], dest[1], dest[2], this.size - 2, this.height - 4, i);
            }
        }
    }
    
    @Override
    public void makeABeard(final aes parent, final List list, final Random rand) {
        final ComponentTFDarkTowerBeard beard = new ComponentTFDarkTowerBeard(this.c() + 1, this);
        list.add(beard);
        beard.a((aes)this, list, rand);
    }
    
    @Override
    public boolean makeTowerWing(final List list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final int rotation) {
        if (wingHeight < 8) {
            return false;
        }
        final int direction = (this.getCoordBaseMode() + rotation) % 4;
        final int[] dx = this.offsetTowerCoords(x, y, z, 5, direction);
        if (dx[1] + wingHeight > 255) {
            return false;
        }
        final ComponentTFDarkTowerBridge bridge = new ComponentTFDarkTowerBridge(index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        aes intersect = aes.a(list, bridge.b());
        if (intersect != null && intersect != this) {
            return false;
        }
        intersect = aes.a(list, bridge.getWingBB());
        if (intersect == null || intersect == this) {
            list.add(bridge);
            bridge.a(this, list, rand);
            this.addOpening(x, y, z, rotation);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean a(final xv world, final Random rand, final acg sbb) {
        final Random decoRNG = new Random(world.E() + this.e.a * 321534781 ^ (long)(this.e.c * 756839));
        this.makeEncasedWalls(world, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1);
        this.a(world, sbb, 1, 1, 1, this.size - 2, this.height - 2, this.size - 2);
        for (int bx = this.e.a; bx <= this.e.d; ++bx) {
            for (int bz = this.e.c; bz <= this.e.f; ++bz) {
                for (int by = this.e.b; by <= this.e.e; ++by) {
                    world.b(yh.a, bx, by, bz, 0);
                }
            }
        }
        this.addHalfFloors(world, decoRNG, sbb, 0, this.height);
        this.makeOpenings(world, sbb);
        return true;
    }
    
    protected void addHalfFloors(final xv world, final Random rand, final acg sbb, final int bottom, final int top) {
        final int spacing = 5;
        int floorside = this.e.b % 4;
        for (int y = bottom; y < top; y += spacing) {
            floorside += ((rand.nextInt(3) > 0) ? 1 : 3);
            floorside %= 4;
            switch (floorside) {
                case 0: {
                    this.a(world, sbb, this.size / 2, y, 1, this.size - 2, y, this.size - 2, amj.A.cm, 0, 0, 0, false);
                    break;
                }
                case 1: {
                    this.a(world, sbb, 1, y, this.size / 2, this.size - 2, y, this.size - 2, amj.A.cm, 0, 0, 0, false);
                    break;
                }
                case 2: {
                    this.a(world, sbb, 1, y, 1, this.size / 2, y, this.size - 2, amj.A.cm, 0, 0, 0, false);
                    break;
                }
                case 3: {
                    this.a(world, sbb, 1, y, 1, this.size - 2, y, this.size / 2, amj.A.cm, 0, 0, 0, false);
                    break;
                }
            }
        }
    }
    
    protected void makeEncasedWalls(final xv world, final acg sbb, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ) {
        final int frameID = TFBlocks.towerWood.cm;
        final int frameMeta = 1;
        final int insideID = TFBlocks.towerWood.cm;
        final int insideMeta = 0;
        for (int x = minX; x <= maxX; ++x) {
            for (int y = minY; y <= maxY; ++y) {
                for (int z = minZ; z <= maxZ; ++z) {
                    if (x == minX || x == maxX || y == minY || y == maxY || z == minZ || z == maxZ) {
                        if (((x == minY || x == maxX) && (y == minY || y == maxY || z == minZ || z == maxZ)) || ((y == minY || y == maxY) && (x == minY || x == maxX || z == minZ || z == maxZ)) || ((z == minZ || z == maxZ) && (x == minY || x == maxX || y == minY || y == maxY))) {
                            this.a(world, frameID, frameMeta, x, y, z, sbb);
                        }
                        else {
                            this.a(world, insideID, insideMeta, x, y, z, sbb);
                        }
                    }
                }
            }
        }
        this.a(world, frameID, 0, minX + 1, minY + 1, minZ, sbb);
        this.a(world, frameID, 0, minX + 1, minY + 1, maxZ, sbb);
        this.a(world, frameID, 0, maxX - 1, minY + 1, minZ, sbb);
        this.a(world, frameID, 0, maxX - 1, minY + 1, maxZ, sbb);
        this.a(world, frameID, 0, minX + 1, maxY - 1, minZ, sbb);
        this.a(world, frameID, 0, minX + 1, maxY - 1, maxZ, sbb);
        this.a(world, frameID, 0, maxX - 1, maxY - 1, minZ, sbb);
        this.a(world, frameID, 0, maxX - 1, maxY - 1, maxZ, sbb);
        this.a(world, frameID, 0, minX, minY + 1, minZ + 1, sbb);
        this.a(world, frameID, 0, minX, minY + 1, maxZ - 1, sbb);
        this.a(world, frameID, 0, maxX, minY + 1, minZ + 1, sbb);
        this.a(world, frameID, 0, maxX, minY + 1, maxZ - 1, sbb);
        this.a(world, frameID, 0, minX, maxY - 1, minZ + 1, sbb);
        this.a(world, frameID, 0, minX, maxY - 1, maxZ - 1, sbb);
        this.a(world, frameID, 0, maxX, maxY - 1, minZ + 1, sbb);
        this.a(world, frameID, 0, maxX, maxY - 1, maxZ - 1, sbb);
        this.a(world, frameID, 0, minX + 1, minY, minZ + 1, sbb);
        this.a(world, frameID, 0, minX + 1, minY, maxZ - 1, sbb);
        this.a(world, frameID, 0, maxX - 1, minY, minZ + 1, sbb);
        this.a(world, frameID, 0, maxX - 1, minY, maxZ - 1, sbb);
        this.a(world, frameID, 0, minX + 1, maxY, minZ + 1, sbb);
        this.a(world, frameID, 0, minX + 1, maxY, maxZ - 1, sbb);
        this.a(world, frameID, 0, maxX - 1, maxY, minZ + 1, sbb);
        this.a(world, frameID, 0, maxX - 1, maxY, maxZ - 1, sbb);
    }
    
    @Override
    public int[] getValidOpening(final Random rand, final int direction) {
        if (direction == 0 || direction == 2) {
            final int rx = (direction == 0) ? (this.size - 1) : 0;
            final int rz = this.size / 2;
            final int ry = this.height - 5;
            return new int[] { rx, ry, rz };
        }
        if (direction == 1 || direction == 3) {
            final int rx = this.size / 2;
            final int rz = (direction == 1) ? (this.size - 1) : 0;
            final int ry = this.height - 5;
            return new int[] { rx, ry, rz };
        }
        return new int[] { 0, 0, 0 };
    }
    
    @Override
    protected void makeDoorOpening(final xv world, final int dx, final int dy, final int dz, final acg sbb) {
        this.a(world, sbb, dx - 1, dy, dz - 1, dx + 1, dy + 2, dz + 1);
        for (int x = dx - 2; x <= dx + 2; ++x) {
            for (int y = dy - 2; y <= dy + 2; ++y) {
                for (int z = dz - 2; z <= dz + 2; ++z) {
                    world.b(yh.a, x, y, z, 0);
                    this.updateLight(world, x, y, z);
                }
            }
        }
        if (dx == 0) {
            this.updateLight(world, dx - 1, dy + 0, dz);
            this.updateLight(world, dx - 1, dy + 1, dz);
        }
        if (dx == this.size - 1) {
            this.updateLight(world, dx + 1, dy + 0, dz);
            this.updateLight(world, dx + 1, dy + 1, dz);
        }
        if (dz == 0) {
            this.updateLight(world, dx, dy + 0, dz - 1);
            this.updateLight(world, dx, dy + 1, dz - 1);
        }
        if (dz == this.size - 1) {
            this.updateLight(world, dx, dy + 0, dz + 1);
            this.updateLight(world, dx, dy + 1, dz + 1);
        }
    }
}
