// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.darktower;

import java.util.Random;
import twilightforest.structures.ComponentTFTowerWing;

public class ComponentTFDarkTowerRoofAntenna extends ComponentTFDarkTowerRoof
{
    public ComponentTFDarkTowerRoofAntenna(final int i, final ComponentTFTowerWing wing) {
        super(i, wing);
    }
    
    @Override
    public boolean a(final zv world, final Random rand, final aee sbb) {
        super.a(world, rand, sbb);
        for (int y = 1; y < 10; ++y) {
            this.a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2, y, this.size / 2, sbb);
        }
        this.a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 - 1, 1, this.size / 2, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 + 1, 1, this.size / 2, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2, 1, this.size / 2 - 1, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2, 1, this.size / 2 + 1, sbb);
        for (int y = 7; y < 10; ++y) {
            this.a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 - 1, y, this.size / 2, sbb);
            this.a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 + 1, y, this.size / 2, sbb);
            this.a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2, y, this.size / 2 - 1, sbb);
            this.a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2, y, this.size / 2 + 1, sbb);
        }
        this.a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 - 1, 8, this.size / 2 - 1, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 - 1, 8, this.size / 2 + 1, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 + 1, 8, this.size / 2 - 1, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 + 1, 8, this.size / 2 + 1, sbb);
        return true;
    }
}
