// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;

public class EntityTFSpikeBlock extends Entity
{
    EntityTFBlockGoblin goblin;
    
    public EntityTFSpikeBlock(final World par1World) {
        super(par1World);
        this.func_70105_a(0.75f, 0.75f);
    }
    
    public EntityTFSpikeBlock(final EntityTFBlockGoblin goblin) {
        this(goblin.func_82194_d());
        this.goblin = goblin;
    }
    
    public boolean func_70097_a(final DamageSource par1DamageSource, final float par2) {
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
        return false;
    }
    
    public boolean func_70104_M() {
        return false;
    }
    
    public boolean func_70028_i(final Entity entity) {
        return this == entity || this.goblin == entity;
    }
    
    protected void func_70088_a() {
    }
    
    protected void func_70037_a(final NBTTagCompound nbttagcompound) {
    }
    
    protected void func_70014_b(final NBTTagCompound nbttagcompound) {
    }
}
