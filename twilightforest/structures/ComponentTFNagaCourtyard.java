// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.block.TFBlocks;
import java.util.Random;

public class ComponentTFNagaCourtyard extends StructureTFComponent
{
    static int RADIUS;
    static int DIAMETER;
    
    public ComponentTFNagaCourtyard(final yc world, final Random rand, final int i, final int x, final int y, final int z) {
        super(i);
        this.setCoordBaseMode(0);
        this.e = StructureTFComponent.getComponentToAddBoundingBox(x, y, z, -ComponentTFNagaCourtyard.RADIUS, -1, -ComponentTFNagaCourtyard.RADIUS, ComponentTFNagaCourtyard.RADIUS * 2, 10, ComponentTFNagaCourtyard.RADIUS * 2, 0);
    }
    
    public boolean a(final yc world, final Random rand, final acn sbb) {
        for (int fx = 0; fx <= ComponentTFNagaCourtyard.DIAMETER; ++fx) {
            for (int fz = 0; fz <= ComponentTFNagaCourtyard.DIAMETER; ++fz) {
                if (rand.nextInt(3) == 0) {
                    this.a(world, amq.am.cm, 0, fx, 0, fz, sbb);
                    if (rand.nextInt(20) == 0) {
                        this.a(world, amq.an.cm, 0, fx, 1, fz, sbb);
                    }
                    else {
                        this.a(world, 0, 0, fx, 1, fz, sbb);
                    }
                }
                else {
                    this.a(world, amq.x.cm, 0, fx, 0, fz, sbb);
                }
            }
        }
        for (int fx = 0; fx <= ComponentTFNagaCourtyard.DIAMETER; ++fx) {
            this.randomBrick(world, rand, fx, 0, ComponentTFNagaCourtyard.DIAMETER, sbb);
            this.randomBrick(world, rand, fx, 0, 0, sbb);
            this.randomBrick(world, rand, fx, 1, ComponentTFNagaCourtyard.DIAMETER, sbb);
            this.randomBrick(world, rand, fx, 1, 0, sbb);
            this.randomBrick(world, rand, fx, 2, ComponentTFNagaCourtyard.DIAMETER, sbb);
            this.randomBrick(world, rand, fx, 2, 0, sbb);
            this.randomBrick(world, rand, fx, 3, ComponentTFNagaCourtyard.DIAMETER, sbb);
            this.randomBrick(world, rand, fx, 3, 0, sbb);
            this.a(world, amq.an.cm, 5, fx, 4, ComponentTFNagaCourtyard.DIAMETER, sbb);
            this.a(world, amq.an.cm, 5, fx, 4, 0, sbb);
            switch (fx % 23) {
                case 2: {
                    this.a(world, TFBlocks.nagastone.cm, 7, fx, 3, ComponentTFNagaCourtyard.DIAMETER, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 7, fx, 3, 0, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 14, fx, 2, ComponentTFNagaCourtyard.DIAMETER, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 14, fx, 2, 0, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 11, fx, 1, ComponentTFNagaCourtyard.DIAMETER, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 11, fx, 1, 0, sbb);
                    break;
                }
                case 3: {
                    this.a(world, TFBlocks.nagastone.cm, 3, fx, 3, ComponentTFNagaCourtyard.DIAMETER, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 3, fx, 3, 0, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 12, fx, 1, ComponentTFNagaCourtyard.DIAMETER, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 12, fx, 1, 0, sbb);
                    break;
                }
                case 4:
                case 8:
                case 16:
                case 20: {
                    this.a(world, TFBlocks.nagastone.cm, 12, fx, 1, ComponentTFNagaCourtyard.DIAMETER, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 12, fx, 1, 0, sbb);
                    break;
                }
                case 5:
                case 9:
                case 17: {
                    this.a(world, TFBlocks.nagastone.cm, 7, fx, 3, ComponentTFNagaCourtyard.DIAMETER, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 7, fx, 3, 0, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 14, fx, 2, ComponentTFNagaCourtyard.DIAMETER, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 14, fx, 2, 0, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 10, fx, 1, ComponentTFNagaCourtyard.DIAMETER, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 10, fx, 1, 0, sbb);
                    break;
                }
                case 6:
                case 10:
                case 14:
                case 18: {
                    this.a(world, TFBlocks.nagastone.cm, 12, fx, 3, ComponentTFNagaCourtyard.DIAMETER, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 12, fx, 3, 0, sbb);
                    break;
                }
                case 7:
                case 15:
                case 19: {
                    this.a(world, TFBlocks.nagastone.cm, 6, fx, 3, ComponentTFNagaCourtyard.DIAMETER, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 6, fx, 3, 0, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 14, fx, 2, ComponentTFNagaCourtyard.DIAMETER, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 14, fx, 2, 0, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 11, fx, 1, ComponentTFNagaCourtyard.DIAMETER, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 11, fx, 1, 0, sbb);
                    break;
                }
                case 11: {
                    this.a(world, TFBlocks.nagastone.cm, 6, fx, 3, ComponentTFNagaCourtyard.DIAMETER, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 6, fx, 3, 0, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 14, fx, 2, ComponentTFNagaCourtyard.DIAMETER, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 14, fx, 2, 0, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 14, fx, 1, ComponentTFNagaCourtyard.DIAMETER, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 14, fx, 1, 0, sbb);
                    break;
                }
                case 13: {
                    this.a(world, TFBlocks.nagastone.cm, 7, fx, 3, ComponentTFNagaCourtyard.DIAMETER, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 7, fx, 3, 0, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 14, fx, 2, ComponentTFNagaCourtyard.DIAMETER, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 14, fx, 2, 0, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 14, fx, 1, ComponentTFNagaCourtyard.DIAMETER, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 14, fx, 1, 0, sbb);
                    break;
                }
                case 21: {
                    this.a(world, TFBlocks.nagastone.cm, 2, fx, 3, ComponentTFNagaCourtyard.DIAMETER, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 2, fx, 3, 0, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 12, fx, 1, ComponentTFNagaCourtyard.DIAMETER, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 12, fx, 1, 0, sbb);
                    break;
                }
                case 22: {
                    this.a(world, TFBlocks.nagastone.cm, 6, fx, 3, ComponentTFNagaCourtyard.DIAMETER, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 6, fx, 3, 0, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 14, fx, 2, ComponentTFNagaCourtyard.DIAMETER, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 14, fx, 2, 0, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 10, fx, 1, ComponentTFNagaCourtyard.DIAMETER, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 10, fx, 1, 0, sbb);
                    break;
                }
            }
        }
        for (int fz2 = 0; fz2 <= ComponentTFNagaCourtyard.DIAMETER; ++fz2) {
            this.randomBrick(world, rand, ComponentTFNagaCourtyard.DIAMETER, 0, fz2, sbb);
            this.randomBrick(world, rand, 0, 0, fz2, sbb);
            this.randomBrick(world, rand, ComponentTFNagaCourtyard.DIAMETER, 1, fz2, sbb);
            this.randomBrick(world, rand, 0, 1, fz2, sbb);
            this.randomBrick(world, rand, ComponentTFNagaCourtyard.DIAMETER, 2, fz2, sbb);
            this.randomBrick(world, rand, 0, 2, fz2, sbb);
            this.randomBrick(world, rand, ComponentTFNagaCourtyard.DIAMETER, 3, fz2, sbb);
            this.randomBrick(world, rand, 0, 3, fz2, sbb);
            this.a(world, amq.an.cm, 5, ComponentTFNagaCourtyard.DIAMETER, 4, fz2, sbb);
            this.a(world, amq.an.cm, 5, 0, 4, fz2, sbb);
            switch (fz2 % 23) {
                case 2: {
                    this.a(world, TFBlocks.nagastone.cm, 5, ComponentTFNagaCourtyard.DIAMETER, 3, fz2, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 5, 0, 3, fz2, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 14, ComponentTFNagaCourtyard.DIAMETER, 2, fz2, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 14, 0, 2, fz2, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 9, ComponentTFNagaCourtyard.DIAMETER, 1, fz2, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 9, 0, 1, fz2, sbb);
                    break;
                }
                case 3: {
                    this.a(world, TFBlocks.nagastone.cm, 1, ComponentTFNagaCourtyard.DIAMETER, 3, fz2, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 1, 0, 3, fz2, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 13, ComponentTFNagaCourtyard.DIAMETER, 1, fz2, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 13, 0, 1, fz2, sbb);
                    break;
                }
                case 4:
                case 8:
                case 16:
                case 20: {
                    this.a(world, TFBlocks.nagastone.cm, 13, ComponentTFNagaCourtyard.DIAMETER, 1, fz2, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 13, 0, 1, fz2, sbb);
                    break;
                }
                case 5:
                case 9:
                case 17: {
                    this.a(world, TFBlocks.nagastone.cm, 5, ComponentTFNagaCourtyard.DIAMETER, 3, fz2, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 5, 0, 3, fz2, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 14, ComponentTFNagaCourtyard.DIAMETER, 2, fz2, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 14, 0, 2, fz2, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 8, ComponentTFNagaCourtyard.DIAMETER, 1, fz2, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 8, 0, 1, fz2, sbb);
                    break;
                }
                case 6:
                case 10:
                case 14:
                case 18: {
                    this.a(world, TFBlocks.nagastone.cm, 13, ComponentTFNagaCourtyard.DIAMETER, 3, fz2, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 13, 0, 3, fz2, sbb);
                    break;
                }
                case 7:
                case 15:
                case 19: {
                    this.a(world, TFBlocks.nagastone.cm, 4, ComponentTFNagaCourtyard.DIAMETER, 3, fz2, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 4, 0, 3, fz2, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 14, ComponentTFNagaCourtyard.DIAMETER, 2, fz2, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 14, 0, 2, fz2, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 9, ComponentTFNagaCourtyard.DIAMETER, 1, fz2, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 9, 0, 1, fz2, sbb);
                    break;
                }
                case 11: {
                    this.a(world, TFBlocks.nagastone.cm, 4, ComponentTFNagaCourtyard.DIAMETER, 3, fz2, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 4, 0, 3, fz2, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 14, ComponentTFNagaCourtyard.DIAMETER, 2, fz2, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 14, 0, 2, fz2, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 14, ComponentTFNagaCourtyard.DIAMETER, 1, fz2, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 14, 0, 1, fz2, sbb);
                    break;
                }
                case 13: {
                    this.a(world, TFBlocks.nagastone.cm, 5, ComponentTFNagaCourtyard.DIAMETER, 3, fz2, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 5, 0, 3, fz2, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 14, ComponentTFNagaCourtyard.DIAMETER, 2, fz2, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 14, 0, 2, fz2, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 14, ComponentTFNagaCourtyard.DIAMETER, 1, fz2, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 14, 0, 1, fz2, sbb);
                    break;
                }
                case 21: {
                    this.a(world, TFBlocks.nagastone.cm, 0, ComponentTFNagaCourtyard.DIAMETER, 3, fz2, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 0, 0, 3, fz2, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 13, ComponentTFNagaCourtyard.DIAMETER, 1, fz2, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 13, 0, 1, fz2, sbb);
                    break;
                }
                case 22: {
                    this.a(world, TFBlocks.nagastone.cm, 4, ComponentTFNagaCourtyard.DIAMETER, 3, fz2, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 4, 0, 3, fz2, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 14, ComponentTFNagaCourtyard.DIAMETER, 2, fz2, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 14, 0, 2, fz2, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 8, ComponentTFNagaCourtyard.DIAMETER, 1, fz2, sbb);
                    this.a(world, TFBlocks.nagastone.cm, 8, 0, 1, fz2, sbb);
                    break;
                }
            }
        }
        final Random pillarRand = new Random(world.E() + this.e.a * this.e.c);
        for (int i = 0; i < 20; ++i) {
            final int rx = 2 + pillarRand.nextInt(ComponentTFNagaCourtyard.DIAMETER - 4);
            final int rz = 2 + pillarRand.nextInt(ComponentTFNagaCourtyard.DIAMETER - 4);
            this.makePillar(world, pillarRand, rx, 1, rz, sbb);
        }
        this.a(world, TFBlocks.bossSpawner.cm, 0, ComponentTFNagaCourtyard.RADIUS + 1, 2, ComponentTFNagaCourtyard.RADIUS + 1, sbb);
        return true;
    }
    
