// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import twilightforest.entity.TFCreatures;

public class TileEntityTFTowerBossSpawner extends TileEntityTFBossSpawner
{
    public TileEntityTFTowerBossSpawner() {
        this.mobID = TFCreatures.getSpawnerNameFor("Tower Boss");
    }
    
    @Override
    public boolean anyPlayerInRange() {
        final EntityPlayer closestPlayer = this.field_145850_b.func_72977_a(this.field_145851_c + 0.5, this.field_145848_d + 0.5, this.field_145849_e + 0.5, 9.0);
        return closestPlayer != null && closestPlayer.field_70163_u > this.field_145848_d - 2;
    }
    
    @Override
    protected void spawnMyBoss() {
        final EntityLiving myCreature = this.makeMyCreature();
        final double rx = this.field_145851_c + 0.5;
        final double ry = this.field_145848_d + 0.5;
        final double rz = this.field_145849_e + 0.5;
        myCreature.func_70012_b(rx, ry, rz, this.field_145850_b.field_73012_v.nextFloat() * 360.0f, 0.0f);
        this.initializeCreature(myCreature);
        this.field_145850_b.func_72838_d((Entity)myCreature);
    }
}
