// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.armor;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelTFArcticArmor extends ModelTFArmor
{
    public ModelTFArcticArmor(final float expand) {
        super(expand);
        final ModelRenderer rightHood = new ModelRenderer((ModelBase)this, 0, 0);
        rightHood.func_78790_a(-1.0f, -2.0f, -1.0f, 1, 4, 1, expand);
        rightHood.func_78793_a(-2.5f, -3.0f, -5.0f);
        this.field_78116_c.func_78792_a(rightHood);
        final ModelRenderer leftHood = new ModelRenderer((ModelBase)this, 0, 0);
        leftHood.func_78790_a(0.0f, -2.0f, -1.0f, 1, 4, 1, expand);
        leftHood.func_78793_a(2.5f, -3.0f, -5.0f);
        this.field_78116_c.func_78792_a(leftHood);
        final ModelRenderer topHood = new ModelRenderer((ModelBase)this, 24, 0);
        topHood.func_78790_a(-2.0f, -1.0f, -1.0f, 4, 1, 1, expand);
        topHood.func_78793_a(0.0f, -5.5f, -5.0f);
        this.field_78116_c.func_78792_a(topHood);
        final ModelRenderer bottomHood = new ModelRenderer((ModelBase)this, 24, 0);
        bottomHood.func_78790_a(-2.0f, -1.0f, -1.0f, 4, 1, 1, expand);
        bottomHood.func_78793_a(0.0f, 0.5f, -5.0f);
        this.field_78116_c.func_78792_a(bottomHood);
    }
}
