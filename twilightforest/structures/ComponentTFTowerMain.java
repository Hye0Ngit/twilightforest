// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import java.util.Iterator;
import java.util.ArrayList;
import twilightforest.TFBlocks;
import twilightforest.TFCreatures;
import java.util.List;
import java.util.Random;

public class ComponentTFTowerMain extends ComponentTFTowerWing
{
    public ComponentTFTowerMain(final xv world, final Random rand, final int index, final int x, final int y, final int z) {
        super(index, x, y, z, 15, 55 + rand.nextInt(32), 0);
    }
    
    @Override
    public void a(final aes parent, final List list, final Random rand) {
        this.makeARoof(parent, list, rand);
        for (int i = 0; i < 4; ++i) {
            final int[] dest = this.getValidOpening(rand, i);
            if (dest[1] < this.height / 2) {
                final int[] array = dest;
                final int n = 1;
                array[n] += 20;
            }
            final int childHeight = Math.min(21 + rand.nextInt(10), this.height - dest[1] - 3);
            if (!this.makeTowerWing(list, rand, 1, dest[0], dest[1], dest[2], 9, childHeight, i)) {
                this.makeTowerWing(list, rand, 1, dest[0], dest[1], dest[2], 7, childHeight, i);
            }
        }
        for (int i = 0; i < 4; ++i) {
            final int[] dest = this.getValidOpening(rand, i);
            if (dest[1] < this.height / 2) {
                final int[] array2 = dest;
                final int n2 = 1;
                array2[n2] += 10;
            }
            final int childHeight = Math.min(21 + rand.nextInt(10), this.height - dest[1] - 3);
            if (!this.makeTowerWing(list, rand, 1, dest[0], dest[1], dest[2], 9, childHeight, i)) {
                this.makeTowerWing(list, rand, 1, dest[0], dest[1], dest[2], 7, childHeight, i);
            }
        }
        for (int i = 0; i < 4; ++i) {
            final int[] dest = this.getValidOpening(rand, i);
            final int childHeight = Math.min(7 + rand.nextInt(6), this.height - dest[1] - 3);
            if (!this.makeTowerWing(list, rand, 1, dest[0], dest[1], dest[2], 5, childHeight, i)) {
                this.makeTowerWing(list, rand, 1, dest[0], dest[1], dest[2], 3, childHeight, i);
            }
        }
        for (int i = 0; i < 4; ++i) {
            final int[] dest = this.getOutbuildingOpening(rand, i);
            final int childHeight = 11 + rand.nextInt(10);
            final int childSize = 7 + rand.nextInt(2) * 2;
            this.makeTowerOutbuilding(list, rand, 1, dest[0], dest[1], dest[2], childSize, childHeight, i);
        }
        for (int i = 0; i < 16; ++i) {
            final int[] dest = this.getValidOpening(rand, i % 4);
            final int childHeight = 6 + rand.nextInt(5);
            if (rand.nextInt(3) == 0 || !this.makeTowerWing(list, rand, 1, dest[0], dest[1], dest[2], 5, childHeight, i % 4)) {
                this.makeTowerWing(list, rand, 1, dest[0], dest[1], dest[2], 3, childHeight, i % 4);
            }
        }
    }
    
    public int[] getOutbuildingOpening(final Random rand, final int rotation) {
        int rx = 0;
        final int ry = 1;
        int rz = 0;
        switch (rotation) {
            case 0: {
                rx = this.size - 1;
                rz = 6 + rand.nextInt(8);
                break;
            }
            case 1: {
                rx = 1 + rand.nextInt(11);
                rz = this.size - 1;
                break;
            }
            case 2: {
                rx = 0;
                rz = 1 + rand.nextInt(8);
                break;
            }
            case 3: {
                rx = 3 + rand.nextInt(11);
                rz = 0;
                break;
            }
        }
        return new int[] { rx, ry, rz };
    }
    
