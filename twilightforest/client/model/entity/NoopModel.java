// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.client.renderer.model.ModelRenderer;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.LivingEntity;

public class NoopModel<T extends LivingEntity> extends BipedModel<T>
{
    public NoopModel() {
        super(0.0f);
    }
    
    public void func_225598_a_(final MatrixStack ms, final IVertexBuilder buffers, final int light, final int overlay, final float r, final float g, final float b, final float a) {
    }
}
