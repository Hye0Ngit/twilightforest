// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import twilightforest.client.BugModelAnimationHelper;
import net.minecraft.util.math.MathHelper;
import javax.annotation.Nullable;
import twilightforest.tileentity.critters.TileEntityTFMoonwormTicking;
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
    
    public void func_78088_a(final Entity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scale) {
        super.func_78088_a(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.func_78087_a(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
        this.Shape1.func_78785_a(scale);
        this.Shape2.func_78785_a(scale);
        this.Shape3.func_78785_a(scale);
        this.head.func_78785_a(scale);
    }
    
    public void render(final float scale) {
        this.Shape1.func_78785_a(scale);
        this.Shape2.func_78785_a(scale);
        this.Shape3.func_78785_a(scale);
        this.head.func_78785_a(scale);
    }
    
    public void func_78087_a(final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scaleFactor, final Entity entity) {
        super.func_78087_a(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
    }
    
    public void setLivingAnimations(@Nullable final TileEntityTFMoonwormTicking moonworm, final float partialTime) {
        this.head.field_78797_d = 7.0f;
        this.Shape1.field_78797_d = 7.0f;
        this.Shape2.field_78797_d = 7.0f;
        this.Shape3.field_78797_d = 7.0f;
        if (moonworm != null && moonworm.yawDelay == 0) {
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
        else if (moonworm == null && BugModelAnimationHelper.yawWriggleDelay == 0) {
            final float time = BugModelAnimationHelper.desiredRotation - BugModelAnimationHelper.currentRotation - partialTime;
            final ModelRenderer head2 = this.head;
            head2.field_78797_d += Math.min(0.0f, MathHelper.func_76126_a(time / 2.0f));
            final ModelRenderer shape4 = this.Shape1;
            shape4.field_78797_d += Math.min(0.0f, MathHelper.func_76126_a(time / 2.0f + 1.0f));
            final ModelRenderer shape5 = this.Shape2;
            shape5.field_78797_d += Math.min(0.0f, MathHelper.func_76126_a(time / 2.0f + 2.0f));
            final ModelRenderer shape6 = this.Shape3;
            shape6.field_78797_d += Math.min(0.0f, MathHelper.func_76126_a(time / 2.0f + 3.0f));
        }
    }
}
