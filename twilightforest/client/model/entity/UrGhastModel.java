// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.world.entity.Entity;
import twilightforest.entity.monster.CarminiteGhastguard;
import net.minecraft.util.Mth;
import twilightforest.TwilightForestMod;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.entity.boss.UrGhast;

@OnlyIn(Dist.CLIENT)
public class UrGhastModel extends TFGhastModel<UrGhast>
{
    private final ModelPart[][] tentacles;
    
    public UrGhastModel(final ModelPart root) {
        super(root);
        this.tentacles = new ModelPart[9][3];
        final ModelPart body = root.m_171324_("body");
        for (int i = 0; i < this.tentacles.length; ++i) {
            this.tentacles[i][0] = body.m_171324_("tentacle_" + i);
            this.tentacles[i][1] = this.tentacles[i][0].m_171324_("tentacle_" + i + "_extension");
            this.tentacles[i][2] = this.tentacles[i][1].m_171324_("tentacle_" + i + "_tip");
        }
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = new MeshDefinition();
        final PartDefinition partRoot = mesh.m_171576_();
        final PartDefinition body = partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-8.0f, -8.0f, -8.0f, 16.0f, 16.0f, 16.0f), PartPose.m_171419_(0.0f, 8.0f, 0.0f));
        for (int i = 0; i < 9; ++i) {
            makeTentacle(body, "tentacle_" + i, i);
        }
        return LayerDefinition.m_171565_(mesh, 64, 32);
    }
    
    private static void makeTentacle(final PartDefinition parent, final String name, final int iteration) {
        final CubeListBuilder 171481_ = CubeListBuilder.m_171558_().m_171481_(-1.5f, 0.0f, -1.5f, 3.333f, 5.333f, 3.333f);
        PartPose partPose = switch (iteration) {
            case 0 -> PartPose.m_171419_(4.5f, 7.0f, 4.5f);
            case 1 -> PartPose.m_171419_(-4.5f, 7.0f, 4.5f);
            case 2 -> PartPose.m_171419_(0.0f, 7.0f, 0.0f);
            case 3 -> PartPose.m_171419_(5.5f, 7.0f, -4.5f);
            case 4 -> PartPose.m_171419_(-5.5f, 7.0f, -4.5f);
            case 5 -> PartPose.m_171423_(-7.5f, 3.5f, -1.0f, 0.0f, 0.0f, 0.7853982f);
            case 6 -> PartPose.m_171423_(-7.5f, -1.5f, 3.5f, 0.0f, 0.0f, 1.0471976f);
            case 7 -> PartPose.m_171423_(7.5f, 3.5f, -1.0f, 0.0f, 0.0f, -0.7853982f);
            case 8 -> PartPose.m_171423_(7.5f, -1.5f, 3.5f, 0.0f, 0.0f, -1.0471976f);
            default -> {
                TwilightForestMod.LOGGER.warn("Out of bounds with Ur-Ghast limb creation: Iteration " + iteration);
                yield PartPose.f_171404_;
            }
        };
        final PartDefinition tentacleBase = parent.m_171599_(name, 171481_, partPose);
        final PartDefinition tentacleExtension = tentacleBase.m_171599_(name + "_extension", CubeListBuilder.m_171558_().m_171514_(0, 3).m_171481_(-1.5f, -1.35f, -1.5f, 3.333f, 6.66f, 3.333f), PartPose.m_171419_(0.0f, 6.66f, 0.0f));
        tentacleExtension.m_171599_(name + "_tip", CubeListBuilder.m_171558_().m_171514_(0, 9).m_171481_(-1.5f, 1.3f, -1.5f, 3.333f, 4.0f, 3.333f), PartPose.m_171419_(0.0f, 4.0f, 0.0f));
    }
    
    @Override
    public void setupAnim(final UrGhast entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        for (int i = 0; i < this.tentacles.length; ++i) {
            final float wiggle = Math.min(limbSwingAmount, 0.6f);
            final float time = (ageInTicks + i * 9) / 2.0f;
            this.tentacles[i][1].f_104203_ = (Mth.m_14089_(time * 0.6662f) - 1.0471976f) * wiggle;
            this.tentacles[i][2].f_104203_ = Mth.m_14089_(time * 0.7774f) * 1.2f * wiggle;
            this.tentacles[i][1].f_104203_ = 0.1f + Mth.m_14089_(time * 0.3335f) * 0.15f;
            this.tentacles[i][2].f_104203_ = 0.1f + Mth.m_14089_(time * 0.4445f) * 0.2f;
            final float yTwist = 0.4f;
            this.tentacles[i][0].f_104204_ = yTwist * Mth.m_14031_(time * 0.3f);
        }
    }
}
