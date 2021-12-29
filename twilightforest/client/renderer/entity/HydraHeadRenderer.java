// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import twilightforest.entity.TFPartEntity;
import javax.annotation.Nullable;
import twilightforest.entity.boss.HydraEntity;
import twilightforest.entity.boss.HydraHeadContainer;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.client.model.entity.HydraHeadModel;
import twilightforest.entity.boss.HydraHeadEntity;

public class HydraHeadRenderer extends TFPartRenderer<HydraHeadEntity, HydraHeadModel>
{
    private static final ResourceLocation textureLoc;
    
    public HydraHeadRenderer(final EntityRendererManager manager) {
        super(manager, new HydraHeadModel());
    }
    
    @Override
    public void render(final HydraHeadEntity entity, final float yaw, final float partialTicks, final MatrixStack stack, final IRenderTypeBuffer buffer, final int light) {
        final HydraHeadContainer headCon = getHeadObject(entity);
        if (headCon != null) {
            if (headCon.shouldRenderHead()) {
                stack.func_227863_a_(Vector3f.field_229181_d_.func_229187_a_(-180.0f));
                super.render(entity, yaw, partialTicks, stack, buffer, light);
            }
        }
        else {
            super.render(entity, yaw, partialTicks, stack, buffer, light);
        }
    }
    
    @Nullable
    public static HydraHeadContainer getHeadObject(final HydraHeadEntity entity) {
        final HydraEntity hydra = (HydraEntity)entity.getParent();
        if (hydra != null) {
            int i = 0;
            while (true) {
                final int n = i;
                hydra.getClass();
                if (n >= 7) {
                    break;
                }
                if (hydra.hc[i].headEntity == entity) {
                    return hydra.hc[i];
                }
                ++i;
            }
        }
        return null;
    }
    
    public ResourceLocation getEntityTexture(final HydraHeadEntity entity) {
        return HydraHeadRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("hydra4.png");
    }
}
