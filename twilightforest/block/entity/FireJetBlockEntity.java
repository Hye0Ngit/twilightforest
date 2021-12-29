// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block.entity;

import java.util.Iterator;
import java.util.List;
import twilightforest.util.TFDamageSources;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.entity.Entity;
import twilightforest.client.particle.TFParticleType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundSource;
import twilightforest.TFSounds;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.block.state.properties.Property;
import twilightforest.block.FireJetBlock;
import twilightforest.enums.FireJetVariant;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;

public class FireJetBlockEntity extends BlockEntity
{
    private int counter;
    
    public FireJetBlockEntity(final BlockPos pos, final BlockState state) {
        super((BlockEntityType)TFBlockEntities.FLAME_JET.get(), pos, state);
        this.counter = 0;
    }
    
    public static void tick(final Level level, final BlockPos pos, final BlockState state, final FireJetBlockEntity te) {
        if (state.m_60734_() == TFBlocks.FIRE_JET.get() || state.m_60734_() == TFBlocks.ENCASED_FIRE_JET.get()) {
            switch ((FireJetVariant)state.m_61143_((Property)FireJetBlock.STATE)) {
                case POPPING: {
                    tickPopping(level, pos, state, te);
                    break;
                }
                case FLAME: {
                    tickFlame(level, pos, state, te);
                    break;
                }
            }
        }
    }
    
    private static void tickPopping(final Level level, final BlockPos pos, final BlockState state, final FireJetBlockEntity te) {
        if (++te.counter >= 80) {
            te.counter = 0;
            if (!level.f_46443_) {
                if (state.m_60734_() == TFBlocks.FIRE_JET.get() || state.m_60734_() == TFBlocks.ENCASED_FIRE_JET.get()) {
                    level.m_46597_(pos, (BlockState)state.m_61124_((Property)FireJetBlock.STATE, (Comparable)FireJetVariant.FLAME));
                }
                else {
                    level.m_7471_(pos, false);
                }
            }
        }
        else if (te.counter % 20 == 0) {
            for (int i = 0; i < 8; ++i) {
                level.m_7106_((ParticleOptions)ParticleTypes.f_123756_, pos.m_123341_() + 0.5, pos.m_123342_() + 1.5, pos.m_123343_() + 0.5, 0.0, 0.0, 0.0);
            }
            level.m_5594_((Player)null, pos, TFSounds.JET_POP, SoundSource.BLOCKS, 0.2f + level.f_46441_.nextFloat() * 0.2f, 0.9f + level.f_46441_.nextFloat() * 0.15f);
        }
    }
    
    private static void tickFlame(final Level level, final BlockPos pos, final BlockState state, final FireJetBlockEntity te) {
        final double x = pos.m_123341_();
        final double y = pos.m_7494_().m_123342_();
        final double z = pos.m_123343_();
        if (++te.counter > 60) {
            te.counter = 0;
            if (!level.f_46443_) {
                if (state.m_60734_() == TFBlocks.FIRE_JET.get() || state.m_60734_() == TFBlocks.ENCASED_FIRE_JET.get()) {
                    level.m_46597_(pos, (BlockState)state.m_61124_((Property)FireJetBlock.STATE, (Comparable)((state.m_60734_() == TFBlocks.FIRE_JET.get()) ? FireJetVariant.IDLE : FireJetVariant.TIMEOUT)));
                }
                else {
                    level.m_7471_(pos, false);
                }
            }
        }
        if (level.f_46443_) {
            if (te.counter % 2 == 0) {
                level.m_7106_((ParticleOptions)ParticleTypes.f_123755_, x + 0.5, y + 1.0, z + 0.5, 0.0, 0.0, 0.0);
                level.m_7106_((ParticleOptions)TFParticleType.LARGE_FLAME.get(), x + 0.5, y + 1.0, z + 0.5, 0.0, 0.5, 0.0);
                level.m_7106_((ParticleOptions)TFParticleType.LARGE_FLAME.get(), x - 0.5, y + 1.0, z + 0.5, 0.05, 0.5, 0.0);
                level.m_7106_((ParticleOptions)TFParticleType.LARGE_FLAME.get(), x + 0.5, y + 1.0, z - 0.5, 0.0, 0.5, 0.05);
                level.m_7106_((ParticleOptions)TFParticleType.LARGE_FLAME.get(), x + 1.5, y + 1.0, z + 0.5, -0.05, 0.5, 0.0);
                level.m_7106_((ParticleOptions)TFParticleType.LARGE_FLAME.get(), x + 0.5, y + 1.0, z + 1.5, 0.0, 0.5, -0.05);
            }
            if (te.counter % 4 == 0) {
                level.m_7785_(x + 0.5, y + 0.5, z + 0.5, TFSounds.JET_ACTIVE, SoundSource.BLOCKS, 1.0f + level.f_46441_.nextFloat(), level.f_46441_.nextFloat() * 0.7f + 0.3f, false);
            }
            else if (te.counter == 1) {
                level.m_7785_(x + 0.5, y + 0.5, z + 0.5, TFSounds.JET_START, SoundSource.BLOCKS, 1.0f + level.f_46441_.nextFloat(), level.f_46441_.nextFloat() * 0.7f + 0.3f, false);
            }
        }
        if (!level.f_46443_ && te.counter % 5 == 0) {
            final List<Entity> entitiesInRange = level.m_45976_((Class)Entity.class, new AABB(pos.m_142082_(-2, 0, -2), pos.m_142082_(2, 4, 2)));
            for (final Entity entity : entitiesInRange) {
                if (!entity.m_5825_()) {
                    entity.m_6469_(TFDamageSources.FIRE_JET, 2.0f);
                    entity.m_20254_(15);
                }
            }
        }
    }
}
