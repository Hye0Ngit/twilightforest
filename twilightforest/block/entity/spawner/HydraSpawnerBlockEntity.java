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
import twilightforest.entity.boss.Hydra;

public class HydraSpawnerBlockEntity extends BossSpawnerBlockEntity<Hydra>
{
    public HydraSpawnerBlockEntity(final BlockPos pos, final BlockState state) {
        super((BlockEntityType<?>)TFBlockEntities.HYDRA_SPAWNER.get(), TFEntities.HYDRA, pos, state);
    }
    
    @Override
    protected int getRange() {
        return 50;
    }
    
    @Override
    public ParticleOptions getSpawnerParticle() {
        return (ParticleOptions)ParticleTypes.f_123744_;
    }
}
