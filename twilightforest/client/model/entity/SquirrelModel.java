// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.entity.passive.SquirrelEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;

@OnlyIn(Dist.CLIENT)
public class SquirrelModel extends SegmentedModel<SquirrelEntity>
{
    public ModelRenderer body;
    public ModelRenderer head;
    public ModelRenderer rightFrontLeg;
    public ModelRenderer leftFrontLeg;
    public ModelRenderer rightBackLeg;
    public ModelRenderer leftBackLeg;
    public ModelRenderer tail1;
    public ModelRenderer tail2;
    
    public SquirrelModel() {
        this.field_78090_t = 32;
        this.field_78089_u = 32;
        (this.rightFrontLeg = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-1.5f, 23.0f, -2.5f);
        this.rightFrontLeg.func_78784_a(0, 16).func_228302_a_(-0.5f, 0.0f, -0.5f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
        (this.body = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 23.0f, 0.0f);
        this.body.func_78784_a(0, 8).func_228302_a_(-2.0f, -3.0f, -3.0f, 4.0f, 3.0f, 5.0f, 0.0f, 0.0f, 0.0f);
        (this.leftBackLeg = new ModelRenderer((Model)this, 0, 0)).func_78793_a(1.5f, 23.0f, 1.5f);
        this.leftBackLeg.func_78784_a(4, 18).func_228302_a_(-0.5f, 0.0f, -0.5f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 20.0f, -3.0f);
        this.head.func_228302_a_(-2.0f, -2.0f, -3.0f, 4.0f, 4.0f, 4.0f, 0.0f, 0.0f, 0.0f);
        this.head.func_228302_a_(-2.0f, -3.0f, -1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
        this.head.func_78784_a(0, 2).func_228302_a_(1.0f, -3.0f, -1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
        (this.tail2 = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 4.0f, 0.5f);
        this.tail2.func_78784_a(13, 11).func_228302_a_(-1.5f, -1.0f, 0.0f, 3.0f, 3.0f, 5.0f, 0.0f, 0.0f, 0.0f);
        (this.leftFrontLeg = new ModelRenderer((Model)this, 0, 0)).func_78793_a(1.5f, 23.0f, -2.5f);
        this.leftFrontLeg.func_78784_a(4, 16).func_228302_a_(-0.5f, 0.0f, -0.5f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
        (this.tail1 = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, -3.0f, 2.0f);
        this.tail1.func_78784_a(18, 0).func_228302_a_(-1.5f, 0.0f, -1.5f, 3.0f, 4.0f, 3.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.tail1, 2.5307274f, 0.0f, 0.0f);
        (this.rightBackLeg = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-1.5f, 23.0f, 1.5f);
        this.rightBackLeg.func_78784_a(0, 18).func_228302_a_(-0.5f, 0.0f, -0.5f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
        this.tail1.func_78792_a(this.tail2);
        this.body.func_78792_a(this.tail1);
    }
    
    public Iterable<ModelRenderer> func_225601_a_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.body, (Object)this.leftFrontLeg, (Object)this.rightFrontLeg, (Object)this.leftBackLeg, (Object)this.rightBackLeg, (Object)this.head);
    }
    
    public void setRotateAngle(final ModelRenderer modelRenderer, final float x, final float y, final float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
    
    public void setRotationAngles(final SquirrelEntity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.head.field_78795_f = headPitch / 57.295776f;
        this.head.field_78796_g = netHeadYaw / 57.295776f;
        this.leftFrontLeg.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.rightFrontLeg.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.leftBackLeg.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.rightBackLeg.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        if (limbSwingAmount > 0.2) {
            final float wiggle = Math.min(limbSwingAmount, 0.6f);
            this.tail2.field_78795_f = (MathHelper.func_76134_b(ageInTicks * 0.6662f) - 1.0471976f) * wiggle;
            this.tail1.field_78795_f = 2.5f + MathHelper.func_76134_b(ageInTicks * 0.7774f) * 1.2f * wiggle;
        }
        else {
            this.tail2.field_78795_f = 0.2f + MathHelper.func_76134_b(ageInTicks * 0.3335f) * 0.25f;
            this.tail1.field_78795_f = 2.5f + MathHelper.func_76134_b(ageInTicks * 0.4445f) * 0.2f;
        }
    }
}
