// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.world.entity.Entity;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.ListModel;
import twilightforest.entity.ProtectionBox;

public class ProtectionBoxModel<T extends ProtectionBox> extends ListModel<T>
{
    private T entity;
    public ModelPart box;
    private int lastPixelsX;
    private int lastPixelsY;
    private int lastPixelsZ;
    
    public ProtectionBoxModel(final ModelPart root) {
        this.box = root.m_171324_("box");
    }
    
    public static MeshDefinition createMesh() {
        final MeshDefinition mesh = new MeshDefinition();
        final PartDefinition partRoot = mesh.m_171576_();
        partRoot.m_171599_("box", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(0.0f, 0.0f, 0.0f, 16.0f, 16.0f, 16.0f), PartPose.f_171404_);
        return mesh;
    }
    
    public Iterable<ModelPart> m_6195_() {
        return (Iterable<ModelPart>)ImmutableList.of((Object)this.box);
    }
    
    public void m_7695_(final PoseStack stack, final VertexConsumer builder, final int light, final int overlay, final float red, final float green, final float blue, final float scale) {
        final ProtectionBox boxEntity = this.entity;
        final int pixelsX = boxEntity.sizeX * 16 + 2;
        final int pixelsY = boxEntity.sizeY * 16 + 2;
        final int pixelsZ = boxEntity.sizeZ * 16 + 2;
        if (pixelsX != this.lastPixelsX || pixelsY != this.lastPixelsY || pixelsZ != this.lastPixelsZ) {
            this.resizeBoxElement(pixelsX, pixelsY, pixelsZ);
        }
        super.m_7695_(stack, builder, light, overlay, red, green, blue, scale);
    }
    
    public void setupAnim(final T entity, final float v, final float v1, final float v2, final float v3, final float v4) {
    }
    
    public void prepareMobModel(final T entity, final float limbSwing, final float limbSwingAmount, final float partialTicks) {
        this.entity = entity;
    }
    
    private void resizeBoxElement(final int pixelsX, final int pixelsY, final int pixelsZ) {
        final MeshDefinition mesh = createMesh();
        final PartDefinition partRoot = mesh.m_171576_();
        partRoot.m_171599_("box", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-1.0f, -1.0f, -1.0f, (float)pixelsX, (float)pixelsY, (float)pixelsZ), PartPose.f_171404_);
        this.lastPixelsX = pixelsX;
        this.lastPixelsY = pixelsY;
        this.lastPixelsZ = pixelsZ;
    }
}
