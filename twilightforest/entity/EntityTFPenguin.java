// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;

public class EntityTFPenguin extends EntityTFBird
{
    public EntityTFPenguin(final zv world) {
        super(world);
        this.aH = "/mods/twilightforest/textures/model/penguin.png";
        this.bo.a(0, (og)new od((ng)this));
        this.bo.a(1, (og)new ox((nl)this, 0.38f));
        this.bo.a(2, (og)new ny((qb)this, 0.25f));
        this.bo.a(3, (og)new ph((nl)this, 0.25f, we.aV.cp, false));
        this.bo.a(4, (og)new of((qb)this, 0.28f));
        this.bo.a(5, (og)new pa((nl)this, 0.25f));
        this.bo.a(6, (og)new ol((ng)this, (Class)sk.class, 6.0f));
        this.bo.a(7, (og)new oj((ng)this, (Class)EntityTFPenguin.class, 5.0f, 0.02f));
        this.bo.a(8, (og)new oz((ng)this));
    }
    
    public EntityTFPenguin(final zv world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    protected String bb() {
        return null;
    }
    
    @Override
    public qb createChild(final mm entityanimal) {
        return new EntityTFPenguin(this.q);
    }
    
    public boolean isWheat(final wg par1ItemStack) {
        return par1ItemStack != null && par1ItemStack.c == we.aV.cp;
    }
    
    public void a(final mg par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof sk) {
            ((sk)par1DamageSource.h()).a((ka)TFAchievementPage.twilightHunter);
        }
    }
    
    public int aW() {
        return 10;
    }
}
