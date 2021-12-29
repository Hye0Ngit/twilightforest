// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.block.Block;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.entity.EntityLivingBase;
import java.util.Iterator;
import java.util.List;
import twilightforest.world.ChunkProviderTwilightForest;
import twilightforest.TFFeature;
import twilightforest.world.TFWorldChunkManager;
import twilightforest.world.WorldProviderTwilightForest;
import net.minecraft.util.MathHelper;
import net.minecraft.stats.StatBase;
import twilightforest.TFAchievementPage;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import twilightforest.item.TFItems;
import net.minecraft.init.Blocks;
import net.minecraft.util.Vec3;
import twilightforest.TwilightForestMod;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import twilightforest.entity.ai.EntityAITFHoverBeam;
import twilightforest.entity.ai.EntityAITFHoverThenDrop;
import twilightforest.entity.ai.EntityAITFHoverSummon;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import twilightforest.entity.IBreathAttacker;
import net.minecraft.entity.IEntityMultiPart;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFSnowQueen extends EntityMob implements IBossDisplayData, IEntityMultiPart, IBreathAttacker
{
    private static final int MAX_SUMMONS = 6;
    private static final int BEAM_FLAG = 21;
    private static final int PHASE_FLAG = 22;
    private static final int MAX_DAMAGE_WHILE_BEAMING = 25;
    private static final float BREATH_DAMAGE = 4.0f;
    public Entity[] iceArray;
    private int summonsRemaining;
    private int successfulDrops;
    private int maxDrops;
    private int damageWhileBeaming;
    
    public EntityTFSnowQueen(final World par1World) {
        super(par1World);
        this.summonsRemaining = 0;
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAITFHoverSummon(this, EntityPlayer.class, 1.0));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAITFHoverThenDrop(this, EntityPlayer.class, 80, 20));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITFHoverBeam(this, EntityPlayer.class, 80, 100));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, (Class)EntityPlayer.class, 1.0, true));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, 0, true));
        this.func_70105_a(0.7f, 2.2f);
        this.iceArray = new Entity[7];
        for (int i = 0; i < this.iceArray.length; ++i) {
            this.iceArray[i] = new EntityTFSnowQueenIceShield(this);
        }
        this.setCurrentPhase(Phase.SUMMON);
        this.field_70178_ae = true;
        this.field_70728_aV = 317;
    }
    
    public boolean func_70104_M() {
        return false;
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.23000000417232513);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(7.0);
        this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(40.0);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(200.0);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(21, (Object)0);
        this.field_70180_af.func_75682_a(22, (Object)0);
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    protected String func_70639_aQ() {
        return "TwilightForest:mob.ice.noise";
    }
    
    protected String func_70621_aR() {
        return "TwilightForest:mob.ice.hurt";
    }
    
    protected String func_70673_aS() {
        return "TwilightForest:mob.ice.death";
    }
    
    protected Item func_146068_u() {
        return Items.field_151126_ay;
    }
    
    protected void func_82162_bC() {
        super.func_82162_bC();
    }
    
    public IEntityLivingData func_110161_a(final IEntityLivingData par1EntityLivingData) {
        final IEntityLivingData data = super.func_110161_a(par1EntityLivingData);
        return data;
    }
    
    public void func_70636_d() {
        super.func_70636_d();
        for (int i = 0; i < 3; ++i) {
            final float px = (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.3f;
            final float py = this.func_70047_e() + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.5f;
            final float pz = (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.3f;
            TwilightForestMod.proxy.spawnParticle(this.field_70170_p, "snowguardian", this.field_70142_S + px, this.field_70137_T + py, this.field_70136_U + pz, 0.0, 0.0, 0.0);
        }
        if (this.getCurrentPhase() == Phase.DROP) {
            for (int i = 0; i < this.iceArray.length; ++i) {
                final float px = (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.5f;
                final float py = (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.5f;
                final float pz = (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.5f;
                TwilightForestMod.proxy.spawnParticle(this.field_70170_p, "snowwarning", this.iceArray[i].field_70142_S + px, this.iceArray[i].field_70137_T + py, this.iceArray[i].field_70136_U + pz, 0.0, 0.0, 0.0);
            }
        }
        if (this.isBreathing() && this.func_70089_S()) {
            final Vec3 look = this.func_70040_Z();
            final double dist = 0.5;
            final double px2 = this.field_70165_t + look.field_72450_a * dist;
            final double py2 = this.field_70163_u + 1.7000000476837158 + look.field_72448_b * dist;
            final double pz2 = this.field_70161_v + look.field_72449_c * dist;
            for (int j = 0; j < 10; ++j) {
                double dx = look.field_72450_a;
                double dy = 0.0;
                double dz = look.field_72449_c;
                final double spread = 2.0 + this.func_70681_au().nextDouble() * 2.5;
                final double velocity = 2.0 + this.func_70681_au().nextDouble() * 0.15;
                dx += this.func_70681_au().nextGaussian() * 0.0075 * spread;
                dy += this.func_70681_au().nextGaussian() * 0.0075 * spread;
                dz += this.func_70681_au().nextGaussian() * 0.0075 * spread;
                dx *= velocity;
                dy *= velocity;
                dz *= velocity;
                TwilightForestMod.proxy.spawnParticle(this.field_70170_p, "icebeam", px2, py2, pz2, dx, dy, dz);
            }
        }
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        for (int i = 0; i < this.iceArray.length; ++i) {
            this.iceArray[i].func_70071_h_();
            if (i < this.iceArray.length - 1) {
                final Vec3 blockPos = this.getIceShieldPosition(i);
                this.iceArray[i].func_70107_b(blockPos.field_72450_a, blockPos.field_72448_b, blockPos.field_72449_c);
                this.iceArray[i].field_70177_z = this.getIceShieldAngle(i);
            }
            else {
                this.iceArray[i].func_70107_b(this.field_70165_t, this.field_70163_u - 1.0, this.field_70161_v);
                this.iceArray[i].field_70177_z = this.getIceShieldAngle(i);
            }
            if (!this.field_70170_p.field_72995_K) {
                this.applyShieldCollisions(this.iceArray[i]);
            }
        }
        if (this.field_70725_aQ > 0) {
            for (int k = 0; k < 5; ++k) {
                final double d = this.field_70146_Z.nextGaussian() * 0.02;
                final double d2 = this.field_70146_Z.nextGaussian() * 0.02;
                final double d3 = this.field_70146_Z.nextGaussian() * 0.02;
                final String explosionType = this.field_70146_Z.nextBoolean() ? "hugeexplosion" : "explode";
                this.field_70170_p.func_72869_a(explosionType, this.field_70165_t + this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f - this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextFloat() * this.field_70131_O, this.field_70161_v + this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f - this.field_70130_N, d, d2, d3);
            }
        }
    }
    
    protected void func_70628_a(final boolean par1, final int par2) {
        this.dropBow();
        for (int totalDrops = this.field_70146_Z.nextInt(4 + par2) + 1, i = 0; i < totalDrops; ++i) {
            this.func_145779_a(Item.func_150898_a(Blocks.field_150403_cj), 7);
        }
        for (int totalDrops = this.field_70146_Z.nextInt(5 + par2) + 5, i = 0; i < totalDrops; ++i) {
            this.func_145779_a(Items.field_151126_ay, 16);
        }
        this.func_70099_a(new ItemStack(TFItems.trophy, 1, 4), 0.0f);
    }
    
    private void dropBow() {
        final int bowType = this.field_70146_Z.nextInt(2);
        if (bowType == 0) {
            this.func_70099_a(new ItemStack(TFItems.tripleBow), 0.0f);
        }
        else {
            this.func_70099_a(new ItemStack(TFItems.seekerBow), 0.0f);
        }
    }
    
    public void func_70645_a(final DamageSource par1DamageSource) {
        super.func_70645_a(par1DamageSource);
        if (par1DamageSource.func_76364_f() instanceof EntityPlayer) {
            ((EntityPlayer)par1DamageSource.func_76364_f()).func_71029_a((StatBase)TFAchievementPage.twilightHunter);
            ((EntityPlayer)par1DamageSource.func_76364_f()).func_71029_a((StatBase)TFAchievementPage.twilightProgressGlacier);
        }
        if (!this.field_70170_p.field_72995_K) {
            final int dx = MathHelper.func_76128_c(this.field_70165_t);
            final int dy = MathHelper.func_76128_c(this.field_70163_u);
            final int dz = MathHelper.func_76128_c(this.field_70161_v);
            if (this.field_70170_p.field_73011_w instanceof WorldProviderTwilightForest) {
                final ChunkProviderTwilightForest chunkProvider = ((WorldProviderTwilightForest)this.field_70170_p.field_73011_w).getChunkProvider();
                final TFFeature nearbyFeature = ((TFWorldChunkManager)this.field_70170_p.field_73011_w.field_76578_c).getFeatureAt(dx, dz, this.field_70170_p);
                if (nearbyFeature == TFFeature.lichTower) {
                    chunkProvider.setStructureConquered(dx, dy, dz, true);
                }
            }
        }
    }
    
    private void applyShieldCollisions(final Entity collider) {
        final List<Entity> list = this.field_70170_p.func_72839_b(collider, collider.field_70121_D.func_72314_b(-0.20000000298023224, -0.20000000298023224, -0.20000000298023224));
        for (final Entity collided : list) {
            if (collided.func_70104_M()) {
                this.applyShieldCollision(collider, collided);
            }
        }
    }
    
    protected void applyShieldCollision(final Entity collider, final Entity collided) {
        if (collided != this) {
            collided.func_70108_f(collider);
            if (collided instanceof EntityLivingBase) {
                final boolean attackSuccess = super.func_70652_k(collided);
                if (attackSuccess) {
                    collided.field_70181_x += 0.4000000059604645;
                    this.func_85030_a("mob.irongolem.throw", 1.0f, 1.0f);
                }
            }
        }
    }
    
    protected void func_70619_bc() {
        super.func_70619_bc();
        if (this.getCurrentPhase() == Phase.SUMMON && this.getSummonsRemaining() == 0 && this.countMyMinions() <= 0) {
            this.setCurrentPhase(Phase.DROP);
        }
        if (this.getCurrentPhase() == Phase.DROP && this.successfulDrops >= this.maxDrops) {
            this.setCurrentPhase(Phase.BEAM);
        }
        if (this.getCurrentPhase() == Phase.BEAM && this.damageWhileBeaming >= 25) {
            this.setCurrentPhase(Phase.SUMMON);
        }
    }
    
    public boolean func_70097_a(final DamageSource par1DamageSource, final float damage) {
        final boolean result = super.func_70097_a(par1DamageSource, damage);
        if (result && this.getCurrentPhase() == Phase.BEAM) {
            this.damageWhileBeaming += (int)damage;
        }
        return result;
    }
    
    private Vec3 getIceShieldPosition(final int i) {
        return this.getIceShieldPosition(this.getIceShieldAngle(i), 1.0f);
    }
    
    private float getIceShieldAngle(final int i) {
        return 60.0f * i + this.field_70173_aa * 5.0f;
    }
    
    public Vec3 getIceShieldPosition(final float angle, final float distance) {
        final double var1 = Math.cos(angle * 3.141592653589793 / 180.0) * distance;
        final double var2 = Math.sin(angle * 3.141592653589793 / 180.0) * distance;
        return Vec3.func_72443_a(this.field_70165_t + var1, this.field_70163_u + this.getShieldYOffset(), this.field_70161_v + var2);
    }
    
    public double getShieldYOffset() {
        return 0.10000000149011612;
    }
    
    protected void func_70069_a(final float par1) {
    }
    
    public World func_82194_d() {
        return this.field_70170_p;
    }
    
    public boolean func_70965_a(final EntityDragonPart entitydragonpart, final DamageSource damagesource, final float i) {
        return false;
    }
    
    public Entity[] func_70021_al() {
        return this.iceArray;
    }
    
    public boolean destroyBlocksInAABB(final AxisAlignedBB par1AxisAlignedBB) {
        final int minX = MathHelper.func_76128_c(par1AxisAlignedBB.field_72340_a);
        final int minY = MathHelper.func_76128_c(par1AxisAlignedBB.field_72338_b);
        final int minZ = MathHelper.func_76128_c(par1AxisAlignedBB.field_72339_c);
        final int maxX = MathHelper.func_76128_c(par1AxisAlignedBB.field_72336_d);
        final int maxY = MathHelper.func_76128_c(par1AxisAlignedBB.field_72337_e);
        final int maxZ = MathHelper.func_76128_c(par1AxisAlignedBB.field_72334_f);
        boolean wasBlocked = false;
        for (int dx = minX; dx <= maxX; ++dx) {
            for (int dy = minY; dy <= maxY; ++dy) {
                for (int dz = minZ; dz <= maxZ; ++dz) {
                    final Block block = this.field_70170_p.func_147439_a(dx, dy, dz);
                    if (block != Blocks.field_150350_a) {
                        final int currentMeta = this.field_70170_p.func_72805_g(dx, dy, dz);
                        if (block == Blocks.field_150432_aD || block == Blocks.field_150403_cj) {
                            this.field_70170_p.func_147465_d(dx, dy, dz, Blocks.field_150350_a, 0, 2);
                            this.field_70170_p.func_72926_e(2001, dx, dy, dz, Block.func_149682_b(block) + (currentMeta << 12));
                        }
                        else {
                            wasBlocked = true;
                        }
                    }
                }
            }
        }
        return wasBlocked;
    }
    
    public boolean isBreathing() {
        return this.func_70096_w().func_75683_a(21) == 1;
    }
    
    public void setBreathing(final boolean flag) {
        this.func_70096_w().func_75692_b(21, (Object)(byte)(flag ? 1 : 0));
    }
    
    public Phase getCurrentPhase() {
        return Phase.values()[this.func_70096_w().func_75683_a(22)];
    }
    
    public void setCurrentPhase(final Phase currentPhase) {
        this.func_70096_w().func_75692_b(22, (Object)(byte)currentPhase.ordinal());
        if (currentPhase == Phase.SUMMON) {
            this.setSummonsRemaining(6);
        }
        if (currentPhase == Phase.DROP) {
            this.successfulDrops = 0;
            this.maxDrops = 2 + this.field_70146_Z.nextInt(3);
        }
        if (currentPhase == Phase.BEAM) {
            this.damageWhileBeaming = 0;
        }
    }
    
    public int getSummonsRemaining() {
        return this.summonsRemaining;
    }
    
    public void setSummonsRemaining(final int summonsRemaining) {
        this.summonsRemaining = summonsRemaining;
    }
    
    public void summonMinionAt(final EntityLivingBase targetedEntity) {
        final Vec3 minionSpot = this.findVecInLOSOf((Entity)targetedEntity);
        final EntityTFIceCrystal minion = new EntityTFIceCrystal(this.field_70170_p);
        minion.func_70107_b(minionSpot.field_72450_a, minionSpot.field_72448_b, minionSpot.field_72449_c);
        this.field_70170_p.func_72838_d((Entity)minion);
        minion.func_70624_b(targetedEntity);
        minion.setToDieIn30Seconds();
        --this.summonsRemaining;
    }
    
    protected Vec3 findVecInLOSOf(final Entity targetEntity) {
        if (targetEntity == null) {
            return null;
        }
        double tx = 0.0;
        double ty = 0.0;
        double tz = 0.0;
        final int tries = 100;
        for (int i = 0; i < tries; ++i) {
            tx = targetEntity.field_70165_t + this.field_70146_Z.nextGaussian() * 16.0;
            ty = targetEntity.field_70163_u + this.field_70146_Z.nextGaussian() * 8.0;
            tz = targetEntity.field_70161_v + this.field_70146_Z.nextGaussian() * 16.0;
            boolean groundFlag = false;
            final int bx = MathHelper.func_76128_c(tx);
            int by = MathHelper.func_76128_c(ty);
            final int bz = MathHelper.func_76128_c(tz);
            while (!groundFlag && ty > 0.0) {
                final Block whatsThere = this.field_70170_p.func_147439_a(bx, by - 1, bz);
                if (whatsThere == Blocks.field_150350_a || !whatsThere.func_149688_o().func_76220_a()) {
                    --ty;
                    --by;
                }
                else {
                    groundFlag = true;
                }
            }
            if (by != 0) {
                if (this.canEntitySee(targetEntity, tx, ty, tz)) {
                    final float halfWidth = this.field_70130_N / 2.0f;
                    final AxisAlignedBB destBox = AxisAlignedBB.func_72330_a(tx - halfWidth, ty - this.field_70129_M + this.field_70139_V, tz - halfWidth, tx + halfWidth, ty - this.field_70129_M + this.field_70139_V + this.field_70131_O, tz + halfWidth);
                    if (this.field_70170_p.func_72945_a((Entity)this, destBox).size() <= 0) {
                        if (!this.field_70170_p.func_72953_d(destBox)) {
                            break;
                        }
                    }
                }
            }
        }
        if (tries == 99) {
            return null;
        }
        return Vec3.func_72443_a(tx, ty, tz);
    }
    
    protected boolean canEntitySee(final Entity entity, final double dx, final double dy, final double dz) {
        return this.field_70170_p.func_72933_a(Vec3.func_72443_a(entity.field_70165_t, entity.field_70163_u + entity.func_70047_e(), entity.field_70161_v), Vec3.func_72443_a(dx, dy, dz)) == null;
    }
    
    public int countMyMinions() {
        final List<EntityTFIceCrystal> nearbyMinons = this.field_70170_p.func_72872_a((Class)EntityTFIceCrystal.class, AxisAlignedBB.func_72330_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70165_t + 1.0, this.field_70163_u + 1.0, this.field_70161_v + 1.0).func_72314_b(32.0, 16.0, 32.0));
        return nearbyMinons.size();
    }
    
    public void incrementSuccessfulDrops() {
        ++this.successfulDrops;
    }
    
    public void doBreathAttack(final Entity target) {
        if (target.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), 4.0f)) {}
    }
    
    public enum Phase
    {
        SUMMON, 
        DROP, 
        BEAM;
    }
}
