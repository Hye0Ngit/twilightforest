// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.block.TFBlocks;
import java.util.Random;
import java.util.List;

public class ComponentTFDarkTowerWing extends ComponentTFTowerWing
{
    protected ComponentTFDarkTowerWing(final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final int direction) {
        super(i, x, y, z, pSize, pHeight, direction);
    }
    
    @Override
    public void a(final aez parent, final List list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponent) {
            this.deco = ((StructureTFComponent)parent).deco;
        }
        this.addOpening(0, 1, this.size / 2, 2);
        this.makeARoof(parent, list, rand);
        this.makeABeard(parent, list, rand);
        if (this.size > 10) {
            for (int i = 0; i < 4; ++i) {
                final int[] dest = this.getValidOpening(rand, i);
                final int childHeight = this.validateChildHeight(this.height - 4 + rand.nextInt(10) - rand.nextInt(10));
                this.makeTowerWing(list, rand, 1, dest[0], dest[1], dest[2], this.size - 2, childHeight, i);
            }
        }
    }
    
    protected int validateChildHeight(final int childHeight) {
        return (childHeight & 0xFC) + 1;
    }
    
    @Override
    public void makeARoof(final aez parent, final List list, final Random rand) {
        final int index = this.c();
        final ComponentTFTowerRoof roof = new ComponentTFDarkTowerRoofAntenna(index + 1, this);
        list.add(roof);
        roof.a((aez)this, list, rand);
        this.roofType = roof.getClass();
    }
    
    @Override
    public void makeABeard(final aez parent, final List list, final Random rand) {
        final ComponentTFDarkTowerBeard beard = new ComponentTFDarkTowerBeard(this.c() + 1, this);
        list.add(beard);
        beard.a((aez)this, list, rand);
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
        aez intersect = aez.a(list, bridge.b());
        if (intersect != null && intersect != this) {
            return false;
        }
        intersect = aez.a(list, bridge.getWingBB());
        if (intersect == null || intersect == this) {
            list.add(bridge);
            bridge.a(this, list, rand);
            this.addOpening(x, y, z, rotation);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean a(final yc world, final Random rand, final acn sbb) {
        final Random decoRNG = new Random(world.E() + this.e.a * 321534781 ^ (long)(this.e.c * 756839));
        this.makeEncasedWalls(world, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1);
        this.a(world, sbb, 1, 1, 1, this.size - 2, this.height - 2, this.size - 2);
        this.nullifySkyLightForBoundingBox(world);
        this.addHalfFloors(world, decoRNG, sbb, 0, this.height - 1);
        this.makeOpenings(world, sbb);
        return true;
    }
    
    protected void addHalfFloors(final yc world, final Random rand, final acn sbb, int bottom, final int top) {
        final int spacing = 4;
        int floorside = this.e.b % 4;
        if (bottom == 0) {
            bottom += spacing;
        }
        for (int y = bottom; y < top; y += spacing) {
            floorside += 3;
            floorside %= 4;
            switch (floorside) {
                case 0: {
                    this.a(world, sbb, this.size / 2 + 1, y, 1, this.size - 2, y, this.size - 2, this.deco.blockID, this.deco.blockMeta, 0, 0, false);
                    this.a(world, sbb, this.size / 2, y, 1, this.size / 2, y, this.size - 2, this.deco.accentID, this.deco.accentMeta, 0, 0, false);
                    break;
                }
                case 1: {
                    this.a(world, sbb, 1, y, this.size / 2 + 1, this.size - 2, y, this.size - 2, this.deco.blockID, this.deco.blockMeta, 0, 0, false);
                    this.a(world, sbb, 1, y, this.size / 2, this.size - 2, y, this.size / 2, this.deco.accentID, this.deco.accentMeta, 0, 0, false);
                    break;
                }
                case 2: {
                    this.a(world, sbb, 1, y, 1, this.size / 2 - 1, y, this.size - 2, this.deco.blockID, this.deco.blockMeta, 0, 0, false);
                    this.a(world, sbb, this.size / 2, y, 1, this.size / 2, y, this.size - 2, this.deco.accentID, this.deco.accentMeta, 0, 0, false);
                    break;
                }
                case 3: {
                    this.a(world, sbb, 1, y, 1, this.size - 2, y, this.size / 2 - 1, this.deco.blockID, this.deco.blockMeta, 0, 0, false);
                    this.a(world, sbb, 1, y, this.size / 2, this.size - 2, y, this.size / 2, this.deco.accentID, this.deco.accentMeta, 0, 0, false);
                    break;
                }
            }
        }
    }
    
    protected void addThreeQuarterFloors(final yc world, final Random rand, final acn sbb, int bottom, final int top) {
        final int spacing = 5;
        int floorside = this.e.b % 4;
        if (bottom == 0) {
            bottom += spacing;
        }
        for (int y = bottom; y < top; y += spacing) {
            floorside += 3;
            floorside %= 4;
            this.makeThreeQuarterFloor(world, sbb, floorside, y, y == bottom && bottom != spacing);
        }
    }
    
    protected void makeThreeQuarterFloor(final yc world, final acn sbb, final int rotation, final int y, final boolean isBottom) {
        final int originalCoordMode = this.getCoordBaseMode();
        this.setCoordBaseMode((this.getCoordBaseMode() + rotation) % 4);
        this.a(world, sbb, 1, y, 1, this.size - 2, y, this.size - 2, this.deco.blockID, this.deco.blockMeta, 0, 0, false);
        this.a(world, sbb, 1, y, 1, this.size / 2, y, this.size / 2, this.deco.accentID, this.deco.accentMeta, 0, 0, false);
        this.a(world, sbb, 1, y + 1, 1, this.size / 2, y + 1, this.size / 2, this.deco.fenceID, this.deco.fenceMeta, 0, 0, false);
        this.a(world, sbb, 1, y, 1, this.size / 2 - 1, y + 1, this.size / 2 - 1);
        if (!isBottom) {
            this.a(world, sbb, this.size / 2, y, 1, this.size / 2, y + 1, 2);
            for (int i = 0; i < 5; ++i) {
                this.a(world, this.deco.stairID, this.getStairMeta(0), this.size / 2 - i, y - i, 1, sbb);
                this.a(world, this.deco.stairID, this.getStairMeta(0), this.size / 2 - i, y - i, 2, sbb);
                this.a(world, this.deco.blockID, this.deco.blockMeta, this.size / 2 - i + 1, y - i, 1, sbb);
                this.a(world, this.deco.blockID, this.deco.blockMeta, this.size / 2 - i + 1, y - i, 2, sbb);
                this.a(world, this.deco.blockID, this.deco.blockMeta, this.size / 2 - i + 1, y - i, 3, sbb);
                if (i > 0 && i < 4) {
                    this.a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 - i, y - i, 3, sbb);
                    this.a(world, this.deco.fenceID, this.deco.fenceMeta, this.size / 2 - i, y - i + 1, 3, sbb);
                    this.a(world, this.deco.fenceID, this.deco.fenceMeta, this.size / 2 - i, y - i + 2, 3, sbb);
                }
                else if (i == 4) {
                    this.a(world, this.deco.stairID, this.getStairMeta(3), this.size / 2 - i, y - i, 3, sbb);
                }
            }
        }
        this.setCoordBaseMode(originalCoordMode);
    }
    
    protected void makeEncasedWalls(final yc world, final acn sbb, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ) {
        for (int x = minX; x <= maxX; ++x) {
            for (int y = minY; y <= maxY; ++y) {
                for (int z = minZ; z <= maxZ; ++z) {
                    if (x == minX || x == maxX || y == minY || y == maxY || z == minZ || z == maxZ) {
                        if (((x == minY || x == maxX) && (y == minY || y == maxY || z == minZ || z == maxZ)) || ((y == minY || y == maxY) && (x == minY || x == maxX || z == minZ || z == maxZ)) || ((z == minZ || z == maxZ) && (x == minY || x == maxX || y == minY || y == maxY))) {
                            this.a(world, this.deco.accentID, this.deco.accentMeta, x, y, z, sbb);
                        }
                        else {
                            this.a(world, this.deco.blockID, this.deco.blockMeta, x, y, z, sbb);
                        }
                    }
                }
            }
        }
        this.a(world, this.deco.accentID, this.deco.accentMeta, minX + 1, minY + 1, minZ, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, minX + 1, minY + 1, maxZ, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, maxX - 1, minY + 1, minZ, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, maxX - 1, minY + 1, maxZ, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, minX + 1, maxY - 1, minZ, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, minX + 1, maxY - 1, maxZ, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, maxX - 1, maxY - 1, minZ, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, maxX - 1, maxY - 1, maxZ, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, minX, minY + 1, minZ + 1, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, minX, minY + 1, maxZ - 1, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, maxX, minY + 1, minZ + 1, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, maxX, minY + 1, maxZ - 1, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, minX, maxY - 1, minZ + 1, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, minX, maxY - 1, maxZ - 1, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, maxX, maxY - 1, minZ + 1, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, maxX, maxY - 1, maxZ - 1, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, minX + 1, minY, minZ + 1, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, minX + 1, minY, maxZ - 1, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, maxX - 1, minY, minZ + 1, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, maxX - 1, minY, maxZ - 1, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, minX + 1, maxY, minZ + 1, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, minX + 1, maxY, maxZ - 1, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, maxX - 1, maxY, minZ + 1, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, maxX - 1, maxY, maxZ - 1, sbb);
    }
    
    @Override
    public int[] getValidOpening(final Random rand, final int direction) {
        final int verticalOffset = (this.size == 19) ? 5 : 4;
        if (direction == 0 || direction == 2) {
            final int rx = (direction == 0) ? (this.size - 1) : 0;
            final int rz = this.size / 2;
            final int ry = this.height - verticalOffset;
            return new int[] { rx, ry, rz };
        }
        if (direction == 1 || direction == 3) {
            final int rx = this.size / 2;
            final int rz = (direction == 1) ? (this.size - 1) : 0;
            final int ry = this.height - verticalOffset;
            return new int[] { rx, ry, rz };
        }
        return new int[] { 0, 0, 0 };
    }
    
    @Override
    protected void makeDoorOpening(final yc world, final int dx, final int dy, final int dz, final acn sbb) {
        this.nullifySkyLightAtCurrentPosition(world, dx - 3, dy - 1, dz - 3, dx + 3, dy + 3, dz + 3);
        if (dx == 0 || dx == this.size - 1) {
            this.a(world, sbb, dx, dy - 1, dz - 2, dx, dy + 3, dz + 2, this.deco.accentID, this.deco.accentMeta, 0, 0, false);
            this.a(world, sbb, dx, dy, dz - 1, dx, dy + 2, dz + 1, TFBlocks.towerDevice.cm, 2, 0, 0, false);
        }
        if (dz == 0 || dz == this.size - 1) {
            this.a(world, sbb, dx - 2, dy - 1, dz, dx + 2, dy + 3, dz, this.deco.accentID, this.deco.accentMeta, 0, 0, false);
            this.a(world, sbb, dx - 1, dy, dz, dx + 1, dy + 2, dz, TFBlocks.towerDevice.cm, 2, 0, 0, false);
        }
    }
}
