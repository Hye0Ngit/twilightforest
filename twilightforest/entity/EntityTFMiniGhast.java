// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

public class EntityTFMiniGhast extends EntityTFTowerGhast
{
    public boolean isMinion;
    
    public EntityTFMiniGhast(final abv par1World) {
        super(par1World);
        this.isMinion = false;
        this.a(1.1f, 1.5f);
        this.aggroRange = 16.0f;
        this.stareRange = 8.0f;
        this.wanderFactor = 4.0f;
    }
    
    @Override
    public int bv() {
        return 16;
    }
    
    public int getMaxHealth() {
        return this.isMinion ? 6 : 10;
    }
    
    @Override
    protected void ay() {
        super.ay();
        this.a(to.a).a(this.isMinion ? 6.0 : 10.0);
    }
    
    @Override
    public void l_() {
        super.l_();
        final byte aggroStatus = this.ah.a(16);
    }
    
    @Override
    protected boolean shouldAttackPlayer(final ue par1EntityPlayer) {
        final yd playerHeadArmor = par1EntityPlayer.bn.b[3];
        if (playerHeadArmor != null && playerHeadArmor.d == aqw.bf.cF) {
            return false;
        }
        if (par1EntityPlayer.d((nm)this) <= 3.5f && par1EntityPlayer.o((nm)this)) {
            return true;
        }
        final asz var3 = par1EntityPlayer.j(1.0f).a();
        asz var4 = this.q.V().a(this.u - par1EntityPlayer.u, this.E.b + this.P / 2.0f - (par1EntityPlayer.v + par1EntityPlayer.f()), this.w - par1EntityPlayer.w);
        final double var5 = var4.b();
        var4 = var4.a();
        final double var6 = var3.b(var4);
        return var6 > 1.0 - 0.025 / var5 && par1EntityPlayer.o((nm)this);
    }
    
    @Override
    protected boolean isValidLightLevel() {
        if (this.isMinion) {
            return true;
        }
        final int myX = lr.c(this.u);
        final int myY = lr.c(this.E.b);
        final int myZ = lr.c(this.w);
        if (this.q.b(acg.a, myX, myY, myZ) > this.ab.nextInt(32)) {
            return false;
        }
        int lightLevel = this.q.n(myX, myY, myZ);
        if (this.q.P()) {
            final int var5 = this.q.j;
            this.q.j = 10;
            lightLevel = this.q.n(myX, myY, myZ);
            this.q.j = var5;
        }
        return lightLevel <= this.ab.nextInt(8);
    }
    
    public void makeBossMinion() {
        this.wanderFactor = 0.005f;
        this.isMinion = true;
        this.g((float)this.getMaxHealth());
    }
    
    protected void b(final boolean par1, final int par2) {
        if (!this.isMinion) {
            super.b(par1, par2);
        }
    }
    
    public void b(final bx nbttagcompound) {
        nbttagcompound.a("isMinion", this.isMinion);
        super.b(nbttagcompound);
    }
    
    public void a(final bx nbttagcompound) {
        super.a(nbttagcompound);
        if (nbttagcompound.n("isMinion")) {
            this.makeBossMinion();
        }
    }
}
