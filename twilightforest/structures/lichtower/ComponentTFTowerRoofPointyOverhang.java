// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.lichtower;

import twilightforest.TFFeature;

public class ComponentTFTowerRoofPointyOverhang extends ComponentTFTowerRoofPointy
{
    public ComponentTFTowerRoofPointyOverhang() {
    }
    
    public ComponentTFTowerRoofPointyOverhang(final TFFeature feature, final int i, final ComponentTFTowerWing wing) {
        super(feature, i, wing);
        this.func_186164_a(wing.func_186165_e());
        this.size = wing.size + 2;
        this.height = this.size;
        this.makeOverhangBB(wing);
    }
}
