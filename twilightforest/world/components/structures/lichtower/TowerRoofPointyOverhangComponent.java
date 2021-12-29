// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.lichtower;

import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class TowerRoofPointyOverhangComponent extends TowerRoofPointyComponent
{
    public TowerRoofPointyOverhangComponent(final ServerLevel level, final CompoundTag nbt) {
        super(LichTowerPieces.TFLTRPO, nbt);
    }
    
    public TowerRoofPointyOverhangComponent(final TFFeature feature, final int i, final TowerWingComponent wing, final int x, final int y, final int z) {
        super(LichTowerPieces.TFLTRPO, feature, i, wing, x, y, z);
        this.m_73519_(wing.m_73549_());
        this.size = wing.size + 2;
        this.height = this.size;
        this.makeOverhangBB(wing);
    }
}
