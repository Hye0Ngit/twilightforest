// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity.spawner;

import twilightforest.entity.boss.EntityTFHydraHead;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import twilightforest.entity.boss.EntityTFHydra;

public class TileEntityTFHydraSpawner extends TileEntityTFBossSpawner
{
    public TileEntityTFHydraSpawner() {
        super(EntityList.func_191306_a((Class)EntityTFHydra.class));
    }
    
    @Override
    protected int getRange() {
        return 50;
    }
    
    @Override
    public Entity getDisplayEntity() {
        if (this.displayCreature == null) {
            this.displayCreature = EntityList.func_188429_b(EntityList.func_191306_a((Class)EntityTFHydraHead.class), this.field_145850_b);
        }
        return this.displayCreature;
    }
}
