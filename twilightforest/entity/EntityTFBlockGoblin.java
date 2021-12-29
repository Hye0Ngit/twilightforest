// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.entity.EntityLivingBase;
import java.util.List;
import net.minecraft.util.Vec3;
import net.minecraft.stats.StatBase;
import twilightforest.TFAchievementPage;
import net.minecraft.util.DamageSource;
import twilightforest.item.TFItems;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityMultiPart;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFBlockGoblin extends EntityMob implements IEntityMultiPart
{
    private static final float CHAIN_SPEED = 16.0f;
    private static final int DATA_CHAINLENGTH = 17;
    private static final int DATA_CHAINPOS = 18;
    int recoilCounter;
    float chainAngle;
    public EntityTFSpikeBlock block;
    public EntityTFGoblinChain chain1;
    public EntityTFGoblinChain chain2;
    public EntityTFGoblinChain chain3;
    public Entity[] partsArray;
    
    public EntityTFBlockGoblin(final World world) {
        super(world);
        this.func_70105_a(0.9f, 1.4f);
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, (Class)EntityTNTPrimed.class, 2.0f, 0.800000011920929, 1.5));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityPlayer.class, 1.0, false));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, 0, true));
        this.recoilCounter = 0;
        this.partsArray = new Entity[] { this.block = new EntityTFSpikeBlock(this), this.chain1 = new EntityTFGoblinChain(this), this.chain2 = new EntityTFGoblinChain(this), this.chain3 = new EntityTFGoblinChain(this) };
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(17, (Object)0);
        this.field_70180_af.func_75682_a(18, (Object)0);
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(20.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.28);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(8.0);
    }
    
    protected String func_70639_aQ() {
        return "TwilightForest:mob.redcap.redcap";
    }
    
    protected String func_70621_aR() {
        return "TwilightForest:mob.redcap.hurt";
    }
    
    protected String func_70673_aS() {
        return "TwilightForest:mob.redcap.die";
    }
    
    protected int func_70633_aT() {
        return TFItems.armorShard.field_77779_bT;
    }
    
    public void func_70645_a(final DamageSource par1DamageSource) {
        super.func_70645_a(par1DamageSource);
        if (par1DamageSource.func_76364_f() instanceof EntityPlayer) {
            ((EntityPlayer)par1DamageSource.func_76364_f()).func_71029_a((StatBase)TFAchievementPage.twilightHunter);
        }
    }
    
    public double getChainYOffset() {
        return 1.5 - this.getChainLength() / 4.0;
    }
    
    public Vec3 getChainPosition() {
        return this.getChainPosition(this.getChainAngle(), this.getChainLength());
    }
    
    public Vec3 getChainPosition(final float angle, final float distance) {
        final double var1 = Math.cos(angle * 3.141592653589793 / 180.0) * distance;
        final double var2 = Math.sin(angle * 3.141592653589793 / 180.0) * distance;
        return this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t + var1, this.field_70163_u + this.getChainYOffset(), this.field_70161_v + var2);
    }
    
    public boolean isSwingingChain() {
        return this.field_82175_bq || (this.func_70638_az() != null && this.recoilCounter == 0);
    }
    
    public boolean func_70652_k(final Entity par1Entity) {
        this.func_71038_i();
        return false;
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        this.block.func_70071_h_();
        this.chain1.func_70071_h_();
        this.chain2.func_70071_h_();
        this.chain3.func_70071_h_();
        if (this.recoilCounter > 0) {
            --this.recoilCounter;
        }
        this.chainAngle += 16.0f;
        this.chainAngle %= 360.0f;
        if (!this.field_70170_p.field_72995_K) {
            this.field_70180_af.func_75692_b(17, (Object)(byte)Math.floor(this.getChainLength() * 127.0f));
            this.field_70180_af.func_75692_b(18, (Object)(byte)Math.floor(this.getChainAngle() / 360.0f * 255.0f));
        }
        else if (Math.abs(this.chainAngle - this.getChainAngle()) > 32.0f) {
            this.chainAngle = this.getChainAngle();
        }
        final Vec3 blockPos = this.getChainPosition();
        this.block.func_70107_b(blockPos.field_72450_a, blockPos.field_72448_b, blockPos.field_72449_c);
        this.block.field_70177_z = this.getChainAngle();
        final double sx = this.field_70165_t;
        final double sy = this.field_70163_u + this.field_70131_O - 0.1;
        final double sz = this.field_70161_v;
        final double ox = sx - blockPos.field_72450_a;
        final double oy = sy - blockPos.field_72448_b - this.block.field_70131_O / 3.0;
        final double oz = sz - blockPos.field_72449_c;
        this.chain1.func_70107_b(sx - ox * 0.4, sy - oy * 0.4, sz - oz * 0.4);
        this.chain2.func_70107_b(sx - ox * 0.5, sy - oy * 0.5, sz - oz * 0.5);
        this.chain3.func_70107_b(sx - ox * 0.6, sy - oy * 0.6, sz - oz * 0.6);
        if (!this.field_70170_p.field_72995_K && this.isSwingingChain()) {
            this.applyBlockCollisions(this.block);
        }
    }
    
    protected void applyBlockCollisions(final Entity collider) {
        final List list = this.field_70170_p.func_72839_b(collider, collider.field_70121_D.func_72314_b(0.20000000298023224, 0.0, 0.20000000298023224));
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); ++i) {
                final Entity entity = list.get(i);
                if (entity.func_70104_M()) {
                    this.applyBlockCollision(collider, entity);
                }
            }
        }
    }
    
    protected void applyBlockCollision(final Entity collider, final Entity collided) {
        if (collided != this) {
            collided.func_70108_f(collider);
            if (collided instanceof EntityLivingBase) {
                final boolean attackSuccess = super.func_70652_k(collided);
                if (attackSuccess) {
                    collided.field_70181_x += 0.4000000059604645;
                    this.func_85030_a("mob.irongolem.throw", 1.0f, 1.0f);
                    this.recoilCounter = 40;
                }
            }
        }
    }
    
    public float getChainAngle() {
        if (!this.field_70170_p.field_72995_K) {
            return this.chainAngle;
        }
        return (this.field_70180_af.func_75683_a(18) & 0xFF) / 255.0f * 360.0f;
    }
    
    public float getChainLength() {
        if (this.field_70170_p.field_72995_K) {
            return (this.field_70180_af.func_75683_a(17) & 0xFF) / 127.0f;
        }
        if (this.isSwingingChain()) {
            return 0.9f;
        }
        return 0.3f;
    }
    
    public World func_82194_d() {
        return this.field_70170_p;
    }
    
    public boolean func_70965_a(final EntityDragonPart entitydragonpart, final DamageSource damagesource, final float i) {
        return false;
    }
    
    public Entity[] func_70021_al() {
        return this.partsArray;
    }
    
    public int func_70658_aO() {
        int i = super.func_70658_aO() + 11;
        if (i > 20) {
            i = 20;
        }
        return i;
    }
}
