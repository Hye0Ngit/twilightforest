// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.lichtower;

public class ComponentTFTowerRoofPointyOverhang extends ComponentTFTowerRoofPointy
{
    public ComponentTFTowerRoofPointyOverhang() {
    }
    
    public ComponentTFTowerRoofPointyOverhang(final int i, final ComponentTFTowerWing wing) {
        super(i, wing);
        this.setCoordBaseMode(wing.getCoordBaseMode());
        this.size = wing.size + 2;
        this.height = this.size;
        this.makeOverhangBB(wing);
    }
}
