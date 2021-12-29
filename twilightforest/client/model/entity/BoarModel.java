// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.model.PigModel;
import twilightforest.entity.passive.Boar;

@OnlyIn(Dist.CLIENT)
public class BoarModel<T extends Boar> extends PigModel<T>
{
    public BoarModel(final ModelPart root) {
        super(root);
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = QuadrupedModel.m_170864_(6, CubeDeformation.f_171458_);
        final PartDefinition partRoot = mesh.m_171576_();
        partRoot.m_171599_("right_front_leg", CubeListBuilder.m_171558_().m_171514_(0, 13).m_171481_(-2.0f, 0.0f, -1.9f, 4.0f, 6.0f, 4.0f), PartPose.m_171419_(-2.9f, 18.0f, -2.0f));
        partRoot.m_171599_("left_front_leg", CubeListBuilder.m_171558_().m_171514_(0, 23).m_171481_(-2.0f, 0.0f, -1.9f, 4.0f, 6.0f, 4.0f), PartPose.m_171419_(2.9f, 18.0f, -2.0f));
        partRoot.m_171599_("right_hind_leg", CubeListBuilder.m_171558_().m_171514_(0, 33).m_171481_(-2.0f, 0.0f, -2.0f, 4.0f, 6.0f, 4.0f), PartPose.m_171419_(-3.1f, 18.0f, 9.0f));
        partRoot.m_171599_("left_hind_leg", CubeListBuilder.m_171558_().m_171514_(0, 43).m_171481_(-2.0f, 0.0f, -2.0f, 4.0f, 6.0f, 4.0f), PartPose.m_171419_(3.1f, 18.0f, 9.0f));
        partRoot.m_171599_("head", CubeListBuilder.m_171558_().m_171481_(-4.0f, -4.0f, -5.0f, 8.0f, 7.0f, 6.0f).m_171514_(46, 22).m_171481_(-3.0f, -1.0f, -8.0f, 6.0f, 4.0f, 3.0f).m_171514_(28, 0).m_171481_(-4.0f, 0.0f, -8.0f, 1.0f, 2.0f, 1.0f).m_171514_(28, 3).m_171481_(3.0f, 0.0f, -8.0f, 1.0f, 2.0f, 1.0f), PartPose.m_171419_(0.0f, 15.5f, -5.0f));
        partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(28, 0).m_171481_(-5.0f, -6.0f, 0.0f, 10.0f, 14.0f, 8.0f), PartPose.m_171423_(0.0f, 19.0f, 2.0f, 1.6580628f, 0.0f, 0.0f));
        return LayerDefinition.m_171565_(mesh, 64, 64);
    }
    
    public void setupAnim(final T entityIn, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.f_103492_.f_104203_ = headPitch * 0.017453292f;
        this.f_103492_.f_104204_ = netHeadYaw * 0.017453292f;
        this.f_103493_.f_104203_ = 1.5707964f;
        this.f_170852_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.f_170853_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.f_170854_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.f_170855_.f_104203_ = Mth.m_14089_(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
    }
}
