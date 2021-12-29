// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import twilightforest.entity.TFCreatures;

public class TileEntityTFHydraSpawner extends TileEntityTFBossSpawner
{
    public TileEntityTFHydraSpawner() {
        this.mobID = TFCreatures.getSpawnerNameFor("Hydra");
    }
    
    @Override
    public mp getDisplayEntity() {
        if (this.displayCreature == null) {
            this.displayCreature = mv.a("HydraHead", this.k);
        }
        return this.displayCreature;
    }
}
