import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ComponentTFNagaCourtyard extends StructureTFComponent
{
    static int RADIUS;
    static int DIAMETER;
    
    public ComponentTFNagaCourtyard(final ge world, final Random rand, final int i, final int x, final int y, final int z) {
        super(i);
        this.h = 0;
        this.g = StructureTFComponent.getComponentToAddBoundingBox(x, y, z, -ComponentTFNagaCourtyard.RADIUS, -1, -ComponentTFNagaCourtyard.RADIUS, ComponentTFNagaCourtyard.RADIUS * 2, 10, ComponentTFNagaCourtyard.RADIUS * 2, 0);
    }
    
    public boolean a(final ge world, final Random rand, final xv sbb) {
        for (int fx = 0; fx <= ComponentTFNagaCourtyard.DIAMETER; ++fx) {
            for (int fz = 0; fz <= ComponentTFNagaCourtyard.DIAMETER; ++fz) {
                if (rand.nextInt(3) == 0) {
                    this.a(world, vz.aj.bO, 0, fx, 0, fz, sbb);
                    if (rand.nextInt(20) == 0) {
                        this.a(world, vz.ak.bO, 0, fx, 1, fz, sbb);
                    }
                    else {
                        this.a(world, 0, 0, fx, 1, fz, sbb);
                    }
                }
                else {
                    this.a(world, vz.u.bO, 0, fx, 0, fz, sbb);
                }
            }
        }
        for (int fx = 0; fx <= ComponentTFNagaCourtyard.DIAMETER; ++fx) {
            this.randomBrick(world, rand, fx, 0, ComponentTFNagaCourtyard.DIAMETER, sbb);
            this.randomBrick(world, rand, fx, 0, 0, sbb);
            this.randomBrick(world, rand, fx, 1, ComponentTFNagaCourtyard.DIAMETER, sbb);
            this.randomBrick(world, rand, fx, 1, 0, sbb);
            if (fx % 2 == 0) {
                this.a(world, vz.ak.bO, 5, fx, 2, ComponentTFNagaCourtyard.DIAMETER, sbb);
                this.a(world, vz.bm.bO, 0, fx, 2, 0, sbb);
            }
            else {
                this.a(world, vz.ak.bO, 5, fx, 2, 0, sbb);
                this.a(world, vz.bm.bO, 0, fx, 2, ComponentTFNagaCourtyard.DIAMETER, sbb);
            }
        }
        for (int fz2 = 0; fz2 <= ComponentTFNagaCourtyard.DIAMETER; ++fz2) {
            this.randomBrick(world, rand, ComponentTFNagaCourtyard.DIAMETER, 0, fz2, sbb);
            this.randomBrick(world, rand, 0, 0, fz2, sbb);
            this.randomBrick(world, rand, ComponentTFNagaCourtyard.DIAMETER, 1, fz2, sbb);
            this.randomBrick(world, rand, 0, 1, fz2, sbb);
            if (fz2 % 2 == 0) {
                this.a(world, vz.ak.bO, 5, ComponentTFNagaCourtyard.DIAMETER, 2, fz2, sbb);
                this.a(world, vz.bm.bO, 0, 0, 2, fz2, sbb);
            }
            else {
                this.a(world, vz.ak.bO, 5, 0, 2, fz2, sbb);
                this.a(world, vz.bm.bO, 0, ComponentTFNagaCourtyard.DIAMETER, 2, fz2, sbb);
            }
        }
        final Random pillarRand = new Random(world.n() + this.g.a * this.g.c);
        for (int i = 0; i < 20; ++i) {
            final int rx = 2 + pillarRand.nextInt(ComponentTFNagaCourtyard.DIAMETER - 4);
            final int rz = 2 + pillarRand.nextInt(ComponentTFNagaCourtyard.DIAMETER - 4);
            this.makePillar(world, pillarRand, rx, 1, rz, sbb);
        }
        this.a(world, TFBlocks.bossSpawner.bO, 0, ComponentTFNagaCourtyard.RADIUS + 1, 2, ComponentTFNagaCourtyard.RADIUS + 1, sbb);
        return true;
    }
    
    public boolean makePillar(final ge world, final Random rand, final int x, final int y, final int z, final xv sbb) {
        final int height = 8;
        this.a(world, vz.ak.bO, 0, x - 1, y + 0, z - 1, sbb);
        this.a(world, vz.ak.bO, 0, x + 0, y + 0, z - 1, sbb);
        this.a(world, vz.ak.bO, 0, x + 1, y + 0, z - 1, sbb);
        this.a(world, vz.ak.bO, 0, x - 1, y + 0, z + 0, sbb);
        this.a(world, vz.ak.bO, 0, x + 1, y + 0, z + 0, sbb);
        this.a(world, vz.ak.bO, 0, x - 1, y + 0, z + 1, sbb);
        this.a(world, vz.ak.bO, 0, x + 0, y + 0, z + 1, sbb);
        this.a(world, vz.ak.bO, 0, x + 1, y + 0, z + 1, sbb);
        for (int i = 0; i < height; ++i) {
            this.randomBrick(world, rand, x, y + i, z, sbb);
            if (i > 0 && rand.nextInt(2) == 0) {
                switch (rand.nextInt(4)) {
                    case 0: {
                        this.a(world, vz.bu.bO, 8, x - 1, y + i, z + 0, sbb);
                        break;
                    }
                    case 1: {
                        this.a(world, vz.bu.bO, 2, x + 1, y + i, z + 0, sbb);
                        break;
                    }
                    case 2: {
                        this.a(world, vz.bu.bO, 4, x + 0, y + i, z + 1, sbb);
                        break;
                    }
                    case 3: {
                        this.a(world, vz.bu.bO, 1, x + 0, y + i, z - 1, sbb);
                        break;
                    }
                }
            }
            else if (i > 0 && rand.nextInt(4) == 0) {
                switch (rand.nextInt(4)) {
                    case 0: {
                        this.a(world, TFBlocks.firefly.bO, 0, x - 1, y + i, z + 0, sbb);
                        break;
                    }
                    case 1: {
                        this.a(world, TFBlocks.firefly.bO, 0, x + 1, y + i, z + 0, sbb);
                        break;
                    }
                    case 2: {
                        this.a(world, TFBlocks.firefly.bO, 0, x + 0, y + i, z + 1, sbb);
                        break;
                    }
                    case 3: {
                        this.a(world, TFBlocks.firefly.bO, 0, x + 0, y + i, z - 1, sbb);
                        break;
                    }
                }
            }
        }
        if (height == 8) {
            this.a(world, vz.ak.bO, 0, x - 1, y + 8, z - 1, sbb);
            this.a(world, vz.ak.bO, 0, x + 0, y + 8, z - 1, sbb);
            this.a(world, vz.ak.bO, 0, x + 1, y + 8, z - 1, sbb);
            this.a(world, vz.ak.bO, 0, x - 1, y + 8, z + 0, sbb);
            this.a(world, vz.ak.bO, 5, x + 0, y + 8, z + 0, sbb);
            this.a(world, vz.ak.bO, 0, x + 1, y + 8, z + 0, sbb);
            this.a(world, vz.ak.bO, 0, x - 1, y + 8, z + 1, sbb);
            this.a(world, vz.ak.bO, 0, x + 0, y + 8, z + 1, sbb);
            this.a(world, vz.ak.bO, 0, x + 1, y + 8, z + 1, sbb);
        }
        return true;
    }
    
    public void randomBrick(final ge world, final Random rand, final int x, final int y, final int z, final xv sbb) {
        this.a(world, vz.bm.bO, rand.nextInt(4), x, y, z, sbb);
    }
    
    static {
        ComponentTFNagaCourtyard.RADIUS = 46;
        ComponentTFNagaCourtyard.DIAMETER = 2 * ComponentTFNagaCourtyard.RADIUS + 1;
    }
}
