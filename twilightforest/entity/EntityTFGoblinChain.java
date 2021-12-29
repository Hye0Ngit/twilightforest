// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.entity.IEntityMultiPart;
import net.minecraft.entity.MultiPartEntityPart;

public class EntityTFGoblinChain extends MultiPartEntityPart
{
    public EntityTFGoblinChain(final IEntityMultiPart goblin) {
        super(goblin, "chain", 0.1f, 0.1f);
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
}
