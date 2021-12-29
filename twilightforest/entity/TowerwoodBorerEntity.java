// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.util.math.vector.Vector3i;
import java.util.Random;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraftforge.event.ForgeEventFactory;
import java.util.EnumSet;
import net.minecraft.util.Direction;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;

public class TowerwoodBorerEntity extends MonsterEntity
{
    private AISummonSilverfish summonSilverfish;
    
    public TowerwoodBorerEntity(final EntityType<? extends TowerwoodBorerEntity> type, final World world) {
        super((EntityType)type, world);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(1, (Goal)new SwimGoal((MobEntity)this));
        this.field_70714_bg.func_75776_a(2, (Goal)(this.summonSilverfish = new AISummonSilverfish(this)));
        this.field_70714_bg.func_75776_a(3, (Goal)new MeleeAttackGoal((CreatureEntity)this, 1.0, false));
        this.field_70714_bg.func_75776_a(4, (Goal)new AIHideInStone(this));
        this.field_70714_bg.func_75776_a(5, (Goal)new LookAtGoal((MobEntity)this, (Class)PlayerEntity.class, 8.0f));
        this.field_70714_bg.func_75776_a(6, (Goal)new LookRandomlyGoal((MobEntity)this));
        this.field_70715_bh.func_75776_a(1, (Goal)new HurtByTargetGoal((CreatureEntity)this, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (Goal)new NearestAttackableTargetGoal((MobEntity)this, (Class)PlayerEntity.class, true));
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MonsterEntity.func_234295_eP_().func_233815_a_(Attributes.field_233818_a_, 15.0).func_233815_a_(Attributes.field_233821_d_, 0.27).func_233815_a_(Attributes.field_233823_f_, 5.0).func_233815_a_(Attributes.field_233819_b_, 8.0);
    }
    
    public boolean func_226271_bk_() {
        return false;
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.TERMITE_AMBIENT;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return TFSounds.TERMITE_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.TERMITE_DEATH;
    }
    
    public boolean func_70097_a(final DamageSource source, final float amount) {
        if (this.func_180431_b(source)) {
            return false;
        }
        if ((source instanceof EntityDamageSource || source == DamageSource.field_76376_m) && this.summonSilverfish != null) {
            this.summonSilverfish.notifyHurt();
        }
        return super.func_70097_a(source, amount);
    }
    
    protected void func_180429_a(final BlockPos pos, final BlockState block) {
        this.func_184185_a(TFSounds.TERMITE_STEP, 0.15f, 1.0f);
    }
    
    public void func_70071_h_() {
        this.field_70761_aq = this.field_70177_z;
        super.func_70071_h_();
    }
    
    public CreatureAttribute func_70668_bt() {
        return CreatureAttribute.field_223224_c_;
    }
    
    private static class AIHideInStone extends RandomWalkingGoal
    {
        private Direction facing;
        private boolean doMerge;
        
        public AIHideInStone(final TowerwoodBorerEntity silverfishIn) {
            super((CreatureEntity)silverfishIn, 1.0, 10);
            this.func_220684_a((EnumSet)EnumSet.of(Goal.Flag.MOVE));
        }
        
        public boolean func_75250_a() {
            if (this.field_75457_a.func_70638_az() != null) {
                return false;
            }
            if (!this.field_75457_a.func_70661_as().func_75500_f()) {
                return false;
            }
            final Random random = this.field_75457_a.func_70681_au();
            if (random.nextInt(10) == 0 && ForgeEventFactory.getMobGriefingEvent(this.field_75457_a.field_70170_p, (Entity)this.field_75457_a)) {
                this.facing = Direction.func_239631_a_(random);
                final BlockPos blockpos = new BlockPos(this.field_75457_a.func_226277_ct_(), this.field_75457_a.func_226278_cu_() + 0.5, this.field_75457_a.func_226281_cx_()).func_177972_a(this.facing);
                final BlockState iblockstate = this.field_75457_a.field_70170_p.func_180495_p(blockpos);
                if (iblockstate == ((Block)TFBlocks.tower_wood.get()).func_176223_P()) {
                    return this.doMerge = true;
                }
            }
            this.doMerge = false;
            return super.func_75250_a();
        }
        
        public boolean func_75253_b() {
            return !this.doMerge && super.func_75253_b();
        }
        
        public void func_75249_e() {
            if (!this.doMerge) {
                super.func_75249_e();
            }
            else {
                final World world = this.field_75457_a.field_70170_p;
                final BlockPos blockpos = new BlockPos(this.field_75457_a.func_226277_ct_(), this.field_75457_a.func_226278_cu_() + 0.5, this.field_75457_a.func_226281_cx_()).func_177972_a(this.facing);
                final BlockState iblockstate = world.func_180495_p(blockpos);
                if (iblockstate == ((Block)TFBlocks.tower_wood.get()).func_176223_P()) {
                    world.func_180501_a(blockpos, ((Block)TFBlocks.tower_wood_infested.get()).func_176223_P(), 3);
                    this.field_75457_a.func_70656_aK();
                    this.field_75457_a.func_70106_y();
                }
            }
        }
    }
    
    private static class AISummonSilverfish extends Goal
    {
        private TowerwoodBorerEntity silverfish;
        private int lookForFriends;
        
        public AISummonSilverfish(final TowerwoodBorerEntity silverfishIn) {
            this.silverfish = silverfishIn;
        }
        
        public void notifyHurt() {
            if (this.lookForFriends == 0) {
                this.lookForFriends = 20;
            }
        }
        
        public boolean func_75250_a() {
            return this.lookForFriends > 0;
        }
        
        public void func_75246_d() {
            --this.lookForFriends;
            if (this.lookForFriends <= 0) {
                final World world = this.silverfish.field_70170_p;
                final Random random = this.silverfish.func_70681_au();
                final BlockPos blockpos = new BlockPos((Vector3i)this.silverfish.func_233580_cy_());
                for (int i = 0; i <= 5 && i >= -5; i = ((i <= 0) ? (1 - i) : (-i))) {
                    for (int j = 0; j <= 10 && j >= -10; j = ((j <= 0) ? (1 - j) : (-j))) {
                        for (int k = 0; k <= 10 && k >= -10; k = ((k <= 0) ? (1 - k) : (-k))) {
                            final BlockPos blockpos2 = blockpos.func_177982_a(j, i, k);
                            final BlockState iblockstate = world.func_180495_p(blockpos2);
                            if (iblockstate == ((Block)TFBlocks.tower_wood_infested.get()).func_176223_P()) {
                                if (ForgeEventFactory.getMobGriefingEvent(world, (Entity)this.silverfish)) {
                                    world.func_175655_b(blockpos2, true);
                                }
                                else {
                                    world.func_180501_a(blockpos2, ((Block)TFBlocks.tower_wood.get()).func_176223_P(), 3);
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
