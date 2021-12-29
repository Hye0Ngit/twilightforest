// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity.spawner;

import twilightforest.entity.TFEntities;
import twilightforest.tileentity.TFTileEntities;
import net.minecraft.tileentity.TileEntityType;
import twilightforest.entity.boss.HydraEntity;

public class HydraSpawnerTileEntity extends BossSpawnerTileEntity<HydraEntity>
{
    public HydraSpawnerTileEntity() {
        super((TileEntityType<?>)TFTileEntities.HYDRA_SPAWNER.get(), TFEntities.hydra);
    }
    
    @Override
    protected int getRange() {
        return 50;
    }
}
