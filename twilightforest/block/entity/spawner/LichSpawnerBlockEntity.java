// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block.entity.spawner;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.entity.player.Player;
import twilightforest.entity.TFEntities;
import twilightforest.block.entity.TFBlockEntities;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import twilightforest.entity.boss.Lich;

public class LichSpawnerBlockEntity extends BossSpawnerBlockEntity<Lich>
{
    public LichSpawnerBlockEntity(final BlockPos pos, final BlockState state) {
        super((BlockEntityType<?>)TFBlockEntities.LICH_SPAWNER.get(), TFEntities.LICH, pos, state);
    }
    
    @Override
    public boolean anyPlayerInRange() {
        final Player closestPlayer = this.f_58857_.m_45924_(this.f_58858_.m_123341_() + 0.5, this.f_58858_.m_123342_() + 0.5, this.f_58858_.m_123343_() + 0.5, (double)this.getRange(), false);
        return closestPlayer != null && closestPlayer.m_20186_() > this.f_58858_.m_123342_() - 4;
    }
    
    @Override
    protected boolean spawnMyBoss(final ServerLevelAccessor world) {
        final Lich myCreature = this.makeMyCreature();
        myCreature.m_20035_(this.f_58858_, world.m_6018_().f_46441_.nextFloat() * 360.0f, 0.0f);
        myCreature.m_6518_(world, world.m_6436_(this.f_58858_), MobSpawnType.SPAWNER, (SpawnGroupData)null, (CompoundTag)null);
        myCreature.setAttackCooldown(40);
        myCreature.setExtinguishTimer();
        this.initializeCreature(myCreature);
        return world.m_7967_((Entity)myCreature);
    }
    
    @Override
    public ParticleOptions getSpawnerParticle() {
        return (ParticleOptions)ParticleTypes.f_123792_;
    }
}
