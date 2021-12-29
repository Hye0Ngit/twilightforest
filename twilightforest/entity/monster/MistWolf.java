// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import net.minecraft.world.damagesource.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;

public class MistWolf extends HostileWolf
{
    public MistWolf(final EntityType<? extends MistWolf> type, final Level world) {
        super(type, world);
        this.m_30397_(DyeColor.GRAY);
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return HostileWolf.registerAttributes().m_22268_(Attributes.f_22276_, 30.0).m_22268_(Attributes.f_22281_, 6.0);
    }
    
    public boolean m_7327_(final Entity entity) {
        if (super.m_7327_(entity)) {
            final float myBrightness = this.m_6073_();
            if (entity instanceof LivingEntity && myBrightness < 0.1f) {
                int n = switch (this.f_19853_.m_46791_()) {
                    case EASY -> 0;
                    case HARD -> 15;
                    default -> 7;
                };
                final int effectDuration = n;
                if (effectDuration > 0) {
                    ((LivingEntity)entity).m_7292_(new MobEffectInstance(MobEffects.f_19610_, effectDuration * 20, 0));
                }
            }
            return true;
        }
        return false;
    }
    
    @Override
    protected SoundEvent getTargetSound() {
        return TFSounds.MISTWOLF_TARGET;
    }
    
    @Override
    protected SoundEvent m_7515_() {
        return TFSounds.MISTWOLF_AMBIENT;
    }
    
    @Override
    protected SoundEvent m_7975_(final DamageSource damageSourceIn) {
        return TFSounds.MISTWOLF_HURT;
    }
    
    @Override
    protected SoundEvent m_5592_() {
        return TFSounds.MISTWOLF_DEATH;
    }
    
    public float m_6100_() {
        return (this.f_19796_.nextFloat() - this.f_19796_.nextFloat()) * 0.2f + 0.6f;
    }
}
