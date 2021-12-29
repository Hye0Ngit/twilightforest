// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.block.TFBlocks;
import twilightforest.item.TFItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityTFMoonwormShot extends sv
{
    public EntityTFMoonwormShot(final zv par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }
    
    public EntityTFMoonwormShot(final zv par1World, final ng par2EntityLiving) {
        super(par1World, par2EntityLiving);
    }
    
    public EntityTFMoonwormShot(final zv par1World) {
        super(par1World);
    }
    
    protected float func_40077_c() {
        return 0.5f;
    }
    
    public void l_() {
        super.l_();
        this.makeTrail();
    }
    
    public float c(final float par1) {
        return 1.0f;
    }
    
    @SideOnly(Side.CLIENT)
    public int b(final float par1) {
        return 15728880;
    }
    
    public void makeTrail() {
    }
    
    public boolean K() {
        return true;
    }
    
    public float X() {
        return 1.0f;
    }
    
    protected float g() {
        return 0.03f;
    }
    
    protected void a(final aqu mop) {
        if (mop.a == aqv.a && !this.q.I) {
            TFItems.moonwormQueen.a((wg)null, (sk)this.h(), this.q, mop.b, mop.c, mop.d, mop.e, 0.0f, 0.0f, 0.0f);
        }
        if (mop.g != null) {
            mop.g.a(mg.a((mp)this, (mp)this.h()), 0);
        }
        for (int var3 = 0; var3 < 8; ++var3) {
            this.q.a("tilecrack_" + TFBlocks.moonworm.cz + "_0", this.u, this.v, this.w, 0.0, 0.0, 0.0);
        }
        if (!this.q.I) {
            this.w();
        }
    }
}
