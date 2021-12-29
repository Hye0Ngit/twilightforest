// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import net.minecraft.core.Vec3i;
import java.util.Random;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.ForgeEventFactory;
import java.util.EnumSet;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.damagesource.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;

public class TowerwoodBorer extends Monster
{
    private AISummonSilverfish summonSilverfish;
    
    public TowerwoodBorer(final EntityType<? extends TowerwoodBorer> type, final Level world) {
        super((EntityType)type, world);
    }
    
    protected void m_8099_() {
        this.f_21345_.m_25352_(1, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(2, (Goal)(this.summonSilverfish = new AISummonSilverfish(this)));
        this.f_21345_.m_25352_(3, (Goal)new MeleeAttackGoal((PathfinderMob)this, 1.0, false));
        this.f_21345_.m_25352_(4, (Goal)new AIHideInStone(this));
        this.f_21345_.m_25352_(5, (Goal)new LookAtPlayerGoal((Mob)this, (Class)Player.class, 8.0f));
        this.f_21345_.m_25352_(6, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21346_.m_25352_(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)this, (Class)Player.class, true));
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Monster.m_33035_().m_22268_(Attributes.f_22276_, 15.0).m_22268_(Attributes.f_22279_, 0.27).m_22268_(Attributes.f_22281_, 5.0).m_22268_(Attributes.f_22277_, 8.0);
    }
    
    public boolean m_20161_() {
        return false;
    }
    
    protected SoundEvent m_7515_() {
        return TFSounds.TERMITE_AMBIENT;
    }
    
    protected SoundEvent m_7975_(final DamageSource source) {
        return TFSounds.TERMITE_HURT;
    }
    
    protected SoundEvent m_5592_() {
        return TFSounds.TERMITE_DEATH;
    }
    
    public boolean m_6469_(final DamageSource source, final float amount) {
        if (this.m_6673_(source)) {
            return false;
        }
        if ((source instanceof EntityDamageSource || source == DamageSource.f_19319_) && this.summonSilverfish != null) {
            this.summonSilverfish.notifyHurt();
        }
        return super.m_6469_(source, amount);
    }
    
    protected void m_7355_(final BlockPos pos, final BlockState block) {
        this.m_5496_(TFSounds.TERMITE_STEP, 0.15f, 1.0f);
    }
    
    public void m_8119_() {
        this.f_20883_ = this.m_146908_();
        super.m_8119_();
    }
    
    public MobType m_6336_() {
        return MobType.f_21642_;
    }
    
    private static class AIHideInStone extends RandomStrollGoal
    {
        private Direction facing;
        private boolean doMerge;
        
        public AIHideInStone(final TowerwoodBorer silverfishIn) {
            super((PathfinderMob)silverfishIn, 1.0, 10);
            this.m_7021_((EnumSet)EnumSet.of(Goal.Flag.MOVE));
        }
        
        public boolean m_8036_() {
            if (this.f_25725_.m_5448_() != null) {
                return false;
            }
            if (!this.f_25725_.m_21573_().m_26571_()) {
                return false;
            }
            final Random random = this.f_25725_.m_21187_();
            if (random.nextInt(10) == 0 && ForgeEventFactory.getMobGriefingEvent(this.f_25725_.f_19853_, (Entity)this.f_25725_)) {
                this.facing = Direction.m_122404_(random);
                final BlockPos blockpos = new BlockPos(this.f_25725_.m_20185_(), this.f_25725_.m_20186_() + 0.5, this.f_25725_.m_20189_()).m_142300_(this.facing);
                final BlockState iblockstate = this.f_25725_.f_19853_.m_8055_(blockpos);
                if (iblockstate == ((Block)TFBlocks.TOWERWOOD.get()).m_49966_()) {
                    return this.doMerge = true;
                }
            }
            this.doMerge = false;
            return super.m_8036_();
        }
        
        public boolean m_8045_() {
            return !this.doMerge && super.m_8045_();
        }
        
        public void m_8056_() {
            if (!this.doMerge) {
                super.m_8056_();
            }
            else {
                final Level world = this.f_25725_.f_19853_;
                final BlockPos blockpos = new BlockPos(this.f_25725_.m_20185_(), this.f_25725_.m_20186_() + 0.5, this.f_25725_.m_20189_()).m_142300_(this.facing);
                final BlockState iblockstate = world.m_8055_(blockpos);
                if (iblockstate == ((Block)TFBlocks.TOWERWOOD.get()).m_49966_()) {
                    world.m_7731_(blockpos, ((Block)TFBlocks.INFESTED_TOWERWOOD.get()).m_49966_(), 3);
                    this.f_25725_.m_21373_();
                    this.f_25725_.m_146870_();
                }
            }
        }
    }
    
    private static class AISummonSilverfish extends Goal
    {
        private final TowerwoodBorer silverfish;
        private int lookForFriends;
        
        public AISummonSilverfish(final TowerwoodBorer silverfishIn) {
            this.silverfish = silverfishIn;
        }
        
        public void notifyHurt() {
            if (this.lookForFriends == 0) {
                this.lookForFriends = 20;
            }
        }
        
        public boolean m_8036_() {
            return this.lookForFriends > 0;
        }
        
        public void m_8037_() {
            --this.lookForFriends;
            if (this.lookForFriends <= 0) {
                final Level world = this.silverfish.f_19853_;
                final Random random = this.silverfish.m_21187_();
                final BlockPos blockpos = new BlockPos((Vec3i)this.silverfish.m_142538_());
                for (int i = 0; i <= 5 && i >= -5; i = ((i <= 0) ? (1 - i) : (-i))) {
                    for (int j = 0; j <= 10 && j >= -10; j = ((j <= 0) ? (1 - j) : (-j))) {
                        for (int k = 0; k <= 10 && k >= -10; k = ((k <= 0) ? (1 - k) : (-k))) {
                            final BlockPos blockpos2 = blockpos.m_142082_(j, i, k);
                            final BlockState iblockstate = world.m_8055_(blockpos2);
                            if (iblockstate == ((Block)TFBlocks.INFESTED_TOWERWOOD.get()).m_49966_()) {
                                if (ForgeEventFactory.getMobGriefingEvent(world, (Entity)this.silverfish)) {
                                    world.m_46961_(blockpos2, true);
                                }
                                else {
                                    world.m_7731_(blockpos2, ((Block)TFBlocks.TOWERWOOD.get()).m_49966_(), 3);
                                }
                                if (random.nextBoolean()) {
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
