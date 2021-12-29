// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block.entity;

import twilightforest.entity.monster.CarminiteGhastguard;
import net.minecraft.world.damagesource.DamageSource;
import twilightforest.entity.boss.UrGhast;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.level.block.state.properties.Property;
import twilightforest.client.particle.TFParticleType;
import java.util.Iterator;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundSource;
import twilightforest.TFSounds;
import twilightforest.block.TFBlocks;
import twilightforest.block.GhastTrapBlock;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.Level;
import java.util.ArrayList;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import java.util.Random;
import twilightforest.entity.monster.CarminiteGhastling;
import java.util.List;
import net.minecraft.world.level.block.entity.BlockEntity;

public class GhastTrapBlockEntity extends BlockEntity
{
    private int counter;
    private final List<CarminiteGhastling> dyingGhasts;
    private final Random rand;
    
    public GhastTrapBlockEntity(final BlockPos pos, final BlockState state) {
        super((BlockEntityType)TFBlockEntities.GHAST_TRAP.get(), pos, state);
        this.counter = 0;
        this.dyingGhasts = new ArrayList<CarminiteGhastling>();
        this.rand = new Random();
    }
    
    private static void tickInactive(final Level level, final BlockPos pos, final BlockState state, final GhastTrapBlockEntity te) {
        final AABB aabb = new AABB(pos).m_82377_(10.0, 16.0, 10.0);
        final List<CarminiteGhastling> nearbyGhasts = level.m_45976_((Class)CarminiteGhastling.class, aabb);
        for (final CarminiteGhastling ghast : nearbyGhasts) {
            if (ghast.f_20919_ > 0) {
                te.makeParticlesTo((Entity)ghast);
                if (te.dyingGhasts.contains(ghast)) {
                    continue;
                }
                te.dyingGhasts.add(ghast);
            }
        }
        final int chargeLevel = Math.min(3, te.dyingGhasts.size());
        ++te.counter;
        if (level.f_46443_) {
            if (te.counter % 20 == 0 && nearbyGhasts.size() > 0) {
                final CarminiteGhastling highlight = nearbyGhasts.get(te.rand.nextInt(nearbyGhasts.size()));
                te.makeParticlesTo((Entity)highlight);
            }
            if (chargeLevel >= 1 && te.counter % 10 == 0) {
                ((GhastTrapBlock)TFBlocks.GHAST_TRAP.get()).sparkle(level, pos);
                level.m_7785_(pos.m_123341_() + 0.5, pos.m_123342_() + 1.5, pos.m_123343_() + 0.5, TFSounds.GHAST_TRAP_AMBIENT, SoundSource.BLOCKS, 1.0f, 1.0f, false);
            }
            if (chargeLevel >= 2) {
                level.m_7106_((ParticleOptions)ParticleTypes.f_123762_, pos.m_123341_() + 0.1 + te.rand.nextFloat() * 0.8, pos.m_123342_() + 1.05, pos.m_123343_() + 0.1 + te.rand.nextFloat() * 0.8, (te.rand.nextFloat() - te.rand.nextFloat()) * 0.05, 0.0, (te.rand.nextFloat() - te.rand.nextFloat()) * 0.05);
                if (te.counter % 10 == 0) {
                    level.m_7785_(pos.m_123341_() + 0.5, pos.m_123342_() + 1.5, pos.m_123343_() + 0.5, TFSounds.GHAST_TRAP_AMBIENT, SoundSource.BLOCKS, 1.2f, 0.8f, false);
                }
            }
            if (chargeLevel >= 3) {
                level.m_7106_((ParticleOptions)ParticleTypes.f_123755_, pos.m_123341_() + 0.1 + te.rand.nextFloat() * 0.8, pos.m_123342_() + 1.05, pos.m_123343_() + 0.1 + te.rand.nextFloat() * 0.8, (te.rand.nextFloat() - te.rand.nextFloat()) * 0.05, 0.05, (te.rand.nextFloat() - te.rand.nextFloat()) * 0.05);
                ((GhastTrapBlock)TFBlocks.GHAST_TRAP.get()).sparkle(level, pos);
                if (te.counter % 5 == 0) {
                    level.m_7785_(pos.m_123341_() + 0.5, pos.m_123342_() + 1.5, pos.m_123343_() + 0.5, TFSounds.GHAST_TRAP_AMBIENT, SoundSource.BLOCKS, 1.5f, 2.0f, false);
                }
            }
        }
    }
    
    private void makeParticlesTo(final Entity highlight) {
        final double sx = this.f_58858_.m_123341_() + 0.5;
        final double sy = this.f_58858_.m_123342_() + 1.0;
        final double sz = this.f_58858_.m_123343_() + 0.5;
        final double dx = sx - highlight.m_20185_();
        final double dy = sy - highlight.m_20186_() - highlight.m_20192_();
        final double dz = sz - highlight.m_20189_();
        for (int i = 0; i < 5; ++i) {
            this.f_58857_.m_7106_((ParticleOptions)TFParticleType.GHAST_TRAP.get(), sx, sy, sz, -dx, -dy, -dz);
        }
    }
    
    public boolean isCharged() {
        return this.dyingGhasts.size() >= 3;
    }
    
