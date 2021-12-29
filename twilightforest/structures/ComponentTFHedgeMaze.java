// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.TFTreasure;
import twilightforest.entity.TFCreatures;
import net.minecraft.block.Block;
import twilightforest.block.TFBlocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;

public class ComponentTFHedgeMaze extends StructureTFComponent
{
    static int MSIZE;
    static int RADIUS;
    static int DIAMETER;
    static int FLOOR_LEVEL;
    
    public ComponentTFHedgeMaze() {
    }
    
    public ComponentTFHedgeMaze(final World world, final Random rand, final int i, final int x, final int y, final int z) {
        super(i);
        this.setCoordBaseMode(0);
        this.field_74887_e = StructureTFComponent.getComponentToAddBoundingBox(x, y, z, -ComponentTFHedgeMaze.RADIUS, -3, -ComponentTFHedgeMaze.RADIUS, ComponentTFHedgeMaze.RADIUS * 2, 10, ComponentTFHedgeMaze.RADIUS * 2, 0);
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        final TFMaze maze = new TFMaze(ComponentTFHedgeMaze.MSIZE, ComponentTFHedgeMaze.MSIZE);
        maze.oddBias = 2;
        maze.torchBlockID = TFBlocks.firefly.field_71990_ca;
        maze.wallBlockID = TFBlocks.hedge.field_71990_ca;
        maze.wallBlockMeta = 0;
        maze.type = 4;
        maze.tall = 3;
        maze.roots = 3;
        maze.setSeed(world.func_72905_C() + this.field_74887_e.field_78897_a * this.field_74887_e.field_78896_c);
        for (int fx = 0; fx <= ComponentTFHedgeMaze.DIAMETER; ++fx) {
            for (int fz = 0; fz <= ComponentTFHedgeMaze.DIAMETER; ++fz) {
                this.func_74864_a(world, Block.field_71980_u.field_71990_ca, 0, fx, ComponentTFHedgeMaze.FLOOR_LEVEL - 1, fz, sbb);
            }
        }
        this.func_74864_a(world, Block.field_72008_bf.field_71990_ca, 1, 0, ComponentTFHedgeMaze.FLOOR_LEVEL, 24, sbb);
        this.func_74864_a(world, Block.field_72008_bf.field_71990_ca, 1, 0, ComponentTFHedgeMaze.FLOOR_LEVEL, 29, sbb);
        this.func_74864_a(world, Block.field_72008_bf.field_71990_ca, 3, 50, ComponentTFHedgeMaze.FLOOR_LEVEL, 24, sbb);
        this.func_74864_a(world, Block.field_72008_bf.field_71990_ca, 3, 50, ComponentTFHedgeMaze.FLOOR_LEVEL, 29, sbb);
        this.func_74864_a(world, Block.field_72008_bf.field_71990_ca, 2, 24, ComponentTFHedgeMaze.FLOOR_LEVEL, 0, sbb);
        this.func_74864_a(world, Block.field_72008_bf.field_71990_ca, 2, 29, ComponentTFHedgeMaze.FLOOR_LEVEL, 0, sbb);
        this.func_74864_a(world, Block.field_72008_bf.field_71990_ca, 0, 24, ComponentTFHedgeMaze.FLOOR_LEVEL, 50, sbb);
        this.func_74864_a(world, Block.field_72008_bf.field_71990_ca, 0, 29, ComponentTFHedgeMaze.FLOOR_LEVEL, 50, sbb);
        final int nrooms = ComponentTFHedgeMaze.MSIZE / 3;
        final int[] rcoords = new int[nrooms * 2];
        for (int i = 0; i < nrooms; ++i) {
            int rx;
            int rz;
            do {
                rx = maze.rand.nextInt(ComponentTFHedgeMaze.MSIZE - 2) + 1;
                rz = maze.rand.nextInt(ComponentTFHedgeMaze.MSIZE - 2) + 1;
            } while (this.isNearRoom(rx, rz, rcoords));
            maze.carveRoom1(rx, rz);
            rcoords[i * 2] = rx;
            rcoords[i * 2 + 1] = rz;
        }
        maze.generateRecursiveBacktracker(0, 0);
        maze.add4Exits();
        maze.copyToStructure(world, 1, ComponentTFHedgeMaze.FLOOR_LEVEL, 1, this, sbb);
        this.decorate3x3Rooms(world, rcoords, sbb);
        return true;
    }
    
