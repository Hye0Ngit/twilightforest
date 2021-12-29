// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.item.TFItems;

public class EntityTFMinoshroom extends EntityTFMinotaur
{
    public EntityTFMinoshroom(final abv par1World) {
        super(par1World);
        this.a(1.49f, 2.9f);
        this.b = 100;
        this.c(0, new yd(TFItems.minotaurAxe));
        this.e[0] = 1.0f;
    }
    
    @Override
    protected void ay() {
        super.ay();
        this.a(to.a).a(120.0);
    }
    
    @Override
    protected int s() {
        return TFItems.meefStroganoff.cv;
    }
    
    @Override
    protected void b(final boolean par1, final int par2) {
        for (int numDrops = this.ab.nextInt(4) + 2 + this.ab.nextInt(1 + par2), i = 0; i < numDrops; ++i) {
            this.b(TFItems.meefStroganoff.cv, 1);
        }
    }
    
    protected boolean t() {
        return false;
    }
}
