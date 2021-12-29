// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.util.MathHelper;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.passive.EntityAnimal;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.EntityLiving;

public class EntityTFNagaSegment extends EntityLiving implements IMob
{
    EntityTFNaga head;
    double sDist;
    int attackStrength;
    int deathCounter;
    
    public EntityTFNagaSegment(final World world) {
        super(world);
        this.sDist = 1.5;
        this.field_70750_az = "/mods/twilightforest/textures/model/nagasegment.png";
        this.func_70105_a(1.75f, 1.95f);
        this.field_70138_W = 2.0f;
        this.field_70734_aK = 1000;
        this.field_70178_ae = true;
        this.attackStrength = 2;
    }
    
    public EntityTFNagaSegment(final World world, final double x, final double y, final double z) {
        this(world);
        this.func_70107_b(x, y, z);
    }
    
    public EntityTFNagaSegment(final World world, final EntityTFNaga head, final int segment) {
        this(world);
        this.head = head;
        this.setSegment(segment);
        this.field_70697_bw = head.getMoveSpeed() * 1.5f;
        this.field_70746_aG = head.field_70746_aG;
        this.field_70747_aH = head.field_70747_aH;
    }
    
    public void setSegment(final int i) {
        this.field_70180_af.func_75692_b(16, (Object)new Byte((byte)i));
    }
    
    public int getSegment() {
        return this.field_70180_af.func_75683_a(16);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(16, (Object)new Byte((byte)1));
    }
    
    public boolean func_70104_M() {
        return true;
    }
    
    public void func_70653_a(final Entity entity, final int i, final double d, final double d1) {
    }
    
    protected void func_70069_a(final float f) {
    }
    
    public boolean func_70041_e_() {
        return false;
    }
    
    public boolean func_70058_J() {
        return false;
    }
    
    public void func_70071_h_() {
        this.despawnIfInvalid();
        if (this.deathCounter > 0) {
            --this.deathCounter;
            if (this.deathCounter == 0) {
                for (int k = 0; k < 20; ++k) {
                    final double d = this.field_70146_Z.nextGaussian() * 0.02;
                    final double d2 = this.field_70146_Z.nextGaussian() * 0.02;
                    final double d3 = this.field_70146_Z.nextGaussian() * 0.02;
                    final String explosionType = this.field_70146_Z.nextBoolean() ? "largeexplode" : "explode";
                    this.field_70170_p.func_72869_a(explosionType, this.field_70165_t + this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f - this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextFloat() * this.field_70131_O, this.field_70161_v + this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0f - this.field_70130_N, d, d2, d3);
                }
                this.func_70106_y();
            }
        }
        super.func_70071_h_();
    }
    
    protected void func_70626_be() {
        if (this.head != null && this.head.field_70724_aR <= 0) {
            final List allNearEntities = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(0.75, 0.75, 0.75));
            for (int i = 0; i < allNearEntities.size(); ++i) {
                final Entity nearEntity = allNearEntities.get(i);
                if (nearEntity instanceof EntityLiving && !(nearEntity instanceof EntityTFNaga) && !(nearEntity instanceof EntityTFNagaSegment)) {
                    this.head.field_70724_aR = 10;
                    this.func_70652_k(nearEntity);
                }
            }
        }
    }
    
    public boolean func_70652_k(final Entity entity) {
        if (entity instanceof EntityAnimal) {
            return entity.func_70097_a(DamageSource.func_76358_a((EntityLiving)this), this.attackStrength * 3);
        }
        return entity.func_70097_a(DamageSource.func_76358_a((EntityLiving)this), this.attackStrength);
    }
    
    public boolean func_70097_a(final DamageSource damagesource, final int i) {
        if (damagesource.func_94541_c() || damagesource.func_76347_k()) {
            this.field_70737_aN = 0;
            return false;
        }
        if (!this.field_70170_p.field_72995_K && this.deathCounter <= 0 && this.head != null) {
            final int n = 10;
            this.field_70738_aO = n;
            this.field_70737_aN = n;
            return this.head.func_70097_a(damagesource, Math.round(i * 2.0f / 3.0f));
        }
        return false;
    }
    
    public void despawnIfInvalid() {
        if (!this.field_70170_p.field_72995_K) {
            if (this.head == null || this.head.field_70128_L) {
                this.func_70106_y();
            }
            if (this.field_70170_p.field_73013_u == 0) {
                this.func_70106_y();
            }
        }
    }
    
    public void pullTowards(final Entity leader) {
        this.field_70697_bw = this.head.getMoveSpeed() * 1.5f;
        final float angle = (float)Math.atan2(this.field_70161_v - leader.field_70161_v, this.field_70165_t - leader.field_70165_t);
        final double idealX = leader.field_70165_t + MathHelper.func_76134_b(angle) * this.sDist;
        final double idealZ = leader.field_70161_v + MathHelper.func_76126_a(angle) * this.sDist;
        final double dx = idealX - this.field_70165_t;
        double dy = leader.field_70163_u - this.field_70163_u;
        final double dz = idealZ - this.field_70161_v;
        final double dist = MathHelper.func_76133_a(dx * dx + dz * dz);
        if (dist > this.sDist * 4.0) {
            this.func_70080_a(idealX, leader.field_70163_u + 0.001, idealZ, 0.0f, (float)(angle * 180.0f / 3.141592653589793) - 90.0f);
            dy = 0.0;
            this.func_70625_a(leader, 90.0f, 90.0f);
            this.field_70701_bs = (float)(this.field_70697_bw * dist * 5.0);
        }
        else if (dist > 0.0) {
            this.func_70625_a(leader, 90.0f, 90.0f);
            this.field_70701_bs = this.head.getMoveSpeed();
        }
        if (dy > 1.1) {
            this.func_70664_aZ();
        }
    }
    
    public void selfDestruct() {
        final int n = 30;
        this.field_70738_aO = n;
        this.field_70737_aN = n;
        this.deathCounter = 30;
    }
    
    public int func_70667_aM() {
        return 250;
    }
}
