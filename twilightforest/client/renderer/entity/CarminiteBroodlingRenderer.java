// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.SpiderEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.SpiderRenderer;
import twilightforest.entity.TowerBroodlingEntity;

public class CarminiteBroodlingRenderer<T extends TowerBroodlingEntity> extends SpiderRenderer<T>
{
    private static final ResourceLocation textureLoc;
    
    public CarminiteBroodlingRenderer(final EntityRendererManager manager) {
        super(manager);
    }
    
    public ResourceLocation getEntityTexture(final T entity) {
        return CarminiteBroodlingRenderer.textureLoc;
    }
    
    protected void preRenderCallback(final T entity, final MatrixStack stack, final float partialTicks) {
        final float scale = 0.7f;
        stack.func_227862_a_(scale, scale, scale);
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("towerbroodling.png");
    }
}
