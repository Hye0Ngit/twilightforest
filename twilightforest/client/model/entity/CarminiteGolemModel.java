// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;
import twilightforest.entity.monster.CarminiteGolem;

public class CarminiteGolemModel<T extends CarminiteGolem> extends HierarchicalModel<T>
{
    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart rightArm;
    private final ModelPart leftArm;
    private final ModelPart leftLeg;
    private final ModelPart rightLeg;
    
    public CarminiteGolemModel(final ModelPart root) {
        this.root = root;
        this.head = this.root.m_171324_("head");
        this.rightArm = this.root.m_171324_("right_arm");
        this.leftArm = this.root.m_171324_("left_arm");
        this.rightLeg = this.root.m_171324_("right_leg");
        this.leftLeg = this.root.m_171324_("left_leg");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = new MeshDefinition();
        final PartDefinition partRoot = mesh.m_171576_();
        partRoot.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-3.5f, -10.0f, -3.0f, 7.0f, 8.0f, 6.0f).m_171514_(0, 14).m_171481_(-4.0f, -6.0f, -3.5f, 8.0f, 4.0f, 6.0f), PartPose.m_171419_(0.0f, -11.0f, -2.0f));
        final PartDefinition body = partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 26).m_171481_(-8.0f, 0.0f, -5.0f, 16.0f, 10.0f, 10.0f), PartPose.m_171419_(0.0f, -13.0f, 0.0f));
        partRoot.m_171599_("ribs", CubeListBuilder.m_171558_().m_171514_(0, 46).m_171481_(-5.0f, 0.0f, -3.0f, 10.0f, 6.0f, 6.0f), PartPose.m_171419_(0.0f, -3.0f, 0.0f));
        partRoot.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(52, 0).m_171481_(-5.0f, -2.0f, -1.5f, 3.0f, 14.0f, 3.0f).m_171514_(52, 17).m_171481_(-7.0f, 12.0f, -3.0f, 6.0f, 12.0f, 6.0f).m_171514_(52, 36).m_171481_(-7.0f, -3.0f, -3.5f, 7.0f, 2.0f, 7.0f).m_171514_(52, 45).m_171481_(-7.0f, -1.0f, -3.5f, 7.0f, 5.0f, 2.0f).m_171514_(52, 45).m_171481_(-7.0f, -1.0f, 1.5f, 7.0f, 5.0f, 2.0f).m_171514_(52, 54).m_171481_(-2.0f, -1.0f, -2.0f, 2.0f, 5.0f, 3.0f), PartPose.m_171419_(-8.0f, -12.0f, 0.0f));
        partRoot.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171480_().m_171514_(52, 0).m_171481_(2.0f, -2.0f, -1.5f, 3.0f, 14.0f, 3.0f).m_171514_(52, 17).m_171481_(1.0f, 12.0f, -3.0f, 6.0f, 12.0f, 6.0f).m_171514_(52, 36).m_171481_(0.0f, -3.0f, -3.5f, 7.0f, 2.0f, 7.0f).m_171514_(52, 45).m_171481_(0.0f, -1.0f, -3.5f, 7.0f, 5.0f, 2.0f).m_171514_(52, 45).m_171481_(0.0f, -1.0f, 1.5f, 7.0f, 5.0f, 2.0f).m_171514_(52, 54).m_171481_(0.0f, -1.0f, -2.0f, 2.0f, 5.0f, 3.0f), PartPose.m_171419_(8.0f, -12.0f, 0.0f));
        partRoot.m_171599_("hips", CubeListBuilder.m_171558_().m_171514_(84, 25).m_171481_(-5.0f, 0.0f, -2.0f, 10.0f, 3.0f, 4.0f), PartPose.m_171419_(0.0f, 1.0f, 0.0f));
        partRoot.m_171599_("spine", CubeListBuilder.m_171558_().m_171514_(84, 18).m_171481_(-1.5f, 0.0f, -1.5f, 3.0f, 4.0f, 3.0f), PartPose.m_171419_(0.0f, -3.0f, 0.0f));
        partRoot.m_171599_("right_leg", CubeListBuilder.m_171558_().m_171514_(84, 32).m_171481_(-3.0f, 0.0f, -1.5f, 3.0f, 8.0f, 3.0f).m_171514_(84, 43).m_171481_(-5.5f, 8.0f, -4.0f, 6.0f, 14.0f, 7.0f), PartPose.m_171419_(-1.0f, 2.0f, 0.0f));
        partRoot.m_171599_("left_leg", CubeListBuilder.m_171558_().m_171480_().m_171514_(84, 32).m_171481_(0.0f, 0.0f, -1.5f, 3.0f, 8.0f, 3.0f).m_171514_(84, 43).m_171481_(-0.5f, 8.0f, -4.0f, 6.0f, 14.0f, 7.0f), PartPose.m_171419_(1.0f, 2.0f, 0.0f));
        return LayerDefinition.m_171565_(mesh, 128, 64);
    }
    
    public ModelPart m_142109_() {
        return this.root;
    }
    
    public void setupAnim(final T entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.head.f_104204_ = netHeadYaw * 0.017453292f;
        this.head.f_104203_ = headPitch * 0.017453292f;
        this.leftLeg.f_104203_ = -1.5f * this.func_78172_a(limbSwing, 13.0f) * limbSwingAmount;
        this.rightLeg.f_104203_ = 1.5f * this.func_78172_a(limbSwing, 13.0f) * limbSwingAmount;
        this.leftLeg.f_104204_ = 0.0f;
        this.rightLeg.f_104204_ = 0.0f;
        this.rightArm.f_104205_ = Mth.m_14089_(ageInTicks * 0.09f) * 0.05f + 0.05f;
        this.leftArm.f_104205_ = -Mth.m_14089_(ageInTicks * 0.09f) * 0.05f - 0.05f;
    }
    
    public void prepareMobModel(final T entity, final float limbSwing, final float limbSwingAmount, final float partialTicks) {
        final int var6 = entity.getAttackTimer();
        if (var6 > 0) {
            this.rightArm.f_104203_ = -2.0f + 1.5f * this.func_78172_a(var6 - partialTicks, 10.0f);
            this.leftArm.f_104203_ = -2.0f + 1.5f * this.func_78172_a(var6 - partialTicks, 10.0f);
        }
        else {
            this.rightArm.f_104203_ = (-0.2f + 1.5f * this.func_78172_a(limbSwing, 25.0f)) * limbSwingAmount;
            this.leftArm.f_104203_ = (-0.2f - 1.5f * this.func_78172_a(limbSwing, 25.0f)) * limbSwingAmount;
        }
    }
    
    private float func_78172_a(final float par1, final float par2) {
        return (Math.abs(par1 % par2 - par2 * 0.5f) - par2 * 0.25f) / (par2 * 0.25f);
    }
}
