// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.model.HumanoidModel;
import twilightforest.entity.monster.BlockChainGoblin;

@OnlyIn(Dist.CLIENT)
public class BlockChainGoblinModel<T extends BlockChainGoblin> extends HumanoidModel<T>
{
    private final ModelPart block;
    
    public BlockChainGoblinModel(final ModelPart root) {
        super(root);
        this.block = root.m_171324_("block");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = HumanoidModel.m_170681_(CubeDeformation.f_171458_, 0.0f);
        final PartDefinition partRoot = mesh.m_171576_();
        partRoot.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(52, 2).m_171481_(-1.5f, -2.0f, -1.5f, 3.0f, 12.0f, 3.0f), PartPose.m_171423_(-5.0f, 12.0f, 0.0f, 0.0f, 0.0f, 3.0543263f));
        partRoot.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171514_(52, 17).m_171481_(-1.5f, -2.0f, -1.5f, 3.0f, 12.0f, 3.0f), PartPose.m_171423_(5.0f, 12.0f, 0.0f, 0.0f, 0.0f, -3.0543263f));
        partRoot.m_171599_("right_leg", CubeListBuilder.m_171558_().m_171514_(0, 33).m_171481_(-1.4f, 0.0f, -1.5f, 3.0f, 6.0f, 3.0f), PartPose.m_171419_(-2.0f, 18.0f, 0.0f));
        partRoot.m_171599_("left_leg", CubeListBuilder.m_171558_().m_171514_(12, 33).m_171481_(-1.6f, 0.0f, -1.5f, 3.0f, 6.0f, 3.0f), PartPose.m_171419_(2.0f, 18.0f, 0.0f));
        partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(28, 6).m_171481_(-3.5f, 1.0f, -2.0f, 7.0f, 6.0f, 4.0f), PartPose.m_171419_(0.0f, 12.0f, 0.0f));
        final PartDefinition head = partRoot.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 18).m_171481_(-7.5f, -9.0f, -2.03f, 15.0f, 10.0f, 2.0f), PartPose.m_171430_(0.0f, -0.7853982f, 0.0f));
        partRoot.m_171599_("hat", CubeListBuilder.m_171558_(), PartPose.f_171404_);
        head.m_171599_("helm", CubeListBuilder.m_171558_().m_171514_(0, 5).m_171481_(-2.5f, -7.0f, -2.5f, 5.0f, 8.0f, 5.0f), PartPose.m_171430_(0.0f, 0.7853982f, 0.0f));
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
        block.m_171599_("spikes_23", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(0.0f, 0.0f, -4.0f, 0.7853982f, 0.0f, 0.0f));
        block.m_171599_("spikes_24", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(-4.0f, 0.0f, -4.0f, -0.9599311f, 0.7853982f, 0.0f));
        block.m_171599_("spikes_25", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(-4.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.7853982f));
        block.m_171599_("spikes_26", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(-4.0f, 0.0f, 4.0f, -0.61086524f, -0.7853982f, 0.0f));
        return LayerDefinition.m_171565_(mesh, 64, 48);
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
        f_102811_.f_104203_ += 3.1415927f;
        this.f_102812_.m_104227_(3.5f, 12.0f, 0.0f);
        final ModelPart f_102812_ = this.f_102812_;
        f_102812_.f_104203_ += 3.1415927f;
        final float angle = ageInTicks / 4.0f;
        final float length = 0.0f;
        this.block.f_104200_ = Mth.m_14031_(angle) * length;
        this.block.f_104202_ = -Mth.m_14089_(angle) * length;
        this.block.f_104204_ = -angle;
    }
}
