// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.entity.EntityTFQuestRam;
import java.util.Random;

public class ComponentTFQuestGrove extends StructureTFComponent
{
    public static final int RADIUS = 13;
    protected boolean beastPlaced;
    protected boolean dispenserPlaced;
    
    public ComponentTFQuestGrove(final zv world, final Random rand, final int i, final int x, final int y, final int z) {
        super(i);
        this.beastPlaced = false;
        this.dispenserPlaced = false;
        this.setCoordBaseMode(0);
        this.e = StructureTFComponent.getComponentToAddBoundingBox(x, y, z, -13, 0, -13, 26, 10, 26, 0);
    }
    
    public boolean a(final zv world, final Random rand, final aee sbb) {
        for (int i = 0; i < 4; ++i) {
            this.makeWallSide(world, rand, i, sbb);
        }
        for (int x = 10; x < 17; ++x) {
            for (int z = 10; z < 17; ++z) {
                if (x == 10 || x == 16 || z == 10 || z == 16) {
                    if (rand.nextInt(2) > 0) {
                        this.a(world, aou.bq.cz, 1, x, -1, z, sbb);
                    }
                }
                else if (x == 11 || x == 15 || z == 11 || z == 15) {
                    if (rand.nextInt(3) > 0) {
                        this.a(world, aou.bq.cz, 1, x, -1, z, sbb);
                    }
                }
                else {
                    this.a(world, aou.bq.cz, 1, x, -1, z, sbb);
                }
            }
        }
        this.a(world, aou.aV.cz, 4, 13, 5, 19, sbb);
        this.a(world, aou.bq.cz, 1, 12, 7, 20, sbb);
        this.a(world, aou.bq.cz, 1, 13, 7, 20, sbb);
        this.a(world, aou.bq.cz, 1, 14, 7, 20, sbb);
        this.a(world, aou.bq.cz, 1, 12, 7, 21, sbb);
        this.a(world, aou.bq.cz, 1, 13, 7, 21, sbb);
        this.a(world, aou.bq.cz, 1, 14, 7, 21, sbb);
        if (!this.dispenserPlaced) {
            final int bx = this.a(13, 20);
            final int by = this.a(6);
            final int bz = this.b(13, 20);
            if (sbb.b(bx, by, bz)) {
                this.dispenserPlaced = true;
                world.f(bx, by, bz, aou.T.cz, 2, 4);
                final apw ted = (apw)world.r(bx, by, bz);
                for (int j = 0; j < 4; ++j) {
                    ted.a(j, new wg(aou.af, 1, rand.nextInt(16)));
                }
            }
        }
        if (!this.beastPlaced) {
            final int bx = this.a(13, 13);
            final int by = this.a(0);
            final int bz = this.b(13, 13);
            if (sbb.b(bx, by, bz)) {
                this.beastPlaced = true;
                final EntityTFQuestRam ram = new EntityTFQuestRam(world);
                ram.b((double)bx, (double)by, (double)bz);
                ram.b(bx, by, bz, 13);
                world.d((mp)ram);
            }
        }
        return true;
    }
    
    private void makeWallSide(final zv world, final Random rand, final int direction, final aee sbb) {
        final int temp = this.getCoordBaseMode();
        this.setCoordBaseMode(direction);
        this.placeOuterArch(world, 3, -1, sbb);
        this.placeOuterArch(world, 11, -1, sbb);
        this.placeOuterArch(world, 19, -1, sbb);
        this.a(world, aou.bq.cz, 3, 0, 0, 0, sbb);
        this.a(world, aou.bq.cz, 3, 0, 1, 0, sbb);
        this.a(world, aou.bq.cz, 3, 0, 2, 0, sbb);
        this.a(world, aou.bq.cz, 3, 0, 3, 0, sbb);
        this.a(world, aou.bq.cz, 3, 1, 3, 0, sbb);
        this.a(world, aou.bq.cz, 3, 2, 3, 0, sbb);
        this.a(world, aou.bq.cz, 3, 8, 3, 0, sbb);
        this.a(world, aou.bq.cz, 3, 9, 3, 0, sbb);
        this.a(world, aou.bq.cz, 3, 10, 3, 0, sbb);
        this.a(world, aou.bq.cz, 3, 16, 3, 0, sbb);
        this.a(world, aou.bq.cz, 3, 17, 3, 0, sbb);
        this.a(world, aou.bq.cz, 3, 18, 3, 0, sbb);
        this.a(world, aou.bq.cz, 3, 24, 3, 0, sbb);
        this.a(world, aou.bq.cz, 3, 25, 3, 0, sbb);
        for (int x = 0; x < 9; ++x) {
            for (int y = 0; y < 9; ++y) {
                for (int z = 0; z < 2; ++z) {
                    if (x == 0 || x == 1 || x == 7 || x == 8 || y == 0 || y == 1 || y == 7 || y == 8) {
                        this.a(world, aou.bq.cz, 1, x + 9, y - 2, z + 5, sbb);
                    }
                }
            }
        }
        this.a(world, aou.bq.cz, 3, 6, 0, 6, sbb);
        this.a(world, aou.bq.cz, 3, 6, 1, 6, sbb);
        this.a(world, aou.bq.cz, 3, 6, 2, 6, sbb);
        this.a(world, aou.bq.cz, 3, 6, 3, 6, sbb);
        this.a(world, aou.bq.cz, 3, 6, 4, 6, sbb);
        this.a(world, aou.bq.cz, 3, 7, 4, 6, sbb);
        this.a(world, aou.bq.cz, 3, 8, 4, 6, sbb);
        this.a(world, aou.bq.cz, 3, 18, 4, 6, sbb);
        this.a(world, aou.bq.cz, 3, 19, 4, 6, sbb);
        this.setCoordBaseMode(temp);
    }
    
    private void placeOuterArch(final zv world, final int ox, final int oy, final aee sbb) {
        for (int x = 0; x < 5; ++x) {
            for (int y = 0; y < 6; ++y) {
                if (x == 0 || x == 4 || y == 0 || y == 5) {
                    this.a(world, aou.bq.cz, 1, x + ox, y + oy, 0, sbb);
                }
            }
        }
    }
}
