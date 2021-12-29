// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import twilightforest.entity.TFCreatures;

public class TileEntityTFNagaSpawner extends TileEntityTFBossSpawner
{
    public TileEntityTFNagaSpawner() {
        this.mobID = TFCreatures.getSpawnerNameFor("Naga");
    }
    
    @Override
    public boolean anyPlayerInRange() {
        return this.field_145850_b.func_72977_a(this.field_145851_c + 0.5, this.field_145848_d + 0.5, this.field_145849_e + 0.5, 50.0) != null;
    }
    
    @Override
    protected void initializeCreature(final EntityLiving myCreature) {
        if (myCreature instanceof EntityCreature) {
            ((EntityCreature)myCreature).func_110171_b(this.field_145851_c, this.field_145848_d, this.field_145849_e, 46);
        }
    }
    
    @Override
    protected int getRange() {
        return 50;
    }
}
