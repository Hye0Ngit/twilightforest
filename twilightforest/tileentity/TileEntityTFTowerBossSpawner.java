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
        final ue closestPlayer = this.k.a(this.l + 0.5, this.m + 0.5, this.n + 0.5, 9.0);
        return closestPlayer != null && closestPlayer.v > this.m - 2;
    }
    
    @Override
    protected void spawnMyBoss() {
        final of myCreature = this.makeMyCreature();
        final double rx = this.l + 0.5;
        final double ry = this.m + 0.5;
        final double rz = this.n + 0.5;
        myCreature.b(rx, ry, rz, this.k.s.nextFloat() * 360.0f, 0.0f);
        this.initializeCreature(myCreature);
        this.k.d((nm)myCreature);
    }
}