    public boolean makeTowerOutbuilding(final List list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final int rotation) {
        final int direction = (this.getCoordBaseMode() + rotation) % 4;
        final int[] dx = this.offsetTowerCoords(x, y, z, wingSize, direction);
        final ComponentTFTowerOutbuilding outbuilding = new ComponentTFTowerOutbuilding(index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        final aes intersect = aes.a(list, outbuilding.b());
        if (intersect == null || intersect == this) {
            list.add(outbuilding);
            outbuilding.a(this, list, rand);
            this.addOpening(x, y, z, rotation);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean a(final xv world, final Random rand, final acg sbb) {
        this.a(world, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1, false, rand, StructureTFComponent.getStrongholdStones());
        this.a(world, sbb, 1, 1, 1, this.size - 2, this.height - 2, this.size - 2);
        for (int x = 0; x < this.size; ++x) {
            for (int z = 0; z < this.size; ++z) {
                this.b(world, amj.z.cm, 0, x, -1, z, sbb);
            }
        }
        for (int bx = this.e.a - 1; bx <= this.e.d + 1; ++bx) {
            for (int bz = this.e.c - 1; bz <= this.e.f + 1; ++bz) {
                for (int by = this.e.b - 1; by <= this.e.e + 1; ++by) {
                    world.b(yh.a, bx, by, bz, 0);
                }
            }
        }
        if (this.height - this.highestOpening > 15) {
            this.highestOpening = this.height - 15;
        }
        this.makeStairs(world, rand, sbb);
        this.makeOpenings(world, sbb);
        this.decorateStairFloor(world, rand, sbb);
        this.makeStairwayCrossings(world, rand, sbb);
        this.makeLichRoom(world, rand, sbb);
        this.makeTowerPaintings(world, rand, sbb);
        return true;
    }
    
    protected void makeStairwayCrossings(final xv world, final Random rand, final acg sbb) {
        for (int flights = this.highestOpening / 5 - 2, i = 2 + rand.nextInt(2); i < flights; i += 1 + rand.nextInt(5)) {
            this.makeStairCrossing(world, rand, i, sbb);
        }
    }
    
    protected void makeStairCrossing(final xv world, final Random rand, final int flight, final acg sbb) {
        final int temp = this.getCoordBaseMode();
        if (flight % 2 == 0) {
            this.setCoordBaseMode((this.getCoordBaseMode() + 1) % 4);
        }
        final int floorMeta = (rand.nextInt(2) == 0) ? 0 : 2;
        int floorLevel = 0 + flight * 5;
        for (int dx = 6; dx <= 8; ++dx) {
            for (int dz = 4; dz <= 10; ++dz) {
                this.a(world, amj.am.cm, floorMeta, dx, floorLevel, dz, sbb);
            }
        }
        ++floorLevel;
        int dx = 6;
        for (int dz = 3; dz <= 11; ++dz) {
            this.a(world, amj.bc.cm, 0, dx, floorLevel, dz, sbb);
        }
        ++dx;
        for (int dz = 3; dz <= 11; ++dz) {
            this.a(world, 0, 0, dx, floorLevel, dz, sbb);
        }
        ++dx;
        for (int dz = 3; dz <= 11; ++dz) {
            this.a(world, amj.bc.cm, 0, dx, floorLevel, dz, sbb);
        }
        this.a(world, amj.am.cm, floorMeta, 6, floorLevel - 1, 11, sbb);
        this.a(world, amj.am.cm, floorMeta, 8, floorLevel - 1, 3, sbb);
        this.a(world, amj.bc.cm, 0, 5, floorLevel, 11, sbb);
        this.a(world, amj.bc.cm, 0, 9, floorLevel, 3, sbb);
        String mobID = "Skeleton";
        switch (rand.nextInt(4)) {
            case 0:
            case 1: {
                mobID = "Skeleton";
                break;
            }
            case 2: {
                mobID = "Zombie";
                break;
            }
            case 3: {
                mobID = TFCreatures.getSpawnerNameFor("Swarm Spider");
                break;
            }
        }
        this.placeSpawnerAtCurrentPosition(world, rand, 7, floorLevel + 2, 7, mobID, sbb);
        this.a(world, amj.bc.cm, 0, 6, floorLevel + 1, 7, sbb);
        this.a(world, amj.bc.cm, 0, 8, floorLevel + 1, 7, sbb);
        this.a(world, amj.bc.cm, 0, 6, floorLevel + 2, 7, sbb);
        this.a(world, amj.bc.cm, 0, 8, floorLevel + 2, 7, sbb);
        this.setCoordBaseMode(temp);
    }
    
    protected void makeLichRoom(final xv world, final Random rand, final acg sbb) {
        final int floorLevel = 2 + this.highestOpening / 5 * 5;
        this.makeLichFloor(world, floorLevel, this.highestOpening / 5 % 2, sbb);
        this.decorateLichChandelier(world, floorLevel, sbb);
        this.decoratePaintings(world, rand, floorLevel, sbb);
        this.decorateTorches(world, rand, floorLevel, sbb);
        this.a(world, TFBlocks.bossSpawner.cm, 1, this.size / 2, floorLevel + 2, this.size / 2, sbb);
    }
    
    protected void makeTowerPaintings(final xv world, final Random rand, final acg sbb) {
        final int howMany = 10;
        this.generatePaintingsOnWall(world, rand, howMany, 0, 0, 48, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, 0, 0, 32, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, 0, 0, 0, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, 0, 1, 48, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, 0, 1, 32, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, 0, 1, 0, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, 0, 2, 48, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, 0, 2, 32, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, 0, 2, 0, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, 0, 3, 48, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, 0, 3, 32, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, 0, 3, 0, sbb);
    }
    
    protected void makeLichFloor(final xv world, final int floorLevel, final int rotation, final acg sbb) {
        final int temp = this.getCoordBaseMode();
        this.setCoordBaseMode((this.getCoordBaseMode() + rotation) % 4);
        for (int fx = 1; fx < 14; ++fx) {
            for (int fz = 1; fz < 14; ++fz) {
                if ((fx == 1 || fx == 2) && fz >= 6 && fz <= 12) {
                    if (fz == 6) {
                        this.a(world, amj.bR.cm, 10, fx, floorLevel, fz, sbb);
                    }
                }
                else if ((fx == 12 || fx == 13) && fz >= 3 && fz <= 8) {
                    if (fz == 8) {
                        this.a(world, amj.bR.cm, 10, fx, floorLevel, fz, sbb);
                    }
                }
                else if (fx >= 4 && fx <= 10 && fz >= 4 && fz <= 10) {
                    if ((fx == 4 && fz == 4) || (fx == 10 && fz == 10)) {
                        this.a(world, amj.A.cm, 2, fx, floorLevel, fz, sbb);
                    }
                    else {
                        this.a(world, amj.P.cm, 0, fx, floorLevel, fz, sbb);
                    }
                }
                else if ((fx == 2 || fx == 3) && (fz == 2 || fz == 3)) {
                    this.a(world, amj.P.cm, 0, fx, floorLevel, fz, sbb);
                }
                else if ((fx == 11 || fx == 12) && (fz == 11 || fz == 12)) {
                    this.a(world, amj.P.cm, 0, fx, floorLevel, fz, sbb);
                }
                else {
                    this.a(world, amj.A.cm, 2, fx, floorLevel, fz, sbb);
                }
            }
        }
        this.a(world, 0, 0, 3, floorLevel + 1, 11, sbb);
        this.a(world, 0, 0, 3, floorLevel + 1, 10, sbb);
        this.a(world, 0, 0, 3, floorLevel + 2, 11, sbb);
        this.a(world, 0, 0, 11, floorLevel + 1, 3, sbb);
        this.a(world, 0, 0, 11, floorLevel + 1, 4, sbb);
        this.a(world, 0, 0, 11, floorLevel + 2, 3, sbb);
        this.setCoordBaseMode(temp);
    }
    
    protected void decorateLichChandelier(final xv world, final int floorLevel, final acg sbb) {
        final int cx = this.size / 2;
        int cy = floorLevel + 4;
        final int cz = this.size / 2;
        this.a(world, amj.bc.cm, 0, cx + 1, cy, cz + 0, sbb);
        this.a(world, amj.bc.cm, 0, cx + 2, cy, cz + 0, sbb);
        this.a(world, amj.bc.cm, 0, cx + 1, cy, cz + 1, sbb);
        this.a(world, amj.bc.cm, 0, cx + 0, cy, cz + 1, sbb);
        this.a(world, amj.bc.cm, 0, cx + 0, cy, cz + 2, sbb);
        this.a(world, amj.bc.cm, 0, cx - 1, cy, cz + 1, sbb);
        this.a(world, amj.bc.cm, 0, cx - 1, cy, cz + 0, sbb);
        this.a(world, amj.bc.cm, 0, cx - 2, cy, cz + 0, sbb);
        this.a(world, amj.bc.cm, 0, cx - 1, cy, cz - 1, sbb);
        this.a(world, amj.bc.cm, 0, cx + 0, cy, cz - 1, sbb);
        this.a(world, amj.bc.cm, 0, cx + 0, cy, cz - 2, sbb);
        this.a(world, amj.bc.cm, 0, cx + 1, cy, cz - 1, sbb);
        ++cy;
        this.a(world, amj.bc.cm, 0, cx + 1, cy, cz + 0, sbb);
        this.a(world, amj.at.cm, 0, cx + 2, cy, cz + 0, sbb);
        this.a(world, amj.at.cm, 0, cx + 1, cy, cz + 1, sbb);
        this.a(world, amj.bc.cm, 0, cx + 0, cy, cz + 1, sbb);
        this.a(world, amj.at.cm, 0, cx + 0, cy, cz + 2, sbb);
        this.a(world, amj.at.cm, 0, cx - 1, cy, cz + 1, sbb);
        this.a(world, amj.bc.cm, 0, cx - 1, cy, cz + 0, sbb);
        this.a(world, amj.at.cm, 0, cx - 2, cy, cz + 0, sbb);
        this.a(world, amj.at.cm, 0, cx - 1, cy, cz - 1, sbb);
        this.a(world, amj.bc.cm, 0, cx + 0, cy, cz - 1, sbb);
        this.a(world, amj.at.cm, 0, cx + 0, cy, cz - 2, sbb);
        this.a(world, amj.at.cm, 0, cx + 1, cy, cz - 1, sbb);
        ++cy;
        this.a(world, amj.at.cm, 0, cx + 1, cy, cz + 0, sbb);
        this.a(world, amj.at.cm, 0, cx + 0, cy, cz + 1, sbb);
        this.a(world, amj.at.cm, 0, cx - 1, cy, cz + 0, sbb);
        this.a(world, amj.at.cm, 0, cx + 0, cy, cz - 1, sbb);
        for (int y = floorLevel + 5; y < this.height - 1; ++y) {
            this.a(world, amj.bc.cm, 0, cx + 0, y, cz + 0, sbb);
        }
    }
    
    protected void decoratePaintings(final xv world, final Random rand, final int floorLevel, final acg sbb) {
        final int howMany = 100;
        this.generatePaintingsOnWall(world, rand, howMany, floorLevel, 0, 48, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, floorLevel, 0, 32, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, floorLevel, 0, 0, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, floorLevel, 1, 48, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, floorLevel, 1, 32, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, floorLevel, 1, 0, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, floorLevel, 2, 48, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, floorLevel, 2, 32, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, floorLevel, 2, 0, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, floorLevel, 3, 48, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, floorLevel, 3, 32, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, floorLevel, 3, 0, sbb);
    }
    
    protected void decorateTorches(final xv world, final Random rand, final int floorLevel, final acg sbb) {
        this.generateTorchesOnWall(world, rand, floorLevel, 0, sbb);
        this.generateTorchesOnWall(world, rand, floorLevel, 1, sbb);
        this.generateTorchesOnWall(world, rand, floorLevel, 2, sbb);
        this.generateTorchesOnWall(world, rand, floorLevel, 3, sbb);
    }
    
    protected void generateTorchesOnWall(final xv world, final Random rand, final int floorLevel, final int direction, final acg sbb) {
        for (int i = 0; i < 10; ++i) {
            final s wCoords = this.getRandomWallSpot(rand, floorLevel, direction, sbb);
            final s tCoords = new s(wCoords);
            if (direction == 0) {
                final s s = tCoords;
                ++s.c;
            }
            if (direction == 1) {
                final s s2 = tCoords;
                --s2.a;
            }
            if (direction == 2) {
                final s s3 = tCoords;
                --s3.c;
            }
            if (direction == 3) {
                final s s4 = tCoords;
                ++s4.a;
            }
            final anw torchBox = anw.a((double)tCoords.a, (double)tCoords.b, (double)tCoords.c, tCoords.a + 1.0, tCoords.b + 2.0, tCoords.c + 1.0);
            if (world.a(tCoords.a, tCoords.b, tCoords.c) == 0 && world.a(tCoords.a, tCoords.b + 1, tCoords.c) == 0 && world.b((lq)null, torchBox).size() == 0) {
                world.b(tCoords.a, tCoords.b, tCoords.c, amj.bc.cm);
                world.b(tCoords.a, tCoords.b + 1, tCoords.c, amj.at.cm);
                world.d(tCoords.a, tCoords.b + 1, tCoords.c, 5);
            }
        }
    }
    
    protected void generatePaintingsOnWall(final xv world, final Random rand, final int howMany, final int floorLevel, final int direction, final int minSize, final acg sbb) {
        for (int i = 0; i < howMany; ++i) {
            final s pCoords = this.getRandomWallSpot(rand, floorLevel, direction, sbb);
            final mg painting = new mg(world, pCoords.a, pCoords.b, pCoords.c, direction);
            painting.e = this.getPaintingOfSize(rand, minSize);
            painting.a(direction);
            if (this.checkPainting(world, painting, sbb)) {
                world.d((lq)painting);
            }
        }
    }
    
    protected mh getPaintingOfSize(final Random rand, final int minSize) {
        final ArrayList valid = new ArrayList();
        for (final mh art : mh.values()) {
            if (art.C >= minSize || art.D >= minSize) {
                valid.add(art);
            }
        }
        if (valid.size() > 0) {
            return valid.get(rand.nextInt(valid.size()));
        }
        return null;
    }
    
    protected boolean checkPainting(final xv world, final mg painting, final acg sbb) {
        if (painting == null) {
            return false;
        }
        anw largerBox;
        if (painting.a == 0 || painting.a == 2) {
            largerBox = painting.D.b(1.0, 1.0, 0.06);
        }
        else {
            largerBox = painting.D.b(0.06, 1.0, 1.0);
        }
        if (world.a((lq)painting, largerBox).size() > 0) {
            return false;
        }
        final List collidingEntities = world.b((lq)painting, largerBox);
        for (final lq entityOnList : collidingEntities) {
            if (entityOnList instanceof mb) {
                return false;
            }
        }
        return true;
    }
    
    protected s getRandomWallSpot(final Random rand, final int floorLevel, final int direction, final acg sbb) {
        int minX = this.e.a + 2;
        int maxX = this.e.d - 2;
        final int minY = this.e.b + floorLevel + 2;
        final int maxY = this.e.e - 2;
        int minZ = this.e.c + 2;
        int maxZ = this.e.f - 2;
        if (direction == 0) {
            minZ = this.e.c;
            maxZ = this.e.c;
        }
        if (direction == 1) {
            maxX = this.e.d;
            minX = this.e.d;
        }
        if (direction == 2) {
            maxZ = this.e.f;
            minZ = this.e.f;
        }
        if (direction == 3) {
            minX = this.e.a;
            maxX = this.e.a;
        }
        for (int i = 0; i < 30; ++i) {
            final int cx = minX + ((maxX > minX) ? rand.nextInt(maxX - minX) : 0);
            final int cy = minY + ((maxY > minY) ? rand.nextInt(maxY - minY) : 0);
            final int cz = minZ + ((maxZ > minZ) ? rand.nextInt(maxZ - minZ) : 0);
            if (sbb.b(cx, cy, cz)) {
                return new s(cx, cy, cz);
            }
        }
        return null;
    }
}
