// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.armor;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelTFKnightlyArmor extends ModelTFArmor
{
    public ModelRenderer righthorn1;
    public ModelRenderer righthorn2;
    public ModelRenderer lefthorn1;
    public ModelRenderer lefthorn2;
    public ModelRenderer shoulderSpike1;
    public ModelRenderer shoulderSpike2;
    public ModelRenderer shoeSpike1;
    public ModelRenderer shoeSpike2;
    
    public ModelTFKnightlyArmor(final float expand) {
        super(expand);
        (this.righthorn1 = new ModelRenderer((ModelBase)this, 24, 0)).func_78789_a(-5.5f, -1.5f, -1.5f, 5, 3, 3);
        this.righthorn1.func_78793_a(-4.0f, -6.5f, 0.0f);
        this.righthorn1.field_78796_g = -0.2617994f;
        this.righthorn1.field_78808_h = 0.17453294f;
        (this.righthorn2 = new ModelRenderer((ModelBase)this, 54, 16)).func_78789_a(-3.5f, -1.0f, -1.0f, 3, 2, 2);
        this.righthorn2.func_78793_a(-4.5f, 0.0f, 0.0f);
        this.righthorn2.field_78808_h = 0.17453294f;
        this.field_78116_c.func_78792_a(this.righthorn1);
        this.righthorn1.func_78792_a(this.righthorn2);
        this.lefthorn1 = new ModelRenderer((ModelBase)this, 24, 0);
        this.lefthorn1.field_78809_i = true;
        this.lefthorn1.func_78789_a(0.5f, -1.5f, -1.5f, 5, 3, 3);
        this.lefthorn1.func_78793_a(4.0f, -6.5f, 0.0f);
        this.lefthorn1.field_78796_g = 0.2617994f;
        this.lefthorn1.field_78808_h = -0.17453294f;
        (this.lefthorn2 = new ModelRenderer((ModelBase)this, 54, 16)).func_78789_a(0.5f, -1.0f, -1.0f, 3, 2, 2);
        this.lefthorn2.func_78793_a(4.5f, 0.0f, 0.0f);
        this.lefthorn2.field_78808_h = -0.17453294f;
        this.field_78116_c.func_78792_a(this.lefthorn1);
        this.lefthorn1.func_78792_a(this.lefthorn2);
        (this.shoulderSpike1 = new ModelRenderer((ModelBase)this, 0, 0)).func_78790_a(-1.0f, -1.0f, -1.0f, 2, 2, 2, 0.5f);
        this.shoulderSpike1.func_78793_a(-3.75f, -2.5f, 0.0f);
        this.shoulderSpike1.field_78795_f = 0.7853982f;
        this.shoulderSpike1.field_78796_g = 0.17453294f;
        this.shoulderSpike1.field_78808_h = 0.6108653f;
        this.field_178723_h.func_78792_a(this.shoulderSpike1);
        (this.shoulderSpike2 = new ModelRenderer((ModelBase)this, 0, 0)).func_78790_a(-1.0f, -1.0f, -1.0f, 2, 2, 2, 0.5f);
        this.shoulderSpike2.func_78793_a(3.75f, -2.5f, 0.0f);
        this.shoulderSpike2.field_78795_f = -0.7853982f;
        this.shoulderSpike2.field_78796_g = -0.17453294f;
        this.shoulderSpike2.field_78808_h = 0.95993114f;
        this.field_178724_i.func_78792_a(this.shoulderSpike2);
        (this.shoeSpike1 = new ModelRenderer((ModelBase)this, 0, 0)).func_78790_a(-1.0f, -1.0f, -1.0f, 2, 2, 2, 0.5f);
        this.shoeSpike1.func_78793_a(-2.5f, 11.0f, 2.0f);
        this.shoeSpike1.field_78796_g = -0.7853982f;
        this.field_178721_j.func_78792_a(this.shoeSpike1);
        (this.shoeSpike2 = new ModelRenderer((ModelBase)this, 0, 0)).func_78790_a(-1.0f, -1.0f, -1.0f, 2, 2, 2, 0.5f);
        this.shoeSpike2.func_78793_a(2.5f, 11.0f, 2.0f);
        this.shoeSpike2.field_78796_g = 0.7853982f;
        this.field_178722_k.func_78792_a(this.shoeSpike2);
    }
}
