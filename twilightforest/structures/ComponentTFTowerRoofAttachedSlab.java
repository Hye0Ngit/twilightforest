// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import java.util.Random;

public class ComponentTFTowerRoofAttachedSlab extends ComponentTFTowerRoofSlab
{
    public ComponentTFTowerRoofAttachedSlab(final int i, final ComponentTFTowerWing wing) {
        super(i, wing);
    }
    
    @Override
    public boolean a(final yc world, final Random rand, final acn sbb) {
        final int slabMeta = 2;
        return this.makeConnectedCap(world, slabMeta, sbb);
    }
}
