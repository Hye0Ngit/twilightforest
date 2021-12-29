// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import java.util.Random;
import net.minecraft.entity.ai.EntityMoveHelper;
import twilightforest.TwilightForestMod;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.util.math.BlockPos;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.init.Items;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.DamageSource;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import twilightforest.entity.ai.EntityAITFFindEntityNearestPlayer;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.EntityFlying;

public class EntityTFWraith extends EntityFlying implements IMob
{
    public static final ResourceLocation LOOT_TABLE;
    
    public EntityTFWraith(final World world) {
        super(world);
        this.field_70765_h = new NoClipMoveHelper((EntityLiving)this);
        this.field_70145_X = true;
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new AIAttack(this));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new AIFlyTowardsTarget(this));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new AIRandomFly(this));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new AILookAround(this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAITFFindEntityNearestPlayer((EntityLiving)this));
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(20.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.5);
        this.func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(5.0);
    }
    
    public boolean func_70041_e_() {
        return false;
    }
    
    public boolean func_70652_k(final Entity entityIn) {
        float f = (float)this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
        int i = 0;
        if (entityIn instanceof EntityLivingBase) {
            f += EnchantmentHelper.func_152377_a(this.func_184614_ca(), ((EntityLivingBase)entityIn).func_70668_bt());
            i += EnchantmentHelper.func_77501_a((EntityLivingBase)this);
        }
        final boolean flag = entityIn.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), f);
        if (flag) {
            if (i > 0 && entityIn instanceof EntityLivingBase) {
                ((EntityLivingBase)entityIn).func_70653_a((Entity)this, i * 0.5f, (double)MathHelper.func_76126_a(this.field_70177_z * 0.017453292f), (double)(-MathHelper.func_76134_b(this.field_70177_z * 0.017453292f)));
                this.field_70159_w *= 0.6;
                this.field_70179_y *= 0.6;
            }
            final int j = EnchantmentHelper.func_90036_a((EntityLivingBase)this);
            if (j > 0) {
                entityIn.func_70015_d(j * 4);
            }
            if (entityIn instanceof EntityPlayer) {
                final EntityPlayer entityplayer = (EntityPlayer)entityIn;
                final ItemStack itemstack = this.func_184614_ca();
                final ItemStack itemstack2 = entityplayer.func_184587_cr() ? entityplayer.func_184607_cu() : ItemStack.field_190927_a;
                if (!itemstack.func_190926_b() && !itemstack2.func_190926_b() && itemstack.func_77973_b() instanceof ItemAxe && itemstack2.func_77973_b() == Items.field_185159_cQ) {
                    final float f2 = 0.25f + EnchantmentHelper.func_185293_e((EntityLivingBase)this) * 0.05f;
                    if (this.field_70146_Z.nextFloat() < f2) {
                        entityplayer.func_184811_cZ().func_185145_a(Items.field_185159_cQ, 100);
                        this.field_70170_p.func_72960_a((Entity)entityplayer, (byte)30);
                    }
                }
            }
            this.func_174815_a((EntityLivingBase)this, entityIn);
        }
        return flag;
    }
    
    private void despawnIfPeaceful() {
        if (!this.field_70170_p.field_72995_K && this.field_70170_p.func_175659_aa() == EnumDifficulty.PEACEFUL) {
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
        if (entity != this && entity instanceof EntityLivingBase) {
            this.func_70624_b((EntityLivingBase)entity);
        }
        return true;
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.WRAITH;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource source) {
        return TFSounds.WRAITH;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.WRAITH;
    }
    
    public ResourceLocation func_184647_J() {
        return EntityTFWraith.LOOT_TABLE;
    }
    
    protected boolean isValidLightLevel() {
        final BlockPos blockpos = new BlockPos(this.field_70165_t, this.func_174813_aQ().field_72338_b, this.field_70161_v);
        if (this.field_70170_p.func_175642_b(EnumSkyBlock.SKY, blockpos) > this.field_70146_Z.nextInt(32)) {
            return false;
        }
        int i = this.field_70170_p.func_175671_l(blockpos);
        if (this.field_70170_p.func_72911_I()) {
            final int j = this.field_70170_p.func_175657_ab();
            this.field_70170_p.func_175692_b(10);
            i = this.field_70170_p.func_175671_l(blockpos);
            this.field_70170_p.func_175692_b(j);
        }
        return i <= this.field_70146_Z.nextInt(8);
    }
    
    public boolean func_70601_bi() {
        return this.field_70170_p.func_175659_aa() != EnumDifficulty.PEACEFUL && this.isValidLightLevel() && super.func_70601_bi();
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/wraith");
    }
    
    static class AIFlyTowardsTarget extends EntityAIBase
    {
        private final EntityTFWraith taskOwner;
        
        AIFlyTowardsTarget(final EntityTFWraith wraith) {
            this.taskOwner = wraith;
            this.func_75248_a(1);
        }
        
        public boolean func_75250_a() {
            return this.taskOwner.func_70638_az() != null;
        }
        
        public boolean func_75253_b() {
            return false;
        }
        
        public void func_75249_e() {
            final EntityLivingBase target = this.taskOwner.func_70638_az();
            if (target != null) {
                this.taskOwner.func_70605_aq().func_75642_a(target.field_70165_t, target.field_70163_u, target.field_70161_v, 0.5);
            }
        }
    }
    
    static class AIAttack extends EntityAIBase
    {
        private final EntityTFWraith taskOwner;
        private int attackTick;
        
        AIAttack(final EntityTFWraith taskOwner) {
            this.attackTick = 20;
            this.taskOwner = taskOwner;
        }
        
        public boolean func_75250_a() {
            final EntityLivingBase target = this.taskOwner.func_70638_az();
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
    
    static class AIRandomFly extends EntityAIBase
    {
        private final EntityTFWraith parentEntity;
        
        public AIRandomFly(final EntityTFWraith wraith) {
            this.parentEntity = wraith;
            this.func_75248_a(1);
        }
        
        public boolean func_75250_a() {
            if (this.parentEntity.func_70638_az() != null) {
                return false;
            }
            final EntityMoveHelper entitymovehelper = this.parentEntity.func_70605_aq();
            final double d0 = entitymovehelper.func_179917_d() - this.parentEntity.field_70165_t;
            final double d2 = entitymovehelper.func_179919_e() - this.parentEntity.field_70163_u;
            final double d3 = entitymovehelper.func_179918_f() - this.parentEntity.field_70161_v;
            final double d4 = d0 * d0 + d2 * d2 + d3 * d3;
            return d4 < 1.0 || d4 > 3600.0;
        }
        
        public boolean func_75253_b() {
            return false;
        }
        
        public void func_75249_e() {
            final Random random = this.parentEntity.func_70681_au();
            final double d0 = this.parentEntity.field_70165_t + (random.nextFloat() * 2.0f - 1.0f) * 16.0f;
            final double d2 = this.parentEntity.field_70163_u + (random.nextFloat() * 2.0f - 1.0f) * 16.0f;
            final double d3 = this.parentEntity.field_70161_v + (random.nextFloat() * 2.0f - 1.0f) * 16.0f;
            this.parentEntity.func_70605_aq().func_75642_a(d0, d2, d3, 0.5);
        }
    }
    
    public static class AILookAround extends EntityAIBase
    {
        private final EntityTFWraith parentEntity;
        
        public AILookAround(final EntityTFWraith wraith) {
            this.parentEntity = wraith;
            this.func_75248_a(2);
        }
        
        public boolean func_75250_a() {
            return true;
        }
        
        public void func_75246_d() {
            if (this.parentEntity.func_70638_az() == null) {
                this.parentEntity.field_70177_z = -(float)MathHelper.func_181159_b(this.parentEntity.field_70159_w, this.parentEntity.field_70179_y) * 57.295776f;
                this.parentEntity.field_70761_aq = this.parentEntity.field_70177_z;
            }
            else {
                final EntityLivingBase entitylivingbase = this.parentEntity.func_70638_az();
                if (entitylivingbase.func_70068_e((Entity)this.parentEntity) < 4096.0) {
                    final double d1 = entitylivingbase.field_70165_t - this.parentEntity.field_70165_t;
                    final double d2 = entitylivingbase.field_70161_v - this.parentEntity.field_70161_v;
                    this.parentEntity.field_70177_z = -(float)MathHelper.func_181159_b(d1, d2) * 57.295776f;
                    this.parentEntity.field_70761_aq = this.parentEntity.field_70177_z;
                }
            }
        }
    }
}
