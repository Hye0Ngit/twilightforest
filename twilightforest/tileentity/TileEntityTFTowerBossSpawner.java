// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import twilightforest.entity.TFCreatures;

public class TileEntityTFTowerBossSpawner extends TileEntityTFBossSpawner
{
    public TileEntityTFTowerBossSpawner() {
        this.mobID = TFCreatures.getSpawnerNameFor("Tower Boss");
    }
    
    @Override
    public boolean anyPlayerInRange() {
        final sk closestPlayer = this.k.a(this.l + 0.5, this.m + 0.5, this.n + 0.5, 9.0);
        return closestPlayer != null && closestPlayer.v > this.m - 2;
    }
}
