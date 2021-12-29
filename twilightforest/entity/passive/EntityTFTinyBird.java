// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import net.minecraftforge.common.ForgeDirection;
import twilightforest.TFAchievementPage;
import twilightforest.entity.ai.EntityAITFBirdFly;

public class EntityTFTinyBird extends EntityTFBird
{
    private static final int DATA_BIRDTYPE = 16;
    private static final int DATA_BIRDFLAGS = 17;
    private t currentFlightTarget;
    private int currentFlightTime;
    
    public EntityTFTinyBird(final abv par1World) {
        super(par1World);
        this.a(0.5f, 0.9f);
        this.k().a(true);
        this.c.a(0, (pr)new EntityAITFBirdFly(this));
        this.c.a(1, (pr)new qt((om)this, 1.0, yb.U.cv, true));
        this.c.a(2, (pr)new ql((om)this, 1.0));
        this.c.a(3, (pr)new pw((of)this, (Class)ue.class, 6.0f));
        this.c.a(4, (pr)new qk((of)this));
        this.setBirdType(this.ab.nextInt(4));
        this.setIsBirdLanded(true);
    }
    
    protected void a() {
        super.a();
        this.ah.a(16, (Object)0);
        this.ah.a(17, (Object)0);
    }
    
    protected void ay() {
        super.ay();
        this.a(to.a).a(1.0);
        this.a(to.d).a(0.20000001192092895);
    }
    
    public void b(final bx par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("BirdType", this.getBirdType());
    }
    
    public void a(final bx par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        this.setBirdType(par1NBTTagCompound.e("BirdType"));
    }
    
    public int getBirdType() {
        return this.ah.a(16);
    }
    
    public void setBirdType(final int par1) {
        this.ah.b(16, (Object)(byte)par1);
    }
    
    protected String r() {
        return "TwilightForest:mob.tinybird.chirp";
    }
    
    protected String aN() {
        return "TwilightForest:mob.tinybird.hurt";
    }
    
    protected String aO() {
        return "TwilightForest:mob.tinybird.hurt";
    }
    
    public float bt() {
        return 0.3f;
    }
    
    protected boolean t() {
        return false;
    }
    
    public float a(final int par1, final int par2, final int par3) {
        final ajz underMaterial = this.q.g(par1, par2 - 1, par3);
        if (underMaterial == ajz.j) {
            return 200.0f;
        }
        if (underMaterial == ajz.d) {
            return 15.0f;
        }
        if (underMaterial == ajz.b) {
            return 9.0f;
        }
        return this.q.q(par1, par2, par3) - 0.5f;
    }
    
    public void a(final na par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof ue) {
            ((ue)par1DamageSource.h()).a((kt)TFAchievementPage.twilightHunter);
        }
    }
    
    public void l_() {
        super.l_();
        if (!this.isBirdLanded()) {
            this.y *= 0.6000000238418579;
        }
    }
    
    protected void bh() {
        super.bh();
        if (this.isBirdLanded()) {
            this.currentFlightTime = 0;
            if (this.ab.nextInt(200) == 0 && !this.isLandableBlock(lr.c(this.u), lr.c(this.v - 1.0), lr.c(this.w))) {
                this.setIsBirdLanded(false);
                this.q.a((ue)null, 1015, (int)this.u, (int)this.v, (int)this.w, 0);
                this.y = 0.4;
            }
            else if (this.isSpooked()) {
                this.setIsBirdLanded(false);
                this.y = 0.4;
                this.q.a((ue)null, 1015, (int)this.u, (int)this.v, (int)this.w, 0);
            }
        }
        else {
            ++this.currentFlightTime;
            if (this.currentFlightTarget != null && (!this.q.c(this.currentFlightTarget.a, this.currentFlightTarget.b, this.currentFlightTarget.c) || this.currentFlightTarget.b < 1)) {
                this.currentFlightTarget = null;
            }
            if (this.currentFlightTarget == null || this.ab.nextInt(30) == 0 || this.currentFlightTarget.e((int)this.u, (int)this.v, (int)this.w) < 4.0f) {
                final int yTarget = (this.currentFlightTime < 100) ? 2 : 4;
                this.currentFlightTarget = new t((int)this.u + this.ab.nextInt(7) - this.ab.nextInt(7), (int)this.v + this.ab.nextInt(6) - yTarget, (int)this.w + this.ab.nextInt(7) - this.ab.nextInt(7));
            }
            final double d0 = this.currentFlightTarget.a + 0.5 - this.u;
            final double d2 = this.currentFlightTarget.b + 0.1 - this.v;
            final double d3 = this.currentFlightTarget.c + 0.5 - this.w;
            this.x += (Math.signum(d0) * 0.5 - this.x) * 0.10000000149011612;
            this.y += (Math.signum(d2) * 0.699999988079071 - this.y) * 0.10000000149011612;
            this.z += (Math.signum(d3) * 0.5 - this.z) * 0.10000000149011612;
            final float f = (float)(Math.atan2(this.z, this.x) * 180.0 / 3.141592653589793) - 90.0f;
            final float f2 = lr.g(f - this.A);
            this.bf = 0.5f;
            this.A += f2;
            if (this.ab.nextInt(10) == 0 && this.isLandableBlock(lr.c(this.u), lr.c(this.v - 1.0), lr.c(this.w))) {
                this.setIsBirdLanded(true);
                this.y = 0.0;
            }
        }
    }
    
    public boolean isSpooked() {
        final ue closestPlayer = this.q.a((nm)this, 4.0);
        return this.ay > 0 || (closestPlayer != null && (closestPlayer.bn.h() == null || closestPlayer.bn.h().d != yb.U.cv));
    }
    
    public boolean isLandableBlock(final int x, final int y, final int z) {
        final aqw block = aqw.s[this.q.a(x, y, z)];
        return block != null && (block.isLeaves(this.q, x, y, z) || block.isBlockSolidOnSide(this.q, x, y, z, ForgeDirection.UP));
    }
    
    @Override
    public boolean isBirdLanded() {
        return (this.ah.a(17) & 0x1) != 0x0;
    }
    
    public void setIsBirdLanded(final boolean par1) {
        final byte b0 = this.ah.a(17);
        if (par1) {
            this.ah.b(17, (Object)(byte)(b0 | 0x1));
        }
        else {
            this.ah.b(17, (Object)(byte)(b0 & 0xFFFFFFFE));
        }
    }
    
    public boolean L() {
        return false;
    }
    
    protected void n(final nm par1Entity) {
    }
    
    protected void func_85033_bc() {
    }
}
