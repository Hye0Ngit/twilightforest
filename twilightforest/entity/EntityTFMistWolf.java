// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

public class EntityTFMistWolf extends EntityTFHostileWolf
{
    public EntityTFMistWolf(final yc world) {
        super(world);
        this.a(1.4f, 1.9f);
        this.aG = "/twilightforest/mistwolf.png";
    }
    
    public String O() {
        return this.aG;
    }
    
    @Override
    public int aT() {
        return 30;
    }
    
    public int getAttackStrength(final lq par1Entity) {
        return 6;
    }
    
    public boolean m(final lq par1Entity) {
        final int damage = this.getAttackStrength(par1Entity);
        if (par1Entity.a(lh.a((md)this), damage)) {
            final float myBrightness = this.c(1.0f);
            System.out.println("Biting and brightness is " + myBrightness);
            if (par1Entity instanceof md && myBrightness < 0.1f) {
                byte effectDuration = 0;
                if (this.p.s > 1) {
                    if (this.p.s == 2) {
                        effectDuration = 7;
                    }
                    else if (this.p.s == 3) {
                        effectDuration = 15;
                    }
                }
                if (effectDuration > 0) {
                    ((md)par1Entity).d(new lm(ll.q.H, effectDuration * 20, 0));
                }
            }
            return true;
        }
        return false;
    }
}
