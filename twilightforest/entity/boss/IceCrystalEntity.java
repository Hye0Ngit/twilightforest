// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.util.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.EntityType;
import twilightforest.entity.TFEntities;
import net.minecraft.world.World;
import twilightforest.entity.IceMobEntity;

public class IceCrystalEntity extends IceMobEntity
{
    private int crystalAge;
    private int maxCrystalAge;
    
    public IceCrystalEntity(final World worldIn) {
        super(TFEntities.ice_crystal, worldIn);
        this.maxCrystalAge = -1;
    }
    
    public IceCrystalEntity(final EntityType<? extends IceCrystalEntity> type, final World world) {
        super(type, world);
        this.maxCrystalAge = -1;
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (Goal)new SwimGoal((MobEntity)this));
        this.field_70714_bg.func_75776_a(1, (Goal)new MeleeAttackGoal((CreatureEntity)this, 1.0, false));
        this.field_70714_bg.func_75776_a(2, (Goal)new WaterAvoidingRandomWalkingGoal((CreatureEntity)this, 1.0));
        this.field_70714_bg.func_75776_a(3, (Goal)new LookAtGoal((MobEntity)this, (Class)PlayerEntity.class, 8.0f));
        this.field_70714_bg.func_75776_a(3, (Goal)new LookRandomlyGoal((MobEntity)this));
        this.field_70715_bh.func_75776_a(1, (Goal)new HurtByTargetGoal((CreatureEntity)this, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (Goal)new NearestAttackableTargetGoal((MobEntity)this, (Class)PlayerEntity.class, true));
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MonsterEntity.func_234295_eP_().func_233815_a_(Attributes.field_233818_a_, 10.0).func_233815_a_(Attributes.field_233821_d_, 0.23).func_233815_a_(Attributes.field_233823_f_, 5.0);
    }
    
    public int func_70641_bl() {
        return 8;
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.ICE_CORE_AMBIENT;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return TFSounds.ICE_CORE_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.ICE_CORE_DEATH;
    }
    
    public void setToDieIn30Seconds() {
        this.maxCrystalAge = 600;
    }
    
    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            ++this.crystalAge;
            if (this.maxCrystalAge > 0 && this.crystalAge >= this.maxCrystalAge) {
                this.func_70106_y();
            }
        }
    }
}
