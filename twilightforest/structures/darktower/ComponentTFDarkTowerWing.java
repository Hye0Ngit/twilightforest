// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.darktower;

import java.util.Iterator;
import twilightforest.structures.StructureDecoratorDarkTower;
import twilightforest.block.TFBlocks;
import twilightforest.entity.TFCreatures;
import twilightforest.item.TFItems;
import twilightforest.TFTreasure;
import twilightforest.structures.StructureTFDecorator;
import twilightforest.structures.ComponentTFTowerRoofFence;
import twilightforest.structures.ComponentTFTowerRoofAttachedSlab;
import twilightforest.structures.ComponentTFTowerRoofSlabForwards;
import twilightforest.structures.ComponentTFTowerRoofGableForwards;
import twilightforest.structures.ComponentTFTowerRoof;
import twilightforest.structures.StructureTFComponent;
import java.util.Random;
import java.util.List;
import twilightforest.structures.EnumDarkTowerDoor;
import java.util.ArrayList;
import twilightforest.structures.ComponentTFTowerWing;

public class ComponentTFDarkTowerWing extends ComponentTFTowerWing
{
    protected boolean keyTower;
    protected ArrayList<EnumDarkTowerDoor> openingTypes;
    
    protected ComponentTFDarkTowerWing(final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final int direction) {
        super(i, x, y, z, pSize, pHeight, direction);
        this.keyTower = false;
        this.openingTypes = new ArrayList<EnumDarkTowerDoor>();
    }
    
