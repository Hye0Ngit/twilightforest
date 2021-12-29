// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.tileentity.legacy;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.util.math.MathHelper;
import java.util.Random;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import twilightforest.client.model.tileentity.GenericTrophyModel;

public class UrGhastTrophyLegacyModel extends GenericTrophyModel
{
    public ModelRenderer body;
    protected ModelRenderer[] tentacles;
    protected ModelRenderer[][] subTentacles;
    protected ModelRenderer[][] smallTentacles;
    
    public UrGhastTrophyLegacyModel() {
        this.tentacles = new ModelRenderer[9];
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        final byte yOffset = -16;
        (this.body = new ModelRenderer((Model)this, 0, 0)).func_228300_a_(-8.0f, -8.0f, -8.0f, 16.0f, 16.0f, 16.0f);
        final ModelRenderer body = this.body;
        body.field_78797_d += 24 + yOffset;
        final Random rand = new Random(1660L);
        for (int i = 0; i < this.tentacles.length; ++i) {
            this.makeTentacle(yOffset, rand, i);
        }
    }
    
    protected void makeTentacle(final byte yOffset, final Random random, final int num) {
        this.tentacles[num] = new ModelRenderer((Model)this, num % 3, 0);
        int length = 5;
        this.tentacles[num].func_228300_a_(-1.5f, 0.0f, -1.5f, 3.0f, (float)length, 3.0f);
        if (num == 0) {
            this.tentacles[num].field_78800_c = 4.5f;
            this.tentacles[num].field_78798_e = 4.5f;
            this.tentacles[num].field_78797_d = (float)(23 + yOffset);
        }
        if (num == 1) {
            this.tentacles[num].field_78800_c = -4.5f;
            this.tentacles[num].field_78798_e = 4.5f;
            this.tentacles[num].field_78797_d = (float)(23 + yOffset);
        }
        if (num == 2) {
            this.tentacles[num].field_78800_c = 0.0f;
            this.tentacles[num].field_78798_e = 0.0f;
            this.tentacles[num].field_78797_d = (float)(23 + yOffset);
        }
        if (num == 3) {
            this.tentacles[num].field_78800_c = 5.5f;
            this.tentacles[num].field_78798_e = -4.5f;
            this.tentacles[num].field_78797_d = (float)(23 + yOffset);
        }
        if (num == 4) {
            this.tentacles[num].field_78800_c = -5.5f;
            this.tentacles[num].field_78798_e = -4.5f;
            this.tentacles[num].field_78797_d = (float)(23 + yOffset);
        }
        else if (num == 5) {
            this.tentacles[num].field_78800_c = -7.5f;
            this.tentacles[num].field_78797_d = 3.5f;
            this.tentacles[num].field_78798_e = -1.0f;
            this.tentacles[num].field_78808_h = 0.7853982f;
        }
        else if (num == 6) {
            this.tentacles[num].field_78800_c = -7.5f;
            this.tentacles[num].field_78797_d = -1.5f;
            this.tentacles[num].field_78798_e = 3.5f;
            this.tentacles[num].field_78808_h = 1.0471976f;
        }
        else if (num == 7) {
            this.tentacles[num].field_78800_c = 7.5f;
            this.tentacles[num].field_78797_d = 3.5f;
            this.tentacles[num].field_78798_e = -1.0f;
            this.tentacles[num].field_78808_h = -0.7853982f;
        }
        else if (num == 8) {
            this.tentacles[num].field_78800_c = 7.5f;
            this.tentacles[num].field_78797_d = -1.5f;
            this.tentacles[num].field_78798_e = 3.5f;
            this.tentacles[num].field_78808_h = -1.0471976f;
        }
        if (this.subTentacles == null) {
            this.subTentacles = new ModelRenderer[this.tentacles.length][3];
        }
        for (int i = 0; i < 3; ++i) {
            length = 4;
            (this.subTentacles[num][i] = new ModelRenderer((Model)this, num % 4, i * 5 - 1)).func_228300_a_(-1.5f, -0.5f, -1.5f, 3.0f, (float)length, 3.0f);
            this.subTentacles[num][i].field_78800_c = 0.0f;
            this.subTentacles[num][i].field_78798_e = 0.0f;
            this.subTentacles[num][i].field_78797_d = (float)length;
            if (i == 0) {
                this.tentacles[num].func_78792_a(this.subTentacles[num][i]);
            }
            else {
                this.subTentacles[num][i - 1].func_78792_a(this.subTentacles[num][i]);
            }
        }
        this.body.func_78792_a(this.tentacles[num]);
    }
    
    @Override
    public void setRotations(final float x, final float y, final float z) {
        super.setRotations(x, y, z);
        this.body.field_78796_g = y * 0.017453292f;
        this.body.field_78795_f = z * 0.017453292f;
        for (int i = 0; i < this.subTentacles.length; ++i) {
            final float wiggle = Math.min(x, 0.6f);
            final float time = (x * 0.5f + i * 9) / 2.0f;
            this.subTentacles[i][0].field_78795_f = (MathHelper.func_76134_b(time * 0.6662f) - 1.0471976f) * wiggle;
            this.subTentacles[i][1].field_78795_f = MathHelper.func_76134_b(time * 0.7774f) * 1.2f * wiggle;
            this.subTentacles[i][2].field_78795_f = MathHelper.func_76134_b(time * 0.8886f + 1.5707964f) * 1.4f * wiggle;
            this.subTentacles[i][0].field_78795_f = 0.2f + MathHelper.func_76134_b(time * 0.3335f) * 0.15f;
            this.subTentacles[i][1].field_78795_f = 0.1f + MathHelper.func_76134_b(time * 0.4445f) * 0.2f;
            this.subTentacles[i][2].field_78795_f = 0.1f + MathHelper.func_76134_b(time * 0.5555f) * 0.25f;
            final float yTwist = 0.4f;
            this.tentacles[i].field_78796_g = yTwist * MathHelper.func_76126_a(time * 0.3f);
        }
    }
    
    public void setTranslate(final MatrixStack matrix, final float x, final float y, final float z) {
        matrix.func_227861_a_((double)x, (double)y, (double)z);
    }
    
    @Override
    public void func_225598_a_(final MatrixStack matrix, final IVertexBuilder buffer, final int packedLight, final int packedOverlay, final float red, final float green, final float blue, final float alpha) {
        this.body.func_228309_a_(matrix, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
