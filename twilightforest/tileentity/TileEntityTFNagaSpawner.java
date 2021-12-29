// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import net.minecraft.entity.EntityLiving;
import twilightforest.entity.TFCreatures;

public class TileEntityTFNagaSpawner extends TileEntityTFBossSpawner
{
    public TileEntityTFNagaSpawner() {
        this.mobID = TFCreatures.getSpawnerNameFor("Naga");
    }
    
    @Override
    public boolean anyPlayerInRange() {
        return this.field_70331_k.func_72977_a(this.field_70329_l + 0.5, this.field_70330_m + 0.5, this.field_70327_n + 0.5, 50.0) != null;
    }
    
    @Override
    protected void initializeCreature(final EntityLiving myCreature) {
        myCreature.func_70598_b(this.field_70329_l, this.field_70330_m, this.field_70327_n, 46);
    }
    
    @Override
    protected int getRange() {
        return 50;
    }
}
