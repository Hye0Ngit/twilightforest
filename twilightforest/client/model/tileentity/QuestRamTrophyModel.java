// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.tileentity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;

public class QuestRamTrophyModel extends GenericTrophyModel
{
    public ModelRenderer horns;
    public ModelRenderer head;
    
    public QuestRamTrophyModel() {
        this.field_78090_t = 128;
        this.field_78089_u = 128;
        (this.head = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, -4.0f, 0.0f);
        this.head.func_78784_a(74, 70).func_228302_a_(-6.0f, -4.0f, -10.0f, 12.0f, 8.0f, 15.0f, 0.0f, 0.0f, 0.0f);
        this.head.func_78784_a(42, 71).func_228302_a_(-6.0f, -7.0f, -6.0f, 12.0f, 3.0f, 11.0f, 0.0f, 0.0f, 0.0f);
        (this.horns = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, -4.0f, 0.0f);
        this.horns.func_78784_a(64, 0).func_228302_a_(-9.0f, -6.0f, -1.0f, 4.0f, 10.0f, 10.0f, 0.0f, 0.0f, 0.0f);
        this.horns.func_78784_a(48, 0).func_228302_a_(-13.0f, -6.0f, 5.0f, 4.0f, 4.0f, 4.0f, 0.0f, 0.0f, 0.0f);
        this.horns.func_78784_a(92, 0).func_228302_a_(5.0f, -6.0f, -1.0f, 4.0f, 10.0f, 10.0f, 0.0f, 0.0f, 0.0f);
        this.horns.func_78784_a(110, 0).func_228302_a_(9.0f, -6.0f, 5.0f, 4.0f, 4.0f, 4.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.horns, -0.43633232f, 0.0f, 0.0f);
        this.head.func_78792_a(this.horns);
    }
    
    private void setRotateAngle(final ModelRenderer model, final float x, final float y, final float z) {
        model.field_78795_f = x;
        model.field_78796_g = y;
        model.field_78808_h = z;
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
