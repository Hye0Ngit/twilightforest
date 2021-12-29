// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.darktower;

import twilightforest.structures.StructureTFComponent;
import java.util.Random;
import java.util.List;
import twilightforest.structures.ComponentTFTowerWing;
import twilightforest.structures.ComponentTFTowerRoof;

public class ComponentTFDarkTowerRoof extends ComponentTFTowerRoof
{
    public ComponentTFDarkTowerRoof(final int i, final ComponentTFTowerWing wing) {
        super(i, wing);
        this.setCoordBaseMode(wing.getCoordBaseMode());
        this.size = wing.size;
        this.height = 12;
        this.makeCapBB(wing);
        this.spawnListIndex = 1;
    }
    
    public void a(final agq parent, final List list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponent) {
            this.deco = ((StructureTFComponent)parent).deco;
        }
    }
    
    @Override
    public boolean a(final zv world, final Random rand, final aee sbb) {
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
        return true;
    }
}
