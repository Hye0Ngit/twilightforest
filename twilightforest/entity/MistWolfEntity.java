// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import twilightforest.TFSounds;
import javax.annotation.Nullable;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.item.DyeColor;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;

public class MistWolfEntity extends HostileWolfEntity
{
    public MistWolfEntity(final EntityType<? extends MistWolfEntity> type, final World world) {
        super(type, world);
        this.func_175547_a(DyeColor.GRAY);
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return HostileWolfEntity.registerAttributes().func_233815_a_(Attributes.field_233818_a_, 30.0).func_233815_a_(Attributes.field_233823_f_, 6.0);
    }
    
    public boolean func_70652_k(final Entity entity) {
        if (super.func_70652_k(entity)) {
            final float myBrightness = this.func_70013_c();
            if (entity instanceof LivingEntity && myBrightness < 0.1f) {
                int effectDuration = 0;
                switch (this.field_70170_p.func_175659_aa()) {
                    case EASY: {
                        effectDuration = 0;
                        break;
                    }
                    default: {
                        effectDuration = 7;
                        break;
                    }
                    case HARD: {
                        effectDuration = 15;
                        break;
                    }
                }
                if (effectDuration > 0) {
                    ((LivingEntity)entity).func_195064_c(new EffectInstance(Effects.field_76440_q, effectDuration * 20, 0));
                }
            }
            return true;
        }
        return false;
    }
    
    @Override
    public void func_70624_b(@Nullable final LivingEntity entity) {
        if (entity != null && entity != this.func_70638_az()) {
            this.func_184185_a(TFSounds.MISTWOLF_TARGET, 4.0f, this.func_70647_i());
        }
        super.func_70624_b(entity);
    }
    
    @Override
    protected SoundEvent func_184639_G() {
        return TFSounds.MISTWOLF_IDLE;
    }
    
    @Override
    protected SoundEvent func_184601_bQ(final DamageSource damageSourceIn) {
        return TFSounds.MISTWOLF_HURT;
    }
    
    @Override
    protected SoundEvent func_184615_bR() {
        return TFSounds.MISTWOLF_DEATH;
    }
    
    protected float func_70647_i() {
        return (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f + 0.6f;
    }
}
