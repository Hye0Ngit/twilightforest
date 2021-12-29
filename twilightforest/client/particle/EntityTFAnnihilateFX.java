// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle;

import net.minecraft.client.renderer.Tessellator;
import twilightforest.item.TFItems;
import twilightforest.item.ItemTFCubeOfAnnihilation;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.particle.EntityFX;

@SideOnly(Side.CLIENT)
public class EntityTFAnnihilateFX extends EntityFX
{
    float initialParticleScale;
    
    public EntityTFAnnihilateFX(final World par1World, final double par2, final double par4, final double par6, final double par8, final double par10, final double par12) {
        this(par1World, par2, par4, par6, par8, par10, par12, 1.0f);
    }
    
    public EntityTFAnnihilateFX(final World par1World, final double par2, final double par4, final double par6, final double par8, final double par10, final double par12, final float par14) {
        super(par1World, par2, par4, par6, 0.0, 0.0, 0.0);
        this.field_70159_w *= 0.10000000149011612;
        this.field_70181_x *= 0.10000000149011612;
        this.field_70179_y *= 0.10000000149011612;
        this.field_70159_w += par8 * 0.4;
        this.field_70181_x += par10 * 0.4;
        this.field_70179_y += par12 * 0.4;
        final float field_70552_h = 1.0f;
        this.field_70551_j = field_70552_h;
        this.field_70553_i = field_70552_h;
        this.field_70552_h = field_70552_h;
        this.field_70544_f *= 0.75f;
        this.field_70544_f *= par14;
        this.initialParticleScale = this.field_70544_f;
        this.field_70547_e = (int)(60.0 / (Math.random() * 0.8 + 0.6));
        this.field_70547_e *= (int)par14;
        this.field_70145_X = false;
        this.func_110125_a(((ItemTFCubeOfAnnihilation)TFItems.cubeOfAnnihilation).getAnnihilateIcon());
        this.func_70071_h_();
    }
    
    public void func_70539_a(final Tessellator par1Tessellator, final float par2, final float par3, final float par4, final float par5, final float par6, final float par7) {
        super.func_70539_a(par1Tessellator, par2, par3, par4, par5, par6, par7);
    }
    
    public void func_70071_h_() {
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        if (this.field_70546_d++ >= this.field_70547_e) {
            this.func_70106_y();
        }
        this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
        this.field_70159_w *= 0.9599999785423279;
        this.field_70181_x *= 0.9599999785423279;
        this.field_70179_y *= 0.9599999785423279;
        if (this.field_70122_E) {
            this.field_70159_w *= 0.699999988079071;
            this.field_70179_y *= 0.699999988079071;
        }
        this.field_70544_f *= (float)0.97;
        if (this.field_70544_f < 0.4) {
            this.func_70106_y();
        }
        final float blacken = 0.985f;
        this.field_70552_h *= blacken;
        this.field_70553_i *= blacken;
        this.field_70551_j *= blacken;
    }
    
    public int func_70070_b(final float par1) {
        return 15728880;
    }
    
    public int func_70537_b() {
        return 2;
    }
}
