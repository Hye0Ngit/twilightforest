// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import twilightforest.entity.TFCreatures;

public class TileEntityTFLichSpawner extends TileEntityTFBossSpawner
{
    public TileEntityTFLichSpawner() {
        this.mobID = TFCreatures.getSpawnerNameFor("Twilight Lich");
    }
    
    @Override
    public boolean anyPlayerInRange() {
        final EntityPlayer closestPlayer = this.field_145850_b.func_72977_a(this.field_145851_c + 0.5, this.field_145848_d + 0.5, this.field_145849_e + 0.5, 9.0);
        return closestPlayer != null && closestPlayer.field_70163_u > this.field_145848_d - 2;
    }
}
