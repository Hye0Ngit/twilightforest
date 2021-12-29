// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.Entity;
import twilightforest.entity.EntityTFKnightPhantom;
import net.minecraft.entity.player.EntityPlayer;
import twilightforest.entity.TFCreatures;

public class TileEntityTFKnightPhantomsSpawner extends TileEntityTFBossSpawner
{
    public TileEntityTFKnightPhantomsSpawner() {
        this.mobID = TFCreatures.getSpawnerNameFor("Knight Phantom");
    }
    
    @Override
    public boolean anyPlayerInRange() {
        final EntityPlayer closestPlayer = this.field_70331_k.func_72977_a(this.field_70329_l + 0.5, this.field_70330_m + 0.5, this.field_70327_n + 0.5, 9.0);
        return closestPlayer != null && closestPlayer.field_70163_u > this.field_70330_m - 2;
    }
    
    @Override
    protected void spawnMyBoss() {
        for (int i = 0; i < 6; ++i) {
            final EntityLiving myCreature = this.makeMyCreature();
            final float angle = 60.0f * i;
            final float distance = 4.0f;
            final double rx = this.field_70329_l + 0.5 + Math.cos(angle * 3.141592653589793 / 180.0) * distance;
            final double ry = this.field_70330_m + 0.5;
            final double rz = this.field_70327_n + 0.5 + Math.sin(angle * 3.141592653589793 / 180.0) * distance;
            myCreature.func_70012_b(rx, ry, rz, this.field_70331_k.field_73012_v.nextFloat() * 360.0f, 0.0f);
            this.initializeCreature(myCreature);
            ((EntityTFKnightPhantom)myCreature).setNumber(i);
            this.field_70331_k.func_72838_d((Entity)myCreature);
        }
    }
    
    @Override
    protected void initializeCreature(final EntityLiving myCreature) {
        if (myCreature instanceof EntityTFKnightPhantom) {
            ((EntityTFKnightPhantom)myCreature).setHomeArea(this.field_70329_l, this.field_70330_m, this.field_70327_n, 46);
        }
    }
}
