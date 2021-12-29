// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.darktower;

import twilightforest.structures.StructureTFComponent;
import java.util.Random;
import java.util.List;
import twilightforest.structures.ComponentTFTowerWing;

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
    public void a(final agq parent, final List list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponent) {
            this.deco = ((StructureTFComponent)parent).deco;
        }
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
        final agq intersect = agq.a(list, wing.b());
        if (intersect == null || intersect == this) {
            list.add(wing);
            wing.a(this, list, rand);
            this.addOpening(x, y, z, rotation);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean a(final zv world, final Random rand, final aee sbb) {
        this.a(world, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1, this.deco.blockID, this.deco.blockMeta, false);
        for (int x = 0; x < this.size; ++x) {
            this.a(world, this.deco.accentID, this.deco.accentMeta, x, 0, 0, sbb);
            this.a(world, this.deco.accentID, this.deco.accentMeta, x, this.height - 1, 0, sbb);
            this.a(world, this.deco.accentID, this.deco.accentMeta, x, 0, this.size - 1, sbb);
            this.a(world, this.deco.accentID, this.deco.accentMeta, x, this.height - 1, this.size - 1, sbb);
        }
        this.nullifySkyLightForBoundingBox(world);
        this.a(world, sbb, 0, 1, 1, this.size - 1, this.height - 2, this.size - 2);
        return true;
    }
    
    public aee getWingBB() {
        final int[] dest = this.offsetTowerCoords(4, 1, 2, this.dSize, this.getCoordBaseMode());
        return StructureTFComponent.getComponentToAddBoundingBox(dest[0], dest[1], dest[2], 0, 0, 0, this.dSize - 1, this.dHeight - 1, this.dSize - 1, this.getCoordBaseMode());
    }
}
