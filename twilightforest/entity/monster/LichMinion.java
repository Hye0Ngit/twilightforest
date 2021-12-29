// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import java.util.Iterator;
import java.util.List;
import net.minecraft.world.phys.AABB;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.damagesource.DamageSource;
import twilightforest.entity.TFEntities;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import twilightforest.entity.boss.Lich;
import net.minecraft.world.entity.monster.Zombie;

public class LichMinion extends Zombie
{
    public Lich master;
    
    public LichMinion(final EntityType<? extends LichMinion> type, final Level world) {
        super((EntityType)type, world);
        this.master = null;
    }
    
    public LichMinion(final Level world, final Lich entityTFLich) {
        super((EntityType)TFEntities.LICH_MINION, world);
        this.master = entityTFLich;
    }
    
    public boolean m_6469_(final DamageSource source, final float amount) {
        final LivingEntity prevTarget = this.m_5448_();
        if (super.m_6469_(source, amount)) {
            if (source.m_7639_() instanceof Lich) {
                this.m_6703_(prevTarget);
                this.m_7292_(new MobEffectInstance(MobEffects.f_19596_, 200, 4));
                this.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 200, 1));
            }
            return true;
        }
        return false;
    }
    
    protected SoundEvent m_7515_() {
        return TFSounds.MINION_AMBIENT;
    }
    
    protected SoundEvent m_7975_(final DamageSource damageSourceIn) {
        return TFSounds.MINION_HURT;
    }
    
    protected SoundEvent m_5592_() {
        return TFSounds.MINION_DEATH;
    }
    
    protected SoundEvent m_7660_() {
        return TFSounds.MINION_STEP;
    }
    
    public void m_8107_() {
        if (this.master == null) {
            this.findNewMaster();
        }
        if (this.master == null || !this.master.m_6084_()) {
            this.m_21153_(0.0f);
        }
        super.m_8107_();
    }
    
    private void findNewMaster() {
        final List<Lich> nearbyLiches = this.f_19853_.m_45976_((Class)Lich.class, new AABB(this.m_20185_(), this.m_20186_(), this.m_20189_(), this.m_20185_() + 1.0, this.m_20186_() + 1.0, this.m_20189_() + 1.0).m_82377_(32.0, 16.0, 32.0));
        for (final Lich nearbyLich : nearbyLiches) {
            if (!nearbyLich.isShadowClone() && nearbyLich.wantsNewMinion()) {
                (this.master = nearbyLich).makeBlackMagicTrail(this.m_20185_(), this.m_20186_() + this.m_20192_(), this.m_20189_(), this.master.m_20185_(), this.master.m_20186_() + this.master.m_20192_(), this.master.m_20189_());
                this.m_6710_(this.master.m_5448_());
                break;
            }
        }
    }
}
