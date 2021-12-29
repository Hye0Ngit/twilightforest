// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import java.util.List;
import java.util.Random;

public class ComponentTFDarkTowerMain extends ComponentTFDarkTowerWing
{
    public ComponentTFDarkTowerMain(final xv world, final Random rand, final int index, final int x, final int y, final int z) {
        this(world, rand, index, x, y, z, 0);
    }
    
    public ComponentTFDarkTowerMain(final xv world, final Random rand, final int index, final int x, final int y, final int z, final int rotation) {
        super(index, x, y, z, 15, 55 + rand.nextInt(32), rotation);
    }
    
    @Override
    public void a(final aes parent, final List list, final Random rand) {
        this.addOpening(0, 1, this.size / 2, 2);
        int mainDir = -1;
        if (this.c() < 2) {
            mainDir = rand.nextInt(4);
            final int[] dest = this.getValidOpening(rand, mainDir);
            this.makeNewMainTower(list, rand, this.c() + 1, dest[0], dest[1], dest[2], mainDir);
        }
        for (int i = 0; i < 4; ++i) {
            if (i != mainDir) {
                final int[] dest2 = this.getValidOpening(rand, i);
                final int childHeight = 21 + rand.nextInt(10);
                if (!this.makeTowerWing(list, rand, 1, dest2[0], dest2[1], dest2[2], 9, childHeight, i)) {
                    this.makeTowerWing(list, rand, 1, dest2[0], dest2[1], dest2[2], 7, childHeight, i);
                }
            }
        }
        if (this.c() > 0) {
            for (int i = 0; i < 4; ++i) {
                if (i != 2) {
                    final int[] dest2 = this.getValidOpening(rand, i);
                    dest2[1] = 1;
                    final int childHeight = 21 + rand.nextInt(10);
                    if (!this.makeTowerWing(list, rand, 1, dest2[0], dest2[1], dest2[2], 9, childHeight, i)) {
                        this.makeTowerWing(list, rand, 1, dest2[0], dest2[1], dest2[2], 7, childHeight, i);
                    }
                }
            }
            this.makeABeard(parent, list, rand);
        }
    }
    
    private boolean makeNewMainTower(final List list, final Random rand, final int index, final int x, final int y, final int z, final int rotation) {
        final int wingSize = 15;
        final int wingHeight = 55;
        final int direction = (this.getCoordBaseMode() + rotation) % 4;
        final int[] dx = this.offsetTowerCoords(x, y, z, 5, direction);
        final ComponentTFDarkTowerMainBridge bridge = new ComponentTFDarkTowerMainBridge(index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        list.add(bridge);
        bridge.a(this, list, rand);
        this.addOpening(x, y, z, rotation);
        return true;
    }
    
    @Override
    public boolean a(final xv world, final Random rand, final acg sbb) {
        final Random decoRNG = new Random(world.E() + this.e.a * 321534781 ^ (long)(this.e.c * 756839));
        this.makeEncasedWalls(world, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1);
        this.a(world, sbb, 1, 1, 1, this.size - 2, this.height - 2, this.size - 2);
        if (this.c() == 0) {
            for (int x = 0; x < this.size; ++x) {
                for (int z = 0; z < this.size; ++z) {
                    this.b(world, amj.z.cm, 0, x, -1, z, sbb);
                }
            }
        }
        for (int bx = this.e.a - 1; bx <= this.e.d + 1; ++bx) {
            for (int bz = this.e.c - 1; bz <= this.e.f + 1; ++bz) {
                for (int by = this.e.b - 1; by <= this.e.e + 1; ++by) {
                    world.b(yh.a, bx, by, bz, 0);
                }
            }
        }
        this.addHalfFloors(world, decoRNG, sbb, 0, 25);
        this.addHalfFloors(world, decoRNG, sbb, this.height - 26, this.height);
        this.makeOpenings(world, sbb);
        return true;
    }
}
