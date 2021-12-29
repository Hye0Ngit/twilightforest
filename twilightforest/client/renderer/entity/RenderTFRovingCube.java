// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;
import twilightforest.client.model.entity.ModelTFCubeOfAnnihilation;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import twilightforest.entity.EntityTFRovingCube;
import net.minecraft.client.renderer.entity.Render;

public class RenderTFRovingCube extends Render<EntityTFRovingCube>
{
    private static final ResourceLocation textureLoc;
    private final ModelBase model;
    
    public RenderTFRovingCube(final RenderManager manager) {
        super(manager);
        this.model = new ModelTFCubeOfAnnihilation();
    }
    
    public void doRender(final EntityTFRovingCube entity, final double x, final double y, final double z, final float yaw, final float partialTicks) {
        GlStateManager.func_179094_E();
        GlStateManager.func_179137_b(x, y, z);
        this.func_180548_c((Entity)entity);
        GlStateManager.func_179152_a(2.0f, 2.0f, 2.0f);
        GlStateManager.func_179114_b(MathHelper.func_76142_g(((float)x + (float)z + ((Entity)entity).field_70173_aa + partialTicks) * 11.0f), 0.0f, 1.0f, 0.0f);
        GlStateManager.func_179140_f();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b(770, 771);
        GlStateManager.func_179109_b(0.0f, 0.75f, 0.0f);
        this.model.func_78088_a((Entity)entity, 0.0f, 0.0f, 0.0f, 0.0f, partialTicks, 0.03125f);
        GlStateManager.func_179145_e();
        GlStateManager.func_179084_k();
        GlStateManager.func_179121_F();
    }
    
    protected ResourceLocation getEntityTexture(final EntityTFRovingCube entity) {
        return RenderTFRovingCube.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("cubeofannihilation.png");
    }
}
