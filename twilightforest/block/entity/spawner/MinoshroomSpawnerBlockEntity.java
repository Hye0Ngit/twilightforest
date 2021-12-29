// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block.entity.spawner;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.entity.player.Player;
import twilightforest.entity.TFEntities;
import twilightforest.block.entity.TFBlockEntities;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import twilightforest.entity.boss.Minoshroom;

public class MinoshroomSpawnerBlockEntity extends BossSpawnerBlockEntity<Minoshroom>
{
    public MinoshroomSpawnerBlockEntity(final BlockPos pos, final BlockState state) {
        super((BlockEntityType<?>)TFBlockEntities.MINOSHROOM_SPAWNER.get(), TFEntities.MINOSHROOM, pos, state);
    }
    
    @Override
    public boolean anyPlayerInRange() {
        final Player closestPlayer = this.f_58857_.m_45924_(this.f_58858_.m_123341_() + 0.5, this.f_58858_.m_123342_() + 0.5, this.f_58858_.m_123343_() + 0.5, (double)this.getRange(), false);
        return closestPlayer != null && closestPlayer.m_20186_() > this.f_58858_.m_123342_() - 4;
    }
    
    @Override
    public ParticleOptions getSpawnerParticle() {
        return (ParticleOptions)ParticleTypes.f_123784_;
    }
}
