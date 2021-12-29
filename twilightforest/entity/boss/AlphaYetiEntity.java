// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.ITextComponent;
import twilightforest.world.TFGenerationSettings;
import twilightforest.TFFeature;
import net.minecraft.util.math.vector.Vector3i;
import twilightforest.block.TFBlocks;
import net.minecraft.world.Difficulty;
import twilightforest.entity.TFEntities;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.MathHelper;
import java.util.Iterator;
import twilightforest.util.EntityUtil;
import net.minecraft.util.math.BlockPos;
import twilightforest.util.WorldUtil;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.DamageSource;
import javax.annotation.Nullable;
import twilightforest.client.particle.TFParticleType;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import twilightforest.TFSounds;
import net.minecraft.entity.LivingEntity;
import twilightforest.entity.ai.ThrowRiderGoal;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import twilightforest.entity.ai.YetiRampageGoal;
import net.minecraft.entity.CreatureEntity;
import twilightforest.entity.ai.StayNearHomeGoal;
import twilightforest.entity.ai.YetiTiredGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.world.BossInfo;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.world.server.ServerBossInfo;
import net.minecraft.network.datasync.DataParameter;
import twilightforest.entity.IHostileMount;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.monster.MonsterEntity;

public class AlphaYetiEntity extends MonsterEntity implements IRangedAttackMob, IHostileMount
{
    private static final DataParameter<Byte> RAMPAGE_FLAG;
    private static final DataParameter<Byte> TIRED_FLAG;
    private final ServerBossInfo bossInfo;
    private int collisionCounter;
    private boolean canRampage;
    
