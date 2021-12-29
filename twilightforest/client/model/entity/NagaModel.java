// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import com.google.common.collect.ImmutableList;
import twilightforest.entity.boss.NagaSegment;
import twilightforest.entity.boss.Naga;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.model.ListModel;
import net.minecraft.world.entity.Entity;

@OnlyIn(Dist.CLIENT)
public class NagaModel<T extends Entity> extends ListModel<T>
{
    public ModelPart root;
    public ModelPart head;
    public ModelPart body;
    private T entity;
    
    public NagaModel(final ModelPart root) {
        this.root = root;
        this.head = root.m_171324_("head");
        this.body = root.m_171324_("body");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = new MeshDefinition();
        final PartDefinition partRoot = mesh.m_171576_();
        final PartDefinition head = partRoot.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f), PartPose.m_171419_(0.0f, 8.0f, 0.0f));
        head.m_171599_("tongue", CubeListBuilder.m_171558_().m_171514_(84, 0).m_171481_(-6.0f, 0.0f, -12.0f, 12.0f, 0.0f, 12.0f), PartPose.m_171423_(0.0f, 10.0f, -16.0f, 0.43633232f, 0.0f, 0.0f));
        partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f), PartPose.m_171419_(0.0f, 8.0f, 0.0f));
        return LayerDefinition.m_171565_(mesh, 128, 64);
    }
    
    public void m_7695_(final PoseStack stack, final VertexConsumer builder, final int light, final int overlay, final float red, final float green, final float blue, final float alpha) {
        if (this.entity instanceof Naga) {
            this.head.m_104306_(stack, builder, light, overlay, red, green, blue, alpha * 2.0f);
        }
        else if (this.entity instanceof NagaSegment) {
            this.body.m_104306_(stack, builder, light, overlay, red, green, blue, alpha * 2.0f);
        }
        else {
            this.head.m_104306_(stack, builder, light, overlay, red, green, blue, alpha * 2.0f);
        }
    }
    
    public Iterable<ModelPart> m_6195_() {
        return (Iterable<ModelPart>)ImmutableList.of((Object)this.head, (Object)this.body);
    }
    
    public void m_6973_(final T entityIn, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
    }
}
