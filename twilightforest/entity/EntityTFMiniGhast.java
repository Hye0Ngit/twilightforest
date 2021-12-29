// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

public class EntityTFMiniGhast extends EntityTFTowerGhast
{
    public boolean isMinion;
    
    public EntityTFMiniGhast(final zv par1World) {
        super(par1World);
        this.isMinion = false;
        this.a(1.1f, 1.5f);
        this.aH = "/mods/twilightforest/textures/model/towerghast.png";
        this.aggroRange = 16.0f;
        this.stareRange = 8.0f;
        this.wanderFactor = 4.0f;
    }
    
    @Override
    public int by() {
        return 16;
    }
    
    @Override
    public void l_() {
        super.l_();
        final byte aggroStatus = this.ah.a(16);
        switch (aggroStatus) {
            default: {
                this.aH = "/mods/twilightforest/textures/model/towerghast.png";
                break;
            }
            case 1: {
                this.aH = "/mods/twilightforest/textures/model/towerghast_openeyes.png";
                break;
            }
            case 2: {
                this.aH = "/mods/twilightforest/textures/model/towerghast_fire.png";
                break;
            }
        }
    }
    
    @Override
    protected boolean shouldAttackPlayer(final sk par1EntityPlayer) {
        final wg playerHeadArmor = par1EntityPlayer.bK.b[3];
        if (playerHeadArmor != null && playerHeadArmor.c == aou.be.cz) {
            return false;
        }
        if (par1EntityPlayer.d((mp)this) <= 3.5f && par1EntityPlayer.n((mp)this)) {
            return true;
        }
        final aqw var3 = par1EntityPlayer.i(1.0f).a();
        aqw var4 = this.q.T().a(this.u - par1EntityPlayer.u, this.E.b + this.P / 2.0f - (par1EntityPlayer.v + par1EntityPlayer.e()), this.w - par1EntityPlayer.w);
        final double var5 = var4.b();
        var4 = var4.a();
        final double var6 = var3.b(var4);
        return var6 > 1.0 - 0.025 / var5 && par1EntityPlayer.n((mp)this);
    }
    
    @Override
    protected boolean isValidLightLevel() {
        if (this.isMinion) {
            return true;
        }
        final int myX = kx.c(this.u);
        final int myY = kx.c(this.E.b);
        final int myZ = kx.c(this.w);
        if (this.q.b(aag.a, myX, myY, myZ) > this.ab.nextInt(32)) {
            return false;
        }
        int lightLevel = this.q.n(myX, myY, myZ);
        if (this.q.N()) {
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
    }
    
    public void b(final bs nbttagcompound) {
        nbttagcompound.a("isMinion", this.isMinion);
        super.b(nbttagcompound);
    }
    
    public void a(final bs nbttagcompound) {
        super.a(nbttagcompound);
        if (nbttagcompound.n("isMinion")) {
            this.makeBossMinion();
        }
    }
}
