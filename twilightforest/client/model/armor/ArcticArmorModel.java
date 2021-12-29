// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.armor;

import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ArcticArmorModel extends TFArmorModel
{
    public ArcticArmorModel(final float expand) {
        super(expand);
        final ModelRenderer rightHood = new ModelRenderer((Model)this, 0, 0);
        rightHood.func_228301_a_(-1.0f, -2.0f, -1.0f, 1.0f, 4.0f, 1.0f, expand);
        rightHood.func_78793_a(-2.5f, -3.0f, -5.0f);
        this.field_78116_c.func_78792_a(rightHood);
        final ModelRenderer leftHood = new ModelRenderer((Model)this, 0, 0);
        leftHood.func_228301_a_(0.0f, -2.0f, -1.0f, 1.0f, 4.0f, 1.0f, expand);
        leftHood.func_78793_a(2.5f, -3.0f, -5.0f);
        this.field_78116_c.func_78792_a(leftHood);
        final ModelRenderer topHood = new ModelRenderer((Model)this, 24, 0);
        topHood.func_228301_a_(-2.0f, -1.0f, -1.0f, 4.0f, 1.0f, 1.0f, expand);
        topHood.func_78793_a(0.0f, -5.5f, -5.0f);
        this.field_78116_c.func_78792_a(topHood);
        final ModelRenderer bottomHood = new ModelRenderer((Model)this, 24, 0);
        bottomHood.func_228301_a_(-2.0f, -1.0f, -1.0f, 4.0f, 1.0f, 1.0f, expand);
        bottomHood.func_78793_a(0.0f, 0.5f, -5.0f);
        this.field_78116_c.func_78792_a(bottomHood);
    }
}
