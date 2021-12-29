// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;

public class HarbingerCube extends Monster
{
    public HarbingerCube(final EntityType<? extends HarbingerCube> type, final Level world) {
        super((EntityType)type, world);
    }
    
    protected void m_8099_() {
        this.f_21345_.m_25352_(1, (Goal)new FloatGoal((Mob)this));
        this.f_21345_.m_25352_(1, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 1.0));
        this.f_21345_.m_25352_(2, (Goal)new LookAtPlayerGoal((Mob)this, (Class)Player.class, 8.0f));
        this.f_21345_.m_25352_(2, (Goal)new RandomLookAroundGoal((Mob)this));
        this.f_21346_.m_25352_(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)this, (Class)Player.class, true));
    }
    
    public static AttributeSupplier.Builder registerAttributes() {
        return Monster.m_33035_().m_22268_(Attributes.f_22276_, 40.0).m_22268_(Attributes.f_22279_, 0.23);
    }
}
