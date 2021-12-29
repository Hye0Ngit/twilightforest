// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import java.util.Iterator;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.enchantment.EnchantmentThorns;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.Vec3;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import java.util.Random;
import twilightforest.TFTreasure;
import java.util.List;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import twilightforest.item.TFItems;
import net.minecraft.world.World;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.EntityFlying;

public class EntityTFKnightPhantom extends EntityFlying implements IMob
{
    private static final float CIRCLE_SMALL_RADIUS = 2.5f;
    private static final float CIRCLE_LARGE_RADIUS = 8.5f;
    private static final int FLAG_CHARGING = 17;
    int number;
    int ticksProgress;
    Formation currentFormation;
    private ChunkCoordinates homePosition;
    private float maximumHomeDistance;
    private int chargePosX;
    private int chargePosY;
    private int chargePosZ;
    
    public EntityTFKnightPhantom(final World par1World) {
        super(par1World);
        this.homePosition = new ChunkCoordinates(0, 0, 0);
        this.maximumHomeDistance = -1.0f;
        this.func_70105_a(1.5f, 3.0f);
        this.field_70145_X = true;
        this.field_70178_ae = true;
        this.currentFormation = Formation.HOVER;
        this.field_70728_aV = 93;
        this.func_70062_b(0, new ItemStack(TFItems.knightlySword));
        this.func_70062_b(3, new ItemStack(TFItems.phantomPlate));
        this.func_70062_b(4, new ItemStack(TFItems.phantomHelm));
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(17, (Object)0);
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(35.0);
        this.func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
    }
    
    protected boolean func_70692_ba() {
        return false;
    }
    
    public boolean func_70097_a(final DamageSource par1DamageSource, final float par2) {
        return !this.func_85032_ar() && par1DamageSource != DamageSource.field_76368_d && super.func_70097_a(par1DamageSource, par2);
    }
    
    public void func_70636_d() {
        super.func_70636_d();
        if (this.isChargingAtPlayer()) {
            for (int i = 0; i < 4; ++i) {
                final int particleID = this.field_70146_Z.nextBoolean() ? TFItems.phantomHelm.field_77779_bT : TFItems.knightlySword.field_77779_bT;
                this.field_70170_p.func_72869_a("iconcrack_" + particleID, this.field_70165_t + (this.field_70146_Z.nextFloat() * this.field_70146_Z.nextFloat() - 0.5) * this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextFloat() * (this.field_70131_O - 0.75) + 0.5, this.field_70161_v + (this.field_70146_Z.nextFloat() * this.field_70146_Z.nextFloat() - 0.5) * this.field_70130_N, 0.0, -0.1, 0.0);
                this.field_70170_p.func_72869_a("smoke", this.field_70165_t + (this.field_70146_Z.nextFloat() * this.field_70146_Z.nextFloat() - 0.5) * this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextFloat() * (this.field_70131_O - 0.75) + 0.5, this.field_70161_v + (this.field_70146_Z.nextFloat() * this.field_70146_Z.nextFloat() - 0.5) * this.field_70130_N, 0.0, 0.1, 0.0);
            }
        }
    }
    
    protected void func_70609_aI() {
        super.func_70609_aI();
        for (int i = 0; i < 20; ++i) {
            final double d0 = this.field_70146_Z.nextGaussian() * 0.02;
            final double d2 = this.field_70146_Z.nextGaussian() * 0.02;
            final double d3 = this.field_70146_Z.nextGaussian() * 0.02;
            this.field_70170_p.func_72869_a("explode", this.field_70165_t + this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f - this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextFloat() * this.field_70131_O, this.field_70161_v + this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f - this.field_70130_N, d0, d2, d3);
        }
        if (this.field_70725_aQ == 20 && !this.field_70170_p.field_72995_K) {
            final List<EntityTFKnightPhantom> nearbyKnights = this.getNearbyKnights();
            if (nearbyKnights.size() <= 1) {
                this.makeATreasure();
            }
        }
    }
    
    private void makeATreasure() {
        TFTreasure.stronghold_boss.generate(this.field_70170_p, null, this.getHomePosition().field_71574_a, this.getHomePosition().field_71572_b - 1, this.getHomePosition().field_71573_c);
    }
    
