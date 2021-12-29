// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import twilightforest.client.model.entity.ModelTFMoonworm;
import net.minecraft.util.ResourceLocation;
import twilightforest.entity.EntityTFMoonwormShot;
import net.minecraft.client.renderer.entity.Render;

public class RenderTFMoonwormShot extends Render<EntityTFMoonwormShot>
{
    private static final ResourceLocation textureLoc;
    private final ModelTFMoonworm wormModel;
    
    public RenderTFMoonwormShot(final RenderManager manager) {
        super(manager);
        this.wormModel = new ModelTFMoonworm();
        this.field_76989_e = 0.5f;
    }
    
    public void doRender(final EntityTFMoonwormShot entity, final double x, final double y, final double z, final float yaw, final float partialTicks) {
        GlStateManager.func_179094_E();
        GlStateManager.func_179137_b(x, y, z);
        GlStateManager.func_179114_b(90.0f, 1.0f, 0.0f, 1.0f);
        this.func_110776_a(this.getEntityTexture(entity));
        this.wormModel.render(0.075f);
        GlStateManager.func_179121_F();
    }
    
    protected ResourceLocation getEntityTexture(final EntityTFMoonwormShot entity) {
        return RenderTFMoonwormShot.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("moonworm.png");
    }
}