    public static void tick(final Level level, final BlockPos pos, final BlockState state, final GhastTrapBlockEntity te) {
        if (state.m_61143_((Property)GhastTrapBlock.ACTIVE)) {
            tickActive(level, pos, state, te);
        }
        else {
            tickInactive(level, pos, state, te);
        }
    }
    
    public boolean m_7531_(final int event, final int payload) {
        if (event == 0) {
            this.counter = 0;
            this.dyingGhasts.clear();
            return true;
        }
        if (event == 1) {
            this.counter = 0;
            return true;
        }
        return false;
    }
    
    private static void tickActive(final Level level, final BlockPos pos, final BlockState state, final GhastTrapBlockEntity te) {
        ++te.counter;
        if (level.f_46443_) {
            if (te.counter > 100 && te.counter % 4 == 0) {
                level.m_7106_((ParticleOptions)TFParticleType.HUGE_SMOKE.get(), pos.m_123341_() + 0.5, pos.m_123342_() + 0.95, pos.m_123343_() + 0.5, Math.cos(te.counter / 10.0) * 0.05, 0.25, Math.sin(te.counter / 10.0) * 0.05);
            }
            else if (te.counter < 100) {
                final double x = pos.m_123341_() + 0.5;
                final double y = pos.m_123342_() + 1.0;
                final double z = pos.m_123343_() + 0.5;
                final double dx = Math.cos(te.counter / 10.0) * 2.5;
                final double dy = 20.0;
                final double dz = Math.sin(te.counter / 10.0) * 2.5;
                level.m_7106_((ParticleOptions)TFParticleType.GHAST_TRAP.get(), x, y, z, dx, dy, dz);
                level.m_7106_((ParticleOptions)TFParticleType.GHAST_TRAP.get(), x, y, z, -dx, dy, -dz);
                level.m_7106_((ParticleOptions)TFParticleType.GHAST_TRAP.get(), x, y, z, -dx, dy / 2.0, dz);
                level.m_7106_((ParticleOptions)TFParticleType.GHAST_TRAP.get(), x, y, z, dx, dy / 2.0, -dz);
                level.m_7106_((ParticleOptions)TFParticleType.GHAST_TRAP.get(), x, y, z, dx / 2.0, dy / 4.0, dz / 2.0);
                level.m_7106_((ParticleOptions)TFParticleType.GHAST_TRAP.get(), x, y, z, -dx / 2.0, dy / 4.0, -dz / 2.0);
            }
            if (te.counter < 30) {
                level.m_7785_(pos.m_123341_() + 0.5, pos.m_123342_() + 1.5, pos.m_123343_() + 0.5, TFSounds.GHAST_TRAP_WARMUP, SoundSource.BLOCKS, 1.0f, 4.0f, false);
            }
            else if (te.counter < 80) {
                level.m_7785_(pos.m_123341_() + 0.5, pos.m_123342_() + 1.5, pos.m_123343_() + 0.5, TFSounds.GHAST_TRAP_ON, SoundSource.BLOCKS, 1.0f, 4.0f, false);
            }
            else {
                level.m_7785_(pos.m_123341_() + 0.5, pos.m_123342_() + 1.5, pos.m_123343_() + 0.5, TFSounds.GHAST_TRAP_SPINDOWN, SoundSource.BLOCKS, 1.0f, 4.0f, false);
            }
        }
        else {
            final AABB aabb = new AABB(pos.m_6630_(16), pos.m_6630_(16).m_142082_(1, 1, 1)).m_82377_(6.0, 16.0, 6.0);
            final List<Ghast> nearbyGhasts = level.m_45976_((Class)Ghast.class, aabb);
            for (final Ghast ghast2 : nearbyGhasts) {
                final Ghast ghast = ghast2;
                if (ghast2 instanceof final UrGhast urghast) {
                    urghast.setInTantrum(false);
                    ghast.f_19794_ = true;
                    final double mx = (ghast.m_20185_() - pos.m_123341_() - 0.5) * -0.1;
                    final double my = (ghast.m_20186_() - pos.m_123342_() - 2.5) * -0.1;
                    final double mz = (ghast.m_20189_() - pos.m_123343_() - 0.5) * -0.1;
                    ghast.m_20334_(mx, my, mz);
                    if (te.rand.nextInt(10) == 0) {
                        ghast.m_6469_(DamageSource.f_19318_, 7.0f);
                        urghast.resetDamageUntilNextPhase();
                    }
                }
                else {
                    final double mx = (ghast.m_20185_() - pos.m_123341_() - 0.5) * -0.1;
                    final double my = (ghast.m_20186_() - pos.m_123342_() - 1.5) * -0.1;
                    final double mz = (ghast.m_20189_() - pos.m_123343_() - 0.5) * -0.1;
                    ghast.m_20334_(mx, my, mz);
                    if (te.rand.nextInt(10) == 0) {
                        ghast.m_6469_(DamageSource.f_19318_, 10.0f);
                    }
                }
                if (ghast instanceof final CarminiteGhastguard carminiteGhastguard) {
                    carminiteGhastguard.setInTrap();
                }
            }
            if (te.counter >= 120) {
                level.m_46597_(pos, (BlockState)state.m_61124_((Property)GhastTrapBlock.ACTIVE, (Comparable)false));
                level.m_7696_(pos, state.m_60734_(), 1, 0);
            }
        }
    }
}
