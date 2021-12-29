// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

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
}
