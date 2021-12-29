// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.MathHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.entity.EntityLiving;

public class EntityTFHydraPart extends EntityLiving
{
    public EntityTFHydra hydraObj;
    
    public EntityTFHydraPart(final World world) {
        super(world);
        this.field_70178_ae = true;
    }
    
    public EntityTFHydraPart(final EntityTFHydra hydra, final String s, final float f, final float f1) {
        super(hydra.field_70170_p);
        this.func_70105_a(f, f1);
        this.hydraObj = hydra;
        this.setPartName(s);
        this.field_70178_ae = true;
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(17, (Object)"");
    }
    
    public String getPartName() {
        return this.field_70180_af.func_75681_e(17);
    }
    
    public void setPartName(final String name) {
        this.field_70180_af.func_75692_b(17, (Object)name);
    }
    
    public void func_70014_b(final NBTTagCompound nbttagcompound) {
        super.func_70014_b(nbttagcompound);
        nbttagcompound.func_74778_a("PartName", this.getPartName());
    }
    
    public void func_70037_a(final NBTTagCompound nbttagcompound) {
        super.func_70037_a(nbttagcompound);
        this.setPartName(nbttagcompound.func_74779_i("PartName"));
    }
    
    public void func_70071_h_() {
        if (this.hydraObj != null && this.hydraObj.field_70725_aQ > 190) {
            this.func_70106_y();
        }
        if (this.hydraObj == null && this.field_70173_aa > 1200) {
            this.func_70106_y();
        }
        super.func_70030_z();
        this.field_70142_S = this.field_70165_t;
        this.field_70137_T = this.field_70163_u;
        this.field_70136_U = this.field_70161_v;
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
        this.field_70759_as = this.field_70177_z;
        this.field_70758_at = this.field_70126_B;
        while (this.field_70177_z - this.field_70126_B < -180.0f) {
            this.field_70126_B -= 360.0f;
        }
        while (this.field_70177_z - this.field_70126_B >= 180.0f) {
            this.field_70126_B += 360.0f;
        }
        while (this.field_70761_aq - this.field_70760_ar < -180.0f) {
            this.field_70760_ar -= 360.0f;
        }
        while (this.field_70761_aq - this.field_70760_ar >= 180.0f) {
            this.field_70760_ar += 360.0f;
        }
        while (this.field_70125_A - this.field_70127_C < -180.0f) {
            this.field_70127_C -= 360.0f;
        }
        while (this.field_70125_A - this.field_70127_C >= 180.0f) {
            this.field_70127_C += 360.0f;
        }
        while (this.field_70759_as - this.field_70758_at < -180.0f) {
            this.field_70758_at -= 360.0f;
        }
        while (this.field_70759_as - this.field_70758_at >= 180.0f) {
            this.field_70758_at += 360.0f;
        }
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1000.0);
    }
    
    public boolean func_70097_a(final DamageSource damagesource, final float i) {
        return this.hydraObj != null && this.hydraObj.attackEntityFromPart(this, damagesource, i);
    }
    
    public boolean func_70028_i(final Entity entity) {
        return this == entity || this.hydraObj == entity;
    }
    
    protected void func_70101_b(final float par1, final float par2) {
        this.field_70177_z = par1 % 360.0f;
        this.field_70125_A = par2 % 360.0f;
    }
}
