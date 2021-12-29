// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import twilightforest.TFAchievementPage;
import twilightforest.item.TFItems;

public class EntityTFDeer extends rq
{
    public EntityTFDeer(final abv world) {
        super(world);
        this.a(0.7f, 2.3f);
    }
    
    public EntityTFDeer(final abv world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    protected String r() {
        return null;
    }
    
    protected void a(final int par1, final int par2, final int par3, final int par4) {
    }
    
    public boolean a(final ue entityplayer) {
        final yd itemstack = entityplayer.bn.h();
        return (itemstack == null || itemstack.d != yb.ay.cv) && super.a(entityplayer);
    }
    
    protected void b(final boolean par1, final int par2) {
        for (int var3 = this.ab.nextInt(3) + this.ab.nextInt(1 + par2), var4 = 0; var4 < var3; ++var4) {
            this.b(yb.aH.cv, 1);
        }
        for (int var3 = this.ab.nextInt(3) + 1 + this.ab.nextInt(1 + par2), var4 = 0; var4 < var3; ++var4) {
            if (this.ae()) {
                this.b(TFItems.venisonCooked.cv, 1);
            }
            else {
                this.b(TFItems.venisonRaw.cv, 1);
            }
        }
    }
    
    public ro createChild(final nj entityanimal) {
        return (ro)new EntityTFDeer(this.q);
    }
    
    public void a(final na par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof ue) {
            ((ue)par1DamageSource.h()).a((kt)TFAchievementPage.twilightHunter);
        }
    }
}
