// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.block.TFBlocks;
import twilightforest.item.TFItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityTFMoonwormShot extends ri
{
    public EntityTFMoonwormShot(final yc par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }
    
    public EntityTFMoonwormShot(final yc par1World, final md par2EntityLiving) {
        super(par1World, par2EntityLiving);
    }
    
    public EntityTFMoonwormShot(final yc par1World) {
        super(par1World);
    }
    
    protected float func_40077_c() {
        return 0.5f;
    }
    
    public void j_() {
        super.j_();
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
    
    public boolean L() {
        return true;
    }
    
    public float Y() {
        return 1.0f;
    }
    
    protected float g() {
        return 0.03f;
    }
    
    protected void a(final aoh mop) {
        if (mop.a == aoi.a && !this.p.I) {
            TFItems.moonwormQueen.a((ur)null, (qx)this.h(), this.p, mop.b, mop.c, mop.d, mop.e, 0.0f, 0.0f, 0.0f);
        }
        if (mop.g != null) {
            mop.g.a(lh.a((lq)this, (lq)this.h()), 0);
        }
        for (int var3 = 0; var3 < 8; ++var3) {
            this.p.a("tilecrack_" + TFBlocks.moonworm.cm + "_0", this.t, this.u, this.v, 0.0, 0.0, 0.0);
        }
        if (!this.p.I) {
            this.x();
        }
    }
}
