// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.Locale;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.gameevent.GameEvent;
import javax.annotation.Nullable;
import net.minecraft.world.phys.Vec3;
import twilightforest.client.particle.TFParticleType;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import java.util.Random;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.BaseEntityBlock;

public abstract class AbstractLightableBlock extends BaseEntityBlock
{
    public static final EnumProperty<Lighting> LIGHTING;
    
    public AbstractLightableBlock(final BlockBehaviour.Properties properties) {
        super(properties);
        this.m_49959_((BlockState)((BlockState)this.m_49965_().m_61090_()).m_61124_((Property)AbstractLightableBlock.LIGHTING, (Comparable)Lighting.NONE));
    }
    
    public InteractionResult m_6227_(final BlockState state, final Level level, final BlockPos pos, final Player player, final InteractionHand hand, final BlockHitResult result) {
        if (player.m_150110_().f_35938_ && player.m_21120_(hand).m_41619_() && state.m_61143_((Property)AbstractLightableBlock.LIGHTING) != Lighting.NONE) {
            extinguish(player, state, level, pos);
            return InteractionResult.m_19078_(level.f_46443_);
        }
        if (state.m_61143_((Property)AbstractLightableBlock.LIGHTING) == Lighting.NONE) {
            if (player.m_21120_(hand).m_150930_(Items.f_42409_)) {
                setLit((LevelAccessor)level, state, pos, true);
                level.m_5594_((Player)null, pos, SoundEvents.f_11942_, SoundSource.BLOCKS, 1.0f, 1.0f);
                if (!player.m_150110_().f_35937_) {
                    player.m_21120_(hand).m_41622_(1, (LivingEntity)player, res -> res.m_21190_(hand));
                }
                return InteractionResult.m_19078_(level.f_46443_);
            }
            if (player.m_21120_(hand).m_150930_(Items.f_42613_)) {
                setLit((LevelAccessor)level, state, pos, true);
                level.m_5594_((Player)null, pos, SoundEvents.f_11874_, SoundSource.BLOCKS, 1.0f, 1.0f);
                if (!player.m_150110_().f_35937_) {
                    player.m_21120_(hand).m_41774_(1);
                }
                return InteractionResult.m_19078_(level.f_46443_);
            }
        }
        return InteractionResult.PASS;
    }
    
    public void m_5581_(final Level level, final BlockState state, final BlockHitResult result, final Projectile projectile) {
        if (!level.f_46443_ && projectile.m_6060_() && this.canBeLit(state)) {
            setLit((LevelAccessor)level, state, result.m_82425_(), true);
        }
    }
    
    protected boolean canBeLit(final BlockState state) {
        return state.m_61143_((Property)AbstractLightableBlock.LIGHTING) == Lighting.NONE;
    }
    
    protected static void addParticlesAndSound(final Level level, final BlockPos pos, final double xFraction, final double yFraction, final double zFraction, final Random rand, final boolean ominous) {
        addParticlesAndSound(level, pos.m_123341_() + xFraction, pos.m_123342_() + yFraction, pos.m_123343_() + zFraction, rand, ominous);
    }
    
    protected static void addParticlesAndSound(final Level level, final double x, final double y, final double z, final Random rand, final boolean ominous) {
        final float var3 = rand.nextFloat();
        if (var3 < 0.3f) {
            if (!ominous) {
                level.m_7106_((ParticleOptions)ParticleTypes.f_123762_, x, y, z, 0.0, 0.0, 0.0);
            }
            if (var3 < 0.17f) {
                level.m_7785_(x + 0.5, y + 0.5, z + 0.5, SoundEvents.f_144096_, SoundSource.BLOCKS, 1.0f + rand.nextFloat(), rand.nextFloat() * 0.7f + 0.3f, false);
            }
        }
        level.m_7106_((ParticleOptions)(ominous ? ((ParticleOptions)TFParticleType.OMINOUS_FLAME.get()) : ParticleTypes.f_175834_), x, y, z, 0.0, 0.0, 0.0);
    }
    
    protected static void addParticlesAndSound(final Level level, final Vec3 vec, final Random rand, final boolean ominous) {
        final float var3 = rand.nextFloat();
        if (var3 < 0.3f) {
            if (!ominous) {
                level.m_7106_((ParticleOptions)ParticleTypes.f_123762_, vec.f_82479_, vec.f_82480_, vec.f_82481_, 0.0, 0.0, 0.0);
            }
            if (var3 < 0.17f) {
                level.m_7785_(vec.f_82479_ + 0.5, vec.f_82480_ + 0.5, vec.f_82481_ + 0.5, SoundEvents.f_144096_, SoundSource.BLOCKS, 1.0f + rand.nextFloat(), rand.nextFloat() * 0.7f + 0.3f, false);
            }
        }
        level.m_7106_((ParticleOptions)(ominous ? ((ParticleOptions)TFParticleType.OMINOUS_FLAME.get()) : ParticleTypes.f_175834_), vec.f_82479_, vec.f_82480_, vec.f_82481_, 0.0, 0.0, 0.0);
    }
    
    public static void extinguish(@Nullable final Player player, final BlockState state, final Level accessor, final BlockPos pos) {
        setLit((LevelAccessor)accessor, state, pos, false);
        final Block 60734_ = state.m_60734_();
        if (60734_ instanceof final AbstractSkullCandleBlock skull) {
            skull.getParticleOffsets(state, accessor, pos).forEach(p_151926_ -> accessor.m_7106_((ParticleOptions)ParticleTypes.f_123762_, pos.m_123341_() + p_151926_.m_7096_(), pos.m_123342_() + p_151926_.m_7098_(), pos.m_123343_() + p_151926_.m_7094_(), 0.0, 0.025, 0.0));
        }
        accessor.m_5594_((Player)null, pos, SoundEvents.f_144098_, SoundSource.BLOCKS, 1.0f, 1.0f);
        accessor.m_142346_((Entity)player, GameEvent.f_157792_, pos);
    }
    
    private static void setLit(final LevelAccessor accessor, final BlockState state, final BlockPos pos, final boolean lit) {
        accessor.m_7731_(pos, (BlockState)state.m_61124_((Property)AbstractLightableBlock.LIGHTING, (Comparable)(lit ? Lighting.NORMAL : Lighting.NONE)), 11);
    }
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.m_61104_(new Property[] { (Property)AbstractLightableBlock.LIGHTING });
    }
    
    static {
        LIGHTING = EnumProperty.m_61587_("lighting", (Class)Lighting.class);
    }
    
    public enum Lighting implements StringRepresentable
    {
        NONE, 
        NORMAL, 
        OMINOUS;
        
        public String m_7912_() {
            return this.name().toLowerCase(Locale.ROOT);
        }
    }
}
