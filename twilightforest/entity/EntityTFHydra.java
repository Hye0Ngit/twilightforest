// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.entity.item.EntityXPOrb;
import twilightforest.item.TFItems;
import net.minecraft.stats.StatBase;
import twilightforest.TFAchievementPage;
import net.minecraft.util.DamageSource;
import net.minecraft.block.Block;
import java.util.Iterator;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import java.util.List;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.SharedMonsterAttributes;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import net.minecraft.world.World;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.IEntityMultiPart;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.EntityLiving;

public class EntityTFHydra extends EntityLiving implements IBossDisplayData, IEntityMultiPart, IMob
{
    private static int TICKS_BEFORE_HEALING;
    private static int HEAD_RESPAWN_TICKS;
    private static int HEAD_MAX_DAMAGE;
    private static float ARMOR_MULTIPLIER;
    private static int MAX_HEALTH;
    private static float HEADS_ACTIVITY_FACTOR;
    private static int SECONDARY_FLAME_CHANCE;
    private static int SECONDARY_MORTAR_CHANCE;
    private static final int DATA_SPAWNHEADS = 17;
    private static final int DATA_BOSSHEALTH = 18;
    public Entity[] partArray;
    public EntityDragonPart body;
    public HydraHeadContainer[] hc;
    public int numHeads;
    public EntityDragonPart leftLeg;
    public EntityDragonPart rightLeg;
    public EntityDragonPart tail;
    Entity field_70776_bF;
    public int ticksSinceDamaged;
    
    public EntityTFHydra(final World world) {
        super(world);
        this.numHeads = 7;
        this.field_70776_bF = null;
        this.ticksSinceDamaged = 0;
        this.partArray = new Entity[] { (Entity)(this.body = new EntityDragonPart((IEntityMultiPart)this, "body", 4.0f, 4.0f)), (Entity)(this.leftLeg = new EntityDragonPart((IEntityMultiPart)this, "leg", 2.0f, 3.0f)), (Entity)(this.rightLeg = new EntityDragonPart((IEntityMultiPart)this, "leg", 2.0f, 3.0f)), (Entity)(this.tail = new EntityDragonPart((IEntityMultiPart)this, "tail", 4.0f, 4.0f)) };
        this.hc = new HydraHeadContainer[this.numHeads];
        for (int i = 0; i < this.numHeads; ++i) {
            this.hc[i] = new HydraHeadContainer(this, i, i < 3);
        }
        final ArrayList<Entity> partList = new ArrayList<Entity>();
        Collections.addAll(partList, this.partArray);
        for (int j = 0; j < this.numHeads; ++j) {
            Collections.addAll((Collection<? super EntityTFHydraNeck>)partList, this.hc[j].getNeckArray());
        }
        this.partArray = partList.toArray(this.partArray);
        this.func_70105_a(16.0f, 12.0f);
        this.field_70158_ak = true;
        this.field_70178_ae = true;
        this.field_70728_aV = 511;
        this.setSpawnHeads(true);
    }
    
