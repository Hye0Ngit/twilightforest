import java.util.Iterator;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ComponentTFTowerWing extends StructureTFComponent
{
    int size;
    int height;
    Class roofType;
    ArrayList openings;
    int highestOpening;
    boolean[] openingTowards;
    
    protected ComponentTFTowerWing(final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final int direction) {
        super(i);
        this.openings = new ArrayList();
        this.size = pSize;
        this.height = pHeight;
        this.f = direction;
        this.highestOpening = 0;
        this.openingTowards = new boolean[] { false, false, true, false };
        this.e = StructureTFComponent.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1, direction);
    }
    
    public void a(final nk parent, final List list, final Random rand) {
        this.addOpening(0, 1, this.size / 2, 2);
        this.makeARoof(parent, list, rand);
        this.makeABeard(parent, list, rand);
        if (this.size > 4) {
            for (int i = 0; i < 4; ++i) {
                if (i != 2) {
                    final int[] dest = this.getValidOpening(rand, i);
                    if (!this.makeTowerWing(list, rand, 1, dest[0], dest[1], dest[2], this.size - 2, this.height - 6, i) && this.size > 8) {
                        this.makeTowerWing(list, rand, 1, dest[0], dest[1], dest[2], this.size - 6, this.height - 18, i);
                    }
                }
            }
        }
    }
    
    public boolean makeTowerWing(final List list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final int rotation) {
        if (wingHeight < 6) {
            return false;
        }
        final int direction = (this.f + rotation) % 4;
        final int[] dx = this.offsetTowerCoords(x, y, z, wingSize, direction);
        if (rand.nextInt(6) == 0) {
            return this.makeBridge(list, rand, index, x, y, z, wingSize, wingHeight, rotation);
        }
        final ComponentTFTowerWing wing = new ComponentTFTowerWing(index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        final nk intersect = nk.a(list, wing.e);
        if (intersect == null || intersect == this) {
            list.add(wing);
            wing.a(this, list, rand);
            this.addOpening(x, y, z, rotation);
            return true;
        }
        return false;
    }
    
    protected boolean makeBridge(final List list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final int rotation) {
        final int direction = (this.f + rotation) % 4;
        final int[] dx = this.offsetTowerCoords(x, y, z, 3, direction);
        final ComponentTFTowerBridge bridge = new ComponentTFTowerBridge(index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        nk intersect = nk.a(list, bridge.e);
        if (intersect != null && intersect != this) {
            return false;
        }
        intersect = nk.a(list, bridge.getWingBB());
        if (intersect == null || intersect == this) {
            list.add(bridge);
            bridge.a(this, list, rand);
            this.addOpening(x, y, z, rotation);
            return true;
        }
        return false;
    }
    
    public void addOpening(final int dx, final int dy, final int dz, final int direction) {
        this.openingTowards[direction] = true;
        if (dy > this.highestOpening) {
            this.highestOpening = dy;
        }
        this.openings.add(new dh(dx, dy, dz));
    }
    
    public void makeABeard(final nk parent, final List list, final Random rand) {
        final int index = this.b();
        final ComponentTFTowerBeard beard = new ComponentTFTowerBeard(index + 1, this);
        list.add(beard);
        beard.a((nk)this, list, rand);
    }
    
    public void makeARoof(final nk parent, final List list, final Random rand) {
        final boolean attached = parent.e.e > this.e.e;
        if (attached) {
            this.makeAttachedRoof(list, rand);
        }
        else {
            this.makeFreestandingRoof(list, rand);
        }
    }
    
    protected void makeAttachedRoof(final List list, final Random rand) {
        final int index = this.b();
        if (this.roofType == null && rand.nextInt(32) != 0) {
            this.tryToFitRoof(list, rand, new ComponentTFTowerRoofGableForwards(index + 1, this));
        }
        if (this.roofType == null && rand.nextInt(8) != 0) {
            this.tryToFitRoof(list, rand, new ComponentTFTowerRoofSlabForwards(index + 1, this));
        }
        if (this.roofType == null && rand.nextInt(32) != 0) {
            final ComponentTFTowerRoof roof = new ComponentTFTowerRoofAttachedSlab(index + 1, this);
            this.tryToFitRoof(list, rand, roof);
        }
        if (this.roofType == null) {
            final ComponentTFTowerRoof roof = new ComponentTFTowerRoofFence(index + 1, this);
            this.tryToFitRoof(list, rand, roof);
        }
    }
    
    protected void tryToFitRoof(final List list, final Random rand, final ComponentTFTowerRoof roof) {
        if (roof.fits(this, list, rand)) {
            list.add(roof);
            roof.a((nk)this, list, rand);
            this.roofType = roof.getClass();
        }
    }
    
    protected void makeFreestandingRoof(final List list, final Random rand) {
        final int index = this.b();
        if (this.roofType == null && rand.nextInt(8) != 0) {
            final ComponentTFTowerRoof roof = new ComponentTFTowerRoofPointyOverhang(index + 1, this);
            this.tryToFitRoof(list, rand, roof);
        }
        if (this.roofType == null) {
            final ComponentTFTowerRoof roof = new ComponentTFTowerRoofStairsOverhang(index + 1, this);
            this.tryToFitRoof(list, rand, roof);
        }
        if (this.roofType == null) {
            final ComponentTFTowerRoof roof = new ComponentTFTowerRoofStairs(index + 1, this);
            this.tryToFitRoof(list, rand, roof);
        }
        if (this.roofType == null && rand.nextInt(53) != 0) {
            final ComponentTFTowerRoof roof = new ComponentTFTowerRoofSlab(index + 1, this);
            this.tryToFitRoof(list, rand, roof);
        }
        if (this.roofType == null) {
            final ComponentTFTowerRoof roof = new ComponentTFTowerRoofFence(index + 1, this);
            this.tryToFitRoof(list, rand, roof);
        }
    }
    
    public boolean a(final ry world, final Random rand, final nl sbb) {
        this.a(world, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1, false, rand, (ox)tc.b());
        if (this.highestOpening > 1) {
            this.makeStairs(world, rand, sbb);
        }
        this.decorateThisTower(world, rand, sbb);
        this.makeWindows(world, rand, sbb);
        this.makeOpenings(world, sbb);
        return true;
    }
    
    protected void makeOpeningMarkers(final ry world, final Random rand, final int numMarkers, final nl sbb) {
        if (this.size > 4) {
            for (int i = 0; i < numMarkers; ++i) {
                final int[] spot = this.getValidOpening(rand, 0);
                this.a(world, yy.ab.bM, 0, spot[0], spot[1], spot[2], sbb);
            }
            for (int i = 0; i < numMarkers; ++i) {
                final int[] spot = this.getValidOpening(rand, 1);
                this.a(world, yy.ab.bM, 1, spot[0], spot[1], spot[2], sbb);
            }
            for (int i = 0; i < numMarkers; ++i) {
                final int[] spot = this.getValidOpening(rand, 2);
                this.a(world, yy.ab.bM, 2, spot[0], spot[1], spot[2], sbb);
            }
            for (int i = 0; i < numMarkers; ++i) {
                final int[] spot = this.getValidOpening(rand, 3);
                this.a(world, yy.ab.bM, 3, spot[0], spot[1], spot[2], sbb);
            }
        }
    }
    
    protected void decorateThisTower(final ry world, final Random rand, final nl sbb) {
        final Random decoRNG = new Random(world.t() + this.e.a * 321534781 * (this.e.c * 756839));
        if (this.size > 3) {
            if (this.isDeadEnd()) {
                this.decorateDeadEnd(world, decoRNG, sbb);
            }
            else {
                this.decorateStairTower(world, decoRNG, sbb);
            }
        }
    }
    
    protected void decorateDeadEnd(final ry world, final Random rand, final nl sbb) {
        final int floors = (this.height - 1) / 5;
        final int floorHeight = this.height / floors;
        for (int i = 1; i < floors; ++i) {
            for (int x = 1; x < this.size - 1; ++x) {
                for (int z = 1; z < this.size - 1; ++z) {
                    this.a(world, yy.x.bM, 0, x, i * floorHeight, z, sbb);
                }
            }
        }
        if (floors > 1) {
            int ladderDir = 3;
            int downLadderDir = -1;
            this.decorateFloor(world, rand, 0, 1, floorHeight, ladderDir, -1, sbb);
            for (int j = 1; j < floors - 1; ++j) {
                final int bottom = 1 + floorHeight * j;
                final int top = floorHeight * (j + 1);
                downLadderDir = ladderDir;
                ladderDir = ++ladderDir % 4;
                this.decorateFloor(world, rand, j, bottom, top, ladderDir, downLadderDir, sbb);
            }
            this.decorateFloor(world, rand, floors, 1 + floorHeight * (floors - 1), this.height - 1, -1, ladderDir, sbb);
        }
        else {
            this.decorateFloor(world, rand, 0, 1, this.height - 1, -1, -1, sbb);
        }
    }
    
    protected void decorateFloor(final ry world, final Random rand, final int floor, final int bottom, final int top, final int ladderUpDir, final int ladderDownDir, final nl sbb) {
        if (ladderUpDir > -1) {
            final int meta = this.getLadderMeta(ladderUpDir);
            final int dx = this.getLadderX(ladderUpDir);
            final int dz = this.getLadderZ(ladderUpDir);
            for (int dy = bottom; dy < top; ++dy) {
                this.a(world, yy.aF.bM, meta, dx, dy, dz, sbb);
            }
        }
        if (ladderDownDir > -1) {
            final int meta = this.getLadderMeta(ladderDownDir);
            final int dx = this.getLadderX(ladderDownDir);
            final int dz = this.getLadderZ(ladderDownDir);
            for (int dy = bottom - 1; dy < bottom + 2; ++dy) {
                this.a(world, yy.aF.bM, meta, dx, dy, dz, sbb);
            }
        }
        if (rand.nextInt(7) == 0 && ladderDownDir == -1) {
            this.decorateWell(world, rand, bottom, top, ladderUpDir, ladderDownDir, sbb);
        }
        else if (rand.nextInt(7) == 0 && ladderDownDir == -1) {
            this.decorateSkeletonRoom(world, rand, bottom, top, ladderUpDir, ladderDownDir, sbb);
        }
        else if (rand.nextInt(6) == 0 && ladderDownDir == -1) {
            this.decorateZombieRoom(world, rand, bottom, top, ladderUpDir, ladderDownDir, sbb);
        }
        else if (rand.nextInt(5) == 0 && ladderDownDir == -1) {
            this.decorateCactusRoom(world, rand, bottom, top, ladderUpDir, ladderDownDir, sbb);
        }
        else if (rand.nextInt(4) == 0 && ladderDownDir > -1) {
            this.decorateTreasureChest(world, rand, bottom, top, ladderUpDir, ladderDownDir, sbb);
        }
        else if (rand.nextInt(5) == 0) {
            this.decorateSpiderWebs(world, rand, bottom, top, ladderUpDir, ladderDownDir, sbb);
        }
        else if (rand.nextInt(12) == 0 && ladderDownDir > -1) {
            this.decorateSolidRock(world, rand, bottom, top, ladderUpDir, ladderDownDir, sbb);
        }
        else if (rand.nextInt(3) == 0) {
            this.decorateFullLibrary(world, rand, bottom, top, ladderUpDir, ladderDownDir, sbb);
        }
        else {
            this.decorateLibrary(world, rand, bottom, top, ladderUpDir, ladderDownDir, sbb);
        }
    }
    
    protected void decorateWell(final ry world, final Random rand, final int bottom, final int top, final int ladderUpDir, final int ladderDownDir, final nl sbb) {
        final int cz;
        final int cx = cz = this.size / 2;
        final int cy = bottom;
        final int waterOrLava = (rand.nextInt(4) == 0) ? yy.D.bM : yy.B.bM;
        if (this.size > 5) {
            this.a(world, yy.bm.bM, 0, cx - 1, cy + 0, cz - 1, sbb);
            this.a(world, yy.ak.bM, 5, cx - 1, cy + 1, cz - 1, sbb);
            this.a(world, yy.bm.bM, 0, cx + 0, cy + 0, cz - 1, sbb);
            this.a(world, yy.bm.bM, 0, cx + 1, cy + 0, cz - 1, sbb);
            this.a(world, yy.ak.bM, 5, cx + 1, cy + 1, cz - 1, sbb);
            this.a(world, yy.bm.bM, 0, cx - 1, cy + 0, cz + 0, sbb);
            this.a(world, waterOrLava, 0, cx + 0, cy + 0, cz + 0, sbb);
            this.a(world, yy.bm.bM, 0, cx + 1, cy + 0, cz + 0, sbb);
            this.a(world, yy.bm.bM, 0, cx - 1, cy + 0, cz + 1, sbb);
            this.a(world, yy.ak.bM, 5, cx - 1, cy + 1, cz + 1, sbb);
            this.a(world, yy.bm.bM, 0, cx + 0, cy + 0, cz + 1, sbb);
            this.a(world, yy.bm.bM, 0, cx + 1, cy + 0, cz + 1, sbb);
            this.a(world, yy.ak.bM, 5, cx + 1, cy + 1, cz + 1, sbb);
        }
        this.a(world, waterOrLava, 0, cx + 0, cy - 1, cz + 0, sbb);
    }
    
    protected void decorateSkeletonRoom(final ry world, final Random rand, final int bottom, final int top, final int ladderUpDir, final int ladderDownDir, final nl sbb) {
        this.placeSpawnerAtCurrentPosition(world, rand, this.size / 2, bottom + 2, this.size / 2, "Skeleton", sbb);
        final ArrayList chainList = new ArrayList();
        chainList.add(new dh(this.size / 2, bottom + 2, this.size / 2));
        for (int i = 0; i < this.size + 2; ++i) {
            final dh chain = new dh(2 + rand.nextInt(this.size - 4), this.height - 2, 2 + rand.nextInt(this.size - 4));
            if (!this.chainCollides(chain, chainList)) {
                for (int dy = bottom; dy < top; ++dy) {
                    this.a(world, yy.bp.bM, 0, chain.a, dy, chain.c, sbb);
                }
                chainList.add(chain);
            }
        }
        for (int dx = 1; dx <= this.size - 2; ++dx) {
            for (int dz = 1; dz <= this.size - 2; ++dz) {
                if ((dx == 1 || dx == this.size - 2 || dz == 1 || dz == this.size - 2) && !this.isWindowPos(dx, dz) && !this.isLadderPos(dx, dz, ladderUpDir, ladderDownDir)) {
                    this.a(world, yy.W.bM, 0, dx, top - 1, dz, sbb);
                }
            }
        }
    }
    
    protected void decorateZombieRoom(final ry world, final Random rand, final int bottom, final int top, final int ladderUpDir, final int ladderDownDir, final nl sbb) {
        this.placeSpawnerAtCurrentPosition(world, rand, this.size / 2, bottom + 2, this.size / 2, "Zombie", sbb);
        for (int dx = 1; dx <= this.size - 2; ++dx) {
            for (int dz = 1; dz <= this.size - 2; ++dz) {
                if (!this.isWindowPos(dx, dz) && !this.isLadderPos(dx, dz, ladderUpDir, ladderDownDir) && rand.nextInt(5) == 0) {
                    this.a(world, yy.af.bM, 0, dx, bottom, dz, sbb);
                }
            }
        }
        final ArrayList slabList = new ArrayList();
        slabList.add(new dh(this.size / 2, bottom + 2, this.size / 2));
        for (int i = 0; i < this.size - 1; ++i) {
            final dh slab = new dh(2 + rand.nextInt(this.size - 4), this.height - 2, 2 + rand.nextInt(this.size - 4));
            if (!this.chainCollides(slab, slabList)) {
                this.a(world, yy.bp.bM, 0, slab.a, bottom + 0, slab.c, sbb);
                this.a(world, yy.ak.bM, 2, slab.a, bottom + 1, slab.c, sbb);
                this.a(world, yy.bc.bM, 0, slab.a, bottom + 2, slab.c, sbb);
                slabList.add(slab);
            }
        }
    }
    
    protected void decorateCactusRoom(final ry world, final Random rand, final int bottom, final int top, final int ladderUpDir, final int ladderDownDir, final nl sbb) {
        for (int dx = 1; dx <= this.size - 2; ++dx) {
            for (int dz = 1; dz <= this.size - 2; ++dz) {
                this.a(world, yy.E.bM, 0, dx, bottom - 1, dz, sbb);
                if (!this.isWindowPos(dx, dz) && !this.isLadderPos(dx, dz, ladderUpDir, ladderDownDir) && rand.nextInt(4) == 0) {
                    this.a(world, yy.Y.bM, 0, dx, bottom, dz, sbb);
                }
            }
        }
        final ArrayList cactusList = new ArrayList();
        cactusList.add(new dh(this.size / 2, bottom + 2, this.size / 2));
        for (int i = 0; i < this.size + 2; ++i) {
            final dh cactus = new dh(2 + rand.nextInt(this.size - 4), this.height - 2, 2 + rand.nextInt(this.size - 4));
            if (!this.chainCollides(cactus, cactusList)) {
                for (int dy = bottom; dy < top; ++dy) {
                    this.a(world, yy.aV.bM, 0, cactus.a, dy, cactus.c, sbb);
                }
                cactusList.add(cactus);
            }
        }
    }
    
    protected void decorateTreasureChest(final ry world, final Random rand, final int bottom, final int top, final int ladderUpDir, final int ladderDownDir, final nl sbb) {
        final int cz;
        final int cx = cz = this.size / 2;
        final int cy = bottom;
        final int waterOrLava = (rand.nextInt(4) == 0) ? yy.D.bM : yy.B.bM;
        this.a(world, yy.ak.bM, 5, cx - 1, cy + 0, cz - 1, sbb);
        this.a(world, yy.bm.bM, 0, cx + 0, cy + 0, cz - 1, sbb);
        this.a(world, yy.ak.bM, 5, cx + 1, cy + 0, cz - 1, sbb);
        this.a(world, yy.bm.bM, 0, cx - 1, cy + 0, cz + 0, sbb);
        this.a(world, yy.bm.bM, 0, cx + 0, cy + 0, cz + 0, sbb);
        this.a(world, yy.bm.bM, 0, cx + 1, cy + 0, cz + 0, sbb);
        this.a(world, yy.ak.bM, 5, cx - 1, cy + 0, cz + 1, sbb);
        this.a(world, yy.bm.bM, 0, cx + 0, cy + 0, cz + 1, sbb);
        this.a(world, yy.ak.bM, 5, cx + 1, cy + 0, cz + 1, sbb);
        this.placeTreasureAtCurrentPosition(world, rand, cx + 0, cy + 1, cz + 0, TFTreasure.tower_room, sbb);
        for (int i = 0; i < 4; ++i) {}
    }
    
    protected void decorateSpiderWebs(final ry world, final Random rand, final int bottom, final int top, final int ladderUpDir, final int ladderDownDir, final nl sbb) {
        for (int dy = bottom; dy < top; ++dy) {
            final int chance = top - dy + 2;
            for (int dx = 1; dx <= this.size - 2; ++dx) {
                for (int dz = 1; dz <= this.size - 2; ++dz) {
                    if (!this.isLadderPos(dx, dz, ladderUpDir, ladderDownDir) && rand.nextInt(chance) == 0) {
                        this.a(world, yy.W.bM, 0, dx, dy, dz, sbb);
                    }
                }
            }
        }
        if (rand.nextInt(5) == 0) {
            String spiderName = null;
            switch (rand.nextInt(4)) {
                case 3: {
                    spiderName = "CaveSpider";
                    break;
                }
                case 2: {
                    spiderName = "Swarm Spider";
                    break;
                }
                case 1: {
                    spiderName = "Hedge Spider";
                    break;
                }
                default: {
                    spiderName = "Spider";
                    break;
                }
            }
            this.placeSpawnerAtCurrentPosition(world, rand, this.size / 2, bottom + 2, this.size / 2, spiderName, sbb);
        }
    }
    
    protected void decorateSolidRock(final ry world, final Random rand, final int bottom, final int top, final int ladderUpDir, final int ladderDownDir, final nl sbb) {
        for (int dy = bottom; dy < top; ++dy) {
            for (int dx = 1; dx <= this.size - 2; ++dx) {
                for (int dz = 1; dz <= this.size - 2; ++dz) {
                    if (!this.isLadderPos(dx, dz, ladderUpDir, ladderDownDir) && rand.nextInt(9) != 0) {
                        this.a(world, yy.t.bM, 0, dx, dy, dz, sbb);
                    }
                }
            }
        }
    }
    
    protected void decorateLibrary(final ry world, final Random rand, final int bottom, final int top, final int ladderUpDir, final int ladderDownDir, final nl sbb) {
        for (int dx = 1; dx <= this.size - 2; ++dx) {
            for (int dz = 1; dz <= this.size - 2; ++dz) {
                for (int dy = bottom; dy < top - 1; ++dy) {
                    if ((dx == 1 || dx == this.size - 2 || dz == 1 || dz == this.size - 2) && !this.isWindowPos(dx, dz) && !this.isLadderPos(dx, dz, ladderUpDir, ladderDownDir)) {
                        this.a(world, yy.an.bM, 0, dx, dy, dz, sbb);
                    }
                }
            }
        }
    }
    
    protected void decorateFullLibrary(final ry world, final Random rand, final int bottom, final int top, final int ladderUpDir, final int ladderDownDir, final nl sbb) {
        for (int dx = 1; dx <= this.size - 2; ++dx) {
            for (int dz = 1; dz <= this.size - 2; ++dz) {
                for (int dy = bottom; dy < top; ++dy) {
                    if (((dx % 2 != 0 && ((dz >= dx && dz <= this.size - dx - 1) || (dz >= this.size - dx - 1 && dz <= dx))) || (dz % 2 != 0 && ((dx >= dz && dx <= this.size - dz - 1) || (dx >= this.size - dz - 1 && dx <= dz)))) && !this.isWindowPos(dx, dy, dz) && !this.isOpeningPos(dx, dy, dz) && !this.isLadderPos(dx, dz, ladderUpDir, ladderDownDir)) {
                        this.a(world, yy.an.bM, 0, dx, dy, dz, sbb);
                    }
                }
            }
        }
    }
    
    protected boolean isWindowPos(final int x, final int z) {
        return (x == 1 && z == this.size / 2) || (x == this.size - 2 && z == this.size / 2) || (x == this.size / 2 && z == 1) || (x == this.size / 2 && z == this.size - 2);
    }
    
    protected boolean isWindowPos(final int x, final int y, final int z) {
        int checkYDir = -1;
        if (x == 1 && z == this.size / 2) {
            checkYDir = 2;
        }
        else if (x == this.size - 2 && z == this.size / 2) {
            checkYDir = 0;
        }
        else if (x == this.size / 2 && z == 1) {
            checkYDir = 3;
        }
        else if (x == this.size / 2 && z == this.size - 2) {
            checkYDir = 1;
        }
        return checkYDir > -1 && !this.openingTowards[checkYDir] && (y == 2 || y == 3 || (this.height > 8 && (y == this.height - 3 || y == this.height - 4)));
    }
    
    protected boolean isOpeningPos(final int x, final int y, final int z) {
        for (final dh door : this.openings) {
            final dh inside = new dh(door);
            if (inside.a == 0) {
                final dh dh = inside;
                ++dh.a;
            }
            else if (inside.a == this.size - 1) {
                final dh dh2 = inside;
                --dh2.a;
            }
            else if (inside.c == 0) {
                final dh dh3 = inside;
                ++dh3.c;
            }
            else if (inside.c == this.size - 1) {
                final dh dh4 = inside;
                --dh4.c;
            }
            if (inside.a == x && inside.c == z && (inside.b == y || inside.b + 1 == y)) {
                return true;
            }
        }
        return false;
    }
    
    protected boolean isLadderPos(final int x, final int z, final int ladderUpDir, final int ladderDownDir) {
        return (x == this.getLadderX(ladderUpDir) && z == this.getLadderZ(ladderUpDir)) || (x == this.getLadderX(ladderDownDir) && z == this.getLadderZ(ladderDownDir));
    }
    
    protected int getLadderX(final int ladderDir) {
        switch (ladderDir) {
            case 0: {
                return this.size - 2;
            }
            case 1: {
                return this.size / 2 + 1;
            }
            case 2: {
                return 1;
            }
            case 3: {
                return this.size / 2 - 1;
            }
            default: {
                return this.size / 2;
            }
        }
    }
    
    protected int getLadderZ(final int ladderDir) {
        switch (ladderDir) {
            case 0: {
                return this.size / 2 - 1;
            }
            case 1: {
                return this.size - 2;
            }
            case 2: {
                return this.size / 2 + 1;
            }
            case 3: {
                return 1;
            }
            default: {
                return this.size / 2;
            }
        }
    }
    
    protected int getLadderMeta(final int ladderDir) {
        switch ((this.f + ladderDir) % 4) {
            case 0: {
                return 4;
            }
            case 1: {
                return 2;
            }
            case 2: {
                return 5;
            }
            case 3: {
                return 3;
            }
            default: {
                return -1;
            }
        }
    }
    
    protected void decorateStairTower(final ry world, final Random rand, final nl sbb) {
        if (this.height - this.highestOpening > 13) {
            final int base = this.highestOpening + 3;
            final int floors = (this.height - base) / 5;
            final int floorHeight = (this.height - base) / floors;
            for (int i = 0; i < floors; ++i) {
                for (int x = 1; x < this.size - 1; ++x) {
                    for (int z = 1; z < this.size - 1; ++z) {
                        this.a(world, yy.x.bM, 0, x, i * floorHeight + base, z, sbb);
                    }
                }
            }
            int ladderDir = 3;
            int downLadderDir = -1;
            final int meta = this.getLadderMeta(ladderDir);
            final int dx = this.getLadderX(ladderDir);
            final int dz = this.getLadderZ(ladderDir);
            for (int dy = 1; dy < 3; ++dy) {
                this.a(world, yy.aF.bM, meta, dx, base - dy, dz, sbb);
            }
            for (int j = 0; j < floors - 1; ++j) {
                final int bottom = base + 1 + floorHeight * j;
                final int top = base + floorHeight * (j + 1);
                downLadderDir = ladderDir;
                ladderDir = ++ladderDir % 4;
                this.decorateFloor(world, rand, j, bottom, top, ladderDir, downLadderDir, sbb);
            }
            this.decorateFloor(world, rand, floors, base + 1 + floorHeight * (floors - 1), this.height - 1, -1, ladderDir, sbb);
        }
        else if (this.size > 5) {
            switch (rand.nextInt(5)) {
                case 0: {
                    this.decorateChandelier(world, rand, sbb);
                    break;
                }
                case 1: {
                    this.decorateHangingChains(world, rand, sbb);
                    break;
                }
                case 2: {
                    this.decorateFloatingBooks(world, rand, sbb);
                    break;
                }
                case 3: {
                    this.decorateFloatingVines(world, rand, sbb);
                    break;
                }
            }
        }
        if (this.size > 5) {
            if (rand.nextInt(4) == 0) {
                this.decorateStairWell(world, rand, sbb);
            }
            else if (rand.nextInt(3) != 0) {
                this.decoratePlanter(world, rand, sbb);
            }
        }
    }
    
    protected void decorateHangingChains(final ry world, final Random rand, final nl sbb) {
        final ArrayList chainList = new ArrayList();
        for (int i = 0; i < this.size + 2; ++i) {
            final int filled = (this.size < 15) ? 2 : 4;
            final dh chain = new dh(filled + rand.nextInt(this.size - filled * 2), this.height - 2, filled + rand.nextInt(this.size - filled * 2));
            if (!this.chainCollides(chain, chainList)) {
                final int length = 1 + rand.nextInt(this.height - this.highestOpening - 3);
                this.decorateOneChain(world, rand, chain.a, length, chain.c, sbb);
                chainList.add(chain);
            }
        }
    }
    
    protected boolean chainCollides(final dh coords, final List list) {
        for (final dh existing : list) {
            if (coords.c == existing.c && Math.abs(coords.a - existing.a) <= 1) {
                return true;
            }
            if (coords.a == existing.a && Math.abs(coords.c - existing.c) <= 1) {
                return true;
            }
        }
        return false;
    }
    
    protected void decorateOneChain(final ry world, final Random rand, final int dx, final int length, final int dz, final nl sbb) {
        for (int y = 1; y <= length; ++y) {
            this.a(world, yy.bp.bM, 0, dx, this.height - y - 1, dz, sbb);
        }
        int ballBlock = 0;
        int ballMeta = 0;
        switch (rand.nextInt(10)) {
            case 0: {
                ballBlock = yy.ai.bM;
                ballMeta = 0;
                break;
            }
            case 1: {
                ballBlock = yy.an.bM;
                ballMeta = 0;
                break;
            }
            case 2: {
                ballBlock = yy.bb.bM;
                ballMeta = 0;
                break;
            }
            case 3: {
                ballBlock = yy.bc.bM;
                ballMeta = 0;
                break;
            }
            case 4: {
                ballBlock = yy.M.bM;
                ballMeta = 0;
                break;
            }
            case 5: {
                ballBlock = yy.O.bM;
                ballMeta = 0;
                break;
            }
            case 6: {
                ballBlock = yy.bl.bM;
                ballMeta = 2;
                break;
            }
            default: {
                ballBlock = yy.bd.bM;
                ballMeta = 0;
                break;
            }
        }
        this.a(world, ballBlock, ballMeta, dx, this.height - length - 2, dz, sbb);
    }
    
    protected void decorateFloatingBooks(final ry world, final Random rand, final nl sbb) {
        final ArrayList shelfList = new ArrayList();
        for (int i = 0; i < this.size + 2; ++i) {
            final int filled = (this.size < 15) ? 2 : 4;
            final dh shelf = new dh(filled + rand.nextInt(this.size - filled * 2), this.height - 2, filled + rand.nextInt(this.size - filled * 2));
            if (!this.chainCollides(shelf, shelfList)) {
                int y;
                for (int bottom = 2 + rand.nextInt(this.height - this.highestOpening - 3), top = y = rand.nextInt(bottom - 1) + 2; y <= bottom; ++y) {
                    this.a(world, yy.an.bM, 0, shelf.a, this.height - y, shelf.c, sbb);
                }
                shelfList.add(shelf);
            }
        }
    }
    
    protected void decorateFloatingVines(final ry world, final Random rand, final nl sbb) {
        final ArrayList mossList = new ArrayList();
        for (int i = 0; i < this.size + 2; ++i) {
            final int filled = (this.size < 15) ? 2 : 4;
            final dh moss = new dh(filled + rand.nextInt(this.size - filled * 2), this.height - 2, filled + rand.nextInt(this.size - filled * 2));
            if (!this.chainCollides(moss, mossList)) {
                int y;
                for (int bottom = 2 + rand.nextInt(this.height - this.highestOpening - 3), top = y = rand.nextInt(bottom - 1) + 2; y <= bottom; ++y) {
                    this.a(world, yy.ao.bM, 0, moss.a, this.height - y, moss.c, sbb);
                    this.a(world, yy.bu.bM, this.getVineMeta(2), moss.a + 1, this.height - y, moss.c + 0, sbb);
                    this.a(world, yy.bu.bM, this.getVineMeta(0), moss.a - 1, this.height - y, moss.c + 0, sbb);
                    this.a(world, yy.bu.bM, this.getVineMeta(3), moss.a + 0, this.height - y, moss.c + 1, sbb);
                    this.a(world, yy.bu.bM, this.getVineMeta(1), moss.a + 0, this.height - y, moss.c - 1, sbb);
                }
                mossList.add(moss);
            }
        }
        for (int y2 = this.highestOpening + 3; y2 < this.height - 1; ++y2) {
            for (int x = 1; x < this.size - 1; ++x) {
                if (rand.nextInt(3) == 0) {
                    this.a(world, yy.bu.bM, this.getVineMeta(3), x, y2, 1, sbb);
                }
                if (rand.nextInt(3) == 0) {
                    this.a(world, yy.bu.bM, this.getVineMeta(1), x, y2, this.size - 2, sbb);
                }
            }
            for (int z = 1; z < this.size - 1; ++z) {
                if (rand.nextInt(3) == 0) {
                    this.a(world, yy.bu.bM, this.getVineMeta(2), 1, y2, z, sbb);
                }
                if (rand.nextInt(3) == 0) {
                    this.a(world, yy.bu.bM, this.getVineMeta(0), this.size - 2, y2, z, sbb);
                }
            }
        }
    }
    
    protected int getVineMeta(final int vineDir) {
        switch ((this.f + vineDir) % 4) {
            case 0: {
                return 8;
            }
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 4;
            }
            default: {
                return -1;
            }
        }
    }
    
    protected void decoratePlanter(final ry world, final Random rand, final nl sbb) {
        final int cz;
        final int cx = cz = this.size / 2;
        this.a(world, yy.ak.bM, 0, cx + 0, 1, cz + 1, sbb);
        this.a(world, yy.ak.bM, 0, cx + 0, 1, cz - 1, sbb);
        this.a(world, yy.ak.bM, 0, cx + 1, 1, cz + 0, sbb);
        this.a(world, yy.ak.bM, 0, cx - 1, 1, cz + 0, sbb);
        this.a(world, yy.u.bM, 0, cx + 0, 1, cz + 0, sbb);
        int planterBlock = 0;
        int planterMeta = 0;
        switch (rand.nextInt(8)) {
            case 0: {
                planterBlock = yy.X.bM;
                planterMeta = 0;
                break;
            }
            case 1: {
                planterBlock = yy.X.bM;
                planterMeta = 1;
                break;
            }
            case 2: {
                planterBlock = yy.X.bM;
                planterMeta = 2;
                break;
            }
            case 3: {
                planterBlock = yy.y.bM;
                planterMeta = 0;
                break;
            }
            case 4: {
                planterBlock = yy.y.bM;
                planterMeta = 1;
                break;
            }
            case 5: {
                planterBlock = yy.y.bM;
                planterMeta = 2;
                break;
            }
            case 6: {
                planterBlock = yy.af.bM;
                planterMeta = 0;
                break;
            }
            default: {
                planterBlock = yy.ag.bM;
                planterMeta = 0;
                break;
            }
        }
        this.a(world, planterBlock, planterMeta, cx + 0, 2, cz + 0, sbb);
        if (planterBlock == yy.y.bM) {
            final int wx = this.a(cx, cz);
            final int wy = this.b(2);
            final int wz = this.b(cx, cz);
            ((aet)yy.y).c(world, wx, wy, wz, world.w);
        }
        if (planterBlock == yy.af.bM || planterBlock == yy.ag.bM) {
            final int wx = this.a(cx, cz);
            final int wy = this.b(2);
            final int wz = this.b(cx, cz);
            ((js)yy.k[planterBlock]).c(world, wx, wy, wz, world.w);
        }
    }
    
    protected void decorateStairWell(final ry world, final Random rand, final nl sbb) {
        final int cz;
        final int cx = cz = this.size / 2;
        final int cy = 1;
        final int waterOrLava = (rand.nextInt(4) == 0) ? yy.D.bM : yy.B.bM;
        if (this.size > 7) {
            this.a(world, yy.bm.bM, 0, cx - 1, cy + 0, cz - 1, sbb);
            this.a(world, yy.ak.bM, 5, cx - 1, cy + 1, cz - 1, sbb);
            this.a(world, yy.bm.bM, 0, cx + 0, cy + 0, cz - 1, sbb);
            this.a(world, yy.bm.bM, 0, cx + 1, cy + 0, cz - 1, sbb);
            this.a(world, yy.ak.bM, 5, cx + 1, cy + 1, cz - 1, sbb);
            this.a(world, yy.bm.bM, 0, cx - 1, cy + 0, cz + 0, sbb);
            this.a(world, waterOrLava, 0, cx + 0, cy + 0, cz + 0, sbb);
            this.a(world, yy.bm.bM, 0, cx + 1, cy + 0, cz + 0, sbb);
            this.a(world, yy.bm.bM, 0, cx - 1, cy + 0, cz + 1, sbb);
            this.a(world, yy.ak.bM, 5, cx - 1, cy + 1, cz + 1, sbb);
            this.a(world, yy.bm.bM, 0, cx + 0, cy + 0, cz + 1, sbb);
            this.a(world, yy.bm.bM, 0, cx + 1, cy + 0, cz + 1, sbb);
            this.a(world, yy.ak.bM, 5, cx + 1, cy + 1, cz + 1, sbb);
        }
        this.a(world, waterOrLava, 0, cx + 0, cy - 1, cz + 0, sbb);
    }
    
    public boolean isDeadEnd() {
        return this.openings.size() == 1;
    }
    
    public boolean hasExitsOnAllWalls() {
        int exits = 0;
        for (int i = 0; i < 4; ++i) {
            exits += (this.openingTowards[i] ? 1 : 0);
        }
        return exits == 4;
    }
    
    public boolean hasStairs() {
        return this.highestOpening > 1;
    }
    
    protected void makeOpenings(final ry world, final nl sbb) {
        for (final dh door : this.openings) {
            this.makeDoorOpening(world, door.a, door.b, door.c, sbb);
        }
    }
    
    protected void makeDoorOpening(final ry world, final int dx, final int dy, final int dz, final nl sbb) {
        this.a(world, 0, 0, dx, dy + 0, dz, sbb);
        this.a(world, 0, 0, dx, dy + 1, dz, sbb);
        if (this.a(world, dx, dy + 2, dz, sbb) != 0) {
            this.a(world, yy.aj.bM, 0, dx, dy + 2, dz, sbb);
        }
    }
    
    public int[] getValidOpening(final Random rand, final int direction) {
        int wLength = this.size - 2;
        int offset = 1;
        if (this.size == 15) {
            wLength = 11;
            offset = 2;
        }
        if (direction == 0 || direction == 2) {
            final int rx = (direction == 0) ? (this.size - 1) : 0;
            final int rz = offset + rand.nextInt(wLength);
            final int ry = this.getYByStairs(rz, rand, direction);
            return new int[] { rx, ry, rz };
        }
        if (direction == 1 || direction == 3) {
            final int rx = offset + rand.nextInt(wLength);
            final int rz = (direction == 1) ? (this.size - 1) : 0;
            final int ry = this.getYByStairs(rx, rand, direction);
            return new int[] { rx, ry, rz };
        }
        return new int[] { 0, 0, 0 };
    }
    
    private int getYByStairs(final int rx, final Random rand, final int direction) {
        int rise = 1;
        int base = 0;
        if (this.size == 15) {
            rise = 10;
            base = ((direction == 0 || direction == 2) ? 23 : 28);
        }
        if (this.size == 9) {
            rise = 6;
            base = ((direction == 0 || direction == 2) ? 2 : 5);
        }
        if (this.size == 7) {
            rise = 4;
            base = ((direction == 0 || direction == 2) ? 2 : 4);
        }
        if (this.size == 5) {
            rise = 4;
            switch (direction) {
                case 0: {
                    base = 3;
                    break;
                }
                case 1: {
                    base = 2;
                    break;
                }
                case 2: {
                    base = 5;
                    break;
                }
                case 3: {
                    base = 4;
                    break;
                }
            }
        }
        final int flights = (this.height - 6 - base) / rise + 1;
        if (base > 0 && flights > 0) {
            final int flightChosen = rand.nextInt(flights);
            int dy = flightChosen * rise + base;
            if (this.size == 15) {
                dy -= ((direction == 0 || direction == 3) ? ((rx - 2) / 2) : ((this.size - rx - 3) / 2));
            }
            else {
                dy -= ((direction == 0 || direction == 3) ? ((rx - 1) / 2) : ((this.size - rx - 2) / 2));
            }
            if (dy < 1) {
                dy = 1;
            }
            return dy;
        }
        return 0;
    }
    
    protected void makeWindows(final ry world, final Random rand, final nl sbb) {
        for (int i = 0; i < 4; ++i) {
            if (!this.openingTowards[i]) {
                this.makeWindowBlock(world, this.size - 1, 2, this.size / 2, i, sbb);
                this.makeWindowBlock(world, this.size - 1, 3, this.size / 2, i, sbb);
                if (this.height > 8) {
                    this.makeWindowBlock(world, this.size - 1, this.height - 3, this.size / 2, i, sbb);
                    this.makeWindowBlock(world, this.size - 1, this.height - 4, this.size / 2, i, sbb);
                }
            }
        }
    }
    
    protected void makeWindowBlock(final ry world, final int x, final int y, final int z, final int rotation, final nl sbb) {
        final int temp = this.f;
        this.f = (this.f + rotation) % 4;
        final int outside = this.a(world, x + 1, y, z, sbb);
        final int inside = this.a(world, x - 1, y, z, sbb);
        if (inside == 0 && outside == 0) {
            this.a(world, yy.bq.bM, 0, x, y, z, sbb);
        }
        this.f = temp;
    }
    
    protected void decorateChandelier(final ry world, final Random rand, final nl sbb) {
        final int cx = this.size / 2;
        final int cy = this.highestOpening + 2 + rand.nextInt(this.height - this.highestOpening - 5);
        final int cz = this.size / 2;
        this.a(world, yy.aZ.bM, 0, cx + 0, cy + 0, cz + 0, sbb);
        this.a(world, yy.aZ.bM, 0, cx - 1, cy + 0, cz + 0, sbb);
        this.a(world, yy.aZ.bM, 0, cx + 1, cy + 0, cz + 0, sbb);
        this.a(world, yy.aZ.bM, 0, cx + 0, cy + 0, cz - 1, sbb);
        this.a(world, yy.aZ.bM, 0, cx + 0, cy + 0, cz + 1, sbb);
        this.a(world, yy.aZ.bM, 0, cx + 0, cy + 1, cz + 0, sbb);
        this.a(world, yy.aq.bM, 0, cx - 1, cy + 1, cz + 0, sbb);
        this.a(world, yy.aq.bM, 0, cx + 1, cy + 1, cz + 0, sbb);
        this.a(world, yy.aq.bM, 0, cx + 0, cy + 1, cz - 1, sbb);
        this.a(world, yy.aq.bM, 0, cx + 0, cy + 1, cz + 1, sbb);
        for (int y = cy; y < this.height - 1; ++y) {
            this.a(world, yy.aZ.bM, 0, cx + 0, y, cz + 0, sbb);
        }
    }
    
    protected boolean makeStairs(final ry world, final Random rand, final nl sbb) {
        if (this.size == 15) {
            return this.makeStairs15(world, rand, sbb);
        }
        if (this.size == 9) {
            return this.makeStairs9(world, rand, sbb);
        }
        if (this.size == 7) {
            return this.makeStairs7(world, rand, sbb);
        }
        return this.size == 5 && this.makeStairs5(world, rand, sbb);
    }
    
    protected boolean makeStairs5(final ry world, final Random rand, final nl sbb) {
        final int rise = 1;
        for (int numFlights = this.highestOpening / rise, i = 0; i < numFlights; ++i) {
            this.makeStairs5flight(world, rand, sbb, i * rise, 0 + i * 3, 2);
        }
        return true;
    }
    
    protected void makeStairs5flight(final ry world, final Random rand, final nl sbb, final int height, final int rotation, final int meta) {
        final int temp = this.f;
        this.f = (this.f + rotation) % 4;
        this.a(world, yy.ak.bM, meta, 2, 1 + height, 3, sbb);
        this.a(world, yy.aj.bM, meta, 3, 1 + height, 3, sbb);
        this.f = temp;
    }
    
    protected boolean makeStairs7(final ry world, final Random rand, final nl sbb) {
        this.a(world, yy.ak.bM, 2, 1, 1, 4, sbb);
        this.a(world, yy.aj.bM, 2, 1, 1, 5, sbb);
        this.a(world, yy.ak.bM, 0, 5, 1, 2, sbb);
        this.a(world, yy.aj.bM, 0, 5, 1, 1, sbb);
        final int rise = 2;
        for (int numFlights = this.highestOpening / rise, i = 0; i < numFlights; ++i) {
            this.makeStairs7flight(world, rand, sbb, 1 + i * rise, 0 + i * 3, 2);
            this.makeStairs7flight(world, rand, sbb, 1 + i * rise, 2 + i * 3, 0);
        }
        return true;
    }
    
    protected void makeStairs7flight(final ry world, final Random rand, final nl sbb, final int height, final int rotation, final int meta) {
        final int temp = this.f;
        this.f = (this.f + rotation) % 4;
        this.a(world, yy.ak.bM, meta, 2, 1 + height, 5, sbb);
        this.a(world, yy.aj.bM, meta, 3, 1 + height, 5, sbb);
        this.a(world, yy.ak.bM, meta, 4, 2 + height, 5, sbb);
        this.a(world, yy.aj.bM, meta, 5, 2 + height, 5, sbb);
        this.f = temp;
    }
    
    protected boolean makeStairs9(final ry world, final Random rand, final nl sbb) {
        this.a(world, yy.ak.bM, 2, 1, 1, 6, sbb);
        this.a(world, yy.aj.bM, 2, 1, 1, 7, sbb);
        this.a(world, yy.ak.bM, 0, 7, 1, 2, sbb);
        this.a(world, yy.aj.bM, 0, 7, 1, 1, sbb);
        final int rise = 3;
        for (int numFlights = this.highestOpening / rise, i = 0; i < numFlights; ++i) {
            this.makeStairs9flight(world, rand, sbb, 1 + i * rise, 0 + i * 3, 2);
            this.makeStairs9flight(world, rand, sbb, 1 + i * rise, 2 + i * 3, 0);
        }
        return true;
    }
    
    protected void makeStairs9flight(final ry world, final Random rand, final nl sbb, final int height, final int rotation, final int meta) {
        final int temp = this.f;
        this.f = (this.f + rotation) % 4;
        this.a(world, yy.ak.bM, meta, 2, 1 + height, 7, sbb);
        this.a(world, yy.aj.bM, meta, 3, 1 + height, 7, sbb);
        this.a(world, yy.ak.bM, meta, 4, 2 + height, 7, sbb);
        this.a(world, yy.aj.bM, meta, 5, 2 + height, 7, sbb);
        this.a(world, yy.ak.bM, meta, 6, 3 + height, 7, sbb);
        this.a(world, yy.aj.bM, meta, 7, 3 + height, 7, sbb);
        this.f = temp;
    }
    
    protected boolean makeStairs15(final ry world, final Random rand, final nl sbb) {
        this.a(world, yy.ak.bM, 2, 1, 1, 9, sbb);
        this.a(world, yy.ak.bM, 2, 2, 1, 9, sbb);
        this.a(world, yy.aj.bM, 2, 1, 1, 10, sbb);
        this.a(world, yy.aj.bM, 2, 2, 1, 10, sbb);
        this.a(world, yy.ak.bM, 2, 1, 2, 11, sbb);
        this.a(world, yy.ak.bM, 2, 2, 2, 11, sbb);
        this.a(world, yy.aj.bM, 2, 1, 2, 12, sbb);
        this.a(world, yy.aj.bM, 2, 2, 2, 12, sbb);
        this.a(world, yy.aj.bM, 2, 1, 2, 13, sbb);
        this.a(world, yy.aj.bM, 2, 2, 2, 13, sbb);
        this.a(world, yy.aj.bM, 2, 3, 2, 11, sbb);
        this.a(world, yy.aZ.bM, 0, 3, 3, 11, sbb);
        this.a(world, yy.aZ.bM, 0, 3, 4, 11, sbb);
        this.a(world, yy.aq.bM, 0, 3, 5, 11, sbb);
        this.a(world, yy.aj.bM, 2, 3, 1, 10, sbb);
        this.a(world, yy.aZ.bM, 0, 3, 2, 10, sbb);
        this.a(world, yy.aZ.bM, 0, 3, 3, 10, sbb);
        this.a(world, yy.aj.bM, 2, 3, 1, 9, sbb);
        this.a(world, yy.aZ.bM, 0, 3, 2, 9, sbb);
        this.a(world, yy.ak.bM, 0, 13, 1, 5, sbb);
        this.a(world, yy.ak.bM, 0, 12, 1, 5, sbb);
        this.a(world, yy.aj.bM, 0, 13, 1, 4, sbb);
        this.a(world, yy.aj.bM, 0, 12, 1, 4, sbb);
        this.a(world, yy.ak.bM, 0, 13, 2, 3, sbb);
        this.a(world, yy.ak.bM, 0, 12, 2, 3, sbb);
        this.a(world, yy.aj.bM, 0, 13, 2, 2, sbb);
        this.a(world, yy.aj.bM, 0, 12, 2, 2, sbb);
        this.a(world, yy.aj.bM, 0, 13, 2, 1, sbb);
        this.a(world, yy.aj.bM, 0, 12, 2, 1, sbb);
        this.a(world, yy.aj.bM, 0, 11, 2, 3, sbb);
        this.a(world, yy.aZ.bM, 0, 11, 3, 3, sbb);
        this.a(world, yy.aZ.bM, 0, 11, 4, 3, sbb);
        this.a(world, yy.aq.bM, 0, 11, 5, 3, sbb);
        this.a(world, yy.aj.bM, 0, 11, 1, 4, sbb);
        this.a(world, yy.aZ.bM, 0, 11, 2, 4, sbb);
        this.a(world, yy.aZ.bM, 0, 11, 3, 4, sbb);
        this.a(world, yy.aj.bM, 0, 11, 1, 5, sbb);
        this.a(world, yy.aZ.bM, 0, 11, 2, 5, sbb);
        final int rise = 5;
        for (int numFlights = this.highestOpening / rise, i = 0; i < numFlights; ++i) {
            this.makeStairs15flight(world, rand, sbb, 2 + i * rise, 0 + i * 3, 2);
            this.makeStairs15flight(world, rand, sbb, 2 + i * rise, 2 + i * 3, 0);
        }
        return true;
    }
    
    protected void makeStairs15flight(final ry world, final Random rand, final nl sbb, final int height, final int rotation, final int meta) {
        final int temp = this.f;
        this.f = (this.f + rotation) % 4;
        this.a(world, yy.ak.bM, meta, 3, 1 + height, 13, sbb);
        this.a(world, yy.aj.bM, meta, 4, 1 + height, 13, sbb);
        this.a(world, yy.ak.bM, meta, 5, 2 + height, 13, sbb);
        this.a(world, yy.aj.bM, meta, 6, 2 + height, 13, sbb);
        this.a(world, yy.ak.bM, meta, 7, 3 + height, 13, sbb);
        this.a(world, yy.aj.bM, meta, 8, 3 + height, 13, sbb);
        this.a(world, yy.ak.bM, meta, 9, 4 + height, 13, sbb);
        this.a(world, yy.aj.bM, meta, 10, 4 + height, 13, sbb);
        this.a(world, yy.ak.bM, meta, 11, 5 + height, 13, sbb);
        this.a(world, yy.aj.bM, meta, 12, 5 + height, 13, sbb);
        this.a(world, yy.aj.bM, meta, 13, 5 + height, 13, sbb);
        this.a(world, yy.ak.bM, meta, 3, 1 + height, 12, sbb);
        this.a(world, yy.aj.bM, meta, 4, 1 + height, 12, sbb);
        this.a(world, yy.ak.bM, meta, 5, 2 + height, 12, sbb);
        this.a(world, yy.aj.bM, meta, 6, 2 + height, 12, sbb);
        this.a(world, yy.ak.bM, meta, 7, 3 + height, 12, sbb);
        this.a(world, yy.aj.bM, meta, 8, 3 + height, 12, sbb);
        this.a(world, yy.ak.bM, meta, 9, 4 + height, 12, sbb);
        this.a(world, yy.aj.bM, meta, 10, 4 + height, 12, sbb);
        this.a(world, yy.ak.bM, meta, 11, 5 + height, 12, sbb);
        this.a(world, yy.aj.bM, meta, 12, 5 + height, 12, sbb);
        this.a(world, yy.aj.bM, meta, 13, 5 + height, 12, sbb);
        this.a(world, yy.aj.bM, meta, 4, 1 + height, 11, sbb);
        this.a(world, yy.aj.bM, meta, 5, 2 + height, 11, sbb);
        this.a(world, yy.aj.bM, meta, 6, 2 + height, 11, sbb);
        this.a(world, yy.aj.bM, meta, 7, 3 + height, 11, sbb);
        this.a(world, yy.aj.bM, meta, 8, 3 + height, 11, sbb);
        this.a(world, yy.aj.bM, meta, 9, 4 + height, 11, sbb);
        this.a(world, yy.aj.bM, meta, 10, 4 + height, 11, sbb);
        this.a(world, yy.aj.bM, meta, 11, 5 + height, 11, sbb);
        this.a(world, yy.aZ.bM, 0, 4, 2 + height, 11, sbb);
        this.a(world, yy.aZ.bM, 0, 5, 3 + height, 11, sbb);
        this.a(world, yy.aZ.bM, 0, 6, 3 + height, 11, sbb);
        this.a(world, yy.aZ.bM, 0, 7, 4 + height, 11, sbb);
        this.a(world, yy.aZ.bM, 0, 8, 4 + height, 11, sbb);
        this.a(world, yy.aZ.bM, 0, 9, 5 + height, 11, sbb);
        this.a(world, yy.aZ.bM, 0, 10, 5 + height, 11, sbb);
        this.a(world, yy.aZ.bM, 0, 11, 6 + height, 11, sbb);
        this.a(world, yy.aZ.bM, 0, 4, 3 + height, 11, sbb);
        this.a(world, yy.aZ.bM, 0, 6, 4 + height, 11, sbb);
        this.a(world, yy.aZ.bM, 0, 8, 5 + height, 11, sbb);
        this.a(world, yy.aZ.bM, 0, 10, 6 + height, 11, sbb);
        this.a(world, yy.aZ.bM, 0, 11, 7 + height, 11, sbb);
        this.a(world, yy.aq.bM, 0, 11, 8 + height, 11, sbb);
        this.f = temp;
    }
}
