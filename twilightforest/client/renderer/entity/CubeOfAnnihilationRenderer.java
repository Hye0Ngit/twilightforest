// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.Mth;
import com.mojang.math.Vector3f;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.renderer.MultiBufferSource;
import com.mojang.blaze3d.vertex.PoseStack;
import twilightforest.client.model.entity.CubeOfAnnihilationModel;
import twilightforest.client.model.TFModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.Model;
import net.minecraft.resources.ResourceLocation;
import twilightforest.entity.CubeOfAnnihilation;
import net.minecraft.client.renderer.entity.EntityRenderer;

public class CubeOfAnnihilationRenderer extends EntityRenderer<CubeOfAnnihilation>
{
    private static final ResourceLocation textureLoc;
    private final Model model;
    
    public CubeOfAnnihilationRenderer(final EntityRendererProvider.Context manager) {
        super(manager);
        this.model = (Model)new CubeOfAnnihilationModel(manager.m_174023_(TFModelLayers.CUBE_OF_ANNIHILATION));
    }
    
    public void render(final CubeOfAnnihilation entity, final float yaw, final float partialTicks, final PoseStack stack, final MultiBufferSource buffer, final int light) {
        super.m_7392_((Entity)entity, yaw, partialTicks, stack, buffer, light);
        stack.m_85836_();
        stack.m_85841_(-1.0f, -1.0f, 1.0f);
        stack.m_85845_(Vector3f.f_122225_.m_122240_(Mth.m_14177_((entity.f_19797_ + partialTicks) * 11.0f)));
        stack.m_85837_(0.0, -0.5, 0.0);
        this.model.m_7695_(stack, buffer.m_6299_(this.model.m_103119_(CubeOfAnnihilationRenderer.textureLoc)), light, OverlayTexture.f_118083_, 1.0f, 1.0f, 1.0f, 1.0f);
        stack.m_85849_();
    }
    
    public ResourceLocation getTextureLocation(final CubeOfAnnihilation entity) {
        return CubeOfAnnihilationRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("cubeofannihilation.png");
    }
}
