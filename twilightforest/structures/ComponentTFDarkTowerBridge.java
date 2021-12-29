// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.TFBlocks;
import java.util.Random;
import java.util.List;

public class ComponentTFDarkTowerBridge extends ComponentTFTowerWing
{
    int dSize;
    int dHeight;
    
    protected ComponentTFDarkTowerBridge(final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final int direction) {
        super(i, x, y, z, 5, 5, direction);
        this.dSize = pSize;
        this.dHeight = pHeight;
    }
    
    @Override
    public void a(final aes parent, final List list, final Random rand) {
        this.makeTowerWing(list, rand, this.c(), 4, 1, 2, this.dSize, this.dHeight, 0);
    }
    
    @Override
    public boolean makeTowerWing(final List list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final int rotation) {
        if (wingHeight < 6) {
            return false;
        }
        final int direction = (this.getCoordBaseMode() + rotation) % 4;
        final int[] dx = this.offsetTowerCoords(x, y, z, wingSize, direction);
        if (dx[1] + wingHeight > 255) {
            return false;
        }
        final ComponentTFTowerWing wing = new ComponentTFDarkTowerWing(index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        final aes intersect = aes.a(list, wing.b());
        if (intersect == null || intersect == this) {
            list.add(wing);
            wing.a(this, list, rand);
            this.addOpening(x, y, z, rotation);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean a(final xv world, final Random rand, final acg sbb) {
        final int insideID = TFBlocks.towerWood.cm;
        final int insideMeta = 0;
        this.a(world, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1, insideID, insideMeta, false);
        final int frameID = TFBlocks.towerWood.cm;
        final int frameMeta = 1;
        for (int x = 0; x < this.size; ++x) {
            this.a(world, frameID, frameMeta, x, 0, 0, sbb);
            this.a(world, frameID, frameMeta, x, this.height - 1, 0, sbb);
            this.a(world, frameID, frameMeta, x, 0, this.size - 1, sbb);
            this.a(world, frameID, frameMeta, x, this.height - 1, this.size - 1, sbb);
        }
        for (int bx = this.e.a - 1; bx <= this.e.d + 1; ++bx) {
            for (int bz = this.e.c - 1; bz <= this.e.f + 1; ++bz) {
                for (int by = this.e.b - 1; by <= this.e.e + 1; ++by) {
                    world.b(yh.a, bx, by, bz, 0);
                }
            }
        }
        this.a(world, sbb, 0, 1, 1, this.size - 1, this.height - 2, this.size - 2);
        return true;
    }
    
    public acg getWingBB() {
        final int[] dest = this.offsetTowerCoords(4, 1, 2, this.dSize, this.getCoordBaseMode());
        return StructureTFComponent.getComponentToAddBoundingBox(dest[0], dest[1], dest[2], 0, 0, 0, this.dSize - 1, this.dHeight - 1, this.dSize - 1, this.getCoordBaseMode());
    }
}