    public EntityTFHydra(final World world, final double x, final double y, final double z) {
        this(world);
        this.func_70107_b(x, y, z);
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)EntityTFHydra.MAX_HEALTH);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.28);
    }
    
    public void func_70636_d() {
        if ((this.hc[0].headEntity == null || this.hc[1].headEntity == null || this.hc[2].headEntity == null) && this.shouldSpawnHeads() && !this.field_70170_p.field_72995_K) {
            for (int i = 0; i < this.numHeads; ++i) {
                (this.hc[i].headEntity = new EntityTFHydraHead(this, "head" + i, 3.0f, 3.0f)).func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                this.field_70170_p.func_72838_d((Entity)this.hc[i].headEntity);
            }
            this.setSpawnHeads(false);
        }
        this.body.func_70071_h_();
        for (int i = 0; i < this.numHeads; ++i) {
            this.hc[i].onUpdate();
        }
        if (!this.field_70170_p.field_72995_K) {
            this.field_70180_af.func_75692_b(18, (Object)(int)this.func_110143_aJ());
        }
        else if (this.func_110143_aJ() > 0.0f) {
            this.field_70725_aQ = 0;
        }
        if (this.field_70737_aN > 0) {
            for (int i = 0; i < this.numHeads; ++i) {
                this.hc[i].setHurtTime(this.field_70737_aN);
            }
        }
        ++this.ticksSinceDamaged;
        if (!this.field_70170_p.field_72995_K && this.ticksSinceDamaged > EntityTFHydra.TICKS_BEFORE_HEALING && this.ticksSinceDamaged % 5 == 0) {
            this.func_70691_i(1.0f);
        }
        this.setDifficultyVariables();
        if (this.field_70716_bi > 0) {
            final double var1 = this.field_70165_t + (this.field_70709_bj - this.field_70165_t) / this.field_70716_bi;
            final double var2 = this.field_70163_u + (this.field_70710_bk - this.field_70163_u) / this.field_70716_bi;
            final double var3 = this.field_70161_v + (this.field_110152_bk - this.field_70161_v) / this.field_70716_bi;
            final double var4 = MathHelper.func_76138_g(this.field_70712_bm - this.field_70177_z);
            this.field_70177_z += (float)(var4 / this.field_70716_bi);
            this.field_70125_A += (float)((this.field_70705_bn - this.field_70125_A) / this.field_70716_bi);
            --this.field_70716_bi;
            this.func_70107_b(var1, var2, var3);
            this.func_70101_b(this.field_70177_z, this.field_70125_A);
        }
        if (Math.abs(this.field_70159_w) < 0.005) {
            this.field_70159_w = 0.0;
        }
        if (Math.abs(this.field_70181_x) < 0.005) {
            this.field_70181_x = 0.0;
        }
        if (Math.abs(this.field_70179_y) < 0.005) {
            this.field_70179_y = 0.0;
        }
        this.field_70170_p.field_72984_F.func_76320_a("ai");
        if (this.func_70610_aX()) {
            this.field_70703_bu = false;
            this.field_70702_br = 0.0f;
            this.field_70701_bs = 0.0f;
            this.field_70704_bt = 0.0f;
        }
        else if (this.func_70613_aW()) {
            this.field_70170_p.field_72984_F.func_76320_a("oldAi");
            this.func_70626_be();
            this.field_70170_p.field_72984_F.func_76319_b();
            this.field_70759_as = this.field_70177_z;
        }
        this.field_70170_p.field_72984_F.func_76319_b();
        this.field_70170_p.field_72984_F.func_76320_a("jump");
        if (this.field_70703_bu) {
            if (!this.func_70090_H() && !this.func_70058_J()) {
                if (this.field_70122_E) {
                    this.func_70664_aZ();
                }
            }
            else {
                this.field_70181_x += 0.03999999910593033;
            }
        }
        this.field_70170_p.field_72984_F.func_76319_b();
        this.field_70170_p.field_72984_F.func_76320_a("travel");
        this.field_70702_br *= 0.98f;
        this.field_70701_bs *= 0.98f;
        this.field_70704_bt *= 0.9f;
        this.func_70612_e(this.field_70702_br, this.field_70701_bs);
        this.field_70170_p.field_72984_F.func_76319_b();
        final EntityDragonPart body = this.body;
        final EntityDragonPart body2 = this.body;
        final float n = 6.0f;
        body2.field_70131_O = n;
        body.field_70130_N = n;
        this.tail.field_70130_N = 6.0f;
        this.tail.field_70131_O = 2.0f;
        final float angle = (this.field_70761_aq + 180.0f) * 3.141593f / 180.0f;
        double dx = this.field_70165_t - MathHelper.func_76126_a(angle) * 3.0;
        double dy = this.field_70163_u + 0.1;
        double dz = this.field_70161_v + MathHelper.func_76134_b(angle) * 3.0;
        this.body.func_70107_b(dx, dy, dz);
        dx = this.field_70165_t - MathHelper.func_76126_a(angle) * 10.5;
        dy = this.field_70163_u + 0.1;
        dz = this.field_70161_v + MathHelper.func_76134_b(angle) * 10.5;
        this.tail.func_70107_b(dx, dy, dz);
        this.field_70170_p.field_72984_F.func_76320_a("push");
        if (!this.field_70170_p.field_72995_K && this.field_70737_aN == 0) {
            this.collideWithEntities(this.field_70170_p.func_72839_b((Entity)this, this.body.field_70121_D), (Entity)this.body);
            this.collideWithEntities(this.field_70170_p.func_72839_b((Entity)this, this.tail.field_70121_D), (Entity)this.tail);
        }
        this.field_70170_p.field_72984_F.func_76319_b();
        if (!this.field_70170_p.field_72995_K) {
            this.destroyBlocksInAABB(this.body.field_70121_D);
            this.destroyBlocksInAABB(this.tail.field_70121_D);
            for (int j = 0; j < this.numHeads; ++j) {
                if (this.hc[j].headEntity != null && this.hc[j].isActive()) {
                    this.destroyBlocksInAABB(this.hc[j].headEntity.field_70121_D);
                }
            }
            if (this.field_70173_aa % 20 == 0 && this.isUnsteadySurfaceBeneath()) {
                this.destroyBlocksInAABB(this.field_70121_D.func_72317_d(0.0, -1.0, 0.0));
            }
        }
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(17, (Object)0);
        this.field_70180_af.func_75682_a(18, (Object)new Integer(EntityTFHydra.MAX_HEALTH));
    }
    
    public boolean shouldSpawnHeads() {
        return this.field_70180_af.func_75683_a(17) != 0;
    }
    
    public void setSpawnHeads(final boolean flag) {
        if (flag) {
            this.field_70180_af.func_75692_b(17, (Object)127);
        }
        else {
            this.field_70180_af.func_75692_b(17, (Object)0);
        }
    }
    
    public void func_70014_b(final NBTTagCompound nbttagcompound) {
        super.func_70014_b(nbttagcompound);
        nbttagcompound.func_74757_a("SpawnHeads", this.shouldSpawnHeads());
        nbttagcompound.func_74774_a("NumHeads", (byte)this.countActiveHeads());
    }
    
    public void func_70037_a(final NBTTagCompound nbttagcompound) {
        super.func_70037_a(nbttagcompound);
        this.setSpawnHeads(nbttagcompound.func_74767_n("SpawnHeads"));
        this.activateNumberOfHeads(nbttagcompound.func_74771_c("NumHeads"));
    }
    
    protected void func_70626_be() {
        ++this.field_70708_bq;
        final EntityPlayer entityplayer = this.field_70170_p.func_72856_b((Entity)this, -1.0);
        this.func_70623_bb();
        this.field_70702_br = 0.0f;
        this.field_70701_bs = 0.0f;
        final float f = 48.0f;
        for (int i = 0; i < this.numHeads; ++i) {
            if (this.hc[i].isActive() && this.hc[i].getDamageTaken() > EntityTFHydra.HEAD_MAX_DAMAGE) {
                this.hc[i].setNextState(11);
                this.hc[i].endCurrentAction();
                this.hc[i].setRespawnCounter(EntityTFHydra.HEAD_RESPAWN_TICKS);
                final int otherHead = this.getRandomDeadHead();
                if (otherHead != -1) {
                    this.hc[otherHead].setRespawnCounter(EntityTFHydra.HEAD_RESPAWN_TICKS);
                }
            }
        }
        if (this.field_70146_Z.nextFloat() < 0.7f) {
            final EntityPlayer entityplayer2 = this.field_70170_p.func_72856_b((Entity)this, (double)f);
            if (entityplayer2 != null) {
                this.field_70776_bF = (Entity)entityplayer2;
                this.field_70700_bx = 100 + this.field_70146_Z.nextInt(20);
            }
            else {
                this.field_70704_bt = (this.field_70146_Z.nextFloat() - 0.5f) * 20.0f;
            }
        }
        if (this.field_70776_bF != null) {
            this.func_70625_a(this.field_70776_bF, 10.0f, (float)this.func_70646_bf());
            for (int i = 0; i < this.numHeads; ++i) {
                if (!this.isHeadAttacking(this.hc[i]) && !this.hc[i].isSecondaryAttacking) {
                    this.hc[i].setTargetEntity(this.field_70776_bF);
                }
            }
            if (this.field_70776_bF.func_70089_S()) {
                final float distance = this.field_70776_bF.func_70032_d((Entity)this);
                if (this.func_70685_l(this.field_70776_bF)) {
                    this.attackEntity(this.field_70776_bF, distance);
                }
            }
            if (this.field_70700_bx-- <= 0 || this.field_70776_bF.field_70128_L || this.field_70776_bF.func_70068_e((Entity)this) > f * f) {
                this.field_70776_bF = null;
            }
        }
        else {
            if (this.field_70146_Z.nextFloat() < 0.05f) {
                this.field_70704_bt = (this.field_70146_Z.nextFloat() - 0.5f) * 20.0f;
            }
            this.field_70177_z += this.field_70704_bt;
            this.field_70125_A = this.field_70698_bv;
            for (int i = 0; i < this.numHeads; ++i) {
                if (this.hc[i].currentState == 0) {
                    this.hc[i].setTargetEntity(null);
                }
            }
        }
        this.secondaryAttacks();
        final boolean flag = this.func_70090_H();
        final boolean flag2 = this.func_70058_J();
        if (flag || flag2) {
            this.field_70703_bu = (this.field_70146_Z.nextFloat() < 0.8f);
        }
    }
    
    private void setDifficultyVariables() {
        if (this.field_70170_p.field_73013_u < 3) {
            EntityTFHydra.HEADS_ACTIVITY_FACTOR = 0.3f;
        }
        else {
            EntityTFHydra.HEADS_ACTIVITY_FACTOR = 0.5f;
        }
    }
    
    private int getRandomDeadHead() {
        for (int i = 0; i < this.numHeads; ++i) {
            if (this.hc[i].currentState == 12 && this.hc[i].respawnCounter == -1) {
                return i;
            }
        }
        return -1;
    }
    
    private void activateNumberOfHeads(final int howMany) {
        for (int moreHeads = howMany - this.countActiveHeads(), i = 0; i < moreHeads; ++i) {
            final int otherHead = this.getRandomDeadHead();
            if (otherHead != -1) {
                this.hc[otherHead].currentState = 0;
                this.hc[otherHead].setNextState(0);
                this.hc[otherHead].endCurrentAction();
            }
        }
    }
    
    private void attackEntity(final Entity target, final float distance) {
        final int BITE_CHANCE = 10;
        final int FLAME_CHANCE = 100;
        final int MORTAR_CHANCE = 160;
        final boolean targetAbove = target.field_70121_D.field_72338_b > this.field_70121_D.field_72337_e;
        for (int i = 0; i < 3; ++i) {
            if (this.hc[i].currentState == 0 && !this.areTooManyHeadsAttacking(target, i)) {
                if (distance > 4.0f && distance < 10.0f && this.field_70146_Z.nextInt(BITE_CHANCE) == 0 && this.countActiveHeads() > 2 && !this.areOtherHeadsBiting(target, i)) {
                    this.hc[i].setNextState(1);
                }
                else if (distance > 0.0f && distance < 20.0f && this.field_70146_Z.nextInt(FLAME_CHANCE) == 0) {
                    this.hc[i].setNextState(5);
                }
                else if (distance > 8.0f && distance < 32.0f && !targetAbove && this.field_70146_Z.nextInt(MORTAR_CHANCE) == 0) {
                    this.hc[i].setNextState(8);
                }
            }
        }
        for (int i = 3; i < this.numHeads; ++i) {
            if (this.hc[i].currentState == 0 && !this.areTooManyHeadsAttacking(target, i)) {
                if (distance > 0.0f && distance < 20.0f && this.field_70146_Z.nextInt(FLAME_CHANCE) == 0) {
                    this.hc[i].setNextState(5);
                }
                else if (distance > 8.0f && distance < 32.0f && !targetAbove && this.field_70146_Z.nextInt(MORTAR_CHANCE) == 0) {
                    this.hc[i].setNextState(8);
                }
            }
        }
    }
    
    protected boolean areTooManyHeadsAttacking(final Entity target, final int testHead) {
        int otherAttacks = 0;
        for (int i = 0; i < this.numHeads; ++i) {
            if (i != testHead && this.isHeadAttacking(this.hc[i])) {
                ++otherAttacks;
                if (this.isHeadBiting(this.hc[i])) {
                    otherAttacks += 2;
                }
            }
        }
        return otherAttacks >= 1.0f + this.countActiveHeads() * EntityTFHydra.HEADS_ACTIVITY_FACTOR;
    }
    
    public int countActiveHeads() {
        int count = 0;
        for (int i = 0; i < this.numHeads; ++i) {
            if (this.hc[i].isActive()) {
                ++count;
            }
        }
        return count;
    }
    
    private boolean isHeadAttacking(final HydraHeadContainer head) {
        return head.currentState == 1 || head.currentState == 2 || head.currentState == 3 || head.currentState == 5 || head.currentState == 6 || head.currentState == 8 || head.currentState == 9;
    }
    
    protected boolean areOtherHeadsBiting(final Entity target, final int testHead) {
        for (int i = 0; i < this.numHeads; ++i) {
            if (i != testHead && this.isHeadBiting(this.hc[i])) {
                return true;
            }
        }
        return false;
    }
    
    protected boolean isHeadBiting(final HydraHeadContainer head) {
        return head.currentState == 1 || head.currentState == 2 || head.currentState == 3 || head.nextState == 1;
    }
    
    private void secondaryAttacks() {
        for (int i = 0; i < this.numHeads; ++i) {
            if (this.hc[i].headEntity == null) {
                return;
            }
        }
        final EntityLivingBase secondaryTarget = this.findSecondaryTarget(20.0);
        if (secondaryTarget != null) {
            final float distance = secondaryTarget.func_70032_d((Entity)this);
            for (int j = 1; j < this.numHeads; ++j) {
                if (this.hc[j].isActive() && this.hc[j].currentState == 0 && this.isTargetOnThisSide(j, (Entity)secondaryTarget)) {
                    if (distance > 0.0f && distance < 20.0f && this.field_70146_Z.nextInt(EntityTFHydra.SECONDARY_FLAME_CHANCE) == 0) {
                        this.hc[j].setTargetEntity((Entity)secondaryTarget);
                        this.hc[j].isSecondaryAttacking = true;
                        this.hc[j].setNextState(5);
                    }
                    else if (distance > 8.0f && distance < 32.0f && this.field_70146_Z.nextInt(EntityTFHydra.SECONDARY_MORTAR_CHANCE) == 0) {
                        this.hc[j].setTargetEntity((Entity)secondaryTarget);
                        this.hc[j].isSecondaryAttacking = true;
                        this.hc[j].setNextState(8);
                    }
                }
            }
        }
    }
    
    public boolean isTargetOnThisSide(final int headNum, final Entity target) {
        final double headDist = this.distanceSqXZ((Entity)this.hc[headNum].headEntity, target);
        final double middleDist = this.distanceSqXZ((Entity)this, target);
        return headDist < middleDist;
    }
    
    private double distanceSqXZ(final Entity headEntity, final Entity target) {
        final double distX = headEntity.field_70165_t - target.field_70165_t;
        final double distZ = headEntity.field_70161_v - target.field_70161_v;
        return distX * distX + distZ * distZ;
    }
    
    public EntityLivingBase findSecondaryTarget(final double range) {
        double closestRange = -1.0;
        EntityLivingBase closestEntity = null;
        final List<EntityLiving> nearbyEntities = this.field_70170_p.func_72872_a((Class)EntityLivingBase.class, AxisAlignedBB.func_72332_a().func_72299_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70165_t + 1.0, this.field_70163_u + 1.0, this.field_70161_v + 1.0).func_72314_b(range, range, range));
        for (final EntityLivingBase nearbyLiving : nearbyEntities) {
            if (!(nearbyLiving instanceof EntityTFHydra)) {
                if (nearbyLiving instanceof EntityTFHydraPart) {
                    continue;
                }
                if (nearbyLiving == this.field_70776_bF) {
                    continue;
                }
                if (this.isAnyHeadTargeting((Entity)nearbyLiving)) {
                    continue;
                }
                if (!this.func_70685_l((Entity)nearbyLiving)) {
                    continue;
                }
                final double curDist = nearbyLiving.func_70092_e(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                if ((range >= 0.0 && curDist >= range * range) || (closestRange != -1.0 && curDist >= closestRange)) {
                    continue;
                }
                closestRange = curDist;
                closestEntity = nearbyLiving;
            }
        }
        return closestEntity;
    }
    
    boolean isAnyHeadTargeting(final Entity targetEntity) {
        for (int i = 0; i < this.numHeads; ++i) {
            if (this.hc[i].targetEntity != null && this.hc[i].targetEntity.equals((Object)targetEntity)) {
                return true;
            }
        }
        return false;
    }
    
    private void collideWithEntities(final List<Entity> par1List, final Entity part) {
        final double pushPower = 4.0;
        final double centerX = (part.field_70121_D.field_72340_a + part.field_70121_D.field_72336_d) / 2.0;
        final double centerY = (part.field_70121_D.field_72339_c + part.field_70121_D.field_72334_f) / 2.0;
        for (final Entity entity : par1List) {
            if (entity instanceof EntityLivingBase) {
                final double distX = entity.field_70165_t - centerX;
                final double distZ = entity.field_70161_v - centerY;
                final double sqDist = distX * distX + distZ * distZ;
                entity.func_70024_g(distX / sqDist * pushPower, 0.20000000298023224, distZ / sqDist * pushPower);
            }
        }
    }
    
    private boolean isUnsteadySurfaceBeneath() {
        final int minX = MathHelper.func_76128_c(this.field_70121_D.field_72340_a);
        final int minZ = MathHelper.func_76128_c(this.field_70121_D.field_72339_c);
        final int maxX = MathHelper.func_76128_c(this.field_70121_D.field_72336_d);
        final int maxZ = MathHelper.func_76128_c(this.field_70121_D.field_72334_f);
        final int minY = MathHelper.func_76128_c(this.field_70121_D.field_72338_b);
        int solid = 0;
        int total = 0;
        final int dy = minY - 1;
        for (int dx = minX; dx <= maxX; ++dx) {
            for (int dz = minZ; dz <= maxZ; ++dz) {
                ++total;
                if (this.field_70170_p.func_72803_f(dx, dy, dz).func_76220_a()) {
                    ++solid;
                }
            }
        }
        return solid / (float)total < 0.6f;
    }
    
    private boolean destroyBlocksInAABB(final AxisAlignedBB par1AxisAlignedBB) {
        final int minX = MathHelper.func_76128_c(par1AxisAlignedBB.field_72340_a);
        final int minY = MathHelper.func_76128_c(par1AxisAlignedBB.field_72338_b);
        final int minZ = MathHelper.func_76128_c(par1AxisAlignedBB.field_72339_c);
        final int maxX = MathHelper.func_76128_c(par1AxisAlignedBB.field_72336_d);
        final int maxY = MathHelper.func_76128_c(par1AxisAlignedBB.field_72337_e);
        final int maxZ = MathHelper.func_76128_c(par1AxisAlignedBB.field_72334_f);
        boolean wasBlocked = false;
        boolean didDestroy = false;
        for (int dx = minX; dx <= maxX; ++dx) {
            for (int dy = minY; dy <= maxY; ++dy) {
                for (int dz = minZ; dz <= maxZ; ++dz) {
                    final int currentID = this.field_70170_p.func_72798_a(dx, dy, dz);
                    if (currentID != 0) {
                        final int currentMeta = this.field_70170_p.func_72805_g(dx, dy, dz);
                        if (currentID != Block.field_72089_ap.field_71990_ca && currentID != Block.field_72082_bJ.field_71990_ca && currentID != Block.field_71986_z.field_71990_ca) {
                            didDestroy = true;
                            this.field_70170_p.func_72832_d(dx, dy, dz, 0, 0, 2);
                            this.field_70170_p.func_72926_e(2001, dx, dy, dz, currentID + (currentMeta << 12));
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
    
    public int func_70646_bf() {
        return 500;
    }
    
    public boolean func_70965_a(final EntityDragonPart dragonpart, final DamageSource damagesource, final float i) {
        final double range = this.calculateRange(damagesource);
        return range <= 400.0 && this.superAttackFrom(damagesource, (float)Math.round(i / 8.0f));
    }
    
    protected boolean superAttackFrom(final DamageSource par1DamageSource, final float par2) {
        return super.func_70097_a(par1DamageSource, par2);
    }
    
    public boolean attackEntityFromPart(final EntityTFHydraPart part, final DamageSource damagesource, final float damageAmount) {
        if (!this.field_70170_p.field_72995_K && damagesource == DamageSource.field_76368_d && part.func_70046_E() != null) {
            this.destroyBlocksInAABB(part.func_70046_E());
        }
        HydraHeadContainer headCon = null;
        for (int i = 0; i < this.numHeads; ++i) {
            if (this.hc[i].headEntity == part) {
                headCon = this.hc[i];
            }
        }
        final double range = this.calculateRange(damagesource);
        if (range > 400.0) {
            return false;
        }
        if (headCon != null && !headCon.isActive()) {
            return false;
        }
        boolean tookDamage;
        if (headCon != null && headCon.getCurrentMouthOpen() > 0.5) {
            tookDamage = this.superAttackFrom(damagesource, damageAmount);
            headCon.addDamage(damageAmount);
        }
        else {
            final int armoredDamage = Math.round(damageAmount / EntityTFHydra.ARMOR_MULTIPLIER);
            tookDamage = this.superAttackFrom(damagesource, (float)armoredDamage);
            if (headCon != null) {
                headCon.addDamage((float)armoredDamage);
            }
        }
        if (tookDamage) {
            this.ticksSinceDamaged = 0;
        }
        return tookDamage;
    }
    
    protected double calculateRange(final DamageSource damagesource) {
        double range = -1.0;
        if (damagesource.func_76364_f() != null) {
            range = this.func_70068_e(damagesource.func_76364_f());
        }
        if (damagesource.func_76346_g() != null) {
            range = this.func_70068_e(damagesource.func_76346_g());
        }
        return range;
    }
    
    public boolean func_70097_a(final DamageSource par1DamageSource, final float par2) {
        return false;
    }
    
    public Entity[] func_70021_al() {
        return this.partArray;
    }
    
    public boolean func_70067_L() {
        return false;
    }
    
    public boolean func_70104_M() {
        return false;
    }
    
    public void func_70653_a(final Entity entity, final float i, final double d, final double d1) {
    }
    
    protected String func_70639_aQ() {
        return "TwilightForest:mob.hydra.growl";
    }
    
    protected String func_70621_aR() {
        return "TwilightForest:mob.hydra.hurt";
    }
    
    protected String func_70673_aS() {
        return "TwilightForest:mob.hydra.death";
    }
    
    protected float func_70599_aP() {
        return 2.0f;
    }
    
    public void func_70645_a(final DamageSource par1DamageSource) {
        super.func_70645_a(par1DamageSource);
        if (par1DamageSource.func_76364_f() instanceof EntityPlayer) {
            ((EntityPlayer)par1DamageSource.func_76364_f()).func_71029_a((StatBase)TFAchievementPage.twilightHunter);
        }
    }
    
    protected void func_70628_a(final boolean par1, final int par2) {
        for (int totalDrops = this.field_70146_Z.nextInt(3 + par2) + 5, i = 0; i < totalDrops; ++i) {
            this.func_70025_b(TFItems.hydraChop.field_77779_bT, 5);
        }
        for (int totalDrops = this.field_70146_Z.nextInt(4 + par2) + 7, i = 0; i < totalDrops; ++i) {
            this.func_70025_b(TFItems.fieryBlood.field_77779_bT, 1);
        }
        this.func_70025_b(TFItems.trophy.field_77779_bT, 1);
    }
    
    protected boolean func_70692_ba() {
        return false;
    }
    
    public boolean func_70027_ad() {
        return false;
    }
    
    protected void func_70609_aI() {
        ++this.field_70725_aQ;
        if (this.field_70725_aQ == 1) {
            for (int i = 0; i < this.numHeads; ++i) {
                this.hc[i].setRespawnCounter(-1);
                if (this.hc[i].isActive()) {
                    this.hc[i].setNextState(0);
                    this.hc[i].endCurrentAction();
                    this.hc[i].setHurtTime(200);
                }
            }
        }
        if (this.field_70725_aQ <= 140 && this.field_70725_aQ % 20 == 0) {
            final int headToDie = this.field_70725_aQ / 20 - 1;
            if (this.hc[headToDie].isActive()) {
                this.hc[headToDie].setNextState(11);
                this.hc[headToDie].endCurrentAction();
            }
        }
        if (this.field_70725_aQ == 200) {
            if (!this.field_70170_p.field_72995_K && (this.field_70718_bc > 0 || this.func_70684_aJ()) && !this.func_70631_g_()) {
                int var1 = this.func_70693_a(this.field_70717_bb);
                while (var1 > 0) {
                    final int var2 = EntityXPOrb.func_70527_a(var1);
                    var1 -= var2;
                    this.field_70170_p.func_72838_d((Entity)new EntityXPOrb(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, var2));
                }
            }
            this.func_70106_y();
        }
        for (int var1 = 0; var1 < 20; ++var1) {
            final double var3 = this.field_70146_Z.nextGaussian() * 0.02;
            final double var4 = this.field_70146_Z.nextGaussian() * 0.02;
            final double var5 = this.field_70146_Z.nextGaussian() * 0.02;
            final String particle = (this.field_70146_Z.nextInt(2) == 0) ? "largeexplode" : "explode";
            this.field_70170_p.func_72869_a(particle, this.field_70165_t + this.field_70146_Z.nextFloat() * this.body.field_70130_N * 2.0f - this.body.field_70130_N, this.field_70163_u + this.field_70146_Z.nextFloat() * this.body.field_70131_O, this.field_70161_v + this.field_70146_Z.nextFloat() * this.body.field_70130_N * 2.0f - this.body.field_70130_N, var3, var4, var5);
        }
    }
    
    public World func_82194_d() {
        return this.field_70170_p;
    }
    
    static {
        EntityTFHydra.TICKS_BEFORE_HEALING = 1000;
        EntityTFHydra.HEAD_RESPAWN_TICKS = 100;
        EntityTFHydra.HEAD_MAX_DAMAGE = 120;
        EntityTFHydra.ARMOR_MULTIPLIER = 8.0f;
        EntityTFHydra.MAX_HEALTH = 360;
        EntityTFHydra.HEADS_ACTIVITY_FACTOR = 0.3f;
        EntityTFHydra.SECONDARY_FLAME_CHANCE = 10;
        EntityTFHydra.SECONDARY_MORTAR_CHANCE = 16;
    }
}
