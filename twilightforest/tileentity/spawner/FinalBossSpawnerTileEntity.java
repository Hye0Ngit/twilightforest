// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity.spawner;

import twilightforest.entity.TFEntities;
import twilightforest.tileentity.TFTileEntities;
import net.minecraft.tileentity.TileEntityType;
import twilightforest.entity.boss.PlateauBossEntity;

public class FinalBossSpawnerTileEntity extends BossSpawnerTileEntity<PlateauBossEntity>
{
    public FinalBossSpawnerTileEntity() {
        super((TileEntityType<?>)TFTileEntities.FINAL_BOSS_SPAWNER.get(), TFEntities.plateau_boss);
    }
    
    @Override
    public void func_73660_a() {
    }
}
