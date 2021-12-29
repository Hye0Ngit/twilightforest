// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.darktower;

import java.util.Random;
import twilightforest.structures.ComponentTFTowerWing;

public class ComponentTFDarkTowerRoofFourPost extends ComponentTFDarkTowerRoof
{
    public ComponentTFDarkTowerRoofFourPost(final int i, final ComponentTFTowerWing wing) {
        super(i, wing);
    }
    
    @Override
    public boolean a(final abv world, final Random rand, final age sbb) {
        super.a(world, rand, sbb);
        this.makeSmallAntenna(world, sbb, 4, this.size - 2, this.size - 2);
        this.makeSmallAntenna(world, sbb, 5, 1, this.size - 2);
        this.makeSmallAntenna(world, sbb, 6, this.size - 2, 1);
        this.makeSmallAntenna(world, sbb, 7, 1, 1);
        return true;
    }
    
    protected void makeSmallAntenna(final abv world, final age sbb, final int height, final int x, final int z) {
        for (int y = 1; y < height; ++y) {
            this.a(world, this.deco.blockID, this.deco.blockMeta, x, y, z, sbb);
        }
        this.a(world, this.deco.accentID, this.deco.accentMeta, x, height + 0, z, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, x, height + 1, z, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, x + 1, height + 1, z, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, x - 1, height + 1, z, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, x, height + 1, z + 1, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, x, height + 1, z - 1, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, x, height + 2, z, sbb);
    }
}
