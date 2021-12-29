// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity.legacy;

import twilightforest.entity.boss.NagaSegment;
import twilightforest.entity.boss.Naga;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.ListModel;
import net.minecraft.world.entity.Entity;

public class NagaLegacyModel<T extends Entity> extends ListModel<T>
{
    public ModelPart head;
    public ModelPart body;
    private T entity;
    
    public NagaLegacyModel(final ModelPart root) {
        this.head = root.m_171324_("head");
        this.body = root.m_171324_("body");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = new MeshDefinition();
        final PartDefinition partRoot = mesh.m_171576_();
        partRoot.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-8.0f, -12.0f, -8.0f, 16.0f, 16.0f, 16.0f), PartPose.f_171404_);
        partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-8.0f, -12.0f, -8.0f, 16.0f, 16.0f, 16.0f), PartPose.f_171404_);
        return LayerDefinition.m_171565_(mesh, 64, 32);
    }
    
    public Iterable<ModelPart> m_6195_() {
        return (Iterable<ModelPart>)ImmutableList.of((Object)this.head, (Object)this.body);
    }
    
    public void m_7695_(final PoseStack stack, final VertexConsumer builder, final int light, final int overlay, final float red, final float green, final float blue, final float scale) {
        if (this.entity instanceof Naga) {
            this.head.m_104306_(stack, builder, light, overlay, red, green, blue, scale * 2.0f);
        }
        else if (this.entity instanceof NagaSegment) {
            this.body.m_104306_(stack, builder, light, overlay, red, green, blue, scale * 2.0f);
        }
        else {
            this.head.m_104306_(stack, builder, light, overlay, red, green, blue, scale * 2.0f);
        }
    }
    
    public void m_6973_(final T entity, final float v, final float v1, final float v2, final float v3, final float v4) {
        this.entity = entity;
    }
}
