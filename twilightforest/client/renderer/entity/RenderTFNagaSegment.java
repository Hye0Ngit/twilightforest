// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import twilightforest.entity.boss.EntityTFNagaSegment;
import net.minecraft.client.renderer.entity.Render;

public class RenderTFNagaSegment extends Render<EntityTFNagaSegment>
{
    private static final ResourceLocation textureLoc;
    private final ModelBase model;
    
    public RenderTFNagaSegment(final RenderManager manager, final ModelBase model) {
        super(manager);
        this.model = model;
    }
    
    public void doRender(final EntityTFNagaSegment entity, final double x, final double y, final double z, final float entityYaw, final float partialTicks) {
        GlStateManager.func_179094_E();
        GlStateManager.func_179109_b((float)x, (float)y, (float)z);
        GlStateManager.func_179152_a(-1.0f, -1.0f, 1.0f);
        float yawDiff = entity.field_70177_z - entity.field_70126_B;
        if (yawDiff > 180.0f) {
            yawDiff -= 360.0f;
        }
        else if (yawDiff < -180.0f) {
            yawDiff += 360.0f;
        }
        final float yaw = entity.field_70126_B + yawDiff * partialTicks;
        GlStateManager.func_179114_b(yaw, 0.0f, 1.0f, 0.0f);
        GlStateManager.func_179114_b(entity.field_70125_A, 1.0f, 0.0f, 0.0f);
        this.func_110776_a(RenderTFNagaSegment.textureLoc);
        this.model.func_78088_a((Entity)entity, 0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        GlStateManager.func_179121_F();
    }
    
    protected ResourceLocation getEntityTexture(final EntityTFNagaSegment entity) {
        return RenderTFNagaSegment.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("nagasegment.png");
    }
}
