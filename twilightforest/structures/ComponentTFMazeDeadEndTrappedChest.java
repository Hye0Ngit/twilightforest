// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import java.util.Random;

public class ComponentTFMazeDeadEndTrappedChest extends ComponentTFMazeDeadEndChest
{
    public ComponentTFMazeDeadEndTrappedChest(final int i, final int x, final int y, final int z, final int rotation) {
        super(i, x, y, z, rotation);
    }
    
    @Override
    public boolean a(final zv world, final Random rand, final aee sbb) {
        super.a(world, rand, sbb);
        this.a(world, aou.bX.cz, this.getHookMeta(3), 1, 1, 2, sbb);
        this.a(world, aou.bX.cz, this.getHookMeta(1), 4, 1, 2, sbb);
        this.a(world, aou.bY.cz, 0, 2, 1, 2, sbb);
        this.a(world, aou.bY.cz, 0, 3, 1, 2, sbb);
        this.a(world, aou.aq.cz, 0, 0, 0, 2, sbb);
        this.a(world, 0, 0, 0, -1, 2, sbb);
        this.a(world, 0, 0, 1, -1, 2, sbb);
        this.a(world, aou.aq.cz, 0, 2, 0, 4, sbb);
        this.a(world, aou.aq.cz, 0, 3, 0, 4, sbb);
        this.a(world, aou.aq.cz, 0, 2, 0, 3, sbb);
        this.a(world, aou.aq.cz, 0, 3, 0, 3, sbb);
        return true;
    }
    
    protected int getHookMeta(final int dir) {
        return (this.getCoordBaseMode() + dir) % 4;
    }
}
