// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block.entity.spawner;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.entity.Mob;

public abstract class BossSpawnerBlockEntity<T extends Mob> extends BlockEntity
{
    protected static final int SHORT_RANGE = 9;
    protected static final int LONG_RANGE = 50;
    protected final EntityType<T> entityType;
    protected boolean spawnedBoss;
    
    protected BossSpawnerBlockEntity(final BlockEntityType<?> type, final EntityType<T> entityType, final BlockPos pos, final BlockState state) {
        super((BlockEntityType)type, pos, state);
        this.spawnedBoss = false;
        this.entityType = entityType;
    }
    
    public boolean anyPlayerInRange() {
        return this.f_58857_.m_45914_(this.f_58858_.m_123341_() + 0.5, this.f_58858_.m_123342_() + 0.5, this.f_58858_.m_123343_() + 0.5, (double)this.getRange());
    }
    
    public static void tick(final Level level, final BlockPos pos, final BlockState state, final BossSpawnerBlockEntity<?> te) {
        if (te.spawnedBoss || !te.anyPlayerInRange()) {
            return;
        }
        if (level.f_46443_) {
            final double rx = pos.m_123341_() - 0.2f + level.f_46441_.nextFloat() * 1.25f;
            final double ry = pos.m_123342_() - 0.2f + level.f_46441_.nextFloat() * 1.25f;
            final double rz = pos.m_123343_() - 0.2f + level.f_46441_.nextFloat() * 1.25f;
            level.m_7106_(te.getSpawnerParticle(), rx, ry, rz, 0.0, 0.0, 0.0);
        }
        else if (level.m_46791_() != Difficulty.PEACEFUL && te.spawnMyBoss((ServerLevelAccessor)level)) {
            level.m_46961_(pos, false);
            te.spawnedBoss = true;
        }
    }
    
    protected boolean spawnMyBoss(final ServerLevelAccessor world) {
        final T myCreature = this.makeMyCreature();
        myCreature.m_20035_(this.f_58858_, world.m_6018_().f_46441_.nextFloat() * 360.0f, 0.0f);
        myCreature.m_6518_(world, world.m_6436_(this.f_58858_), MobSpawnType.SPAWNER, (SpawnGroupData)null, (CompoundTag)null);
        this.initializeCreature(myCreature);
        return world.m_7967_((Entity)myCreature);
    }
    
    public abstract ParticleOptions getSpawnerParticle();
    
    protected void initializeCreature(final T myCreature) {
        myCreature.m_21446_(this.f_58858_, 46);
    }
    
    protected int getRange() {
        return 9;
    }
    
    protected T makeMyCreature() {
        return (T)this.entityType.m_20615_(this.f_58857_);
    }
}
