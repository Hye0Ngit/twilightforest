// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity.legacy;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HumanoidModel;
import twilightforest.entity.monster.BlockChainGoblin;

public class BlockChainGoblinLegacyModel<T extends BlockChainGoblin> extends HumanoidModel<T>
{
    ModelPart block;
    
    public BlockChainGoblinLegacyModel(final ModelPart root) {
        super(root);
        this.block = root.m_171324_("block");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = HumanoidModel.m_170681_(CubeDeformation.f_171458_, 0.0f);
        final PartDefinition partRoot = mesh.m_171576_();
        partRoot.m_171599_("head", CubeListBuilder.m_171558_(), PartPose.f_171404_);
        final PartDefinition hat = partRoot.m_171599_("hat", CubeListBuilder.m_171558_(), PartPose.f_171404_);
        hat.m_171599_("helmet", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171481_(-2.5f, -9.0f, -2.5f, 5.0f, 9.0f, 5.0f), PartPose.m_171423_(0.0f, 0.0f, 0.0f, 0.0f, 0.7853982f, 0.0f));
        partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 21).m_171481_(-3.5f, 0.0f, -2.0f, 7.0f, 7.0f, 4.0f), PartPose.m_171419_(0.0f, 11.0f, 0.0f));
        partRoot.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(52, 0).m_171481_(-3.0f, -1.0f, -2.0f, 3.0f, 12.0f, 3.0f), PartPose.m_171419_(-3.5f, 12.0f, 0.0f));
        partRoot.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171514_(52, 0).m_171481_(0.0f, -1.0f, -1.5f, 3.0f, 12.0f, 3.0f), PartPose.m_171419_(3.5f, 12.0f, 0.0f));
        partRoot.m_171599_("right_leg", CubeListBuilder.m_171558_().m_171514_(0, 12).m_171481_(-1.5f, 0.0f, -1.5f, 3.0f, 6.0f, 3.0f), PartPose.m_171419_(-2.0f, 18.0f, 0.0f));
        partRoot.m_171599_("left_leg", CubeListBuilder.m_171558_().m_171514_(0, 12).m_171481_(-1.5f, 0.0f, -1.5f, 3.0f, 6.0f, 3.0f), PartPose.m_171419_(2.0f, 18.0f, 0.0f));
        final PartDefinition block = partRoot.m_171599_("block", CubeListBuilder.m_171558_().m_171514_(32, 32).m_171481_(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f), PartPose.f_171404_);
        final float QUARTER_PI = 0.7853982f;
        final float ANGLE_MINOR = -0.61086524f;
        final float ANGLE_MAJOR = -0.9599311f;
        block.m_171599_("spikes_0", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(0.0f, -9.0f, 0.0f, 0.0f, 0.0f, 0.0f));
        block.m_171599_("spikes_1", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(0.0f, -8.0f, 4.0f, 0.7853982f, 0.0f, 0.0f));
        block.m_171599_("spikes_2", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(4.0f, -8.0f, 4.0f, -0.9599311f, 0.7853982f, 0.0f));
        block.m_171599_("spikes_3", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(4.0f, -8.0f, 0.0f, 0.0f, 0.0f, 0.7853982f));
        block.m_171599_("spikes_4", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(4.0f, -8.0f, -4.0f, -0.61086524f, -0.7853982f, 0.0f));
        block.m_171599_("spikes_5", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(0.0f, -8.0f, -4.0f, 0.7853982f, 0.0f, 0.0f));
        block.m_171599_("spikes_6", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(-4.0f, -8.0f, -4.0f, -0.61086524f, 0.7853982f, 0.0f));
        block.m_171599_("spikes_7", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(-4.0f, -8.0f, 0.0f, 0.0f, 0.0f, 0.7853982f));
        block.m_171599_("spikes_8", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(-4.0f, -8.0f, 4.0f, -0.9599311f, -0.7853982f, 0.0f));
        block.m_171599_("spikes_9", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(0.0f, -4.0f, 0.0f, 0.0f, 0.0f, 0.0f));
        block.m_171599_("spikes_10", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(0.0f, -4.0f, 4.0f, 0.0f, 0.0f, 0.0f));
        block.m_171599_("spikes_11", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(4.0f, -4.0f, 5.0f, 0.0f, 0.7853982f, 0.0f));
        block.m_171599_("spikes_12", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(5.0f, -4.0f, 0.0f, 0.0f, 0.0f, 0.0f));
        block.m_171599_("spikes_13", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(4.0f, -4.0f, -4.0f, 0.0f, 0.7853982f, 0.0f));
        block.m_171599_("spikes_14", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(0.0f, -4.0f, -5.0f, 0.0f, 0.0f, 0.0f));
        block.m_171599_("spikes_15", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(-4.0f, -4.0f, -4.0f, 0.0f, 0.7853982f, 0.0f));
        block.m_171599_("spikes_16", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(-5.0f, -4.0f, 0.0f, 0.0f, 0.0f, 0.0f));
        block.m_171599_("spikes_17", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(-4.0f, -4.0f, 4.0f, 0.0f, 0.7853982f, 0.0f));
        block.m_171599_("spikes_18", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f));
        block.m_171599_("spikes_19", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(0.0f, 0.0f, 4.0f, 0.7853982f, 0.0f, 0.0f));
        block.m_171599_("spikes_20", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(4.0f, 0.0f, 4.0f, -0.61086524f, 0.7853982f, 0.0f));
        block.m_171599_("spikes_21", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(4.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.7853982f));
        block.m_171599_("spikes_22", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(4.0f, 0.0f, -4.0f, -0.9599311f, -0.7853982f, 0.0f));
        block.m_171599_("spikes_23", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(4.0f, 0.0f, -4.0f, 0.7853982f, 0.0f, 0.0f));
        block.m_171599_("spikes_24", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(-4.0f, 0.0f, -4.0f, -0.9599311f, 0.7853982f, 0.0f));
        block.m_171599_("spikes_25", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(-4.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.7853982f));
        block.m_171599_("spikes_26", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(-4.0f, 0.0f, 4.0f, -0.61086524f, -0.7853982f, 0.0f));
        return LayerDefinition.m_171565_(mesh, 64, 32);
    }
    
    public void setupAnim(final T entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        super.m_6973_((LivingEntity)entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        this.f_102808_.f_104201_ = 11.0f;
        this.f_102809_.f_104201_ = 11.0f;
        this.f_102810_.f_104201_ = 11.0f;
        this.f_102813_.f_104201_ = 18.0f;
        this.f_102814_.f_104201_ = 18.0f;
        this.f_102811_.m_104227_(-3.5f, 12.0f, 0.0f);
        final ModelPart f_102811_ = this.f_102811_;
        f_102811_.f_104203_ += (float)3.141592653589793;
        this.f_102812_.m_104227_(3.5f, 12.0f, 0.0f);
        final ModelPart f_102812_ = this.f_102812_;
        f_102812_.f_104203_ += (float)3.141592653589793;
        final float angle = ageInTicks / 4.0f;
        final float length = 0.0f;
        this.block.f_104200_ = (float)Math.sin(angle) * length;
        this.block.f_104202_ = (float)(-Math.cos(angle)) * length;
        this.block.f_104204_ = -angle;
    }
}
