// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.entity.EntityLiving;

public class EntityTFHydraPart extends EntityLiving
{
    private static final DataParameter<String> PART_NAME;
    public EntityTFHydra hydra;
    
    public EntityTFHydraPart(final World world) {
        super(world);
        this.field_70178_ae = true;
    }
    
    public EntityTFHydraPart(final EntityTFHydra hydra, final String name, final float width, final float height) {
        super(hydra.field_70170_p);
        this.func_70105_a(width, height);
        this.hydra = hydra;
        this.setPartName(name);
        this.field_70178_ae = true;
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a((DataParameter)EntityTFHydraPart.PART_NAME, (Object)"");
    }
    
    public String getPartName() {
        return (String)this.field_70180_af.func_187225_a((DataParameter)EntityTFHydraPart.PART_NAME);
    }
    
    public void setPartName(final String name) {
        this.field_70180_af.func_187227_b((DataParameter)EntityTFHydraPart.PART_NAME, (Object)name);
    }
    
    public void func_70014_b(final NBTTagCompound compound) {
        super.func_70014_b(compound);
        compound.func_74778_a("PartName", this.getPartName());
    }
    
    public void func_70037_a(final NBTTagCompound compound) {
        super.func_70037_a(compound);
        this.setPartName(compound.func_74779_i("PartName"));
    }
    
    public void func_70071_h_() {
        if (this.hydra != null && this.hydra.field_70725_aQ > 190) {
            this.func_70106_y();
        }
        if (this.hydra == null && this.field_70173_aa > 1200) {
            this.func_70106_y();
        }
        super.func_70030_z();
        this.field_70142_S = this.field_70165_t;
        this.field_70137_T = this.field_70163_u;
        this.field_70136_U = this.field_70161_v;
        if (this.field_70716_bi > 0) {
            final double x = this.field_70165_t + (this.field_184623_bh - this.field_70165_t) / this.field_70716_bi;
            final double y = this.field_70163_u + (this.field_184624_bi - this.field_70163_u) / this.field_70716_bi;
            final double z = this.field_70161_v + (this.field_184625_bj - this.field_70161_v) / this.field_70716_bi;
            final double yawDelta = MathHelper.func_76138_g(this.field_184626_bk - this.field_70177_z);
            this.field_70177_z += (float)(yawDelta / this.field_70716_bi);
            this.field_70125_A += (float)((this.field_70709_bj - this.field_70125_A) / this.field_70716_bi);
            --this.field_70716_bi;
            this.func_70107_b(x, y, z);
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
    
    public boolean func_70097_a(final DamageSource source, final float amount) {
        return this.hydra != null && this.hydra.attackEntityFromPart(this, source, amount);
    }
    
    public boolean func_70028_i(final Entity entity) {
        return this == entity || this.hydra == entity;
    }
    
    protected void func_70101_b(final float yaw, final float pitch) {
        this.field_70177_z = yaw % 360.0f;
        this.field_70125_A = pitch % 360.0f;
    }
    
    public boolean func_184222_aU() {
        return false;
    }
    
    protected boolean func_70692_ba() {
        return this.hydra == null;
    }
    
    static {
        PART_NAME = EntityDataManager.func_187226_a((Class)EntityTFHydraPart.class, DataSerializers.field_187194_d);
    }
}
