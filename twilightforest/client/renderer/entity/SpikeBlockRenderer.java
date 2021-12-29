// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.Entity;

public class SpikeBlockRenderer<T extends Entity, M extends EntityModel<T>> extends EntityRenderer<T>
{
    private static final ResourceLocation textureLoc;
    private final Model model;
    
    public SpikeBlockRenderer(final EntityRendererManager manager, final M model) {
        super(manager);
        this.model = (Model)model;
    }
    
    public void func_225623_a_(final T goblin, final float yaw, final float partialTicks, final MatrixStack stack, final IRenderTypeBuffer buffer, final int light) {
        stack.func_227860_a_();
        stack.func_227862_a_(-1.0f, -1.0f, 1.0f);
        final IVertexBuilder ivertexbuilder = buffer.getBuffer(this.model.func_228282_a_(SpikeBlockRenderer.textureLoc));
        stack.func_227863_a_(Vector3f.field_229183_f_.func_229187_a_(yaw));
        this.model.func_225598_a_(stack, ivertexbuilder, light, OverlayTexture.field_229196_a_, 1.0f, 1.0f, 1.0f, 1.0f);
        stack.func_227865_b_();
        super.func_225623_a_((Entity)goblin, yaw, partialTicks, stack, buffer, light);
    }
    
    public ResourceLocation func_110775_a(final T entity) {
        return SpikeBlockRenderer.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("blockgoblin.png");
    }
}
