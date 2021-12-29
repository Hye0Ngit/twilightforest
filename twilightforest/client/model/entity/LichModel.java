// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import com.google.common.collect.Iterables;
import java.util.Arrays;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import twilightforest.entity.boss.Lich;
import net.minecraft.client.model.HumanoidModel;

public class LichModel extends HumanoidModel<Lich>
{
    private boolean shadowClone;
    private final ModelPart collar;
    private final ModelPart cloak;
    
    public LichModel(final ModelPart root) {
        super(root);
        this.collar = root.m_171324_("collar");
        this.cloak = root.m_171324_("cloak");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = HumanoidModel.m_170681_(CubeDeformation.f_171458_, 0.0f);
        final PartDefinition partRoot = mesh.m_171576_();
        partRoot.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-4.0f, -4.0f, -4.0f, 8.0f, 8.0f, 8.0f), PartPose.m_171419_(0.0f, -4.0f, 0.0f));
        partRoot.m_171599_("hat", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, new CubeDeformation(0.5f)), PartPose.m_171419_(0.0f, -4.0f, 0.0f));
        partRoot.m_171599_("collar", CubeListBuilder.m_171558_().m_171514_(32, 16).m_171481_(-6.0f, -2.0f, -4.0f, 12.0f, 12.0f, 1.0f), PartPose.m_171423_(0.0f, -3.0f, -1.0f, 2.164208f, 0.0f, 0.0f));
        partRoot.m_171599_("cloak", CubeListBuilder.m_171558_().m_171514_(0, 44).m_171481_(-6.0f, 2.0f, 0.0f, 12.0f, 19.0f, 1.0f), PartPose.m_171419_(0.0f, -4.0f, 2.5f));
        partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(8, 16).m_171481_(-4.0f, 0.0f, -2.0f, 8.0f, 24.0f, 4.0f), PartPose.m_171419_(0.0f, -4.0f, 0.0f));
        partRoot.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171481_(-2.0f, -2.0f, -2.0f, 2.0f, 12.0f, 2.0f), PartPose.m_171419_(-5.0f, -2.0f, 0.0f));
        partRoot.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171480_().m_171514_(0, 16).m_171481_(-1.0f, -2.0f, -2.0f, 2.0f, 12.0f, 2.0f), PartPose.m_171419_(5.0f, 2.0f, 0.0f));
        partRoot.m_171599_("right_leg", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171481_(-1.0f, 0.0f, -1.0f, 2.0f, 12.0f, 2.0f), PartPose.m_171419_(-2.0f, 12.0f, 0.0f));
        partRoot.m_171599_("left_leg", CubeListBuilder.m_171558_().m_171480_().m_171514_(0, 16).m_171481_(-1.0f, 0.0f, -1.0f, 2.0f, 12.0f, 2.0f), PartPose.m_171419_(2.0f, 12.0f, 0.0f));
        return LayerDefinition.m_171565_(mesh, 64, 64);
    }
    
    public void m_7695_(final PoseStack stack, final VertexConsumer builder, final int light, final int overlay, final float red, final float green, final float blue, final float alpha) {
        if (!this.shadowClone) {
            super.m_7695_(stack, builder, light, overlay, red, green, blue, alpha);
        }
        else {
            final float shadow = 0.33f;
            super.m_7695_(stack, builder, light, overlay, red * shadow, green * shadow, blue * shadow, 0.8f);
        }
    }
    
    protected Iterable<ModelPart> m_5608_() {
        if (this.shadowClone) {
            return super.m_5608_();
        }
        return Iterables.concat((Iterable)Arrays.asList(this.cloak, this.collar), super.m_5608_());
    }
    
    public void setupAnim(final Lich entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.shadowClone = entity.isShadowClone();
        super.m_6973_((LivingEntity)entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        final float ogSin = Mth.m_14031_(this.f_102608_ * 3.141593f);
        final float otherSin = Mth.m_14031_((1.0f - (1.0f - this.f_102608_) * (1.0f - this.f_102608_)) * 3.141593f);
        this.f_102811_.f_104205_ = 0.0f;
        this.f_102812_.f_104205_ = 0.5f;
        this.f_102811_.f_104204_ = -(0.1f - ogSin * 0.6f);
        this.f_102812_.f_104204_ = 0.1f - ogSin * 0.6f;
        this.f_102811_.f_104203_ = -1.570796f;
        this.f_102812_.f_104203_ = -3.141593f;
        final ModelPart f_102811_ = this.f_102811_;
        f_102811_.f_104203_ -= ogSin * 1.2f - otherSin * 0.4f;
        final ModelPart f_102812_ = this.f_102812_;
        f_102812_.f_104203_ -= ogSin * 1.2f - otherSin * 0.4f;
        final ModelPart f_102811_2 = this.f_102811_;
        f_102811_2.f_104205_ += Mth.m_14089_(ageInTicks * 0.26f) * 0.15f + 0.05f;
        final ModelPart f_102812_2 = this.f_102812_;
        f_102812_2.f_104205_ -= Mth.m_14089_(ageInTicks * 0.26f) * 0.15f + 0.05f;
        final ModelPart f_102811_3 = this.f_102811_;
        f_102811_3.f_104203_ += Mth.m_14031_(ageInTicks * 0.167f) * 0.15f;
        final ModelPart f_102812_3 = this.f_102812_;
        f_102812_3.f_104203_ -= Mth.m_14031_(ageInTicks * 0.167f) * 0.15f;
        this.f_102808_.f_104201_ = -4.0f;
        this.f_102809_.f_104201_ = -4.0f;
    }
}
