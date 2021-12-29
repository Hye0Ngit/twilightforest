// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import twilightforest.EntityTFQuestRam;
import org.lwjgl.opengl.GL11;

public class ModelTFQuestRam extends awt
{
    axx frontbody;
    axx rearbody;
    axx leg1;
    axx haunch1;
    axx leg2;
    axx haunch2;
    axx leg3;
    axx haunch3;
    axx leg4;
    axx haunch4;
    axx neck;
    axx nose;
    axx head;
    axx[] segments;
    boolean[] segmentEnabled;
    int[] colorOrder;
    
    public ModelTFQuestRam() {
        this.colorOrder = new int[] { 0, 8, 7, 15, 14, 1, 4, 5, 13, 3, 9, 11, 10, 2, 6, 12 };
        this.t = 128;
        this.u = 128;
        this.a("head.head", 0, 70);
        this.a("head.horn1a", 0, 94);
        this.a("head.horn1b", 20, 96);
        this.a("head.horn1c", 34, 95);
        this.a("head.horn1d", 46, 98);
        this.a("head.horn1e", 58, 95);
        this.a("head.horn1f", 76, 95);
        this.a("head.horn1g", 88, 97);
        this.a("head.horn1a", 0, 94);
        this.a("head.horn1b", 20, 96);
        this.a("head.horn1c", 34, 95);
        this.a("head.horn1d", 46, 98);
        this.a("head.horn1e", 58, 95);
        this.a("head.horn1f", 76, 95);
        this.a("head.horn1g", 88, 97);
        (this.frontbody = new axx((awt)this, 0, 0)).a(-9.0f, -7.5f, -15.0f, 18, 15, 15);
        this.frontbody.a(0.0f, -1.0f, 2.0f);
        (this.rearbody = new axx((awt)this, 0, 30)).a(-9.0f, -7.5f, 0.0f, 18, 15, 15);
        this.rearbody.a(0.0f, -1.0f, 4.0f);
        (this.leg1 = new axx((awt)this, 66, 0)).a(-3.0f, 10.0f, -3.0f, 6, 12, 6);
        this.leg1.a(-6.0f, 2.0f, 13.0f);
        (this.haunch1 = new axx((awt)this, 90, 0)).a(-3.5f, 0.0f, -6.0f, 7, 10, 10);
        this.haunch1.a(-6.0f, 2.0f, 13.0f);
        (this.leg2 = new axx((awt)this, 66, 0)).a(-3.0f, 10.0f, -3.0f, 6, 12, 6);
        this.leg2.a(6.0f, 2.0f, 13.0f);
        (this.haunch2 = new axx((awt)this, 90, 0)).a(-3.5f, 0.0f, -6.0f, 7, 10, 10);
        this.haunch2.a(6.0f, 2.0f, 13.0f);
        (this.leg3 = new axx((awt)this, 66, 18)).a(-3.0f, 10.0f, -3.0f, 6, 13, 6);
        this.leg3.a(-6.0f, 1.0f, -8.0f);
        (this.haunch3 = new axx((awt)this, 90, 20)).a(-3.5f, 0.0f, -4.0f, 7, 10, 7);
        this.haunch3.a(-6.0f, 1.0f, -8.0f);
        (this.leg4 = new axx((awt)this, 66, 18)).a(-3.0f, 10.0f, -3.0f, 6, 13, 6);
        this.leg4.a(6.0f, 1.0f, -8.0f);
        (this.haunch4 = new axx((awt)this, 90, 20)).a(-3.5f, 0.0f, -4.0f, 7, 10, 7);
        this.haunch4.a(6.0f, 1.0f, -8.0f);
        (this.neck = new axx((awt)this, 66, 37)).a(-5.5f, -8.0f, -8.0f, 11, 14, 12);
        this.neck.a(0.0f, -8.0f, -7.0f);
        this.setRotation(this.neck, 0.2617994f, 0.0f, 0.0f);
        (this.head = new axx((awt)this, "head")).a(0.0f, -13.0f, -5.0f);
        this.head.a("head", -6.0f, -4.5f, -15.0f, 12, 9, 15);
        this.head.a("horn1a", 5.0f, -9.0f, -7.0f, 4, 4, 6);
        this.head.a("horn1b", 7.0f, -8.0f, -2.0f, 3, 4, 4);
        this.head.a("horn1c", 8.0f, -6.0f, 0.0f, 3, 6, 3);
        this.head.a("horn1d", 9.5f, -2.0f, -2.0f, 3, 3, 3);
        this.head.a("horn1e", 11.0f, 0.0f, -7.0f, 3, 3, 6);
        this.head.a("horn1f", 12.0f, -4.0f, -9.0f, 3, 6, 3);
        this.head.a("horn1g", 13.0f, -6.0f, -7.0f, 3, 3, 4);
        this.head.a("horn1a", -9.0f, -9.0f, -7.0f, 4, 4, 6);
        this.head.a("horn1b", -10.0f, -8.0f, -2.0f, 3, 4, 4);
        this.head.a("horn1c", -11.0f, -6.0f, 0.0f, 3, 6, 3);
        this.head.a("horn1d", -12.5f, -2.0f, -2.0f, 3, 3, 3);
        this.head.a("horn1e", -14.0f, 0.0f, -7.0f, 3, 3, 6);
        this.head.a("horn1f", -15.0f, -4.0f, -9.0f, 3, 6, 3);
        this.head.a("horn1g", -16.0f, -6.0f, -7.0f, 3, 3, 4);
        (this.nose = new axx((awt)this, 54, 73)).a(-5.5f, -5.0f, -13.0f, 11, 9, 12);
        this.nose.a(0.0f, -7.0f, -1.0f);
        this.nose.b(128, 128);
        this.setRotation(this.nose, 0.5235988f, 0.0f, 0.0f);
        this.head.a(this.nose);
        this.segments = new axx[16];
        this.segmentEnabled = new boolean[16];
        for (int i = 0; i < 16; ++i) {
            (this.segments[i] = new axx((awt)this, 0, 104)).a(-9.0f, -7.5f, 0.0f, 18, 15, 2);
            this.segments[i].a(0.0f, -1.0f, 2.0f);
            this.segmentEnabled[i] = false;
        }
    }
    
