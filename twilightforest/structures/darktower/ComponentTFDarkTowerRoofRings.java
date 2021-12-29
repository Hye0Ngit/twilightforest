// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.darktower;

import java.util.Random;
import twilightforest.structures.ComponentTFTowerWing;

public class ComponentTFDarkTowerRoofRings extends ComponentTFDarkTowerRoof
{
    public ComponentTFDarkTowerRoofRings(final int i, final ComponentTFTowerWing wing) {
        super(i, wing);
    }
    
    @Override
    public boolean a(final zv world, final Random rand, final aee sbb) {
        super.a(world, rand, sbb);
        for (int y = 1; y < 10; ++y) {
            this.a(world, this.deco.blockID, this.deco.blockMeta, this.size / 2, y, this.size / 2, sbb);
        }
        this.a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2, 10, this.size / 2, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 - 1, 1, this.size / 2, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 + 1, 1, this.size / 2, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2, 1, this.size / 2 - 1, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2, 1, this.size / 2 + 1, sbb);
        this.makeARing(world, 6, sbb);
        this.makeARing(world, 8, sbb);
        return true;
    }
    
    protected void makeARing(final zv world, final int y, final aee sbb) {
        this.a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 - 2, y, this.size / 2 + 1, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 - 2, y, this.size / 2 + 0, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 - 2, y, this.size / 2 - 1, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 + 2, y, this.size / 2 + 1, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 + 2, y, this.size / 2 + 0, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 + 2, y, this.size / 2 - 1, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 + 1, y, this.size / 2 - 2, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 + 0, y, this.size / 2 - 2, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 - 1, y, this.size / 2 - 2, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 + 1, y, this.size / 2 + 2, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 + 0, y, this.size / 2 + 2, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, this.size / 2 - 1, y, this.size / 2 + 2, sbb);
    }
}
