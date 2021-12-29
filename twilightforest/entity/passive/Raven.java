// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.damagesource.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;

public class Raven extends TinyBird
{
    public Raven(final EntityType<? extends Raven> type, final Level world) {
        super(type, world);
        this.f_19793_ = 1.0f;
    }
    
    @Override
    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(1, (Goal)new PanicGoal((PathfinderMob)this, 1.5));
        this.f_21345_.m_25352_(2, (Goal)new TemptGoal((PathfinderMob)this, 0.8500000238418579, Raven.SEEDS, true));
        this.f_21345_.m_25352_(5, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 1.0));
        this.f_21345_.m_25352_(6, (Goal)new LookAtPlayerGoal((Mob)this, (Class)Player.class, 6.0f));
        this.f_21345_.m_25352_(7, (Goal)new RandomLookAroundGoal((Mob)this));
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return TinyBird.registerAttributes().m_22268_(Attributes.f_22276_, 10.0).m_22268_(Attributes.f_22279_, 0.2);
    }
    
    @Override
    protected SoundEvent m_7515_() {
        return TFSounds.RAVEN_CAW;
    }
    
    @Override
    protected SoundEvent m_7975_(final DamageSource source) {
        return TFSounds.RAVEN_SQUAWK;
    }
    
    @Override
    protected SoundEvent m_5592_() {
        return TFSounds.RAVEN_SQUAWK;
    }
    
    @Override
    public float m_20236_(final Pose pose) {
        return this.m_20206_() * 0.75f;
    }
    
    @Override
    protected boolean m_7341_(final Entity entityIn) {
        return false;
    }
    
    @Override
    public boolean isSpooked() {
        return this.f_20916_ > 0;
    }
}
