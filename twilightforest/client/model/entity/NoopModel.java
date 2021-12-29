// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.LivingEntity;

public class NoopModel<T extends LivingEntity> extends HumanoidModel<T>
{
    public NoopModel(final ModelPart part) {
        super(part);
    }
    
    public void m_7695_(final PoseStack ms, final VertexConsumer buffers, final int light, final int overlay, final float r, final float g, final float b, final float a) {
    }
}
