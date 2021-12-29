// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.start;

import twilightforest.structures.darktower.ComponentTFDarkTowerMain;
import net.minecraft.world.gen.structure.StructureComponent;
import java.util.Random;
import twilightforest.TFFeature;
import net.minecraft.world.World;

public class StructureStartDarkTower extends StructureStartTFFeatureAbstract
{
    public StructureStartDarkTower() {
    }
    
    public StructureStartDarkTower(final World world, final TFFeature feature, final Random rand, final int chunkX, final int chunkZ) {
        super(world, feature, rand, chunkX, chunkZ);
    }
    
    @Override
    protected StructureComponent makeFirstComponent(final World world, final TFFeature feature, final Random rand, final int x, final int y, final int z) {
        return new ComponentTFDarkTowerMain(TFFeature.DARK_TOWER, world, rand, 0, x, y - 1, z);
    }
}
