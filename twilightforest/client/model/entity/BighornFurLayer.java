// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import twilightforest.entity.passive.BighornEntity;
import net.minecraft.client.renderer.entity.model.SheepWoolModel;

public class BighornFurLayer extends SheepWoolModel<BighornEntity>
{
    public BighornFurLayer() {
        (this.field_78150_a = new ModelRenderer((Model)this, 0, 0)).func_228301_a_(-3.0f, -4.0f, -4.0f, 6.0f, 6.0f, 6.0f, 0.6f);
        this.field_78150_a.func_78793_a(0.0f, 6.0f, -8.0f);
        (this.field_78148_b = new ModelRenderer((Model)this, 28, 8)).func_228301_a_(-4.0f, -9.0f, -7.0f, 8.0f, 15.0f, 6.0f, 0.5f);
        this.field_78148_b.func_78793_a(0.0f, 5.0f, 2.0f);
        final float f = 0.4f;
        (this.field_78149_c = new ModelRenderer((Model)this, 0, 16)).func_228301_a_(-2.0f, 0.0f, -2.0f, 4.0f, 6.0f, 4.0f, f);
        this.field_78149_c.func_78793_a(-3.0f, 12.0f, 7.0f);
        (this.field_78146_d = new ModelRenderer((Model)this, 0, 16)).func_228301_a_(-2.0f, 0.0f, -2.0f, 4.0f, 6.0f, 4.0f, f);
        this.field_78146_d.func_78793_a(3.0f, 12.0f, 7.0f);
        (this.field_78147_e = new ModelRenderer((Model)this, 0, 16)).func_228301_a_(-2.0f, 0.0f, -2.0f, 4.0f, 6.0f, 4.0f, f);
        this.field_78147_e.func_78793_a(-3.0f, 12.0f, -5.0f);
        (this.field_78144_f = new ModelRenderer((Model)this, 0, 16)).func_228301_a_(-2.0f, 0.0f, -2.0f, 4.0f, 6.0f, 4.0f, f);
        this.field_78144_f.func_78793_a(3.0f, 12.0f, -5.0f);
    }
}
