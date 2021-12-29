// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.IEntityMultiPart;
import net.minecraft.entity.MultiPartEntityPart;

public class EntityTFSnowQueenIceShield extends MultiPartEntityPart
{
    public EntityTFSnowQueenIceShield(final EntityTFSnowQueen waifu) {
        super((IEntityMultiPart)waifu, "shield", 0.75f, 0.75f);
    }
    
    public boolean func_70097_a(final DamageSource source, final float amount) {
        this.func_184185_a(SoundEvents.field_187635_cQ, 1.0f, ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.7f + 1.0f) * 2.0f);
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
}
