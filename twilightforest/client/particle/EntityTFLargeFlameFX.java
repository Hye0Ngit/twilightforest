// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.particle.EntityFX;

@SideOnly(Side.CLIENT)
public class EntityTFLargeFlameFX extends EntityFX
{
    private float flameScale;
    
    public EntityTFLargeFlameFX(final World par1World, final double par2, final double par4, final double par6, final double par8, final double par10, final double par12) {
        super(par1World, par2, par4, par6, par8, par10, par12);
        this.field_70159_w = this.field_70159_w * 0.009999999776482582 + par8;
        this.field_70181_x = this.field_70181_x * 0.009999999776482582 + par10;
        this.field_70179_y = this.field_70179_y * 0.009999999776482582 + par12;
        this.field_70544_f *= 5.0;
        this.flameScale = this.field_70544_f;
        final float field_70552_h = 1.0f;
        this.field_70551_j = field_70552_h;
        this.field_70553_i = field_70552_h;
        this.field_70552_h = field_70552_h;
        this.field_70547_e = (int)(8.0 / (Math.random() * 0.8 + 0.2)) + 4;
        this.func_70536_a(48);
    }
    
    public void func_70539_a(final Tessellator par1Tessellator, final float par2, final float par3, final float par4, final float par5, final float par6, final float par7) {
        final float var8 = (this.field_70546_d + par2) / this.field_70547_e;
        this.field_70544_f = this.flameScale * (1.0f - var8 * var8 * 0.5f);
        super.func_70539_a(par1Tessellator, par2, par3, par4, par5, par6, par7);
    }
    
    public int func_70070_b(final float par1) {
        float var2 = (this.field_70546_d + par1) / this.field_70547_e;
        if (var2 < 0.0f) {
            var2 = 0.0f;
        }
        if (var2 > 1.0f) {
            var2 = 1.0f;
        }
        final int var3 = super.func_70070_b(par1);
        int var4 = var3 & 0xFF;
        final int var5 = var3 >> 16 & 0xFF;
        var4 += (int)(var2 * 15.0f * 16.0f);
        if (var4 > 240) {
            var4 = 240;
        }
        return var4 | var5 << 16;
    }
    
    public float func_70013_c(final float par1) {
        float var2 = (this.field_70546_d + par1) / this.field_70547_e;
        if (var2 < 0.0f) {
            var2 = 0.0f;
        }
        if (var2 > 1.0f) {
            var2 = 1.0f;
        }
        final float var3 = super.func_70013_c(par1);
        return var3 * var2 + (1.0f - var2);
    }
    
    public void func_70071_h_() {
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        if (this.field_70546_d++ >= this.field_70547_e) {
            this.func_70106_y();
        }
        this.field_70181_x += 0.004;
        this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
        this.field_70159_w *= 0.9599999785423279;
        this.field_70181_x *= 0.9599999785423279;
        this.field_70179_y *= 0.9599999785423279;
        if (this.field_70122_E) {
            this.field_70159_w *= 0.699999988079071;
            this.field_70179_y *= 0.699999988079071;
        }
    }
}