    public AlphaYetiEntity(final EntityType<? extends AlphaYetiEntity> type, final World world) {
        super((EntityType)type, world);
        this.bossInfo = new ServerBossInfo(this.func_145748_c_(), BossInfo.Color.WHITE, BossInfo.Overlay.PROGRESS);
        this.field_70728_aV = 317;
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (Goal)new SwimGoal((MobEntity)this));
        this.field_70714_bg.func_75776_a(1, (Goal)new YetiTiredGoal(this, 100));
        this.field_70714_bg.func_75776_a(2, (Goal)new StayNearHomeGoal((CreatureEntity)this, 2.0f));
        this.field_70714_bg.func_75776_a(3, (Goal)new YetiRampageGoal(this, 10, 180));
        this.field_70714_bg.func_75776_a(4, (Goal)new RangedAttackGoal(this, 1.0, 40, 40, 40.0f) {
            public boolean func_75250_a() {
                return AlphaYetiEntity.this.func_70681_au().nextInt(50) > 0 && AlphaYetiEntity.this.func_70638_az() != null && AlphaYetiEntity.this.func_70068_e((Entity)AlphaYetiEntity.this.func_70638_az()) >= 16.0 && super.func_75250_a();
            }
        });
        this.field_70714_bg.func_75776_a(4, (Goal)new ThrowRiderGoal(this, 1.0, false) {
            @Override
            protected void func_190102_a(final LivingEntity p_190102_1_, final double p_190102_2_) {
                super.func_190102_a(p_190102_1_, p_190102_2_);
                if (!AlphaYetiEntity.this.func_184188_bt().isEmpty()) {
                    AlphaYetiEntity.this.func_184185_a(TFSounds.ALPHAYETI_GRAB, 4.0f, 0.75f + AlphaYetiEntity.this.func_70681_au().nextFloat() * 0.25f);
                }
            }
            
            @Override
            public void func_75251_c() {
                if (!AlphaYetiEntity.this.func_184188_bt().isEmpty()) {
                    AlphaYetiEntity.this.func_184185_a(TFSounds.ALPHAYETI_THROW, 4.0f, 0.75f + AlphaYetiEntity.this.func_70681_au().nextFloat() * 0.25f);
                }
                super.func_75251_c();
            }
        });
        this.field_70714_bg.func_75776_a(5, (Goal)new WaterAvoidingRandomWalkingGoal((CreatureEntity)this, 2.0));
        this.field_70714_bg.func_75776_a(6, (Goal)new LookAtGoal((MobEntity)this, (Class)PlayerEntity.class, 8.0f));
        this.field_70714_bg.func_75776_a(7, (Goal)new LookRandomlyGoal((MobEntity)this));
        this.field_70715_bh.func_75776_a(1, (Goal)new HurtByTargetGoal((CreatureEntity)this, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (Goal)new NearestAttackableTargetGoal((MobEntity)this, (Class)PlayerEntity.class, true));
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)AlphaYetiEntity.RAMPAGE_FLAG, (Object)0);
        this.field_70180_af.func_187214_a((DataParameter)AlphaYetiEntity.TIRED_FLAG, (Object)0);
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MonsterEntity.func_234295_eP_().func_233815_a_(Attributes.field_233818_a_, 200.0).func_233815_a_(Attributes.field_233821_d_, 0.38).func_233815_a_(Attributes.field_233823_f_, 1.0).func_233815_a_(Attributes.field_233819_b_, 40.0);
    }
    
    public void func_70636_d() {
        if (!this.func_184188_bt().isEmpty() && this.func_184188_bt().get(0).func_225608_bj_()) {
            this.func_184188_bt().get(0).func_226284_e_(false);
        }
        super.func_70636_d();
        if (this.func_184207_aI()) {
            this.func_70671_ap().func_75651_a((Entity)this.func_184188_bt().get(0), 100.0f, 100.0f);
        }
        if (!this.field_70170_p.field_72995_K) {
            this.bossInfo.func_186735_a(this.func_110143_aJ() / this.func_110138_aP());
            if (this.field_70123_F || this.field_70124_G) {
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
                    this.field_70170_p.func_195594_a((IParticleData)ParticleTypes.field_218422_X, this.func_226277_ct_() + (this.field_70146_Z.nextDouble() - 0.5) * this.func_213311_cf() * 0.5, this.func_226278_cu_() + this.func_70047_e(), this.func_226281_cx_() + (this.field_70146_Z.nextDouble() - 0.5) * this.func_213311_cf() * 0.5, (double)((this.field_70146_Z.nextFloat() - 0.5f) * 0.75f), 0.0, (double)((this.field_70146_Z.nextFloat() - 0.5f) * 0.75f));
                }
            }
        }
    }
    
    private void addSnowEffect(final float rotation, final float hgt) {
        final double px = 3.0 * Math.cos(rotation);
        final double py = hgt % 5.0f;
        final double pz = 3.0 * Math.sin(rotation);
        this.field_70170_p.func_195594_a((IParticleData)TFParticleType.SNOW.get(), this.field_70142_S + px, this.field_70137_T + py, this.field_70136_U + pz, 0.0, 0.0, 0.0);
    }
    
    public void func_70624_b(@Nullable final LivingEntity entity) {
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
        return TFSounds.ALPHAYETI_DEATH;
    }
    
    protected float func_70647_i() {
        return 0.5f + this.func_70681_au().nextFloat() * 0.5f;
    }
    
    protected float func_70599_aP() {
        return 4.0f;
    }
    
    public void func_184232_k(final Entity passenger) {
        final Vector3d riderPos = this.getRiderPosition();
        passenger.func_70107_b(riderPos.field_72450_a, riderPos.field_72448_b, riderPos.field_72449_c);
    }
    
    public double func_70042_X() {
        return 5.75;
    }
    
    private Vector3d getRiderPosition() {
        if (this.func_184207_aI()) {
            final float distance = 0.4f;
            final double dx = Math.cos((this.field_70177_z + 90.0f) * 3.141592653589793 / 180.0) * distance;
            final double dz = Math.sin((this.field_70177_z + 90.0f) * 3.141592653589793 / 180.0) * distance;
            return new Vector3d(this.func_226277_ct_() + dx, this.func_226278_cu_() + this.func_70042_X() + this.func_184188_bt().get(0).func_70033_W(), this.func_226281_cx_() + dz);
        }
        return new Vector3d(this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_());
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
        final int bx = MathHelper.func_76128_c(this.func_226277_ct_()) + this.func_70681_au().nextInt(range) - this.func_70681_au().nextInt(range);
        final int bz = MathHelper.func_76128_c(this.func_226281_cx_()) + this.func_70681_au().nextInt(range) - this.func_70681_au().nextInt(range);
        final int by = MathHelper.func_76128_c(this.func_226278_cu_() + this.func_70047_e());
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
            final int bx = MathHelper.func_76128_c(this.func_70638_az().func_226277_ct_());
            final int bz = MathHelper.func_76128_c(this.func_70638_az().func_226281_cx_());
            final int by = MathHelper.func_76128_c(this.func_70638_az().func_226278_cu_() + this.func_70638_az().func_70047_e());
            this.makeBlockFallAbove(new BlockPos(bx, bz, by));
        }
    }
    
    private void makeBlockFall(final BlockPos pos) {
        this.field_70170_p.func_175656_a(pos, Blocks.field_150403_cj.func_176223_P());
        this.field_70170_p.func_217379_c(2001, pos, Block.func_196246_j(Blocks.field_150403_cj.func_176223_P()));
        final FallingIceEntity ice = new FallingIceEntity(this.field_70170_p, pos.func_177958_n(), pos.func_177956_o() - 3, pos.func_177952_p());
        this.field_70170_p.func_217376_c((Entity)ice);
    }
    
    public void func_82196_d(final LivingEntity target, final float distanceFactor) {
        if (!this.canRampage) {
            final IceBombEntity ice = new IceBombEntity(TFEntities.thrown_ice, this.field_70170_p, (LivingEntity)this);
            final double d0 = target.func_226277_ct_() - this.func_226277_ct_();
            final double d2 = target.func_174813_aQ().field_72338_b + target.func_213302_cg() / 3.0f - ice.func_226278_cu_();
            final double d3 = target.func_226281_cx_() - this.func_226281_cx_();
            final double d4 = MathHelper.func_76133_a(d0 * d0 + d3 * d3);
            ice.func_70186_c(d0, d2 + d4 * 0.20000000298023224, d3, 1.6f, (float)(14 - this.field_70170_p.func_175659_aa().func_151525_a() * 4));
            this.func_184185_a(TFSounds.ALPHAYETI_ICE, 1.0f, 1.0f / (this.func_70681_au().nextFloat() * 0.4f + 0.8f));
            this.field_70170_p.func_217376_c((Entity)ice);
        }
    }
    
    public boolean func_213397_c(final double p_213397_1_) {
        return false;
    }
    
    public void func_70623_bb() {
        if (this.field_70170_p.func_175659_aa() == Difficulty.PEACEFUL) {
            if (!this.func_213394_dL()) {
                this.field_70170_p.func_175656_a(this.func_213384_dI(), ((Block)TFBlocks.boss_spawner_alpha_yeti.get()).func_176223_P());
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
        this.field_70180_af.func_187227_b((DataParameter)AlphaYetiEntity.RAMPAGE_FLAG, (Object)(byte)(rampaging ? 1 : 0));
    }
    
    public boolean isRampaging() {
        return (byte)this.field_70180_af.func_187225_a((DataParameter)AlphaYetiEntity.RAMPAGE_FLAG) == 1;
    }
    
    public void setTired(final boolean tired) {
        this.field_70180_af.func_187227_b((DataParameter)AlphaYetiEntity.TIRED_FLAG, (Object)(byte)(tired ? 1 : 0));
        this.canRampage = false;
    }
    
    public boolean isTired() {
        return (byte)this.field_70180_af.func_187225_a((DataParameter)AlphaYetiEntity.TIRED_FLAG) == 1;
    }
    
    public boolean func_225503_b_(final float distance, final float multiplier) {
        if (!this.field_70170_p.field_72995_K && this.isRampaging()) {
            this.func_184185_a(TFSounds.ALPHAYETI_ICE, 1.0f, 1.0f / (this.func_70681_au().nextFloat() * 0.4f + 0.8f));
            this.hitNearbyEntities();
        }
        return super.func_225503_b_(distance, multiplier);
    }
    
    private void hitNearbyEntities() {
        for (final LivingEntity entity : this.field_70170_p.func_217357_a((Class)LivingEntity.class, this.func_174813_aQ().func_72314_b(5.0, 0.0, 5.0))) {
            if (entity != this && entity.func_70097_a(DamageSource.func_76358_a((LivingEntity)this), 5.0f)) {
                entity.func_70024_g(0.0, 0.4, 0.0);
            }
        }
    }
    
    public void func_70645_a(final DamageSource cause) {
        super.func_70645_a(cause);
        if (!this.field_70170_p.field_72995_K) {
            TFGenerationSettings.markStructureConquered(this.field_70170_p, new BlockPos((Vector3i)this.func_233580_cy_()), TFFeature.YETI_CAVE);
        }
    }
    
    public void func_200203_b(@Nullable final ITextComponent name) {
        super.func_200203_b(name);
        this.bossInfo.func_186739_a(this.func_145748_c_());
    }
    
    public void func_184178_b(final ServerPlayerEntity player) {
        super.func_184178_b(player);
        this.bossInfo.func_186760_a(player);
    }
    
    public void func_184203_c(final ServerPlayerEntity player) {
        super.func_184203_c(player);
        this.bossInfo.func_186761_b(player);
    }
    
    public void func_213281_b(final CompoundNBT compound) {
        final BlockPos home = this.func_213384_dI();
        compound.func_218657_a("Home", (INBT)this.func_70087_a(new double[] { home.func_177958_n(), home.func_177956_o(), home.func_177952_p() }));
        compound.func_74757_a("HasHome", this.func_213394_dL());
        super.func_213281_b(compound);
    }
    
    public void func_70037_a(final CompoundNBT compound) {
        super.func_70037_a(compound);
        if (compound.func_150297_b("Home", 9)) {
            final ListNBT nbttaglist = compound.func_150295_c("Home", 6);
            final int hx = (int)nbttaglist.func_150309_d(0);
            final int hy = (int)nbttaglist.func_150309_d(1);
            final int hz = (int)nbttaglist.func_150309_d(2);
            this.func_213390_a(new BlockPos(hx, hy, hz), 30);
        }
        if (!compound.func_74767_n("HasHome")) {
            this.func_213394_dL();
        }
        if (this.func_145818_k_()) {
            this.bossInfo.func_186739_a(this.func_145748_c_());
        }
    }
    
    protected boolean func_184228_n(final Entity entityIn) {
        return false;
    }
    
    public boolean func_184222_aU() {
        return false;
    }
    
    static {
        RAMPAGE_FLAG = EntityDataManager.func_187226_a((Class)AlphaYetiEntity.class, DataSerializers.field_187191_a);
        TIRED_FLAG = EntityDataManager.func_187226_a((Class)AlphaYetiEntity.class, DataSerializers.field_187191_a);
    }
}
