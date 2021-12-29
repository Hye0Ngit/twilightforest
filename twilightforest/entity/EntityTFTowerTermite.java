// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.item.TFItems;
import twilightforest.block.TFBlocks;

public class EntityTFTowerTermite extends rv
{
    private int allySummonCooldown;
    
    public EntityTFTowerTermite(final zv par1World) {
        super(par1World);
        this.aH = "/mods/twilightforest/textures/model/towertermite.png";
        this.a(0.3f, 0.7f);
        this.bI = 0.27f;
        this.bo.a(0, (og)new od((ng)this));
        this.bo.a(1, (og)new oo((ng)this, (Class)sk.class, this.bI, false));
        this.bo.a(2, (og)new pa((nl)this, this.bI));
        this.bo.a(3, (og)new ol((ng)this, (Class)sk.class, 8.0f));
        this.bo.a(4, (og)new oz((ng)this));
        this.bp.a(1, (og)new pk((ng)this, true));
        this.bp.a(2, (og)new pl((ng)this, (Class)sk.class, 8.0f, 0, true));
    }
    
    protected boolean bh() {
        return true;
    }
    
    public int aW() {
        return 15;
    }
    
    public int c(final mp par1Entity) {
        return 5;
    }
    
    protected boolean f_() {
        return false;
    }
    
    protected mp j() {
        final double var1 = 8.0;
        return (mp)this.q.b((mp)this, var1);
    }
    
    protected String bb() {
        return "mob.silverfish.say";
    }
    
    protected String bc() {
        return "mob.silverfish.hit";
    }
    
    protected String bd() {
        return "mob.silverfish.kill";
    }
    
    public boolean a(final mg par1DamageSource, final int par2) {
        if (this.aq()) {
            return false;
        }
        if (this.allySummonCooldown <= 0 && (par1DamageSource instanceof mh || par1DamageSource == mg.k)) {
            this.allySummonCooldown = 20;
        }
        return super.a(par1DamageSource, par2);
    }
    
    protected void bo() {
        super.bo();
        if (this.allySummonCooldown > 0) {
            --this.allySummonCooldown;
            if (this.allySummonCooldown == 0) {
                this.tryToSummonAllies();
            }
        }
        if (this.aJ() == null && this.aC().f()) {
            this.tryToBurrow();
        }
    }
    
    protected void tryToSummonAllies() {
        final int sx = kx.c(this.u);
        final int sy = kx.c(this.v);
        final int sz = kx.c(this.w);
        boolean stopSummoning = false;
        for (int dy = 0; !stopSummoning && dy <= 5 && dy >= -5; dy = ((dy <= 0) ? (1 - dy) : (0 - dy))) {
            for (int dx = 0; !stopSummoning && dx <= 10 && dx >= -10; dx = ((dx <= 0) ? (1 - dx) : (0 - dx))) {
                for (int dz = 0; !stopSummoning && dz <= 10 && dz >= -10; dz = ((dz <= 0) ? (1 - dz) : (0 - dz))) {
                    final int blockID = this.q.a(sx + dx, sy + dy, sz + dz);
                    final int blockMeta = this.q.h(sx + dx, sy + dy, sz + dz);
                    if (blockID == TFBlocks.towerWood.cz && blockMeta == 4) {
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
        int x = kx.c(this.u);
        int y = kx.c(this.v + 0.5);
        int z = kx.c(this.w);
        final int randomFacing = this.ab.nextInt(6);
        x += s.b[randomFacing];
        y += s.c[randomFacing];
        z += s.d[randomFacing];
        final int blockIDNearby = this.q.a(x, y, z);
        final int blockMetaNearby = this.q.h(x, y, z);
        if (this.canBurrowIn(blockIDNearby, blockMetaNearby)) {
            this.q.f(x, y, z, TFBlocks.towerWood.cz, 4, 3);
            this.aU();
            this.w();
        }
    }
    
    protected boolean canBurrowIn(final int blockIDNearby, final int blockMetaNearby) {
        return blockIDNearby == TFBlocks.towerWood.cz && blockMetaNearby == 0;
    }
    
    protected boolean isInfestedBlock(final int blockIDNearby, final int blockMetaNearby) {
        return blockIDNearby == TFBlocks.towerWood.cz && blockMetaNearby == 4;
    }
    
    protected void a(final int par1, final int par2, final int par3, final int par4) {
        this.a("mob.silverfish.step", 0.15f, 1.0f);
    }
    
    protected int be() {
        return TFItems.borerEssence.cp;
    }
    
    public void l_() {
        this.ay = this.A;
        super.l_();
    }
    
    public ni bF() {
        return ni.c;
    }
}