    protected void func_70626_be() {
        if (!this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u == 0) {
            this.func_70106_y();
        }
        this.func_70623_bb();
        this.field_70145_X = (this.ticksProgress % 20 != 0);
        ++this.ticksProgress;
        if (this.ticksProgress >= this.getMaxTicksForFormation()) {
            this.switchToNextFormation();
        }
        final float seekRange = this.isChargingAtPlayer() ? 24.0f : 9.0f;
        final EntityPlayer target = this.field_70170_p.func_72856_b((Entity)this, (double)seekRange);
        if (target != null && this.currentFormation == Formation.ATTACK_PLAYER_START) {
            final int targetX = MathHelper.func_76128_c(target.field_70142_S);
            final int targetY = MathHelper.func_76128_c(target.field_70137_T);
            final int targetZ = MathHelper.func_76128_c(target.field_70136_U);
            if (this.isWithinHomeArea(targetX, targetY, targetZ)) {
                this.chargePosX = targetX;
                this.chargePosY = targetY;
                this.chargePosZ = targetZ;
            }
            else {
                this.chargePosX = this.getHomePosition().field_71574_a;
                this.chargePosY = this.getHomePosition().field_71572_b;
                this.chargePosZ = this.getHomePosition().field_71573_c;
            }
        }
        final Vec3 dest = this.getDestination();
        final double moveX = dest.field_72450_a - this.field_70165_t;
        final double moveY = dest.field_72448_b - this.field_70163_u;
        final double moveZ = dest.field_72449_c - this.field_70161_v;
        double factor = moveX * moveX + moveY * moveY + moveZ * moveZ;
        factor = MathHelper.func_76133_a(factor);
        final double speed = 0.1;
        this.field_70159_w += moveX / factor * speed;
        this.field_70181_x += moveY / factor * speed;
        this.field_70179_y += moveZ / factor * speed;
        if (target != null) {
            this.func_70625_a((Entity)target, 10.0f, 500.0f);
            if (target.func_70089_S()) {
                final float f1 = target.func_70032_d((Entity)this);
                if (this.func_70685_l((Entity)target)) {
                    this.attackEntity((Entity)target, f1);
                }
            }
            if (this.isAxeKnight() && this.currentFormation == Formation.ATTACK_PLAYER_ATTACK && this.ticksProgress % 4 == 0) {
                this.launchAxeAt((Entity)target);
            }
            if (this.isPickKnight() && this.currentFormation == Formation.ATTACK_PLAYER_ATTACK && this.ticksProgress % 4 == 0) {
                this.launchPicks();
            }
        }
    }
    
    protected void attackEntity(final Entity par1Entity, final float par2) {
        if (this.field_70724_aR <= 0 && par2 < 2.0f && par1Entity.field_70121_D.field_72337_e > this.field_70121_D.field_72338_b && par1Entity.field_70121_D.field_72338_b < this.field_70121_D.field_72337_e) {
            this.field_70724_aR = 20;
            this.func_70652_k(par1Entity);
        }
    }
    
