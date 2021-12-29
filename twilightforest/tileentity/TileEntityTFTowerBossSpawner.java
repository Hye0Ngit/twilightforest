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
        final EntityPlayer closestPlayer = this.field_70331_k.func_72977_a(this.field_70329_l + 0.5, this.field_70330_m + 0.5, this.field_70327_n + 0.5, 9.0);
        return closestPlayer != null && closestPlayer.field_70163_u > this.field_70330_m - 2;
    }
    
    @Override
    protected void spawnMyBoss() {
        final EntityLiving myCreature = this.makeMyCreature();
        final double rx = this.field_70329_l + 0.5;
        final double ry = this.field_70330_m + 0.5;
        final double rz = this.field_70327_n + 0.5;
        myCreature.func_70012_b(rx, ry, rz, this.field_70331_k.field_73012_v.nextFloat() * 360.0f, 0.0f);
        this.initializeCreature(myCreature);
        this.field_70331_k.func_72838_d((Entity)myCreature);
    }
}
