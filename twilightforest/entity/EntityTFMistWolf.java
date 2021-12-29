// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

public class EntityTFMistWolf extends EntityTFHostileWolf
{
    public EntityTFMistWolf(final zv world) {
        super(world);
        this.a(1.4f, 1.9f);
        this.aH = "/mods/twilightforest/textures/model/mistwolf.png";
    }
    
    public String N() {
        return this.aH;
    }
    
    @Override
    public int aW() {
        return 30;
    }
    
    public int getAttackStrength(final mp par1Entity) {
        return 6;
    }
    
    public boolean m(final mp par1Entity) {
        final int damage = this.getAttackStrength(par1Entity);
        if (par1Entity.a(mg.a((ng)this), damage)) {
            final float myBrightness = this.c(1.0f);
            if (par1Entity instanceof ng && myBrightness < 0.1f) {
                byte effectDuration = 0;
                if (this.q.r > 1) {
                    if (this.q.r == 2) {
                        effectDuration = 7;
                    }
                    else if (this.q.r == 3) {
                        effectDuration = 15;
                    }
                }
                if (effectDuration > 0) {
                    ((ng)par1Entity).d(new ml(mk.q.H, effectDuration * 20, 0));
                }
            }
            return true;
        }
        return false;
    }
}