    @Override
    public void a(final aiq parent, final List list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponent) {
            this.deco = ((StructureTFComponent)parent).deco;
        }
        this.addOpening(0, 1, this.size / 2, 2);
        this.makeARoof(parent, list, rand);
        this.makeABeard(parent, list, rand);
        if (this.size > 10) {
            for (int direction = 0; direction < 4; ++direction) {
                final int[] dest = this.getValidOpening(rand, direction);
                final int childSize = this.size - 2;
                final int childHeight = this.validateChildHeight(this.height - 4 + rand.nextInt(10) - rand.nextInt(10), childSize);
                final boolean madeWing = this.makeTowerWing(list, rand, this.c(), dest[0], dest[1], dest[2], this.size - 2, childHeight, direction);
                if (!madeWing && (direction == 2 || rand.nextBoolean())) {
                    this.makeTowerBalcony(list, rand, this.c(), dest[0], dest[1], dest[2], direction);
                }
            }
        }
        else if (rand.nextInt(4) == 0) {
            final int direction = rand.nextInt(4);
            final int[] dest = this.getValidOpening(rand, direction);
            this.makeTowerBalcony(list, rand, this.c(), dest[0], dest[1], dest[2], direction);
        }
    }
    
    protected int validateChildHeight(final int childHeight, final int childSize) {
        return childHeight / 4 * 4 + 1;
    }
    
    @Override
    public void makeARoof(final aiq parent, final List list, final Random rand) {
        final int index = this.c();
        ComponentTFTowerRoof roof = null;
        switch (rand.nextInt(5)) {
            default: {
                roof = new ComponentTFDarkTowerRoofAntenna(index, this);
                break;
            }
            case 2: {
                roof = new ComponentTFDarkTowerRoofCactus(index, this);
                break;
            }
            case 3: {
                roof = new ComponentTFDarkTowerRoofRings(index, this);
                break;
            }
            case 4: {
                roof = new ComponentTFDarkTowerRoofFourPost(index, this);
                break;
            }
        }
        list.add(roof);
        roof.a((aiq)this, list, rand);
        this.roofType = roof.getClass();
    }
    
    @Override
    protected void makeAttachedRoof(final List list, final Random rand) {
        final int index = this.c();
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
    
    @Override
    public void makeABeard(final aiq parent, final List list, final Random rand) {
        final ComponentTFDarkTowerBeard beard = new ComponentTFDarkTowerBeard(this.c() + 1, this);
        list.add(beard);
        beard.a((aiq)this, list, rand);
    }
    
    @Override
    public boolean makeTowerWing(final List list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final int rotation) {
        if (wingHeight < 8) {
            return false;
        }
        final int direction = (this.getCoordBaseMode() + rotation) % 4;
        final int[] dx = this.offsetTowerCoords(x, y, z, 5, direction);
        if (dx[1] + wingHeight > 250) {
            return false;
        }
        final ComponentTFDarkTowerBridge bridge = new ComponentTFDarkTowerBridge(index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        aiq intersect = aiq.a(list, bridge.b());
        if (intersect != null && intersect != this) {
            return false;
        }
        intersect = aiq.a(list, bridge.getWingBB());
        if (intersect == null || intersect == this) {
            list.add(bridge);
            bridge.a(this, list, rand);
            this.addOpening(x, y, z, rotation);
            return true;
        }
        return false;
    }
    
    protected boolean makeTowerBalcony(final List list, final Random rand, final int index, final int x, final int y, final int z, final int rotation) {
        final int direction = (this.getCoordBaseMode() + rotation) % 4;
        final int[] dx = this.offsetTowerCoords(x, y, z, 5, direction);
        final ComponentTFDarkTowerBalcony balcony = new ComponentTFDarkTowerBalcony(index, dx[0], dx[1], dx[2], direction);
        final aiq intersect = aiq.a(list, balcony.b());
        if (intersect == null || intersect == this) {
            list.add(balcony);
            balcony.a(this, list, rand);
            this.addOpening(x, y, z, rotation, EnumDarkTowerDoor.REAPPEARING);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean a(final abv world, final Random rand, final age sbb) {
        final Random decoRNG = new Random(world.H() + this.f.a * 321534781 ^ (long)(this.f.c * 756839));
        this.makeEncasedWalls(world, rand, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1);
        this.a(world, sbb, 1, 1, 1, this.size - 2, this.height - 2, this.size - 2);
        this.nullifySkyLightForBoundingBox(world);
        if (this.size > 9) {
            this.addHalfFloors(world, decoRNG, sbb, 4, this.height - 1);
        }
        else if (decoRNG.nextInt(3) == 0) {
            this.addSmallTimberBeams(world, decoRNG, sbb, 4, this.height - 1);
        }
        else {
            this.addHalfFloors(world, decoRNG, sbb, 4, this.height - 1);
        }
        this.makeOpenings(world, sbb);
        if (decoRNG.nextBoolean() && !this.isKeyTower() && this.height > 8) {
            int blobs = 1;
            if (this.size > 9 && decoRNG.nextBoolean()) {
                ++blobs;
            }
            for (int i = 0; i < blobs; ++i) {
                final int x = decoRNG.nextInt(this.size);
                final int y = decoRNG.nextInt(this.height - 7) + 2;
                final int z = decoRNG.nextInt(this.size);
                this.destroyTower(world, decoRNG, x, y, z, 3, sbb);
            }
        }
        return true;
    }
    
    protected void destroyTower(final abv world, final Random decoRNG, final int x, final int y, final int z, final int amount, final age sbb) {
        final int initialRadius = decoRNG.nextInt(amount) + amount;
        this.drawBlob(world, x, y, z, initialRadius, 0, 0, sbb);
        for (int i = 0; i < 3; ++i) {
            final int dx = x + (initialRadius - 1) * (decoRNG.nextBoolean() ? 1 : -1);
            final int dy = y + (initialRadius - 1) * (decoRNG.nextBoolean() ? 1 : -1);
            final int dz = z + (initialRadius - 1) * (decoRNG.nextBoolean() ? 1 : -1);
            this.netherTransformBlob(world, decoRNG, dx, dy, dz, initialRadius - 1, sbb);
            this.drawBlob(world, dx, dy, dz, initialRadius - 2, 0, 0, sbb);
        }
    }
    
    private void netherTransformBlob(final abv world, final Random inRand, final int sx, final int sy, final int sz, final int rad, final age sbb) {
        final Random rand = new Random(inRand.nextLong());
        for (byte dx = 0; dx <= rad; ++dx) {
            for (byte dy = 0; dy <= rad; ++dy) {
                for (byte dz = 0; dz <= rad; ++dz) {
                    byte dist = 0;
                    if (dx >= dy && dx >= dz) {
                        dist = (byte)(dx + (byte)(Math.max(dy, dz) * 0.5 + Math.min(dy, dz) * 0.25));
                    }
                    else if (dy >= dx && dy >= dz) {
                        dist = (byte)(dy + (byte)(Math.max(dx, dz) * 0.5 + Math.min(dx, dz) * 0.25));
                    }
                    else {
                        dist = (byte)(dz + (byte)(Math.max(dx, dy) * 0.5 + Math.min(dx, dy) * 0.25));
                    }
                    if (dist <= rad) {
                        this.testAndChangeToNetherrack(world, rand, sx + dx, sy + dy, sz + dz, sbb);
                        this.testAndChangeToNetherrack(world, rand, sx + dx, sy + dy, sz + dz, sbb);
                        this.testAndChangeToNetherrack(world, rand, sx + dx, sy + dy, sz - dz, sbb);
                        this.testAndChangeToNetherrack(world, rand, sx - dx, sy + dy, sz + dz, sbb);
                        this.testAndChangeToNetherrack(world, rand, sx - dx, sy + dy, sz - dz, sbb);
                        this.testAndChangeToNetherrack(world, rand, sx + dx, sy - dy, sz + dz, sbb);
                        this.testAndChangeToNetherrack(world, rand, sx + dx, sy - dy, sz - dz, sbb);
                        this.testAndChangeToNetherrack(world, rand, sx - dx, sy - dy, sz + dz, sbb);
                        this.testAndChangeToNetherrack(world, rand, sx - dx, sy - dy, sz - dz, sbb);
                    }
                }
            }
        }
    }
    
    private void testAndChangeToNetherrack(final abv world, final Random rand, final int x, final int y, final int z, final age sbb) {
        if (this.a(world, x, y, z, sbb) > 0) {
            this.a(world, aqw.bg.cF, 0, x, y, z, sbb);
            if (this.a(world, x, y + 1, z, sbb) == 0 && rand.nextBoolean()) {
                this.a(world, aqw.aw.cF, 0, x, y + 1, z, sbb);
            }
        }
    }
    
    public void drawBlob(final abv world, final int sx, final int sy, final int sz, final int rad, final int blockValue, final int metaValue, final age sbb) {
        for (byte dx = 0; dx <= rad; ++dx) {
            for (byte dy = 0; dy <= rad; ++dy) {
                for (byte dz = 0; dz <= rad; ++dz) {
                    byte dist = 0;
                    if (dx >= dy && dx >= dz) {
                        dist = (byte)(dx + (byte)(Math.max(dy, dz) * 0.5 + Math.min(dy, dz) * 0.25));
                    }
                    else if (dy >= dx && dy >= dz) {
                        dist = (byte)(dy + (byte)(Math.max(dx, dz) * 0.5 + Math.min(dx, dz) * 0.25));
                    }
                    else {
                        dist = (byte)(dz + (byte)(Math.max(dx, dy) * 0.5 + Math.min(dx, dy) * 0.25));
                    }
                    if (dist <= rad) {
                        this.a(world, blockValue, metaValue, sx + dx, sy + dy, sz + dz, sbb);
                        this.a(world, blockValue, metaValue, sx + dx, sy + dy, sz - dz, sbb);
                        this.a(world, blockValue, metaValue, sx - dx, sy + dy, sz + dz, sbb);
                        this.a(world, blockValue, metaValue, sx - dx, sy + dy, sz - dz, sbb);
                        this.a(world, blockValue, metaValue, sx + dx, sy - dy, sz + dz, sbb);
                        this.a(world, blockValue, metaValue, sx + dx, sy - dy, sz - dz, sbb);
                        this.a(world, blockValue, metaValue, sx - dx, sy - dy, sz + dz, sbb);
                        this.a(world, blockValue, metaValue, sx - dx, sy - dy, sz - dz, sbb);
                    }
                }
            }
        }
    }
    
    protected void addHalfFloors(final abv world, final Random rand, final age sbb, int bottom, final int top) {
        final int spacing = 4;
        int rotation = (this.f.b + bottom) % 3;
        if (bottom == 0) {
            bottom += spacing;
        }
        for (int y = bottom; y < top; y += spacing) {
            rotation += 2;
            rotation %= 4;
            if (y >= top - spacing) {
                this.makeFullFloor(world, sbb, rotation, y, spacing);
                if (this.isDeadEnd()) {
                    this.decorateTreasureRoom(world, sbb, rotation, y, 4, this.deco);
                }
            }
            else {
                this.makeHalfFloor(world, sbb, rotation, y, spacing);
                switch (rand.nextInt(8)) {
                    case 0: {
                        if (this.size < 11) {
                            this.decorateReappearingFloor(world, rand, sbb, rotation, y);
                            break;
                        }
                    }
                    case 1: {
                        this.decorateSpawner(world, rand, sbb, rotation, y);
                        break;
                    }
                    case 2: {
                        this.decorateLounge(world, rand, sbb, rotation, y);
                        break;
                    }
                    case 3: {
                        this.decorateLibrary(world, rand, sbb, rotation, y);
                        break;
                    }
                    case 4: {
                        this.decorateExperimentPulser(world, rand, sbb, rotation, y);
                        break;
                    }
                    case 5: {
                        this.decorateExperimentLamp(world, rand, sbb, rotation, y);
                        break;
                    }
                    case 6: {
                        this.decoratePuzzleChest(world, rand, sbb, rotation, y);
                        break;
                    }
                }
            }
            this.addStairsDown(world, sbb, rotation, y, this.size - 2, spacing);
            if (this.size > 9) {
                this.addStairsDown(world, sbb, rotation, y, this.size - 3, spacing);
            }
        }
        rotation += 2;
        rotation %= 4;
        this.addStairsDown(world, sbb, rotation, this.height - 1, this.size - 2, spacing);
    }
    
    protected void makeHalfFloor(final abv world, final age sbb, final int rotation, final int y, final int spacing) {
        this.fillBlocksRotated(world, sbb, this.size / 2, y, 1, this.size - 2, y, this.size - 2, this.deco.blockID, this.deco.blockMeta, rotation);
        this.fillBlocksRotated(world, sbb, this.size / 2 - 1, y, 1, this.size / 2 - 1, y, this.size - 2, this.deco.accentID, this.deco.accentMeta, rotation);
    }
    
    protected void makeFullFloor(final abv world, final age sbb, final int rotation, final int y, final int spacing) {
        this.a(world, sbb, 1, y, 1, this.size - 2, y, this.size - 2, this.deco.blockID, this.deco.blockMeta, 0, 0, false);
        this.a(world, sbb, this.size / 2, y, 1, this.size / 2, y, this.size - 2, this.deco.accentID, this.deco.accentMeta, 0, 0, true);
    }
    
    protected void decorateTreasureRoom(final abv world, final age sbb, final int rotation, final int y, final int spacing, final StructureTFDecorator myDeco) {
        final int x = this.size / 2;
        final int z = this.size / 2;
        for (int dy = 1; dy < spacing; ++dy) {
            this.placeBlockRotated(world, myDeco.pillarID, myDeco.pillarMeta, x - 1, y + dy, z - 1, rotation, sbb);
            this.placeBlockRotated(world, myDeco.pillarID, myDeco.pillarMeta, x + 1, y + dy, z - 1, rotation, sbb);
            this.placeBlockRotated(world, myDeco.pillarID, myDeco.pillarMeta, x - 1, y + dy, z + 1, rotation, sbb);
            this.placeBlockRotated(world, myDeco.pillarID, myDeco.pillarMeta, x + 1, y + dy, z + 1, rotation, sbb);
        }
        this.placeBlockRotated(world, myDeco.stairID, this.getStairMeta(1 + rotation), x + 0, y + 1, z - 1, rotation, sbb);
        this.placeBlockRotated(world, myDeco.stairID, this.getStairMeta(0 + rotation), x - 1, y + 1, z + 0, rotation, sbb);
        this.placeBlockRotated(world, myDeco.stairID, this.getStairMeta(2 + rotation), x + 1, y + 1, z + 0, rotation, sbb);
        this.placeBlockRotated(world, myDeco.stairID, this.getStairMeta(3 + rotation), x + 0, y + 1, z + 1, rotation, sbb);
        for (int dy = 2; dy < spacing - 1; ++dy) {
            this.placeBlockRotated(world, myDeco.fenceID, myDeco.fenceMeta, x + 0, y + dy, z - 1, rotation, sbb);
            this.placeBlockRotated(world, myDeco.fenceID, myDeco.fenceMeta, x - 1, y + dy, z + 0, rotation, sbb);
            this.placeBlockRotated(world, myDeco.fenceID, myDeco.fenceMeta, x + 1, y + dy, z + 0, rotation, sbb);
            this.placeBlockRotated(world, myDeco.fenceID, myDeco.fenceMeta, x + 0, y + dy, z + 1, rotation, sbb);
        }
        this.placeBlockRotated(world, myDeco.stairID, this.getStairMeta(1 + rotation) + 4, x + 0, y + spacing - 1, z - 1, rotation, sbb);
        this.placeBlockRotated(world, myDeco.stairID, this.getStairMeta(0 + rotation) + 4, x - 1, y + spacing - 1, z + 0, rotation, sbb);
        this.placeBlockRotated(world, myDeco.stairID, this.getStairMeta(2 + rotation) + 4, x + 1, y + spacing - 1, z + 0, rotation, sbb);
        this.placeBlockRotated(world, myDeco.stairID, this.getStairMeta(3 + rotation) + 4, x + 0, y + spacing - 1, z + 1, rotation, sbb);
        this.placeBlockRotated(world, myDeco.platformID, myDeco.platformMeta, x, y + 1, z, rotation, sbb);
        this.placeTreasureAtCurrentPosition(world, null, x, y + 2, z, this.isKeyTower() ? TFTreasure.darktower_key : TFTreasure.darktower_cache, sbb);
        if (this.isKeyTower()) {
            this.putItemInTreasure(world, x, y + 2, z, new yd(TFItems.towerKey), sbb);
        }
    }
    
    private void decorateSpawner(final abv world, final Random rand, final age sbb, final int rotation, final int y) {
        final int x = (this.size > 9) ? 4 : 3;
        final int z = (this.size > 9) ? 5 : 4;
        String mobID;
        if (this.size > 9) {
            mobID = (rand.nextBoolean() ? TFCreatures.getSpawnerNameFor("Tower Golem") : TFCreatures.getSpawnerNameFor("Redscale Broodling"));
        }
        else {
            mobID = TFCreatures.getSpawnerNameFor("Redscale Broodling");
        }
        this.makePillarFrame(world, sbb, this.deco, rotation, x, y, z, true);
        this.placeSpawnerRotated(world, x + 1, y + 2, z + 1, rotation, mobID, sbb);
    }
    
    private void decorateLounge(final abv world, final Random rand, final age sbb, final int rotation, final int y) {
        int cx = (this.size > 9) ? 9 : 7;
        final int cz = (this.size > 9) ? 4 : 3;
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(3 + rotation), cx, y + 1, cz + 0, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(0 + rotation), cx, y + 1, cz + 1, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(1 + rotation), cx, y + 1, cz + 2, rotation, sbb);
        cx = ((this.size > 9) ? 5 : 3);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(3 + rotation) + 4, cx, y + 1, cz + 0, rotation, sbb);
        this.placeBlockRotated(world, aqw.bT.cF, 9, cx, y + 1, cz + 1, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(1 + rotation) + 4, cx, y + 1, cz + 2, rotation, sbb);
    }
    
    private void decorateReappearingFloor(final abv world, final Random rand, final age sbb, final int rotation, final int y) {
        this.fillBlocksRotated(world, sbb, 4, y, 3, 7, y, 5, TFBlocks.towerDevice.cF, 0, rotation);
        this.fillBlocksRotated(world, sbb, 4, y + 1, 2, 7, y + 1, 2, aqw.aR.cF, 0, rotation);
        this.fillBlocksRotated(world, sbb, 4, y + 1, 6, 7, y + 1, 6, aqw.aR.cF, 0, rotation);
    }
    
    private void decorateExperimentLamp(final abv world, final Random rand, final age sbb, final int rotation, final int y) {
        final int cx = (this.size > 9) ? 5 : 3;
        final int cz = (this.size > 9) ? 5 : 4;
        this.placeBlockRotated(world, aqw.aa.cF, 1, cx, y + 1, cz, rotation, sbb);
        this.placeBlockRotated(world, aqw.bQ.cF, 0, cx, y + 2, cz, rotation, sbb);
        this.placeBlockRotated(world, this.deco.accentID, this.deco.accentMeta, cx, y + 1, cz + 1, rotation, sbb);
        this.placeBlockRotated(world, aqw.aO.cF, this.getLeverMeta(rotation, 3), cx, y + 1, cz + 2, rotation, sbb);
        this.placeBlockRotated(world, this.deco.accentID, this.deco.accentMeta, cx, y + 3, cz - 1, rotation, sbb);
        this.placeBlockRotated(world, aqw.aO.cF, this.getLeverMeta(rotation, 2) + 8, cx, y + 3, cz - 2, rotation, sbb);
    }
    
    private void decorateExperimentPulser(final abv world, final Random rand, final age sbb, final int rotation, final int y) {
        final int cx = (this.size > 9) ? 6 : 5;
        final int cz = (this.size > 9) ? 4 : 3;
        this.placeBlockRotated(world, aqw.aa.cF, 5 - this.getStairMeta(3 + rotation), cx, y + 1, cz + 1, rotation, sbb);
        this.placeBlockRotated(world, this.deco.accentID, this.deco.accentMeta, cx, y + 1, cz, rotation, sbb);
        this.placeBlockRotated(world, aqw.aA.cF, 0, cx + 1, y + 1, cz, rotation, sbb);
        this.placeBlockRotated(world, aqw.aR.cF, 0, cx + 2, y + 1, cz, rotation, sbb);
        this.placeBlockRotated(world, aqw.bm.cF, (rotation + 1) % 4 + 4, cx - 1, y + 1, cz, rotation, sbb);
        this.placeBlockRotated(world, aqw.aA.cF, 0, cx - 2, y + 1, cz, rotation, sbb);
        this.placeBlockRotated(world, aqw.aA.cF, 0, cx - 2, y + 1, cz + 1, rotation, sbb);
        this.placeBlockRotated(world, aqw.aA.cF, 0, cx - 1, y + 1, cz + 1, rotation, sbb);
    }
    
    private void decorateLibrary(final abv world, final Random rand, final age sbb, final int rotation, final int y) {
        int bx = (this.size > 9) ? 4 : 3;
        int bz = (this.size > 9) ? 3 : 2;
        this.makeSmallBookshelf(world, sbb, rotation, y, bx, bz);
        bx = ((this.size > 9) ? 9 : 7);
        bz = ((this.size > 9) ? 3 : 2);
        this.makeSmallBookshelf(world, sbb, rotation, y, bx, bz);
    }
    
    protected void makeSmallBookshelf(final abv world, final age sbb, final int rotation, final int y, final int bx, final int bz) {
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(1 + rotation) + 0, bx, y + 1, bz + 0, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(1 + rotation) + 4, bx, y + 2, bz + 0, rotation, sbb);
        this.placeBlockRotated(world, aqw.as.cF, 0, bx, y + 1, bz + 1, rotation, sbb);
        this.placeBlockRotated(world, aqw.as.cF, 0, bx, y + 2, bz + 1, rotation, sbb);
        this.placeBlockRotated(world, aqw.as.cF, 0, bx, y + 1, bz + 2, rotation, sbb);
        this.placeBlockRotated(world, aqw.as.cF, 0, bx, y + 2, bz + 2, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(3 + rotation) + 0, bx, y + 1, bz + 3, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(3 + rotation) + 4, bx, y + 2, bz + 3, rotation, sbb);
    }
    
    private void decoratePuzzleChest(final abv world, final Random rand, final age sbb, final int rotation, final int y) {
        final int x = (this.size > 9) ? 4 : 3;
        final int z = (this.size > 9) ? 5 : 4;
        this.makePillarFrame(world, sbb, this.deco, rotation, x, y, z, true);
        this.placeBlockRotated(world, this.deco.platformID, this.deco.platformMeta, x + 1, y + 1, z + 1, rotation, sbb);
        this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, x + 2, y + 1, z + 1, rotation, sbb);
        this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, x + 0, y + 1, z + 1, rotation, sbb);
        this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, x + 1, y + 1, z + 2, rotation, sbb);
        this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, x + 1, y + 1, z + 0, rotation, sbb);
        this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, x + 2, y + 3, z + 1, rotation, sbb);
        this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, x + 0, y + 3, z + 1, rotation, sbb);
        this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, x + 1, y + 3, z + 2, rotation, sbb);
        this.placeBlockRotated(world, 0, 0, x + 1, y + 3, z + 0, rotation, sbb);
        this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, x + 1, y + 3, z + 1, rotation, sbb);
        this.placeBlockRotated(world, aqw.aa.cF, 5 - this.getStairMeta(1 + rotation), x + 1, y + 3, z - 1, rotation, sbb);
        this.placeBlockRotated(world, this.deco.accentID, this.deco.accentMeta, x + 1, y + 3, z - 2, rotation, sbb);
        this.placeBlockRotated(world, aqw.aO.cF, this.getLeverMeta(rotation, 5), x + 2, y + 3, z - 2, rotation, sbb);
        this.placeTreasureRotated(world, x + 1, y + 2, z + 1, rotation, TFTreasure.darktower_cache, sbb);
    }
    
    protected void makePillarFrame(final abv world, final age sbb, final StructureTFDecorator myDeco, final int rotation, final int x, final int y, final int z, final boolean fenced) {
        this.makePillarFrame(world, sbb, myDeco, rotation, x, y, z, 3, 3, 3, fenced);
    }
    
    protected void makePillarFrame(final abv world, final age sbb, final StructureTFDecorator myDeco, final int rotation, final int x, final int y, final int z, final int width, final int height, final int length, final boolean fenced) {
        for (int dx = 0; dx < width; ++dx) {
            for (int dz = 0; dz < length; ++dz) {
                if ((dx % 3 == 0 || dx == width - 1) && (dz % 3 == 0 || dz == length - 1)) {
                    for (int py = 1; py <= height; ++py) {
                        this.placeBlockRotated(world, myDeco.pillarID, myDeco.pillarMeta, x + dx, y + py, z + dz, rotation, sbb);
                    }
                }
                else {
                    if (dx == 0) {
                        this.placeBlockRotated(world, myDeco.stairID, this.getStairMeta(0 + rotation), x + dx, y + 1, z + dz, rotation, sbb);
                        this.placeBlockRotated(world, myDeco.stairID, this.getStairMeta(0 + rotation) + 4, x + dx, y + height, z + dz, rotation, sbb);
                    }
                    else if (dx == width - 1) {
                        this.placeBlockRotated(world, myDeco.stairID, this.getStairMeta(2 + rotation), x + dx, y + 1, z + dz, rotation, sbb);
                        this.placeBlockRotated(world, myDeco.stairID, this.getStairMeta(2 + rotation) + 4, x + dx, y + height, z + dz, rotation, sbb);
                    }
                    else if (dz == 0) {
                        this.placeBlockRotated(world, myDeco.stairID, this.getStairMeta(1 + rotation), x + dx, y + 1, z + dz, rotation, sbb);
                        this.placeBlockRotated(world, myDeco.stairID, this.getStairMeta(1 + rotation) + 4, x + dx, y + height, z + dz, rotation, sbb);
                    }
                    else if (dz == length - 1) {
                        this.placeBlockRotated(world, myDeco.stairID, this.getStairMeta(3 + rotation), x + dx, y + 1, z + dz, rotation, sbb);
                        this.placeBlockRotated(world, myDeco.stairID, this.getStairMeta(3 + rotation) + 4, x + dx, y + height, z + dz, rotation, sbb);
                    }
                    if (fenced && (dx == 0 || dx == width - 1 || dz == 0 || dz == length - 1)) {
                        for (int fy = 2; fy <= height - 1; ++fy) {
                            this.placeBlockRotated(world, myDeco.fenceID, myDeco.fenceMeta, x + dx, y + fy, z + dz, rotation, sbb);
                        }
                    }
                }
            }
        }
    }
    
    protected void putItemInTreasure(final abv world, final int x, final int y, final int z, final yd itemToAdd, final age sbb) {
        final int dx = this.a(x, z);
        final int dy = this.a(y);
        final int dz = this.b(x, z);
        if (sbb.b(dx, dy, dz)) {
            final asm tileEntity = world.r(dx, dy, dz);
            if (tileEntity != null && tileEntity instanceof mn) {
                final mn inventory = (mn)tileEntity;
                boolean alreadyPresent = false;
                int emptySlots = 0;
                for (int i = 0; i < inventory.j_(); ++i) {
                    final yd inSlot = inventory.a(i);
                    if (inSlot == null) {
                        ++emptySlots;
                    }
                    else if (yd.b(inSlot, itemToAdd)) {
                        alreadyPresent = true;
                        break;
                    }
                }
                if (!alreadyPresent && emptySlots > 0) {
                    int slotsUntilPlaced = world.s.nextInt(emptySlots);
                    for (int j = 0; j < inventory.j_(); ++j) {
                        final yd inSlot2 = inventory.a(j);
                        if (inSlot2 == null) {
                            if (slotsUntilPlaced == 0) {
                                inventory.a(j, itemToAdd);
                                break;
                            }
                            --slotsUntilPlaced;
                        }
                    }
                }
            }
        }
    }
    
    protected void addStairsDown(final abv world, final age sbb, final int rotation, final int y, final int sz, final int spacing) {
        for (int i = 0; i < spacing; ++i) {
            final int sx = this.size - 3 - i;
            this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(0 + rotation), sx, y - i, sz, rotation, sbb);
            this.placeBlockRotated(world, this.deco.accentID, this.deco.accentMeta, sx, y - 1 - i, sz, rotation, sbb);
            this.placeBlockRotated(world, 0, 0, sx, y + 1 - i, sz, rotation, sbb);
            this.placeBlockRotated(world, 0, 0, sx, y + 2 - i, sz, rotation, sbb);
            this.placeBlockRotated(world, 0, 0, sx - 1, y + 2 - i, sz, rotation, sbb);
            this.placeBlockRotated(world, 0, 0, sx, y + 3 - i, sz, rotation, sbb);
            this.placeBlockRotated(world, 0, 0, sx - 1, y + 3 - i, sz, rotation, sbb);
        }
    }
    
    protected void addSmallTimberBeams(final abv world, final Random rand, final age sbb, int bottom, final int top) {
        final int spacing = 4;
        int rotation = 0;
        if (bottom == 0) {
            bottom += spacing;
        }
        for (int y = bottom; y < top; y += spacing) {
            rotation = ++rotation % 4;
            if (y >= top - spacing && this.isDeadEnd()) {
                this.makeTimberFloor(world, rand, sbb, rotation, y, spacing);
                final StructureTFDecorator logDeco = new StructureDecoratorDarkTower();
                logDeco.pillarID = TFBlocks.log.cF;
                logDeco.pillarMeta = 3;
                logDeco.platformID = TFBlocks.log.cF;
                logDeco.pillarMeta = 3;
                this.decorateTreasureRoom(world, sbb, rotation, y, 4, logDeco);
            }
            else {
                final int y2;
                this.makeSmallTimberBeams(world, rand, sbb, rotation, y2, (y2 = y) == bottom && bottom != spacing, y >= top - spacing);
            }
        }
    }
    
    protected void makeTimberFloor(final abv world, final Random rand, final age sbb, final int rotation, final int y, final int spacing) {
        final int beamID = TFBlocks.log.cF;
        final int beamMetaBase = 3;
        final int beamMetaNS = ((this.g + rotation) % 2 == 0) ? 4 : 8;
        final int beamMetaEW = (beamMetaNS == 4) ? 8 : 4;
        final int beamMetaUD = 0;
        for (int z = 1; z < this.size - 1; ++z) {
            for (int x = 1; x < this.size - 1; ++x) {
                if (x < z) {
                    this.placeBlockRotated(world, beamID, beamMetaBase + beamMetaNS, x, y, z, rotation, sbb);
                }
                else {
                    this.placeBlockRotated(world, beamID, beamMetaBase + beamMetaEW, x, y, z, rotation, sbb);
                }
            }
        }
        for (int by = 1; by < 4; ++by) {
            this.placeBlockRotated(world, beamID, beamMetaBase + beamMetaUD, 2, y - by, 2, rotation, sbb);
            this.placeBlockRotated(world, aqw.aK.cF, this.getLadderMeta(2 + rotation), 3, y - by, 2, rotation, sbb);
            this.placeBlockRotated(world, beamID, beamMetaBase + beamMetaUD, 6, y - by, 6, rotation, sbb);
            this.placeBlockRotated(world, aqw.aK.cF, this.getLadderMeta(4 + rotation), 5, y - by, 6, rotation, sbb);
        }
        this.placeBlockRotated(world, 0, 0, 3, y, 2, rotation, sbb);
        this.placeBlockRotated(world, 0, 0, 5, y, 6, rotation, sbb);
    }
    
    protected void makeSmallTimberBeams(final abv world, final Random rand, final age sbb, final int rotation, final int y, final boolean bottom, final boolean top) {
        final int beamID = TFBlocks.log.cF;
        final int beamMetaBase = 3;
        final int beamMetaNS = ((this.g + rotation) % 2 == 0) ? 4 : 8;
        final int beamMetaEW = (beamMetaNS == 4) ? 8 : 4;
        final int beamMetaUD = 0;
        for (int z = 1; z < this.size - 1; ++z) {
            this.placeBlockRotated(world, beamID, beamMetaBase + beamMetaEW, 2, y, z, rotation, sbb);
            this.placeBlockRotated(world, beamID, beamMetaBase + beamMetaEW, 6, y, z, rotation, sbb);
        }
        int z = this.pickBetweenExcluding(3, this.size - 3, rand, 2, 2, 6);
        for (int x = 3; x < 6; ++x) {
            this.placeBlockRotated(world, beamID, beamMetaBase + beamMetaNS, x, y, z, rotation, sbb);
        }
        final int x2 = 2;
        final int z2 = rand.nextBoolean() ? 2 : 6;
        final int x3 = 6;
        final int z3 = rand.nextBoolean() ? 2 : 6;
        for (int by = 1; by < 4; ++by) {
            if (!bottom || this.checkPost(world, x2, y - 4, z2, rotation, sbb)) {
                this.placeBlockRotated(world, beamID, beamMetaBase + beamMetaUD, x2, y - by, z2, rotation, sbb);
                this.placeBlockRotated(world, aqw.aK.cF, this.getLadderMeta(2 + rotation), x2 + 1, y - by, z2, rotation, sbb);
            }
            if (!bottom || this.checkPost(world, x3, y - 4, z3, rotation, sbb)) {
                this.placeBlockRotated(world, beamID, beamMetaBase + beamMetaUD, x3, y - by, z3, rotation, sbb);
                this.placeBlockRotated(world, aqw.aK.cF, this.getLadderMeta(4 + rotation), x3 - 1, y - by, z3, rotation, sbb);
            }
        }
    }
    
    protected int pickBetweenExcluding(final int low, final int high, final Random rand, final int k, final int l, final int m) {
        int result;
        do {
            result = rand.nextInt(high - low) + low;
        } while (result == k || result == l || result == m);
        return result;
    }
    
    protected int pickFrom(final Random rand, final int i, final int j, final int k) {
        switch (rand.nextInt(3)) {
            default: {
                return i;
            }
            case 1: {
                return j;
            }
            case 2: {
                return k;
            }
        }
    }
    
    protected boolean checkPost(final abv world, final int x, final int y, final int z, final int rotation, final age sbb) {
        final int worldX = this.getXWithOffsetAsIfRotated(x, z, rotation);
        final int worldY = this.a(y);
        final int worldZ = this.getZWithOffsetAsIfRotated(x, z, rotation);
        final int blockID = sbb.b(worldX, worldY, worldZ) ? world.a(worldX, worldY, worldZ) : 0;
        return blockID != 0 && (blockID != this.deco.accentID || world.h(worldX, worldY, worldZ) != this.deco.accentMeta);
    }
    
    protected void makeEncasedWalls(final abv world, final Random rand, final age sbb, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ) {
        for (int x = minX; x <= maxX; ++x) {
            for (int y = minY; y <= maxY; ++y) {
                for (int z = minZ; z <= maxZ; ++z) {
                    if (x == minX || x == maxX || y == minY || y == maxY || z == minZ || z == maxZ) {
                        if (((x == minY || x == maxX) && (y == minY || y == maxY || z == minZ || z == maxZ)) || ((y == minY || y == maxY) && (x == minY || x == maxX || z == minZ || z == maxZ)) || ((z == minZ || z == maxZ) && (x == minY || x == maxX || y == minY || y == maxY))) {
                            this.a(world, this.deco.accentID, this.deco.accentMeta, x, y, z, sbb);
                        }
                        else {
                            final air blocker = StructureTFComponent.getTowerWoods();
                            blocker.a(rand, x, y, z, true);
                            this.a(world, blocker.a(), blocker.b(), x, y, z, sbb);
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
    public void addOpening(final int dx, final int dy, final int dz, final int direction) {
        this.addOpening(dx, dy, dz, direction, EnumDarkTowerDoor.VANISHING);
    }
    
    protected void addOpening(final int dx, final int dy, final int dz, final int direction, final EnumDarkTowerDoor type) {
        super.addOpening(dx, dy, dz, direction);
        this.openingTypes.add(this.openings.indexOf(new t(dx, dy, dz)), type);
    }
    
    @Override
    protected void makeOpenings(final abv world, final age sbb) {
        for (int i = 0; i < this.openings.size(); ++i) {
            final t doorCoords = this.openings.get(i);
            final EnumDarkTowerDoor doorType = this.openingTypes.get(i);
            switch (doorType) {
                default: {
                    this.makeDoorOpening(world, doorCoords.a, doorCoords.b, doorCoords.c, sbb);
                    break;
                }
                case REAPPEARING: {
                    this.makeReappearingDoorOpening(world, doorCoords.a, doorCoords.b, doorCoords.c, sbb);
                    break;
                }
                case LOCKED: {
                    this.makeLockedDoorOpening(world, doorCoords.a, doorCoords.b, doorCoords.c, sbb);
                    break;
                }
            }
        }
    }
    
    @Override
    protected void makeDoorOpening(final abv world, final int dx, final int dy, final int dz, final age sbb) {
        this.nullifySkyLightAtCurrentPosition(world, dx - 3, dy - 1, dz - 3, dx + 3, dy + 3, dz + 3);
        if (dx == 0 || dx == this.size - 1) {
            this.a(world, sbb, dx, dy - 1, dz - 2, dx, dy + 3, dz + 2, this.deco.accentID, this.deco.accentMeta, 0, 0, false);
            this.a(world, sbb, dx, dy, dz - 1, dx, dy + 2, dz + 1, TFBlocks.towerDevice.cF, 2, 0, 0, false);
        }
        if (dz == 0 || dz == this.size - 1) {
            this.a(world, sbb, dx - 2, dy - 1, dz, dx + 2, dy + 3, dz, this.deco.accentID, this.deco.accentMeta, 0, 0, false);
            this.a(world, sbb, dx - 1, dy, dz, dx + 1, dy + 2, dz, TFBlocks.towerDevice.cF, 2, 0, 0, false);
        }
    }
    
    protected void makeReappearingDoorOpening(final abv world, final int dx, final int dy, final int dz, final age sbb) {
        this.nullifySkyLightAtCurrentPosition(world, dx - 3, dy - 1, dz - 3, dx + 3, dy + 3, dz + 3);
        if (dx == 0 || dx == this.size - 1) {
            this.a(world, sbb, dx, dy - 1, dz - 2, dx, dy + 3, dz + 2, this.deco.accentID, this.deco.accentMeta, 0, 0, false);
            this.a(world, sbb, dx, dy, dz - 1, dx, dy + 2, dz + 1, TFBlocks.towerDevice.cF, 0, 0, 0, false);
        }
        if (dz == 0 || dz == this.size - 1) {
            this.a(world, sbb, dx - 2, dy - 1, dz, dx + 2, dy + 3, dz, this.deco.accentID, this.deco.accentMeta, 0, 0, false);
            this.a(world, sbb, dx - 1, dy, dz, dx + 1, dy + 2, dz, TFBlocks.towerDevice.cF, 0, 0, 0, false);
        }
    }
    
    protected void makeLockedDoorOpening(final abv world, final int dx, final int dy, final int dz, final age sbb) {
        this.nullifySkyLightAtCurrentPosition(world, dx - 3, dy - 1, dz - 3, dx + 3, dy + 3, dz + 3);
        if (dx == 0 || dx == this.size - 1) {
            this.a(world, sbb, dx, dy - 1, dz - 2, dx, dy + 3, dz + 2, this.deco.accentID, this.deco.accentMeta, 0, 0, false);
            this.a(world, sbb, dx, dy, dz - 1, dx, dy + 2, dz + 1, TFBlocks.towerDevice.cF, 2, 0, 0, false);
            this.a(world, TFBlocks.towerDevice.cF, 4, dx, dy + 0, dz + 1, sbb);
            this.a(world, TFBlocks.towerDevice.cF, 4, dx, dy + 0, dz - 1, sbb);
            this.a(world, TFBlocks.towerDevice.cF, 4, dx, dy + 2, dz + 1, sbb);
            this.a(world, TFBlocks.towerDevice.cF, 4, dx, dy + 2, dz - 1, sbb);
        }
        if (dz == 0 || dz == this.size - 1) {
            this.a(world, sbb, dx - 2, dy - 1, dz, dx + 2, dy + 3, dz, this.deco.accentID, this.deco.accentMeta, 0, 0, false);
            this.a(world, sbb, dx - 1, dy, dz, dx + 1, dy + 2, dz, TFBlocks.towerDevice.cF, 2, 0, 0, false);
            this.a(world, TFBlocks.towerDevice.cF, 4, dx + 1, dy + 0, dz, sbb);
            this.a(world, TFBlocks.towerDevice.cF, 4, dx - 1, dy + 0, dz, sbb);
            this.a(world, TFBlocks.towerDevice.cF, 4, dx + 1, dy + 2, dz, sbb);
            this.a(world, TFBlocks.towerDevice.cF, 4, dx - 1, dy + 2, dz, sbb);
        }
    }
    
    @Override
    public boolean isDeadEnd() {
        int nonBalconies = 0;
        for (final EnumDarkTowerDoor type : this.openingTypes) {
            if (type != EnumDarkTowerDoor.REAPPEARING) {
                ++nonBalconies;
            }
        }
        return nonBalconies <= 1;
    }
    
    public boolean isKeyTower() {
        return this.keyTower;
    }
    
    public void setKeyTower(final boolean keyTower) {
        this.keyTower = keyTower;
    }
    
    protected int getLeverMeta(int rotation, final int direction) {
        if (direction == 0) {
            return 0;
        }
        if (direction == 1) {
            return 5;
        }
        rotation += this.getCoordBaseMode();
        rotation %= 4;
        if (rotation == 0) {
            switch (direction) {
                case 2: {
                    return 4;
                }
                case 3: {
                    return 3;
                }
                case 4: {
                    return 2;
                }
                case 5: {
                    return 1;
                }
            }
        }
        else if (rotation == 1) {
            switch (direction) {
                case 2: {
                    return 1;
                }
                case 3: {
                    return 2;
                }
                case 4: {
                    return 4;
                }
                case 5: {
                    return 3;
                }
            }
        }
        else if (rotation == 2) {
            switch (direction) {
                case 2: {
                    return 3;
                }
                case 3: {
                    return 4;
                }
                case 4: {
                    return 1;
                }
                case 5: {
                    return 2;
                }
            }
        }
        else if (rotation == 3) {
            switch (direction) {
                case 2: {
                    return 2;
                }
                case 3: {
                    return 1;
                }
                case 4: {
                    return 3;
                }
                case 5: {
                    return 4;
                }
            }
        }
        return -1;
    }
}
