// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity.spawner;

import net.minecraft.entity.player.PlayerEntity;
import twilightforest.entity.TFEntities;
import twilightforest.tileentity.TFTileEntities;
import net.minecraft.tileentity.TileEntityType;
import twilightforest.entity.boss.SnowQueenEntity;

public class SnowQueenSpawnerTileEntity extends BossSpawnerTileEntity<SnowQueenEntity>
{
    public SnowQueenSpawnerTileEntity() {
        super((TileEntityType<?>)TFTileEntities.SNOW_QUEEN_SPAWNER.get(), TFEntities.snow_queen);
    }
    
    @Override
    public boolean anyPlayerInRange() {
        final PlayerEntity closestPlayer = this.field_145850_b.func_217366_a(this.field_174879_c.func_177958_n() + 0.5, this.field_174879_c.func_177956_o() + 0.5, this.field_174879_c.func_177952_p() + 0.5, (double)this.getRange(), false);
        return closestPlayer != null && closestPlayer.func_226278_cu_() > this.field_174879_c.func_177956_o() - 4;
    }
}
