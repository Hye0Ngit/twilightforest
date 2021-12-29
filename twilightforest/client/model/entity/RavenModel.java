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
import twilightforest.entity.passive.RavenEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;

@OnlyIn(Dist.CLIENT)
public class RavenModel extends SegmentedModel<RavenEntity>
{
    public ModelRenderer head;
    public ModelRenderer torso;
    public ModelRenderer rightWing;
    public ModelRenderer leftWing;
    public ModelRenderer rightLeg;
    public ModelRenderer leftLeg;
    public ModelRenderer tail;
    
    public RavenModel() {
        this.field_78090_t = 32;
        this.field_78089_u = 32;
        (this.torso = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 18.5f, -2.0f);
        this.torso.func_78784_a(0, 6).func_228302_a_(-2.0f, -1.5f, 0.0f, 4.0f, 3.0f, 6.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.torso, -0.43633232f, 0.0f, 0.0f);
        (this.leftWing = new ModelRenderer((Model)this, 0, 0)).func_78793_a(2.0f, -1.0f, 2.0f);
        this.leftWing.func_78784_a(14, 15).func_228302_a_(0.0f, 0.0f, -1.0f, 1.0f, 3.0f, 6.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.leftWing, 0.2617994f, 0.0f, 0.0f);
        (this.leftLeg = new ModelRenderer((Model)this, 0, 0)).func_78793_a(1.0f, 0.0f, 0.0f);
        this.leftLeg.func_78784_a(14, 15).func_228302_a_(0.0f, 0.0f, -1.0f, 1.0f, 2.0f, 2.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.leftLeg, 0.7853982f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 18.5f, -2.0f);
        this.head.func_228302_a_(-1.5f, -1.0f, -2.0f, 3.0f, 3.0f, 3.0f, 0.0f, 0.0f, 0.0f);
        this.head.func_78784_a(9, 0).func_228302_a_(-0.5f, 0.0f, -3.0f, 1.0f, 2.0f, 1.0f, 0.0f, 0.0f, 0.0f);
        (this.rightWing = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-2.0f, -1.0f, 2.0f);
        this.rightWing.func_78784_a(0, 15).func_228302_a_(-1.0f, 0.0f, -1.0f, 1.0f, 3.0f, 6.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.rightWing, 0.2617994f, 0.0f, 0.0f);
        (this.rightLeg = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-1.0f, 0.0f, 0.0f);
        this.rightLeg.func_78784_a(8, 15).func_228302_a_(0.0f, 0.0f, -1.0f, 1.0f, 2.0f, 2.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.rightLeg, 0.7853982f, 0.0f, 0.0f);
        (this.tail = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, -1.5f, 6.0f);
        this.tail.func_78784_a(8, 0).func_228302_a_(-2.5f, 0.0f, 0.0f, 5.0f, 0.0f, 5.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.tail, -0.43633232f, 0.0f, 0.0f);
        this.torso.func_78792_a(this.leftWing);
        this.torso.func_78792_a(this.rightWing);
        this.torso.func_78792_a(this.tail);
    }
    
    public Iterable<ModelRenderer> func_225601_a_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.head, (Object)this.torso, (Object)this.leftLeg, (Object)this.rightLeg);
    }
    
    public void setRotationAngles(final RavenEntity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.head.field_78795_f = headPitch / 57.295776f;
        this.head.field_78796_g = netHeadYaw / 57.295776f;
        this.head.field_78808_h = ((netHeadYaw > 5.0f) ? -0.2617994f : 0.0f);
        this.leftLeg.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.rightLeg.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.rightWing.field_78808_h = ageInTicks;
        this.leftWing.field_78808_h = -ageInTicks;
        if (entity.isBirdLanded()) {
            this.rightLeg.field_78797_d = 21.0f;
            this.leftLeg.field_78797_d = 21.0f;
        }
        else {
            this.rightLeg.field_78797_d = 20.0f;
            this.leftLeg.field_78797_d = 20.0f;
        }
    }
    
    public void setRotateAngle(final ModelRenderer modelRenderer, final float x, final float y, final float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}
