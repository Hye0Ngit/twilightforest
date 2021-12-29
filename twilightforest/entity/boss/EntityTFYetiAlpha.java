// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.player.EntityPlayerMP;
import twilightforest.world.TFWorld;
import twilightforest.TFFeature;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.BossVariant;
import twilightforest.block.BlockTFBossSpawner;
import twilightforest.block.TFBlocks;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.init.SoundEvents;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.MathHelper;
import java.util.Iterator;
import twilightforest.util.EntityUtil;
import net.minecraft.util.math.BlockPos;
import twilightforest.util.WorldUtil;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.DamageSource;
import javax.annotation.Nullable;
import twilightforest.client.particle.TFParticleType;
import twilightforest.TwilightForestMod;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import twilightforest.TFSounds;
import net.minecraft.entity.EntityLivingBase;
import twilightforest.entity.ai.EntityAITFThrowRider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import twilightforest.entity.ai.EntityAITFYetiRampage;
import net.minecraft.entity.EntityCreature;
import twilightforest.entity.ai.EntityAIStayNearHome;
import twilightforest.entity.ai.EntityAITFYetiTired;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.BossInfo;
import net.minecraft.world.World;
import net.minecraft.world.BossInfoServer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.util.ResourceLocation;
import twilightforest.entity.IHostileMount;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFYetiAlpha extends EntityMob implements IRangedAttackMob, IHostileMount
{
    public static final ResourceLocation LOOT_TABLE;
    private static final DataParameter<Byte> RAMPAGE_FLAG;
    private static final DataParameter<Byte> TIRED_FLAG;
    private final BossInfoServer bossInfo;
    private int collisionCounter;
    private boolean canRampage;
    
    public EntityTFYetiAlpha(final World world) {
        super(world);
        this.bossInfo = new BossInfoServer(this.func_145748_c_(), BossInfo.Color.WHITE, BossInfo.Overlay.PROGRESS);
        this.func_70105_a(3.8f, 5.0f);
        this.field_70728_aV = 317;
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAITFYetiTired(this, 100));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIStayNearHome((EntityCreature)this, 2.0f));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITFYetiRampage(this, 10, 180));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIAttackRanged(this, 1.0, 40, 40, 40.0f) {
            public boolean func_75250_a() {
                return EntityTFYetiAlpha.this.func_70681_au().nextInt(50) > 0 && EntityTFYetiAlpha.this.func_70638_az() != null && EntityTFYetiAlpha.this.func_70068_e((Entity)EntityTFYetiAlpha.this.func_70638_az()) >= 16.0 && super.func_75250_a();
            }
        });
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAITFThrowRider(this, 1.0, false) {
            @Override
            protected void func_190102_a(final EntityLivingBase p_190102_1_, final double p_190102_2_) {
                super.func_190102_a(p_190102_1_, p_190102_2_);
                if (!EntityTFYetiAlpha.this.func_184188_bt().isEmpty()) {
                    EntityTFYetiAlpha.this.func_184185_a(TFSounds.ALPHAYETI_GRAB, 4.0f, 0.75f + EntityTFYetiAlpha.this.func_70681_au().nextFloat() * 0.25f);
                }
            }
            
            @Override
            public void func_75251_c() {
                if (!EntityTFYetiAlpha.this.func_184188_bt().isEmpty()) {
                    EntityTFYetiAlpha.this.func_184185_a(TFSounds.ALPHAYETI_THROW, 4.0f, 0.75f + EntityTFYetiAlpha.this.func_70681_au().nextFloat() * 0.25f);
                }
                super.func_75251_c();
            }
        });
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIWanderAvoidWater((EntityCreature)this, 2.0));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, true));
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)EntityTFYetiAlpha.RAMPAGE_FLAG, (Object)0);
        this.field_70180_af.func_187214_a((DataParameter)EntityTFYetiAlpha.TIRED_FLAG, (Object)0);
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(200.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.38);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(40.0);
    }
    
    public void func_70636_d() {
        if (!this.func_184188_bt().isEmpty() && this.func_184188_bt().get(0).func_70093_af()) {
            this.func_184188_bt().get(0).func_70095_a(false);
        }
        super.func_70636_d();
        if (this.func_184207_aI()) {
            this.func_70671_ap().func_75651_a((Entity)this.func_184188_bt().get(0), 100.0f, 100.0f);
        }
        if (!this.field_70170_p.field_72995_K) {
            this.bossInfo.func_186735_a(this.func_110143_aJ() / this.func_110138_aP());
            if (this.field_70132_H) {
                ++this.collisionCounter;
            }
            if (this.collisionCounter >= 15) {
                this.destroyBlocksInAABB(this.func_174813_aQ());
                this.collisionCounter = 0;
            }
        }
        else {
            if (this.isRampaging()) {
                final float rotation = this.field_70173_aa / 10.0f;
                for (int i = 0; i < 20; ++i) {
                    this.addSnowEffect(rotation + i * 50, i + rotation);
                }
                this.field_70721_aZ += (float)0.6;
            }
            if (this.isTired()) {
                for (int j = 0; j < 20; ++j) {
                    this.field_70170_p.func_175688_a(EnumParticleTypes.WATER_SPLASH, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * this.field_70130_N * 0.5, this.field_70163_u + this.func_70047_e(), this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * this.field_70130_N * 0.5, (double)((this.field_70146_Z.nextFloat() - 0.5f) * 0.75f), 0.0, (double)((this.field_70146_Z.nextFloat() - 0.5f) * 0.75f), new int[0]);
                }
            }
        }
    }
    
    private void addSnowEffect(final float rotation, final float hgt) {
        final double px = 3.0 * Math.cos(rotation);
        final double py = hgt % 5.0f;
        final double pz = 3.0 * Math.sin(rotation);
        TwilightForestMod.proxy.spawnParticle(TFParticleType.SNOW, this.field_70142_S + px, this.field_70137_T + py, this.field_70136_U + pz, 0.0, 0.0, 0.0);
    }
    
    public void func_70624_b(@Nullable final EntityLivingBase entity) {
        if (entity != null && entity != this.func_70638_az()) {
            this.func_184185_a(TFSounds.ALPHAYETI_ALERT, 4.0f, 0.5f + this.func_70681_au().nextFloat() * 0.5f);
        }
        super.func_70624_b(entity);
    }
    
    public boolean func_70097_a(final DamageSource source, final float amount) {
        if (!this.canRampage && !this.isTired() && source.func_76352_a()) {
            return false;
        }
        this.canRampage = true;
        return super.func_70097_a(source, amount);
    }
    
    @Nullable
    protected SoundEvent func_184639_G() {
        return TFSounds.ALPHAYETI_GROWL;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource damageSourceIn) {
        return TFSounds.ALPHAYETI_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.ALPHAYETI_DIE;
    }
    
    protected float func_70647_i() {
        return 0.5f + this.func_70681_au().nextFloat() * 0.5f;
    }
    
    protected float func_70599_aP() {
        return 4.0f;
    }
    
    public ResourceLocation func_184647_J() {
        return EntityTFYetiAlpha.LOOT_TABLE;
    }
    
    public void func_184232_k(final Entity passenger) {
        final Vec3d riderPos = this.getRiderPosition();
        passenger.func_70107_b(riderPos.field_72450_a, riderPos.field_72448_b, riderPos.field_72449_c);
    }
    
    public double func_70042_X() {
        return 5.75;
    }
    
    private Vec3d getRiderPosition() {
        if (this.func_184207_aI()) {
            final float distance = 0.4f;
            final double dx = Math.cos((this.field_70177_z + 90.0f) * 3.141592653589793 / 180.0) * distance;
            final double dz = Math.sin((this.field_70177_z + 90.0f) * 3.141592653589793 / 180.0) * distance;
            return new Vec3d(this.field_70165_t + dx, this.field_70163_u + this.func_70042_X() + this.func_184188_bt().get(0).func_70033_W(), this.field_70161_v + dz);
        }
        return new Vec3d(this.field_70165_t, this.field_70163_u, this.field_70161_v);
    }
    
    public boolean canRiderInteract() {
        return true;
    }
    
    public void destroyBlocksInAABB(final AxisAlignedBB box) {
        if (ForgeEventFactory.getMobGriefingEvent(this.field_70170_p, (Entity)this)) {
            for (final BlockPos pos : WorldUtil.getAllInBB(box)) {
                if (EntityUtil.canDestroyBlock(this.field_70170_p, pos, (Entity)this)) {
                    this.field_70170_p.func_175655_b(pos, false);
                }
            }
        }
    }
    
    public void makeRandomBlockFall() {
        this.makeRandomBlockFall(30);
    }
    
    private void makeRandomBlockFall(final int range) {
        final int bx = MathHelper.func_76128_c(this.field_70165_t) + this.func_70681_au().nextInt(range) - this.func_70681_au().nextInt(range);
        final int bz = MathHelper.func_76128_c(this.field_70161_v) + this.func_70681_au().nextInt(range) - this.func_70681_au().nextInt(range);
        final int by = MathHelper.func_76128_c(this.field_70163_u + this.func_70047_e());
        this.makeBlockFallAbove(new BlockPos(bx, bz, by));
    }
    
    private void makeBlockFallAbove(final BlockPos pos) {
        if (this.field_70170_p.func_175623_d(pos)) {
            for (int i = 1; i < 30; ++i) {
                final BlockPos up = pos.func_177981_b(i);
                if (!this.field_70170_p.func_175623_d(up)) {
                    this.makeBlockFall(up);
                    break;
                }
            }
        }
    }
    
    public void makeNearbyBlockFall() {
        this.makeRandomBlockFall(15);
    }
    
    public void makeBlockAboveTargetFall() {
        if (this.func_70638_az() != null) {
            final int bx = MathHelper.func_76128_c(this.func_70638_az().field_70165_t);
            final int bz = MathHelper.func_76128_c(this.func_70638_az().field_70161_v);
            final int by = MathHelper.func_76128_c(this.func_70638_az().field_70163_u + this.func_70638_az().func_70047_e());
            this.makeBlockFallAbove(new BlockPos(bx, bz, by));
        }
    }
    
    private void makeBlockFall(final BlockPos pos) {
        this.field_70170_p.func_175656_a(pos, Blocks.field_150403_cj.func_176223_P());
        this.field_70170_p.func_175718_b(2001, pos, Block.func_176210_f(Blocks.field_150403_cj.func_176223_P()));
        final EntityTFFallingIce ice = new EntityTFFallingIce(this.field_70170_p, pos.func_177958_n(), pos.func_177956_o() - 3, pos.func_177952_p());
        this.field_70170_p.func_72838_d((Entity)ice);
    }
    
    public void func_82196_d(final EntityLivingBase target, final float distanceFactor) {
        if (!this.canRampage) {
            final EntityTFIceBomb ice = new EntityTFIceBomb(this.field_70170_p, (EntityLivingBase)this);
            final double d0 = target.field_70165_t - this.field_70165_t;
            final double d2 = target.func_174813_aQ().field_72338_b + target.field_70131_O / 3.0f - ice.field_70163_u;
            final double d3 = target.field_70161_v - this.field_70161_v;
            final double d4 = MathHelper.func_76133_a(d0 * d0 + d3 * d3);
            ice.func_70186_c(d0, d2 + d4 * 0.20000000298023224, d3, 1.6f, (float)(14 - this.field_70170_p.func_175659_aa().func_151525_a() * 4));
            this.func_184185_a(SoundEvents.field_187737_v, 1.0f, 1.0f / (this.func_70681_au().nextFloat() * 0.4f + 0.8f));
            this.field_70170_p.func_72838_d((Entity)ice);
        }
    }
    
    public void func_184724_a(final boolean swingingArms) {
    }
    
    public boolean func_70692_ba() {
        return false;
    }
    
    protected void func_70623_bb() {
        if (this.field_70170_p.func_175659_aa() == EnumDifficulty.PEACEFUL) {
            if (this.func_110175_bO()) {
                this.field_70170_p.func_175656_a(this.func_180486_cf(), TFBlocks.boss_spawner.func_176223_P().func_177226_a((IProperty)BlockTFBossSpawner.VARIANT, (Comparable)BossVariant.ALPHA_YETI));
            }
            this.func_70106_y();
        }
        else {
            super.func_70623_bb();
        }
    }
    
    public boolean canRampage() {
        return this.canRampage;
    }
    
    public void setRampaging(final boolean rampaging) {
        this.field_70180_af.func_187227_b((DataParameter)EntityTFYetiAlpha.RAMPAGE_FLAG, (Object)(byte)(rampaging ? 1 : 0));
    }
    
    public boolean isRampaging() {
        return (byte)this.field_70180_af.func_187225_a((DataParameter)EntityTFYetiAlpha.RAMPAGE_FLAG) == 1;
    }
    
    public void setTired(final boolean tired) {
        this.field_70180_af.func_187227_b((DataParameter)EntityTFYetiAlpha.TIRED_FLAG, (Object)(byte)(tired ? 1 : 0));
        this.canRampage = false;
    }
    
    public boolean isTired() {
        return (byte)this.field_70180_af.func_187225_a((DataParameter)EntityTFYetiAlpha.TIRED_FLAG) == 1;
    }
    
    public void func_180430_e(final float distance, final float multiplier) {
        super.func_180430_e(distance, multiplier);
        if (!this.field_70170_p.field_72995_K && this.isRampaging()) {
            this.func_184185_a(SoundEvents.field_187737_v, 1.0f, 1.0f / (this.func_70681_au().nextFloat() * 0.4f + 0.8f));
            this.hitNearbyEntities();
        }
    }
    
    private void hitNearbyEntities() {
        for (final EntityLivingBase entity : this.field_70170_p.func_72872_a((Class)EntityLivingBase.class, this.func_174813_aQ().func_72314_b(5.0, 0.0, 5.0))) {
            if (entity != this && entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), 5.0f)) {
                final EntityLivingBase entityLivingBase = entity;
                entityLivingBase.field_70181_x += 0.4;
            }
        }
    }
    
    public void func_70645_a(final DamageSource cause) {
        super.func_70645_a(cause);
        if (!this.field_70170_p.field_72995_K) {
            TFWorld.markStructureConquered(this.field_70170_p, new BlockPos((Entity)this), TFFeature.YETI_CAVE);
        }
    }
    
    public void func_96094_a(final String name) {
        super.func_96094_a(name);
        this.bossInfo.func_186739_a(this.func_145748_c_());
    }
    
    public void func_184178_b(final EntityPlayerMP player) {
        super.func_184178_b(player);
        this.bossInfo.func_186760_a(player);
    }
    
    public void func_184203_c(final EntityPlayerMP player) {
        super.func_184203_c(player);
        this.bossInfo.func_186761_b(player);
    }
    
    public void func_70014_b(final NBTTagCompound compound) {
        final BlockPos home = this.func_180486_cf();
        compound.func_74782_a("Home", (NBTBase)this.func_70087_a(new double[] { home.func_177958_n(), home.func_177956_o(), home.func_177952_p() }));
        compound.func_74757_a("HasHome", this.func_110175_bO());
        super.func_70014_b(compound);
    }
    
    public void func_70037_a(final NBTTagCompound compound) {
        super.func_70037_a(compound);
        if (compound.func_150297_b("Home", 9)) {
            final NBTTagList nbttaglist = compound.func_150295_c("Home", 6);
            final int hx = (int)nbttaglist.func_150309_d(0);
            final int hy = (int)nbttaglist.func_150309_d(1);
            final int hz = (int)nbttaglist.func_150309_d(2);
            this.func_175449_a(new BlockPos(hx, hy, hz), 30);
        }
        if (!compound.func_74767_n("HasHome")) {
            this.func_110177_bN();
        }
        if (this.func_145818_k_()) {
            this.bossInfo.func_186739_a(this.func_145748_c_());
        }
    }
    
    public boolean func_184222_aU() {
        return false;
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/yeti_alpha");
        RAMPAGE_FLAG = EntityDataManager.func_187226_a((Class)EntityTFYetiAlpha.class, DataSerializers.field_187191_a);
        TIRED_FLAG = EntityDataManager.func_187226_a((Class)EntityTFYetiAlpha.class, DataSerializers.field_187191_a);
    }
}
