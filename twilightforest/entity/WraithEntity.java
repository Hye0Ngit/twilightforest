// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.entity.ai.controller.MovementController;
import java.util.EnumSet;
import net.minecraft.world.IWorld;
import net.minecraft.entity.monster.MonsterEntity;
import java.util.Random;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.SpawnReason;
import net.minecraft.world.IServerWorld;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.DamageSource;
import net.minecraft.world.Difficulty;
import net.minecraft.item.Items;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import twilightforest.util.TFDamageSources;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.MobEntity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.FlyingEntity;

public class WraithEntity extends FlyingEntity implements IMob
{
    public WraithEntity(final EntityType<? extends WraithEntity> type, final World world) {
        super((EntityType)type, world);
        this.field_70765_h = new NoClipMoveHelper((MobEntity)this);
        this.field_70145_X = true;
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(4, (Goal)new AIAttack(this));
        this.field_70714_bg.func_75776_a(5, (Goal)new AIFlyTowardsTarget(this));
        this.field_70714_bg.func_75776_a(6, (Goal)new AIRandomFly(this));
        this.field_70714_bg.func_75776_a(7, (Goal)new AILookAround(this));
        this.field_70715_bh.func_75776_a(1, (Goal)new NearestAttackableTargetGoal((MobEntity)this, (Class)PlayerEntity.class, false));
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233818_a_, 20.0).func_233815_a_(Attributes.field_233821_d_, 0.5).func_233815_a_(Attributes.field_233823_f_, 5.0);
    }
    
    public boolean func_226271_bk_() {
        return false;
    }
    
    public boolean func_70652_k(final Entity entityIn) {
        float f = (float)this.func_110148_a(Attributes.field_233823_f_).func_111126_e();
        int i = 0;
        if (entityIn instanceof LivingEntity) {
            f += EnchantmentHelper.func_152377_a(this.func_184614_ca(), ((LivingEntity)entityIn).func_70668_bt());
            i += EnchantmentHelper.func_77501_a((LivingEntity)this);
        }
        final boolean flag = entityIn.func_70097_a(TFDamageSources.HAUNT((LivingEntity)this), f);
        if (flag) {
            if (i > 0 && entityIn instanceof LivingEntity) {
                ((LivingEntity)entityIn).func_233627_a_(i * 0.5f, (double)MathHelper.func_76126_a(this.field_70177_z * 0.017453292f), (double)(-MathHelper.func_76134_b(this.field_70177_z * 0.017453292f)));
                this.func_213293_j(this.func_213322_ci().func_82615_a() * 0.6, this.func_213322_ci().func_82617_b(), this.func_213322_ci().func_82616_c() * 0.6);
            }
            final int j = EnchantmentHelper.func_90036_a((LivingEntity)this);
            if (j > 0) {
                entityIn.func_70015_d(j * 4);
            }
            if (entityIn instanceof PlayerEntity) {
                final PlayerEntity entityplayer = (PlayerEntity)entityIn;
                final ItemStack itemstack = this.func_184614_ca();
                final ItemStack itemstack2 = entityplayer.func_184587_cr() ? entityplayer.func_184607_cu() : ItemStack.field_190927_a;
                if (!itemstack.func_190926_b() && !itemstack2.func_190926_b() && itemstack.func_77973_b() instanceof AxeItem && itemstack2.func_77973_b() == Items.field_185159_cQ) {
                    final float f2 = 0.25f + EnchantmentHelper.func_185293_e((LivingEntity)this) * 0.05f;
                    if (this.field_70146_Z.nextFloat() < f2) {
                        entityplayer.func_184811_cZ().func_185145_a(Items.field_185159_cQ, 100);
                        this.field_70170_p.func_72960_a((Entity)entityplayer, (byte)30);
                    }
                }
            }
            this.func_174815_a((LivingEntity)this, entityIn);
        }
        return flag;
    }
    
    private void despawnIfPeaceful() {
        if (!this.field_70170_p.field_72995_K && this.field_70170_p.func_175659_aa() == Difficulty.PEACEFUL) {
            this.func_70106_y();
        }
    }
    
    public void func_70636_d() {
        super.func_70636_d();
        this.despawnIfPeaceful();
    }
    
    public boolean func_70097_a(final DamageSource source, final float amount) {
        if (!super.func_70097_a(source, amount)) {
            return false;
        }
        final Entity entity = source.func_76346_g();
        if (this.func_184187_bx() == entity || this.func_184188_bt().contains(entity)) {
            return true;
        }
        if (entity != this && entity instanceof LivingEntity && !source.func_180136_u()) {
            this.func_70624_b((LivingEntity)entity);
        }
        return true;
    }
    
    protected boolean func_184228_n(final Entity entityIn) {
        return false;
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.WRAITH_AMBIENT;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return TFSounds.WRAITH_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.WRAITH_DEATH;
    }
    
    public static boolean getCanSpawnHere(final EntityType<? extends WraithEntity> entity, final IServerWorld world, final SpawnReason reason, final BlockPos pos, final Random random) {
        return world.func_175659_aa() != Difficulty.PEACEFUL && MonsterEntity.func_223323_a(world, pos, random) && func_223315_a((EntityType)entity, (IWorld)world, reason, pos, random);
    }
    
    static class AIFlyTowardsTarget extends Goal
    {
        private final WraithEntity taskOwner;
        
        AIFlyTowardsTarget(final WraithEntity wraith) {
            this.taskOwner = wraith;
            this.func_220684_a((EnumSet)EnumSet.of(Goal.Flag.MOVE));
        }
        
        public boolean func_75250_a() {
            return this.taskOwner.func_70638_az() != null;
        }
        
        public boolean func_75253_b() {
            return false;
        }
        
        public void func_75249_e() {
            final LivingEntity target = this.taskOwner.func_70638_az();
            if (target != null) {
                this.taskOwner.func_70605_aq().func_75642_a(target.func_226277_ct_(), target.func_226278_cu_(), target.func_226281_cx_(), 0.5);
            }
        }
    }
    
    static class AIAttack extends Goal
    {
        private final WraithEntity taskOwner;
        private int attackTick;
        
        AIAttack(final WraithEntity taskOwner) {
            this.attackTick = 20;
            this.taskOwner = taskOwner;
        }
        
        public boolean func_75250_a() {
            final LivingEntity target = this.taskOwner.func_70638_az();
            return target != null && target.func_174813_aQ().field_72337_e > this.taskOwner.func_174813_aQ().field_72338_b && target.func_174813_aQ().field_72338_b < this.taskOwner.func_174813_aQ().field_72337_e && this.taskOwner.func_70068_e((Entity)target) <= 4.0;
        }
        
        public void func_75246_d() {
            if (this.attackTick > 0) {
                --this.attackTick;
            }
        }
        
        public void func_75251_c() {
            this.attackTick = 20;
        }
        
        public void func_75249_e() {
            if (this.taskOwner.func_70638_az() != null) {
                this.taskOwner.func_70652_k((Entity)this.taskOwner.func_70638_az());
            }
            this.attackTick = 20;
        }
    }
    
    static class AIRandomFly extends Goal
    {
        private final WraithEntity parentEntity;
        
        public AIRandomFly(final WraithEntity wraith) {
            this.parentEntity = wraith;
            this.func_220684_a((EnumSet)EnumSet.of(Goal.Flag.MOVE));
        }
        
        public boolean func_75250_a() {
            if (this.parentEntity.func_70638_az() != null) {
                return false;
            }
            final MovementController entitymovehelper = this.parentEntity.func_70605_aq();
            final double d0 = entitymovehelper.func_179917_d() - this.parentEntity.func_226277_ct_();
            final double d2 = entitymovehelper.func_179919_e() - this.parentEntity.func_226278_cu_();
            final double d3 = entitymovehelper.func_179918_f() - this.parentEntity.func_226281_cx_();
            final double d4 = d0 * d0 + d2 * d2 + d3 * d3;
            return d4 < 1.0 || d4 > 3600.0;
        }
        
        public boolean func_75253_b() {
            return false;
        }
        
        public void func_75249_e() {
            final Random random = this.parentEntity.func_70681_au();
            final double d0 = this.parentEntity.func_226277_ct_() + (random.nextFloat() * 2.0f - 1.0f) * 16.0f;
            final double d2 = this.parentEntity.func_226278_cu_() + (random.nextFloat() * 2.0f - 1.0f) * 16.0f;
            final double d3 = this.parentEntity.func_226281_cx_() + (random.nextFloat() * 2.0f - 1.0f) * 16.0f;
            this.parentEntity.func_70605_aq().func_75642_a(d0, d2, d3, 0.5);
        }
    }
    
    public static class AILookAround extends Goal
    {
        private final WraithEntity parentEntity;
        
        public AILookAround(final WraithEntity wraith) {
            this.parentEntity = wraith;
            this.func_220684_a((EnumSet)EnumSet.of(Goal.Flag.LOOK));
        }
        
        public boolean func_75250_a() {
            return true;
        }
        
        public void func_75246_d() {
            if (this.parentEntity.func_70638_az() == null) {
                this.parentEntity.field_70177_z = -(float)MathHelper.func_181159_b(this.parentEntity.func_213322_ci().func_82615_a(), this.parentEntity.func_213322_ci().func_82616_c()) * 57.295776f;
                this.parentEntity.field_70761_aq = this.parentEntity.field_70177_z;
            }
            else {
                final LivingEntity entitylivingbase = this.parentEntity.func_70638_az();
                if (entitylivingbase.func_70068_e((Entity)this.parentEntity) < 4096.0) {
                    final double d1 = entitylivingbase.func_226277_ct_() - this.parentEntity.func_226277_ct_();
                    final double d2 = entitylivingbase.func_226281_cx_() - this.parentEntity.func_226281_cx_();
                    this.parentEntity.field_70177_z = -(float)MathHelper.func_181159_b(d1, d2) * 57.295776f;
                    this.parentEntity.field_70761_aq = this.parentEntity.field_70177_z;
                }
            }
        }
    }
}
