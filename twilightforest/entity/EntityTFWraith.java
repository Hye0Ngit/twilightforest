// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFFeature;
import net.minecraft.stats.StatBase;
import twilightforest.TFAchievementPage;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.EntityFlying;

public class EntityTFWraith extends EntityFlying implements IMob
{
    public int courseChangeCooldown;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    private Entity targetedEntity;
    private int aggroCooldown;
    public int prevAttackCounter;
    public int attackCounter;
    int attackStrength;
    
    public EntityTFWraith(final World world) {
        super(world);
        this.field_70750_az = "/mods/twilightforest/textures/model/ghost-crown.png";
        this.field_70697_bw = 0.5f;
        this.attackStrength = 5;
    }
    
    public EntityTFWraith(final World world, final double x, final double y, final double z) {
        this(world);
        this.func_70107_b(x, y, z);
    }
    
    public int func_70667_aM() {
        return 20;
    }
    
    public void func_70636_d() {
        if (this.field_70170_p.func_72935_r()) {
            final float f = this.func_70013_c(1.0f);
            if (f <= 0.5f || !this.field_70170_p.func_72937_j(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v)) || this.field_70146_Z.nextFloat() * 30.0f < (f - 0.4f) * 2.0f) {}
        }
        super.func_70636_d();
    }
    
    public boolean func_70041_e_() {
        return false;
    }
    
    protected void func_70626_be() {
        if (!this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u == 0) {
            this.func_70106_y();
        }
        this.func_70623_bb();
        this.prevAttackCounter = this.attackCounter;
        final double d = this.waypointX - this.field_70165_t;
        final double d2 = this.waypointY - this.field_70163_u;
        final double d3 = this.waypointZ - this.field_70161_v;
        final double d4 = MathHelper.func_76133_a(d * d + d2 * d2 + d3 * d3);
        if (d4 < 1.0 || d4 > 60.0) {
            this.waypointX = this.field_70165_t + (this.field_70146_Z.nextFloat() * 2.0f - 1.0f) * 16.0f;
            this.waypointY = this.field_70163_u + (this.field_70146_Z.nextFloat() * 2.0f - 1.0f) * 16.0f;
            this.waypointZ = this.field_70161_v + (this.field_70146_Z.nextFloat() * 2.0f - 1.0f) * 16.0f;
        }
        if (this.courseChangeCooldown-- <= 0) {
            this.courseChangeCooldown += this.field_70146_Z.nextInt(5) + 2;
            if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, d4)) {
                this.field_70159_w += d / d4 * 0.1;
                this.field_70181_x += d2 / d4 * 0.1;
                this.field_70179_y += d3 / d4 * 0.1;
            }
            else {
                this.waypointX = this.field_70165_t;
                this.waypointY = this.field_70163_u;
                this.waypointZ = this.field_70161_v;
                this.targetedEntity = null;
            }
        }
        if (this.targetedEntity != null && this.targetedEntity.field_70128_L) {
            this.targetedEntity = null;
        }
        if (this.targetedEntity == null || this.aggroCooldown-- <= 0) {
            this.targetedEntity = this.findPlayerToAttack();
            if (this.targetedEntity != null) {
                this.aggroCooldown = 20;
            }
        }
        else {
            final float f1 = this.targetedEntity.func_70032_d((Entity)this);
            if (this.func_70685_l(this.targetedEntity)) {
                this.attackEntity(this.targetedEntity, f1);
            }
            else {
                this.attackBlockedEntity(this.targetedEntity, f1);
            }
        }
        final double d5 = 64.0;
        if (this.targetedEntity != null && this.targetedEntity.func_70068_e((Entity)this) < d5 * d5) {
            final double d6 = this.targetedEntity.field_70165_t - this.field_70165_t;
            final double d7 = this.targetedEntity.field_70121_D.field_72338_b + this.targetedEntity.field_70131_O / 2.0f - (this.field_70163_u + this.field_70131_O / 2.0f);
            final double d8 = this.targetedEntity.field_70161_v - this.field_70161_v;
            final float n = -(float)Math.atan2(d6, d8) * 180.0f / 3.141593f;
            this.field_70177_z = n;
            this.field_70761_aq = n;
            if (this.func_70685_l(this.targetedEntity)) {
                if (this.attackCounter == 10) {}
                ++this.attackCounter;
                if (this.attackCounter == 20) {
                    this.waypointX = this.targetedEntity.field_70165_t;
                    this.waypointY = this.targetedEntity.field_70163_u - this.targetedEntity.field_70131_O + 0.5;
                    this.waypointZ = this.targetedEntity.field_70161_v;
                    this.attackCounter = -40;
                }
            }
            else if (this.attackCounter > 0) {
                --this.attackCounter;
            }
        }
        else {
            final float n2 = -(float)Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0f / 3.141593f;
            this.field_70177_z = n2;
            this.field_70761_aq = n2;
            if (this.attackCounter > 0) {
                --this.attackCounter;
            }
        }
    }
    
    protected void attackEntity(final Entity entity, final float f) {
        if (this.field_70724_aR <= 0 && f < 2.0f && entity.field_70121_D.field_72337_e > this.field_70121_D.field_72338_b && entity.field_70121_D.field_72338_b < this.field_70121_D.field_72337_e) {
            this.field_70724_aR = 20;
            entity.func_70097_a(DamageSource.func_76358_a((EntityLiving)this), this.attackStrength);
        }
    }
    
    protected void attackBlockedEntity(final Entity entity, final float f) {
    }
    
    public boolean func_70097_a(final DamageSource damagesource, final int i) {
        if (!super.func_70097_a(damagesource, i)) {
            return false;
        }
        final Entity entity = damagesource.func_76346_g();
        if (this.field_70153_n == entity || this.field_70154_o == entity) {
            return true;
        }
        if (entity != this) {
            this.targetedEntity = entity;
        }
        return true;
    }
    
    protected Entity findPlayerToAttack() {
        final EntityPlayer entityplayer = this.field_70170_p.func_72856_b((Entity)this, 16.0);
        if (entityplayer != null && this.func_70685_l((Entity)entityplayer)) {
            return (Entity)entityplayer;
        }
        return null;
    }
    
    private boolean isCourseTraversable(final double d, final double d1, final double d2, final double d3) {
        final double d4 = (this.waypointX - this.field_70165_t) / d3;
        final double d5 = (this.waypointY - this.field_70163_u) / d3;
        final double d6 = (this.waypointZ - this.field_70161_v) / d3;
        final AxisAlignedBB axisalignedbb = this.field_70121_D.func_72329_c();
        for (int i = 1; i < d3; ++i) {
            axisalignedbb.func_72317_d(d4, d5, d6);
            if (this.field_70170_p.func_72945_a((Entity)this, axisalignedbb).size() > 0) {
                return false;
            }
        }
        return true;
    }
    
    protected String func_70639_aQ() {
        return "mob.tf.wraith.wraith";
    }
    
    protected String func_70621_aR() {
        return "mob.tf.wraith.wraith";
    }
    
    protected String func_70673_aS() {
        return "mob.tf.wraith.wraith";
    }
    
    protected int func_70633_aT() {
        return Item.field_77751_aT.field_77779_bT;
    }
    
    public void func_70645_a(final DamageSource par1DamageSource) {
        super.func_70645_a(par1DamageSource);
        if (par1DamageSource.func_76364_f() instanceof EntityPlayer) {
            ((EntityPlayer)par1DamageSource.func_76364_f()).func_71029_a((StatBase)TFAchievementPage.twilightHunter);
            final int chunkX = MathHelper.func_76128_c(this.field_70165_t) >> 4;
            final int chunkZ = MathHelper.func_76128_c(this.field_70161_v) >> 4;
            if (TFFeature.getNearestFeature(chunkX, chunkZ, this.field_70170_p) == TFFeature.hill3) {
                ((EntityPlayer)par1DamageSource.func_76364_f()).func_71029_a((StatBase)TFAchievementPage.twilightHill3);
            }
        }
    }
}
