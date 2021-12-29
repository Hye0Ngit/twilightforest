// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import twilightforest.entity.TFPartEntity;
import twilightforest.entity.boss.HydraHeadContainer;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.client.model.entity.HydraNeckModel;
import twilightforest.entity.boss.HydraNeckEntity;

public class HydraNeckRenderer extends TFPartRenderer<HydraNeckEntity, HydraNeckModel>
{
    private static final ResourceLocation textureLoc;
    
    public HydraNeckRenderer(final EntityRendererManager manager) {
        super(manager, new HydraNeckModel());
    }
    
    @Override
    public void render(final HydraNeckEntity entityIn, final float entityYaw, final float partialTicks, final MatrixStack matrixStackIn, final IRenderTypeBuffer bufferIn, final int light) {
        final HydraHeadContainer headCon = HydraHeadRenderer.getHeadObject(entityIn.head);
        if (headCon != null && headCon.shouldRenderHead()) {
            float yawDiff = entityIn.field_70177_z - entityIn.field_70126_B;
            if (yawDiff > 180.0f) {
                yawDiff -= 360.0f;
            }
            else if (yawDiff < -180.0f) {
                yawDiff += 360.0f;
            }
            final float yaw2 = entityIn.field_70126_B + yawDiff * partialTicks;
            matrixStackIn.func_227863_a_(Vector3f.field_229180_c_.func_229187_a_(yaw2 + 180.0f));
            super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, light);
        }
    }
    
    public ResourceLocation getEntityTexture(final HydraNeckEntity entity) {
        return HydraNeckRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("hydra4.png");
    }
}
