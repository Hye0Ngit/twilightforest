// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import twilightforest.entity.EntityTFKnightPhantom;
import twilightforest.entity.TFCreatures;

public class TileEntityTFKnightPhantomsSpawner extends TileEntityTFBossSpawner
{
    public TileEntityTFKnightPhantomsSpawner() {
        this.mobID = TFCreatures.getSpawnerNameFor("Knight Phantom");
    }
    
    @Override
    public boolean anyPlayerInRange() {
        final ue closestPlayer = this.k.a(this.l + 0.5, this.m + 0.5, this.n + 0.5, 9.0);
        return closestPlayer != null && closestPlayer.v > this.m - 2;
    }
    
    @Override
    protected void spawnMyBoss() {
        for (int i = 0; i < 6; ++i) {
            final of myCreature = this.makeMyCreature();
            final float angle = 60.0f * i;
            final float distance = 4.0f;
            final double rx = this.l + 0.5 + Math.cos(angle * 3.141592653589793 / 180.0) * distance;
            final double ry = this.m + 0.5;
            final double rz = this.n + 0.5 + Math.sin(angle * 3.141592653589793 / 180.0) * distance;
            myCreature.b(rx, ry, rz, this.k.s.nextFloat() * 360.0f, 0.0f);
            this.initializeCreature(myCreature);
            ((EntityTFKnightPhantom)myCreature).setNumber(i);
            this.k.d((nm)myCreature);
        }
    }
    
    @Override
    protected void initializeCreature(final of myCreature) {
        if (myCreature instanceof om) {
            ((om)myCreature).b(this.l, this.m, this.n, 46);
        }
    }
}
