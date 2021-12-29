// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;

public class EntityTFSnowQueenIceShield extends Entity
{
    EntityTFSnowQueen queen;
    
    public EntityTFSnowQueenIceShield(final World par1World) {
        super(par1World);
        this.func_70105_a(0.75f, 0.75f);
    }
    
    public EntityTFSnowQueenIceShield(final EntityTFSnowQueen goblin) {
        this(goblin.func_82194_d());
        this.queen = goblin;
    }
    
    public boolean func_70097_a(final DamageSource par1DamageSource, final float par2) {
        this.field_70170_p.func_72956_a((Entity)this, "random.break", 1.0f, ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.7f + 1.0f) * 2.0f);
        return false;
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
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
    }
    
    public boolean func_70067_L() {
        return true;
    }
    
    public boolean func_70104_M() {
        return false;
    }
    
    public boolean func_70028_i(final Entity entity) {
        return this == entity || this.queen == entity;
    }
    
    protected void func_70088_a() {
    }
    
    protected void func_70037_a(final NBTTagCompound nbttagcompound) {
    }
    
    protected void func_70014_b(final NBTTagCompound nbttagcompound) {
    }
}
