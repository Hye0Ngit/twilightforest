import java.util.List;
import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ComponentTFHollowHill extends StructureTFComponent
{
    int hillSize;
    int radius;
    
    public ComponentTFHollowHill(final ge world, final Random rand, final int i, final int size, final int x, final int y, final int z) {
        super(i);
        this.h = 0;
        this.hillSize = size;
        this.radius = (this.hillSize * 2 + 1) * 8 - 6;
        this.g = StructureTFComponent.getComponentToAddBoundingBox(x, y, z, -this.radius, -3, -this.radius, this.radius * 2, 10, this.radius * 2, 0);
    }
    
    public void a(final ln structurecomponent, final List list, final Random random) {
        super.a(structurecomponent, list, random);
        final ComponentTFHillMaze maze = new ComponentTFHillMaze(1, this.g.a + (this.g.d - this.g.a) / 2, this.g.b - 20, this.g.c + (this.g.f - this.g.c) / 2, this.hillSize);
        list.add(maze);
        maze.a((ln)this, list, random);
    }
    
    public boolean a(final ge world, final Random rand, final xv sbb) {
        final int[] sna = { 0, 128, 256, 512 };
        final int sn = sna[this.hillSize];
        final int[] mga = { 0, 1, 4, 9 };
        final int mg = mga[this.hillSize];
        final int[] tca = { 0, 2, 6, 12 };
        final int tc = tca[this.hillSize];
        for (int i = 0; i < mg; ++i) {
            final int[] dest = this.getCoordsInHill2D(rand);
            final String mobID = this.getMobID(rand);
            this.placeSpawnerAtCurrentPosition(world, rand, dest[0], rand.nextInt(4), dest[1], mobID, sbb);
        }
        for (int i = 0; i < tc; ++i) {
            final int[] dest = this.getCoordsInHill2D(rand);
            this.generateTreasureChest(world, dest[0], 0, dest[1], sbb);
        }
        for (int i = 0; i < sn; ++i) {
            final int[] dest = this.getCoordsInHill2D(rand);
            this.generateOreStalactite(world, dest[0], 1, dest[1], sbb);
        }
        for (int i = 0; i < sn; ++i) {
            final int[] dest = this.getCoordsInHill2D(rand);
            this.generateStoneStalactite(world, 1.0, true, dest[0], 1, dest[1], sbb);
        }
        for (int i = 0; i < sn; ++i) {
            final int[] dest = this.getCoordsInHill2D(rand);
            this.generateStoneStalactite(world, 0.9, false, dest[0], 1, dest[1], sbb);
        }
        if (this.hillSize == 3) {}
        return true;
    }
    
    private void generateTreasureChest(final ge world, final int x, final int y, final int z, final xv sbb) {
        final Random chestRNG = new Random(world.n() + x * z);
        this.placeTreasureAtCurrentPosition(world, chestRNG, x, y, z, TFTreasure.hill1, sbb);
        this.b(world, vz.w.bO, 0, x, y - 1, z, sbb);
    }
    
    protected void generateOreStalactite(final ge world, final int x, final int y, final int z, final xv sbb) {
        final int dx = this.a(x, z);
        final int dy = this.b(y);
        final int dz = this.b(x, z);
        if (sbb.b(dx, dy, dz) && world.a(dx, dy, dz) != vz.as.bO) {
            final Random stalRNG = new Random(world.n() + dx * dz);
            final TFGenCaveStalactite stalag = TFGenCaveStalactite.makeRandomOreStalactite(stalRNG, this.hillSize);
            stalag.a(world, stalRNG, dx, dy, dz);
        }
    }
    
    protected void generateStoneStalactite(final ge world, double length, final boolean up, final int x, final int y, final int z, final xv sbb) {
        final int dx = this.a(x, z);
        final int dy = this.b(y);
        final int dz = this.b(x, z);
        if (sbb.b(dx, dy, dz) && world.a(dx, dy, dz) != vz.as.bO) {
            final Random stalRNG = new Random(world.n() + dx * dz);
            if (this.hillSize == 1) {
                length *= 1.9;
            }
            new TFGenCaveStalactite(vz.t.bO, stalRNG.nextDouble() * length, up).a(world, stalRNG, dx, dy, dz);
        }
    }
    
    boolean isInHill(final int cx, final int cz) {
        final int dx = this.radius - cx;
        final int dz = this.radius - cz;
        final int dist = (int)Math.sqrt(dx * dx + dz * dz);
        return dist < this.radius;
    }
    
    boolean isInHill(final int mapX, final int mapY, final int mapZ) {
        final int dx = this.g.a + this.radius - mapX;
        final int dy = (this.g.b - mapY) * 2;
        final int dz = this.g.c + this.radius - mapZ;
        final int dist = dx * dx + dy * dy + dz * dz;
        return dist < this.radius * this.radius;
    }
    
    int[] getCoordsInHill2D(final Random rand) {
        return this.getCoordsInHill2D(rand, this.radius);
    }
    
    int[] getCoordsInHill2D(final Random rand, final int rad) {
        int rx;
        int rz;
        do {
            rx = rand.nextInt(2 * rad);
            rz = rand.nextInt(2 * rad);
        } while (!this.isInHill(rx, rz));
        final int[] coords = { rx, rz };
        return coords;
    }
    
    protected String getMobID(final Random rand) {
        return this.getMobID(rand, this.hillSize);
    }
    
    protected String getMobID(final Random rand, final int level) {
        if (level == 1) {
            return this.getLevel1Mob(rand);
        }
        if (level == 2) {
            return this.getLevel2Mob(rand);
        }
        if (level == 3) {
            return this.getLevel3Mob(rand);
        }
        return "Spider";
    }
    
    public String getLevel1Mob(final Random rand) {
        switch (rand.nextInt(10)) {
            case 0:
            case 1:
            case 2: {
                return "Swarm Spider";
            }
            case 3:
            case 4:
            case 5: {
                return "Spider";
            }
            case 6:
            case 7: {
                return "Zombie";
            }
            case 8: {
                return "Silverfish";
            }
            case 9: {
                return "Redcap";
            }
            default: {
                return "Swarm Spider";
            }
        }
    }
    
    public String getLevel2Mob(final Random rand) {
        switch (rand.nextInt(10)) {
            case 0:
            case 1:
            case 2: {
                return "Redcap";
            }
            case 3:
            case 4:
            case 5: {
                return "Zombie";
            }
            case 6:
            case 7: {
                return "Skeleton";
            }
            case 8: {
                return "Swarm Spider";
            }
            case 9: {
                return "CaveSpider";
            }
            default: {
                return "Redcap";
            }
        }
    }
    
    public String getLevel3Mob(final Random rand) {
        switch (rand.nextInt(11)) {
            case 0:
            case 1:
            case 2: {
                return "Enderman";
            }
            case 3:
            case 4:
            case 5: {
                return "Skeleton";
            }
            case 6:
            case 7:
            case 8: {
                return "CaveSpider";
            }
            case 9: {
                return "Creeper";
            }
            case 10: {
                return "Twilight Wraith";
            }
            default: {
                return "Enderman";
            }
        }
    }
}
