// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.tileentity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;

public class KnightPhantomTrophyModel extends GenericTrophyModel
{
    public ModelRenderer head;
    
    public KnightPhantomTrophyModel() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        (this.head = new ModelRenderer((Model)this, 0, 0)).func_228300_a_(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f);
        this.head.func_78793_a(0.0f, -4.0f, 0.0f);
    }
    
    @Override
    public void setRotations(final float x, final float y, final float z) {
        super.setRotations(x, y, z);
        this.head.field_78796_g = y * 0.017453292f;
        this.head.field_78795_f = x * 0.017453292f;
    }
    
    @Override
    public void func_225598_a_(final MatrixStack matrix, final IVertexBuilder buffer, final int packedLight, final int packedOverlay, final float red, final float green, final float blue, final float alpha) {
        this.head.func_228309_a_(matrix, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
