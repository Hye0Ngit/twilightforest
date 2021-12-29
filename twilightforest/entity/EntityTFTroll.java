// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S0BPacketAnimation;
import net.minecraft.world.WorldServer;
import twilightforest.entity.boss.EntityTFIceBomb;
import twilightforest.item.TFItems;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.stats.StatBase;
import twilightforest.TFAchievementPage;
import net.minecraft.util.DamageSource;
import twilightforest.block.TFBlocks;
import net.minecraft.util.MathHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import twilightforest.entity.ai.EntityAITFCollideAttackFixed;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFTroll extends EntityMob implements IRangedAttackMob
{
    private static final int ROCK_FLAG = 16;
    private EntityAIArrowAttack aiArrowAttack;
    private EntityAITFCollideAttackFixed aiAttackOnCollide;
    
    public EntityTFTroll(final World par1World) {
        super(par1World);
        this.aiArrowAttack = new EntityAIArrowAttack((IRangedAttackMob)this, 1.0, 20, 60, 15.0f);
        this.aiAttackOnCollide = new EntityAITFCollideAttackFixed((EntityCreature)this, (Class<? extends EntityLivingBase>)EntityPlayer.class, 1.2, false);
        this.func_70105_a(1.4f, 2.4f);
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIRestrictSun((EntityCreature)this));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIFleeSun((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, 0, true));
        if (par1World != null && !par1World.field_72995_K) {
            this.setCombatTask();
        }
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(30.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.28);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(7.0);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(16, (Object)0);
    }
    
    public void func_70636_d() {
        super.func_70636_d();
    }
    
    public boolean hasRock() {
        return (this.field_70180_af.func_75683_a(16) & 0x2) != 0x0;
    }
    
    public void setHasRock(final boolean rock) {
        final byte b0 = this.field_70180_af.func_75683_a(16);
        if (rock) {
            this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(40.0);
            this.field_70180_af.func_75692_b(16, (Object)(byte)(b0 | 0x2));
        }
        else {
            this.field_70180_af.func_75692_b(16, (Object)(byte)(b0 & 0xFFFFFFFD));
        }
        this.setCombatTask();
    }
    
    public boolean func_70652_k(final Entity par1Entity) {
        this.func_71038_i();
        return super.func_70652_k(par1Entity);
    }
    
    public void func_70014_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_70014_b(par1NBTTagCompound);
        par1NBTTagCompound.func_74757_a("HasRock", this.hasRock());
    }
    
    public void func_70037_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_70037_a(par1NBTTagCompound);
        this.setHasRock(par1NBTTagCompound.func_74767_n("HasRock"));
    }
    
    public void setCombatTask() {
        this.field_70714_bg.func_85156_a((EntityAIBase)this.aiAttackOnCollide);
        this.field_70714_bg.func_85156_a((EntityAIBase)this.aiArrowAttack);
        if (this.hasRock()) {
            this.field_70714_bg.func_75776_a(4, (EntityAIBase)this.aiArrowAttack);
        }
        else {
            this.field_70714_bg.func_75776_a(4, (EntityAIBase)this.aiAttackOnCollide);
        }
    }
    
    protected void func_70609_aI() {
        super.func_70609_aI();
        if (this.field_70725_aQ % 5 == 0) {
            this.ripenTrollBerNearby(this.field_70725_aQ / 5);
        }
        if (this.field_70725_aQ == 1) {}
    }
    
    private void ripenTrollBerNearby(final int offset) {
        final int sx = MathHelper.func_76128_c(this.field_70165_t);
        final int sy = MathHelper.func_76128_c(this.field_70163_u);
        final int sz = MathHelper.func_76128_c(this.field_70161_v);
        for (int range = 12, dx = -range; dx < range; ++dx) {
            for (int dy = -range; dy < range; ++dy) {
                for (int dz = -range; dz < range; ++dz) {
                    final int cx = sx + dx;
                    final int cy = sy + dy;
                    final int cz = sz + dz;
                    this.ripenBer(offset, cx, cy, cz);
                }
            }
        }
    }
    
    private void ripenBer(final int offset, final int cx, final int cy, final int cz) {
        if (this.field_70170_p.func_147439_a(cx, cy, cz) == TFBlocks.unripeTrollBer && this.field_70146_Z.nextBoolean() && Math.abs(cx + cy + cz) % 5 == offset) {
            this.field_70170_p.func_147449_b(cx, cy, cz, TFBlocks.trollBer);
            this.field_70170_p.func_72926_e(2004, cx, cy, cz, 0);
        }
    }
    
    public void func_70645_a(final DamageSource par1DamageSource) {
        super.func_70645_a(par1DamageSource);
        if (par1DamageSource.func_76364_f() instanceof EntityPlayer) {
            ((EntityPlayer)par1DamageSource.func_76364_f()).func_71029_a((StatBase)TFAchievementPage.twilightHunter);
        }
    }
    
    private void makeTrollStoneInAABB(final AxisAlignedBB par1AxisAlignedBB) {
        final int minX = MathHelper.func_76143_f(par1AxisAlignedBB.field_72340_a);
        final int minY = MathHelper.func_76143_f(par1AxisAlignedBB.field_72338_b);
        final int minZ = MathHelper.func_76143_f(par1AxisAlignedBB.field_72339_c);
        final int maxX = MathHelper.func_76128_c(par1AxisAlignedBB.field_72336_d);
        final int maxY = MathHelper.func_76128_c(par1AxisAlignedBB.field_72337_e);
        final int maxZ = MathHelper.func_76128_c(par1AxisAlignedBB.field_72334_f);
        for (int dx = minX; dx <= maxX; ++dx) {
            for (int dy = minY; dy <= maxY; ++dy) {
                for (int dz = minZ; dz <= maxZ; ++dz) {
                    final Block currentID = this.field_70170_p.func_147439_a(dx, dy, dz);
                    if (currentID == Blocks.field_150350_a) {
                        this.field_70170_p.func_147449_b(dx, dy, dz, TFBlocks.trollSteinn);
                        this.field_70170_p.func_72926_e(2001, dx, dy, dz, Block.func_149682_b(TFBlocks.trollSteinn) + 0);
                    }
                }
            }
        }
    }
    
    protected Item func_146068_u() {
        return null;
    }
    
    protected void func_70600_l(final int p_70600_1_) {
        this.func_145779_a(TFItems.magicBeans, 1);
    }
    
    public void func_82196_d(final EntityLivingBase target, final float par2) {
        if (this.hasRock()) {
            final EntityTFIceBomb ice = new EntityTFIceBomb(this.field_70170_p, (EntityLivingBase)this);
            final double d0 = target.field_70165_t - this.field_70165_t;
            final double d2 = target.field_70163_u + target.func_70047_e() - 1.100000023841858 - target.field_70163_u;
            final double d3 = target.field_70161_v - this.field_70161_v;
            final float f1 = MathHelper.func_76133_a(d0 * d0 + d3 * d3) * 0.2f;
            ice.func_70186_c(d0, d2 + f1, d3, 0.75f, 12.0f);
            this.func_85030_a("random.bow", 1.0f, 1.0f / (this.func_70681_au().nextFloat() * 0.4f + 0.8f));
            this.field_70170_p.func_72838_d((Entity)ice);
        }
    }
    
    public void func_71038_i() {
        if (!this.field_82175_bq || this.field_110158_av >= this.getArmSwingAnimationEnd() / 2 || this.field_110158_av < 0) {
            this.field_110158_av = -1;
            this.field_82175_bq = true;
            if (this.field_70170_p instanceof WorldServer) {
                ((WorldServer)this.field_70170_p).func_73039_n().func_151247_a((Entity)this, (Packet)new S0BPacketAnimation((Entity)this, 0));
            }
        }
    }
    
    protected void func_82168_bl() {
        final int maxSwing = this.getArmSwingAnimationEnd();
        if (this.field_82175_bq) {
            ++this.field_110158_av;
            if (this.field_110158_av >= maxSwing) {
                this.field_110158_av = 0;
                this.field_82175_bq = false;
            }
        }
        else {
            this.field_110158_av = 0;
        }
        this.field_70733_aJ = this.field_110158_av / (float)maxSwing;
    }
    
    private int getArmSwingAnimationEnd() {
        return 6;
    }
}
