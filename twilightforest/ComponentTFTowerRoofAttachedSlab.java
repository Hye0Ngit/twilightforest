// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Random;

public class ComponentTFTowerRoofAttachedSlab extends ComponentTFTowerRoofSlab
{
    public ComponentTFTowerRoofAttachedSlab(final int i, final ComponentTFTowerWing wing) {
        super(i, wing);
    }
    
    @Override
    public boolean a(final xd world, final Random rand, final qg sbb) {
        return this.makeConnectedCap(world, sbb);
    }
}
