// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity.spawner;

import twilightforest.entity.TFEntities;
import twilightforest.tileentity.TFTileEntities;
import net.minecraft.tileentity.TileEntityType;
import twilightforest.entity.boss.NagaEntity;

public class NagaSpawnerTileEntity extends BossSpawnerTileEntity<NagaEntity>
{
    public NagaSpawnerTileEntity() {
        super((TileEntityType<?>)TFTileEntities.NAGA_SPAWNER.get(), TFEntities.naga);
    }
    
    @Override
    protected int getRange() {
        return 50;
    }
}
