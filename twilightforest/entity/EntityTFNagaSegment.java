// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.EntityLivingBase;
import java.util.List;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;

public class EntityTFNagaSegment extends Entity
{
    EntityTFNaga naga;
    int segment;
    String texture;
    private int deathCounter;
    
    public EntityTFNagaSegment(final World par1World) {
        super(par1World);
        this.func_70105_a(1.8f, 1.8f);
        this.field_70138_W = 2.0f;
    }
    
    public EntityTFNagaSegment(final EntityTFNaga myNaga, final int segNum) {
        this(myNaga.func_82194_d());
        this.naga = myNaga;
        this.segment = segNum;
    }
    
    public boolean func_70097_a(final DamageSource damagesource, final float damage) {
        return !damagesource.func_94541_c() && !damagesource.func_76347_k() && this.naga != null && this.naga.func_70097_a(damagesource, (float)Math.round(damage * 2.0f / 3.0f));
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.naga == null || this.naga.field_70128_L) {
            this.func_70106_y();
        }
        ++this.field_70173_aa;
        this.field_70142_S = this.field_70165_t;
        this.field_70137_T = this.field_70163_u;
        this.field_70136_U = this.field_70161_v;
        while (this.field_70177_z - this.field_70126_B < -180.0f) {
            this.field_70126_B -= 360.0f;
        }
        while (this.field_70177_z - this.field_70126_B >= 180.0f) {
            this.field_70126_B += 360.0f;
        }
        while (this.field_70125_A - this.field_70127_C < -180.0f) {
            this.field_70127_C -= 360.0f;
        }
        while (this.field_70125_A - this.field_70127_C >= 180.0f) {
            this.field_70127_C += 360.0f;
        }
        if (!this.field_70122_E) {
            this.field_70181_x -= 0.08;
        }
        else {
            this.field_70159_w *= 0.800000011920929;
            this.field_70179_y *= 0.800000011920929;
        }
        this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
        this.collideWithOthers();
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
                this.field_70170_p.func_72900_e((Entity)this);
            }
        }
    }
    
    protected void collideWithOthers() {
        final List list = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(0.20000000298023224, 0.0, 0.20000000298023224));
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); ++i) {
                final Entity entity = list.get(i);
                if (entity.func_70104_M()) {
                    this.collideWithEntity(entity);
                }
            }
        }
    }
    
    private void collideWithEntity(final Entity entity) {
        entity.func_70108_f((Entity)this);
        if (entity instanceof EntityLivingBase && !(entity instanceof EntityTFNaga) && !(entity instanceof EntityTFNagaSegment)) {
            this.naga.field_70724_aR = 10;
            int attackStrength = 2;
            if (entity instanceof EntityAnimal) {
                attackStrength *= 3;
            }
            entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this.naga), (float)attackStrength);
        }
    }
    
    public void func_70101_b(final float par1, final float par2) {
        this.field_70177_z = MathHelper.func_76142_g(par1 % 360.0f);
        this.field_70125_A = par2 % 360.0f;
    }
    
    public boolean func_70067_L() {
        return true;
    }
    
    public boolean func_70104_M() {
        return false;
    }
    
    public boolean func_70028_i(final Entity entity) {
        return this == entity || this.naga == entity;
    }
    
    protected void func_70088_a() {
    }
    
    protected void func_70037_a(final NBTTagCompound nbttagcompound) {
    }
    
    protected void func_70014_b(final NBTTagCompound nbttagcompound) {
    }
    
    protected void func_70036_a(final int par1, final int par2, final int par3, final int par4) {
    }
    
    @SideOnly(Side.CLIENT)
    public String getTexture() {
        return this.texture;
    }
    
    public void selfDestruct() {
        this.deathCounter = 30;
    }
}
