// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.armor;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.google.common.collect.Iterables;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.inventory.EquipmentSlotType;

public class YetiArmorModel extends TFArmorModel
{
    private final EquipmentSlotType slot;
    private ModelRenderer bipedLegBody;
    private ModelRenderer rightRuff;
    private ModelRenderer leftRuff;
    private ModelRenderer rightToe;
    private ModelRenderer leftToe;
    
    public YetiArmorModel(final EquipmentSlotType slot, final float expand) {
        super(expand);
        this.slot = slot;
        (this.field_78116_c = new ModelRenderer((Model)this, 0, 0)).func_228301_a_(-4.5f, -7.5f, -4.0f, 9.0f, 8.0f, 8.0f, expand);
        this.field_78116_c.func_78793_a(0.0f, 0.0f + expand, 0.0f);
        this.addPairHorns(-8.0f, 35.0f);
        this.addPairHorns(-6.0f, 15.0f);
        this.addPairHorns(-4.0f, -5.0f);
        (this.field_178721_j = new ModelRenderer((Model)this, 40, 0)).func_228301_a_(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, expand);
        this.field_178721_j.func_78793_a(-1.9f, 12.0f, 0.0f);
        this.field_178722_k = new ModelRenderer((Model)this, 40, 0);
        this.field_178722_k.field_78809_i = true;
        this.field_178722_k.func_228301_a_(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, expand);
        this.field_178722_k.func_78793_a(1.9f, 12.0f, 0.0f);
        (this.rightRuff = new ModelRenderer((Model)this, 40, 22)).func_228301_a_(-2.5f, 0.0f, -2.5f, 5.0f, 2.0f, 5.0f, expand);
        this.rightRuff.func_78793_a(0.0f, 6.0f, 0.0f);
        this.field_178721_j.func_78792_a(this.rightRuff);
        (this.leftRuff = new ModelRenderer((Model)this, 40, 22)).func_228301_a_(-2.5f, 0.0f, -2.5f, 5.0f, 2.0f, 5.0f, expand);
        this.leftRuff.func_78793_a(0.0f, 6.0f, 0.0f);
        this.field_178722_k.func_78792_a(this.leftRuff);
        (this.rightToe = new ModelRenderer((Model)this, 40, 17)).func_228301_a_(-2.0f, 0.0f, -1.0f, 4.0f, 2.0f, 1.0f, expand);
        this.rightToe.func_78793_a(0.0f, 10.0f, -2.0f);
        this.field_178721_j.func_78792_a(this.rightToe);
        (this.leftToe = new ModelRenderer((Model)this, 40, 17)).func_228301_a_(-2.0f, 0.0f, -1.0f, 4.0f, 2.0f, 1.0f, expand);
        this.leftToe.func_78793_a(0.0f, 10.0f, -2.0f);
        this.field_178722_k.func_78792_a(this.leftToe);
        (this.field_78115_e = new ModelRenderer((Model)this, 0, 0)).func_228301_a_(-4.0f, 0.0f, -2.0f, 8.0f, 11.0f, 4.0f, expand);
        this.field_78115_e.func_78793_a(0.0f, 0.0f, 0.0f);
        (this.bipedLegBody = new ModelRenderer((Model)this, 40, 16)).func_228301_a_(-4.0f, 0.0f, -2.0f, 8.0f, 12.0f, 4.0f, expand);
        this.bipedLegBody.func_78793_a(0.0f, 0.0f, 0.0f);
        (this.field_178723_h = new ModelRenderer((Model)this, 0, 16)).func_228301_a_(-3.0f, -2.0f, -2.0f, 4.0f, 10.0f, 4.0f, expand);
        this.field_178723_h.func_78793_a(-5.0f, 2.0f, 0.0f);
        this.field_178724_i = new ModelRenderer((Model)this, 0, 16);
        this.field_178724_i.field_78809_i = true;
        this.field_178724_i.func_228301_a_(-1.0f, -2.0f, -2.0f, 4.0f, 10.0f, 4.0f, expand);
        this.field_178724_i.func_78793_a(5.0f, 2.0f, 0.0f);
    }
    
    protected Iterable<ModelRenderer> func_225600_b_() {
        return Iterables.concat(super.func_225600_b_(), (Iterable)ImmutableList.of((Object)this.bipedLegBody));
    }
    
