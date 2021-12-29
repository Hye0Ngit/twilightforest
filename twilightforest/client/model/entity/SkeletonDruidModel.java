// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import com.google.common.collect.Iterables;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import twilightforest.entity.SkeletonDruidEntity;
import net.minecraft.client.renderer.entity.model.SkeletonModel;

public class SkeletonDruidModel extends SkeletonModel<SkeletonDruidEntity>
{
    private ModelRenderer dress;
    
    public SkeletonDruidModel() {
        (this.field_78115_e = new ModelRenderer((Model)this, 8, 16)).func_228301_a_(-4.0f, 0.0f, -2.0f, 8.0f, 12.0f, 4.0f, 0.0f);
        this.field_78115_e.func_78793_a(0.0f, 0.0f, 0.0f);
        (this.field_178723_h = new ModelRenderer((Model)this, 0, 16)).func_228301_a_(-1.0f, -2.0f, -1.0f, 2.0f, 12.0f, 2.0f, 0.0f);
        this.field_178723_h.func_78793_a(-5.0f, 2.0f, 0.0f);
        this.field_178724_i = new ModelRenderer((Model)this, 0, 16);
        this.field_178724_i.field_78809_i = true;
        this.field_178724_i.func_228301_a_(-1.0f, -2.0f, -1.0f, 2.0f, 12.0f, 2.0f, 0.0f);
        this.field_178724_i.func_78793_a(5.0f, 2.0f, 0.0f);
        (this.dress = new ModelRenderer((Model)this, 32, 16)).func_228301_a_(-4.0f, 12.0f, -2.0f, 8.0f, 12.0f, 4.0f, 0.0f);
        this.dress.func_78793_a(0.0f, 0.0f, 0.0f);
    }
    
    public void func_225598_a_(final MatrixStack matrixStackIn, final IVertexBuilder bufferIn, final int packedLightIn, final int packedOverlayIn, final float red, final float green, final float blue, final float alpha) {
        if (this.field_217113_d) {
            matrixStackIn.func_227861_a_(0.0, -0.25, 0.0);
        }
        super.func_225598_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }
    
    protected Iterable<ModelRenderer> func_225600_b_() {
        return Iterables.concat(super.func_225600_b_(), (Iterable)ImmutableList.of((Object)this.dress));
    }
}
