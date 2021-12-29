// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import twilightforest.client.model.entity.ProtectionBoxModel;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRenderer;
import twilightforest.entity.ProtectionBoxEntity;

public class ProtectionBoxRenderer<T extends ProtectionBoxEntity> extends EntityRenderer<T>
{
    private static final ResourceLocation textureLoc;
    private final ProtectionBoxModel<T> boxModel;
    
    public ProtectionBoxRenderer(final EntityRendererManager manager) {
        super(manager);
        this.boxModel = new ProtectionBoxModel<T>();
        this.field_76989_e = 0.5f;
    }
    
    public void render(final T entity, final float yaw, final float partialTicks, final MatrixStack stack, final IRenderTypeBuffer buffer, final int light) {
        stack.func_227860_a_();
        stack.func_227865_b_();
    }
    
    public ResourceLocation getEntityTexture(final T entity) {
        return ProtectionBoxRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("protectionbox.png");
    }
}
