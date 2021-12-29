// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.client.model.entity.IceCrystalModel;
import twilightforest.entity.boss.IceCrystalEntity;
import net.minecraft.client.renderer.entity.MobRenderer;

public class IceCrystalRenderer extends MobRenderer<IceCrystalEntity, IceCrystalModel>
{
    private static final ResourceLocation textureLoc;
    
    public IceCrystalRenderer(final EntityRendererManager manager) {
        super(manager, (EntityModel)new IceCrystalModel(), 0.25f);
    }
    
    protected void preRenderCallback(final IceCrystalEntity entity, final MatrixStack stack, final float partialTicks) {
        final float bounce = entity.field_70173_aa + partialTicks;
        stack.func_227861_a_(0.0, (double)(MathHelper.func_76126_a(bounce * 0.2f) * 0.15f), 0.0);
    }
    
    public ResourceLocation getEntityTexture(final IceCrystalEntity entity) {
        return IceCrystalRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("icecrystal.png");
    }
}
