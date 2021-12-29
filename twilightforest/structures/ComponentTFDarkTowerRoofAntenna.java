// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import java.util.Random;
import java.util.List;

public class ComponentTFDarkTowerRoofAntenna extends ComponentTFTowerRoof
{
    public ComponentTFDarkTowerRoofAntenna(final int i, final ComponentTFTowerWing wing) {
        super(i, wing);
        this.setCoordBaseMode(wing.getCoordBaseMode());
        this.size = wing.size;
        this.height = 10;
        this.makeCapBB(wing);
    }
    
    public void a(final aez parent, final List list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponent) {
            this.deco = ((StructureTFComponent)parent).deco;
        }
    }
    
    @Override
    public boolean a(final yc world, final Random rand, final acn sbb) {
        for (int x = 0; x <= this.size - 1; ++x) {
            for (int z = 0; z <= this.size - 1; ++z) {
                if (x == 0 || x == this.size - 1 || z == 0 || z == this.size - 1) {
                    this.a(world, this.deco.fenceID, this.deco.fenceMeta, x, 1, z, sbb);
                }
            }
        }
        this.a(world, this.deco.accentID, this.deco.accentMeta, 0, 1, 0, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, this.size - 1, 1, 0, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, 0, 1, this.size - 1, sbb);
        this.a(world, this.deco.accentID, this.deco.accentMeta, this.size - 1, 1, this.size - 1, sbb);
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
