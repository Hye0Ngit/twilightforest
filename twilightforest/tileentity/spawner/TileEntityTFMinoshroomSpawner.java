// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity.spawner;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityList;
import twilightforest.entity.boss.EntityTFMinoshroom;

public class TileEntityTFMinoshroomSpawner extends TileEntityTFBossSpawner
{
    public TileEntityTFMinoshroomSpawner() {
        super(EntityList.func_191306_a((Class)EntityTFMinoshroom.class));
    }
    
    @Override
    public boolean anyPlayerInRange() {
        final EntityPlayer closestPlayer = this.field_145850_b.func_184137_a(this.field_174879_c.func_177958_n() + 0.5, this.field_174879_c.func_177956_o() + 0.5, this.field_174879_c.func_177952_p() + 0.5, (double)this.getRange(), false);
        return closestPlayer != null && closestPlayer.field_70163_u > this.field_174879_c.func_177956_o() - 4;
    }
}
