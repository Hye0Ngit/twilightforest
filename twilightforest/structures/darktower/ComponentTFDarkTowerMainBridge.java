// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.darktower;

import net.minecraft.world.World;
import net.minecraft.util.Rotation;
import java.util.Random;
import net.minecraft.world.gen.structure.StructureComponent;
import java.util.List;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;

public class ComponentTFDarkTowerMainBridge extends ComponentTFDarkTowerBridge
{
    public ComponentTFDarkTowerMainBridge() {
    }
    
    protected ComponentTFDarkTowerMainBridge(final TFFeature feature, final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final EnumFacing direction) {
        super(feature, i, x, y, z, 15, pHeight, direction);
    }
    
    @Override
    public boolean makeTowerWing(final List<StructureComponent> list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final Rotation rotation) {
        final EnumFacing direction = this.getStructureRelativeRotation(rotation);
        final int[] dx = this.offsetTowerCoords(x, y, z, 19, direction);
        final ComponentTFDarkTowerMain wing = new ComponentTFDarkTowerMain(this.getFeatureType(), null, rand, index, dx[0], dx[1], dx[2], direction);
        list.add(wing);
        wing.func_74861_a(this, list, rand);
        this.addOpening(x, y, z, rotation);
        return true;
    }
}
