// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block.entity.spawner;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.ParticleOptions;
import twilightforest.entity.TFEntities;
import twilightforest.block.entity.TFBlockEntities;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import twilightforest.entity.boss.Naga;

public class NagaSpawnerBlockEntity extends BossSpawnerBlockEntity<Naga>
{
    public NagaSpawnerBlockEntity(final BlockPos pos, final BlockState state) {
        super((BlockEntityType<?>)TFBlockEntities.NAGA_SPAWNER.get(), TFEntities.NAGA, pos, state);
    }
    
    @Override
    protected int getRange() {
        return 50;
    }
    
    @Override
    public ParticleOptions getSpawnerParticle() {
        return (ParticleOptions)ParticleTypes.f_123797_;
    }
}
