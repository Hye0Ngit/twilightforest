import java.util.List;
import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ComponentTFHollowHill extends StructureTFComponent
{
    int hsize;
    int radius;
    
    public ComponentTFHollowHill(final fq world, final Random rand, final int i, final int size, final int x, final int y, final int z) {
        super(i);
        this.h = 0;
        this.hsize = size;
        this.radius = (this.hsize * 2 + 1) * 8 - 6;
        this.g = StructureTFComponent.getComponentToAddBoundingBox(x, y, z, -this.radius, -3, -this.radius, this.radius * 2, 10, this.radius * 2, 0);
    }
    
    public void a(final ki structurecomponent, final List list, final Random random) {
        super.a(structurecomponent, list, random);
        final ComponentTFHillMaze maze = new ComponentTFHillMaze(1, this.g.a, this.g.b - 20, this.g.c, this.hsize);
    }
    
    public boolean a(final fq world, final Random rand, final vw sbb) {
        final int area = (int)(3.141592653589793 * this.radius * this.radius);
        final int sn = area / 16;
        final int[] mga = { 0, 3, 9, 18 };
        final int mg = mga[this.hsize];
        final int[] tca = { 0, 2, 6, 12 };
        final int tc = tca[this.hsize];
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
            this.generateStoneStalactite(world, 0.7, false, dest[0], 1, dest[1], sbb);
        }
        if (this.hsize == 3) {}
        return true;
    }
    
    private void generateTreasureChest(final fq world, final int x, final int y, final int z, final vw sbb) {
        final Random chestRNG = new Random(world.m() + x * z);
        this.placeTreasureAtCurrentPosition(world, chestRNG, x, y, z, TFTreasure.hill1, sbb);
    }
    
    protected void generateOreStalactite(final fq world, final int x, final int y, final int z, final vw sbb) {
        final int dx = this.a(x, z);
        final int dy = this.b(y);
        final int dz = this.b(x, z);
        if (sbb.b(dx, dy, dz) && world.a(dx, dy, dz) != ud.au.bO) {
            final Random stalRNG = new Random(world.m() + dx * dz);
            final TFGenCaveStalactite stalag = TFGenCaveStalactite.makeRandomOreStalactite(stalRNG, this.hsize);
            stalag.a(world, stalRNG, dx, dy, dz);
        }
    }
    
    protected void generateStoneStalactite(final fq world, final double length, final boolean up, final int x, final int y, final int z, final vw sbb) {
        final int dx = this.a(x, z);
        final int dy = this.b(y);
        final int dz = this.b(x, z);
        if (sbb.b(dx, dy, dz) && world.a(dx, dy, dz) != ud.au.bO) {
            final Random stalRNG = new Random(world.m() + dx * dz);
            new TFGenCaveStalactite(ud.v.bO, stalRNG.nextDouble() * length, up).a(world, stalRNG, dx, dy, dz);
        }
    }
    
    boolean isInHill(final int cx, final int cz) {
        final int dx = this.radius - cx;
        final int dz = this.radius - cz;
        final int dist = (int)Math.sqrt(dx * dx + dz * dz);
        return dist < this.radius;
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
        return this.getMobID(rand, this.hsize);
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
