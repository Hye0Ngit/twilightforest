// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.stats.StatBase;
import twilightforest.TFAchievementPage;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.block.Block;
import net.minecraft.util.Vec3;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.enchantment.EnchantmentHelper;
import twilightforest.item.TFItems;
import net.minecraft.item.Item;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFLich extends EntityMob implements IBossDisplayData
{
    private static final int DATA_ISCLONE = 21;
    private static final int DATA_SHIELDSTRENGTH = 17;
    private static final int DATA_MINIONSLEFT = 18;
    private static final int DATA_BOSSHEALTH = 19;
    private static final int DATA_ATTACKTYPE = 20;
    EntityTFLich masterLich;
    private static final ItemStack[] heldItems;
    public static final int MAX_SHADOW_CLONES = 2;
    public static final int INITIAL_SHIELD_STRENGTH = 5;
    public static final int MAX_ACTIVE_MINIONS = 3;
    public static final int INITIAL_MINIONS_TO_SUMMON = 9;
    public static final int MAX_HEALTH = 100;
    
    public EntityTFLich(final World world) {
        super(world);
        this.func_70105_a(1.1f, 2.5f);
        this.setShadowClone(false);
        this.masterLich = null;
        this.field_70178_ae = true;
        this.setShieldStrength(5);
        this.setMinionsToSummon(9);
        this.field_70728_aV = 217;
    }
    
    public EntityTFLich(final World world, final double x, final double y, final double z) {
        this(world);
        this.func_70107_b(x, y, z);
    }
    
    public EntityTFLich(final World world, final EntityTFLich otherLich) {
        this(world);
        this.setShadowClone(true);
        this.masterLich = otherLich;
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(21, (Object)0);
        this.field_70180_af.func_75682_a(17, (Object)0);
        this.field_70180_af.func_75682_a(18, (Object)0);
        this.field_70180_af.func_75682_a(19, (Object)new Integer(100));
        this.field_70180_af.func_75682_a(20, (Object)0);
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(100.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(6.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.800000011920929);
    }
    
    public ItemStack func_70694_bm() {
        return EntityTFLich.heldItems[this.getPhase() - 1];
    }
    
    protected void func_70628_a(final boolean par1, final int par2) {
        this.dropScepter();
        for (int totalDrops = this.field_70146_Z.nextInt(3 + par2) + 2, i = 0; i < totalDrops; ++i) {
            this.dropGoldThing();
        }
        for (int totalDrops = this.field_70146_Z.nextInt(4 + par2) + 1, i = 0; i < totalDrops; ++i) {
            this.func_70025_b(Item.field_77730_bn.field_77779_bT, 1);
        }
        for (int totalDrops = this.field_70146_Z.nextInt(5 + par2) + 5, i = 0; i < totalDrops; ++i) {
            this.func_70025_b(Item.field_77755_aX.field_77779_bT, 1);
        }
        this.func_70099_a(new ItemStack(TFItems.trophy, 1, 2), 0.0f);
    }
    
    private void dropScepter() {
        final int scepterType = this.field_70146_Z.nextInt(3);
        if (scepterType == 0) {
            this.func_70099_a(new ItemStack(TFItems.scepterZombie), 0.0f);
        }
        else if (scepterType == 1) {
            this.func_70099_a(new ItemStack(TFItems.scepterLifeDrain), 0.0f);
        }
        else {
            this.func_70099_a(new ItemStack(TFItems.scepterTwilight), 0.0f);
        }
    }
    
    private void dropGoldThing() {
        final int thingType = this.field_70146_Z.nextInt(5);
        ItemStack goldThing;
        if (thingType == 0) {
            goldThing = new ItemStack(Item.field_77672_G);
        }
        else if (thingType == 1) {
            goldThing = new ItemStack((Item)Item.field_77796_al);
        }
        else if (thingType == 2) {
            goldThing = new ItemStack((Item)Item.field_77806_am);
        }
        else if (thingType == 3) {
            goldThing = new ItemStack((Item)Item.field_77808_an);
        }
        else {
            goldThing = new ItemStack((Item)Item.field_77802_ao);
        }
        EnchantmentHelper.func_77504_a(this.field_70146_Z, goldThing, 10 + this.field_70146_Z.nextInt(30));
        this.func_70099_a(goldThing, 0.0f);
    }
    
    public void func_70110_aj() {
    }
    
    protected boolean func_70692_ba() {
        return false;
    }
    
    public boolean func_70058_J() {
        return false;
    }
    
    public boolean func_70090_H() {
        return false;
    }
    
    public int getPhase() {
        if (this.isShadowClone() || this.getShieldStrength() > 0) {
            return 1;
        }
        if (this.getMinionsToSummon() > 0) {
            return 2;
        }
        return 3;
    }
    
    public void func_70636_d() {
        final float angle = this.field_70761_aq * 3.141593f / 180.0f;
        final double dx = this.field_70165_t + MathHelper.func_76134_b(angle) * 0.65;
        final double dy = this.field_70163_u + this.field_70131_O * 0.94;
        final double dz = this.field_70161_v + MathHelper.func_76126_a(angle) * 0.65;
        final int factor = (80 - this.field_70724_aR) / 10;
        for (int particles = (factor > 0) ? this.field_70146_Z.nextInt(factor) : 1, j1 = 0; j1 < particles; ++j1) {
            float sparkle = 1.0f - (this.field_70724_aR + 1.0f) / 60.0f;
            sparkle *= sparkle;
            float red = 0.37f * sparkle;
            float grn = 0.99f * sparkle;
            float blu = 0.89f * sparkle;
            if (this.getNextAttackType() != 0) {
                red = 0.99f * sparkle;
                grn = 0.47f * sparkle;
                blu = 0.0f * sparkle;
            }
            this.field_70170_p.func_72869_a("mobSpell", dx + this.field_70146_Z.nextGaussian() * 0.025, dy + this.field_70146_Z.nextGaussian() * 0.025, dz + this.field_70146_Z.nextGaussian() * 0.025, (double)red, (double)grn, (double)blu);
        }
        if (this.isShadowClone()) {
            this.checkForMaster();
        }
        if (!this.field_70170_p.field_72995_K) {
            this.field_70180_af.func_75692_b(19, (Object)(int)this.func_110143_aJ());
        }
        super.func_70636_d();
    }
    
    public boolean func_70097_a(final DamageSource par1DamageSource, final float damage) {
        if (par1DamageSource.func_76355_l() == "inWall" && this.field_70789_a != null) {
            this.teleportToSightOfEntity(this.field_70789_a);
        }
        if (this.isShadowClone()) {
            this.field_70170_p.func_72956_a((Entity)this, "random.fizz", 1.0f, ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.7f + 1.0f) * 2.0f);
            return false;
        }
        final Entity prevTarget = this.field_70789_a;
        if (par1DamageSource.func_76346_g() instanceof EntityTFLich) {
            return false;
        }
        if (this.getShieldStrength() > 0) {
            if (par1DamageSource.func_76363_c() && damage > 2.0f) {
                if (this.getShieldStrength() > 0) {
                    this.setShieldStrength(this.getShieldStrength() - 1);
                    this.field_70170_p.func_72956_a((Entity)this, "random.break", 1.0f, ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.7f + 1.0f) * 2.0f);
                }
            }
            else {
                this.field_70170_p.func_72956_a((Entity)this, "random.break", 1.0f, ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.7f + 1.0f) * 2.0f);
                if (par1DamageSource.func_76346_g() instanceof EntityPlayer) {
                    this.field_70789_a = par1DamageSource.func_76346_g();
                }
            }
            return false;
        }
        if (super.func_70097_a(par1DamageSource, damage)) {
            if (this.field_70789_a instanceof EntityTFLich) {
                this.field_70789_a = prevTarget;
            }
            if (this.getPhase() < 3 || this.field_70146_Z.nextInt(4) == 0) {
                this.teleportToSightOfEntity(this.field_70789_a);
            }
            return true;
        }
        return false;
    }
    
    protected void func_70785_a(final Entity targetedEntity, final float f) {
        if (!this.isShadowClone() && this.field_70724_aR % 15 == 0) {
            this.popNearbyMob();
        }
        if (this.getPhase() == 1) {
            if (this.field_70724_aR == 60 && !this.field_70170_p.field_72995_K) {
                this.teleportToSightOfEntity(targetedEntity);
                if (!this.isShadowClone()) {
                    this.checkAndSpawnClones(targetedEntity);
                }
            }
            if (this.func_70685_l(targetedEntity) && this.field_70724_aR == 0 && f < 20.0f) {
                if (this.getNextAttackType() == 0) {
                    this.launchBoltAt(targetedEntity);
                }
                else {
                    this.launchBombAt(targetedEntity);
                }
                if (this.field_70146_Z.nextInt(3) > 0) {
                    this.setNextAttackType(0);
                }
                else {
                    this.setNextAttackType(1);
                }
                this.field_70724_aR = 100;
            }
            this.field_70787_b = true;
        }
        if (this.getPhase() == 2 && !this.isShadowClone()) {
            this.despawnClones();
            if (this.field_70724_aR % 15 == 0) {
                this.checkAndSpawnMinions(targetedEntity);
            }
            if (this.field_70724_aR == 0) {
                if (f < 2.0f) {
                    this.func_70652_k(targetedEntity);
                    this.field_70724_aR = 20;
                }
                else if (f < 20.0f && this.func_70685_l(targetedEntity)) {
                    if (this.getNextAttackType() == 0) {
                        this.launchBoltAt(targetedEntity);
                    }
                    else {
                        this.launchBombAt(targetedEntity);
                    }
                    if (this.field_70146_Z.nextInt(2) > 0) {
                        this.setNextAttackType(0);
                    }
                    else {
                        this.setNextAttackType(1);
                    }
                    this.field_70724_aR = 60;
                }
                else {
                    this.teleportToSightOfEntity(targetedEntity);
                    this.field_70724_aR = 20;
                }
            }
            this.field_70787_b = true;
        }
        if (this.getPhase() == 3 && this.field_70724_aR <= 0 && f < 2.0f && targetedEntity.field_70121_D.field_72337_e > this.field_70121_D.field_72338_b && targetedEntity.field_70121_D.field_72338_b < this.field_70121_D.field_72337_e) {
            this.field_70724_aR = 20;
            this.func_70652_k(targetedEntity);
            this.field_70787_b = true;
        }
    }
    
    protected void launchBoltAt(final Entity targetedEntity) {
        final float bodyFacingAngle = this.field_70761_aq * 3.141593f / 180.0f;
        final double sx = this.field_70165_t + MathHelper.func_76134_b(bodyFacingAngle) * 0.65;
        final double sy = this.field_70163_u + this.field_70131_O * 0.82;
        final double sz = this.field_70161_v + MathHelper.func_76126_a(bodyFacingAngle) * 0.65;
        final double tx = targetedEntity.field_70165_t - sx;
        final double ty = targetedEntity.field_70121_D.field_72338_b + targetedEntity.field_70131_O / 2.0f - (this.field_70163_u + this.field_70131_O / 2.0f);
        final double tz = targetedEntity.field_70161_v - sz;
        this.field_70170_p.func_72956_a((Entity)this, "mob.ghast.fireball", this.func_70599_aP(), (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f + 1.0f);
        final EntityTFLichBolt projectile = new EntityTFLichBolt(this.field_70170_p, (EntityLivingBase)this);
        projectile.func_70186_c(tx, ty, tz, projectile.func_70182_d(), 1.0f);
        projectile.func_70012_b(sx, sy, sz, this.field_70177_z, this.field_70125_A);
        this.field_70170_p.func_72838_d((Entity)projectile);
    }
    
    protected void launchBombAt(final Entity targetedEntity) {
        final float bodyFacingAngle = this.field_70761_aq * 3.141593f / 180.0f;
        final double sx = this.field_70165_t + MathHelper.func_76134_b(bodyFacingAngle) * 0.65;
        final double sy = this.field_70163_u + this.field_70131_O * 0.82;
        final double sz = this.field_70161_v + MathHelper.func_76126_a(bodyFacingAngle) * 0.65;
        final double tx = targetedEntity.field_70165_t - sx;
        final double ty = targetedEntity.field_70121_D.field_72338_b + targetedEntity.field_70131_O / 2.0f - (this.field_70163_u + this.field_70131_O / 2.0f);
        final double tz = targetedEntity.field_70161_v - sz;
        this.field_70170_p.func_72956_a((Entity)this, "mob.ghast.fireball", this.func_70599_aP(), (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f + 1.0f);
        final EntityTFLichBomb projectile = new EntityTFLichBomb(this.field_70170_p, (EntityLivingBase)this);
        projectile.func_70186_c(tx, ty, tz, projectile.func_40077_c(), 1.0f);
        projectile.func_70012_b(sx, sy, sz, this.field_70177_z, this.field_70125_A);
        this.field_70170_p.func_72838_d((Entity)projectile);
    }
    
    protected void popNearbyMob() {
        final List<Entity> nearbyMobs = this.field_70170_p.func_72839_b((Entity)this, AxisAlignedBB.func_72332_a().func_72299_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70165_t + 1.0, this.field_70163_u + 1.0, this.field_70161_v + 1.0).func_72314_b(32.0, 16.0, 32.0));
        for (final Entity entity : nearbyMobs) {
            if (entity instanceof EntityLiving && this.canPop(entity) && this.func_70685_l(entity)) {
                final EntityLiving mob = (EntityLiving)entity;
                if (!this.field_70170_p.field_72995_K) {
                    mob.func_70106_y();
                    mob.func_70656_aK();
                }
                this.makeRedMagicTrail(mob.field_70165_t, mob.field_70163_u + mob.field_70131_O / 2.0, mob.field_70161_v, this.field_70165_t, this.field_70163_u + this.field_70131_O / 2.0, this.field_70161_v);
                break;
            }
        }
    }
    
    protected boolean canPop(final Entity nearby) {
        final Class[] arr$;
        final Class[] poppable = arr$ = new Class[] { EntitySkeleton.class, EntityZombie.class, EntityEnderman.class, EntitySpider.class, EntityCreeper.class, EntityTFSwarmSpider.class };
        for (final Class pop : arr$) {
            if (nearby.getClass() == pop) {
                return true;
            }
        }
        return false;
    }
    
    protected void checkAndSpawnClones(final Entity targetedEntity) {
        if (this.countMyClones() < 2) {
            this.spawnShadowClone(targetedEntity);
        }
    }
    
    protected int countMyClones() {
        final List<EntityTFLich> nearbyLiches = this.field_70170_p.func_72872_a((Class)EntityTFLich.class, AxisAlignedBB.func_72332_a().func_72299_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70165_t + 1.0, this.field_70163_u + 1.0, this.field_70161_v + 1.0).func_72314_b(32.0, 16.0, 32.0));
        int count = 0;
        for (final EntityTFLich nearbyLich : nearbyLiches) {
            if (nearbyLich.isShadowClone() && nearbyLich.masterLich == this) {
                ++count;
            }
        }
        return count;
    }
    
    public boolean wantsNewClone(final EntityTFLich clone) {
        return clone.isShadowClone() && this.countMyClones() < 2;
    }
    
    protected void spawnShadowClone(final Entity targetedEntity) {
        final Vec3 cloneSpot = this.findVecInLOSOf(targetedEntity);
        final EntityTFLich newClone = new EntityTFLich(this.field_70170_p, this);
        newClone.func_70107_b(cloneSpot.field_72450_a, cloneSpot.field_72448_b, cloneSpot.field_72449_c);
        this.field_70170_p.func_72838_d((Entity)newClone);
        newClone.field_70789_a = targetedEntity;
        newClone.field_70724_aR = 60 + this.field_70146_Z.nextInt(3) - this.field_70146_Z.nextInt(3);
        this.makeTeleportTrail(this.field_70165_t, this.field_70163_u, this.field_70161_v, cloneSpot.field_72450_a, cloneSpot.field_72448_b, cloneSpot.field_72449_c);
    }
    
    protected void despawnClones() {
        final List<EntityTFLich> nearbyLiches = this.field_70170_p.func_72872_a((Class)this.getClass(), AxisAlignedBB.func_72332_a().func_72299_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70165_t + 1.0, this.field_70163_u + 1.0, this.field_70161_v + 1.0).func_72314_b(32.0, 16.0, 32.0));
        for (final EntityTFLich nearbyLich : nearbyLiches) {
            if (nearbyLich.isShadowClone()) {
                nearbyLich.field_70128_L = true;
            }
        }
    }
    
    protected void checkAndSpawnMinions(final Entity targetedEntity) {
        if (!this.field_70170_p.field_72995_K && this.getMinionsToSummon() > 0) {
            final int minions = this.countMyMinions();
            if (minions < 3) {
                this.spawnMinionAt((EntityLivingBase)targetedEntity);
                this.setMinionsToSummon(this.getMinionsToSummon() - 1);
            }
        }
    }
    
    protected int countMyMinions() {
        final List<EntityTFLichMinion> nearbyMinons = this.field_70170_p.func_72872_a((Class)EntityTFLichMinion.class, AxisAlignedBB.func_72332_a().func_72299_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70165_t + 1.0, this.field_70163_u + 1.0, this.field_70161_v + 1.0).func_72314_b(32.0, 16.0, 32.0));
        int count = 0;
        for (final EntityTFLichMinion nearbyMinon : nearbyMinons) {
            if (nearbyMinon.master == this) {
                ++count;
            }
        }
        return count;
    }
    
    protected void spawnMinionAt(final EntityLivingBase targetedEntity) {
        final Vec3 minionSpot = this.findVecInLOSOf((Entity)targetedEntity);
        final EntityTFLichMinion minion = new EntityTFLichMinion(this.field_70170_p, this);
        minion.func_70107_b(minionSpot.field_72450_a, minionSpot.field_72448_b, minionSpot.field_72449_c);
        this.field_70170_p.func_72838_d((Entity)minion);
        minion.func_70624_b(targetedEntity);
        minion.func_70656_aK();
        this.field_70170_p.func_72956_a((Entity)minion, "random.pop", 1.0f, ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.7f + 1.0f) * 2.0f);
        this.makeBlackMagicTrail(this.field_70165_t, this.field_70163_u + this.func_70047_e(), this.field_70161_v, minionSpot.field_72450_a, minionSpot.field_72448_b + minion.field_70131_O / 2.0, minionSpot.field_72449_c);
    }
    
    public boolean wantsNewMinion(final EntityTFLichMinion minion) {
        return this.countMyMinions() < 3;
    }
    
    protected void checkForMaster() {
        if (this.masterLich == null) {
            this.findNewMaster();
        }
        if (!this.field_70170_p.field_72995_K) {
            if (this.masterLich == null || this.masterLich.field_70128_L) {
                this.field_70128_L = true;
            }
            else {
                final double distance = (this.field_70165_t - this.masterLich.field_70165_t) * (this.field_70165_t - this.masterLich.field_70165_t) + (this.field_70163_u - this.masterLich.field_70163_u) * (this.field_70163_u - this.masterLich.field_70163_u) + (this.field_70161_v - this.masterLich.field_70161_v) * (this.field_70161_v - this.masterLich.field_70161_v);
            }
        }
    }
    
    private void findNewMaster() {
        final List<EntityTFLich> nearbyLiches = this.field_70170_p.func_72872_a((Class)EntityTFLich.class, AxisAlignedBB.func_72332_a().func_72299_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70165_t + 1.0, this.field_70163_u + 1.0, this.field_70161_v + 1.0).func_72314_b(32.0, 16.0, 32.0));
        for (final EntityTFLich nearbyLich : nearbyLiches) {
            if (!nearbyLich.isShadowClone() && nearbyLich.wantsNewClone(this)) {
                this.masterLich = nearbyLich;
                this.makeTeleportTrail(this.field_70165_t, this.field_70163_u, this.field_70161_v, nearbyLich.field_70165_t, nearbyLich.field_70163_u, nearbyLich.field_70161_v);
                this.func_70624_b(this.masterLich.func_70638_az());
                break;
            }
        }
    }
    
    protected void teleportToSightOfEntity(final Entity entity) {
        final Vec3 dest = this.findVecInLOSOf(entity);
        final double srcX = this.field_70165_t;
        final double srcY = this.field_70163_u;
        final double srcZ = this.field_70161_v;
        if (dest != null) {
            this.teleportToNoChecks(dest.field_72450_a, dest.field_72448_b, dest.field_72449_c);
            this.func_70625_a(entity, 100.0f, 100.0f);
            this.field_70761_aq = this.field_70177_z;
            if (!this.func_70685_l(entity)) {
                this.teleportToNoChecks(srcX, srcY, srcZ);
            }
        }
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
                final int whatsThere = this.field_70170_p.func_72798_a(bx, by - 1, bz);
                if (whatsThere == 0 || !Block.field_71973_m[whatsThere].field_72018_cp.func_76220_a()) {
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
        return this.field_70170_p.func_82732_R().func_72345_a(tx, ty, tz);
    }
    
    protected boolean canEntitySee(final Entity entity, final double dx, final double dy, final double dz) {
        return this.field_70170_p.func_72933_a(this.field_70170_p.func_82732_R().func_72345_a(entity.field_70165_t, entity.field_70163_u + entity.func_70047_e(), entity.field_70161_v), this.field_70170_p.func_82732_R().func_72345_a(dx, dy, dz)) == null;
    }
    
    protected boolean teleportToNoChecks(final double destX, final double destY, final double destZ) {
        final double srcX = this.field_70165_t;
        final double srcY = this.field_70163_u;
        final double srcZ = this.field_70161_v;
        this.func_70107_b(destX, destY, destZ);
        this.makeTeleportTrail(srcX, srcY, srcZ, destX, destY, destZ);
        this.field_70170_p.func_72908_a(srcX, srcY, srcZ, "mob.endermen.portal", 1.0f, 1.0f);
        this.field_70170_p.func_72956_a((Entity)this, "mob.endermen.portal", 1.0f, 1.0f);
        this.field_70703_bu = false;
        return true;
    }
    
    protected void makeTeleportTrail(final double srcX, final double srcY, final double srcZ, final double destX, final double destY, final double destZ) {
        for (int particles = 128, i = 0; i < particles; ++i) {
            final double trailFactor = i / (particles - 1.0);
            final float f = (this.field_70146_Z.nextFloat() - 0.5f) * 0.2f;
            final float f2 = (this.field_70146_Z.nextFloat() - 0.5f) * 0.2f;
            final float f3 = (this.field_70146_Z.nextFloat() - 0.5f) * 0.2f;
            final double tx = srcX + (destX - srcX) * trailFactor + (this.field_70146_Z.nextDouble() - 0.5) * this.field_70130_N * 2.0;
            final double ty = srcY + (destY - srcY) * trailFactor + this.field_70146_Z.nextDouble() * this.field_70131_O;
            final double tz = srcZ + (destZ - srcZ) * trailFactor + (this.field_70146_Z.nextDouble() - 0.5) * this.field_70130_N * 2.0;
            this.field_70170_p.func_72869_a("spell", tx, ty, tz, (double)f, (double)f2, (double)f3);
        }
    }
    
    protected void makeRedMagicTrail(final double srcX, final double srcY, final double srcZ, final double destX, final double destY, final double destZ) {
        for (int particles = 32, i = 0; i < particles; ++i) {
            final double trailFactor = i / (particles - 1.0);
            final float f = 1.0f;
            final float f2 = 0.5f;
            final float f3 = 0.5f;
            final double tx = srcX + (destX - srcX) * trailFactor + this.field_70146_Z.nextGaussian() * 0.005;
            final double ty = srcY + (destY - srcY) * trailFactor + this.field_70146_Z.nextGaussian() * 0.005;
            final double tz = srcZ + (destZ - srcZ) * trailFactor + this.field_70146_Z.nextGaussian() * 0.005;
            this.field_70170_p.func_72869_a("mobSpell", tx, ty, tz, (double)f, (double)f2, (double)f3);
        }
    }
    
    protected void makeBlackMagicTrail(final double srcX, final double srcY, final double srcZ, final double destX, final double destY, final double destZ) {
        for (int particles = 32, i = 0; i < particles; ++i) {
            final double trailFactor = i / (particles - 1.0);
            final float f = 0.2f;
            final float f2 = 0.2f;
            final float f3 = 0.2f;
            final double tx = srcX + (destX - srcX) * trailFactor + this.field_70146_Z.nextGaussian() * 0.005;
            final double ty = srcY + (destY - srcY) * trailFactor + this.field_70146_Z.nextGaussian() * 0.005;
            final double tz = srcZ + (destZ - srcZ) * trailFactor + this.field_70146_Z.nextGaussian() * 0.005;
            this.field_70170_p.func_72869_a("mobSpell", tx, ty, tz, (double)f, (double)f2, (double)f3);
        }
    }
    
    public boolean isShadowClone() {
        return (this.field_70180_af.func_75683_a(21) & 0x2) != 0x0;
    }
    
    public void setShadowClone(final boolean par1) {
        final byte var2 = this.field_70180_af.func_75683_a(21);
        if (par1) {
            this.field_70180_af.func_75692_b(21, (Object)(byte)(var2 | 0x2));
        }
        else {
            this.field_70180_af.func_75692_b(21, (Object)(byte)(var2 & 0xFFFFFFFD));
        }
    }
    
    public byte getShieldStrength() {
        return this.field_70180_af.func_75683_a(17);
    }
    
    public void setShieldStrength(final int shieldStrength) {
        this.field_70180_af.func_75692_b(17, (Object)(byte)shieldStrength);
    }
    
    public byte getMinionsToSummon() {
        return this.field_70180_af.func_75683_a(18);
    }
    
    public void setMinionsToSummon(final int minionsToSummon) {
        this.field_70180_af.func_75692_b(18, (Object)(byte)minionsToSummon);
    }
    
    public byte getNextAttackType() {
        return this.field_70180_af.func_75683_a(20);
    }
    
    public void setNextAttackType(final int attackType) {
        this.field_70180_af.func_75692_b(20, (Object)(byte)attackType);
    }
    
    protected String func_70639_aQ() {
        return "mob.blaze.breathe";
    }
    
    protected String func_70621_aR() {
        return "mob.blaze.hit";
    }
    
    protected String func_70673_aS() {
        return "mob.blaze.death";
    }
    
    public void func_70014_b(final NBTTagCompound nbttagcompound) {
        super.func_70014_b(nbttagcompound);
        nbttagcompound.func_74757_a("ShadowClone", this.isShadowClone());
        nbttagcompound.func_74774_a("ShieldStrength", this.getShieldStrength());
        nbttagcompound.func_74774_a("MinionsToSummon", this.getMinionsToSummon());
    }
    
    public void func_70037_a(final NBTTagCompound nbttagcompound) {
        super.func_70037_a(nbttagcompound);
        this.setShadowClone(nbttagcompound.func_74767_n("ShadowClone"));
        this.setShieldStrength(nbttagcompound.func_74771_c("ShieldStrength"));
        this.setMinionsToSummon(nbttagcompound.func_74771_c("MinionsToSummon"));
    }
    
    public void func_70645_a(final DamageSource par1DamageSource) {
        super.func_70645_a(par1DamageSource);
        if (par1DamageSource.func_76364_f() instanceof EntityPlayer) {
            ((EntityPlayer)par1DamageSource.func_76364_f()).func_71029_a((StatBase)TFAchievementPage.twilightHunter);
            ((EntityPlayer)par1DamageSource.func_76364_f()).func_71029_a((StatBase)TFAchievementPage.twilightLich);
        }
    }
    
    public EnumCreatureAttribute func_70668_bt() {
        return EnumCreatureAttribute.UNDEAD;
    }
    
    static {
        heldItems = new ItemStack[] { new ItemStack(TFItems.scepterTwilight, 1), new ItemStack(TFItems.scepterZombie, 1), new ItemStack(Item.field_77672_G, 1) };
    }
}
