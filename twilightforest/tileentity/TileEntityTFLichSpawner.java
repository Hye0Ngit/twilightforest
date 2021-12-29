// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import twilightforest.entity.TFCreatures;

public class TileEntityTFLichSpawner extends TileEntityTFBossSpawner
{
    public TileEntityTFLichSpawner() {
        this.mobID = TFCreatures.getSpawnerNameFor("Twilight Lich");
    }
    
    @Override
    public boolean anyPlayerInRange() {
        final sk closestPlayer = this.k.a(this.l + 0.5, this.m + 0.5, this.n + 0.5, 9.0);
        return closestPlayer != null && closestPlayer.v > this.m - 2;
    }
}