    private void addPairHorns(final float height, final float zangle) {
        final ModelRenderer horn1a = new ModelRenderer((Model)this, 0, 19);
        horn1a.func_228300_a_(-3.0f, -1.5f, -1.5f, 3.0f, 3.0f, 3.0f);
        horn1a.func_78793_a(-4.5f, height, -1.0f);
        horn1a.field_78796_g = -0.5235988f;
        horn1a.field_78808_h = zangle / 57.295776f;
        this.field_78116_c.func_78792_a(horn1a);
        final ModelRenderer horn1b = new ModelRenderer((Model)this, 0, 26);
        horn1b.func_228300_a_(-4.0f, -1.0f, -1.0f, 5.0f, 2.0f, 2.0f);
        horn1b.func_78793_a(-3.0f, 0.0f, 0.0f);
        horn1b.field_78796_g = -0.34906587f;
        horn1b.field_78808_h = zangle / 57.295776f;
        horn1a.func_78792_a(horn1b);
        final ModelRenderer horn2a = new ModelRenderer((Model)this, 0, 19);
        horn2a.func_228300_a_(0.0f, -1.5f, -1.5f, 3.0f, 3.0f, 3.0f);
        horn2a.func_78793_a(4.5f, height, -1.0f);
        horn2a.field_78796_g = 0.5235988f;
        horn2a.field_78808_h = -zangle / 57.295776f;
        this.field_78116_c.func_78792_a(horn2a);
        final ModelRenderer horn2b = new ModelRenderer((Model)this, 0, 26);
        horn2b.func_228300_a_(-1.0f, -1.0f, -1.0f, 5.0f, 2.0f, 2.0f);
        horn2b.func_78793_a(3.0f, 0.0f, 0.0f);
        horn2b.field_78796_g = 0.34906587f;
        horn2b.field_78808_h = -zangle / 57.295776f;
        horn2a.func_78792_a(horn2b);
    }
    
    public void func_178719_a(final boolean visible) {
        super.func_178719_a(visible);
        this.bipedLegBody.field_78806_j = visible;
    }
    
    public void func_225598_a_(final MatrixStack stack, final IVertexBuilder builder, final int light, final int overlay, final float red, final float green, final float blue, final float scale) {
        switch (this.slot) {
            case HEAD: {
                this.field_78116_c.field_78806_j = true;
                this.field_178720_f.field_78806_j = false;
                this.field_78115_e.field_78806_j = false;
                this.field_178723_h.field_78806_j = false;
                this.field_178724_i.field_78806_j = false;
                this.bipedLegBody.field_78806_j = false;
                this.field_178721_j.field_78806_j = false;
                this.field_178722_k.field_78806_j = false;
                break;
            }
            case CHEST: {
                this.field_78116_c.field_78806_j = false;
                this.field_178720_f.field_78806_j = false;
                this.field_78115_e.field_78806_j = true;
                this.field_178723_h.field_78806_j = true;
                this.field_178724_i.field_78806_j = true;
                this.bipedLegBody.field_78806_j = false;
                this.field_178721_j.field_78806_j = false;
                this.field_178722_k.field_78806_j = false;
                break;
            }
            case LEGS: {
                this.field_78116_c.field_78806_j = false;
                this.field_178720_f.field_78806_j = false;
                this.field_78115_e.field_78806_j = false;
                this.field_178723_h.field_78806_j = false;
                this.field_178724_i.field_78806_j = false;
                this.bipedLegBody.field_78806_j = true;
                this.field_178721_j.field_78806_j = true;
                this.field_178722_k.field_78806_j = true;
                this.leftRuff.field_78806_j = false;
                this.leftToe.field_78806_j = false;
                this.rightRuff.field_78806_j = false;
                this.rightToe.field_78806_j = false;
                break;
            }
            case FEET: {
                this.field_78116_c.field_78806_j = false;
                this.field_178720_f.field_78806_j = false;
                this.field_78115_e.field_78806_j = false;
                this.field_178723_h.field_78806_j = false;
                this.field_178724_i.field_78806_j = false;
                this.bipedLegBody.field_78806_j = false;
                this.field_178721_j.field_78806_j = true;
                this.field_178722_k.field_78806_j = true;
                this.leftRuff.field_78806_j = true;
                this.leftToe.field_78806_j = true;
                this.rightRuff.field_78806_j = true;
                this.rightToe.field_78806_j = true;
                break;
            }
        }
        super.func_225598_a_(stack, builder, light, overlay, red, green, blue, scale);
    }
}
