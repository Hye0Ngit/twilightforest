// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.Entity;
import twilightforest.entity.TFCreatures;

public class TileEntityTFHydraSpawner extends TileEntityTFBossSpawner
{
    public TileEntityTFHydraSpawner() {
        this.mobID = TFCreatures.getSpawnerNameFor("Hydra");
    }
    
    @Override
    public Entity getDisplayEntity() {
        if (this.displayCreature == null) {
            this.displayCreature = EntityList.func_75620_a("HydraHead", this.field_145850_b);
        }
        return this.displayCreature;
    }
}
