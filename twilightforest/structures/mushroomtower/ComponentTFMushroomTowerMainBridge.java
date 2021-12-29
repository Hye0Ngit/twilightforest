// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.mushroomtower;

import net.minecraft.world.gen.structure.StructureComponent;
import java.util.Random;
import java.util.List;

public class ComponentTFMushroomTowerMainBridge extends ComponentTFMushroomTowerBridge
{
    public ComponentTFMushroomTowerMainBridge() {
    }
    
    protected ComponentTFMushroomTowerMainBridge(final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final int direction) {
        super(i, x, y, z, 11, pHeight, direction);
    }
    
    @Override
    public boolean makeTowerWing(final List list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final int rotation) {
        final int direction = (this.getCoordBaseMode() + rotation) % 4;
        int[] dx = this.offsetTowerCoords(x, y, z, 15, direction);
        dx = this.adjustCoordinates(dx[0], dx[1], dx[2], 15, direction, list);
        final ComponentTFMushroomTowerMain wing = new ComponentTFMushroomTowerMain(index, dx[0], dx[1], dx[2], 15, wingHeight, direction);
        list.add(wing);
        wing.func_74861_a(list.get(0), list, rand);
        this.addOpening(x, y, z, rotation);
        return true;
    }
}