    public boolean func_70652_k(final Entity par1Entity) {
        float f = this.getAttackDamage();
        int i = 0;
        if (par1Entity instanceof EntityLivingBase) {
            f += EnchantmentHelper.func_77512_a((EntityLivingBase)this, (EntityLivingBase)par1Entity);
            i += EnchantmentHelper.func_77507_b((EntityLivingBase)this, (EntityLivingBase)par1Entity);
        }
        final boolean flag = par1Entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), f);
        if (flag) {
            if (i > 0) {
                par1Entity.func_70024_g((double)(-MathHelper.func_76126_a(this.field_70177_z * 3.1415927f / 180.0f) * i * 0.5f), 0.1, (double)(MathHelper.func_76134_b(this.field_70177_z * 3.1415927f / 180.0f) * i * 0.5f));
                this.field_70159_w *= 0.6;
                this.field_70179_y *= 0.6;
            }
            final int j = EnchantmentHelper.func_90036_a((EntityLivingBase)this);
            if (j > 0) {
                par1Entity.func_70015_d(j * 4);
            }
            if (par1Entity instanceof EntityLivingBase) {
                EnchantmentThorns.func_92096_a((Entity)this, (EntityLivingBase)par1Entity, this.field_70146_Z);
            }
        }
        return flag;
    }
    
    private float getAttackDamage() {
        float damage = (float)this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
        if (this.isChargingAtPlayer()) {
            damage += 7.0f;
        }
        return damage;
    }
    
    protected void launchAxeAt(final Entity targetedEntity) {
        final float bodyFacingAngle = this.field_70761_aq * 3.141593f / 180.0f;
        final double sx = this.field_70165_t + MathHelper.func_76134_b(bodyFacingAngle) * 1.0f;
        final double sy = this.field_70163_u + this.field_70131_O * 0.82;
        final double sz = this.field_70161_v + MathHelper.func_76126_a(bodyFacingAngle) * 1.0f;
        final double tx = targetedEntity.field_70165_t - sx;
        final double ty = targetedEntity.field_70121_D.field_72338_b + targetedEntity.field_70131_O / 2.0f - (this.field_70163_u + this.field_70131_O / 2.0f);
        final double tz = targetedEntity.field_70161_v - sz;
        this.field_70170_p.func_72956_a((Entity)this, "random.bow", this.func_70599_aP(), (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f + 0.4f);
        final EntityTFThrownAxe projectile = new EntityTFThrownAxe(this.field_70170_p, (EntityLivingBase)this);
        final float speed = 0.75f;
        projectile.func_70186_c(tx, ty, tz, speed, 1.0f);
        projectile.func_70012_b(sx, sy, sz, this.field_70177_z, this.field_70125_A);
        this.field_70170_p.func_72838_d((Entity)projectile);
    }
    
    protected void launchPicks() {
        this.field_70170_p.func_72956_a((Entity)this, "random.bow", this.func_70599_aP(), (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2f + 0.4f);
        for (int i = 0; i < 8; ++i) {
            final float throwAngle = i * 3.1415915f / 4.0f;
            final double sx = this.field_70165_t + MathHelper.func_76134_b(throwAngle) * 1.0f;
            final double sy = this.field_70163_u + this.field_70131_O * 0.82;
            final double sz = this.field_70161_v + MathHelper.func_76126_a(throwAngle) * 1.0f;
            final double vx = MathHelper.func_76134_b(throwAngle);
            final double vy = 0.0;
            final double vz = MathHelper.func_76126_a(throwAngle);
            final EntityTFThrownPick projectile = new EntityTFThrownPick(this.field_70170_p, (EntityLivingBase)this);
            projectile.func_70012_b(sx, sy, sz, i * 45.0f, this.field_70125_A);
            final float speed = 0.5f;
            projectile.func_70186_c(vx, vy, vz, speed, 1.0f);
            this.field_70170_p.func_72838_d((Entity)projectile);
        }
    }
    
    public boolean func_70104_M() {
        return true;
    }
    
    public void func_70653_a(final Entity par1Entity, final float damage, final double par3, final double par5) {
        this.field_70160_al = true;
        final float f = MathHelper.func_76133_a(par3 * par3 + par5 * par5);
        final float distance = 0.2f;
        this.field_70159_w /= 2.0;
        this.field_70181_x /= 2.0;
        this.field_70179_y /= 2.0;
        this.field_70159_w -= par3 / f * distance;
        this.field_70181_x += distance;
        this.field_70179_y -= par5 / f * distance;
        if (this.field_70181_x > 0.4000000059604645) {
            this.field_70181_x = 0.4000000059604645;
        }
    }
    
    public void switchToNextFormation() {
        final List<EntityTFKnightPhantom> nearbyKnights = this.getNearbyKnights();
        if (this.currentFormation == Formation.ATTACK_PLAYER_START) {
            this.switchToFormation(Formation.ATTACK_PLAYER_ATTACK);
        }
        else if (this.currentFormation == Formation.ATTACK_PLAYER_ATTACK) {
            if (nearbyKnights.size() > 1) {
                this.switchToFormation(Formation.WAITING_FOR_LEADER);
            }
            else {
                switch (this.field_70146_Z.nextInt(3)) {
                    case 0: {
                        this.func_70062_b(0, new ItemStack(TFItems.knightlySword));
                        break;
                    }
                    case 1: {
                        this.func_70062_b(0, new ItemStack(TFItems.knightlyAxe));
                        break;
                    }
                    case 2: {
                        this.func_70062_b(0, new ItemStack(TFItems.knightlyPick));
                        break;
                    }
                }
                this.switchToFormation(Formation.ATTACK_PLAYER_START);
            }
        }
        else if (this.currentFormation == Formation.WAITING_FOR_LEADER) {
            if (nearbyKnights.size() > 1) {
                this.switchToFormation(nearbyKnights.get(1).currentFormation);
                this.ticksProgress = nearbyKnights.get(1).ticksProgress;
            }
            else {
                this.switchToFormation(Formation.ATTACK_PLAYER_START);
            }
        }
        else if (this.isThisTheLeader(nearbyKnights)) {
            this.pickRandomFormation();
            this.broadcastMyFormation(nearbyKnights);
            if (this.isNobodyCharging(nearbyKnights)) {
                this.makeARandomKnightCharge(nearbyKnights);
            }
        }
    }
    
    private List<EntityTFKnightPhantom> getNearbyKnights() {
        final List<EntityTFKnightPhantom> nearbyKnights = this.field_70170_p.func_72872_a((Class)EntityTFKnightPhantom.class, AxisAlignedBB.func_72332_a().func_72299_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70165_t + 1.0, this.field_70163_u + 1.0, this.field_70161_v + 1.0).func_72314_b(32.0, 8.0, 32.0));
        return nearbyKnights;
    }
    
    protected void pickRandomFormation() {
        switch (this.field_70146_Z.nextInt(8)) {
            case 0: {
                this.currentFormation = Formation.SMALL_CLOCKWISE;
                break;
            }
            case 1: {
                this.currentFormation = Formation.SMALL_ANTICLOCKWISE;
                break;
            }
            case 2: {
                this.currentFormation = Formation.SMALL_ANTICLOCKWISE;
                break;
            }
            case 3: {
                this.currentFormation = Formation.CHARGE_PLUSX;
                break;
            }
            case 4: {
                this.currentFormation = Formation.CHARGE_MINUSX;
                break;
            }
            case 5: {
                this.currentFormation = Formation.CHARGE_PLUSZ;
                break;
            }
            case 6: {
                this.currentFormation = Formation.CHARGE_MINUSZ;
                break;
            }
            case 7: {
                this.currentFormation = Formation.SMALL_CLOCKWISE;
                break;
            }
        }
        this.switchToFormation(this.currentFormation);
    }
    
    private boolean isThisTheLeader(final List<EntityTFKnightPhantom> nearbyKnights) {
        boolean iAmTheLowest = true;
        for (final EntityTFKnightPhantom knight : nearbyKnights) {
            if (knight.getNumber() < this.getNumber()) {
                iAmTheLowest = false;
                break;
            }
        }
        return iAmTheLowest;
    }
    
    private boolean isNobodyCharging(final List<EntityTFKnightPhantom> nearbyKnights) {
        boolean noCharge = true;
        for (final EntityTFKnightPhantom knight : nearbyKnights) {
            if (knight.isChargingAtPlayer()) {
                noCharge = false;
                break;
            }
        }
        return noCharge;
    }
    
    private void makeARandomKnightCharge(final List<EntityTFKnightPhantom> nearbyKnights) {
        final int randomNum = this.field_70146_Z.nextInt(nearbyKnights.size());
        nearbyKnights.get(randomNum).switchToFormation(Formation.ATTACK_PLAYER_START);
    }
    
    private void broadcastMyFormation(final List<EntityTFKnightPhantom> nearbyKnights) {
        for (final EntityTFKnightPhantom knight : nearbyKnights) {
            if (!knight.isChargingAtPlayer()) {
                knight.switchToFormation(this.currentFormation);
            }
        }
    }
    
    public boolean isChargingAtPlayer() {
        return this.field_70180_af.func_75683_a(17) != 0;
    }
    
    public void setChargingAtPlayer(final boolean flag) {
        if (flag) {
            this.field_70180_af.func_75692_b(17, (Object)127);
        }
        else {
            this.field_70180_af.func_75692_b(17, (Object)0);
        }
    }
    
    protected String func_70639_aQ() {
        return "TwilightForest:mob.wraith.wraith";
    }
    
    protected String func_70621_aR() {
        return "TwilightForest:mob.wraith.wraith";
    }
    
    protected String func_70673_aS() {
        return "TwilightForest:mob.wraith.wraith";
    }
    
    private void switchToFormationByNumber(final int formationNumber) {
        this.currentFormation = Formation.values()[formationNumber];
        this.ticksProgress = 0;
    }
    
    public void switchToFormation(final Formation formation) {
        this.currentFormation = formation;
        this.ticksProgress = 0;
        this.setChargingAtPlayer(this.currentFormation == Formation.ATTACK_PLAYER_START || this.currentFormation == Formation.ATTACK_PLAYER_ATTACK);
    }
    
    public int getFormationAsNumber() {
        return this.currentFormation.ordinal();
    }
    
    public int getTicksProgress() {
        return this.ticksProgress;
    }
    
    public void setTicksProgress(final int ticksProgress) {
        this.ticksProgress = ticksProgress;
    }
    
    public int getMaxTicksForFormation() {
        switch (this.currentFormation) {
            default: {
                return 90;
            }
            case LARGE_CLOCKWISE: {
                return 180;
            }
            case SMALL_CLOCKWISE: {
                return 90;
            }
            case LARGE_ANTICLOCKWISE: {
                return 180;
            }
            case SMALL_ANTICLOCKWISE: {
                return 90;
            }
            case CHARGE_PLUSX: {
                return 180;
            }
            case CHARGE_MINUSX: {
                return 180;
            }
            case CHARGE_PLUSZ: {
                return 180;
            }
            case CHARGE_MINUSZ: {
                return 180;
            }
            case ATTACK_PLAYER_START: {
                return 50;
            }
            case ATTACK_PLAYER_ATTACK: {
                return 50;
            }
            case WAITING_FOR_LEADER: {
                return 10;
            }
        }
    }
    
    private Vec3 getDestination() {
        if (!this.hasHome()) {}
        switch (this.currentFormation) {
            case LARGE_CLOCKWISE: {
                return this.getCirclePosition(8.5f, true);
            }
            case SMALL_CLOCKWISE: {
                return this.getCirclePosition(2.5f, true);
            }
            case LARGE_ANTICLOCKWISE: {
                return this.getCirclePosition(8.5f, false);
            }
            case SMALL_ANTICLOCKWISE: {
                return this.getCirclePosition(2.5f, false);
            }
            case CHARGE_PLUSX: {
                return this.getMoveAcrossPosition(true, true);
            }
            case CHARGE_MINUSX: {
                return this.getMoveAcrossPosition(false, true);
            }
            case CHARGE_PLUSZ: {
                return this.getMoveAcrossPosition(true, false);
            }
            case HOVER:
            case ATTACK_PLAYER_START: {
                return this.getHoverPosition(8.5f);
            }
            case CHARGE_MINUSZ: {
                return this.getMoveAcrossPosition(false, false);
            }
            case WAITING_FOR_LEADER: {
                return this.getLoiterPosition();
            }
            case ATTACK_PLAYER_ATTACK: {
                return this.getAttackPlayerPosition();
            }
            default: {
                return this.getLoiterPosition();
            }
        }
    }
    
    private Vec3 getMoveAcrossPosition(final boolean plus, final boolean alongX) {
        final float offset0 = this.getNumber() * 3.0f - 7.5f;
        float offset2;
        if (this.ticksProgress < 60) {
            offset2 = -7.0f;
        }
        else {
            offset2 = -7.0f + (this.ticksProgress - 60) / 120.0f * 14.0f;
        }
        if (!plus) {
            offset2 *= -1.0f;
        }
        final double dx = this.getHomePosition().field_71574_a + (alongX ? offset0 : offset2);
        final double dy = this.getHomePosition().field_71572_b + Math.cos(this.ticksProgress / 7.0f + this.getNumber());
        final double dz = this.getHomePosition().field_71573_c + (alongX ? offset2 : offset0);
        return this.field_70170_p.func_82732_R().func_72345_a(dx, dy, dz);
    }
    
    protected Vec3 getCirclePosition(final float distance, final boolean clockwise) {
        float angle = this.ticksProgress * 2.0f;
        if (!clockwise) {
            angle *= -1.0f;
        }
        angle += 60.0f * this.getNumber();
        final double dx = this.getHomePosition().field_71574_a + Math.cos(angle * 3.141592653589793 / 180.0) * distance;
        final double dy = this.getHomePosition().field_71572_b + Math.cos(this.ticksProgress / 7.0f + this.getNumber());
        final double dz = this.getHomePosition().field_71573_c + Math.sin(angle * 3.141592653589793 / 180.0) * distance;
        return this.field_70170_p.func_82732_R().func_72345_a(dx, dy, dz);
    }
    
    private Vec3 getHoverPosition(final float distance) {
        double dx = this.field_70142_S;
        final double dy = this.getHomePosition().field_71572_b + Math.cos(this.ticksProgress / 7.0f + this.getNumber());
        double dz = this.field_70136_U;
        final double ox = this.getHomePosition().field_71574_a - dx;
        final double oz = this.getHomePosition().field_71573_c - dz;
        final double dDist = Math.sqrt(ox * ox + oz * oz);
        if (dDist > distance) {
            dx = this.getHomePosition().field_71574_a + ox / dDist * distance;
            dz = this.getHomePosition().field_71573_c + oz / dDist * distance;
        }
        return this.field_70170_p.func_82732_R().func_72345_a(dx, dy, dz);
    }
    
    private Vec3 getLoiterPosition() {
        final double dx = this.getHomePosition().field_71574_a;
        final double dy = this.getHomePosition().field_71572_b + Math.cos(this.ticksProgress / 7.0f + this.getNumber());
        final double dz = this.getHomePosition().field_71573_c;
        return this.field_70170_p.func_82732_R().func_72345_a(dx, dy, dz);
    }
    
    private Vec3 getAttackPlayerPosition() {
        if (this.isSwordKnight()) {
            return this.field_70170_p.func_82732_R().func_72345_a((double)this.chargePosX, (double)this.chargePosY, (double)this.chargePosZ);
        }
        return this.getHoverPosition(8.5f);
    }
    
    public boolean isSwordKnight() {
        return this.func_71124_b(0).field_77993_c == TFItems.knightlySword.field_77779_bT;
    }
    
    public boolean isAxeKnight() {
        return this.func_71124_b(0).field_77993_c == TFItems.knightlyAxe.field_77779_bT;
    }
    
    public boolean isPickKnight() {
        return this.func_71124_b(0).field_77993_c == TFItems.knightlyPick.field_77779_bT;
    }
    
    public int getNumber() {
        return this.number;
    }
    
    public void setNumber(final int number) {
        switch ((this.number = number) % 3) {
            case 0: {
                this.func_70062_b(0, new ItemStack(TFItems.knightlySword));
                break;
            }
            case 1: {
                this.func_70062_b(0, new ItemStack(TFItems.knightlyAxe));
                break;
            }
            case 2: {
                this.func_70062_b(0, new ItemStack(TFItems.knightlyPick));
                break;
            }
        }
    }
    
    public void func_70014_b(final NBTTagCompound nbttagcompound) {
        super.func_70014_b(nbttagcompound);
        final ChunkCoordinates home = this.getHomePosition();
        nbttagcompound.func_74782_a("Home", (NBTBase)this.func_70087_a(new double[] { home.field_71574_a, home.field_71572_b, home.field_71573_c }));
        nbttagcompound.func_74757_a("HasHome", this.hasHome());
        nbttagcompound.func_74768_a("MyNumber", this.getNumber());
        nbttagcompound.func_74768_a("Formation", this.getFormationAsNumber());
        nbttagcompound.func_74768_a("TicksProgress", this.getTicksProgress());
    }
    
    public void func_70037_a(final NBTTagCompound nbttagcompound) {
        super.func_70037_a(nbttagcompound);
        final NBTTagList homelist = nbttagcompound.func_74761_m("Home");
        this.setHomeArea((int)((NBTTagDouble)homelist.func_74743_b(0)).field_74755_a, (int)((NBTTagDouble)homelist.func_74743_b(1)).field_74755_a, (int)((NBTTagDouble)homelist.func_74743_b(2)).field_74755_a, 20);
        if (!nbttagcompound.func_74767_n("HasHome")) {
            this.detachHome();
        }
        this.setNumber(nbttagcompound.func_74762_e("MyNumber"));
        this.switchToFormationByNumber(nbttagcompound.func_74762_e("Formation"));
        this.setTicksProgress(nbttagcompound.func_74762_e("TicksProgress"));
    }
    
    public boolean isWithinHomeArea(final int par1, final int par2, final int par3) {
        return this.maximumHomeDistance == -1.0f || this.homePosition.func_71569_e(par1, par2, par3) < this.maximumHomeDistance * this.maximumHomeDistance;
    }
    
    public void setHomeArea(final int par1, final int par2, final int par3, final int par4) {
        this.homePosition.func_71571_b(par1, par2, par3);
        this.maximumHomeDistance = (float)par4;
    }
    
    public ChunkCoordinates getHomePosition() {
        return this.homePosition;
    }
    
    public float getMaximumHomeDistance() {
        return this.maximumHomeDistance;
    }
    
    public void detachHome() {
        this.maximumHomeDistance = -1.0f;
    }
    
    public boolean hasHome() {
        return this.maximumHomeDistance != -1.0f;
    }
    
    public enum Formation
    {
        HOVER, 
        LARGE_CLOCKWISE, 
        SMALL_CLOCKWISE, 
        LARGE_ANTICLOCKWISE, 
        SMALL_ANTICLOCKWISE, 
        CHARGE_PLUSX, 
        CHARGE_MINUSX, 
        CHARGE_PLUSZ, 
        CHARGE_MINUSZ, 
        WAITING_FOR_LEADER, 
        ATTACK_PLAYER_START, 
        ATTACK_PLAYER_ATTACK;
    }
}
