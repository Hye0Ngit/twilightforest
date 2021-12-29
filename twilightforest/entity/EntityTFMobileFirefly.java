// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityTFMobileFirefly extends ov
{
    private s currentFlightTarget;
    
    public EntityTFMobileFirefly(final yc par1World) {
        super(par1World);
        this.a(0.5f, 0.5f);
    }
    
    protected float aX() {
        return 0.1f;
    }
    
    protected float aV() {
        return super.aV() * 0.95f;
    }
    
    protected String aZ() {
        return "mob.bat.hurt";
    }
    
    protected String ba() {
        return "mob.bat.death";
    }
    
    public boolean M() {
        return false;
    }
    
    protected void o(final lq par1Entity) {
    }
    
    protected void bd() {
    }
    
    public int aT() {
        return 6;
    }
    
    protected boolean be() {
        return true;
    }
    
    public void j_() {
        super.j_();
        this.x *= 0.6000000238418579;
    }
    
    protected void bl() {
        super.bl();
        if (this.currentFlightTarget != null && (!this.p.c(this.currentFlightTarget.a, this.currentFlightTarget.b, this.currentFlightTarget.c) || this.currentFlightTarget.b < 1)) {
            this.currentFlightTarget = null;
        }
        if (this.currentFlightTarget == null || this.aa.nextInt(30) == 0 || this.currentFlightTarget.e((int)this.t, (int)this.u, (int)this.v) < 4.0f) {
            this.currentFlightTarget = new s((int)this.t + this.aa.nextInt(7) - this.aa.nextInt(7), (int)this.u + this.aa.nextInt(6) - 2, (int)this.v + this.aa.nextInt(7) - this.aa.nextInt(7));
        }
        final double var1 = this.currentFlightTarget.a + 0.5 - this.t;
        final double var2 = this.currentFlightTarget.b + 0.1 - this.u;
        final double var3 = this.currentFlightTarget.c + 0.5 - this.v;
        final double speed = 0.05000000149011612;
        this.w += (Math.signum(var1) * 0.5 - this.w) * speed;
        this.x += (Math.signum(var2) * 0.699999988079071 - this.x) * speed * 2.0;
        this.y += (Math.signum(var3) * 0.5 - this.y) * speed;
        final float var4 = (float)(Math.atan2(this.y, this.w) * 180.0 / 3.141592653589793) - 90.0f;
        final float var5 = ke.g(var4 - this.z);
        this.bD = 0.5f;
        this.z += var5;
    }
    
    protected boolean f_() {
        return false;
    }
    
    protected void a(final float par1) {
    }
    
    protected void a(final double par1, final boolean par3) {
    }
    
    public boolean au() {
        return true;
    }
    
    public boolean bs() {
        final int var1 = ke.c(this.D.b);
        if (var1 >= 63) {
            return false;
        }
        final int var2 = ke.c(this.t);
        final int var3 = ke.c(this.v);
        final int var4 = this.p.m(var2, var1, var3);
        final byte var5 = 4;
        return var4 <= this.aa.nextInt(var5) && super.bs();
    }
    
    public void bG() {
    }
    
    @SideOnly(Side.CLIENT)
    public int b(final float par1) {
        return 15728880;
    }
    
    public float getGlowBrightness() {
        return (float)Math.sin(this.ab / 7.0) + 1.0f;
    }
}
