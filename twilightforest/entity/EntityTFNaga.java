// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.stats.StatBase;
import twilightforest.TFAchievementPage;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChunkCoordinates;
import twilightforest.block.TFBlocks;
import net.minecraft.item.ItemStack;
import twilightforest.item.TFItems;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.block.Block;
import net.minecraft.util.Vec3;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.entity.IEntityMultiPart;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.monster.EntityMob;

public class EntityTFNaga extends EntityMob implements IMob, IBossDisplayData, IEntityMultiPart
{
    private static int TICKS_BEFORE_HEALING;
    private static int MAX_SEGMENTS;
    int currentSegments;
    float segmentHealth;
    int LEASH_X;
    int LEASH_Y;
    int LEASH_Z;
    EntityTFNagaSegment[] body;
    protected PathEntity field_70786_d;
    protected Entity targetEntity;
    int circleCount;
    int intimidateTimer;
    int crumblePlayerTimer;
    int chargeCount;
    boolean clockwise;
    public int ticksSinceDamaged;
    
    public EntityTFNaga(final World world) {
        super(world);
        this.currentSegments = 0;
        this.LEASH_X = 46;
        this.LEASH_Y = 7;
        this.LEASH_Z = 46;
        this.ticksSinceDamaged = 0;
        this.func_70105_a(1.75f, 3.0f);
        this.field_70138_W = 2.0f;
        this.func_70606_j(this.func_110138_aP());
        this.segmentHealth = this.func_110138_aP() / 10.0f;
        this.setSegmentsPerHealth();
        this.field_70728_aV = 217;
        this.field_70158_ak = true;
        this.circleCount = 15;
        this.body = new EntityTFNagaSegment[EntityTFNaga.MAX_SEGMENTS];
        for (int i = 0; i < this.body.length; ++i) {
            world.func_72838_d((Entity)(this.body[i] = new EntityTFNagaSegment(this, i)));
        }
        this.goNormal();
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    public float getMaxHealthPerDifficulty() {
        if (this.field_70170_p == null) {
            return 200.0f;
        }
        switch (this.field_70170_p.field_73013_u) {
            default: {
                return 200.0f;
            }
            case 1: {
                return 120.0f;
            }
            case 3: {
                return 250.0f;
            }
        }
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.getMaxHealthPerDifficulty());
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(2.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(6.0);
    }
    
    protected int setSegmentsPerHealth() {
        final int oldSegments = this.currentSegments;
        int newSegments = (int)(this.func_110143_aJ() / this.segmentHealth + ((this.func_110143_aJ() > 0.0f) ? 2 : 0));
        if (newSegments < 0) {
            newSegments = 0;
        }
        if (newSegments > EntityTFNaga.MAX_SEGMENTS) {
            newSegments = EntityTFNaga.MAX_SEGMENTS;
        }
        if (newSegments != oldSegments) {
            if (newSegments < oldSegments) {
                for (int i = newSegments; i < oldSegments; ++i) {
                    if (this.body != null && this.body[i] != null) {
                        this.body[i].selfDestruct();
                    }
                }
            }
            else {
                this.spawnBodySegments();
            }
        }
        this.currentSegments = newSegments;
        this.setMovementFactorPerSegments();
        return this.currentSegments;
    }
    
    protected void setMovementFactorPerSegments() {
        final float movementFactor = 0.6f - this.currentSegments / 12.0f * 0.2f;
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)movementFactor);
    }
    
    public boolean func_70041_e_() {
        return false;
    }
    
    public boolean func_70058_J() {
        return false;
    }
    
    public void func_70071_h_() {
        this.despawnIfInvalid();
        if (this.field_70725_aQ > 0) {
            for (int k = 0; k < 5; ++k) {
                final double d = this.field_70146_Z.nextGaussian() * 0.02;
                final double d2 = this.field_70146_Z.nextGaussian() * 0.02;
                final double d3 = this.field_70146_Z.nextGaussian() * 0.02;
                final String explosionType = this.field_70146_Z.nextBoolean() ? "hugeexplosion" : "explode";
                this.field_70170_p.func_72869_a(explosionType, this.field_70165_t + this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f - this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextFloat() * this.field_70131_O, this.field_70161_v + this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f - this.field_70130_N, d, d2, d3);
            }
        }
        ++this.ticksSinceDamaged;
        if (!this.field_70170_p.field_72995_K && this.ticksSinceDamaged > EntityTFNaga.TICKS_BEFORE_HEALING && this.ticksSinceDamaged % 20 == 0) {
            this.func_70691_i(1.0f);
        }
        this.setSegmentsPerHealth();
        super.func_70071_h_();
        this.moveSegments();
        for (int i = 0; i < this.body.length; ++i) {
            if (!this.body[i].field_70175_ag && !this.field_70170_p.field_72995_K) {
                this.field_70170_p.func_72838_d((Entity)this.body[i]);
            }
        }
    }
    
    protected void func_70619_bc() {
        super.func_70619_bc();
        if (this.field_70123_F && this.hasTarget()) {
            this.breakNearbyBlocks();
        }
        if (this.targetEntity != null && !this.isEntityWithinHomeArea(this.targetEntity)) {
            this.targetEntity = null;
        }
        if (this.targetEntity == null) {
            this.targetEntity = this.findTarget();
            if (this.targetEntity != null) {
                this.acquireNewPath();
            }
        }
        else if (!this.targetEntity.func_70089_S()) {
            this.targetEntity = null;
        }
        else {
            final float targetDistance = this.targetEntity.func_70032_d((Entity)this);
            if (targetDistance > 80.0f) {
                this.targetEntity = null;
            }
            else if (this.func_70685_l(this.targetEntity)) {
                this.func_70785_a(this.targetEntity, targetDistance);
            }
        }
        if (!this.func_70781_l()) {
            this.acquireNewPath();
        }
        final boolean inWater = this.func_70090_H();
        final boolean inLava = this.func_70058_J();
        Vec3 vec3d = this.func_70781_l() ? this.field_70786_d.func_75878_a((Entity)this) : null;
        final double d = this.field_70130_N * 4.0f;
        while (vec3d != null && vec3d.func_72445_d(this.field_70165_t, vec3d.field_72448_b, this.field_70161_v) < d * d) {
            this.field_70786_d.func_75875_a();
            if (this.field_70786_d.func_75879_b()) {
                vec3d = null;
                this.field_70786_d = null;
            }
            else {
                vec3d = this.field_70786_d.func_75878_a((Entity)this);
            }
        }
        this.field_70703_bu = false;
        if (vec3d != null) {
            final double d2 = vec3d.field_72450_a - this.field_70165_t;
            final double d3 = vec3d.field_72449_c - this.field_70161_v;
            final double dist = MathHelper.func_76133_a(d2 * d2 + d3 * d3);
            final int i = MathHelper.func_76128_c(this.field_70121_D.field_72338_b + 0.5);
            final double d4 = vec3d.field_72448_b - i;
            final float f2 = (float)(Math.atan2(d3, d2) * 180.0 / 3.1415927410125732) - 90.0f;
            float f3 = f2 - this.field_70177_z;
            this.field_70701_bs = this.getMoveSpeed();
            this.func_70659_e(0.5f);
            if (dist > 4.0 && this.chargeCount == 0) {
                this.field_70702_br = MathHelper.func_76134_b(this.field_70173_aa * 0.3f) * this.getMoveSpeed() * 0.6f;
            }
            while (f3 < -180.0f) {
                f3 += 360.0f;
            }
            while (f3 >= 180.0f) {
                f3 -= 360.0f;
            }
            if (f3 > 30.0f) {
                f3 = 30.0f;
            }
            if (f3 < -30.0f) {
                f3 = -30.0f;
            }
            this.field_70177_z += f3;
            if (d4 > 0.6) {
                this.field_70703_bu = true;
            }
        }
        if (this.intimidateTimer > 0 && this.hasTarget()) {
            this.func_70625_a(this.targetEntity, 30.0f, 30.0f);
            this.field_70701_bs = 0.1f;
        }
        if (this.intimidateTimer > 0 && this.hasTarget()) {
            this.func_70625_a(this.targetEntity, 30.0f, 30.0f);
            this.field_70701_bs = 0.1f;
        }
        if (this.field_70146_Z.nextFloat() < 0.8f && (inWater || inLava)) {
            this.field_70703_bu = true;
        }
    }
    
    private float getMoveSpeed() {
        return 0.5f;
    }
    
    private void setMoveSpeed(final float f) {
        this.func_70659_e(f);
    }
    
    protected void breakNearbyBlocks() {
        final int minx = MathHelper.func_76128_c(this.field_70121_D.field_72340_a - 0.5);
        final int miny = MathHelper.func_76128_c(this.field_70121_D.field_72338_b + 1.01);
        final int minz = MathHelper.func_76128_c(this.field_70121_D.field_72339_c - 0.5);
        final int maxx = MathHelper.func_76128_c(this.field_70121_D.field_72336_d + 0.5);
        final int maxy = MathHelper.func_76128_c(this.field_70121_D.field_72337_e + 0.001);
        final int maxz = MathHelper.func_76128_c(this.field_70121_D.field_72334_f + 0.5);
        if (this.field_70170_p.func_72904_c(minx, miny, minz, maxx, maxy, maxz)) {
            for (int dx = minx; dx <= maxx; ++dx) {
                for (int dy = miny; dy <= maxy; ++dy) {
                    for (int dz = minz; dz <= maxz; ++dz) {
                        final int i5 = this.field_70170_p.func_72798_a(dx, dy, dz);
                        if (i5 > 0) {
                            this.breakBlock(dx, dy, dz);
                        }
                    }
                }
            }
        }
    }
    
    protected String func_70639_aQ() {
        return (this.field_70146_Z.nextInt(3) != 0) ? "TwilightForest:mob.naga.hiss" : "TwilightForest:mob.naga.rattle";
    }
    
    protected String func_70621_aR() {
        return "TwilightForest:mob.naga.hurt";
    }
    
    protected String func_70673_aS() {
        return "TwilightForest:mob.naga.hurt";
    }
    
    protected void acquireNewPath() {
        if (!this.hasTarget()) {
            this.wanderRandomly();
            return;
        }
        if (this.intimidateTimer > 0) {
            this.field_70786_d = null;
            --this.intimidateTimer;
            if (this.intimidateTimer == 0) {
                this.clockwise = !this.clockwise;
                if (this.targetEntity.field_70121_D.field_72338_b > this.field_70121_D.field_72337_e) {
                    this.doCrumblePlayer();
                }
                else {
                    this.doCharge();
                }
            }
            return;
        }
        if (this.crumblePlayerTimer > 0) {
            this.field_70786_d = null;
            --this.crumblePlayerTimer;
            this.crumbleBelowTarget(2);
            this.crumbleBelowTarget(3);
            if (this.crumblePlayerTimer == 0) {
                this.doCharge();
            }
        }
        if (this.chargeCount > 0) {
            --this.chargeCount;
            final Vec3 tpoint = this.findCirclePoint(this.targetEntity, 14.0, 3.141592653589793);
            this.field_70786_d = this.field_70170_p.func_72844_a((Entity)this, MathHelper.func_76128_c(tpoint.field_72450_a), MathHelper.func_76128_c(tpoint.field_72448_b), MathHelper.func_76128_c(tpoint.field_72449_c), 40.0f, true, true, true, true);
            if (this.chargeCount == 0) {
                this.doCircle();
            }
        }
        if (this.circleCount > 0) {
            --this.circleCount;
            double radius = (this.circleCount % 2 == 0) ? 12.0 : 14.0;
            double rotation = 1.0;
            if (this.circleCount > 1 && this.circleCount < 3) {
                radius = 16.0;
            }
            if (this.circleCount == 1) {
                rotation = 0.1;
            }
            final Vec3 tpoint2 = this.findCirclePoint(this.targetEntity, radius, rotation);
            this.field_70786_d = this.field_70170_p.func_72844_a((Entity)this, (int)tpoint2.field_72450_a, (int)tpoint2.field_72448_b, (int)tpoint2.field_72449_c, 40.0f, true, true, true, true);
            if (this.circleCount == 0) {
                this.doIntimidate();
            }
        }
    }
    
    protected void crumbleBelowTarget(final int range) {
        final int floor = (int)this.field_70121_D.field_72338_b;
        final int targetY = (int)this.targetEntity.field_70121_D.field_72338_b;
        if (targetY > floor) {
            final int dx = (int)this.targetEntity.field_70165_t + this.field_70146_Z.nextInt(range) - this.field_70146_Z.nextInt(range);
            final int dz = (int)this.targetEntity.field_70161_v + this.field_70146_Z.nextInt(range) - this.field_70146_Z.nextInt(range);
            int dy = targetY - this.field_70146_Z.nextInt(range) + this.field_70146_Z.nextInt((range > 1) ? (range - 1) : range);
            if (dy <= floor) {
                dy = targetY;
            }
            if (this.field_70170_p.func_72798_a(dx, dy, dz) != 0) {
                this.breakBlock(dx, dy, dz);
                for (int k = 0; k < 20; ++k) {
                    final double d = this.field_70146_Z.nextGaussian() * 0.02;
                    final double d2 = this.field_70146_Z.nextGaussian() * 0.02;
                    final double d3 = this.field_70146_Z.nextGaussian() * 0.02;
                    this.field_70170_p.func_72869_a("crit", this.field_70165_t + this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f - this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextFloat() * this.field_70131_O, this.field_70161_v + this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f - this.field_70130_N, d, d2, d3);
                }
            }
        }
    }
    
    protected void breakBlock(final int dx, final int dy, final int dz) {
        final int whatsThere = this.field_70170_p.func_72798_a(dx, dy, dz);
        final int whatsMeta = this.field_70170_p.func_72805_g(dx, dy, dz);
        if (whatsThere > 0) {
            Block.field_71973_m[whatsThere].func_71897_c(this.field_70170_p, dx, dy, dz, whatsMeta, 0);
            this.field_70170_p.func_72832_d(dx, dy, dz, 0, 0, 2);
            this.field_70170_p.func_72926_e(2001, dx, dy, dz, whatsThere + (whatsMeta << 12));
        }
    }
    
    protected void doCircle() {
        this.circleCount += 10 + this.field_70146_Z.nextInt(10);
        this.goNormal();
    }
    
    protected void doCrumblePlayer() {
        this.crumblePlayerTimer = 20 + this.field_70146_Z.nextInt(20);
        this.goSlow();
    }
    
    protected void doCharge() {
        this.chargeCount = 4;
        this.goFast();
    }
    
    protected void doIntimidate() {
        this.intimidateTimer += 15 + this.field_70146_Z.nextInt(10);
        this.goSlow();
    }
    
    protected void goSlow() {
        this.field_70702_br = 0.0f;
        this.setMoveSpeed(0.1f);
        this.field_70786_d = null;
    }
    
    protected void goNormal() {
        this.setMoveSpeed(0.6f);
    }
    
    protected void goFast() {
        this.setMoveSpeed(1.0f);
    }
    
    public boolean func_70104_M() {
        return false;
    }
    
    protected Vec3 findCirclePoint(final Entity toCircle, final double radius, final double rotation) {
        final double vecx = this.field_70165_t - toCircle.field_70165_t;
        final double vecz = this.field_70161_v - toCircle.field_70161_v;
        float rangle = (float)Math.atan2(vecz, vecx);
        rangle += (float)(this.clockwise ? rotation : (-rotation));
        final double dx = MathHelper.func_76134_b(rangle) * radius;
        final double dz = MathHelper.func_76126_a(rangle) * radius;
        final double dy = Math.min(this.field_70121_D.field_72338_b, toCircle.field_70163_u);
        return this.field_70170_p.func_82732_R().func_72345_a(toCircle.field_70165_t + dx, dy, toCircle.field_70161_v + dz);
    }
    
    public boolean hasTarget() {
        return this.targetEntity != null;
    }
    
    protected Entity findTarget() {
        final EntityPlayer entityplayer = this.field_70170_p.func_72856_b((Entity)this, 32.0);
        if (entityplayer != null && this.func_70685_l((Entity)entityplayer) && this.isEntityWithinHomeArea((Entity)entityplayer)) {
            return (Entity)entityplayer;
        }
        return null;
    }
    
    public boolean func_70097_a(final DamageSource damagesource, final float i) {
        if (damagesource.func_76364_f() != null && !this.isEntityWithinHomeArea(damagesource.func_76364_f())) {
            return false;
        }
        if (damagesource.func_76346_g() != null && !this.isEntityWithinHomeArea(damagesource.func_76346_g())) {
            return false;
        }
        if (super.func_70097_a(damagesource, i)) {
            this.setSegmentsPerHealth();
            final Entity entity = damagesource.func_76346_g();
            if (entity != this) {
                this.targetEntity = entity;
            }
            this.ticksSinceDamaged = 0;
            return true;
        }
        return false;
    }
    
    protected void func_70785_a(final Entity toAttack, final float f) {
        if (this.field_70724_aR <= 0 && f < 4.0f && toAttack.field_70121_D.field_72337_e > this.field_70121_D.field_72338_b - 2.5 && toAttack.field_70121_D.field_72338_b < this.field_70121_D.field_72337_e + 2.5) {
            this.field_70724_aR = 20;
            this.func_70652_k(toAttack);
            if (this.getMoveSpeed() > 0.8) {
                toAttack.func_70024_g((double)(-MathHelper.func_76126_a(this.field_70177_z * 3.141593f / 180.0f) * 1.0f), 0.1, (double)(MathHelper.func_76134_b(this.field_70177_z * 3.141593f / 180.0f) * 1.0f));
            }
        }
    }
    
    protected void wanderRandomly() {
        this.goNormal();
        boolean flag = false;
        int tx = -1;
        int ty = -1;
        int tz = -1;
        float worstweight = -99999.0f;
        for (int l = 0; l < 10; ++l) {
            int dx = MathHelper.func_76128_c(this.field_70165_t + this.field_70146_Z.nextInt(21) - 6.0);
            int dy = MathHelper.func_76128_c(this.field_70163_u + this.field_70146_Z.nextInt(7) - 3.0);
            int dz = MathHelper.func_76128_c(this.field_70161_v + this.field_70146_Z.nextInt(21) - 6.0);
            if (!this.isWithinHomeDistance(dx, dy, dz)) {
                dx = this.func_110172_bL().field_71574_a + this.field_70146_Z.nextInt(21) - this.field_70146_Z.nextInt(21);
                dy = this.func_110172_bL().field_71572_b + this.field_70146_Z.nextInt(7) - this.field_70146_Z.nextInt(7);
                dz = this.func_110172_bL().field_71573_c + this.field_70146_Z.nextInt(21) - this.field_70146_Z.nextInt(21);
            }
            final float weight = this.func_70783_a(dx, dy, dz);
            if (weight > worstweight) {
                worstweight = weight;
                tx = dx;
                ty = dy;
                tz = dz;
                flag = true;
            }
        }
        if (flag) {
            this.field_70786_d = this.field_70170_p.func_72844_a((Entity)this, tx, ty, tz, 80.0f, true, true, true, true);
        }
    }
    
    public float func_70783_a(final int i, final int j, final int k) {
        if (!this.isWithinHomeDistance(i, j, k)) {
            return Float.MIN_VALUE;
        }
        return 0.0f;
    }
    
    public boolean func_70781_l() {
        return this.field_70786_d != null;
    }
    
    protected int func_70633_aT() {
        return TFItems.nagaScale.field_77779_bT;
    }
    
    protected void func_70628_a(final boolean flag, final int z) {
        final int i = this.func_70633_aT();
        if (i > 0) {
            for (int j = 6 + this.field_70146_Z.nextInt(6), k = 0; k < j; ++k) {
                this.func_70025_b(i, 1);
            }
        }
        this.func_70099_a(new ItemStack(TFItems.trophy, 1, 1), 0.0f);
    }
    
    protected void despawnIfInvalid() {
        if (!this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u == 0) {
            this.despawnMe();
        }
    }
    
    protected void despawnMe() {
        if (this.isLeashed()) {
            final ChunkCoordinates home = this.func_110172_bL();
            this.field_70170_p.func_72832_d(home.field_71574_a, home.field_71572_b, home.field_71573_c, TFBlocks.bossSpawner.field_71990_ca, 0, 2);
        }
        this.func_70106_y();
    }
    
    public boolean isLeashed() {
        return this.getMaximumHomeDistance() > -1.0f;
    }
    
    public boolean isWithinHomeDistance(final int x, final int y, final int z) {
        if (this.getMaximumHomeDistance() == -1.0f) {
            return true;
        }
        final int distX = Math.abs(this.func_110172_bL().field_71574_a - x);
        final int distY = Math.abs(this.func_110172_bL().field_71572_b - y);
        final int distZ = Math.abs(this.func_110172_bL().field_71573_c - z);
        return distX <= this.LEASH_X && distY <= this.LEASH_Y && distZ <= this.LEASH_Z;
    }
    
    public boolean isEntityWithinHomeArea(final Entity entity) {
        return this.isWithinHomeDistance(MathHelper.func_76128_c(entity.field_70165_t), MathHelper.func_76128_c(entity.field_70163_u), MathHelper.func_76128_c(entity.field_70161_v));
    }
    
    protected void spawnBodySegments() {
        if (!this.field_70170_p.field_72995_K) {
            if (this.body == null) {
                this.body = new EntityTFNagaSegment[EntityTFNaga.MAX_SEGMENTS];
            }
            for (int i = 0; i < this.currentSegments; ++i) {
                if (this.body[i] == null || this.body[i].field_70128_L) {
                    (this.body[i] = new EntityTFNagaSegment(this, i)).func_70012_b(this.field_70165_t + 0.1 * i, this.field_70163_u + 0.5, this.field_70161_v + 0.1 * i, this.field_70146_Z.nextFloat() * 360.0f, 0.0f);
                    this.field_70170_p.func_72838_d((Entity)this.body[i]);
                }
            }
        }
    }
    
    protected void moveSegments() {
        for (int i = 0; i < this.currentSegments; ++i) {
            Entity leader;
            if (i == 0) {
                leader = (Entity)this;
            }
            else {
                leader = this.body[i - 1];
            }
            final double followX = leader.field_70165_t;
            final double followY = leader.field_70163_u;
            final double followZ = leader.field_70161_v;
            final float angle = (leader.field_70177_z + 180.0f) * 3.141593f / 180.0f;
            final double straightenForce = 0.05 + 1.0 / (float)(i + 1) * 0.5;
            final double idealX = -MathHelper.func_76126_a(angle) * straightenForce;
            final double idealZ = MathHelper.func_76134_b(angle) * straightenForce;
            Vec3 diff = this.field_70170_p.func_82732_R().func_72345_a(this.body[i].field_70165_t - followX, this.body[i].field_70163_u - followY, this.body[i].field_70161_v - followZ);
            diff = diff.func_72432_b();
            diff = diff.func_72441_c(idealX, 0.0, idealZ);
            diff = diff.func_72432_b();
            final double f = 2.0;
            final double destX = followX + f * diff.field_72450_a;
            final double destY = followY + f * diff.field_72448_b;
            final double destZ = followZ + f * diff.field_72449_c;
            this.body[i].func_70107_b(destX, destY, destZ);
            this.body[i].field_70159_w = f * diff.field_72450_a;
            this.body[i].field_70181_x = f * diff.field_72448_b;
            this.body[i].field_70179_y = f * diff.field_72449_c;
            final double distance = MathHelper.func_76133_a(diff.field_72450_a * diff.field_72450_a + diff.field_72449_c * diff.field_72449_c);
            if (i == 0) {
                final Vec3 vec3 = diff;
                vec3.field_72448_b -= 0.15;
            }
            this.body[i].func_70101_b((float)(Math.atan2(diff.field_72449_c, diff.field_72450_a) * 180.0 / 3.141592653589793) + 90.0f, -(float)(Math.atan2(diff.field_72448_b, distance) * 180.0 / 3.141592653589793));
        }
    }
    
    public void func_70014_b(final NBTTagCompound nbttagcompound) {
        final ChunkCoordinates home = this.func_110172_bL();
        nbttagcompound.func_74782_a("Home", (NBTBase)this.func_70087_a(new double[] { home.field_71574_a, home.field_71572_b, home.field_71573_c }));
        nbttagcompound.func_74757_a("HasHome", this.func_110175_bO());
        super.func_70014_b(nbttagcompound);
    }
    
    public void func_70037_a(final NBTTagCompound nbttagcompound) {
        super.func_70037_a(nbttagcompound);
        final NBTTagList homelist = nbttagcompound.func_74761_m("Home");
        this.func_110171_b((int)((NBTTagDouble)homelist.func_74743_b(0)).field_74755_a, (int)((NBTTagDouble)homelist.func_74743_b(1)).field_74755_a, (int)((NBTTagDouble)homelist.func_74743_b(2)).field_74755_a, this.LEASH_X);
        if (!nbttagcompound.func_74767_n("HasHome")) {
            this.func_110177_bN();
        }
        this.setSegmentsPerHealth();
    }
    
    public void func_70645_a(final DamageSource par1DamageSource) {
        super.func_70645_a(par1DamageSource);
        if (par1DamageSource.func_76364_f() instanceof EntityPlayer) {
            ((EntityPlayer)par1DamageSource.func_76364_f()).func_71029_a((StatBase)TFAchievementPage.twilightHunter);
            ((EntityPlayer)par1DamageSource.func_76364_f()).func_71029_a((StatBase)TFAchievementPage.twilightNaga);
        }
    }
    
    public World func_82194_d() {
        return this.field_70170_p;
    }
    
    public boolean func_70965_a(final EntityDragonPart entitydragonpart, final DamageSource damagesource, final float i) {
        return false;
    }
    
    public Entity[] func_70021_al() {
        return this.body;
    }
    
    public float getMaximumHomeDistance() {
        return this.func_110174_bM();
    }
    
    static {
        EntityTFNaga.TICKS_BEFORE_HEALING = 600;
        EntityTFNaga.MAX_SEGMENTS = 12;
    }
}
