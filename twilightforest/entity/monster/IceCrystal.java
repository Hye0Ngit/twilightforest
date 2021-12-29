// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import net.minecraft.world.damagesource.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.EntityType;
import twilightforest.entity.TFEntities;
import net.minecraft.world.level.Level;

public class IceCrystal extends BaseIceMob
{
    private int crystalAge;
    private int maxCrystalAge;
    
    public IceCrystal(final Level worldIn) {
        super(TFEntities.ICE_CRYSTAL, worldIn);
        this.maxCrystalAge = -1;
    }
    
    public IceCrystal(final EntityType<? extends IceCrystal> type, final Level world) {
        super(type, world);
        this.maxCrystalAge = -1;
    }
    
    protected void m_8099_() {
        this.f_21345_.m_25352_(0, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(1, (Goal)new MeleeAttackGoal((PathfinderMob)this, 1.0, false));
        this.f_21345_.m_25352_(2, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 1.0));
        this.f_21345_.m_25352_(3, (Goal)new LookAtPlayerGoal((Mob)this, (Class)Player.class, 8.0f));
        this.f_21345_.m_25352_(3, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21346_.m_25352_(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)this, (Class)Player.class, true));
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Monster.m_33035_().m_22268_(Attributes.f_22276_, 10.0).m_22268_(Attributes.f_22279_, 0.23).m_22268_(Attributes.f_22281_, 5.0);
    }
    
    public int m_5792_() {
        return 8;
    }
    
    protected SoundEvent m_7515_() {
        return TFSounds.ICE_CORE_AMBIENT;
    }
    
    protected SoundEvent m_7975_(final DamageSource source) {
        return TFSounds.ICE_CORE_HURT;
    }
    
    protected SoundEvent m_5592_() {
        return TFSounds.ICE_CORE_DEATH;
    }
    
    public void setToDieIn30Seconds() {
        this.maxCrystalAge = 600;
    }
    
    @Override
    public void m_8107_() {
        super.m_8107_();
        if (!this.f_19853_.f_46443_) {
            ++this.crystalAge;
            if (this.maxCrystalAge > 0 && this.crystalAge >= this.maxCrystalAge) {
                this.m_146870_();
            }
        }
    }
}
