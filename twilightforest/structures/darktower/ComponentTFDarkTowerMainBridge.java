// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.darktower;

import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.World;
import java.util.Random;
import java.util.List;

public class ComponentTFDarkTowerMainBridge extends ComponentTFDarkTowerBridge
{
    public ComponentTFDarkTowerMainBridge() {
    }
    
    protected ComponentTFDarkTowerMainBridge(final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final int direction) {
        super(i, x, y, z, 15, pHeight, direction);
    }
    
    @Override
    public boolean makeTowerWing(final List list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final int rotation) {
        final int direction = (this.getCoordBaseMode() + rotation) % 4;
        final int[] dx = this.offsetTowerCoords(x, y, z, 19, direction);
        final ComponentTFDarkTowerMain wing = new ComponentTFDarkTowerMain(null, rand, index, dx[0], dx[1], dx[2], direction);
        list.add(wing);
        wing.func_74861_a(this, list, rand);
        this.addOpening(x, y, z, rotation);
        return true;
    }
}