    public void a(final lq entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.a(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5);
        this.frontbody.a(f5);
        this.rearbody.a(f5);
        this.leg1.a(f5);
        this.haunch1.a(f5);
        this.leg2.a(f5);
        this.haunch2.a(f5);
        this.leg3.a(f5);
        this.haunch3.a(f5);
        this.leg4.a(f5);
        this.haunch4.a(f5);
        this.neck.a(f5);
        this.head.a(f5);
        for (int i = 0; i < 16; ++i) {
            if (this.segmentEnabled[i]) {
                final float var4 = 1.0f;
                GL11.glColor3f(var4 * pe.d[i][0], var4 * pe.d[i][1], var4 * pe.d[i][2]);
                this.segments[i].a(f5);
            }
        }
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
    }
    
    private void setRotation(final axx model, final float x, final float y, final float z) {
        model.f = x;
        model.g = y;
        model.h = z;
    }
    
    public void setRotationAngles(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6) {
        this.head.f = par5 / 57.295776f;
        this.head.g = par4 / 57.295776f;
        this.neck.g = this.head.g;
        this.leg1.f = ke.b(par1 * 0.6662f) * 1.4f * par2 * 0.5f;
        this.leg2.f = ke.b(par1 * 0.6662f + 3.1415927f) * 1.4f * par2 * 0.5f;
        this.leg3.f = ke.b(par1 * 0.6662f + 3.1415927f) * 1.4f * par2 * 0.5f;
        this.leg4.f = ke.b(par1 * 0.6662f) * 1.4f * par2 * 0.5f;
        this.haunch1.f = this.leg1.f;
        this.haunch2.f = this.leg2.f;
        this.haunch3.f = this.leg3.f;
        this.haunch4.f = this.leg4.f;
    }
    
    public void a(final md par1EntityLiving, final float par2, final float par3, final float par4) {
        final EntityTFQuestRam ram = (EntityTFQuestRam)par1EntityLiving;
        final int count = ram.countColorsSet();
        this.rearbody.e = (float)(2 + 2 * count);
        this.leg1.e = (float)(11 + 2 * count);
        this.leg2.e = (float)(11 + 2 * count);
        this.haunch1.e = (float)(11 + 2 * count);
        this.haunch2.e = (float)(11 + 2 * count);
        int segmentOffset = 2;
        for (final int color : this.colorOrder) {
            if (ram.isColorPresent(color)) {
                this.segmentEnabled[color] = true;
                this.segments[color].e = (float)segmentOffset;
                segmentOffset += 2;
            }
            else {
                this.segmentEnabled[color] = false;
            }
        }
    }
}
