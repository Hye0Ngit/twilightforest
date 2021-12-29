// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.armor;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import com.google.common.collect.Iterables;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.EquipmentSlot;

public class YetiArmorModel extends TFArmorModel
{
    private final EquipmentSlot slot;
    private final ModelPart bipedLegBody;
    private final ModelPart rightRuff;
    private final ModelPart leftRuff;
    private final ModelPart rightToe;
    private final ModelPart leftToe;
    
    public YetiArmorModel(final EquipmentSlot slot, final ModelPart part) {
        super(part);
        this.slot = slot;
        this.bipedLegBody = part.m_171324_("biped_leg_body");
        this.rightRuff = this.f_102813_.m_171324_("right_ruff");
        this.leftRuff = this.f_102814_.m_171324_("left_ruff");
        this.rightToe = this.f_102813_.m_171324_("right_toe");
        this.leftToe = this.f_102814_.m_171324_("left_toe");
    }
    
    public static MeshDefinition addPieces(final CubeDeformation deformation) {
        final MeshDefinition meshdefinition = HumanoidModel.m_170681_(deformation, 0.0f);
        final PartDefinition partdefinition = meshdefinition.m_171576_();
        final PartDefinition head = partdefinition.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.5f, -7.5f, -4.0f, 9.0f, 8.0f, 8.0f, deformation), PartPose.m_171419_(0.0f, 0.0f, 0.0f));
        addPairHorns(head, 1, -8.0f, 35.0f);
        addPairHorns(head, 2, -6.0f, 15.0f);
        addPairHorns(head, 3, -4.0f, -5.0f);
        final PartDefinition rightLeg = partdefinition.m_171599_("right_leg", CubeListBuilder.m_171558_().m_171514_(40, 0).m_171488_(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, deformation), PartPose.m_171419_(-1.9f, 12.0f, 0.0f));
        final PartDefinition leftLeg = partdefinition.m_171599_("left_leg", CubeListBuilder.m_171558_().m_171514_(40, 0).m_171480_().m_171488_(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, deformation), PartPose.m_171419_(1.9f, 12.0f, 0.0f));
        rightLeg.m_171599_("right_ruff", CubeListBuilder.m_171558_().m_171514_(40, 22).m_171488_(-2.5f, 0.0f, -2.5f, 5.0f, 2.0f, 5.0f, deformation), PartPose.m_171419_(0.0f, 6.0f, 0.0f));
        leftLeg.m_171599_("left_ruff", CubeListBuilder.m_171558_().m_171514_(40, 22).m_171488_(-2.5f, 0.0f, -2.5f, 5.0f, 2.0f, 5.0f, deformation), PartPose.m_171419_(0.0f, 6.0f, 0.0f));
        rightLeg.m_171599_("right_toe", CubeListBuilder.m_171558_().m_171514_(40, 17).m_171488_(-2.0f, 0.0f, -1.0f, 4.0f, 2.0f, 1.0f, deformation), PartPose.m_171419_(0.0f, 10.0f, -2.0f));
        leftLeg.m_171599_("left_toe", CubeListBuilder.m_171558_().m_171514_(40, 17).m_171488_(-2.0f, 0.0f, -1.0f, 4.0f, 2.0f, 1.0f, deformation), PartPose.m_171419_(0.0f, 10.0f, -2.0f));
        partdefinition.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.0f, 0.0f, -2.0f, 8.0f, 11.0f, 4.0f, deformation), PartPose.m_171419_(0.0f, 0.0f, 0.0f));
        partdefinition.m_171599_("biped_leg_body", CubeListBuilder.m_171558_().m_171514_(40, 16).m_171488_(-4.0f, 0.0f, -2.0f, 8.0f, 12.0f, 4.0f, deformation), PartPose.m_171419_(0.0f, 0.0f, 0.0f));
        partdefinition.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-3.0f, -2.0f, -2.0f, 4.0f, 10.0f, 4.0f, deformation), PartPose.m_171419_(-5.0f, 2.0f, 0.0f));
        partdefinition.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171480_().m_171488_(-1.0f, -2.0f, -2.0f, 4.0f, 10.0f, 4.0f, deformation), PartPose.m_171419_(5.0f, 2.0f, 0.0f));
        return meshdefinition;
    }
    
    protected Iterable<ModelPart> m_5608_() {
        return Iterables.concat(super.m_5608_(), (Iterable)ImmutableList.of((Object)this.bipedLegBody));
    }
    
    private static void addPairHorns(final PartDefinition partdefinition, final int iter, final float height, final float zangle) {
        final PartDefinition leftBottom = partdefinition.m_171599_("horn_" + iter + "_left_bottom", CubeListBuilder.m_171558_().m_171514_(0, 19).m_171481_(-3.0f, -1.5f, -1.5f, 3.0f, 3.0f, 3.0f), PartPose.m_171423_(-4.5f, height, -1.0f, 0.0f, -0.5235988f, zangle / 57.295776f));
        leftBottom.m_171599_("horn_" + iter + "_left_top", CubeListBuilder.m_171558_().m_171514_(0, 26).m_171481_(-4.0f, -1.0f, -1.0f, 5.0f, 2.0f, 2.0f), PartPose.m_171423_(-3.0f, 0.0f, 0.0f, 0.0f, -0.34906587f, zangle / 57.295776f));
        final PartDefinition rightBottom = partdefinition.m_171599_("horn_" + iter + "_right_bottom", CubeListBuilder.m_171558_().m_171514_(0, 19).m_171481_(0.0f, -1.5f, -1.5f, 3.0f, 3.0f, 3.0f), PartPose.m_171423_(4.5f, height, -1.0f, 0.0f, 0.5235988f, -zangle / 57.295776f));
        rightBottom.m_171599_("horn_" + iter + "_right_top", CubeListBuilder.m_171558_().m_171514_(0, 26).m_171481_(-1.0f, -1.0f, -1.0f, 5.0f, 2.0f, 2.0f), PartPose.m_171423_(3.0f, 0.0f, 0.0f, 0.0f, 0.34906587f, -zangle / 57.295776f));
    }
    
    public void m_8009_(final boolean visible) {
        super.m_8009_(visible);
        this.bipedLegBody.f_104207_ = visible;
    }
    
    public void m_7695_(final PoseStack stack, final VertexConsumer builder, final int light, final int overlay, final float red, final float green, final float blue, final float scale) {
        switch (this.slot) {
            case HEAD: {
                this.f_102808_.f_104207_ = true;
                this.f_102809_.f_104207_ = false;
                this.f_102810_.f_104207_ = false;
                this.f_102811_.f_104207_ = false;
                this.f_102812_.f_104207_ = false;
                this.bipedLegBody.f_104207_ = false;
                this.f_102813_.f_104207_ = false;
                this.f_102814_.f_104207_ = false;
                break;
            }
            case CHEST: {
                this.f_102808_.f_104207_ = false;
                this.f_102809_.f_104207_ = false;
                this.f_102810_.f_104207_ = true;
                this.f_102811_.f_104207_ = true;
                this.f_102812_.f_104207_ = true;
                this.bipedLegBody.f_104207_ = false;
                this.f_102813_.f_104207_ = false;
                this.f_102814_.f_104207_ = false;
                break;
            }
            case LEGS: {
                this.f_102808_.f_104207_ = false;
                this.f_102809_.f_104207_ = false;
                this.f_102810_.f_104207_ = false;
                this.f_102811_.f_104207_ = false;
                this.f_102812_.f_104207_ = false;
                this.bipedLegBody.f_104207_ = true;
                this.f_102813_.f_104207_ = true;
                this.f_102814_.f_104207_ = true;
                this.leftRuff.f_104207_ = false;
                this.leftToe.f_104207_ = false;
                this.rightRuff.f_104207_ = false;
                this.rightToe.f_104207_ = false;
                break;
            }
            case FEET: {
                this.f_102808_.f_104207_ = false;
                this.f_102809_.f_104207_ = false;
                this.f_102810_.f_104207_ = false;
                this.f_102811_.f_104207_ = false;
                this.f_102812_.f_104207_ = false;
                this.bipedLegBody.f_104207_ = false;
                this.f_102813_.f_104207_ = true;
                this.f_102814_.f_104207_ = true;
                this.leftRuff.f_104207_ = true;
                this.leftToe.f_104207_ = true;
                this.rightRuff.f_104207_ = true;
                this.rightToe.f_104207_ = true;
                break;
            }
        }
        super.m_7695_(stack, builder, light, overlay, red, green, blue, scale);
    }
}
