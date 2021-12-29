// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Items;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.particle.EntityFX;

@SideOnly(Side.CLIENT)
public class EntityTFBossTearFX extends EntityFX
{
    public EntityTFBossTearFX(final World par1World, final double par2, final double par4, final double par6, final Item par8Item) {
        super(par1World, par2, par4, par6, 0.0, 0.0, 0.0);
        this.func_110125_a(par8Item.func_77617_a(0));
        final float field_70552_h = 1.0f;
        this.field_70551_j = field_70552_h;
        this.field_70553_i = field_70552_h;
        this.field_70552_h = field_70552_h;
        this.field_70545_g = Blocks.field_150433_aE.field_149763_I * 2.0f;
        this.field_70544_f = 16.0f;
        this.field_70547_e = 20 + this.field_70146_Z.nextInt(40);
    }
    
    public EntityTFBossTearFX(final World par1World, final double par2, final double par4, final double par6, final double par8, final double par10, final double par12, final Item par14Item) {
        this(par1World, par2, par4, par6, par14Item);
        this.field_70159_w *= 0.10000000149011612;
        this.field_70181_x *= 0.10000000149011612;
        this.field_70179_y *= 0.10000000149011612;
        this.field_70159_w += par8;
        this.field_70181_x += par10;
        this.field_70179_y += par12;
    }
    
    public int func_70537_b() {
        return 2;
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70122_E && this.field_70146_Z.nextBoolean()) {
            this.field_70170_p.func_72980_b(this.field_70165_t, this.field_70163_u + 1.0, this.field_70161_v, "random.glass", 0.5f, 1.0f, false);
            for (int var1 = 0; var1 < 50; ++var1) {
                final double gaussX = this.field_70146_Z.nextGaussian() * 0.1;
                final double gaussY = this.field_70146_Z.nextGaussian() * 0.2;
                final double gaussZ = this.field_70146_Z.nextGaussian() * 0.1;
                final Item popItem = Items.field_151073_bk;
                this.field_70170_p.func_72869_a("iconcrack_" + Item.func_150891_b(popItem), this.field_70165_t + this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat(), this.field_70163_u + 0.5, this.field_70161_v + this.field_70146_Z.nextFloat(), gaussX, gaussY, gaussZ);
            }
            this.func_70106_y();
        }
    }
    
    public void func_70539_a(final Tessellator par1Tessellator, final float par2, final float par3, final float par4, final float par5, final float par6, final float par7) {
        float f6 = this.field_94054_b / 16.0f;
        float f7 = f6 + 0.0624375f;
        float f8 = this.field_94055_c / 16.0f;
        float f9 = f8 + 0.0624375f;
        final float f10 = 0.1f * this.field_70544_f;
        if (this.field_70550_a != null) {
            f6 = this.field_70550_a.func_94214_a(0.0);
            f7 = this.field_70550_a.func_94214_a(16.0);
            f8 = this.field_70550_a.func_94207_b(0.0);
            f9 = this.field_70550_a.func_94207_b(16.0);
        }
        final float f11 = (float)(this.field_70169_q + (this.field_70165_t - this.field_70169_q) * par2 - EntityTFBossTearFX.field_70556_an);
        final float f12 = (float)(this.field_70167_r + (this.field_70163_u - this.field_70167_r) * par2 - EntityTFBossTearFX.field_70554_ao);
        final float f13 = (float)(this.field_70166_s + (this.field_70161_v - this.field_70166_s) * par2 - EntityTFBossTearFX.field_70555_ap);
        final float f14 = 1.0f;
        par1Tessellator.func_78386_a(f14 * this.field_70552_h, f14 * this.field_70553_i, f14 * this.field_70551_j);
        par1Tessellator.func_78374_a((double)(f11 - par3 * f10 - par6 * f10), (double)(f12 - par4 * f10), (double)(f13 - par5 * f10 - par7 * f10), (double)f6, (double)f9);
        par1Tessellator.func_78374_a((double)(f11 - par3 * f10 + par6 * f10), (double)(f12 + par4 * f10), (double)(f13 - par5 * f10 + par7 * f10), (double)f6, (double)f8);
        par1Tessellator.func_78374_a((double)(f11 + par3 * f10 + par6 * f10), (double)(f12 + par4 * f10), (double)(f13 + par5 * f10 + par7 * f10), (double)f7, (double)f8);
        par1Tessellator.func_78374_a((double)(f11 + par3 * f10 - par6 * f10), (double)(f12 - par4 * f10), (double)(f13 + par5 * f10 - par7 * f10), (double)f7, (double)f9);
    }
}
