// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityTFMobileFirefly extends rm
{
    private t currentFlightTarget;
    
    public EntityTFMobileFirefly(final abv par1World) {
        super(par1World);
        this.a(0.5f, 0.5f);
    }
    
    protected float aZ() {
        return 0.1f;
    }
    
    protected float ba() {
        return super.ba() * 0.95f;
    }
    
    protected String aN() {
        return "mob.bat.hurt";
    }
    
    protected String aO() {
        return "mob.bat.death";
    }
    
    public boolean L() {
        return false;
    }
    
    protected void n(final nm par1Entity) {
    }
    
    protected void ay() {
        super.ay();
        this.a(to.a).a(6.0);
    }
    
    protected boolean be() {
        return true;
    }
    
    public void l_() {
        super.l_();
        this.y *= 0.6000000238418579;
    }
    
    protected void bh() {
        super.bh();
        if (this.currentFlightTarget != null && (!this.q.c(this.currentFlightTarget.a, this.currentFlightTarget.b, this.currentFlightTarget.c) || this.currentFlightTarget.b < 1)) {
            this.currentFlightTarget = null;
        }
        if (this.currentFlightTarget == null || this.ab.nextInt(30) == 0 || this.currentFlightTarget.e((int)this.u, (int)this.v, (int)this.w) < 4.0f) {
            this.currentFlightTarget = new t((int)this.u + this.ab.nextInt(7) - this.ab.nextInt(7), (int)this.v + this.ab.nextInt(6) - 2, (int)this.w + this.ab.nextInt(7) - this.ab.nextInt(7));
        }
        final double var1 = this.currentFlightTarget.a + 0.5 - this.u;
        final double var2 = this.currentFlightTarget.b + 0.1 - this.v;
        final double var3 = this.currentFlightTarget.c + 0.5 - this.w;
        final double speed = 0.05000000149011612;
        this.x += (Math.signum(var1) * 0.5 - this.x) * speed;
        this.y += (Math.signum(var2) * 0.699999988079071 - this.y) * speed * 2.0;
        this.z += (Math.signum(var3) * 0.5 - this.z) * speed;
        final float var4 = (float)(Math.atan2(this.z, this.x) * 180.0 / 3.141592653589793) - 90.0f;
        final float var5 = lr.g(var4 - this.A);
        this.bf = 0.5f;
        this.A += var5;
    }
    
    protected boolean e_() {
        return false;
    }
    
    protected void b(final float par1) {
    }
    
    protected void a(final double par1, final boolean par3) {
    }
    
    public boolean at() {
        return true;
    }
    
    public boolean bs() {
        final int var1 = lr.c(this.E.b);
        if (var1 >= 63) {
            return false;
        }
        final int var2 = lr.c(this.u);
        final int var3 = lr.c(this.w);
        final int var4 = this.q.n(var2, var1, var3);
        final byte var5 = 4;
        return var4 <= this.ab.nextInt(var5) && super.bs();
    }
    
    @SideOnly(Side.CLIENT)
    public int c(final float par1) {
        return 15728880;
    }
    
    public float getGlowBrightness() {
        return (float)Math.sin(this.ac / 7.0) + 1.0f;
    }
}
