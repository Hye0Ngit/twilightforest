// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.entity.passive.EntityAmbientCreature;

public class EntityTFMobileFirefly extends EntityAmbientCreature
{
    private ChunkCoordinates currentFlightTarget;
    
    public EntityTFMobileFirefly(final World par1World) {
        super(par1World);
        this.func_70105_a(0.5f, 0.5f);
    }
    
    protected float func_70599_aP() {
        return 0.1f;
    }
    
    protected float func_70647_i() {
        return super.func_70647_i() * 0.95f;
    }
    
    protected String func_70621_aR() {
        return "mob.bat.hurt";
    }
    
    protected String func_70673_aS() {
        return "mob.bat.death";
    }
    
    public boolean func_70104_M() {
        return false;
    }
    
    protected void func_82167_n(final Entity par1Entity) {
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(6.0);
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        this.field_70181_x *= 0.6000000238418579;
    }
    
    protected void func_70619_bc() {
        super.func_70619_bc();
        if (this.currentFlightTarget != null && (!this.field_70170_p.func_147437_c(this.currentFlightTarget.field_71574_a, this.currentFlightTarget.field_71572_b, this.currentFlightTarget.field_71573_c) || this.currentFlightTarget.field_71572_b < 1)) {
            this.currentFlightTarget = null;
        }
        if (this.currentFlightTarget == null || this.field_70146_Z.nextInt(30) == 0 || this.currentFlightTarget.func_71569_e((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v) < 4.0f) {
            this.currentFlightTarget = new ChunkCoordinates((int)this.field_70165_t + this.field_70146_Z.nextInt(7) - this.field_70146_Z.nextInt(7), (int)this.field_70163_u + this.field_70146_Z.nextInt(6) - 2, (int)this.field_70161_v + this.field_70146_Z.nextInt(7) - this.field_70146_Z.nextInt(7));
        }
        final double var1 = this.currentFlightTarget.field_71574_a + 0.5 - this.field_70165_t;
        final double var2 = this.currentFlightTarget.field_71572_b + 0.1 - this.field_70163_u;
        final double var3 = this.currentFlightTarget.field_71573_c + 0.5 - this.field_70161_v;
        final double speed = 0.05000000149011612;
        this.field_70159_w += (Math.signum(var1) * 0.5 - this.field_70159_w) * speed;
        this.field_70181_x += (Math.signum(var2) * 0.699999988079071 - this.field_70181_x) * speed * 2.0;
        this.field_70179_y += (Math.signum(var3) * 0.5 - this.field_70179_y) * speed;
        final float var4 = (float)(Math.atan2(this.field_70179_y, this.field_70159_w) * 180.0 / 3.141592653589793) - 90.0f;
        final float var5 = MathHelper.func_76142_g(var4 - this.field_70177_z);
        this.field_70701_bs = 0.5f;
        this.field_70177_z += var5;
    }
    
    protected boolean func_70041_e_() {
        return false;
    }
    
    protected void func_70069_a(final float par1) {
    }
    
    protected void func_70064_a(final double par1, final boolean par3) {
    }
    
    public boolean func_145773_az() {
        return true;
    }
    
    public boolean func_70601_bi() {
        final int var1 = MathHelper.func_76128_c(this.field_70121_D.field_72338_b);
        if (var1 >= 63) {
            return false;
        }
        final int var2 = MathHelper.func_76128_c(this.field_70165_t);
        final int var3 = MathHelper.func_76128_c(this.field_70161_v);
        final int var4 = this.field_70170_p.func_72957_l(var2, var1, var3);
        final byte var5 = 4;
        return var4 <= this.field_70146_Z.nextInt(var5) && super.func_70601_bi();
    }
    
    @SideOnly(Side.CLIENT)
    public int func_70070_b(final float par1) {
        return 15728880;
    }
    
    public float getGlowBrightness() {
        return (float)Math.sin(this.field_70173_aa / 7.0) + 1.0f;
    }
}
