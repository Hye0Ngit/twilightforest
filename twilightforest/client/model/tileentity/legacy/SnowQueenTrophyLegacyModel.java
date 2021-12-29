// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.tileentity.legacy;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import twilightforest.client.model.tileentity.GenericTrophyModel;

public class SnowQueenTrophyLegacyModel extends GenericTrophyModel
{
    public ModelRenderer head;
    public ModelRenderer crown;
    
    public SnowQueenTrophyLegacyModel() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        (this.head = new ModelRenderer((Model)this, 0, 0)).func_228300_a_(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f);
        this.head.func_78793_a(0.0f, -4.0f, 0.0f);
        (this.crown = new ModelRenderer((Model)this, 0, 0)).func_78792_a(this.makeFrontCrown(-1.0f, -4.0f, 10.0f));
        this.crown.func_78792_a(this.makeFrontCrown(0.0f, 4.0f, -10.0f));
        this.crown.func_78792_a(this.makeSideCrown(-1.0f, -4.0f, 10.0f));
        this.crown.func_78792_a(this.makeSideCrown(0.0f, 4.0f, -10.0f));
        this.head.func_78792_a(this.crown);
    }
    
    private ModelRenderer makeSideCrown(final float spikeDepth, final float crownX, final float angle) {
        final ModelRenderer crownSide = new ModelRenderer((Model)this, 28, 28);
        crownSide.func_228300_a_(-3.5f, -0.5f, -0.5f, 7.0f, 1.0f, 1.0f);
        crownSide.func_78793_a(crownX, -6.0f, 0.0f);
        crownSide.field_78796_g = 1.570795f;
        final ModelRenderer spike4 = new ModelRenderer((Model)this, 48, 27);
        spike4.func_228300_a_(-0.5f, -3.5f, spikeDepth, 1.0f, 4.0f, 1.0f);
        spike4.field_78795_f = angle * 1.5f / 180.0f * 3.14159f;
        final ModelRenderer spike3l = new ModelRenderer((Model)this, 52, 28);
        spike3l.func_228300_a_(-0.5f, -2.5f, spikeDepth, 1.0f, 3.0f, 1.0f);
        spike3l.func_78793_a(-2.5f, 0.0f, 0.0f);
        spike3l.field_78795_f = angle / 180.0f * 3.14159f;
        spike3l.field_78808_h = -0.17453279f;
        final ModelRenderer spike3r = new ModelRenderer((Model)this, 52, 28);
        spike3r.func_228300_a_(-0.5f, -2.5f, spikeDepth, 1.0f, 3.0f, 1.0f);
        spike3r.func_78793_a(2.5f, 0.0f, 0.0f);
        spike3r.field_78795_f = angle / 180.0f * 3.14159f;
        spike3r.field_78808_h = 0.17453279f;
        crownSide.func_78792_a(spike4);
        crownSide.func_78792_a(spike3l);
        crownSide.func_78792_a(spike3r);
        return crownSide;
    }
    
    private ModelRenderer makeFrontCrown(final float spikeDepth, final float crownZ, final float angle) {
        final ModelRenderer crownFront = new ModelRenderer((Model)this, 28, 30);
        crownFront.func_228300_a_(-4.5f, -0.5f, -0.5f, 9.0f, 1.0f, 1.0f);
        crownFront.func_78793_a(0.0f, -6.0f, crownZ);
        final ModelRenderer spike4 = new ModelRenderer((Model)this, 48, 27);
        spike4.func_228300_a_(-0.5f, -3.5f, spikeDepth, 1.0f, 4.0f, 1.0f);
        spike4.field_78795_f = angle * 1.5f / 180.0f * 3.14159f;
        final ModelRenderer spike3l = new ModelRenderer((Model)this, 52, 28);
        spike3l.func_228300_a_(-0.5f, -2.5f, spikeDepth, 1.0f, 3.0f, 1.0f);
        spike3l.func_78793_a(-2.5f, 0.0f, 0.0f);
        spike3l.field_78795_f = angle / 180.0f * 3.14159f;
        spike3l.field_78808_h = -0.17453279f;
        final ModelRenderer spike3r = new ModelRenderer((Model)this, 52, 28);
        spike3r.func_228300_a_(-0.5f, -2.5f, spikeDepth, 1.0f, 3.0f, 1.0f);
        spike3r.func_78793_a(2.5f, 0.0f, 0.0f);
        spike3r.field_78795_f = angle / 180.0f * 3.14159f;
        spike3r.field_78808_h = 0.17453279f;
        crownFront.func_78792_a(spike4);
        crownFront.func_78792_a(spike3l);
        crownFront.func_78792_a(spike3r);
        return crownFront;
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
