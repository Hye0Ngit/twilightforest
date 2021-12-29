// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.block.TFBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityTFTowerGolem extends rv
{
    private int attackTimer;
    
    public EntityTFTowerGolem(final zv par1World) {
        super(par1World);
        this.aH = "/mods/twilightforest/textures/model/carminitegolem.png";
        this.a(1.4f, 2.9f);
        this.bI = 0.25f;
        this.aC().a(true);
        this.bo.a(1, (og)new oo((ng)this, (Class)sk.class, this.bI, false));
        this.bo.a(2, (og)new pa((nl)this, 0.16f));
        this.bo.a(3, (og)new ol((ng)this, (Class)sk.class, 6.0f));
        this.bo.a(3, (og)new oz((ng)this));
        this.bp.a(1, (og)new pk((ng)this, false));
        this.bp.a(2, (og)new pl((ng)this, (Class)sk.class, 16.0f, 0, true));
    }
    
    protected boolean bh() {
        return true;
    }
    
    public int aW() {
        return 40;
    }
    
    public int aZ() {
        int var1 = super.aZ() + 2;
        if (var1 > 20) {
            var1 = 20;
        }
        return var1;
    }
    
    public boolean m(final mp par1Entity) {
        this.attackTimer = 10;
        this.q.a((mp)this, (byte)4);
        final boolean attackSuccess = super.m(par1Entity);
        if (attackSuccess) {
            par1Entity.y += 0.4000000059604645;
        }
        this.a("mob.irongolem.throw", 1.0f, 1.0f);
        return attackSuccess;
    }
    
    protected String bb() {
        return "none";
    }
    
    protected String bc() {
        return "mob.irongolem.hit";
    }
    
    protected String bd() {
        return "mob.irongolem.death";
    }
    
    protected void a(final int par1, final int par2, final int par3, final int par4) {
        this.a("mob.irongolem.walk", 1.0f, 1.0f);
    }
    
    protected void o(final mp par1Entity) {
        if (par1Entity instanceof rq && this.aE().nextInt(10) == 0) {
            this.b((ng)par1Entity);
        }
        super.o(par1Entity);
    }
    
    public void c() {
        super.c();
        if (this.attackTimer > 0) {
            --this.attackTimer;
        }
        if (this.x * this.x + this.z * this.z > 2.500000277905201E-7 && this.ab.nextInt(5) == 0) {
            final int var1 = kx.c(this.u);
            final int var2 = kx.c(this.v - 0.20000000298023224 - this.N);
            final int var3 = kx.c(this.w);
            final int var4 = this.q.a(var1, var2, var3);
            if (var4 > 0) {
                this.q.a("tilecrack_" + var4 + "_" + this.q.h(var1, var2, var3), this.u + (this.ab.nextFloat() - 0.5) * this.O, this.E.b + 0.1, this.w + (this.ab.nextFloat() - 0.5) * this.O, 4.0 * (this.ab.nextFloat() - 0.5), 0.5, (this.ab.nextFloat() - 0.5) * 4.0);
            }
        }
        if (this.ab.nextBoolean()) {
            this.q.a("reddust", this.u + (this.ab.nextDouble() - 0.5) * this.O, this.v + this.ab.nextDouble() * this.P - 0.25, this.w + (this.ab.nextDouble() - 0.5) * this.O, 0.0, 0.0, 0.0);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final byte par1) {
        if (par1 == 4) {
            this.attackTimer = 10;
            this.a("mob.irongolem.throw", 1.0f, 1.0f);
        }
        else {
            super.a(par1);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public int getAttackTimer() {
        return this.attackTimer;
    }
    
    public int c(final mp par1Entity) {
        return 9;
    }
    
    protected void a(final boolean par1, final int par2) {
        for (int var4 = this.ab.nextInt(3), i = 0; i < var4; ++i) {
            this.b(we.p.cp, 1);
        }
        for (int var4 = this.ab.nextInt(3), i = 0; i < var4; ++i) {
            this.b(TFBlocks.towerWood.cz, 1);
        }
    }
    
    public int by() {
        return 16;
    }
}
