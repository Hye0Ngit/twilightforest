// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EntityTFBossTearFX extends ben
{
    public EntityTFBossTearFX(final zv par1World, final double par2, final double par4, final double par6, final we par8Item, final bfy par9RenderEngine) {
        super(par1World, par2, par4, par6, 0.0, 0.0, 0.0);
        this.a(par9RenderEngine, par8Item.a_(0));
        final float j = 1.0f;
        this.av = j;
        this.au = j;
        this.j = j;
        this.i = aou.aY.cN * 2.0f;
        this.h = 16.0f;
        this.g = 20 + this.ab.nextInt(40);
    }
    
    public EntityTFBossTearFX(final zv par1World, final double par2, final double par4, final double par6, final double par8, final double par10, final double par12, final we par14Item, final bfy par15RenderEngine) {
        this(par1World, par2, par4, par6, par14Item, par15RenderEngine);
        this.x *= 0.10000000149011612;
        this.y *= 0.10000000149011612;
        this.z *= 0.10000000149011612;
        this.x += par8;
        this.y += par10;
        this.z += par12;
    }
    
    public int b() {
        return 2;
    }
    
    public void l_() {
        super.l_();
        if (this.F && this.ab.nextBoolean()) {
            this.q.a(this.u, this.v + 1.0, this.w, "random.glass", 0.5f, 1.0f, false);
            for (int var1 = 0; var1 < 50; ++var1) {
                final double gaussX = this.ab.nextGaussian() * 0.1;
                final double gaussY = this.ab.nextGaussian() * 0.2;
                final double gaussZ = this.ab.nextGaussian() * 0.1;
                final double gaussFactor = 10.0;
                final int popItem = we.bq.cp;
                this.q.a("iconcrack_" + popItem, this.u + this.ab.nextFloat() - this.ab.nextFloat(), this.v + 0.5, this.w + this.ab.nextFloat(), gaussX, gaussY, gaussZ);
            }
            this.w();
        }
    }
    
    public void a(final bfx par1Tessellator, final float par2, final float par3, final float par4, final float par5, final float par6, final float par7) {
        float f6 = this.b / 16.0f;
        float f7 = f6 + 0.0624375f;
        float f8 = this.c / 16.0f;
        float f9 = f8 + 0.0624375f;
        final float f10 = 0.1f * this.h;
        if (this.ax != null) {
            f6 = this.ax.a(0.0);
            f7 = this.ax.a(16.0);
            f8 = this.ax.b(0.0);
            f9 = this.ax.b(16.0);
        }
        final float f11 = (float)(this.r + (this.u - this.r) * par2 - EntityTFBossTearFX.ay);
        final float f12 = (float)(this.s + (this.v - this.s) * par2 - EntityTFBossTearFX.az);
        final float f13 = (float)(this.t + (this.w - this.t) * par2 - EntityTFBossTearFX.aA);
        final float f14 = 1.0f;
        par1Tessellator.a(f14 * this.j, f14 * this.au, f14 * this.av);
        par1Tessellator.a((double)(f11 - par3 * f10 - par6 * f10), (double)(f12 - par4 * f10), (double)(f13 - par5 * f10 - par7 * f10), (double)f6, (double)f9);
        par1Tessellator.a((double)(f11 - par3 * f10 + par6 * f10), (double)(f12 + par4 * f10), (double)(f13 - par5 * f10 + par7 * f10), (double)f6, (double)f8);
        par1Tessellator.a((double)(f11 + par3 * f10 + par6 * f10), (double)(f12 + par4 * f10), (double)(f13 + par5 * f10 + par7 * f10), (double)f7, (double)f8);
        par1Tessellator.a((double)(f11 + par3 * f10 - par6 * f10), (double)(f12 - par4 * f10), (double)(f13 + par5 * f10 - par7 * f10), (double)f7, (double)f9);
    }
}
