// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity.spawner;

import net.minecraft.entity.EntityList;
import twilightforest.entity.boss.EntityTFNaga;

public class TileEntityTFNagaSpawner extends TileEntityTFBossSpawner
{
    public TileEntityTFNagaSpawner() {
        super(EntityList.func_191306_a((Class)EntityTFNaga.class));
    }
    
    @Override
    protected int getRange() {
        return 50;
    }
}
