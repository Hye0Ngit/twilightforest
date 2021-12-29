// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block.entity.spawner;

import twilightforest.client.particle.TFParticleType;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.level.ServerLevelAccessor;
import twilightforest.entity.TFEntities;
import twilightforest.block.entity.TFBlockEntities;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import twilightforest.entity.boss.PlateauBoss;

public class FinalBossSpawnerBlockEntity extends BossSpawnerBlockEntity<PlateauBoss>
{
    public FinalBossSpawnerBlockEntity(final BlockPos pos, final BlockState state) {
        super((BlockEntityType<?>)TFBlockEntities.FINAL_BOSS_SPAWNER.get(), TFEntities.PLATEAU_BOSS, pos, state);
    }
    
    @Override
    protected boolean spawnMyBoss(final ServerLevelAccessor world) {
        return false;
    }
    
    @Override
    public ParticleOptions getSpawnerParticle() {
        return (ParticleOptions)TFParticleType.ANNIHILATE.get();
    }
}
