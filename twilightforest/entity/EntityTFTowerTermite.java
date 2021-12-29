// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.item.TFItems;
import twilightforest.block.TFBlocks;

public class EntityTFTowerTermite extends tl
{
    private int allySummonCooldown;
    
    public EntityTFTowerTermite(final abv par1World) {
        super(par1World);
        this.a(0.3f, 0.7f);
        this.c.a(0, (pr)new po((of)this));
        this.c.a(1, (pr)new pz((om)this, (Class)ue.class, 1.0, false));
        this.c.a(2, (pr)new ql((om)this, 1.0));
        this.c.a(3, (pr)new pw((of)this, (Class)ue.class, 8.0f));
        this.c.a(4, (pr)new qk((of)this));
        this.d.a(1, (pr)new qw((om)this, true));
        this.d.a(2, (pr)new qx((om)this, (Class)ue.class, 0, true));
    }
    
    protected boolean be() {
        return true;
    }
    
    protected void ay() {
        super.ay();
        this.a(to.a).a(15.0);
        this.a(to.d).a(0.27);
        this.a(to.e).a(5.0);
    }
    
    protected boolean e_() {
        return false;
    }
    
    protected nm bL() {
        final double var1 = 8.0;
        return (nm)this.q.b((nm)this, var1);
    }
    
    protected String r() {
        return "mob.silverfish.say";
    }
    
    protected String aN() {
        return "mob.silverfish.hit";
    }
    
    protected String aO() {
        return "mob.silverfish.kill";
    }
    
    public boolean attackEntityFrom(final na par1DamageSource, final int par2) {
        if (this.aq()) {
            return false;
        }
        if (this.allySummonCooldown <= 0 && (par1DamageSource instanceof nb || par1DamageSource == na.k)) {
            this.allySummonCooldown = 20;
        }
        return super.a(par1DamageSource, (float)par2);
    }
    
    protected void bh() {
        super.bh();
        if (this.allySummonCooldown > 0) {
            --this.allySummonCooldown;
            if (this.allySummonCooldown == 0) {
                this.tryToSummonAllies();
            }
        }
        if (this.m() == null && this.k().g()) {
            this.tryToBurrow();
        }
    }
    
    protected void tryToSummonAllies() {
        final int sx = lr.c(this.u);
        final int sy = lr.c(this.v);
        final int sz = lr.c(this.w);
        boolean stopSummoning = false;
        for (int dy = 0; !stopSummoning && dy <= 5 && dy >= -5; dy = ((dy <= 0) ? (1 - dy) : (0 - dy))) {
            for (int dx = 0; !stopSummoning && dx <= 10 && dx >= -10; dx = ((dx <= 0) ? (1 - dx) : (0 - dx))) {
                for (int dz = 0; !stopSummoning && dz <= 10 && dz >= -10; dz = ((dz <= 0) ? (1 - dz) : (0 - dz))) {
                    final int blockID = this.q.a(sx + dx, sy + dy, sz + dz);
                    final int blockMeta = this.q.h(sx + dx, sy + dy, sz + dz);
                    if (blockID == TFBlocks.towerWood.cF && blockMeta == 4) {
                        this.q.e(2001, sx + dx, sy + dy, sz + dz, blockID + (blockMeta << 12));
                        this.q.f(sx + dx, sy + dy, sz + dz, 0, 0, 3);
                        TFBlocks.towerWood.g(this.q, sx + dx, sy + dy, sz + dz, 4);
                        if (this.ab.nextBoolean()) {
                            stopSummoning = true;
                            break;
                        }
                    }
                }
            }
        }
    }
    
    protected void tryToBurrow() {
        int x = lr.c(this.u);
        int y = lr.c(this.v + 0.5);
        int z = lr.c(this.w);
        final int randomFacing = this.ab.nextInt(6);
        x += s.b[randomFacing];
        y += s.c[randomFacing];
        z += s.d[randomFacing];
        final int blockIDNearby = this.q.a(x, y, z);
        final int blockMetaNearby = this.q.h(x, y, z);
        if (this.canBurrowIn(blockIDNearby, blockMetaNearby)) {
            this.q.f(x, y, z, TFBlocks.towerWood.cF, 4, 3);
            this.q();
            this.w();
        }
    }
    
    protected boolean canBurrowIn(final int blockIDNearby, final int blockMetaNearby) {
        return blockIDNearby == TFBlocks.towerWood.cF && blockMetaNearby == 0;
    }
    
    protected boolean isInfestedBlock(final int blockIDNearby, final int blockMetaNearby) {
        return blockIDNearby == TFBlocks.towerWood.cF && blockMetaNearby == 4;
    }
    
    protected void a(final int par1, final int par2, final int par3, final int par4) {
        this.a("mob.silverfish.step", 0.15f, 1.0f);
    }
    
    protected int s() {
        return TFItems.borerEssence.cv;
    }
    
    public void l_() {
        this.aN = this.A;
        super.l_();
    }
    
    public oi aX() {
        return oi.c;
    }
}
