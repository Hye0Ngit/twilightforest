// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;
import twilightforest.item.TFItems;

public class EntityTFDeer extends oz
{
    public EntityTFDeer(final yc world) {
        super(world);
        this.aG = "/twilightforest/wilddeer.png";
        this.a(0.7f, 2.3f);
    }
    
    public EntityTFDeer(final yc world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    protected String aY() {
        return null;
    }
    
    protected void a(final int par1, final int par2, final int par3, final int par4) {
    }
    
    public boolean a(final qx entityplayer) {
        final ur itemstack = entityplayer.bJ.g();
        return (itemstack == null || itemstack.c != up.aw.cj) && super.a(entityplayer);
    }
    
    protected void a(final boolean par1, final int par2) {
        for (int var3 = this.aa.nextInt(3) + this.aa.nextInt(1 + par2), var4 = 0; var4 < var3; ++var4) {
            this.b(up.aF.cj, 1);
        }
        for (int var3 = this.aa.nextInt(3) + 1 + this.aa.nextInt(1 + par2), var4 = 0; var4 < var3; ++var4) {
            if (this.af()) {
                this.b(TFItems.venisonCooked.cj, 1);
            }
            else {
                this.b(TFItems.venisonRaw.cj, 1);
            }
        }
    }
    
    public ox func_90011_a(final ln entityanimal) {
        return (ox)new EntityTFDeer(this.p);
    }
    
    public void a(final lh par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.f() instanceof qx) {
            ((qx)par1DamageSource.f()).a((jl)TFAchievementPage.twilightHunter);
        }
    }
}
