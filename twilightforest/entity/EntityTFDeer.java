// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;
import twilightforest.item.TFItems;

public class EntityTFDeer extends qd
{
    public EntityTFDeer(final zv world) {
        super(world);
        this.aH = "/mods/twilightforest/textures/model/wilddeer.png";
        this.a(0.7f, 2.3f);
    }
    
    public EntityTFDeer(final zv world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    protected String bb() {
        return null;
    }
    
    protected void a(final int par1, final int par2, final int par3, final int par4) {
    }
    
    public boolean a_(final sk entityplayer) {
        final wg itemstack = entityplayer.bK.h();
        return (itemstack == null || itemstack.c != we.ax.cp) && super.a_(entityplayer);
    }
    
    protected void a(final boolean par1, final int par2) {
        for (int var3 = this.ab.nextInt(3) + this.ab.nextInt(1 + par2), var4 = 0; var4 < var3; ++var4) {
            this.b(we.aG.cp, 1);
        }
        for (int var3 = this.ab.nextInt(3) + 1 + this.ab.nextInt(1 + par2), var4 = 0; var4 < var3; ++var4) {
            if (this.ae()) {
                this.b(TFItems.venisonCooked.cp, 1);
            }
            else {
                this.b(TFItems.venisonRaw.cp, 1);
            }
        }
    }
    
    public qb createChild(final mm entityanimal) {
        return (qb)new EntityTFDeer(this.q);
    }
    
    public void a(final mg par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof sk) {
            ((sk)par1DamageSource.h()).a((ka)TFAchievementPage.twilightHunter);
        }
    }
}
