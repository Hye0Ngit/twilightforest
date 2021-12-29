// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block.entity.spawner;

import twilightforest.client.particle.TFParticleType;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import twilightforest.item.TFItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.Difficulty;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.entity.player.Player;
import twilightforest.entity.TFEntities;
import twilightforest.block.entity.TFBlockEntities;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import twilightforest.entity.boss.KnightPhantom;

public class KnightPhantomSpawnerBlockEntity extends BossSpawnerBlockEntity<KnightPhantom>
{
    private static final int COUNT = 6;
    private int spawned;
    
    public KnightPhantomSpawnerBlockEntity(final BlockPos pos, final BlockState state) {
        super((BlockEntityType<?>)TFBlockEntities.KNIGHT_PHANTOM_SPAWNER.get(), TFEntities.KNIGHT_PHANTOM, pos, state);
        this.spawned = 0;
    }
    
    @Override
    public boolean anyPlayerInRange() {
        final Player closestPlayer = this.f_58857_.m_45924_(this.f_58858_.m_123341_() + 0.5, this.f_58858_.m_123342_() + 0.5, this.f_58858_.m_123343_() + 0.5, (double)this.getRange(), false);
        return closestPlayer != null && closestPlayer.m_20186_() > this.f_58858_.m_123342_() - 2;
    }
    
    @Override
    protected boolean spawnMyBoss(final ServerLevelAccessor world) {
        for (int i = this.spawned; i < 6; ++i) {
            final KnightPhantom myCreature = this.makeMyCreature();
            final float angle = 60.0f * i;
            final float distance = 4.0f;
            final double rx = this.f_58858_.m_123341_() + 0.5 + Math.cos(angle * 3.141592653589793 / 180.0) * 4.0;
            final double ry = this.f_58858_.m_123342_();
            final double rz = this.f_58858_.m_123343_() + 0.5 + Math.sin(angle * 3.141592653589793 / 180.0) * 4.0;
            myCreature.m_7678_(rx, ry, rz, world.m_6018_().f_46441_.nextFloat() * 360.0f, 0.0f);
            myCreature.m_6518_(world, world.m_6436_(new BlockPos((Vec3i)myCreature.m_142538_())), MobSpawnType.SPAWNER, null, null);
            if (i == 5 && world.m_46791_() == Difficulty.HARD) {
                myCreature.m_8061_(EquipmentSlot.OFFHAND, new ItemStack((ItemLike)TFItems.KNIGHTMETAL_SHIELD.get()));
            }
            this.initializeCreature(myCreature);
            myCreature.setNumber(i);
            if (world.m_7967_((Entity)myCreature)) {
                ++this.spawned;
            }
        }
        return this.spawned == 6;
    }
    
    @Override
    public ParticleOptions getSpawnerParticle() {
        return (ParticleOptions)TFParticleType.OMINOUS_FLAME.get();
    }
}
