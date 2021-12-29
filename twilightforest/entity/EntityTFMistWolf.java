// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

public class EntityTFMistWolf extends EntityTFHostileWolf
{
    public EntityTFMistWolf(final abv world) {
        super(world);
        this.a(1.4f, 1.9f);
    }
    
    public int getMaxHealth() {
        return 30;
    }
    
    public int getAttackStrength(final nm par1Entity) {
        return 6;
    }
    
    public boolean m(final nm par1Entity) {
        final int damage = this.getAttackStrength(par1Entity);
        if (par1Entity.a(na.a((oe)this), (float)damage)) {
            final float myBrightness = this.d(1.0f);
            if (par1Entity instanceof oe && myBrightness < 0.1f) {
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
                    ((oe)par1Entity).c(new ni(nh.q.H, effectDuration * 20, 0));
                }
            }
            return true;
        }
        return false;
    }
}