    public boolean makePillar(final yc world, final Random rand, final int x, final int y, final int z, final acn sbb) {
        final int height = 8;
        this.a(world, amq.an.cm, 0, x - 1, y + 0, z - 1, sbb);
        this.a(world, amq.an.cm, 0, x + 0, y + 0, z - 1, sbb);
        this.a(world, amq.an.cm, 0, x + 1, y + 0, z - 1, sbb);
        this.a(world, amq.an.cm, 0, x - 1, y + 0, z + 0, sbb);
        this.a(world, amq.an.cm, 0, x + 1, y + 0, z + 0, sbb);
        this.a(world, amq.an.cm, 0, x - 1, y + 0, z + 1, sbb);
        this.a(world, amq.an.cm, 0, x + 0, y + 0, z + 1, sbb);
        this.a(world, amq.an.cm, 0, x + 1, y + 0, z + 1, sbb);
        for (int i = 0; i < height; ++i) {
            this.randomBrick(world, rand, x, y + i, z, sbb);
            if (i > 0 && rand.nextInt(2) == 0) {
                switch (rand.nextInt(4)) {
                    case 0: {
                        this.a(world, amq.bx.cm, 8, x - 1, y + i, z + 0, sbb);
                        break;
                    }
                    case 1: {
                        this.a(world, amq.bx.cm, 2, x + 1, y + i, z + 0, sbb);
                        break;
                    }
                    case 2: {
                        this.a(world, amq.bx.cm, 4, x + 0, y + i, z + 1, sbb);
                        break;
                    }
                    case 3: {
                        this.a(world, amq.bx.cm, 1, x + 0, y + i, z - 1, sbb);
                        break;
                    }
                }
            }
            else if (i > 0 && rand.nextInt(4) == 0) {
                switch (rand.nextInt(4)) {
                    case 0: {
                        this.a(world, TFBlocks.firefly.cm, 0, x - 1, y + i, z + 0, sbb);
                        break;
                    }
                    case 1: {
                        this.a(world, TFBlocks.firefly.cm, 0, x + 1, y + i, z + 0, sbb);
                        break;
                    }
                    case 2: {
                        this.a(world, TFBlocks.firefly.cm, 0, x + 0, y + i, z + 1, sbb);
                        break;
                    }
                    case 3: {
                        this.a(world, TFBlocks.firefly.cm, 0, x + 0, y + i, z - 1, sbb);
                        break;
                    }
                }
            }
        }
        if (height == 8) {
            this.a(world, amq.an.cm, 0, x - 1, y + 8, z - 1, sbb);
            this.a(world, amq.an.cm, 0, x + 0, y + 8, z - 1, sbb);
            this.a(world, amq.an.cm, 0, x + 1, y + 8, z - 1, sbb);
            this.a(world, amq.an.cm, 0, x - 1, y + 8, z + 0, sbb);
            this.a(world, amq.an.cm, 5, x + 0, y + 8, z + 0, sbb);
            this.a(world, amq.an.cm, 0, x + 1, y + 8, z + 0, sbb);
            this.a(world, amq.an.cm, 0, x - 1, y + 8, z + 1, sbb);
            this.a(world, amq.an.cm, 0, x + 0, y + 8, z + 1, sbb);
            this.a(world, amq.an.cm, 0, x + 1, y + 8, z + 1, sbb);
        }
        return true;
    }
    
    public void randomBrick(final yc world, final Random rand, final int x, final int y, final int z, final acn sbb) {
        this.a(world, amq.bp.cm, rand.nextInt(3), x, y, z, sbb);
    }
    
    static {
        ComponentTFNagaCourtyard.RADIUS = 46;
        ComponentTFNagaCourtyard.DIAMETER = 2 * ComponentTFNagaCourtyard.RADIUS + 1;
    }
}
