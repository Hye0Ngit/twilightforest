// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity.spawner;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityList;
import twilightforest.entity.EntityTFKobold;

public class TileEntityTFFinalBossSpawner extends TileEntityTFBossSpawner
{
    public TileEntityTFFinalBossSpawner() {
        super(EntityList.func_191306_a((Class)EntityTFKobold.class));
    }
    
    @Override
    protected void initializeCreature(final EntityLiving myCreature) {
        super.initializeCreature(myCreature);
        myCreature.func_96094_a("Final Boss");
        myCreature.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1024.0);
        myCreature.func_70606_j(myCreature.func_110138_aP());
    }
}
