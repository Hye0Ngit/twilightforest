// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import twilightforest.entity.boss.KnightPhantom;
import net.minecraft.client.model.HumanoidModel;

public class KnightPhantomModel extends HumanoidModel<KnightPhantom>
{
    private KnightPhantom knight;
    
    public KnightPhantomModel(final ModelPart root) {
        super(root);
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = HumanoidModel.m_170681_(CubeDeformation.f_171458_, 0.0f);
        final PartDefinition partRoot = mesh.m_171576_();
        partRoot.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(40, 16).m_171481_(-1.0f, -2.0f, -1.0f, 2.0f, 12.0f, 2.0f), PartPose.m_171419_(-5.0f, 2.0f, 0.0f));
        partRoot.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171480_().m_171514_(40, 16).m_171481_(-1.0f, -2.0f, -1.0f, 2.0f, 12.0f, 2.0f), PartPose.m_171419_(5.0f, 2.0f, 0.0f));
        partRoot.m_171599_("right_leg", CubeListBuilder.m_171558_().m_171480_().m_171514_(0, 16).m_171481_(-1.0f, 0.0f, -1.0f, 2.0f, 12.0f, 2.0f), PartPose.m_171419_(-2.0f, 12.0f, 0.0f));
        partRoot.m_171599_("left_leg", CubeListBuilder.m_171558_().m_171480_().m_171514_(0, 16).m_171481_(-1.0f, 0.0f, -1.0f, 2.0f, 12.0f, 2.0f), PartPose.m_171419_(2.0f, 12.0f, 0.0f));
        return LayerDefinition.m_171565_(mesh, 64, 32);
    }
    
    public void m_7695_(final PoseStack stack, final VertexConsumer builder, final int light, final int overlay, final float red, final float green, final float blue, final float scale) {
        if (this.knight != null && this.knight.isChargingAtPlayer()) {
            super.m_7695_(stack, builder, light, overlay, red, green, blue, scale);
        }
    }
    
    public void setupAnim(final KnightPhantom entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        super.m_6973_((LivingEntity)(this.knight = entity), limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        this.f_102814_.f_104204_ = 0.0f;
        this.f_102814_.f_104205_ = 0.0f;
        this.f_102813_.f_104204_ = 0.0f;
        this.f_102813_.f_104205_ = 0.0f;
        this.f_102813_.f_104203_ = 0.2f * Mth.m_14031_(ageInTicks * 0.3f) + 0.4f;
        this.f_102814_.f_104203_ = 0.2f * Mth.m_14031_(ageInTicks * 0.3f) + 0.4f;
    }
}
