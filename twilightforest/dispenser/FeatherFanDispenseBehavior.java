// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.dispenser;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import java.util.Random;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundSource;
import twilightforest.TFSounds;
import net.minecraft.core.Vec3i;
import java.util.Iterator;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;

public class FeatherFanDispenseBehavior extends DefaultDispenseItemBehavior
{
    boolean fired;
    
    public FeatherFanDispenseBehavior() {
        this.fired = false;
    }
    
    protected ItemStack m_7498_(final BlockSource source, final ItemStack stack) {
        final Level world = (Level)source.m_7727_();
        final BlockPos blockpos = source.m_7961_().m_142300_((Direction)source.m_6414_().m_61143_((Property)DispenserBlock.f_52659_));
        final int damage = stack.m_41776_() - stack.m_41773_();
        if (!world.f_46443_) {
            final List<LivingEntity> thingsToPush = world.m_6443_((Class)LivingEntity.class, new AABB(blockpos).m_82400_(3.0), EntitySelector.f_20408_);
            if (thingsToPush.size() < damage) {
                for (final Entity entity : thingsToPush) {
                    final Vec3i lookVec = ((Direction)world.m_8055_(source.m_7961_()).m_61143_((Property)DispenserBlock.f_52659_)).m_122436_();
                    if (entity.m_6094_() || entity instanceof ItemEntity) {
                        entity.m_20334_((double)lookVec.m_123341_(), (double)lookVec.m_123342_(), (double)lookVec.m_123343_());
                        if (!stack.m_41629_(1, world.f_46441_, (ServerPlayer)null)) {
                            continue;
                        }
                        stack.m_41764_(0);
                    }
                }
                this.fired = true;
            }
        }
        return stack;
    }
    
    protected void m_6823_(final BlockSource source) {
        if (this.fired) {
            final Random random = source.m_7727_().m_5822_();
            source.m_7727_().m_5594_((Player)null, source.m_7961_(), TFSounds.FAN_WOOSH, SoundSource.BLOCKS, 1.0f + random.nextFloat(), random.nextFloat() * 0.7f + 0.3f);
            this.fired = false;
        }
        else {
            source.m_7727_().m_46796_(1001, source.m_7961_(), 0);
        }
    }
    
    protected void m_123387_(final BlockSource source, final Direction direction) {
        final BlockPos blockpos = source.m_7961_().m_142300_((Direction)source.m_6414_().m_61143_((Property)DispenserBlock.f_52659_));
        final Level world = (Level)source.m_7727_();
        final Random random = world.m_5822_();
        final int j1 = direction.m_122429_();
        final int j2 = direction.m_122430_();
        final int k2 = direction.m_122431_();
        final double d18 = blockpos.m_123341_() + j1 * 0.6 + 0.5;
        final double d19 = blockpos.m_123342_() + j2 * 0.6 + 0.5;
        final double d20 = blockpos.m_123343_() + k2 * 0.6 + 0.5;
        for (int i = 0; i < 30; ++i) {
            final double d21 = random.nextDouble() * 0.2 + 0.01;
            final double d22 = d18 + j1 * 0.01 + (random.nextDouble() - 0.5) * k2 * 0.5;
            final double d23 = d19 + j2 * 0.01 + (random.nextDouble() - 0.5) * j2 * 0.5;
            final double d24 = d20 + k2 * 0.01 + (random.nextDouble() - 0.5) * j1 * 0.5;
            final double d25 = j1 * d21 + random.nextGaussian() * 0.01;
            final double d26 = j2 * d21 + random.nextGaussian() * 0.01;
            final double d27 = k2 * d21 + random.nextGaussian() * 0.01;
            world.m_7106_((ParticleOptions)ParticleTypes.f_123796_, d22, d23, d24, d25, d26, d27);
        }
    }
}
