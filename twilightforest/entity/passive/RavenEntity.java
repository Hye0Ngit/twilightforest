// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import net.minecraft.entity.Entity;
import net.minecraft.entity.Pose;
import net.minecraft.util.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;

public class RavenEntity extends TinyBirdEntity
{
    public RavenEntity(final EntityType<? extends RavenEntity> type, final World world) {
        super(type, world);
        this.field_70138_W = 1.0f;
    }
    
    @Override
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (Goal)new SwimGoal((MobEntity)this));
        this.field_70714_bg.func_75776_a(1, (Goal)new PanicGoal((CreatureEntity)this, 1.5));
        this.field_70714_bg.func_75776_a(2, (Goal)new TemptGoal((CreatureEntity)this, 0.8500000238418579, true, RavenEntity.SEEDS));
        this.field_70714_bg.func_75776_a(5, (Goal)new WaterAvoidingRandomWalkingGoal((CreatureEntity)this, 1.0));
        this.field_70714_bg.func_75776_a(6, (Goal)new LookAtGoal((MobEntity)this, (Class)PlayerEntity.class, 6.0f));
        this.field_70714_bg.func_75776_a(7, (Goal)new LookRandomlyGoal((MobEntity)this));
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return TinyBirdEntity.registerAttributes().func_233815_a_(Attributes.field_233818_a_, 10.0).func_233815_a_(Attributes.field_233821_d_, 0.2);
    }
    
    @Override
    protected SoundEvent func_184639_G() {
        return TFSounds.RAVEN_CAW;
    }
    
    @Override
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return TFSounds.RAVEN_SQUAWK;
    }
    
    @Override
    protected SoundEvent func_184615_bR() {
        return TFSounds.RAVEN_SQUAWK;
    }
    
    @Override
    public float func_213307_e(final Pose pose) {
        return this.func_213302_cg() * 0.75f;
    }
    
    @Override
    protected boolean func_184228_n(final Entity entityIn) {
        return false;
    }
    
    @Override
    public boolean isSpooked() {
        return this.field_70737_aN > 0;
    }
}
