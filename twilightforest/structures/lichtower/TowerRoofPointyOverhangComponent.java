// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.lichtower;

import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class TowerRoofPointyOverhangComponent extends TowerRoofPointyComponent
{
    public TowerRoofPointyOverhangComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(LichTowerPieces.TFLTRPO, nbt);
    }
    
    public TowerRoofPointyOverhangComponent(final TFFeature feature, final int i, final TowerWingComponent wing) {
        super(LichTowerPieces.TFLTRPO, feature, i, wing);
        this.func_186164_a(wing.func_186165_e());
        this.size = wing.size + 2;
        this.height = this.size;
        this.makeOverhangBB(wing);
    }
}
