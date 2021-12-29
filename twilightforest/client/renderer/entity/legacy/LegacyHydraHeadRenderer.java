// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity.legacy;

import twilightforest.TwilightForestMod;
import net.minecraft.world.entity.Entity;
import twilightforest.entity.TFPart;
import javax.annotation.Nullable;
import java.util.Objects;
import twilightforest.entity.boss.Hydra;
import twilightforest.entity.boss.HydraHeadContainer;
import com.mojang.math.Vector3f;
import net.minecraft.client.renderer.MultiBufferSource;
import com.mojang.blaze3d.vertex.PoseStack;
import twilightforest.client.model.TFModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import twilightforest.client.model.entity.legacy.HydraHeadLegacyModel;
import twilightforest.entity.boss.HydraHead;
import twilightforest.client.renderer.entity.TFPartRenderer;

public class LegacyHydraHeadRenderer extends TFPartRenderer<HydraHead, HydraHeadLegacyModel>
{
    private static final ResourceLocation textureLoc;
    
    public LegacyHydraHeadRenderer(final EntityRendererProvider.Context manager) {
        super(manager, new HydraHeadLegacyModel(manager.m_174023_(TFModelLayers.LEGACY_HYDRA_HEAD)));
    }
    
    @Override
    public void render(final HydraHead entity, final float yaw, final float partialTicks, final PoseStack stack, final MultiBufferSource buffer, final int light) {
        final HydraHeadContainer headCon = getHeadObject(entity);
        if (headCon != null) {
            if (headCon.shouldRenderHead()) {
                stack.m_85845_(Vector3f.f_122225_.m_122240_(-180.0f));
                super.render(entity, yaw, partialTicks, stack, buffer, light);
            }
        }
        else {
            super.render(entity, yaw, partialTicks, stack, buffer, light);
        }
    }
    
    @Nullable
    public static HydraHeadContainer getHeadObject(final HydraHead entity) {
        final Hydra hydra = (Hydra)entity.getParent();
        if (hydra != null) {
            int i = 0;
            while (true) {
                final int n = i;
                Objects.requireNonNull(hydra);
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
    
    public ResourceLocation getTextureLocation(final HydraHead entity) {
        return LegacyHydraHeadRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("hydra4.png");
    }
}