    protected boolean isNearRoom(final int dx, final int dz, final int[] rcoords) {
        if (dx == 1 && dz == 1) {
            return true;
        }
        for (int i = 0; i < rcoords.length / 2; ++i) {
            final int rx = rcoords[i * 2];
            final int rz = rcoords[i * 2 + 1];
            if (rx != 0 || rz != 0) {
                if (Math.abs(dx - rx) < 3 && Math.abs(dz - rz) < 3) {
                    return true;
                }
            }
        }
        return false;
    }
    
    void decorate3x3Rooms(final World world, final int[] rcoords, final StructureBoundingBox sbb) {
        for (int i = 0; i < rcoords.length / 2; ++i) {
            int dx = rcoords[i * 2];
            int dz = rcoords[i * 2 + 1];
            dx = dx * 3 + 3;
            dz = dz * 3 + 3;
            this.decorate3x3Room(world, dx, dz, sbb);
        }
    }
    
    void decorate3x3Room(final World world, final int x, final int z, final StructureBoundingBox sbb) {
        final Random roomRNG = new Random(world.func_72905_C() ^ (long)(x + z));
        this.roomJackO(world, roomRNG, x, z, 8, sbb);
        if (roomRNG.nextInt(4) == 0) {
            this.roomJackO(world, roomRNG, x, z, 8, sbb);
        }
        this.roomSpawner(world, roomRNG, x, z, 8, sbb);
        this.roomTreasure(world, roomRNG, x, z, 8, sbb);
        if (roomRNG.nextInt(4) == 0) {
            this.roomTreasure(world, roomRNG, x, z, 8, sbb);
        }
    }
    
    private void roomSpawner(final World world, final Random rand, final int x, final int z, final int diameter, final StructureBoundingBox sbb) {
        final int rx = x + rand.nextInt(diameter) - diameter / 2;
        final int rz = z + rand.nextInt(diameter) - diameter / 2;
        String mobID = null;
        switch (rand.nextInt(3)) {
            case 1: {
                mobID = TFCreatures.getSpawnerNameFor("Swarm Spider");
                break;
            }
            case 2: {
                mobID = TFCreatures.getSpawnerNameFor("Hostile Wolf");
                break;
            }
            default: {
                mobID = TFCreatures.getSpawnerNameFor("Hedge Spider");
                break;
            }
        }
        this.placeSpawnerAtCurrentPosition(world, rand, rx, ComponentTFHedgeMaze.FLOOR_LEVEL, rz, mobID, sbb);
    }
    
    private void roomTreasure(final World world, final Random rand, final int x, final int z, final int diameter, final StructureBoundingBox sbb) {
        final int rx = x + rand.nextInt(diameter) - diameter / 2;
        final int rz = z + rand.nextInt(diameter) - diameter / 2;
        this.placeTreasureAtCurrentPosition(world, rand, rx, ComponentTFHedgeMaze.FLOOR_LEVEL, rz, TFTreasure.hedgemaze, sbb);
    }
    
    private void roomJackO(final World world, final Random rand, final int x, final int z, final int diameter, final StructureBoundingBox sbb) {
        final int rx = x + rand.nextInt(diameter) - diameter / 2;
        final int rz = z + rand.nextInt(diameter) - diameter / 2;
        this.func_74864_a(world, Block.field_72008_bf.field_71990_ca, rand.nextInt(4), rx, ComponentTFHedgeMaze.FLOOR_LEVEL, rz, sbb);
    }
    
    static {
        ComponentTFHedgeMaze.MSIZE = 16;
        ComponentTFHedgeMaze.RADIUS = ComponentTFHedgeMaze.MSIZE / 2 * 3 + 1;
        ComponentTFHedgeMaze.DIAMETER = 2 * ComponentTFHedgeMaze.RADIUS;
        ComponentTFHedgeMaze.FLOOR_LEVEL = 3;
    }
}
