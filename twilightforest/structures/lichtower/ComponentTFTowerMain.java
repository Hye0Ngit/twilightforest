// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.lichtower;

import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import twilightforest.block.TFBlocks;
import twilightforest.entity.TFCreatures;
import net.minecraft.block.Block;
import twilightforest.structures.StructureTFComponent;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import java.util.Random;
import net.minecraft.world.World;

public class ComponentTFTowerMain extends ComponentTFTowerWing
{
    public ComponentTFTowerMain() {
    }
    
    public ComponentTFTowerMain(final World world, final Random rand, final int index, final int x, final int y, final int z) {
        super(index, x, y, z, 15, 55 + rand.nextInt(32), 0);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
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
        final StructureComponent intersect = StructureComponent.func_74883_a(list, outbuilding.func_74874_b());
        if (intersect == null || intersect == this) {
            list.add(outbuilding);
            outbuilding.func_74861_a(this, list, rand);
            this.addOpening(x, y, z, rotation);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.func_74882_a(world, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1, false, rand, StructureTFComponent.getStrongholdStones());
        this.func_74878_a(world, sbb, 1, 1, 1, this.size - 2, this.height - 2, this.size - 2);
        for (int x = 0; x < this.size; ++x) {
            for (int z = 0; z < this.size; ++z) {
                this.func_74870_b(world, Block.field_71978_w.field_71990_ca, 0, x, -1, z, sbb);
            }
        }
        this.nullifySkyLightForBoundingBox(world);
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
    
    protected void makeStairwayCrossings(final World world, final Random rand, final StructureBoundingBox sbb) {
        for (int flights = this.highestOpening / 5 - 2, i = 2 + rand.nextInt(2); i < flights; i += 1 + rand.nextInt(5)) {
            this.makeStairCrossing(world, rand, i, sbb);
        }
    }
    
    protected void makeStairCrossing(final World world, final Random rand, final int flight, final StructureBoundingBox sbb) {
        final int temp = this.getCoordBaseMode();
        if (flight % 2 == 0) {
            this.setCoordBaseMode((this.getCoordBaseMode() + 1) % 4);
        }
        final int floorMeta = (rand.nextInt(2) == 0) ? 0 : 2;
        int floorLevel = 0 + flight * 5;
        for (int dx = 6; dx <= 8; ++dx) {
            for (int dz = 4; dz <= 10; ++dz) {
                this.func_74864_a(world, Block.field_72085_aj.field_71990_ca, floorMeta, dx, floorLevel, dz, sbb);
            }
        }
        ++floorLevel;
        int dx = 6;
        for (int dz = 3; dz <= 11; ++dz) {
            this.func_74864_a(world, Block.field_72031_aZ.field_71990_ca, 0, dx, floorLevel, dz, sbb);
        }
        ++dx;
        for (int dz = 3; dz <= 11; ++dz) {
            this.func_74864_a(world, 0, 0, dx, floorLevel, dz, sbb);
        }
        ++dx;
        for (int dz = 3; dz <= 11; ++dz) {
            this.func_74864_a(world, Block.field_72031_aZ.field_71990_ca, 0, dx, floorLevel, dz, sbb);
        }
        this.func_74864_a(world, Block.field_72085_aj.field_71990_ca, floorMeta, 6, floorLevel - 1, 11, sbb);
        this.func_74864_a(world, Block.field_72085_aj.field_71990_ca, floorMeta, 8, floorLevel - 1, 3, sbb);
        this.func_74864_a(world, Block.field_72031_aZ.field_71990_ca, 0, 5, floorLevel, 11, sbb);
        this.func_74864_a(world, Block.field_72031_aZ.field_71990_ca, 0, 9, floorLevel, 3, sbb);
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
        this.func_74864_a(world, Block.field_72031_aZ.field_71990_ca, 0, 6, floorLevel + 1, 7, sbb);
        this.func_74864_a(world, Block.field_72031_aZ.field_71990_ca, 0, 8, floorLevel + 1, 7, sbb);
        this.func_74864_a(world, Block.field_72031_aZ.field_71990_ca, 0, 6, floorLevel + 2, 7, sbb);
        this.func_74864_a(world, Block.field_72031_aZ.field_71990_ca, 0, 8, floorLevel + 2, 7, sbb);
        this.setCoordBaseMode(temp);
    }
    
    protected void makeLichRoom(final World world, final Random rand, final StructureBoundingBox sbb) {
        final int floorLevel = 2 + this.highestOpening / 5 * 5;
        this.makeLichFloor(world, floorLevel, this.highestOpening / 5 % 2, sbb);
        this.decorateLichChandelier(world, floorLevel, sbb);
        this.decoratePaintings(world, rand, floorLevel, sbb);
        this.decorateTorches(world, rand, floorLevel, sbb);
        this.func_74864_a(world, TFBlocks.bossSpawner.field_71990_ca, 1, this.size / 2, floorLevel + 2, this.size / 2, sbb);
    }
    
    protected void makeTowerPaintings(final World world, final Random rand, final StructureBoundingBox sbb) {
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
    
    protected void makeLichFloor(final World world, final int floorLevel, final int rotation, final StructureBoundingBox sbb) {
        final int temp = this.getCoordBaseMode();
        this.setCoordBaseMode((this.getCoordBaseMode() + rotation) % 4);
        for (int fx = 1; fx < 14; ++fx) {
            for (int fz = 1; fz < 14; ++fz) {
                if ((fx == 1 || fx == 2) && fz >= 6 && fz <= 12) {
                    if (fz == 6) {
                        this.func_74864_a(world, Block.field_72092_bO.field_71990_ca, 10, fx, floorLevel, fz, sbb);
                    }
                }
                else if ((fx == 12 || fx == 13) && fz >= 3 && fz <= 8) {
                    if (fz == 8) {
                        this.func_74864_a(world, Block.field_72092_bO.field_71990_ca, 10, fx, floorLevel, fz, sbb);
                    }
                }
                else if (fx >= 4 && fx <= 10 && fz >= 4 && fz <= 10) {
                    if ((fx == 4 && fz == 4) || (fx == 10 && fz == 10)) {
                        this.func_74864_a(world, Block.field_71988_x.field_71990_ca, 2, fx, floorLevel, fz, sbb);
                    }
                    else {
                        this.func_74864_a(world, Block.field_71946_M.field_71990_ca, 0, fx, floorLevel, fz, sbb);
                    }
                }
                else if ((fx == 2 || fx == 3) && (fz == 2 || fz == 3)) {
                    this.func_74864_a(world, Block.field_71946_M.field_71990_ca, 0, fx, floorLevel, fz, sbb);
                }
                else if ((fx == 11 || fx == 12) && (fz == 11 || fz == 12)) {
                    this.func_74864_a(world, Block.field_71946_M.field_71990_ca, 0, fx, floorLevel, fz, sbb);
                }
                else {
                    this.func_74864_a(world, Block.field_71988_x.field_71990_ca, 2, fx, floorLevel, fz, sbb);
                }
            }
        }
        this.func_74864_a(world, 0, 0, 3, floorLevel + 1, 11, sbb);
        this.func_74864_a(world, 0, 0, 3, floorLevel + 1, 10, sbb);
        this.func_74864_a(world, 0, 0, 3, floorLevel + 2, 11, sbb);
        this.func_74864_a(world, 0, 0, 11, floorLevel + 1, 3, sbb);
        this.func_74864_a(world, 0, 0, 11, floorLevel + 1, 4, sbb);
        this.func_74864_a(world, 0, 0, 11, floorLevel + 2, 3, sbb);
        this.setCoordBaseMode(temp);
    }
    
    protected void decorateLichChandelier(final World world, final int floorLevel, final StructureBoundingBox sbb) {
        final int cx = this.size / 2;
        int cy = floorLevel + 4;
        final int cz = this.size / 2;
        this.func_74864_a(world, Block.field_72031_aZ.field_71990_ca, 0, cx + 1, cy, cz + 0, sbb);
        this.func_74864_a(world, Block.field_72031_aZ.field_71990_ca, 0, cx + 2, cy, cz + 0, sbb);
        this.func_74864_a(world, Block.field_72031_aZ.field_71990_ca, 0, cx + 1, cy, cz + 1, sbb);
        this.func_74864_a(world, Block.field_72031_aZ.field_71990_ca, 0, cx + 0, cy, cz + 1, sbb);
        this.func_74864_a(world, Block.field_72031_aZ.field_71990_ca, 0, cx + 0, cy, cz + 2, sbb);
        this.func_74864_a(world, Block.field_72031_aZ.field_71990_ca, 0, cx - 1, cy, cz + 1, sbb);
        this.func_74864_a(world, Block.field_72031_aZ.field_71990_ca, 0, cx - 1, cy, cz + 0, sbb);
        this.func_74864_a(world, Block.field_72031_aZ.field_71990_ca, 0, cx - 2, cy, cz + 0, sbb);
        this.func_74864_a(world, Block.field_72031_aZ.field_71990_ca, 0, cx - 1, cy, cz - 1, sbb);
        this.func_74864_a(world, Block.field_72031_aZ.field_71990_ca, 0, cx + 0, cy, cz - 1, sbb);
        this.func_74864_a(world, Block.field_72031_aZ.field_71990_ca, 0, cx + 0, cy, cz - 2, sbb);
        this.func_74864_a(world, Block.field_72031_aZ.field_71990_ca, 0, cx + 1, cy, cz - 1, sbb);
        ++cy;
        this.func_74864_a(world, Block.field_72031_aZ.field_71990_ca, 0, cx + 1, cy, cz + 0, sbb);
        this.func_74864_a(world, Block.field_72069_aq.field_71990_ca, 0, cx + 2, cy, cz + 0, sbb);
        this.func_74864_a(world, Block.field_72069_aq.field_71990_ca, 0, cx + 1, cy, cz + 1, sbb);
        this.func_74864_a(world, Block.field_72031_aZ.field_71990_ca, 0, cx + 0, cy, cz + 1, sbb);
        this.func_74864_a(world, Block.field_72069_aq.field_71990_ca, 0, cx + 0, cy, cz + 2, sbb);
        this.func_74864_a(world, Block.field_72069_aq.field_71990_ca, 0, cx - 1, cy, cz + 1, sbb);
        this.func_74864_a(world, Block.field_72031_aZ.field_71990_ca, 0, cx - 1, cy, cz + 0, sbb);
        this.func_74864_a(world, Block.field_72069_aq.field_71990_ca, 0, cx - 2, cy, cz + 0, sbb);
        this.func_74864_a(world, Block.field_72069_aq.field_71990_ca, 0, cx - 1, cy, cz - 1, sbb);
        this.func_74864_a(world, Block.field_72031_aZ.field_71990_ca, 0, cx + 0, cy, cz - 1, sbb);
        this.func_74864_a(world, Block.field_72069_aq.field_71990_ca, 0, cx + 0, cy, cz - 2, sbb);
        this.func_74864_a(world, Block.field_72069_aq.field_71990_ca, 0, cx + 1, cy, cz - 1, sbb);
        ++cy;
        this.func_74864_a(world, Block.field_72069_aq.field_71990_ca, 0, cx + 1, cy, cz + 0, sbb);
        this.func_74864_a(world, Block.field_72069_aq.field_71990_ca, 0, cx + 0, cy, cz + 1, sbb);
        this.func_74864_a(world, Block.field_72069_aq.field_71990_ca, 0, cx - 1, cy, cz + 0, sbb);
        this.func_74864_a(world, Block.field_72069_aq.field_71990_ca, 0, cx + 0, cy, cz - 1, sbb);
        for (int y = floorLevel + 5; y < this.height - 1; ++y) {
            this.func_74864_a(world, Block.field_72031_aZ.field_71990_ca, 0, cx + 0, y, cz + 0, sbb);
        }
    }
    
    protected void decoratePaintings(final World world, final Random rand, final int floorLevel, final StructureBoundingBox sbb) {
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
    
    protected void decorateTorches(final World world, final Random rand, final int floorLevel, final StructureBoundingBox sbb) {
        this.generateTorchesOnWall(world, rand, floorLevel, 0, sbb);
        this.generateTorchesOnWall(world, rand, floorLevel, 1, sbb);
        this.generateTorchesOnWall(world, rand, floorLevel, 2, sbb);
        this.generateTorchesOnWall(world, rand, floorLevel, 3, sbb);
    }
    
    protected void generateTorchesOnWall(final World world, final Random rand, final int floorLevel, final int direction, final StructureBoundingBox sbb) {
        for (int i = 0; i < 10; ++i) {
            final ChunkCoordinates wCoords = this.getRandomWallSpot(rand, floorLevel, direction, sbb);
            final ChunkCoordinates tCoords = new ChunkCoordinates(wCoords);
            if (direction == 0) {
                final ChunkCoordinates chunkCoordinates = tCoords;
                ++chunkCoordinates.field_71573_c;
            }
            if (direction == 1) {
                final ChunkCoordinates chunkCoordinates2 = tCoords;
                --chunkCoordinates2.field_71574_a;
            }
            if (direction == 2) {
                final ChunkCoordinates chunkCoordinates3 = tCoords;
                --chunkCoordinates3.field_71573_c;
            }
            if (direction == 3) {
                final ChunkCoordinates chunkCoordinates4 = tCoords;
                ++chunkCoordinates4.field_71574_a;
            }
            final AxisAlignedBB torchBox = AxisAlignedBB.func_72330_a((double)tCoords.field_71574_a, (double)tCoords.field_71572_b, (double)tCoords.field_71573_c, tCoords.field_71574_a + 1.0, tCoords.field_71572_b + 2.0, tCoords.field_71573_c + 1.0);
            if (world.func_72798_a(tCoords.field_71574_a, tCoords.field_71572_b, tCoords.field_71573_c) == 0 && world.func_72798_a(tCoords.field_71574_a, tCoords.field_71572_b + 1, tCoords.field_71573_c) == 0 && world.func_72839_b((Entity)null, torchBox).size() == 0) {
                world.func_72832_d(tCoords.field_71574_a, tCoords.field_71572_b, tCoords.field_71573_c, Block.field_72031_aZ.field_71990_ca, 0, 2);
                world.func_72832_d(tCoords.field_71574_a, tCoords.field_71572_b + 1, tCoords.field_71573_c, Block.field_72069_aq.field_71990_ca, 5, 2);
            }
        }
    }
}
