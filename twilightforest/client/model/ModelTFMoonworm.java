// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import net.minecraft.util.MathHelper;
import twilightforest.tileentity.TileEntityTFMoonworm;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelTFMoonworm extends ModelBase
{
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer head;
    
    public ModelTFMoonworm() {
        this.field_78090_t = 32;
        this.field_78089_u = 32;
        (this.Shape1 = new ModelRenderer((ModelBase)this, 0, 4)).func_78789_a(-1.0f, -1.0f, -1.0f, 4, 2, 2);
        this.Shape1.func_78793_a(-1.0f, 7.0f, 3.0f);
        (this.Shape2 = new ModelRenderer((ModelBase)this, 0, 8)).func_78789_a(-1.0f, -1.0f, -1.0f, 2, 2, 4);
        this.Shape2.func_78793_a(3.0f, 7.0f, 0.0f);
        (this.Shape3 = new ModelRenderer((ModelBase)this, 0, 14)).func_78789_a(-1.0f, -1.0f, -1.0f, 2, 2, 2);
        this.Shape3.func_78793_a(2.0f, 7.0f, -2.0f);
        (this.head = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-1.0f, -1.0f, -1.0f, 2, 2, 2);
        this.head.func_78793_a(-3.0f, 7.0f, 2.0f);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        this.Shape1.func_78785_a(f5);
        this.Shape2.func_78785_a(f5);
        this.Shape3.func_78785_a(f5);
        this.head.func_78785_a(f5);
    }
    
    public void render(final float f5) {
        this.Shape1.func_78785_a(f5);
        this.Shape2.func_78785_a(f5);
        this.Shape3.func_78785_a(f5);
        this.head.func_78785_a(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.field_78795_f = x;
        model.field_78796_g = y;
        model.field_78808_h = z;
    }
    
    public void func_78087_a(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity) {
        super.func_78087_a(f, f1, f2, f3, f4, f5, entity);
    }
    
    public void setLivingAnimations(final TileEntityTFMoonworm moonworm, final float partialTime) {
        this.head.field_78797_d = 7.0f;
        this.Shape1.field_78797_d = 7.0f;
        this.Shape2.field_78797_d = 7.0f;
        this.Shape3.field_78797_d = 7.0f;
        if (moonworm.yawDelay == 0) {
            final float time = moonworm.desiredYaw - moonworm.currentYaw - partialTime;
            final ModelRenderer head = this.head;
            head.field_78797_d += Math.min(0.0f, MathHelper.func_76126_a(time / 2.0f));
            final ModelRenderer shape1 = this.Shape1;
            shape1.field_78797_d += Math.min(0.0f, MathHelper.func_76126_a(time / 2.0f + 1.0f));
            final ModelRenderer shape2 = this.Shape2;
            shape2.field_78797_d += Math.min(0.0f, MathHelper.func_76126_a(time / 2.0f + 2.0f));
            final ModelRenderer shape3 = this.Shape3;
            shape3.field_78797_d += Math.min(0.0f, MathHelper.func_76126_a(time / 2.0f + 3.0f));
        }
    }
}
