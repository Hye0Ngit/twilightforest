// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import twilightforest.entity.TFCreatures;

public class TileEntityTFNagaSpawner extends TileEntityTFBossSpawner
{
    public TileEntityTFNagaSpawner() {
        this.mobID = TFCreatures.getSpawnerNameFor("Naga");
    }
    
    @Override
    public boolean anyPlayerInRange() {
        return this.k.a(this.l + 0.5, this.m + 0.5, this.n + 0.5, 50.0) != null;
    }
    
    @Override
    protected void initializeCreature(final of myCreature) {
        if (myCreature instanceof om) {
            ((om)myCreature).b(this.l, this.m, this.n, 46);
        }
    }
    
    @Override
    protected int getRange() {
        return 50;
    }
}
