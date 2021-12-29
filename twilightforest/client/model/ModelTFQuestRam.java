// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import twilightforest.entity.passive.EntityTFQuestRam;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelTFQuestRam extends ModelBase
{
    ModelRenderer frontbody;
    ModelRenderer rearbody;
    ModelRenderer leg1;
    ModelRenderer haunch1;
    ModelRenderer leg2;
    ModelRenderer haunch2;
    ModelRenderer leg3;
    ModelRenderer haunch3;
    ModelRenderer leg4;
    ModelRenderer haunch4;
    ModelRenderer neck;
    ModelRenderer nose;
    ModelRenderer head;
    ModelRenderer[] segments;
    boolean[] segmentEnabled;
    int[] colorOrder;
    
    public ModelTFQuestRam() {
        this.colorOrder = new int[] { 0, 8, 7, 15, 14, 1, 4, 5, 13, 3, 9, 11, 10, 2, 6, 12 };
        this.field_78090_t = 128;
        this.field_78089_u = 128;
        this.func_78085_a("head.head", 0, 70);
        this.func_78085_a("head.horn1a", 0, 94);
        this.func_78085_a("head.horn1b", 20, 96);
        this.func_78085_a("head.horn1c", 34, 95);
        this.func_78085_a("head.horn1d", 46, 98);
        this.func_78085_a("head.horn1e", 58, 95);
        this.func_78085_a("head.horn1f", 76, 95);
        this.func_78085_a("head.horn1g", 88, 97);
        this.func_78085_a("head.horn1a", 0, 94);
        this.func_78085_a("head.horn1b", 20, 96);
        this.func_78085_a("head.horn1c", 34, 95);
        this.func_78085_a("head.horn1d", 46, 98);
        this.func_78085_a("head.horn1e", 58, 95);
        this.func_78085_a("head.horn1f", 76, 95);
        this.func_78085_a("head.horn1g", 88, 97);
        (this.frontbody = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-9.0f, -7.5f, -15.0f, 18, 15, 15);
        this.frontbody.func_78793_a(0.0f, -1.0f, 2.0f);
        (this.rearbody = new ModelRenderer((ModelBase)this, 0, 30)).func_78789_a(-9.0f, -7.5f, 0.0f, 18, 15, 15);
        this.rearbody.func_78793_a(0.0f, -1.0f, 4.0f);
        (this.leg1 = new ModelRenderer((ModelBase)this, 66, 0)).func_78789_a(-3.0f, 10.0f, -3.0f, 6, 12, 6);
        this.leg1.func_78793_a(-6.0f, 2.0f, 13.0f);
        (this.haunch1 = new ModelRenderer((ModelBase)this, 90, 0)).func_78789_a(-3.5f, 0.0f, -6.0f, 7, 10, 10);
        this.haunch1.func_78793_a(-6.0f, 2.0f, 13.0f);
        (this.leg2 = new ModelRenderer((ModelBase)this, 66, 0)).func_78789_a(-3.0f, 10.0f, -3.0f, 6, 12, 6);
        this.leg2.func_78793_a(6.0f, 2.0f, 13.0f);
        (this.haunch2 = new ModelRenderer((ModelBase)this, 90, 0)).func_78789_a(-3.5f, 0.0f, -6.0f, 7, 10, 10);
        this.haunch2.func_78793_a(6.0f, 2.0f, 13.0f);
        (this.leg3 = new ModelRenderer((ModelBase)this, 66, 18)).func_78789_a(-3.0f, 10.0f, -3.0f, 6, 13, 6);
        this.leg3.func_78793_a(-6.0f, 1.0f, -8.0f);
        (this.haunch3 = new ModelRenderer((ModelBase)this, 90, 20)).func_78789_a(-3.5f, 0.0f, -4.0f, 7, 10, 7);
        this.haunch3.func_78793_a(-6.0f, 1.0f, -8.0f);
        (this.leg4 = new ModelRenderer((ModelBase)this, 66, 18)).func_78789_a(-3.0f, 10.0f, -3.0f, 6, 13, 6);
        this.leg4.func_78793_a(6.0f, 1.0f, -8.0f);
        (this.haunch4 = new ModelRenderer((ModelBase)this, 90, 20)).func_78789_a(-3.5f, 0.0f, -4.0f, 7, 10, 7);
        this.haunch4.func_78793_a(6.0f, 1.0f, -8.0f);
        (this.neck = new ModelRenderer((ModelBase)this, 66, 37)).func_78789_a(-5.5f, -8.0f, -8.0f, 11, 14, 12);
        this.neck.func_78793_a(0.0f, -8.0f, -7.0f);
        this.setRotation(this.neck, 0.2617994f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((ModelBase)this, "head")).func_78793_a(0.0f, -13.0f, -5.0f);
        this.head.func_78786_a("head", -6.0f, -4.5f, -15.0f, 12, 9, 15);
        this.head.func_78786_a("horn1a", 5.0f, -9.0f, -7.0f, 4, 4, 6);
        this.head.func_78786_a("horn1b", 7.0f, -8.0f, -2.0f, 3, 4, 4);
        this.head.func_78786_a("horn1c", 8.0f, -6.0f, 0.0f, 3, 6, 3);
        this.head.func_78786_a("horn1d", 9.5f, -2.0f, -2.0f, 3, 3, 3);
        this.head.func_78786_a("horn1e", 11.0f, 0.0f, -7.0f, 3, 3, 6);
        this.head.func_78786_a("horn1f", 12.0f, -4.0f, -9.0f, 3, 6, 3);
        this.head.func_78786_a("horn1g", 13.0f, -6.0f, -7.0f, 3, 3, 4);
        this.head.func_78786_a("horn1a", -9.0f, -9.0f, -7.0f, 4, 4, 6);
        this.head.func_78786_a("horn1b", -10.0f, -8.0f, -2.0f, 3, 4, 4);
        this.head.func_78786_a("horn1c", -11.0f, -6.0f, 0.0f, 3, 6, 3);
        this.head.func_78786_a("horn1d", -12.5f, -2.0f, -2.0f, 3, 3, 3);
        this.head.func_78786_a("horn1e", -14.0f, 0.0f, -7.0f, 3, 3, 6);
        this.head.func_78786_a("horn1f", -15.0f, -4.0f, -9.0f, 3, 6, 3);
        this.head.func_78786_a("horn1g", -16.0f, -6.0f, -7.0f, 3, 3, 4);
        (this.nose = new ModelRenderer((ModelBase)this, 54, 73)).func_78789_a(-5.5f, -5.0f, -13.0f, 11, 9, 12);
        this.nose.func_78793_a(0.0f, -7.0f, -1.0f);
        this.nose.func_78787_b(128, 128);
        this.setRotation(this.nose, 0.5235988f, 0.0f, 0.0f);
        this.head.func_78792_a(this.nose);
        this.segments = new ModelRenderer[16];
        this.segmentEnabled = new boolean[16];
        for (int i = 0; i < 16; ++i) {
            (this.segments[i] = new ModelRenderer((ModelBase)this, 0, 104)).func_78789_a(-9.0f, -7.5f, 0.0f, 18, 15, 2);
            this.segments[i].func_78793_a(0.0f, -1.0f, 2.0f);
            this.segmentEnabled[i] = false;
        }
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5);
        this.frontbody.func_78785_a(f5);
        this.rearbody.func_78785_a(f5);
        this.leg1.func_78785_a(f5);
        this.haunch1.func_78785_a(f5);
        this.leg2.func_78785_a(f5);
        this.haunch2.func_78785_a(f5);
        this.leg3.func_78785_a(f5);
        this.haunch3.func_78785_a(f5);
        this.leg4.func_78785_a(f5);
        this.haunch4.func_78785_a(f5);
        this.neck.func_78785_a(f5);
        this.head.func_78785_a(f5);
        for (int i = 0; i < 16; ++i) {
            if (this.segmentEnabled[i]) {
                final float var4 = 1.0f;
                GL11.glColor3f(var4 * EntitySheep.field_70898_d[i][0], var4 * EntitySheep.field_70898_d[i][1], var4 * EntitySheep.field_70898_d[i][2]);
                this.segments[i].func_78785_a(f5);
            }
        }
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.field_78795_f = x;
        model.field_78796_g = y;
        model.field_78808_h = z;
    }
    
    public void setRotationAngles(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6) {
        this.head.field_78795_f = par5 / 57.295776f;
        this.head.field_78796_g = par4 / 57.295776f;
        this.neck.field_78796_g = this.head.field_78796_g;
        this.leg1.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662f) * 1.4f * par2 * 0.5f;
        this.leg2.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662f + 3.1415927f) * 1.4f * par2 * 0.5f;
        this.leg3.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662f + 3.1415927f) * 1.4f * par2 * 0.5f;
        this.leg4.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662f) * 1.4f * par2 * 0.5f;
        this.haunch1.field_78795_f = this.leg1.field_78795_f;
        this.haunch2.field_78795_f = this.leg2.field_78795_f;
        this.haunch3.field_78795_f = this.leg3.field_78795_f;
        this.haunch4.field_78795_f = this.leg4.field_78795_f;
    }
    
    public void func_78086_a(final EntityLiving par1EntityLiving, final float par2, final float par3, final float par4) {
        final EntityTFQuestRam ram = (EntityTFQuestRam)par1EntityLiving;
        final int count = ram.countColorsSet();
        this.rearbody.field_78798_e = (float)(2 + 2 * count);
        this.leg1.field_78798_e = (float)(11 + 2 * count);
        this.leg2.field_78798_e = (float)(11 + 2 * count);
        this.haunch1.field_78798_e = (float)(11 + 2 * count);
        this.haunch2.field_78798_e = (float)(11 + 2 * count);
        int segmentOffset = 2;
        for (final int color : this.colorOrder) {
            if (ram.isColorPresent(color)) {
                this.segmentEnabled[color] = true;
                this.segments[color].field_78798_e = (float)segmentOffset;
                segmentOffset += 2;
            }
            else {
                this.segmentEnabled[color] = false;
            }
        }
    }
}
