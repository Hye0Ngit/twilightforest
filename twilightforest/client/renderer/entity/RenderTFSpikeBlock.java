// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.Render;

public class RenderTFSpikeBlock extends Render<Entity>
{
    private static final ResourceLocation textureLoc;
    private final ModelBase model;
    
    public RenderTFSpikeBlock(final RenderManager manager, final ModelBase modelTFSpikeBlock) {
        super(manager);
        this.model = modelTFSpikeBlock;
    }
    
    public void func_76986_a(final Entity entity, final double x, final double y, final double z, final float yaw, final float partialTicks) {
        GlStateManager.func_179094_E();
        GlStateManager.func_179137_b(x, y, z);
        GlStateManager.func_179114_b(180.0f - MathHelper.func_76142_g(yaw), 0.0f, 1.0f, 0.0f);
        final float pitch = entity.field_70127_C + (entity.field_70125_A - entity.field_70127_C) * partialTicks;
        GlStateManager.func_179114_b(pitch, 1.0f, 0.0f, 0.0f);
        this.func_180548_c(entity);
        GlStateManager.func_179152_a(-1.0f, -1.0f, 1.0f);
        this.model.func_78088_a(entity, 0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        GlStateManager.func_179121_F();
    }
    
    protected ResourceLocation func_110775_a(final Entity entity) {
        return RenderTFSpikeBlock.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("blockgoblin.png");
    }
}
