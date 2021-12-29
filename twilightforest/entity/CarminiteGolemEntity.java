// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.MathHelper;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;

public class CarminiteGolemEntity extends MonsterEntity
{
    private int attackTimer;
    
    public CarminiteGolemEntity(final EntityType<? extends CarminiteGolemEntity> type, final World world) {
        super((EntityType)type, world);
        this.func_184644_a(PathNodeType.WATER, -1.0f);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(1, (Goal)new MeleeAttackGoal((CreatureEntity)this, 1.0, false));
        this.field_70714_bg.func_75776_a(2, (Goal)new WaterAvoidingRandomWalkingGoal((CreatureEntity)this, 1.0, 0.0f));
        this.field_70714_bg.func_75776_a(3, (Goal)new LookAtGoal((MobEntity)this, (Class)PlayerEntity.class, 6.0f));
        this.field_70714_bg.func_75776_a(3, (Goal)new LookRandomlyGoal((MobEntity)this));
        this.field_70715_bh.func_75776_a(1, (Goal)new HurtByTargetGoal((CreatureEntity)this, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (Goal)new NearestAttackableTargetGoal((MobEntity)this, (Class)PlayerEntity.class, true));
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MonsterEntity.func_234295_eP_().func_233815_a_(Attributes.field_233818_a_, 40.0).func_233815_a_(Attributes.field_233821_d_, 0.25).func_233815_a_(Attributes.field_233823_f_, 9.0).func_233815_a_(Attributes.field_233826_i_, 2.0);
    }
    
    public boolean func_70652_k(final Entity entity) {
        this.attackTimer = 10;
        this.field_70170_p.func_72960_a((Entity)this, (byte)4);
        final boolean attackSuccess = super.func_70652_k(entity);
        if (attackSuccess) {
            entity.func_70024_g(0.0, 0.4, 0.0);
        }
        return attackSuccess;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return TFSounds.CARMINITE_GOLEM_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.CARMINITE_GOLEM_DEATH;
    }
    
    protected void func_180429_a(final BlockPos pos, final BlockState block) {
        this.func_184185_a(TFSounds.CARMINITE_GOLEM_STEP, 1.0f, 1.0f);
    }
    
    public void func_70636_d() {
        super.func_70636_d();
        if (this.attackTimer > 0) {
            --this.attackTimer;
        }
        if (this.func_213322_ci().func_82615_a() * this.func_213322_ci().func_82615_a() + this.func_213322_ci().func_82616_c() * this.func_213322_ci().func_82616_c() > 2.500000277905201E-7 && this.field_70146_Z.nextInt(5) == 0) {
            final int i = MathHelper.func_76128_c(this.func_226277_ct_());
            final int j = MathHelper.func_76128_c(this.func_226278_cu_() - 0.20000000298023224);
            final int k = MathHelper.func_76128_c(this.func_226281_cx_());
            final BlockState iblockstate = this.field_70170_p.func_180495_p(new BlockPos(i, j, k));
            if (iblockstate.func_185904_a() != Material.field_151579_a) {
                this.field_70170_p.func_195594_a((IParticleData)new BlockParticleData(ParticleTypes.field_197611_d, iblockstate), this.func_226277_ct_() + (this.field_70146_Z.nextFloat() - 0.5) * this.func_213311_cf(), this.func_174813_aQ().field_72338_b + 0.1, this.func_226281_cx_() + (this.field_70146_Z.nextFloat() - 0.5) * this.func_213311_cf(), 4.0 * (this.field_70146_Z.nextFloat() - 0.5), 0.5, (this.field_70146_Z.nextFloat() - 0.5) * 4.0);
            }
        }
        if (this.field_70146_Z.nextBoolean()) {
            this.field_70170_p.func_195594_a((IParticleData)new RedstoneParticleData(1.0f, 0.0f, 0.0f, 1.0f), this.func_226277_ct_() + (this.field_70146_Z.nextDouble() - 0.5) * this.func_213311_cf(), this.func_226278_cu_() + this.field_70146_Z.nextDouble() * this.func_213302_cg() - 0.25, this.func_226281_cx_() + (this.field_70146_Z.nextDouble() - 0.5) * this.func_213311_cf(), 0.0, 0.0, 0.0);
        }
    }
    
    @OnlyIn(Dist.CLIENT)
    public void func_70103_a(final byte id) {
        if (id == 4) {
            this.attackTimer = 10;
            this.func_184185_a(TFSounds.CARMINITE_GOLEM_ATTACK, 1.0f, 1.0f);
        }
        else {
            super.func_70103_a(id);
        }
    }
    
    public int getAttackTimer() {
        return this.attackTimer;
    }
    
    public int func_70641_bl() {
        return 16;
    }
}
