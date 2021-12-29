// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity.legacy;

import twilightforest.entity.boss.NagaSegmentEntity;
import twilightforest.entity.boss.NagaEntity;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.entity.Entity;

public class NagaLegacyModel<T extends Entity> extends SegmentedModel<T>
{
    private T entity;
    public ModelRenderer head;
    public ModelRenderer body;
    
    public NagaLegacyModel() {
        (this.head = new ModelRenderer((Model)this, 0, 0)).func_228301_a_(-8.0f, -12.0f, -8.0f, 16.0f, 16.0f, 16.0f, 0.0f);
        this.head.func_78793_a(0.0f, 0.0f, 0.0f);
        (this.body = new ModelRenderer((Model)this, 0, 0)).func_228301_a_(-8.0f, -16.0f, -8.0f, 16.0f, 16.0f, 16.0f, 0.0f);
        this.body.func_78793_a(0.0f, 0.0f, 0.0f);
    }
    
    public Iterable<ModelRenderer> func_225601_a_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.head, (Object)this.body);
    }
    
    public void func_225598_a_(final MatrixStack stack, final IVertexBuilder builder, final int light, final int overlay, final float red, final float green, final float blue, final float scale) {
        if (this.entity instanceof NagaEntity) {
            this.head.func_228309_a_(stack, builder, light, overlay, red, green, blue, scale * 2.0f);
        }
        else if (this.entity instanceof NagaSegmentEntity) {
            this.body.func_228309_a_(stack, builder, light, overlay, red, green, blue, scale * 2.0f);
        }
        else {
            this.head.func_228309_a_(stack, builder, light, overlay, red, green, blue, scale * 2.0f);
        }
    }
    
    public void func_225597_a_(final T entity, final float v, final float v1, final float v2, final float v3, final float v4) {
        this.entity = entity;
    }
}
