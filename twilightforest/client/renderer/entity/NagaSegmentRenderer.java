// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import twilightforest.entity.TFPartEntity;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.client.model.entity.NagaModel;
import twilightforest.entity.boss.NagaSegmentEntity;

public class NagaSegmentRenderer<T extends NagaSegmentEntity> extends TFPartRenderer<T, NagaModel<T>>
{
    private static final ResourceLocation part_TextureLoc;
    
    public NagaSegmentRenderer(final EntityRendererManager m) {
        super(m, new NagaModel());
    }
    
    @Override
    public void render(final T entityIn, final float entityYaw, final float partialTicks, final MatrixStack matrixStackIn, final IRenderTypeBuffer bufferIn, final int packedLightIn) {
        if (!entityIn.func_82150_aj()) {
            matrixStackIn.func_227860_a_();
            float yawDiff = entityIn.field_70177_z - entityIn.field_70126_B;
            if (yawDiff > 180.0f) {
                yawDiff -= 360.0f;
            }
            else if (yawDiff < -180.0f) {
                yawDiff += 360.0f;
            }
            final float yaw2 = entityIn.field_70126_B + yawDiff * partialTicks;
            matrixStackIn.func_227863_a_(Vector3f.field_229181_d_.func_229187_a_(yaw2));
            matrixStackIn.func_227863_a_(Vector3f.field_229179_b_.func_229187_a_(entityIn.field_70125_A));
            final int light = this.field_76990_c.func_229085_a_(entityIn.getParent(), partialTicks);
            super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, light);
            matrixStackIn.func_227865_b_();
        }
    }
    
    public ResourceLocation getEntityTexture(final T entity) {
        return NagaSegmentRenderer.part_TextureLoc;
    }
    
    static {
        part_TextureLoc = TwilightForestMod.getModelTexture("nagasegment.png");
    }
}
