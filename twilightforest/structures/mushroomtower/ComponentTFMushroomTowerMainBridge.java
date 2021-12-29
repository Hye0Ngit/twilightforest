// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.mushroomtower;

import net.minecraft.util.Rotation;
import java.util.Random;
import net.minecraft.world.gen.structure.StructureComponent;
import java.util.List;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;

public class ComponentTFMushroomTowerMainBridge extends ComponentTFMushroomTowerBridge
{
    public ComponentTFMushroomTowerMainBridge() {
    }
    
    protected ComponentTFMushroomTowerMainBridge(final TFFeature feature, final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final EnumFacing direction) {
        super(feature, i, x, y, z, 11, pHeight, direction);
    }
    
    @Override
    public boolean makeTowerWing(final List<StructureComponent> list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final Rotation rotation) {
        final EnumFacing direction = this.getStructureRelativeRotation(rotation);
        int[] dx = this.offsetTowerCoords(x, y, z, 15, direction);
        dx = this.adjustCoordinates(dx[0], dx[1], dx[2], 15, direction, list);
        final ComponentTFMushroomTowerMain wing = new ComponentTFMushroomTowerMain(this.getFeatureType(), index, dx[0], dx[1], dx[2], 15, wingHeight, direction);
        list.add(wing);
        wing.func_74861_a(list.get(0), list, rand);
        this.addOpening(x, y, z, rotation);
        return true;
    }
}
